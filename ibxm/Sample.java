package ibxm;

public class Sample
{
    public static final int FP_SHIFT = 15;
    public static final int FP_ONE = 32768;
    public static final int FP_MASK = 32767;
    public static final int C2_PAL = 8287;
    public static final int C2_NTSC = 8363;
    public String name;
    public int volume;
    public int panning;
    public int relNote;
    public int fineTune;
    public int c2Rate;
    private int loopStart;
    private int loopLength;
    private short[] sampleData;
    private static final int LOG2_FILTER_TAPS = 4;
    private static final int FILTER_TAPS = 16;
    private static final int DELAY = 8;
    private static final int LOG2_TABLE_ACCURACY = 4;
    private static final int TABLE_ACCURACY = 16;
    private static final int TABLE_INTERP_SHIFT = 11;
    private static final int TABLE_INTERP_ONE = 2048;
    private static final int TABLE_INTERP_MASK = 2047;
    private static final int LOG2_NUM_TABLES = 3;
    private static final int NUM_TABLES = 8;
    private static final short[][] SINC_TABLES;
    
    public Sample() {
        this.name = "";
        this.volume = 0;
        this.panning = -1;
        this.relNote = 0;
        this.fineTune = 0;
        this.c2Rate = 8363;
        this.loopStart = 0;
        this.loopLength = 0;
    }
    
    private static short[][] calculateSincTables() {
        final short[][] sincTables = new short[8][];
        for (int tableIdx = 0; tableIdx < 8; ++tableIdx) {
            sincTables[tableIdx] = calculateSincTable(1.0 / (tableIdx + 1));
        }
        return sincTables;
    }
    
    private static short[] calculateSincTable(final double lowpass) {
        final short[] sincTable = new short[272];
        final double windDT = -0.39269908169872414;
        final double sincDT = -3.141592653589793;
        int tableIdx = 0;
        for (int tableY = 0; tableY <= 16; ++tableY) {
            final double fracT = tableY / 16.0;
            double sincT = 3.141592653589793 * (7.0 + fracT);
            double windT = 3.141592653589793 + sincT * 2.0 / 16.0;
            for (int tableX = 0; tableX < 16; ++tableX) {
                double sincY = lowpass;
                if (sincT != 0.0) {
                    sincY = Math.sin(lowpass * sincT) / sincT;
                }
                double windY = 0.35875;
                windY -= 0.48829 * Math.cos(windT);
                windY += 0.14128 * Math.cos(windT * 2.0);
                windY -= 0.01168 * Math.cos(windT * 3.0);
                sincTable[tableIdx++] = (short)Math.round(sincY * windY * 32767.0);
                sincT += sincDT;
                windT += windDT;
            }
        }
        return sincTable;
    }
    
    public void setSampleData(short[] sampleData, int loopStart, int loopLength, final boolean pingPong) {
        int sampleLength = sampleData.length;
        if (loopStart < 0 || loopStart > sampleLength) {
            loopStart = sampleLength;
        }
        if (loopLength < 0 || loopStart + loopLength > sampleLength) {
            loopLength = sampleLength - loopStart;
        }
        sampleLength = loopStart + loopLength;
        loopStart += 8;
        final int newSampleLength = 8 + sampleLength + (pingPong ? loopLength : 0) + 16;
        final short[] newSampleData = new short[newSampleLength];
        System.arraycopy(sampleData, 0, newSampleData, 8, sampleLength);
        sampleData = newSampleData;
        if (pingPong) {
            final int loopEnd = loopStart + loopLength;
            for (int idx = 0; idx < loopLength; ++idx) {
                sampleData[loopEnd + idx] = sampleData[loopEnd - idx - 1];
            }
            loopLength *= 2;
        }
        for (int idx2 = loopStart + loopLength, end = idx2 + 16; idx2 < end; ++idx2) {
            sampleData[idx2] = sampleData[idx2 - loopLength];
        }
        this.sampleData = sampleData;
        this.loopStart = loopStart;
        this.loopLength = loopLength;
    }
    
    public void resampleNearest(int sampleIdx, int sampleFrac, final int step, final int leftGain, final int rightGain, final int[] mixBuffer, final int offset, final int length) {
        final int loopLen = this.loopLength;
        final int loopEnd = this.loopStart + loopLen;
        sampleIdx += 8;
        if (sampleIdx >= loopEnd) {
            sampleIdx = this.normaliseSampleIdx(sampleIdx);
        }
        final short[] data = this.sampleData;
        int y;
        int n;
        int n2;
        for (int outIdx = offset << 1, outEnd = offset + length << 1; outIdx < outEnd; n = outIdx++, mixBuffer[n] += y * leftGain >> 15, n2 = outIdx++, mixBuffer[n2] += y * rightGain >> 15, sampleFrac += step, sampleIdx += sampleFrac >> 15, sampleFrac &= 0x7FFF) {
            if (sampleIdx >= loopEnd) {
                if (loopLen < 2) {
                    break;
                }
                while (sampleIdx >= loopEnd) {
                    sampleIdx -= loopLen;
                }
            }
            y = data[sampleIdx];
        }
    }
    
