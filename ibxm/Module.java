package ibxm;

import java.io.IOException;
import java.io.InputStream;

public class Module
{
    public String songName;
    public int numChannels;
    public int numInstruments;
    public int numPatterns;
    public int sequenceLength;
    public int restartPos;
    public int defaultGVol;
    public int defaultSpeed;
    public int defaultTempo;
    public int c2Rate;
    public int gain;
    public boolean linearPeriods;
    public boolean fastVolSlides;
    public int[] defaultPanning;
    public int[] sequence;
    public Pattern[] patterns;
    public Instrument[] instruments;
    
    public Module() {
        this.songName = "Blank";
        this.numChannels = 4;
        this.numInstruments = 1;
        this.numPatterns = 1;
        this.sequenceLength = 1;
        this.restartPos = 0;
        this.defaultGVol = 64;
        this.defaultSpeed = 6;
        this.defaultTempo = 125;
        this.c2Rate = 8287;
        this.gain = 64;
        this.linearPeriods = false;
        this.fastVolSlides = false;
        this.defaultPanning = new int[] { 51, 204, 204, 51 };
        this.sequence = new int[] { 0 };
        this.patterns = new Pattern[] { new Pattern(4, 64) };
        this.instruments = new Instrument[] { new Instrument(), new Instrument() };
    }
    
    public Module(final InputStream inputStream) throws IOException {
        this(new Data(inputStream));
    }
    
    public Module(final Data moduleData) throws IOException {
        this.songName = "Blank";
        this.numChannels = 4;
        this.numInstruments = 1;
        this.numPatterns = 1;
        this.sequenceLength = 1;
        this.restartPos = 0;
        this.defaultGVol = 64;
        this.defaultSpeed = 6;
        this.defaultTempo = 125;
        this.c2Rate = 8287;
        this.gain = 64;
        this.linearPeriods = false;
        this.fastVolSlides = false;
        this.defaultPanning = new int[] { 51, 204, 204, 51 };
        this.sequence = new int[] { 0 };
        this.patterns = new Pattern[] { new Pattern(4, 64) };
        this.instruments = new Instrument[] { new Instrument(), new Instrument() };
        if (moduleData.strLatin1(0, 17).equals("Extended Module: ")) {
            this.loadXM(moduleData);
        }
        else if (moduleData.strLatin1(44, 4).equals("SCRM")) {
            this.loadS3M(moduleData);
        }
        else {
            this.loadMod(moduleData);
        }
    }
    
    public Module(final byte[] moduleData) throws IOException {
        this(new Data(moduleData));
    }
    
