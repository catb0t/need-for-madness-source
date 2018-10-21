import ds.nfm.ModuleSlayer;
import ds.nfm.Module;
import java.net.URL;
import ds.nfm.ModuleLoader;

public class RadicalMod
{
    SuperClip sClip;
    boolean playing;
    int loaded;
    int rvol;
    String imod;
    String pmod;
    
    public RadicalMod() {
        this.playing = false;
        this.loaded = 0;
        this.rvol = 0;
        this.imod = "";
        this.pmod = "";
        this.loaded = 0;
        System.gc();
    }
    
    public RadicalMod(String replace, int n, int n2, final int n3, final boolean b, final boolean b2) {
        this.playing = false;
        this.loaded = 0;
        this.rvol = 0;
        this.imod = "";
        this.pmod = "";
        final int n4 = 22000;
        n2 = (int)(n2 / 8000.0f * 2.0f * n4);
        n *= (int)0.8f;
        try {
            Module module;
            if (!b2) {
                module = ModuleLoader.loadMod("" + Madness.fpath + "" + replace + "");
            }
            else {
                replace = replace.replace(' ', '_');
                module = ModuleLoader.loadMod(new URL("http://multiplayer.needformadness.com/tracks/music/" + replace + ".zip"));
            }
            if (module.isLoaded()) {
                final ModuleSlayer prepareSlayer = ModuleLoader.prepareSlayer(module, n2, n, n3);
                final byte[] turnbytesNorm = prepareSlayer.turnbytesNorm(b);
                if (b) {
                    this.rvol = prepareSlayer.olav;
                }
                this.sClip = new SuperClip(turnbytesNorm, prepareSlayer.oln, n4);
                this.sClip.rollBackPos = prepareSlayer.rollBackPos;
                this.sClip.rollBackTrig = prepareSlayer.oln - prepareSlayer.rollBackTrig;
                this.loaded = 2;
            }
        }
        catch (Exception ex) {
            System.out.println("Error downloading and making Mod: " + ex.toString());
            this.loaded = 0;
        }
        System.runFinalization();
        System.gc();
    }
    
    public RadicalMod(final String s) {
        this.playing = false;
        this.loaded = 0;
        this.rvol = 0;
        this.imod = "";
        this.pmod = "";
        this.loaded = 1;
        this.imod = "" + Madness.fpath + "" + s + "";
    }
    
    public void loadimod(final boolean b) {
        if (this.loaded == 1) {
            final int n = 44000;
            int n2 = 160;
            if (b) {
                n2 = 300;
            }
            final int n3 = 125;
            try {
                final Module loadMod = ModuleLoader.loadMod(this.imod);
                if (loadMod.isLoaded()) {
                    final ModuleSlayer prepareSlayer = ModuleLoader.prepareSlayer(loadMod, n, n2, n3);
                    final byte[] turnbytesNorm = prepareSlayer.turnbytesNorm(b);
                    if (b) {
                        this.rvol = prepareSlayer.olav;
                    }
                    this.sClip = new SuperClip(turnbytesNorm, prepareSlayer.oln, 22000);
                    this.sClip.rollBackPos = prepareSlayer.rollBackPos;
                    this.sClip.rollBackTrig = prepareSlayer.oln - prepareSlayer.rollBackTrig;
                    this.loaded = 2;
                }
            }
            catch (Exception ex) {
                System.out.println("Error making a imod: " + ex.toString());
                this.loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }
    
    public void loadpmod(final boolean b) {
        if (this.loaded == 1) {
            final int n = 44000;
            int n2 = 160;
            if (b) {
                n2 = 300;
            }
            final int n3 = 125;
            try {
                final Module loadMod = ModuleLoader.loadMod(this.pmod);
                if (loadMod.isLoaded()) {
                    final ModuleSlayer prepareSlayer = ModuleLoader.prepareSlayer(loadMod, n, n2, n3);
                    final byte[] turnbytesNorm = prepareSlayer.turnbytesNorm(b);
                    if (b) {
                        this.rvol = prepareSlayer.olav;
                    }
                    this.sClip = new SuperClip(turnbytesNorm, prepareSlayer.oln, 22000);
                    this.sClip.rollBackPos = prepareSlayer.rollBackPos;
                    this.sClip.rollBackTrig = prepareSlayer.oln - prepareSlayer.rollBackTrig;
                    this.loaded = 2;
                }
            }
            catch (Exception ex) {
                System.out.println("Error making a imod: " + ex.toString());
                this.loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }
    
    public RadicalMod(final String pmod, final boolean b) {
        this.playing = false;
        this.loaded = 0;
        this.rvol = 0;
        this.imod = "";
        this.pmod = "";
        this.loaded = 1;
        this.pmod = pmod;
        this.loadpmod(true);
    }
    
    public void play() {
        if (!this.playing && this.loaded == 2) {
            this.sClip.play();
            if (this.sClip.stoped == 0) {
                this.playing = true;
            }
        }
    }
    
    public void resume() {
        if (!this.playing && this.loaded == 2) {
            this.sClip.resume();
            if (this.sClip.stoped == 0) {
                this.playing = true;
            }
        }
    }
    
    public void stop() {
        if (this.playing && this.loaded == 2) {
            this.sClip.stop();
            this.playing = false;
        }
    }
    
    protected void unloadimod() {
        if (this.loaded == 2) {
            if (this.playing) {
                this.sClip.stop();
                this.playing = false;
            }
            try {
                this.sClip.close();
                this.sClip = null;
            }
            catch (Exception ex) {}
            System.gc();
            this.loaded = 1;
        }
    }
    
    protected void unload() {
        if (this.playing && this.loaded == 2) {
            this.sClip.stop();
            this.playing = false;
        }
        try {
            this.sClip.close();
            this.sClip = null;
        }
        catch (Exception ex) {}
        try {
            this.imod = null;
        }
        catch (Exception ex2) {}
        System.gc();
        this.loaded = 0;
    }
}