    public void resampleLinear(int sampleIdx, int sampleFrac, final int step, final int leftGain, final int rightGain, final int[] mixBuffer, final int offset, final int length) {
        final int loopLen = this.loopLength;
        final int loopEnd = this.loopStart + loopLen;
        sampleIdx += 8;
        if (sampleIdx >= loopEnd) {
            sampleIdx = this.normaliseSampleIdx(sampleIdx);
        }
        final short[] data = this.sampleData;
        int y;
        int n;
        int n2;
        for (int outIdx = offset << 1, outEnd = offset + length << 1; outIdx < outEnd; n = outIdx++, mixBuffer[n] += y * leftGain >> 15, n2 = outIdx++, mixBuffer[n2] += y * rightGain >> 15, sampleFrac += step, sampleIdx += sampleFrac >> 15, sampleFrac &= 0x7FFF) {
            if (sampleIdx >= loopEnd) {
                if (loopLen < 2) {
                    break;
                }
                while (sampleIdx >= loopEnd) {
                    sampleIdx -= loopLen;
                }
            }
            final int c = data[sampleIdx];
            final int m = data[sampleIdx + 1] - c;
            y = (m * sampleFrac >> 15) + c;
        }
    }
    
    public void resampleSinc(int sampleIdx, int sampleFrac, final int step, final int leftGain, final int rightGain, final int[] mixBuffer, final int offset, final int length) {
        int tableIdx = 0;
        if (step > 32768) {
            tableIdx = (step >> 15) - 1;
            if (tableIdx >= 8) {
                tableIdx = 7;
            }
        }
        final short[] sincTable = Sample.SINC_TABLES[tableIdx];
        final int loopLen = this.loopLength;
        final int loopEnd = this.loopStart + loopLen;
        if (sampleIdx >= loopEnd) {
            sampleIdx = this.normaliseSampleIdx(sampleIdx);
        }
        final short[] data = this.sampleData;
        int y;
        int n;
        int n2;
        for (int outIdx = offset << 1, outEnd = offset + length << 1; outIdx < outEnd; n = outIdx++, mixBuffer[n] += y * leftGain >> 15, n2 = outIdx++, mixBuffer[n2] += y * rightGain >> 15, sampleFrac += step, sampleIdx += sampleFrac >> 15, sampleFrac &= 0x7FFF) {
            if (sampleIdx >= loopEnd) {
                if (loopLen < 2) {
                    break;
                }
                while (sampleIdx >= loopEnd) {
                    sampleIdx -= loopLen;
                }
            }
            final int tableIdx2 = sampleFrac >> 11 << 4;
            final int tableIdx3 = tableIdx2 + 16;
            int a1 = 0;
            int a2 = 0;
            for (int tap = 0; tap < 16; ++tap) {
                a1 += sincTable[tableIdx2 + tap] * data[sampleIdx + tap];
                a2 += sincTable[tableIdx3 + tap] * data[sampleIdx + tap];
            }
            a1 >>= 15;
            a2 >>= 15;
            y = a1 + ((a2 - a1) * (sampleFrac & 0x7FF) >> 11);
        }
    }
    
    public int normaliseSampleIdx(int sampleIdx) {
        final int loopOffset = sampleIdx - this.loopStart;
        if (loopOffset > 0) {
            sampleIdx = this.loopStart;
            if (this.loopLength > 1) {
                sampleIdx += loopOffset % this.loopLength;
            }
        }
        return sampleIdx;
    }
    
    public boolean looped() {
        return this.loopLength > 1;
    }
    
    public void toStringBuffer(final StringBuffer out) {
        out.append("Name: " + this.name + '\n');
        out.append("Volume: " + this.volume + '\n');
        out.append("Panning: " + this.panning + '\n');
        out.append("Relative Note: " + this.relNote + '\n');
        out.append("Fine Tune: " + this.fineTune + '\n');
        out.append("Loop Start: " + this.loopStart + '\n');
        out.append("Loop Length: " + this.loopLength + '\n');
    }
    
    static {
        SINC_TABLES = calculateSincTables();
    }
}
