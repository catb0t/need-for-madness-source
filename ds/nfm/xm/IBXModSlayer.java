package ds.nfm.xm;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import ibxm.IBXM;
import ibxm.Module;
import ds.nfm.ModuleSlayer;

public class IBXModSlayer extends ModuleSlayer
{
    private Module module;
    private IBXM ibxm;
    private int samplePos;
    private int duration;
    private int gain;
    public boolean offMark;
    public int offIndex;
    public int[] patternOffsets;
    
    public IBXModSlayer(final IBXMod pmod, final int smpl, final int gn, final int bpmflex) {
        this.gain = 300;
        this.offMark = false;
        this.offIndex = -1;
        this.module = pmod.refMod;
        if (this.module.defaultTempo == 125) {
            this.module.defaultTempo = bpmflex;
        }
        (this.ibxm = new IBXM(this.module, smpl / 2)).connect(this);
        this.ibxm.setInterpolation(1);
        this.gain = gn;
        this.duration = this.ibxm.calculateSongDuration();
    }
    
    public void offMark(final int index) {
        this.offIndex = index;
        this.offMark = true;
    }
    
    @Override
    public byte[] turnbytesNorm(final boolean calvol) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final int[] mixBuf = new int[this.ibxm.getMixBufferLength()];
        final byte[] outBuf = new byte[mixBuf.length * 2];
        this.oln = 0;
        int olniu = 1;
        int niu = 0;
        int cav = 0;
        final int maxsize = Math.min(18000000, this.duration * 2);
        while (this.oln < maxsize) {
            final int count = this.getAudio(mixBuf);
            if (this.offMark) {
                if (this.patternOffsets[this.offIndex] == 0) {
                    this.patternOffsets[this.offIndex] = this.oln;
                }
                this.offMark = false;
            }
            int outIdx;
            niu = (outIdx = (cav = 0));
            for (int mixIdx = 0, mixEnd = count * 2; mixIdx < mixEnd; ++mixIdx) {
                if (mixIdx % 2 == 0) {
                    int ampl = (int)(mixBuf[mixIdx] * (this.gain / 300.0f));
                    if (ampl > 32767) {
                        ampl = 32767;
                    }
                    if (ampl < -32768) {
                        ampl = -32768;
                    }
                    outBuf[outIdx++] = (byte)(ampl & 0xFF);
                    outBuf[outIdx++] = (byte)(ampl >> 8);
                    this.oln += 2;
                    if (calvol) {
                        cav += Math.abs(ampl);
                        ++niu;
                    }
                }
            }
            if (calvol && niu != 0) {
                cav /= niu;
                this.olav += cav;
                ++olniu;
            }
            out.write(outBuf, 0, outIdx);
            if (this.loopMark) {
                this.rollBackTrig = this.oln;
                this.loopMark = false;
            }
        }
        if (calvol) {
            this.olav /= olniu;
        }
        if (this.oln % 2 != 0) {
            ++this.oln;
        }
        return out.toByteArray();
    }
    
    private synchronized void seek(final int pos) {
        this.samplePos = this.ibxm.seek(pos);
    }
    
    private synchronized int getAudio(final int[] mixBuf) {
        final int count = this.ibxm.getAudio(mixBuf);
        this.samplePos += count;
        return count;
    }
}