    private void loadMod(final Data moduleData) throws IOException {
        this.songName = moduleData.strLatin1(0, 20);
        this.sequenceLength = (moduleData.uByte(950) & 0x7F);
        this.restartPos = (moduleData.uByte(951) & 0x7F);
        if (this.restartPos >= this.sequenceLength) {
            this.restartPos = 0;
        }
        this.sequence = new int[128];
        for (int seqIdx = 0; seqIdx < 128; ++seqIdx) {
            final int patIdx = moduleData.uByte(952 + seqIdx) & 0x7F;
            if ((this.sequence[seqIdx] = patIdx) >= this.numPatterns) {
                this.numPatterns = patIdx + 1;
            }
        }
        switch (moduleData.ubeShort(1082)) {
            case 19233:
            case 19246:
            case 21556: {
                this.numChannels = 4;
                this.c2Rate = 8287;
                this.gain = 64;
                break;
            }
            case 18510: {
                this.numChannels = moduleData.uByte(1080) - 48;
                this.c2Rate = 8363;
                this.gain = 32;
                break;
            }
            case 17224: {
                this.numChannels = (moduleData.uByte(1080) - 48) * 10;
                this.numChannels += moduleData.uByte(1081) - 48;
                this.c2Rate = 8363;
                this.gain = 32;
                break;
            }
            default: {
                throw new IllegalArgumentException("MOD Format not recognised!");
            }
        }
        this.defaultGVol = 64;
        this.defaultSpeed = 6;
        this.defaultTempo = 125;
        this.defaultPanning = new int[this.numChannels];
        for (int idx = 0; idx < this.numChannels; ++idx) {
            this.defaultPanning[idx] = 51;
            if ((idx & 0x3) == 0x1 || (idx & 0x3) == 0x2) {
                this.defaultPanning[idx] = 204;
            }
        }
        int moduleDataIdx = 1084;
        this.patterns = new Pattern[this.numPatterns];
        for (int patIdx = 0; patIdx < this.numPatterns; ++patIdx) {
            final Pattern[] patterns = this.patterns;
            final int n = patIdx;
            final Pattern pattern2 = new Pattern(this.numChannels, 64);
            patterns[n] = pattern2;
            final Pattern pattern = pattern2;
            for (int patDataIdx = 0; patDataIdx < pattern.data.length; patDataIdx += 5) {
                int period = (moduleData.uByte(moduleDataIdx) & 0xF) << 8;
                period = (period | moduleData.uByte(moduleDataIdx + 1)) * 4;
                if (period > 112) {
                    pattern.data[patDataIdx] = (byte)Channel.periodToKey(period);
                }
                int ins = (moduleData.uByte(moduleDataIdx + 2) & 0xF0) >> 4;
                ins |= (moduleData.uByte(moduleDataIdx) & 0x10);
                pattern.data[patDataIdx + 1] = (byte)ins;
                int effect = moduleData.uByte(moduleDataIdx + 2) & 0xF;
                int param = moduleData.uByte(moduleDataIdx + 3);
                if (param == 0 && (effect < 3 || effect == 10)) {
                    effect = 0;
                }
                if (param == 0 && (effect == 5 || effect == 6)) {
                    effect -= 2;
                }
                if (effect == 8 && this.numChannels == 4) {
                    param = (effect = 0);
                }
                pattern.data[patDataIdx + 3] = (byte)effect;
                pattern.data[patDataIdx + 4] = (byte)param;
                moduleDataIdx += 4;
            }
        }
        this.numInstruments = 31;
        (this.instruments = new Instrument[this.numInstruments + 1])[0] = new Instrument();
        for (int instIdx = 1; instIdx <= this.numInstruments; ++instIdx) {
            final Instrument[] instruments = this.instruments;
            final int n2 = instIdx;
            final Instrument instrument2 = new Instrument();
            instruments[n2] = instrument2;
            final Instrument instrument = instrument2;
            final Sample sample = instrument.samples[0];
            instrument.name = moduleData.strLatin1(instIdx * 30 - 10, 22);
            final int sampleLength = moduleData.ubeShort(instIdx * 30 + 12) * 2;
            final int fineTune = (moduleData.uByte(instIdx * 30 + 14) & 0xF) << 4;
            sample.fineTune = ((fineTune < 128) ? fineTune : (fineTune - 256));
            final int volume = moduleData.uByte(instIdx * 30 + 15) & 0x7F;
            sample.volume = ((volume <= 64) ? volume : 64);
            sample.panning = -1;
            sample.c2Rate = this.c2Rate;
            int loopStart = moduleData.ubeShort(instIdx * 30 + 16) * 2;
            int loopLength = moduleData.ubeShort(instIdx * 30 + 18) * 2;
            if (loopStart + loopLength > sampleLength) {
                loopLength = sampleLength - loopStart;
            }
            if (loopLength < 4) {
                loopStart = sampleLength;
                loopLength = 0;
            }
            sample.setSampleData(moduleData.samS8(moduleDataIdx, sampleLength), loopStart, loopLength, false);
            moduleDataIdx += sampleLength;
        }
    }
    
