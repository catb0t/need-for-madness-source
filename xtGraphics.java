import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.awt.RenderingHints;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.io.Reader;
import java.io.InputStreamReader;
import java.awt.Component;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.zip.ZipEntry;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Panel;

@SuppressWarnings("serial")
public class xtGraphics extends Panel implements Runnable
{
    Graphics2D rd;
    Medium m;
    CarDefine cd;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker app;
    int fase;
    int oldfase;
    int starcnt;
    boolean mtop;
    int opselect;
    int dropf;
    int cfase;
    boolean firstime;
    boolean shaded;
    int flipo;
    int nextc;
    int multion;
    int gmode;
    int[] unlocked;
    int[] scm;
    int looped;
    int warning;
    boolean newparts;
    boolean logged;
    boolean gotlog;
    boolean autolog;
    boolean nofull;
    int nfreeplays;
    int ndisco;
    int hours;
    boolean onviewpro;
    int playingame;
    int onjoin;
    int ontyp;
    boolean lan;
    float[] arnp;
    String nickname;
    String clan;
    String nickey;
    String clankey;
    String backlog;
    String server;
    String localserver;
    String servername;
    int servport;
    int gameport;
    int acexp;
    int discon;
    int cntptrys;
    int[] delays;
    int nplayers;
    int im;
    String[] plnames;
    int osc;
    int minsl;
    int maxsl;
    int[] sc;
    int[] xstart;
    int[] zstart;
    float[][] allrnp;
    boolean[] isbot;
    int clangame;
    boolean clanchat;
    String[] pclan;
    String gaclan;
    int lcarx;
    int lcary;
    int lcarz;
    int[] dcrashes;
    int beststunt;
    int laptime;
    int fastestlap;
    int sendstat;
    int testdrive;
    boolean holdit;
    int holdcnt;
    boolean winner;
    int[] flexpix;
    int[] smokey;
    Image fleximg;
    int flatrstart;
    Thread runner;
    int runtyp;
    int forstart;
    int exitm;
    Image odmg;
    Image opwr;
    Image opos;
    Image osped;
    Image owas;
    Image olap;
    Image oyourwasted;
    Image odisco;
    Image ogamefinished;
    Image oyoulost;
    Image oyouwon;
    Image oyouwastedem;
    Image ogameh;
    Image owgame;
    Image oloadingmusic;
    Image oflaot;
    Image oexitgame;
    Image mload;
    Image dmg;
    Image pwr;
    Image pos;
    Image sped;
    Image was;
    Image lap;
    Image br;
    Image select;
    Image loadingmusic;
    Image yourwasted;
    Image disco;
    Image gamefinished;
    Image youlost;
    Image youwon;
    Image youwastedem;
    Image gameh;
    Image wgame;
    Image congrd;
    Image gameov;
    Image carsbg;
    Image carsbgc;
    Image selectcar;
    Image statb;
    Image statbo;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image logocars;
    Image logomadnes;
    Image logomadbg;
    Image byrd;
    Image bggo;
    Image opback;
    Image nfmcoms;
    Image opti;
    Image opti2;
    Image bgmain;
    Image rpro;
    Image nfmcom;
    Image flaot;
    Image brt;
    Image arn;
    Image exitgame;
    Image pgate;
    Image fixhoop;
    Image sarrow;
    Image stunts;
    Image racing;
    Image wasting;
    Image plus;
    Image space;
    Image arrows;
    Image chil;
    Image ory;
    Image kz;
    Image kx;
    Image kv;
    Image km;
    Image kn;
    Image ks;
    Image kenter;
    Image nfm;
    Image login;
    Image register;
    Image play;
    Image sdets;
    Image cancel;
    Image bob;
    Image bot;
    Image bol;
    Image bolp;
    Image bor;
    Image borp;
    Image logout;
    Image change;
    Image pln;
    Image pon;
    Image dome;
    Image upgrade;
    Image bols;
    Image bolps;
    Image bors;
    Image borps;
    Image games;
    Image exit;
    Image chat;
    Image players;
    Image cgame;
    Image ccar;
    Image lanm;
    Image asu;
    Image asd;
    Image pls;
    Image sts;
    Image gmc;
    Image stg;
    Image crd;
    Image roomp;
    Image myfr;
    Image mycl;
    Image cnmc;
    Image redy;
    Image ntrg;
    Image[] bcl;
    Image[] bcr;
    Image[] bc;
    Image cmc;
    Image myc;
    Image gac;
    Image yac;
    Image ycmc;
    Image top20s;
    Image[] trackbg;
    Image[] dude;
    int duds;
    int dudo;
    Image[] next;
    Image[] back;
    Image[] contin;
    Image[] ostar;
    Image[] star;
    int pcontin;
    int pnext;
    int pback;
    int pstar;
    Image[] orank;
    Image[] rank;
    Image[] ocntdn;
    Image[] cntdn;
    int gocnt;
    soundClip[][] engs;
    boolean[] pengs;
    soundClip[] air;
    boolean aird;
    boolean grrd;
    soundClip[] crash;
    soundClip[] lowcrash;
    soundClip tires;
    soundClip checkpoint;
    soundClip carfixed;
    soundClip powerup;
    soundClip three;
    soundClip two;
    soundClip one;
    soundClip go;
    soundClip wastd;
    soundClip firewasted;
    boolean pwastd;
    soundClip[] skid;
    soundClip[] dustskid;
    soundClip[] scrape;
    boolean mutes;
    RadicalMod intertrack;
    RadicalMod strack;
    boolean loadedt;
    boolean mutem;
    boolean badmac;
    boolean arrace;
    int alocked;
    int lalocked;
    int cntflock;
    boolean onlock;
    int ana;
    int cntan;
    int cntovn;
    boolean flk;
    int tcnt;
    boolean tflk;
    String say;
    boolean wasay;
    int clear;
    int posit;
    int wasted;
    int laps;
    int[] dested;
    int dmcnt;
    boolean dmflk;
    int pwcnt;
    boolean pwflk;
    String[][] adj;
    String[] exlm;
    String loop;
    String spin;
    String asay;
    int auscnt;
    boolean aflk;
    int[] sndsize;
    Image hello;
    Image sign;
    Image loadbar;
    int kbload;
    int dnload;
    float shload;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int radpx;
    int pin;
    int[] trkx;
    int trkl;
    int trklim;
    int lmode;
    int[] bgmy;
    float bgf;
    boolean bgup;
    int[] ovx;
    int[] ovy;
    int[] ovw;
    int[] ovh;
    int[] ovsx;
    int removeds;
    int nfmtab;
    boolean justwon1;
    boolean justwon2;
    int lfrom;
    int lockcnt;
    boolean showtf;
    int ransay;
    String[][] cnames;
    String[][] sentn;
    int[] updatec;
    int[] movepos;
    int[] pointc;
    int[] floater;
    int[] cntchatp;
    int[] msgflk;
    String[] lcmsg;
    int flkat;
    int movly;
    int gxdu;
    int gydu;
    int muhi;
    int lsc;
    int mouson;
    int onmsc;
    boolean remi;
    int basefase;
    boolean noclass;
    int gatey;
    int[] pgatx;
    int[] pgaty;
    int[] pgady;
    boolean[] pgas;
    int waitlink;
    int lxm;
    int lym;
    int pwait;
    int stopcnt;
    int cntwis;
    int lcn;
    int crshturn;
    int bfcrash;
    int bfskid;
    boolean crashup;
    boolean skidup;
    int skflg;
    int dskflg;
    int bfscrape;
    int sturn0;
    int sturn1;
    int bfsc1;
    int bfsc2;
    int flatr;
    int flyr;
    int flyrdest;
    int flang;

    public xtGraphics(final Medium m, final CarDefine cd, final Graphics2D rd, final GameSparker app) {
        this.fase = 111;
        this.oldfase = 0;
        this.starcnt = 0;
        this.mtop = false;
        this.opselect = 0;
        this.dropf = 0;
        this.cfase = 0;
        this.firstime = true;
        this.shaded = false;
        this.flipo = 0;
        this.nextc = 0;
        this.multion = 0;
        this.gmode = 0;
        this.unlocked = new int[] { 1, 1 };
        this.scm = new int[] { 0, 0 };
        this.looped = 1;
        this.warning = 0;
        this.newparts = false;
        this.logged = false;
        this.gotlog = false;
        this.autolog = false;
        this.nofull = false;
        this.nfreeplays = 0;
        this.ndisco = 0;
        this.hours = 8;
        this.onviewpro = false;
        this.playingame = -1;
        this.onjoin = -1;
        this.ontyp = 0;
        this.lan = false;
        this.arnp = new float[] { 0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 0.0f };
        this.nickname = "";
        this.clan = "";
        this.nickey = "";
        this.clankey = "";
        this.backlog = "";
        this.server = "multiplayer.needformadness.com";
        this.localserver = "";
        this.servername = "Madness";
        this.servport = 7071;
        this.gameport = 7001;
        this.acexp = 0;
        this.discon = 0;
        this.cntptrys = 5;
        this.delays = new int[] { 600, 600, 600 };
        this.nplayers = 7;
        this.im = 0;
        this.plnames = new String[] { "", "", "", "", "", "", "", "" };
        this.osc = 10;
        this.minsl = 0;
        this.maxsl = 15;
        this.sc = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.xstart = new int[] { 0, -350, 350, 0, -350, 350, 0, 0 };
        this.zstart = new int[] { -760, -380, -380, 0, 380, 380, 760, 0 };
        this.allrnp = new float[8][6];
        this.isbot = new boolean[8];
        this.clangame = 0;
        this.clanchat = false;
        this.pclan = new String[] { "", "", "", "", "", "", "", "" };
        this.gaclan = "";
        this.lcarx = 0;
        this.lcary = 0;
        this.lcarz = 0;
        this.dcrashes = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.beststunt = 0;
        this.laptime = 0;
        this.fastestlap = 0;
        this.sendstat = 0;
        this.testdrive = 0;
        this.holdit = false;
        this.holdcnt = 0;
        this.winner = true;
        this.flexpix = null;
        this.smokey = new int[94132];
        this.flatrstart = 0;
        this.runtyp = 0;
        this.forstart = 0;
        this.exitm = 0;
        this.bcl = new Image[2];
        this.bcr = new Image[2];
        this.bc = new Image[2];
        this.trackbg = new Image[2];
        this.dude = new Image[3];
        this.duds = 0;
        this.dudo = 0;
        this.next = new Image[2];
        this.back = new Image[2];
        this.contin = new Image[2];
        this.ostar = new Image[2];
        this.star = new Image[3];
        this.pcontin = 0;
        this.pnext = 0;
        this.pback = 0;
        this.pstar = 0;
        this.orank = new Image[8];
        this.rank = new Image[8];
        this.ocntdn = new Image[4];
        this.cntdn = new Image[4];
        this.gocnt = 0;
        this.engs = new soundClip[5][5];
        this.pengs = new boolean[5];
        this.air = new soundClip[6];
        this.aird = false;
        this.grrd = false;
        this.crash = new soundClip[3];
        this.lowcrash = new soundClip[3];
        this.pwastd = false;
        this.skid = new soundClip[3];
        this.dustskid = new soundClip[3];
        this.scrape = new soundClip[4];
        this.mutes = false;
        this.loadedt = false;
        this.mutem = false;
        this.badmac = false;
        this.arrace = false;
        this.alocked = -1;
        this.lalocked = -1;
        this.cntflock = 0;
        this.onlock = false;
        this.ana = 0;
        this.cntan = 0;
        this.cntovn = 0;
        this.flk = false;
        this.tcnt = 30;
        this.tflk = false;
        this.say = "";
        this.wasay = false;
        this.clear = 0;
        this.posit = 0;
        this.wasted = 0;
        this.laps = 0;
        this.dested = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.dmcnt = 0;
        this.dmflk = false;
        this.pwcnt = 0;
        this.pwflk = false;
        this.adj = new String[][] { { "Cool", "Alright", "Nice" }, { "Wicked", "Amazing", "Super" }, { "Awesome", "Ripping", "Radical" }, { "What the...?", "You're a super star!!!!", "Who are you again...?" }, { "surf style", "off the lip", "bounce back" } };
        this.exlm = new String[] { "!", "!!", "!!!" };
        this.loop = "";
        this.spin = "";
        this.asay = "";
        this.auscnt = 45;
        this.aflk = false;
        this.sndsize = new int[] { 39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 80, 44, 57, 123, 202, 210, 111 };
        this.kbload = 0;
        this.dnload = 0;
        this.shload = 0.0f;
        this.radpx = 212;
        this.pin = 60;
        this.trkx = new int[] { 65, 735 };
        this.trkl = 0;
        this.trklim = (int)(Math.random() * 40.0);
        this.lmode = 0;
        this.bgmy = new int[] { 0, -400 };
        this.bgf = 0.0f;
        this.bgup = false;
        this.ovx = new int[] { 0, 0, 0, 0 };
        this.ovy = new int[] { 0, 0, 0, 0 };
        this.ovw = new int[] { 0, 0, 0, 0 };
        this.ovh = new int[] { 0, 0, 0, 0 };
        this.ovsx = new int[] { 0, 0, 0, 0 };
        this.removeds = 0;
        this.nfmtab = 0;
        this.justwon1 = false;
        this.justwon2 = false;
        this.lfrom = 0;
        this.lockcnt = 0;
        this.showtf = false;
        this.ransay = 0;
        this.cnames = new String[][] { { "", "", "", "", "", "", "Game Chat  " }, { "", "", "", "", "", "", "Your Clan's Chat  " } };
        this.sentn = new String[][] { { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" } };
        this.updatec = new int[] { -1, -1 };
        this.movepos = new int[] { 0, 0 };
        this.pointc = new int[] { 6, 6 };
        this.floater = new int[] { 0, 0 };
        this.cntchatp = new int[] { 0, 0 };
        this.msgflk = new int[] { 0, 0 };
        this.lcmsg = new String[] { "", "" };
        this.flkat = 0;
        this.movly = 0;
        this.gxdu = 0;
        this.gydu = 0;
        this.muhi = 0;
        this.lsc = -1;
        this.mouson = -1;
        this.onmsc = -1;
        this.remi = false;
        this.basefase = 0;
        this.noclass = false;
        this.gatey = 300;
        this.pgatx = new int[] { 211, 240, 280, 332, 399, 466, 517, 558, 586 };
        this.pgaty = new int[] { 193, 213, 226, 237, 244, 239, 228, 214, 196 };
        this.pgady = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.pgas = new boolean[] { false, false, false, false, false, false, false, false, false };
        this.waitlink = 0;
        this.lxm = -10;
        this.lym = -10;
        this.pwait = 7;
        this.stopcnt = 0;
        this.cntwis = 0;
        this.lcn = 0;
        this.crshturn = 0;
        this.bfcrash = 0;
        this.bfskid = 0;
        this.crashup = false;
        this.skidup = false;
        this.skflg = 0;
        this.dskflg = 0;
        this.bfscrape = 0;
        this.sturn0 = 0;
        this.sturn1 = 0;
        this.bfsc1 = 0;
        this.bfsc2 = 0;
        this.flatr = 0;
        this.flyr = 0;
        this.flyrdest = 0;
        this.flang = 0;
        this.m = m;
        this.cd = cd;
        this.app = app;
        this.rd = rd;
        this.hello = this.getImage("data/hello.gif");
        this.sign = this.getImage("data/sign.gif");
        this.loadbar = this.getImage("data/loadbar.gif");
        for (int i = 0; i < 5; ++i) {
            this.pengs[i] = false;
        }
        this.nofull = false;
        final SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkConnect("needformadness.com", -1);
            }
            catch (Exception ex) {
                if (("" + ex).indexOf("access denied") != -1) {
                    this.nofull = true;
                }
            }
        }
        this.badmac = false;
    }

    public void loaddata() {
        this.kbload = 637;
        this.runtyp = 176;
        (this.runner = new Thread(this)).start();
        this.loadimages();
        this.intertrack = new RadicalMod("music/interface.zip");
        this.dnload += 44;
        this.loadsounds();
    }

    public void loadsounds() {
        this.dnload += 3;
        try {
            final FileInputStream fileInputStream = new FileInputStream(new File("" + Madness.fpath + "data/sounds.zip"));
            final ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
                int i = (int)zipEntry.getSize();
                final String name = zipEntry.getName();
                final byte[] array = new byte[i];
                int n = 0;
                while (i > 0) {
                    final int read = zipInputStream.read(array, n, i);
                    n += read;
                    i -= read;
                }
                for (int j = 0; j < 5; ++j) {
                    for (int k = 0; k < 5; ++k) {
                        if (name.equals("" + k + "" + j + ".wav")) {
                            this.engs[k][j] = new soundClip(array);
                        }
                    }
                }
                for (int l = 0; l < 6; ++l) {
                    if (name.equals("air" + l + ".wav")) {
                        this.air[l] = new soundClip(array);
                    }
                }
                for (int n2 = 0; n2 < 3; ++n2) {
                    if (name.equals("crash" + (n2 + 1) + ".wav")) {
                        this.crash[n2] = new soundClip(array);
                    }
                }
                for (int n3 = 0; n3 < 3; ++n3) {
                    if (name.equals("lowcrash" + (n3 + 1) + ".wav")) {
                        this.lowcrash[n3] = new soundClip(array);
                    }
                }
                for (int n4 = 0; n4 < 3; ++n4) {
                    if (name.equals("skid" + (n4 + 1) + ".wav")) {
                        this.skid[n4] = new soundClip(array);
                    }
                }
                for (int n5 = 0; n5 < 3; ++n5) {
                    if (name.equals("dustskid" + (n5 + 1) + ".wav")) {
                        this.dustskid[n5] = new soundClip(array);
                    }
                }
                for (int n6 = 0; n6 < 3; ++n6) {
                    if (name.equals("scrape" + (n6 + 1) + ".wav")) {
                        this.scrape[n6] = new soundClip(array);
                        if (n6 == 2) {
                            this.scrape[3] = new soundClip(array);
                        }
                    }
                }
                if (name.equals("powerup.wav")) {
                    this.powerup = new soundClip(array);
                }
                if (name.equals("tires.wav")) {
                    this.tires = new soundClip(array);
                }
                if (name.equals("checkpoint.wav")) {
                    this.checkpoint = new soundClip(array);
                }
                if (name.equals("carfixed.wav")) {
                    this.carfixed = new soundClip(array);
                }
                if (name.equals("three.wav")) {
                    this.three = new soundClip(array);
                }
                if (name.equals("two.wav")) {
                    this.two = new soundClip(array);
                }
                if (name.equals("one.wav")) {
                    this.one = new soundClip(array);
                }
                if (name.equals("go.wav")) {
                    this.go = new soundClip(array);
                }
                if (name.equals("wasted.wav")) {
                    this.wastd = new soundClip(array);
                }
                if (name.equals("firewasted.wav")) {
                    this.firewasted = new soundClip(array);
                }
                this.dnload += 5;
            }
            fileInputStream.close();
            zipInputStream.close();
        }
        catch (Exception ex) {
            System.out.println("Error Loading Sounds: " + ex);
        }
        System.gc();
    }

    public void loadimages() {
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final MediaTracker mediaTracker = new MediaTracker(this.app);
        Image loadBimage = null;
        Image loadBimage2 = null;
        this.dnload += 8;
        try {
            final FileInputStream fileInputStream = new FileInputStream(new File("" + Madness.fpath + "data/images.zip"));
            final ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
                int i = (int)zipEntry.getSize();
                final String name = zipEntry.getName();
                final byte[] array = new byte[i];
                int n = 0;
                while (i > 0) {
                    final int read = zipInputStream.read(array, n, i);
                    n += read;
                    i -= read;
                }
                if (name.equals("cars.gif")) {
                    this.carsbg = this.loadBimage(array, mediaTracker, defaultToolkit, 1);
                }
                if (name.equals("color.gif")) {
                    loadBimage = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("class.gif")) {
                    loadBimage2 = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("smokey.gif")) {
                    this.smokeypix(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("1.gif")) {
                    this.orank[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("gameh.gif")) {
                    this.ogameh = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("wgame.gif")) {
                    this.owgame = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("gameov.gif")) {
                    this.gameov = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("lap.gif")) {
                    this.olap = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("paused.gif")) {
                    this.paused = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("select.gif")) {
                    this.select = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("yourwasted.gif")) {
                    this.oyourwasted = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("disco.gif")) {
                    this.odisco = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("youwastedem.gif")) {
                    this.oyouwastedem = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("gamefinished.gif")) {
                    this.ogamefinished = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("exitgame.gif")) {
                    this.oexitgame = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("pgate.gif")) {
                    this.pgate = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("d1.png")) {
                    this.dude[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("d2.png")) {
                    this.dude[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("d3.png")) {
                    this.dude[2] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("float.gif")) {
                    this.oflaot = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("1c.gif")) {
                    this.ocntdn[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("2c.gif")) {
                    this.ocntdn[2] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("3c.gif")) {
                    this.ocntdn[3] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("2.gif")) {
                    this.orank[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("3.gif")) {
                    this.orank[2] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("4.gif")) {
                    this.orank[3] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("5.gif")) {
                    this.orank[4] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("6.gif")) {
                    this.orank[5] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("7.gif")) {
                    this.orank[6] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("8.gif")) {
                    this.orank[7] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("bgmain.jpg")) {
                    this.bgmain = this.loadBimage(array, mediaTracker, defaultToolkit, 2);
                }
                if (name.equals("br.png")) {
                    this.br = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("loadingmusic.gif")) {
                    this.oloadingmusic = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("radicalplay.gif")) {
                    this.radicalplay = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("back.gif")) {
                    this.back[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                    this.back[1] = this.bressed(this.back[0]);
                }
                if (name.equals("continue.gif")) {
                    this.contin[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                    this.contin[1] = this.bressed(this.contin[0]);
                }
                if (name.equals("next.gif")) {
                    this.next[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                    this.next[1] = this.bressed(this.next[0]);
                }
                if (name.equals("rpro.gif")) {
                    this.rpro = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("selectcar.gif")) {
                    this.selectcar = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("track.jpg")) {
                    this.trackbg[0] = this.loadBimage(array, mediaTracker, defaultToolkit, 3);
                    this.trackbg[1] = this.dodgen(this.trackbg[0]);
                }
                if (name.equals("youlost.gif")) {
                    this.oyoulost = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("youwon.gif")) {
                    this.oyouwon = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("0c.gif")) {
                    this.ocntdn[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("damage.gif")) {
                    this.odmg = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("power.gif")) {
                    this.opwr = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("position.gif")) {
                    this.opos = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("speed.gif")) {
                    this.osped = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("wasted.gif")) {
                    this.owas = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("start1.gif")) {
                    this.ostar[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("start2.gif")) {
                    this.ostar[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                    this.star[2] = this.pressed(this.ostar[1]);
                }
                if (name.equals("congrad.gif")) {
                    this.congrd = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("statb.gif")) {
                    this.statb = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("statbo.gif")) {
                    this.statbo = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("madness.gif")) {
                    this.mdness = this.loadude(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("fixhoop.png")) {
                    this.fixhoop = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("arrow.gif")) {
                    this.sarrow = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("stunts.png")) {
                    this.stunts = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("racing.gif")) {
                    this.racing = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("wasting.gif")) {
                    this.wasting = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("plus.gif")) {
                    this.plus = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("space.gif")) {
                    this.space = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("arrows.gif")) {
                    this.arrows = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("chil.gif")) {
                    this.chil = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("ory.gif")) {
                    this.ory = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("kz.gif")) {
                    this.kz = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("kx.gif")) {
                    this.kx = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("kv.gif")) {
                    this.kv = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("km.gif")) {
                    this.km = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("kn.gif")) {
                    this.kn = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("ks.gif")) {
                    this.ks = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("kenter.gif")) {
                    this.kenter = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("nfm.gif")) {
                    this.nfm = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("options.png")) {
                    this.opti = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("options2.png")) {
                    this.opti2 = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("opback.png")) {
                    this.opback = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("logocars.png")) {
                    this.logocars = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("logomad.png")) {
                    this.logomadnes = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("logomadbg.jpg")) {
                    this.logomadbg = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("byrd.png")) {
                    this.byrd = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("bggo.jpg")) {
                    this.bggo = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("nfmcoms.png")) {
                    this.nfmcoms = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("nfmcom.gif")) {
                    this.nfmcom = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("brit.gif")) {
                    this.brt = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("arn.gif")) {
                    this.arn = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("mload.gif")) {
                    this.mload = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("login.gif")) {
                    this.login = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("play.gif")) {
                    this.play = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("cancel.gif")) {
                    this.cancel = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("dome.gif")) {
                    this.dome = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("register.gif")) {
                    this.register = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("upgrade.gif")) {
                    this.upgrade = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("sdets.gif")) {
                    this.sdets = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bob.gif")) {
                    this.bob = this.loadBimage(array, mediaTracker, defaultToolkit, 1);
                }
                if (name.equals("bot.gif")) {
                    this.bot = this.loadBimage(array, mediaTracker, defaultToolkit, 1);
                }
                if (name.equals("bol.gif")) {
                    this.bol = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bolp.gif")) {
                    this.bolp = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bor.gif")) {
                    this.bor = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("borp.gif")) {
                    this.borp = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("logout.gif")) {
                    this.logout = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("change.gif")) {
                    this.change = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("pln.gif")) {
                    this.pln = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("pon.gif")) {
                    this.pon = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bols.gif")) {
                    this.bols = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bolps.gif")) {
                    this.bolps = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bors.gif")) {
                    this.bors = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("borps.gif")) {
                    this.borps = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("games.gif")) {
                    this.games = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("exit.gif")) {
                    this.exit = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("chat.gif")) {
                    this.chat = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("players.gif")) {
                    this.players = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("roomp.gif")) {
                    this.roomp = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("myfr.gif")) {
                    this.myfr = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("mycl.gif")) {
                    this.mycl = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("cnmc.gif")) {
                    this.cnmc = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("ready.gif")) {
                    this.redy = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("notreg.gif")) {
                    this.ntrg = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("cgame.gif")) {
                    this.cgame = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("ccar.gif")) {
                    this.ccar = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("lanm.gif")) {
                    this.lanm = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("asu.gif")) {
                    this.asu = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("asd.gif")) {
                    this.asd = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("pls.gif")) {
                    this.pls = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("sts.gif")) {
                    this.sts = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("gmc.gif")) {
                    this.gmc = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("stg.gif")) {
                    this.stg = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("crd.gif")) {
                    this.crd = this.loadBimage(array, mediaTracker, defaultToolkit, 0);
                }
                if (name.equals("bcl.gif")) {
                    this.bcl[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("bcr.gif")) {
                    this.bcr[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("bc.gif")) {
                    this.bc[0] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("pbcl.gif")) {
                    this.bcl[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("pbcr.gif")) {
                    this.bcr[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("pbc.gif")) {
                    this.bc[1] = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("cmc.gif")) {
                    this.cmc = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("myc.gif")) {
                    this.myc = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("gac.gif")) {
                    this.gac = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("yac.gif")) {
                    this.yac = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("ycmc.gif")) {
                    this.ycmc = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                if (name.equals("top20s.gif")) {
                    this.top20s = this.loadimage(array, mediaTracker, defaultToolkit);
                }
                this.dnload += 2;
            }
            fileInputStream.close();
            zipInputStream.close();
        }
        catch (Exception ex) {
            System.out.println("Error Loading Images: " + ex);
        }
        this.makecarsbgc(loadBimage, loadBimage2);
        System.gc();
    }

    @Override
    public void run() {
        boolean b = false;
        while (this.runtyp > 0) {
            if (this.runtyp >= 1 && this.runtyp <= 140) {
                this.hipnoload(this.runtyp, false);
            }
            if (this.runtyp == 176) {
                this.loading();
                b = true;
            }
            this.app.repaint();
            try {
                final Thread runner = this.runner;
                Thread.sleep(20L);
            }
            catch (InterruptedException ex) {}
        }
        if (b) {
            this.pingstat();
        }
        final boolean[] array = { true, true };
        while ((this.runtyp == -101 || this.sendstat == 1) && !this.lan) {
            final String string = "3|" + this.playingame + "|" + this.updatec[0] + "|";
            String s;
            if (this.clanchat) {
                s = string + "" + this.updatec[1] + "|" + this.clan + "|" + this.clankey + "|";
            }
            else {
                s = string + "0|||";
            }
            if (this.updatec[0] <= -11) {
                for (int i = 0; i < -this.updatec[0] - 10; ++i) {
                    s = s + "" + this.cnames[0][6 - i] + "|" + this.sentn[0][6 - i] + "|";
                }
                this.updatec[0] = -2;
            }
            if (this.clanchat && this.updatec[1] <= -11) {
                for (int j = 0; j < -this.updatec[1] - 10; ++j) {
                    s = s + "" + this.cnames[1][6 - j] + "|" + this.sentn[1][6 - j] + "|";
                }
                this.updatec[1] = -2;
            }
            if (this.sendstat == 1) {
                s = "5|" + this.playingame + "|" + this.im + "|" + this.beststunt + "|" + this.fastestlap + "|";
                for (int k = 0; k < this.nplayers; ++k) {
                    s = s + "" + this.dcrashes[k] + "|";
                }
                this.sendstat = 2;
            }
            int n = 0;
            String s2 = "";
            try {
                this.dout.println(s);
                s2 = this.din.readLine();
                if (s2 == null) {
                    n = 1;
                }
            }
            catch (Exception ex2) {
                n = 1;
            }
            if (n != 0) {
                try {
                    this.socket.close();
                    this.socket = null;
                    this.din.close();
                    this.din = null;
                    this.dout.close();
                    this.dout = null;
                }
                catch (Exception ex3) {}
                try {
                    this.socket = new Socket(this.server, this.servport);
                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println(s);
                    s2 = this.din.readLine();
                    if (s2 != null) {
                        n = 0;
                    }
                }
                catch (Exception ex4) {}
            }
            if (n != 0) {
                try {
                    this.socket.close();
                    this.socket = null;
                }
                catch (Exception ex5) {}
                this.runtyp = 0;
                if (this.app.cmsg.isShowing()) {
                    this.app.cmsg.setVisible(true);
                    this.app.requestFocus();
                }
                this.runner.stop();
                /*try {
                  //this.runner = null; // NOTE: added this, might be broken
                } catch (InterruptedException ex) {
                  // NOTE: caught here
                }*/
            }
            if (this.sendstat != 2) {
                int n2 = 2;
                int n3 = 1;
                if (this.clanchat) {
                    n3 = 2;
                }
                for (int l = 0; l < n3; ++l) {
                    final int getvalue = this.getvalue(s2, l);
                    if (this.updatec[l] != getvalue && this.updatec[l] >= -2 && this.pointc[l] == 6) {
                        for (int n4 = 0; n4 < 7; ++n4) {
                            this.cnames[l][n4] = this.getSvalue(s2, n2);
                            ++n2;
                            this.sentn[l][n4] = this.getSvalue(s2, n2);
                            ++n2;
                        }
                        if (this.cnames[l][6].equals("")) {
                            if (l == 0) {
                                this.cnames[l][6] = "Game Chat  ";
                            }
                            else {
                                this.cnames[l][6] = "" + this.clan + "'s Chat  ";
                            }
                        }
                        if (this.updatec[l] != -2) {
                            this.floater[l] = 1;
                            if (array[l]) {
                                this.msgflk[l] = 67;
                                array[l] = false;
                            }
                            else {
                                this.msgflk[l] = 110;
                            }
                        }
                        this.updatec[l] = getvalue;
                    }
                }
            }
            else {
                this.sendstat = 3;
            }
            try {
                final Thread runner2 = this.runner;
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex6) {}
        }
        Label_1376: {
            if (this.runtyp != -167) {
                if (this.runtyp != -168) {
                    break Label_1376;
                }
            }
            try {
                this.socket = new Socket("multiplayer.needformadness.com", 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("101|" + (this.runtyp + 174) + "|" + this.app.tnick.getText() + "|" + this.app.tpass.getText() + "|");
                this.din.readLine();
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            }
            catch (Exception ex7) {}
            this.runtyp = 0;
        }
        if (this.runtyp == -166 || this.runtyp == -167 || this.runtyp == -168) {
            this.pingstat();
        }
    }

    public void stopchat() {
        this.clanchat = false;
        this.clangame = 0;
        if (this.runtyp == -101) {
            this.runtyp = 0;
            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            }
            catch (Exception ex) {}
        }
    }

    public void sendwin(final CheckPoints checkPoints) {
        if (this.logged && this.multion == 1 && this.winner) {
            if (checkPoints.wasted == this.nplayers - 1) {
                this.runtyp = -167;
            }
            else {
                this.runtyp = -168;
            }
        }
        else {
            this.runtyp = -166;
        }
        (this.runner = new Thread(this)).start();
    }

    public void loading() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.drawImage(this.sign, 362, 35, this);
        this.rd.drawImage(this.hello, 125, 105, this);
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.drawImage(this.loadbar, 281, 365, this);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(358, "Loading game, please wait.", 0, 0, 0, 3);
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(295, 398, 210, 17);
        this.shload += (this.dnload + 10.0f - this.shload) / 100.0f;
        if (this.shload > this.kbload) {
            this.shload = this.kbload;
        }
        if (this.dnload == this.kbload) {
            this.shload = this.kbload;
        }
        this.drawcs(410, "" + (int)((26.0f + this.shload / this.kbload * 200.0f) / 226.0f * 100.0f) + " % loaded    |    " + (this.kbload - (int)this.shload) + " KB remaining", 32, 64, 128, 3);
        this.rd.setColor(new Color(32, 64, 128));
        this.rd.fillRect(287, 371, 26 + (int)(this.shload / this.kbload * 200.0f), 10);
    }

    public void stoploading() {
        this.loading();
        this.app.repaint();
        this.runtyp = 0;
    }

    public void clicknow() {
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        if (this.aflk) {
            this.drawcs(380, "Click here to Start", 0, 0, 0, 3);
            this.aflk = false;
        }
        else {
            this.drawcs(380, "Click here to Start", 0, 67, 200, 3);
            this.aflk = true;
        }
    }

    public void stopallnow() {
        if (this.runner != null) {
          this.runner.stop();
          this.runner = null;
          /*try {
            this.runner.join(0);
            this.runner = null;
          } catch (InterruptedException ex) {
            // NOTE: caught here
          }*/
        }
        this.runtyp = 0;
        if (this.loadedt) {
            this.strack.unload();
            this.strack = null;
            this.loadedt = false;
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                this.engs[i][j].stop_clip();
                this.engs[i][j] = null;
            }
        }
        for (int k = 0; k < 6; ++k) {
            this.air[k].stop_clip();
            this.air[k] = null;
        }
        this.wastd.stop_clip();
        this.intertrack.unload();
        this.intertrack = null;
    }

    public void resetstat(final int n) {
        this.arrace = false;
        this.alocked = -1;
        this.lalocked = -1;
        this.cntflock = 90;
        this.onlock = false;
        this.ana = 0;
        this.cntan = 0;
        this.cntovn = 0;
        this.tcnt = 30;
        this.wasay = false;
        this.clear = 0;
        this.dmcnt = 0;
        this.pwcnt = 0;
        this.auscnt = 45;
        this.pnext = 0;
        this.pback = 0;
        this.starcnt = 130;
        this.gocnt = 3;
        this.grrd = true;
        this.aird = true;
        this.bfcrash = 0;
        this.bfscrape = 0;
        this.cntwis = 0;
        this.bfskid = 0;
        this.pwait = 7;
        this.forstart = 200;
        this.exitm = 0;
        this.holdcnt = 0;
        this.holdit = false;
        this.winner = false;
        this.wasted = 0;
        for (int i = 0; i < 8; ++i) {
            this.dested[i] = 0;
            this.isbot[i] = false;
            this.dcrashes[i] = 0;
        }
        this.runtyp = 0;
        this.discon = 0;
        this.dnload = 0;
        this.beststunt = 0;
        this.laptime = 0;
        this.fastestlap = 0;
        this.sendstat = 0;
        if (this.fase == 2 || this.fase == -22) {
            this.sortcars(n);
        }
        if (this.fase == 22) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 7; ++k) {
                    this.cnames[j][k] = "";
                    this.sentn[j][k] = "";
                }
                if (j == 0) {
                    this.cnames[j][6] = "Game Chat  ";
                }
                else {
                    this.cnames[j][6] = "" + this.clan + "'s Chat  ";
                }
                this.updatec[j] = -1;
                this.movepos[j] = 0;
                this.pointc[j] = 6;
                this.floater[j] = 0;
                this.cntchatp[j] = 0;
                this.msgflk[j] = 0;
                this.lcmsg[j] = "";
            }
            if (this.multion == 3) {
                this.ransay = 4;
            }
            else if (this.ransay == 0) {
                this.ransay = 1 + (int)(Math.random() * 3.0);
            }
            else {
                ++this.ransay;
                if (this.ransay > 3) {
                    this.ransay = 1;
                }
            }
        }
    }

    public void setbots(final boolean[] array, final int[][] array2) {
        for (int i = 0; i < this.nplayers; ++i) {
            if (this.plnames[i].indexOf("MadBot") != -1) {
                array[i] = true;
                this.isbot[i] = true;
            }
        }
    }

    public void rad(final int n) {
        if (n == 0) {
            this.powerup.play();
            this.radpx = 212;
            this.pin = 0;
        }
        this.trackbg(false);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 135, 670, 59);
        if (this.pin != 0) {
            this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 135, null);
        }
        else {
            this.rd.drawImage(this.radicalplay, 212, 135, null);
        }
        if (this.radpx != 212) {
            this.radpx += 40;
            if (this.radpx > 735) {
                this.radpx = -388;
            }
        }
        else if (this.pin != 0) {
            --this.pin;
        }
        if (n == 40) {
            this.radpx = 213;
            this.pin = 7;
        }
        if (this.radpx == 212) {
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(185 + (int)(5.0f * this.m.random()), "Radicalplay.com", 112, 120, 143, 3);
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            this.drawcs(215, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            this.aflk = false;
        }
        else {
            this.drawcs(217, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.rpro, 275, 265, null);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void credits(final Control control, final int n, final int n2, final int n3) {
        if (this.flipo == 0) {
            this.powerup.play();
            this.flipo = 1;
        }
        if (this.flipo >= 1 && this.flipo <= 100) {
            this.rad(this.flipo);
            ++this.flipo;
            if (this.flipo == 100) {
                this.flipo = 1;
            }
        }
        if (this.flipo == 101) {
            this.mainbg(-1);
            this.rd.drawImage(this.mdness, 283, 32, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
            this.drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            this.drawcs(185, "By Omar Waly", 40, 60, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(225, "Special Thanks!", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(245, "Thanks to Dany Fernandez Diaz (DragShot) for imporving the game\u2019s music player to play more mod formats & effects!", 66, 98, 0, 3);
            this.drawcs(260, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
            this.drawcs(275, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
            this.drawcs(290, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
            this.drawcs(305, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
            this.drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
            this.drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
            this.rd.drawLine(400 - this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396, this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
            if (n > 258 && n < 542 && n2 > 385 && n2 < 399) {
                this.app.setCursor(new Cursor(12));
                if (n3 == 2) {
                    this.app.musiclink();
                }
            }
            else {
                this.app.setCursor(new Cursor(0));
            }
        }
        if (this.flipo == 102) {
            this.mainbg(0);
            this.rd.drawImage(this.nfmcom, 190, 195, null);
            if (n > 190 && n < 609 && n2 > 195 && n2 < 216) {
                this.app.setCursor(new Cursor(12));
                if (n3 == 2) {
                    this.app.madlink();
                }
            }
            else {
                this.app.setCursor(new Cursor(0));
            }
        }
        this.rd.drawImage(this.next[this.pnext], 665, 395, null);
        if (control.enter || control.handb || control.right) {
            if (this.flipo >= 1 && this.flipo <= 100) {
                this.flipo = 101;
                this.app.setCursor(new Cursor(0));
            }
            else {
                ++this.flipo;
            }
            if (this.flipo == 103) {
                this.flipo = 0;
                this.fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
    }

    public void trackbg(final boolean b) {
        int n = 0;
        ++this.trkl;
        if (this.trkl > this.trklim) {
            n = 1;
            this.trklim = (int)(Math.random() * 40.0);
            this.trkl = 0;
        }
        if (b) {
            n = 0;
        }
        for (int i = 0; i < 2; ++i) {
            this.rd.drawImage(this.trackbg[n], this.trkx[i], 25, null);
            final int[] trkx = this.trkx;
            final int n2 = i;
            trkx[n2] -= 10;
            if (this.trkx[i] <= -605) {
                this.trkx[i] = 735;
            }
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void mainbg(final int n) {
        int n2 = 2;
        this.rd.setColor(new Color(191, 184, 124));
        if (n == -1) {
            if (n != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.bgup = false;
                this.bgf = 0.0f;
                this.lmode = n;
            }
            this.rd.setColor(new Color(144, 222, 9));
            n2 = 8;
        }
        if (n == 0) {
            if (n != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.bgup = false;
                this.bgf = 0.0f;
                this.lmode = n;
            }
            final int n3 = (int)(255.0f * this.bgf + 191.0f * (1.0f - this.bgf));
            final int n4 = (int)(176.0f * this.bgf + 184.0f * (1.0f - this.bgf));
            final int n5 = (int)(67.0f * this.bgf + 124.0f * (1.0f - this.bgf));
            if (!this.bgup) {
                this.bgf += 0.02f;
                if (this.bgf > 0.9f) {
                    this.bgf = 0.9f;
                    this.bgup = true;
                }
            }
            else {
                this.bgf -= 0.02f;
                if (this.bgf < 0.2f) {
                    this.bgf = 0.2f;
                    this.bgup = false;
                }
            }
            this.rd.setColor(new Color(n3, n4, n5));
            n2 = 4;
        }
        if (n == 1) {
            if (n != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.lmode = n;
            }
            this.rd.setColor(new Color(255, 176, 67));
            n2 = 8;
        }
        if (n == 2) {
            if (n != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.lmode = n;
                this.bgf = 0.2f;
            }
            this.rd.setColor(new Color(188, 170, 122));
            if (this.flipo == 16) {
                this.rd.setColor(new Color((int)(176.0f * this.bgf + 191.0f * (1.0f - this.bgf)), (int)(202.0f * this.bgf + 184.0f * (1.0f - this.bgf)), (int)(255.0f * this.bgf + 124.0f * (1.0f - this.bgf))));
                this.bgf += 0.025f;
                if (this.bgf > 0.85f) {
                    this.bgf = 0.85f;
                }
            }
            else {
                this.bgf = 0.2f;
            }
            n2 = 2;
        }
        if (n == 3) {
            if (n != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.bgup = false;
                this.bgf = 0.0f;
                this.lmode = n;
            }
            final int n6 = (int)(255.0f * this.bgf + 191.0f * (1.0f - this.bgf));
            final int n7 = (int)(176.0f * this.bgf + 184.0f * (1.0f - this.bgf));
            final int n8 = (int)(67.0f * this.bgf + 124.0f * (1.0f - this.bgf));
            if (!this.bgup) {
                this.bgf += 0.02f;
                if (this.bgf > 0.9f) {
                    this.bgf = 0.9f;
                    this.bgup = true;
                }
            }
            else {
                this.bgf -= 0.02f;
                if (this.bgf < 0.2f) {
                    this.bgf = 0.2f;
                    this.bgup = false;
                }
            }
            this.rd.setColor(new Color(n6, n7, n8));
            n2 = 2;
        }
        if (n != -101) {
            if (n == 4) {
                this.rd.setColor(new Color(216, 177, 100));
                this.rd.fillRect(65, 0, 670, 425);
            }
            else {
                this.rd.fillRect(65, 25, 670, 400);
            }
        }
        if (n == 4) {
            if (n != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                for (int i = 0; i < 4; ++i) {
                    this.ovw[i] = (int)(50.0 + 150.0 * Math.random());
                    this.ovh[i] = (int)(50.0 + 150.0 * Math.random());
                    this.ovy[i] = (int)(400.0 * Math.random());
                    this.ovx[i] = (int)(Math.random() * 670.0);
                    this.ovsx[i] = (int)(5.0 + Math.random() * 10.0);
                }
                this.lmode = n;
            }
            for (int j = 0; j < 4; ++j) {
                this.rd.setColor(new Color(235, 176, 84));
                this.rd.fillOval((int)(65 + this.ovx[j] - this.ovw[j] * 1.5 / 2.0), (int)(25 + this.ovy[j] - this.ovh[j] * 1.5 / 2.0), (int)(this.ovw[j] * 1.5), (int)(this.ovh[j] * 1.5));
                this.rd.setColor(new Color(255, 176, 67));
                this.rd.fillOval(65 + this.ovx[j] - this.ovh[j] / 2, 25 + this.ovy[j] - this.ovh[j] / 2, this.ovw[j], this.ovh[j]);
                final int[] ovx = this.ovx;
                final int n9 = j;
                ovx[n9] -= this.ovsx[j];
                if (this.ovx[j] + this.ovw[j] * 1.5 / 2.0 < 0.0) {
                    this.ovw[j] = (int)(50.0 + 150.0 * Math.random());
                    this.ovh[j] = (int)(50.0 + 150.0 * Math.random());
                    this.ovy[j] = (int)(400.0 * Math.random());
                    this.ovx[j] = (int)(670.0 + this.ovw[j] * 1.5 / 2.0);
                    this.ovsx[j] = (int)(5.0 + Math.random() * 10.0);
                }
            }
        }
        if (n != -101 && n != 4) {
            for (int k = 0; k < 2; ++k) {
                if (n != 2 || this.flipo != 16) {
                    this.rd.drawImage(this.bgmain, 65, 25 + this.bgmy[k], null);
                }
                final int[] bgmy = this.bgmy;
                final int n10 = k;
                bgmy[n10] += n2;
                if (this.bgmy[k] >= 400) {
                    this.bgmy[k] = -400;
                }
            }
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        if (n != 4) {
            this.rd.fillRect(65, 0, 670, 25);
        }
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void inishstageselect(final CheckPoints checkPoints) {
        if (checkPoints.stage == -2 && (this.cd.msloaded != 1 || !this.logged)) {
            checkPoints.stage = (int)(Math.random() * 27.0) + 1;
            checkPoints.top20 = 0;
        }
        if (checkPoints.stage > 27) {
            checkPoints.stage = (int)(Math.random() * 27.0) + 1;
        }
        if (checkPoints.stage == -2) {
            boolean b = false;
            for (int i = 1; i < this.app.mstgs.getItemCount(); ++i) {
                if (this.app.mstgs.getItem(i).equals(checkPoints.name)) {
                    b = true;
                }
            }
            if (!b) {
                checkPoints.stage = (int)(Math.random() * 27.0) + 1;
            }
        }
        if (this.gmode == 1) {
            if (this.unlocked[0] != 11 || this.justwon1) {
                checkPoints.stage = this.unlocked[0];
            }
            else if (this.winner || checkPoints.stage > 11) {
                checkPoints.stage = (int)(Math.random() * 11.0) + 1;
            }
            if (checkPoints.stage == 11) {
                checkPoints.stage = 27;
            }
        }
        if (this.gmode == 2) {
            if (this.unlocked[0] != 17 || this.justwon2) {
                checkPoints.stage = this.unlocked[1] + 10;
            }
            else if (this.winner || checkPoints.stage < 11) {
                checkPoints.stage = (int)(Math.random() * 17.0) + 11;
            }
        }
        this.app.sgame.setBackground(new Color(0, 0, 0));
        this.app.sgame.setForeground(new Color(47, 179, 255));
        this.app.snfm1.setBackground(new Color(0, 0, 0));
        this.app.snfm1.setForeground(new Color(47, 179, 255));
        this.app.snfm2.setBackground(new Color(0, 0, 0));
        this.app.snfm2.setForeground(new Color(47, 179, 255));
        this.app.mstgs.setBackground(new Color(0, 0, 0));
        this.app.mstgs.setForeground(new Color(47, 179, 255));
        this.app.gmode.setBackground(new Color(49, 49, 0));
        this.app.gmode.setForeground(new Color(148, 167, 0));
        this.app.sgame.removeAll();
        this.app.sgame.add(this.rd, " NFM 1     ");
        this.app.sgame.add(this.rd, " NFM 2     ");
        this.app.sgame.add(this.rd, " My Stages ");
        this.app.sgame.add(this.rd, " Weekly Top20 ");
        this.app.sgame.add(this.rd, " Monthly Top20 ");
        this.app.sgame.add(this.rd, " Stage Maker ");
        if (checkPoints.stage > 0 && checkPoints.stage <= 10) {
            this.app.sgame.select(0);
            this.nfmtab = 0;
        }
        if (checkPoints.stage > 10) {
            this.app.sgame.select(1);
            this.nfmtab = 1;
        }
        if (checkPoints.stage == -2) {
            this.app.sgame.select(2);
            this.nfmtab = 2;
        }
        if (checkPoints.stage == -1) {
            this.app.sgame.select(5);
            this.nfmtab = 5;
        }
        this.removeds = 0;
        this.lfrom = 0;
        this.cd.staction = 0;
        this.fase = 2;
    }

    public void loadingstage(final int n, final boolean b) {
        this.trackbg(true);
        this.rd.drawImage(this.br, 65, 25, null);
        this.rd.setColor(new Color(212, 214, 138));
        this.rd.fillRoundRect(265, 201, 270, 26, 20, 40);
        this.rd.setColor(new Color(57, 64, 8));
        this.rd.drawRoundRect(265, 201, 270, 26, 20, 40);
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(219, "Loading, please wait...", 58, 61, 17, 3);
        if (b) {
            this.rd.drawImage(this.select, 338, 35, null);
        }
        this.app.repaint();
        if (this.cd.staction != 0) {
            this.app.tnick.setVisible(false);
            this.app.tpass.setVisible(false);
            this.cd.staction = 0;
        }
        this.removeds = 0;
    }

    public void cantgo(final Control control) {
        this.pnext = 0;
        this.trackbg(false);
        this.rd.drawImage(this.br, 65, 25, null);
        this.rd.drawImage(this.select, 338, 35, null);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(130, "This stage will be unlocked when stage " + this.unlocked[this.gmode - 1] + " is complete!", 177, 177, 177, 3);
        for (int i = 0; i < 9; ++i) {
            this.rd.drawImage(this.pgate, 277 + i * 30, 215, null);
        }
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            this.drawcs(185, "[ Stage " + (this.unlocked[this.gmode - 1] + 1) + " Locked ]", 255, 128, 0, 3);
            this.aflk = false;
        }
        else {
            this.drawcs(185, "[ Stage " + (this.unlocked[this.gmode - 1] + 1) + " Locked ]", 255, 0, 0, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.back[this.pback], 370, 345, null);
        --this.lockcnt;
        if (this.lockcnt == 0 || control.enter || control.handb || control.left) {
            control.left = false;
            control.handb = false;
            control.enter = false;
            this.fase = 1;
        }
    }

    public void stageselect(final CheckPoints checkPoints, final Control control, final int n, final int n2, final boolean b) {
        this.rd.drawImage(this.br, 65, 25, null);
        this.rd.drawImage(this.select, 338, 35, null);
        if (this.testdrive != 3 && this.testdrive != 4) {
            if (checkPoints.stage > 0 && this.cd.staction == 0) {
                if (checkPoints.stage != 1 && (checkPoints.stage != 11 || this.gmode != 2)) {
                    this.rd.drawImage(this.back[this.pback], 115, 135, null);
                }
                if (checkPoints.stage != 27) {
                    this.rd.drawImage(this.next[this.pnext], 625, 135, null);
                }
            }
            if (this.gmode == 0) {
                boolean b2 = false;
                int n3 = 0;
                if (this.nfmtab != this.app.sgame.getSelectedIndex()) {
                    this.nfmtab = this.app.sgame.getSelectedIndex();
                    this.app.snfm1.select(0);
                    this.app.snfm2.select(0);
                    this.app.mstgs.select(0);
                    this.app.requestFocus();
                    b2 = true;
                }
                if (this.cd.staction == 5) {
                    if (this.lfrom == 0) {
                        this.cd.staction = 0;
                        this.removeds = 1;
                        b2 = true;
                    }
                    else {
                        this.cd.onstage = checkPoints.name;
                        this.cd.staction = 2;
                        this.dnload = 2;
                    }
                    this.nickname = this.app.tnick.getText();
                    this.backlog = this.nickname;
                    this.nickey = this.cd.tnickey;
                    this.clan = this.cd.tclan;
                    this.clankey = this.cd.tclankey;
                    this.app.setloggedcookie();
                    this.logged = true;
                    this.gotlog = true;
                    if (this.cd.reco == 0) {
                        this.acexp = 0;
                    }
                    if (this.cd.reco > 10) {
                        this.acexp = this.cd.reco - 10;
                    }
                    if (this.cd.reco == 3) {
                        this.acexp = -1;
                    }
                    if (this.cd.reco == 111) {
                        if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) {
                            this.acexp = -3;
                        }
                        else {
                            this.acexp = 0;
                        }
                    }
                }
                if (this.nfmtab == 2 && this.cd.staction == 0 && this.removeds == 1) {
                    checkPoints.stage = -3;
                }
                if (this.app.openm && this.cd.staction == 3) {
                    this.app.tnick.setVisible(false);
                    this.app.tpass.setVisible(false);
                    this.cd.staction = 0;
                }
                int n4 = 0;
                this.app.sgame.setSize(131, 22);
                if (this.app.sgame.getSelectedIndex() == 0) {
                    n4 = 400 - (this.app.sgame.getWidth() + 6 + this.app.snfm1.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 1) {
                    n4 = 400 - (this.app.sgame.getWidth() + 6 + this.app.snfm2.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 2) {
                    this.app.mstgs.setSize(338, 22);
                    if (b2) {
                        if (this.logged) {
                            if (this.cd.msloaded != 1) {
                                this.app.mstgs.removeAll();
                                this.app.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                this.app.mstgs.select(0);
                                n3 = 1;
                            }
                        }
                        else {
                            this.app.mstgs.removeAll();
                            this.app.mstgs.add(this.rd, "Please login first to load your stages...");
                            this.app.mstgs.select(0);
                            this.cd.msloaded = 0;
                            this.lfrom = 0;
                            this.cd.staction = 3;
                            this.showtf = false;
                            this.tcnt = 0;
                            this.cntflock = 0;
                            this.cd.reco = -2;
                        }
                    }
                    n4 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 3) {
                    this.app.mstgs.setSize(338, 22);
                    if (b2 && this.cd.msloaded != 3) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        this.app.mstgs.select(0);
                        n3 = 3;
                    }
                    n4 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 4) {
                    this.app.mstgs.setSize(338, 22);
                    if (b2 && this.cd.msloaded != 4) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        this.app.mstgs.select(0);
                        n3 = 4;
                    }
                    n4 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 5) {
                    if (this.cd.staction != 0) {
                        this.app.tnick.setVisible(false);
                        this.app.tpass.setVisible(false);
                        this.cd.staction = 0;
                    }
                    this.app.mstgs.setSize(338, 22);
                    if (b2 && this.cd.msloaded != 2) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading Stage Maker stages, please wait...");
                        this.app.mstgs.select(0);
                        n3 = 2;
                    }
                    n4 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (!this.app.sgame.isShowing()) {
                    this.app.sgame.show();
                }
                this.app.sgame.move(n4, 62);
                final int n5 = n4 + (this.app.sgame.getWidth() + 6);
                if (this.nfmtab == 0) {
                    if (!this.app.snfm1.isShowing()) {
                        this.app.snfm1.show();
                        if (!b2 && checkPoints.stage > 0) {
                            this.app.snfm1.select(checkPoints.stage);
                        }
                    }
                    this.app.snfm1.move(n5, 62);
                    if (this.app.snfm2.isShowing()) {
                        this.app.snfm2.hide();
                    }
                    if (this.app.mstgs.isShowing()) {
                        this.app.mstgs.hide();
                    }
                }
                if (this.nfmtab == 1) {
                    if (!this.app.snfm2.isShowing()) {
                        this.app.snfm2.show();
                        if (!b2 && checkPoints.stage > 10) {
                            this.app.snfm2.select(checkPoints.stage - 10);
                        }
                    }
                    this.app.snfm2.move(n5, 62);
                    if (this.app.snfm1.isShowing()) {
                        this.app.snfm1.hide();
                    }
                    if (this.app.mstgs.isShowing()) {
                        this.app.mstgs.hide();
                    }
                }
                if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5) {
                    if (!this.app.mstgs.isShowing()) {
                        this.app.mstgs.show();
                        if (!b2) {
                            this.app.mstgs.select(checkPoints.name);
                        }
                    }
                    this.app.mstgs.move(n5, 62);
                    if (this.app.snfm1.isShowing()) {
                        this.app.snfm1.hide();
                    }
                    if (this.app.snfm2.isShowing()) {
                        this.app.snfm2.hide();
                    }
                }
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.cd.staction == 0 || this.cd.staction == 6) {
                    if (checkPoints.stage != -3) {
                        String string = "";
                        if (checkPoints.top20 >= 3) {
                            string = "N#" + checkPoints.nto + "  ";
                        }
                        if (this.aflk) {
                            this.drawcs(132, string + checkPoints.name, 240, 240, 240, 3);
                            this.aflk = false;
                        }
                        else {
                            this.drawcs(132, string + checkPoints.name, 176, 176, 176, 3);
                            this.aflk = true;
                        }
                        if (checkPoints.stage == -2 && this.cd.staction == 0) {
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(255, 176, 85));
                            if (checkPoints.maker.equals(this.nickname)) {
                                this.rd.drawString("Created by You", 70, 115);
                            }
                            else {
                                this.rd.drawString("Created by :  " + checkPoints.maker + "", 70, 115);
                            }
                            if (checkPoints.top20 >= 3) {
                                this.rd.drawString("Added by :  " + this.cd.top20adds[checkPoints.nto - 1] + " Players", 70, 135);
                            }
                        }
                    }
                    else if (this.removeds != 1) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.nfmtab == 5) {
                            this.drawcs(155, "Please Test Drive this stage in the Stage Maker to make sure it can be loaded!", 255, 138, 0, 3);
                        }
                        if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4) {
                            this.drawcs(155, "It could be a connection error, please try again later.", 255, 138, 0, 3);
                        }
                        if (this.nfmtab == 1 || this.nfmtab == 0) {
                            this.drawcs(155, "Will try to load another stage...", 255, 138, 0, 3);
                            this.app.repaint();
                            try {
                                Thread.sleep(5000L);
                            }
                            catch (InterruptedException ex) {}
                            if (this.nfmtab == 0) {
                                this.app.snfm1.select(1 + (int)(Math.random() * 10.0));
                            }
                            if (this.nfmtab == 1) {
                                this.app.snfm2.select(1 + (int)(Math.random() * 17.0));
                            }
                        }
                    }
                }
                if (this.cd.staction == 3) {
                    this.drawdprom(145, 170);
                    if (this.cd.reco == -2) {
                        if (this.lfrom == 0) {
                            this.drawcs(171, "Login to Retrieve your Account Stages", 0, 0, 0, 3);
                        }
                        else {
                            this.drawcs(171, "Login to add this stage to your account.", 0, 0, 0, 3);
                        }
                    }
                    if (this.cd.reco == -1) {
                        this.drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                    }
                    if (this.cd.reco == 1) {
                        this.drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                    }
                    if (this.cd.reco == 2) {
                        this.drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                    }
                    if (this.cd.reco == -167 || this.cd.reco == -177) {
                        if (this.cd.reco == -167) {
                            this.nickname = this.app.tnick.getText();
                            this.backlog = this.nickname;
                            this.cd.reco = -177;
                        }
                        this.drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
                    }
                    if (this.cd.reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                        this.drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                    }
                    if (this.cd.reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                        this.drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                    }
                    if (!this.showtf) {
                        this.app.tnick.setBackground(new Color(206, 237, 255));
                        if (this.cd.reco != 1) {
                            if (this.cd.reco != 2) {
                                this.app.tnick.setText(this.nickname);
                            }
                            this.app.tnick.setForeground(new Color(0, 0, 0));
                        }
                        else {
                            this.app.tnick.setForeground(new Color(255, 0, 0));
                        }
                        this.app.tnick.requestFocus();
                        this.app.tpass.setBackground(new Color(206, 237, 255));
                        if (this.cd.reco != 2) {
                            if (!this.autolog) {
                                this.app.tpass.setText("");
                            }
                            this.app.tpass.setForeground(new Color(0, 0, 0));
                        }
                        else {
                            this.app.tpass.setForeground(new Color(255, 0, 0));
                        }
                        if (!this.app.tnick.getText().equals("") && this.cd.reco != 1) {
                            this.app.tpass.requestFocus();
                        }
                        this.showtf = true;
                    }
                    this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                    this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                    this.app.movefieldd(this.app.tnick, 376, 185, 129, 23, true);
                    this.app.movefieldd(this.app.tpass, 376, 215, 129, 23, true);
                    if (this.tcnt < 30) {
                        ++this.tcnt;
                        if (this.tcnt == 30) {
                            if (this.cd.reco == 2) {
                                this.app.tpass.setText("");
                            }
                            this.app.tnick.setForeground(new Color(0, 0, 0));
                            this.app.tpass.setForeground(new Color(0, 0, 0));
                        }
                    }
                    if (this.cd.reco != -177) {
                        if ((this.drawcarb(true, null, "       Login       ", 347, 247, n, n2, b) || control.handb || control.enter) && this.tcnt > 5) {
                            this.tcnt = 0;
                            if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                                this.autolog = false;
                                this.app.tnick.setVisible(false);
                                this.app.tpass.setVisible(false);
                                this.app.requestFocus();
                                this.cd.staction = 4;
                                this.cd.sparkstageaction();
                            }
                            else {
                                if (this.app.tpass.getText().equals("")) {
                                    this.cd.reco = -4;
                                }
                                if (this.app.tnick.getText().equals("")) {
                                    this.cd.reco = -3;
                                }
                            }
                        }
                    }
                    else if (this.drawcarb(true, null, "  Upgrade to have your own stages!  ", 277, 247, n, n2, b) && this.cntflock == 0) {
                        this.app.editlink(this.nickname, true);
                        this.cntflock = 100;
                    }
                    if (this.drawcarb(true, null, "  Cancel  ", 409, 282, n, n2, b)) {
                        this.app.tnick.setVisible(false);
                        this.app.tpass.setVisible(false);
                        this.app.requestFocus();
                        this.cd.staction = 0;
                    }
                    if (this.drawcarb(true, null, "  Register!  ", 316, 282, n, n2, b)) {
                        if (this.cntflock == 0) {
                            this.app.reglink();
                            this.cntflock = 100;
                        }
                    }
                    else if (this.cntflock != 0) {
                        --this.cntflock;
                    }
                }
                if (this.cd.staction == 4) {
                    this.drawdprom(145, 170);
                    this.drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                }
                if (checkPoints.stage == -2 && this.cd.msloaded == 1 && checkPoints.top20 < 3 && !this.app.openm && this.drawcarb(true, null, "X", 609, 113, n, n2, b)) {
                    this.cd.staction = 6;
                }
                if (this.cd.staction == -1 && checkPoints.top20 < 3) {
                    this.removeds = 0;
                    this.drawdprom(145, 95);
                    this.drawcs(175, "Failed to remove stage from your account, try again later.", 0, 0, 0, 3);
                    if (this.drawcarb(true, null, " OK ", 379, 195, n, n2, b)) {
                        this.cd.staction = 0;
                    }
                }
                if (this.cd.staction == 1) {
                    this.drawdprom(145, 95);
                    this.drawcs(195, "Removing stage from your account...", 0, 0, 0, 3);
                    this.removeds = 1;
                }
                if (this.cd.staction == 6) {
                    this.drawdprom(145, 95);
                    this.drawcs(175, "Remove this stage from your account?", 0, 0, 0, 3);
                    if (this.drawcarb(true, null, " Yes ", 354, 195, n, n2, b)) {
                        this.cd.onstage = this.app.mstgs.getSelectedItem();
                        this.cd.staction = 1;
                        this.cd.sparkstageaction();
                    }
                    if (this.drawcarb(true, null, " No ", 408, 195, n, n2, b)) {
                        this.cd.staction = 0;
                    }
                }
                if (n3 == 1) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadmystages(checkPoints);
                }
                if (n3 >= 3) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadtop20(n3);
                }
                if (n3 == 2) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadstagemaker();
                }
                if (checkPoints.stage != -3 && this.cd.staction == 0 && checkPoints.top20 < 3) {
                    this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
                }
                else {
                    this.pcontin = 0;
                }
                if (checkPoints.top20 >= 3 && this.cd.staction != 3 && this.cd.staction != 4) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.dnload == 0 && this.drawcarb(true, null, " Add to My Stages ", 334, 355, n, n2, b)) {
                        if (this.logged) {
                            this.cd.onstage = checkPoints.name;
                            this.cd.staction = 2;
                            this.cd.sparkstageaction();
                            this.dnload = 2;
                        }
                        else {
                            this.lfrom = 1;
                            this.cd.staction = 3;
                            this.showtf = false;
                            this.tcnt = 0;
                            this.cntflock = 0;
                            this.cd.reco = -2;
                        }
                    }
                    if (this.dnload == 2) {
                        this.drawcs(370, "Adding stage please wait...", 193, 106, 0, 3);
                        if (this.cd.staction == 0) {
                            this.dnload = 3;
                        }
                        if (this.cd.staction == -2) {
                            this.dnload = 4;
                        }
                        if (this.cd.staction == -3) {
                            this.dnload = 5;
                        }
                        if (this.cd.staction == -1) {
                            this.dnload = 6;
                        }
                        if (this.dnload != 2) {
                            this.cd.staction = 0;
                        }
                    }
                    if (this.dnload == 3) {
                        this.drawcs(370, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                    }
                    if (this.dnload == 4) {
                        this.drawcs(370, "You already have this stage!", 193, 106, 0, 3);
                    }
                    if (this.dnload == 5) {
                        this.drawcs(370, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                    }
                    if (this.dnload == 6) {
                        this.drawcs(370, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                    }
                }
                if (this.testdrive == 0 && checkPoints.top20 < 3) {
                    if (!this.app.gmode.isShowing()) {
                        this.app.gmode.select(0);
                        this.app.gmode.show();
                    }
                    this.app.gmode.move(400 - this.app.gmode.getWidth() / 2, 395);
                    if (this.app.gmode.getSelectedIndex() == 0 && this.nplayers != 7) {
                        this.nplayers = 7;
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                    if (this.app.gmode.getSelectedIndex() == 1 && this.nplayers != 1) {
                        this.nplayers = 1;
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                }
                else if (this.app.gmode.isShowing()) {
                    this.app.gmode.hide();
                }
                if (this.nfmtab == 0 && this.app.snfm1.getSelectedIndex() != checkPoints.stage && this.app.snfm1.getSelectedIndex() != 0) {
                    checkPoints.stage = this.app.snfm1.getSelectedIndex();
                    checkPoints.top20 = 0;
                    checkPoints.nto = 0;
                    this.hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if (this.nfmtab == 1 && this.app.snfm2.getSelectedIndex() != checkPoints.stage - 10 && this.app.snfm2.getSelectedIndex() != 0) {
                    checkPoints.stage = this.app.snfm2.getSelectedIndex() + 10;
                    checkPoints.top20 = 0;
                    checkPoints.nto = 0;
                    this.hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if ((this.nfmtab == 2 || this.nfmtab == 5) && !this.app.mstgs.getSelectedItem().equals(checkPoints.name) && this.app.mstgs.getSelectedIndex() != 0) {
                    if (this.nfmtab == 2) {
                        checkPoints.stage = -2;
                    }
                    else {
                        checkPoints.stage = -1;
                    }
                    checkPoints.name = this.app.mstgs.getSelectedItem();
                    checkPoints.top20 = 0;
                    checkPoints.nto = 0;
                    this.hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if (this.nfmtab == 3 || this.nfmtab == 4) {
                    String substring = "";
                    final int n6 = this.app.mstgs.getSelectedItem().indexOf(" ") + 1;
                    if (n6 > 0) {
                        substring = this.app.mstgs.getSelectedItem().substring(n6);
                    }
                    if (!substring.equals("") && !substring.equals(checkPoints.name) && this.app.mstgs.getSelectedIndex() != 0) {
                        checkPoints.stage = -2;
                        checkPoints.name = substring;
                        checkPoints.top20 = -this.cd.msloaded;
                        checkPoints.nto = this.app.mstgs.getSelectedIndex();
                        this.hidos();
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                }
            }
            else {
                this.rd.setFont(new Font("SansSerif", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (checkPoints.stage != 27) {
                    int stage = checkPoints.stage;
                    if (stage > 10) {
                        stage -= 10;
                    }
                    this.drawcs(80, "Stage " + stage + "  >", 255, 128, 0, 3);
                }
                else {
                    this.drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
                }
                if (this.aflk) {
                    this.drawcs(100, "| " + checkPoints.name + " |", 240, 240, 240, 3);
                    this.aflk = false;
                }
                else {
                    this.drawcs(100, "| " + checkPoints.name + " |", 176, 176, 176, 3);
                    this.aflk = true;
                }
                if (checkPoints.stage != -3) {
                    this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
                }
                else {
                    this.pcontin = 0;
                }
            }
            if (this.cd.staction == 0) {
                if ((control.handb || control.enter) && checkPoints.stage != -3 && checkPoints.top20 < 3) {
                    this.app.gmode.hide();
                    this.hidos();
                    this.dudo = 150;
                    this.fase = 5;
                    control.handb = false;
                    control.enter = false;
                    this.intertrack.stop();
                    this.intertrack.unloadimod();
                }
                if (checkPoints.stage > 0) {
                    if (control.right) {
                        if (this.gmode == 0 || (this.gmode == 1 && checkPoints.stage != this.unlocked[0]) || (this.gmode == 2 && checkPoints.stage != this.unlocked[1] + 10) || checkPoints.stage == 27) {
                            if (checkPoints.stage != 27) {
                                this.hidos();
                                ++checkPoints.stage;
                                if (this.gmode == 1 && checkPoints.stage == 11) {
                                    checkPoints.stage = 27;
                                }
                                if (checkPoints.stage > 10) {
                                    this.app.sgame.select(1);
                                    this.nfmtab = 1;
                                }
                                else {
                                    this.app.sgame.select(0);
                                    this.nfmtab = 0;
                                }
                                this.fase = 2;
                            }
                        }
                        else {
                            this.fase = 4;
                            this.lockcnt = 100;
                        }
                        control.right = false;
                    }
                    if (control.left && checkPoints.stage != 1 && (checkPoints.stage != 11 || this.gmode != 2)) {
                        this.hidos();
                        --checkPoints.stage;
                        if (this.gmode == 1 && checkPoints.stage == 26) {
                            checkPoints.stage = 10;
                        }
                        if (checkPoints.stage > 10) {
                            this.app.sgame.select(1);
                            this.nfmtab = 1;
                        }
                        else {
                            this.app.sgame.select(0);
                            this.nfmtab = 0;
                        }
                        this.fase = 2;
                        control.left = false;
                    }
                }
            }
        }
        else {
            if (this.aflk) {
                this.drawcs(132, checkPoints.name, 240, 240, 240, 3);
                this.aflk = false;
            }
            else {
                this.drawcs(132, checkPoints.name, 176, 176, 176, 3);
                this.aflk = true;
            }
            this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
            if (control.handb || control.enter) {
                this.dudo = 150;
                this.fase = 5;
                control.handb = false;
                control.enter = false;
                this.intertrack.stop();
                this.intertrack.unloadimod();
            }
        }
        if (this.drawcarb(true, null, " Exit X ", 670, 30, n, n2, b)) {
            this.fase = 102;
            if (this.gmode == 0) {
                this.opselect = 3;
            }
            if (this.gmode == 1) {
                this.opselect = 0;
            }
            if (this.gmode == 2) {
                this.opselect = 1;
            }
            this.app.gmode.hide();
            this.hidos();
            this.app.tnick.setVisible(false);
            this.app.tpass.setVisible(false);
            this.intertrack.stop();
        }
    }

    public void hidos() {
        this.app.sgame.hide();
        this.app.snfm1.hide();
        this.app.snfm2.hide();
        this.app.mstgs.hide();
    }

    public void hipnoload(final int n, final boolean b) {
        final int[] array = { this.m.snap[0], this.m.snap[1], this.m.snap[2] };
        while (array[0] + array[1] + array[2] < -30) {
            for (int i = 0; i < 3; ++i) {
                if (array[i] < 50) {
                    final int[] array2 = array;
                    final int n2 = i;
                    ++array2[n2];
                }
            }
        }
        int n3 = (int)(230.0f - 230.0f * (array[0] / 100.0f));
        if (n3 > 255) {
            n3 = 255;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        int n4 = (int)(230.0f - 230.0f * (array[1] / 100.0f));
        if (n4 > 255) {
            n4 = 255;
        }
        if (n4 < 0) {
            n4 = 0;
        }
        int n5 = (int)(230.0f - 230.0f * (array[2] / 100.0f));
        if (n5 > 255) {
            n5 = 255;
        }
        if (n5 < 0) {
            n5 = 0;
        }
        this.rd.setColor(new Color(n3, n4, n5));
        this.rd.fillRect(65, 25, 670, 400);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3f));
        this.rd.drawImage(this.bggo, 0, -25, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(50, this.asay, 0, 0, 0, 3);
        int n6 = -90;
        if (this.multion == 0) {
            if (n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 10) {
                n6 = 0;
            }
            if (n == 11 || n == 12 || n == 13 || n == 14 || n == 17 || n == 18 || n == 19 || n == 20 || n == 22 || n == 23 || n == 26) {
                n6 = 0;
            }
            if (n < 0 && this.nplayers != 1 && this.newparts) {
                n6 = 0;
            }
        }
        else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || n == 10) {
            n6 = 0;
        }
        if (n6 == 0) {
            if (this.dudo > 0) {
                if (this.aflk) {
                    if (Math.random() > Math.random()) {
                        this.duds = (int)(Math.random() * 3.0);
                    }
                    else {
                        this.duds = (int)(Math.random() * 2.0);
                    }
                    this.aflk = false;
                }
                else {
                    this.aflk = true;
                }
                --this.dudo;
            }
            else {
                this.duds = 0;
            }
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.3f));
            this.rd.drawImage(this.dude[this.duds], 95, 35, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.7f));
            this.rd.drawImage(this.flaot, 192, 67, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
            int n7 = (int)(80.0f - 80.0f * (array[0] / 100.0f));
            if (n7 > 255) {
                n7 = 255;
            }
            if (n7 < 0) {
                n7 = 0;
            }
            int n8 = (int)(80.0f - 80.0f * (array[1] / 100.0f));
            if (n8 > 255) {
                n8 = 255;
            }
            if (n8 < 0) {
                n8 = 0;
            }
            int n9 = (int)(80.0f - 80.0f * (array[2] / 100.0f));
            if (n9 > 255) {
                n9 = 255;
            }
            if (n9 < 0) {
                n9 = 0;
            }
            this.rd.setColor(new Color(n7, n8, n9));
            this.rd.setFont(new Font("Arial", 1, 13));
            if (this.multion != 0) {
                if (this.ransay == 1 && n != 10) {
                    this.rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!", 262, 92);
                }
                if (this.ransay == 2 && n != 10) {
                    this.rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and", 262, 92);
                    this.rd.drawString("click any of the players listed on the right to lock the Arrow on!", 262, 112);
                }
                if (this.ransay == 3 && n != 10) {
                    this.rd.drawString("Multiplayer Tip:  When wasting in multiplayer it's better to aim slightly", 262, 92);
                    this.rd.drawString("ahead of the other player's car to compensate for internet delay.", 262, 112);
                }
                if (this.ransay == 4) {
                    this.rd.drawString("When watching a game, click any player listed on the right of the", 262, 92);
                    this.rd.drawString("screen to follow and watch.", 262, 112);
                    this.rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
                }
                if (n == 10 && this.ransay != 4) {
                    if (this.tflk) {
                        this.rd.setColor(new Color(200, n8, n9));
                        this.tflk = false;
                    }
                    else {
                        this.tflk = true;
                    }
                    this.rd.drawString("NOTE: Guidance Arrow and opponent status is disabled in this stage!", 262, 92);
                }
            }
            else {
                if (n < 0 && this.nplayers != 1 && this.newparts) {
                    this.rd.drawString("Please note, the computer car's AI has not yet been trained to handle", 262, 92);
                    this.rd.drawString("some of the new stage parts such as the 'Rollercoaster Road' and the", 262, 112);
                    this.rd.drawString("'Tunnel Side Ramp'.", 262, 132);
                    this.rd.drawString("(Those new parts where mostly designed for the multiplayer game.)", 262, 152);
                    this.rd.drawString("The AI will be trained and ready in the future releases of the game!", 262, 172);
                }
                if (n == 1 || n == 11) {
                    this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 262, 92);
                    this.rd.drawString("all checkpoints in the track!", 262, 112);
                }
                if (n == 2 || n == 12) {
                    this.rd.drawString("Remember, the more power you have the faster your car will be!", 262, 92);
                }
                if (n == 3) {
                    this.rd.drawString("> Hint: its easier to waste the other cars then to race in this stage!", 262, 92);
                    this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 112);
                    this.rd.drawString("the track.", 262, 132);
                }
                if (n == 4) {
                    this.rd.drawString("Remember, the better the stunt you perform the more power you get!", 262, 92);
                }
                if (n == 5) {
                    this.rd.drawString("Remember, the more power you have the stronger your car is!", 262, 92);
                }
                if (n == 10) {
                    if (this.tflk) {
                        this.rd.setColor(new Color(200, n8, n9));
                        this.tflk = false;
                    }
                    else {
                        this.tflk = true;
                    }
                    this.rd.drawString("NOTE: Guidance Arrow is disabled in this stage!", 262, 92);
                }
                if (n == 13) {
                    this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 262, 92);
                    this.rd.drawString("Don't upset him or you'll be arrested!", 262, 112);
                    this.rd.drawString("Better run, run, run.", 262, 152);
                }
                if (n == 14) {
                    this.rd.drawString("Don't waste your time.  Waste them instead!", 262, 92);
                    this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 262, 112);
                    this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 152);
                    this.rd.drawString("the track.", 262, 172);
                }
                if (n == 17) {
                    this.rd.drawString("Welcome to the realm of the king...", 262, 92);
                    this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 262, 132);
                    this.rd.drawString("and STRONGER you car will be!", 262, 152);
                }
                if (n == 18) {
                    this.rd.drawString("Watch out, EL KING is out to get you now!", 262, 92);
                    this.rd.drawString("He seems to be seeking revenge?", 262, 112);
                    this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 262, 152);
                    this.rd.drawString("before take off).", 262, 172);
                }
                if (n == 19) {
                    this.rd.drawString("It\u2019s good to be the king!", 262, 92);
                }
                if (n == 20) {
                    this.rd.drawString("Remember, forward loops give your car a push forwards in the air", 262, 92);
                    this.rd.drawString("and help in racing.", 262, 112);
                    this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 262, 152);
                    this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 262, 172);
                }
                if (n == 22) {
                    this.rd.drawString("Watch out!  Beware!  Take care!", 262, 92);
                    this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 262, 112);
                }
                if (n == 23) {
                    this.rd.drawString("Anyone for a game of Digger?!", 262, 92);
                    this.rd.drawString("You can have fun using MASHEEN here!", 262, 112);
                }
                if (n == 26) {
                    this.rd.drawString("This is it!  This is the toughest stage in the game!", 262, 92);
                    this.rd.drawString("This track is actually a 4D object projected onto the 3D world.", 262, 132);
                    this.rd.drawString("It's been broken down, separated and, in many ways, it is also a", 262, 152);
                    this.rd.drawString("maze!  GOOD LUCK!", 262, 172);
                }
            }
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.8f));
        this.rd.drawImage(this.loadingmusic, 289, 205 + n6, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        int n10 = n - 1;
        if (n10 < 0) {
            n10 = 32;
        }
        if (!b) {
            this.drawcs(340 + n6, "" + this.sndsize[n10] + " KB", 0, 0, 0, 3);
            this.drawcs(375 + n6, " Please Wait...", 0, 0, 0, 3);
        }
        else {
            this.drawcs(365 + n6, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5f));
            this.rd.drawImage(this.star[this.pstar], 359, 385 + n6, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
            if (this.pstar != 2) {
                if (this.pstar == 0) {
                    this.pstar = 1;
                }
                else {
                    this.pstar = 0;
                }
            }
            if (this.multion != 0) {
                this.drawcs(380 + n6, "" + this.forstart / 20, 0, 0, 0, 3);
            }
        }
    }

    public void loadmusic(final int runtyp, final String s, final int n) {
        this.hipnoload(runtyp, false);
        this.app.setCursor(new Cursor(3));
        this.app.repaint();
        boolean b = false;
        if (this.multion == 0) {
            if (runtyp == 1 || runtyp == 2 || runtyp == 3 || runtyp == 4 || runtyp == 5 || runtyp == 10) {
                b = true;
            }
            if (runtyp == 11 || runtyp == 12 || runtyp == 13 || runtyp == 14 || runtyp == 17 || runtyp == 18 || runtyp == 19 || runtyp == 20 || runtyp == 22 || runtyp == 23 || runtyp == 26) {
                b = true;
            }
            if (runtyp < 0 && this.nplayers != 1 && this.newparts) {
                b = true;
            }
        }
        else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || runtyp == 10) {
            b = true;
        }
        if (b) {
            this.runtyp = runtyp;
            (this.runner = new Thread(this)).start();
        }
        this.loadstrack(runtyp, s, n);
        if (b) {
          this.runner.stop();
          this.runner = null;
          /*try {
            this.runner = null;
          } catch (InterruptedException ex) {
            // NOTE: caught here
          }*/
          this.runtyp = 0;
        }
        System.gc();
        if (this.multion == 0 && this.app.applejava) {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex) {}
        }
        if (!this.lan) {
            this.strack.play();
        }
        else if (this.im != 0) {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex2) {}
        }
        this.app.setCursor(new Cursor(0));
        this.pcontin = 0;
        this.mutem = false;
        this.mutes = false;
        this.fase = 6;
    }

    public void loadstrack(final int n, final String s, final int n2) {
        if (n == 1) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 240, 8400, 135, false, false);
        }
        if (n == 2) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 190, 9000, 145, false, false);
        }
        if (n == 3) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 170, 8500, 145, false, false);
        }
        if (n == 4) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 205, 7500, 125, false, false);
        }
        if (n == 5) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 170, 7900, 125, false, false);
        }
        if (n == 6) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 370, 7900, 125, false, false);
        }
        if (n == 7) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 205, 7500, 125, false, false);
        }
        if (n == 8) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 230, 7900, 125, false, false);
        }
        if (n == 9) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 180, 7900, 125, false, false);
        }
        if (n == 10) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 280, 8100, 145, false, false);
        }
        if (n == 11) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 120, 8000, 125, false, false);
        }
        if (n == 12) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 260, 7200, 125, false, false);
        }
        if (n == 13) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 270, 8000, 125, false, false);
        }
        if (n == 14) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 190, 8000, 125, false, false);
        }
        if (n == 15) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 162, 7800, 125, false, false);
        }
        if (n == 16) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 220, 7600, 125, false, false);
        }
        if (n == 17) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 300, 7500, 125, false, false);
        }
        if (n == 18) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 200, 7900, 125, false, false);
        }
        if (n == 19) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 200, 7900, 125, false, false);
        }
        if (n == 20) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 232, 7300, 125, false, false);
        }
        if (n == 21) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 370, 7900, 125, false, false);
        }
        if (n == 22) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 290, 7900, 125, false, false);
        }
        if (n == 23) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 222, 7600, 125, false, false);
        }
        if (n == 24) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 230, 8000, 125, false, false);
        }
        if (n == 25) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 220, 8000, 125, false, false);
        }
        if (n == 26) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 261, 8000, 125, false, false);
        }
        if (n == 27) {
            if (this.gmode == 2) {
                this.strack = new RadicalMod("music/party.zip", 400, 7600, 125, false, false);
            }
            else {
                this.strack = new RadicalMod("music/stage" + n + ".zip", 276, 8800, 145, false, false);
            }
        }
        if (n == 28) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 182, 8000, 125, false, false);
        }
        if (n == 29) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 220, 8000, 125, false, false);
        }
        if (n == 30) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 200, 8000, 125, false, false);
        }
        if (n == 31) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 350, 7900, 125, false, false);
        }
        if (n == 32) {
            this.strack = new RadicalMod("music/stage" + n + ".zip", 310, 8000, 125, false, false);
        }
        if (n < 0) {
            if (!s.equals("")) {
                if (n != -2) {
                    this.strack = new RadicalMod("mystages/mymusic/" + s + ".zip", n2, 8000, 125, false, false);
                }
                else {
                    this.strack = new RadicalMod(s, n2, 8000, 125, false, true);
                }
            }
            else {
                this.strack = new RadicalMod();
            }
        }
        this.loadedt = true;
    }

    public void musicomp(final int n, final Control control) {
        this.hipnoload(n, true);
        if (this.multion != 0) {
            --this.forstart;
            if (this.lan && this.im == 0) {
                this.forstart = 0;
            }
        }
        if (control.handb || control.enter || this.forstart == 0) {
            System.gc();
            this.m.trk = 0;
            this.m.crs = false;
            this.m.ih = 0;
            this.m.iw = 0;
            this.m.h = 450;
            this.m.w = 800;
            this.m.focus_point = 400;
            this.m.cx = 400;
            this.m.cy = 225;
            this.m.cz = 50;
            this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            if (this.multion == 0) {
                this.fase = 0;
            }
            else {
                this.fase = 7001;
                this.forstart = 0;
                if (!this.lan) {
                    try {
                        this.socket = new Socket(this.server, this.servport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                        this.runtyp = -101;
                        (this.runner = new Thread(this)).start();
                    }
                    catch (Exception ex) {}
                }
            }
            if (Math.random() > Math.random()) {
                this.dudo = 250;
            }
            else {
                this.dudo = 428;
            }
            control.handb = false;
            control.enter = false;
        }
    }

    public void waitenter() {
        if (this.forstart < 690) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0, 0);
            if (this.forstart <= 640) {
                this.drawcs(90, "" + (640 - this.forstart) / 32 + "", 0, 0, 0, 0);
            }
            else {
                this.drawcs(90, "Your connection to game may have been lost...", 0, 0, 0, 0);
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            if (this.tflk) {
                this.drawcs(125, "Get Ready!", 0, 0, 0, 0);
                this.tflk = false;
            }
            else {
                this.drawcs(125, "Get Ready!", 0, 128, 255, 0);
                this.tflk = true;
            }
        }
        ++this.forstart;
        if (this.forstart == 700) {
            this.fase = -2;
            this.winner = false;
        }
    }

    public void multistat(final Control control, final CheckPoints checkPoints, final int lxm, final int lym, final boolean b, final UDPMistro udpMistro) {
        int n = -1;
        if (this.fase != -2) {
            if (this.exitm != 0 && !this.holdit) {
                if (!this.lan || this.im != 0) {
                    if (b) {
                        if (lxm > 357 && lxm < 396 && lym > 162 && lym < 179) {
                            this.exitm = 2;
                            if (this.multion == 1 && !this.lan && this.sendstat == 0) {
                                this.sendstat = 1;
                                if (this.runtyp != -101) {
                                    if (this.runner != null) {
                                      this.runner.stop();
                                      /*try {
                                        this.runner.join(0);
                                      } catch (InterruptedException ex) {
                                         // NOTE: caught here
                                      }*/
                                    }
                                    (this.runner = new Thread(this)).start();
                                }
                            }
                        }
                        else {
                            this.exitm = 0;
                        }
                    }
                    final float[] array = new float[3];
                    Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], array);
                    final float[] array2 = array;
                    final int n2 = 1;
                    array2[n2] -= 0.15;
                    if (array[1] < 0.0f) {
                        array[1] = 0.0f;
                    }
                    final float[] array3 = array;
                    final int n3 = 2;
                    array3[n3] += 0.15;
                    if (array[2] > 1.0f) {
                        array[2] = 1.0f;
                    }
                    this.rd.setColor(Color.getHSBColor(array[0], array[1], array[2]));
                    this.rd.fillRect(357, 169, 39, 10);
                    this.rd.fillRect(403, 169, 39, 10);
                    final float[] array4 = array;
                    final int n4 = 1;
                    array4[n4] -= 0.07;
                    if (array[1] < 0.0f) {
                        array[1] = 0.0f;
                    }
                    final float[] array5 = array;
                    final int n5 = 2;
                    array5[n5] += 0.07;
                    if (array[2] > 1.0f) {
                        array[2] = 1.0f;
                    }
                    this.rd.setColor(Color.getHSBColor(array[0], array[1], array[2]));
                    this.rd.fillRect(357, 162, 39, 7);
                    this.rd.fillRect(403, 162, 39, 7);
                    this.drawhi(this.exitgame, 116);
                    if (lxm > 357 && lxm < 396 && lym > 162 && lym < 179) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(357, 162, 39, 17);
                    }
                    if (lxm > 403 && lxm < 442 && lym > 162 && lym < 179) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(403, 162, 39, 17);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Yes", 366, 175);
                    this.rd.drawString("No", 416, 175);
                    this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
                    this.rd.drawRect(403, 162, 39, 17);
                    this.rd.drawRect(357, 162, 39, 17);
                }
                else {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.drawcs(125, "You cannot exit game.  Your computer is the LAN server!", 0, 0, 0, 0);
                    final int[] msgflk = this.msgflk;
                    final int n6 = 0;
                    ++msgflk[n6];
                    if (this.msgflk[0] == 67 || b) {
                        this.msgflk[0] = 0;
                        this.exitm = 0;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                }
            }
            else if (this.exitm == 4) {
                if (b) {
                    if (lxm > 357 && lxm < 396 && lym > 362 && lym < 379) {
                        this.alocked = -1;
                        this.lalocked = -1;
                        this.multion = 2;
                        control.multion = this.multion;
                        this.holdit = false;
                        this.exitm = 0;
                        control.chatup = 0;
                    }
                    if ((!this.lan || this.im != 0) && lxm > 403 && lxm < 442 && lym > 362 && lym < 379) {
                        this.holdcnt = 600;
                        this.exitm = 0;
                        control.chatup = 0;
                    }
                }
                final float[] array6 = new float[3];
                Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], array6);
                final float[] array7 = array6;
                final int n7 = 1;
                array7[n7] -= 0.15;
                if (array6[1] < 0.0f) {
                    array6[1] = 0.0f;
                }
                final float[] array8 = array6;
                final int n8 = 2;
                array8[n8] += 0.15;
                if (array6[2] > 1.0f) {
                    array6[2] = 1.0f;
                }
                this.rd.setColor(Color.getHSBColor(array6[0], array6[1], array6[2]));
                this.rd.fillRect(357, 369, 39, 10);
                if (!this.lan || this.im != 0) {
                    this.rd.fillRect(403, 369, 39, 10);
                }
                final float[] array9 = array6;
                final int n9 = 1;
                array9[n9] -= 0.07;
                if (array6[1] < 0.0f) {
                    array6[1] = 0.0f;
                }
                final float[] array10 = array6;
                final int n10 = 2;
                array10[n10] += 0.07;
                if (array6[2] > 1.0f) {
                    array6[2] = 1.0f;
                }
                this.rd.setColor(Color.getHSBColor(array6[0], array6[1], array6[2]));
                this.rd.fillRect(357, 362, 39, 7);
                if (!this.lan || this.im != 0) {
                    this.rd.fillRect(403, 362, 39, 7);
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.lan && this.im == 0) {
                    this.drawcs(140, "( You cannot exit game.  Your computer is the LAN server... )", 0, 0, 0, 0);
                }
                this.rd.drawString("Continue watching this game?", 155, 375);
                if (lxm > 357 && lxm < 396 && lym > 362 && lym < 379) {
                    this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    this.rd.fillRect(357, 362, 39, 17);
                }
                if ((!this.lan || this.im != 0) && lxm > 403 && lxm < 442 && lym > 362 && lym < 379) {
                    this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    this.rd.fillRect(403, 362, 39, 17);
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Yes", 366, 375);
                if (!this.lan || this.im != 0) {
                    this.rd.drawString("No", 416, 375);
                }
                this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
                if (!this.lan || this.im != 0) {
                    this.rd.drawRoundRect(147, 357, 301, 27, 7, 20);
                }
                else {
                    this.rd.drawRoundRect(147, 357, 262, 27, 7, 20);
                }
                this.rd.drawRect(357, 362, 39, 17);
                if (!this.lan || this.im != 0) {
                    this.rd.drawRect(403, 362, 39, 17);
                }
            }
            if (this.runtyp == -101 && !this.lan) {
                if (this.warning == 0 || this.warning == 210) {
                    int n11 = 0;
                    int n12 = 0;
                    if (this.clanchat) {
                        n11 = 1;
                        n12 = -23;
                    }
                    else if (control.chatup == 2) {
                        control.chatup = 1;
                    }
                    for (int i = n11; i >= 0; --i) {
                        boolean b2 = false;
                        if (lxm > 5 && lxm < 33 && lym > 423 + n12 && lym < 446 + n12) {
                            b2 = true;
                            if (control.chatup != 0) {
                                control.chatup = 0;
                            }
                        }
                        else if (this.pointc[i] != 6) {
                            this.pointc[i] = 6;
                            this.floater[i] = 1;
                        }
                        if (lxm > 33 && lxm < 666 && lym > 423 + n12 && lym < 446 + n12 && this.lxm != lxm && lym != this.lym && this.lxm != -100) {
                            control.chatup = i + 1;
                            this.cntchatp[i] = 0;
                        }
                        if (i == 0) {
                            this.lxm = lxm;
                            this.lym = lym;
                        }
                        if (this.exitm != 0 && this.exitm != 4) {
                            control.chatup = 0;
                        }
                        boolean b3 = false;
                        if (control.enter && control.chatup == i + 1) {
                            b3 = true;
                            control.chatup = 0;
                            control.enter = false;
                            this.lxm = -100;
                        }
                        if (b) {
                            if (this.mouson == 0) {
                                if (lxm > 676 && lxm < 785 && lym > 426 + n12 && lym < 443 + n12 && control.chatup == i + 1) {
                                    b3 = true;
                                    control.chatup = 0;
                                }
                                if (b2 && this.pointc[i] > 0) {
                                    final int[] pointc = this.pointc;
                                    final int n13 = i;
                                    --pointc[n13];
                                    this.floater[i] = 1;
                                }
                                if (i == 0) {
                                    this.mouson = 1;
                                }
                            }
                            if (i == 0) {
                                control.chatup = 0;
                            }
                        }
                        else if (i == 0 && this.mouson != 0) {
                            this.mouson = 0;
                        }
                        if (b3) {
                            String string = "";
                            int j = 0;
                            int n14 = 1;
                            while (j < this.lcmsg[i].length()) {
                                final String string2 = "" + this.lcmsg[i].charAt(j);
                                if (string2.equals(" ")) {
                                    ++n14;
                                }
                                else {
                                    n14 = 0;
                                }
                                if (n14 < 2) {
                                    string += string2;
                                }
                                ++j;
                            }
                            if (!string.equals("")) {
                                String replace = string.replace('|', ':');
                                if (replace.toLowerCase().indexOf(this.app.tpass.getText().toLowerCase()) != -1) {
                                    replace = " ";
                                }
                                if (!this.msgcheck(replace) && this.updatec[i] > -12) {
                                    if (this.cnames[i][6].equals("Game Chat  ") || this.cnames[i][6].equals("" + this.clan + "'s Chat  ")) {
                                        this.cnames[i][6] = "";
                                    }
                                    for (int k = 0; k < 6; ++k) {
                                        this.sentn[i][k] = this.sentn[i][k + 1];
                                        this.cnames[i][k] = this.cnames[i][k + 1];
                                    }
                                    this.sentn[i][6] = replace;
                                    this.cnames[i][6] = this.nickname;
                                    if (this.pointc[i] != 6) {
                                        this.pointc[i] = 6;
                                        this.floater[i] = 1;
                                    }
                                    this.msgflk[i] = 110;
                                    if (this.updatec[i] > -11) {
                                        this.updatec[i] = -11;
                                    }
                                    else {
                                        final int[] updatec = this.updatec;
                                        final int n15 = i;
                                        --updatec[n15];
                                    }
                                }
                                else {
                                    ++this.warning;
                                }
                            }
                        }
                        if (b2 || this.floater[i] != 0 || control.chatup == i + 1 || this.msgflk[i] != 0) {
                            final float[] array11 = new float[3];
                            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], array11);
                            final float[] array12 = array11;
                            final int n16 = 1;
                            array12[n16] -= 0.15;
                            if (array11[1] < 0.0f) {
                                array11[1] = 0.0f;
                            }
                            final float[] array13 = array11;
                            final int n17 = 2;
                            array13[n17] += 0.15;
                            if (array11[2] > 1.0f) {
                                array11[2] = 1.0f;
                            }
                            this.rd.setColor(Color.getHSBColor(array11[0], array11[1], array11[2]));
                            this.rd.fillRect(33, 423 + n12, 761, 23);
                        }
                        if (control.chatup == 0 && this.app.cmsg.isShowing()) {
                            this.app.cmsg.setVisible(false);
                            this.app.requestFocus();
                        }
                        if (control.chatup != i + 1) {
                            int n18 = 0;
                            int n19 = (int)(48.0f + 48.0f * (this.m.snap[1] / 100.0f));
                            if (n19 > 255) {
                                n19 = 255;
                            }
                            if (n19 < 0) {
                                n19 = 0;
                            }
                            int n20 = (int)(96.0f + 96.0f * (this.m.snap[2] / 100.0f));
                            if (n20 > 255) {
                                n20 = 255;
                            }
                            if (n20 < 0) {
                                n20 = 0;
                            }
                            if (this.floater[i] != 0) {
                                for (int l = 6; l >= 0; --l) {
                                    if (this.pointc[i] == l) {
                                        if (Math.abs(n18 + this.movepos[i]) > 10) {
                                            this.floater[i] = (this.movepos[i] + n18) / 4;
                                            if (this.floater[i] > -5 && this.floater[i] < 0) {
                                                this.floater[i] = -5;
                                            }
                                            if (this.floater[i] < 10 && this.floater[i] > 0) {
                                                this.floater[i] = 10;
                                            }
                                            final int[] movepos = this.movepos;
                                            final int n21 = i;
                                            movepos[n21] -= this.floater[i];
                                        }
                                        else {
                                            this.movepos[i] = -n18;
                                            this.floater[i] = 0;
                                        }
                                    }
                                    if (this.pointc[i] >= l) {
                                        this.rd.setColor(new Color(0, n19, n20));
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.cnames[i][l] + ": ", 39 + n18 + this.movepos[i], 439 + n12);
                                        final int n22 = n18 + this.ftm.stringWidth(this.cnames[i][l] + ": ");
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.sentn[i][l] + "   ", 39 + n22 + this.movepos[i], 439 + n12);
                                        n18 = n22 + this.ftm.stringWidth(this.sentn[i][l] + "   ");
                                    }
                                    else {
                                        n18 = n18 + this.ftm.stringWidth(this.cnames[i][l] + ": ") + this.ftm.stringWidth(this.sentn[i][l] + "   ");
                                    }
                                }
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.fillRect(0, 423 + n12, 5, 24);
                                this.rd.fillRect(794, 423 + n12, 6, 24);
                            }
                            else {
                                int n23 = this.pointc[i];
                                while (n23 >= 0) {
                                    if (n23 == 6 && this.msgflk[i] != 0) {
                                        final int[] msgflk2 = this.msgflk;
                                        final int n24 = i;
                                        --msgflk2[n24];
                                    }
                                    this.rd.setColor(new Color(0, n19, n20));
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.ftm.stringWidth(this.cnames[i][n23] + ": ") + 39 + n18 < 775) {
                                        if (n23 != 6 || this.msgflk[i] < 67 || this.msgflk[i] % 3 != 0) {
                                            this.rd.drawString(this.cnames[i][n23] + ": ", 39 + n18, 439 + n12);
                                        }
                                        final int n25 = n18 + this.ftm.stringWidth(this.cnames[i][n23] + ": ");
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.ftm.stringWidth(this.sentn[i][n23]) + 39 + n25 < 775) {
                                            if (n23 != 6 || this.msgflk[i] < 67 || this.msgflk[i] % 3 != 0) {
                                                this.rd.drawString(this.sentn[i][n23] + "   ", 39 + n25, 439 + n12);
                                            }
                                            n18 = n25 + this.ftm.stringWidth(this.sentn[i][n23] + "   ");
                                            --n23;
                                        }
                                        else {
                                            String string3 = "";
                                            for (int n26 = 0; this.ftm.stringWidth(string3) + 39 + n25 < 775 && n26 < this.sentn[i][n23].length(); string3 += this.sentn[i][n23].charAt(n26), ++n26) {}
                                            final String string4 = string3 + "...";
                                            if (n23 != 6 || this.msgflk[i] < 67 || this.msgflk[i] % 3 != 0) {
                                                this.rd.drawString(string4, 39 + n25, 439 + n12);
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    else {
                                        String string5 = "";
                                        for (int n27 = 0; this.ftm.stringWidth(string5) + 39 + n18 < 775 && n27 < this.cnames[i][n23].length(); string5 += this.cnames[i][n23].charAt(n27), ++n27) {}
                                        final String string6 = string5 + "...";
                                        if (n23 != 6 || this.msgflk[i] < 67 || this.msgflk[i] % 3 != 0) {
                                            this.rd.drawString(string6, 39 + n18, 439 + n12);
                                            break;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        else {
                            this.msgflk[i] = 0;
                            n = i;
                        }
                        if (b2 || this.floater[i] != 0) {
                            final float[] array14 = new float[3];
                            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], array14);
                            final float[] array15 = array14;
                            final int n28 = 1;
                            array15[n28] -= 0.076;
                            if (array14[1] < 0.0f) {
                                array14[1] = 0.0f;
                            }
                            final float[] array16 = array14;
                            final int n29 = 2;
                            array16[n29] += 0.076;
                            if (array14[2] > 1.0f) {
                                array14[2] = 1.0f;
                            }
                            this.rd.setColor(Color.getHSBColor(array14[0], array14[1], array14[2]));
                            this.rd.fillRect(5, 423 + n12, 28, 23);
                        }
                        if (b2) {
                            this.rd.setColor(new Color(0, 0, 0));
                        }
                        else {
                            this.rd.setColor(new Color((int)(this.m.cgrnd[0] / 2.0f), (int)(this.m.cgrnd[1] / 2.0f), (int)(this.m.cgrnd[2] / 2.0f)));
                        }
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.rd.drawString("<<", 10, 439 + n12);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(5, 423 + n12, 789, 23);
                        this.rd.drawLine(33, 423 + n12, 33, 446 + n12);
                        n12 += 23;
                    }
                    if (lxm > 775 && lxm < 794 && lym > 409 - n11 * 23 && lym < 423 - n11 * 23) {
                        this.rd.drawRect(775, 409 - n11 * 23, 19, 14);
                        this.rd.setColor(new Color(200, 0, 0));
                        if (b) {
                            control.chatup = 0;
                            if (this.app.cmsg.isShowing()) {
                                this.app.cmsg.setVisible(false);
                                this.app.requestFocus();
                            }
                            this.runtyp = 0;
                            try {
                                this.socket.close();
                                this.socket = null;
                                this.din.close();
                                this.din = null;
                                this.dout.close();
                                this.dout = null;
                            }
                            catch (Exception ex) {}
                        }
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("x", 782, 420 - n11 * 23);
                }
                else {
                    this.drawWarning();
                    if (this.app.cmsg.isShowing()) {
                        this.app.cmsg.setVisible(false);
                        this.app.requestFocus();
                    }
                    ++this.warning;
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
            else if (control.chatup != 0) {
                control.chatup = 0;
                if (!this.lan) {
                    this.runtyp = -101;
                    if (this.runner != null) {
                      this.runner.stop();
                      /*try {
                        this.runner.join(0);
                      } catch (InterruptedException ex) {
                         // NOTE: caught here
                      }*/
                    }
                    (this.runner = new Thread(this)).start();
                }
            }
            if (this.holdit && this.multion == 1 && !this.lan && this.sendstat == 0) {
                this.sendstat = 1;
                if (this.runtyp != -101) {
                    if (this.runner != null) {
                      this.runner.stop();
                      /*try {
                        this.runner.join(0);
                      } catch (InterruptedException ex) {
                         // NOTE: caught here
                      }*/
                    }
                    (this.runner = new Thread(this)).start();
                }
            }
            if ((control.arrace && this.starcnt < 38 && !this.holdit && checkPoints.stage != 10) || this.multion >= 2) {
                if (this.alocked != -1 && checkPoints.dested[this.alocked] != 0) {
                    this.alocked = -1;
                    this.lalocked = -1;
                }
                if (this.multion >= 2) {
                    if (this.alocked == -1 || this.holdit) {
                        if (this.cntflock == 100) {
                            for (int n30 = 0; n30 < this.nplayers; ++n30) {
                                if (this.holdit) {
                                    if (checkPoints.pos[n30] == 0) {
                                        this.alocked = n30;
                                        this.im = n30;
                                    }
                                }
                                else if (checkPoints.dested[n30] == 0) {
                                    this.alocked = n30;
                                    this.im = n30;
                                }
                            }
                        }
                        ++this.cntflock;
                    }
                    else {
                        this.cntflock = 0;
                    }
                    if (this.lan) {
                        boolean b4 = true;
                        for (int n31 = 0; n31 < this.nplayers; ++n31) {
                            if (this.dested[n31] == 0 && this.plnames[n31].indexOf("MadBot") == -1) {
                                b4 = false;
                            }
                        }
                        if (b4) {
                            this.exitm = 2;
                        }
                    }
                }
                for (int nplayers = this.nplayers, n32 = 0; n32 < nplayers; ++n32) {
                    int n33 = 0;
                    for (int n34 = 0; n34 < this.nplayers; ++n34) {
                        if (checkPoints.pos[n34] == n32 && checkPoints.dested[n34] == 0 && n33 == 0) {
                            int n35 = (int)(100.0f + 100.0f * (this.m.snap[2] / 100.0f));
                            if (n35 > 255) {
                                n35 = 255;
                            }
                            if (n35 < 0) {
                                n35 = 0;
                            }
                            this.rd.setColor(new Color(0, 0, n35));
                            if (n32 == 0) {
                                this.rd.drawString("1st", 673, 76 + 30 * n32);
                            }
                            if (n32 == 1) {
                                this.rd.drawString("2nd", 671, 76 + 30 * n32);
                            }
                            if (n32 == 2) {
                                this.rd.drawString("3rd", 671, 76 + 30 * n32);
                            }
                            if (n32 >= 3) {
                                this.rd.drawString("" + (n32 + 1) + "th", 671, 76 + 30 * n32);
                            }
                            if (this.clangame != 0) {
                                int n36;
                                int n37;
                                int n38;
                                if (this.pclan[n34].toLowerCase().equals(this.gaclan.toLowerCase())) {
                                    n36 = 255;
                                    n37 = 128;
                                    n38 = 0;
                                }
                                else {
                                    n36 = 0;
                                    n37 = 128;
                                    n38 = 255;
                                }
                                int n39 = (int)(n36 + n36 * (this.m.snap[0] / 100.0f));
                                if (n39 > 255) {
                                    n39 = 255;
                                }
                                if (n39 < 0) {
                                    n39 = 0;
                                }
                                int n40 = (int)(n37 + n37 * (this.m.snap[1] / 100.0f));
                                if (n40 > 255) {
                                    n40 = 255;
                                }
                                if (n40 < 0) {
                                    n40 = 0;
                                }
                                int n41 = (int)(n38 + n38 * (this.m.snap[2] / 100.0f));
                                if (n41 > 255) {
                                    n41 = 255;
                                }
                                if (n41 < 0) {
                                    n41 = 0;
                                }
                                this.rd.setColor(new Color(n39, n40, n41));
                                this.rd.drawString(this.plnames[n34], 731 - this.ftm.stringWidth(this.plnames[n34]) / 2, 70 + 30 * n32);
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString(this.plnames[n34], 730 - this.ftm.stringWidth(this.plnames[n34]) / 2, 70 + 30 * n32);
                            final int n42 = (int)(60.0f * checkPoints.magperc[n34]);
                            final int n43 = 244;
                            int n44 = 244;
                            final int n45 = 11;
                            if (n42 > 20) {
                                n44 = (int)(244.0f - 233.0f * ((n42 - 20) / 40.0f));
                            }
                            int n46 = (int)(n43 + n43 * (this.m.snap[0] / 100.0f));
                            if (n46 > 255) {
                                n46 = 255;
                            }
                            if (n46 < 0) {
                                n46 = 0;
                            }
                            int n47 = (int)(n44 + n44 * (this.m.snap[1] / 100.0f));
                            if (n47 > 255) {
                                n47 = 255;
                            }
                            if (n47 < 0) {
                                n47 = 0;
                            }
                            int n48 = (int)(n45 + n45 * (this.m.snap[2] / 100.0f));
                            if (n48 > 255) {
                                n48 = 255;
                            }
                            if (n48 < 0) {
                                n48 = 0;
                            }
                            this.rd.setColor(new Color(n46, n47, n48));
                            this.rd.fillRect(700, 74 + 30 * n32, n42, 5);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRect(700, 74 + 30 * n32, 60, 5);
                            boolean b5 = false;
                            if ((this.im != n34 || this.multion >= 2) && lxm > 661 && lxm < 775 && lym > 58 + 30 * n32 && lym < 83 + 30 * n32) {
                                b5 = true;
                                if (b) {
                                    if (!this.onlock) {
                                        if (this.alocked != n34 || this.multion >= 2) {
                                            this.alocked = n34;
                                            if (this.multion >= 2) {
                                                this.im = n34;
                                            }
                                        }
                                        else {
                                            this.alocked = -1;
                                        }
                                    }
                                    this.onlock = true;
                                }
                                else if (this.onlock) {
                                    this.onlock = false;
                                }
                            }
                            if (this.alocked == n34) {
                                int n49 = (int)(159.0f + 159.0f * (this.m.snap[0] / 100.0f));
                                if (n49 > 255) {
                                    n49 = 255;
                                }
                                if (n49 < 0) {
                                    n49 = 0;
                                }
                                int n50 = (int)(207.0f + 207.0f * (this.m.snap[1] / 100.0f));
                                if (n50 > 255) {
                                    n50 = 255;
                                }
                                if (n50 < 0) {
                                    n50 = 0;
                                }
                                int n51 = (int)(255.0f + 255.0f * (this.m.snap[2] / 100.0f));
                                if (n51 > 255) {
                                    n51 = 255;
                                }
                                if (n51 < 0) {
                                    n51 = 0;
                                }
                                this.rd.setColor(new Color(n49, n50, n51));
                                this.rd.drawRect(661, 58 + 30 * n32, 114, 25);
                                this.rd.drawRect(662, 59 + 30 * n32, 112, 23);
                            }
                            if (b5 && !this.onlock) {
                                int n52;
                                int n53;
                                int n54;
                                if (this.alocked == n34) {
                                    n52 = (int)(120.0f + 120.0f * (this.m.snap[0] / 100.0f));
                                    if (n52 > 255) {
                                        n52 = 255;
                                    }
                                    if (n52 < 0) {
                                        n52 = 0;
                                    }
                                    n53 = (int)(114.0f + 114.0f * (this.m.snap[1] / 100.0f));
                                    if (n53 > 255) {
                                        n53 = 255;
                                    }
                                    if (n53 < 0) {
                                        n53 = 0;
                                    }
                                    n54 = (int)(255.0f + 255.0f * (this.m.snap[2] / 100.0f));
                                    if (n54 > 255) {
                                        n54 = 255;
                                    }
                                    if (n54 < 0) {
                                        n54 = 0;
                                    }
                                }
                                else {
                                    n52 = (int)(140.0f + 140.0f * (this.m.snap[0] / 100.0f));
                                    if (n52 > 255) {
                                        n52 = 255;
                                    }
                                    if (n52 < 0) {
                                        n52 = 0;
                                    }
                                    n53 = (int)(160.0f + 160.0f * (this.m.snap[1] / 100.0f));
                                    if (n53 > 255) {
                                        n53 = 255;
                                    }
                                    if (n53 < 0) {
                                        n53 = 0;
                                    }
                                    n54 = (int)(255.0f + 255.0f * (this.m.snap[2] / 100.0f));
                                    if (n54 > 255) {
                                        n54 = 255;
                                    }
                                    if (n54 < 0) {
                                        n54 = 0;
                                    }
                                }
                                this.rd.setColor(new Color(n52, n53, n54));
                                this.rd.drawRect(660, 57 + 30 * n32, 116, 27);
                            }
                            n33 = 1;
                        }
                    }
                }
            }
            if (udpMistro.go && udpMistro.runon == 1 && !this.holdit) {
                int n55 = 0;
                int n56 = 0;
                for (int n57 = 0; n57 < this.nplayers; ++n57) {
                    if (n57 != udpMistro.im) {
                        ++n56;
                        if (udpMistro.lframe[n57] == udpMistro.lcframe[n57] || udpMistro.force[n57] == 7) {
                            ++n55;
                        }
                        else {
                            udpMistro.lcframe[n57] = udpMistro.lframe[n57];
                        }
                    }
                }
                if (n55 == n56) {
                    ++this.discon;
                }
                else if (this.discon != 0) {
                    this.discon = 0;
                }
                if (this.discon == 240) {
                    udpMistro.runon = 2;
                }
            }
        }
        if (n != -1) {
            final float[] array17 = new float[3];
            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], array17);
            final float[] array18 = array17;
            final int n58 = 1;
            array18[n58] -= 0.22;
            if (array17[1] < 0.0f) {
                array17[1] = 0.0f;
            }
            final float[] array19 = array17;
            final int n59 = 2;
            array19[n59] += 0.22;
            if (array17[2] > 1.0f) {
                array17[2] = 1.0f;
            }
            final Color hsbColor = Color.getHSBColor(array17[0], array17[1], array17[2]);
            this.rd.setColor(hsbColor);
            this.rd.fillRect(676, 426 - n * 23, 109, 7);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.rd.drawString("Send Message  >", 684, 439 - n * 23);
            this.rd.setColor(new Color((int)(this.m.cgrnd[0] / 1.2f), (int)(this.m.cgrnd[1] / 1.2f), (int)(this.m.cgrnd[2] / 1.2f)));
            this.rd.drawRect(676, 426 - n * 23, 109, 17);
            if (!this.app.cmsg.isShowing()) {
                this.app.cmsg.setVisible(true);
                this.app.cmsg.requestFocus();
                this.lcmsg[n] = "";
                this.app.cmsg.setText("");
                this.app.cmsg.setBackground(hsbColor);
            }
            this.app.movefield(this.app.cmsg, 34, 424 - n * 23, 633, 22);
            if (this.app.cmsg.getText().equals(this.lcmsg[n])) {
                final int[] cntchatp = this.cntchatp;
                final int n60 = n;
                ++cntchatp[n60];
            }
            else {
                this.cntchatp[n] = -200;
            }
            this.lcmsg[n] = "" + this.app.cmsg.getText();
            if (this.cntchatp[n] == 67) {
                control.chatup = 0;
            }
            if (this.app.cmsg.getText().length() > 100) {
                this.app.cmsg.setText(this.app.cmsg.getText().substring(0, 100));
                this.app.cmsg.select(100, 100);
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
        }
    }

    public void levelhigh(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.rd.drawImage(this.gameh, 301, 20, null);
        int n6 = 16;
        int n7 = 48;
        int n8 = 96;
        if (n4 < 50) {
            if (this.aflk) {
                n6 = 106;
                n7 = 176;
                n8 = 255;
                this.aflk = false;
            }
            else {
                this.aflk = true;
            }
        }
        if (n != this.im) {
            if (n3 == 0) {
                this.drawcs(60, "You Wasted 'em!", n6, n7, n8, 0);
            }
            else if (n3 == 1) {
                this.drawcs(60, "Close Finish!", n6, n7, n8, 0);
            }
            else {
                this.drawcs(60, "Close Finish!  Almost got it!", n6, n7, n8, 0);
            }
        }
        else if (n2 == 229) {
            if (this.discon != 240) {
                this.drawcs(60, "Wasted!", n6, n7, n8, 0);
            }
            else {
                this.drawcs(60, "Disconnected!", n6, n7, n8, 0);
            }
        }
        else if (n5 > 2 || n5 < 0) {
            this.drawcs(60, "Stunts!", n6, n7, n8, 0);
        }
        else {
            this.drawcs(60, "Best Stunt!", n6, n7, n8, 0);
        }
        this.drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }

    public void inst(final Control control) {
        if (this.flipo == 0) {
            this.flipo = 1;
        }
        if (this.flipo == 2) {
            this.flipo = 3;
            this.dudo = 200;
        }
        if (this.flipo == 4) {
            this.flipo = 5;
            this.dudo = 250;
        }
        if (this.flipo == 6) {
            this.flipo = 7;
            this.dudo = 200;
        }
        if (this.flipo == 8) {
            this.flipo = 9;
            this.dudo = 250;
        }
        if (this.flipo == 10) {
            this.flipo = 11;
            this.dudo = 200;
        }
        if (this.flipo == 12) {
            this.flipo = 13;
            this.dudo = 200;
        }
        if (this.flipo == 14) {
            this.flipo = 15;
            this.dudo = 100;
        }
        this.mainbg(2);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3f));
        this.rd.drawImage(this.bggo, 65, 25, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 425, 670, 25);
        if (this.aflk) {
            this.aflk = false;
        }
        else {
            this.aflk = true;
        }
        if (this.flipo != 1 && this.flipo != 16) {
            if (this.dudo > 0) {
                if (this.aflk) {
                    if (Math.random() > Math.random()) {
                        this.duds = (int)(Math.random() * 3.0);
                    }
                    else {
                        this.duds = (int)(Math.random() * 2.0);
                    }
                }
                --this.dudo;
            }
            else {
                this.duds = 0;
            }
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.4f));
            this.rd.drawImage(this.dude[this.duds], 95, 15, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
            this.rd.drawImage(this.oflaot, 192, 42, null);
        }
        this.rd.setColor(new Color(0, 64, 128));
        this.rd.setFont(new Font("Arial", 1, 13));
        if (this.flipo == 3 || this.flipo == 5) {
            if (this.flipo == 3) {
                this.rd.drawString("Hello!  Welcome to the world of", 262, 67);
                this.rd.drawString("!", 657, 67);
                this.rd.drawImage(this.nfm, 469, 55, null);
                this.rd.drawString("In this game there are two ways to complete a stage.", 262, 107);
                this.rd.drawString("One is by racing and finishing in first place, the other is by", 262, 127);
                this.rd.drawString("wasting and crashing all the other cars in the stage!", 262, 147);
            }
            else {
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("While racing, you will need to focus on going fast and passing", 262, 67);
                this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 262, 87);
                this.rd.drawString("must not miss a checkpoint.", 262, 107);
                this.rd.drawString("While wasting, you will just need to chase the other cars and", 262, 127);
                this.rd.drawString("crash into them (without worrying about track and checkpoints).", 262, 147);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.racing, 165, 185, null);
            this.rd.drawImage(this.ory, 429, 235, null);
            this.rd.drawImage(this.wasting, 492, 185, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("Checkpoint", 392, 189);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("Drive your car using the Arrow Keys and Spacebar", 125, 320);
            this.rd.drawImage(this.space, 171, 355, null);
            this.rd.drawImage(this.arrows, 505, 323, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 125, 341);
            this.rd.drawString("Accelerate", 515, 319);
            this.rd.drawString("Brake/Reverse", 506, 397);
            this.rd.drawString("Turn left", 454, 375);
            this.rd.drawString("Turn right", 590, 375);
            this.rd.drawString("Handbrake", 247, 374);
        }
        if (this.flipo == 7 || this.flipo == 9) {
            if (this.flipo == 7) {
                this.rd.drawString("Whether you are racing or wasting the other cars you will need", 262, 67);
                this.rd.drawString("to power up your car.", 262, 87);
                this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 262, 107);
                this.rd.drawString("To power up your car (and keep it powered up) you will need to", 262, 127);
                this.rd.drawString("perform stunts!", 262, 147);
                this.rd.drawImage(this.chil, 167, 295, null);
            }
            else {
                this.rd.drawString("The better the stunt the more power you get!", 262, 67);
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 262, 87);
                this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 262, 107);
                this.rd.drawString("more hang time in the air making it easier to control its landing.", 262, 127);
                this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 262, 147);
                if (this.aflk || this.dudo < 150) {
                    this.rd.drawImage(this.chil, 167, 295, null);
                }
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.stunts, 105, 175, null);
            this.rd.drawImage(this.opwr, 540, 253, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("To perform stunts. When your car is in the AIR:", 125, 310);
            this.rd.drawString("Press combo Spacebar + Arrow Keys", 125, 330);
            this.rd.drawImage(this.space, 185, 355, null);
            this.rd.drawImage(this.plus, 405, 358, null);
            this.rd.drawImage(this.arrows, 491, 323, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 492, 319);
            this.rd.drawString("Backward Loop", 490, 397);
            this.rd.drawString("Left Roll", 443, 375);
            this.rd.drawString("Right Roll", 576, 375);
            this.rd.drawString("Spacebar", 266, 374);
            this.rd.setColor(new Color(140, 243, 244));
            this.rd.fillRect(602, 257, 76, 9);
        }
        if (this.flipo == 11 || this.flipo == 13) {
            if (this.flipo == 11) {
                this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 262, 67);
                this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 262, 87);
                this.rd.drawString("to pointing to the cars.", 262, 107);
                this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 262, 127);
                this.rd.drawString("jumping through the electrified hoop.", 262, 147);
            }
            else {
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 262, 67);
                this.rd.drawString("and in some others it's easier to race and finish in first place.", 262, 87);
                this.rd.drawString("It is up to you to decide when to waste and when to race.", 262, 107);
                this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 262, 127);
                this.rd.drawString("will need it whether you are racing or wasting!", 262, 147);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.fixhoop, 185, 218, null);
            this.rd.drawImage(this.sarrow, 385, 228, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("The Electrified Hoop", 192, 216);
            this.rd.drawString("Jumping through it fixes your car.", 158, 338);
            this.rd.drawString("Make guidance arrow point to cars.", 385, 216);
        }
        if (this.flipo == 15) {
            this.rd.drawString("And if you don\u2019t know who I am,", 262, 67);
            this.rd.drawString("I am Coach Insano, I am the coach and narrator of this game!", 262, 87);
            this.rd.drawString("I recommended starting with NFM 1 if it\u2019s your first time to play.", 262, 127);
            this.rd.drawString("Good Luck & Have Fun!", 262, 147);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Other Controls :", 155, 205);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawImage(this.kz, 169, 229, null);
            this.rd.drawString("OR", 206, 251);
            this.rd.drawImage(this.kx, 229, 229, null);
            this.rd.drawString("To look behind you while driving.", 267, 251);
            this.rd.drawImage(this.kv, 169, 279, null);
            this.rd.drawString("Change Views", 207, 301);
            this.rd.drawImage(this.kenter, 169, 329, null);
            this.rd.drawString("Navigate & Pause Game", 275, 351);
            this.rd.drawImage(this.km, 489, 229, null);
            this.rd.drawString("Mute Music", 527, 251);
            this.rd.drawImage(this.kn, 489, 279, null);
            this.rd.drawString("Mute Sound Effects", 527, 301);
            this.rd.drawImage(this.ks, 489, 329, null);
            this.rd.drawString("Toggle radar / map", 527, 351);
        }
        if (this.flipo == 1 || this.flipo == 16) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            if (this.flipo == 16) {
                this.rd.drawString("M A I N    C O N T R O L S   -   once again!", 400 - this.ftm.stringWidth("M A I N    C O N T R O L S   -   once again!") / 2, 49);
            }
            else {
                this.rd.drawString("M A I N    C O N T R O L S", 400 - this.ftm.stringWidth("M A I N    C O N T R O L S") / 2, 49);
            }
            this.rd.drawString("Drive your car using the Arrow Keys:", 125, 80);
            this.rd.drawString("On the GROUND Spacebar is for Handbrake", 125, 101);
            this.rd.drawImage(this.space, 171, 115, null);
            this.rd.drawImage(this.arrows, 505, 83, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Accelerate", 515, 79);
            this.rd.drawString("Brake/Reverse", 506, 157);
            this.rd.drawString("Turn left", 454, 135);
            this.rd.drawString("Turn right", 590, 135);
            this.rd.drawString("Handbrake", 247, 134);
            this.drawcs(175, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 64, 128, 3);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("To perform STUNTS:", 125, 200);
            this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys", 125, 220);
            this.rd.drawImage(this.space, 185, 245, null);
            this.rd.drawImage(this.plus, 405, 248, null);
            this.rd.drawImage(this.arrows, 491, 213, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 492, 209);
            this.rd.drawString("Backward Loop", 490, 287);
            this.rd.drawString("Left Roll", 443, 265);
            this.rd.drawString("Right Roll", 576, 265);
            this.rd.drawString("Spacebar", 266, 264);
            this.rd.drawImage(this.stunts, 125, 285, null);
        }
        if (this.flipo >= 1 && this.flipo <= 15) {
            this.rd.drawImage(this.next[this.pnext], 665, 395, null);
        }
        if (this.flipo >= 3 && this.flipo <= 16) {
            this.rd.drawImage(this.back[this.pback], 75, 395, null);
        }
        if (this.flipo == 16) {
            this.rd.drawImage(this.contin[this.pcontin], 565, 395, null);
        }
        if (control.enter || control.right) {
            if (control.enter && this.flipo == 16) {
                this.flipo = 0;
                this.fase = this.oldfase;
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
            if (this.flipo >= 1 && this.flipo <= 15) {
                ++this.flipo;
            }
        }
        if (control.left) {
            if (this.flipo >= 3 && this.flipo <= 15) {
                this.flipo -= 3;
            }
            if (this.flipo == 16) {
                --this.flipo;
            }
            control.left = false;
        }
    }

    public void maini(final Control control) {
        if (this.flipo == 0) {
            this.app.setCursor(new Cursor(0));
            ++this.flipo;
        }
        this.mainbg(1);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.6f));
        this.rd.drawImage(this.logomadbg, 65, 25, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.drawImage(this.logomadnes, 233, 186, null);
        float n = this.flkat / 800.0f;
        if (n > 0.2) {
            n = 0.2f;
        }
        if (this.flkat > 200) {
            n = (400 - this.flkat) / 1000.0f;
            if (n < 0.0f) {
                n = 0.0f;
            }
        }
        ++this.flkat;
        if (this.flkat == 400) {
            this.flkat = 0;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, n));
        this.rd.drawImage(this.dude[0], 351 + this.gxdu, 28 + this.gydu, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        if (this.movly == 0) {
            this.gxdu = (int)(5.0 - 11.0 * Math.random());
            this.gydu = (int)(5.0 - 11.0 * Math.random());
        }
        ++this.movly;
        if (this.movly == 2) {
            this.movly = 0;
        }
        this.rd.drawImage(this.logocars, 66, 33, null);
        this.rd.drawImage(this.opback, 247, 237, null);
        if (this.muhi < 0) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRoundRect(335, 293, 114, 19, 7, 20);
        }
        --this.muhi;
        if (this.muhi < -5) {
            this.muhi = 50;
        }
        if (control.up) {
            --this.opselect;
            if (this.opselect == -1) {
                this.opselect = 3;
            }
            control.up = false;
        }
        if (control.down) {
            ++this.opselect;
            if (this.opselect == 4) {
                this.opselect = 0;
            }
            control.down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(343, 261, 110, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 200, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(288, 291, 221, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 191, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 95, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(301, 321, 196, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 128, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        }
        if (this.opselect == 3) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(357, 351, 85, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 0, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        }
        this.rd.drawImage(this.opti, 294, 265, null);
        if (control.enter || control.handb) {
            if (this.opselect == 1) {
                this.mtop = true;
                this.multion = 1;
                this.gmode = 0;
                if (this.firstime) {
                    this.oldfase = -9;
                    this.fase = 11;
                    this.firstime = false;
                }
                else {
                    this.fase = -9;
                }
            }
            if (this.opselect == 2) {
                this.oldfase = 10;
                this.fase = 11;
                this.firstime = false;
            }
            if (this.opselect == 3) {
                this.fase = 8;
            }
            if (this.opselect == 0) {
                if (this.unlocked[0] == 11) {
                    if (this.unlocked[1] != 17) {
                        this.opselect = 1;
                    }
                    else {
                        this.opselect = 2;
                    }
                }
                if (this.firstime) {
                    this.oldfase = 102;
                    this.fase = 11;
                    this.firstime = false;
                }
                else {
                    this.fase = 102;
                }
            }
            this.flipo = 0;
            control.enter = false;
            control.handb = false;
        }
        this.rd.drawImage(this.byrd, 72, 410, null);
        this.rd.drawImage(this.nfmcoms, 567, 410, null);
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException ex) {}
        }
    }

    public void maini2(final Control control, final int n, final int n2, final int n3) {
        this.mainbg(1);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.6f));
        this.rd.drawImage(this.logomadbg, 65, 25, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.drawImage(this.logomadnes, 233, 186, null);
        float n4 = this.flkat / 800.0f;
        if (n4 > 0.2) {
            n4 = 0.2f;
        }
        if (this.flkat > 200) {
            n4 = (400 - this.flkat) / 1000.0f;
            if (n4 < 0.0f) {
                n4 = 0.0f;
            }
        }
        ++this.flkat;
        if (this.flkat == 400) {
            this.flkat = 0;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, n4));
        this.rd.drawImage(this.dude[0], 351 + this.gxdu, 28 + this.gydu, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        if (this.movly == 0) {
            this.gxdu = (int)(5.0 - 11.0 * Math.random());
            this.gydu = (int)(5.0 - 11.0 * Math.random());
        }
        ++this.movly;
        if (this.movly == 2) {
            this.movly = 0;
        }
        this.rd.drawImage(this.logocars, 66, 33, null);
        this.rd.drawImage(this.opback, 247, 237, null);
        if (control.up) {
            --this.opselect;
            if (this.opselect == -1) {
                this.opselect = 3 - this.dropf / 15;
            }
            control.up = false;
        }
        if (control.down) {
            ++this.opselect;
            if (this.opselect == 4 - this.dropf / 15) {
                this.opselect = 0;
            }
            control.down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(358, 262 + this.dropf, 82, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(358, 290 + this.dropf, 82, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 95, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(333, 318 + this.dropf, 132, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 255, 0));
                this.aflk = false;
            }
            else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
        }
        if (this.dropf == 0) {
            if (this.opselect == 3) {
                if (this.shaded) {
                    this.rd.setColor(new Color(140, 70, 0));
                    this.rd.fillRect(348, 346, 102, 22);
                    this.aflk = false;
                }
                if (this.aflk) {
                    this.rd.setColor(new Color(200, 64, 0));
                    this.aflk = false;
                }
                else {
                    this.rd.setColor(new Color(255, 128, 0));
                    this.aflk = true;
                }
                this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
            }
            else {
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
            }
        }
        this.rd.drawImage(this.opti2, 346, 265 + this.dropf, null);
        if (this.dropf != 0) {
            this.rd.setColor(new Color(58, 30, 8));
            this.rd.fillRect(357, 365, 87, 15);
        }
        if (control.enter || control.handb) {
            this.mtop = false;
            if (this.opselect == 0) {
                this.multion = 0;
                this.clangame = 0;
                this.gmode = 1;
                this.fase = -9;
            }
            if (this.opselect == 1) {
                this.multion = 0;
                this.clangame = 0;
                this.gmode = 2;
                this.fase = -9;
                this.opselect = 0;
            }
            if (this.dropf == 0 && this.opselect == 3) {
                this.multion = 0;
                this.clangame = 0;
                this.gmode = 0;
                this.fase = -9;
                this.opselect = 0;
            }
            if (this.opselect == 2) {
                this.multion = 1;
                this.gmode = 0;
                if (this.firstime) {
                    this.oldfase = -9;
                    this.fase = 11;
                    this.firstime = false;
                }
                else {
                    this.fase = -9;
                }
            }
            this.flipo = 0;
            control.enter = false;
            control.handb = false;
        }
        this.rd.drawImage(this.byrd, 72, 410, null);
        this.rd.drawImage(this.nfmcoms, 567, 410, null);
        boolean b = false;
        if (n3 == 2) {
            b = true;
        }
        if (this.drawcarb(true, null, "   < Back   ", 161, 313, n, n2, b)) {
            this.opselect = 0;
            this.fase = 10;
        }
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException ex) {}
        }
    }

    public void pausedgame(final int n, final Control control, final Record record) {
        if (!this.badmac) {
            this.rd.drawImage(this.fleximg, 0, 0, null);
        }
        else {
            this.rd.setColor(new Color(30, 67, 110));
            this.rd.fillRect(281, 8, 237, 188);
        }
        if (control.up) {
            --this.opselect;
            if (this.opselect == -1) {
                this.opselect = 3;
            }
            control.up = false;
        }
        if (control.down) {
            ++this.opselect;
            if (this.opselect == 4) {
                this.opselect = 0;
            }
            control.down = false;
        }
        if (this.opselect == 0) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(329, 45, 137, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            }
            else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(329, 45, 137, 22, 7, 20);
        }
        if (this.opselect == 1) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(320, 73, 155, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            }
            else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(320, 73, 155, 22, 7, 20);
        }
        if (this.opselect == 2) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(303, 99, 190, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            }
            else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(303, 99, 190, 22, 7, 20);
        }
        if (this.opselect == 3) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(341, 125, 109, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            }
            else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(341, 125, 109, 22, 7, 20);
        }
        this.rd.drawImage(this.paused, 281, 8, null);
        if (control.enter || control.handb) {
            if (this.opselect == 0) {
                if (this.loadedt && !this.mutem) {
                    this.strack.resume();
                }
                this.fase = 0;
            }
            if (this.opselect == 1) {
                if (record.caught >= 300) {
                    if (this.loadedt && !this.mutem) {
                        this.strack.resume();
                    }
                    this.fase = -1;
                }
                else {
                    this.fase = -8;
                }
            }
            if (this.opselect == 2) {
                if (this.loadedt) {
                    this.strack.stop();
                }
                this.oldfase = -7;
                this.fase = 11;
            }
            if (this.opselect == 3) {
                if (this.loadedt) {
                    this.strack.unload();
                }
                this.fase = 102;
                if (this.gmode == 0) {
                    this.opselect = 3;
                }
                if (this.gmode == 1) {
                    this.opselect = 0;
                }
                if (this.gmode == 2) {
                    this.opselect = 1;
                }
                this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void replyn() {
        if (this.aflk) {
            this.drawcs(30, "Replay  > ", 0, 0, 0, 0);
            this.aflk = false;
        }
        else {
            this.drawcs(30, "Replay  >>", 0, 128, 255, 0);
            this.aflk = true;
        }
    }

    public void cantreply() {
        this.rd.setColor(new Color(64, 143, 223));
        this.rd.fillRoundRect(200, 73, 400, 23, 7, 20);
        this.rd.setColor(new Color(0, 89, 223));
        this.rd.drawRoundRect(200, 73, 400, 23, 7, 20);
        this.drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void nofocus() {
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(0, 0, 800, 20);
        this.rd.fillRect(0, 0, 20, 450);
        this.rd.fillRect(0, 430, 800, 20);
        this.rd.fillRect(780, 0, 20, 450);
        this.rd.setColor(new Color(192, 192, 192));
        this.rd.drawRect(20, 20, 760, 410);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRect(22, 22, 756, 406);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
        this.drawcs(445, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
    }

    public void inishcarselect(final ContO[] array) {
        this.nplayers = 7;
        this.im = 0;
        this.xstart[0] = 0;
        this.xstart[1] = -350;
        this.xstart[2] = 350;
        this.xstart[3] = 0;
        this.xstart[4] = -350;
        this.xstart[5] = 350;
        this.xstart[6] = 0;
        this.zstart[0] = -760;
        this.zstart[1] = -380;
        this.zstart[2] = -380;
        this.zstart[3] = 0;
        this.zstart[4] = 380;
        this.zstart[5] = 380;
        this.zstart[6] = 760;
        this.onmsc = -1;
        this.remi = false;
        this.basefase = 0;
        this.noclass = false;
        if (this.testdrive != 1 && this.testdrive != 2) {
            if (this.gmode != 0) {
                this.cfase = 0;
                this.sc[0] = this.scm[this.gmode - 1];
            }
            if (this.gmode == 0) {
                this.sc[0] = this.osc;
            }
            if (this.cd.lastload != 1 || this.cfase != 3) {
                this.onmsc = this.sc[0];
            }
            if (this.cfase == 0 && this.sc[0] > 15) {
                this.sc[0] = 15;
                if (this.multion != 0) {
                    this.cfase = -1;
                }
            }
            if (this.onjoin != -1 && this.multion != 0) {
                if (this.ontyp <= -2) {
                    this.cfase = 0;
                }
                if (this.ontyp >= 20) {
                    this.ontyp -= 20;
                    this.cfase = 0;
                }
                if (this.ontyp >= 10) {
                    this.ontyp -= 10;
                    if (this.cd.lastload != 2) {
                        this.cfase = -1;
                        this.onjoin = -1;
                    }
                    else {
                        this.cfase = 3;
                    }
                }
            }
            if (this.cfase == 11 || this.cfase == 101) {
                if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                    this.cfase = 3;
                }
                else {
                    this.cfase = 0;
                }
            }
            if (this.cfase == 3) {
                if (this.multion != 0 && this.cd.lastload == 1) {
                    this.sc[0] = 15;
                    this.minsl = 0;
                    this.maxsl = 15;
                    this.cfase = 0;
                }
                if (this.cd.lastload == 0) {
                    this.sc[0] = 15;
                    this.minsl = 0;
                    this.maxsl = 15;
                    this.cfase = 0;
                }
                if (this.cd.lastload == 2) {
                    this.minsl = 16;
                    this.maxsl = this.cd.nlocars - 1;
                    if (this.sc[0] < this.minsl) {
                        this.sc[0] = this.minsl;
                    }
                    if (this.sc[0] > this.maxsl) {
                        this.sc[0] = this.maxsl;
                    }
                    if (this.onjoin != -1 && this.multion != 0 && this.ontyp > 0 && this.ontyp <= 5) {
                        int n = 0;
                        for (int i = 16; i < this.cd.nlocars; ++i) {
                            if (Math.abs(this.cd.cclass[i] - (this.ontyp - 1)) <= 1) {
                                if (n == 0) {
                                    this.minsl = i;
                                    n = 1;
                                }
                                if (n != 0) {
                                    this.maxsl = i;
                                }
                            }
                        }
                        if (n == 0) {
                            this.onjoin = -1;
                            this.noclass = true;
                        }
                        else {
                            if (this.sc[0] < this.minsl) {
                                this.sc[0] = this.minsl;
                            }
                            if (this.sc[0] > this.maxsl) {
                                this.sc[0] = this.maxsl;
                            }
                            if (Math.abs(this.cd.cclass[this.sc[0]] - (this.ontyp - 1)) > 1) {
                                this.sc[0] = this.minsl;
                            }
                        }
                    }
                }
                if (this.cd.lastload == -2 && this.logged) {
                    this.cfase = 5;
                    this.showtf = false;
                    this.cd.action = 3;
                    this.cd.sparkactionloader();
                }
            }
            if (this.cfase == 0) {
                this.minsl = 0;
                this.maxsl = 15;
                if (this.onjoin != -1 && this.multion != 0) {
                    if (this.ontyp == 1) {
                        this.minsl = 0;
                        this.maxsl = 5;
                    }
                    if (this.ontyp == 2) {
                        this.minsl = 0;
                        this.maxsl = 9;
                    }
                    if (this.ontyp == 3) {
                        this.minsl = 5;
                        this.maxsl = 10;
                    }
                    if (this.ontyp == 4) {
                        this.minsl = 6;
                        this.maxsl = 15;
                    }
                    if (this.ontyp == 5) {
                        this.minsl = 10;
                        this.maxsl = 15;
                    }
                    if (this.ontyp <= -2) {
                        this.minsl = Math.abs(this.ontyp + 2);
                        this.maxsl = Math.abs(this.ontyp + 2);
                    }
                }
                if (this.sc[0] < this.minsl) {
                    this.sc[0] = this.minsl;
                }
                if (this.sc[0] > this.maxsl) {
                    this.sc[0] = this.maxsl;
                }
            }
        }
        else {
            this.minsl = this.sc[0];
            this.maxsl = this.sc[0];
        }
        this.app.mcars.setBackground(new Color(0, 0, 0));
        this.app.mcars.setForeground(new Color(47, 179, 255));
        this.app.mcars.alphad = true;
        this.app.mcars.carsel = true;
        this.carsbginflex();
        this.flatrstart = 0;
        this.m.lightson = false;
        this.pnext = 0;
        this.pback = 0;
        this.lsc = -1;
        this.mouson = -1;
        if (this.multion == 0) {
            this.app.mycar.setLabel(" Include in this game.");
            this.app.mycar.setBackground(new Color(198, 179, 129));
            this.app.mycar.setForeground(new Color(0, 0, 0));
            int nlocars = 16;
            if (this.cd.lastload == 2) {
                nlocars = this.cd.nlocars;
            }
            for (int j = 0; j < nlocars; ++j) {
                final float[] array2 = new float[3];
                Color.RGBtoHSB(array[j].fcol[0], array[j].fcol[1], array[j].fcol[2], array2);
                for (int k = 0; k < array[j].npl; ++k) {
                    if (array[j].p[k].colnum == 1) {
                        array[j].p[k].hsb[0] = array2[0];
                        array[j].p[k].hsb[1] = array2[1];
                        array[j].p[k].hsb[2] = array2[2];
                        array[j].p[k].oc[0] = array[j].fcol[0];
                        array[j].p[k].oc[1] = array[j].fcol[1];
                        array[j].p[k].oc[2] = array[j].fcol[2];
                    }
                }
                Color.RGBtoHSB(array[j].scol[0], array[j].scol[1], array[j].scol[2], array2);
                for (int l = 0; l < array[j].npl; ++l) {
                    if (array[j].p[l].colnum == 2) {
                        array[j].p[l].hsb[0] = array2[0];
                        array[j].p[l].hsb[1] = array2[1];
                        array[j].p[l].hsb[2] = array2[2];
                        array[j].p[l].oc[0] = array[j].scol[0];
                        array[j].p[l].oc[1] = array[j].scol[1];
                        array[j].p[l].oc[2] = array[j].scol[2];
                    }
                }
                array[j].xy = 0;
            }
            for (int n2 = 0; n2 < 6; ++n2) {
                this.arnp[n2] = -1.0f;
            }
        }
        this.m.trk = 0;
        this.m.crs = true;
        this.m.x = -400;
        this.m.y = -525;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 10;
        this.m.ground = 495;
        this.m.ih = 0;
        this.m.iw = 0;
        this.m.h = 450;
        this.m.w = 800;
        this.m.focus_point = 400;
        this.m.cx = 400;
        this.m.cy = 225;
        this.m.cz = 50;
        if (this.multion == 0) {
            this.intertrack.loadimod(false);
            this.intertrack.play();
        }
    }

    public void carselect(final Control control, final ContO[] array, final Mad mad, final int n, final int n2, final boolean b) {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
        if (this.flatrstart == 6) {
            if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
                this.rd.drawImage(this.carsbgc, 65, 25, null);
            }
            else {
                this.rd.drawImage(this.carsbg, 65, 25, null);
            }
        }
        else if (this.flatrstart <= 1) {
            this.drawSmokeCarsbg();
        }
        else {
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRect(65, 25, 670, 400);
            this.carsbginflex();
            this.flatrstart = 6;
        }
        this.rd.drawImage(this.selectcar, 321, 37, null);
        if (this.cfase == 3 || this.cfase == 7 || this.remi) {
            if (this.cd.lastload == 1) {
                this.rd.drawImage(this.ycmc, 337, 58, null);
            }
            if (this.cd.lastload == 2) {
                this.rd.drawImage(this.yac, 323, 58, null);
            }
        }
        if (this.cfase == 11) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            String s = "Top 20 Cars";
            int i = this.cd.loadlist;
            String s2 = "Weekly";
            while (i > 6) {
                i -= 6;
                if (s2.equals("Semi-Annual")) {
                    s2 = "Annual";
                }
                if (s2.equals("Monthly")) {
                    s2 = "Semi-Annual";
                }
                if (s2.equals("Weekly")) {
                    s2 = "Monthly";
                }
            }
            if (i == 1) {
                s = "" + s2 + " Top 20 Cars";
            }
            if (i == 2) {
                s = "" + s2 + " Top 20 Class A Cars";
            }
            if (i == 3) {
                s = "" + s2 + " Top 20 Class A & B Cars";
            }
            if (i == 4) {
                s = "" + s2 + " Top 20 Class B Cars";
            }
            if (i == 5) {
                s = "" + s2 + " Top 20 Class B & C Cars";
            }
            if (i == 6) {
                s = "" + s2 + " Top 20 Class C Cars";
            }
            this.drawcs(69, s, 120, 176, 255, 3);
        }
        if (this.cfase == 101) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(69, "" + this.cd.viewname + "'s account cars!", 220, 112, 33, 3);
        }
        if (!this.remi) {
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            array[this.sc[0]].d(this.rd);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        if (this.cfase == 8) {
            this.drawprom(150, 85);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(195, "Removing Car...", 0, 0, 0, 3);
            if (this.cd.action != 10) {
                if (this.cd.action != -10) {
                    this.cfase = 5;
                    this.showtf = false;
                }
                else {
                    this.cfase = 9;
                }
            }
        }
        if ((this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) && this.lsc != this.sc[0]) {
            if (array[this.sc[0]].xy != 0) {
                array[this.sc[0]].xy = 0;
            }
            for (int n3 = 0, n4 = 0; n4 < array[this.sc[0]].npl && n3 == 0; ++n4) {
                if (array[this.sc[0]].p[n4].colnum == 1) {
                    final float[] array2 = new float[3];
                    Color.RGBtoHSB(array[this.sc[0]].p[n4].c[0], array[this.sc[0]].p[n4].c[1], array[this.sc[0]].p[n4].c[2], array2);
                    this.arnp[0] = array2[0];
                    this.arnp[1] = array2[1];
                    this.arnp[2] = 1.0f - array2[2];
                    n3 = 1;
                }
            }
            for (int n5 = 0, n6 = 0; n6 < array[this.sc[0]].npl && n5 == 0; ++n6) {
                if (array[this.sc[0]].p[n6].colnum == 2) {
                    final float[] array3 = new float[3];
                    Color.RGBtoHSB(array[this.sc[0]].p[n6].c[0], array[this.sc[0]].p[n6].c[1], array[this.sc[0]].p[n6].c[2], array3);
                    this.arnp[3] = array3[0];
                    this.arnp[4] = array3[1];
                    this.arnp[5] = 1.0f - array3[2];
                    n5 = 1;
                }
            }
            final Color hsbColor = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0f - this.arnp[2]);
            final Color hsbColor2 = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0f - this.arnp[5]);
            for (int j = 0; j < array[this.sc[0]].npl; ++j) {
                if (array[this.sc[0]].p[j].colnum == 1) {
                    array[this.sc[0]].p[j].hsb[0] = this.arnp[0];
                    array[this.sc[0]].p[j].hsb[1] = this.arnp[1];
                    array[this.sc[0]].p[j].hsb[2] = 1.0f - this.arnp[2];
                    array[this.sc[0]].p[j].c[0] = hsbColor.getRed();
                    array[this.sc[0]].p[j].c[1] = hsbColor.getGreen();
                    array[this.sc[0]].p[j].c[2] = hsbColor.getBlue();
                    array[this.sc[0]].p[j].oc[0] = hsbColor.getRed();
                    array[this.sc[0]].p[j].oc[1] = hsbColor.getGreen();
                    array[this.sc[0]].p[j].oc[2] = hsbColor.getBlue();
                }
                if (array[this.sc[0]].p[j].colnum == 2) {
                    array[this.sc[0]].p[j].hsb[0] = this.arnp[3];
                    array[this.sc[0]].p[j].hsb[1] = this.arnp[4];
                    array[this.sc[0]].p[j].hsb[2] = 1.0f - this.arnp[5];
                    array[this.sc[0]].p[j].c[0] = hsbColor2.getRed();
                    array[this.sc[0]].p[j].c[1] = hsbColor2.getGreen();
                    array[this.sc[0]].p[j].c[2] = hsbColor2.getBlue();
                    array[this.sc[0]].p[j].oc[0] = hsbColor2.getRed();
                    array[this.sc[0]].p[j].oc[1] = hsbColor2.getGreen();
                    array[this.sc[0]].p[j].oc[2] = hsbColor2.getBlue();
                }
            }
            this.lsc = this.sc[0];
        }
        int n7 = -1;
        int n8 = 0;
        boolean b2 = false;
        if (this.flipo == 0) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            int n9 = 0;
            if (this.flatrstart < 6) {
                n9 = 2;
            }
            if (!this.remi && (this.cfase != 10 || (this.cd.action != 0 && this.cd.action < 14))) {
                if (this.cfase == 3 && this.cd.lastload == 2) {
                    this.app.mcars.move(400 - this.app.mcars.w / 2, 78);
                    this.app.mcars.show = true;
                    if (!this.app.mcars.getSelectedItem().equals(this.cd.names[this.sc[0]])) {
                        for (int k = 16; k < this.cd.nlocars; ++k) {
                            if (this.cd.names[k].equals(this.app.mcars.getSelectedItem())) {
                                n7 = k;
                            }
                        }
                        if (n7 == -1) {
                            this.cfase = 5;
                            this.cd.action = 4;
                            this.cd.sparkactionloader();
                        }
                    }
                }
                else {
                    this.app.mcars.show = false;
                    String string = "";
                    if (this.cfase == 11) {
                        string = "N#" + (this.sc[0] - 35) + "  ";
                    }
                    if (this.aflk) {
                        this.drawcs(95 + n9, string + this.cd.names[this.sc[0]], 240, 240, 240, 3);
                        this.aflk = false;
                    }
                    else {
                        this.drawcs(95, string + this.cd.names[this.sc[0]], 176, 176, 176, 3);
                        this.aflk = true;
                    }
                }
            }
            else {
                this.app.mcars.show = false;
            }
            array[this.sc[0]].z = 950;
            if (this.sc[0] == 13) {
                array[this.sc[0]].z = 1000;
            }
            array[this.sc[0]].y = -34 - array[this.sc[0]].grat;
            array[this.sc[0]].x = 0;
            if (this.mouson >= 0 && this.mouson <= 3) {
                final ContO contO = array[this.sc[0]];
                contO.xz += 2;
            }
            else {
                final ContO contO2 = array[this.sc[0]];
                contO2.xz += 5;
            }
            if (array[this.sc[0]].xz > 360) {
                final ContO contO3 = array[this.sc[0]];
                contO3.xz -= 360;
            }
            array[this.sc[0]].zy = 0;
            final ContO contO4 = array[this.sc[0]];
            contO4.wzy -= 10;
            if (array[this.sc[0]].wzy < -30) {
                final ContO contO5 = array[this.sc[0]];
                contO5.wzy += 30;
            }
            if (!this.remi) {
                if (this.sc[0] != this.minsl) {
                    this.rd.drawImage(this.back[this.pback], 95, 275, null);
                }
                if (this.sc[0] != this.maxsl) {
                    this.rd.drawImage(this.next[this.pnext], 645, 275, null);
                }
            }
            if (this.gmode == 1) {
                if (this.sc[0] == 5 && this.unlocked[0] <= 2) {
                    n8 = 2;
                }
                if (this.sc[0] == 6 && this.unlocked[0] <= 4) {
                    n8 = 4;
                }
                if (this.sc[0] == 11 && this.unlocked[0] <= 6) {
                    n8 = 6;
                }
                if (this.sc[0] == 14 && this.unlocked[0] <= 8) {
                    n8 = 8;
                }
                if (this.sc[0] == 15 && this.unlocked[0] <= 10) {
                    n8 = 10;
                }
            }
            if (this.gmode == 2 && this.sc[0] >= 8 && this.unlocked[1] <= (this.sc[0] - 7) * 2) {
                n8 = (this.sc[0] - 7) * 2;
            }
            if (n8 != 0) {
                if (this.gatey == 300) {
                    for (int l = 0; l < 9; ++l) {
                        this.pgas[l] = false;
                        this.pgady[l] = 0;
                    }
                    this.pgas[0] = true;
                }
                for (int n10 = 0; n10 < 9; ++n10) {
                    this.rd.drawImage(this.pgate, this.pgatx[n10], this.pgaty[n10] + this.pgady[n10] - this.gatey, null);
                    if (this.flatrstart == 6) {
                        if (this.pgas[n10]) {
                            final int[] pgady = this.pgady;
                            final int n11 = n10;
                            pgady[n11] -= (80 + 100 / (n10 + 1) - Math.abs(this.pgady[n10])) / 3;
                            if (this.pgady[n10] < -(70 + 100 / (n10 + 1))) {
                                this.pgas[n10] = false;
                                if (n10 != 8) {
                                    this.pgas[n10 + 1] = true;
                                }
                            }
                        }
                        else {
                            final int[] pgady2 = this.pgady;
                            final int n12 = n10;
                            pgady2[n12] += (80 + 100 / (n10 + 1) - Math.abs(this.pgady[n10])) / 3;
                            if (this.pgady[n10] > 0) {
                                this.pgady[n10] = 0;
                            }
                        }
                    }
                }
                if (this.gatey != 0) {
                    this.gatey -= 100;
                }
                if (this.flatrstart == 6) {
                    this.drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
                    this.drawcs(375, "This car unlocks when stage " + n8 + " is completed...", 255, 96, 0, 3);
                }
            }
            else {
                if (this.flatrstart == 6) {
                    if (this.cfase == 10) {
                        if (this.cd.action == 13) {
                            this.minsl = 36;
                            this.maxsl = this.cd.xnlocars - 1;
                            n7 = 36;
                            this.cd.action = 0;
                            this.cfase = 11;
                        }
                        if (this.cd.action == 12) {
                            int loadlist = this.cd.loadlist;
                            String s3 = "Top 20 Cars";
                            String s4 = "Weekly";
                            while (loadlist > 6) {
                                loadlist -= 6;
                                if (s4.equals("Semi-Annual")) {
                                    s4 = "Annual";
                                }
                                if (s4.equals("Monthly")) {
                                    s4 = "Semi-Annual";
                                }
                                if (s4.equals("Weekly")) {
                                    s4 = "Monthly";
                                }
                            }
                            if (loadlist == 1) {
                                s3 = "" + s4 + " Top 20 Cars";
                            }
                            if (loadlist == 2) {
                                s3 = "" + s4 + " Top 20 Class A Cars";
                            }
                            if (loadlist == 3) {
                                s3 = "" + s4 + " Top 20 Class A & B Cars";
                            }
                            if (loadlist == 4) {
                                s3 = "" + s4 + " Top 20 Class B Cars";
                            }
                            if (loadlist == 5) {
                                s3 = "" + s4 + " Top 20 Class B & C Cars";
                            }
                            if (loadlist == 6) {
                                s3 = "" + s4 + " Top 20 Class C Cars";
                            }
                            this.drawprom(145, 170);
                            this.drawcs(195, "[  Loading " + s3 + "  ]", 0, 0, 0, 3);
                            if (this.cd.nl > 0 && this.cd.nl <= 20) {
                                this.drawcs(235, "Loading :  " + this.cd.loadnames[this.cd.nl - 1] + "", 0, 0, 0, 3);
                            }
                        }
                        if (this.cd.action == 11) {
                            this.drawprom(145, 170);
                            this.drawcs(195, "Loading List, Please Wait...", 0, 0, 0, 3);
                        }
                        if (this.cd.action == -1) {
                            this.drawprom(145, 170);
                            this.drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
                            this.drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, "   OK   ", 371, 255, n, n2, b)) {
                                this.cd.action = 0;
                                this.cfase = this.basefase;
                            }
                        }
                        if (this.cd.action == 0 || this.cd.action == 14 || this.cd.action == 15 || this.cd.action == 16 || this.cd.action == 17) {
                            this.drawprom(65, 250);
                            if (this.drawcarb(true, null, " X ", 557, 70, n, n2, b)) {
                                this.cd.action = 0;
                                this.cfase = this.basefase;
                            }
                            this.drawcs(305, "The lists get updated every 24 hours!", 0, 0, 0, 3);
                            if (this.cd.action == 14 || this.cd.action == 15 || this.cd.action == 16 || this.cd.action == 17) {
                                if (!b && this.cntflock == 20) {
                                    this.cntflock = 0;
                                }
                                if (this.cd.action == 14) {
                                    this.drawcs(91, "Weekly Top 20 Cars", 0, 0, 0, 3);
                                }
                                if (this.cd.action == 15) {
                                    this.drawcs(91, "Monthly Top 20 Cars", 0, 0, 0, 3);
                                }
                                if (this.cd.action == 16) {
                                    this.drawcs(91, "Semi-Annual Top 20 Cars", 0, 0, 0, 3);
                                }
                                if (this.cd.action == 17) {
                                    this.drawcs(91, "Annual Top 20 Cars", 0, 0, 0, 3);
                                }
                                if (this.drawcarb(true, null, "   All Cars, All Classes   ", 318, 105, n, n2, b) && this.cntflock == 0) {
                                    this.cd.loadlist = 1 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (this.drawcarb(true, null, "Class A Cars", 337, 135, n, n2, b) && this.cntflock == 0) {
                                    this.cd.loadlist = 2 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (this.drawcarb(true, null, "Class A & B Cars", 337, 165, n, n2, b) && this.cntflock == 0) {
                                    this.cd.loadlist = 3 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (this.drawcarb(true, null, "Class B Cars", 337, 195, n, n2, b) && this.cntflock == 0) {
                                    this.cd.loadlist = 4 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (this.drawcarb(true, null, "Class B & C Cars", 337, 225, n, n2, b) && this.cntflock == 0) {
                                    this.cd.loadlist = 5 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (this.drawcarb(true, null, "Class C Cars", 337, 255, n, n2, b) && this.cntflock == 0) {
                                    this.cd.loadlist = 6 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                            }
                            if (this.cd.action == 0) {
                                this.drawcs(91, "Top 20 Most Added Public Custom Cars", 0, 0, 0, 3);
                                if (this.drawcarb(true, null, "  Weekly Top 20  ", 338, 125, n, n2, b)) {
                                    this.cd.action = 14;
                                }
                                if (this.drawcarb(true, null, "  Monthly Top 20  ", 337, 165, n, n2, b)) {
                                    this.cd.action = 15;
                                }
                                if (this.drawcarb(true, null, "  Semi-Annual Top 20  ", 321, 205, n, n2, b)) {
                                    this.cd.action = 16;
                                }
                                if (this.drawcarb(true, null, "  Annual Top 20  ", 339, 245, n, n2, b)) {
                                    this.cd.action = 17;
                                }
                                if (this.cntflock != 20) {
                                    this.cntflock = 20;
                                }
                            }
                        }
                    }
                    if (this.cfase == 100) {
                        if (this.cd.action == -1) {
                            this.drawprom(145, 170);
                            this.drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
                            this.drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, "   OK   ", 371, 255, n, n2, b)) {
                                if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                                    this.cfase = 3;
                                }
                                else {
                                    this.cfase = 0;
                                }
                            }
                        }
                        if (this.cd.action == -2) {
                            this.drawprom(145, 170);
                            this.drawcs(195, "No account cars found.", 0, 0, 0, 3);
                            this.drawcs(225, "" + this.cd.viewname + " does not have any published or added cars.", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, "   OK   ", 371, 255, n, n2, b)) {
                                if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                                    this.cfase = 3;
                                }
                                else {
                                    this.cfase = 0;
                                }
                            }
                        }
                        if (this.cd.action == 100) {
                            this.cd.action = 101;
                            this.cd.sparkactionloader();
                        }
                        if (this.cd.action == 101) {
                            this.drawprom(145, 170);
                            this.drawcs(195, "Loading " + this.cd.viewname + "'s account cars, please wait...", 0, 0, 0, 3);
                        }
                        if (this.cd.action == 102) {
                            this.drawprom(145, 170);
                            this.drawcs(195, "Loading " + this.cd.viewname + "'s account cars, please wait...", 0, 0, 0, 3);
                            if (this.cd.nl > 0 && this.cd.nl <= 20) {
                                this.drawcs(235, "Loading :  " + this.cd.loadnames[this.cd.nl - 1] + "", 0, 0, 0, 3);
                            }
                        }
                        if (this.cd.action == 103) {
                            this.minsl = 36;
                            this.maxsl = this.cd.xnlocars - 1;
                            n7 = 36;
                            this.cd.action = 0;
                            this.cfase = 101;
                        }
                    }
                    if (this.cfase == 0 && this.testdrive != 1 && this.testdrive != 2 && this.gmode == 0) {
                        int n13 = 95;
                        int n14 = 5;
                        if (this.multion != 0) {
                            n13 = 185;
                            n14 = 0;
                        }
                        if (this.multion == 0 && this.drawcarb(false, this.cmc, "", 95, 70, n, n2, b)) {
                            if (this.cd.lastload != 1) {
                                this.cfase = 1;
                            }
                            else {
                                this.minsl = 16;
                                this.maxsl = this.cd.nlcars - 1;
                                n7 = 16;
                                this.cfase = 3;
                            }
                        }
                        if (this.drawcarb(false, this.myc, "", n13, 105 + n14, n, n2, b)) {
                            if (this.cd.lastload != 2) {
                                this.cfase = 5;
                                this.showtf = false;
                                if (!this.logged) {
                                    this.cd.action = 0;
                                    this.cd.reco = -2;
                                    this.tcnt = 5;
                                    this.cntflock = 0;
                                }
                                else {
                                    this.cd.action = 3;
                                    this.cd.sparkactionloader();
                                }
                            }
                            else {
                                this.minsl = 16;
                                this.maxsl = this.cd.nlocars - 1;
                                if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                    n7 = this.onmsc;
                                }
                                else {
                                    n7 = 16;
                                }
                                this.cfase = 3;
                            }
                        }
                        if ((this.multion == 0 || this.onjoin == -1) && this.drawcarb(false, this.top20s, "", n13, (n13 - 95) / 7 + 25 + n14, n, n2, b)) {
                            this.cd.action = 0;
                            this.cfase = 10;
                        }
                        if (this.remi) {
                            this.remi = false;
                        }
                    }
                    if (this.cfase == -1) {
                        if (this.autolog) {
                            this.autolog = false;
                            this.cfase = 5;
                            this.cd.action = 1;
                            this.cd.sparkactionloader();
                        }
                        else if (this.cd.lastload != 2) {
                            this.cfase = 5;
                            this.showtf = false;
                            if (!this.logged) {
                                this.cd.action = 0;
                                this.cd.reco = -2;
                                this.tcnt = 5;
                                this.cntflock = 0;
                            }
                            else {
                                this.cd.action = 3;
                                this.cd.sparkactionloader();
                            }
                        }
                        else {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlocars - 1;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                n7 = this.onmsc;
                            }
                            else {
                                n7 = 16;
                            }
                            this.cfase = 3;
                        }
                    }
                    if (this.cfase == 9) {
                        this.drawprom(145, 95);
                        this.drawcs(175, "Failed to remove car.  Unkown Error.  Try again laster.", 0, 0, 0, 3);
                        if (this.drawcarb(true, null, "   OK   ", 371, 195, n, n2, b)) {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlocars - 1;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                n7 = this.onmsc;
                            }
                            else {
                                n7 = 16;
                            }
                            this.cfase = 3;
                        }
                    }
                    if (this.cfase == 7) {
                        if (this.app.mycar.isShowing()) {
                            this.app.mycar.setVisible(true);
                        }
                        this.drawprom(145, 95);
                        this.drawcs(175, "Remove this car from your account?", 0, 0, 0, 3);
                        if (this.drawcarb(true, null, " Yes ", 354, 195, n, n2, b)) {
                            this.remi = true;
                            this.minsl = 0;
                            this.maxsl = 15;
                            n7 = 15;
                            this.cfase = 8;
                            this.onmsc = this.sc[0];
                            this.cd.ac = this.sc[0];
                            this.cd.action = 10;
                            this.cd.sparkactionloader();
                        }
                        if (this.drawcarb(true, null, " No ", 408, 195, n, n2, b)) {
                            this.cfase = 3;
                        }
                    }
                    if (this.cfase == 3 && n7 == -1) {
                        int n15 = 95;
                        int n16 = 5;
                        if (this.multion != 0) {
                            n15 = 185;
                            n16 = 0;
                        }
                        if (this.drawcarb(false, this.gac, "", n15, 105 + n16, n, n2, b)) {
                            this.minsl = 0;
                            this.maxsl = 15;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                n7 = this.onmsc;
                            }
                            else {
                                n7 = 15;
                            }
                            this.cfase = 0;
                        }
                        if (this.multion == 0) {
                            if (!this.app.openm) {
                                if (!this.app.mycar.isShowing()) {
                                    this.app.mycar.setVisible(true);
                                    this.app.mycar.setState(this.cd.include[this.sc[0] - 16]);
                                }
                            }
                            else {
                                this.app.mycar.setVisible(false);
                            }
                            this.rd.setColor(new Color(198, 179, 129));
                            this.rd.fillRoundRect(305, 302, 190, 24, 7, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(305, 302, 190, 24, 7, 20);
                            this.app.movefield(this.app.mycar, 334, 306, 150, 17);
                            if (this.app.mycar.getState() != this.cd.include[this.sc[0] - 16]) {
                                this.cd.include[this.sc[0] - 16] = this.app.mycar.getState();
                                this.app.requestFocus();
                            }
                        }
                        if ((this.multion == 0 || this.onjoin == -1) && this.drawcarb(false, this.top20s, "", n15, (n15 - 95) / 7 + 25 + n16, n, n2, b)) {
                            this.cd.action = 0;
                            this.cfase = 10;
                            if (this.app.mycar.isShowing()) {
                                this.app.mycar.setVisible(false);
                            }
                        }
                        if (this.cd.lastload == 2) {
                            if (this.drawcarb(true, null, "X", 567, 135, n, n2, b)) {
                                this.cfase = 7;
                            }
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            if (!this.cd.createdby[this.sc[0] - 16].equals(this.nickname)) {
                                b2 = this.clink(this.cd.createdby[this.sc[0] - 16], n, n2, b);
                            }
                            else {
                                this.rd.drawString("Created by You", 241, 160);
                            }
                        }
                        if (this.remi) {
                            this.remi = false;
                        }
                        if (this.noclass) {
                            this.drawprom(200, 95);
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            String s5 = "Class C";
                            if (this.ontyp == 2) {
                                s5 = "Class B or C";
                            }
                            if (this.ontyp == 3) {
                                s5 = "Class B";
                            }
                            if (this.ontyp == 4) {
                                s5 = "Class A or B";
                            }
                            if (this.ontyp == 5) {
                                s5 = "Class A";
                            }
                            this.drawcs(230, "You do not have a " + s5 + " car in your account cars.", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, "   OK   ", 371, 250, n, n2, b)) {
                                this.noclass = false;
                            }
                        }
                    }
                    if ((this.cfase == 11 || this.cfase == 101) && n7 == -1) {
                        if (this.cd.action == -9) {
                            this.drawprom(145, 95);
                            this.drawcs(175, "Unknown error!  Failed to add car.  Try again later.", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, " OK ", 379, 195, n, n2, b)) {
                                this.cd.action = 0;
                            }
                        }
                        if (this.cd.action == -8) {
                            this.drawprom(145, 95);
                            this.drawcs(175, "Failed.  You already have 20 cars in your account!", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, " OK ", 379, 195, n, n2, b)) {
                                this.cd.action = 0;
                            }
                        }
                        if (this.cd.action == -7) {
                            this.drawprom(145, 95);
                            this.drawcs(175, "You already have this car!", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, " OK ", 379, 195, n, n2, b)) {
                                this.cd.action = 0;
                            }
                        }
                        if (this.cd.action == 7) {
                            this.drawprom(145, 95);
                            this.drawcs(175, "" + this.cd.names[this.cd.ac] + " has been successfully added to your cars!", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, " OK ", 379, 195, n, n2, b)) {
                                this.cd.action = 0;
                            }
                        }
                        if (this.cd.action == 6) {
                            this.drawprom(145, 95);
                            this.drawcs(195, "Adding " + this.cd.names[this.cd.ac] + " to your cars...", 0, 0, 0, 3);
                        }
                        int n17 = 95;
                        int n18 = 5;
                        if (this.multion != 0) {
                            n17 = 185;
                            n18 = 0;
                        }
                        if (this.onmsc >= 16 && (this.cd.lastload == 2 || this.cd.lastload == -2)) {
                            if (this.drawcarb(false, this.myc, "", n17, 105 + n18, n, n2, b)) {
                                if (this.cd.lastload != 2) {
                                    this.cfase = 5;
                                    this.showtf = false;
                                    if (!this.logged) {
                                        this.cd.action = 0;
                                        this.cd.reco = -2;
                                        this.tcnt = 5;
                                        this.cntflock = 0;
                                    }
                                    else {
                                        this.cd.action = 3;
                                        this.cd.sparkactionloader();
                                    }
                                }
                                else {
                                    this.cd.action = 0;
                                    this.minsl = 16;
                                    this.maxsl = this.cd.nlocars - 1;
                                    if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                        n7 = this.onmsc;
                                    }
                                    else {
                                        n7 = 16;
                                    }
                                    this.cfase = 3;
                                }
                                this.app.moused = false;
                            }
                        }
                        else if (this.drawcarb(false, this.gac, "", n17, 105 + n18, n, n2, b)) {
                            this.cd.action = 0;
                            this.minsl = 0;
                            this.maxsl = 15;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                n7 = this.onmsc;
                            }
                            else {
                                n7 = 15;
                            }
                            this.cfase = 0;
                            this.app.moused = false;
                        }
                        if (this.drawcarb(false, this.top20s, "", n17, (n17 - 95) / 7 + 25 + n18, n, n2, b)) {
                            this.cd.action = 0;
                            this.cfase = 10;
                        }
                        if (this.cd.action == 0) {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            if (!this.cd.createdby[this.sc[0] - 16].equals(this.nickname)) {
                                b2 = this.clink(this.cd.createdby[this.sc[0] - 16], n, n2, b);
                            }
                            else {
                                this.rd.drawString("Created by You", 241, 160);
                            }
                            if (this.cfase != 101) {
                                this.rd.setFont(new Font("Arial", 1, 11));
                                this.rd.drawString("Added by :  " + this.cd.adds[this.sc[0] - 36] + " Players", 241, 180);
                            }
                        }
                    }
                    if (this.cfase == 5) {
                        this.drawprom(145, 170);
                        if (this.cd.action == 5) {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlocars - 1;
                            if (this.cd.inslot != -1) {
                                this.onmsc = this.cd.inslot;
                                this.cd.inslot = -1;
                            }
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                n7 = this.onmsc;
                            }
                            else {
                                n7 = 16;
                            }
                            this.cfase = 3;
                        }
                        if (this.cd.action == 4) {
                            this.drawcs(195, "[  Loading Car  ]", 0, 0, 0, 3);
                            this.drawcs(235, "Loading :  " + this.app.mcars.getSelectedItem() + "", 0, 0, 0, 3);
                        }
                        if (this.cd.action == -2) {
                            this.drawcs(195, "Unknown Connection Error", 0, 0, 0, 3);
                            this.drawcs(225, "Failed to connect to server, try again later!", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, "   OK   ", 371, 255, n, n2, b)) {
                                this.cfase = 0;
                            }
                        }
                        if (this.cd.action == -1) {
                            this.drawcs(195, "No published cars found...", 0, 0, 0, 3);
                            this.drawcs(225, "You have no added cars to your account yet!", 0, 0, 0, 3);
                            if (this.drawcarb(true, null, "   OK   ", 371, 255, n, n2, b)) {
                                this.cfase = 0;
                            }
                        }
                        if (this.cd.action == 2 || this.cd.action == 3) {
                            this.drawcs(195, "Loading your Account Cars list...", 0, 0, 0, 3);
                            if (this.cd.action == 2) {
                                this.nickname = this.app.tnick.getText();
                                this.backlog = this.nickname;
                                this.nickey = this.cd.tnickey;
                                this.clan = this.cd.tclan;
                                this.clankey = this.cd.tclankey;
                                this.app.setloggedcookie();
                                this.logged = true;
                                this.gotlog = true;
                                if (this.cd.reco == 0) {
                                    this.acexp = 0;
                                }
                                if (this.cd.reco > 10) {
                                    this.acexp = this.cd.reco - 10;
                                }
                                if (this.cd.reco == 3) {
                                    this.acexp = -1;
                                }
                                if (this.cd.reco == 111) {
                                    if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) {
                                        this.acexp = -3;
                                    }
                                    else {
                                        this.acexp = 0;
                                    }
                                }
                                if (this.basefase == 0) {
                                    this.cd.action = 3;
                                }
                                if (this.basefase == 11) {
                                    this.cd.action = 6;
                                    this.cfase = 11;
                                }
                                if (this.basefase == 101) {
                                    this.cd.action = 6;
                                    this.cfase = 101;
                                }
                            }
                        }
                        if (this.cd.action == 1) {
                            this.drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                        }
                        if (this.cd.action == 0) {
                            if (this.cd.reco == -5) {
                                this.drawcs(171, "Login to Add this Car to your Account", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == -2) {
                                this.drawcs(171, "Login to Retrieve your Account Cars", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == -1) {
                                this.drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                            }
                            if (this.cd.reco == 1) {
                                this.drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == 2) {
                                this.drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == -167 || this.cd.reco == -177) {
                                if (this.cd.reco == -167) {
                                    this.nickname = this.app.tnick.getText();
                                    this.backlog = this.nickname;
                                    this.cd.reco = -177;
                                }
                                this.drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                                this.drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                                this.drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                            }
                            if (!this.showtf) {
                                this.app.tnick.setVisible(true);
                                this.app.tnick.setBackground(new Color(206, 237, 255));
                                if (this.cd.reco != 1) {
                                    if (this.cd.reco != 2) {
                                        this.app.tnick.setText(this.nickname);
                                    }
                                    this.app.tnick.setForeground(new Color(0, 0, 0));
                                }
                                else {
                                    this.app.tnick.setForeground(new Color(255, 0, 0));
                                }
                                this.app.tnick.requestFocus();
                                this.app.tpass.setVisible(true);
                                this.app.tpass.setBackground(new Color(206, 237, 255));
                                if (this.cd.reco != 2) {
                                    if (!this.autolog) {
                                        this.app.tpass.setText("");
                                    }
                                    this.app.tpass.setForeground(new Color(0, 0, 0));
                                }
                                else {
                                    this.app.tpass.setForeground(new Color(255, 0, 0));
                                }
                                if (!this.app.tnick.getText().equals("") && this.cd.reco != 1) {
                                    this.app.tpass.requestFocus();
                                }
                                this.showtf = true;
                            }
                            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                            this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                            this.app.movefieldd(this.app.tnick, 376, 185, 129, 23, true);
                            this.app.movefieldd(this.app.tpass, 376, 215, 129, 23, true);
                            if (this.tcnt < 30) {
                                ++this.tcnt;
                                if (this.tcnt == 30) {
                                    if (this.cd.reco == 2) {
                                        this.app.tpass.setText("");
                                    }
                                    this.app.tnick.setForeground(new Color(0, 0, 0));
                                    this.app.tpass.setForeground(new Color(0, 0, 0));
                                }
                            }
                            if (this.cd.reco != -177) {
                                if (this.drawcarb(true, null, "       Login       ", 347, 247, n, n2, b) && this.tcnt > 5) {
                                    this.tcnt = 0;
                                    if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                                        this.autolog = false;
                                        this.app.tnick.setVisible(false);
                                        this.app.tpass.setVisible(false);
                                        this.app.requestFocus();
                                        this.cd.action = 1;
                                        this.cd.sparkactionloader();
                                    }
                                    else {
                                        if (this.app.tpass.getText().equals("")) {
                                            this.cd.reco = -4;
                                        }
                                        if (this.app.tnick.getText().equals("")) {
                                            this.cd.reco = -3;
                                        }
                                    }
                                }
                            }
                            else if (this.drawcarb(true, null, "  Upgrade to have your own cars!  ", 284, 247, n, n2, b) && this.cntflock == 0) {
                                this.app.editlink(this.nickname, true);
                                this.cntflock = 100;
                            }
                            if (this.drawcarb(true, null, "  Cancel  ", 409, 282, n, n2, b)) {
                                this.app.tnick.setVisible(false);
                                this.app.tpass.setVisible(false);
                                this.app.requestFocus();
                                this.cfase = this.basefase;
                            }
                            if (this.drawcarb(true, null, "  Register!  ", 316, 282, n, n2, b)) {
                                if (this.cntflock == 0) {
                                    this.app.reglink();
                                    this.cntflock = 100;
                                }
                            }
                            else if (this.cntflock != 0) {
                                --this.cntflock;
                            }
                        }
                    }
                    if (this.cfase == 4) {
                        this.drawprom(145, 150);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to find any ready car in your \u2018mycars\u2019 folder!", 215, 175);
                        this.rd.drawString("Please \u2018Test Drive\u2019 your cars in the Car Maker to make", 215, 215);
                        this.rd.drawString("sure they are ready.", 215, 235);
                        if (this.drawcarb(true, null, "   OK   ", 371, 255, n, n2, b)) {
                            this.cfase = 0;
                        }
                    }
                    if (this.cfase == 2) {
                        this.drawprom(165, 70);
                        this.drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
                        this.app.repaint();
                        this.cd.loadcarmaker();
                        if (this.cd.nlcars > 16) {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlcars - 1;
                            n7 = 16;
                            this.cfase = 3;
                        }
                        else {
                            this.cfase = 4;
                        }
                    }
                    if (this.cfase == 1) {
                        this.drawprom(145, 170);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("The game will now load all the cars that can be loaded", 215, 170);
                        this.rd.drawString("from your \u2018mycars\u2019 folder.", 215, 190);
                        this.rd.drawString("If a car is not loaded, then it is not ready (not finished).", 215, 210);
                        this.rd.drawString("Perform a \u2018Test Drive\u2019 on any car to see if it is ready or not.", 215, 230);
                        this.rd.drawString("The maximum number of cars that can be loaded is  40 !", 215, 260);
                        if (this.drawcarb(true, null, "   OK   ", 371, 275, n, n2, b)) {
                            this.cfase = 2;
                        }
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(181, 120, 40));
                    this.rd.drawString("Top Speed:", 98, 343);
                    this.rd.drawImage(this.statb, 162, 337, null);
                    this.rd.drawString("Acceleration:", 88, 358);
                    this.rd.drawImage(this.statb, 162, 352, null);
                    this.rd.drawString("Handling:", 110, 373);
                    this.rd.drawImage(this.statb, 162, 367, null);
                    this.rd.drawString("Stunts:", 495, 343);
                    this.rd.drawImage(this.statb, 536, 337, null);
                    this.rd.drawString("Strength:", 483, 358);
                    this.rd.drawImage(this.statb, 536, 352, null);
                    this.rd.drawString("Endurance:", 473, 373);
                    this.rd.drawImage(this.statb, 536, 367, null);
                    this.rd.setColor(new Color(0, 0, 0));
                    float n19 = (this.cd.swits[this.sc[0]][2] - 220) / 90.0f;
                    if (n19 < 0.2) {
                        n19 = 0.2f;
                    }
                    this.rd.fillRect((int)(162.0f + 156.0f * n19), 337, (int)(156.0f * (1.0f - n19) + 1.0f), 7);
                    float n20 = this.cd.acelf[this.sc[0]][1] * this.cd.acelf[this.sc[0]][0] * this.cd.acelf[this.sc[0]][2] * this.cd.grip[this.sc[0]] / 7700.0f;
                    if (n20 > 1.0f) {
                        n20 = 1.0f;
                    }
                    this.rd.fillRect((int)(162.0f + 156.0f * n20), 352, (int)(156.0f * (1.0f - n20) + 1.0f), 7);
                    final float n21 = this.cd.dishandle[this.sc[0]];
                    this.rd.fillRect((int)(162.0f + 156.0f * n21), 367, (int)(156.0f * (1.0f - n21) + 1.0f), 7);
                    float n22 = (this.cd.airc[this.sc[0]] * this.cd.airs[this.sc[0]] * this.cd.bounce[this.sc[0]] + 28.0f) / 139.0f;
                    if (n22 > 1.0f) {
                        n22 = 1.0f;
                    }
                    this.rd.fillRect((int)(536.0f + 156.0f * n22), 337, (int)(156.0f * (1.0f - n22) + 1.0f), 7);
                    float n23 = (this.cd.moment[this.sc[0]] + 0.5f) / 2.6f;
                    if (n23 > 1.0f) {
                        n23 = 1.0f;
                    }
                    this.rd.fillRect((int)(536.0f + 156.0f * n23), 352, (int)(156.0f * (1.0f - n23) + 1.0f), 7);
                    final float n24 = this.cd.outdam[this.sc[0]];
                    this.rd.fillRect((int)(536.0f + 156.0f * n24), 367, (int)(156.0f * (1.0f - n24) + 1.0f), 7);
                    this.rd.drawImage(this.statbo, 162, 337, null);
                    this.rd.drawImage(this.statbo, 162, 352, null);
                    this.rd.drawImage(this.statbo, 162, 367, null);
                    this.rd.drawImage(this.statbo, 536, 337, null);
                    this.rd.drawImage(this.statbo, 536, 352, null);
                    this.rd.drawImage(this.statbo, 536, 367, null);
                    if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        String s6 = "Class C";
                        if (this.cd.cclass[this.sc[0]] == 1) {
                            s6 = "Class B & C";
                        }
                        if (this.cd.cclass[this.sc[0]] == 2) {
                            s6 = "Class B";
                        }
                        if (this.cd.cclass[this.sc[0]] == 3) {
                            s6 = "Class A & B";
                        }
                        if (this.cd.cclass[this.sc[0]] == 4) {
                            s6 = "Class A";
                        }
                        if (this.kbload < 7) {
                            this.rd.setColor(new Color(0, 0, 0));
                            ++this.kbload;
                        }
                        else {
                            this.rd.setColor(new Color(176, 41, 0));
                            this.kbload = 0;
                        }
                        if (this.cfase != 10 || (this.cd.action != 0 && this.cd.action < 14)) {
                            this.rd.drawString(s6, 549 - this.ftm.stringWidth(s6) / 2, 95);
                        }
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("1st Color", 100, 55);
                        this.rd.drawString("2nd Color", 649, 55);
                        this.rd.setFont(new Font("Arial", 1, 10));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Hue  | ", 97, 70);
                        this.rd.drawImage(this.brt, 137, 63, null);
                        this.rd.drawString("Hue  | ", 647, 70);
                        this.rd.drawImage(this.brt, 687, 63, null);
                        this.rd.drawString("Intensity", 121, 219);
                        this.rd.drawString("Intensity", 671, 219);
                        this.rd.drawString("Reset", 110, 257);
                        this.rd.drawString("Reset", 660, 257);
                        for (int n25 = 0; n25 < 161; ++n25) {
                            this.rd.setColor(Color.getHSBColor((float)(n25 * 0.00625), 1.0f, 1.0f));
                            this.rd.drawLine(102, 75 + n25, 110, 75 + n25);
                            if (n25 <= 128) {
                                this.rd.setColor(Color.getHSBColor(1.0f, 0.0f, (float)(1.0 - n25 * 0.00625)));
                                this.rd.drawLine(137, 75 + n25, 145, 75 + n25);
                            }
                            this.rd.setColor(Color.getHSBColor((float)(n25 * 0.00625), 1.0f, 1.0f));
                            this.rd.drawLine(652, 75 + n25, 660, 75 + n25);
                            if (n25 <= 128) {
                                this.rd.setColor(Color.getHSBColor(1.0f, 0.0f, (float)(1.0 - n25 * 0.00625)));
                                this.rd.drawLine(687, 75 + n25, 695, 75 + n25);
                            }
                        }
                        for (int n26 = 0; n26 < 40; ++n26) {
                            this.rd.setColor(Color.getHSBColor(this.arnp[0], (float)(n26 * 0.025), 1.0f - this.arnp[2]));
                            this.rd.drawLine(121 + n26, 224, 121 + n26, 230);
                            this.rd.setColor(Color.getHSBColor(this.arnp[3], (float)(n26 * 0.025), 1.0f - this.arnp[5]));
                            this.rd.drawLine(671 + n26, 224, 671 + n26, 230);
                        }
                        this.rd.drawImage(this.arn, 110, 71 + (int)(this.arnp[0] * 160.0f), null);
                        this.rd.drawImage(this.arn, 145, 71 + (int)(this.arnp[2] * 160.0f), null);
                        this.rd.drawImage(this.arn, 660, 71 + (int)(this.arnp[3] * 160.0f), null);
                        this.rd.drawImage(this.arn, 695, 71 + (int)(this.arnp[5] * 160.0f), null);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(120 + (int)(this.arnp[1] * 40.0f), 222, 3, 3);
                        this.rd.drawLine(121 + (int)(this.arnp[1] * 40.0f), 224, 121 + (int)(this.arnp[1] * 40.0f), 230);
                        this.rd.fillRect(120 + (int)(this.arnp[1] * 40.0f), 230, 3, 3);
                        this.rd.fillRect(670 + (int)(this.arnp[4] * 40.0f), 222, 3, 3);
                        this.rd.drawLine(671 + (int)(this.arnp[4] * 40.0f), 224, 671 + (int)(this.arnp[4] * 40.0f), 230);
                        this.rd.fillRect(670 + (int)(this.arnp[4] * 40.0f), 230, 3, 3);
                        if (b) {
                            if (this.mouson == -1) {
                                if (n > 96 && n < 152 && n2 > 248 && n2 < 258) {
                                    final float[] array4 = new float[3];
                                    Color.RGBtoHSB(array[this.sc[0]].fcol[0], array[this.sc[0]].fcol[1], array[this.sc[0]].fcol[2], array4);
                                    this.arnp[0] = array4[0];
                                    this.arnp[1] = array4[1];
                                    this.arnp[2] = 1.0f - array4[2];
                                }
                                if (n > 646 && n < 702 && n2 > 248 && n2 < 258) {
                                    final float[] array5 = new float[3];
                                    Color.RGBtoHSB(array[this.sc[0]].scol[0], array[this.sc[0]].scol[1], array[this.sc[0]].scol[2], array5);
                                    this.arnp[3] = array5[0];
                                    this.arnp[4] = array5[1];
                                    this.arnp[5] = 1.0f - array5[2];
                                }
                                this.mouson = -2;
                                if (n > 119 && n < 163 && n2 > 222 && n2 < 232) {
                                    this.mouson = 1;
                                }
                                if (n > 669 && n < 713 && n2 > 222 && n2 < 232) {
                                    this.mouson = 4;
                                }
                                if (n > 98 && n < 122 && n2 > 69 && n2 < 241 && this.mouson == -2) {
                                    this.mouson = 0;
                                }
                                if (n > 133 && n < 157 && n2 > 69 && n2 < 209 && this.mouson == -2) {
                                    this.mouson = 2;
                                }
                                if (n > 648 && n < 672 && n2 > 69 && n2 < 241 && this.mouson == -2) {
                                    this.mouson = 3;
                                }
                                if (n > 683 && n < 707 && n2 > 69 && n2 < 209 && this.mouson == -2) {
                                    this.mouson = 5;
                                }
                            }
                        }
                        else if (this.mouson != -1) {
                            this.mouson = -1;
                        }
                        if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
                            this.arnp[this.mouson] = (float)((n2 - 75.0f) * 0.00625);
                            if (this.mouson == 2 || this.mouson == 5) {
                                if (this.arnp[this.mouson] > 0.8) {
                                    this.arnp[this.mouson] = 0.8f;
                                }
                            }
                            else if (this.arnp[this.mouson] > 1.0f) {
                                this.arnp[this.mouson] = 1.0f;
                            }
                            if (this.arnp[this.mouson] < 0.0f) {
                                this.arnp[this.mouson] = 0.0f;
                            }
                        }
                        if (this.mouson == 1) {
                            this.arnp[this.mouson] = (float)((n - 121.0f) * 0.025);
                            if (this.arnp[this.mouson] > 1.0f) {
                                this.arnp[this.mouson] = 1.0f;
                            }
                            if (this.arnp[this.mouson] < 0.0f) {
                                this.arnp[this.mouson] = 0.0f;
                            }
                        }
                        if (this.mouson == 4) {
                            this.arnp[this.mouson] = (float)((n - 671.0f) * 0.025);
                            if (this.arnp[this.mouson] > 1.0f) {
                                this.arnp[this.mouson] = 1.0f;
                            }
                            if (this.arnp[this.mouson] < 0.0f) {
                                this.arnp[this.mouson] = 0.0f;
                            }
                        }
                        if (this.cfase != 10 && this.cfase != 5 && n7 == -1) {
                            final Color hsbColor3 = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0f - this.arnp[2]);
                            final Color hsbColor4 = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0f - this.arnp[5]);
                            for (int n27 = 0; n27 < array[this.sc[0]].npl; ++n27) {
                                if (array[this.sc[0]].p[n27].colnum == 1) {
                                    array[this.sc[0]].p[n27].hsb[0] = this.arnp[0];
                                    array[this.sc[0]].p[n27].hsb[1] = this.arnp[1];
                                    array[this.sc[0]].p[n27].hsb[2] = 1.0f - this.arnp[2];
                                    array[this.sc[0]].p[n27].c[0] = hsbColor3.getRed();
                                    array[this.sc[0]].p[n27].c[1] = hsbColor3.getGreen();
                                    array[this.sc[0]].p[n27].c[2] = hsbColor3.getBlue();
                                    array[this.sc[0]].p[n27].oc[0] = hsbColor3.getRed();
                                    array[this.sc[0]].p[n27].oc[1] = hsbColor3.getGreen();
                                    array[this.sc[0]].p[n27].oc[2] = hsbColor3.getBlue();
                                }
                                if (array[this.sc[0]].p[n27].colnum == 2) {
                                    array[this.sc[0]].p[n27].hsb[0] = this.arnp[3];
                                    array[this.sc[0]].p[n27].hsb[1] = this.arnp[4];
                                    array[this.sc[0]].p[n27].hsb[2] = 1.0f - this.arnp[5];
                                    array[this.sc[0]].p[n27].c[0] = hsbColor4.getRed();
                                    array[this.sc[0]].p[n27].c[1] = hsbColor4.getGreen();
                                    array[this.sc[0]].p[n27].c[2] = hsbColor4.getBlue();
                                    array[this.sc[0]].p[n27].oc[0] = hsbColor4.getRed();
                                    array[this.sc[0]].p[n27].oc[1] = hsbColor4.getGreen();
                                    array[this.sc[0]].p[n27].oc[2] = hsbColor4.getBlue();
                                }
                            }
                        }
                    }
                }
                if (!this.remi && this.cfase != 10 && this.cfase != 11 && this.cfase != 100 && this.cfase != 101) {
                    this.rd.drawImage(this.contin[this.pcontin], 355, 385, null);
                }
                else {
                    if (this.cfase == 11 && this.drawcarb(true, null, "Add to My Cars", 345, 385, n, n2, b) && this.cd.action == 0) {
                        this.cd.ac = this.sc[0];
                        if (this.logged) {
                            this.cd.action = 6;
                            this.cd.sparkactionloader();
                        }
                        else {
                            this.cd.reco = -5;
                            this.cfase = 5;
                            this.showtf = false;
                        }
                    }
                    if (this.cfase == 101 && n7 == -1) {
                        if (this.cd.publish[this.sc[0] - 16] == 1 || this.cd.publish[this.sc[0] - 16] == 2) {
                            if (this.drawcarb(true, null, "Add to My Cars", 345, 385, n, n2, b) && this.cd.action == 0) {
                                this.cd.ac = this.sc[0];
                                if (this.logged) {
                                    this.cd.action = 6;
                                    this.cd.sparkactionloader();
                                }
                                else {
                                    this.cd.reco = -5;
                                    this.cfase = 5;
                                    this.showtf = false;
                                }
                            }
                        }
                        else {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.drawcs(405, "Private Car", 193, 106, 0, 3);
                        }
                    }
                }
            }
        }
        else {
            if (this.cfase == 11 || this.cfase == 101) {
                this.cd.action = 0;
            }
            if (this.app.mycar.isShowing()) {
                this.app.mycar.setVisible(false);
            }
            this.pback = 0;
            this.pnext = 0;
            this.gatey = 300;
            if (this.flipo > 10) {
                final ContO contO6 = array[this.sc[0]];
                contO6.y -= 100;
                if (this.nextc == 1) {
                    final ContO contO7 = array[this.sc[0]];
                    contO7.zy += 20;
                }
                if (this.nextc == -1) {
                    final ContO contO8 = array[this.sc[0]];
                    contO8.zy -= 20;
                }
            }
            else {
                if (this.flipo == 10) {
                    if (this.nextc >= 20) {
                        this.sc[0] = this.nextc - 20;
                        this.lsc = -1;
                    }
                    if (this.nextc == 1) {
                        final int[] sc = this.sc;
                        final int n28 = 0;
                        ++sc[n28];
                        if (this.gmode == 1) {
                            if (this.sc[0] == 7) {
                                this.sc[0] = 11;
                            }
                            if (this.sc[0] == 12) {
                                this.sc[0] = 14;
                            }
                        }
                        if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
                            while (this.sc[0] < this.maxsl && Math.abs(this.cd.cclass[this.sc[0]] - (this.ontyp - 1)) > 1) {
                                final int[] sc2 = this.sc;
                                final int n29 = 0;
                                ++sc2[n29];
                            }
                        }
                    }
                    if (this.nextc == -1) {
                        final int[] sc3 = this.sc;
                        final int n30 = 0;
                        --sc3[n30];
                        if (this.gmode == 1) {
                            if (this.sc[0] == 13) {
                                this.sc[0] = 11;
                            }
                            if (this.sc[0] == 10) {
                                this.sc[0] = 6;
                            }
                        }
                        if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
                            while (this.sc[0] > this.minsl && Math.abs(this.cd.cclass[this.sc[0]] - (this.ontyp - 1)) > 1) {
                                final int[] sc4 = this.sc;
                                final int n31 = 0;
                                --sc4[n31];
                            }
                        }
                    }
                    if (this.cfase == 3 && this.cd.lastload == 2) {
                        this.app.mcars.select(this.cd.names[this.sc[0]]);
                    }
                    array[this.sc[0]].z = 950;
                    array[this.sc[0]].y = -34 - array[this.sc[0]].grat - 1100;
                    array[this.sc[0]].x = 0;
                    array[this.sc[0]].zy = 0;
                }
                final ContO contO9 = array[this.sc[0]];
                contO9.y += 100;
            }
            --this.flipo;
        }
        if (this.cfase == 0 || this.cfase == 3 || this.cfase == 11 || this.cfase == 101) {
            this.basefase = this.cfase;
            if (n7 != -1) {
                if (this.flatrstart > 1) {
                    this.flatrstart = 0;
                }
                this.nextc = n7 + 20;
                this.flipo = 20;
            }
            if (control.right) {
                control.right = false;
                if (this.sc[0] != this.maxsl && this.flipo == 0) {
                    if (this.flatrstart > 1) {
                        this.flatrstart = 0;
                    }
                    this.nextc = 1;
                    this.flipo = 20;
                }
            }
            if (control.left) {
                control.left = false;
                if (this.sc[0] != this.minsl && this.flipo == 0) {
                    if (this.flatrstart > 1) {
                        this.flatrstart = 0;
                    }
                    this.nextc = -1;
                    this.flipo = 20;
                }
            }
            if (this.cfase != 11 && this.cfase != 101 && n8 == 0 && this.flipo < 10 && (control.handb || control.enter)) {
                this.m.crs = false;
                this.app.mcars.show = false;
                if (this.multion != 0) {
                    this.fase = 1177;
                    this.intertrack.stop();
                }
                else if (this.testdrive != 3 && this.testdrive != 4) {
                    this.fase = 3;
                }
                else {
                    this.fase = -22;
                }
                if (this.sc[0] < 16 || this.cd.lastload == 2) {
                    this.app.setcarcookie(this.sc[0], this.cd.names[this.sc[0]], this.arnp, this.gmode, this.unlocked, this.mtop);
                }
                if (this.cd.haltload != 0) {
                    if (this.cd.haltload == 2) {
                        this.cd.lcardate[1] = 0;
                    }
                    this.cd.lcardate[0] = 0;
                    this.cd.haltload = 0;
                }
                if (this.gmode == 0) {
                    this.osc = this.sc[0];
                }
                if (this.gmode == 1) {
                    this.scm[0] = this.sc[0];
                }
                if (this.gmode == 2) {
                    this.scm[1] = this.sc[0];
                }
                if (this.app.mycar.isShowing()) {
                    this.app.mycar.setVisible(false);
                }
                this.flexpix = null;
                control.handb = false;
                control.enter = false;
            }
        }
        else {
            this.pback = 0;
            this.pnext = 0;
            this.pcontin = 0;
            if (this.cfase == 8 && n7 != -1) {
                if (this.flatrstart > 1) {
                    this.flatrstart = 0;
                }
                this.nextc = n7 + 20;
                this.flipo = 20;
            }
            if (this.cfase == 5 && this.cd.action == 0 && control.enter) {
                this.tcnt = 0;
                if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                    this.app.tnick.setVisible(false);
                    this.app.tpass.setVisible(false);
                    this.app.requestFocus();
                    this.cd.action = 1;
                    this.cd.sparkactionloader();
                }
                else {
                    if (this.app.tpass.getText().equals("")) {
                        this.cd.reco = -4;
                    }
                    if (this.app.tnick.getText().equals("")) {
                        this.cd.reco = -3;
                    }
                }
                control.enter = false;
            }
        }
        if (control.handb || control.enter) {
            control.handb = false;
            control.enter = false;
        }
        if (b2) {
            this.app.mouses = 0;
            this.onviewpro = true;
            this.cd.viewname = this.cd.createdby[this.sc[0] - 16];
            this.m.crs = false;
            this.fase = 1177;
            this.intertrack.stop();
            this.sc[0] = this.onmsc;
            if ((this.sc[0] >= 16 && this.cd.lastload != 2) || this.sc[0] >= 36) {
                this.sc[0] = 15;
            }
            this.osc = this.sc[0];
            this.multion = 1;
            this.gmode = 0;
            if (this.app.mycar.isShowing()) {
                this.app.mycar.setVisible(false);
            }
            this.flexpix = null;
            control.handb = false;
            control.enter = false;
        }
    }

    public void colorCar(final ContO contO, final int n) {
        if (this.plnames[n].indexOf("MadBot") == -1) {
            for (int i = 0; i < contO.npl; ++i) {
                if (contO.p[i].colnum == 1) {
                    final Color hsbColor = Color.getHSBColor(this.allrnp[n][0], this.allrnp[n][1], 1.0f - this.allrnp[n][2]);
                    contO.p[i].oc[0] = hsbColor.getRed();
                    contO.p[i].oc[1] = hsbColor.getGreen();
                    contO.p[i].oc[2] = hsbColor.getBlue();
                }
                if (contO.p[i].colnum == 2) {
                    final Color hsbColor2 = Color.getHSBColor(this.allrnp[n][3], this.allrnp[n][4], 1.0f - this.allrnp[n][5]);
                    contO.p[i].oc[0] = hsbColor2.getRed();
                    contO.p[i].oc[1] = hsbColor2.getGreen();
                    contO.p[i].oc[2] = hsbColor2.getBlue();
                }
            }
        }
        else {
            for (int j = 0; j < contO.npl; ++j) {
                if (contO.p[j].colnum == 1) {
                    contO.p[j].oc[0] = contO.fcol[0];
                    contO.p[j].oc[1] = contO.fcol[1];
                    contO.p[j].oc[2] = contO.fcol[2];
                }
                if (contO.p[j].colnum == 2) {
                    contO.p[j].oc[0] = contO.scol[0];
                    contO.p[j].oc[1] = contO.scol[1];
                    contO.p[j].oc[2] = contO.scol[2];
                }
            }
        }
    }

    public boolean clink(final String s, final int n, final int n2, final boolean b) {
        boolean b2 = false;
        this.rd.drawString("Created by :  " + s + "", 241, 160);
        final int stringWidth = this.ftm.stringWidth(s);
        final int n3 = 241 + this.ftm.stringWidth("Created by :  " + s + "") - stringWidth;
        this.rd.drawLine(n3, 162, n3 + stringWidth - 2, 162);
        if (n > n3 - 2 && n < n3 + stringWidth && n2 > 147 && n2 < 164) {
            if (b) {
                b2 = true;
            }
            if (this.waitlink != 1) {
                this.app.setCursor(new Cursor(12));
                this.waitlink = 1;
            }
        }
        else if (this.waitlink != 0) {
            this.app.setCursor(new Cursor(0));
            this.waitlink = 0;
        }
        return b2;
    }

    public void drawprom(final int n, final int n2) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.76f));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(205, n, 390, n2, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(205, n, 390, n2, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }

    public void drawdprom(final int n, final int n2) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.9f));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(205, n, 390, n2, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(205, n, 390, n2, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }

    public void drawlprom(final int n, final int n2) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5f));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(277, n, 390, n2, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(277, n, 390, n2, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }

    public void finish(final CheckPoints checkPoints, final ContO[] array, final Control control, final int n, final int n2, final boolean b) {
        if (!this.badmac) {
            this.rd.drawImage(this.fleximg, 0, 0, null);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1f));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        int n3 = 0;
        String string = ":";
        if (checkPoints.stage > 0) {
            int stage = checkPoints.stage;
            if (stage > 10) {
                stage -= 10;
            }
            string = " " + stage + "!";
        }
        if (this.multion < 3) {
            if (this.winner) {
                this.rd.drawImage(this.congrd, 265, 87, null);
                this.drawcs(137, "You Won!  At Stage" + string + "", 255, 161, 85, 3);
                this.drawcs(154, "" + checkPoints.name + "", 255, 115, 0, 3);
                n3 = 154;
            }
            else {
                this.rd.drawImage(this.gameov, 315, 117, null);
                if (this.multion != 0 && (this.forstart == 700 || this.discon == 240)) {
                    this.drawcs(167, "Sorry, You where Disconnected from Game!", 255, 161, 85, 3);
                    this.drawcs(184, "Please check your connection!", 255, 115, 0, 3);
                }
                else {
                    this.drawcs(167, "You Lost!  At Stage" + string + "", 255, 161, 85, 3);
                    this.drawcs(184, "" + checkPoints.name + "", 255, 115, 0, 3);
                    n3 = 184;
                }
            }
        }
        else {
            this.rd.drawImage(this.gameov, 315, 117, null);
            this.drawcs(167, "Finished Watching Game!  At Stage" + string + "", 255, 161, 85, 3);
            this.drawcs(184, "" + checkPoints.name + "", 255, 115, 0, 3);
            n3 = 184;
        }
        if (this.winner && this.multion == 0 && this.gmode != 0 && (checkPoints.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 || checkPoints.stage == 27)) {
            int n4 = 0;
            int y = 0;
            this.pin = 60;
            if (this.gmode == 1) {
                if (checkPoints.stage == 2) {
                    n4 = 5;
                    y = 365;
                    this.pin = -20;
                    this.scm[0] = 5;
                }
                if (checkPoints.stage == 4) {
                    n4 = 6;
                    y = 320;
                    this.pin = -20;
                    this.scm[0] = 6;
                }
                if (checkPoints.stage == 6) {
                    n4 = 11;
                    y = 326;
                    this.pin = -20;
                    this.scm[0] = 11;
                }
                if (checkPoints.stage == 8) {
                    n4 = 14;
                    y = 350;
                    this.pin = -20;
                    this.scm[0] = 14;
                }
                if (checkPoints.stage == 10) {
                    n4 = 15;
                    y = 370;
                    this.pin = -20;
                    this.scm[0] = 15;
                }
            }
            if (this.gmode == 2) {
                if (checkPoints.stage == 12) {
                    n4 = 8;
                    y = 365;
                    this.pin = -20;
                    this.scm[1] = 8;
                }
                if (checkPoints.stage == 14) {
                    n4 = 9;
                    y = 320;
                    this.pin = -20;
                    this.scm[1] = 9;
                }
                if (checkPoints.stage == 16) {
                    n4 = 10;
                    y = 370;
                    this.pin = -20;
                    this.scm[1] = 10;
                }
                if (checkPoints.stage == 18) {
                    n4 = 11;
                    y = 326;
                    this.pin = -20;
                    this.scm[1] = 11;
                }
                if (checkPoints.stage == 20) {
                    n4 = 12;
                    y = 310;
                    this.pin = -20;
                    this.scm[1] = 12;
                }
                if (checkPoints.stage == 22) {
                    n4 = 13;
                    y = 310;
                    this.pin = -20;
                    this.scm[1] = 13;
                }
                if (checkPoints.stage == 24) {
                    n4 = 14;
                    y = 350;
                    this.pin = -20;
                    this.scm[1] = 14;
                }
                if (checkPoints.stage == 26) {
                    n4 = 15;
                    y = 370;
                    this.pin = -20;
                    this.scm[1] = 15;
                }
            }
            if (checkPoints.stage != 27) {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.aflk) {
                    this.drawcs(200 + this.pin, "Stage " + (checkPoints.stage + 1 - (this.gmode - 1) * 10) + " is now unlocked!", 196, 176, 0, 3);
                }
                else {
                    this.drawcs(200 + this.pin, "Stage " + (checkPoints.stage + 1 - (this.gmode - 1) * 10) + " is now unlocked!", 255, 247, 165, 3);
                }
                if (n4 != 0) {
                    if (this.aflk) {
                        this.drawcs(200, "And:", 196, 176, 0, 3);
                    }
                    else {
                        this.drawcs(200, "And:", 255, 247, 165, 3);
                    }
                    this.rd.setColor(new Color(236, 226, 202));
                    if (Math.random() > 0.5) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5f));
                        this.rd.fillRect(226, 211, 344, 125);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(226, 211, 348, 4);
                    this.rd.fillRect(226, 211, 4, 125);
                    this.rd.fillRect(226, 332, 348, 4);
                    this.rd.fillRect(570, 211, 4, 125);
                    array[n4].y = y;
                    this.m.crs = true;
                    this.m.x = -400;
                    this.m.y = 0;
                    this.m.z = -50;
                    this.m.xz = 0;
                    this.m.zy = 0;
                    this.m.ground = 2470;
                    array[n4].z = 1000;
                    array[n4].x = 0;
                    final ContO contO = array[n4];
                    contO.xz += 5;
                    array[n4].zy = 0;
                    final ContO contO2 = array[n4];
                    contO2.wzy -= 10;
                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    array[n4].d(this.rd);
                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    if (Math.random() < 0.5) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4f));
                        this.rd.setColor(new Color(236, 226, 202));
                        for (int i = 0; i < 30; ++i) {
                            this.rd.drawLine(230, 215 + 4 * i, 569, 215 + 4 * i);
                        }
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                    }
                    String s = "";
                    if (n4 == 13) {
                        s = " ";
                    }
                    if (this.aflk) {
                        this.drawcs(320, "" + this.cd.names[n4] + "" + s + " has been unlocked!", 196, 176, 0, 3);
                    }
                    else {
                        this.drawcs(320, "" + this.cd.names[n4] + "" + s + " has been unlocked!", 255, 247, 165, 3);
                    }
                    this.pin = 140;
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.drawcs(220 + this.pin, "GAME SAVED", 230, 167, 0, 3);
                if (this.pin == 60) {
                    this.pin = 30;
                }
                else {
                    this.pin = 0;
                }
            }
            else {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.aflk) {
                    this.drawcs(180, "Woohoooo you finished NFM" + this.gmode + " !!!", 144, 167, 255, 3);
                }
                else {
                    this.drawcs(180, "Woohoooo you finished NFM" + this.gmode + " !!!", 228, 240, 255, 3);
                }
                if (this.aflk) {
                    this.drawcs(210, "You're Awesome!", 144, 167, 255, 3);
                }
                else {
                    this.drawcs(212, "You're Awesome!", 228, 240, 255, 3);
                }
                if (this.aflk) {
                    this.drawcs(240, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                }
                else {
                    this.drawcs(240, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.fillRect(0, 255, 800, 62);
                this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 255, null);
                if (this.radpx != 212) {
                    this.radpx += 40;
                    if (this.radpx > 800) {
                        this.radpx = -468;
                    }
                }
                if (this.flipo == 40) {
                    this.radpx = 213;
                }
                ++this.flipo;
                if (this.flipo == 70) {
                    this.flipo = 0;
                }
                if (this.radpx == 212) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(309, "A Game by Radicalplay.com", 144, 167, 255, 3);
                    }
                    else {
                        this.drawcs(309, "A Game by Radicalplay.com", 228, 240, 255, 3);
                    }
                }
                if (this.aflk) {
                    this.drawcs(350, "Now get up and dance!", 144, 167, 255, 3);
                }
                else {
                    this.drawcs(350, "Now get up and dance!", 228, 240, 255, 3);
                }
                this.pin = 0;
            }
            if (this.aflk) {
                this.aflk = false;
            }
            else {
                this.aflk = true;
            }
        }
        if (this.multion != 0 && checkPoints.stage == -2 && n3 != 0) {
            this.drawcs(n3 + 17, "Created by: " + checkPoints.maker + "", 255, 161, 85, 3);
            if (checkPoints.pubt > 0) {
                if (checkPoints.pubt == 2) {
                    this.drawcs(310, "Super Public Stage", 41, 177, 255, 3);
                }
                else {
                    this.drawcs(310, "Public Stage", 41, 177, 255, 3);
                }
                if (this.dnload == 0 && this.drawcarb(true, null, " Add to My Stages ", 334, 317, n, n2, b)) {
                    if (this.logged) {
                        this.cd.onstage = checkPoints.name;
                        this.cd.staction = 2;
                        this.cd.sparkstageaction();
                        this.dnload = 2;
                    }
                    else {
                        this.dnload = 1;
                        this.waitlink = 20;
                    }
                }
                if (this.dnload == 1) {
                    this.rd.setColor(new Color(193, 106, 0));
                    final String s2 = "Upgrade to a full account to add custom stages!";
                    final int n5 = 400 - this.ftm.stringWidth(s2) / 2;
                    final int n6 = n5 + this.ftm.stringWidth(s2);
                    this.rd.drawString(s2, n5, 332);
                    if (this.waitlink != -1) {
                        this.rd.drawLine(n5, 334, n6, 334);
                    }
                    if (n > n5 && n < n6 && n2 > 321 && n2 < 334) {
                        if (this.waitlink != -1) {
                            this.app.setCursor(new Cursor(12));
                        }
                        if (b && this.waitlink == 0) {
                            this.app.editlink(this.nickname, true);
                            this.waitlink = -1;
                        }
                    }
                    else {
                        this.app.setCursor(new Cursor(0));
                    }
                    if (this.waitlink > 0) {
                        --this.waitlink;
                    }
                }
                if (this.dnload == 2) {
                    this.drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
                    if (this.cd.staction == 0) {
                        this.dnload = 3;
                    }
                    if (this.cd.staction == -2) {
                        this.dnload = 4;
                    }
                    if (this.cd.staction == -3) {
                        this.dnload = 5;
                    }
                    if (this.cd.staction == -1) {
                        this.dnload = 6;
                    }
                }
                if (this.dnload == 3) {
                    this.drawcs(332, "Stager has been successfully added to your stages!", 193, 106, 0, 3);
                }
                if (this.dnload == 4) {
                    this.drawcs(332, "You already have this stage!", 193, 106, 0, 3);
                }
                if (this.dnload == 5) {
                    this.drawcs(332, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                }
                if (this.dnload == 6) {
                    this.drawcs(332, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                }
            }
            else {
                this.drawcs(342, "Private Stage", 193, 106, 0, 3);
            }
        }
        this.rd.drawImage(this.contin[this.pcontin], 355, 380, null);
        if (control.enter || control.handb) {
            if (this.loadedt) {
                this.strack.unload();
            }
            if (this.multion == 0) {
                this.opselect = 3;
                if (this.gmode == 1) {
                    this.opselect = 0;
                    if (this.winner && checkPoints.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && checkPoints.stage != 27) {
                        final int[] unlocked = this.unlocked;
                        final int n7 = this.gmode - 1;
                        ++unlocked[n7];
                        this.justwon1 = true;
                    }
                    else {
                        this.justwon1 = false;
                    }
                }
                if (this.gmode == 2) {
                    this.opselect = 1;
                    if (this.winner && checkPoints.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && checkPoints.stage != 27) {
                        final int[] unlocked2 = this.unlocked;
                        final int n8 = this.gmode - 1;
                        ++unlocked2[n8];
                        this.justwon2 = true;
                    }
                    else {
                        this.justwon2 = false;
                    }
                }
                if (checkPoints.stage == 27 && this.gmode == 0) {
                    checkPoints.stage = (int)(Math.random() * 27.0) + 1;
                }
                this.fase = 102;
            }
            else if (this.cd.haltload == 1) {
                this.sc[0] = 36;
                this.fase = 1177;
            }
            else if (!this.mtop || (this.nfreeplays >= 5 && !this.logged)) {
                this.opselect = 2;
                this.fase = 102;
            }
            else {
                this.fase = -9;
            }
            if (this.multion == 0 && this.winner && checkPoints.stage != 27 && checkPoints.stage > 0) {
                ++checkPoints.stage;
            }
            if (!this.winner && this.multion != 0 && (this.forstart == 700 || this.discon == 240) && this.ndisco < 5) {
                ++this.ndisco;
            }
            this.flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int n) {
        if (n != 0) {
            for (int i = 1; i < 7; ++i) {
                this.sc[i] = -1;
            }
            final boolean[] array = new boolean[7];
            if (n < 0) {
                n = 27;
            }
            int n2 = 7;
            if (this.gmode == 1) {
                n2 = 5;
            }
            boolean b = false;
            if (n <= 10) {
                int n3 = 6;
                if (this.gmode == 1) {
                    n3 = 4;
                }
                if ((n == 1 || n == 2) && this.sc[0] != 5) {
                    this.sc[n3] = 5;
                    n2 = n3;
                }
                if ((n == 3 || n == 4) && this.sc[0] != 6) {
                    this.sc[n3] = 6;
                    n2 = n3;
                }
                if ((n == 5 || n == 6) && this.sc[0] != 11) {
                    this.sc[n3] = 11;
                    n2 = n3;
                }
                if ((n == 7 || n == 8) && this.sc[0] != 14) {
                    this.sc[n3] = 14;
                    n2 = n3;
                }
                if ((n == 9 || n == 10) && this.sc[0] != 15) {
                    this.sc[n3] = 15;
                    n2 = n3;
                }
            }
            else {
                n -= 10;
                b = true;
                if (this.sc[0] != 7 + (n + 1) / 2 && n != 17) {
                    this.sc[6] = 7 + (n + 1) / 2;
                    n2 = 6;
                }
            }
            int n4 = 16;
            int n5 = 1;
            int n6 = 2;
            for (int j = 1; j < n2; ++j) {
                array[j] = false;
                while (!array[j]) {
                    float n7 = 10.0f;
                    if (b) {
                        n7 = 17.0f;
                    }
                    this.sc[j] = (int)(Math.random() * (24.0f + 8.0f * (n / n7)));
                    if (this.sc[j] >= 16) {
                        final int[] sc = this.sc;
                        final int n8 = j;
                        sc[n8] -= 16;
                    }
                    array[j] = true;
                    for (int k = 0; k < 7; ++k) {
                        if (j != k && this.sc[j] == this.sc[k]) {
                            array[j] = false;
                        }
                    }
                    if (b) {
                        n7 = 16.0f;
                    }
                    float n9 = (15 - this.sc[j]) / 15.0f * (n / n7);
                    if (n9 > 0.8) {
                        n9 = 0.8f;
                    }
                    if (n == 17 && n9 > 0.5) {
                        n9 = 0.5f;
                    }
                    if (n9 > Math.random()) {
                        array[j] = false;
                    }
                    if (this.gmode == 1) {
                        if (this.sc[j] >= 7 && this.sc[j] <= 10) {
                            array[j] = false;
                        }
                        if (this.sc[j] == 12 || this.sc[j] == 13) {
                            array[j] = false;
                        }
                        if (this.sc[j] > 5 && this.unlocked[0] <= 2) {
                            array[j] = false;
                        }
                        if (this.sc[j] > 6 && this.unlocked[0] <= 4) {
                            array[j] = false;
                        }
                        if (this.sc[j] > 11 && this.unlocked[0] <= 6) {
                            array[j] = false;
                        }
                        if (this.sc[j] > 14 && this.unlocked[0] <= 8) {
                            array[j] = false;
                        }
                    }
                    if (this.gmode == 2) {
                        if ((this.sc[j] - 7) * 2 > this.unlocked[1]) {
                            array[j] = false;
                        }
                        if (n != 16 || this.unlocked[1] != 16 || this.sc[j] >= 9) {
                            continue;
                        }
                        array[j] = false;
                    }
                }
                if (this.sc[j] < n4) {
                    n4 = this.sc[j];
                    if (n5 != j) {
                        n6 = n5;
                        n5 = j;
                    }
                }
            }
            if (!b && n == 10) {
                boolean b2 = false;
                for (int l = 0; l < 7; ++l) {
                    if (this.sc[l] == 11) {
                        b2 = true;
                    }
                }
                if (!b2 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n5] = 11;
                }
                boolean b3 = false;
                for (int n10 = 0; n10 < 7; ++n10) {
                    if (this.sc[n10] == 14) {
                        b3 = true;
                    }
                }
                if (!b3 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n6] = 14;
                }
            }
            if (n == 12) {
                boolean b4 = false;
                for (int n11 = 0; n11 < 7; ++n11) {
                    if (this.sc[n11] == 11) {
                        b4 = true;
                    }
                }
                if (!b4) {
                    this.sc[n5] = 11;
                }
            }
            if (n == 14) {
                boolean b5 = false;
                for (int n12 = 0; n12 < 7; ++n12) {
                    if (this.sc[n12] == 12) {
                        b5 = true;
                    }
                }
                if (!b5 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n5] = 12;
                }
                boolean b6 = false;
                for (int n13 = 0; n13 < 7; ++n13) {
                    if (this.sc[n13] == 10) {
                        b6 = true;
                    }
                }
                if (!b6 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n6] = 10;
                }
            }
            if (n == 15) {
                boolean b7 = false;
                for (int n14 = 0; n14 < 7; ++n14) {
                    if (this.sc[n14] == 11) {
                        b7 = true;
                    }
                }
                if (!b7 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n5] = 11;
                }
                boolean b8 = false;
                for (int n15 = 0; n15 < 7; ++n15) {
                    if (this.sc[n15] == 13) {
                        b8 = true;
                    }
                }
                if (!b8 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n6] = 13;
                }
            }
            if (n == 16) {
                boolean b9 = false;
                for (int n16 = 0; n16 < 7; ++n16) {
                    if (this.sc[n16] == 13) {
                        b9 = true;
                    }
                }
                if (!b9 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n5] = 13;
                }
                boolean b10 = false;
                for (int n17 = 0; n17 < 7; ++n17) {
                    if (this.sc[n17] == 12) {
                        b10 = true;
                    }
                }
                if (!b10 && (Math.random() > Math.random() || this.gmode != 0)) {
                    this.sc[n6] = 12;
                }
            }
            if (this.cd.lastload == 1) {
                int n18 = 0;
                for (int n19 = 0; n19 < this.cd.nlcars - 16; ++n19) {
                    if (n18 == 0) {
                        for (int n20 = 1; n20 < n2; ++n20) {
                            array[n20] = false;
                        }
                    }
                    if (this.cd.include[n19] && this.sc[0] != n19 + 16) {
                        int n21;
                        for (n21 = (int)(1.0 + Math.random() * (n2 - 1)); array[n21]; n21 = (int)(1.0 + Math.random() * (n2 - 1))) {}
                        array[n21] = true;
                        this.sc[n21] = n19 + 16;
                        if (++n18 == n2 - 1) {
                            n18 = 0;
                        }
                    }
                }
            }
            if (this.cd.lastload == 2) {
                int n22 = 0;
                for (int n23 = 0; n23 < this.cd.nlocars - 16; ++n23) {
                    if (n22 == 0) {
                        for (int n24 = 1; n24 < n2; ++n24) {
                            array[n24] = false;
                        }
                    }
                    if (this.cd.include[n23] && this.sc[0] != n23 + 16) {
                        int n25;
                        for (n25 = (int)(1.0 + Math.random() * (n2 - 1)); array[n25]; n25 = (int)(1.0 + Math.random() * (n2 - 1))) {}
                        array[n25] = true;
                        this.sc[n25] = n23 + 16;
                        if (++n22 == n2 - 1) {
                            n22 = 0;
                        }
                    }
                }
            }
        }
    }

    public void ctachm(final int n, final int n2, final int n3, final Control control) {
        if (this.fase == 1) {
            if (n3 == 1) {
                if (this.over(this.next[0], n, n2, 625, 135)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], n, n2, 115, 135)) {
                    this.pback = 1;
                }
                if (this.over(this.contin[0], n, n2, 355, 360)) {
                    this.pcontin = 1;
                }
            }
            if (n3 == 2) {
                if (this.pnext == 1) {
                    control.right = true;
                }
                if (this.pback == 1) {
                    control.left = true;
                }
                if (this.pcontin == 1) {
                    control.enter = true;
                }
            }
        }
        if (this.fase == 3) {
            if (n3 == 1 && this.over(this.contin[0], n, n2, 355, 350)) {
                this.pcontin = 1;
            }
            if (n3 == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == 4) {
            if (n3 == 1 && this.over(this.back[0], n, n2, 370, 345)) {
                this.pback = 1;
            }
            if (n3 == 2 && this.pback == 1) {
                control.enter = true;
                this.pback = 0;
            }
        }
        if (this.fase == 6) {
            if (n3 == 1 && (this.over(this.star[0], n, n2, 359, 385) || this.over(this.star[0], n, n2, 359, 295))) {
                this.pstar = 2;
            }
            if (n3 == 2 && this.pstar == 2) {
                control.enter = true;
                this.pstar = 1;
            }
        }
        if (this.fase == 7) {
            if (n3 == 1) {
                if (this.over(this.next[0], n, n2, 645, 275)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], n, n2, 95, 275)) {
                    this.pback = 1;
                }
                if (this.over(this.contin[0], n, n2, 355, 385) && !this.app.openm) {
                    this.pcontin = 1;
                }
            }
            if (n3 == 2) {
                if (this.pnext == 1) {
                    control.right = true;
                }
                if (this.pback == 1) {
                    control.left = true;
                }
                if (this.pcontin == 1) {
                    control.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == -5) {
            this.lxm = n;
            this.lym = n2;
            if (n3 == 1 && this.over(this.contin[0], n, n2, 355, 380)) {
                this.pcontin = 1;
            }
            if (n3 == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == -7) {
            if (n3 == 1) {
                if (this.overon(329, 45, 137, 22, n, n2)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(320, 73, 155, 22, n, n2)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(303, 99, 190, 22, n, n2)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.overon(341, 125, 109, 22, n, n2)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (n3 == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (n3 == 0 && (n != this.lxm || n2 != this.lym)) {
                if (this.overon(329, 45, 137, 22, n, n2)) {
                    this.opselect = 0;
                }
                if (this.overon(320, 73, 155, 22, n, n2)) {
                    this.opselect = 1;
                }
                if (this.overon(303, 99, 190, 22, n, n2)) {
                    this.opselect = 2;
                }
                if (this.overon(341, 125, 109, 22, n, n2)) {
                    this.opselect = 3;
                }
                this.lxm = n;
                this.lym = n2;
            }
        }
        if (this.fase == 10) {
            if (n3 == 1) {
                if (this.overon(343, 261, 110, 22, n, n2)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(288, 291, 221, 22, n, n2)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(301, 321, 196, 22, n, n2)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.overon(357, 351, 85, 22, n, n2)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (n3 == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (n3 == 0 && (n != this.lxm || n2 != this.lym)) {
                if (this.overon(343, 261, 110, 22, n, n2)) {
                    this.opselect = 0;
                }
                if (this.overon(288, 291, 221, 22, n, n2)) {
                    this.opselect = 1;
                }
                if (this.overon(301, 321, 196, 22, n, n2)) {
                    this.opselect = 2;
                }
                if (this.overon(357, 351, 85, 22, n, n2)) {
                    this.opselect = 3;
                }
                this.lxm = n;
                this.lym = n2;
            }
        }
        if (this.fase == 102) {
            if (n3 == 1) {
                if (this.overon(358, 262 + this.dropf, 82, 22, n, n2)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(358, 290 + this.dropf, 82, 22, n, n2)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(333, 318 + this.dropf, 132, 22, n, n2)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.dropf == 0 && this.overon(348, 346, 102, 22, n, n2)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (n3 == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (n3 == 0 && (n != this.lxm || n2 != this.lym)) {
                if (this.overon(358, 262 + this.dropf, 82, 22, n, n2)) {
                    this.opselect = 0;
                }
                if (this.overon(358, 290 + this.dropf, 82, 22, n, n2)) {
                    this.opselect = 1;
                }
                if (this.overon(333, 318 + this.dropf, 132, 22, n, n2)) {
                    this.opselect = 2;
                }
                if (this.dropf == 0 && this.overon(348, 346, 102, 22, n, n2)) {
                    this.opselect = 3;
                }
                this.lxm = n;
                this.lym = n2;
            }
        }
        if (this.fase == 11) {
            if (this.flipo >= 1 && this.flipo <= 15) {
                if (n3 == 1 && this.over(this.next[0], n, n2, 665, 395)) {
                    this.pnext = 1;
                }
                if (n3 == 2 && this.pnext == 1) {
                    control.right = true;
                    this.pnext = 0;
                }
            }
            if (this.flipo >= 3 && this.flipo <= 16) {
                if (n3 == 1 && this.over(this.back[0], n, n2, 75, 395)) {
                    this.pback = 1;
                }
                if (n3 == 2 && this.pback == 1) {
                    control.left = true;
                    this.pback = 0;
                }
            }
            if (this.flipo == 16) {
                if (n3 == 1 && this.over(this.contin[0], n, n2, 565, 395)) {
                    this.pcontin = 1;
                }
                if (n3 == 2 && this.pcontin == 1) {
                    control.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == 8) {
            if (n3 == 1 && this.over(this.next[0], n, n2, 665, 395)) {
                this.pnext = 1;
            }
            if (n3 == 2 && this.pnext == 1) {
                control.enter = true;
                this.pnext = 0;
            }
        }
    }

    public void stat(final Mad mad, final ContO contO, final CheckPoints checkPoints, final Control control, final boolean b) {
        if (this.holdit) {
            int n = 250;
            if (this.fase == 7001) {
                if (this.exitm != 4) {
                    this.exitm = 0;
                    n = 600;
                }
                else {
                    n = 1200;
                }
            }
            if (this.exitm != 4 || !this.lan || this.im != 0) {
                ++this.holdcnt;
                if ((control.enter || this.holdcnt > n) && (control.chatup == 0 || this.fase != 7001)) {
                    this.fase = -2;
                    control.enter = false;
                }
            }
            else if (control.enter) {
                control.enter = false;
            }
        }
        else {
            if (this.holdcnt != 0) {
                this.holdcnt = 0;
            }
            if (control.enter || control.exit) {
                if (this.fase == 0) {
                    if (this.loadedt) {
                        this.strack.stop();
                    }
                    this.fase = -6;
                }
                else if (this.starcnt == 0 && control.chatup == 0 && (this.multion < 2 || !this.lan)) {
                    if (this.exitm == 0) {
                        this.exitm = 1;
                    }
                    else {
                        this.exitm = 0;
                    }
                }
                if (control.chatup == 0 || this.fase != 7001) {
                    control.enter = false;
                }
                control.exit = false;
            }
        }
        if (this.exitm == 2) {
            this.fase = -2;
            this.winner = false;
        }
        if (this.fase != -2) {
            this.holdit = false;
            if (checkPoints.haltall) {
                checkPoints.haltall = false;
            }
            boolean b2 = false;
            String s = "";
            String s2 = "";
            if (this.clangame != 0 && (!mad.dest || this.multion >= 2)) {
                b2 = true;
                for (int i = 0; i < this.nplayers; ++i) {
                    if (checkPoints.dested[i] == 0) {
                        if (s.equals("")) {
                            s = this.pclan[i];
                        }
                        else if (!s.toLowerCase().equals(this.pclan[i].toLowerCase())) {
                            b2 = false;
                            break;
                        }
                    }
                }
            }
            if (this.clangame > 1) {
                boolean b3 = false;
                String s3 = "";
                if (b2) {
                    for (int j = 0; j < this.nplayers; ++j) {
                        if (!s.toLowerCase().equals(this.pclan[j].toLowerCase())) {
                            s2 = this.pclan[j];
                            break;
                        }
                    }
                    if (this.clangame == 2) {
                        b3 = true;
                        s3 = "Clan " + s2 + " wasted, nobody won becuase this is a racing only game!";
                    }
                    if (this.clangame == 4 && !s.toLowerCase().equals(this.gaclan.toLowerCase())) {
                        b3 = true;
                        s3 = "Clan " + s2 + " wasted, nobody won becuase " + s + " should have raced in this racing vs wasting game!";
                    }
                    if (this.clangame == 5 && s.toLowerCase().equals(this.gaclan.toLowerCase())) {
                        b3 = true;
                        s3 = "Clan " + s2 + " wasted, nobody won becuase " + s + " should have raced in this racing vs wasting game!";
                    }
                }
                for (int k = 0; k < this.nplayers; ++k) {
                    if (checkPoints.clear[k] == checkPoints.nlaps * checkPoints.nsp && checkPoints.pos[k] == 0) {
                        if (this.clangame == 3) {
                            b3 = true;
                            s3 = "" + this.plnames[k] + " of clan " + this.pclan[k] + " finished first, nobody won becuase this is a wasting only game!";
                        }
                        if (this.clangame == 4 && this.pclan[k].toLowerCase().equals(this.gaclan.toLowerCase())) {
                            b3 = true;
                            s3 = "" + this.plnames[k] + " of clan " + this.pclan[k] + " finished first, nobody won becuase " + this.pclan[k] + " should have wasted in this racing vs wasting game!";
                        }
                        if (this.clangame == 5 && !this.pclan[k].toLowerCase().equals(this.gaclan.toLowerCase())) {
                            b3 = true;
                            s3 = "" + this.plnames[k] + " of clan " + this.pclan[k] + " finished first, nobody won becuase " + this.pclan[k] + " should have wasted in this racing vs wasting game!";
                        }
                    }
                }
                if (b3) {
                    this.drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        this.drawcs(120, s3, 0, 0, 0, 0);
                        this.aflk = false;
                    }
                    else {
                        this.drawcs(120, s3, 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkPoints.haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
            }
            if (this.multion < 2) {
                if (!this.holdit && ((checkPoints.wasted == this.nplayers - 1 && this.nplayers != 1) || b2)) {
                    this.drawhi(this.youwastedem, 70);
                    if (!b2) {
                        if (this.aflk) {
                            this.drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                            this.aflk = false;
                        }
                        else {
                            this.drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                            this.aflk = true;
                        }
                    }
                    else if (this.aflk) {
                        this.drawcs(120, "Your clan " + s + " has wasted all the cars!", 0, 0, 0, 0);
                        this.aflk = false;
                    }
                    else {
                        this.drawcs(120, "Your clan " + s + " has wasted all the cars!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkPoints.haltall = true;
                    this.holdit = true;
                    this.winner = true;
                }
                if (!this.holdit && mad.dest && this.cntwis == 8) {
                    if (this.discon != 240) {
                        this.drawhi(this.yourwasted, 70);
                    }
                    else {
                        this.drawhi(this.disco, 70);
                        this.stopchat();
                    }
                    boolean b4 = false;
                    if (this.lan) {
                        b4 = true;
                        for (int l = 0; l < this.nplayers; ++l) {
                            if (l != this.im && this.dested[l] == 0 && this.plnames[l].indexOf("MadBot") == -1) {
                                b4 = false;
                            }
                        }
                    }
                    if (this.fase == 7001 && this.nplayers - (checkPoints.wasted + 1) >= 2 && this.discon != 240 && !b4) {
                        this.exitm = 4;
                    }
                    else {
                        if (this.exitm == 4) {
                            this.exitm = 0;
                        }
                        this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    }
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    for (int n2 = 0; n2 < this.nplayers; ++n2) {
                        if (checkPoints.clear[n2] == checkPoints.nlaps * checkPoints.nsp && checkPoints.pos[n2] == 0) {
                            if (this.clangame == 0) {
                                if (n2 == this.im) {
                                    this.drawhi(this.youwon, 70);
                                    if (this.aflk) {
                                        this.drawcs(120, "You finished first, nice job!", 0, 0, 0, 0);
                                        this.aflk = false;
                                    }
                                    else {
                                        this.drawcs(120, "You finished first, nice job!", 0, 128, 255, 0);
                                        this.aflk = true;
                                    }
                                    this.winner = true;
                                }
                                else {
                                    this.drawhi(this.youlost, 70);
                                    if (this.fase != 7001) {
                                        if (this.aflk) {
                                            this.drawcs(120, "" + this.cd.names[this.sc[n2]] + " finished first, race over!", 0, 0, 0, 0);
                                            this.aflk = false;
                                        }
                                        else {
                                            this.drawcs(120, "" + this.cd.names[this.sc[n2]] + " finished first, race over!", 0, 128, 255, 0);
                                            this.aflk = true;
                                        }
                                    }
                                    else if (this.aflk) {
                                        this.drawcs(120, "" + this.plnames[n2] + " finished first, race over!", 0, 0, 0, 0);
                                        this.aflk = false;
                                    }
                                    else {
                                        this.drawcs(120, "" + this.plnames[n2] + " finished first, race over!", 0, 128, 255, 0);
                                        this.aflk = true;
                                    }
                                    this.winner = false;
                                }
                            }
                            else if (this.pclan[n2].toLowerCase().equals(this.pclan[this.im].toLowerCase())) {
                                this.drawhi(this.youwon, 70);
                                if (this.aflk) {
                                    this.drawcs(120, "Your clan " + this.pclan[this.im] + " finished first, nice job!", 0, 0, 0, 0);
                                    this.aflk = false;
                                }
                                else {
                                    this.drawcs(120, "Your clan " + this.pclan[this.im] + " finished first, nice job!", 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                                this.winner = true;
                            }
                            else {
                                this.drawhi(this.youlost, 70);
                                if (this.aflk) {
                                    this.drawcs(120, "" + this.plnames[n2] + " of clan " + this.pclan[n2] + " finished first, race over!", 0, 0, 0, 0);
                                    this.aflk = false;
                                }
                                else {
                                    this.drawcs(120, "" + this.plnames[n2] + " of clan " + this.pclan[n2] + " finished first, race over!", 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                                this.winner = false;
                            }
                            this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                            checkPoints.haltall = true;
                            this.holdit = true;
                        }
                    }
                }
            }
            else {
                if (!this.holdit && (checkPoints.wasted >= this.nplayers - 1 || b2)) {
                    String string = "Someone";
                    if (!b2) {
                        for (int n3 = 0; n3 < this.nplayers; ++n3) {
                            if (checkPoints.dested[n3] == 0) {
                                string = this.plnames[n3];
                            }
                        }
                    }
                    else {
                        string = "Clan " + s + "";
                    }
                    this.drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        this.drawcs(120, "" + string + " has wasted all the cars!", 0, 0, 0, 0);
                        this.aflk = false;
                    }
                    else {
                        this.drawcs(120, "" + string + " has wasted all the cars!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkPoints.haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    for (int n4 = 0; n4 < this.nplayers; ++n4) {
                        if (checkPoints.clear[n4] == checkPoints.nlaps * checkPoints.nsp && checkPoints.pos[n4] == 0) {
                            this.drawhi(this.gamefinished, 70);
                            if (this.clangame == 0) {
                                if (this.aflk) {
                                    this.drawcs(120, "" + this.plnames[n4] + " finished first, race over!", 0, 0, 0, 0);
                                    this.aflk = false;
                                }
                                else {
                                    this.drawcs(120, "" + this.plnames[n4] + " finished first, race over!", 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                            }
                            else if (this.aflk) {
                                this.drawcs(120, "Clan " + this.pclan[n4] + " finished first, race over!", 0, 0, 0, 0);
                                this.aflk = false;
                            }
                            else {
                                this.drawcs(120, "Clan " + this.pclan[n4] + " finished first, race over!", 0, 128, 255, 0);
                                this.aflk = true;
                            }
                            this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                            checkPoints.haltall = true;
                            this.holdit = true;
                            this.winner = false;
                        }
                    }
                }
                if (!this.holdit && this.discon == 240) {
                    this.drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        this.drawcs(120, "Game got disconnected!", 0, 0, 0, 0);
                        this.aflk = false;
                    }
                    else {
                        this.drawcs(120, "Game got disconnected!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkPoints.haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    this.rd.drawImage(this.wgame, 311, 20, null);
                    if (!this.clanchat) {
                        this.drawcs(397, "Click any player on the right to follow!", 0, 0, 0, 0);
                        if (!this.lan) {
                            this.drawcs(412, "Press [V] to change view.  Press [Enter] to exit.", 0, 0, 0, 0);
                        }
                        else {
                            this.drawcs(412, "Press [V] to change view.", 0, 0, 0, 0);
                        }
                    }
                }
            }
            if (b) {
                if (checkPoints.stage != 10 && this.multion < 2 && this.nplayers != 1 && this.arrace != control.arrace) {
                    this.arrace = control.arrace;
                    if (this.multion == 1 && this.arrace) {
                        control.radar = true;
                    }
                    if (this.arrace) {
                        this.wasay = true;
                        this.say = " Arrow now pointing at >  CARS";
                        if (this.multion == 1) {
                            this.say += "    Press [S] to toggle Radar!";
                        }
                        this.tcnt = -5;
                    }
                    if (!this.arrace) {
                        this.wasay = false;
                        this.say = " Arrow now pointing at >  TRACK";
                        if (this.multion == 1) {
                            this.say += "    Press [S] to toggle Radar!";
                        }
                        this.tcnt = -5;
                        this.cntan = 20;
                        this.alocked = -1;
                        this.alocked = -1;
                    }
                }
                if (!this.holdit && this.fase != -6 && this.starcnt == 0 && this.multion < 2 && checkPoints.stage != 10) {
                    this.arrow(mad.point, mad.missedcp, checkPoints, this.arrace);
                    if (!this.arrace) {
                        if (this.auscnt == 45 && mad.capcnt == 0 && this.exitm == 0) {
                            if (mad.missedcp > 0) {
                                if (mad.missedcp > 15 && mad.missedcp < 50) {
                                    if (this.flk) {
                                        this.drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                                    }
                                    else {
                                        this.drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
                                    }
                                }
                                ++mad.missedcp;
                                if (mad.missedcp == 70) {
                                    mad.missedcp = -2;
                                }
                            }
                            else if (mad.mtouch && this.cntovn < 70) {
                                if (Math.abs(this.ana) > 100) {
                                    ++this.cntan;
                                }
                                else if (this.cntan != 0) {
                                    --this.cntan;
                                }
                                if (this.cntan > 40) {
                                    ++this.cntovn;
                                    this.cntan = 40;
                                    if (this.flk) {
                                        this.drawcs(70, "Wrong Way!", 255, 150, 0, 0);
                                        this.flk = false;
                                    }
                                    else {
                                        this.drawcs(70, "Wrong Way!", 255, 0, 0, 2);
                                        this.flk = true;
                                    }
                                }
                            }
                        }
                    }
                    else if (this.alocked != this.lalocked) {
                        if (this.alocked != -1) {
                            this.wasay = true;
                            this.say = " Arrow Locked on >  " + this.plnames[this.alocked] + "";
                            this.tcnt = -5;
                        }
                        else {
                            this.wasay = true;
                            this.say = "Arrow Unlocked!";
                            this.tcnt = 10;
                        }
                        this.lalocked = this.alocked;
                    }
                }
                if (this.m.darksky) {
                    final Color color = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
                    final float[] array = new float[3];
                    Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], array);
                    array[2] = 0.6f;
                    this.rd.setColor(Color.getHSBColor(array[0], array[1], array[2]));
                    this.rd.fillRect(602, 9, 54, 14);
                    this.rd.drawLine(601, 10, 601, 21);
                    this.rd.drawLine(600, 12, 600, 19);
                    this.rd.fillRect(607, 29, 49, 14);
                    this.rd.drawLine(606, 30, 606, 41);
                    this.rd.drawLine(605, 32, 605, 39);
                    this.rd.fillRect(18, 6, 155, 14);
                    this.rd.drawLine(17, 7, 17, 18);
                    this.rd.drawLine(16, 9, 16, 16);
                    this.rd.drawLine(173, 7, 173, 18);
                    this.rd.drawLine(174, 9, 174, 16);
                    this.rd.fillRect(40, 26, 107, 21);
                    this.rd.drawLine(39, 27, 39, 45);
                    this.rd.drawLine(38, 29, 38, 43);
                    this.rd.drawLine(147, 27, 147, 45);
                    this.rd.drawLine(148, 29, 148, 43);
                }
                this.rd.drawImage(this.dmg, 600, 7, null);
                this.rd.drawImage(this.pwr, 600, 27, null);
                this.rd.drawImage(this.lap, 19, 7, null);
                this.rd.setColor(new Color(0, 0, 100));
                this.rd.drawString("" + (mad.nlaps + 1) + " / " + checkPoints.nlaps + "", 51, 18);
                this.rd.drawImage(this.was, 92, 7, null);
                this.rd.setColor(new Color(0, 0, 100));
                this.rd.drawString("" + checkPoints.wasted + " / " + (this.nplayers - 1) + "", 150, 18);
                this.rd.drawImage(this.pos, 42, 27, null);
                this.rd.drawImage(this.rank[checkPoints.pos[mad.im]], 110, 28, null);
                this.drawstat(this.cd.maxmag[mad.cn], mad.hitmag, mad.newcar, mad.power);
                if (control.radar && checkPoints.stage != 10) {
                    this.radarstat(mad, contO, checkPoints);
                }
            }
            if (!this.holdit) {
                if (this.starcnt != 0 && this.starcnt <= 35) {
                    if (this.starcnt == 35 && !this.mutes) {
                        this.three.play();
                    }
                    if (this.starcnt == 24) {
                        this.gocnt = 2;
                        if (!this.mutes) {
                            this.two.play();
                        }
                    }
                    if (this.starcnt == 13) {
                        this.gocnt = 1;
                        if (!this.mutes) {
                            this.one.play();
                        }
                    }
                    if (this.starcnt == 2) {
                        this.gocnt = 0;
                        if (!this.mutes) {
                            this.go.play();
                        }
                    }
                    this.duds = 0;
                    if (this.starcnt <= 37 && this.starcnt > 32) {
                        this.duds = 1;
                    }
                    if (this.starcnt <= 26 && this.starcnt > 21) {
                        this.duds = 1;
                    }
                    if (this.starcnt <= 15 && this.starcnt > 10) {
                        this.duds = 1;
                    }
                    if (this.starcnt <= 4) {
                        this.duds = 2;
                    }
                    if (this.dudo != -1) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3f));
                        this.rd.drawImage(this.dude[this.duds], this.dudo, 0, null);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                    }
                    if (this.gocnt != 0) {
                        this.rd.drawImage(this.cntdn[this.gocnt], 385, 50, null);
                    }
                    else {
                        this.rd.drawImage(this.cntdn[this.gocnt], 363, 50, null);
                    }
                }
                if (this.looped != 0 && mad.loop == 2) {
                    this.looped = 0;
                }
                if (mad.power < 45.0f) {
                    if (this.tcnt == 30 && this.auscnt == 45 && mad.mtouch && mad.capcnt == 0 && this.exitm == 0) {
                        if (this.looped != 2) {
                            if (this.pwcnt < 70 || (this.pwcnt < 100 && this.looped != 0)) {
                                if (this.pwflk) {
                                    this.drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
                                    this.pwflk = false;
                                }
                                else {
                                    this.drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
                                    this.pwflk = true;
                                }
                            }
                        }
                        else if (this.pwcnt < 100) {
                            String s4 = "";
                            if (this.multion == 0) {
                                s4 = "  (Press Enter)";
                            }
                            if (this.pwflk) {
                                this.drawcs(110, "Please read the Game Instructions!" + s4 + "", 0, 0, 200, 0);
                                this.pwflk = false;
                            }
                            else {
                                this.drawcs(110, "Please read the Game Instructions!" + s4 + "", 255, 100, 0, 0);
                                this.pwflk = true;
                            }
                        }
                        ++this.pwcnt;
                        if (this.pwcnt == 300) {
                            this.pwcnt = 0;
                            if (this.looped != 0) {
                                ++this.looped;
                                if (this.looped == 4) {
                                    this.looped = 2;
                                }
                            }
                        }
                    }
                }
                else if (this.pwcnt != 0) {
                    this.pwcnt = 0;
                }
                if (mad.capcnt == 0) {
                    if (this.tcnt < 30) {
                        if (this.exitm == 0) {
                            if (this.tflk) {
                                if (!this.wasay) {
                                    this.drawcs(105, this.say, 0, 0, 0, 0);
                                }
                                else {
                                    this.drawcs(105, this.say, 0, 0, 0, 0);
                                }
                                this.tflk = false;
                            }
                            else {
                                if (!this.wasay) {
                                    this.drawcs(105, this.say, 0, 128, 255, 0);
                                }
                                else {
                                    this.drawcs(105, this.say, 255, 128, 0, 0);
                                }
                                this.tflk = true;
                            }
                        }
                        ++this.tcnt;
                    }
                    else if (this.wasay) {
                        this.wasay = false;
                    }
                    if (this.auscnt < 45) {
                        if (this.exitm == 0) {
                            if (this.aflk) {
                                this.drawcs(85, this.asay, 98, 176, 255, 0);
                                this.aflk = false;
                            }
                            else {
                                this.drawcs(85, this.asay, 0, 128, 255, 0);
                                this.aflk = true;
                            }
                        }
                        ++this.auscnt;
                    }
                }
                else if (this.exitm == 0) {
                    if (this.tflk) {
                        this.drawcs(110, "Bad Landing!", 0, 0, 200, 0);
                        this.tflk = false;
                    }
                    else {
                        this.drawcs(110, "Bad Landing!", 255, 100, 0, 0);
                        this.tflk = true;
                    }
                }
                if (mad.trcnt == 10) {
                    this.loop = "";
                    this.spin = "";
                    this.asay = "";
                    int n5 = 0;
                    while (mad.travzy > 225) {
                        mad.travzy -= 360;
                        ++n5;
                    }
                    while (mad.travzy < -225) {
                        mad.travzy += 360;
                        --n5;
                    }
                    if (n5 == 1) {
                        this.loop = "Forward loop";
                    }
                    if (n5 == 2) {
                        this.loop = "double Forward";
                    }
                    if (n5 == 3) {
                        this.loop = "triple Forward";
                    }
                    if (n5 >= 4) {
                        this.loop = "massive Forward looping";
                    }
                    if (n5 == -1) {
                        this.loop = "Backloop";
                    }
                    if (n5 == -2) {
                        this.loop = "double Back";
                    }
                    if (n5 == -3) {
                        this.loop = "triple Back";
                    }
                    if (n5 <= -4) {
                        this.loop = "massive Back looping";
                    }
                    if (n5 == 0) {
                        if (mad.ftab && mad.btab) {
                            this.loop = "Tabletop and reversed Tabletop";
                        }
                        else if (mad.ftab || mad.btab) {
                            this.loop = "Tabletop";
                        }
                    }
                    if (n5 > 0 && mad.btab) {
                        this.loop = "Hanged " + this.loop;
                    }
                    if (n5 < 0 && mad.ftab) {
                        this.loop = "Hanged " + this.loop;
                    }
                    if (this.loop != "") {
                        this.asay = this.asay + " " + this.loop;
                    }
                    int n6 = 0;
                    mad.travxy = Math.abs(mad.travxy);
                    while (mad.travxy > 270) {
                        mad.travxy -= 360;
                        ++n6;
                    }
                    if (n6 == 0 && mad.rtab) {
                        if (this.loop == "") {
                            this.spin = "Tabletop";
                        }
                        else {
                            this.spin = "Flipside";
                        }
                    }
                    if (n6 == 1) {
                        this.spin = "Rollspin";
                    }
                    if (n6 == 2) {
                        this.spin = "double Rollspin";
                    }
                    if (n6 == 3) {
                        this.spin = "triple Rollspin";
                    }
                    if (n6 >= 4) {
                        this.spin = "massive Roll spinning";
                    }
                    int n7 = 0;
                    boolean b5 = false;
                    mad.travxz = Math.abs(mad.travxz);
                    while (mad.travxz > 90) {
                        mad.travxz -= 180;
                        n7 += 180;
                        if (n7 > 900) {
                            n7 = 900;
                            b5 = true;
                        }
                    }
                    if (n7 != 0) {
                        if (this.loop == "" && this.spin == "") {
                            this.asay = this.asay + " " + n7;
                            if (b5) {
                                this.asay += " and beyond";
                            }
                        }
                        else {
                            if (this.spin != "") {
                                if (this.loop == "") {
                                    this.asay = this.asay + " " + this.spin;
                                }
                                else {
                                    this.asay = this.asay + " with " + this.spin;
                                }
                            }
                            this.asay = this.asay + " by " + n7;
                            if (b5) {
                                this.asay += " and beyond";
                            }
                        }
                    }
                    else if (this.spin != "") {
                        if (this.loop == "") {
                            this.asay = this.asay + " " + this.spin;
                        }
                        else {
                            this.asay = this.asay + " by " + this.spin;
                        }
                    }
                    if (this.asay != "") {
                        this.auscnt -= 15;
                    }
                    if (this.loop != "") {
                        this.auscnt -= 25;
                    }
                    if (this.spin != "") {
                        this.auscnt -= 25;
                    }
                    if (n7 != 0) {
                        this.auscnt -= 25;
                    }
                    if (this.auscnt < 45) {
                        if (!this.mutes) {
                            this.powerup.play();
                        }
                        if (this.auscnt < -20) {
                            this.auscnt = -20;
                        }
                        int n8 = 0;
                        if (mad.powerup > 20.0f) {
                            n8 = 1;
                        }
                        if (mad.powerup > 40.0f) {
                            n8 = 2;
                        }
                        if (mad.powerup > 150.0f) {
                            n8 = 3;
                        }
                        if (mad.surfer) {
                            this.asay = " " + this.adj[4][(int)(this.m.random() * 3.0f)] + this.asay;
                        }
                        if (n8 != 3) {
                            this.asay = this.adj[n8][(int)(this.m.random() * 3.0f)] + this.asay + this.exlm[n8];
                        }
                        else {
                            this.asay = this.adj[n8][(int)(this.m.random() * 3.0f)];
                        }
                        if (!this.wasay) {
                            this.tcnt = this.auscnt;
                            if (mad.power != 98.0f) {
                                this.say = "Power Up " + (int)(100.0f * mad.powerup / 98.0f) + "%";
                            }
                            else {
                                this.say = "Power To The MAX";
                            }
                            if (this.skidup) {
                                this.skidup = false;
                            }
                            else {
                                this.skidup = true;
                            }
                        }
                    }
                }
                if (mad.newcar) {
                    if (!this.wasay) {
                        this.say = "Car Fixed";
                        this.tcnt = 0;
                    }
                    if (this.crashup) {
                        this.crashup = false;
                    }
                    else {
                        this.crashup = true;
                    }
                }
                for (int n9 = 0; n9 < this.nplayers; ++n9) {
                    if (this.dested[n9] != checkPoints.dested[n9] && n9 != this.im) {
                        this.dested[n9] = checkPoints.dested[n9];
                        if (this.fase != 7001) {
                            if (this.dested[n9] == 1) {
                                this.wasay = true;
                                this.say = "" + this.cd.names[this.sc[n9]] + " has been wasted!";
                                this.tcnt = -15;
                            }
                            if (this.dested[n9] == 2) {
                                this.wasay = true;
                                this.say = "You wasted " + this.cd.names[this.sc[n9]] + "!";
                                this.tcnt = -15;
                            }
                        }
                        else {
                            if (this.dested[n9] == 1) {
                                this.wasay = true;
                                this.say = "" + this.plnames[n9] + " has been wasted!";
                                this.tcnt = -15;
                            }
                            if (this.dested[n9] == 2) {
                                this.wasay = true;
                                if (this.multion < 2) {
                                    this.say = "You wasted " + this.plnames[n9] + "!";
                                }
                                else {
                                    this.say = "" + this.plnames[this.im] + " wasted " + this.plnames[n9] + "!";
                                }
                                this.tcnt = -15;
                            }
                            if (this.dested[n9] == 3) {
                                this.wasay = true;
                                this.say = "" + this.plnames[n9] + " has been wasted! (Disconnected)";
                                this.tcnt = -15;
                            }
                        }
                    }
                }
                if (this.multion >= 2 && this.alocked != this.lalocked) {
                    if (this.alocked != -1) {
                        this.wasay = false;
                        this.say = "Now following " + this.plnames[this.alocked] + "!";
                        this.tcnt = -15;
                    }
                    this.lalocked = this.alocked;
                    this.clear = mad.clear;
                }
                if (this.clear != mad.clear && mad.clear != 0) {
                    if (!this.wasay) {
                        this.say = "Checkpoint!";
                        this.tcnt = 15;
                    }
                    this.clear = mad.clear;
                    if (!this.mutes) {
                        this.checkpoint.play();
                    }
                    this.cntovn = 0;
                    if (this.cntan != 0) {
                        this.cntan = 0;
                    }
                }
            }
        }
        if (this.m.lightn != -1) {
            final int available = this.strack.sClip.stream.available();
            this.m.lton = false;
            if (available <= 6380001 && available > 5368001) {
                this.m.lton = true;
            }
            if (available <= 2992001 && available > 1320001) {
                this.m.lton = true;
            }
        }
    }

    public void drawstat(final int n, int n2, final boolean b, final float n3) {
        final int[] array = new int[4];
        final int[] array2 = new int[4];
        if (n2 > n) {
            n2 = n;
        }
        final int n4 = (int)(98.0f * (n2 / n));
        array[0] = 662;
        array2[0] = 11;
        array[1] = 662;
        array2[1] = 20;
        array[2] = 662 + n4;
        array2[2] = 20;
        array[3] = 662 + n4;
        array2[3] = 11;
        final int n5 = 244;
        int n6 = 244;
        final int n7 = 11;
        if (n4 > 33) {
            n6 = (int)(244.0f - 233.0f * ((n4 - 33) / 65.0f));
        }
        if (n4 > 70) {
            if (this.dmcnt < 10) {
                if (this.dmflk) {
                    n6 = 170;
                    this.dmflk = false;
                }
                else {
                    this.dmflk = true;
                }
            }
            ++this.dmcnt;
            if (this.dmcnt > 167.0 - n4 * 1.5) {
                this.dmcnt = 0;
            }
        }
        int n8 = (int)(n5 + n5 * (this.m.snap[0] / 100.0f));
        if (n8 > 255) {
            n8 = 255;
        }
        if (n8 < 0) {
            n8 = 0;
        }
        int n9 = (int)(n6 + n6 * (this.m.snap[1] / 100.0f));
        if (n9 > 255) {
            n9 = 255;
        }
        if (n9 < 0) {
            n9 = 0;
        }
        int n10 = (int)(n7 + n7 * (this.m.snap[2] / 100.0f));
        if (n10 > 255) {
            n10 = 255;
        }
        if (n10 < 0) {
            n10 = 0;
        }
        this.rd.setColor(new Color(n8, n9, n10));
        this.rd.fillPolygon(array, array2, 4);
        array[0] = 662;
        array2[0] = 31;
        array[1] = 662;
        array2[1] = 40;
        array[2] = (int)(662.0f + n3);
        array2[2] = 40;
        array[3] = (int)(662.0f + n3);
        array2[3] = 31;
        int n11 = 128;
        if (n3 == 98.0f) {
            n11 = 64;
        }
        int n12 = (int)(190.0 + n3 * 0.37);
        int n13 = 244;
        if (this.auscnt < 45 && this.aflk) {
            n11 = 128;
            n12 = 244;
            n13 = 244;
        }
        int n14 = (int)(n11 + n11 * (this.m.snap[0] / 100.0f));
        if (n14 > 255) {
            n14 = 255;
        }
        if (n14 < 0) {
            n14 = 0;
        }
        int n15 = (int)(n12 + n12 * (this.m.snap[1] / 100.0f));
        if (n15 > 255) {
            n15 = 255;
        }
        if (n15 < 0) {
            n15 = 0;
        }
        int n16 = (int)(n13 + n13 * (this.m.snap[2] / 100.0f));
        if (n16 > 255) {
            n16 = 255;
        }
        if (n16 < 0) {
            n16 = 0;
        }
        this.rd.setColor(new Color(n14, n15, n16));
        this.rd.fillPolygon(array, array2, 4);
    }

    public void drawhi(final Image image, final int n) {
        if (this.m.darksky) {
            final Color color = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
            final float[] array = new float[3];
            Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], array);
            array[2] = 0.6f;
            final Color hsbColor = Color.getHSBColor(array[0], array[1], array[2]);
            this.rd.setColor(hsbColor);
            this.rd.fillRoundRect(390 - image.getWidth(this.ob) / 2, n - 2, image.getWidth(this.ob) + 20, image.getHeight(this.ob) + 2, 7, 20);
            this.rd.setColor(new Color((int)(hsbColor.getRed() / 1.1), (int)(hsbColor.getGreen() / 1.1), (int)(hsbColor.getBlue() / 1.1)));
            this.rd.drawRoundRect(390 - image.getWidth(this.ob) / 2, n - 2, image.getWidth(this.ob) + 20, image.getHeight(this.ob) + 2, 7, 20);
        }
        this.rd.drawImage(image, 400 - image.getWidth(this.ob) / 2, n, null);
    }

    public void drawcs(final int n, final String s, int n2, int n3, int n4, final int n5) {
        if (n5 != 3 && n5 != 4 && n5 != 5) {
            n2 += (int)(n2 * (this.m.snap[0] / 100.0f));
            if (n2 > 255) {
                n2 = 255;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            n3 += (int)(n3 * (this.m.snap[1] / 100.0f));
            if (n3 > 255) {
                n3 = 255;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            n4 += (int)(n4 * (this.m.snap[2] / 100.0f));
            if (n4 > 255) {
                n4 = 255;
            }
            if (n4 < 0) {
                n4 = 0;
            }
        }
        if (n5 == 4) {
            n2 -= (int)(n2 * (this.m.snap[0] / 100.0f));
            if (n2 > 255) {
                n2 = 255;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            n3 -= (int)(n3 * (this.m.snap[1] / 100.0f));
            if (n3 > 255) {
                n3 = 255;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            n4 -= (int)(n4 * (this.m.snap[2] / 100.0f));
            if (n4 > 255) {
                n4 = 255;
            }
            if (n4 < 0) {
                n4 = 0;
            }
        }
        if (n5 == 1) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2 + 1, n + 1);
        }
        if (n5 == 2) {
            n2 = (n2 * 2 + this.m.csky[0] * 1) / 3;
            if (n2 > 255) {
                n2 = 255;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            n3 = (n3 * 2 + this.m.csky[1] * 1) / 3;
            if (n3 > 255) {
                n3 = 255;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            n4 = (n4 * 2 + this.m.csky[2] * 1) / 3;
            if (n4 > 255) {
                n4 = 255;
            }
            if (n4 < 0) {
                n4 = 0;
            }
        }
        if (n5 == 5) {
            this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
            this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2 + 1, n + 1);
        }
        this.rd.setColor(new Color(n2, n3, n4));
        this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2, n);
    }

    public void arrow(final int n, final int n2, final CheckPoints checkPoints, final boolean b) {
        final int[] array = new int[7];
        final int[] array2 = new int[7];
        final int[] array3 = new int[7];
        final int n3 = 400;
        final int n4 = -90;
        final int n5 = 700;
        for (int i = 0; i < 7; ++i) {
            array2[i] = n4;
        }
        array[0] = n3;
        array3[0] = n5 + 110;
        array[1] = n3 - 35;
        array3[1] = n5 + 50;
        array[2] = n3 - 15;
        array3[2] = n5 + 50;
        array[3] = n3 - 15;
        array3[3] = n5 - 50;
        array[4] = n3 + 15;
        array3[4] = n5 - 50;
        array[5] = n3 + 15;
        array3[5] = n5 + 50;
        array[6] = n3 + 35;
        array3[6] = n5 + 50;
        int n7;
        if (!b) {
            int n6 = 0;
            if (checkPoints.x[n] - checkPoints.opx[this.im] >= 0) {
                n6 = 180;
            }
            // NOTE: semantics changed
            float divisor = checkPoints.x[n] - checkPoints.opx[this.im];
            if (divisor == 0.0f) {
              divisor = 1;
            }
            n7 = (int)(90 + n6 + Math.atan((checkPoints.z[n] - checkPoints.opz[this.im]) / (divisor)) / 0.017453292519943295);
        }
        else {
            int alocked = 0;
            if (this.multion == 0 || this.alocked == -1) {
                int py = -1;
                int n8 = 0;
                for (int j = 0; j < this.nplayers; ++j) {
                    if (j != this.im && (this.py(checkPoints.opx[this.im] / 100, checkPoints.opx[j] / 100, checkPoints.opz[this.im] / 100, checkPoints.opz[j] / 100) < py || py == -1) && (n8 == 0 || checkPoints.onscreen[j] != 0) && checkPoints.dested[j] == 0) {
                        alocked = j;
                        py = this.py(checkPoints.opx[this.im] / 100, checkPoints.opx[j] / 100, checkPoints.opz[this.im] / 100, checkPoints.opz[j] / 100);
                        if (checkPoints.onscreen[j] != 0) {
                            n8 = 1;
                        }
                    }
                }
            }
            else {
                alocked = this.alocked;
            }
            int n9 = 0;
            if (checkPoints.opx[alocked] - checkPoints.opx[this.im] >= 0) {
                n9 = 180;
            }
            n7 = (int)(90 + n9 + Math.atan((checkPoints.opz[alocked] - checkPoints.opz[this.im]) / (checkPoints.opx[alocked] - checkPoints.opx[this.im])) / 0.017453292519943295);
            if (this.multion == 0) {
                this.drawcs(13, "[                                ]", 76, 67, 240, 0);
                this.drawcs(13, this.cd.names[this.sc[alocked]], 0, 0, 0, 0);
            }
            else {
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.drawcs(17, "[                                ]", 76, 67, 240, 0);
                this.drawcs(12, this.plnames[alocked], 0, 0, 0, 0);
                this.rd.setFont(new Font("Arial", 0, 10));
                this.ftm = this.rd.getFontMetrics();
                this.drawcs(24, this.cd.names[this.sc[alocked]], 0, 0, 0, 0);
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
        }
        int k;
        for (k = n7 + this.m.xz; k < 0; k += 360) {}
        while (k > 180) {
            k -= 360;
        }
        if (!b) {
            if (k > 130) {
                k = 130;
            }
            if (k < -130) {
                k = -130;
            }
        }
        else {
            if (k > 100) {
                k = 100;
            }
            if (k < -100) {
                k = -100;
            }
        }
        if (Math.abs(this.ana - k) < 180) {
            if (Math.abs(this.ana - k) < 10) {
                this.ana = k;
            }
            else if (this.ana < k) {
                this.ana += 10;
            }
            else {
                this.ana -= 10;
            }
        }
        else {
            if (k < 0) {
                this.ana += 15;
                if (this.ana > 180) {
                    this.ana -= 360;
                }
            }
            if (k > 0) {
                this.ana -= 15;
                if (this.ana < -180) {
                    this.ana += 360;
                }
            }
        }
        this.rot(array, array3, n3, n5, this.ana, 7);
        final int abs = Math.abs(this.ana);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!b) {
            if (abs > 7 || n2 > 0 || n2 == -2 || this.cntan != 0) {
                for (int l = 0; l < 7; ++l) {
                    array[l] = this.xs(array[l], array3[l]);
                    array2[l] = this.ys(array2[l], array3[l]);
                }
                int n10 = (int)(190.0f + 190.0f * (this.m.snap[0] / 100.0f));
                if (n10 > 255) {
                    n10 = 255;
                }
                if (n10 < 0) {
                    n10 = 0;
                }
                int n11 = (int)(255.0f + 255.0f * (this.m.snap[1] / 100.0f));
                if (n11 > 255) {
                    n11 = 255;
                }
                if (n11 < 0) {
                    n11 = 0;
                }
                int n12 = 0;
                if (n2 <= 0) {
                    if (abs <= 45 && n2 != -2 && this.cntan == 0) {
                        n10 = (n10 * abs + this.m.csky[0] * (45 - abs)) / 45;
                        n11 = (n11 * abs + this.m.csky[1] * (45 - abs)) / 45;
                        n12 = (n12 * abs + this.m.csky[2] * (45 - abs)) / 45;
                    }
                    if (abs >= 90) {
                        int n13 = (int)(255.0f + 255.0f * (this.m.snap[0] / 100.0f));
                        if (n13 > 255) {
                            n13 = 255;
                        }
                        if (n13 < 0) {
                            n13 = 0;
                        }
                        n10 = (n10 * (140 - abs) + n13 * (abs - 90)) / 50;
                        if (n10 > 255) {
                            n10 = 255;
                        }
                    }
                }
                else if (this.flk) {
                    n10 = (int)(255.0f + 255.0f * (this.m.snap[0] / 100.0f));
                    if (n10 > 255) {
                        n10 = 255;
                    }
                    if (n10 < 0) {
                        n10 = 0;
                    }
                    this.flk = false;
                }
                else {
                    n10 = (int)(255.0f + 255.0f * (this.m.snap[0] / 100.0f));
                    if (n10 > 255) {
                        n10 = 255;
                    }
                    if (n10 < 0) {
                        n10 = 0;
                    }
                    n11 = (int)(220.0f + 220.0f * (this.m.snap[1] / 100.0f));
                    if (n11 > 255) {
                        n11 = 255;
                    }
                    if (n11 < 0) {
                        n11 = 0;
                    }
                    this.flk = true;
                }
                this.rd.setColor(new Color(n10, n11, n12));
                this.rd.fillPolygon(array, array2, 7);
                int n14 = (int)(115.0f + 115.0f * (this.m.snap[0] / 100.0f));
                if (n14 > 255) {
                    n14 = 255;
                }
                if (n14 < 0) {
                    n14 = 0;
                }
                int n15 = (int)(170.0f + 170.0f * (this.m.snap[1] / 100.0f));
                if (n15 > 255) {
                    n15 = 255;
                }
                if (n15 < 0) {
                    n15 = 0;
                }
                int n16 = 0;
                if (n2 <= 0) {
                    if (abs <= 45 && n2 != -2 && this.cntan == 0) {
                        n14 = (n14 * abs + this.m.csky[0] * (45 - abs)) / 45;
                        n15 = (n15 * abs + this.m.csky[1] * (45 - abs)) / 45;
                        n16 = (n16 * abs + this.m.csky[2] * (45 - abs)) / 45;
                    }
                }
                else if (this.flk) {
                    n14 = (int)(255.0f + 255.0f * (this.m.snap[0] / 100.0f));
                    if (n14 > 255) {
                        n14 = 255;
                    }
                    if (n14 < 0) {
                        n14 = 0;
                    }
                    n15 = 0;
                }
                this.rd.setColor(new Color(n14, n15, n16));
                this.rd.drawPolygon(array, array2, 7);
            }
        }
        else {
            int n17 = 0;
            if (this.multion != 0) {
                n17 = 8;
            }
            for (int n18 = 0; n18 < 7; ++n18) {
                array[n18] = this.xs(array[n18], array3[n18]);
                array2[n18] = this.ys(array2[n18], array3[n18]) + n17;
            }
            int n19 = (int)(159.0f + 159.0f * (this.m.snap[0] / 100.0f));
            if (n19 > 255) {
                n19 = 255;
            }
            if (n19 < 0) {
                n19 = 0;
            }
            int n20 = (int)(207.0f + 207.0f * (this.m.snap[1] / 100.0f));
            if (n20 > 255) {
                n20 = 255;
            }
            if (n20 < 0) {
                n20 = 0;
            }
            int n21 = (int)(255.0f + 255.0f * (this.m.snap[2] / 100.0f));
            if (n21 > 255) {
                n21 = 255;
            }
            if (n21 < 0) {
                n21 = 0;
            }
            this.rd.setColor(new Color(n19, n20, n21));
            this.rd.fillPolygon(array, array2, 7);
            int n22 = (int)(120.0f + 120.0f * (this.m.snap[0] / 100.0f));
            if (n22 > 255) {
                n22 = 255;
            }
            if (n22 < 0) {
                n22 = 0;
            }
            int n23 = (int)(114.0f + 114.0f * (this.m.snap[1] / 100.0f));
            if (n23 > 255) {
                n23 = 255;
            }
            if (n23 < 0) {
                n23 = 0;
            }
            int n24 = (int)(255.0f + 255.0f * (this.m.snap[2] / 100.0f));
            if (n24 > 255) {
                n24 = 255;
            }
            if (n24 < 0) {
                n24 = 0;
            }
            this.rd.setColor(new Color(n22, n23, n24));
            this.rd.drawPolygon(array, array2, 7);
        }
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    public void radarstat(final Mad mad, final ContO contO, final CheckPoints checkPoints) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5f));
        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
        this.rd.fillRoundRect(10, 55, 172, 172, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
        for (int i = 0; i < checkPoints.n; ++i) {
            int n = i + 1;
            if (i == checkPoints.n - 1) {
                n = 0;
            }
            boolean b = false;
            if (checkPoints.typ[n] == -3) {
                n = 0;
                b = true;
            }
            final int[] array = { (int)(96.0f - (checkPoints.opx[this.im] - checkPoints.x[i]) / checkPoints.prox), (int)(96.0f - (checkPoints.opx[this.im] - checkPoints.x[n]) / checkPoints.prox) };
            final int[] array2 = { (int)(141.0f - (checkPoints.z[i] - checkPoints.opz[this.im]) / checkPoints.prox), (int)(141.0f - (checkPoints.z[n] - checkPoints.opz[this.im]) / checkPoints.prox) };
            this.rot(array, array2, 96, 141, mad.cxz, 2);
            this.rd.drawLine(array[0], array2[0], array[1], array2[1]);
            if (b) {
                break;
            }
        }
        if (this.arrace || this.multion > 1) {
            final int[] array3 = new int[this.nplayers];
            final int[] array4 = new int[this.nplayers];
            for (int j = 0; j < this.nplayers; ++j) {
                array3[j] = (int)(96.0f - (checkPoints.opx[this.im] - checkPoints.opx[j]) / checkPoints.prox);
                array4[j] = (int)(141.0f - (checkPoints.opz[j] - checkPoints.opz[this.im]) / checkPoints.prox);
            }
            this.rot(array3, array4, 96, 141, mad.cxz, this.nplayers);
            int n2 = 0;
            int n3 = (int)(80.0f + 80.0f * (this.m.snap[1] / 100.0f));
            if (n3 > 255) {
                n3 = 255;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            int n4 = (int)(159.0f + 159.0f * (this.m.snap[2] / 100.0f));
            if (n4 > 255) {
                n4 = 255;
            }
            if (n4 < 0) {
                n4 = 0;
            }
            for (int k = 0; k < this.nplayers; ++k) {
                if (k != this.im && checkPoints.dested[k] == 0) {
                    if (this.clangame != 0) {
                        int n5;
                        int n6;
                        int n7;
                        if (this.pclan[k].toLowerCase().equals(this.gaclan.toLowerCase())) {
                            n5 = 159;
                            n6 = 80;
                            n7 = 0;
                        }
                        else {
                            n5 = 0;
                            n6 = 80;
                            n7 = 159;
                        }
                        n2 = (int)(n5 + n5 * (this.m.snap[0] / 100.0f));
                        if (n2 > 255) {
                            n2 = 255;
                        }
                        if (n2 < 0) {
                            n2 = 0;
                        }
                        n3 = (int)(n6 + n6 * (this.m.snap[1] / 100.0f));
                        if (n3 > 255) {
                            n3 = 255;
                        }
                        if (n3 < 0) {
                            n3 = 0;
                        }
                        n4 = (int)(n7 + n7 * (this.m.snap[2] / 100.0f));
                        if (n4 > 255) {
                            n4 = 255;
                        }
                        if (n4 < 0) {
                            n4 = 0;
                        }
                    }
                    int n8 = 2;
                    if (this.alocked == k) {
                        n8 = 3;
                        this.rd.setColor(new Color(n2, n3, n4));
                    }
                    else {
                        this.rd.setColor(new Color((n2 + this.m.csky[0]) / 2, (this.m.csky[1] + n3) / 2, (n4 + this.m.csky[2]) / 2));
                    }
                    this.rd.drawLine(array3[k] - n8, array4[k], array3[k] + n8, array4[k]);
                    this.rd.drawLine(array3[k], array4[k] + n8, array3[k], array4[k] - n8);
                    this.rd.setColor(new Color(n2, n3, n4));
                    this.rd.fillRect(array3[k] - 1, array4[k] - 1, 3, 3);
                }
            }
        }
        int n9 = (int)(159.0f + 159.0f * (this.m.snap[0] / 100.0f));
        if (n9 > 255) {
            n9 = 255;
        }
        if (n9 < 0) {
            n9 = 0;
        }
        int n10 = 0;
        int n11 = 0;
        if (this.clangame != 0) {
            int n12;
            int n13;
            int n14;
            if (this.pclan[this.im].toLowerCase().equals(this.gaclan.toLowerCase())) {
                n12 = 159;
                n13 = 80;
                n14 = 0;
            }
            else {
                n12 = 0;
                n13 = 80;
                n14 = 159;
            }
            n9 = (int)(n12 + n12 * (this.m.snap[0] / 100.0f));
            if (n9 > 255) {
                n9 = 255;
            }
            if (n9 < 0) {
                n9 = 0;
            }
            n10 = (int)(n13 + n13 * (this.m.snap[1] / 100.0f));
            if (n10 > 255) {
                n10 = 255;
            }
            if (n10 < 0) {
                n10 = 0;
            }
            n11 = (int)(n14 + n14 * (this.m.snap[2] / 100.0f));
            if (n11 > 255) {
                n11 = 255;
            }
            if (n11 < 0) {
                n11 = 0;
            }
        }
        this.rd.setColor(new Color((n9 + this.m.csky[0]) / 2, (this.m.csky[1] + n10) / 2, (n11 + this.m.csky[2]) / 2));
        this.rd.drawLine(96, 139, 96, 143);
        this.rd.drawLine(94, 141, 98, 141);
        this.rd.setColor(new Color(n9, n10, n11));
        this.rd.fillRect(95, 140, 3, 3);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        if (this.m.darksky) {
            final Color color = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
            final float[] array5 = new float[3];
            Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], array5);
            array5[2] = 0.6f;
            this.rd.setColor(Color.getHSBColor(array5[0], array5[1], array5[2]));
            this.rd.fillRect(5, 232, 181, 17);
            this.rd.drawLine(4, 233, 4, 247);
            this.rd.drawLine(3, 235, 3, 245);
            this.rd.drawLine(186, 233, 186, 247);
            this.rd.drawLine(187, 235, 187, 245);
        }
        this.rd.drawImage(this.sped, 7, 234, null);
        final int n15 = contO.x - this.lcarx;
        this.lcarx = contO.x;
        final int n16 = contO.y - this.lcary;
        this.lcary = contO.y;
        final int n17 = contO.z - this.lcarz;
        this.lcarz = contO.z;
        final float n18 = (float)Math.sqrt(n15 * n15 + n17 * n17) * 1.4f * 21.0f * 60.0f * 60.0f / 100000.0f;
        final float n19 = n18 * 0.621371f;
        this.rd.setColor(new Color(0, 0, 100));
        this.rd.drawString("" + (int)n18, 62, 245);
        this.rd.drawString("" + (int)n19, 132, 245);
    }

    public void playsounds(final Mad mad, final Control control, final int n) {
        if ((this.fase == 0 || this.fase == 7001) && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
            boolean b = (control.up && mad.speed > 0.0f) || (control.down && mad.speed < 10.0f);
            boolean b2 = (mad.skid == 1 && control.handb) || Math.abs(mad.scz[0] - (mad.scz[1] + mad.scz[0] + mad.scz[2] + mad.scz[3]) / 4.0f) > 1.0f || Math.abs(mad.scx[0] - (mad.scx[1] + mad.scx[0] + mad.scx[2] + mad.scx[3]) / 4.0f) > 1.0f;
            boolean b3 = false;
            if (control.up && mad.speed < 10.0f) {
                b2 = true;
                b = true;
                b3 = true;
            }
            if (b && mad.mtouch) {
                if (!mad.capsized) {
                    if (!b2) {
                        if (mad.power != 98.0f) {
                            if (Math.abs(mad.speed) > 0.0f && Math.abs(mad.speed) <= this.cd.swits[mad.cn][0]) {
                                int n2 = (int)(3.0f * Math.abs(mad.speed) / this.cd.swits[mad.cn][0]);
                                if (n2 == 2) {
                                    if (this.pwait == 0) {
                                        n2 = 0;
                                    }
                                    else {
                                        --this.pwait;
                                    }
                                }
                                else {
                                    this.pwait = 7;
                                }
                                this.sparkeng(n2, mad.cn);
                            }
                            if (Math.abs(mad.speed) > this.cd.swits[mad.cn][0] && Math.abs(mad.speed) <= this.cd.swits[mad.cn][1]) {
                                int n3 = (int)(3.0f * (Math.abs(mad.speed) - this.cd.swits[mad.cn][0]) / (this.cd.swits[mad.cn][1] - this.cd.swits[mad.cn][0]));
                                if (n3 == 2) {
                                    if (this.pwait == 0) {
                                        n3 = 0;
                                    }
                                    else {
                                        --this.pwait;
                                    }
                                }
                                else {
                                    this.pwait = 7;
                                }
                                this.sparkeng(n3, mad.cn);
                            }
                            if (Math.abs(mad.speed) > this.cd.swits[mad.cn][1] && Math.abs(mad.speed) <= this.cd.swits[mad.cn][2]) {
                                this.sparkeng((int)(3.0f * (Math.abs(mad.speed) - this.cd.swits[mad.cn][1]) / (this.cd.swits[mad.cn][2] - this.cd.swits[mad.cn][1])), mad.cn);
                            }
                        }
                        else {
                            int n4 = 2;
                            if (this.pwait == 0) {
                                if (Math.abs(mad.speed) > this.cd.swits[mad.cn][1]) {
                                    n4 = 3;
                                }
                            }
                            else {
                                --this.pwait;
                            }
                            this.sparkeng(n4, mad.cn);
                        }
                    }
                    else {
                        this.sparkeng(-1, mad.cn);
                        if (b3) {
                            if (this.stopcnt <= 0) {
                                this.air[5].loop();
                                this.stopcnt = 10;
                            }
                        }
                        else if (this.stopcnt <= -2) {
                            this.air[2 + (int)(this.m.random() * 3.0f)].loop();
                            this.stopcnt = 7;
                        }
                    }
                }
                else {
                    this.sparkeng(3, mad.cn);
                }
                this.grrd = false;
                this.aird = false;
            }
            else {
                this.pwait = 15;
                if (!mad.mtouch && !this.grrd && this.m.random() > 0.4) {
                    this.air[(int)(this.m.random() * 4.0f)].loop();
                    this.stopcnt = 5;
                    this.grrd = true;
                }
                if (!mad.wtouch && !this.aird) {
                    this.stopairs();
                    this.air[(int)(this.m.random() * 4.0f)].loop();
                    this.stopcnt = 10;
                    this.aird = true;
                }
                this.sparkeng(-1, mad.cn);
            }
            if (mad.cntdest != 0 && this.cntwis < 7) {
                if (!this.pwastd) {
                    this.wastd.loop();
                    this.pwastd = true;
                }
            }
            else {
                if (this.pwastd) {
                    this.wastd.stop_clip();
                    this.pwastd = false;
                }
                if (this.cntwis == 7 && !this.mutes) {
                    this.firewasted.play();
                }
            }
        }
        else {
            this.sparkeng(-2, mad.cn);
            if (this.pwastd) {
                this.wastd.stop_clip();
                this.pwastd = false;
            }
        }
        if (this.stopcnt != -20) {
            if (this.stopcnt == 1) {
                this.stopairs();
            }
            --this.stopcnt;
        }
        if (this.bfcrash != 0) {
            --this.bfcrash;
        }
        if (this.bfscrape != 0) {
            --this.bfscrape;
        }
        if (this.bfsc1 != 0) {
            --this.bfsc1;
        }
        if (this.bfsc2 != 0) {
            --this.bfsc2;
        }
        if (this.bfskid != 0) {
            --this.bfskid;
        }
        if (mad.newcar) {
            this.cntwis = 0;
        }
        if (this.fase == 0 || this.fase == 7001 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
            if (this.mutes != control.mutes) {
                this.mutes = control.mutes;
            }
            if (control.mutem != this.mutem) {
                this.mutem = control.mutem;
                if (this.mutem) {
                    if (this.loadedt) {
                        this.strack.stop();
                    }
                }
                else if (this.loadedt) {
                    this.strack.resume();
                }
            }
        }
        if (mad.cntdest != 0 && this.cntwis < 7) {
            if (mad.dest) {
                ++this.cntwis;
            }
        }
        else {
            if (mad.cntdest == 0) {
                this.cntwis = 0;
            }
            if (this.cntwis == 7) {
                this.cntwis = 8;
            }
        }
        if (this.app.applejava) {
            this.closesounds();
        }
    }

    public void stopairs() {
        for (int i = 0; i < 6; ++i) {
            this.air[i].stop_clip();
        }
    }

    public void sparkeng(int n, final int lcn) {
        if (this.lcn != lcn) {
            for (int i = 0; i < 5; ++i) {
                if (this.pengs[i]) {
                    this.engs[this.cd.enginsignature[this.lcn]][i].stop_clip();
                    this.pengs[i] = false;
                }
            }
            this.lcn = lcn;
        }
        ++n;
        for (int j = 0; j < 5; ++j) {
            if (n == j) {
                if (!this.pengs[j]) {
                    this.engs[this.cd.enginsignature[lcn]][j].loop();
                    this.pengs[j] = true;
                }
            }
            else if (this.pengs[j]) {
                this.engs[this.cd.enginsignature[lcn]][j].stop_clip();
                this.pengs[j] = false;
            }
        }
    }

    public void crash(final float n, final int n2) {
        if (this.bfcrash == 0) {
            if (n2 == 0) {
                if (Math.abs(n) > 25.0f && Math.abs(n) < 170.0f) {
                    if (!this.mutes) {
                        this.lowcrash[this.crshturn].play();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(n) >= 170.0f) {
                    if (!this.mutes) {
                        this.crash[this.crshturn].play();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(n) > 25.0f) {
                    if (this.crashup) {
                        --this.crshturn;
                    }
                    else {
                        ++this.crshturn;
                    }
                    if (this.crshturn == -1) {
                        this.crshturn = 2;
                    }
                    if (this.crshturn == 3) {
                        this.crshturn = 0;
                    }
                }
            }
            if (n2 == -1) {
                if (Math.abs(n) > 25.0f && Math.abs(n) < 170.0f) {
                    if (!this.mutes) {
                        this.lowcrash[2].play();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(n) > 170.0f) {
                    if (!this.mutes) {
                        this.crash[2].play();
                    }
                    this.bfcrash = 2;
                }
            }
            if (n2 == 1) {
                if (!this.mutes) {
                    this.tires.play();
                }
                this.bfcrash = 3;
            }
        }
    }

    public void skid(final int n, final float n2) {
        if (this.bfcrash == 0 && this.bfskid == 0 && n2 > 150.0f) {
            if (n == 0) {
                if (!this.mutes) {
                    this.skid[this.skflg].play();
                }
                if (this.skidup) {
                    ++this.skflg;
                }
                else {
                    --this.skflg;
                }
                if (this.skflg == 3) {
                    this.skflg = 0;
                }
                if (this.skflg == -1) {
                    this.skflg = 2;
                }
            }
            else {
                if (!this.mutes) {
                    this.dustskid[this.dskflg].play();
                }
                if (this.skidup) {
                    ++this.dskflg;
                }
                else {
                    --this.dskflg;
                }
                if (this.dskflg == 3) {
                    this.dskflg = 0;
                }
                if (this.dskflg == -1) {
                    this.dskflg = 2;
                }
            }
            this.bfskid = 35;
        }
    }

    public void scrape(final int n, final int n2, final int n3) {
        if (this.bfscrape == 0 && Math.sqrt(n * n + n2 * n2 + n3 * n3) / 10.0 > 10.0) {
            int n4 = 0;
            if (this.m.random() > this.m.random()) {
                n4 = 1;
            }
            if (n4 == 0) {
                this.sturn1 = 0;
                ++this.sturn0;
                if (this.sturn0 == 3) {
                    n4 = 1;
                    this.sturn1 = 1;
                    this.sturn0 = 0;
                }
            }
            else {
                this.sturn0 = 0;
                ++this.sturn1;
                if (this.sturn1 == 3) {
                    n4 = 0;
                    this.sturn0 = 1;
                    this.sturn1 = 0;
                }
            }
            if (!this.mutes) {
                this.scrape[n4].play();
            }
            this.bfscrape = 5;
        }
    }

    public void gscrape(final int n, final int n2, final int n3) {
        if ((this.bfsc1 == 0 || this.bfsc2 == 0) && Math.sqrt(n * n + n2 * n2 + n3 * n3) / 10.0 > 15.0) {
            if (this.bfsc1 == 0) {
                if (!this.mutes) {
                    this.scrape[2].stop_clip();
                    this.scrape[2].play();
                }
                this.bfsc1 = 12;
                this.bfsc2 = 6;
            }
            else {
                if (!this.mutes) {
                    this.scrape[3].stop_clip();
                    this.scrape[3].play();
                }
                this.bfsc2 = 12;
                this.bfsc1 = 6;
            }
        }
    }

    public void closesounds() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                this.engs[i][j].checkopen();
            }
        }
        for (int k = 0; k < 6; ++k) {
            this.air[k].checkopen();
        }
        this.tires.checkopen();
        this.checkpoint.checkopen();
        this.carfixed.checkopen();
        this.powerup.checkopen();
        this.three.checkopen();
        this.two.checkopen();
        this.one.checkopen();
        this.go.checkopen();
        this.wastd.checkopen();
        this.firewasted.checkopen();
        for (int l = 0; l < 3; ++l) {
            this.skid[l].checkopen();
            this.dustskid[l].checkopen();
            this.crash[l].checkopen();
            this.lowcrash[l].checkopen();
            this.scrape[l].checkopen();
        }
    }

    public void rot(final int[] array, final int[] array2, final int n, final int n2, final int n3, final int n4) {
        if (n3 != 0) {
            for (int i = 0; i < n4; ++i) {
                final int n5 = array[i];
                final int n6 = array2[i];
                array[i] = n + (int)((n5 - n) * this.m.cos(n3) - (n6 - n2) * this.m.sin(n3));
                array2[i] = n2 + (int)((n5 - n) * this.m.sin(n3) + (n6 - n2) * this.m.cos(n3));
            }
        }
    }

    public int xs(final int n, int n2) {
        if (n2 < 50) {
            n2 = 50;
        }
        return (n2 - this.m.focus_point) * (this.m.cx - n) / n2 + n;
    }

    public int ys(final int n, int n2) {
        if (n2 < 50) {
            n2 = 50;
        }
        return (n2 - this.m.focus_point) * (this.m.cy - n) / n2 + n;
    }

    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
    }

    public float pys(final int n, final int n2, final int n3, final int n4) {
        return (float)Math.sqrt((n - n2) * (n - n2) + (n3 - n4) * (n3 - n4));
    }

    public void snap(final int n) {
        this.dmg = this.loadsnap(this.odmg);
        this.pwr = this.loadsnap(this.opwr);
        this.was = this.loadsnap(this.owas);
        this.lap = this.loadsnap(this.olap);
        this.pos = this.loadsnap(this.opos);
        this.sped = this.loadsnap(this.osped);
        for (int i = 0; i < 8; ++i) {
            this.rank[i] = this.loadsnap(this.orank[i]);
        }
        for (int j = 0; j < 4; ++j) {
            this.cntdn[j] = this.loadsnap(this.ocntdn[j]);
        }
        if (this.multion != 0) {
            this.wgame = this.loadsnap(this.owgame);
            this.exitgame = this.loadsnap(this.oexitgame);
            this.gamefinished = this.loadsnap(this.ogamefinished);
            this.disco = this.loadsnap(this.odisco);
        }
        this.yourwasted = this.loadsnap(this.oyourwasted);
        this.youlost = this.loadsnap(this.oyoulost);
        this.youwon = this.loadsnap(this.oyouwon);
        this.youwastedem = this.loadsnap(this.oyouwastedem);
        this.gameh = this.loadsnap(this.ogameh);
        this.loadingmusic = this.loadopsnap(this.oloadingmusic, n, 76);
        this.star[0] = this.loadopsnap(this.ostar[0], n, 0);
        this.star[1] = this.loadopsnap(this.ostar[1], n, 0);
        this.flaot = this.loadopsnap(this.oflaot, n, 1);
    }

    public boolean overon(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return n5 > n && n5 < n + n3 && n6 > n2 && n6 < n2 + n4;
    }

    public boolean over(final Image image, final int n, final int n2, final int n3, final int n4) {
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        return n > n3 - 5 && n < n3 + width + 5 && n2 > n4 - 5 && n2 < n4 + height + 5;
    }

    public void fleximage(final Image image, final int n, final int n2) {
        if (!this.badmac) {
            if (n == 0) {
                this.flexpix = new int[360000];
                final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, 800, 450, this.flexpix, 0, 800);
                try {
                    pixelGrabber.grabPixels();
                }
                catch (InterruptedException ex) {}
            }
            int n3 = 0;
            int red = 0;
            int green = 0;
            int blue = 0;
            int n4 = (int)(Math.random() * 128.0);
            int n5 = (int)(5.0 + Math.random() * 15.0);
            for (int i = 0; i < 360000; ++i) {
                final Color color = new Color(this.flexpix[i]);
                int n6;
                int n7;
                int n8;
                if (n3 == 0) {
                    n6 = (red = color.getRed());
                    n7 = (green = color.getGreen());
                    n8 = (blue = color.getBlue());
                }
                else {
                    n6 = (red = (int)((color.getRed() + red * 0.38f * n) / (1.0f + 0.38f * n)));
                    n7 = (green = (int)((color.getGreen() + green * 0.38f * n) / (1.0f + 0.38f * n)));
                    n8 = (blue = (int)((color.getBlue() + blue * 0.38f * n) / (1.0f + 0.38f * n)));
                }
                if (++n3 == 800) {
                    n3 = 0;
                }
                final int n9 = (int)((n6 * 17 + n7 + n8 + n4) / 21.0f);
                final int n10 = (int)((n7 * 17 + n6 + n8 + n4) / 22.0f);
                final int n11 = (int)((n8 * 17 + n6 + n7 + n4) / 24.0f);
                if (--n5 == 0) {
                    n4 = (int)(Math.random() * 128.0);
                    n5 = (int)(5.0 + Math.random() * 15.0);
                }
                this.flexpix[i] = new Color(n9, n10, n11).getRGB();
            }
            this.fleximg = this.createImage(new MemoryImageSource(800, 450, this.flexpix, 0, 800));
            this.rd.drawImage(this.fleximg, 0, 0, null);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1f));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        }
    }

    private Image loadsnap(final Image image) {
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex) {}
        for (int i = 0; i < width * height; ++i) {
            final Color color = new Color(array[width * height - 1]);
            final Color color2 = new Color(array[i]);
            if (color2.getRed() != color2.getGreen() && color2.getGreen() != color2.getBlue()) {
                int n = (int)(color2.getRed() + color2.getRed() * (this.m.snap[0] / 100.0f));
                if (n > 255) {
                    n = 255;
                }
                if (n < 0) {
                    n = 0;
                }
                int n2 = (int)(color2.getGreen() + color2.getGreen() * (this.m.snap[1] / 100.0f));
                if (n2 > 255) {
                    n2 = 255;
                }
                if (n2 < 0) {
                    n2 = 0;
                }
                int n3 = (int)(color2.getBlue() + color2.getBlue() * (this.m.snap[2] / 100.0f));
                if (n3 > 255) {
                    n3 = 255;
                }
                if (n3 < 0) {
                    n3 = 0;
                }
                array[i] = (0xFF000000 | n << 16 | n2 << 8 | n3);
            }
            else {
                int n4 = (int)((color.getRed() - color2.getRed()) / color.getRed() * 255.0f);
                if (n4 > 255) {
                    n4 = 255;
                }
                if (n4 < 0) {
                    n4 = 0;
                }
                array[i] = (n4 << 24 | 0x0 | 0x0 | 0x0);
            }
        }
        final BufferedImage bufferedImage = new BufferedImage(width, height, 2);
        bufferedImage.setRGB(0, 0, width, height, array, 0, width);
        return bufferedImage;
    }

    private Image loadopsnap(final Image image, int n, final int n2) {
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex) {}
        if (n < 0) {
            n = 33;
        }
        int n3 = 0;
        if (n2 == 1) {
            n3 = array[61993];
        }
        final int[] array2 = { this.m.snap[0], this.m.snap[1], this.m.snap[2] };
        while (array2[0] + array2[1] + array2[2] < -30) {
            for (int i = 0; i < 3; ++i) {
                if (array2[i] < 50) {
                    final int[] array3 = array2;
                    final int n4 = i;
                    ++array3[n4];
                }
            }
        }
        for (int j = 0; j < width * height; ++j) {
            if (array[j] != array[n2]) {
                final Color color = new Color(array[j]);
                int n5;
                int n6;
                int n7;
                if (n2 == 1 && array[j] == n3) {
                    n5 = (int)(237.0f - 237.0f * (array2[0] / 150.0f));
                    if (n5 > 255) {
                        n5 = 255;
                    }
                    if (n5 < 0) {
                        n5 = 0;
                    }
                    n6 = (int)(237.0f - 237.0f * (array2[1] / 150.0f));
                    if (n6 > 255) {
                        n6 = 255;
                    }
                    if (n6 < 0) {
                        n6 = 0;
                    }
                    n7 = (int)(237.0f - 237.0f * (array2[2] / 150.0f));
                    if (n7 > 255) {
                        n7 = 255;
                    }
                    if (n7 < 0) {
                        n7 = 0;
                    }
                    if (n == 11) {
                        n5 = 250;
                        n6 = 250;
                        n7 = 250;
                    }
                }
                else {
                    n5 = (int)(color.getRed() - color.getRed() * (array2[0] / 100.0f));
                    if (n5 > 255) {
                        n5 = 255;
                    }
                    if (n5 < 0) {
                        n5 = 0;
                    }
                    n6 = (int)(color.getGreen() - color.getGreen() * (array2[1] / 100.0f));
                    if (n6 > 255) {
                        n6 = 255;
                    }
                    if (n6 < 0) {
                        n6 = 0;
                    }
                    n7 = (int)(color.getBlue() - color.getBlue() * (array2[2] / 100.0f));
                    if (n7 > 255) {
                        n7 = 255;
                    }
                    if (n7 < 0) {
                        n7 = 0;
                    }
                }
                array[j] = new Color(n5, n6, n7).getRGB();
            }
        }
        return this.createImage(new MemoryImageSource(width, height, array, 0, width));
    }

    private Image pressed(final Image image) {
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex) {}
        for (int i = 0; i < width * height; ++i) {
            if (array[i] != array[width * height - 1]) {
                array[i] = -16777216;
            }
        }
        return this.createImage(new MemoryImageSource(width, height, array, 0, width));
    }

    private Image bressed(final Image image) {
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex) {}
        final Color color = new Color(247, 255, 165);
        for (int i = 0; i < width * height; ++i) {
            if (array[i] != array[width * height - 1]) {
                array[i] = color.getRGB();
            }
        }
        return this.createImage(new MemoryImageSource(width, height, array, 0, width));
    }

    public void pauseimage(final Image image) {
        if (!this.badmac) {
            final int[] array = new int[360000];
            final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, 800, 450, array, 0, 800);
            try {
                pixelGrabber.grabPixels();
            }
            catch (InterruptedException ex) {}
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            for (int i = 0; i < 360000; ++i) {
                final Color color = new Color(array[i]);
                int n5;
                if (n4 == 0) {
                    n5 = (n3 = (color.getRed() + color.getGreen() + color.getBlue()) / 3);
                }
                else {
                    n5 = (n3 = (color.getRed() + color.getGreen() + color.getBlue() + n3 * 30) / 33);
                }
                if (++n4 == 800) {
                    n4 = 0;
                }
                if (i > 800 * (8 + n2) + 281 && n2 < 188) {
                    final int n6 = (n5 + 60) / 3;
                    final int n7 = (n5 + 135) / 3;
                    final int n8 = (n5 + 220) / 3;
                    if (++n == 237) {
                        ++n2;
                        n = 0;
                    }
                    array[i] = new Color(n6, n7, n8).getRGB();
                }
                else {
                    array[i] = new Color(n5, n5, n5).getRGB();
                }
            }
            this.fleximg = this.createImage(new MemoryImageSource(800, 450, array, 0, 800));
            this.rd.drawImage(this.fleximg, 0, 0, null);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5f));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        }
    }

    public void jflexo() {
        if (!this.badmac) {
            final int[] array = new int[360000];
            final PixelGrabber pixelGrabber = new PixelGrabber(this.app.offImage, 0, 0, 800, 450, array, 0, 800);
            try {
                pixelGrabber.grabPixels();
            }
            catch (InterruptedException ex) {}
            int red = 0;
            int blue = 0;
            int green = 0;
            int n = 0;
            for (int i = 0; i < 360000; ++i) {
                final Color color = new Color(array[i]);
                int n2;
                int n3;
                int n4;
                if (n == 0) {
                    n2 = (red = color.getRed());
                    n3 = (green = color.getGreen());
                    n4 = (blue = color.getBlue());
                }
                else {
                    n2 = (red = (color.getRed() + red * 10) / 11);
                    n3 = (green = (color.getGreen() + green * 10) / 11);
                    n4 = (blue = (color.getBlue() + blue * 10) / 11);
                }
                if (++n == 800) {
                    n = 0;
                }
                array[i] = new Color(n2, n3, n4).getRGB();
            }
            this.rd.drawImage(this.createImage(new MemoryImageSource(800, 450, array, 0, 800)), 0, 0, null);
        }
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5f));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        }
    }

    public void pingstat() {
        final int n = (int)(100.0 * Math.random());
        try {
            final URL url = new URL("http://c.statcounter.com/9994681/0/14bb645e/1/?reco=" + n + "");
            url.openConnection().setConnectTimeout(5000);
            final Image image = Toolkit.getDefaultToolkit().createImage(url);
            final MediaTracker mediaTracker = new MediaTracker(this.app);
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);
            mediaTracker.removeImage(image, 0);
        }
        catch (Exception ex) {}
    }

    public Image getImage(final String s) {
        final Image image = Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "" + s + "");
        final MediaTracker mediaTracker = new MediaTracker(this.app);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        }
        catch (Exception ex) {}
        return image;
    }

    private Image loadimage(final byte[] array, final MediaTracker mediaTracker, final Toolkit toolkit) {
        final Image image = toolkit.createImage(array);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        }
        catch (Exception ex) {}
        return image;
    }

    private Image loadude(final byte[] array, final MediaTracker mediaTracker, final Toolkit toolkit) {
        final Image image = toolkit.createImage(array);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        }
        catch (Exception ex) {}
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array2 = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array2, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex2) {}
        for (int i = 0; i < width * height; ++i) {
            final Color color = new Color(array2[i]);
            if (color.getGreen() > color.getRed() + 5 && color.getGreen() > color.getBlue() + 5) {
                int n = (int)(255.0f - (color.getGreen() - (color.getRed() + color.getBlue()) / 2) * 1.5f);
                if (n > 255) {
                    n = 255;
                }
                if (n < 0) {
                    n = 0;
                }
                array2[i] = (n << 24 | 0x0 | 0x0 | 0x0);
            }
        }
        final BufferedImage bufferedImage = new BufferedImage(width, height, 2);
        bufferedImage.setRGB(0, 0, width, height, array2, 0, width);
        return bufferedImage;
    }

    private Image loadBimage(final byte[] array, final MediaTracker mediaTracker, final Toolkit toolkit, final int n) {
        final Image image = toolkit.createImage(array);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        }
        catch (Exception ex) {}
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array2 = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array2, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex2) {}
        for (int i = 0; i < width * height; ++i) {
            if (array2[i] != array2[0] || n != 0) {
                final Color color = new Color(array2[i]);
                final float[] array3 = new float[3];
                Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), array3);
                array3[0] = 0.12f;
                array3[1] = 0.45f;
                if (n == 3) {
                    array3[0] = 0.13f;
                    array3[1] = 0.45f;
                }
                array2[i] = Color.getHSBColor(array3[0], array3[1], array3[2]).getRGB();
            }
        }
        if (n == 2) {
            final Color color2 = new Color(array2[0]);
            final int n2 = 0x40000000 | color2.getRed() << 16 | color2.getGreen() << 8 | color2.getBlue();
            final Color color3 = new Color(array2[1]);
            final int n3 = Integer.MIN_VALUE | color3.getRed() << 16 | color3.getGreen() << 8 | color3.getBlue();
            for (int j = 2; j < width * height; ++j) {
                if (array2[j] == array2[0]) {
                    array2[j] = n2;
                }
                if (array2[j] == array2[1]) {
                    array2[j] = n3;
                }
            }
            array2[0] = n2;
            array2[1] = n3;
        }
        Image image2;
        if (n == 2) {
            final BufferedImage bufferedImage = new BufferedImage(width, height, 2);
            bufferedImage.setRGB(0, 0, width, height, array2, 0, width);
            image2 = bufferedImage;
        }
        else {
            image2 = this.createImage(new MemoryImageSource(width, height, array2, 0, width));
        }
        return image2;
    }

    private Image dodgen(final Image image) {
        final int height = image.getHeight(this.ob);
        final int width = image.getWidth(this.ob);
        final int[] array = new int[width * height];
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, array, 0, width);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex) {}
        for (int i = 0; i < width * height; ++i) {
            final Color color = new Color(array[i]);
            int n = color.getRed() * 4 + 90;
            if (n > 255) {
                n = 255;
            }
            if (n < 0) {
                n = 0;
            }
            int n2 = color.getGreen() * 4 + 90;
            if (n2 > 255) {
                n2 = 255;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            int n3 = color.getBlue() * 4 + 90;
            if (n3 > 255) {
                n3 = 255;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            array[i] = new Color(n, n2, n3).getRGB();
        }
        return this.createImage(new MemoryImageSource(width, height, array, 0, width));
    }

    private void smokeypix(final byte[] array, final MediaTracker mediaTracker, final Toolkit toolkit) {
        final Image image = toolkit.createImage(array);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        }
        catch (Exception ex) {}
        final PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, 466, 202, this.smokey, 0, 466);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex2) {}
        for (int i = 0; i < 94132; ++i) {
            if (this.smokey[i] != this.smokey[0]) {
                final Color color = new Color(this.smokey[i]);
                final float[] array2 = new float[3];
                Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), array2);
                array2[0] = 0.11f;
                array2[1] = 0.45f;
                this.smokey[i] = Color.getHSBColor(array2[0], array2[1], array2[2]).getRGB();
            }
        }
    }

    private void makecarsbgc(final Image image, final Image image2) {
        final int[] array = new int[268000];
        final PixelGrabber pixelGrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, array, 0, 670);
        try {
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException ex) {}
        final int[] array2 = new int[20700];
        final PixelGrabber pixelGrabber2 = new PixelGrabber(image, 0, 0, 92, 225, array2, 0, 92);
        try {
            pixelGrabber2.grabPixels();
        }
        catch (InterruptedException ex2) {}
        final int[] array3 = new int[2112];
        final PixelGrabber pixelGrabber3 = new PixelGrabber(image2, 0, 0, 88, 24, array3, 0, 88);
        try {
            pixelGrabber3.grabPixels();
        }
        catch (InterruptedException ex3) {}
        for (int i = 0; i < 670; ++i) {
            for (int j = 0; j < 400; ++j) {
                if (i > 14 && i < 106 && j > 11 && j < 236 && array2[i - 14 + (j - 11) * 92] != array2[0]) {
                    final Color color = new Color(array[i + j * 670]);
                    final Color color2 = new Color(array2[i - 14 + (j - 11) * 92]);
                    int n = (int)(color.getRed() * 0.33 + color2.getRed() * 0.67);
                    if (n > 255) {
                        n = 255;
                    }
                    if (n < 0) {
                        n = 0;
                    }
                    int n2 = (int)(color.getGreen() * 0.33 + color2.getGreen() * 0.67);
                    if (n2 > 255) {
                        n2 = 255;
                    }
                    if (n2 < 0) {
                        n2 = 0;
                    }
                    int n3 = (int)(color.getBlue() * 0.33 + color2.getBlue() * 0.67);
                    if (n3 > 255) {
                        n3 = 255;
                    }
                    if (n3 < 0) {
                        n3 = 0;
                    }
                    array[i + j * 670] = new Color(n, n2, n3).getRGB();
                }
                if (i > 564 && i < 656 && j > 11 && j < 236 && array2[i - 564 + (j - 11) * 92] != array2[0]) {
                    final Color color3 = new Color(array[i + j * 670]);
                    final Color color4 = new Color(array2[i - 564 + (j - 11) * 92]);
                    int n4 = (int)(color3.getRed() * 0.33 + color4.getRed() * 0.67);
                    if (n4 > 255) {
                        n4 = 255;
                    }
                    if (n4 < 0) {
                        n4 = 0;
                    }
                    int n5 = (int)(color3.getGreen() * 0.33 + color4.getGreen() * 0.67);
                    if (n5 > 255) {
                        n5 = 255;
                    }
                    if (n5 < 0) {
                        n5 = 0;
                    }
                    int n6 = (int)(color3.getBlue() * 0.33 + color4.getBlue() * 0.67);
                    if (n6 > 255) {
                        n6 = 255;
                    }
                    if (n6 < 0) {
                        n6 = 0;
                    }
                    array[i + j * 670] = new Color(n4, n5, n6).getRGB();
                }
                if (i > 440 && i < 528 && j > 53 && j < 77 && array3[i - 440 + (j - 53) * 88] != array3[0]) {
                    final Color color5 = new Color(array[i + j * 670]);
                    final Color color6 = new Color(array3[i - 440 + (j - 53) * 88]);
                    int n7 = (int)(color5.getRed() * 0.33 + color6.getRed() * 0.67);
                    if (n7 > 255) {
                        n7 = 255;
                    }
                    if (n7 < 0) {
                        n7 = 0;
                    }
                    int n8 = (int)(color5.getGreen() * 0.33 + color6.getGreen() * 0.67);
                    if (n8 > 255) {
                        n8 = 255;
                    }
                    if (n8 < 0) {
                        n8 = 0;
                    }
                    int n9 = (int)(color5.getBlue() * 0.33 + color6.getBlue() * 0.67);
                    if (n9 > 255) {
                        n9 = 255;
                    }
                    if (n9 < 0) {
                        n9 = 0;
                    }
                    array[i + j * 670] = new Color(n7, n8, n9).getRGB();
                }
            }
        }
        this.carsbgc = this.createImage(new MemoryImageSource(670, 400, array, 0, 670));
    }

    public void carsbginflex() {
        if (!this.badmac) {
            this.flatr = 0;
            this.flyr = (int)(this.m.random() * 160.0f - 80.0f);
            this.flyrdest = (int)(this.flyr + this.m.random() * 160.0f - 80.0f);
            this.flang = 1;
            this.flexpix = new int[268000];
            final PixelGrabber pixelGrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, this.flexpix, 0, 670);
            try {
                pixelGrabber.grabPixels();
            }
            catch (InterruptedException ex) {}
        }
    }

    public void drawSmokeCarsbg() {
        if (!this.badmac) {
            if (Math.abs(this.flyr - this.flyrdest) > 20) {
                if (this.flyr > this.flyrdest) {
                    this.flyr -= 20;
                }
                else {
                    this.flyr += 20;
                }
            }
            else {
                this.flyr = this.flyrdest;
                this.flyrdest = (int)(this.flyr + this.m.random() * 160.0f - 80.0f);
            }
            if (this.flyr > 160) {
                this.flyr = 160;
            }
            if (this.flatr > 170) {
                ++this.flatrstart;
                this.flatr = this.flatrstart * 3;
                this.flyr = (int)(this.m.random() * 160.0f - 80.0f);
                this.flyrdest = (int)(this.flyr + this.m.random() * 160.0f - 80.0f);
                this.flang = 1;
            }
            for (int i = 0; i < 466; ++i) {
                for (int j = 0; j < 202; ++j) {
                    if (this.smokey[i + j * 466] != this.smokey[0]) {
                        final float pys = this.pys(i, 233, j, this.flyr);
                        final int n = (int)((i - 233) / pys * this.flatr);
                        final int n2 = (int)((j - this.flyr) / pys * this.flatr);
                        final int n3 = i + n + 100 + (j + n2 + 110) * 670;
                        if (i + n + 100 < 670 && i + n + 100 > 0 && j + n2 + 110 < 400 && j + n2 + 110 > 0 && n3 < 268000 && n3 >= 0) {
                            final Color color = new Color(this.flexpix[n3]);
                            final Color color2 = new Color(this.smokey[i + j * 466]);
                            final float n4 = (255.0f - color2.getRed()) / 255.0f;
                            final float n5 = (255.0f - color2.getGreen()) / 255.0f;
                            final float n6 = (255.0f - color2.getBlue()) / 255.0f;
                            int n7 = (int)((color.getRed() * (this.flang * n4) + color2.getRed() * (1.0f - n4)) / (this.flang * n4 + (1.0f - n4)));
                            int n8 = (int)((color.getGreen() * (this.flang * n5) + color2.getGreen() * (1.0f - n5)) / (this.flang * n5 + (1.0f - n5)));
                            int n9 = (int)((color.getBlue() * (this.flang * n6) + color2.getBlue() * (1.0f - n6)) / (this.flang * n6 + (1.0f - n6)));
                            if (n7 > 255) {
                                n7 = 255;
                            }
                            if (n7 < 0) {
                                n7 = 0;
                            }
                            if (n8 > 255) {
                                n8 = 255;
                            }
                            if (n8 < 0) {
                                n8 = 0;
                            }
                            if (n9 > 255) {
                                n9 = 255;
                            }
                            if (n9 < 0) {
                                n9 = 0;
                            }
                            this.flexpix[n3] = new Color(n7, n8, n9).getRGB();
                        }
                    }
                }
            }
            this.flang += 2;
            this.flatr += 10 + this.flatrstart * 2;
            this.rd.drawImage(this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670)), 65, 25, null);
        }
        else {
            this.rd.drawImage(this.carsbg, 65, 25, null);
            ++this.flatrstart;
        }
    }

    public boolean msgcheck(String lowerCase) {
        boolean b = false;
        lowerCase = lowerCase.toLowerCase();
        final String[] array = { "fu ", " rape", "slut ", "screw ", "redtube", "fuck", "fuk", "f*ck", "fu*k", "f**k", "ass hole", "asshole", "dick", "dik", "cock", "cok ", "shit", "damn", "sex", "anal", "whore", "bitch", "biatch", "bich", " ass", "bastard", "cunt", "dildo", "fag", "homo", "mothaf", "motherf", "negro", "nigga", "nigger", "pussy", "gay", "homo", "you punk", "i will kill you" };
        for (int i = 0; i < array.length; ++i) {
            if (lowerCase.indexOf(array[i]) != -1) {
                b = true;
            }
        }
        if (lowerCase.startsWith("ass ")) {
            b = true;
        }
        if (lowerCase.equals("ass")) {
            b = true;
        }
        if (lowerCase.equals("rape")) {
            b = true;
        }
        if (lowerCase.equals("fu")) {
            b = true;
        }
        String string = "";
        String string2 = "";
        int n = 0;
        int n2 = 0;
        int n3;
        for (n3 = 0; n < lowerCase.length() && n3 == 0; ++n) {
            if (n2 == 0) {
                string = string + "" + lowerCase.charAt(n);
                n2 = 1;
            }
            else {
                n2 = 0;
                if (!string2.equals("") && !string2.equals("" + lowerCase.charAt(n))) {
                    n3 = 1;
                }
                string2 = "" + lowerCase.charAt(n);
            }
        }
        if (n3 == 0) {
            for (int j = 0; j < array.length; ++j) {
                if (string.indexOf(array[j]) != -1) {
                    b = true;
                }
            }
        }
        String string3 = "";
        String string4 = "";
        int n4 = 0;
        int n5 = 1;
        int n6;
        for (n6 = 0; n4 < lowerCase.length() && n6 == 0; ++n4) {
            if (n5 == 0) {
                string3 = string3 + "" + lowerCase.charAt(n4);
                n5 = 1;
            }
            else {
                n5 = 0;
                if (!string4.equals("") && !string4.equals("" + lowerCase.charAt(n4))) {
                    n6 = 1;
                }
                string4 = "" + lowerCase.charAt(n4);
            }
        }
        if (n6 == 0) {
            for (int k = 0; k < array.length; ++k) {
                if (string3.indexOf(array[k]) != -1) {
                    b = true;
                }
            }
        }
        String string5 = "";
        String string6 = "";
        int n7 = 0;
        int n8 = 0;
        int n9;
        for (n9 = 0; n7 < lowerCase.length() && n9 == 0; ++n7) {
            if (n8 == 0) {
                string5 = string5 + "" + lowerCase.charAt(n7);
                n8 = 2;
            }
            else {
                --n8;
                if (!string6.equals("") && !string6.equals("" + lowerCase.charAt(n7))) {
                    n9 = 1;
                }
                string6 = "" + lowerCase.charAt(n7);
            }
        }
        if (n9 == 0) {
            for (int l = 0; l < array.length; ++l) {
                if (string5.indexOf(array[l]) != -1) {
                    b = true;
                }
            }
        }
        String string7 = "";
        String string8 = "";
        int n10 = 0;
        int n11 = 1;
        int n12;
        for (n12 = 0; n10 < lowerCase.length() && n12 == 0; ++n10) {
            if (n11 == 0) {
                string7 = string7 + "" + lowerCase.charAt(n10);
                n11 = 2;
            }
            else {
                --n11;
                if (!string8.equals("") && !string8.equals("" + lowerCase.charAt(n10))) {
                    n12 = 1;
                }
                string8 = "" + lowerCase.charAt(n10);
            }
        }
        if (n12 == 0) {
            for (int n13 = 0; n13 < array.length; ++n13) {
                if (string7.indexOf(array[n13]) != -1) {
                    b = true;
                }
            }
        }
        String string9 = "";
        String string10 = "";
        int n14 = 0;
        int n15 = 2;
        int n16;
        for (n16 = 0; n14 < lowerCase.length() && n16 == 0; ++n14) {
            if (n15 == 0) {
                string9 = string9 + "" + lowerCase.charAt(n14);
                n15 = 2;
            }
            else {
                --n15;
                if (!string10.equals("") && !string10.equals("" + lowerCase.charAt(n14))) {
                    n16 = 1;
                }
                string10 = "" + lowerCase.charAt(n14);
            }
        }
        if (n16 == 0) {
            for (int n17 = 0; n17 < array.length; ++n17) {
                if (string9.indexOf(array[n17]) != -1) {
                    b = true;
                }
            }
        }
        return b;
    }

    public boolean drawcarb(final boolean b, final Image image, final String s, final int n, int n2, final int n3, final int n4, final boolean b2) {
        boolean b3 = false;
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        int n5;
        if (b) {
            n5 = this.ftm.stringWidth(s);
            if (s.startsWith("Class")) {
                n5 = 112;
            }
        }
        else {
            n5 = image.getWidth(this.ob);
        }
        int n6 = 0;
        if (n3 > n && n3 < n + n5 + 14 && n4 > n2 && n4 < n2 + 28) {
            n6 = 1;
            if (b2) {
                b3 = true;
            }
        }
        this.rd.drawImage(this.bcl[n6], n, n2, null);
        this.rd.drawImage(this.bc[n6], n + 4, n2, n5 + 6, 28, null);
        this.rd.drawImage(this.bcr[n6], n + n5 + 10, n2, null);
        if (!b && n5 == 73) {
            --n2;
        }
        if (b) {
            if (s.equals("X") && n6 == 1) {
                this.rd.setColor(new Color(255, 0, 0));
            }
            else {
                this.rd.setColor(new Color(0, 0, 0));
            }
            if (s.startsWith("Class")) {
                this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2, n2 + 19);
            }
            else {
                this.rd.drawString(s, n + 7, n2 + 19);
            }
        }
        else {
            this.rd.drawImage(image, n + 7, n2 + 7, null);
        }
        return b3;
    }

    public void drawWarning() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.setFont(new Font("Arial", 1, 22));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(100, "Warning!", 255, 0, 0, 3);
        this.rd.setFont(new Font("Arial", 1, 18));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(150, "Bad language and flooding is strictly prohibited in this game!", 255, 255, 255, 3);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (this.warning < 210) {
            this.drawcs(200, "If you continue typing bad language or flooding your game will shut down.", 200, 200, 200, 3);
        }
        if (this.warning > 210) {
            this.drawcs(200, "Sorry. This was your second warring your game has shut down.", 200, 200, 200, 3);
        }
        if (this.warning > 250) {
            this.stopallnow();
            this.runtyp = 0;
            this.app.repaint();
            this.app.gamer.stop();
            /*try {
              this.app.gamer.join(0);
            } catch (InterruptedException ex) {
              // NOTE: caught here
            }*/
        }
    }

    public int getvalue(final String s, final int n) {
        int intValue = -1;
        try {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            String string = "";
            while (n2 < s.length() && n4 != 2) {
                final String string2 = "" + s.charAt(n2);
                if (string2.equals("|")) {
                    ++n3;
                    if (n4 == 1 || n3 > n) {
                        n4 = 2;
                    }
                }
                else if (n3 == n) {
                    string += string2;
                    n4 = 1;
                }
                ++n2;
            }
            if (string.equals("")) {
                string = "-1";
            }
            intValue = Integer.valueOf(string);
        }
        catch (Exception ex) {}
        return intValue;
    }

    public String getSvalue(final String s, final int n) {
        String s2 = "";
        try {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            String string = "";
            while (n2 < s.length() && n4 != 2) {
                final String string2 = "" + s.charAt(n2);
                if (string2.equals("|")) {
                    ++n3;
                    if (n4 == 1 || n3 > n) {
                        n4 = 2;
                    }
                }
                else if (n3 == n) {
                    string += string2;
                    n4 = 1;
                }
                ++n2;
            }
            s2 = string;
        }
        catch (Exception ex) {}
        return s2;
    }

    // NOTE: added method
    static private void writeObject(java.io.ObjectOutputStream oos) throws java.io.IOException {
      throw new java.io.IOException("Unserializable type: GameSparker");
    }
}
