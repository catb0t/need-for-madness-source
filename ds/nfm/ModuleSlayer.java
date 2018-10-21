package ds.nfm;

import java.io.IOException;

public abstract class ModuleSlayer
{
    public int oln;
    public int olav;
    public int rollBack;
    public int rollBackPos;
    public int rollBackTrig;
    public boolean loopMark;
    
    public ModuleSlayer() {
        this.oln = 0;
        this.olav = 0;
        this.rollBack = -1;
        this.rollBackPos = 0;
        this.rollBackTrig = 0;
        this.loopMark = false;
    }
    
    public abstract byte[] turnbytesNorm(final boolean p0) throws IOException;
}
