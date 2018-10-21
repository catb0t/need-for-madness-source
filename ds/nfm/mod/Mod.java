package ds.nfm.mod;

import java.io.IOException;
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import ds.nfm.Module;

public class Mod extends Module
{
    int numtracks;
    int track_shift;
    int numpatterns;
    byte[][] patterns;
    ModInstrument[] insts;
    byte[] positions;
    int song_length_patterns;
    int song_repeat_patterns;
    boolean s3m;
    static final int voice_mk;
    static final int voice_mk2;
    static final int voice_mk3;
    static final int voice_flt4;
    static final int voice_flt8;
    static final int voice_fltoct;
    static final int voice_6chn;
    static final int voice_8chn;
    static final int voice_10ch;
    static final int voice_12ch;
    static final int voice_14ch;
    static final int voice_16ch;
    static final int voice_18ch;
    static final int voice_20ch;
    static final int voice_22ch;
    static final int voice_24ch;
    static final int voice_26ch;
    static final int voice_28ch;
    static final int voice_30ch;
    static final int voice_32ch;
    static final int voice_11ch;
    static final int voice_13ch;
    static final int voice_15ch;
    static final int voice_tdz1;
    static final int voice_tdz2;
    static final int voice_tdz3;
    static final int voice_5chn;
    static final int voice_7chn;
    static final int voice_9chn;
    static final int[] voice_31_list;
    
    public Mod(final byte[] modf) {
        try {
            this.loadMod(new ByteArrayInputStream(modf));
            this.loaded = true;
        }
        catch (Exception e) {
            this.loaded = false;
        }
    }
    
    static final int FOURCC(final String s) {
        return (s.charAt(3) & '\u00ff') | (s.charAt(2) & '\u00ff') << 8 | (s.charAt(1) & '\u00ff') << 16 | (s.charAt(0) & '\u00ff') << 24;
    }
    
    @Override
    public void loadMod(final InputStream inputstream) throws IOException {
        final DataInputStream datainputstream = new DataInputStream(inputstream);
        byte samples = 15;
        this.numtracks = 4;
        this.name = readText(datainputstream, 20);
        if (this.name.trim().isEmpty()) {
            this.name = "Untitled";
        }
        datainputstream.mark(1068);
        datainputstream.skip(1060L);
        final int signature = datainputstream.readInt();
        datainputstream.reset();
        for (int i = 0; i < Mod.voice_31_list.length; ++i) {
            if (signature == Mod.voice_31_list[i]) {
                samples = 31;
                break;
            }
        }
        if (samples == 31) {
            if (signature == Mod.voice_8chn) {
                this.numtracks = 8;
            }
            else if (signature == Mod.voice_6chn) {
                this.numtracks = 6;
            }
            else if (signature == Mod.voice_10ch) {
                this.numtracks = 10;
            }
            else if (signature == Mod.voice_28ch) {
                this.numtracks = 28;
            }
            else if (signature == Mod.voice_12ch) {
                this.numtracks = 12;
            }
            else if (signature == Mod.voice_14ch) {
                this.numtracks = 14;
            }
            else if (signature == Mod.voice_16ch) {
                this.numtracks = 16;
            }
            else if (signature == Mod.voice_18ch) {
                this.numtracks = 18;
            }
            else if (signature == Mod.voice_20ch) {
                this.numtracks = 20;
            }
            else if (signature == Mod.voice_22ch) {
                this.numtracks = 22;
            }
            else if (signature == Mod.voice_24ch) {
                this.numtracks = 24;
            }
            else if (signature == Mod.voice_26ch) {
                this.numtracks = 26;
            }
            else if (signature == Mod.voice_30ch) {
                this.numtracks = 30;
            }
            else if (signature == Mod.voice_32ch) {
                this.numtracks = 32;
            }
            else if (signature == Mod.voice_tdz1) {
                this.numtracks = 1;
            }
            else if (signature == Mod.voice_tdz2) {
                this.numtracks = 2;
            }
            else if (signature == Mod.voice_tdz3) {
                this.numtracks = 3;
            }
            else if (signature == Mod.voice_5chn) {
                this.numtracks = 5;
            }
            else if (signature == Mod.voice_7chn) {
                this.numtracks = 7;
            }
            else if (signature == Mod.voice_9chn) {
                this.numtracks = 9;
            }
            else if (signature == Mod.voice_11ch) {
                this.numtracks = 11;
            }
            else if (signature == Mod.voice_13ch) {
                this.numtracks = 13;
            }
            else if (signature == Mod.voice_15ch) {
                this.numtracks = 15;
            }
        }
        else {
            System.out.print("Format unknown. Checking bytes... ");
            datainputstream.mark(0);
            datainputstream.reset();
            datainputstream.skip(471L);
            final byte readByte = datainputstream.readByte();
            if (readByte >= 32 && readByte <= 126) {
                samples = 31;
            }
            System.out.println(readByte);
            datainputstream.mark(1068);
            datainputstream.reset();
            datainputstream.skip(1064L);
        }
        this.insts = new ModInstrument[samples];
        for (int j = 0; j < samples; ++j) {
            this.insts[j] = readInstrument(datainputstream);
        }
        this.readSequence(datainputstream);
        datainputstream.skipBytes(4);
        this.readPatterns(datainputstream);
        try {
            for (int k = 0; k < samples; ++k) {
                readSampleData(datainputstream, this.insts[k]);
            }
        }
        catch (EOFException _ex) {
            System.out.println("Warning: EOF on MOD file");
        }
        datainputstream.close();
        inputstream.close();
    }
    
