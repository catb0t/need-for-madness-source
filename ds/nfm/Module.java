package ds.nfm;

import java.io.IOException;
import java.io.InputStream;

public abstract class Module
{
    protected String name;
    protected boolean loaded;
    
    public Module() {
        this.loaded = false;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isLoaded() {
        return this.loaded;
    }
    
    public abstract void loadMod(final InputStream p0) throws IOException;
}