    private void loadS3M(final Data moduleData) throws IOException {
        this.songName = moduleData.strCp850(0, 28);
        this.sequenceLength = moduleData.uleShort(32);
        this.numInstruments = moduleData.uleShort(34);
        this.numPatterns = moduleData.uleShort(36);
        final int flags = moduleData.uleShort(38);
        final int version = moduleData.uleShort(40);
        this.fastVolSlides = ((flags & 0x40) == 0x40 || version == 4864);
        final boolean signedSamples = moduleData.uleShort(42) == 1;
        if (moduleData.uleInt(44) != 1297236819) {
            throw new IllegalArgumentException("Not an S3M file!");
        }
        this.defaultGVol = moduleData.uByte(48);
        this.defaultSpeed = moduleData.uByte(49);
        this.defaultTempo = moduleData.uByte(50);
        this.c2Rate = 8363;
        this.gain = (moduleData.uByte(51) & 0x7F);
        final boolean stereoMode = (moduleData.uByte(51) & 0x80) == 0x80;
        final boolean defaultPan = moduleData.uByte(53) == 252;
        final int[] channelMap = new int[32];
        for (int chanIdx = 0; chanIdx < 32; ++chanIdx) {
            channelMap[chanIdx] = -1;
            if (moduleData.uByte(64 + chanIdx) < 16) {
                channelMap[chanIdx] = this.numChannels++;
            }
        }
        this.sequence = new int[this.sequenceLength];
        for (int seqIdx = 0; seqIdx < this.sequenceLength; ++seqIdx) {
            this.sequence[seqIdx] = moduleData.uByte(96 + seqIdx);
        }
        int moduleDataIdx = 96 + this.sequenceLength;
        (this.instruments = new Instrument[this.numInstruments + 1])[0] = new Instrument();
        for (int instIdx = 1; instIdx <= this.numInstruments; ++instIdx) {
            final Instrument[] instruments = this.instruments;
            final int n = instIdx;
            final Instrument instrument2 = new Instrument();
            instruments[n] = instrument2;
            final Instrument instrument = instrument2;
            final Sample sample = instrument.samples[0];
            final int instOffset = moduleData.uleShort(moduleDataIdx) << 4;
            moduleDataIdx += 2;
            instrument.name = moduleData.strCp850(instOffset + 48, 28);
            if (moduleData.uByte(instOffset) == 1) {
                if (moduleData.uleShort(instOffset + 76) == 17235) {
                    int sampleOffset = moduleData.uByte(instOffset + 13) << 20;
                    sampleOffset += moduleData.uleShort(instOffset + 14) << 4;
                    final int sampleLength = moduleData.uleInt(instOffset + 16);
                    int loopStart = moduleData.uleInt(instOffset + 20);
                    int loopLength = moduleData.uleInt(instOffset + 24) - loopStart;
                    sample.volume = moduleData.uByte(instOffset + 28);
                    sample.panning = -1;
                    final boolean packed = moduleData.uByte(instOffset + 30) != 0;
                    final boolean loopOn = (moduleData.uByte(instOffset + 31) & 0x1) == 0x1;
                    if (loopStart + loopLength > sampleLength) {
                        loopLength = sampleLength - loopStart;
                    }
                    if (loopLength < 1 || !loopOn) {
                        loopStart = sampleLength;
                        loopLength = 0;
                    }
                    final boolean stereo = (moduleData.uByte(instOffset + 31) & 0x2) == 0x2;
                    final boolean sixteenBit = (moduleData.uByte(instOffset + 31) & 0x4) == 0x4;
                    if (packed) {
                        throw new IllegalArgumentException("Packed samples not supported!");
                    }
                    sample.c2Rate = moduleData.uleInt(instOffset + 32);
                    if (sixteenBit) {
                        if (signedSamples) {
                            sample.setSampleData(moduleData.samS16(sampleOffset, sampleLength), loopStart, loopLength, false);
                        }
                        else {
                            sample.setSampleData(moduleData.samU16(sampleOffset, sampleLength), loopStart, loopLength, false);
                        }
                    }
                    else if (signedSamples) {
                        sample.setSampleData(moduleData.samS8(sampleOffset, sampleLength), loopStart, loopLength, false);
                    }
                    else {
                        sample.setSampleData(moduleData.samU8(sampleOffset, sampleLength), loopStart, loopLength, false);
                    }
                }
            }
        }
        this.patterns = new Pattern[this.numPatterns];
        for (int patIdx = 0; patIdx < this.numPatterns; ++patIdx) {
            final Pattern[] patterns = this.patterns;
            final int n2 = patIdx;
            final Pattern pattern2 = new Pattern(this.numChannels, 64);
            patterns[n2] = pattern2;
            final Pattern pattern = pattern2;
            int inOffset = (moduleData.uleShort(moduleDataIdx) << 4) + 2;
            int rowIdx = 0;
            while (rowIdx < 64) {
                final int token = moduleData.uByte(inOffset++);
                if (token == 0) {
                    ++rowIdx;
                }
                else {
                    int noteKey = 0;
                    int noteIns = 0;
                    if ((token & 0x20) == 0x20) {
                        noteKey = moduleData.uByte(inOffset++);
                        noteIns = moduleData.uByte(inOffset++);
                        if (noteKey < 254) {
                            noteKey = (noteKey >> 4) * 12 + (noteKey & 0xF) + 1;
                        }
                        if (noteKey == 255) {
                            noteKey = 0;
                        }
                    }
                    int noteVol = 0;
                    if ((token & 0x40) == 0x40) {
                        noteVol = (moduleData.uByte(inOffset++) & 0x7F) + 16;
                        if (noteVol > 80) {
                            noteVol = 0;
                        }
                    }
                    int noteEffect = 0;
                    int noteParam = 0;
                    if ((token & 0x80) == 0x80) {
                        noteEffect = moduleData.uByte(inOffset++);
                        noteParam = moduleData.uByte(inOffset++);
                        if (noteEffect < 1 || noteEffect >= 64) {
                            noteParam = (noteEffect = 0);
                        }
                        if (noteEffect > 0) {
                            noteEffect += 128;
                        }
                    }
                    final int chanIdx2 = channelMap[token & 0x1F];
                    if (chanIdx2 < 0) {
                        continue;
                    }
                    final int noteOffset = (rowIdx * this.numChannels + chanIdx2) * 5;
                    pattern.data[noteOffset] = (byte)noteKey;
                    pattern.data[noteOffset + 1] = (byte)noteIns;
                    pattern.data[noteOffset + 2] = (byte)noteVol;
                    pattern.data[noteOffset + 3] = (byte)noteEffect;
                    pattern.data[noteOffset + 4] = (byte)noteParam;
                }
            }
            moduleDataIdx += 2;
        }
        this.defaultPanning = new int[this.numChannels];
        for (int chanIdx3 = 0; chanIdx3 < 32; ++chanIdx3) {
            if (channelMap[chanIdx3] >= 0) {
                int panning = 7;
                if (stereoMode) {
                    panning = 12;
                    if (moduleData.uByte(64 + chanIdx3) < 8) {
                        panning = 3;
                    }
                }
                if (defaultPan) {
                    final int panFlags = moduleData.uByte(moduleDataIdx + chanIdx3);
                    if ((panFlags & 0x20) == 0x20) {
                        panning = (panFlags & 0xF);
                    }
                }
                this.defaultPanning[channelMap[chanIdx3]] = panning * 17;
            }
        }
    }
    
