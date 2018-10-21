package ibxm;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.InputStream;

public class Data
{
    private int bufLen;
    private byte[] buffer;
    private InputStream stream;
    
    public Data(final InputStream inputStream) throws IOException {
        this.bufLen = 65536;
        this.buffer = new byte[this.bufLen];
        readFully(this.stream = inputStream, this.buffer, 0, this.bufLen);
    }
    
    public Data(final byte[] data) {
        this.bufLen = data.length;
        this.buffer = data;
    }
    
    public byte sByte(final int offset) throws IOException {
        this.load(offset, 1);
        return this.buffer[offset];
    }
    
    public int uByte(final int offset) throws IOException {
        this.load(offset, 1);
        return this.buffer[offset] & 0xFF;
    }
    
    public int ubeShort(final int offset) throws IOException {
        this.load(offset, 2);
        return (this.buffer[offset] & 0xFF) << 8 | (this.buffer[offset + 1] & 0xFF);
    }
    
    public int uleShort(final int offset) throws IOException {
        this.load(offset, 2);
        return (this.buffer[offset] & 0xFF) | (this.buffer[offset + 1] & 0xFF) << 8;
    }
    
    public int uleInt(final int offset) throws IOException {
        this.load(offset, 4);
        int value = this.buffer[offset] & 0xFF;
        value |= (this.buffer[offset + 1] & 0xFF) << 8;
        value |= (this.buffer[offset + 2] & 0xFF) << 16;
        value |= (this.buffer[offset + 3] & 0x7F) << 24;
        return value;
    }
    
    public String strLatin1(final int offset, final int length) throws IOException {
        this.load(offset, length);
        final char[] str = new char[length];
        for (int idx = 0; idx < length; ++idx) {
            final int chr = this.buffer[offset + idx] & 0xFF;
            str[idx] = ((chr < 32) ? ' ' : ((char)chr));
        }
        return new String(str);
    }
    
    public String strCp850(final int offset, final int length) throws IOException {
        this.load(offset, length);
        try {
            final char[] str = new String(this.buffer, offset, length, "Cp850").toCharArray();
            for (int idx = 0; idx < str.length; ++idx) {
                str[idx] = ((str[idx] < ' ') ? ' ' : str[idx]);
            }
            return new String(str);
        }
        catch (UnsupportedEncodingException e) {
            return this.strLatin1(offset, length);
        }
    }
    
    public short[] samS8(final int offset, final int length) throws IOException {
        this.load(offset, length);
        final short[] sampleData = new short[length];
        for (int idx = 0; idx < length; ++idx) {
            sampleData[idx] = (short)(this.buffer[offset + idx] << 8);
        }
        return sampleData;
    }
    
    public short[] samS8D(final int offset, final int length) throws IOException {
        this.load(offset, length);
        final short[] sampleData = new short[length];
        int sam = 0;
        for (int idx = 0; idx < length; ++idx) {
            sam += this.buffer[offset + idx];
            sampleData[idx] = (short)(sam << 8);
        }
        return sampleData;
    }
    
    public short[] samU8(final int offset, final int length) throws IOException {
        this.load(offset, length);
        final short[] sampleData = new short[length];
        for (int idx = 0; idx < length; ++idx) {
            sampleData[idx] = (short)((this.buffer[offset + idx] & 0xFF) - 128 << 8);
        }
        return sampleData;
    }
    
    public short[] samS16(final int offset, final int samples) throws IOException {
        this.load(offset, samples * 2);
        final short[] sampleData = new short[samples];
        for (int idx = 0; idx < samples; ++idx) {
            sampleData[idx] = (short)((this.buffer[offset + idx * 2] & 0xFF) | this.buffer[offset + idx * 2 + 1] << 8);
        }
        return sampleData;
    }
    
    public short[] samS16D(final int offset, final int samples) throws IOException {
        this.load(offset, samples * 2);
        final short[] sampleData = new short[samples];
        int sam = 0;
        for (int idx = 0; idx < samples; ++idx) {
            sam += ((this.buffer[offset + idx * 2] & 0xFF) | this.buffer[offset + idx * 2 + 1] << 8);
            sampleData[idx] = (short)sam;
        }
        return sampleData;
    }
    
    public short[] samU16(final int offset, final int samples) throws IOException {
        this.load(offset, samples * 2);
        final short[] sampleData = new short[samples];
        for (int idx = 0; idx < samples; ++idx) {
            final int sam = (this.buffer[offset + idx * 2] & 0xFF) | (this.buffer[offset + idx * 2 + 1] & 0xFF) << 8;
            sampleData[idx] = (short)(sam - 32768);
        }
        return sampleData;
    }
    
    private void load(final int offset, final int length) throws IOException {
        while (offset + length > this.bufLen) {
            final int newBufLen = this.bufLen << 1;
            final byte[] newBuf = new byte[newBufLen];
            System.arraycopy(this.buffer, 0, newBuf, 0, this.bufLen);
            if (this.stream != null) {
                readFully(this.stream, newBuf, this.bufLen, newBufLen - this.bufLen);
            }
            this.bufLen = newBufLen;
            this.buffer = newBuf;
        }
    }
    
    private static void readFully(final InputStream inputStream, final byte[] buffer, int offset, final int length) throws IOException {
        for (int read = 1, end = offset + length; read > 0; read = inputStream.read(buffer, offset, end - offset), offset += read) {}
    }
}
