package ds.nfm.xm;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import ds.nfm.Module;

public class IBXMod extends Module
{
    ibxm.Module refMod;
    
    public IBXMod(final byte[] modf) {
        try {
            this.loadMod(new ByteArrayInputStream(modf));
            this.loaded = true;
        }
        catch (Exception e) {
            this.loaded = false;
        }
    }
    
    @Override
    public void loadMod(final InputStream inputstream) throws IOException {
        this.refMod = new ibxm.Module(inputstream);
    }
}