    private void loadXM(final Data moduleData) throws IOException {
        if (moduleData.uleShort(58) != 260) {
            throw new IllegalArgumentException("XM format version must be 0x0104!");
        }
        this.songName = moduleData.strCp850(17, 20);
        final boolean deltaEnv = moduleData.strLatin1(38, 20).startsWith("DigiBooster Pro");
        int dataOffset = 60 + moduleData.uleInt(60);
        this.sequenceLength = moduleData.uleShort(64);
        this.restartPos = moduleData.uleShort(66);
        this.numChannels = moduleData.uleShort(68);
        this.numPatterns = moduleData.uleShort(70);
        this.numInstruments = moduleData.uleShort(72);
        this.linearPeriods = ((moduleData.uleShort(74) & 0x1) > 0);
        this.defaultGVol = 64;
        this.defaultSpeed = moduleData.uleShort(76);
        this.defaultTempo = moduleData.uleShort(78);
        this.c2Rate = 8363;
        this.gain = 64;
        this.defaultPanning = new int[this.numChannels];
        for (int idx = 0; idx < this.numChannels; ++idx) {
            this.defaultPanning[idx] = 128;
        }
        this.sequence = new int[this.sequenceLength];
        for (int seqIdx = 0; seqIdx < this.sequenceLength; ++seqIdx) {
            final int entry = moduleData.uByte(80 + seqIdx);
            this.sequence[seqIdx] = ((entry < this.numPatterns) ? entry : 0);
        }
        this.patterns = new Pattern[this.numPatterns];
        for (int patIdx = 0; patIdx < this.numPatterns; ++patIdx) {
            if (moduleData.uByte(dataOffset + 4) != 0) {
                throw new IllegalArgumentException("Unknown pattern packing type!");
            }
            final int numRows = moduleData.uleShort(dataOffset + 5);
            final int numNotes = numRows * this.numChannels;
            final Pattern[] patterns = this.patterns;
            final int n = patIdx;
            final Pattern pattern2 = new Pattern(this.numChannels, numRows);
            patterns[n] = pattern2;
            final Pattern pattern = pattern2;
            final int patternDataLength = moduleData.uleShort(dataOffset + 7);
            dataOffset += moduleData.uleInt(dataOffset);
            final int nextOffset = dataOffset + patternDataLength;
            if (patternDataLength > 0) {
                int patternDataOffset = 0;
                for (int note = 0; note < numNotes; ++note) {
                    int flags = moduleData.uByte(dataOffset);
                    if ((flags & 0x80) == 0x0) {
                        flags = 31;
                    }
                    else {
                        ++dataOffset;
                    }
                    final byte key = (byte)(((flags & 0x1) > 0) ? moduleData.sByte(dataOffset++) : 0);
                    pattern.data[patternDataOffset++] = key;
                    final byte ins = (byte)(((flags & 0x2) > 0) ? moduleData.sByte(dataOffset++) : 0);
                    pattern.data[patternDataOffset++] = ins;
                    final byte vol = (byte)(((flags & 0x4) > 0) ? moduleData.sByte(dataOffset++) : 0);
                    pattern.data[patternDataOffset++] = vol;
                    byte fxc = (byte)(((flags & 0x8) > 0) ? moduleData.sByte(dataOffset++) : 0);
                    byte fxp = (byte)(((flags & 0x10) > 0) ? moduleData.sByte(dataOffset++) : 0);
                    if (fxc >= 64) {
                        fxp = (fxc = 0);
                    }
                    pattern.data[patternDataOffset++] = fxc;
                    pattern.data[patternDataOffset++] = fxp;
                }
            }
            dataOffset = nextOffset;
        }
        (this.instruments = new Instrument[this.numInstruments + 1])[0] = new Instrument();
        for (int insIdx = 1; insIdx <= this.numInstruments; ++insIdx) {
            final Instrument[] instruments = this.instruments;
            final int n2 = insIdx;
            final Instrument instrument2 = new Instrument();
            instruments[n2] = instrument2;
            final Instrument instrument = instrument2;
            instrument.name = moduleData.strCp850(dataOffset + 4, 22);
            final Instrument instrument3 = instrument;
            final int uleShort = moduleData.uleShort(dataOffset + 27);
            instrument3.numSamples = uleShort;
            final int numSamples = uleShort;
            if (numSamples > 0) {
                instrument.samples = new Sample[numSamples];
                for (int keyIdx = 0; keyIdx < 96; ++keyIdx) {
                    instrument.keyToSample[keyIdx + 1] = moduleData.uByte(dataOffset + 33 + keyIdx);
                }
                final Instrument instrument4 = instrument;
                final Envelope volumeEnvelope = new Envelope();
                instrument4.volumeEnvelope = volumeEnvelope;
                final Envelope volEnv = volumeEnvelope;
                volEnv.pointsTick = new int[12];
                volEnv.pointsAmpl = new int[12];
                int pointTick = 0;
                for (int point = 0; point < 12; ++point) {
                    final int pointOffset = dataOffset + 129 + point * 4;
                    pointTick = (deltaEnv ? pointTick : 0) + moduleData.uleShort(pointOffset);
                    volEnv.pointsTick[point] = pointTick;
                    volEnv.pointsAmpl[point] = moduleData.uleShort(pointOffset + 2);
                }
                final Instrument instrument5 = instrument;
                final Envelope panningEnvelope = new Envelope();
                instrument5.panningEnvelope = panningEnvelope;
                final Envelope panEnv = panningEnvelope;
                panEnv.pointsTick = new int[12];
                panEnv.pointsAmpl = new int[12];
                pointTick = 0;
                for (int point2 = 0; point2 < 12; ++point2) {
                    final int pointOffset2 = dataOffset + 177 + point2 * 4;
                    pointTick = (deltaEnv ? pointTick : 0) + moduleData.uleShort(pointOffset2);
                    panEnv.pointsTick[point2] = pointTick;
                    panEnv.pointsAmpl[point2] = moduleData.uleShort(pointOffset2 + 2);
                }
                volEnv.numPoints = moduleData.uByte(dataOffset + 225);
                if (volEnv.numPoints > 12) {
                    volEnv.numPoints = 0;
                }
                panEnv.numPoints = moduleData.uByte(dataOffset + 226);
                if (panEnv.numPoints > 12) {
                    panEnv.numPoints = 0;
                }
                volEnv.sustainTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 227)];
                volEnv.loopStartTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 228)];
                volEnv.loopEndTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 229)];
                panEnv.sustainTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 230)];
                panEnv.loopStartTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 231)];
                panEnv.loopEndTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 232)];
                volEnv.enabled = (volEnv.numPoints > 0 && (moduleData.uByte(dataOffset + 233) & 0x1) > 0);
                volEnv.sustain = ((moduleData.uByte(dataOffset + 233) & 0x2) > 0);
                volEnv.looped = ((moduleData.uByte(dataOffset + 233) & 0x4) > 0);
                panEnv.enabled = (panEnv.numPoints > 0 && (moduleData.uByte(dataOffset + 234) & 0x1) > 0);
                panEnv.sustain = ((moduleData.uByte(dataOffset + 234) & 0x2) > 0);
                panEnv.looped = ((moduleData.uByte(dataOffset + 234) & 0x4) > 0);
                instrument.vibratoType = moduleData.uByte(dataOffset + 235);
                instrument.vibratoSweep = moduleData.uByte(dataOffset + 236);
                instrument.vibratoDepth = moduleData.uByte(dataOffset + 237);
                instrument.vibratoRate = moduleData.uByte(dataOffset + 238);
                instrument.volumeFadeOut = moduleData.uleShort(dataOffset + 239);
            }
            int sampleHeaderOffset;
            dataOffset = (sampleHeaderOffset = dataOffset + moduleData.uleInt(dataOffset));
            dataOffset += numSamples * 40;
            for (int samIdx = 0; samIdx < numSamples; ++samIdx) {
                final Sample[] samples = instrument.samples;
                final int n3 = samIdx;
                final Sample sample2 = new Sample();
                samples[n3] = sample2;
                final Sample sample = sample2;
                final int sampleDataBytes = moduleData.uleInt(sampleHeaderOffset);
                int sampleLoopStart = moduleData.uleInt(sampleHeaderOffset + 4);
                int sampleLoopLength = moduleData.uleInt(sampleHeaderOffset + 8);
                sample.volume = moduleData.sByte(sampleHeaderOffset + 12);
                sample.fineTune = moduleData.sByte(sampleHeaderOffset + 13);
                sample.c2Rate = 8363;
                final boolean looped = (moduleData.uByte(sampleHeaderOffset + 14) & 0x3) > 0;
                final boolean pingPong = (moduleData.uByte(sampleHeaderOffset + 14) & 0x2) > 0;
                final boolean sixteenBit = (moduleData.uByte(sampleHeaderOffset + 14) & 0x10) > 0;
                sample.panning = moduleData.uByte(sampleHeaderOffset + 15);
                sample.relNote = moduleData.sByte(sampleHeaderOffset + 16);
                sample.name = moduleData.strCp850(sampleHeaderOffset + 18, 22);
                sampleHeaderOffset += 40;
                if (!looped || sampleLoopStart + sampleLoopLength > sampleDataBytes) {
                    sampleLoopStart = sampleDataBytes;
                    sampleLoopLength = 0;
                }
                if (sixteenBit) {
                    sample.setSampleData(moduleData.samS16D(dataOffset, sampleDataBytes >> 1), sampleLoopStart >> 1, sampleLoopLength >> 1, pingPong);
                }
                else {
                    sample.setSampleData(moduleData.samS8D(dataOffset, sampleDataBytes), sampleLoopStart, sampleLoopLength, pingPong);
                }
                dataOffset += sampleDataBytes;
            }
        }
    }
    
    public void toStringBuffer(final StringBuffer out) {
        out.append("Song Name: " + this.songName + '\n' + "Num Channels: " + this.numChannels + '\n' + "Num Instruments: " + this.numInstruments + '\n' + "Num Patterns: " + this.numPatterns + '\n' + "Sequence Length: " + this.sequenceLength + '\n' + "Restart Pos: " + this.restartPos + '\n' + "Default Speed: " + this.defaultSpeed + '\n' + "Default Tempo: " + this.defaultTempo + '\n' + "Linear Periods: " + this.linearPeriods + '\n');
        out.append("Sequence: ");
        for (int seqIdx = 0; seqIdx < this.sequence.length; ++seqIdx) {
            out.append(this.sequence[seqIdx] + ", ");
        }
        out.append('\n');
        for (int patIdx = 0; patIdx < this.patterns.length; ++patIdx) {
            out.append("Pattern " + patIdx + ":\n");
            this.patterns[patIdx].toStringBuffer(out);
        }
        for (int insIdx = 1; insIdx < this.instruments.length; ++insIdx) {
            out.append("Instrument " + insIdx + ":\n");
            this.instruments[insIdx].toStringBuffer(out);
        }
    }
}
