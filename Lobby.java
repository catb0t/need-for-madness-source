import java.awt.Component;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.net.InetAddress;
import java.awt.Cursor;
import java.util.Date;
import java.io.Reader;
import java.io.InputStreamReader;
import java.awt.Color;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.awt.image.ImageObserver;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Lobby implements Runnable
{
    Graphics2D rd;
    Login lg;
    Globe gb;
    xtGraphics xt;
    CarDefine cd;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    Thread connector;
    int conon;
    boolean regnow;
    boolean lanlogged;
    int fase;
    int stage;
    int laps;
    String stagename;
    int nfix;
    boolean notb;
    boolean[] pessd;
    int[] bx;
    int[] by;
    int[] bw;
    int btn;
    int pbtn;
    int nflk;
    int ncnt;
    int rerr;
    int pback;
    int cflk;
    int sflk;
    String msg;
    String lmsg;
    int opselect;
    boolean lloaded;
    int npo;
    String[] pnames;
    int[] pcars;
    String[] pcarnames;
    String[] pclan;
    int[] pgames;
    float[][] pcols;
    int prnpo;
    String[] prnames;
    int[] ppos;
    int[] plap;
    int[] ppow;
    int[] pdam;
    int prevloaded;
    String stuntname;
    String lapsname;
    String wastename;
    int ngm;
    int[] gnum;
    int[] gstgn;
    String[] gstages;
    int[] gnlaps;
    int[] mnpls;
    int[] mnbts;
    int[] wait;
    int[] gcrs;
    int[] gclss;
    int[] gfx;
    int[] gntb;
    String[] gplyrs;
    int[] gwarb;
    String[] gwarbnum;
    int[] gameturn;
    String[] gaclan;
    String[] gvclan;
    int[] gascore;
    int[] gvscore;
    int[] gwtyp;
    String[] gmaker;
    int[] npls;
    int ongame;
    int join;
    int chalngd;
    int im;
    int longame;
    int onjoin;
    int ontyp;
    int dispcar;
    int forcar;
    int addstage;
    ContO dispco;
    boolean fstart;
    boolean jflexo;
    String chalby;
    int ctime;
    boolean invo;
    String[] invos;
    String[] dinvi;
    String[] cnames;
    String[] sentn;
    int updatec;
    int loadstage;
    int gstage;
    int gstagelaps;
    int gnpls;
    int gwait;
    int gnbts;
    int gcars;
    int gclass;
    int gfix;
    int gnotp;
    int remstage;
    int msload;
    int sgflag;
    String gstagename;
    String gplayers;
    boolean inwab;
    boolean loadwarb;
    int warbsel;
    int cancreate;
    int pgamesel;
    int cntchkn;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int spos;
    int spos2;
    int spos3;
    int mscro;
    int lspos;
    int mscro2;
    int lspos2;
    int mscro3;
    int lspos3;
    int clicked;
    int opengame;
    int britchl;
    boolean zeromsw;
    int mousonp;
    int cmonp;
    long ptime;
    int pcurs;
    boolean grprsd;
    int pend;
    int mrot;
    boolean pendb;
    int[] cac;
    int[] cax;
    int[] cay;
    boolean mousedout;
    int flks;
    int waitlink;
    boolean pre1;
    boolean pre2;
    int prereq;
    int plsndt;
    int lxm;
    int lym;

    public Lobby(final Medium m, final Graphics2D rd, final Login lg, final Globe gb, final xtGraphics xt, final CarDefine cd, final GameSparker gs) {
        this.conon = 0;
        this.regnow = false;
        this.lanlogged = false;
        this.fase = 0;
        this.stage = 0;
        this.laps = 3;
        this.stagename = "";
        this.nfix = 0;
        this.notb = false;
        this.pessd = new boolean[] { false, false, false, false, false, false, false, false };
        this.bx = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.by = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.bw = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.btn = 0;
        this.pbtn = 0;
        this.nflk = 0;
        this.ncnt = 0;
        this.rerr = 0;
        this.pback = 0;
        this.cflk = 0;
        this.sflk = 0;
        this.msg = "";
        this.lmsg = "| Searching/Waiting for other LAN Players |";
        this.opselect = 0;
        this.lloaded = false;
        this.npo = 0;
        this.pnames = new String[200];
        this.pcars = new int[200];
        this.pcarnames = new String[200];
        this.pclan = new String[200];
        this.pgames = new int[200];
        this.pcols = new float[200][6];
        this.prnpo = 0;
        this.prnames = new String[] { "", "", "", "", "", "", "", "" };
        this.ppos = new int[] { 6, 6, 6, 6, 6, 6, 6, 6 };
        this.plap = new int[] { 6, 6, 6, 6, 6, 6, 6, 6 };
        this.ppow = new int[] { 50, 50, 50, 50, 50, 50, 50, 50 };
        this.pdam = new int[] { 50, 50, 50, 50, 50, 50, 50, 50 };
        this.prevloaded = -1;
        this.stuntname = "";
        this.lapsname = "";
        this.wastename = "";
        this.ngm = 0;
        this.gnum = new int[500];
        this.gstgn = new int[500];
        this.gstages = new String[500];
        this.gnlaps = new int[500];
        this.mnpls = new int[500];
        this.mnbts = new int[500];
        this.wait = new int[500];
        this.gcrs = new int[500];
        this.gclss = new int[500];
        this.gfx = new int[500];
        this.gntb = new int[500];
        this.gplyrs = new String[500];
        this.gwarb = new int[500];
        this.gwarbnum = new String[500];
        this.gameturn = new int[500];
        this.gaclan = new String[500];
        this.gvclan = new String[500];
        this.gascore = new int[500];
        this.gvscore = new int[500];
        this.gwtyp = new int[500];
        this.gmaker = new String[500];
        this.npls = new int[500];
        this.ongame = -1;
        this.join = -1;
        this.chalngd = -1;
        this.im = 0;
        this.longame = -1;
        this.onjoin = -1;
        this.ontyp = 0;
        this.dispcar = -1;
        this.forcar = -1;
        this.addstage = 0;
        this.dispco = null;
        this.fstart = false;
        this.jflexo = false;
        this.chalby = "";
        this.ctime = 0;
        this.invo = false;
        this.invos = new String[] { "", "", "", "", "", "", "", "" };
        this.dinvi = new String[] { "", "", "", "", "", "", "", "" };
        this.cnames = new String[] { "", "", "", "", "", "", "" };
        this.sentn = new String[] { "", "", "", "", "", "", "" };
        this.updatec = -1;
        this.loadstage = 0;
        this.gstage = 0;
        this.gstagelaps = 0;
        this.gnpls = 8;
        this.gwait = 0;
        this.gnbts = 0;
        this.gclass = 0;
        this.gfix = 0;
        this.gnotp = 0;
        this.remstage = 0;
        this.msload = 0;
        this.sgflag = 0;
        this.gstagename = "";
        this.gplayers = "";
        this.inwab = false;
        this.loadwarb = false;
        this.warbsel = 0;
        this.cancreate = 0;
        this.pgamesel = 0;
        this.cntchkn = 0;
        this.spos = 0;
        this.spos2 = 0;
        this.spos3 = 28;
        this.mscro = 125;
        this.lspos = 0;
        this.mscro2 = 145;
        this.lspos2 = 0;
        this.mscro3 = 345;
        this.lspos3 = 0;
        this.clicked = -1;
        this.opengame = 0;
        this.britchl = 0;
        this.zeromsw = false;
        this.mousonp = -1;
        this.cmonp = -1;
        this.ptime = 0L;
        this.pcurs = 0;
        this.grprsd = false;
        this.pend = 0;
        this.mrot = 0;
        this.pendb = false;
        this.cac = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        this.cax = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.cay = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.mousedout = false;
        this.flks = 0;
        this.waitlink = 0;
        this.pre1 = false;
        this.pre2 = false;
        this.prereq = 0;
        this.plsndt = 0;
        this.lxm = 0;
        this.lym = 0;
        this.m = m;
        this.rd = rd;
        this.xt = xt;
        this.cd = cd;
        this.gs = gs;
        this.lg = lg;
        this.gb = gb;
        this.gs.cmsg.setBackground(this.color2k(240, 240, 240));
        this.gs.swait.setBackground(this.color2k(220, 220, 220));
        this.gs.snpls.setBackground(this.color2k(220, 220, 220));
        this.gs.snbts.setBackground(this.color2k(220, 220, 220));
        this.gs.sgame.setBackground(this.color2k(200, 200, 200));
        this.gs.wgame.setBackground(this.color2k(200, 200, 200));
        this.gs.pgame.setBackground(this.color2k(200, 200, 200));
        this.gs.vnpls.setBackground(this.color2k(200, 200, 200));
        this.gs.vtyp.setBackground(this.color2k(200, 200, 200));
        this.gs.warb.setBackground(this.color2k(200, 200, 200));
        this.gs.snfmm.setBackground(this.color2k(200, 200, 200));
        this.gs.snfm1.setBackground(this.color2k(200, 200, 200));
        this.gs.snfm2.setBackground(this.color2k(200, 200, 200));
        this.gs.mstgs.setBackground(this.color2k(230, 230, 230));
        this.gs.slaps.setBackground(this.color2k(200, 200, 200));
        this.gs.sclass.setBackground(this.color2k(220, 220, 220));
        this.gs.scars.setBackground(this.color2k(220, 220, 220));
        this.gs.sfix.setBackground(this.color2k(220, 220, 220));
        this.gs.mycar.setBackground(this.color2k(255, 255, 255));
        this.gs.notp.setBackground(this.color2k(255, 255, 255));
        this.gs.rooms.setBackground(this.color2k(170, 170, 170));
        this.gs.swait.setForeground(new Color(0, 0, 0));
        this.gs.snpls.setForeground(new Color(0, 0, 0));
        this.gs.snbts.setForeground(new Color(0, 0, 0));
        this.gs.sgame.setForeground(new Color(0, 0, 0));
        this.gs.wgame.setForeground(new Color(0, 0, 0));
        this.gs.pgame.setForeground(new Color(0, 0, 0));
        this.gs.vnpls.setForeground(new Color(0, 0, 0));
        this.gs.vtyp.setForeground(new Color(0, 0, 0));
        this.gs.warb.setForeground(new Color(0, 0, 0));
        this.gs.snfmm.setForeground(new Color(0, 0, 0));
        this.gs.snfm1.setForeground(new Color(0, 0, 0));
        this.gs.slaps.setForeground(new Color(0, 0, 0));
        this.gs.snfm2.setForeground(new Color(0, 0, 0));
        this.gs.mstgs.setForeground(new Color(0, 0, 0));
        this.gs.sclass.setForeground(new Color(0, 0, 0));
        this.gs.scars.setForeground(new Color(0, 0, 0));
        this.gs.sfix.setForeground(new Color(0, 0, 0));
        this.gs.mycar.setForeground(new Color(0, 0, 0));
        this.gs.notp.setForeground(new Color(0, 0, 0));
        this.gs.rooms.setForeground(new Color(0, 0, 0));
        this.gs.sgame.removeAll();
        this.gs.sgame.add(this.rd, " NFM Multiplayer ");
        this.gs.sgame.add(this.rd, " NFM 2     ");
        this.gs.sgame.add(this.rd, " NFM 1     ");
        this.gs.sgame.add(this.rd, " My Stages ");
        this.gs.sgame.add(this.rd, " My Clan Stages ");
        this.gs.sgame.add(this.rd, " Weekly Top 20 ");
        this.gs.sgame.add(this.rd, " Monthly Top 20 ");
    }

    public void inishlobby() {
        this.gs.tnick.hide();
        this.gs.tpass.hide();
        this.gs.temail.hide();
        this.hideinputs();
        this.gs.mycar.setBackground(this.color2k(255, 255, 255));
        this.gs.mycar.setForeground(new Color(0, 0, 0));
        this.gs.rooms.removeAll();
        this.gs.rooms.add(this.rd, "" + this.xt.servername + " :: " + (this.xt.servport - 7070) + "");
        this.gs.rooms.select(0);
        this.gs.requestFocus();
        this.cd.loadready();
        for (int i = 0; i < 500; ++i) {
            this.gnum[i] = -2;
            this.gstgn[i] = 0;
            this.gstages[i] = "";
            this.gnlaps[i] = 0;
            this.mnpls[i] = 0;
            this.mnbts[i] = 0;
            this.wait[i] = 0;
            this.gmaker[i] = "";
            this.gcrs[i] = 0;
            this.gclss[i] = 0;
            this.gfx[i] = 0;
            this.gntb[i] = 0;
            this.gplyrs[i] = "";
            this.npls[i] = 0;
            this.gwarb[i] = 0;
            this.gwarbnum[i] = "";
            this.gameturn[i] = 0;
            this.gaclan[i] = "";
            this.gvclan[i] = "";
            this.gascore[i] = 0;
            this.gvscore[i] = 0;
            this.gwtyp[i] = 0;
        }
        for (int j = 0; j < 200; ++j) {
            this.pnames[j] = "";
            this.pcars[j] = 0;
            this.pcarnames[j] = "";
            this.pgames[j] = -1;
            this.pclan[j] = "";
            for (int k = 0; k < 6; ++k) {
                this.pcols[j][k] = 0.0f;
            }
        }
        this.ongame = -1;
        this.join = -1;
        this.onjoin = -1;
        this.chalngd = -1;
        this.dispcar = -1;
        this.forcar = -1;
        this.chalby = "";
        this.im = 0;
        this.fstart = false;
        this.updatec = -1;
        this.prevloaded = -1;
        this.spos = 0;
        this.spos2 = 0;
        this.spos3 = 0;
        this.ngm = 0;
        this.npo = 0;
        this.fase = 1;
        this.lloaded = false;
        this.lg.gamec = -1;
        try {
            this.socket = new Socket(this.xt.server, this.xt.servport);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
        }
        catch (Exception ex) {}
        this.conon = 1;
        (this.connector = new Thread(this)).start();
    }

    @Override
    public void run() {
        int playingame = -1;
        while (this.conon == 1) {
            final long time = new Date().getTime();
            if (!this.lloaded) {
                this.gs.setCursor(new Cursor(3));
            }
            if (!this.xt.logged && !this.xt.lan && this.xt.nfreeplays - this.xt.ndisco >= 5) {
                if (this.join >= 0) {
                    this.join = -1;
                    this.regnow = true;
                }
                if (this.pgames[this.im] != -1) {
                    this.join = -2;
                    this.regnow = true;
                }
            }
            if ((this.join >= 0 || this.pgames[this.im] != -1) && !this.regnow) {
                int n = -1;
                for (int i = 0; i < this.ngm; ++i) {
                    if (this.join == this.gnum[i] || this.pgames[this.im] == this.gnum[i]) {
                        n = i;
                    }
                }
                if (n != -1) {
                    boolean b = false;
                    this.ontyp = 0;
                    if (this.gcrs[n] == 1 && this.pcars[this.im] < 16) {
                        b = true;
                        this.ontyp = 10;
                        if (this.gclss[n] > 0 && this.gclss[n] <= 5) {
                            this.ontyp += this.gclss[n];
                        }
                    }
                    if (this.gcrs[n] == 2 && this.pcars[this.im] >= 16) {
                        b = true;
                        this.ontyp = 20;
                        if (this.gclss[n] > 0 && this.gclss[n] <= 5) {
                            this.ontyp += this.gclss[n];
                        }
                    }
                    if (this.gcrs[n] == 1 && this.gwarb[n] != 0 && this.xt.sc[0] != 36) {
                        b = true;
                        this.ontyp = 30;
                        if (this.gclss[n] > 0 && this.gclss[n] <= 5) {
                            this.ontyp += this.gclss[n];
                        }
                    }
                    if (this.gclss[n] > 0 && this.gclss[n] <= 5 && Math.abs(this.cd.cclass[this.pcars[this.im]] - (this.gclss[n] - 1)) > 1) {
                        b = true;
                        if (this.gcrs[n] == 1) {
                            if (this.gwarb[n] == 0) {
                                this.ontyp = 10;
                            }
                            else {
                                this.ontyp = 30;
                            }
                        }
                        if (this.gcrs[n] == 2) {
                            this.ontyp = 20;
                        }
                        this.ontyp += this.gclss[n];
                    }
                    if (this.gclss[n] <= -2 && this.pcars[this.im] != Math.abs(this.gclss[n] + 2)) {
                        b = true;
                        this.ontyp = this.gclss[n];
                    }
                    if (this.gstgn[n] == -2 && !this.xt.logged) {
                        b = true;
                        this.ontyp = 76;
                    }
                    if (b) {
                        this.onjoin = this.gnum[n];
                        this.jflexo = false;
                        if (this.join >= 0) {
                            this.join = -1;
                        }
                        if (this.pgames[this.im] != -1) {
                            this.join = -2;
                        }
                    }
                }
            }
            if (this.xt.onjoin != -1) {
                this.join = this.xt.onjoin;
                this.ongame = this.xt.onjoin;
                this.xt.onjoin = -1;
            }
            if (this.updatec < -17) {
                this.updatec = -17;
            }
            boolean b2 = false;
            if (this.lloaded) {
                playingame = this.pgames[this.im];
                if (playingame != -1) {
                    for (int j = 0; j < this.ngm; ++j) {
                        if (playingame == this.gnum[j]) {
                            this.laps = this.gnlaps[j];
                            this.stage = this.gstgn[j];
                            this.stagename = this.gstages[j];
                            this.nfix = this.gfx[j];
                            if (this.gntb[j] == 1) {
                                this.notb = true;
                            }
                            else {
                                this.notb = false;
                            }
                        }
                    }
                }
            }
            String s = "" + this.xt.sc[0] + "";
            if (this.xt.sc[0] >= 16) {
                s = "C" + this.cd.names[this.xt.sc[0]] + "";
            }
            final String string = "1|" + this.xt.nickname + ":" + this.xt.nickey + "|" + this.xt.clan + "|" + this.xt.clankey + "|" + s + "|" + this.join + "|" + (int)(this.xt.arnp[0] * 100.0f) + "|" + (int)(this.xt.arnp[1] * 100.0f) + "|" + (int)(this.xt.arnp[2] * 100.0f) + "|" + (int)(this.xt.arnp[3] * 100.0f) + "|" + (int)(this.xt.arnp[4] * 100.0f) + "|" + (int)(this.xt.arnp[5] * 100.0f) + "|" + this.ongame + "|";
            String s2;
            if (!this.xt.lan) {
                s2 = string + "" + this.updatec + "|";
                if (this.updatec <= -11) {
                    for (int k = 0; k < -this.updatec - 10; ++k) {
                        s2 = s2 + "" + this.cnames[6 - k] + "|" + this.sentn[6 - k] + "|";
                    }
                    this.updatec = -2;
                }
            }
            else {
                String s3;
                try {
                    s3 = InetAddress.getLocalHost().getHostName();
                    if (s3.indexOf("|") != -1) {
                        s3 = InetAddress.getLocalHost().getHostAddress();
                    }
                }
                catch (Exception ex) {
                    s3 = "Nonex";
                }
                int n2 = 0;
                if (this.xt.logged) {
                    n2 = 1;
                }
                s2 = string + "" + s3 + "|" + n2 + "|";
            }
            if (this.fstart) {
                s2 += "3|";
                b2 = true;
            }
            if (this.chalngd == -5 && !this.fstart) {
                s2 = s2 + "11|" + this.gstage + "|" + this.gstagename + "|" + this.gstagelaps + "|" + this.gnpls + "|" + this.gwait + "|" + this.pnames[this.im] + "|" + this.gcars + "|" + this.gclass + "|" + this.gfix + "|" + this.gnotp + "|" + this.gplayers + "|";
                if (this.xt.lan) {
                    s2 = s2 + "" + this.gnbts + "|";
                }
            }
            if (this.ongame != -1 && this.chalngd != -5 && !this.fstart) {
                int n3 = 0;
                for (int l = 0; l < 7; ++l) {
                    if (!this.invos[l].equals("") && !this.dinvi[l].equals(this.invos[l])) {
                        if (n3 == 0) {
                            s2 = s2 + "2|" + this.ongame + "|";
                            n3 = 1;
                        }
                        s2 = s2 + "" + this.invos[l] + "|";
                        this.dinvi[l] = this.invos[l];
                    }
                }
            }
            String s4 = "";
            int n4 = 0;
            try {
                this.dout.println(s2);
                s4 = this.din.readLine();
                if (s4 == null) {
                    n4 = 1;
                }
            }
            catch (Exception ex2) {
                n4 = 1;
            }
            if (n4 != 0) {
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
                    this.socket = new Socket(this.xt.server, this.xt.servport);
                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println(s2);
                    s4 = this.din.readLine();
                    if (s4 != null) {
                        n4 = 0;
                    }
                }
                catch (Exception ex4) {}
            }
            if (n4 != 0) {
                try {
                    this.socket.close();
                    this.socket = null;
                }
                catch (Exception ex5) {}
                this.conon = 0;
                this.lg.exitfromlobby();
                this.hideinputs();
                this.connector.stop();
            }
            if (this.regnow && this.join == -2) {
                this.join = -1;
            }
            this.npo = this.getvalue(s4, 0);
            if (this.npo < 0) {
                this.npo = 0;
            }
            this.im = this.getvalue(s4, 1);
            if (this.im < 0) {
                this.im = 0;
            }
            for (int n5 = 0; n5 < this.npo; ++n5) {
                this.pnames[n5] = this.getSvalue(s4, 2 + n5 * 10);
                if (this.pnames[n5].equals("")) {
                    this.pnames[n5] = "Unknown";
                }
                final String svalue = this.getSvalue(s4, 3 + n5 * 10);
                if (svalue.startsWith("C")) {
                    this.pcarnames[n5] = svalue.substring(1);
                    if (!this.pcarnames[n5].equals("")) {
                        int n6 = 0;
                        for (int n7 = 16; n7 < 56; ++n7) {
                            if (this.pcarnames[n5].equals(this.cd.names[n7])) {
                                n6 = n7;
                                break;
                            }
                        }
                        if (n6 == 0) {
                            this.pcars[n5] = -1;
                            boolean b3 = false;
                            for (int n8 = 0; n8 < this.cd.nl; ++n8) {
                                if (this.pcarnames[n5].equals(this.cd.loadnames[n8])) {
                                    b3 = true;
                                }
                            }
                            if (!b3 && this.cd.nl < 20 && this.cd.nl >= 0) {
                                this.cd.loadnames[this.cd.nl] = this.pcarnames[n5];
                                final CarDefine cd = this.cd;
                                ++cd.nl;
                            }
                            this.cd.sparkcarloader();
                        }
                        else {
                            this.pcars[n5] = n6;
                        }
                    }
                    else {
                        this.pcars[n5] = 0;
                        this.pcarnames[n5] = this.cd.names[this.pcars[n5]];
                    }
                }
                else {
                    this.pcars[n5] = this.getvalue(s4, 3 + n5 * 10);
                    if (this.pcars[n5] == -1) {
                        this.pcars[n5] = 0;
                    }
                    this.pcarnames[n5] = this.cd.names[this.pcars[n5]];
                }
                this.pclan[n5] = this.getSvalue(s4, 4 + n5 * 10);
                this.pgames[n5] = this.getvalue(s4, 5 + n5 * 10);
                this.pcols[n5][0] = this.getvalue(s4, 6 + n5 * 10) / 100.0f;
                if (this.pcols[n5][0] == -1.0f) {
                    this.pcols[n5][0] = 0.0f;
                }
                this.pcols[n5][1] = this.getvalue(s4, 7 + n5 * 10) / 100.0f;
                if (this.pcols[n5][1] == -1.0f) {
                    this.pcols[n5][1] = 0.0f;
                }
                this.pcols[n5][2] = this.getvalue(s4, 8 + n5 * 10) / 100.0f;
                if (this.pcols[n5][2] == -1.0f) {
                    this.pcols[n5][2] = 0.0f;
                }
                this.pcols[n5][3] = this.getvalue(s4, 9 + n5 * 10) / 100.0f;
                if (this.pcols[n5][3] == -1.0f) {
                    this.pcols[n5][3] = 0.0f;
                }
                this.pcols[n5][4] = this.getvalue(s4, 10 + n5 * 10) / 100.0f;
                if (this.pcols[n5][4] == -1.0f) {
                    this.pcols[n5][4] = 0.0f;
                }
                this.pcols[n5][5] = this.getvalue(s4, 11 + n5 * 10) / 100.0f;
                if (this.pcols[n5][5] == -1.0f) {
                    this.pcols[n5][5] = 0.0f;
                }
            }
            final int n9 = 12 + (this.npo - 1) * 10;
            this.ngm = this.getvalue(s4, n9);
            if (this.ngm < 0) {
                this.ngm = 0;
            }
            int n10 = 12;
            if (this.xt.lan) {
                n10 = 13;
            }
            for (int n11 = 0; n11 < this.ngm; ++n11) {
                this.gnum[n11] = this.getvalue(s4, n9 + 1 + n11 * n10);
                this.gstgn[n11] = this.getvalue(s4, n9 + 2 + n11 * n10);
                this.gstgn[n11] = Math.abs(this.gstgn[n11]);
                if (this.gstgn[n11] > 100) {
                    this.gstgn[n11] = -2;
                }
                this.gstages[n11] = this.getSvalue(s4, n9 + 3 + n11 * n10);
                this.gnlaps[n11] = this.getvalue(s4, n9 + 4 + n11 * n10);
                this.mnpls[n11] = this.getvalue(s4, n9 + 5 + n11 * n10);
                this.wait[n11] = this.getvalue(s4, n9 + 6 + n11 * n10);
                this.gmaker[n11] = this.getSvalue(s4, n9 + 7 + n11 * n10);
                this.gcrs[n11] = this.getvalue(s4, n9 + 8 + n11 * n10);
                this.gclss[n11] = this.getvalue(s4, n9 + 9 + n11 * n10);
                this.gfx[n11] = this.getvalue(s4, n9 + 10 + n11 * n10);
                this.gntb[n11] = this.getvalue(s4, n9 + 11 + n11 * n10);
                this.gplyrs[n11] = this.getSvalue(s4, n9 + 12 + n11 * n10);
                if (this.gplyrs[n11].startsWith("#warb#")) {
                    this.gwarb[n11] = this.getHvalue(this.gplyrs[n11], 2);
                    this.gwarbnum[n11] = this.getHSvalue(this.gplyrs[n11], 3);
                    this.gameturn[n11] = this.getHvalue(this.gplyrs[n11], 4);
                    this.gaclan[n11] = this.getHSvalue(this.gplyrs[n11], 5);
                    this.gvclan[n11] = this.getHSvalue(this.gplyrs[n11], 6);
                    this.gascore[n11] = this.getHvalue(this.gplyrs[n11], 7);
                    this.gvscore[n11] = this.getHvalue(this.gplyrs[n11], 8);
                    this.gwtyp[n11] = this.getHvalue(this.gplyrs[n11], 9);
                    if (this.gwtyp[n11] < 1 || this.gwtyp[n11] > 5) {
                        this.gwtyp[n11] = 1;
                    }
                    this.gplyrs[n11] = "";
                }
                else {
                    this.gwarb[n11] = 0;
                    this.gwarbnum[n11] = "";
                    this.gameturn[n11] = 0;
                    this.gaclan[n11] = "";
                    this.gvclan[n11] = "";
                    this.gascore[n11] = 0;
                    this.gvscore[n11] = 0;
                    this.gwtyp[n11] = 0;
                }
                if (this.xt.lan) {
                    this.mnbts[n11] = this.getvalue(s4, n9 + 13 + n11 * n10);
                }
                if (this.xt.playingame > -1 && this.xt.playingame == this.gnum[n11] && !this.xt.lan) {
                    this.ongame = this.gnum[n11];
                }
                if (playingame == this.gnum[n11] && this.wait[n11] == 0 && this.lloaded && playingame != -1) {
                    for (int im = 0; im < this.npo; ++im) {
                        if (this.pgames[im] == this.gnum[n11] && this.pnames[im].equals(this.xt.nickname)) {
                            this.im = im;
                            break;
                        }
                    }
                    this.conon = 2;
                    this.gs.setCursor(new Cursor(3));
                }
            }
            for (int n12 = 0; n12 < this.ngm; ++n12) {
                this.npls[n12] = 0;
                for (int n13 = 0; n13 < this.npo; ++n13) {
                    if (this.pgames[n13] == this.gnum[n12]) {
                        final int[] npls = this.npls;
                        final int n14 = n12;
                        ++npls[n14];
                    }
                }
            }
            if (this.conon != 0 && this.xt.playingame != -1) {
                this.xt.playingame = -1;
            }
            if (this.ongame != -1) {
                boolean b4 = false;
                for (int n15 = 0; n15 < this.ngm; ++n15) {
                    if (this.ongame == this.gnum[n15]) {
                        b4 = true;
                    }
                }
                if (!b4) {
                    this.britchl = -1;
                }
            }
            if (this.join > -1) {
                boolean b5 = false;
                for (int n16 = 0; n16 < this.ngm; ++n16) {
                    if (this.join == this.gnum[n16]) {
                        b5 = true;
                    }
                }
                if (!b5) {
                    this.join = -1;
                }
            }
            for (int n17 = 0; n17 < this.npo; ++n17) {
                if (this.pgames[n17] != -1) {
                    boolean b6 = false;
                    for (int n18 = 0; n18 < this.ngm; ++n18) {
                        if (this.pgames[n17] == this.gnum[n18]) {
                            b6 = true;
                        }
                    }
                    if (!b6) {
                        this.pgames[n17] = -1;
                    }
                }
            }
            int n19;
            if (this.xt.lan) {
                n19 = n9 + (14 + (this.ngm - 1) * 13);
            }
            else {
                n19 = n9 + (13 + (this.ngm - 1) * 12);
            }
            if (!this.xt.lan) {
                final int getvalue = this.getvalue(s4, n19);
                final int getvalue2 = this.getvalue(s4, n19 + 1);
                n19 += 2;
                if (this.updatec != getvalue && this.updatec >= -2 && getvalue2 == this.ongame) {
                    for (int n20 = 0; n20 < 7; ++n20) {
                        this.cnames[n20] = this.getSvalue(s4, n19 + n20 * 2);
                        this.sentn[n20] = this.getSvalue(s4, n19 + 1 + n20 * 2);
                    }
                    this.updatec = getvalue;
                    if (this.ongame == -1) {
                        this.spos3 = 28;
                    }
                    n19 += 14;
                }
                if (this.ongame != -1) {
                    if (this.prevloaded != -1) {
                        this.prevloaded = -1;
                    }
                    boolean b7 = false;
                    for (int n21 = 0; n21 < this.ngm; ++n21) {
                        if (this.ongame == this.gnum[n21] && this.wait[n21] <= 0) {
                            b7 = true;
                        }
                    }
                    if (b7) {
                        this.prevloaded = this.getvalue(s4, n19);
                        ++n19;
                        if (this.prevloaded == 1) {
                            this.prnpo = this.getvalue(s4, n19);
                            ++n19;
                            for (int n22 = 0; n22 < this.prnpo; ++n22) {
                                this.prnames[n22] = this.getSvalue(s4, n19);
                                ++n19;
                            }
                            for (int n23 = 0; n23 < this.prnpo; ++n23) {
                                this.ppos[n23] = this.getvalue(s4, n19);
                                ++n19;
                            }
                            for (int n24 = 0; n24 < this.prnpo; ++n24) {
                                this.plap[n24] = this.getvalue(s4, n19);
                                ++n19;
                            }
                            for (int n25 = 0; n25 < this.prnpo; ++n25) {
                                this.ppow[n25] = (int)(this.getvalue(s4, n19) / 9800.0f * 55.0f);
                                ++n19;
                            }
                            for (int n26 = 0; n26 < this.prnpo; ++n26) {
                                final int getvalue3 = this.getvalue(s4, n19);
                                if (getvalue3 != -17) {
                                    this.pdam[n26] = (int)(getvalue3 / 100.0f * 55.0f);
                                }
                                else {
                                    this.pdam[n26] = -17;
                                }
                                ++n19;
                            }
                            this.stuntname = this.getSvalue(s4, n19);
                            ++n19;
                            this.lapsname = this.getSvalue(s4, n19);
                            ++n19;
                            this.wastename = this.getSvalue(s4, n19);
                            ++n19;
                        }
                    }
                }
            }
            else {
                if (this.getvalue(s4, n19) == 1) {
                    this.lanlogged = true;
                }
                else {
                    this.lanlogged = false;
                }
                ++n19;
            }
            final int getvalue4 = this.getvalue(s4, n19);
            if (getvalue4 != -1) {
                int n27 = 0;
                for (int n28 = 0; n28 < this.ngm; ++n28) {
                    if (getvalue4 == this.gnum[n28]) {
                        n27 = n28;
                    }
                }
                boolean b8 = false;
                if (this.gwarb[n27] != 0) {
                    if (this.xt.clan.toLowerCase().equals(this.gaclan[n27].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[n27].toLowerCase())) {
                        b8 = true;
                    }
                }
                else {
                    b8 = true;
                }
                if ((this.pgames[this.im] != this.ongame || this.ongame == -1) && getvalue4 != this.ongame && this.chalngd == -1 && this.join == -1 && this.fase == 1 && this.wait[n27] > 0 && b8) {
                    this.chalngd = getvalue4;
                    this.chalby = this.getSvalue(s4, n19 + 1);
                    this.cflk = 20;
                    this.ctime = 20;
                    this.ptime = 0L;
                    this.longame = this.ongame;
                    if (this.gs.rooms.open) {
                        this.gs.rooms.open = false;
                    }
                    if (this.ongame != -1) {
                        this.britchl = -1;
                    }
                }
                ++n19;
            }
            if (!this.xt.lan) {
                int no = 1;
                for (int n29 = 1; n29 < 6; ++n29) {
                    if (n29 != this.xt.servport - 7070) {
                        final int getvalue5 = this.getvalue(s4, n19 + n29);
                        if (getvalue5 != -1) {
                            this.gs.rooms.sopts[no] = "Room " + n29 + "  ::  " + getvalue5 + "";
                            this.gs.rooms.opts[no] = "";
                            this.gs.rooms.iroom[no] = n29;
                            ++no;
                        }
                    }
                }
                for (int n30 = 0; n30 < this.lg.nservers; ++n30) {
                    if (!this.xt.server.equals(this.lg.servers[n30]) && this.xt.delays[n30] < 300) {
                        this.gs.rooms.sopts[no] = ":: " + this.lg.snames[n30] + "";
                        this.gs.rooms.opts[no] = "";
                        this.gs.rooms.iroom[no] = 1000 + n30;
                        ++no;
                    }
                }
                this.gs.rooms.no = no;
            }
            if (this.join > -1) {
                boolean b9 = false;
                for (int n31 = 0; n31 < this.ngm; ++n31) {
                    if (this.join == this.gnum[n31] && this.wait[n31] == 0) {
                        b9 = true;
                    }
                }
                if (this.pgames[this.im] == this.join || b9) {
                    this.join = -1;
                    this.nflk = 3;
                }
            }
            if (this.join == -2) {
                boolean b10 = false;
                for (int n32 = 0; n32 < this.ngm; ++n32) {
                    if (this.pgames[this.im] == this.gnum[n32] && this.wait[n32] == 0) {
                        b10 = true;
                    }
                }
                if (this.pgames[this.im] == -1 || b10) {
                    this.join = -1;
                    if (!b10) {
                        this.ongame = -1;
                    }
                }
            }
            if (this.chalngd == -5 && this.pgames[this.im] != -1) {
                this.ongame = this.pgames[this.im];
                this.chalngd = -1;
                if (!this.xt.lan && this.gplayers.equals("")) {
                    this.lg.gamealert();
                }
            }
            if (this.fstart && b2) {
                this.fstart = false;
            }
            this.rerr = 0;
            if (!this.lloaded) {
                this.gs.setCursor(new Cursor(0));
                this.lloaded = true;
            }
            if (!this.gb.domon) {
                this.gb.roomlogos(this.pnames, this.npo);
                if (this.ongame == -1) {
                    if (this.cntchkn == 5) {
                        this.lg.checkgamealerts();
                    }
                }
                else if (this.lg.gamec != -1) {
                    this.lg.gamec = -1;
                }
                if (this.cntchkn == 5) {
                    this.lg.checknotifcations();
                    this.cntchkn = 0;
                }
                else {
                    ++this.cntchkn;
                }
            }
            else if (this.lg.gamec != -1) {
                this.lg.gamec = -1;
            }
            int n33 = 700 - (int)(new Date().getTime() - time);
            if (n33 < 50) {
                n33 = 50;
            }
            try {
                final Thread connector = this.connector;
                Thread.sleep(n33);
            }
            catch (InterruptedException ex6) {}
        }
        if (this.conon == 2) {
            int n34 = 20;
            this.xt.playingame = -1;
            while (n34 != 0) {
                final String string2 = "2|" + playingame + "|";
                String s5 = "";
                int n35 = 0;
                try {
                    this.dout.println(string2);
                    s5 = this.din.readLine();
                    if (s5 == null) {
                        n35 = 1;
                    }
                }
                catch (Exception ex7) {
                    n35 = 1;
                }
                if (n35 != 0) {
                    try {
                        this.socket.close();
                        this.socket = null;
                        this.din.close();
                        this.din = null;
                        this.dout.close();
                        this.dout = null;
                    }
                    catch (Exception ex8) {}
                    try {
                        this.socket = new Socket(this.xt.server, this.xt.servport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println(string2);
                        s5 = this.din.readLine();
                        if (s5 != null) {
                            n35 = 0;
                        }
                    }
                    catch (Exception ex9) {}
                }
                if (n35 != 0) {
                    try {
                        this.socket.close();
                        this.socket = null;
                    }
                    catch (Exception ex10) {}
                    this.conon = 0;
                    this.lg.exitfromlobby();
                    this.hideinputs();
                    this.connector.stop();
                }
                if (!this.xt.lan) {
                    this.xt.gameport = this.getvalue(s5, 0);
                }
                else {
                    this.xt.gameport = -1;
                    this.xt.localserver = this.getSevervalue(s5, 0);
                    if (!this.xt.localserver.equals("")) {
                        this.xt.gameport = 0;
                    }
                }
                if (this.xt.gameport != -1) {
                    int n36 = 0;
                    this.xt.im = -1;
                    this.xt.nplayers = this.getvalue(s5, 1);
                    if (this.xt.nplayers < 1) {
                        this.xt.nplayers = 1;
                    }
                    if (this.xt.nplayers > 8) {
                        this.xt.nplayers = 8;
                    }
                    for (int im2 = 0; im2 < this.xt.nplayers; ++im2) {
                        this.xt.plnames[im2] = this.getSvalue(s5, 2 + im2);
                        if (this.xt.nickname.equals(this.xt.plnames[im2])) {
                            this.xt.im = im2;
                        }
                    }
                    final int n37 = 2 + this.xt.nplayers;
                    for (int n38 = 0; n38 < this.xt.nplayers; ++n38) {
                        final String svalue2 = this.getSvalue(s5, n37 + n38);
                        if (svalue2.startsWith("C")) {
                            final String substring = svalue2.substring(1);
                            if (!substring.equals("")) {
                                int n39 = 0;
                                for (int n40 = 16; n40 < 56; ++n40) {
                                    if (substring.equals(this.cd.names[n40])) {
                                        n39 = n40;
                                        break;
                                    }
                                }
                                while (n39 == 0 && n36 < 100) {
                                    boolean b11 = false;
                                    for (int n41 = 0; n41 < this.cd.nl; ++n41) {
                                        if (substring.equals(this.cd.loadnames[n41])) {
                                            b11 = true;
                                        }
                                    }
                                    if (!b11 && this.cd.nl < 20) {
                                        this.cd.loadnames[this.cd.nl] = substring;
                                        final CarDefine cd2 = this.cd;
                                        ++cd2.nl;
                                    }
                                    this.cd.sparkcarloader();
                                    try {
                                        final Thread connector2 = this.connector;
                                        Thread.sleep(100L);
                                    }
                                    catch (InterruptedException ex11) {}
                                    for (int n42 = 16; n42 < 56; ++n42) {
                                        if (substring.equals(this.cd.names[n42])) {
                                            n39 = n42;
                                        }
                                    }
                                    ++n36;
                                }
                                if (n39 != 0) {
                                    this.xt.sc[n38] = n39;
                                    for (int n43 = 0; n43 < this.npo; ++n43) {
                                        if (this.pcarnames[n43].equals(substring)) {
                                            this.pcars[n43] = n39;
                                        }
                                    }
                                }
                                else {
                                    this.xt.im = -1;
                                }
                            }
                            else {
                                this.xt.im = -1;
                            }
                        }
                        else {
                            this.xt.sc[n38] = this.getvalue(s5, n37 + n38);
                            if (this.xt.sc[n38] == -1) {
                                this.xt.im = -1;
                            }
                        }
                    }
                    final int n44 = n37 + this.xt.nplayers;
                    for (int n45 = 0; n45 < this.xt.nplayers; ++n45) {
                        this.xt.xstart[n45] = this.getvalue(s5, n44 + n45);
                    }
                    final int n46 = n44 + this.xt.nplayers;
                    for (int n47 = 0; n47 < this.xt.nplayers; ++n47) {
                        this.xt.zstart[n47] = this.getvalue(s5, n46 + n47);
                    }
                    final int n48 = n46 + this.xt.nplayers;
                    for (int n49 = 0; n49 < this.xt.nplayers; ++n49) {
                        for (int n50 = 0; n50 < 6; ++n50) {
                            this.xt.allrnp[n49][n50] = this.getvalue(s5, n48 + n49 * 6 + n50) / 100.0f;
                        }
                    }
                    if (this.xt.im != -1) {
                        this.xt.playingame = playingame;
                        int n51 = 0;
                        for (int n52 = 0; n52 < this.ngm; ++n52) {
                            if (playingame == this.gnum[n52]) {
                                n51 = n52;
                            }
                        }
                        if (this.gwarb[n51] != 0) {
                            this.xt.clangame = this.gwtyp[n51];
                            this.xt.clanchat = true;
                            this.xt.gaclan = this.gaclan[n51];
                            for (int n53 = 0; n53 < this.xt.nplayers; ++n53) {
                                for (int n54 = 0; n54 < this.npo; ++n54) {
                                    if (this.xt.plnames[n53].equals(this.pnames[n54]) && this.pgames[n54] == playingame) {
                                        this.xt.pclan[n53] = this.pclan[n54];
                                    }
                                }
                            }
                        }
                        else {
                            this.xt.clangame = 0;
                        }
                    }
                    else {
                        this.xt.playingame = -1;
                        this.xt.im = 0;
                    }
                    n34 = 0;
                }
                else {
                    --n34;
                }
                try {
                    final Thread connector3 = this.connector;
                    Thread.sleep(1000L);
                }
                catch (InterruptedException ex12) {}
            }
            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            }
            catch (Exception ex13) {}
            if (this.xt.playingame != -1) {
                if (!this.xt.lan && !this.xt.logged) {
                    final xtGraphics xt = this.xt;
                    ++xt.nfreeplays;
                    try {
                        this.socket = new Socket(this.lg.servers[0], 7061);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("7|" + this.xt.nfreeplays + "|");
                        this.xt.hours = this.getvalue(this.din.readLine(), 0);
                        this.socket.close();
                        this.socket = null;
                        this.din.close();
                        this.din = null;
                        this.dout.close();
                        this.dout = null;
                    }
                    catch (Exception ex14) {}
                }
                this.hideinputs();
                this.xt.multion = 1;
                this.fase = 76;
                System.gc();
            }
            else {
                this.inishlobby();
            }
        }
        if (this.conon == 3) {
            int n55 = 20;
            this.xt.playingame = -1;
            while (n55 != 0) {
                final String string3 = "4|" + this.ongame + "|";
                String s6 = "";
                int n56 = 0;
                try {
                    this.dout.println(string3);
                    s6 = this.din.readLine();
                    if (s6 == null) {
                        n56 = 1;
                    }
                }
                catch (Exception ex15) {
                    n56 = 1;
                }
                if (n56 != 0) {
                    try {
                        this.socket.close();
                        this.socket = null;
                        this.din.close();
                        this.din = null;
                        this.dout.close();
                        this.dout = null;
                    }
                    catch (Exception ex16) {}
                    try {
                        this.socket = new Socket(this.xt.server, this.xt.servport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println(string3);
                        s6 = this.din.readLine();
                        if (s6 != null) {
                            n56 = 0;
                        }
                    }
                    catch (Exception ex17) {}
                }
                if (n56 != 0) {
                    try {
                        this.socket.close();
                        this.socket = null;
                    }
                    catch (Exception ex18) {}
                    this.conon = 0;
                    this.lg.exitfromlobby();
                    this.hideinputs();
                    this.connector.stop();
                }
                if (!this.xt.lan) {
                    this.xt.gameport = this.getvalue(s6, 0);
                }
                else {
                    this.xt.gameport = -1;
                    this.xt.localserver = this.getSevervalue(s6, 0);
                    if (!this.xt.localserver.equals("")) {
                        this.xt.gameport = 0;
                    }
                }
                if (this.xt.gameport != -1) {
                    int n57 = 0;
                    this.xt.nplayers = this.getvalue(s6, 1);
                    if (this.xt.nplayers < 1) {
                        this.xt.nplayers = 1;
                    }
                    if (this.xt.nplayers > 8) {
                        this.xt.nplayers = 8;
                    }
                    this.xt.im = this.getvalue(s6, 2) + this.xt.nplayers;
                    for (int n58 = 0; n58 < this.xt.nplayers; ++n58) {
                        this.xt.plnames[n58] = this.getSvalue(s6, 3 + n58);
                    }
                    final int n59 = 3 + this.xt.nplayers;
                    for (int n60 = 0; n60 < this.xt.nplayers; ++n60) {
                        final String svalue3 = this.getSvalue(s6, n59 + n60);
                        if (svalue3.startsWith("C")) {
                            final String substring2 = svalue3.substring(1);
                            if (!substring2.equals("")) {
                                int n61 = 0;
                                for (int n62 = 16; n62 < 56; ++n62) {
                                    if (substring2.equals(this.cd.names[n62])) {
                                        n61 = n62;
                                        break;
                                    }
                                }
                                while (n61 == 0 && n57 < 100) {
                                    boolean b12 = false;
                                    for (int n63 = 0; n63 < this.cd.nl; ++n63) {
                                        if (substring2.equals(this.cd.loadnames[n63])) {
                                            b12 = true;
                                        }
                                    }
                                    if (!b12 && this.cd.nl < 20) {
                                        this.cd.loadnames[this.cd.nl] = substring2;
                                        final CarDefine cd3 = this.cd;
                                        ++cd3.nl;
                                    }
                                    this.cd.sparkcarloader();
                                    try {
                                        final Thread connector4 = this.connector;
                                        Thread.sleep(100L);
                                    }
                                    catch (InterruptedException ex19) {}
                                    for (int n64 = 16; n64 < 56; ++n64) {
                                        if (substring2.equals(this.cd.names[n64])) {
                                            n61 = n64;
                                        }
                                    }
                                    ++n57;
                                }
                                if (n61 != 0) {
                                    this.xt.sc[n60] = n61;
                                    for (int n65 = 0; n65 < this.npo; ++n65) {
                                        if (this.pcarnames[n65].equals(substring2)) {
                                            this.pcars[n65] = n61;
                                        }
                                    }
                                }
                                else {
                                    this.xt.im = -1;
                                }
                            }
                            else {
                                this.xt.im = -1;
                            }
                        }
                        else {
                            this.xt.sc[n60] = this.getvalue(s6, n59 + n60);
                            if (this.xt.sc[n60] == -1) {
                                this.xt.im = -1;
                            }
                        }
                    }
                    final int n66 = n59 + this.xt.nplayers;
                    for (int n67 = 0; n67 < this.xt.nplayers; ++n67) {
                        this.xt.xstart[n67] = this.getvalue(s6, n66 + n67);
                    }
                    final int n68 = n66 + this.xt.nplayers;
                    for (int n69 = 0; n69 < this.xt.nplayers; ++n69) {
                        this.xt.zstart[n69] = this.getvalue(s6, n68 + n69);
                    }
                    final int n70 = n68 + this.xt.nplayers;
                    for (int n71 = 0; n71 < this.xt.nplayers; ++n71) {
                        for (int n72 = 0; n72 < 6; ++n72) {
                            this.xt.allrnp[n71][n72] = this.getvalue(s6, n70 + n71 * 6 + n72) / 100.0f;
                        }
                    }
                    if (this.xt.im >= this.xt.nplayers && this.xt.im < this.xt.nplayers + 3) {
                        this.xt.playingame = this.ongame;
                        int n73 = 0;
                        for (int n74 = 0; n74 < this.ngm; ++n74) {
                            if (this.ongame == this.gnum[n74]) {
                                n73 = n74;
                            }
                        }
                        if (this.gwarb[n73] != 0) {
                            this.xt.clangame = this.gwtyp[n73];
                            this.xt.gaclan = this.gaclan[n73];
                            if (this.xt.clan.toLowerCase().equals(this.gaclan[n73].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[n73].toLowerCase())) {
                                this.xt.clanchat = true;
                            }
                            for (int n75 = 0; n75 < this.xt.nplayers; ++n75) {
                                for (int n76 = 0; n76 < this.npo; ++n76) {
                                    if (this.xt.plnames[n75].equals(this.pnames[n76]) && this.pgames[n76] == this.ongame) {
                                        this.xt.pclan[n75] = this.pclan[n76];
                                    }
                                }
                            }
                        }
                        else {
                            this.xt.clangame = 0;
                        }
                    }
                    else {
                        this.xt.playingame = -1;
                        this.xt.im = 0;
                    }
                    n55 = 0;
                }
                else {
                    --n55;
                }
                try {
                    final Thread connector5 = this.connector;
                    Thread.sleep(1000L);
                }
                catch (InterruptedException ex20) {}
            }
            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            }
            catch (Exception ex21) {}
            if (this.xt.playingame != -1) {
                this.hideinputs();
                this.xt.multion = 3;
                this.fase = 76;
                System.gc();
            }
            else {
                this.inishlobby();
            }
        }
    }

    public void stopallnow() {
        this.conon = 0;
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
        }
        catch (Exception ex) {}
        if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
        }
    }

    public void lobby(int n, int n2, boolean b, final int n3, final CheckPoints checkPoints, final Control control, final ContO[] array) {
        this.pre1 = false;
        this.pre2 = false;
        int pcurs = 0;
        Label_53505: {
            if (this.xt.warning != 0) {
                if (this.xt.warning != 210) {
                    this.xt.drawWarning();
                    if (this.gs.cmsg.isShowing()) {
                        this.gs.cmsg.hide();
                        this.gs.requestFocus();
                    }
                    if (this.xt.warning > 220) {
                        this.conon = 0;
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
                    final xtGraphics xt = this.xt;
                    ++xt.warning;
                    break Label_53505;
                }
            }
            if (this.regnow) {
                this.xt.mainbg(3);
                this.btn = 0;
                if (this.gs.cmsg.isShowing()) {
                    this.gs.cmsg.hide();
                    this.gs.requestFocus();
                }
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.2f));
                this.rd.drawImage(this.xt.bggo, 0, 0, null);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.fillRect(65, 425, 670, 25);
                this.rd.fillRect(0, 0, 65, 450);
                this.rd.fillRect(735, 0, 65, 450);
                this.rd.fillRect(65, 0, 670, 25);
                float n4 = 1.0f - (this.lg.flipo - 10) / 80.0f;
                if (n4 > 1.0f) {
                    n4 = 1.0f;
                }
                if (n4 < 0.0f) {
                    n4 = 0.0f;
                }
                this.rd.setComposite(AlphaComposite.getInstance(3, n4));
                if (this.lg.flipo <= 10) {
                    this.rd.drawImage(this.xt.logomadnes, 97, 36, null);
                }
                else {
                    this.rd.drawImage(this.xt.logomadnes, 97 + (int)(2.0 - Math.random() * 4.0), 36 + (int)(2.0 - Math.random() * 4.0), null);
                }
                final Login lg = this.lg;
                ++lg.flipo;
                if (this.lg.flipo > 50) {
                    this.lg.flipo = 0;
                }
                final int n5 = 30;
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(115, 57 + n5, 570, 307, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                this.rd.setColor(this.color2k(90, 90, 90));
                this.rd.drawRoundRect(115, 57 + n5, 570, 307, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(this.color2k(0, 0, 0));
                this.rd.drawString("You are allowed 5 multiplayer turns per day to try the game with your trial account.", 135, 85 + n5);
                this.rd.drawString("Upgrade your account to a full account to purchase and play the multiplayer game.", 135, 105 + n5);
                this.drawSbutton(this.xt.upgrade, 400, 130 + n5);
                this.rd.setColor(new Color(30, 70, 110));
                this.rd.drawString("You can upgrade your account by just sharing the game & posting about it online!", 135, 165 + n5);
                this.rd.drawString("Click 'Upgrade' for more details.", 135, 185 + n5);
                this.rd.drawString("Or try the multiplayer again tomorrow.", 135, 205 + n5);
                this.rd.setColor(this.color2k(0, 0, 0));
                this.rd.drawString("For now to preview and try the multiplayer more, with your trial account you can:", 135, 245 + n5);
                this.rd.setColor(new Color(30, 70, 110));
                this.rd.drawString("-  Watch online multiplayer games.", 135, 265 + n5);
                this.rd.drawString("-  Access the multiplayer dome.", 135, 285 + n5);
                this.rd.drawString("-  Play LAN multiplayer games (unlimitedly).", 135, 305 + n5);
                this.drawSbutton(this.xt.exit, 400, 336 + n5);
            }
            else if (this.onjoin != -1) {
                if (!this.jflexo) {
                    this.xt.jflexo();
                    this.jflexo = true;
                }
                this.btn = 0;
                if (this.gs.cmsg.isShowing()) {
                    this.gs.cmsg.hide();
                    this.gs.requestFocus();
                }
                this.rd.setColor(this.color2k(255, 255, 255));
                this.rd.fillRoundRect(155, 148, 490, 127, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(155, 148, 490, 127, 20, 20);
                if (this.ontyp == 76) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString(": :   Custom Stage   : :", 400 - this.ftm.stringWidth(": :   Custom Stage   : :") / 2, 175);
                    this.rd.drawString("You need to upgrade to a full account to join this game!", 400 - this.ftm.stringWidth("You need to upgrade to a full account to join this game!") / 2, 202);
                    this.rd.setColor(this.color2k(200, 200, 200));
                    this.rd.fillRoundRect(310, 215, 180, 50, 20, 20);
                    this.drawSbutton(this.xt.upgrade, 400, 240);
                    this.stringbutton("  Cancel X  ", 593, 259, 2);
                }
                else {
                    String s = "";
                    int n6 = 0;
                    if (this.ontyp >= 10) {
                        n6 = 10;
                        s = "Custom Cars";
                        if (this.ontyp > 10) {
                            s += ", ";
                        }
                    }
                    if (this.ontyp >= 20) {
                        n6 = 20;
                        s = "Game Cars";
                        if (this.ontyp > 20) {
                            s += ", ";
                        }
                    }
                    if (this.ontyp >= 30) {
                        n6 = 30;
                        s = "Clan Cars";
                        if (this.ontyp > 30) {
                            s += ", ";
                        }
                    }
                    if (this.ontyp - n6 == 1) {
                        s += "Class C";
                    }
                    if (this.ontyp - n6 == 2) {
                        s += "Class B & C";
                    }
                    if (this.ontyp - n6 == 3) {
                        s += "Class B";
                    }
                    if (this.ontyp - n6 == 4) {
                        s += "Class A & B";
                    }
                    if (this.ontyp - n6 == 5) {
                        s += "Class A";
                    }
                    if (this.ontyp <= -2) {
                        if (Math.abs(this.ontyp + 2) != 13) {
                            s = "" + this.cd.names[Math.abs(this.ontyp + 2)] + " Game";
                        }
                        else {
                            s = " " + this.cd.names[Math.abs(this.ontyp + 2)] + "  Game";
                        }
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString(": :   " + s + "   : :", 400 - this.ftm.stringWidth(": :   " + s + "   : :") / 2, 175);
                    String s2 = "a";
                    if (this.ontyp - n6 == 1) {
                        s2 = "a class C";
                    }
                    if (this.ontyp - n6 == 2) {
                        s2 = "a class B or C";
                    }
                    if (this.ontyp - n6 == 3) {
                        s2 = "a class B";
                    }
                    if (this.ontyp - n6 == 4) {
                        s2 = "a class A or B";
                    }
                    if (this.ontyp - n6 == 5) {
                        s2 = "a class A";
                    }
                    if (n6 == 0) {
                        s2 += " car";
                    }
                    if (n6 == 10) {
                        s2 += " custom car";
                    }
                    if (n6 == 20) {
                        s2 += " game car";
                    }
                    if (n6 == 30) {
                        s2 += " clan car";
                    }
                    if (this.ontyp <= -2) {
                        if (Math.abs(this.ontyp + 2) != 13) {
                            s2 = "" + this.cd.names[Math.abs(this.ontyp + 2)] + "";
                        }
                        else {
                            s2 = " " + this.cd.names[Math.abs(this.ontyp + 2)] + " ";
                        }
                    }
                    this.rd.drawString("To join this game you need to have " + s2 + "!", 400 - this.ftm.stringWidth("To join this game you need to have " + s2 + "!") / 2, 206);
                    this.stringbutton("  Get " + s2 + " now  ", 400, 247, 0);
                    this.stringbutton("  Cancel X  ", 593, 259, 2);
                    if (this.gb.open > 0) {
                        if (this.gb.upo) {
                            this.onjoin = -1;
                        }
                    }
                }
            }
            else {
                this.xt.mainbg(3);
                if (this.britchl == -1) {
                    this.ongame = -1;
                    this.britchl = 0;
                }
                this.btn = 0;
                this.pbtn = 0;
                this.zeromsw = false;
                int npo = this.npo;
                if (this.invo) {
                    npo = 0;
                    for (int i = 0; i < this.npo; ++i) {
                        if (this.pgames[i] == -1) {
                            ++npo;
                        }
                    }
                    npo += 2;
                }
                int n7 = (npo - 11) * 30;
                if (n7 < 0) {
                    n7 = 0;
                }
                final int n8 = (int)(this.spos / 295.0f * n7);
                int n9 = 0;
                int n10 = -1;
                int n11 = -1;
                if (this.conon == 1) {
                    if (!this.invo) {
                        for (int j = 0; j < this.npo; ++j) {
                            if (this.pgames[j] != -1) {
                                int n12 = 0;
                                for (int k = 0; k < this.ngm; ++k) {
                                    if (this.pgames[j] == this.gnum[k]) {
                                        n12 = k;
                                    }
                                }
                                if (this.wait[n12] > 0) {
                                    if (82 + 30 * n9 - n8 > 50) {
                                        if (82 + 30 * (n9 - 1) - n8 < 415) {
                                            boolean b2 = false;
                                            if (n > 70) {
                                                if (n < 185) {
                                                    if (n2 > 52 + 30 * n9 - n8) {
                                                        if (n2 < 82 + 30 * n9 - n8) {
                                                            if (this.pgames[this.im] == -1) {
                                                                if (this.join == -1) {
                                                                    if (this.chalngd >= -1) {
                                                                        Label_0729: {
                                                                            if (!b) {
                                                                                if (this.mousonp != j) {
                                                                                    this.rd.setColor(this.color2k(220, 220, 220));
                                                                                    break Label_0729;
                                                                                }
                                                                            }
                                                                            this.rd.setColor(this.color2k(255, 255, 255));
                                                                            this.mousonp = j;
                                                                            n11 = 52 + 30 * n9 - n8;
                                                                            if (!b) {
                                                                                if (this.cmonp == -1) {
                                                                                    this.ongame = -1;
                                                                                    this.cmonp = j;
                                                                                }
                                                                                if (this.ongame == this.pgames[j]) {
                                                                                    this.mousonp = -1;
                                                                                }
                                                                            }
                                                                            else {
                                                                                if (this.cmonp == j) {
                                                                                    this.ongame = this.pgames[j];
                                                                                }
                                                                                this.chalngd = -1;
                                                                            }
                                                                        }
                                                                        this.rd.fillRect(70, 53 + 30 * n9 - n8, 116, 29);
                                                                        n10 = j;
                                                                    }
                                                                }
                                                            }
                                                            b2 = true;
                                                            if (control.handb) {
                                                                this.gs.cmsg.setText(this.gs.cmsg.getText() + "" + this.pnames[j]);
                                                                control.handb = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            Label_0924: {
                                                if (this.pgames[this.im] == -1) {
                                                    if (this.join == -1) {
                                                        if (this.chalngd >= -1) {
                                                            this.rd.setColor(new Color(49, 79, 0));
                                                            break Label_0924;
                                                        }
                                                    }
                                                }
                                                this.rd.setColor(new Color(34, 55, 0));
                                            }
                                            final boolean drawl = this.gb.drawl(this.rd, this.pnames[j], 68, 53 + 30 * n9 - n8, b2);
                                            Label_1134: {
                                                if (b2) {
                                                    if (drawl) {
                                                        break Label_1134;
                                                    }
                                                }
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString(this.pnames[j], 127 - this.ftm.stringWidth(this.pnames[j]) / 2, 66 + 30 * n9 - n8);
                                                this.rd.setFont(new Font("Arial", 0, 10));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString(this.pcarnames[j], 127 - this.ftm.stringWidth(this.pcarnames[j]) / 2, 78 + 30 * n9 - n8);
                                            }
                                            this.rd.setColor(this.color2k(150, 150, 150));
                                            this.rd.drawLine(70, 82 + 30 * n9 - n8, 185, 82 + 30 * n9 - n8);
                                        }
                                    }
                                    ++n9;
                                }
                            }
                        }
                    }
                    int n13 = -1;
                    if (this.invo) {
                        for (int l = 0; l < this.ngm; ++l) {
                            if (this.gwarb[l] != 0) {
                                if (this.pgames[this.im] == this.gnum[l]) {
                                    n13 = l;
                                }
                            }
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (n13 != -1) {
                            this.rd.drawString("Members of Clans", 127 - this.ftm.stringWidth("Members of Clans") / 2, 75 - n8);
                        }
                        else {
                            this.rd.drawString("Free Players", 127 - this.ftm.stringWidth("Free Players") / 2, 75 - n8);
                        }
                        this.rd.setFont(new Font("Arial", 0, 10));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Click a player to invite:", 127 - this.ftm.stringWidth("Click a player to invite:") / 2, 92 - n8);
                        this.rd.setColor(this.color2k(150, 150, 150));
                        this.rd.drawLine(70, 112 - n8, 185, 112 - n8);
                        n9 += 2;
                    }
                    for (int mousonp = 0; mousonp < this.npo; ++mousonp) {
                        int n14 = 0;
                        if (this.invo) {
                            if (this.im == mousonp) {
                                n14 = 1;
                            }
                            for (int n15 = 0; n15 < 7; ++n15) {
                                if (this.invos[n15].equals(this.pnames[mousonp])) {
                                    if (n14 == 0) {
                                        n14 = 1;
                                    }
                                }
                            }
                            if (n13 != -1) {
                                if (!this.pclan[mousonp].toLowerCase().equals(this.gaclan[n13].toLowerCase())) {
                                    if (!this.pclan[mousonp].toLowerCase().equals(this.gvclan[n13].toLowerCase())) {
                                        n14 = 1;
                                    }
                                }
                            }
                        }
                        if (this.pgames[mousonp] == -1) {
                            if (n14 == 0) {
                                if (82 + 30 * n9 - n8 > 50) {
                                    if (82 + 30 * (n9 - 1) - n8 < 415) {
                                        boolean b3 = false;
                                        if (n > 70) {
                                            if (n < 185) {
                                                if (n2 > 52 + 30 * n9 - n8) {
                                                    if (n2 < 82 + 30 * n9 - n8) {
                                                        if (!this.invo) {
                                                            if (this.pgames[this.im] == -1) {
                                                                if (this.join == -1) {
                                                                    if (this.chalngd >= -1) {
                                                                        pcurs = 12;
                                                                        if (b) {
                                                                            if (!this.gb.proname.equals(this.pnames[mousonp])) {
                                                                                this.gb.proname = this.pnames[mousonp];
                                                                                this.gb.loadedp = false;
                                                                            }
                                                                            this.gb.tab = 1;
                                                                            this.gb.open = 2;
                                                                            this.gb.upo = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else {
                                                            Label_2059: {
                                                                if (!b) {
                                                                    this.rd.setColor(this.color2k(220, 220, 220));
                                                                    if (this.mousonp == mousonp) {
                                                                        int n16 = 0;
                                                                        int n17 = 0;
                                                                        while (true) {
                                                                            while (n16 < 7) {
                                                                                if (n17 != 0) {
                                                                                    this.mousonp = -1;
                                                                                    this.invo = false;
                                                                                    break Label_2059;
                                                                                }
                                                                                if (this.invos[n16].equals("")) {
                                                                                    this.invos[n16] = this.pnames[mousonp];
                                                                                    n17 = 1;
                                                                                }
                                                                                ++n16;
                                                                            }
                                                                            continue;
                                                                        }
                                                                    }
                                                                }
                                                                else {
                                                                    this.rd.setColor(this.color2k(255, 255, 255));
                                                                    this.mousonp = mousonp;
                                                                }
                                                            }
                                                            this.rd.fillRect(70, 53 + 30 * n9 - n8, 116, 29);
                                                            n10 = mousonp;
                                                        }
                                                        b3 = true;
                                                        if (control.handb) {
                                                            this.gs.cmsg.setText(this.gs.cmsg.getText() + "" + this.pnames[mousonp]);
                                                            control.handb = false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (!this.invo) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                        }
                                        else {
                                            this.rd.setColor(new Color(62, 98, 0));
                                        }
                                        final boolean drawl2 = this.gb.drawl(this.rd, this.pnames[mousonp], 68, 53 + 30 * n9 - n8, b3);
                                        Label_2568: {
                                            if (b3) {
                                                if (drawl2) {
                                                    break Label_2568;
                                                }
                                            }
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(this.pnames[mousonp], 127 - this.ftm.stringWidth(this.pnames[mousonp]) / 2, 66 + 30 * n9 - n8);
                                            this.rd.setFont(new Font("Arial", 0, 10));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(this.pcarnames[mousonp], 127 - this.ftm.stringWidth(this.pcarnames[mousonp]) / 2, 78 + 30 * n9 - n8);
                                        }
                                        this.rd.setColor(this.color2k(150, 150, 150));
                                        this.rd.drawLine(70, 82 + 30 * n9 - n8, 185, 82 + 30 * n9 - n8);
                                    }
                                }
                                ++n9;
                            }
                        }
                    }
                    if (this.invo) {
                        if (n9 == 2) {
                            this.invo = false;
                        }
                    }
                    if (!this.invo) {
                        for (int n18 = this.npo - 1; n18 >= 0; --n18) {
                            if (this.pgames[n18] != -1) {
                                int n19 = 0;
                                for (int n20 = 0; n20 < this.ngm; ++n20) {
                                    if (this.pgames[n18] == this.gnum[n20]) {
                                        n19 = n20;
                                    }
                                }
                                if (this.wait[n19] <= 0) {
                                    boolean b4 = false;
                                    for (int n21 = 0; n21 < this.npo; ++n21) {
                                        if (n18 != n21) {
                                            if (this.pnames[n18].equals(this.pnames[n21])) {
                                                if (this.pgames[n21] != -1) {
                                                    for (int n22 = 0; n22 < this.ngm; ++n22) {
                                                        if (this.pgames[n21] == this.gnum[n22]) {
                                                            if (this.wait[n22] > 0) {
                                                                b4 = true;
                                                            }
                                                        }
                                                    }
                                                }
                                                else {
                                                    b4 = true;
                                                }
                                            }
                                        }
                                    }
                                    if (!b4) {
                                        if (82 + 30 * n9 - n8 > 50) {
                                            if (82 + 30 * (n9 - 1) - n8 < 415) {
                                                boolean b5 = false;
                                                if (n > 70) {
                                                    if (n < 185) {
                                                        if (n2 > 52 + 30 * n9 - n8) {
                                                            if (n2 < 82 + 30 * n9 - n8) {
                                                                if (this.pgames[this.im] == -1) {
                                                                    if (this.join == -1) {
                                                                        if (this.chalngd >= -1) {
                                                                            Label_3314: {
                                                                                if (!b) {
                                                                                    if (this.mousonp != n18) {
                                                                                        this.rd.setColor(this.color2k(220, 220, 220));
                                                                                        break Label_3314;
                                                                                    }
                                                                                }
                                                                                this.rd.setColor(this.color2k(255, 255, 255));
                                                                                this.mousonp = n18;
                                                                                n11 = 52 + 30 * n9 - n8;
                                                                                if (!b) {
                                                                                    if (this.cmonp == -1) {
                                                                                        this.ongame = -1;
                                                                                        this.cmonp = n18;
                                                                                    }
                                                                                    if (this.ongame == this.pgames[n18]) {
                                                                                        this.mousonp = -1;
                                                                                    }
                                                                                }
                                                                                else {
                                                                                    if (this.cmonp == n18) {
                                                                                        this.ongame = this.pgames[n18];
                                                                                    }
                                                                                    this.chalngd = -1;
                                                                                }
                                                                            }
                                                                            this.rd.fillRect(70, 53 + 30 * n9 - n8, 116, 29);
                                                                            n10 = n18;
                                                                        }
                                                                    }
                                                                }
                                                                b5 = true;
                                                                if (control.handb) {
                                                                    this.gs.cmsg.setText(this.gs.cmsg.getText() + "" + this.pnames[n18]);
                                                                    control.handb = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                Label_3581: {
                                                    if (this.pgames[this.im] == -1) {
                                                        if (this.join == -1) {
                                                            if (this.chalngd >= -1) {
                                                                if (this.wait[n19] != 0) {
                                                                    this.rd.setColor(this.color2k(0, 28, 102));
                                                                    break Label_3581;
                                                                }
                                                                this.rd.setColor(new Color(117, 67, 0));
                                                                break Label_3581;
                                                            }
                                                        }
                                                    }
                                                    if (this.wait[n19] != 0) {
                                                        this.rd.setColor(this.color2k(0, 20, 71));
                                                    }
                                                    else {
                                                        this.rd.setColor(new Color(82, 47, 0));
                                                    }
                                                }
                                                final boolean drawl3 = this.gb.drawl(this.rd, this.pnames[n18], 68, 53 + 30 * n9 - n8, b5);
                                                Label_3791: {
                                                    if (b5) {
                                                        if (drawl3) {
                                                            break Label_3791;
                                                        }
                                                    }
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString(this.pnames[n18], 127 - this.ftm.stringWidth(this.pnames[n18]) / 2, 66 + 30 * n9 - n8);
                                                    this.rd.setFont(new Font("Arial", 0, 10));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString(this.pcarnames[n18], 127 - this.ftm.stringWidth(this.pcarnames[n18]) / 2, 78 + 30 * n9 - n8);
                                                }
                                                this.rd.setColor(this.color2k(150, 150, 150));
                                                this.rd.drawLine(70, 82 + 30 * n9 - n8, 185, 82 + 30 * n9 - n8);
                                            }
                                        }
                                        ++n9;
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mousonp != n10) {
                    this.mousonp = -1;
                    this.cmonp = -1;
                }
                if (this.npo == 0) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("|  Loading Players  |", 127 - this.ftm.stringWidth("|  Loading Players  |") / 2, 95);
                }
                this.rd.setColor(this.color2k(205, 205, 205));
                this.rd.fillRect(65, 25, 145, 28);
                this.rd.setColor(this.color2k(150, 150, 150));
                this.rd.drawLine(65, 50, 190, 50);
                this.rd.setColor(this.color2k(205, 205, 205));
                this.rd.fillRect(65, 413, 145, 12);
                this.rd.setColor(this.color2k(150, 150, 150));
                this.rd.drawLine(65, 415, 190, 415);
                this.rd.setColor(this.color2k(205, 205, 205));
                this.rd.fillRect(193, 53, 17, 360);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawLine(211, 25, 211, 425);
                this.rd.drawImage(this.xt.roomp, 72, 30, null);
                Label_4384: {
                    if (this.mscro != 131) {
                        if (n7 != 0) {
                            this.rd.setColor(this.color2k(220, 220, 220));
                            this.rd.fill3DRect(193, 53, 17, 17, true);
                            break Label_4384;
                        }
                    }
                    if (n7 != 0) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                    }
                    else {
                        this.rd.setColor(this.color2k(205, 205, 205));
                    }
                    this.rd.fillRect(193, 53, 17, 17);
                }
                if (n7 != 0) {
                    this.rd.drawImage(this.xt.asu, 198, 59, null);
                }
                Label_4560: {
                    if (this.mscro != 132) {
                        if (n7 != 0) {
                            this.rd.setColor(this.color2k(220, 220, 220));
                            this.rd.fill3DRect(193, 396, 17, 17, true);
                            break Label_4560;
                        }
                    }
                    if (n7 != 0) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                    }
                    else {
                        this.rd.setColor(this.color2k(205, 205, 205));
                    }
                    this.rd.fillRect(193, 396, 17, 17);
                }
                if (n7 != 0) {
                    this.rd.drawImage(this.xt.asd, 198, 403, null);
                }
                if (n7 != 0) {
                    if (this.conon == 1) {
                        if (this.lspos == this.spos) {
                            if (this.mscro == 131) {
                                this.rd.setColor(this.color2k(215, 215, 215));
                            }
                            this.rd.fill3DRect(193, 70 + this.spos, 17, 31, true);
                        }
                        else {
                            this.rd.setColor(this.color2k(215, 215, 215));
                            this.rd.fillRect(193, 70 + this.spos, 17, 31);
                        }
                        this.rd.setColor(this.color2k(150, 150, 150));
                        this.rd.drawLine(198, 83 + this.spos, 204, 83 + this.spos);
                        this.rd.drawLine(198, 85 + this.spos, 204, 85 + this.spos);
                        this.rd.drawLine(198, 87 + this.spos, 204, 87 + this.spos);
                        if (this.mscro > 101) {
                            if (this.lspos != this.spos) {
                                this.lspos = this.spos;
                            }
                        }
                        if (!b) {
                            if (this.mscro != 125) {
                                this.mscro = 125;
                            }
                        }
                        else {
                            if (this.mscro == 125) {
                                if (n > 193) {
                                    if (n < 210) {
                                        if (n2 > 70 + this.spos) {
                                            if (n2 < this.spos + 101) {
                                                this.mscro = n2 - this.spos;
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.mscro == 125) {
                                if (n > 191) {
                                    if (n < 212) {
                                        if (n2 > 51) {
                                            if (n2 < 72) {
                                                this.mscro = 131;
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.mscro == 125) {
                                if (n > 191) {
                                    if (n < 212) {
                                        if (n2 > 394) {
                                            if (n2 < 415) {
                                                this.mscro = 132;
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.mscro == 125) {
                                if (n > 193) {
                                    if (n < 210) {
                                        if (n2 > 70) {
                                            if (n2 < 396) {
                                                this.mscro = 85;
                                                this.spos = n2 - this.mscro;
                                            }
                                        }
                                    }
                                }
                            }
                            int n23 = 1350 / n7;
                            if (n23 < 1) {
                                n23 = 1;
                            }
                            if (this.mscro == 131) {
                                this.spos -= n23;
                                if (this.spos > 295) {
                                    this.spos = 295;
                                }
                                if (this.spos < 0) {
                                    this.spos = 0;
                                }
                                this.lspos = this.spos;
                            }
                            if (this.mscro == 132) {
                                this.spos += n23;
                                if (this.spos > 295) {
                                    this.spos = 295;
                                }
                                if (this.spos < 0) {
                                    this.spos = 0;
                                }
                                this.lspos = this.spos;
                            }
                            if (this.mscro <= 101) {
                                this.spos = n2 - this.mscro;
                                if (this.spos > 295) {
                                    this.spos = 295;
                                }
                                if (this.spos < 0) {
                                    this.spos = 0;
                                }
                            }
                            if (this.mscro == 125) {
                                this.mscro = 225;
                            }
                        }
                        if (n3 != 0) {
                            if (n > 65) {
                                if (n < 170) {
                                    if (n2 > 93) {
                                        if (n2 < 413) {
                                            this.spos -= n3;
                                            this.zeromsw = true;
                                            if (this.spos > 295) {
                                                this.spos = 295;
                                                this.zeromsw = false;
                                            }
                                            if (this.spos < 0) {
                                                this.spos = 0;
                                                this.zeromsw = false;
                                            }
                                            this.lspos = this.spos;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Label_50933: {
                    if (this.ongame != -1) {
                        if (this.opengame >= 26) {
                            this.rd.setColor(this.color2k(255, 255, 255));
                            this.rd.fillRoundRect(225, 1, 495, 417, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 1, 495, 417, 20, 20);
                            Label_29199: {
                                if (this.join > -1) {
                                    if (this.pgames[this.im] != this.join) {
                                        break Label_29199;
                                    }
                                }
                                if (this.join != -2) {
                                    int n24 = 0;
                                    for (int n25 = 0; n25 < this.ngm; ++n25) {
                                        if (this.ongame == this.gnum[n25]) {
                                            n24 = n25;
                                        }
                                    }
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    int n26 = 23;
                                    int n27 = 0;
                                    if (this.gwarb[n24] != 0) {
                                        n26 = 28;
                                        n27 = 2;
                                        String s3 = "Clan war";
                                        if (this.gwarb[n24] == 2) {
                                            s3 = "Car battle";
                                        }
                                        if (this.gwarb[n24] == 3) {
                                            s3 = "Stage battle";
                                        }
                                        this.rd.drawString("" + s3 + " between " + this.gaclan[n24] + " and " + this.gvclan[n24] + "", 243, 14);
                                    }
                                    String s4 = "";
                                    String s5 = "";
                                    String s6 = "";
                                    if (this.conon != 1) {
                                        this.rd.drawString("Status:", 241 + n27, n26);
                                        this.rd.setColor(new Color(128, 73, 0));
                                        this.rd.drawString("Starting...", 286 + n27, n26);
                                    }
                                    else {
                                        if (this.wait[n24] > 0) {
                                            if (this.gwarb[n24] != 0) {
                                                String s7 = "Game #" + this.gameturn[n24] + "";
                                                if (this.gcrs[n24] == 1) {
                                                    s7 += " | Clan Cars";
                                                }
                                                if (this.gcrs[n24] == 2) {
                                                    s7 += " | Game Cars";
                                                }
                                                if (this.gclss[n24] == 1) {
                                                    s7 += " | Class C";
                                                }
                                                if (this.gclss[n24] == 2) {
                                                    s7 += " | Class B & C";
                                                }
                                                if (this.gclss[n24] == 3) {
                                                    s7 += " | Class B";
                                                }
                                                if (this.gclss[n24] == 4) {
                                                    s7 += " | Class A & B";
                                                }
                                                if (this.gclss[n24] == 5) {
                                                    s7 += " | Class A";
                                                }
                                                if (this.gfx[n24] == 1) {
                                                    s7 += " | 4 Fixes";
                                                }
                                                if (this.gfx[n24] == 2) {
                                                    s7 += " | 3 Fixes";
                                                }
                                                if (this.gfx[n24] == 3) {
                                                    s7 += " | 2 Fixes";
                                                }
                                                if (this.gfx[n24] == 4) {
                                                    s7 += " | 1 Fix";
                                                }
                                                if (this.gfx[n24] == 5) {
                                                    s7 += " | No Fixing";
                                                }
                                                this.rd.setColor(new Color(80, 128, 0));
                                                this.rd.drawString(s7, 243, 28);
                                            }
                                            else {
                                                String s8;
                                                if (!this.gplyrs[n24].equals("")) {
                                                    s8 = "Private Game";
                                                }
                                                else {
                                                    s8 = "Public Game";
                                                }
                                                if (this.gfx[n24] == 1) {
                                                    s8 += " | 4 Fixes";
                                                }
                                                if (this.gfx[n24] == 2) {
                                                    s8 += " | 3 Fixes";
                                                }
                                                if (this.gfx[n24] == 3) {
                                                    s8 += " | 2 Fixes";
                                                }
                                                if (this.gfx[n24] == 4) {
                                                    s8 += " | 1 Fix";
                                                }
                                                if (this.gfx[n24] == 5) {
                                                    s8 += " | No Fixing";
                                                }
                                                String s9 = "";
                                                String s10 = null;
                                                if (this.gclss[n24] <= -2) {
                                                    s10 = "" + this.cd.names[Math.abs(this.gclss[n24] + 2)] + "";
                                                }
                                                else {
                                                    if (this.gcrs[n24] == 1) {
                                                        s9 = "Custom Cars";
                                                    }
                                                    if (this.gcrs[n24] == 2) {
                                                        s9 = "Game Cars";
                                                    }
                                                    String s11 = "";
                                                    if (this.gclss[n24] == 1) {
                                                        s11 = "Class C";
                                                    }
                                                    if (this.gclss[n24] == 2) {
                                                        s11 = "Class B & C";
                                                    }
                                                    if (this.gclss[n24] == 3) {
                                                        s11 = "Class B";
                                                    }
                                                    if (this.gclss[n24] == 4) {
                                                        s11 = "Class A & B";
                                                    }
                                                    if (this.gclss[n24] == 5) {
                                                        s11 = "Class A";
                                                    }
                                                    Label_30711: {
                                                        if (!s9.equals("")) {
                                                            if (!s11.equals("")) {
                                                                s10 = s9 + " | " + s11;
                                                                break Label_30711;
                                                            }
                                                        }
                                                        s10 = s9 + s11;
                                                    }
                                                }
                                                if (!s10.equals("")) {
                                                    this.rd.drawString("Type:", 243, 14);
                                                    this.rd.drawString("Cars:", 244, 28);
                                                    this.rd.setColor(new Color(80, 128, 0));
                                                    this.rd.drawString(s8, 279, 14);
                                                    this.rd.drawString(s10, 279, 28);
                                                }
                                                else {
                                                    this.rd.drawString("Type:", 243, 23);
                                                    this.rd.setColor(new Color(80, 128, 0));
                                                    this.rd.drawString(s8, 279, 23);
                                                }
                                            }
                                        }
                                        if (this.wait[n24] == 0) {
                                            this.rd.drawString("Status:", 241 + n27, n26);
                                            this.rd.setColor(new Color(128, 73, 0));
                                            if (this.prevloaded != 0) {
                                                this.rd.drawString("Started", 286 + n27, n26);
                                            }
                                            else {
                                                this.rd.drawString("Starting...", 286 + n27, n26);
                                            }
                                        }
                                        if (this.wait[n24] == -1) {
                                            this.rd.drawString("Status:", 241 + n27, n26);
                                            this.rd.setColor(this.color2k(100, 100, 100));
                                            this.rd.drawString("Finished", 286 + n27, n26);
                                        }
                                    }
                                    Label_33770: {
                                        if (this.gwarb[n24] != 0) {
                                            if (this.wait[n24] != 0) {
                                                if (this.wait[n24] != -1) {
                                                    if (this.conon == 1) {
                                                        break Label_33770;
                                                    }
                                                }
                                            }
                                            this.rd.setColor(this.color2k(200, 200, 200));
                                            this.rd.drawRect(349, 16, 253, 16);
                                            this.rd.setFont(new Font("Arial", 0, 11));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.setColor(new Color(0, 0, 0));
                                            int n28 = 0;
                                            int n29 = 0;
                                            Label_33337: {
                                                if (this.wait[n24] == -1) {
                                                    final String[] array2 = { "", "", "", "", "", "", "", "" };
                                                    for (int n30 = 0; n30 < this.prnpo; ++n30) {
                                                        for (int n31 = 0; n31 < this.npo; ++n31) {
                                                            if (this.prnames[n30].equals(this.pnames[n31])) {
                                                                if (this.pgames[n31] == this.gnum[n24]) {
                                                                    array2[n30] = this.pclan[n31];
                                                                }
                                                            }
                                                        }
                                                    }
                                                    while (true) {
                                                        boolean b6;
                                                        boolean b7;
                                                        boolean b8;
                                                        boolean b9;
                                                        boolean b10;
                                                        boolean b11;
                                                        int a = 0;
                                                         //Label_33061_Outer:
                                                        Label_32727_Outer:
                                                        for (int n32 = 0; n32 < this.prnpo; ++n32) {
                                                            if (this.ppos[n32] == 0) {
                                                                s4 = array2[n32];
                                                                Label_33264: {
                                                                    if (s4.equals("")) {
                                                                        s6 = "No one finished first - no one survived!";
                                                                    }
                                                                    else {
                                                                        Label_32429: {
                                                                            if (this.gwtyp[n24] == 2) {
                                                                                b6 = false;
                                                                                while (true) {
                                                                                    for (int n33 = 0; n33 < this.prnpo; ++n33) {
                                                                                        if (!array2[n33].toLowerCase().equals(s4.toLowerCase())) {
                                                                                            if (this.pdam[n33] < 55) {
                                                                                                if (this.pdam[n33] != -17) {
                                                                                                    b6 = true;
                                                                                                    if (!b6) {
                                                                                                        s6 = "" + s4 + " should have raced in this game!";
                                                                                                        s4 = "";
                                                                                                    }
                                                                                                    break Label_32429;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                        Label_32591: {
                                                                            if (this.gwtyp[n24] == 3) {
                                                                                b7 = true;
                                                                                while (true) {
                                                                                    for (int n34 = 0; n34 < this.prnpo; ++n34) {
                                                                                        if (!array2[n34].toLowerCase().equals(s4.toLowerCase())) {
                                                                                            if (this.pdam[n34] < 55) {
                                                                                                if (this.pdam[n34] != -17) {
                                                                                                    b7 = false;
                                                                                                    if (!b7) {
                                                                                                        s6 = "" + s4 + " should have wasted in this game!";
                                                                                                        s4 = "";
                                                                                                    }
                                                                                                    break Label_32591;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                        Label_32925: {
                                                                            if (this.gwtyp[n24] == 4) {
                                                                                if (!s4.toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                                                    b8 = false;
                                                                                    while (true) {
                                                                                        for (int n35 = 0; n35 < this.prnpo; ++n35) {
                                                                                            if (!array2[n35].toLowerCase().equals(s4.toLowerCase())) {
                                                                                                if (this.pdam[n35] < 55) {
                                                                                                    if (this.pdam[n35] != -17) {
                                                                                                        b8 = true;
                                                                                                        if (!b8) {
                                                                                                            s6 = "" + s4 + " should have raced in this game!";
                                                                                                            s4 = "";
                                                                                                        }
                                                                                                        break Label_32925;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        continue Label_32727_Outer;
                                                                                    }
                                                                                }
                                                                                b9 = true;
                                                                                while (true) {
                                                                                    for (int n36 = 0; n36 < this.prnpo; ++n36) {
                                                                                        if (!array2[n36].toLowerCase().equals(s4.toLowerCase())) {
                                                                                            if (this.pdam[n36] < 55) {
                                                                                                if (this.pdam[n36] != -17) {
                                                                                                    b9 = false;
                                                                                                    if (!b9) {
                                                                                                        s6 = "" + s4 + " should have wasted in this game!";
                                                                                                        s4 = "";
                                                                                                    }
                                                                                                    break Label_32925;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (this.gwtyp[n24] == 5) {
                                                                            if (s4.toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                                                b10 = false;
                                                                                while (true) {
                                                                                    for (int n37 = 0; n37 < this.prnpo; ++n37) {
                                                                                        if (!array2[n37].toLowerCase().equals(s4.toLowerCase())) {
                                                                                            if (this.pdam[n37] < 55) {
                                                                                                if (this.pdam[n37] != -17) {
                                                                                                    b10 = true;
                                                                                                    if (!b10) {
                                                                                                        s6 = "" + s4 + " should have raced in this game!";
                                                                                                        s4 = "";
                                                                                                    }
                                                                                                    break Label_33264;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    continue Label_32727_Outer;
                                                                                }
                                                                            }
                                                                            b11 = true;
                                                                            while (true) {
                                                                                for (int n38 = 0; n38 < this.prnpo; ++n38) {
                                                                                    if (!array2[n38].toLowerCase().equals(s4.toLowerCase())) {
                                                                                        if (this.pdam[n38] < 55) {
                                                                                            if (this.pdam[n38] != -17) {
                                                                                                b11 = false;
                                                                                                if (!b11) {
                                                                                                    s6 = "" + s4 + " should have wasted in this game!";
                                                                                                    s4 = "";
                                                                                                }
                                                                                                break Label_33264;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                continue;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if (s4.toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                                    n28 = 1;
                                                                }
                                                                if (s4.toLowerCase().equals(this.gvclan[n24].toLowerCase())) {
                                                                    n29 = 1;
                                                                }
                                                                break Label_33337;
                                                            }
                                                        }
                                                        continue;
                                                    }
                                                }
                                            }
                                            this.rd.drawString("" + this.gaclan[n24] + " : " + (this.gascore[n24] + n28) + "     |     " + this.gvclan[n24] + " : " + (this.gvscore[n24] + n29) + "", 474 - this.ftm.stringWidth("" + this.gaclan[n24] + " : " + this.gascore[n24] + "     |     " + this.gvclan[n24] + " : " + this.gvscore[n24] + "") / 2, 28);
                                            if (this.gwarb[n24] != 1) {
                                                if (this.gascore[n24] + n28 >= 3) {
                                                    s5 = "" + this.gaclan[n24] + " wins the battle!";
                                                }
                                                if (this.gvscore[n24] + n29 >= 3) {
                                                    s5 = "" + this.gvclan[n24] + " wins the battle!";
                                                }
                                            }
                                            else {
                                                if (this.gascore[n24] + n28 >= 5) {
                                                    s5 = "" + this.gaclan[n24] + " wins the war!";
                                                }
                                                if (this.gvscore[n24] + n29 >= 5) {
                                                    s5 = "" + this.gvclan[n24] + " wins the war!";
                                                }
                                            }
                                        }
                                        else {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            if (!this.gmaker[n24].equals(this.pnames[this.im])) {
                                                this.rd.drawString("Created by", 449, 23);
                                                this.rd.drawString(":", 511, 23);
                                                this.rd.drawString(this.gmaker[n24], 520, 23);
                                            }
                                            else {
                                                this.rd.drawString("Created by You", 449, 23);
                                            }
                                        }
                                    }
                                    this.rd.setColor(this.color2k(200, 200, 200));
                                    this.rd.drawLine(233, 32, 602, 32);
                                    this.rd.drawLine(602, 7, 602, 32);
                                    if (this.conon == 1) {
                                        if (this.pgames[this.im] != this.ongame) {
                                            this.stringbutton("Close X", 679, 26, 0);
                                        }
                                        else {
                                            this.stringbutton("Leave Game X", 660, 26, 0);
                                        }
                                    }
                                    this.rd.drawImage(this.xt.pls, 292, 39, null);
                                    if (this.opengame != 27) {
                                        this.m.crs = true;
                                        this.m.x = -335;
                                        this.m.y = 0;
                                        this.m.z = -50;
                                        this.m.xz = 0;
                                        this.m.zy = 20;
                                        this.m.ground = -2000;
                                        this.pend = 0;
                                        this.pendb = false;
                                        this.ptime = 0L;
                                        this.opengame = 27;
                                    }
                                    int n39 = 0;
                                    int dispcar = -1;
                                    for (int n40 = 0; n40 < this.npo; ++n40) {
                                        if (this.pgames[n40] == this.ongame) {
                                            this.rd.setColor(this.color2k(240, 240, 240));
                                            Label_34179: {
                                                if (n40 == this.im) {
                                                    if (this.wait[n24] != -1) {
                                                        if (this.nflk != 0) {
                                                            if (this.conon != 2) {
                                                                --this.nflk;
                                                                break Label_34179;
                                                            }
                                                        }
                                                        this.rd.setColor(this.color2k(255, 255, 255));
                                                        this.nflk = 3;
                                                    }
                                                }
                                            }
                                            this.rd.fillRect(237, 54 + n39 * 42, 170, 40);
                                            this.rd.setColor(this.color2k(200, 200, 200));
                                            if (this.gwarb[n24] == 0) {
                                                if (this.wait[n24] == -1) {
                                                    if (this.prevloaded == 1) {
                                                        for (int n41 = 0; n41 < this.prnpo; ++n41) {
                                                            if (this.pnames[n40].equals(this.prnames[n41])) {
                                                                if (this.ppos[n41] == 0) {
                                                                    if (this.nflk == 0) {
                                                                        this.rd.setColor(new Color(0, 0, 0));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            else {
                                                if (this.pclan[n40].toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                    this.rd.setColor(new Color(255, 128, 0));
                                                }
                                                if (this.pclan[n40].toLowerCase().equals(this.gvclan[n24].toLowerCase())) {
                                                    this.rd.setColor(new Color(0, 128, 255));
                                                }
                                                if (this.wait[n24] == -1) {
                                                    if (this.prevloaded == 1) {
                                                        if (s4.toLowerCase().equals(this.pclan[n40].toLowerCase())) {
                                                            if (this.nflk == 0) {
                                                                this.rd.setColor(new Color(0, 0, 0));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            this.rd.drawRect(237, 54 + n39 * 42, 170, 40);
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(this.pnames[n40], 282 - this.ftm.stringWidth(this.pnames[n40]) / 2, 72 + n39 * 42);
                                            this.rd.setFont(new Font("Arial", 0, 10));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(this.pcarnames[n40], 282 - this.ftm.stringWidth(this.pcarnames[n40]) / 2, 84 + n39 * 42);
                                            this.m.crs = true;
                                            this.m.x = -335;
                                            this.m.y = 0;
                                            this.m.z = -50;
                                            this.m.xz = 0;
                                            this.m.zy = 20;
                                            this.m.ground = -2000;
                                            if (this.pcars[n40] == -1) {
                                                this.rd.setFont(new Font("Arial", 1, 11));
                                                this.rd.setColor(this.color2k(80, 80, 80));
                                                this.rd.drawString("Loading...", 339, 77 + n39 * 42);
                                            }
                                            else {
                                                for (int n42 = 0; n42 < array[this.pcars[n40]].npl; ++n42) {
                                                    array[this.pcars[n40]].p[n42].flx = 0;
                                                    if (array[this.pcars[n40]].p[n42].colnum == 1) {
                                                        array[this.pcars[n40]].p[n42].hsb[0] = this.pcols[n40][0];
                                                        array[this.pcars[n40]].p[n42].hsb[1] = this.pcols[n40][1];
                                                        array[this.pcars[n40]].p[n42].hsb[2] = 1.0f - this.pcols[n40][2];
                                                    }
                                                    if (array[this.pcars[n40]].p[n42].colnum == 2) {
                                                        array[this.pcars[n40]].p[n42].hsb[0] = this.pcols[n40][3];
                                                        array[this.pcars[n40]].p[n42].hsb[1] = this.pcols[n40][4];
                                                        array[this.pcars[n40]].p[n42].hsb[2] = 1.0f - this.pcols[n40][5];
                                                    }
                                                }
                                                if (this.cac[n39] != this.pcars[n40]) {
                                                    int n44;
                                                    int n43 = n44 = array[this.pcars[n40]].p[0].oz[0];
                                                    int n46;
                                                    int n45 = n46 = array[this.pcars[n40]].p[0].oy[0];
                                                    for (int n47 = 0; n47 < array[this.pcars[n40]].npl; ++n47) {
                                                        for (int n48 = 0; n48 < array[this.pcars[n40]].p[n47].n; ++n48) {
                                                            if (array[this.pcars[n40]].p[n47].oz[n48] < n43) {
                                                                n43 = array[this.pcars[n40]].p[n47].oz[n48];
                                                            }
                                                            if (array[this.pcars[n40]].p[n47].oz[n48] > n44) {
                                                                n44 = array[this.pcars[n40]].p[n47].oz[n48];
                                                            }
                                                            if (array[this.pcars[n40]].p[n47].oy[n48] < n45) {
                                                                n45 = array[this.pcars[n40]].p[n47].oy[n48];
                                                            }
                                                            if (array[this.pcars[n40]].p[n47].oy[n48] > n46) {
                                                                n46 = array[this.pcars[n40]].p[n47].oy[n48];
                                                            }
                                                        }
                                                    }
                                                    this.cax[n39] = (n44 + n43) / 2;
                                                    this.cay[n39] = (n46 + n45) / 2;
                                                    this.cac[n39] = this.pcars[n40];
                                                }
                                                if (n > 327) {
                                                    if (n < 402) {
                                                        if (n2 > 57 + n39 * 42) {
                                                            if (n2 < 91 + n39 * 42) {
                                                                pcurs = 12;
                                                                dispcar = n40;
                                                                for (int n49 = 0; n49 < array[this.pcars[n40]].npl; ++n49) {
                                                                    array[this.pcars[n40]].p[n49].flx = 77;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                array[this.pcars[n40]].z = 2500 - n39 * 80;
                                                array[this.pcars[n40]].y = 150 + 250 * n39 - this.cay[n39];
                                                array[this.pcars[n40]].x = -145 - this.cax[n39];
                                                array[this.pcars[n40]].zy = 0;
                                                array[this.pcars[n40]].xz = -90;
                                                array[this.pcars[n40]].xy = this.pend - n39 * 5;
                                                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                                array[this.pcars[n40]].d(this.rd);
                                                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                            }
                                            ++n39;
                                        }
                                    }
                                    if (this.pendb) {
                                        this.pend -= 2;
                                        if (this.pend < -10) {
                                            this.pendb = false;
                                        }
                                    }
                                    else {
                                        this.pend += 2;
                                        if (this.pend > 80) {
                                            this.pendb = true;
                                        }
                                    }
                                    if (dispcar == -1) {
                                        if (this.mousedout) {
                                            this.mousedout = false;
                                        }
                                    }
                                    else if (!b) {
                                        if (this.mousedout) {
                                            Label_36185: {
                                                if (this.dispcar != dispcar) {
                                                    if (dispcar != -1) {
                                                        if (this.cd.action != 6) {
                                                            this.cd.action = 0;
                                                            this.dispcar = dispcar;
                                                            this.forcar = this.pcars[dispcar];
                                                            this.dispco = null;
                                                            System.gc();
                                                            this.dispco = new ContO(array[this.forcar], 0, 0, 0, 0);
                                                            break Label_36185;
                                                        }
                                                    }
                                                }
                                                this.dispcar = -1;
                                            }
                                            this.mousedout = false;
                                        }
                                    }
                                    else {
                                        this.mousedout = true;
                                    }
                                    for (int n50 = 0; n50 < 7; ++n50) {
                                        for (int n51 = 0; n51 < this.npo; ++n51) {
                                            if (this.pgames[n51] == this.ongame) {
                                                if (this.invos[n50].equals(this.pnames[n51])) {
                                                    if (this.dinvi[n50].equals(this.invos[n50])) {
                                                        for (int n52 = n50; n52 < 6; ++n52) {
                                                            this.invos[n52] = this.invos[n52 + 1];
                                                            this.dinvi[n52] = this.dinvi[n52 + 1];
                                                        }
                                                        this.invos[6] = "";
                                                        this.dinvi[6] = "";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.wait[n24] > 0) {
                                        int n53 = 0;
                                        for (int n54 = n39; n54 < this.mnpls[n24]; ++n54) {
                                            this.rd.setColor(this.color2k(200, 200, 200));
                                            this.rd.drawRect(237, 54 + n54 * 42, 170, 40);
                                            boolean b12 = false;
                                            if (this.pgames[this.im] != this.ongame) {
                                                if (this.gwarb[n24] != 0) {
                                                    if (!this.xt.clan.toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                        if (!this.xt.clan.toLowerCase().equals(this.gvclan[n24].toLowerCase())) {
                                                            b12 = true;
                                                        }
                                                    }
                                                }
                                                else if (!this.gplyrs[n24].equals("")) {
                                                    if (this.gplyrs[n24].indexOf(this.pnames[this.im]) == -1) {
                                                        b12 = true;
                                                    }
                                                }
                                            }
                                            else if (!this.gplyrs[n24].equals("")) {
                                                b12 = true;
                                            }
                                            Label_37281: {
                                                if (n > 237) {
                                                    if (n < 407) {
                                                        if (n2 > 54 + n54 * 42) {
                                                            if (n2 < 94 + n54 * 42) {
                                                                if (!b12) {
                                                                    if (this.pgames[this.im] != this.ongame) {
                                                                        this.stringbutton("    Join Game    ", 322, 79 + n54 * 42, 0);
                                                                    }
                                                                    else {
                                                                        this.stringbutton("<     Invite Player      ", 322, 79 + n54 * 42, 0);
                                                                    }
                                                                    this.pbtn = 1;
                                                                    break Label_37281;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!this.invos[n53].equals("")) {
                                                    if (this.dinvi[n53].equals(this.invos[n53])) {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.setFont(new Font("Arial", 0, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.drawString("Player Invited!", 322 - this.ftm.stringWidth("Player Invited!") / 2, 71 + n54 * 42);
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.drawString(this.invos[n53], 322 - this.ftm.stringWidth(this.invos[n53]) / 2, 87 + n54 * 42);
                                                    }
                                                    else if (this.nflk != 0) {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.setFont(new Font("Arial", 0, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.drawString("Inviting player...", 322 - this.ftm.stringWidth("Inviting player...") / 2, 79 + n54 * 42);
                                                    }
                                                }
                                                else {
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString("Empty", 322 - this.ftm.stringWidth("Empty") / 2, 72 + n54 * 42);
                                                    this.rd.setFont(new Font("Arial", 0, 10));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString("Waiting for player...", 322 - this.ftm.stringWidth("Waiting for player...") / 2, 84 + n54 * 42);
                                                }
                                            }
                                            ++n53;
                                        }
                                    }
                                    if (this.xt.lan) {
                                        if (this.mnbts[n24] != 0) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString("Plus " + this.mnbts[n24] + " MadBots!", 322 - this.ftm.stringWidth("Plus " + this.mnbts[n24] + " MadBots!") / 2, 73 + this.mnpls[n24] * 42);
                                        }
                                    }
                                    if (this.dispcar != -1) {
                                        if (this.conon == 1) {
                                            if (this.gs.cmsg.isShowing()) {
                                                this.gs.cmsg.hide();
                                            }
                                            if (this.pcars[this.dispcar] == this.forcar) {
                                                if (this.forcar != -1) {
                                                    this.rd.drawImage(this.xt.crd, 517, 81, null);
                                                    this.rd.setColor(new Color(16, 198, 255));
                                                    this.rd.drawRect(415, 96, 293, 315);
                                                    this.rd.setColor(this.color2k(240, 240, 240));
                                                    this.rd.fillRect(416, 97, 4, 314);
                                                    this.rd.fillRect(704, 97, 4, 314);
                                                    this.rd.fillRect(416, 97, 292, 4);
                                                    this.rd.fillRect(416, 407, 292, 4);
                                                    if (this.flks < 0) {
                                                        this.rd.setColor(new Color(224, 226, 176));
                                                        --this.flks;
                                                        if (this.flks < -4) {
                                                            this.flks = 0;
                                                        }
                                                    }
                                                    else {
                                                        this.rd.setColor(new Color(239, 234, 177));
                                                        ++this.flks;
                                                        if (this.flks > 3) {
                                                            this.flks = -1;
                                                        }
                                                    }
                                                    this.rd.fillRect(445, 120, 233, 127);
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.setFont(new Font("Arial", 1, 13));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString(this.cd.names[this.forcar], 561 - this.ftm.stringWidth(this.cd.names[this.forcar]) / 2, 117);
                                                    for (int n55 = 0; n55 < this.dispco.npl; ++n55) {
                                                        if (array[this.forcar].p[n55].colnum == 1) {
                                                            this.dispco.p[n55].hsb[0] = this.pcols[this.dispcar][0];
                                                            this.dispco.p[n55].hsb[1] = this.pcols[this.dispcar][1];
                                                            this.dispco.p[n55].hsb[2] = 1.0f - this.pcols[this.dispcar][2];
                                                        }
                                                        if (array[this.forcar].p[n55].colnum == 2) {
                                                            this.dispco.p[n55].hsb[0] = this.pcols[this.dispcar][3];
                                                            this.dispco.p[n55].hsb[1] = this.pcols[this.dispcar][4];
                                                            this.dispco.p[n55].hsb[2] = 1.0f - this.pcols[this.dispcar][5];
                                                        }
                                                    }
                                                    this.m.cx = 561;
                                                    this.dispco.z = 1200;
                                                    this.dispco.y = 605 - this.dispco.grat;
                                                    this.dispco.x = 225;
                                                    this.dispco.zy = 0;
                                                    this.dispco.xz = this.mrot;
                                                    this.mrot -= 5;
                                                    if (this.mrot < -360) {
                                                        this.mrot += 360;
                                                    }
                                                    this.dispco.xy = 0;
                                                    final ContO dispco = this.dispco;
                                                    dispco.wzy -= 10;
                                                    if (this.dispco.wzy < -45) {
                                                        final ContO dispco2 = this.dispco;
                                                        dispco2.wzy += 45;
                                                    }
                                                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                                    this.dispco.d(this.rd);
                                                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                                    this.m.cx = 400;
                                                    this.rd.setFont(new Font("Arial", 1, 11));
                                                    final int n56 = 424;
                                                    final int n57 = -55;
                                                    this.rd.setColor(new Color(0, 63, 128));
                                                    this.rd.drawString("Top Speed:", 30 + n56, 318 + n57);
                                                    this.rd.drawImage(this.xt.statb, 97 + n56, 312 + n57, null);
                                                    this.rd.drawString("Acceleration:", 20 + n56, 333 + n57);
                                                    this.rd.drawImage(this.xt.statb, 97 + n56, 327 + n57, null);
                                                    this.rd.setColor(this.color2k(255, 255, 255));
                                                    float n58 = (this.cd.swits[this.forcar][2] - 220) / 90.0f;
                                                    if (n58 < 0.2) {
                                                        n58 = 0.2f;
                                                    }
                                                    this.rd.fillRect((int)(97.0f + 156.0f * n58) + n56, 312 + n57, (int)(156.0f * (1.0f - n58) + 1.0f), 7);
                                                    float n59 = this.cd.acelf[this.forcar][1] * this.cd.acelf[this.forcar][0] * this.cd.acelf[this.forcar][2] * this.cd.grip[this.forcar] / 7700.0f;
                                                    if (n59 > 1.0f) {
                                                        n59 = 1.0f;
                                                    }
                                                    this.rd.fillRect((int)(97.0f + 156.0f * n59) + n56, 327 + n57, (int)(156.0f * (1.0f - n59) + 1.0f), 7);
                                                    this.rd.drawImage(this.xt.statbo, 97 + n56, 312 + n57, null);
                                                    this.rd.drawImage(this.xt.statbo, 97 + n56, 327 + n57, null);
                                                    final int n60 = 50;
                                                    final int n61 = -25;
                                                    this.rd.setColor(new Color(0, 63, 128));
                                                    this.rd.drawString("Stunts:", 427 + n60, 318 + n61);
                                                    this.rd.drawImage(this.xt.statb, 471 + n60, 312 + n61, null);
                                                    this.rd.drawString("Strength:", 415 + n60, 333 + n61);
                                                    this.rd.drawImage(this.xt.statb, 471 + n60, 327 + n61, null);
                                                    this.rd.drawString("Endurance:", 405 + n60, 348 + n61);
                                                    this.rd.drawImage(this.xt.statb, 471 + n60, 342 + n61, null);
                                                    this.rd.setColor(this.color2k(255, 255, 255));
                                                    float n62 = (this.cd.airc[this.forcar] * this.cd.airs[this.forcar] * this.cd.bounce[this.forcar] + 28.0f) / 139.0f;
                                                    if (n62 > 1.0f) {
                                                        n62 = 1.0f;
                                                    }
                                                    this.rd.fillRect((int)(471.0f + 156.0f * n62) + n60, 312 + n61, (int)(156.0f * (1.0f - n62) + 1.0f), 7);
                                                    float n63 = (this.cd.moment[this.forcar] + 0.5f) / 2.6f;
                                                    if (n63 > 1.0f) {
                                                        n63 = 1.0f;
                                                    }
                                                    this.rd.fillRect((int)(471.0f + 156.0f * n63) + n60, 327 + n61, (int)(156.0f * (1.0f - n63) + 1.0f), 7);
                                                    final float n64 = this.cd.outdam[this.forcar];
                                                    this.rd.fillRect((int)(471.0f + 156.0f * n64) + n60, 342 + n61, (int)(156.0f * (1.0f - n64) + 1.0f), 7);
                                                    this.rd.drawImage(this.xt.statbo, 471 + n60, 312 + n61, null);
                                                    this.rd.drawImage(this.xt.statbo, 471 + n60, 327 + n61, null);
                                                    this.rd.drawImage(this.xt.statbo, 471 + n60, 342 + n61, null);
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    Label_50885: {
                                                        if (this.forcar >= 16) {
                                                            this.rd.setFont(new Font("Arial", 1, 12));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            if (this.cd.createdby[this.forcar - 16].equals(this.xt.nickname)) {
                                                                this.rd.drawString("Created by You", 561 - this.ftm.stringWidth("Created by You") / 2, 347);
                                                            }
                                                            else {
                                                                this.rd.drawString("Created by :  " + this.cd.createdby[this.forcar - 16] + "", 561 - this.ftm.stringWidth("Created by :  " + this.cd.createdby[this.forcar - 16] + "") / 2, 347);
                                                                final int stringWidth = this.ftm.stringWidth(this.cd.createdby[this.forcar - 16]);
                                                                final int n65 = 561 - this.ftm.stringWidth("Created by :  " + this.cd.createdby[this.forcar - 16] + "") / 2 + this.ftm.stringWidth("Created by :  " + this.cd.createdby[this.forcar - 16] + "") - stringWidth;
                                                                this.rd.drawLine(n65, 349, n65 + stringWidth - 2, 349);
                                                                if (n > n65 - 2) {
                                                                    if (n < n65 + stringWidth) {
                                                                        if (n2 > 334) {
                                                                            if (n2 < 351) {
                                                                                if (b) {
                                                                                    if (!this.gb.proname.equals(this.cd.createdby[this.forcar - 16])) {
                                                                                        this.gb.proname = this.cd.createdby[this.forcar - 16];
                                                                                        this.gb.loadedp = false;
                                                                                    }
                                                                                    this.gb.tab = 1;
                                                                                    this.gb.open = 2;
                                                                                    this.gb.upo = true;
                                                                                }
                                                                                pcurs = 12;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            this.rd.setColor(new Color(128, 73, 0));
                                                            String s12 = "";
                                                            if (this.cd.cclass[this.forcar] == 0) {
                                                                s12 = "Class C ,  ";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 1) {
                                                                s12 = "Class B & C ,  ";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 2) {
                                                                s12 = "Class B ,  ";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 3) {
                                                                s12 = "Class A & B ,  ";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 4) {
                                                                s12 = "Class A ,  ";
                                                            }
                                                            if (this.cd.publish[this.forcar - 16] == 0) {
                                                                s12 += "Private Car";
                                                            }
                                                            if (this.cd.publish[this.forcar - 16] == 1) {
                                                                s12 += "Public Car";
                                                                this.rd.setColor(new Color(0, 64, 128));
                                                            }
                                                            if (this.cd.publish[this.forcar - 16] == 2) {
                                                                s12 += "Super Public Car";
                                                                this.rd.setColor(new Color(0, 64, 128));
                                                            }
                                                            this.rd.drawString(s12, 561 - this.ftm.stringWidth(s12) / 2, 367);
                                                            this.rd.setColor(new Color(0, 0, 0));
                                                            this.rd.setFont(new Font("Arial", 0, 12));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            if (this.cd.publish[this.forcar - 16] != 1) {
                                                                if (this.cd.publish[this.forcar - 16] != 2) {
                                                                    this.rd.drawString("Private Car.  Cannot be added to account.", 561 - this.ftm.stringWidth("Private Car.  Cannot be added to account.") / 2, 395);
                                                                    break Label_50885;
                                                                }
                                                            }
                                                            if (this.cd.action == -9) {
                                                                this.rd.drawString("Failed to add car!  Unknown error!", 561 - this.ftm.stringWidth("Failed to add car!  Unknown error!") / 2, 395);
                                                            }
                                                            if (this.cd.action == -8) {
                                                                this.rd.drawString("Failed!  You already have 20 cars!", 561 - this.ftm.stringWidth("Failed!  You already have 20 cars!") / 2, 395);
                                                            }
                                                            if (this.cd.action == 7) {
                                                                this.rd.drawString("" + this.cd.names[this.cd.ac] + " has been added to your cars!", 561 - this.ftm.stringWidth("" + this.cd.names[this.cd.ac] + " has been added to your cars!") / 2, 395);
                                                            }
                                                            if (this.cd.action == -7) {
                                                                this.rd.drawString("You already have this car.", 561 - this.ftm.stringWidth("You already have this car.") / 2, 395);
                                                            }
                                                            if (this.cd.action == 6) {
                                                                this.rd.drawString("Adding Car...", 561 - this.ftm.stringWidth("Adding Car...") / 2, 395);
                                                            }
                                                            if (this.cd.action == -6) {
                                                                final String s13 = "Upgrade to a full account to add custom cars!";
                                                                final int n66 = 561 - this.ftm.stringWidth(s13) / 2;
                                                                final int n67 = n66 + this.ftm.stringWidth(s13);
                                                                this.rd.drawString(s13, n66, 395);
                                                                if (this.waitlink != -1) {
                                                                    this.rd.drawLine(n66, 396, n67, 396);
                                                                }
                                                                if (n > n66) {
                                                                    if (n < n67) {
                                                                        if (n2 > 384) {
                                                                            if (n2 < 397) {
                                                                                if (this.waitlink != -1) {
                                                                                    pcurs = 12;
                                                                                }
                                                                                if (b) {
                                                                                    if (this.waitlink == 0) {
                                                                                        this.gs.editlink(this.xt.nickname, true);
                                                                                        this.waitlink = -1;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if (this.waitlink > 0) {
                                                                    --this.waitlink;
                                                                }
                                                            }
                                                            if (this.cd.action == 0) {
                                                                if (this.xt.drawcarb(true, null, " Add to My Cars ", 503, 375, n, n2, b)) {
                                                                    if (!this.xt.logged) {
                                                                        this.cd.action = -6;
                                                                        this.waitlink = 20;
                                                                    }
                                                                    else {
                                                                        if (this.cd.lastload == 2) {
                                                                            if (this.forcar < 36) {
                                                                                this.cd.action = -7;
                                                                                break Label_50885;
                                                                            }
                                                                        }
                                                                        this.cd.action = 6;
                                                                        this.cd.ac = this.forcar;
                                                                        this.cd.sparkactionloader();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else {
                                                            this.rd.setFont(new Font("Arial", 1, 12));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            this.rd.drawString("Created by Radicalplay.com", 561 - this.ftm.stringWidth("Created by Radicalplay.com") / 2, 347);
                                                            String s14 = "Game Car";
                                                            if (this.cd.cclass[this.forcar] == 0) {
                                                                s14 = "Class C ,  Game Car";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 1) {
                                                                s14 = "Class B & C ,  Game Car";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 2) {
                                                                s14 = "Class B ,  Game Car";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 3) {
                                                                s14 = "Class A & B ,  Game Car";
                                                            }
                                                            if (this.cd.cclass[this.forcar] == 4) {
                                                                s14 = "Class A ,  Game Car";
                                                            }
                                                            this.rd.drawString(s14, 561 - this.ftm.stringWidth(s14) / 2, 367);
                                                            this.rd.setColor(new Color(0, 0, 0));
                                                            this.rd.setFont(new Font("Arial", 0, 12));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            this.rd.drawString("You already have this car.", 561 - this.ftm.stringWidth("You already have this car.") / 2, 395);
                                                        }
                                                    }
                                                    if (this.xt.drawcarb(true, null, "X", 682, 99, n, n2, b)) {
                                                        this.dispcar = -1;
                                                    }
                                                    break Label_50933;
                                                }
                                            }
                                            this.dispcar = -1;
                                            break Label_50933;
                                        }
                                    }
                                    this.rd.drawImage(this.xt.sts, 537, 39, null);
                                    this.rd.setColor(this.color2k(200, 200, 200));
                                    this.rd.drawRect(415, 54, 293, 166);
                                    Label_44895: {
                                        if (this.conon != 1) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (this.conon == 2) {
                                                this.rd.drawString("Starting Game Now!", 561 - this.ftm.stringWidth("Starting Game Now!") / 2, 124);
                                            }
                                            if (this.conon == 3) {
                                                this.rd.drawString("Opening Game Now!", 561 - this.ftm.stringWidth("Opening Game Now!") / 2, 124);
                                            }
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString("Please Wait...", 561 - this.ftm.stringWidth("Please Wait...") / 2, 154);
                                        }
                                        else if (this.wait[n24] <= 0) {
                                            if (this.prevloaded != 1) {
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                if (this.prevloaded != -1) {
                                                    this.rd.drawString("About to Start...", 561 - this.ftm.stringWidth("About to Start...") / 2, 134);
                                                }
                                                else if (this.xt.lan) {
                                                    if (this.pgames[this.im] != this.ongame) {
                                                        this.rd.drawString("Game Started", 561 - this.ftm.stringWidth("Game Started") / 2, 117);
                                                        this.stringbutton("    Watch this Game    ", 561, 154, 0);
                                                    }
                                                    else {
                                                        this.rd.drawString("About to Start...", 561 - this.ftm.stringWidth("About to Start...") / 2, 134);
                                                    }
                                                }
                                                else {
                                                    this.rd.drawString("Loading Info...", 561 - this.ftm.stringWidth("Loading Info...") / 2, 134);
                                                }
                                            }
                                            else {
                                                int n68 = (int)(80.0 + this.rerr / 1.243);
                                                if (n68 > 255) {
                                                    n68 = 255;
                                                }
                                                if (n68 < 0) {
                                                    n68 = 0;
                                                }
                                                int n69 = (int)(128.0 + this.rerr / 2.428);
                                                if (n69 > 255) {
                                                    n69 = 255;
                                                }
                                                if (n69 < 0) {
                                                    n69 = 0;
                                                }
                                                int rerr = this.rerr;
                                                if (rerr > 255) {
                                                    rerr = 255;
                                                }
                                                if (rerr < 0) {
                                                    rerr = 0;
                                                }
                                                if (this.wait[n24] == 0) {
                                                    this.rd.setColor(new Color(n68, n69, rerr));
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.rd.drawString("Live Info!", 621, 51);
                                                    this.rd.drawString("Live Info!", 451, 51);
                                                }
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                                this.rd.drawString("Player       Position   Laps      Power        Damage", 439, 69);
                                                this.rd.setColor(this.color2k(200, 200, 200));
                                                this.rd.drawLine(489, 61, 489, 162);
                                                this.rd.drawLine(542, 61, 542, 162);
                                                this.rd.drawLine(579, 61, 579, 162);
                                                this.rd.drawLine(641, 61, 641, 162);
                                                this.rd.drawLine(422, 72, 702, 72);
                                                this.rd.drawLine(422, 163, 702, 163);
                                                int n70 = 0;
                                                for (int n71 = 0; n71 < this.prnpo; ++n71) {
                                                    for (int n72 = 0; n72 < this.prnpo; ++n72) {
                                                        if (this.ppos[n72] == n71) {
                                                            this.rd.setFont(new Font("Tahoma", 0, 11));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            this.rd.setColor(new Color(0, 44, 124));
                                                            this.rd.drawString(this.prnames[n72], 455 - this.ftm.stringWidth(this.prnames[n72]) / 2, 83 + 11 * n70);
                                                            Label_43065: {
                                                                if (this.pdam[n72] < 55) {
                                                                    if (this.pdam[n72] != -17) {
                                                                        this.rd.setColor(new Color(80, 128, 0));
                                                                        String s15 = "th";
                                                                        if (this.ppos[n72] == 0) {
                                                                            s15 = "st";
                                                                        }
                                                                        if (this.ppos[n72] == 1) {
                                                                            s15 = "nd";
                                                                        }
                                                                        if (this.ppos[n72] == 2) {
                                                                            s15 = "rd";
                                                                        }
                                                                        this.rd.drawString("" + (this.ppos[n72] + 1) + "" + s15, 515 - this.ftm.stringWidth("" + (this.ppos[n72] + 1) + "" + s15) / 2, 83 + 11 * n70);
                                                                        this.rd.setColor(new Color(128, 73, 0));
                                                                        if (this.plap[n72] > this.gnlaps[n24] - 1) {
                                                                            this.plap[n72] = this.gnlaps[n24] - 1;
                                                                        }
                                                                        this.rd.drawString("" + (this.plap[n72] + 1) + " / " + this.gnlaps[n24] + "", 560 - this.ftm.stringWidth("" + (this.plap[n72] + 1) + " / " + this.gnlaps[n24] + "") / 2, 83 + 11 * n70);
                                                                        this.rd.setColor(new Color(0, 128, 255));
                                                                        this.rd.drawRect(582, 76 + 11 * n70, 56, 6);
                                                                        this.rd.fillRect(583, 79 + 11 * n70, this.ppow[n72], 3);
                                                                        this.rd.setColor(new Color(128, 210, 255));
                                                                        this.rd.fillRect(583, 77 + 11 * n70, this.ppow[n72], 2);
                                                                        this.rd.setColor(new Color(255, 0, 0));
                                                                        this.rd.drawRect(645, 76 + 11 * n70, 56, 6);
                                                                        this.rd.fillRect(646, 79 + 11 * n70, this.pdam[n72], 3);
                                                                        this.rd.setColor(new Color(255, 155, 64));
                                                                        this.rd.fillRect(646, 77 + 11 * n70, this.pdam[n72], 2);
                                                                        break Label_43065;
                                                                    }
                                                                }
                                                                int n73 = (int)(85.0 + this.rerr * 2 / 1.5);
                                                                if (n73 > 255) {
                                                                    n73 = 255;
                                                                }
                                                                if (n73 < 0) {
                                                                    n73 = 0;
                                                                }
                                                                this.rd.setColor(this.color2k(n73, n73, n73));
                                                                this.rd.fillRect(490, 75 + 11 * n70, 213, 9);
                                                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                                                this.ftm = this.rd.getFontMetrics();
                                                                int n74 = 255 - this.rerr * 2;
                                                                if (n74 > 255) {
                                                                    n74 = 255;
                                                                }
                                                                if (n74 < 0) {
                                                                    n74 = 0;
                                                                }
                                                                int n75 = (int)(155.0 - this.rerr * 2 / 1.645);
                                                                if (n75 > 255) {
                                                                    n75 = 255;
                                                                }
                                                                if (n75 < 0) {
                                                                    n75 = 0;
                                                                }
                                                                int n76 = (int)(64.0 - this.rerr * 2 / 3.984);
                                                                if (n76 > 255) {
                                                                    n76 = 255;
                                                                }
                                                                if (n76 < 0) {
                                                                    n76 = 0;
                                                                }
                                                                this.rd.setColor(new Color(n74, n75, n76));
                                                                if (this.pdam[n72] == -17) {
                                                                    this.rd.drawString("=   =   =   DISCONNECTED   =   =   =", 597 - this.ftm.stringWidth("=   =   =   DISCONNECTED   =   =   =") / 2, 84 + 11 * n70);
                                                                }
                                                                else {
                                                                    this.rd.drawString("=   =   =   =    W A S T E D    =   =   =   =", 597 - this.ftm.stringWidth("=   =   =   =    W A S T E D    =   =   =   =") / 2, 84 + 11 * n70);
                                                                }
                                                            }
                                                            ++n70;
                                                        }
                                                    }
                                                }
                                                Label_44434: {
                                                    if (this.wait[n24] != 0) {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        int n77 = 186;
                                                        if (!this.lapsname.equals("")) {
                                                            if (!this.wastename.equals("")) {
                                                                if (!this.stuntname.equals("")) {
                                                                    n77 = 183;
                                                                }
                                                            }
                                                        }
                                                        if (this.gwarb[n24] == 0) {
                                                            String s16 = "";
                                                            while (true) {
                                                                for (int n78 = 0; n78 < this.prnpo; ++n78) {
                                                                    if (this.ppos[n78] == 0) {
                                                                        s16 = this.prnames[n78];
                                                                        if (!s16.equals("")) {
                                                                            this.rd.drawString("Game Finished!    Winner:  " + s16 + "", 561 - this.ftm.stringWidth("Game Finished!    Winner:  " + s16 + "") / 2, n77);
                                                                            if (this.nflk != 0) {
                                                                                --this.nflk;
                                                                            }
                                                                            else {
                                                                                this.rd.setColor(new Color(255, 176, 67));
                                                                                this.nflk = 3;
                                                                            }
                                                                            this.rd.drawString("" + s16 + "", 561 - this.ftm.stringWidth("Game Finished!    Winner:  " + s16 + "") / 2 + this.ftm.stringWidth("Game Finished!    Winner:  "), n77);
                                                                        }
                                                                        else {
                                                                            this.rd.drawString("Game Finished!    Nobody Won!", 561 - this.ftm.stringWidth("Game Finished!    Nobody Won!") / 2, n77);
                                                                        }
                                                                        this.rd.setColor(new Color(0, 0, 0));
                                                                        this.rd.setFont(new Font("Arial", 0, 11));
                                                                        this.ftm = this.rd.getFontMetrics();
                                                                        String s17 = "    ";
                                                                        int n79 = 0;
                                                                        if (!this.lapsname.equals("")) {
                                                                            s17 = s17 + "Fastest lap: " + this.lapsname + "    ";
                                                                            ++n79;
                                                                        }
                                                                        if (!this.wastename.equals("")) {
                                                                            s17 = s17 + "Deadliest waster: " + this.wastename + "    ";
                                                                            ++n79;
                                                                        }
                                                                        if (n79 != 2) {
                                                                            if (!this.stuntname.equals("")) {
                                                                                s17 = s17 + "Best stunt: " + this.stuntname + "    ";
                                                                            }
                                                                            this.rd.drawString(s17, 561 - this.ftm.stringWidth(s17) / 2, 206);
                                                                        }
                                                                        else if (this.stuntname.equals("")) {
                                                                            this.rd.drawString(s17, 561 - this.ftm.stringWidth(s17) / 2, 206);
                                                                        }
                                                                        else {
                                                                            this.rd.drawString(s17, 561 - this.ftm.stringWidth(s17) / 2, 199);
                                                                            this.rd.drawString("Best stunt: " + this.stuntname + "", 561 - this.ftm.stringWidth("Best stunt: " + this.stuntname + "") / 2, 213);
                                                                        }
                                                                        break Label_44434;
                                                                    }
                                                                }
                                                                continue;
                                                            }
                                                        }
                                                        if (!s5.equals("")) {
                                                            if (this.nflk != 0) {
                                                                --this.nflk;
                                                            }
                                                            else {
                                                                this.rd.setColor(new Color(255, 176, 67));
                                                                this.nflk = 3;
                                                            }
                                                            this.rd.drawString(s5, 561 - this.ftm.stringWidth(s5) / 2, 196);
                                                        }
                                                        else if (!s4.equals("")) {
                                                            this.rd.drawString("Game Finished!    " + s4 + "  Wins!", 561 - this.ftm.stringWidth("Game Finished!    " + s4 + "  Wins!") / 2, 196);
                                                            if (this.nflk != 0) {
                                                                --this.nflk;
                                                            }
                                                            else {
                                                                this.rd.setColor(new Color(255, 176, 67));
                                                                this.nflk = 3;
                                                            }
                                                            this.rd.drawString("" + s4 + "", 561 - this.ftm.stringWidth("Game Finished!    " + s4 + "  Wins!") / 2 + this.ftm.stringWidth("Game Finished!    "), 196);
                                                        }
                                                        else {
                                                            this.rd.drawString("Game Finished!    Nobody Won!", 561 - this.ftm.stringWidth("Game Finished!    Nobody Won!") / 2, 186);
                                                            this.rd.setFont(new Font("Arial", 1, 11));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            this.rd.drawString(s6, 561 - this.ftm.stringWidth(s6) / 2, 206);
                                                        }
                                                    }
                                                    else {
                                                        this.stringbutton("    Watch Live Now!    ", 561, 196, 0);
                                                    }
                                                }
                                                this.rerr += 3;
                                            }
                                        }
                                        else {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (this.gwarb[n24] != 0) {
                                                String s18 = "s";
                                                if (this.mnpls[n24] - this.npls[n24] == 1) {
                                                    s18 = "";
                                                }
                                                this.rd.drawString("Waiting for " + (this.mnpls[n24] - this.npls[n24]) + " clan member" + s18 + " to join to start.", 561 - this.ftm.stringWidth("Waiting for " + (this.mnpls[n24] - this.npls[n24]) + " clan member" + s18 + " to join to start.") / 2, 72);
                                                int n80 = this.mnpls[n24] / 2;
                                                int n81 = this.mnpls[n24] / 2;
                                                for (int n82 = 0; n82 < this.npo; ++n82) {
                                                    if (this.pgames[n82] == this.gnum[n24]) {
                                                        if (this.pclan[n82].toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                            if (--n80 < 0) {
                                                                n80 = 0;
                                                            }
                                                        }
                                                        if (this.pclan[n82].toLowerCase().equals(this.gvclan[n24].toLowerCase())) {
                                                            if (--n81 < 0) {
                                                                n81 = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                this.rd.setFont(new Font("Arial", 0, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString("( " + n80 + " of " + this.gaclan[n24] + "  &  " + n81 + " of " + this.gvclan[n24] + " )", 561 - this.ftm.stringWidth("( " + n80 + " of " + this.gaclan[n24] + "  &  " + n81 + " of " + this.gvclan[n24] + " )") / 2, 87);
                                                this.rd.drawString(this.gaclan[n24], 491 - this.ftm.stringWidth(this.gaclan[n24]) / 2, 125);
                                                this.rd.drawString(this.gvclan[n24], 631 - this.ftm.stringWidth(this.gvclan[n24]) / 2, 125);
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                String s19 = "War";
                                                if (this.gwarb[n24] > 1) {
                                                    s19 = "Battle";
                                                }
                                                this.rd.drawString("" + s19 + " Score", 561 - this.ftm.stringWidth("" + s19 + " Score") / 2, 107);
                                                this.rd.drawString("" + this.gascore[n24] + "", 491 - this.ftm.stringWidth("" + this.gascore[n24] + "") / 2, 139);
                                                this.rd.drawString("" + this.gvscore[n24] + "", 631 - this.ftm.stringWidth("" + this.gascore[n24] + "") / 2, 139);
                                                this.rd.drawRect(421, 111, 280, 33);
                                                this.rd.drawLine(561, 111, 561, 144);
                                                this.rd.setColor(new Color(255, 128, 0));
                                                this.rd.drawRect(422, 112, 138, 31);
                                                this.rd.setColor(new Color(0, 128, 255));
                                                this.rd.drawRect(562, 112, 138, 31);
                                                Label_40354: {
                                                    if (this.pgames[this.im] == this.ongame) {
                                                        if (this.gmaker[n24].equals(this.pnames[this.im])) {
                                                            if (this.npls[n24] > 1) {
                                                                this.stringbutton("    Start this Game Now!    ", 561, -1000, 0);
                                                            }
                                                        }
                                                        this.rd.setColor(new Color(80, 128, 0));
                                                        this.rd.drawString("You have joined this game.", 561 - this.ftm.stringWidth("You have joined this game.") / 2, 198);
                                                    }
                                                    else {
                                                        if (!this.xt.clan.toLowerCase().equals(this.gaclan[n24].toLowerCase())) {
                                                            if (!this.xt.clan.toLowerCase().equals(this.gvclan[n24].toLowerCase())) {
                                                                this.rd.setColor(new Color(128, 73, 0));
                                                                this.rd.drawString("You must be a member of either clan to join.", 561 - this.ftm.stringWidth("You must be a member of either clan to join.") / 2, 198);
                                                                break Label_40354;
                                                            }
                                                        }
                                                        this.stringbutton("    Join this Game    ", 561, 200, 0);
                                                    }
                                                }
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                if (this.gwtyp[n24] == 1) {
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.drawString("This is a normal clan game.", 561 - this.ftm.stringWidth("This is a normal clan game.") / 2, 161);
                                                    this.rd.setFont(new Font("Arial", 0, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.drawString("Any clan can win by racing or wasting.", 561 - this.ftm.stringWidth("Any clan can win by racing or wasting.") / 2, 176);
                                                }
                                                if (this.gwtyp[n24] == 2) {
                                                    if (this.sflk == 0) {
                                                        this.sflk = 3;
                                                        this.rd.setColor(new Color(117, 67, 0));
                                                    }
                                                    else {
                                                        --this.sflk;
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                    }
                                                    this.rd.drawString("This is a racing only game!", 561 - this.ftm.stringWidth("This is a racing only game!") / 2, 161);
                                                    this.rd.setFont(new Font("Arial", 0, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.drawString("A clan can only win by racing.", 561 - this.ftm.stringWidth("A clan can only win by racing.") / 2, 176);
                                                }
                                                if (this.gwtyp[n24] == 3) {
                                                    if (this.sflk == 0) {
                                                        this.sflk = 3;
                                                        this.rd.setColor(new Color(117, 67, 0));
                                                    }
                                                    else {
                                                        --this.sflk;
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                    }
                                                    this.rd.drawString("This is a wasting only game!", 561 - this.ftm.stringWidth("This is a wasting only game!") / 2, 161);
                                                    this.rd.setFont(new Font("Arial", 0, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.drawString("A clan can only win by wasting.", 561 - this.ftm.stringWidth("A clan can only win by wasting.") / 2, 176);
                                                }
                                                if (this.gwtyp[n24] == 4) {
                                                    if (this.sflk == 0) {
                                                        this.sflk = 3;
                                                        this.rd.setColor(new Color(117, 67, 0));
                                                    }
                                                    else {
                                                        --this.sflk;
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                    }
                                                    this.rd.drawString("This is Racers VS Wasters game!", 561 - this.ftm.stringWidth("This is Racers VS Wasters game!") / 2, 161);
                                                    this.rd.drawString("" + this.gaclan[n24] + " wastes & " + this.gvclan[n24] + " races.", 561 - this.ftm.stringWidth("" + this.gaclan[n24] + " wastes & " + this.gvclan[n24] + " races.") / 2, 176);
                                                }
                                                if (this.gwtyp[n24] == 5) {
                                                    if (this.sflk == 0) {
                                                        this.sflk = 3;
                                                        this.rd.setColor(new Color(117, 67, 0));
                                                    }
                                                    else {
                                                        --this.sflk;
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                    }
                                                    this.rd.drawString("This is Racers VS Wasters game!", 561 - this.ftm.stringWidth("This is Racers VS Wasters game!") / 2, 161);
                                                    this.rd.drawString("" + this.gaclan[n24] + " races & " + this.gvclan[n24] + " wastes.", 561 - this.ftm.stringWidth("" + this.gaclan[n24] + " races & " + this.gvclan[n24] + " wastes.") / 2, 176);
                                                }
                                            }
                                            else {
                                                Label_38624: {
                                                    if (this.wait[n24] <= 30) {
                                                        if (this.npls[n24] > 1) {
                                                            final long time = new Date().getTime();
                                                            Label_38438: {
                                                                if (this.ptime != 0L) {
                                                                    if (time <= this.ptime + 1500L) {
                                                                        break Label_38438;
                                                                    }
                                                                }
                                                                if (this.ptime != 0L) {
                                                                    final int[] wait = this.wait;
                                                                    final int n83 = n24;
                                                                    --wait[n83];
                                                                    if (this.wait[n24] < 1) {
                                                                        this.wait[n24] = 1;
                                                                    }
                                                                }
                                                                this.ptime = time;
                                                            }
                                                            if (this.pgames[this.im] != this.ongame) {
                                                                if (this.nflk == 0) {
                                                                    if (this.pgames[this.im] == this.ongame) {
                                                                        break Label_38624;
                                                                    }
                                                                    this.nflk = 3;
                                                                    break Label_38624;
                                                                }
                                                            }
                                                            this.rd.drawString("Game starts in " + this.wait[n24] + " seconds!", 561 - this.ftm.stringWidth("Game starts in " + this.wait[n24] + " seconds!") / 2, 124);
                                                            if (this.pgames[this.im] == this.ongame) {
                                                                break Label_38624;
                                                            }
                                                            --this.nflk;
                                                            break Label_38624;
                                                        }
                                                    }
                                                    String s20 = "s";
                                                    if (this.mnpls[n24] - this.npls[n24] == 1) {
                                                        s20 = "";
                                                    }
                                                    this.rd.drawString("Waiting for " + (this.mnpls[n24] - this.npls[n24]) + " more player" + s20 + " to join to start.", 561 - this.ftm.stringWidth("Waiting for " + (this.mnpls[n24] - this.npls[n24]) + " more player" + s20 + " to join to start.") / 2, 98);
                                                    this.rd.setFont(new Font("Arial", 0, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    int n84 = 134;
                                                    if (!this.gmaker[n24].equals("Coach Insano")) {
                                                        if (!this.gmaker[n24].equals(this.pnames[this.im])) {
                                                            boolean b13 = false;
                                                            for (int n85 = 0; n85 < this.npo; ++n85) {
                                                                if (this.pgames[n85] == this.ongame) {
                                                                    if (this.gmaker[n24].equals(this.pnames[n85])) {
                                                                        b13 = true;
                                                                    }
                                                                }
                                                            }
                                                            if (b13) {
                                                                n84 = 144;
                                                                this.rd.drawString("" + this.gmaker[n24] + " can start this game at anytime.", 561 - this.ftm.stringWidth("" + this.gmaker[n24] + " can start this game at anytime.") / 2, 124);
                                                            }
                                                        }
                                                    }
                                                    if (this.npls[n24] > 1) {
                                                        String s21 = "" + this.wait[n24] + " seconds";
                                                        if (this.wait[n24] > 60) {
                                                            s21 = "" + (int)(this.wait[n24] / 60.0f * 100.0f) / 100.0f + " minutes";
                                                        }
                                                        this.rd.drawString("( Waiting " + s21 + " maximum! )", 561 - this.ftm.stringWidth("( Waiting " + s21 + " maximum! )") / 2, n84);
                                                    }
                                                }
                                                if (this.pgames[this.im] == this.ongame) {
                                                    if (!this.gmaker[n24].equals(this.pnames[this.im])) {
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.setColor(new Color(80, 128, 0));
                                                        this.rd.drawString("You have joined this game.", 561 - this.ftm.stringWidth("You have joined this game.") / 2, 180);
                                                    }
                                                    else if (this.npls[n24] <= 1) {
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.setColor(new Color(128, 73, 0));
                                                        this.rd.drawString("You have created this game.", 561 - this.ftm.stringWidth("You have created this game.") / 2, 180);
                                                    }
                                                    else if (this.fstart) {
                                                        this.stringbutton("    Starting game now, one moment...    ", 561, 182, 0);
                                                    }
                                                    else {
                                                        this.stringbutton("    Start this Game Now!    ", 561, 182, 0);
                                                    }
                                                }
                                                else {
                                                    if (!this.gplyrs[n24].equals("")) {
                                                        if (this.gplyrs[n24].indexOf(this.pnames[this.im]) == -1) {
                                                            this.rd.setFont(new Font("Arial", 1, 12));
                                                            this.ftm = this.rd.getFontMetrics();
                                                            this.rd.setColor(new Color(128, 73, 0));
                                                            this.rd.drawString("Private Game, only specific players allowed.", 561 - this.ftm.stringWidth("Private Game, only specific players allowed.") / 2, 180);
                                                            this.stringbutton("    Join this Game    ", 561, -1000, 0);
                                                            break Label_44895;
                                                        }
                                                    }
                                                    this.stringbutton("    Join this Game    ", 561, 182, 0);
                                                }
                                            }
                                        }
                                    }
                                    this.rd.setColor(this.color2k(200, 200, 200));
                                    this.rd.drawRect(415, 222, 293, 40);
                                    this.rd.drawImage(this.xt.stg, 422, 227, null);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 10));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("Laps: " + this.gnlaps[n24] + "", 660, 235);
                                    Label_45466: {
                                        Label_45162: {
                                            if (n > 415) {
                                                if (n < 708) {
                                                    if (n2 > 222) {
                                                        if (n2 < 262) {
                                                            if (this.wait[n24] <= 0) {
                                                                if (this.gstgn[n24] >= 0) {
                                                                    break Label_45162;
                                                                }
                                                            }
                                                            if (this.conon == 1) {
                                                                this.stringbutton("       Preview Stage       ", 562, 247, 0);
                                                                this.pbtn = 2;
                                                                break Label_45466;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (this.gstgn[n24] <= 0) {
                                            this.rd.drawString("Custom Stage", 562 - this.ftm.stringWidth("Custom Stage") / 2, 237);
                                        }
                                        else {
                                            String s22 = "NFM 1";
                                            int n86 = this.gstgn[n24];
                                            if (this.gstgn[n24] > 10) {
                                                s22 = "NFM 2";
                                                n86 = this.gstgn[n24] - 10;
                                            }
                                            if (this.gstgn[n24] > 27) {
                                                s22 = "Multiplayer";
                                                n86 = this.gstgn[n24] - 27;
                                            }
                                            this.rd.drawString("" + s22 + " - Stage " + n86 + "", 562 - this.ftm.stringWidth("" + s22 + " - Stage " + n86 + "") / 2, 237);
                                        }
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.gstages[n24], 562 - this.ftm.stringWidth(this.gstages[n24]) / 2, 254);
                                    }
                                    if (this.xt.lan) {
                                        break Label_50933;
                                    }
                                    int n87 = 237;
                                    int n88 = 471;
                                    if (this.wait[n24] <= 0) {
                                        if (this.npls[n24] > 5) {
                                            n87 = 415;
                                            n88 = 293;
                                        }
                                    }
                                    else if (this.mnpls[n24] > 5) {
                                        n87 = 415;
                                        n88 = 293;
                                    }
                                    this.rd.setColor(this.color2k(200, 200, 200));
                                    this.rd.drawRect(n87, 264, n88, 124);
                                    this.rd.setColor(this.color2k(240, 240, 240));
                                    this.rd.fillRect(n87 + 1, 265, n88 - 1, 21);
                                    this.rd.drawImage(this.xt.gmc, n87 + 7, 269, null);
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.rd.setColor(this.color2k(110, 110, 110));
                                    this.rd.drawString("( Game Chat )", n87 + 57, 278);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.updatec == -1) {
                                        this.rd.drawString("Loading chat...", n87 + n88 / 2 - this.ftm.stringWidth("Loading chat...") / 2, 315);
                                    }
                                    else {
                                        final String[] array3 = new String[7];
                                        final String[] array4 = new String[7];
                                        final boolean[] array5 = { false, false, false, false, false, false, false };
                                        for (int n89 = 0; n89 < 7; ++n89) {
                                            array3[n89] = "";
                                            array4[n89] = this.cnames[n89];
                                            int n90 = 0;
                                            int n91 = 0;
                                            int n92 = 0;
                                            int n93 = 0;
                                            int n94 = 0;
                                            while (n90 < this.sentn[n89].length()) {
                                                final String string = "" + this.sentn[n89].charAt(n90);
                                                if (!string.equals(" ")) {
                                                    n94 = 0;
                                                }
                                                else {
                                                    n91 = n92;
                                                    n93 = n90;
                                                    ++n94;
                                                }
                                                if (n94 <= 1) {
                                                    final StringBuilder sb = new StringBuilder();
                                                    final String[] array6 = array3;
                                                    final int n95 = n89;
                                                    array6[n95] = sb.append(array6[n95]).append(string).toString();
                                                    ++n92;
                                                    if (this.ftm.stringWidth(array3[n89]) > n88 - 94) {
                                                        if (n91 == 0) {
                                                            array3[n89] = "";
                                                            n92 = 0;
                                                        }
                                                        else {
                                                            array3[n89] = array3[n89].substring(0, n91);
                                                            for (int n96 = 0; n96 < n89; ++n96) {
                                                                array3[n96] = array3[n96 + 1];
                                                                array4[n96] = array4[n96 + 1];
                                                                array5[n96] = array5[n96 + 1];
                                                            }
                                                            array3[n89] = "";
                                                            array5[n89] = true;
                                                            n90 = n93;
                                                            n92 = 0;
                                                            n91 = 0;
                                                        }
                                                    }
                                                }
                                                ++n90;
                                            }
                                        }
                                        String s23 = "";
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        for (int n97 = 0; n97 < 7; ++n97) {
                                            if (!s23.equals(array4[n97])) {
                                                this.rd.drawString(array4[n97] + ":", n87 + 84 - this.ftm.stringWidth(array4[n97] + ":"), 299 + n97 * 14);
                                                s23 = array4[n97];
                                            }
                                        }
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        for (int n98 = 0; n98 < 7; ++n98) {
                                            if (array5[n98]) {
                                                if (n98 == 0) {
                                                    if (array3[n98].indexOf(" ") != -1) {
                                                        array3[n98] = "..." + array3[n98].substring(array3[n98].indexOf(" "), array3[n98].length()) + "";
                                                    }
                                                }
                                            }
                                            this.rd.drawString(array3[n98], n87 + 88, 299 + n98 * 14);
                                        }
                                    }
                                    if (this.conon != 1) {
                                        this.hideinputs();
                                    }
                                    else {
                                        this.pre2 = true;
                                    }
                                    if (control.enter) {
                                        if (!this.gs.cmsg.getText().equals("Type here...")) {
                                            if (!this.gs.cmsg.getText().equals("")) {
                                                this.pessd[this.btn] = true;
                                                control.enter = false;
                                                String replace = this.gs.cmsg.getText().replace('|', ':');
                                                if (replace.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                                                    replace = " ";
                                                }
                                                Label_46846: {
                                                    if (!this.xt.msgcheck(replace)) {
                                                        if (this.updatec > -12) {
                                                            for (int n99 = 0; n99 < 6; ++n99) {
                                                                this.sentn[n99] = this.sentn[n99 + 1];
                                                                this.cnames[n99] = this.cnames[n99 + 1];
                                                            }
                                                            this.sentn[6] = replace;
                                                            this.cnames[6] = this.pnames[this.im];
                                                            if (this.updatec <= -11) {
                                                                --this.updatec;
                                                                break Label_46846;
                                                            }
                                                            this.updatec = -11;
                                                            break Label_46846;
                                                        }
                                                    }
                                                    final xtGraphics xt2 = this.xt;
                                                    ++xt2.warning;
                                                }
                                                this.gs.cmsg.setText("");
                                            }
                                        }
                                    }
                                    this.stringbutton("Send Message", 655, 405, 3);
                                    break Label_50933;
                                }
                            }
                            if (this.join > -1) {
                                if (this.pgames[this.im] != this.join) {
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 195);
                                    if (this.msg.equals(". . . | Joining Game | . . .")) {
                                        if (this.ncnt == 0) {
                                            this.msg = "| Joining Game |";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.msg.equals(". . | Joining Game | . .")) {
                                        if (this.ncnt == 0) {
                                            this.msg = ". . . | Joining Game | . . .";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.msg.equals(". | Joining Game | .")) {
                                        if (this.ncnt == 0) {
                                            this.msg = ". . | Joining Game | . .";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.msg.equals("| Joining Game |")) {
                                        if (this.ncnt == 0) {
                                            this.msg = ". | Joining Game | .";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.ncnt != 0) {
                                        --this.ncnt;
                                    }
                                }
                            }
                            if (this.join == -2) {
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 195);
                                if (this.msg.equals(". . . | Leaving Game | . . .")) {
                                    if (this.ncnt == 0) {
                                        this.msg = "| Leaving Game |";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.msg.equals(". . | Leaving Game | . .")) {
                                    if (this.ncnt == 0) {
                                        this.msg = ". . . | Leaving Game | . . .";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.msg.equals(". | Leaving Game | .")) {
                                    if (this.ncnt == 0) {
                                        this.msg = ". . | Leaving Game | . .";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.msg.equals("| Leaving Game |")) {
                                    if (this.ncnt == 0) {
                                        this.msg = ". | Leaving Game | .";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.ncnt != 0) {
                                    --this.ncnt;
                                }
                            }
                            if (this.gs.cmsg.isShowing()) {
                                this.gs.cmsg.hide();
                                this.gs.requestFocus();
                            }
                        }
                        else {
                            int n100 = 229 + this.opengame;
                            if (n100 > 255) {
                                n100 = 255;
                            }
                            if (n100 < 0) {
                                n100 = 0;
                            }
                            this.rd.setColor(this.color2k(n100, n100, n100));
                            this.rd.fillRoundRect(225, 59 - (int)(this.opengame * 2.23f), 495, 200 + this.opengame * 8, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 59 - (int)(this.opengame * 2.23f), 495, 200 + this.opengame * 8, 20, 20);
                            if (!this.xt.lan) {
                                this.rd.setColor(this.color2k(217, 217, 217));
                                this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                            }
                            this.btn = 0;
                            if (this.prevloaded != -1) {
                                this.prevloaded = -1;
                            }
                            if (this.updatec != -1) {
                                this.updatec = -1;
                            }
                            if (this.gs.cmsg.isShowing()) {
                                this.gs.cmsg.hide();
                                this.gs.requestFocus();
                            }
                            if (this.gs.rooms.isShowing()) {
                                this.gs.rooms.hide();
                            }
                            if (this.fstart) {
                                this.fstart = false;
                            }
                            for (int n101 = 0; n101 < 9; ++n101) {
                                if (this.cac[n101] != -1) {
                                    this.cac[n101] = -1;
                                }
                            }
                            if (this.dispcar != -1) {
                                this.dispcar = -1;
                            }
                            this.opengame += 2;
                        }
                    }
                    else if (this.opengame < 2) {
                        if (this.xt.lan) {
                            this.rd.drawImage(this.xt.lanm, 241, 31, null);
                            if (this.npo > 1) {
                                if (this.lanlogged) {
                                    this.rd.setColor(this.color2k(90, 90, 90));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("[  " + n9 + " Players Connected  ]", 472 - this.ftm.stringWidth("[  " + n9 + " Players Connected  ]") / 2, 295);
                                    this.drawSbutton(this.xt.cgame, 472, 325);
                                }
                                else {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("You have played the allowed 3 LAN games per day!", 472 - this.ftm.stringWidth("You have played the allowed 3 LAN games per day!") / 2, 295);
                                    this.rd.setColor(this.color2k(70, 70, 70));
                                    this.rd.drawString("There needs to be at least one of the LAN players in the lobby with a registered", 225, 325);
                                    this.rd.drawString("account to be able to play LAN unlimitedly...", 225, 345);
                                    this.rd.drawString("Just one registered user allows everyone in the LAN game to play unlimitedly!", 225, 365);
                                    this.rd.drawString("Please register now!", 225, 385);
                                    this.drawSbutton(this.xt.register, 472, 395);
                                }
                            }
                            else {
                                this.drawSbutton(this.xt.cgame, 292, -1000);
                                this.rd.setColor(new Color(0, 0, 0));
                                if (this.ncnt == 0) {
                                    this.rd.setColor(new Color(188, 111, 0));
                                }
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(this.lmsg, 472 - this.ftm.stringWidth(this.lmsg) / 2, 295);
                                if (this.lmsg.equals(". . . | Searching/Waiting for other LAN Players | . . .")) {
                                    if (this.ncnt == 0) {
                                        this.lmsg = "| Searching/Waiting for other LAN Players |";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.lmsg.equals(". . | Searching/Waiting for other LAN Players | . .")) {
                                    if (this.ncnt == 0) {
                                        this.lmsg = ". . . | Searching/Waiting for other LAN Players | . . .";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.lmsg.equals(". | Searching/Waiting for other LAN Players | .")) {
                                    if (this.ncnt == 0) {
                                        this.lmsg = ". . | Searching/Waiting for other LAN Players | . .";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.lmsg.equals("| Searching/Waiting for other LAN Players |")) {
                                    if (this.ncnt == 0) {
                                        this.lmsg = ". | Searching/Waiting for other LAN Players | .";
                                        this.ncnt = 5;
                                    }
                                }
                                if (this.ncnt != 0) {
                                    --this.ncnt;
                                }
                                this.rd.setColor(this.color2k(70, 70, 70));
                                this.rd.drawString("So far, you are the only player connected to this network!", 225, 325);
                                this.rd.drawString("There needs to be at least one more player logged in here with your same", 225, 345);
                                this.rd.drawString("internet connection...", 225, 365);
                            }
                            this.drawSbutton(this.xt.ccar, 442, -1000);
                        }
                        else {
                            this.drawSbutton(this.xt.cgame, 292, 42);
                            this.drawSbutton(this.xt.ccar, 442, 42);
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(this.color2k(60, 60, 60));
                            if (!this.gs.rooms.isShowing()) {
                                this.gs.rooms.show();
                            }
                            this.gs.rooms.move(580 - this.gs.rooms.w / 2, 29);
                            if (this.gs.rooms.sel != 0) {
                                this.stopallnow();
                                int n102 = this.gs.rooms.iroom[this.gs.rooms.sel];
                                if (n102 >= 1000) {
                                    n102 -= 1000;
                                    if (n102 >= 0) {
                                        if (n102 < this.lg.nservers) {
                                            this.xt.servport = 7071;
                                            this.xt.server = this.lg.servers[n102];
                                            this.xt.servername = this.lg.snames[n102];
                                        }
                                    }
                                }
                                else if (n102 >= 1) {
                                    if (n102 <= 5) {
                                        this.xt.servport = 7070 + n102;
                                    }
                                }
                                this.inishlobby();
                                this.gs.rooms.kmoused = 20;
                            }
                            if (this.gs.rooms.kmoused != 0) {
                                n = -1;
                                n2 = -1;
                                b = false;
                                final Smenu rooms = this.gs.rooms;
                                --rooms.kmoused;
                            }
                        }
                        this.drawSbutton(this.xt.exit, 690, 42);
                        if (control.enter) {
                            if (!this.gs.cmsg.getText().equals("Type here...")) {
                                if (!this.gs.cmsg.getText().equals("")) {
                                    if (this.chalngd != -1) {
                                        this.pessd[5] = true;
                                    }
                                    else {
                                        this.pessd[2] = true;
                                    }
                                    control.enter = false;
                                    String replace2 = this.gs.cmsg.getText().replace('|', ':');
                                    if (replace2.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                                        replace2 = " ";
                                    }
                                    Label_7941: {
                                        if (!this.xt.msgcheck(replace2)) {
                                            if (this.updatec > -12) {
                                                for (int n103 = 0; n103 < 6; ++n103) {
                                                    this.sentn[n103] = this.sentn[n103 + 1];
                                                    this.cnames[n103] = this.cnames[n103 + 1];
                                                }
                                                this.sentn[6] = replace2;
                                                this.cnames[6] = this.pnames[this.im];
                                                if (this.updatec <= -11) {
                                                    --this.updatec;
                                                }
                                                else {
                                                    this.updatec = -11;
                                                }
                                                this.spos3 = 28;
                                                break Label_7941;
                                            }
                                        }
                                        final xtGraphics xt3 = this.xt;
                                        ++xt3.warning;
                                    }
                                    this.gs.cmsg.setText("");
                                }
                            }
                        }
                        if (this.chalngd != -1) {
                            int n104 = 230 + this.britchl;
                            if (n104 > 255) {
                                n104 = 255;
                            }
                            if (n104 < 0) {
                                n104 = 0;
                            }
                            this.rd.setColor(this.color2k(n104, n104, n104));
                            this.rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                            if (this.britchl < 25) {
                                this.britchl += 5;
                            }
                            if (this.chalngd <= -1) {
                                if (this.chalngd != -5) {
                                    this.stringbutton(" Cancel X ", 669, 85, 2);
                                }
                                if (this.chalngd == -6) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.rd.drawString("This room already has a game that has started.", 288, 120);
                                    this.rd.drawString("Please switch to another room to create a new game.", 288, 140);
                                    this.rd.drawString("Or wait for the game to finish.", 288, 160);
                                    this.rd.drawString("Use the dropdown menu above to change room or server.", 288, 180);
                                    this.rd.fillPolygon(new int[] { 580, 569, 576, 576, 584, 584, 591 }, new int[] { 66, 77, 77, 102, 102, 77, 77 }, 7);
                                    this.stringbutton("     OK     ", 472, 215, 1);
                                }
                                if (this.chalngd == -2) {
                                    boolean b14 = false;
                                    boolean b15 = false;
                                    if (!this.gs.wgame.isShowing()) {
                                        this.gs.wgame.show();
                                    }
                                    this.gs.wgame.move(236, 68);
                                    if (this.gs.wgame.getSelectedIndex() != 0) {
                                        if (!this.inwab) {
                                            this.gs.sgame.hide();
                                            this.gs.mstgs.hide();
                                            this.gs.slaps.hide();
                                            this.gs.snfm1.hide();
                                            this.gs.snfmm.hide();
                                            this.gs.snfm2.hide();
                                        }
                                        if (this.xt.clan.equals("")) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString("You must join a clan first to play wars and battles!", 472 - this.ftm.stringWidth("You must join a clan first to play wars and battles!") / 2, 145);
                                            this.stringbutton("    Find a clan to join    ", 472, 185, 2);
                                        }
                                        else if (this.inwab) {
                                            if (!this.gs.warb.isShowing()) {
                                                this.gs.warb.show();
                                            }
                                            this.gs.warb.move(472 - this.gs.warb.w / 2, 105);
                                            if (this.gs.warb.sel != 0) {
                                                if (this.gs.warb.sel == this.warbsel) {
                                                    if (this.gb.loadwbgames == 7) {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.drawString("Redoing last game, please wait...", 472 - this.ftm.stringWidth("Redoing last game, please wait...") / 2, 155);
                                                    }
                                                    if (this.gb.loadwbgames == 2) {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        if (this.gs.wgame.getSelectedIndex() == 1) {
                                                            this.rd.drawString("[ " + this.gb.gameturndisp + " ]", 472 - this.ftm.stringWidth("[ " + this.gb.gameturndisp + " ]") / 2, 155);
                                                            b15 = true;
                                                            final int n105 = 472 - (this.gs.vnpls.w + this.gs.vtyp.w + 10) / 2;
                                                            this.gs.vnpls.move(n105, 168);
                                                            this.gs.vtyp.move(n105 + (this.gs.vnpls.w + 10), 168);
                                                            if (this.gb.lwbwinner.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                                                if (this.sflk == 0) {
                                                                    this.sflk = 4;
                                                                    this.rd.setColor(new Color(117, 67, 0));
                                                                }
                                                                else {
                                                                    --this.sflk;
                                                                }
                                                                this.rd.drawString("Your clan won the last game.  " + this.gb.vclan + " must create this game!", 472 - this.ftm.stringWidth("Your clan won the last game.  " + this.gb.vclan + " must create this game!") / 2, 211);
                                                            }
                                                            else if (this.gs.vnpls.sel != 0) {
                                                                if (this.pgamesel != -this.gs.vnpls.sel) {
                                                                    this.gstagename = this.gb.wbstages[this.gb.gameturn];
                                                                    this.cancreate = 0;
                                                                    this.pgamesel = -this.gs.vnpls.sel;
                                                                }
                                                                if (this.cancreate == 1) {
                                                                    this.cancreate = 2;
                                                                }
                                                                if (this.cancreate == 0) {
                                                                    if (this.gb.wbstage[this.gb.gameturn] != 101) {
                                                                        this.loadstage = this.gb.wbstage[this.gb.gameturn];
                                                                        this.cancreate = 1;
                                                                    }
                                                                    else {
                                                                        this.cancreate = 2;
                                                                    }
                                                                }
                                                                if (this.cancreate == 1) {
                                                                    this.rd.drawString("Loading...", 472 - this.ftm.stringWidth("Loading...") / 2, 235);
                                                                }
                                                                if (this.cancreate == 2) {
                                                                    this.stringbutton("   Create Game   ", 472, 235, 1);
                                                                }
                                                            }
                                                            if (this.gb.canredo) {
                                                                this.stringbutton(" Redo last game  < ", 644, 242, 1);
                                                            }
                                                        }
                                                        if (this.gs.wgame.getSelectedIndex() == 2) {
                                                            b14 = true;
                                                            this.gs.pgame.move(472 - this.gs.pgame.w / 2, 150);
                                                            if (this.gs.pgame.sel != 0) {
                                                                if (this.pgamesel != this.gs.pgame.sel) {
                                                                    this.gstagename = this.gb.wbstages[this.gs.pgame.sel - 1];
                                                                    this.cancreate = 0;
                                                                    this.pgamesel = this.gs.pgame.sel;
                                                                }
                                                                if (this.cancreate == 1) {
                                                                    this.cancreate = 2;
                                                                }
                                                                if (this.cancreate == 0) {
                                                                    if (this.gb.wbstage[this.gs.pgame.sel - 1] != 101) {
                                                                        this.loadstage = this.gb.wbstage[this.gs.pgame.sel - 1];
                                                                        this.cancreate = 1;
                                                                    }
                                                                    else {
                                                                        this.cancreate = 2;
                                                                    }
                                                                }
                                                                if (this.cancreate == 1) {
                                                                    this.rd.drawString("Loading...", 472 - this.ftm.stringWidth("Loading...") / 2, 235);
                                                                }
                                                                if (this.cancreate == 2) {
                                                                    this.stringbutton("   Create Practice Game   ", 472, 235, 1);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (this.gb.loadwbgames == 3) {
                                                        this.rd.drawString("Failed to load scheduled games, please try again later...", 472 - this.ftm.stringWidth("Failed to load scheduled games, please try again later...") / 2, 165);
                                                    }
                                                    if (this.gb.loadwbgames == 4) {
                                                        this.rd.drawString("This war or battle was not found, it may have been expired.", 472 - this.ftm.stringWidth("This war or battle was not found, it may have been expired.") / 2, 165);
                                                    }
                                                    if (this.gb.loadwbgames == 6) {
                                                        this.rd.drawString("Failed to undo the last game, please try again later...", 472 - this.ftm.stringWidth("Failed to undo the last game, please try again later...") / 2, 165);
                                                    }
                                                }
                                                else {
                                                    this.gb.loadwbgames = 1;
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString("Loading scheduled games, please wait...", 472 - this.ftm.stringWidth("Loading scheduled games, please wait...") / 2, 165);
                                                    this.warbsel = this.gs.warb.sel;
                                                    this.gs.vnpls.sel = 0;
                                                    this.gs.vtyp.sel = 0;
                                                    this.pgamesel = 0;
                                                    this.cancreate = 0;
                                                }
                                            }
                                        }
                                        else {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString("Loading your clan's wars and battles, please wait...", 472 - this.ftm.stringWidth("Loading your clan's wars and battles, please wait...") / 2, 155);
                                            this.loadwarb = true;
                                            this.warbsel = 0;
                                            this.cancreate = 0;
                                        }
                                        if (!this.inwab) {
                                            this.inwab = true;
                                        }
                                    }
                                    else {
                                        if (this.inwab) {
                                            this.inwab = false;
                                            this.gs.warb.hide();
                                            this.loadstage = 0;
                                        }
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        Label_15551: {
                                            if (this.sflk % 4 == 0) {
                                                if (this.sflk != 0) {
                                                    break Label_15551;
                                                }
                                            }
                                            this.rd.drawString("Select Stage", 472 - this.ftm.stringWidth("Select Stage") / 2, 85);
                                        }
                                        if (this.sflk != 0) {
                                            --this.sflk;
                                        }
                                        int n106 = 0;
                                        this.gs.sgame.setSize(139, 22);
                                        if (this.gs.sgame.getSelectedIndex() == 0) {
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.snfmm.getWidth()) / 2;
                                            this.sgflag = 0;
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 1) {
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.snfm1.getWidth()) / 2;
                                            this.sgflag = 1;
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 2) {
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.snfm2.getWidth()) / 2;
                                            this.sgflag = 2;
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 3) {
                                            this.gs.mstgs.setSize(338, 22);
                                            if (this.sgflag != 3) {
                                                this.gstage = 0;
                                                if (!this.xt.logged) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                                    this.gs.mstgs.select(0);
                                                    this.cd.msloaded = 0;
                                                }
                                                else if (this.cd.msloaded != 1) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                                    this.gs.mstgs.select(0);
                                                    this.msload = 1;
                                                }
                                                this.sgflag = 3;
                                            }
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 4) {
                                            this.gs.mstgs.setSize(338, 22);
                                            if (this.sgflag != 4) {
                                                this.gstage = 0;
                                                if (!this.xt.logged) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                                    this.gs.mstgs.select(0);
                                                    this.cd.msloaded = 0;
                                                }
                                                else if (this.cd.msloaded != 7) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                                    this.gs.mstgs.select(0);
                                                    this.msload = 7;
                                                }
                                                this.sgflag = 4;
                                            }
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 5) {
                                            this.gs.mstgs.setSize(338, 22);
                                            if (this.sgflag != 5) {
                                                this.gstage = 0;
                                                if (!this.xt.logged) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                                    this.gs.mstgs.select(0);
                                                    this.cd.msloaded = 0;
                                                }
                                                else if (this.cd.msloaded != 3) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                                    this.gs.mstgs.select(0);
                                                    this.msload = 3;
                                                }
                                                this.sgflag = 5;
                                            }
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 6) {
                                            this.gs.mstgs.setSize(338, 22);
                                            if (this.sgflag != 6) {
                                                this.gstage = 0;
                                                if (!this.xt.logged) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                                    this.gs.mstgs.select(0);
                                                    this.cd.msloaded = 0;
                                                }
                                                else if (this.cd.msloaded != 4) {
                                                    this.gs.mstgs.removeAll();
                                                    this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                                    this.gs.mstgs.select(0);
                                                    this.msload = 4;
                                                }
                                                this.sgflag = 6;
                                            }
                                            n106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                                        }
                                        if (!this.gs.sgame.isShowing()) {
                                            this.gs.sgame.show();
                                            this.remstage = 0;
                                            if (this.loadstage == 0) {
                                                int n107 = (int)(Math.random() * 3.0);
                                                if (n107 == 3) {
                                                    n107 = 2;
                                                }
                                                this.gs.sgame.select(n107);
                                            }
                                        }
                                        this.gs.sgame.move(n106, 105);
                                        final int n108 = n106 + (this.gs.sgame.getWidth() + 6);
                                        if (this.gs.sgame.getSelectedIndex() == 0) {
                                            if (!this.gs.snfmm.isShowing()) {
                                                this.gs.snfmm.show();
                                                if (this.loadstage == 0) {
                                                    this.gs.snfmm.select(0);
                                                }
                                            }
                                            this.gs.snfmm.move(n108, 105);
                                            if (this.gs.snfm1.isShowing()) {
                                                this.gs.snfm1.hide();
                                            }
                                            if (this.gs.snfm2.isShowing()) {
                                                this.gs.snfm2.hide();
                                            }
                                            if (this.gs.mstgs.isShowing()) {
                                                this.gs.mstgs.hide();
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 0) {
                                            if (this.gs.snfmm.getSelectedIndex() != 0) {
                                                if (this.gstage != this.gs.snfmm.getSelectedIndex() + 27) {
                                                    this.loadstage = this.gs.snfmm.getSelectedIndex() + 27;
                                                    this.gstage = this.loadstage;
                                                    this.gs.requestFocus();
                                                }
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 1) {
                                            if (!this.gs.snfm2.isShowing()) {
                                                this.gs.snfm2.show();
                                                if (this.loadstage == 0) {
                                                    this.gs.snfm2.select(0);
                                                }
                                            }
                                            this.gs.snfm2.move(n108, 105);
                                            if (this.gs.snfmm.isShowing()) {
                                                this.gs.snfmm.hide();
                                            }
                                            if (this.gs.snfm1.isShowing()) {
                                                this.gs.snfm1.hide();
                                            }
                                            if (this.gs.mstgs.isShowing()) {
                                                this.gs.mstgs.hide();
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 1) {
                                            if (this.gs.snfm2.getSelectedIndex() != 0) {
                                                if (this.gstage != this.gs.snfm2.getSelectedIndex() + 10) {
                                                    this.loadstage = this.gs.snfm2.getSelectedIndex() + 10;
                                                    this.gstage = this.loadstage;
                                                    this.gs.requestFocus();
                                                }
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 2) {
                                            if (!this.gs.snfm1.isShowing()) {
                                                this.gs.snfm1.show();
                                                if (this.loadstage == 0) {
                                                    this.gs.snfm1.select(0);
                                                }
                                            }
                                            this.gs.snfm1.move(n108, 105);
                                            if (this.gs.snfmm.isShowing()) {
                                                this.gs.snfmm.hide();
                                            }
                                            if (this.gs.snfm2.isShowing()) {
                                                this.gs.snfm2.hide();
                                            }
                                            if (this.gs.mstgs.isShowing()) {
                                                this.gs.mstgs.hide();
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 2) {
                                            if (this.gs.snfm1.getSelectedIndex() != 0) {
                                                if (this.gstage != this.gs.snfm1.getSelectedIndex()) {
                                                    this.loadstage = this.gs.snfm1.getSelectedIndex();
                                                    this.gstage = this.loadstage;
                                                    this.gs.requestFocus();
                                                }
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() == 3) {
                                            if (!this.gs.mstgs.isShowing()) {
                                                this.gs.mstgs.show();
                                                if (this.loadstage == 0) {
                                                    this.gs.mstgs.select(0);
                                                }
                                            }
                                            this.gs.mstgs.move(n108, 105);
                                            if (this.gs.snfmm.isShowing()) {
                                                this.gs.snfmm.hide();
                                            }
                                            if (this.gs.snfm1.isShowing()) {
                                                this.gs.snfm1.hide();
                                            }
                                            if (this.gs.snfm2.isShowing()) {
                                                this.gs.snfm2.hide();
                                            }
                                        }
                                        Label_18045: {
                                            if (this.remstage != 2) {
                                                if (this.gs.sgame.getSelectedIndex() == 3) {
                                                    if (this.gs.mstgs.getSelectedIndex() != 0) {
                                                        if (this.gstage != this.gs.mstgs.getSelectedIndex() + 100) {
                                                            this.loadstage = this.gs.mstgs.getSelectedIndex() + 100;
                                                            this.gstage = this.loadstage;
                                                            this.gs.requestFocus();
                                                            this.remstage = 0;
                                                        }
                                                        if (this.loadstage > 0) {
                                                            break Label_18045;
                                                        }
                                                        if (this.remstage != 0) {
                                                            break Label_18045;
                                                        }
                                                        if (!this.xt.drawcarb(true, null, "X", 674, 136, n, n2, b)) {
                                                            break Label_18045;
                                                        }
                                                        this.remstage = 1;
                                                        break Label_18045;
                                                    }
                                                }
                                                if (this.remstage != 0) {
                                                    this.remstage = 0;
                                                }
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() >= 4) {
                                            if (!this.gs.mstgs.isShowing()) {
                                                this.gs.mstgs.show();
                                                if (this.loadstage == 0) {
                                                    this.gs.mstgs.select(0);
                                                }
                                            }
                                            this.gs.mstgs.move(n108, 105);
                                            if (this.gs.snfmm.isShowing()) {
                                                this.gs.snfmm.hide();
                                            }
                                            if (this.gs.snfm1.isShowing()) {
                                                this.gs.snfm1.hide();
                                            }
                                            if (this.gs.snfm2.isShowing()) {
                                                this.gs.snfm2.hide();
                                            }
                                        }
                                        if (this.gs.sgame.getSelectedIndex() >= 4) {
                                            if (this.gs.mstgs.getSelectedIndex() != 0) {
                                                if (this.gstage != this.gs.mstgs.getSelectedIndex() + 100) {
                                                    this.loadstage = this.gs.mstgs.getSelectedIndex() + 100;
                                                    this.gstage = this.loadstage;
                                                    this.gs.requestFocus();
                                                }
                                            }
                                        }
                                        if (this.loadstage > 0) {
                                            if (this.remstage == 0) {
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString("Loading stage, please wait...", 472 - this.ftm.stringWidth("Loading Stage, please wait...") / 2, 165);
                                            }
                                        }
                                        Label_19686: {
                                            if (this.gs.sgame.getSelectedIndex() >= 3) {
                                                if (!this.xt.logged) {
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString("You are currently using a trial account.", 472 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 155);
                                                    this.rd.drawString("You need to upgrade your account to access and publish custom stages!", 472 - this.ftm.stringWidth("You need to upgrade your account to access and publish custom stages!") / 2, 175);
                                                    this.rd.setColor(this.color2k(200, 200, 200));
                                                    this.rd.fillRoundRect(382, 185, 180, 50, 20, 20);
                                                    this.drawSbutton(this.xt.upgrade, 472, 210);
                                                    if (!this.gs.slaps.isShowing()) {
                                                        break Label_19686;
                                                    }
                                                    this.gs.slaps.hide();
                                                    break Label_19686;
                                                }
                                            }
                                            Label_19031: {
                                                if (this.loadstage < 0) {
                                                    if (this.remstage == 0) {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.setFont(new Font("Arial", 1, 12));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        this.rd.drawString("" + this.gstagename + "  -  Laps:              ", 472 - this.ftm.stringWidth("" + this.gstagename + "  -  Laps:              ") / 2, 155);
                                                        if (!this.gs.slaps.isShowing()) {
                                                            this.gs.slaps.show();
                                                            this.gs.slaps.select(this.gstagelaps - 1);
                                                        }
                                                        this.gs.slaps.move(472 + this.ftm.stringWidth("" + this.gstagename + "  -  Laps:              ") / 2 - 35, 138);
                                                        if (this.gs.slaps.getSelectedIndex() != this.gstagelaps - 1) {
                                                            this.gstagelaps = this.gs.slaps.getSelectedIndex() + 1;
                                                            this.gs.requestFocus();
                                                        }
                                                        this.stringbutton("    Preview Stage    ", 472, 185, 2);
                                                        break Label_19031;
                                                    }
                                                }
                                                if (this.gs.slaps.isShowing()) {
                                                    this.gs.slaps.hide();
                                                }
                                            }
                                            if (this.remstage == 3) {
                                                if (this.loadstage < 0) {
                                                    this.stringbutton("    Preview Stage    ", 472, -160, 2);
                                                }
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 13));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.xt.drawlprom(135, 75);
                                                this.rd.drawString("Failed to remove stage, server error, please try again later.", 472 - this.ftm.stringWidth("Failed to remove stage, server error, please try again later.") / 2, 155);
                                                if (this.xt.drawcarb(true, null, " OK ", 451, 175, n, n2, b)) {
                                                    this.remstage = 0;
                                                    this.gs.mouses = 0;
                                                }
                                            }
                                            if (this.remstage == 2) {
                                                if (this.loadstage < 0) {
                                                    this.stringbutton("    Preview Stage    ", 472, -160, 2);
                                                }
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 13));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.xt.drawlprom(135, 75);
                                                this.rd.drawString("Removing stage from your account...", 472 - this.ftm.stringWidth("Removing stage from your account...") / 2, 175);
                                                if (this.cd.staction == 0) {
                                                    this.gstage = 0;
                                                    this.loadstage = 0;
                                                    this.remstage = 0;
                                                }
                                                if (this.cd.staction == -1) {
                                                    this.remstage = 3;
                                                    this.gs.mouses = 0;
                                                }
                                            }
                                            if (this.remstage == 1) {
                                                if (this.loadstage < 0) {
                                                    this.stringbutton("    Preview Stage    ", 472, -160, 2);
                                                }
                                                this.xt.drawlprom(135, 75);
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 13));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString("Remove this stage from your account?", 472 - this.ftm.stringWidth("Remove this stage from your account?") / 2, 155);
                                                if (this.xt.drawcarb(true, null, " Yes ", 426, 175, n, n2, b)) {
                                                    this.remstage = 2;
                                                    this.cd.onstage = this.gs.mstgs.getSelectedItem();
                                                    this.cd.staction = 1;
                                                    this.cd.sparkstageaction();
                                                    this.gs.mouses = 0;
                                                }
                                                if (this.xt.drawcarb(true, null, " No ", 480, 175, n, n2, b)) {
                                                    this.remstage = 0;
                                                    this.gs.mouses = 0;
                                                }
                                            }
                                            this.stringbutton("   Next >   ", 472, 235, 1);
                                        }
                                    }
                                    if (!b14) {
                                        this.gs.pgame.hide();
                                    }
                                    else {
                                        this.gs.pgame.show();
                                    }
                                    if (!b15) {
                                        this.gs.vnpls.hide();
                                        this.gs.vtyp.hide();
                                    }
                                    else {
                                        this.gs.vnpls.show();
                                        this.gs.vtyp.show();
                                    }
                                }
                                if (this.chalngd == -3) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    Label_21764: {
                                        if (this.sflk % 4 == 0) {
                                            if (this.sflk != 0) {
                                                break Label_21764;
                                            }
                                        }
                                        this.rd.drawString("Select Number of Players", 472 - this.ftm.stringWidth("Select Number of Players") / 2, 85);
                                    }
                                    if (this.sflk != 0) {
                                        --this.sflk;
                                    }
                                    int n109 = 0;
                                    if (this.xt.lan) {
                                        n109 = 59;
                                    }
                                    this.rd.drawString("Players", 413 - n109, 122);
                                    if (!this.gs.snpls.isShowing()) {
                                        this.gs.snpls.show();
                                        this.gs.snpls.select(this.gnpls - 1);
                                    }
                                    this.gs.snpls.move(467 - n109, 105);
                                    boolean b16 = false;
                                    if (this.gs.snpls.getSelectedIndex() != 0) {
                                        if (this.gs.snpls.getSelectedIndex() != this.gnpls - 1) {
                                            this.gnpls = this.gs.snpls.getSelectedIndex() + 1;
                                            b16 = true;
                                            this.gs.swait.hide();
                                        }
                                    }
                                    Label_22175: {
                                        if (this.xt.lan) {
                                            this.rd.drawString("Bots", 490, 122);
                                            if (!this.gs.snbts.isShowing()) {
                                                this.gs.snbts.show();
                                                this.gs.snbts.select(0);
                                                this.gnbts = 0;
                                            }
                                            this.gs.snbts.move(524, 105);
                                            if (this.gs.snbts.getSelectedIndex() == this.gnbts) {
                                                if (!b16) {
                                                    break Label_22175;
                                                }
                                            }
                                            this.gnbts = this.gs.snbts.getSelectedIndex();
                                            while (this.gnbts + this.gnpls > 8) {
                                                --this.gnbts;
                                            }
                                            this.gs.snbts.select(this.gnbts);
                                        }
                                    }
                                    this.rd.drawString("Wait", 414, 162);
                                    if (!this.gs.swait.isShowing()) {
                                        this.gs.swait.show();
                                        if (this.gwait == 0) {
                                            this.gs.swait.select(1);
                                        }
                                    }
                                    this.gs.swait.move(451, 145);
                                    if ((this.gs.swait.getSelectedIndex() + 1) * 60 != this.gwait) {
                                        this.gwait = (this.gs.swait.getSelectedIndex() + 1) * 60;
                                    }
                                    this.rd.setColor(this.color2k(90, 90, 90));
                                    this.rd.setFont(new Font("Arial", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("( Maximum time to wait for all players to `join. )", 472 - this.ftm.stringWidth("( Maximum time to wait for all players to join. )") / 2, 179);
                                    this.stringbutton("   < Back   ", 422, 235, 1);
                                    this.stringbutton("   Next >   ", 522, 235, 1);
                                }
                                if (this.chalngd == -4) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    Label_22545: {
                                        if (this.sflk % 4 == 0) {
                                            if (this.sflk != 0) {
                                                break Label_22545;
                                            }
                                        }
                                        this.rd.drawString("Game Options", 472 - this.ftm.stringWidth("Game Options") / 2, 85);
                                    }
                                    if (this.sflk != 0) {
                                        --this.sflk;
                                    }
                                    final int n110 = 472 - (this.gs.scars.getWidth() + this.gs.sclass.getWidth() + this.gs.sfix.getWidth() + 16) / 2;
                                    Label_22703: {
                                        if (!this.gs.scars.isShowing()) {
                                            this.gs.scars.show();
                                            if (this.gcars >= 0) {
                                                if (this.gcars <= 2) {
                                                    this.gs.scars.select(this.gcars);
                                                    break Label_22703;
                                                }
                                            }
                                            this.gs.scars.select(0);
                                        }
                                    }
                                    this.gs.scars.move(n110, 105);
                                    final int n111 = n110 + (this.gs.scars.getWidth() + 8);
                                    Label_22823: {
                                        if (!this.gs.sclass.isShowing()) {
                                            this.gs.sclass.show();
                                            if (this.gclass >= 0) {
                                                if (this.gclass <= 5) {
                                                    this.gs.sclass.select(this.gclass);
                                                    break Label_22823;
                                                }
                                            }
                                            this.gs.sclass.select(0);
                                        }
                                    }
                                    this.gs.sclass.move(n111, 105);
                                    final int n112 = n111 + (this.gs.sclass.getWidth() + 8);
                                    Label_22943: {
                                        if (!this.gs.sfix.isShowing()) {
                                            this.gs.sfix.show();
                                            if (this.gfix >= 0) {
                                                if (this.gfix <= 5) {
                                                    this.gs.sfix.select(this.gfix);
                                                    break Label_22943;
                                                }
                                            }
                                            this.gs.sfix.select(0);
                                        }
                                    }
                                    this.gs.sfix.move(n112, 105);
                                    final int n113 = n112 + this.gs.sfix.getWidth();
                                    if (this.gs.openm) {
                                        this.gs.movefield(this.gs.notp, n113 - 112, -2000, 150, 17);
                                    }
                                    else {
                                        this.gs.movefield(this.gs.notp, n113 - 112, 131, 150, 17);
                                    }
                                    if (!this.gs.notp.isShowing()) {
                                        this.gs.notp.show();
                                        if (this.gnotp != 0) {
                                            this.gs.notp.setState(true);
                                        }
                                        else {
                                            this.gs.notp.setState(false);
                                        }
                                    }
                                    if (this.xt.sc[0] >= 16) {
                                        if (this.gs.mycar.getState()) {
                                            this.gs.mycar.setState(false);
                                        }
                                    }
                                    else {
                                        if (this.gs.openm) {
                                            this.gs.movefield(this.gs.mycar, 410, -2000, 150, 17);
                                        }
                                        else {
                                            this.gs.movefield(this.gs.mycar, 472 - (this.gs.scars.getWidth() + this.gs.sclass.getWidth() + this.gs.sfix.getWidth() + 16) / 2, 131, 150, 17);
                                        }
                                        if (!this.gs.mycar.isShowing()) {
                                            this.gs.mycar.show();
                                            this.gs.mycar.setLabel("" + this.cd.names[this.xt.sc[0]] + " Game!");
                                            if (this.gclass > -2) {
                                                this.gs.mycar.setState(false);
                                            }
                                            else {
                                                this.gs.mycar.setState(true);
                                            }
                                        }
                                    }
                                    if (!this.gs.mycar.getState()) {
                                        if (!this.gs.sclass.isEnabled()) {
                                            this.gs.sclass.enable();
                                        }
                                        if (!this.gs.scars.isEnabled()) {
                                            this.gs.scars.enable();
                                        }
                                        if (this.gs.sclass.getSelectedIndex() != this.gclass) {
                                            this.gclass = this.gs.sclass.getSelectedIndex();
                                            this.gs.mycar.hide();
                                        }
                                        if (this.gs.scars.getSelectedIndex() != this.gcars) {
                                            this.gcars = this.gs.scars.getSelectedIndex();
                                        }
                                    }
                                    else {
                                        if (this.gs.sclass.isEnabled()) {
                                            this.gs.sclass.disable();
                                        }
                                        if (this.gs.scars.isEnabled()) {
                                            this.gs.scars.disable();
                                        }
                                    }
                                    if (this.gs.sfix.getSelectedIndex() != this.gfix) {
                                        this.gfix = this.gs.sfix.getSelectedIndex();
                                    }
                                    String s24 = "Public Game, anyone can join...";
                                    int n114 = 0;
                                    for (int n115 = 0; n115 < 7; ++n115) {
                                        if (!this.invos[n115].equals("")) {
                                            ++n114;
                                        }
                                    }
                                    if (n114 > 0) {
                                        s24 = "Players Allowed:  ";
                                        int n116 = 0;
                                        for (int n117 = 0; n117 < 7; ++n117) {
                                            if (!this.invos[n117].equals("")) {
                                                s24 += this.invos[n117];
                                                if (++n116 != n114) {
                                                    if (n116 != n114 - 1) {
                                                        s24 += ", ";
                                                    }
                                                    else {
                                                        s24 += " and ";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (n114 >= this.gnpls - 1) {
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("" + n114 + " Allowed Players Selected", 472 - this.ftm.stringWidth("" + n114 + " Allowed Players Selected") / 2, 180);
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(s24, 472 - this.ftm.stringWidth(s24) / 2, 203);
                                    }
                                    else {
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.rd.drawString("Private Game, only specific players allowed to join?  " + n114 + "/" + (this.gnpls - 1) + "", 330, 180);
                                        this.stringbutton("<   Select   ", 281, 180, 2);
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(s24, 472 - this.ftm.stringWidth(s24) / 2, 203);
                                    }
                                    this.stringbutton("   < Back   ", 422, 235, 1);
                                    this.stringbutton("   Finish!   ", 522, 235, 1);
                                }
                                if (this.chalngd == -5) {
                                    if (this.fstart) {
                                        this.fstart = false;
                                    }
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 145);
                                    if (this.msg.equals(". . . | Creating Game | . . .")) {
                                        if (this.ncnt == 0) {
                                            this.msg = "| Creating Game |";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.msg.equals(". . | Creating Game | . .")) {
                                        if (this.ncnt == 0) {
                                            this.msg = ". . . | Creating Game | . . .";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.msg.equals(". | Creating Game | .")) {
                                        if (this.ncnt == 0) {
                                            this.msg = ". . | Creating Game | . .";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.msg.equals("| Creating Game |")) {
                                        if (this.ncnt == 0) {
                                            this.msg = ". | Creating Game | .";
                                            this.ncnt = 5;
                                        }
                                    }
                                    if (this.ncnt != 0) {
                                        --this.ncnt;
                                    }
                                }
                            }
                            else {
                                int n118 = 0;
                                for (int n119 = 0; n119 < this.ngm; ++n119) {
                                    if (this.chalngd == this.gnum[n119]) {
                                        n118 = n119;
                                    }
                                }
                                Label_14097: {
                                    if (this.cflk % 4 == 0) {
                                        if (this.cflk != 0) {
                                            break Label_14097;
                                        }
                                    }
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("You have been invited by " + this.chalby + " to join a game!", 472 - this.ftm.stringWidth("You have been invited by " + this.chalby + " to join a game!") / 2, 95);
                                    this.rd.setColor(new Color(117, 67, 0));
                                    this.rd.drawString(this.chalby, 472 - this.ftm.stringWidth("You have been invited by " + this.chalby + " to join a game!") / 2 + this.ftm.stringWidth("You have been invited by "), 95);
                                }
                                if (this.cflk != 0) {
                                    --this.cflk;
                                }
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("Stage:  " + this.gstages[n118] + " ,  Laps: " + this.gnlaps[n118] + "", 472 - this.ftm.stringWidth("Stage:  " + this.gstages[n118] + " ,  Laps: " + this.gnlaps[n118] + "") / 2, 130);
                                this.rd.setColor(new Color(62, 98, 0));
                                this.rd.drawString(this.gstages[n118], 472 - this.ftm.stringWidth("Stage:  " + this.gstages[n118] + " ,  Laps: " + this.gnlaps[n118] + "") / 2 + this.ftm.stringWidth("Stage:  "), 130);
                                this.rd.drawString("" + this.gnlaps[n118] + "", 472 - this.ftm.stringWidth("Stage:  " + this.gstages[n118] + " ,  Laps: " + this.gnlaps[n118] + "") / 2 + this.ftm.stringWidth("Stage:  " + this.gstages[n118] + " ,  Laps: "), 130);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Players:  " + this.mnpls[n118] + "", 472 - this.ftm.stringWidth("Players:  " + this.mnpls[n118] + "") / 2, 150);
                                this.rd.setColor(new Color(62, 98, 0));
                                this.rd.drawString("" + this.mnpls[n118] + "", 472 - this.ftm.stringWidth("Players:  " + this.mnpls[n118] + "") / 2 + this.ftm.stringWidth("Players:  "), 150);
                                final long time2 = new Date().getTime();
                                Label_14841: {
                                    if (this.ptime != 0L) {
                                        if (time2 <= this.ptime + 1000L) {
                                            break Label_14841;
                                        }
                                    }
                                    if (this.ptime != 0L) {
                                        --this.ctime;
                                    }
                                    this.ptime = time2;
                                }
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 0, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("( " + this.ctime + " )", 472 - this.ftm.stringWidth("( " + this.ctime + " )") / 2, 170);
                                if (this.ctime == 0) {
                                    this.ongame = this.longame;
                                    this.chalngd = -1;
                                    this.longame = -1;
                                }
                                this.stringbutton("   View Game   ", 352, 215, 2);
                                this.stringbutton("   Join Game   ", 462, 215, 2);
                                this.stringbutton("   Decline X   ", 599, 215, 2);
                            }
                        }
                        else {
                            this.rd.setColor(this.color2k(230, 230, 230));
                            this.rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                            if (this.britchl != 0) {
                                this.britchl = 0;
                            }
                            int n120 = (this.ngm - 5) * 24;
                            if (n120 < 0) {
                                n120 = 0;
                            }
                            int n121 = (int)(this.spos2 / 82.0f * n120 - 2.0f);
                            final int[] array7 = new int[this.ngm];
                            final int[] array8 = new int[this.ngm];
                            for (int n122 = 0; n122 < this.ngm; ++n122) {
                                array7[n122] = 0;
                            }
                            for (int n123 = 0; n123 < this.ngm; ++n123) {
                                for (int n124 = n123 + 1; n124 < this.ngm; ++n124) {
                                    if (this.wait[n123] == this.wait[n124]) {
                                        if (n124 >= n123) {
                                            final int[] array9 = array7;
                                            final int n125 = n124;
                                            ++array9[n125];
                                        }
                                        else {
                                            final int[] array10 = array7;
                                            final int n126 = n123;
                                            ++array10[n126];
                                        }
                                    }
                                    else {
                                        if (this.wait[n123] <= 0) {
                                            if (this.wait[n124] <= 0) {
                                                if (this.wait[n123] >= this.wait[n124]) {
                                                    final int[] array11 = array7;
                                                    final int n127 = n124;
                                                    ++array11[n127];
                                                    continue;
                                                }
                                                final int[] array12 = array7;
                                                final int n128 = n123;
                                                ++array12[n128];
                                                continue;
                                            }
                                        }
                                        Label_8373: {
                                            if (this.wait[n123] <= this.wait[n124]) {
                                                if (this.wait[n123] > 0) {
                                                    break Label_8373;
                                                }
                                            }
                                            if (this.wait[n124] > 0) {
                                                final int[] array13 = array7;
                                                final int n129 = n123;
                                                ++array13[n129];
                                                continue;
                                            }
                                        }
                                        final int[] array14 = array7;
                                        final int n130 = n124;
                                        ++array14[n130];
                                    }
                                }
                                array8[array7[n123]] = n123;
                            }
                            Label_8605: {
                                if (control.down) {
                                    ++this.opselect;
                                    int n131 = 0;
                                    while (true) {
                                        while (80 + 24 * this.opselect - n121 > 202) {
                                            if (n131 != 0) {
                                                control.down = false;
                                                break Label_8605;
                                            }
                                            ++this.spos2;
                                            if (this.spos2 > 82) {
                                                this.spos2 = 82;
                                                n131 = 1;
                                            }
                                            if (this.spos2 < 0) {
                                                this.spos2 = 0;
                                                n131 = 1;
                                            }
                                            n121 = (int)(this.spos2 / 82.0f * n120 - 2.0f);
                                        }
                                        continue;
                                    }
                                }
                            }
                            Label_8761: {
                                if (control.up) {
                                    --this.opselect;
                                    int n132 = 0;
                                    while (true) {
                                        while (80 + 24 * this.opselect - n121 < 80) {
                                            if (n132 != 0) {
                                                control.up = false;
                                                break Label_8761;
                                            }
                                            --this.spos2;
                                            if (this.spos2 > 82) {
                                                this.spos2 = 82;
                                                n132 = 1;
                                            }
                                            if (this.spos2 < 0) {
                                                this.spos2 = 0;
                                                n132 = 1;
                                            }
                                            n121 = (int)(this.spos2 / 82.0f * n120 - 2.0f);
                                        }
                                        continue;
                                    }
                                }
                            }
                            int n133 = -1;
                            if (this.mousonp != -1) {
                                int n134 = 0;
                                for (int n135 = 0; n135 < this.ngm; ++n135) {
                                    if (this.pgames[this.mousonp] == this.gnum[n135]) {
                                        n134 = n135;
                                    }
                                }
                                n133 = 91 + 24 * array7[n134] - n121;
                                if (80 + 24 * array7[n134] - n121 > 202) {
                                    int n136 = 1000 / n120;
                                    if (n136 < 1) {
                                        n136 = 1;
                                    }
                                    this.spos2 += n136;
                                    n133 = -1;
                                }
                                if (80 + 24 * array7[n134] - n121 < 80) {
                                    int n137 = 1000 / n120;
                                    if (n137 < 1) {
                                        n137 = 1;
                                    }
                                    this.spos2 -= n137;
                                    n133 = -1;
                                }
                                if (this.spos2 > 82) {
                                    this.spos2 = 82;
                                }
                                if (this.spos2 < 0) {
                                    this.spos2 = 0;
                                }
                                n121 = (int)(this.spos2 / 82.0f * n120 - 2.0f);
                                this.opselect = array7[n134];
                            }
                            if (this.opselect <= -1) {
                                this.opselect = 0;
                            }
                            if (this.opselect >= this.ngm) {
                                this.opselect = this.ngm - 1;
                            }
                            int n138 = 0;
                            for (int opselect = 0; opselect < this.ngm; ++opselect) {
                                if (80 + 24 * opselect - n121 < 224) {
                                    if (80 + 24 * opselect - n121 > 56) {
                                        if (this.opselect == opselect) {
                                            if (80 + 24 * opselect - n121 >= 224) {
                                                --this.opselect;
                                            }
                                            if (80 + 24 * opselect - n121 < 62) {
                                                ++this.opselect;
                                            }
                                        }
                                        boolean b17 = false;
                                        boolean b18 = false;
                                        if (!this.gs.openm) {
                                            Label_9783: {
                                                if (n > 241) {
                                                    if (n < 692) {
                                                        if (n2 > 92 + 24 * opselect - n121) {
                                                            if (n2 < 110 + 24 * opselect - n121) {
                                                                Label_9400: {
                                                                    if (this.lxm == n) {
                                                                        if (this.lym == n2) {
                                                                            break Label_9400;
                                                                        }
                                                                    }
                                                                    this.opselect = opselect;
                                                                }
                                                                b17 = true;
                                                                if (!b) {
                                                                    if (this.clicked == array8[opselect]) {
                                                                        this.ongame = this.gnum[array8[opselect]];
                                                                        this.opengame = 0;
                                                                        if (n >= 641) {
                                                                            if (n <= 689) {
                                                                                if (n2 > 92 + 24 * opselect - n121) {
                                                                                    if (n2 < 110 + 24 * opselect - n121) {
                                                                                        if (this.wait[array8[opselect]] > 0) {
                                                                                            boolean b19 = false;
                                                                                            Label_9716: {
                                                                                                if (this.gwarb[array8[opselect]] != 0) {
                                                                                                    if (!this.xt.clan.toLowerCase().equals(this.gaclan[array8[opselect]].toLowerCase())) {
                                                                                                        if (!this.xt.clan.toLowerCase().equals(this.gvclan[array8[opselect]].toLowerCase())) {
                                                                                                            break Label_9716;
                                                                                                        }
                                                                                                    }
                                                                                                    b19 = true;
                                                                                                }
                                                                                                else {
                                                                                                    if (!this.gplyrs[array8[opselect]].equals("")) {
                                                                                                        if (this.gplyrs[array8[opselect]].indexOf(this.pnames[this.im]) == -1) {
                                                                                                            break Label_9716;
                                                                                                        }
                                                                                                    }
                                                                                                    b19 = true;
                                                                                                }
                                                                                            }
                                                                                            if (b19) {
                                                                                                this.join = this.gnum[array8[opselect]];
                                                                                                this.msg = "| Joining Game |";
                                                                                                this.spos = 0;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        this.clicked = -1;
                                                                    }
                                                                    ++n138;
                                                                    break Label_9783;
                                                                }
                                                                if (this.clicked != -1) {
                                                                    break Label_9783;
                                                                }
                                                                this.clicked = array8[opselect];
                                                                break Label_9783;
                                                            }
                                                        }
                                                    }
                                                }
                                                ++n138;
                                            }
                                            if (n >= 641) {
                                                if (n <= 689) {
                                                    if (n2 > 92 + 24 * opselect - n121) {
                                                        if (n2 < 110 + 24 * opselect - n121) {
                                                            if (b) {
                                                                b18 = true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (this.opselect == opselect) {
                                            Label_9993: {
                                                Label_9910: {
                                                    if (b17) {
                                                        if (b) {
                                                            break Label_9910;
                                                        }
                                                    }
                                                    if (!control.enter) {
                                                        this.rd.setColor(this.color2k(255, 255, 255));
                                                        break Label_9993;
                                                    }
                                                }
                                                this.rd.setColor(this.color2k(200, 200, 200));
                                                if (control.enter) {
                                                    this.ongame = this.gnum[array8[opselect]];
                                                    this.opengame = 0;
                                                    control.enter = false;
                                                }
                                            }
                                            this.rd.fillRect(241, 92 + 24 * opselect - n121, 451, 18);
                                            if (b17) {
                                                this.rd.setColor(this.color2k(150, 150, 150));
                                                this.rd.drawRect(239, 90 + 24 * opselect - n121, 454, 21);
                                            }
                                        }
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.gstages[array8[opselect]], 382 - this.ftm.stringWidth(this.gstages[array8[opselect]]) / 2, 105 + 24 * opselect - n121);
                                        this.rd.drawString("|", 525, 105 + 24 * opselect - n121);
                                        this.rd.drawString("|", 584, 105 + 24 * opselect - n121);
                                        if (this.wait[array8[opselect]] <= 0) {
                                            this.rd.drawString("" + this.npls[array8[opselect]] + "", 556 - this.ftm.stringWidth("" + this.npls[array8[opselect]] + "") / 2, 105 + 24 * opselect - n121);
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (this.wait[array8[opselect]] != 0) {
                                                this.rd.setColor(this.color2k(100, 100, 100));
                                                this.rd.drawString("Finished", 590, 105 + 24 * opselect - n121);
                                            }
                                            else {
                                                this.rd.setColor(new Color(128, 73, 0));
                                                this.rd.drawString("Started", 594, 105 + 24 * opselect - n121);
                                            }
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (b18) {
                                                this.rd.setColor(this.color2k(230, 230, 230));
                                                this.rd.fillRect(641, 92 + 24 * opselect - n121, 48, 18);
                                            }
                                            else {
                                                this.rd.setColor(this.color2k(230, 230, 230));
                                                this.rd.fill3DRect(641, 92 + 24 * opselect - n121, 48, 18, true);
                                            }
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString("View", 665 - this.ftm.stringWidth("View") / 2, 105 + 24 * opselect - n121);
                                        }
                                        else {
                                            this.rd.drawString("" + this.npls[array8[opselect]] + " / " + this.mnpls[array8[opselect]] + "", 556 - this.ftm.stringWidth("" + this.npls[array8[opselect]] + " / " + this.mnpls[array8[opselect]] + "") / 2, 105 + 24 * opselect - n121);
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.rd.setColor(new Color(80, 128, 0));
                                            this.rd.drawString("Waiting", 593, 105 + 24 * opselect - n121);
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (b18) {
                                                this.rd.setColor(this.color2k(230, 230, 230));
                                                this.rd.fillRect(641, 92 + 24 * opselect - n121, 48, 18);
                                            }
                                            else {
                                                this.rd.setColor(this.color2k(230, 230, 230));
                                                this.rd.fill3DRect(641, 92 + 24 * opselect - n121, 48, 18, true);
                                                this.rd.fill3DRect(642, 93 + 24 * opselect - n121, 46, 16, true);
                                            }
                                            this.rd.setColor(new Color(0, 0, 0));
                                            boolean b20 = false;
                                            Label_10781: {
                                                if (this.gwarb[array8[opselect]] != 0) {
                                                    if (!this.xt.clan.toLowerCase().equals(this.gaclan[array8[opselect]].toLowerCase())) {
                                                        if (!this.xt.clan.toLowerCase().equals(this.gvclan[array8[opselect]].toLowerCase())) {
                                                            break Label_10781;
                                                        }
                                                    }
                                                    b20 = true;
                                                }
                                                else {
                                                    if (!this.gplyrs[array8[opselect]].equals("")) {
                                                        if (this.gplyrs[array8[opselect]].indexOf(this.pnames[this.im]) == -1) {
                                                            break Label_10781;
                                                        }
                                                    }
                                                    b20 = true;
                                                }
                                            }
                                            if (!b20) {
                                                this.rd.drawString("View", 665 - this.ftm.stringWidth("View") / 2, 105 + 24 * opselect - n121);
                                            }
                                            else {
                                                this.rd.drawString("Join", 665 - this.ftm.stringWidth("Join") / 2, 105 + 24 * opselect - n121);
                                            }
                                        }
                                        continue;
                                    }
                                }
                                if (this.opselect == opselect) {
                                    if (80 + 24 * opselect - n121 >= 224) {
                                        --this.opselect;
                                    }
                                    if (80 + 24 * opselect - n121 <= 56) {
                                        ++this.opselect;
                                    }
                                }
                                ++n138;
                            }
                            if (n138 == this.ngm) {
                                if (this.clicked != -1) {
                                    this.clicked = -1;
                                }
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            if (this.ngm == 0) {
                                if (this.lloaded) {
                                    if (!this.xt.lan) {
                                        this.rd.drawString("No Games Created", 472 - this.ftm.stringWidth("No Games Created") / 2, 165);
                                    }
                                }
                                else {
                                    this.rd.drawString("|  Loading Games  |", 472 - this.ftm.stringWidth("|  Loading Games  |") / 2, 165);
                                }
                            }
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(235, 65, 480, 25);
                            this.rd.drawImage(this.xt.games, 241, 69, null);
                            this.rd.setColor(this.color2k(70, 70, 70));
                            this.rd.drawString("Stage Name", 382 - this.ftm.stringWidth("Stage Name") / 2, 81);
                            this.rd.drawString("|", 525, 81);
                            this.rd.drawString("Players", 556 - this.ftm.stringWidth("Players") / 2, 81);
                            this.rd.drawString("|", 584, 81);
                            this.rd.drawString("Status", 641 - this.ftm.stringWidth("Status") / 2, 81);
                            this.rd.setColor(this.color2k(150, 150, 150));
                            this.rd.drawLine(235, 87, 696, 87);
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(235, 237, 480, 17);
                            this.rd.setColor(this.color2k(150, 150, 150));
                            this.rd.drawLine(235, 239, 696, 239);
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(698, 107, 17, 113);
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(231, 65, 4, 189);
                            Label_12108: {
                                if (this.mscro2 != 141) {
                                    if (n120 != 0) {
                                        this.rd.setColor(this.color2k(220, 220, 220));
                                        this.rd.fill3DRect(698, 90, 17, 17, true);
                                        break Label_12108;
                                    }
                                }
                                if (n120 != 0) {
                                    this.rd.setColor(this.color2k(215, 215, 215));
                                }
                                else {
                                    this.rd.setColor(this.color2k(205, 205, 205));
                                }
                                this.rd.fillRect(698, 90, 17, 17);
                            }
                            if (n120 != 0) {
                                this.rd.drawImage(this.xt.asu, 703, 96, null);
                            }
                            Label_12284: {
                                if (this.mscro2 != 142) {
                                    if (n120 != 0) {
                                        this.rd.setColor(this.color2k(220, 220, 220));
                                        this.rd.fill3DRect(698, 220, 17, 17, true);
                                        break Label_12284;
                                    }
                                }
                                if (n120 != 0) {
                                    this.rd.setColor(this.color2k(215, 215, 215));
                                }
                                else {
                                    this.rd.setColor(this.color2k(205, 205, 205));
                                }
                                this.rd.fillRect(698, 220, 17, 17);
                            }
                            if (n120 != 0) {
                                this.rd.drawImage(this.xt.asd, 703, 226, null);
                            }
                            if (n120 != 0) {
                                if (this.lspos2 == this.spos2) {
                                    if (this.mscro2 == 141) {
                                        this.rd.setColor(this.color2k(215, 215, 215));
                                    }
                                    this.rd.fill3DRect(698, 107 + this.spos2, 17, 31, true);
                                }
                                else {
                                    this.rd.setColor(this.color2k(215, 215, 215));
                                    this.rd.fillRect(698, 107 + this.spos2, 17, 31);
                                }
                                this.rd.setColor(this.color2k(150, 150, 150));
                                this.rd.drawLine(703, 120 + this.spos2, 709, 120 + this.spos2);
                                this.rd.drawLine(703, 122 + this.spos2, 709, 122 + this.spos2);
                                this.rd.drawLine(703, 124 + this.spos2, 709, 124 + this.spos2);
                                if (this.mscro2 > 138) {
                                    if (this.lspos2 != this.spos2) {
                                        this.lspos2 = this.spos2;
                                    }
                                }
                                if (!b) {
                                    if (this.mscro2 != 145) {
                                        this.mscro2 = 145;
                                    }
                                }
                                else {
                                    if (this.mscro2 == 145) {
                                        if (n > 698) {
                                            if (n < 715) {
                                                if (n2 > 107 + this.spos2) {
                                                    if (n2 < this.spos2 + 138) {
                                                        this.mscro2 = n2 - this.spos2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.mscro2 == 145) {
                                        if (n > 696) {
                                            if (n < 717) {
                                                if (n2 > 88) {
                                                    if (n2 < 109) {
                                                        this.mscro2 = 141;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.mscro2 == 145) {
                                        if (n > 696) {
                                            if (n < 717) {
                                                if (n2 > 218) {
                                                    if (n2 < 239) {
                                                        this.mscro2 = 142;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.mscro2 == 145) {
                                        if (n > 698) {
                                            if (n < 715) {
                                                if (n2 > 107) {
                                                    if (n2 < 220) {
                                                        this.mscro2 = 122;
                                                        this.spos2 = n2 - this.mscro2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    int n139 = 400 / n120;
                                    if (n139 < 1) {
                                        n139 = 1;
                                    }
                                    if (this.mscro2 == 141) {
                                        this.spos2 -= n139;
                                        if (this.spos2 > 82) {
                                            this.spos2 = 82;
                                        }
                                        if (this.spos2 < 0) {
                                            this.spos2 = 0;
                                        }
                                        this.lspos2 = this.spos2;
                                    }
                                    if (this.mscro2 == 142) {
                                        this.spos2 += n139;
                                        if (this.spos2 > 82) {
                                            this.spos2 = 82;
                                        }
                                        if (this.spos2 < 0) {
                                            this.spos2 = 0;
                                        }
                                        this.lspos2 = this.spos2;
                                    }
                                    if (this.mscro2 <= 138) {
                                        this.spos2 = n2 - this.mscro2;
                                        if (this.spos2 > 82) {
                                            this.spos2 = 82;
                                        }
                                        if (this.spos2 < 0) {
                                            this.spos2 = 0;
                                        }
                                    }
                                    if (this.mscro2 == 145) {
                                        this.mscro2 = 225;
                                    }
                                }
                                if (n3 != 0) {
                                    if (n > 235) {
                                        if (n < 698) {
                                            if (n2 > 87) {
                                                if (n2 < 239) {
                                                    this.spos2 -= n3;
                                                    this.zeromsw = true;
                                                    if (this.spos2 > 82) {
                                                        this.spos2 = 82;
                                                        this.zeromsw = false;
                                                    }
                                                    if (this.spos2 < 0) {
                                                        this.spos2 = 0;
                                                        this.zeromsw = false;
                                                    }
                                                    this.lspos2 = this.spos2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.mousonp != -1) {
                                if (n133 != -1) {
                                    this.rd.setColor(this.color2k(255, 255, 255));
                                    this.rd.fillPolygon(new int[] { 185, 241, 241, 185 }, new int[] { n11, n133, n133 + 19, n11 + 30 }, 4);
                                    this.rd.setColor(this.color2k(150, 150, 150));
                                    this.rd.drawLine(185, n11, 241, n133);
                                    this.rd.drawLine(185, n11 + 30, 241, n133 + 19);
                                    this.rd.drawLine(241, n133, 692, n133);
                                    this.rd.drawLine(241, n133 + 19, 692, n133 + 19);
                                }
                            }
                        }
                        if (!this.xt.lan) {
                            this.rd.setColor(this.color2k(230, 230, 230));
                            this.rd.fillRoundRect(225, 263, 495, 157, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 263, 495, 157, 20, 20);
                            final String[] array15 = new String[14];
                            final String[] array16 = new String[14];
                            final boolean[] array17 = new boolean[14];
                            for (int n140 = 0; n140 < 14; ++n140) {
                                array16[n140] = (array15[n140] = "");
                                array17[n140] = false;
                            }
                            int n141 = 0;
                            this.rd.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            int n142;
                            if (this.updatec == -1) {
                                n142 = 0;
                                this.rd.drawString("Loading chat...", 465 - this.ftm.stringWidth("Loading chat...") / 2, 325);
                            }
                            else {
                                for (int n143 = 0; n143 < 7; ++n143) {
                                    array15[n141] = "";
                                    array16[n141] = this.cnames[n143];
                                    int n144 = 0;
                                    int n145 = 0;
                                    int n146 = 0;
                                    int n147 = 0;
                                    int n148 = 0;
                                    while (n144 < this.sentn[n143].length()) {
                                        final String string2 = "" + this.sentn[n143].charAt(n144);
                                        if (!string2.equals(" ")) {
                                            n148 = 0;
                                        }
                                        else {
                                            n145 = n146;
                                            n147 = n144;
                                            ++n148;
                                        }
                                        if (n148 <= 1) {
                                            final StringBuilder sb2 = new StringBuilder();
                                            final String[] array18 = array15;
                                            final int n149 = n141;
                                            array18[n149] = sb2.append(array18[n149]).append(string2).toString();
                                            ++n146;
                                            if (this.ftm.stringWidth(array15[n141]) > 367) {
                                                if (n145 == 0) {
                                                    array15[n141] = "";
                                                    n146 = 0;
                                                }
                                                else {
                                                    array15[n141] = array15[n141].substring(0, n145);
                                                    if (n141 != 13) {
                                                        ++n141;
                                                        array16[n141] = this.cnames[n143];
                                                    }
                                                    else {
                                                        for (int n150 = 0; n150 < 13; ++n150) {
                                                            array15[n150] = array15[n150 + 1];
                                                            array16[n150] = array16[n150 + 1];
                                                            array17[n150] = array17[n150 + 1];
                                                        }
                                                        array15[n141] = "";
                                                        array17[n141] = true;
                                                    }
                                                    n144 = n147;
                                                    n146 = 0;
                                                    n145 = 0;
                                                }
                                            }
                                        }
                                        ++n144;
                                    }
                                    if (n141 == 13) {
                                        if (n143 != 6) {
                                            for (int n151 = 0; n151 < 13; ++n151) {
                                                array15[n151] = array15[n151 + 1];
                                                array16[n151] = array16[n151 + 1];
                                                array17[n151] = array17[n151 + 1];
                                            }
                                            continue;
                                        }
                                    }
                                    ++n141;
                                }
                                n142 = (n141 - 6) * 15;
                                if (n142 < 0) {
                                    n142 = 0;
                                }
                                final int n152 = (int)(this.spos3 / 28.0f * n142);
                                String s25 = "";
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                for (int n153 = 0; n153 < n141; ++n153) {
                                    if (!s25.equals(array16[n153])) {
                                        if (280 + n153 * 15 - n152 > 266) {
                                            if (280 + n153 * 15 - n152 < 370) {
                                                this.rd.drawString(array16[n153] + ":", 320 - this.ftm.stringWidth(array16[n153] + ":"), 305 + n153 * 15 - n152);
                                            }
                                        }
                                        s25 = array16[n153];
                                    }
                                }
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                for (int n154 = 0; n154 < n141; ++n154) {
                                    if (array17[n154]) {
                                        if (n154 == 0) {
                                            if (array15[n154].indexOf(" ") != -1) {
                                                array15[n154] = "..." + array15[n154].substring(array15[n154].indexOf(" "), array15[n154].length()) + "";
                                            }
                                        }
                                    }
                                    if (280 + n154 * 15 - n152 > 266) {
                                        if (280 + n154 * 15 - n152 < 370) {
                                            this.rd.drawString(array15[n154], 325, 305 + n154 * 15 - n152);
                                        }
                                    }
                                }
                            }
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(235, 269, 480, 25);
                            this.rd.drawImage(this.xt.chat, 241, 273, null);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.setColor(this.color2k(120, 120, 120));
                            this.rd.drawString("( Room Chat )", 299, 285);
                            this.rd.setColor(this.color2k(150, 150, 150));
                            this.rd.drawLine(235, 291, 696, 291);
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(235, 387, 480, 28);
                            this.rd.setColor(this.color2k(150, 150, 150));
                            this.rd.drawLine(235, 389, 696, 389);
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(698, 311, 17, 59);
                            this.rd.setColor(this.color2k(205, 205, 205));
                            this.rd.fillRect(231, 269, 4, 146);
                            Label_26258: {
                                if (this.mscro3 != 351) {
                                    if (n142 != 0) {
                                        this.rd.setColor(this.color2k(220, 220, 220));
                                        this.rd.fill3DRect(698, 294, 17, 17, true);
                                        break Label_26258;
                                    }
                                }
                                if (n142 != 0) {
                                    this.rd.setColor(this.color2k(215, 215, 215));
                                }
                                else {
                                    this.rd.setColor(this.color2k(205, 205, 205));
                                }
                                this.rd.fillRect(698, 294, 17, 17);
                            }
                            if (n142 != 0) {
                                this.rd.drawImage(this.xt.asu, 703, 300, null);
                            }
                            Label_26435: {
                                if (this.mscro3 != 352) {
                                    if (n142 != 0) {
                                        this.rd.setColor(this.color2k(220, 220, 220));
                                        this.rd.fill3DRect(698, 370, 17, 17, true);
                                        break Label_26435;
                                    }
                                }
                                if (n142 != 0) {
                                    this.rd.setColor(this.color2k(215, 215, 215));
                                }
                                else {
                                    this.rd.setColor(this.color2k(205, 205, 205));
                                }
                                this.rd.fillRect(698, 370, 17, 17);
                            }
                            if (n142 != 0) {
                                this.rd.drawImage(this.xt.asd, 703, 376, null);
                            }
                            if (n142 != 0) {
                                if (this.lspos3 == this.spos3) {
                                    if (this.mscro3 == 141) {
                                        this.rd.setColor(this.color2k(215, 215, 215));
                                    }
                                    this.rd.fill3DRect(698, 311 + this.spos3, 17, 31, true);
                                }
                                else {
                                    this.rd.setColor(this.color2k(215, 215, 215));
                                    this.rd.fillRect(698, 311 + this.spos3, 17, 31);
                                }
                                this.rd.setColor(this.color2k(150, 150, 150));
                                this.rd.drawLine(703, 324 + this.spos3, 709, 324 + this.spos3);
                                this.rd.drawLine(703, 326 + this.spos3, 709, 326 + this.spos3);
                                this.rd.drawLine(703, 328 + this.spos3, 709, 328 + this.spos3);
                                if (this.mscro3 > 342) {
                                    if (this.lspos3 != this.spos3) {
                                        this.lspos3 = this.spos3;
                                    }
                                }
                                if (!b) {
                                    if (this.mscro3 != 345) {
                                        this.mscro3 = 345;
                                    }
                                }
                                else {
                                    if (this.mscro3 == 345) {
                                        if (n > 698) {
                                            if (n < 715) {
                                                if (n2 > 311 + this.spos3) {
                                                    if (n2 < this.spos3 + 342) {
                                                        this.mscro3 = n2 - this.spos3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.mscro3 == 345) {
                                        if (n > 696) {
                                            if (n < 717) {
                                                if (n2 > 292) {
                                                    if (n2 < 313) {
                                                        this.mscro3 = 351;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.mscro3 == 345) {
                                        if (n > 696) {
                                            if (n < 717) {
                                                if (n2 > 368) {
                                                    if (n2 < 389) {
                                                        this.mscro3 = 352;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.mscro3 == 345) {
                                        if (n > 698) {
                                            if (n < 715) {
                                                if (n2 > 311) {
                                                    if (n2 < 370) {
                                                        this.mscro3 = 326;
                                                        this.spos3 = n2 - this.mscro3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    int n155 = 100 / n142;
                                    if (n155 < 1) {
                                        n155 = 1;
                                    }
                                    if (this.mscro3 == 351) {
                                        this.spos3 -= n155;
                                        if (this.spos3 > 28) {
                                            this.spos3 = 28;
                                        }
                                        if (this.spos3 < 0) {
                                            this.spos3 = 0;
                                        }
                                        this.lspos3 = this.spos3;
                                    }
                                    if (this.mscro3 == 352) {
                                        this.spos3 += n155;
                                        if (this.spos3 > 28) {
                                            this.spos3 = 28;
                                        }
                                        if (this.spos3 < 0) {
                                            this.spos3 = 0;
                                        }
                                        this.lspos3 = this.spos3;
                                    }
                                    if (this.mscro3 <= 342) {
                                        this.spos3 = n2 - this.mscro3;
                                        if (this.spos3 > 28) {
                                            this.spos3 = 28;
                                        }
                                        if (this.spos3 < 0) {
                                            this.spos3 = 0;
                                        }
                                    }
                                    if (this.mscro3 == 345) {
                                        this.mscro3 = 425;
                                    }
                                }
                                if (n3 != 0) {
                                    if (n > 235) {
                                        if (n < 698) {
                                            if (n2 > 291) {
                                                if (n2 < 389) {
                                                    this.spos3 -= n3 / 2;
                                                    this.zeromsw = true;
                                                    if (this.spos3 > 28) {
                                                        this.spos3 = 28;
                                                        this.zeromsw = false;
                                                    }
                                                    if (this.spos3 < 0) {
                                                        this.spos3 = 0;
                                                        this.zeromsw = false;
                                                    }
                                                    this.lspos3 = this.spos3;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            this.pre1 = true;
                            this.stringbutton("Send Message", 657, 406, 3);
                        }
                        if (this.chalngd != -1) {
                            if (this.chalngd != -6) {
                                break Label_50933;
                            }
                        }
                        if (this.lg.gamec != -1) {
                            if (this.lg.cntgame >= 0) {
                                if (this.lg.cntgame < 10) {
                                    this.rd.setComposite(AlphaComposite.getInstance(3, this.lg.cntgame / 10.0f));
                                }
                            }
                            if (this.lg.cntgame > 390) {
                                if (this.lg.cntgame < 400) {
                                    this.rd.setComposite(AlphaComposite.getInstance(3, (400 - this.lg.cntgame) / 10.0f));
                                }
                            }
                            this.rd.setColor(this.color2k(245, 245, 245));
                            this.rd.fillRoundRect(383, 242, 337, 46, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(383, 242, 337, 46, 20, 20);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("" + this.lg.gmaker + " created a game in " + this.lg.gservern + " :: Room " + this.lg.groom + "", 551 - this.ftm.stringWidth("" + this.lg.gmaker + " created a game in " + this.lg.gservern + " :: Room " + this.lg.groom + "") / 2, 260);
                            Label_28252: {
                                if (n > 488) {
                                    if (n < 614) {
                                        if (n2 > 264) {
                                            if (n2 < 287) {
                                                if (b) {
                                                    this.grprsd = true;
                                                    break Label_28252;
                                                }
                                                if (!this.grprsd) {
                                                    break Label_28252;
                                                }
                                                while (true) {
                                                    for (int n156 = 0; n156 < this.lg.nservers; ++n156) {
                                                        if (this.lg.gservern.equals(this.lg.snames[n156])) {
                                                            this.stopallnow();
                                                            this.xt.server = this.lg.servers[n156];
                                                            this.xt.servername = this.lg.snames[n156];
                                                            this.xt.servport = 7070 + this.lg.groom;
                                                            this.inishlobby();
                                                            this.grprsd = false;
                                                            break Label_28252;
                                                        }
                                                    }
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (this.grprsd) {
                                    this.grprsd = false;
                                }
                            }
                            if (this.grprsd) {
                                this.rd.setColor(this.color2k(230, 230, 230));
                                this.rd.fillRect(490, 266, 122, 19);
                                this.rd.setColor(this.color2k(60, 60, 60));
                            }
                            else {
                                this.rd.setColor(this.color2k(230, 230, 230));
                                this.rd.fill3DRect(490, 266, 122, 19, true);
                                this.rd.setColor(new Color(0, 0, 0));
                            }
                            this.rd.drawString("View / Join Game", 551 - this.ftm.stringWidth("View / Join Game") / 2, 280);
                            Label_28492: {
                                Label_28475: {
                                    if (this.lg.cntgame >= 0) {
                                        if (this.lg.cntgame < 10) {
                                            break Label_28475;
                                        }
                                    }
                                    if (this.lg.cntgame <= 390) {
                                        break Label_28492;
                                    }
                                    if (this.lg.cntgame >= 400) {
                                        break Label_28492;
                                    }
                                }
                                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                            }
                            final Login lg2 = this.lg;
                            ++lg2.cntgame;
                            if (this.lg.cntgame == 400) {
                                this.lg.gamec = -1;
                            }
                        }
                    }
                    else {
                        if (this.opengame >= 27) {
                            this.opengame = 26;
                        }
                        int n157 = 229 + this.opengame;
                        if (n157 > 255) {
                            n157 = 255;
                        }
                        if (n157 < 0) {
                            n157 = 0;
                        }
                        this.rd.setColor(this.color2k(n157, n157, n157));
                        this.rd.fillRoundRect(225, 59 - (int)(this.opengame * 2.23f), 495, 200 + this.opengame * 8, 20, 20);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(225, 59 - (int)(this.opengame * 2.23f), 495, 200 + this.opengame * 8, 20, 20);
                        if (!this.xt.lan) {
                            this.rd.setColor(this.color2k(217, 217, 217));
                            this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                        }
                        this.btn = 0;
                        if (this.prevloaded != -1) {
                            this.prevloaded = -1;
                        }
                        if (this.updatec != -1) {
                            this.updatec = -1;
                        }
                        if (this.gs.cmsg.isShowing()) {
                            this.gs.cmsg.hide();
                            this.gs.requestFocus();
                        }
                        this.opengame -= 2;
                        if (this.opengame == 0) {
                            if (this.longame != -1) {
                                if (this.chalngd == -1) {
                                    this.ongame = this.longame;
                                    this.longame = -1;
                                }
                            }
                        }
                        if (this.invo) {
                            this.invo = false;
                        }
                        for (int n158 = 0; n158 < 7; ++n158) {
                            if (!this.invos[n158].equals("")) {
                                this.invos[n158] = "";
                            }
                            if (!this.dinvi[n158].equals("")) {
                                this.dinvi[n158] = "";
                            }
                        }
                        if (this.fstart) {
                            this.fstart = false;
                        }
                        for (int n159 = 0; n159 < 9; ++n159) {
                            if (this.cac[n159] != -1) {
                                this.cac[n159] = -1;
                            }
                        }
                        if (this.dispcar != -1) {
                            this.dispcar = -1;
                        }
                    }
                }
            }
        }
        if (pcurs != this.pcurs) {
            this.gs.setCursor(new Cursor(pcurs));
            this.pcurs = pcurs;
        }
    }

    public void preforma(final int n, final int n2) {
        if (this.pre1) {
            boolean b = false;
            if (!this.gs.openm && this.gb.open == 0) {
                if (this.conon != 0) {
                    b = true;
                }
            }
            else if (this.gs.cmsg.isShowing()) {
                this.gs.cmsg.hide();
            }
            this.gs.movefieldd(this.gs.cmsg, 235, 390, 360, 22, b);
            if (this.gs.cmsg.getText().equals("Type here...") && n > 234 && n < 603 && n2 > 385 && n2 < 417) {
                this.gs.cmsg.setText("");
            }
        }
        if (this.pre2) {
            boolean b2 = false;
            if (!this.gs.openm && this.gb.open == 0) {
                b2 = true;
            }
            else if (this.gs.cmsg.isShowing()) {
                this.gs.cmsg.hide();
            }
            this.gs.movefieldd(this.gs.cmsg, 237, 390, 360, 22, b2);
            if (this.gs.cmsg.getText().equals("Type here...") && n > 232 && n < 601 && n2 > 385 && n2 < 417) {
                this.gs.cmsg.setText("");
            }
        }
        if (this.pre1 || this.pre2) {
            if (this.gs.cmsg.getText().length() > 100) {
                this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, 100));
                this.gs.cmsg.select(100, 100);
            }
            this.pre1 = false;
            this.pre2 = false;
        }
    }

    public void stageselect(final CheckPoints checkPoints, final Control control, final int n, final int n2, final boolean b) {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
        this.btn = 0;
        int pcurs = 0;
        this.rd.drawImage(this.xt.br, 65, 25, null);
        if (this.britchl == -1) {
            this.ongame = -1;
            this.britchl = 0;
        }
        int n3 = 0;
        for (int i = 0; i < this.ngm; ++i) {
            if (this.ongame == this.gnum[i]) {
                n3 = i;
            }
        }
        if (this.chalngd != -2 && this.ongame != -1) {
            this.rd.setColor(this.color2k(20, 20, 20));
            this.rd.fillRect(80, 0, 640, 40);
            this.rd.setColor(this.color2k(70, 70, 70));
            this.rd.drawLine(80, 40, 720, 40);
            this.rd.drawLine(80, 40, 80, 0);
            this.rd.drawLine(720, 40, 720, 0);
            this.rd.setColor(new Color(193, 106, 0));
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            if (this.wait[n3] > 0) {
                if (this.gwarb[n3] == 0) {
                    if (this.wait[n3] > 30 || this.npls[n3] <= 1) {
                        String s = "";
                        if (this.npls[n3] > 1) {
                            final long time = new Date().getTime();
                            if (this.ptime == 0L || time > this.ptime + 1500L) {
                                if (this.ptime != 0L) {
                                    final int[] wait = this.wait;
                                    final int n4 = n3;
                                    --wait[n4];
                                    if (this.wait[n3] < 1) {
                                        this.wait[n3] = 1;
                                    }
                                }
                                this.ptime = time;
                            }
                            s = " (waiting " + this.wait[n3] + " seconds maximum)";
                            if (this.wait[n3] > 60) {
                                s = " (waiting " + (int)(this.wait[n3] / 60.0f * 100.0f) / 100.0f + " minutes maximum)";
                            }
                        }
                        this.rd.drawString("Waiting for " + (this.mnpls[n3] - this.npls[n3]) + " more players to join to start this game" + s + "!", 95, 15);
                        this.rd.setFont(new Font("Arial", 0, 12));
                        if (!this.gmaker[n3].equals("Coach Insano") && !this.gmaker[n3].equals(this.pnames[this.im])) {
                            boolean b2 = false;
                            for (int j = 0; j < this.npo; ++j) {
                                if (this.pgames[j] == this.ongame && this.gmaker[n3].equals(this.pnames[j])) {
                                    b2 = true;
                                }
                            }
                            if (b2) {
                                this.rd.drawString("" + this.gmaker[n3] + " can start this game at anytime (the game creator)...", 95, 31);
                            }
                        }
                    }
                    else {
                        final long time2 = new Date().getTime();
                        if (this.ptime == 0L || time2 > this.ptime + 1500L) {
                            if (this.ptime != 0L) {
                                final int[] wait2 = this.wait;
                                final int n5 = n3;
                                --wait2[n5];
                                if (this.wait[n3] < 1) {
                                    this.wait[n3] = 1;
                                }
                            }
                            this.ptime = time2;
                        }
                        if (this.pgames[this.im] == this.ongame || this.nflk != 0) {
                            this.rd.drawString("Game starts in " + this.wait[n3] + " seconds!", 400 - this.ftm.stringWidth("Game starts in " + this.wait[n3] + " seconds!") / 2, 23);
                            if (this.pgames[this.im] != this.ongame) {
                                --this.nflk;
                            }
                        }
                        else if (this.pgames[this.im] != this.ongame) {
                            this.nflk = 3;
                        }
                    }
                }
                else {
                    this.rd.drawString("Waiting for " + (this.mnpls[n3] - this.npls[n3]) + " clan members to join to start this game!", 95, 23);
                }
                if (this.pgames[this.im] != this.ongame) {
                    boolean b3 = false;
                    if (this.gwarb[n3] == 0) {
                        if (this.gplyrs[n3].equals("") || this.gplyrs[n3].indexOf(this.pnames[this.im]) != -1) {
                            b3 = true;
                        }
                    }
                    else if (this.xt.clan.toLowerCase().equals(this.gaclan[n3].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[n3].toLowerCase())) {
                        b3 = true;
                    }
                    if (b3) {
                        this.stringbutton(" Join Game ", 660, 23, 2);
                    }
                }
            }
            else {
                this.rd.setColor(this.color2k(120, 120, 120));
                if (this.wait[n3] == 0) {
                    this.rd.drawString("Game Started", 400 - this.ftm.stringWidth("Game Started") / 2, 20);
                }
                else {
                    this.rd.drawString("Game Finished", 400 - this.ftm.stringWidth("Game Finished") / 2, 20);
                }
            }
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.xt.ftm = this.rd.getFontMetrics();
        this.ftm = this.rd.getFontMetrics();
        String s2 = "";
        if (checkPoints.stage < 0) {
            s2 = "Custom Stage";
        }
        if (checkPoints.stage > 0 && checkPoints.stage <= 10) {
            s2 = "Stage " + checkPoints.stage + " NFM 1";
        }
        if (checkPoints.stage > 10 && checkPoints.stage <= 27) {
            s2 = "Stage " + (checkPoints.stage - 10) + " NFM 2";
        }
        if (checkPoints.stage > 27) {
            s2 = "Multiplayer Stage " + (checkPoints.stage - 27) + "";
        }
        this.xt.drawcs(85, "Previewing " + s2 + "  >", 255, 138, 0, 5);
        this.xt.drawcs(105, "| " + checkPoints.name + " |", 255, 176, 85, 5);
        this.rd.drawImage(this.xt.back[this.pback], 532, 285, null);
        if (this.plsndt == 0) {
            final String s3 = "Play Soundtrack >";
            final int n6 = 562 - this.ftm.stringWidth(s3) / 2;
            final int n7 = n6 + this.ftm.stringWidth(s3);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s3, n6 + 1, 326);
            this.rd.drawLine(n6 + 1, 328, n7 + 1, 328);
            this.rd.setColor(new Color(255, 138, 0));
            this.rd.drawString(s3, n6, 325);
            this.rd.drawLine(n6, 327, n7, 327);
            if (n > n6 && n < n7 && n2 > 314 && n2 < 327) {
                pcurs = 12;
                if (b) {
                    this.plsndt = 1;
                }
            }
        }
        if (this.plsndt == 1) {
            this.xt.drawcs(190, "Loading Soundtrack, please wait...", 255, 138, 0, 5);
        }
        if (checkPoints.stage < 0) {
            this.rd.setColor(new Color(255, 138, 0));
            this.rd.drawString("Created by: " + checkPoints.maker + "", 85, 413);
            if (checkPoints.pubt > 0) {
                if (checkPoints.pubt == 2) {
                    this.xt.drawcs(413, "Super Public Stage", 41, 177, 255, 3);
                }
                else {
                    this.xt.drawcs(413, "Public Stage", 41, 177, 255, 3);
                }
                if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 334, 420, n, n2, b)) {
                    if (this.xt.logged) {
                        this.cd.onstage = checkPoints.name;
                        this.cd.staction = 2;
                        this.cd.sparkstageaction();
                        this.addstage = 2;
                    }
                    else {
                        this.addstage = 1;
                        this.waitlink = 20;
                    }
                }
                if (this.addstage == 1) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(193, 106, 0));
                    final String s4 = "Upgrade to a full account to add custom stages!";
                    final int n8 = 400 - this.ftm.stringWidth(s4) / 2;
                    final int n9 = n8 + this.ftm.stringWidth(s4);
                    this.rd.drawString(s4, n8, 435);
                    if (this.waitlink != -1) {
                        this.rd.drawLine(n8, 437, n9, 437);
                    }
                    if (n > n8 && n < n9 && n2 > 424 && n2 < 437) {
                        if (this.waitlink != -1) {
                            pcurs = 12;
                        }
                        if (b && this.waitlink == 0) {
                            this.gs.editlink(this.xt.nickname, true);
                            this.waitlink = -1;
                        }
                    }
                    if (this.waitlink > 0) {
                        --this.waitlink;
                    }
                }
                if (this.addstage == 2) {
                    this.xt.drawcs(435, "Adding stage please wait...", 193, 106, 0, 3);
                    if (this.cd.staction == 0) {
                        this.addstage = 3;
                    }
                    if (this.cd.staction == -2) {
                        this.addstage = 4;
                    }
                    if (this.cd.staction == -3) {
                        this.addstage = 5;
                    }
                    if (this.cd.staction == -1) {
                        this.addstage = 6;
                    }
                }
                if (this.addstage == 3) {
                    this.xt.drawcs(435, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                }
                if (this.addstage == 4) {
                    this.xt.drawcs(435, "You already have this stage!", 193, 106, 0, 3);
                }
                if (this.addstage == 5) {
                    this.xt.drawcs(435, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                }
                if (this.addstage == 6) {
                    this.xt.drawcs(435, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                }
            }
            else {
                this.xt.drawcs(435, "Private Stage", 193, 106, 0, 3);
            }
        }
        if (control.enter || this.conon == 2 || (this.ongame == -1 && this.chalngd != -2)) {
            this.m.trk = 0;
            if (this.xt.loadedt) {
                this.xt.strack.unload();
            }
            this.m.focus_point = 400;
            this.m.crs = true;
            this.m.x = -335;
            this.m.y = 0;
            this.m.z = -50;
            this.m.xz = 0;
            this.m.zy = 20;
            this.m.ground = -2000;
            this.fase = 1;
            control.enter = false;
        }
        if (pcurs != this.pcurs) {
            this.gs.setCursor(new Cursor(pcurs));
            this.pcurs = pcurs;
        }
    }

    public void ctachm(final int lxm, final int lym, final int n, final Control control) {
        int n2 = -1;
        if (this.fase == 1 || this.fase == 4) {
            for (int i = 0; i < this.btn; ++i) {
                if (Math.abs(lxm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(lym - this.by[i]) < 14 && (n == 1 || n == 11)) {
                    this.pessd[i] = true;
                }
                else {
                    this.pessd[i] = false;
                }
                if (Math.abs(lxm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(lym - this.by[i]) < 14 && n <= -1) {
                    n2 = i;
                    this.gs.mouses = 0;
                }
            }
        }
        if (this.conon == 1) {
            if (!this.regnow) {
                if (this.onjoin == -1) {
                    if (this.fase == 4) {
                        if (lxm > 532 && lxm < 592 && lym > 285 && lym < 306 && (n == 1 || n == 11)) {
                            this.pback = 1;
                        }
                        else {
                            this.pback = 0;
                        }
                        if (lxm > 532 && lxm < 592 && lym > 285 && lym < 306 && n <= -1) {
                            this.gs.mouses = 0;
                            this.m.trk = 0;
                            if (this.xt.loadedt) {
                                this.xt.strack.unload();
                            }
                            this.m.focus_point = 400;
                            this.m.crs = true;
                            this.m.x = -335;
                            this.m.y = 0;
                            this.m.z = -50;
                            this.m.xz = 0;
                            this.m.zy = 20;
                            this.m.ground = -2000;
                            this.fase = 1;
                        }
                        if (n2 == 0 && this.chalngd == -1) {
                            n2 = -1;
                            this.join = this.ongame;
                            this.msg = "| Joining Game |";
                            this.spos = 0;
                            this.m.trk = 0;
                            if (this.xt.loadedt) {
                                this.xt.strack.unload();
                            }
                            this.m.focus_point = 400;
                            this.m.crs = true;
                            this.m.x = -335;
                            this.m.y = 0;
                            this.m.z = -50;
                            this.m.xz = 0;
                            this.m.zy = 20;
                            this.m.ground = -2000;
                            this.fase = 1;
                        }
                    }
                    if (this.fase == 1) {
                        if (this.ongame == -1) {
                            if (n2 == 0) {
                                if (this.chalngd == -1) {
                                    if (this.xt.lan && !this.lanlogged) {
                                        this.gs.reglink();
                                    }
                                    else {
                                        boolean b = false;
                                        for (int j = 0; j < this.ngm; ++j) {
                                            if (this.wait[j] == 0) {
                                                b = true;
                                                break;
                                            }
                                        }
                                        if (!b || this.xt.lan) {
                                            this.loadstage = 0;
                                            this.remstage = 0;
                                            this.gstage = 0;
                                            this.gnpls = 8;
                                            this.gwait = 0;
                                            this.gnbts = 0;
                                            this.gclass = 0;
                                            this.gcars = 0;
                                            this.gfix = 0;
                                            this.gnotp = 0;
                                            this.gplayers = "";
                                            this.gs.wgame.select(0);
                                            this.chalngd = -2;
                                        }
                                        else {
                                            this.chalngd = -6;
                                        }
                                    }
                                }
                                else if (this.chalngd != -5) {
                                    if (this.invo) {
                                        this.invo = false;
                                    }
                                    for (int k = 0; k < 7; ++k) {
                                        if (!this.invos[k].equals("")) {
                                            this.invos[k] = "";
                                        }
                                        if (!this.dinvi[k].equals("")) {
                                            this.dinvi[k] = "";
                                        }
                                    }
                                    this.gs.swait.hide();
                                    this.gs.snpls.hide();
                                    this.gs.snbts.hide();
                                    this.gs.sgame.hide();
                                    this.gs.wgame.hide();
                                    this.gs.pgame.hide();
                                    this.gs.vnpls.hide();
                                    this.gs.vtyp.hide();
                                    this.gs.warb.hide();
                                    this.gs.mstgs.hide();
                                    this.gs.slaps.hide();
                                    this.gs.snfm1.hide();
                                    this.gs.snfmm.hide();
                                    this.gs.snfm2.hide();
                                    this.gs.sclass.hide();
                                    this.gs.scars.hide();
                                    this.gs.sfix.hide();
                                    this.gs.mycar.hide();
                                    this.gs.notp.hide();
                                    this.gs.requestFocus();
                                    this.chalngd = -1;
                                }
                            }
                            if (n2 == 1) {
                                this.xt.fase = 23;
                            }
                            if (n2 == 2) {
                                this.conon = 0;
                                this.lg.exitfromlobby();
                                try {
                                    this.socket.close();
                                    this.socket = null;
                                    this.din.close();
                                    this.din = null;
                                    this.dout.close();
                                    this.dout = null;
                                }
                                catch (Exception ex) {}
                                this.hideinputs();
                            }
                            int n3 = 3;
                            if (this.chalngd > -1) {
                                if (n2 == 3) {
                                    this.ongame = this.chalngd;
                                    this.chalngd = -1;
                                }
                                if (n2 == 4) {
                                    this.ongame = this.chalngd;
                                    this.join = this.chalngd;
                                    this.msg = "| Joining Game |";
                                    this.chalngd = -1;
                                    this.longame = -1;
                                }
                                if (n2 == 5) {
                                    this.ongame = this.longame;
                                    this.chalngd = -1;
                                    this.longame = -1;
                                }
                                n3 = 6;
                            }
                            else {
                                if (this.chalngd != -1 && this.chalngd != -5 && n2 == 3) {
                                    if (this.invo) {
                                        this.invo = false;
                                    }
                                    for (int l = 0; l < 7; ++l) {
                                        if (!this.invos[l].equals("")) {
                                            this.invos[l] = "";
                                        }
                                        if (!this.dinvi[l].equals("")) {
                                            this.dinvi[l] = "";
                                        }
                                    }
                                    this.gs.swait.hide();
                                    this.gs.snpls.hide();
                                    this.gs.snbts.hide();
                                    this.gs.sgame.hide();
                                    this.gs.wgame.hide();
                                    this.gs.pgame.hide();
                                    this.gs.vnpls.hide();
                                    this.gs.vtyp.hide();
                                    this.gs.warb.hide();
                                    this.gs.mstgs.hide();
                                    this.gs.slaps.hide();
                                    this.gs.snfm1.hide();
                                    this.gs.snfmm.hide();
                                    this.gs.snfm2.hide();
                                    this.gs.sclass.hide();
                                    this.gs.scars.hide();
                                    this.gs.sfix.hide();
                                    this.gs.mycar.hide();
                                    this.gs.notp.hide();
                                    this.gs.requestFocus();
                                    this.chalngd = -1;
                                }
                                if (this.chalngd == -6 && n2 == 4) {
                                    this.chalngd = -1;
                                }
                                if (this.chalngd == -2) {
                                    if (this.gs.wgame.getSelectedIndex() == 0) {
                                        if (this.gs.sgame.getSelectedIndex() >= 3 && !this.xt.logged) {
                                            if (n2 == 4) {
                                                this.gs.editlink(this.xt.nickname, true);
                                            }
                                            n3 = 5;
                                        }
                                        else {
                                            if (n2 == 4) {
                                                if (this.loadstage < 0) {
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.fillRect(0, 0, 670, 400);
                                                    this.gs.repaint();
                                                    this.gs.rooms.hide();
                                                    this.gs.cmsg.hide();
                                                    this.gs.sgame.hide();
                                                    this.gs.wgame.hide();
                                                    this.gs.warb.hide();
                                                    this.gs.pgame.hide();
                                                    this.gs.vnpls.hide();
                                                    this.gs.vtyp.hide();
                                                    this.gs.mstgs.hide();
                                                    this.gs.slaps.hide();
                                                    this.gs.snfm1.hide();
                                                    this.gs.snfmm.hide();
                                                    this.gs.snfm2.hide();
                                                    this.gs.requestFocus();
                                                    this.m.ptr = 0;
                                                    this.m.ptcnt = -10;
                                                    this.m.hit = 20000;
                                                    this.m.fallen = 0;
                                                    this.m.nrnd = 0;
                                                    this.m.ih = 25;
                                                    this.m.iw = 65;
                                                    this.m.h = 425;
                                                    this.m.w = 735;
                                                    this.m.trk = 4;
                                                    this.plsndt = 0;
                                                    this.addstage = 0;
                                                    this.fase = 4;
                                                }
                                                else {
                                                    this.sflk = 25;
                                                }
                                            }
                                            if (this.loadstage >= 0) {
                                                n3 = 5;
                                            }
                                            else {
                                                if (n2 == 5) {
                                                    if (this.gstage != 0) {
                                                        this.gs.sgame.hide();
                                                        this.gs.wgame.hide();
                                                        this.gs.pgame.hide();
                                                        this.gs.vnpls.hide();
                                                        this.gs.vtyp.hide();
                                                        this.gs.warb.hide();
                                                        this.gs.mstgs.hide();
                                                        this.gs.slaps.hide();
                                                        this.gs.snfm1.hide();
                                                        this.gs.snfmm.hide();
                                                        this.gs.snfm2.hide();
                                                        this.gs.requestFocus();
                                                        this.chalngd = -3;
                                                        n2 = -1;
                                                    }
                                                    else {
                                                        this.sflk = 25;
                                                    }
                                                }
                                                n3 = 6;
                                            }
                                        }
                                    }
                                    else if (!this.xt.clan.equals("")) {
                                        int n4 = 4;
                                        if (this.gs.warb.sel != 0 && this.gb.loadwbgames == 2) {
                                            if (this.gs.wgame.getSelectedIndex() == 1 && this.gs.vnpls.sel != 0 && this.cancreate == 2) {
                                                if (n2 == 4) {
                                                    if (this.invo) {
                                                        this.invo = false;
                                                    }
                                                    this.msg = "| Creating Game |";
                                                    this.gplayers = "#warb#" + this.gb.warb + "#" + this.gb.warbnum + "#" + (this.gb.gameturn + 1) + "#" + this.xt.clan + "#" + this.gb.vclan + "#" + this.gb.ascore + "#" + this.gb.vscore + "#" + (this.gs.vtyp.sel + 1) + "#";
                                                    this.gstage = this.gb.wbstage[this.gb.gameturn];
                                                    this.gstagelaps = this.gb.wblaps[this.gb.gameturn];
                                                    this.gcars = this.gb.wbcars[this.gb.gameturn] - 1;
                                                    this.gclass = this.gb.wbclass[this.gb.gameturn];
                                                    this.gfix = this.gb.wbfix[this.gb.gameturn];
                                                    this.gnpls = 8;
                                                    if (this.gs.vnpls.sel == 1) {
                                                        this.gnpls = 4;
                                                    }
                                                    if (this.gs.vnpls.sel == 2) {
                                                        this.gnpls = 6;
                                                    }
                                                    this.gwait = 120;
                                                    this.gnotp = 0;
                                                    this.gs.wgame.hide();
                                                    this.gs.pgame.hide();
                                                    this.gs.vnpls.hide();
                                                    this.gs.vtyp.hide();
                                                    this.gs.warb.hide();
                                                    this.gs.requestFocus();
                                                    this.chalngd = -5;
                                                }
                                                ++n4;
                                            }
                                            if (this.gs.wgame.getSelectedIndex() == 2 && this.gs.pgame.sel != 0 && n2 == 4) {
                                                if (this.invo) {
                                                    this.invo = false;
                                                }
                                                this.msg = "| Creating Game |";
                                                this.gstage = this.gb.wbstage[this.gs.pgame.sel - 1];
                                                this.gstagelaps = this.gb.wblaps[this.gs.pgame.sel - 1];
                                                this.gcars = this.gb.wbcars[this.gs.pgame.sel - 1] - 1;
                                                this.gclass = this.gb.wbclass[this.gs.pgame.sel - 1];
                                                this.gfix = this.gb.wbfix[this.gs.pgame.sel - 1];
                                                this.gnpls = 8;
                                                this.gwait = 120;
                                                this.gnotp = 0;
                                                this.gplayers = "";
                                                this.gs.wgame.hide();
                                                this.gs.pgame.hide();
                                                this.gs.vnpls.hide();
                                                this.gs.vtyp.hide();
                                                this.gs.warb.hide();
                                                this.gs.requestFocus();
                                                this.chalngd = -5;
                                            }
                                            if (this.gs.wgame.getSelectedIndex() == 1 && this.gb.canredo && n2 == n4) {
                                                this.gb.loadwbgames = 7;
                                            }
                                        }
                                    }
                                    else if (n2 == 4) {
                                        this.gb.tab = 3;
                                        this.gb.cfase = 2;
                                        this.gb.em = 1;
                                        this.gb.msg = "Clan Search";
                                        this.gb.smsg = "Listing clans with recent activity...";
                                        this.gb.nclns = 0;
                                        this.gb.spos5 = 0;
                                        this.gb.lspos5 = 0;
                                        this.gb.flko = 0;
                                        this.gb.open = 2;
                                        this.gb.upo = true;
                                    }
                                }
                                if (this.chalngd == -3) {
                                    if (n2 == 4) {
                                        this.chalngd = -2;
                                        this.gs.snpls.hide();
                                        this.gs.snbts.hide();
                                        this.gs.swait.hide();
                                        this.gs.requestFocus();
                                    }
                                    if (n2 == 5) {
                                        if (this.gnpls != 0 && this.gs.snpls.getSelectedIndex() != 0) {
                                            this.chalngd = -4;
                                            for (int n5 = 0; n5 < 7; ++n5) {
                                                if (!this.invos[n5].equals("")) {
                                                    this.invos[n5] = "";
                                                }
                                                if (!this.dinvi[n5].equals("")) {
                                                    this.dinvi[n5] = "";
                                                }
                                            }
                                            n2 = -1;
                                            this.gs.snpls.hide();
                                            this.gs.snbts.hide();
                                            this.gs.swait.hide();
                                            this.gs.requestFocus();
                                        }
                                        else {
                                            this.sflk = 25;
                                        }
                                    }
                                    n3 = 6;
                                }
                                if (this.chalngd == -4) {
                                    n3 = 7;
                                    int n6 = 0;
                                    for (int n7 = 0; n7 < 7; ++n7) {
                                        if (!this.invos[n7].equals("")) {
                                            ++n6;
                                        }
                                    }
                                    if (n6 < this.gnpls - 1) {
                                        if (n2 == 4) {
                                            if (!this.invo) {
                                                this.invo = true;
                                            }
                                            else {
                                                this.invo = false;
                                            }
                                        }
                                    }
                                    else {
                                        n3 = 6;
                                    }
                                    if (n2 == n3 - 2) {
                                        if (this.invo) {
                                            this.invo = false;
                                        }
                                        if (this.gs.mycar.getState() && this.xt.sc[0] < 16) {
                                            this.gclass = -(this.xt.sc[0] + 2);
                                            this.gcars = 0;
                                        }
                                        if (this.gs.notp.getState()) {
                                            this.gnotp = 1;
                                        }
                                        else {
                                            this.gnotp = 0;
                                        }
                                        this.gplayers = "";
                                        this.gs.sclass.hide();
                                        this.gs.scars.hide();
                                        this.gs.sfix.hide();
                                        this.gs.mycar.hide();
                                        this.gs.notp.hide();
                                        this.gs.requestFocus();
                                        this.chalngd = -3;
                                    }
                                    if (n2 == n3 - 1) {
                                        if (this.invo) {
                                            this.invo = false;
                                        }
                                        this.msg = "| Creating Game |";
                                        if (this.gs.mycar.getState() && this.xt.sc[0] < 16) {
                                            this.gclass = -(this.xt.sc[0] + 2);
                                            this.gcars = 0;
                                        }
                                        if (this.gclass != 0) {
                                            this.gwait = 120;
                                        }
                                        if (this.gs.notp.getState()) {
                                            this.gnotp = 1;
                                        }
                                        else {
                                            this.gnotp = 0;
                                        }
                                        this.gplayers = "";
                                        if (n6 != 0) {
                                            this.gnpls = n6 + 1;
                                            this.gplayers = "" + this.pnames[this.im] + "#";
                                            for (int n8 = 0; n8 < n6; ++n8) {
                                                this.gplayers = this.gplayers + this.invos[n8] + "#";
                                            }
                                        }
                                        this.gs.sclass.hide();
                                        this.gs.scars.hide();
                                        this.gs.sfix.hide();
                                        this.gs.mycar.hide();
                                        this.gs.notp.hide();
                                        this.gs.requestFocus();
                                        this.chalngd = -5;
                                    }
                                }
                            }
                            if (n2 == n3 && !this.xt.lan && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
                                String replace = this.gs.cmsg.getText().replace('|', ':');
                                if (replace.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                                    replace = " ";
                                }
                                if (!this.xt.msgcheck(replace) && this.updatec > -12) {
                                    for (int n9 = 0; n9 < 6; ++n9) {
                                        this.sentn[n9] = this.sentn[n9 + 1];
                                        this.cnames[n9] = this.cnames[n9 + 1];
                                    }
                                    this.sentn[6] = replace;
                                    this.cnames[6] = this.pnames[this.im];
                                    if (this.updatec > -11) {
                                        this.updatec = -11;
                                    }
                                    else {
                                        --this.updatec;
                                    }
                                    this.spos3 = 28;
                                }
                                else {
                                    final xtGraphics xt = this.xt;
                                    ++xt.warning;
                                }
                                this.gs.cmsg.setText("");
                            }
                        }
                        else if (this.dispcar == -1) {
                            int n10 = 0;
                            for (int n11 = 0; n11 < this.ngm; ++n11) {
                                if (this.ongame == this.gnum[n11]) {
                                    n10 = n11;
                                }
                            }
                            boolean b2 = false;
                            if (this.gwarb[n10] == 0) {
                                if (!this.gplyrs[n10].equals("") && this.gplyrs[n10].indexOf(this.pnames[this.im]) == -1) {
                                    b2 = true;
                                }
                            }
                            else if (!this.xt.clan.toLowerCase().equals(this.gaclan[n10].toLowerCase()) && !this.xt.clan.toLowerCase().equals(this.gvclan[n10].toLowerCase())) {
                                b2 = true;
                            }
                            if (control.enter && this.wait[n10] > 0 && this.pgames[this.im] == -1 && !b2) {
                                this.join = this.ongame;
                                this.msg = "| Joining Game |";
                                this.spos = 0;
                                if (this.pbtn == 0) {
                                    this.pessd[1] = true;
                                }
                            }
                            if (this.wait[n10] == -1 && this.pgames[this.im] == -1 && control.enter) {
                                n2 = 0;
                                this.pessd[0] = true;
                            }
                            if (this.pgames[this.im] == -1 && control.exit) {
                                n2 = 0;
                                this.pessd[0] = true;
                            }
                            if (n2 == 0) {
                                if (this.pgames[this.im] == -1) {
                                    this.ongame = -1;
                                    this.chalngd = -1;
                                }
                                else {
                                    this.join = -2;
                                    this.msg = "| Leaving Game |";
                                    this.longame = -1;
                                }
                            }
                            if (this.pbtn == 0) {
                                if (n2 == 1) {
                                    if (this.wait[n10] > 0) {
                                        if (this.pgames[this.im] == -1) {
                                            this.join = this.ongame;
                                            this.msg = "| Joining Game |";
                                            this.spos = 0;
                                        }
                                        else if (this.gmaker[n10].equals(this.pnames[this.im]) && this.npls[n10] > 1) {
                                            this.fstart = true;
                                        }
                                        else {
                                            n2 = 2;
                                        }
                                    }
                                    else {
                                        if (this.wait[n10] == 0 && this.prevloaded == 1) {
                                            this.laps = this.gnlaps[n10];
                                            this.stage = this.gstgn[n10];
                                            this.stagename = this.gstages[n10];
                                            this.nfix = this.gfx[n10];
                                            if (this.gntb[n10] == 1) {
                                                this.notb = true;
                                            }
                                            else {
                                                this.notb = false;
                                            }
                                            this.gs.setCursor(new Cursor(3));
                                            this.conon = 3;
                                        }
                                        else {
                                            n2 = 2;
                                        }
                                        if (this.wait[n10] == 0 && this.xt.lan) {
                                            this.laps = this.gnlaps[n10];
                                            this.stage = this.gstgn[n10];
                                            this.stagename = this.gstages[n10];
                                            this.nfix = this.gfx[n10];
                                            if (this.gntb[n10] == 1) {
                                                this.notb = true;
                                            }
                                            else {
                                                this.notb = false;
                                            }
                                            this.gs.setCursor(new Cursor(3));
                                            this.conon = 3;
                                        }
                                    }
                                }
                                if (n2 == 2 && !this.xt.lan && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
                                    String replace2 = this.gs.cmsg.getText().replace('|', ':');
                                    if (replace2.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                                        replace2 = " ";
                                    }
                                    if (!this.xt.msgcheck(replace2) && this.updatec > -12) {
                                        for (int n12 = 0; n12 < 6; ++n12) {
                                            this.sentn[n12] = this.sentn[n12 + 1];
                                            this.cnames[n12] = this.cnames[n12 + 1];
                                        }
                                        this.sentn[6] = replace2;
                                        this.cnames[6] = this.pnames[this.im];
                                        if (this.updatec > -11) {
                                            this.updatec = -11;
                                        }
                                        else {
                                            --this.updatec;
                                        }
                                    }
                                    else {
                                        final xtGraphics xt2 = this.xt;
                                        ++xt2.warning;
                                    }
                                    this.gs.cmsg.setText("");
                                }
                            }
                            if (this.pbtn == 1 && n2 == 1) {
                                if (this.pgames[this.im] == -1) {
                                    this.join = this.ongame;
                                    this.msg = "| Joining Game |";
                                    this.spos = 0;
                                }
                                else if (!this.invo) {
                                    this.invo = true;
                                }
                                else {
                                    this.invo = false;
                                }
                            }
                            if (this.pbtn == 2 && (n2 == 1 || n2 == 2)) {
                                this.fase = 2;
                                this.m.ptr = 0;
                                this.m.ptcnt = -10;
                                this.m.hit = 20000;
                                this.m.fallen = 500;
                                this.m.nrnd = 0;
                                this.m.ih = 25;
                                this.m.iw = 65;
                                this.m.h = 425;
                                this.m.w = 735;
                                this.m.trk = 4;
                                this.plsndt = 0;
                                if (this.gs.cmsg.isShowing()) {
                                    this.gs.cmsg.hide();
                                    this.gs.requestFocus();
                                }
                            }
                        }
                        else {
                            if (n2 == 0) {
                                if (this.pgames[this.im] == -1) {
                                    this.ongame = -1;
                                    this.chalngd = -1;
                                }
                                else {
                                    this.join = -2;
                                    this.msg = "| Leaving Game |";
                                    this.longame = -1;
                                }
                            }
                            if (this.pbtn == 1 && n2 == 1) {
                                if (this.pgames[this.im] == -1) {
                                    this.join = this.ongame;
                                    this.msg = "| Joining Game |";
                                    this.spos = 0;
                                }
                                else if (!this.invo) {
                                    this.invo = true;
                                }
                                else {
                                    this.invo = false;
                                }
                            }
                        }
                    }
                }
                else if (this.ontyp != 76) {
                    if (n2 == 0) {
                        if (this.ontyp < 30) {
                            this.xt.onjoin = this.onjoin;
                            this.xt.ontyp = this.ontyp;
                            this.xt.playingame = -101;
                            this.xt.fase = 23;
                        }
                        else {
                            if (!this.gb.claname.equals(this.xt.clan)) {
                                this.gb.claname = this.xt.clan;
                                this.gb.loadedc = false;
                            }
                            this.gb.spos5 = 0;
                            this.gb.lspos5 = 0;
                            this.gb.cfase = 3;
                            this.gb.loadedcars = -1;
                            this.gb.loadedcar = 0;
                            this.gb.ctab = 2;
                            this.gb.tab = 3;
                            this.gb.open = 2;
                            this.gb.upo = true;
                            this.onjoin = -1;
                        }
                    }
                    if (n2 == 1) {
                        this.onjoin = -1;
                    }
                }
                else {
                    if (n2 == 0) {
                        this.gs.editlink(this.xt.nickname, true);
                        this.onjoin = -1;
                    }
                    if (n2 == 1) {
                        this.onjoin = -1;
                    }
                }
            }
            else {
                if (n2 == 0) {
                    this.gs.editlink(this.xt.nickname, true);
                }
                if (n2 == 1) {
                    this.regnow = false;
                }
            }
        }
        this.lxm = lxm;
        this.lym = lym;
        control.enter = false;
        control.exit = false;
    }

    public void hideinputs() {
        this.gs.cmsg.hide();
        this.gs.swait.hide();
        this.gs.snpls.hide();
        this.gs.snbts.hide();
        this.gs.sgame.hide();
        this.gs.wgame.hide();
        this.gs.pgame.hide();
        this.gs.vnpls.hide();
        this.gs.vtyp.hide();
        this.gs.warb.hide();
        this.gs.mstgs.hide();
        this.gs.snfm1.hide();
        this.gs.snfmm.hide();
        this.gs.slaps.hide();
        this.gs.snfm2.hide();
        this.gs.sclass.hide();
        this.gs.scars.hide();
        this.gs.sfix.hide();
        this.gs.mycar.hide();
        this.gs.notp.hide();
        this.gs.rooms.hide();
        this.gs.requestFocus();
    }

    public void drawSbutton(final Image image, final int n, final int n2) {
        this.bx[this.btn] = n;
        this.by[this.btn] = n2;
        this.bw[this.btn] = image.getWidth(this.ob);
        if (!this.pessd[this.btn]) {
            this.rd.drawImage(image, n - this.bw[this.btn] / 2, n2 - image.getHeight(this.ob) / 2 - 1, null);
            this.rd.drawImage(this.xt.bols, n - this.bw[this.btn] / 2 - 15, n2 - 13, null);
            this.rd.drawImage(this.xt.bors, n + this.bw[this.btn] / 2 + 9, n2 - 13, null);
            this.rd.drawImage(this.xt.bot, n - this.bw[this.btn] / 2 - 9, n2 - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bob, n - this.bw[this.btn] / 2 - 9, n2 + 10, this.bw[this.btn] + 18, 3, null);
        }
        else {
            this.rd.drawImage(image, n - this.bw[this.btn] / 2 + 1, n2 - image.getHeight(this.ob) / 2, null);
            this.rd.drawImage(this.xt.bolps, n - this.bw[this.btn] / 2 - 15, n2 - 13, null);
            this.rd.drawImage(this.xt.borps, n + this.bw[this.btn] / 2 + 9, n2 - 13, null);
            this.rd.drawImage(this.xt.bob, n - this.bw[this.btn] / 2 - 9, n2 - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bot, n - this.bw[this.btn] / 2 - 9, n2 + 10, this.bw[this.btn] + 18, 3, null);
        }
        ++this.btn;
    }

    public void stringbutton(final String s, final int n, final int n2, final int n3) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        this.bx[this.btn] = n;
        this.by[this.btn] = n2 - 5;
        this.bw[this.btn] = this.ftm.stringWidth(s);
        if (!this.pessd[this.btn]) {
            this.rd.setColor(this.color2k(220, 220, 220));
            this.rd.fillRect(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), this.bw[this.btn] + 20, 25 - n3 * 2);
            this.rd.setColor(this.color2k(240, 240, 240));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (18 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (18 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 - (19 - n3), n + this.bw[this.btn] / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(this.color2k(200, 200, 200));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 11, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 11, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 12, n2 - (16 - n3), n + this.bw[this.btn] / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (8 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (8 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 + (9 - n3), n + this.bw[this.btn] / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(this.color2k(240, 240, 240));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 11, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 11, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 12, n2 - (16 - n3), n - this.bw[this.btn] / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, n - this.bw[this.btn] / 2, n2);
        }
        else {
            this.rd.setColor(this.color2k(210, 210, 210));
            this.rd.fillRect(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), this.bw[this.btn] + 20, 25 - n3 * 2);
            this.rd.setColor(this.color2k(200, 200, 200));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (18 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (18 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 - (19 - n3), n + this.bw[this.btn] / 2 + 9, n2 - (19 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 11, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 11, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 12, n2 - (16 - n3), n + this.bw[this.btn] / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (8 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (8 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 + (9 - n3), n + this.bw[this.btn] / 2 + 9, n2 + (9 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 11, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 11, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 12, n2 - (16 - n3), n - this.bw[this.btn] / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, n - this.bw[this.btn] / 2 + 1, n2);
        }
        ++this.btn;
    }

    public Color color2k(final int n, final int n2, final int n3) {
        final Color color = new Color(n, n2, n3);
        final float[] array = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), array);
        array[0] = 0.13f;
        array[1] = 0.35f;
        return Color.getHSBColor(array[0], array[1], array[2]);
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

    public int getHvalue(final String s, final int n) {
        int intValue = -1;
        try {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            String string = "";
            while (n2 < s.length() && n4 != 2) {
                final String string2 = "" + s.charAt(n2);
                if (string2.equals("#")) {
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

    public String getHSvalue(final String s, final int n) {
        String s2 = "";
        try {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            String string = "";
            while (n2 < s.length() && n4 != 2) {
                final String string2 = "" + s.charAt(n2);
                if (string2.equals("#")) {
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

    public String getSevervalue(final String s, final int n) {
        String s2 = "";
        if (!s.equals("")) {
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
            catch (Exception ex) {
                s2 = "";
            }
        }
        return s2;
    }
}