    public int getNumPatterns() {
        return this.numpatterns;
    }
    
    public int getNumTracks() {
        return this.numtracks;
    }
    
    static ModInstrument readInstrument(final DataInputStream datainputstream) throws IOException {
        final ModInstrument modinstrument = new ModInstrument();
        modinstrument.name = readText(datainputstream, 22);
        modinstrument.sample_length = readu16(datainputstream) << 1;
        modinstrument.samples = new byte[modinstrument.sample_length + 8];
        int fine = readu8(datainputstream) & 0xF;
        fine = ((fine > 7) ? (fine - 16) : fine);
        modinstrument.finetune_value = (byte)(fine << 4);
        modinstrument.volume = readu8(datainputstream);
        modinstrument.repeat_point = readu16(datainputstream) << 1;
        modinstrument.repeat_length = readu16(datainputstream) << 1;
        if (modinstrument.repeat_point > modinstrument.sample_length) {
            modinstrument.repeat_point = modinstrument.sample_length - 1;
        }
        if (modinstrument.repeat_point + modinstrument.repeat_length > modinstrument.sample_length) {
            modinstrument.repeat_length = modinstrument.sample_length - modinstrument.repeat_point;
        }
        return modinstrument;
    }
    
    void readPatterns(final DataInputStream datainputstream) throws IOException {
        final int i = this.numtracks * 4 * 64;
        this.patterns = new byte[this.numpatterns][];
        for (int j = 0; j < this.numpatterns; ++j) {
            datainputstream.readFully(this.patterns[j] = new byte[i], 0, i);
        }
    }
    
    static void readSampleData(final DataInputStream datainputstream, final ModInstrument modinstrument) throws IOException {
        datainputstream.readFully(modinstrument.samples, 0, modinstrument.sample_length);
        if (modinstrument.repeat_length > 3) {
            System.arraycopy(modinstrument.samples, modinstrument.repeat_point, modinstrument.samples, modinstrument.sample_length, 8);
        }
    }
    
    void readSequence(final DataInputStream datainputstream) throws IOException {
        this.positions = new byte[128];
        this.song_length_patterns = readu8(datainputstream);
        this.song_repeat_patterns = readu8(datainputstream);
        datainputstream.readFully(this.positions, 0, 128);
        if (this.song_repeat_patterns > this.song_length_patterns) {
            this.song_repeat_patterns = this.song_length_patterns;
        }
        this.numpatterns = 0;
        for (int i = 0; i < this.positions.length; ++i) {
            if (this.positions[i] > this.numpatterns) {
                this.numpatterns = this.positions[i];
            }
        }
        ++this.numpatterns;
    }
    
    static final String readText(final DataInputStream datainputstream, final int i) throws IOException {
        final byte[] abyte0 = new byte[i];
        datainputstream.readFully(abyte0, 0, i);
        for (int j = i - 1; j >= 0; --j) {
            if (abyte0[j] != 0) {
                return new String(abyte0, 0, 0, j + 1);
            }
        }
        return "";
    }
    
    static final int readu16(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readShort() & 0xFFFF;
    }
    
    static final int readu8(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readByte() & 0xFF;
    }
    
    @Override
    public String toString() {
        return this.name + " (" + this.numtracks + " tracks, " + this.numpatterns + " patterns, " + this.insts.length + " samples)";
    }
    
    static {
        voice_mk = FOURCC("M.K.");
        voice_mk2 = FOURCC("M!K!");
        voice_mk3 = FOURCC("M&K!");
        voice_flt4 = FOURCC("FLT4");
        voice_flt8 = FOURCC("FLT8");
        voice_fltoct = FOURCC("OCTA");
        voice_6chn = FOURCC("6CHN");
        voice_8chn = FOURCC("8CHN");
        voice_10ch = FOURCC("10CH");
        voice_12ch = FOURCC("12CH");
        voice_14ch = FOURCC("14CH");
        voice_16ch = FOURCC("16CH");
        voice_18ch = FOURCC("18CH");
        voice_20ch = FOURCC("20CH");
        voice_22ch = FOURCC("22CH");
        voice_24ch = FOURCC("24CH");
        voice_26ch = FOURCC("26CH");
        voice_28ch = FOURCC("28CH");
        voice_30ch = FOURCC("30CH");
        voice_32ch = FOURCC("32CH");
        voice_11ch = FOURCC("11CH");
        voice_13ch = FOURCC("13CH");
        voice_15ch = FOURCC("15CH");
        voice_tdz1 = FOURCC("TDZ1");
        voice_tdz2 = FOURCC("TDZ2");
        voice_tdz3 = FOURCC("TDZ3");
        voice_5chn = FOURCC("5CHN");
        voice_7chn = FOURCC("7CHN");
        voice_9chn = FOURCC("9CHN");
        voice_31_list = new int[] { Mod.voice_mk, Mod.voice_mk2, Mod.voice_mk3, Mod.voice_flt4, Mod.voice_flt8, Mod.voice_8chn, Mod.voice_6chn, Mod.voice_10ch, Mod.voice_12ch, Mod.voice_14ch, Mod.voice_16ch, Mod.voice_18ch, Mod.voice_20ch, Mod.voice_22ch, Mod.voice_24ch, Mod.voice_26ch, Mod.voice_28ch, Mod.voice_30ch, Mod.voice_32ch, Mod.voice_11ch, Mod.voice_13ch, Mod.voice_15ch, Mod.voice_tdz1, Mod.voice_tdz2, Mod.voice_tdz3, Mod.voice_5chn, Mod.voice_7chn, Mod.voice_9chn };
    }
}
