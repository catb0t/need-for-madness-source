import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.FileReader;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.zip.ZipInputStream;
import java.net.URL;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.image.ImageObserver;
import java.io.File;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.applet.Applet;

public class StageMaker extends Applet implements Runnable
{
    Graphics2D rd;
    Image offImage;
    Thread thredo;
    boolean exwist;
    FontMetrics ftm;
    int apx;
    int apy;
    String sstage;
    String suser;
    int tab;
    int tabed;
    Image[] btgame;
    Image logo;
    boolean onbtgame;
    boolean focuson;
    boolean overcan;
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    boolean zoomi;
    boolean zoomo;
    String stagename;
    String tstage;
    String bstage;
    String[] undos;
    int nundo;
    Medium m;
    CheckPoints cp;
    Trackers t;
    ContO[] bco;
    ContO[] co;
    int nob;
    int xnob;
    int errd;
    int origfade;
    int sfase;
    Smenu slstage;
    TextField srch;
    Smenu strtyp;
    Smenu ptyp;
    Smenu part;
    int sptyp;
    int spart;
    int sp;
    int lsp;
    int seq;
    boolean setcur;
    boolean epart;
    boolean arrng;
    int esp;
    int hi;
    int arrcnt;
    int chi;
    boolean seqn;
    int rot;
    int adrot;
    Image[] su;
    Image[] sl;
    Image[] sd;
    Image[] sr;
    Image[] zi;
    Image[] zo;
    boolean pgen;
    float pwd;
    float phd;
    int fgen;
    int sx;
    int sz;
    int sy;
    TextField fixh;
    int hf;
    int[][] atp;
    String[] discp;
    String[] errlo;
    int[] rcheckp;
    int[] ocheckp;
    boolean onoff;
    boolean onfly;
    int flyh;
    int[] csky;
    int[] cgrnd;
    int[] cfade;
    int[] texture;
    int[] cldd;
    TextField mgen;
    int vxz;
    int vx;
    int vz;
    int vy;
    int dtab;
    int dtabed;
    int mouseon;
    float[][] hsb;
    Checkbox pfog;
    int[] snap;
    int[] fogn;
    Smenu nlaps;
    Smenu tracks;
    String trackname;
    String ltrackname;
    int trackvol;
    int tracksize;
    RadicalMod track;
    int avon;
    Smenu witho;
    int logged;
    TextField tnick;
    TextField tpass;
    Smenu pubitem;
    Smenu pubtyp;
    int nms;
    int roto;
    String[] mystages;
    String[] maker;
    int[] pubt;
    String[][] addeda;
    int[] nad;
    String justpubd;
    boolean[] pessd;
    int[] bx;
    int[] by;
    int[] bw;
    int btn;
    int mouses;
    int xm;
    int ym;
    int lxm;
    int lym;
    int cntout;
    boolean preop;
    boolean mousdr;
    String ttstage;
    
    public StageMaker() {
        this.exwist = false;
        this.apx = 0;
        this.apy = 0;
        this.sstage = "";
        this.suser = "Horaks";
        this.tab = 0;
        this.tabed = -1;
        this.btgame = new Image[2];
        this.onbtgame = false;
        this.focuson = true;
        this.overcan = false;
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.zoomi = false;
        this.zoomo = false;
        this.stagename = "";
        this.tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\n\rmountains(" + (int)(Math.random() * 100000.0) + ")\r\nnlaps(5)\r\n\r\n";
        this.bstage = "set(47,0,0,0)\r\nmaxr(11,28500,-5600)\r\nmaxb(9,-8000,-12300)\r\nmaxl(11,-14700,-5600)\r\nmaxt(9,44800,-12300)\r\n";
        this.undos = new String[5000];
        this.nundo = 0;
        this.m = new Medium();
        this.cp = new CheckPoints();
        this.t = new Trackers();
        this.bco = new ContO[67];
        this.co = new ContO[601];
        this.nob = 0;
        this.xnob = 0;
        this.errd = 0;
        this.origfade = 5000;
        this.sfase = 0;
        this.slstage = new Smenu(2000);
        this.srch = new TextField("", 38);
        this.strtyp = new Smenu(40);
        this.ptyp = new Smenu(40);
        this.part = new Smenu(40);
        this.sptyp = 0;
        this.spart = 0;
        this.sp = 0;
        this.lsp = -1;
        this.seq = 0;
        this.setcur = false;
        this.epart = false;
        this.arrng = false;
        this.esp = -1;
        this.hi = -1;
        this.arrcnt = 0;
        this.chi = -1;
        this.seqn = false;
        this.rot = 0;
        this.adrot = 0;
        this.su = new Image[2];
        this.sl = new Image[2];
        this.sd = new Image[2];
        this.sr = new Image[2];
        this.zi = new Image[2];
        this.zo = new Image[2];
        this.pgen = false;
        this.pwd = 2L + Math.round(Math.random() * 4.0);
        this.phd = 2L + Math.round(Math.random() * 4.0);
        this.fgen = 0;
        this.sx = 0;
        this.sz = 1500;
        this.sy = -10000;
        this.fixh = new TextField("2000", 5);
        this.hf = 2000;
        this.atp = new int[][] { { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 1520, 2830, -1520, -2830 }, { -1520, 2830, 1520, -2830 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 560, 0, -560 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 385, 980, 385, -980 }, { 0, 0, 0, -600 }, { 0, 0, 0, 0 }, { 0, 2164, 0, -2164 }, { 0, 2164, 0, -2164 }, { 0, 3309, 0, -1680 }, { 0, 1680, 0, -3309 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1810, 980, 1810, -980 }, { 0, 0, 0, 0 }, { 0, 500, 0, -500 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 1680, 0, -3309 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 700, 1400, 700, -1400 }, { 0, -1480, 0, -1480 }, { 0, 0, 0, 0 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 700, 0, -700, 0 }, { 0, 0, 0, 0 }, { 0, -2198, 0, 1482 }, { 0, -1319, 0, 1391 }, { 0, -1894, 0, 2271 }, { 0, -826, 0, 839 }, { 0, -1400, 0, 1400 }, { 0, -1400, 0, 1400 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        this.discp = new String[] { "NormalRoad :  Basic asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',  'NormalRoad Edged',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad Edged :  Asphalt road with edged side blocks (a destructive road).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad TwistedRight :  Asphalt road twisted towards the right.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad Twistedleft',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad TwistedLeft :  Asphalt road twisted towards the left.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad Turn :  Asphalt corner road turn.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp', 'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "OffRoad :  Basic sandy dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "OffRoad BumpyGreen :  Dirt-road with bumpy greenery in the middle.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "OffRoad Turn :  Dirt-road corner turn.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand 'Normal-Off-Road Blend'\n\n", "HalfpipeRoad :  Basic road for the half-pipe ramp.\nAttaches correctly to the following other parts :\n\n'Off-Halfpipe-Road Blend',  'HalfpipeRoad',  'HalfpipeRoad Turn',  'HalfpipeRoad-Ramp Filler'\nand  'Halfpipe-Normal-Road Blend'\n\n", "HalfpipeRoad Turn :  Half-pipe corner road turn.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'  and  'Halfpipe-Normal-Road Blend'\n\n", "Normal-Off-Road Blend :  Road blend between the normal asphalt road and the dirt-road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp', 'Halfpipe-Normal-Road Blend' 'OffRoad',  'OffRoad Turn',\n'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start'  and  'Off-Halfpipe-Road Blend'\n\n", "Off-Halfpipe-Road Blend :  Road blend between the dirt-road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',\n'HalfpipeRoad',  'HalfpipeRoad Turn',  'Halfpipe-Normal-Road Blend'  and  'Normal-Off-Road Blend'\n\n", "Halfpipe-Normal-Road Blend :  Road blend between the normal asphalt road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp',  'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'\nand  'Off-Halfpipe-Road Blend'\n\n", "NormalRoad End :  The end part of the normal asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "OffRoad End :  The end part of the dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "HalfpipeRoad-Ramp Filler :  A part that gets placed between the half-pipe road and the half-pipe ramp to extend the distance in between.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad'  and  'Halfpipe'\n\n", "Basic Ramp :  Basic 30 degree asphalt ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Crash Ramp :  A 35 degree ramp with big side blocks for crashing into.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Two-Way Ramp :  Two way 15 degree inclined ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Two-Way High-Low Ramp :  Two way 15 degree inclined ramp, with peeked side for an optional higher car jump.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Landing Ramp :  A ramp that is both a landing inclination and an obstacle as well, it is usually placed just after another normal ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Big-Takeoff Ramp:  A big takeoff ramp for getting huge heights with the cars.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Small Ramp :  A small ramp that can be placed on either side of the road.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Offroad Bump Ramp :  A small bump ramp that is to be placed over the off-road dirt tracks.\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Offroad Big Ramp :  The big off-road dirt mountain like ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Offroad Ramp :  Normal sized off-road dirt track ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Halfpipe :  The Half-pipe ramp, two of these ramps opposite each other create a half-pipe for the cars!\nAttaches correctly over and to the following other parts :\n\n'HalfpipeRoad',  'HalfpipeRoad Turn'  and  'HalfpipeRoad-Ramp Filler'\n\n", "Spiky Pillars :  An obstacle that is usually placed after a ramp for the cars to crash onto if they did not jump high or far enough!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Rail Doorway :  A rail doorway that works as an obstacle for cars flying above it or cars driving through it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "The Wall", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "Fixing Hoop :  The fixing hoop that fixes a car when it flies through it! You can add a max of 5 fixing hoops per stage.\nPlace it anywhere in the stage at an height your choose, the only important thing is that it needs to be reachable by the cars.", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "OffRoad BumpySides :  Off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad-BumpySides Start'\n\n", "OffRoad-BumpySides Start: The start of the off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides',\n'Off-Halfpipe-Road Blend'  and  'Normal-Off-Road Blend'\n\n", "NormalRoad-Raised Ramp:  The start of the raised above the ground road (NormalRoad Raised).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight'  and  'NormalRoad Raised'\n\n", "NormalRoad Raised :  Normal road raised above the ground, cars must avoid falling off it when driving on it.\nAttaches correctly to the following other parts :\n\n'NormalRoad-Raised Ramp'\n\n", "The Start1", "The Start2", "Tunnel Side Ramp:  A ramp that can be used to create a tunnel like road with an open top or can be used as a wall ramp!\nAttaches correctly over only the 'NormalRoad' part.", "Launch Pad Ramp:  A ramp that launches your car fully upwards like a rocket, it also has sides to lock any car climbing it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "The Net:  An obstacle part that is to be placed in the center of the road right after a ramp, the idea is that the\ncars jumping the ramp should try to go over it or through it without getting caught crashing (without getting\ncaught in it, getting caught in the net!).\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Speed Ramp:  A ramp that is designed to have the perfect angle to catapult your car the furthest when doing forward loops, it is half the roads width.\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Offroad Hill Ramp:  An offroad hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Bump Slide:  A small bump obstacle that is to be placed on the sides of the road or in the center.\nAttaches correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Offroad Big Hill Ramp:  An offroad big hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Rollercoaster Start/End:  The ramp that starts the Rollercoaster Road and ends it.\nAttaches correctly over and to following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n 'NormalRoad TwistedRight'  and  'Rollercoaster Start/End'\n\n", "Rollercoaster Road1\nAttaches correctly to only 'Rollercoaster Start/End', 'Rollercoaster Road2' and itself.\n\n", "Rollercoaster Road3\nAttaches correctly to only 'Rollercoaster Road2', 'Rollercoaster Road4' and itself.\n\n", "Rollercoaster Road4\nAttaches correctly to only 'Rollercoaster Road3', 'Rollercoaster Road5' and itself.\n\n", "Rollercoaster Road2\nAttaches correctly to only 'Rollercoaster Road1', 'Rollercoaster Road3' and itself.\n\n", "Rollercoaster Road5\nAttaches correctly to only 'Rollercoaster Road4' and itself.\n\n", "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n", "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Ground Piles are to be paced outside the race track on the ground and NEVER on any road part or ramp!\nThey are to be used as ground decoration and out of race course obstacles (ground obstacles)!\n\n" };
        this.errlo = new String[] { "The maximum allocated memory for the stage's part's details has been exerted.\nPlease decrease the amount of parts in the stage that have more details then average.", "The maximum amount of road points allowed in the track has been exceeded.\nPlease remove some of the road parts that are in the circler path of the track (the parts that are between the checkpoints).\nOr try to remove some of the extra checkpoints in the track as well.", "The maximum allowed area for a track (the area in between its walls) has been exceeded.\nPlease try to place parts only inside the current allowed area, inside the area between the current maximum wall placements.", "The maximum number of parts allowed per stage has been exceeded.\nPlease remove some of the already extra parts placed in order to make space.", "The maximum number of Fixing Hoops allowed per stage is 5!\nPlease remove the extra Fixing Hoops from your stage to have only 5 main ones left.", "Unknown Error, please make sure the stage you are handling is saved correctly.\nPlease go to the 'Build' tab and press 'Save & Preview'.", "There needs to be at least 2 checkpoints in the Stage in order for the game to work.\nPlease go to the 'Build' tab and select 'Checkpoint' in the Part Selection menu to add more checkpoints.", "The name of the stage is too long!\nPlease go to the 'Stage' tab, click 'Rename Stage' and give your stage a shorter name." };
        this.rcheckp = new int[] { 0, 1, 2, 3, 4, 12, 13, 37 };
        this.ocheckp = new int[] { 5, 6, 7, 11, 14, 33, 34, 38 };
        this.onoff = false;
        this.onfly = false;
        this.flyh = 0;
        this.csky = new int[] { 170, 220, 255 };
        this.cgrnd = new int[] { 205, 200, 200 };
        this.cfade = new int[] { 255, 220, 220 };
        this.texture = new int[] { 0, 0, 0, 10 };
        this.cldd = new int[] { 210, 210, 210, 1, -1000 };
        this.mgen = new TextField("", 10);
        this.vxz = 0;
        this.vx = 0;
        this.vz = 0;
        this.vy = 0;
        this.dtab = 0;
        this.dtabed = -1;
        this.mouseon = -1;
        this.hsb = new float[][] { { 0.5f, 0.875f, 0.5f }, { 0.5f, 0.875f, 0.5f }, { 0.5f, 0.875f, 0.5f } };
        this.pfog = new Checkbox("Linked Blend");
        this.snap = new int[] { 50, 50, 50 };
        this.fogn = new int[] { 60, 0 };
        this.nlaps = new Smenu(40);
        this.tracks = new Smenu(2000);
        this.trackname = "";
        this.ltrackname = "";
        this.trackvol = 200;
        this.tracksize = 111;
        this.track = new RadicalMod();
        this.avon = 0;
        this.witho = new Smenu(40);
        this.logged = 0;
        this.tnick = new TextField("", 15);
        this.tpass = new TextField("", 15);
        this.pubitem = new Smenu(707);
        this.pubtyp = new Smenu(40);
        this.nms = 0;
        this.roto = 0;
        this.mystages = new String[20];
        this.maker = new String[20];
        this.pubt = new int[20];
        this.addeda = new String[20][5000];
        this.nad = new int[20];
        this.justpubd = "";
        this.pessd = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
        this.bx = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.by = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.bw = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.btn = 0;
        this.mouses = 0;
        this.xm = 0;
        this.ym = 0;
        this.lxm = 0;
        this.lym = 0;
        this.cntout = 0;
        this.preop = false;
        this.mousdr = false;
        this.ttstage = "";
    }
    
    @Override
    public void run() {
        this.thredo.setPriority(10);
        this.btgame[0] = this.getImage("" + Madness.fpath + "data/backtogame1.gif");
        this.btgame[1] = this.getImage("" + Madness.fpath + "data/backtogame2.gif");
        this.logo = this.getImage("" + Madness.fpath + "data/stagemakerlogo.gif");
        for (int i = 0; i < 2; ++i) {
            this.su[i] = this.getImage("" + Madness.fpath + "data/su" + (i + 1) + ".gif");
            this.sl[i] = this.getImage("" + Madness.fpath + "data/sl" + (i + 1) + ".gif");
            this.sd[i] = this.getImage("" + Madness.fpath + "data/sd" + (i + 1) + ".gif");
            this.sr[i] = this.getImage("" + Madness.fpath + "data/sr" + (i + 1) + ".gif");
            this.zi[i] = this.getImage("" + Madness.fpath + "data/zi" + (i + 1) + ".gif");
            this.zo[i] = this.getImage("" + Madness.fpath + "data/zo" + (i + 1) + ".gif");
        }
        this.loadbase();
        this.loadsettings();
        if (Madness.testdrive != 0) {
            if (!Madness.testcar.equals("Failx12")) {
                this.stagename = Madness.testcar;
                this.errd = 0;
                this.readstage(3);
                if (this.errd == 0) {
                    this.tab = 2;
                    this.dtab = 6;
                    this.witho.select(Madness.testdrive - 3);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Failed to load stage! Please make sure stage is saved properly before Test Drive.", "Stage Maker", 1);
                this.thredo.stop();
            }
            Madness.testcar = "";
            Madness.testdrive = 0;
        }
        this.requestFocus();
        while (!this.exwist) {
            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(0, 25, 800, 525);
            this.rd.setColor(new Color(0, 0, 0));
            if (this.tab != this.tabed) {
                this.hidefields();
            }
            if (this.tab == 0) {
                if (this.tabed != this.tab) {
                    this.slstage.removeAll();
                    this.slstage.maxl = 360;
                    this.slstage.add(this.rd, "Select a Stage                      ");
                    final String[] list = new File("" + Madness.fpath + "mystages/").list();
                    if (list != null) {
                        for (int j = 0; j < list.length; ++j) {
                            if (list[j].toLowerCase().endsWith(".txt")) {
                                this.slstage.add(this.rd, list[j].substring(0, list[j].length() - 4));
                            }
                        }
                    }
                    if (!this.stagename.equals("")) {
                        this.slstage.select(this.stagename);
                        if (!this.stagename.equals(this.slstage.getSelectedItem())) {
                            this.stagename = "";
                            this.slstage.select(0);
                        }
                        else {
                            this.readstage(3);
                            this.sx = 0;
                            this.sz = 1500;
                            this.sy = -10000;
                        }
                    }
                    else {
                        this.slstage.select(0);
                    }
                    this.mouseon = -1;
                    this.sfase = 0;
                }
                this.rd.drawImage(this.logo, 261, 35, null);
                Label_1093: {
                    if (this.xm > 261) {
                        if (this.xm < 538) {
                            if (this.ym > 35) {
                                if (this.ym < 121) {
                                    if (this.mouseon != -1) {
                                        break Label_1093;
                                    }
                                    this.mouseon = 3;
                                    this.setCursor(new Cursor(12));
                                    break Label_1093;
                                }
                            }
                        }
                    }
                    if (this.mouseon == 3) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                }
                if (this.mouseon == 3) {
                    if (this.mouses == -1) {
                        this.openhlink();
                    }
                }
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                Label_1290: {
                    if (this.xm > 200) {
                        if (this.xm < 550) {
                            if (this.ym > 467) {
                                if (this.ym < 504) {
                                    if (this.mouseon != -1) {
                                        break Label_1290;
                                    }
                                    this.mouseon = 2;
                                    this.setCursor(new Cursor(12));
                                    break Label_1290;
                                }
                            }
                        }
                    }
                    if (this.mouseon == 2) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                }
                if (this.mouseon != 2) {
                    this.rd.setColor(new Color(0, 0, 0));
                }
                else {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                this.rd.drawString("For the Stage Maker Homepage, Development Center and Forums :", 400 - this.ftm.stringWidth("For the Stage Maker Homepage, Development Center and Forums :") / 2, 480);
                this.rd.setColor(new Color(0, 128, 255));
                final String s = "http://www.needformadness.com/developer/";
                this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2, 500);
                if (this.mouseon != 2) {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                else {
                    this.rd.setColor(new Color(0, 128, 255));
                }
                this.rd.drawLine(400 - this.ftm.stringWidth(s) / 2, 501, 400 + this.ftm.stringWidth(s) / 2, 501);
                if (this.mouseon == 2) {
                    if (this.mouses == -1) {
                        this.openhlink();
                    }
                }
                final int n = -110;
                Label_1697: {
                    if (this.xm > 150) {
                        if (this.xm < 600) {
                            if (this.ym > 467 + n) {
                                if (this.ym < 504 + n) {
                                    if (this.mouseon != -1) {
                                        break Label_1697;
                                    }
                                    this.mouseon = 1;
                                    this.setCursor(new Cursor(12));
                                    break Label_1697;
                                }
                            }
                        }
                    }
                    if (this.mouseon == 1) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                }
                if (this.mouseon != 1) {
                    this.rd.setColor(new Color(0, 0, 0));
                }
                else {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                this.rd.drawString("For help and a detailed step by step description on how to use the Stage Maker :", 400 - this.ftm.stringWidth("For help and a detailed step by step description on how to use the Stage Maker :") / 2, 480 + n);
                this.rd.setColor(new Color(0, 128, 255));
                final String s2 = "http://www.needformadness.com/developer/help.html";
                this.rd.drawString(s2, 400 - this.ftm.stringWidth(s2) / 2, 500 + n);
                if (this.mouseon != 1) {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                else {
                    this.rd.setColor(new Color(0, 128, 255));
                }
                this.rd.drawLine(400 - this.ftm.stringWidth(s2) / 2, 501 + n, 400 + this.ftm.stringWidth(s2) / 2, 501 + n);
                if (this.mouseon == 1) {
                    if (this.mouses == -1) {
                        this.openlink();
                    }
                }
                final int n2 = -60;
                final int n3 = 70;
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRect(227 - n3, 194 + n2, 346 + n3 * 2, 167 + n3 / 5);
                if (this.sfase == 0) {
                    this.rd.drawString("Select Stage to Edit", 400 - this.ftm.stringWidth("Select Stage to Edit") / 2, 230 + n2);
                    this.slstage.move(220, 240 + n2);
                    if (this.slstage.getWidth() != 360) {
                        this.slstage.setSize(360, 21);
                    }
                    if (!this.slstage.isShowing()) {
                        this.slstage.show();
                    }
                    if (this.button("    Make new Stage    ", 400, 296 + n2, 0, true)) {
                        this.srch.setText("");
                        this.slstage.hide();
                        this.sfase = 1;
                    }
                    if (this.button("     Rename Stage     ", 325, 336 + n2, 0, false)) {
                        if (this.stagename.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please select a stage to rename first.", "Stage Maker", 1);
                        }
                        else {
                            this.slstage.hide();
                            this.srch.setText(this.stagename);
                            this.sfase = 2;
                        }
                    }
                    if (this.button("      Delete Stage      ", 475, 336 + n2, 0, false)) {
                        if (this.stagename.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please select a stage to delete first.", "Stage Maker", 1);
                        }
                        else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete this stage?\n\n" + this.stagename + "\n\n", "Stage Maker", 0) == 0) {
                            this.delstage(this.stagename);
                        }
                    }
                    if (this.slstage.getSelectedIndex() == 0) {
                        this.stagename = "";
                    }
                    else if (!this.stagename.equals(this.slstage.getSelectedItem())) {
                        this.stagename = this.slstage.getSelectedItem();
                        this.readstage(3);
                        this.sx = 0;
                        this.sz = 1500;
                        this.sy = -10000;
                        this.requestFocus();
                    }
                }
                if (this.sfase == 1) {
                    this.rd.drawString("Make a new Stage", 400 - this.ftm.stringWidth("Make a new Stage") / 2, 220 + n2);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New stage name :", 200, 246 + n2);
                    this.movefield(this.srch, 310, 231 + n2, 290, 23);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    this.fixtext(this.srch);
                    this.rd.drawString("Starting line type :", 293, 272 + n2);
                    this.strtyp.move(408, 256 + n2);
                    if (!this.strtyp.isShowing()) {
                        this.strtyp.show();
                    }
                    if (this.button("    Make Stage    ", 400, 311 + n2, 0, true)) {
                        this.newstage();
                    }
                    if (this.button("  Cancel  ", 400, 351 + n2, 0, false)) {
                        this.strtyp.hide();
                        this.srch.hide();
                        this.sfase = 0;
                    }
                }
                if (this.sfase == 2) {
                    this.rd.drawString("Rename Stage :  " + this.stagename + "", 400 - this.ftm.stringWidth("Rename Stage :  " + this.stagename + "") / 2, 230 + n2);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New name :", 218, 266 + n2);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    this.movefield(this.srch, 292, 251 + n2, 290, 23);
                    this.fixtext(this.srch);
                    if (this.button("    Rename Stage    ", 400, 306 + n2, 0, true)) {
                        this.renstage(this.srch.getText());
                    }
                    if (this.button("  Cancel  ", 400, 346 + n2, 0, false)) {
                        this.srch.hide();
                        this.sfase = 0;
                    }
                }
            }
            if (this.tab == 1) {
                if (this.tabed != this.tab) {
                    this.m.trk = 2;
                    this.readstage(0);
                    if (this.sptyp == 0) {
                        this.partroads();
                    }
                    if (this.sptyp == 1) {
                        this.partramps();
                    }
                    if (this.sptyp == 2) {
                        this.partobst();
                    }
                    if (this.sptyp == 5) {
                        this.partrees();
                    }
                    this.onoff = false;
                    this.setCursor(new Cursor(0));
                    this.setcur = false;
                    this.epart = false;
                    this.arrng = false;
                    if (this.nob == 1) {
                        this.sptyp = 0;
                        if (this.co[0].colok != 38) {
                            this.spart = 0;
                        }
                        else {
                            this.spart = 9;
                        }
                    }
                    this.mouseon = -1;
                }
                if (this.sptyp == 0) {
                    if (this.spart == 0) {
                        this.sp = 0;
                    }
                    if (this.spart == 1) {
                        this.sp = 4;
                    }
                    if (this.spart == 2) {
                        this.sp = 13;
                    }
                    if (this.spart == 3) {
                        this.sp = 3;
                    }
                    if (this.spart == 4) {
                        this.sp = 2;
                    }
                    if (this.spart == 5) {
                        this.sp = 1;
                    }
                    if (this.spart == 6) {
                        this.sp = 35;
                    }
                    if (this.spart == 7) {
                        this.sp = 36;
                    }
                    if (this.spart == 8) {
                        this.sp = 10;
                    }
                    if (this.spart == 9) {
                        this.sp = 5;
                    }
                    if (this.spart == 10) {
                        this.sp = 7;
                    }
                    if (this.spart == 11) {
                        this.sp = 14;
                    }
                    if (this.spart == 12) {
                        this.sp = 6;
                    }
                    if (this.spart == 13) {
                        this.sp = 34;
                    }
                    if (this.spart == 14) {
                        this.sp = 33;
                    }
                    if (this.spart == 15) {
                        this.sp = 11;
                    }
                    if (this.spart == 16) {
                        this.sp = 8;
                    }
                    if (this.spart == 17) {
                        this.sp = 9;
                    }
                    if (this.spart == 18) {
                        this.sp = 15;
                    }
                    if (this.spart == 19) {
                        this.sp = 12;
                    }
                    if (this.spart == 20) {
                        this.sp = 46;
                    }
                    if (this.spart == 21) {
                        this.sp = 47;
                    }
                    if (this.spart == 22) {
                        this.sp = 50;
                    }
                    if (this.spart == 23) {
                        this.sp = 48;
                    }
                    if (this.spart == 24) {
                        this.sp = 49;
                    }
                    if (this.spart == 25) {
                        this.sp = 51;
                    }
                }
                if (this.sptyp == 1) {
                    if (this.spart == 0) {
                        this.sp = 16;
                    }
                    if (this.spart == 1) {
                        this.sp = 18;
                    }
                    if (this.spart == 2) {
                        this.sp = 19;
                    }
                    if (this.spart == 3) {
                        this.sp = 22;
                    }
                    if (this.spart == 4) {
                        this.sp = 17;
                    }
                    if (this.spart == 5) {
                        this.sp = 21;
                    }
                    if (this.spart == 6) {
                        this.sp = 20;
                    }
                    if (this.spart == 7) {
                        this.sp = 39;
                    }
                    if (this.spart == 8) {
                        this.sp = 42;
                    }
                    if (this.spart == 9) {
                        this.sp = 40;
                    }
                    if (this.spart == 10) {
                        this.sp = 23;
                    }
                    if (this.spart == 11) {
                        this.sp = 25;
                    }
                    if (this.spart == 12) {
                        this.sp = 24;
                    }
                    if (this.spart == 13) {
                        this.sp = 43;
                    }
                    if (this.spart == 14) {
                        this.sp = 45;
                    }
                    if (this.spart == 15) {
                        this.sp = 26;
                    }
                }
                if (this.sptyp == 2) {
                    if (this.spart == 0) {
                        this.sp = 27;
                    }
                    if (this.spart == 1) {
                        this.sp = 28;
                    }
                    if (this.spart == 2) {
                        this.sp = 41;
                    }
                    if (this.spart == 3) {
                        this.sp = 44;
                    }
                    if (this.spart == 4) {
                        this.sp = 52;
                    }
                    if (this.spart == 5) {
                        this.sp = 53;
                    }
                }
                if (this.sptyp == 3) {
                    if (!this.onfly) {
                        if (this.onoff) {
                            this.sp = 32;
                        }
                        else {
                            this.sp = 30;
                        }
                    }
                    else {
                        this.sp = 54;
                    }
                }
                if (this.sptyp == 4) {
                    this.sp = 31;
                }
                if (this.sptyp == 5) {
                    if (this.spart == 0) {
                        this.sp = 55;
                    }
                    if (this.spart == 1) {
                        this.sp = 56;
                    }
                    if (this.spart == 2) {
                        this.sp = 57;
                    }
                    if (this.spart == 3) {
                        this.sp = 58;
                    }
                    if (this.spart == 4) {
                        this.sp = 59;
                    }
                    if (this.spart == 5) {
                        this.sp = 60;
                    }
                    if (this.spart == 6) {
                        this.sp = 61;
                    }
                    if (this.spart == 7) {
                        this.sp = 62;
                    }
                    if (this.spart == 8) {
                        this.sp = 63;
                    }
                    if (this.spart == 9) {
                        this.sp = 64;
                    }
                    if (this.spart == 10) {
                        this.sp = 65;
                    }
                }
                if (this.sptyp != 6) {
                    if (this.pgen) {
                        this.pgen = false;
                        this.pwd = 2L + Math.round(Math.random() * 4.0);
                        this.phd = 2L + Math.round(Math.random() * 4.0);
                    }
                }
                else {
                    if (!this.pgen) {
                        int fgen = (int)(10000.0 * Math.random());
                        if (this.fgen != 0) {
                            fgen = this.fgen;
                            this.fgen = 0;
                        }
                        this.bco[66] = new ContO(fgen, (int)this.pwd, (int)this.phd, this.m, this.t, 0, 0, 0);
                        this.bco[66].srz = fgen;
                        this.bco[66].srx = (int)this.pwd;
                        this.bco[66].sry = (int)this.phd;
                        this.pgen = true;
                        this.seq = 3;
                    }
                    this.sp = 66;
                    this.rot = 0;
                }
                Label_5219: {
                    if (this.sp != 30) {
                        if (this.sp != 31) {
                            if (this.sp != 32) {
                                if (this.sp != 54) {
                                    break Label_5219;
                                }
                            }
                        }
                    }
                    if (this.rot == -90) {
                        this.rot = 90;
                    }
                    if (this.rot == 180) {
                        this.rot = 0;
                    }
                }
                this.adrot = 0;
                if (this.sp == 2) {
                    this.adrot = -30;
                }
                if (this.sp == 3) {
                    this.adrot = 30;
                }
                if (this.sp == 15) {
                    this.adrot = 90;
                }
                if (this.sp == 20) {
                    this.adrot = 180;
                }
                if (this.sp == 26) {
                    this.adrot = 90;
                }
                this.rd.setColor(new Color(200, 200, 200));
                this.rd.fillRect(248, 63, 514, 454);
                this.m.trk = 2;
                this.m.zy = 90;
                this.m.xz = 0;
                this.m.iw = 248;
                this.m.w = 762;
                this.m.ih = 63;
                this.m.h = 517;
                this.m.cx = 505;
                this.m.cy = 290;
                this.m.x = this.sx - this.m.cx;
                this.m.z = this.sz - this.m.cz;
                this.m.y = this.sy;
                int n4 = 0;
                final int[] array = new int[200];
                for (int k = 0; k < this.nob; ++k) {
                    if (this.co[k].dist == 0) {
                        this.co[k].d(this.rd);
                    }
                    else {
                        array[n4] = k;
                        ++n4;
                    }
                }
                final int[] array2 = new int[n4];
                for (int l = 0; l < n4; ++l) {
                    array2[l] = 0;
                }
                for (int n5 = 0; n5 < n4; ++n5) {
                    for (int n6 = n5 + 1; n6 < n4; ++n6) {
                        if (this.co[array[n5]].dist == this.co[array[n6]].dist) {
                            if (n6 <= n5) {
                                final int[] array3 = array2;
                                final int n7 = n6;
                                ++array3[n7];
                            }
                            else {
                                final int[] array4 = array2;
                                final int n8 = n5;
                                ++array4[n8];
                            }
                        }
                        else if (this.co[array[n5]].dist >= this.co[array[n6]].dist) {
                            final int[] array5 = array2;
                            final int n9 = n6;
                            ++array5[n9];
                        }
                        else {
                            final int[] array6 = array2;
                            final int n10 = n5;
                            ++array6[n10];
                        }
                    }
                }
                for (int n11 = 0; n11 < n4; ++n11) {
                    for (int n12 = 0; n12 < n4; ++n12) {
                        if (array2[n12] == n11) {
                            if (array[n12] == this.hi) {
                                this.m.trk = 3;
                            }
                            if (array[n12] == this.chi) {
                                if (!this.co[array[n12]].errd) {
                                    final int n13 = this.m.cx + (int)((this.co[array[n12]].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.co[array[n12]].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
                                    final int n14 = this.m.cz + (int)((this.co[array[n12]].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.co[array[n12]].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
                                    final int n15 = this.m.cy + (int)((this.co[array[n12]].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n14 - this.m.cz) * this.m.sin(this.m.zy));
                                    final int n16 = this.m.cz + (int)((this.co[array[n12]].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n14 - this.m.cz) * this.m.cos(this.m.zy));
                                    final int n17 = 1000000 / Math.abs(this.sy);
                                    final Graphics2D rd = this.rd;
                                    rd.setComposite(AlphaComposite.getInstance(3, 0.7f));
                                    this.rd.setColor(new Color(0, 164, 255));
                                    this.rd.fillOval(this.xs(n13, n16) - n17 / 2, this.ys(n15, n16) - n17 / 2, n17, n17);
                                    rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("NO# " + (this.arrcnt + 1) + "", this.xs(n13, n16) - this.ftm.stringWidth("NO# " + (this.arrcnt + 1) + "") / 2, this.ys(n15, n16) - n17 / 2);
                                }
                            }
                            Label_7240: {
                                if (this.arrng) {
                                    if (this.co[array[n12]].colok != 30) {
                                        if (this.co[array[n12]].colok != 32) {
                                            if (this.co[array[n12]].colok != 54) {
                                                break Label_7240;
                                            }
                                        }
                                    }
                                    if (this.co[array[n12]].errd) {
                                        final int n18 = this.m.cx + (int)((this.co[array[n12]].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.co[array[n12]].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
                                        final int n19 = this.m.cz + (int)((this.co[array[n12]].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.co[array[n12]].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
                                        final int n20 = this.m.cy + (int)((this.co[array[n12]].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n19 - this.m.cz) * this.m.sin(this.m.zy));
                                        final int n21 = this.m.cz + (int)((this.co[array[n12]].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n19 - this.m.cz) * this.m.cos(this.m.zy));
                                        final int n22 = 1000000 / Math.abs(this.sy);
                                        final Graphics2D rd2 = this.rd;
                                        rd2.setComposite(AlphaComposite.getInstance(3, 0.5f));
                                        this.rd.setColor(new Color(255, 128, 0));
                                        this.rd.fillOval(this.xs(n18, n21) - n22 / 2, this.ys(n20, n21) - n22 / 2, n22, n22);
                                        rd2.setComposite(AlphaComposite.getInstance(3, 1.0f));
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("NO# " + this.co[array[n12]].wh + "", this.xs(n18, n21) - this.ftm.stringWidth("NO# " + this.co[array[n12]].wh + "") / 2, this.ys(n20, n21) - n22 / 2);
                                    }
                                }
                            }
                            this.co[array[n12]].d(this.rd);
                            if (this.m.trk == 3) {
                                this.m.trk = 2;
                            }
                        }
                    }
                }
                Label_13926: {
                    if (this.xm > 248) {
                        if (this.xm < 762) {
                            if (this.ym > 63) {
                                if (this.ym < 517) {
                                    if (!this.epart) {
                                        if (!this.arrng) {
                                            this.bco[this.sp].x = (this.xm - 505) * (Math.abs(this.sy) / this.m.focus_point) + this.sx;
                                            this.bco[this.sp].z = (290 - this.ym) * (Math.abs(this.sy) / this.m.focus_point) + this.sz;
                                            this.bco[this.sp].y = this.m.ground - this.bco[this.sp].grat;
                                            this.bco[this.sp].xz = this.rot + this.adrot;
                                            int n23 = 200;
                                            int n24 = 0;
                                            int n25 = 0;
                                            final int[] array7 = { this.bco[this.sp].x + this.atp[this.sp][0], this.bco[this.sp].x + this.atp[this.sp][2] };
                                            final int[] array8 = { this.bco[this.sp].z + this.atp[this.sp][1], this.bco[this.sp].z + this.atp[this.sp][3] };
                                            this.rot(array7, array8, this.bco[this.sp].x, this.bco[this.sp].z, this.rot, 2);
                                            int n26 = 0;
                                            this.onfly = false;
                                            int n27 = 500;
                                            for (int n28 = 0; n28 < this.nob; ++n28) {
                                                final int[] array9 = { this.co[n28].x + this.atp[this.co[n28].colok][0], this.co[n28].x + this.atp[this.co[n28].colok][2] };
                                                final int[] array10 = { this.co[n28].z + this.atp[this.co[n28].colok][1], this.co[n28].z + this.atp[this.co[n28].colok][3] };
                                                int roofat = this.co[n28].roofat;
                                                if (this.co[n28].colok == 2) {
                                                    roofat += 30;
                                                }
                                                if (this.co[n28].colok == 3) {
                                                    roofat -= 30;
                                                }
                                                if (this.co[n28].colok == 15) {
                                                    roofat -= 90;
                                                }
                                                if (this.co[n28].colok == 20) {
                                                    roofat -= 180;
                                                }
                                                if (this.co[n28].colok == 26) {
                                                    roofat -= 90;
                                                }
                                                this.rot(array9, array10, this.co[n28].x, this.co[n28].z, roofat, 2);
                                                if (this.sp <= 54) {
                                                    final int py = this.py(array9[0], array7[0], array10[0], array8[0]);
                                                    if (py < n23) {
                                                        if (py != 0) {
                                                            n23 = py;
                                                            n24 = array9[0] - array7[0];
                                                            n25 = array10[0] - array8[0];
                                                        }
                                                    }
                                                    final int py2 = this.py(array9[1], array7[0], array10[1], array8[0]);
                                                    if (py2 < n23) {
                                                        if (py2 != 0) {
                                                            n23 = py2;
                                                            n24 = array9[1] - array7[0];
                                                            n25 = array10[1] - array8[0];
                                                        }
                                                    }
                                                    final int py3 = this.py(array9[1], array7[1], array10[1], array8[1]);
                                                    if (py3 < n23) {
                                                        if (py3 != 0) {
                                                            n23 = py3;
                                                            n24 = array9[1] - array7[1];
                                                            n25 = array10[1] - array8[1];
                                                        }
                                                    }
                                                    final int py4 = this.py(array9[0], array7[1], array10[0], array8[1]);
                                                    if (py4 < n23) {
                                                        if (py4 != 0) {
                                                            n23 = py4;
                                                            n24 = array9[0] - array7[1];
                                                            n25 = array10[0] - array8[1];
                                                        }
                                                    }
                                                }
                                                if (this.sptyp == 3) {
                                                    if (this.py(array9[0], array7[0], array10[0], array8[0]) != 0) {
                                                        if (this.py(array9[1], array7[0], array10[1], array8[0]) != 0) {
                                                            for (int n29 = 0; n29 < this.rcheckp.length; ++n29) {
                                                                if (this.co[n28].colok == this.rcheckp[n29]) {
                                                                    Label_8536: {
                                                                        if (this.py(array9[0], array7[0], array10[0], array8[0]) > n26) {
                                                                            if (n26 != 0) {
                                                                                break Label_8536;
                                                                            }
                                                                        }
                                                                        n26 = this.py(array9[0], array7[0], array10[0], array8[0]);
                                                                        this.onoff = false;
                                                                    }
                                                                    if (this.py(array9[1], array7[0], array10[1], array8[0]) <= n26) {
                                                                        n26 = this.py(array9[1], array7[0], array10[1], array8[0]);
                                                                        this.onoff = false;
                                                                    }
                                                                }
                                                            }
                                                            for (int n30 = 0; n30 < this.ocheckp.length; ++n30) {
                                                                if (this.co[n28].colok == this.ocheckp[n30]) {
                                                                    Label_8721: {
                                                                        if (this.py(array9[0], array7[0], array10[0], array8[0]) > n26) {
                                                                            if (n26 != 0) {
                                                                                break Label_8721;
                                                                            }
                                                                        }
                                                                        n26 = this.py(array9[0], array7[0], array10[0], array8[0]);
                                                                        this.onoff = true;
                                                                    }
                                                                    if (this.py(array9[1], array7[0], array10[1], array8[0]) <= n26) {
                                                                        n26 = this.py(array9[1], array7[0], array10[1], array8[0]);
                                                                        this.onoff = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                Label_9406: {
                                                    Label_8880: {
                                                        if (this.sp > 12) {
                                                            if (this.sp < 33) {
                                                                break Label_8880;
                                                            }
                                                        }
                                                        if (this.sp != 35) {
                                                            if (this.sp != 36) {
                                                                if (this.sp < 39) {
                                                                    break Label_9406;
                                                                }
                                                                if (this.sp > 54) {
                                                                    break Label_9406;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    Label_9142: {
                                                        if (this.rot != 0) {
                                                            if (this.rot != 180) {
                                                                if (this.sp != 26) {
                                                                    if (this.sp != 15) {
                                                                        break Label_9142;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (roofat != 0) {
                                                            if (roofat != 180) {
                                                                if (this.sp != 26) {
                                                                    if (this.sp != 15) {
                                                                        break Label_9142;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (Math.abs(array9[0] - array7[0]) < 200) {
                                                            n24 = array9[0] - array7[0];
                                                        }
                                                        if (Math.abs(array9[0] - array7[1]) < 200) {
                                                            n24 = array9[0] - array7[1];
                                                        }
                                                        if (Math.abs(array9[1] - array7[1]) < 200) {
                                                            n24 = array9[1] - array7[1];
                                                        }
                                                        if (Math.abs(array9[1] - array7[0]) < 200) {
                                                            n24 = array9[1] - array7[0];
                                                        }
                                                    }
                                                    if (this.rot != 90) {
                                                        if (this.rot != -90) {
                                                            if (this.sp != 26) {
                                                                if (this.sp != 15) {
                                                                    break Label_9406;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (roofat != 90) {
                                                        if (roofat != -90) {
                                                            if (this.sp != 26) {
                                                                if (this.sp != 15) {
                                                                    break Label_9406;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (Math.abs(array10[0] - array8[0]) < 200) {
                                                        n25 = array10[0] - array8[0];
                                                    }
                                                    if (Math.abs(array10[0] - array8[1]) < 200) {
                                                        n25 = array10[0] - array8[1];
                                                    }
                                                    if (Math.abs(array10[1] - array8[1]) < 200) {
                                                        n25 = array10[1] - array8[1];
                                                    }
                                                    if (Math.abs(array10[1] - array8[0]) < 200) {
                                                        n25 = array10[1] - array8[0];
                                                    }
                                                }
                                                if (this.sptyp == 3) {
                                                    if (this.co[n28].colok >= 46) {
                                                        if (this.co[n28].colok <= 51) {
                                                            final int[] array11 = { 2, 3, 5, 2, 3, 3 };
                                                            Label_9958: {
                                                                if (Math.abs(this.co[n28].roofat) != 180) {
                                                                    if (this.co[n28].roofat != 0) {
                                                                        break Label_9958;
                                                                    }
                                                                }
                                                                if (this.rot == 0) {
                                                                    if (Math.abs(this.bco[this.sp].x - this.co[n28].x) < 500) {
                                                                        if (Math.abs(this.bco[this.sp].z - this.co[n28].z) < 3000) {
                                                                            for (int n31 = 0; n31 < array11[this.co[n28].colok - 46]; ++n31) {
                                                                                for (int n32 = 0; n32 < this.co[n28].p[n31].n; ++n32) {
                                                                                    if (this.py(this.bco[this.sp].x, this.co[n28].x, this.bco[this.sp].z, this.co[n28].z + this.co[n28].p[n31].oz[n32]) < n27) {
                                                                                        n27 = this.py(this.bco[this.sp].x, this.co[n28].x, this.bco[this.sp].z, this.co[n28].z + this.co[n28].p[n31].oz[n32]);
                                                                                        this.flyh = this.co[n28].p[n31].oy[n32] - 28 + this.m.ground;
                                                                                        n24 = this.co[n28].x - this.bco[this.sp].x;
                                                                                        n25 = this.co[n28].z + this.co[n28].p[n31].oz[n32] - this.bco[this.sp].z;
                                                                                        this.onfly = true;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (Math.abs(this.co[n28].roofat) == 90) {
                                                                if (this.rot == 90) {
                                                                    if (Math.abs(this.bco[this.sp].z - this.co[n28].z) < 500) {
                                                                        if (Math.abs(this.bco[this.sp].x - this.co[n28].x) < 3000) {
                                                                            for (int n33 = 0; n33 < array11[this.co[n28].colok - 46]; ++n33) {
                                                                                for (int n34 = 0; n34 < this.co[n28].p[n33].n; ++n34) {
                                                                                    if (this.py(this.bco[this.sp].z, this.co[n28].z, this.bco[this.sp].x, this.co[n28].x + this.co[n28].p[n33].ox[n34]) < n27) {
                                                                                        n27 = this.py(this.bco[this.sp].z, this.co[n28].z, this.bco[this.sp].x, this.co[n28].x + this.co[n28].p[n33].ox[n34]);
                                                                                        this.flyh = this.co[n28].p[n33].oy[n34] - 28 + this.m.ground;
                                                                                        n25 = this.co[n28].z - this.bco[this.sp].z;
                                                                                        n24 = this.co[n28].x + this.co[n28].p[n33].ox[n34] - this.bco[this.sp].x;
                                                                                        this.onfly = true;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            final ContO contO = this.bco[this.sp];
                                            contO.x += n24;
                                            final ContO contO2 = this.bco[this.sp];
                                            contO2.z += n25;
                                            final int xy = this.bco[this.sp].xy;
                                            final int zy = this.bco[this.sp].zy;
                                            if (this.sp != 31) {
                                                this.bco[this.sp].xy = 0;
                                            }
                                            else {
                                                this.bco[this.sp].y = -this.hf;
                                                if (this.bco[this.sp].y > -500) {
                                                    this.bco[this.sp].y = -500;
                                                }
                                            }
                                            if (this.sp == 54) {
                                                this.bco[this.sp].y = this.flyh;
                                            }
                                            this.bco[this.sp].zy = 0;
                                            if (this.cntout != 0) {
                                                if (this.lxm != this.bco[this.sp].x) {
                                                    if (this.lxm != this.bco[this.sp].z) {
                                                        --this.cntout;
                                                    }
                                                }
                                                if (this.setcur) {
                                                    this.setCursor(new Cursor(0));
                                                    this.setcur = false;
                                                }
                                            }
                                            else if (this.mouseon == -1) {
                                                this.bco[this.sp].d(this.rd);
                                                if (!this.setcur) {
                                                    this.setCursor(new Cursor(13));
                                                    this.setcur = true;
                                                }
                                                if (this.mouses == -1) {
                                                    if (this.nundo < 5000) {
                                                        this.undos[this.nundo] = this.bstage;
                                                        ++this.nundo;
                                                    }
                                                    if (this.bco[this.sp].xz == 270) {
                                                        this.bco[this.sp].xz = -90;
                                                    }
                                                    if (this.bco[this.sp].xz == 360) {
                                                        this.bco[this.sp].xz = 0;
                                                    }
                                                    this.errd = 0;
                                                    boolean b = false;
                                                    if (this.xnob >= 601) {
                                                        this.errd = 4;
                                                    }
                                                    else {
                                                        if (this.sp != 31) {
                                                            if (this.sp != 54) {
                                                                if (this.sp != 66) {
                                                                    try {
                                                                        this.co[this.nob] = new ContO(this.bco[this.sp], this.bco[this.sp].x, this.m.ground - this.bco[this.sp].grat, this.bco[this.sp].z, this.bco[this.sp].xz);
                                                                        this.co[this.nob].roofat = this.bco[this.sp].xz;
                                                                        this.co[this.nob].colok = this.sp;
                                                                        ++this.nob;
                                                                    }
                                                                    catch (Exception ex3) {
                                                                        this.errd = 1;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (this.sp == 31) {
                                                            if (this.cp.fn >= 5) {
                                                                this.errd = 5;
                                                            }
                                                            else {
                                                                this.co[this.nob] = new ContO(this.bco[this.sp], this.bco[this.sp].x, this.bco[this.sp].y, this.bco[this.sp].z, this.bco[this.sp].xz);
                                                                this.co[this.nob].roofat = this.bco[this.sp].xz;
                                                                this.co[this.nob].colok = this.sp;
                                                                ++this.nob;
                                                                this.fixh.setText("" + Math.abs(this.bco[this.sp].y) + "");
                                                            }
                                                        }
                                                        if (this.sp == 54) {
                                                            try {
                                                                this.co[this.nob] = new ContO(this.bco[this.sp], this.bco[this.sp].x, this.bco[this.sp].y, this.bco[this.sp].z, this.bco[this.sp].xz);
                                                                this.co[this.nob].roofat = this.bco[this.sp].xz;
                                                                this.co[this.nob].colok = this.sp;
                                                                ++this.nob;
                                                            }
                                                            catch (Exception ex4) {
                                                                this.errd = 1;
                                                            }
                                                        }
                                                        if (this.sp == 66) {
                                                            this.co[this.nob] = new ContO(this.bco[66].srz, this.bco[66].srx, this.bco[66].sry, this.m, this.t, this.bco[66].x, this.bco[66].z, this.bco[this.sp].y);
                                                            this.co[this.nob].srz = this.bco[66].srz;
                                                            this.co[this.nob].srx = this.bco[66].srx;
                                                            this.co[this.nob].sry = this.bco[66].sry;
                                                            this.co[this.nob].colok = this.sp;
                                                            ++this.nob;
                                                        }
                                                    }
                                                    Label_11915: {
                                                        if (this.errd == 0) {
                                                            this.sortstage();
                                                            this.readstage(0);
                                                            b = true;
                                                            if (this.sp == 66) {
                                                                this.pgen = false;
                                                            }
                                                            if (this.sp != 52) {
                                                                if (this.sp != 53) {
                                                                    if (this.sp < 55) {
                                                                        break Label_11915;
                                                                    }
                                                                    if (this.sp > 65) {
                                                                        break Label_11915;
                                                                    }
                                                                }
                                                            }
                                                            this.seq = 3;
                                                            this.bco[this.sp].xy = 0;
                                                            this.bco[this.sp].zy = 0;
                                                            int n35 = 0;
                                                            if (this.rot == 0) {
                                                                if (n35 == 0) {
                                                                    this.rot = 90;
                                                                    n35 = 1;
                                                                }
                                                            }
                                                            if (this.rot == 90) {
                                                                if (n35 == 0) {
                                                                    this.rot = 180;
                                                                    n35 = 1;
                                                                }
                                                            }
                                                            if (this.rot == 180) {
                                                                if (n35 == 0) {
                                                                    this.rot = -90;
                                                                    n35 = 1;
                                                                }
                                                            }
                                                            if (this.rot == -90) {
                                                                if (n35 == 0) {
                                                                    this.rot = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (this.errd != 0) {
                                                        JOptionPane.showMessageDialog(null, "Error!  Unable to place part!\nReason:\n" + this.errlo[this.errd - 1] + "\n\n", "Stage Maker", 0);
                                                        if (b) {
                                                            --this.nundo;
                                                            this.bstage = this.undos[this.nundo];
                                                            this.readstage(0);
                                                        }
                                                    }
                                                    this.lxm = this.bco[this.sp].x;
                                                    this.lym = this.bco[this.sp].z;
                                                    this.cntout = 10;
                                                }
                                            }
                                            this.bco[this.sp].xy = xy;
                                            this.bco[this.sp].zy = zy;
                                            break Label_13926;
                                        }
                                    }
                                    Label_13058: {
                                        if (this.epart) {
                                            if (this.esp == -1) {
                                                if (!this.overcan) {
                                                    this.hi = -1;
                                                    int n36 = 0;
                                                    for (int n37 = 0; n37 < this.nob; ++n37) {
                                                        final int n38 = this.m.cx + (int)((this.co[n37].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.co[n37].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
                                                        final int n39 = this.m.cz + (int)((this.co[n37].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.co[n37].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
                                                        final int n40 = this.m.cy + (int)((this.co[n37].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n39 - this.m.cz) * this.m.sin(this.m.zy));
                                                        final int n41 = this.m.cz + (int)((this.co[n37].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n39 - this.m.cz) * this.m.cos(this.m.zy));
                                                        if (this.xm > this.xs(n38 - this.co[n37].maxR, n41)) {
                                                            if (this.xm < this.xs(n38 + this.co[n37].maxR, n41)) {
                                                                if (this.ym > this.ys(n40 - this.co[n37].maxR, n41)) {
                                                                    if (this.ym < this.ys(n40 + this.co[n37].maxR, n41)) {
                                                                        if (this.co[n37].colok != 37) {
                                                                            if (this.co[n37].colok != 38) {
                                                                                if (this.hi != -1) {
                                                                                    if (this.py(this.xm, this.xs(n38, n41), this.ym, this.ys(n40, n41)) <= n36) {
                                                                                        this.hi = n37;
                                                                                        n36 = this.py(this.xm, this.xs(n38, n41), this.ym, this.ys(n40, n41));
                                                                                    }
                                                                                }
                                                                                else {
                                                                                    this.hi = n37;
                                                                                    n36 = this.py(this.xm, this.xs(n38, n41), this.ym, this.ys(n40, n41));
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (this.hi == -1) {
                                                        if (this.setcur) {
                                                            this.setCursor(new Cursor(0));
                                                            this.setcur = false;
                                                        }
                                                    }
                                                    else {
                                                        if (!this.setcur) {
                                                            this.setCursor(new Cursor(13));
                                                            this.setcur = true;
                                                        }
                                                        if (this.mouses == -1) {
                                                            this.esp = this.hi;
                                                            this.mouses = 0;
                                                        }
                                                    }
                                                    break Label_13058;
                                                }
                                            }
                                            if (this.setcur) {
                                                this.setCursor(new Cursor(0));
                                                this.setcur = false;
                                            }
                                        }
                                    }
                                    if (!this.arrng) {
                                        break Label_13926;
                                    }
                                    this.chi = -1;
                                    int py5 = 5000;
                                    for (int chi = 0; chi < this.nob; ++chi) {
                                        if (this.co[chi].colok != 30) {
                                            if (this.co[chi].colok != 32) {
                                                if (this.co[chi].colok != 54) {
                                                    continue;
                                                }
                                            }
                                        }
                                        if (!this.co[chi].errd) {
                                            final int n42 = this.m.cx + (int)((this.co[chi].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.co[chi].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
                                            final int n43 = this.m.cz + (int)((this.co[chi].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.co[chi].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
                                            final int n44 = this.m.cy + (int)((this.co[chi].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n43 - this.m.cz) * this.m.sin(this.m.zy));
                                            final int n45 = this.m.cz + (int)((this.co[chi].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n43 - this.m.cz) * this.m.cos(this.m.zy));
                                            if (this.xm > this.xs(n42 - this.co[chi].maxR, n45)) {
                                                if (this.xm < this.xs(n42 + this.co[chi].maxR, n45)) {
                                                    if (this.ym > this.ys(n44 - this.co[chi].maxR, n45)) {
                                                        if (this.ym < this.ys(n44 + this.co[chi].maxR, n45)) {
                                                            if (this.py(this.xm, this.xs(n42, n45), this.ym, this.ys(n44, n45)) <= py5) {
                                                                this.chi = chi;
                                                                py5 = this.py(this.xm, this.xs(n42, n45), this.ym, this.ys(n44, n45));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.chi == -1) {
                                        if (this.setcur) {
                                            this.setCursor(new Cursor(0));
                                            this.setcur = false;
                                        }
                                    }
                                    else {
                                        if (!this.setcur) {
                                            this.setCursor(new Cursor(13));
                                            this.setcur = true;
                                        }
                                        if (this.mouses == -1) {
                                            ++this.arrcnt;
                                            this.co[this.chi].wh = this.arrcnt;
                                            this.co[this.chi].errd = true;
                                            this.mouses = 0;
                                        }
                                    }
                                    break Label_13926;
                                }
                            }
                        }
                    }
                    if (this.setcur) {
                        this.setCursor(new Cursor(0));
                        this.setcur = false;
                    }
                }
                if (this.epart) {
                    if (this.esp != -1) {
                        if (this.co[this.esp].dist == 0) {
                            this.esp = -1;
                        }
                        else {
                            this.m.cx = 505;
                            this.m.cy = 290;
                            this.m.x = this.sx - this.m.cx;
                            this.m.z = this.sz - this.m.cz;
                            this.m.y = this.sy;
                            final int n46 = this.m.cx + (int)((this.co[this.esp].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.co[this.esp].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
                            final int n47 = this.m.cz + (int)((this.co[this.esp].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.co[this.esp].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
                            final int n48 = this.m.cy + (int)((this.co[this.esp].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n47 - this.m.cz) * this.m.sin(this.m.zy));
                            final int n49 = this.m.cz + (int)((this.co[this.esp].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n47 - this.m.cz) * this.m.cos(this.m.zy));
                            final int xs = this.xs(n46, n49);
                            final int ys = this.ys(n48, n49);
                            this.rd.setColor(new Color(225, 225, 225));
                            this.rd.fillRect(xs, ys, 90, 88);
                            this.rd.setColor(new Color(138, 147, 160));
                            this.rd.drawRect(xs, ys, 90, 88);
                            if (this.button("   Edit   ", xs + 45, ys + 22, 3, false)) {
                                this.copyesp(true);
                                this.removesp();
                                this.lxm = 0;
                                this.lym = 0;
                                this.cntout = 2;
                                this.epart = false;
                            }
                            if (this.button(" Remove ", xs + 45, ys + 49, 3, false)) {
                                this.removesp();
                                this.esp = -1;
                                this.mouses = 0;
                            }
                            if (this.button("  Copy  ", xs + 45, ys + 76, 3, false)) {
                                this.copyesp(false);
                                this.lxm = 0;
                                this.lym = 0;
                                this.cntout = 2;
                                this.epart = false;
                            }
                            this.rd.setColor(new Color(255, 0, 0));
                            this.rd.drawString("x", xs + 82, ys - 2);
                            Label_14851: {
                                if (this.xm > 248) {
                                    if (this.xm < 762) {
                                        if (this.ym > 63) {
                                            if (this.ym < 517) {
                                                if (this.mouses == 1) {
                                                    if (this.xm >= xs) {
                                                        if (this.xm <= xs + 90) {
                                                            if (this.ym >= ys) {
                                                                if (this.ym <= ys + 88) {
                                                                    break Label_14851;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    this.esp = -1;
                                                    this.mouses = 0;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillRect(248, 25, 514, 38);
                this.rd.fillRect(0, 25, 248, 530);
                this.rd.fillRect(248, 517, 514, 38);
                this.rd.fillRect(762, 25, 38, 530);
                if (this.sptyp == 6) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("Radius:", 11, 97);
                    this.rd.drawString("Height:", 14, 117);
                    boolean b2 = false;
                    if (this.xm > 57) {
                        if (this.xm < 204) {
                            if (this.ym > 90) {
                                if (this.ym < 99) {
                                    b2 = true;
                                }
                            }
                        }
                    }
                    this.rd.setColor(new Color(136, 148, 170));
                    Label_15188: {
                        if (!b2) {
                            if (this.mouseon != 1) {
                                break Label_15188;
                            }
                        }
                        this.rd.drawRect(57, 90, 147, 8);
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    this.rd.drawLine(57, 94, 204, 94);
                    if (this.mouseon == 1) {
                        this.pwd = (this.xm - 57) / 36.75f + 2.0f;
                        if (this.pwd < 2.0f) {
                            this.pwd = 2.0f;
                        }
                        if (this.pwd > 6.0f) {
                            this.pwd = 6.0f;
                        }
                    }
                    this.rd.drawRect((int)(57.0f + (this.pwd - 2.0f) * 36.75f), 90, 2, 8);
                    boolean b3 = false;
                    if (this.xm > 57) {
                        if (this.xm < 204) {
                            if (this.ym > 110) {
                                if (this.ym < 119) {
                                    b3 = true;
                                }
                            }
                        }
                    }
                    this.rd.setColor(new Color(136, 148, 170));
                    Label_15466: {
                        if (!b3) {
                            if (this.mouseon != 2) {
                                break Label_15466;
                            }
                        }
                        this.rd.drawRect(57, 110, 147, 8);
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    this.rd.drawLine(57, 114, 204, 114);
                    if (this.mouseon == 2) {
                        this.phd = (this.xm - 57) / 36.75f + 2.0f;
                        if (this.phd < 2.0f) {
                            this.phd = 2.0f;
                        }
                        if (this.phd > 6.0f) {
                            this.phd = 6.0f;
                        }
                    }
                    this.rd.drawRect((int)(57.0f + (this.phd - 2.0f) * 36.75f), 110, 2, 8);
                    if (this.mouses != 1) {
                        Label_15681: {
                            if (this.mouseon != 1) {
                                if (this.mouseon != 2) {
                                    break Label_15681;
                                }
                            }
                            this.pgen = false;
                        }
                        this.mouseon = -1;
                    }
                    else {
                        if (b2) {
                            this.mouseon = 1;
                        }
                        if (b3) {
                            this.mouseon = 2;
                        }
                    }
                }
                int n50 = 0;
                Label_15809: {
                    Label_15764: {
                        if (this.xm > 482) {
                            if (this.xm < 529) {
                                if (this.ym > 35) {
                                    if (this.ym < 61) {
                                        break Label_15764;
                                    }
                                }
                            }
                        }
                        if (!this.up) {
                            break Label_15809;
                        }
                    }
                    n50 = 1;
                    if (this.mouses != 1) {
                        if (!this.up) {
                            break Label_15809;
                        }
                    }
                    this.sz += 500;
                }
                this.rd.drawImage(this.su[n50], 482, 35, null);
                int n51 = 0;
                Label_15950: {
                    Label_15905: {
                        if (this.xm > 482) {
                            if (this.xm < 529) {
                                if (this.ym > 519) {
                                    if (this.ym < 545) {
                                        break Label_15905;
                                    }
                                }
                            }
                        }
                        if (!this.down) {
                            break Label_15950;
                        }
                    }
                    n51 = 1;
                    if (this.mouses != 1) {
                        if (!this.down) {
                            break Label_15950;
                        }
                    }
                    this.sz -= 500;
                }
                this.rd.drawImage(this.sd[n51], 482, 519, null);
                int n52 = 0;
                Label_16092: {
                    Label_16047: {
                        if (this.xm > 220) {
                            if (this.xm < 246) {
                                if (this.ym > 264) {
                                    if (this.ym < 311) {
                                        break Label_16047;
                                    }
                                }
                            }
                        }
                        if (!this.left) {
                            break Label_16092;
                        }
                    }
                    n52 = 1;
                    if (this.mouses != 1) {
                        if (!this.left) {
                            break Label_16092;
                        }
                    }
                    this.sx -= 500;
                }
                this.rd.drawImage(this.sl[n52], 220, 264, null);
                int n53 = 0;
                Label_16234: {
                    Label_16189: {
                        if (this.xm > 764) {
                            if (this.xm < 790) {
                                if (this.ym > 264) {
                                    if (this.ym < 311) {
                                        break Label_16189;
                                    }
                                }
                            }
                        }
                        if (!this.right) {
                            break Label_16234;
                        }
                    }
                    n53 = 1;
                    if (this.mouses != 1) {
                        if (!this.right) {
                            break Label_16234;
                        }
                    }
                    this.sx += 500;
                }
                this.rd.drawImage(this.sr[n53], 764, 264, null);
                int n54 = 0;
                Label_16396: {
                    Label_16329: {
                        if (this.xm > 616) {
                            if (this.xm < 677) {
                                if (this.ym > 30) {
                                    if (this.ym < 61) {
                                        break Label_16329;
                                    }
                                }
                            }
                        }
                        if (!this.zoomi) {
                            break Label_16396;
                        }
                    }
                    n54 = 1;
                    if (this.mouses != 1) {
                        if (!this.zoomi) {
                            break Label_16396;
                        }
                    }
                    this.sy += 500;
                    if (this.sy > -2500) {
                        this.sy = -2500;
                    }
                }
                this.rd.drawImage(this.zi[n54], 616, 30, null);
                int n55 = 0;
                Label_16557: {
                    Label_16490: {
                        if (this.xm > 690) {
                            if (this.xm < 751) {
                                if (this.ym > 30) {
                                    if (this.ym < 61) {
                                        break Label_16490;
                                    }
                                }
                            }
                        }
                        if (!this.zoomo) {
                            break Label_16557;
                        }
                    }
                    n55 = 1;
                    if (this.mouses != 1) {
                        if (!this.zoomo) {
                            break Label_16557;
                        }
                    }
                    this.sy -= 500;
                    if (this.sy < -55000) {
                        this.sy = -55000;
                    }
                }
                this.rd.drawImage(this.zo[n55], 690, 30, null);
                Label_16629: {
                    if (!this.epart) {
                        if (!this.arrng) {
                            break Label_16629;
                        }
                    }
                    if (this.sy < -36000) {
                        this.sy = -36000;
                    }
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Part Selection", 11, 47);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.ptyp.move(10, 50);
                if (!this.ptyp.isShowing()) {
                    this.ptyp.show();
                    this.ptyp.select(this.sptyp);
                }
                if (this.sptyp != this.ptyp.getSelectedIndex()) {
                    this.sptyp = this.ptyp.getSelectedIndex();
                    if (this.sptyp == 0) {
                        this.partroads();
                        this.part.show();
                    }
                    if (this.sptyp == 1) {
                        this.partramps();
                        this.part.show();
                    }
                    if (this.sptyp == 2) {
                        this.partobst();
                        this.part.show();
                    }
                    if (this.sptyp == 5) {
                        this.partrees();
                        this.part.show();
                    }
                    this.spart = 0;
                    this.part.select(this.spart);
                    this.requestFocus();
                    this.fixh.setText("2000");
                    this.focuson = false;
                }
                this.part.move(10, 80);
                this.part.setSize(200, 21);
                Label_17094: {
                    if (this.sptyp != 0) {
                        if (this.sptyp != 1) {
                            if (this.sptyp != 2) {
                                if (this.sptyp != 5) {
                                    if (!this.part.isShowing()) {
                                        break Label_17094;
                                    }
                                    this.part.hide();
                                    break Label_17094;
                                }
                            }
                        }
                    }
                    if (!this.part.isShowing()) {
                        this.part.show();
                        this.part.select(this.spart);
                    }
                }
                if (this.spart != this.part.getSelectedIndex()) {
                    this.spart = this.part.getSelectedIndex();
                    this.focuson = false;
                }
                if (this.sptyp == 3) {
                    this.rd.drawString("Checkpoint", 110 - this.ftm.stringWidth("Checkpoint") / 2, 120);
                }
                if (this.sptyp == 4) {
                    this.rd.drawString("Fixing Hoop", 110 - this.ftm.stringWidth("Fixing Hoop") / 2, 120);
                }
                if (this.lsp != this.sp) {
                    this.seq = 3;
                    this.bco[this.sp].xy = 0;
                    this.bco[this.sp].zy = 0;
                    this.lsp = this.sp;
                    this.epart = false;
                    this.arrng = false;
                }
                Label_17504: {
                    if (this.xm > 10) {
                        if (this.xm < 210) {
                            if (this.ym > 130) {
                                if (this.ym < 334) {
                                    Label_17443: {
                                        if (this.seq >= 3) {
                                            if (this.seq != 20) {
                                                if (this.seqn) {
                                                    ++this.seq;
                                                    break Label_17443;
                                                }
                                            }
                                            this.seq = 0;
                                            this.bco[this.sp].xy = 0;
                                            this.bco[this.sp].zy = 0;
                                        }
                                    }
                                    this.seqn = true;
                                    this.rd.setColor(new Color(210, 210, 210));
                                    break Label_17504;
                                }
                            }
                        }
                    }
                    this.rd.setColor(new Color(200, 200, 200));
                    this.seqn = false;
                }
                this.rd.fillRect(10, 130, 200, 200);
                Label_17734: {
                    if (this.sp != 30) {
                        if (this.sp != 32) {
                            if (this.sp != 54) {
                                break Label_17734;
                            }
                        }
                    }
                    if (this.button("  Rearrange Checkpoints  >  ", 110, 315, 2, true)) {
                        this.mouses = 0;
                        this.epart = false;
                        if (this.arrng) {
                            this.arrng = false;
                        }
                        else {
                            this.arrcnt = 0;
                            for (int n56 = 0; n56 < this.nob; ++n56) {
                                if (this.co[n56].colok != 30) {
                                    if (this.co[n56].colok != 32) {
                                        if (this.co[n56].colok != 54) {
                                            continue;
                                        }
                                    }
                                }
                                this.co[n56].errd = false;
                            }
                            this.arrng = true;
                        }
                    }
                }
                if (this.seqn) {
                    if (this.mouses == -1) {
                        if (this.sp == 66) {
                            this.pgen = false;
                            this.pwd = 2L + Math.round(Math.random() * 4.0);
                            this.phd = 2L + Math.round(Math.random() * 4.0);
                        }
                        else {
                            int n57 = 0;
                            if (this.rot == 0) {
                                if (n57 == 0) {
                                    this.rot = 90;
                                    n57 = 1;
                                }
                            }
                            if (this.rot == 90) {
                                if (n57 == 0) {
                                    this.rot = 180;
                                    n57 = 1;
                                }
                            }
                            if (this.rot == 180) {
                                if (n57 == 0) {
                                    this.rot = -90;
                                    n57 = 1;
                                }
                            }
                            if (this.rot == -90) {
                                if (n57 == 0) {
                                    this.rot = 0;
                                }
                            }
                            Label_18019: {
                                if (this.sp != 30) {
                                    if (this.sp != 31) {
                                        if (this.sp != 32) {
                                            break Label_18019;
                                        }
                                    }
                                }
                                if (this.rot == -90) {
                                    this.rot = 90;
                                }
                                if (this.rot == 180) {
                                    this.rot = 0;
                                }
                            }
                            this.seq = 5;
                            this.bco[this.sp].xy = 0;
                            this.bco[this.sp].zy = 0;
                            this.epart = false;
                            this.arrng = false;
                        }
                    }
                }
                if (this.sp != 31) {
                    if (this.fixh.isShowing()) {
                        this.fixh.hide();
                    }
                }
                else {
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Height:", 62, 280);
                    this.movefield(this.fixh, 107, 266, 50, 20);
                    if (this.fixh.hasFocus()) {
                        this.focuson = false;
                    }
                    if (!this.fixh.isShowing()) {
                        this.fixh.show();
                    }
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("( Height off the ground... )", 110 - this.ftm.stringWidth("( Height off the ground... )") / 2, 300);
                    if (this.fixh.getText().equals("")) {
                        this.fixh.setText("0");
                        this.fixh.select(0, 0);
                    }
                    try {
                        this.hf = Integer.valueOf(this.fixh.getText());
                        if (this.hf > 8000) {
                            this.hf = 8000;
                            this.fixh.setText("8000");
                        }
                    }
                    catch (Exception ex5) {
                        this.hf = 2000;
                        this.fixh.setText("2000");
                    }
                }
                this.m.trk = 2;
                this.m.zy = 90;
                this.m.xz = 0;
                this.m.iw = 10;
                this.m.w = 210;
                this.m.ih = 130;
                this.m.h = 330;
                this.m.cx = 110;
                this.m.cy = 230;
                this.m.x = -110;
                this.m.z = -230;
                this.m.y = -15000;
                if (this.sptyp == 1) {
                    if (this.sp != 20) {
                        if (this.sp != 21) {
                            if (this.sp != 43) {
                                if (this.sp != 45) {
                                    this.m.y = -10000;
                                }
                            }
                        }
                    }
                }
                if (this.sptyp == 2) {
                    if (this.sp != 41) {
                        this.m.y = -7600;
                    }
                }
                Label_18739: {
                    if (this.sptyp != 3) {
                        if (this.sptyp != 4) {
                            break Label_18739;
                        }
                    }
                    this.m.y = -5000;
                }
                if (this.sptyp == 5) {
                    this.m.y = -3000;
                    this.m.z = 150;
                }
                if (this.sptyp == 6) {
                    this.m.y = -7600;
                }
                if (this.sp == 31) {
                    this.m.z = -500;
                    if (this.rot == 0) {
                        this.bco[this.sp].roted = false;
                    }
                    else {
                        this.bco[this.sp].roted = true;
                    }
                }
                this.bco[this.sp].x = 0;
                this.bco[this.sp].y = 0;
                this.bco[this.sp].z = 0;
                this.bco[this.sp].xz = this.rot + this.adrot;
                this.bco[this.sp].d(this.rd);
                int n58 = 1;
                Label_19301: {
                    if (this.sptyp != 0) {
                        if (this.sptyp != 1) {
                            break Label_19301;
                        }
                    }
                    Label_19146: {
                        if (this.sp != 26) {
                            if (this.sp != 20) {
                                if (this.rot != -90) {
                                    if (this.rot != 0) {
                                        break Label_19146;
                                    }
                                }
                                n58 = -1;
                                break Label_19146;
                            }
                        }
                        Label_19095: {
                            if (this.sp == 26) {
                                if (this.rot != -90) {
                                    if (this.rot != 180) {
                                        break Label_19095;
                                    }
                                }
                                n58 = -1;
                            }
                        }
                        if (this.sp == 20) {
                            if (this.rot != 90) {
                                if (this.rot != 180) {
                                    break Label_19146;
                                }
                            }
                            n58 = -1;
                        }
                    }
                    if (this.seq == 2) {
                        final ContO contO3 = this.bco[this.sp];
                        contO3.xy -= 5 * n58;
                        if (this.bco[this.sp].xy == 0) {
                            this.seq = 3;
                        }
                    }
                    if (this.seq == 1) {
                        this.seq = 2;
                    }
                    if (this.seq == 0) {
                        final ContO contO4 = this.bco[this.sp];
                        contO4.xy += 5 * n58;
                        if (this.bco[this.sp].xy == 85 * n58) {
                            this.seq = 1;
                        }
                    }
                }
                Label_19547: {
                    if (this.sptyp != 2) {
                        if (this.sptyp != 3) {
                            if (this.sptyp != 4) {
                                if (this.sptyp != 6) {
                                    break Label_19547;
                                }
                            }
                        }
                    }
                    Label_19391: {
                        if (this.rot != -90) {
                            if (this.rot != 180) {
                                break Label_19391;
                            }
                        }
                        n58 = -1;
                    }
                    if (this.seq == 2) {
                        final ContO contO5 = this.bco[this.sp];
                        contO5.zy += 5 * n58;
                        if (this.bco[this.sp].zy == 0) {
                            this.seq = 3;
                        }
                    }
                    if (this.seq == 1) {
                        this.seq = 2;
                    }
                    if (this.seq == 0) {
                        final ContO contO6 = this.bco[this.sp];
                        contO6.zy -= 5 * n58;
                        if (this.bco[this.sp].zy == -(85 * n58)) {
                            this.seq = 1;
                        }
                    }
                }
                if (this.sptyp == 5) {
                    Label_19597: {
                        if (this.rot != -90) {
                            if (this.rot != 180) {
                                break Label_19597;
                            }
                        }
                        n58 = -1;
                    }
                    boolean b4 = false;
                    Label_19636: {
                        if (this.rot != -90) {
                            if (this.rot != 90) {
                                break Label_19636;
                            }
                        }
                        b4 = true;
                    }
                    if (b4) {
                        this.bco[this.sp].zy = 0;
                    }
                    else {
                        this.bco[this.sp].xy = 0;
                    }
                    if (this.seq == 2) {
                        if (b4) {
                            final ContO contO7 = this.bco[this.sp];
                            contO7.xy -= 5 * n58;
                            if (this.bco[this.sp].xy == 0) {
                                this.seq = 3;
                            }
                        }
                        else {
                            final ContO contO8 = this.bco[this.sp];
                            contO8.zy += 5 * n58;
                            if (this.bco[this.sp].zy == 0) {
                                this.seq = 3;
                            }
                        }
                    }
                    if (this.seq == 1) {
                        this.seq = 2;
                    }
                    if (this.seq == 0) {
                        if (b4) {
                            final ContO contO9 = this.bco[this.sp];
                            contO9.xy += 5 * n58;
                            if (this.bco[this.sp].xy == 85 * n58) {
                                this.seq = 1;
                            }
                        }
                        else {
                            final ContO contO10 = this.bco[this.sp];
                            contO10.zy -= 5 * n58;
                            if (this.bco[this.sp].zy == -(85 * n58)) {
                                this.seq = 1;
                            }
                        }
                    }
                }
                if (this.sp == 66) {
                    if (this.button("  Generate New  ", 110, 348, 3, true)) {
                        this.pgen = false;
                        this.pwd = 2L + Math.round(Math.random() * 4.0);
                        this.phd = 2L + Math.round(Math.random() * 4.0);
                    }
                }
                else if (this.button("  Rotate  ", 110, 348, 3, true)) {
                    int n59 = 0;
                    if (this.rot == 0) {
                        if (n59 == 0) {
                            this.rot = 90;
                            n59 = 1;
                        }
                    }
                    if (this.rot == 90) {
                        if (n59 == 0) {
                            this.rot = 180;
                            n59 = 1;
                        }
                    }
                    if (this.rot == 180) {
                        if (n59 == 0) {
                            this.rot = -90;
                            n59 = 1;
                        }
                    }
                    if (this.rot == -90) {
                        if (n59 == 0) {
                            this.rot = 0;
                        }
                    }
                    Label_20247: {
                        if (this.sp != 30) {
                            if (this.sp != 31) {
                                if (this.sp != 32) {
                                    break Label_20247;
                                }
                            }
                        }
                        if (this.rot == -90) {
                            this.rot = 90;
                        }
                        if (this.rot == 180) {
                            this.rot = 0;
                        }
                    }
                    this.seq = 3;
                    this.bco[this.sp].xy = 0;
                    this.bco[this.sp].zy = 0;
                    this.epart = false;
                    this.arrng = false;
                }
                Label_20502: {
                    if (this.button(">", 191, 348, 3, true)) {
                        if (this.sptyp != 0) {
                            if (this.sptyp != 1) {
                                if (this.sptyp != 2) {
                                    if (this.sptyp != 5) {
                                        break Label_20502;
                                    }
                                }
                            }
                        }
                        ++this.spart;
                        if (this.spart == this.part.getItemCount()) {
                            this.spart = 0;
                        }
                        this.part.select(this.spart);
                        this.epart = false;
                        this.arrng = false;
                    }
                }
                Label_20642: {
                    if (this.button("<", 28, 348, 3, true)) {
                        if (this.sptyp != 0) {
                            if (this.sptyp != 1) {
                                if (this.sptyp != 2) {
                                    if (this.sptyp != 5) {
                                        break Label_20642;
                                    }
                                }
                            }
                        }
                        --this.spart;
                        if (this.spart == -1) {
                            this.spart = this.part.getItemCount() - 1;
                        }
                        this.part.select(this.spart);
                        this.epart = false;
                        this.arrng = false;
                    }
                }
                if (this.button("   <  Undo   ", 204, 404, 0, true)) {
                    this.epart = false;
                    this.arrng = false;
                    if (this.nundo > 0) {
                        --this.nundo;
                        this.bstage = this.undos[this.nundo];
                        this.readstage(0);
                    }
                }
                if (this.button("   Remove / Edit  Part   ", 172, 454, 0, true)) {
                    if (this.epart) {
                        this.epart = false;
                    }
                    else {
                        this.epart = true;
                    }
                    this.arrng = false;
                    this.esp = -1;
                }
                if (this.button("   Go to >  Startline   ", 175, 504, 0, true)) {
                    this.sx = 0;
                    this.sz = 1500;
                }
                if (this.button(" About Part ", 164, 66, 3, false)) {
                    JOptionPane.showMessageDialog(null, this.discp[this.sp], "Stage Maker", 1);
                }
                if (this.button("  Keyboard Controls  ", 691, 536, 3, false)) {
                    JOptionPane.showMessageDialog(null, "Instead of clicking the triangular buttons around the Building Area to scroll, you can use:\n[ Keyboard Arrows ]\n\nYou can also zoom in and out using the following keys:\n[+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]\n\n", "Stage Maker", 1);
                }
                if (this.button("  Save  ", 280, 50, 0, false)) {
                    this.epart = false;
                    this.arrng = false;
                    this.savefile();
                }
                if (this.button("  Save & Preview  ", 380, 50, 0, false)) {
                    this.epart = false;
                    this.arrng = false;
                    this.savefile();
                    this.hidefields();
                    this.tab = 2;
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                int n60 = 0;
                int n62;
                final int n61 = n62 = (int)(this.xnob / 601.0f * 200.0f);
                final int n63 = (int)(this.t.nt / 6700.0f * 200.0f);
                if (n63 > n62) {
                    n62 = n63;
                    n60 = 1;
                }
                final int n64 = (int)(this.cp.n / 140.0f * 200.0f);
                if (n64 > n62) {
                    n62 = n64;
                    n60 = 2;
                }
                final int n65 = (int)(this.m.nrw * this.m.ncl / 16000.0f * 200.0f);
                if (n65 > n62) {
                    n62 = n65;
                    n60 = 3;
                }
                if (n62 > 200) {
                    n62 = 200;
                }
                if (n62 > 100) {
                    this.rd.setColor(new Color(200, 325 - n62, 30));
                }
                else {
                    this.rd.setColor(new Color(100 + n62, 225, 30));
                }
                this.rd.fillRect(167, 531, n62, 9);
                if (this.button("Memory Consumption :", 85, 540, 3, false)) {
                    JOptionPane.showMessageDialog(null, "Memory Consumption Details\n\nNumber of Parts:  " + n61 / 2 + " %\nPart's Details:  " + n63 / 2 + " %\nRoad Points:  " + n64 / 2 + " %\nStage Area:  " + n65 / 2 + " %\n \n", "Stage Maker", 1);
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRect(167, 531, 200, 9);
                final String[] array12 = { "Number of Parts", "Part's Details", "Road Points", "Stage Area" };
                this.rd.drawString(array12[n60], 267 - this.ftm.stringWidth(array12[n60]) / 2, 540);
                this.rd.drawString("" + n62 / 2 + " %  used", 375, 540);
                if (this.overcan) {
                    this.overcan = false;
                }
                if (!this.epart) {
                    if (this.hi != -1) {
                        this.hi = -1;
                    }
                    if (this.esp != -1) {
                        this.esp = -1;
                    }
                }
                else if (this.esp == -1) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Click on any part to Edit >", 257, 454);
                    if (this.button(" Cancel ", 323, 474, 4, false)) {
                        this.epart = false;
                    }
                }
                if (!this.arrng) {
                    if (this.chi != -1) {
                        this.chi = -1;
                    }
                }
                else {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Click on Checkpoint NO# " + (this.arrcnt + 1) + "  >", 257, 80);
                    if (this.button(" Cancel ", 330, 100, 4, false)) {
                        this.arrng = false;
                    }
                    if (this.arrcnt == this.cp.nsp) {
                        this.sortstage();
                        JOptionPane.showMessageDialog(null, "Checkpoints Arranged!\nPress Save and Test Drive to check the new checkpoint order.\n", "Stage Maker", 1);
                        this.arrng = false;
                    }
                }
            }
            if (this.tab == 2) {
                if (this.tabed != this.tab) {
                    this.m.trk = 0;
                    this.readstage(1);
                    this.setCursor(new Cursor(0));
                    this.setcur = false;
                    this.vxz = 0;
                    this.vx = this.sx - 400;
                    this.vz = this.sz - this.m.cz - 8000;
                    this.vy = -1500;
                    this.dtabed = -1;
                }
                this.m.trk = 0;
                this.m.zy = 6;
                this.m.iw = 10;
                this.m.w = 790;
                this.m.ih = 35;
                this.m.h = 445;
                this.m.cx = 400;
                this.m.cy = 215;
                this.m.xz = this.vxz;
                this.m.x = this.vx;
                this.m.z = this.vz;
                this.m.y = this.vy;
                this.m.d(this.rd);
                int n66 = 0;
                final int[] array13 = new int[200];
                for (int n67 = 0; n67 < this.nob; ++n67) {
                    if (this.co[n67].dist == 0) {
                        this.co[n67].d(this.rd);
                    }
                    else {
                        array13[n66] = n67;
                        ++n66;
                    }
                }
                final int[] array14 = new int[n66];
                for (int n68 = 0; n68 < n66; ++n68) {
                    array14[n68] = 0;
                }
                for (int n69 = 0; n69 < n66; ++n69) {
                    for (int n70 = n69 + 1; n70 < n66; ++n70) {
                        if (this.co[array13[n69]].dist == this.co[array13[n70]].dist) {
                            if (n70 <= n69) {
                                final int[] array15 = array14;
                                final int n71 = n70;
                                ++array15[n71];
                            }
                            else {
                                final int[] array16 = array14;
                                final int n72 = n69;
                                ++array16[n72];
                            }
                        }
                        else if (this.co[array13[n69]].dist >= this.co[array13[n70]].dist) {
                            final int[] array17 = array14;
                            final int n73 = n70;
                            ++array17[n73];
                        }
                        else {
                            final int[] array18 = array14;
                            final int n74 = n69;
                            ++array18[n74];
                        }
                    }
                }
                for (int n75 = 0; n75 < n66; ++n75) {
                    for (int n76 = 0; n76 < n66; ++n76) {
                        if (array14[n76] == n75) {
                            if (array13[n76] == this.hi) {
                                this.m.trk = 3;
                            }
                            this.co[array13[n76]].d(this.rd);
                            if (this.m.trk == 3) {
                                this.m.trk = 2;
                            }
                        }
                    }
                }
                if (this.up) {
                    this.vz += (int)(500.0f * this.m.cos(this.m.xz));
                    this.vx += (int)(500.0f * this.m.sin(this.m.xz));
                }
                if (this.down) {
                    this.vz -= (int)(500.0f * this.m.cos(this.m.xz));
                    this.vx -= (int)(500.0f * this.m.sin(this.m.xz));
                }
                if (this.left) {
                    this.vxz -= 5;
                }
                if (this.right) {
                    this.vxz += 5;
                }
                if (this.zoomi) {
                    this.vy += 100;
                    if (this.vy > -500) {
                        this.vy = -500;
                    }
                }
                if (this.zoomo) {
                    this.vy -= 100;
                    if (this.vy < -5000) {
                        this.vy = -5000;
                    }
                }
                this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillRect(0, 25, 10, 525);
                this.rd.fillRect(790, 25, 10, 525);
                this.rd.fillRect(10, 25, 780, 10);
                this.rd.fillRect(10, 445, 780, 105);
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                final String[] array19 = { "Controls", "Atmosphere", "Colors", "Scenery", "Laps", "Sound Track", "Test Drive" };
                final int[] array20 = { 10, 10, 121, 111 };
                final int[] array21 = { 425, 445, 445, 425 };
                for (int dtab = 0; dtab < 7; ++dtab) {
                    this.rd.setColor(new Color(170, 170, 170));
                    if (this.xm > array20[0]) {
                        if (this.xm < array20[3]) {
                            if (this.ym > 425) {
                                if (this.ym < 445) {
                                    this.rd.setColor(new Color(190, 190, 190));
                                }
                            }
                        }
                    }
                    if (this.dtab == dtab) {
                        this.rd.setColor(new Color(225, 225, 225));
                    }
                    this.rd.fillPolygon(array20, array21, 4);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(array19[dtab], dtab * 111 + 62 - this.ftm.stringWidth(array19[dtab]) / 2, 439);
                    if (this.xm > array20[0]) {
                        if (this.xm < array20[3]) {
                            if (this.ym > 425) {
                                if (this.ym < 445) {
                                    if (this.mouses == -1) {
                                        if (this.mouseon == -1) {
                                            this.dtab = dtab;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int n77 = 0; n77 < 4; ++n77) {
                        final int[] array22 = array20;
                        final int n78 = n77;
                        array22[n78] += 111;
                    }
                }
                if (this.tabed == this.tab) {
                    if (this.dtab != this.dtabed) {
                        if (!this.ttstage.equals("")) {
                            this.tstage = this.ttstage;
                            this.ttstage = "";
                        }
                        this.readstage(1);
                        this.hidefields();
                    }
                }
                if (this.dtab == 0) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Use the [ Keyboard Arrows ] to navigate through the stage.", 20, 470);
                    this.rd.drawString("[Left] & [Right] arrows are for rotating.  [Up] & [Down] arrows are for moving forwards and backwards.", 20, 490);
                    this.rd.drawString("For moving vertically down and up use the following keys:  [+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]", 20, 520);
                }
                if (this.dtab == 2) {
                    if (this.dtabed != this.dtab) {
                        Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], this.hsb[0]);
                        Color.RGBtoHSB(this.cfade[0], this.cfade[1], this.cfade[2], this.hsb[1]);
                        Color.RGBtoHSB(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2], this.hsb[2]);
                        for (int n79 = 0; n79 < 3; ++n79) {
                            final float n80 = this.hsb[n79][1];
                            this.hsb[n79][1] = this.hsb[n79][2];
                            this.hsb[n79][2] = n80;
                        }
                        Label_23888: {
                            if (this.hsb[1][1] == (this.hsb[0][1] + this.hsb[2][1]) / 2.0f) {
                                if (this.hsb[1][0] == this.hsb[2][0]) {
                                    if (this.hsb[1][2] == this.hsb[2][2]) {
                                        this.pfog.setState(true);
                                        break Label_23888;
                                    }
                                }
                            }
                            this.pfog.setState(false);
                        }
                        this.ttstage = "";
                        this.mouseon = -1;
                    }
                    if (this.mouses != 1) {
                        Label_24001: {
                            if (this.mouseon < 6) {
                                if (this.mouseon >= 3) {
                                    break Label_24001;
                                }
                            }
                            if (this.mouseon != -1) {
                                if (this.ttstage.equals("")) {
                                    this.ttstage = this.tstage;
                                }
                                this.sortop();
                                this.readstage(1);
                            }
                        }
                        this.mouseon = -1;
                    }
                    final String[] array23 = { "Sky", "Dust / Fog", "Ground" };
                    for (int n81 = 0; n81 < 3; ++n81) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(array23[n81], 107 + 195 * n81 - this.ftm.stringWidth(array23[n81]) / 2, 461);
                        for (int n82 = 0; n82 < 150; ++n82) {
                            this.rd.setColor(Color.getHSBColor((float)(n82 * 0.006667), 1.0f, 1.0f));
                            this.rd.drawLine(32 + n82 + 195 * n81, 467, 32 + n82 + 195 * n81, 474);
                        }
                        for (int n83 = 0; n83 < 150; ++n83) {
                            this.rd.setColor(Color.getHSBColor(0.0f, 0.0f, 0.5f + n83 * 0.00333f));
                            this.rd.drawLine(32 + n83 + 195 * n81, 483, 32 + n83 + 195 * n81, 490);
                        }
                        for (int n84 = 0; n84 < 150; ++n84) {
                            this.rd.setColor(Color.getHSBColor(this.hsb[n81][0], 0.0f + (float)(n84 * 0.001667), this.hsb[n81][1]));
                            this.rd.drawLine(32 + n84 + 195 * n81, 499, 32 + n84 + 195 * n81, 506);
                        }
                        for (int n85 = 0; n85 < 3; ++n85) {
                            this.rd.setColor(new Color(0, 0, 0));
                            float n86 = this.hsb[n81][n85] * 150.0f;
                            if (n85 == 1) {
                                float n87 = 0.75f;
                                if (n81 == 0) {
                                    n87 = 0.85f;
                                }
                                if (n81 == 1) {
                                    n87 = 0.8f;
                                }
                                n86 = (this.hsb[n81][n85] - n87) / 0.001f;
                            }
                            if (n85 == 2) {
                                n86 = this.hsb[n81][n85] * 600.0f;
                            }
                            if (n86 < 0.0f) {
                                n86 = 0.0f;
                            }
                            if (n86 > 150.0f) {
                                n86 = 150.0f;
                            }
                            this.rd.drawLine((int)(32 + 195 * n81 + n86), 467 + n85 * 16, (int)(32 + 195 * n81 + n86), 474 + n85 * 16);
                            this.rd.drawLine((int)(33 + 195 * n81 + n86), 467 + n85 * 16, (int)(33 + 195 * n81 + n86), 474 + n85 * 16);
                            this.rd.fillRect((int)(31 + 195 * n81 + n86), 475 + n85 * 16, 4, 2);
                            this.rd.drawLine((int)(30 + 195 * n81 + n86), 477 + n85 * 16, (int)(35 + 195 * n81 + n86), 477 + n85 * 16);
                            if (this.xm > 29 + 195 * n81) {
                                if (this.xm < 185 + 195 * n81) {
                                    if (this.ym > 468 + n85 * 16) {
                                        if (this.ym < 477 + n85 * 16) {
                                            if (this.mouses == 1) {
                                                if (this.mouseon == -1) {
                                                    this.mouseon = n85 + n81 * 3;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.mouseon == n85 + n81 * 3) {
                                if (n85 == 0) {
                                    this.hsb[n81][n85] = (this.xm - (32 + 195 * n81)) / 150.0f;
                                }
                                if (n85 == 1) {
                                    float n88 = 0.75f;
                                    if (n81 == 0) {
                                        n88 = 0.85f;
                                    }
                                    if (n81 == 1) {
                                        n88 = 0.8f;
                                    }
                                    this.hsb[n81][n85] = n88 + (this.xm - (32 + 195 * n81)) * 0.001f;
                                    if (this.hsb[n81][n85] < n88) {
                                        this.hsb[n81][n85] = n88;
                                    }
                                    if (this.hsb[n81][n85] > n88 + 0.15f) {
                                        this.hsb[n81][n85] = n88 + 0.15f;
                                    }
                                }
                                if (n85 == 2) {
                                    this.hsb[n81][n85] = (this.xm - (32 + 195 * n81)) / 600.0f;
                                    if (this.hsb[n81][n85] > 0.25) {
                                        this.hsb[n81][n85] = 0.25f;
                                    }
                                }
                                if (this.hsb[n81][n85] > 1.0f) {
                                    this.hsb[n81][n85] = 1.0f;
                                }
                                if (this.hsb[n81][n85] < 0.0f) {
                                    this.hsb[n81][n85] = 0.0f;
                                }
                            }
                        }
                    }
                    this.movefield(this.pfog, 258, 511, 200, 23);
                    if (!this.pfog.isShowing()) {
                        this.pfog.show();
                    }
                    if (this.pfog.getState()) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(215, 464, 175, 47);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                        this.hsb[1][1] = (this.hsb[0][1] + this.hsb[2][1]) / 2.0f;
                        this.hsb[1][0] = this.hsb[2][0];
                        this.hsb[1][2] = this.hsb[2][2];
                    }
                    final Color hsbColor = Color.getHSBColor(this.hsb[0][0], this.hsb[0][2], this.hsb[0][1]);
                    this.m.setsky(hsbColor.getRed(), hsbColor.getGreen(), hsbColor.getBlue());
                    this.csky[0] = hsbColor.getRed();
                    this.csky[1] = hsbColor.getGreen();
                    this.csky[2] = hsbColor.getBlue();
                    final Color hsbColor2 = Color.getHSBColor(this.hsb[1][0], this.hsb[1][2], this.hsb[1][1]);
                    this.m.setfade(hsbColor2.getRed(), hsbColor2.getGreen(), hsbColor2.getBlue());
                    this.cfade[0] = hsbColor2.getRed();
                    this.cfade[1] = hsbColor2.getGreen();
                    this.cfade[2] = hsbColor2.getBlue();
                    final Color hsbColor3 = Color.getHSBColor(this.hsb[2][0], this.hsb[2][2], this.hsb[2][1]);
                    this.m.setgrnd(hsbColor3.getRed(), hsbColor3.getGreen(), hsbColor3.getBlue());
                    this.cgrnd[0] = hsbColor3.getRed();
                    this.cgrnd[1] = hsbColor3.getGreen();
                    this.cgrnd[2] = hsbColor3.getBlue();
                    if (this.button(" Reset ", 650, 510, 0, true)) {
                        if (!this.ttstage.equals("")) {
                            this.tstage = this.ttstage;
                            this.ttstage = "";
                        }
                        this.readstage(1);
                        this.dtabed = -2;
                    }
                    if (this.button("        Save        ", 737, 510, 0, true)) {
                        this.sortop();
                        this.ttstage = "";
                        this.savefile();
                    }
                }
                if (this.dtab == 3) {
                    if (this.dtabed != this.dtab) {
                        Color.RGBtoHSB(this.cldd[0], this.cldd[1], this.cldd[2], this.hsb[0]);
                        Color.RGBtoHSB(this.texture[0], this.texture[1], this.texture[2], this.hsb[1]);
                        this.mgen.setText("" + this.m.mgen + "");
                        this.mouseon = -1;
                        this.ttstage = "";
                    }
                    if (this.mouses != 1) {
                        Label_26109: {
                            if (this.mouseon != 0) {
                                if (this.mouseon != 1) {
                                    if (this.mouseon != 2) {
                                        if (this.mouseon != 6) {
                                            break Label_26109;
                                        }
                                    }
                                }
                            }
                            if (this.ttstage.equals("")) {
                                this.ttstage = this.tstage;
                            }
                            this.sortop();
                            this.readstage(1);
                        }
                        this.mouseon = -1;
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Clouds", 32, 461);
                    for (int n89 = 0; n89 < 150; ++n89) {
                        this.rd.setColor(Color.getHSBColor(n89 * 0.006667f, 1.0f, 1.0f));
                        this.rd.drawLine(32 + n89 + 0, 467, 32 + n89 + 0, 474);
                    }
                    for (int n90 = 0; n90 < 150; ++n90) {
                        this.rd.setColor(Color.getHSBColor(0.0f, 0.0f, 0.75f + n90 * 0.001667f));
                        this.rd.drawLine(32 + n90 + 0, 483, 32 + n90 + 0, 490);
                    }
                    for (int n91 = 0; n91 < 150; ++n91) {
                        this.rd.setColor(Color.getHSBColor(this.hsb[0][0], n91 * 0.003333f, this.hsb[0][2]));
                        this.rd.drawLine(32 + n91 + 0, 499, 32 + n91 + 0, 506);
                    }
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Blend:", 32, 529);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(70, 522, 112, 2);
                    this.rd.fillRect(70, 528, 112, 2);
                    float n92 = 0.0f;
                    for (int n93 = 0; n93 < 112; ++n93) {
                        int n94 = (int)(255.0f / (n92 + 1.0f));
                        if (n94 > 255) {
                            n94 = 255;
                        }
                        if (n94 < 0) {
                            n94 = 0;
                        }
                        n92 += 0.02f;
                        this.rd.setColor(new Color(n94, n94, n94));
                        this.rd.drawLine(70 + n93, 524, 70 + n93, 527);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Height", 202 - this.ftm.stringWidth("Height") / 2, 461);
                    this.rd.drawLine(202, 467, 202, 530);
                    for (int n95 = 0; n95 < 8; ++n95) {
                        this.rd.drawLine(202, 466 + n95 * 8, 202 + (8 - n95), 466 + n95 * 8);
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Ground Texture", 257, 471);
                    for (int n96 = 0; n96 < 150; ++n96) {
                        this.rd.setColor(Color.getHSBColor(n96 * 0.006667f, 1.0f, 1.0f));
                        this.rd.drawLine(32 + n96 + 225, 477, 32 + n96 + 225, 484);
                    }
                    for (int n97 = 0; n97 < 150; ++n97) {
                        this.rd.setColor(Color.getHSBColor(this.hsb[1][0], n97 * 0.006667f, n97 * 0.006667f));
                        this.rd.drawLine(32 + n97 + 225, 493, 32 + n97 + 225, 500);
                    }
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Blend:", 257, 523);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(295, 516, 112, 2);
                    this.rd.fillRect(295, 522, 112, 2);
                    float n98 = 0.0f;
                    for (int n99 = 0; n99 < 112; ++n99) {
                        int n100 = (int)(255.0f / (n98 + 1.0f));
                        if (n100 > 255) {
                            n100 = 255;
                        }
                        if (n100 < 0) {
                            n100 = 0;
                        }
                        n98 += 0.02f;
                        this.rd.setColor(new Color(n100, n100, n100));
                        this.rd.drawLine(70 + n99 + 225, 518, 70 + n99 + 225, 521);
                    }
                    for (int n101 = 0; n101 < 2; ++n101) {
                        int n102 = 3;
                        if (n101 == 1) {
                            n102 = 2;
                        }
                        for (int n103 = 0; n103 < n102; ++n103) {
                            int n104;
                            if ((n104 = n103) == 1) {
                                n104 = 2;
                            }
                            if (n103 == 2) {
                                n104 = 1;
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            float n105 = this.hsb[n101][n104] * 150.0f;
                            if (n103 == 1) {
                                if (n101 == 0) {
                                    n105 = (this.hsb[n101][n104] - 0.75f) / 0.001667f;
                                }
                            }
                            if (n103 == 2) {
                                if (n101 == 0) {
                                    n105 = this.hsb[n101][n104] / 0.003333f;
                                }
                            }
                            if (n105 < 0.0f) {
                                n105 = 0.0f;
                            }
                            if (n105 > 150.0f) {
                                n105 = 150.0f;
                            }
                            this.rd.drawLine((int)(32 + 225 * n101 + n105), 467 + n103 * 16 + 10 * n101, (int)(32 + 225 * n101 + n105), 474 + n103 * 16 + 10 * n101);
                            this.rd.drawLine((int)(33 + 225 * n101 + n105), 467 + n103 * 16 + 10 * n101, (int)(33 + 225 * n101 + n105), 474 + n103 * 16 + 10 * n101);
                            this.rd.fillRect((int)(31 + 225 * n101 + n105), 475 + n103 * 16 + 10 * n101, 4, 2);
                            this.rd.drawLine((int)(30 + 225 * n101 + n105), 477 + n103 * 16 + 10 * n101, (int)(35 + 225 * n101 + n105), 477 + n103 * 16 + 10 * n101);
                            if (this.xm > 29 + 225 * n101) {
                                if (this.xm < 185 + 225 * n101) {
                                    if (this.ym > 468 + n103 * 16 + 10 * n101) {
                                        if (this.ym < 477 + n103 * 16 + 10 * n101) {
                                            if (this.mouses == 1) {
                                                if (this.mouseon == -1) {
                                                    this.mouseon = n103 + n101 * 3;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.mouseon == n103 + n101 * 3) {
                                this.hsb[n101][n104] = (this.xm - (32 + 225 * n101)) * 0.006667f;
                                if (n103 == 1) {
                                    if (n101 == 1) {
                                        this.hsb[n101][1] = (this.xm - (32 + 225 * n101)) * 0.006667f;
                                        if (this.hsb[n101][1] > 1.0f) {
                                            this.hsb[n101][1] = 1.0f;
                                        }
                                        if (this.hsb[n101][1] < 0.0f) {
                                            this.hsb[n101][1] = 0.0f;
                                        }
                                    }
                                }
                                if (n103 == 1) {
                                    if (n101 == 0) {
                                        final float n106 = 0.75f;
                                        this.hsb[n101][n104] = n106 + (this.xm - (32 + 225 * n101)) * 0.001667f;
                                        if (this.hsb[n101][n104] < n106) {
                                            this.hsb[n101][n104] = n106;
                                        }
                                    }
                                }
                                if (n103 == 2) {
                                    if (n101 == 0) {
                                        this.hsb[n101][n104] = (this.xm - (32 + 225 * n101)) * 0.003333f;
                                        if (this.hsb[n101][n104] > 0.5) {
                                            this.hsb[n101][n104] = 0.5f;
                                        }
                                    }
                                }
                                if (this.hsb[n101][n104] > 1.0f) {
                                    this.hsb[n101][n104] = 1.0f;
                                }
                                if (this.hsb[n101][n104] < 0.0f) {
                                    this.hsb[n101][n104] = 0.0f;
                                }
                            }
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        float n107 = (this.texture[3] - 20) * 2.8f;
                        if (n101 == 0) {
                            n107 = this.cldd[3] * 11.2f;
                        }
                        if (n107 < 0.0f) {
                            n107 = 0.0f;
                        }
                        if (n107 > 112.0f) {
                            n107 = 112.0f;
                        }
                        this.rd.drawLine((int)(70 + 225 * n101 + n107), 522 - 6 * n101, (int)(70 + 225 * n101 + n107), 529 - 6 * n101);
                        this.rd.drawLine((int)(71 + 225 * n101 + n107), 522 - 6 * n101, (int)(71 + 225 * n101 + n107), 529 - 6 * n101);
                        this.rd.fillRect((int)(69 + 225 * n101 + n107), 530 - 6 * n101, 4, 2);
                        this.rd.drawLine((int)(68 + 225 * n101 + n107), 532 - 6 * n101, (int)(73 + 225 * n101 + n107), 532 - 6 * n101);
                        if (this.xm > 67 + 225 * n101) {
                            if (this.xm < 185 + 225 * n101) {
                                if (this.ym > 522 - 6 * n101) {
                                    if (this.ym < 532 - 6 * n101) {
                                        if (this.mouses == 1) {
                                            if (this.mouseon == -1) {
                                                this.mouseon = 6 + n101;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.mouseon == 6) {
                        this.cldd[3] = (int)((this.xm - 70) / 11.2f);
                        if (this.cldd[3] < 0) {
                            this.cldd[3] = 0;
                        }
                        if (this.cldd[3] > 10) {
                            this.cldd[3] = 10;
                        }
                    }
                    if (this.mouseon == 7) {
                        this.texture[3] = (int)((this.xm - 70 - 225) / 2.8 + 20.0);
                        if (this.texture[3] < 20) {
                            this.texture[3] = 20;
                        }
                        if (this.texture[3] > 60) {
                            this.texture[3] = 60;
                        }
                    }
                    this.rd.setColor(new Color(0, 128, 255));
                    float n108 = (1500 - Math.abs(this.cldd[4])) / 15.625f;
                    if (n108 > 64.0f) {
                        n108 = 64.0f;
                    }
                    if (n108 < 0.0f) {
                        n108 = 0.0f;
                    }
                    this.rd.drawRect(199, (int)(465.0f + n108), 12, 2);
                    if (this.xm > 197) {
                        if (this.xm < 213) {
                            if (this.ym > 463) {
                                if (this.ym < 533) {
                                    if (this.mouses == 1) {
                                        if (this.mouseon == -1) {
                                            this.mouseon = 8;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.mouseon == 8) {
                        this.cldd[4] = -(int)((530 - this.ym) * 15.625f + 500.0f);
                        if (this.cldd[4] > -500) {
                            this.cldd[4] = -500;
                        }
                        if (this.cldd[4] < -1500) {
                            this.cldd[4] = -1500;
                        }
                    }
                    final Color hsbColor4 = Color.getHSBColor(this.hsb[0][0], this.hsb[0][1], this.hsb[0][2]);
                    this.m.setcloads(hsbColor4.getRed(), hsbColor4.getGreen(), hsbColor4.getBlue(), this.cldd[3], this.cldd[4]);
                    this.cldd[0] = hsbColor4.getRed();
                    this.cldd[1] = hsbColor4.getGreen();
                    this.cldd[2] = hsbColor4.getBlue();
                    final Color hsbColor5 = Color.getHSBColor(this.hsb[1][0], this.hsb[1][1], this.hsb[1][2]);
                    this.m.setexture(hsbColor5.getRed(), hsbColor5.getGreen(), hsbColor5.getBlue(), this.texture[3]);
                    this.texture[0] = hsbColor5.getRed();
                    this.texture[1] = hsbColor5.getGreen();
                    this.texture[2] = hsbColor5.getBlue();
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Mountains", 452, 465);
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.rd.drawString("Mountain Generator Key:", 452, 480);
                    this.movefield(this.mgen, 452, 484, 120, 20);
                    if (this.mgen.hasFocus()) {
                        this.focuson = false;
                    }
                    if (!this.mgen.isShowing()) {
                        this.mgen.show();
                    }
                    if (this.button("  Generate New  ", 512, 525, 3, true)) {
                        this.m.mgen = (int)(Math.random() * 100000.0);
                        this.mgen.setText("" + this.m.mgen + "");
                        if (this.ttstage.equals("")) {
                            this.ttstage = this.tstage;
                        }
                        this.sortop();
                        this.readstage(1);
                    }
                    if (!this.mgen.getText().equals("" + this.m.mgen + "")) {
                        try {
                            this.m.mgen = Integer.valueOf(this.mgen.getText());
                            if (this.ttstage.equals("")) {
                                this.ttstage = this.tstage;
                            }
                            this.sortop();
                            this.readstage(1);
                        }
                        catch (Exception ex6) {
                            this.mgen.setText("" + this.m.mgen + "");
                        }
                    }
                    if (this.button(" Reset ", 650, 510, 0, true)) {
                        if (!this.ttstage.equals("")) {
                            this.tstage = this.ttstage;
                            this.ttstage = "";
                        }
                        this.readstage(1);
                        this.dtabed = -2;
                    }
                    if (this.button("        Save        ", 737, 510, 0, true)) {
                        this.sortop();
                        this.ttstage = "";
                        this.savefile();
                    }
                }
                if (this.dtab == 1) {
                    if (this.dtabed != this.dtab) {
                        for (int n109 = 0; n109 < 3; ++n109) {
                            this.snap[n109] = (int)(this.m.snap[n109] / 1.2f + 50.0f);
                        }
                        this.fogn[0] = (8 - ((this.m.fogd + 1) / 2 - 1)) * 20;
                        this.fogn[1] = (this.m.fade[0] - 5000) / 30;
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Atmosphere RGB Mask", 20, 461);
                    this.rd.setColor(new Color(128, 128, 128));
                    this.rd.drawLine(10, 457, 17, 457);
                    this.rd.drawLine(260, 457, 152, 457);
                    this.rd.drawLine(10, 457, 10, 546);
                    this.rd.drawLine(260, 457, 260, 527);
                    this.rd.drawLine(260, 527, 360, 527);
                    this.rd.drawLine(10, 546, 360, 546);
                    this.rd.drawLine(360, 527, 360, 546);
                    final String[] array24 = { "Red", "Green", "Blue" };
                    final int[] array25 = { 32, 20, 29 };
                    final int n110 = 38;
                    final int n111 = -70;
                    for (int n112 = 0; n112 < 3; ++n112) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("" + array24[n112] + " :", array25[n112], 447 + n112 * 24 + n110);
                        this.rd.drawLine(140 + n111, 443 + (n112 * 24 + n110), 230 + n111, 443 + n112 * 24 + n110);
                        for (int n113 = 1; n113 < 10; ++n113) {
                            this.rd.drawLine(140 + 10 * n113 + n111, 443 - n113 + n112 * 24 + n110, 140 + 10 * n113 + n111, 443 + n113 + n112 * 24 + n110);
                        }
                        this.rd.setColor(new Color(255, 0, 0));
                        final int n114 = (int)(this.snap[n112] / 1.1111f / 10.0f);
                        this.rd.fillRect(138 + (int)(this.snap[n112] / 1.1111f) + n111, 443 - n114 + n112 * 24 + n110, 5, n114 * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(139 + (int)(this.snap[n112] / 1.1111f) + n111, 434 + n112 * 24 + n110, 2, 18);
                        if (this.button(" - ", 260 + n111, 447 + n112 * 24 + n110, 4, false)) {
                            final int[] snap = this.snap;
                            final int n115 = n112;
                            snap[n115] -= 2;
                            if (this.snap[n112] < 0) {
                                this.snap[n112] = 0;
                            }
                        }
                        if (this.button(" + ", 300 + n111, 447 + n112 * 24 + n110, 4, false)) {
                            if (this.snap[0] + this.snap[1] + this.snap[2] > 200) {
                                for (int n116 = 0; n116 < 3; ++n116) {
                                    if (n116 != n112) {
                                        final int[] snap2 = this.snap;
                                        final int n117 = n116;
                                        --snap2[n117];
                                        if (this.snap[n116] < 0) {
                                            this.snap[n116] = 0;
                                        }
                                    }
                                }
                            }
                            final int[] snap3 = this.snap;
                            final int n118 = n112;
                            snap3[n118] += 2;
                            if (this.snap[n112] > 100) {
                                this.snap[n112] = 100;
                            }
                        }
                    }
                    Label_31147: {
                        if (this.m.snap[0] == (int)(this.snap[0] * 1.2f - 60.0f)) {
                            if (this.m.snap[1] == (int)(this.snap[1] * 1.2f - 60.0f)) {
                                if (this.m.snap[2] == (int)(this.snap[2] * 1.2f - 60.0f)) {
                                    break Label_31147;
                                }
                            }
                        }
                        for (int n119 = 0; n119 < 3; ++n119) {
                            this.m.snap[n119] = (int)(this.snap[n119] * 1.2f - 60.0f);
                        }
                        this.readstage(2);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Car Lights :", 265, 541);
                    if (this.snap[0] + this.snap[1] + this.snap[2] <= 110) {
                        this.rd.setColor(new Color(0, 200, 0));
                        this.rd.drawString("On", 335, 541);
                        this.m.lightson = true;
                    }
                    else {
                        this.rd.drawString("Off", 335, 541);
                        this.m.lightson = false;
                    }
                    final int n120 = 33;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dust/Fog Properties", 280 + n120, 461);
                    this.rd.setColor(new Color(128, 128, 128));
                    this.rd.drawLine(270 + n120, 457, 277 + n120, 457);
                    this.rd.drawLine(540 + n120, 457, 393 + n120, 457);
                    this.rd.drawLine(270 + n120, 457, 270 + n120, 522);
                    this.rd.drawLine(540 + n120, 457, 540 + n120, 522);
                    this.rd.drawLine(270 + n120, 522, 540 + n120, 522);
                    final String[] array26 = { "Density", "Near / Far" };
                    final int[] array27 = { 292 + n120, 280 + n120 };
                    final int[] array28 = { 20, 10 };
                    final int n121 = 38;
                    final int n122 = 210 + n120;
                    for (int n123 = 0; n123 < 2; ++n123) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("" + array26[n123] + " :", array27[n123], 447 + n123 * 24 + n121);
                        this.rd.drawLine(140 + n122, 443 + (n123 * 24 + n121), 230 + n122, 443 + n123 * 24 + n121);
                        for (int n124 = 1; n124 < 10; ++n124) {
                            this.rd.drawLine(140 + 10 * n124 + n122, 443 - n124 + n123 * 24 + n121, 140 + 10 * n124 + n122, 443 + n124 + n123 * 24 + n121);
                        }
                        this.rd.setColor(new Color(255, 0, 0));
                        final int n125 = (int)(this.fogn[n123] / 1.1111f / 10.0f);
                        this.rd.fillRect(138 + (int)(this.fogn[n123] / 1.1111f) + n122, 443 - n125 + n123 * 24 + n121, 5, n125 * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(139 + (int)(this.fogn[n123] / 1.1111f) + n122, 434 + n123 * 24 + n121, 2, 18);
                        if (this.button(" - ", 260 + n122, 447 + n123 * 24 + n121, 4, false)) {
                            final int[] fogn = this.fogn;
                            final int n126 = n123;
                            fogn[n126] -= array28[n123];
                            if (this.fogn[n123] < 0) {
                                this.fogn[n123] = 0;
                            }
                        }
                        if (this.button(" + ", 300 + n122, 447 + n123 * 24 + n121, 4, false)) {
                            final int[] fogn2 = this.fogn;
                            final int n127 = n123;
                            fogn2[n127] += array28[n123];
                            if (this.fogn[n123] > 100) {
                                this.fogn[n123] = 100;
                            }
                        }
                    }
                    this.m.fogd = (8 - this.fogn[0] / 20 + 1) * 2 - 1;
                    this.m.fadfrom(5000 + this.fogn[1] * 30);
                    this.origfade = this.m.fade[0];
                    if (this.button(" Reset ", 650, 510, 0, true)) {
                        this.dtabed = -2;
                    }
                    if (this.button("        Save        ", 737, 510, 0, true)) {
                        this.sortop();
                        this.savefile();
                    }
                }
                if (this.dtab == 4) {
                    if (this.dtabed != this.dtab) {
                        if (this.cp.nlaps - 1 >= 0) {
                            if (this.cp.nlaps - 1 <= 14) {
                                this.nlaps.select(this.cp.nlaps - 1);
                            }
                        }
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Set the number of laps for this stage:", 130, 496);
                    this.nlaps.move(348, 480);
                    if (!this.nlaps.isShowing()) {
                        this.nlaps.show();
                    }
                    if (this.cp.nlaps != this.nlaps.getSelectedIndex() + 1) {
                        this.cp.nlaps = this.nlaps.getSelectedIndex() + 1;
                        this.requestFocus();
                    }
                    if (this.button(" Reset ", 530, 496, 0, true)) {
                        this.dtabed = -2;
                    }
                    if (this.button("        Save        ", 617, 496, 0, true)) {
                        this.sortop();
                        this.savefile();
                    }
                }
                if (this.dtab == 5) {
                    if (this.dtabed != this.dtab) {
                        this.tracks.removeAll();
                        this.tracks.maxl = 200;
                        this.tracks.add(this.rd, "The Play List  -  MOD Tracks");
                        final String[] list2 = new File("" + Madness.fpath + "mystages/mymusic/").list();
                        if (list2 != null) {
                            for (int n128 = 0; n128 < list2.length; ++n128) {
                                if (list2[n128].toLowerCase().endsWith(".zip")) {
                                    this.tracks.add(this.rd, list2[n128].substring(0, list2[n128].length() - 4));
                                }
                            }
                        }
                        if (!this.ltrackname.equals("")) {
                            this.tracks.select(this.ltrackname);
                        }
                        else if (!this.trackname.equals("")) {
                            this.tracks.select(this.trackname);
                        }
                        else {
                            this.tracks.select(0);
                        }
                        this.mouseon = -1;
                    }
                    this.tracks.move(10, 450);
                    if (this.tracks.getWidth() != 200) {
                        this.tracks.setSize(200, 21);
                    }
                    if (!this.tracks.isShowing()) {
                        this.tracks.show();
                    }
                    Label_33745: {
                        if (this.track.playing) {
                            if (this.track.loaded == 2) {
                                if (this.button("      Stop      ", 110, 495, 2, false)) {
                                    this.track.stop();
                                }
                                if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                                    this.track.stop();
                                }
                                Label_33059: {
                                    if (this.xm > 10) {
                                        if (this.xm < 210) {
                                            if (this.ym > 516) {
                                                if (this.ym < 534) {
                                                    if (this.mouses == 1) {
                                                        this.mouseon = 1;
                                                    }
                                                    this.rd.setColor(new Color(0, 164, 242));
                                                    break Label_33059;
                                                }
                                            }
                                        }
                                    }
                                    this.rd.setColor(new Color(120, 210, 255));
                                }
                                this.rd.drawRect(10, 516, 200, 18);
                                this.rd.setColor(new Color(200, 200, 200));
                                this.rd.drawLine(10, 523, 210, 523);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawLine(10, 524, 210, 524);
                                this.rd.drawLine(10, 525, 210, 525);
                                this.rd.drawLine(10, 526, 210, 526);
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.drawLine(10, 527, 210, 527);
                                int n129 = (int)((1.0f - this.track.sClip.stream.available() / this.avon) * 200.0f);
                                if (this.mouseon == 1) {
                                    n129 = this.xm - 10;
                                    if (n129 < 0) {
                                        n129 = 0;
                                    }
                                    if (n129 > 200) {
                                        n129 = 200;
                                    }
                                    if (this.mouses != 1) {
                                        this.track.sClip.stream.reset();
                                        this.track.sClip.stream.skip((long)(n129 / 200.0f * this.avon));
                                        this.mouseon = -1;
                                    }
                                }
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRect(8 + n129, 516, 4, 18);
                                this.rd.setColor(new Color(0, 164, 242));
                                this.rd.drawLine(10 + n129, 520, 10 + n129, 518);
                                this.rd.drawLine(10 + n129, 530, 10 + n129, 532);
                                break Label_33745;
                            }
                        }
                        if (this.tracks.getSelectedIndex() != 0) {
                            if (this.button("      Play  >      ", 110, 495, 2, false)) {
                                if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                                    this.track.unload();
                                    this.track = new RadicalMod("mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip", 300, 8000, 125, true, false);
                                    if (this.track.loaded != 2) {
                                        this.ltrackname = "";
                                    }
                                    else {
                                        this.avon = this.track.sClip.stream.available();
                                        this.ltrackname = this.tracks.getSelectedItem();
                                    }
                                }
                                if (this.ltrackname.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Failed to load '" + this.tracks.getSelectedItem() + "', please make sure it is a valid MOD Track!", "Stage Maker", 1);
                                }
                                else {
                                    this.track.play();
                                }
                            }
                        }
                    }
                    if (this.tracks.getSelectedIndex() != 0) {
                        if (this.button("   Set as the stage's Sound Track  >   ", 330, 466, 2, false)) {
                            if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                                this.track.unload();
                                this.track = new RadicalMod("mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip", 300, 8000, 125, true, false);
                                if (this.track.loaded != 2) {
                                    this.ltrackname = "";
                                }
                                else {
                                    this.avon = this.track.sClip.stream.available();
                                    this.ltrackname = this.tracks.getSelectedItem();
                                }
                            }
                            if (this.ltrackname.equals("")) {
                                JOptionPane.showMessageDialog(null, "Failed to load '" + this.tracks.getSelectedItem() + "', please make sure it is a valid MOD Track!", "Stage Maker", 1);
                            }
                            else {
                                this.trackname = this.ltrackname;
                                this.trackvol = (int)(220.0f / (this.track.rvol / 3750.0f));
                                try {
                                    this.tracksize = (int)(new File("" + Madness.fpath + "mystages/mymusic/" + this.trackname + ".zip").length() / 1024L);
                                    if (this.tracksize > 700) {
                                        JOptionPane.showMessageDialog(null, "Cannot use '" + this.tracks.getSelectedItem() + "' as the sound track!\nIts file size is bigger then 700KB.\n\n", "Stage Maker", 1);
                                        this.trackname = "";
                                    }
                                }
                                catch (Exception ex7) {
                                    this.tracksize = 111;
                                }
                            }
                        }
                        if (this.button("   X Delete   ", 258, 495, 2, false)) {
                            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete this MOD Track from your Play List?\n\n" + this.tracks.getSelectedItem() + "\n\n>  If you delete this Track from the Play List you will not be able to use it for other stages as well!     \n\n", "Stage Maker", 0) == 0) {
                                this.deltrack();
                            }
                        }
                    }
                    if (this.button("      Add a new Track from a file . . .     ", 330, 530, 0, false)) {
                        if (JOptionPane.showConfirmDialog(null, "The game only accepts Module format music files for the game ('.mod', '.xm' and '.s3m' file extensions).\nA good place to find Module Tracks is the modarchive.com, all the current Module Tracks\nthat are distributed with the game are from the modarchive.com.\n\nTo find out more about Module Tracks and to learn how to compose & remix your own\nmusic, please read the section of the Stage Maker help about it.\n\nThe Stage Maker accepts only '.mod', '.xm' & '.s3m' files or a '.zip' file containing a Module file.\nThe file size of the Module must be less the 700KB (when compressed as a zip file).\n", "Stage Maker", 0) == 0) {
                            File file = null;
                            final FileDialog fileDialog = new FileDialog(new Frame(), "Stage Maker - Add MOD Track file to stage sound track play list!");
                            fileDialog.setFile("*.mod;*.xm;*.s3m;*.zip");
                            fileDialog.setMode(0);
                            fileDialog.setVisible(true);
                            try {
                                if (fileDialog.getFile() != null) {
                                    file = new File("" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "");
                                }
                            }
                            catch (Exception ex8) {}
                            if (file != null) {
                                try {
                                    Label_35049: {
                                        if (!fileDialog.getFile().toLowerCase().endsWith(".mod")) {
                                            if (!fileDialog.getFile().toLowerCase().endsWith(".xm")) {
                                                if (!fileDialog.getFile().toLowerCase().endsWith(".s3m")) {
                                                    if (file.length() / 1024L >= 700L) {
                                                        JOptionPane.showMessageDialog(null, "The selected file is larger then 700KB in size and therefore cannot be added!", "Stage Maker", 1);
                                                        break Label_35049;
                                                    }
                                                    final File file2 = new File("" + Madness.fpath + "mystages/mymusic/");
                                                    if (!file2.exists()) {
                                                        file2.mkdirs();
                                                    }
                                                    final File file3 = new File("" + Madness.fpath + "mystages/mymusic/" + file.getName() + "");
                                                    final FileInputStream fileInputStream = new FileInputStream(file);
                                                    final FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                                    final byte[] array29 = new byte[1024];
                                                    int read;
                                                    while ((read = fileInputStream.read(array29)) > 0) {
                                                        fileOutputStream.write(array29, 0, read);
                                                    }
                                                    fileInputStream.close();
                                                    fileOutputStream.close();
                                                    break Label_35049;
                                                }
                                            }
                                        }
                                        final File file4 = new File("" + Madness.fpath + "mystages/mymusic/");
                                        if (!file4.exists()) {
                                            file4.mkdirs();
                                        }
                                        final String string = "" + Madness.fpath + "mystages/mymusic/" + file.getName().substring(0, file.getName().length() - 4) + ".zip";
                                        final FileInputStream fileInputStream2 = new FileInputStream(file);
                                        final ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(string));
                                        final ZipEntry zipEntry = new ZipEntry("" + file.getName() + "");
                                        zipEntry.setSize(file.length());
                                        zipOutputStream.putNextEntry(zipEntry);
                                        final byte[] array30 = new byte[1024];
                                        int read2;
                                        while ((read2 = fileInputStream2.read(array30)) > 0) {
                                            zipOutputStream.write(array30, 0, read2);
                                        }
                                        zipOutputStream.closeEntry();
                                        zipOutputStream.close();
                                        fileInputStream2.close();
                                        final File file5 = new File("" + Madness.fpath + "mystages/mymusic/" + file.getName() + ".zip");
                                        if (file5.length() / 1024L >= 700L) {
                                            JOptionPane.showMessageDialog(null, "The selected file is larger then 700KB in size when zipped and therefore cannot be added!", "Stage Maker", 1);
                                            file5.delete();
                                        }
                                    }
                                    this.tracks.removeAll();
                                    this.tracks.add(this.rd, "Select MOD Track                      ");
                                    final String[] list3 = new File("" + Madness.fpath + "mystages/mymusic/").list();
                                    if (list3 != null) {
                                        for (int n130 = 0; n130 < list3.length; ++n130) {
                                            if (list3[n130].toLowerCase().endsWith(".zip")) {
                                                this.tracks.add(this.rd, list3[n130].substring(0, list3[n130].length() - 4));
                                            }
                                        }
                                    }
                                    this.tracks.select(file.getName().substring(0, file.getName().length() - 4));
                                }
                                catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Unable to copy file! Error Deatials:\n" + ex, "Stage Maker", 1);
                                }
                            }
                        }
                    }
                    final int n131 = 200;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Sound Track", 280 + n131, 461);
                    String trackname = this.trackname;
                    if (!trackname.equals("")) {
                        if (this.button("   <  Remove Track   ", 378, 495, 2, false)) {
                            this.trackname = "";
                        }
                    }
                    else {
                        trackname = "No Sound Track set.";
                    }
                    this.rd.drawString(trackname, 629 - this.ftm.stringWidth(trackname) / 2, 482);
                    this.rd.setColor(new Color(128, 128, 128));
                    this.rd.drawLine(270 + n131, 457, 277 + n131, 457);
                    this.rd.drawLine(589 + n131, 457, 353 + n131, 457);
                    this.rd.drawLine(270 + n131, 457, 270 + n131, 497);
                    this.rd.drawLine(589 + n131, 457, 589 + n131, 497);
                    this.rd.drawLine(270 + n131, 497, 589 + n131, 497);
                    if (this.button(" Reset ", 576, 530, 0, true)) {
                        this.ltrackname = "";
                        this.dtabed = -2;
                    }
                    if (this.button("        Save        ", 663, 530, 0, true)) {
                        this.sortop();
                        this.savefile();
                    }
                }
                if (this.dtab == 6) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Test Drive the Stage", 400 - this.ftm.stringWidth("Test Drive the Stage") / 2, 470);
                    this.witho.move(342, 480);
                    if (!this.witho.isShowing()) {
                        this.witho.show();
                    }
                    if (this.button("     TEST DRIVE!     ", 400, 530, 0, true)) {
                        this.savefile();
                        this.errd = 0;
                        this.readstage(3);
                        if (this.cp.nsp < 2) {
                            this.errd = 7;
                        }
                        if (this.errd != 0) {
                            JOptionPane.showMessageDialog(null, "Error!  This stage is not ready for a test drive!\nReason:\n" + this.errlo[this.errd - 1] + "\n\n", "Stage Maker", 0);
                        }
                        else {
                            Madness.testcar = this.stagename;
                            Madness.testdrive = this.witho.getSelectedIndex() + 3;
                            Madness.game();
                        }
                    }
                }
                if (this.dtabed != this.dtab) {
                    if (this.dtabed != -2) {
                        this.dtabed = this.dtab;
                    }
                    else {
                        this.dtabed = -1;
                    }
                }
            }
            if (this.tab == 3) {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Publish Stage :  [ " + this.stagename + " ]", 30, 50);
                this.rd.drawString("Publishing Type :", 30, 80);
                this.pubtyp.move(150, 63);
                if (!this.pubtyp.isShowing()) {
                    this.pubtyp.show();
                    this.pubtyp.select(1);
                }
                this.pubitem.move(790 - this.pubitem.w, 96);
                if (!this.pubitem.isShowing()) {
                    this.pubitem.show();
                }
                if (this.pubitem.sel != 0) {
                    boolean b5 = false;
                    for (int n132 = 0; n132 < this.nms; ++n132) {
                        if (this.pubitem.getSelectedItem().equals(this.mystages[n132])) {
                            b5 = true;
                        }
                    }
                    if (!b5) {
                        this.logged = 2;
                    }
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 0, 12));
                if (this.pubtyp.getSelectedIndex() == 0) {
                    this.rd.drawString("Private :  This means only you can have your stage in your account and no one else can add", 268, 72);
                    this.rd.drawString("it to their account to play it!", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 1) {
                    this.rd.drawString("Public :  This means anyone can add this stage to their account to play it, but only you can", 268, 72);
                    this.rd.drawString("download it to your Stage Maker and edit it (no one else but you can edit it).", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 2) {
                    this.rd.drawString("Super Public :  This means anyone can add this stage to their account to play it and can also", 268, 72);
                    this.rd.drawString("download it to their stage Maker, edit it and publish it.", 268, 88);
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("Stage Name", 180 - this.ftm.stringWidth("Stage Name") / 2, 138);
                this.rd.drawString("Created By", 400 - this.ftm.stringWidth("Created By") / 2, 138);
                this.rd.drawString("Added By", 500 - this.ftm.stringWidth("Added By") / 2, 138);
                this.rd.drawString("Publish Type", 600 - this.ftm.stringWidth("Publish Type") / 2, 138);
                this.rd.drawString("Options", 720 - this.ftm.stringWidth("Options") / 2, 138);
                this.rd.drawLine(350, 129, 350, 140);
                this.rd.drawLine(450, 129, 450, 140);
                this.rd.drawLine(550, 129, 550, 140);
                this.rd.drawLine(650, 129, 650, 140);
                this.rd.drawRect(10, 140, 780, 402);
                Label_38627: {
                    if (this.button("       Publish  >       ", 102, 110, 0, true)) {
                        if (this.logged == 0) {
                            JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Stage Maker", 1);
                        }
                        if (this.logged != 3) {
                            if (this.logged != -1) {
                                break Label_38627;
                            }
                        }
                        this.savefile();
                        this.errd = 0;
                        this.readstage(3);
                        if (this.cp.nsp < 2) {
                            this.errd = 7;
                        }
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.ftm.stringWidth(this.stagename) > 274) {
                            this.errd = 8;
                        }
                        if (this.errd != 0) {
                            JOptionPane.showMessageDialog(null, "Error!  This stage is not ready for publishing!\nReason:\n" + this.errlo[this.errd - 1] + "\n\n", "Stage Maker", 0);
                        }
                        else {
                            int showConfirmDialog = 0;
                            for (int n133 = 0; n133 < this.pubitem.no; ++n133) {
                                if (this.pubitem.opts[n133].equals(this.stagename)) {
                                    showConfirmDialog = JOptionPane.showConfirmDialog(null, "Replace your already online stage '" + this.stagename + "' with this one?", "Stage Maker", 0);
                                }
                            }
                            if (showConfirmDialog == 0) {
                                this.setCursor(new Cursor(3));
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(225, 225, 225));
                                this.rd.fillRect(11, 141, 779, 401);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Connecting to Server...", 400 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
                                this.repaint();
                                this.justpubd = this.stagename;
                                int n134 = -1;
                                try {
                                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                    final PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                                    printWriter.println("20|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.stagename + "|" + this.pubtyp.getSelectedIndex() + "|");
                                    final String line = bufferedReader.readLine();
                                    if (line != null) {
                                        n134 = this.servervalue(line, 0);
                                    }
                                    if (n134 == 0) {
                                        String string2 = " Publishing Stage ";
                                        String line2;
                                        while ((line2 = new DataInputStream(new ByteArrayInputStream(("" + this.tstage + "\r\n" + this.bstage + "").getBytes())).readLine()) != null) {
                                            printWriter.println(line2.trim());
                                            this.rd.setColor(new Color(225, 225, 225));
                                            this.rd.fillRect(11, 141, 779, 401);
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString(string2, 400 - this.ftm.stringWidth(string2) / 2, 250);
                                            string2 = "| " + string2 + " |";
                                            if (string2.equals("| | | | | | | | | | | | | | | | | | | | | | | |  Publishing Stage  | | | | | | | | | | | | | | | | | | | | | | | |")) {
                                                string2 = " Publishing Stage ";
                                            }
                                            this.repaint();
                                            try {
                                                final Thread thredo = this.thredo;
                                                Thread.sleep(10L);
                                            }
                                            catch (InterruptedException ex9) {}
                                        }
                                        printWriter.println("QUITX1111");
                                        this.rd.setColor(new Color(225, 225, 225));
                                        this.rd.fillRect(11, 141, 779, 401);
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString("Creating the stage online...", 400 - this.ftm.stringWidth("Creating the stage online...") / 2, 250);
                                        this.rd.drawString("This may take a couple of minutes, please wait...", 400 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                        this.repaint();
                                        final String line3 = bufferedReader.readLine();
                                        if (line3 == null) {
                                            n134 = -1;
                                        }
                                        else {
                                            n134 = this.servervalue(line3, 0);
                                        }
                                        if (n134 == 0) {
                                            this.rd.setColor(new Color(225, 225, 225));
                                            this.rd.fillRect(11, 141, 779, 401);
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString("Uploading stage's sound track...", 400 - this.ftm.stringWidth("Uploading Stage's Sound Track...") / 2, 250);
                                            this.rd.drawString("This may take a couple of minutes, please wait...", 400 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                            this.repaint();
                                            final File file6 = new File("" + Madness.fpath + "mystages/mymusic/" + this.trackname + ".zip");
                                            Label_38204: {
                                                if (!this.trackname.equals("")) {
                                                    if (file6.exists()) {
                                                        final int n135 = (int)file6.length();
                                                        printWriter.println("track|" + this.trackname + "|" + n135 + "|");
                                                        final String line4 = bufferedReader.readLine();
                                                        if (line4 == null) {
                                                            n134 = -2;
                                                        }
                                                        else {
                                                            n134 = this.servervalue(line4, 0);
                                                        }
                                                        if (n134 == 0) {
                                                            final FileInputStream fileInputStream3 = new FileInputStream(file6);
                                                            final byte[] array31 = new byte[n135];
                                                            fileInputStream3.read(array31);
                                                            fileInputStream3.close();
                                                            new DataOutputStream(socket.getOutputStream()).write(array31, 0, n135);
                                                            final String line5 = bufferedReader.readLine();
                                                            if (line5 == null) {
                                                                n134 = -2;
                                                            }
                                                            else {
                                                                n134 = this.servervalue(line5, 0);
                                                            }
                                                        }
                                                        if (n134 == -67) {
                                                            n134 = 0;
                                                        }
                                                        break Label_38204;
                                                    }
                                                }
                                                printWriter.println("END");
                                                bufferedReader.readLine();
                                            }
                                        }
                                    }
                                    socket.close();
                                }
                                catch (Exception ex10) {
                                    n134 = -1;
                                }
                                this.setCursor(new Cursor(0));
                                boolean b6 = false;
                                if (n134 == 0) {
                                    this.logged = 1;
                                    b6 = true;
                                }
                                if (n134 == 3) {
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage.\nReason:\n" + this.errlo[8] + "\n\n", "Stage Maker", 1);
                                    b6 = true;
                                }
                                if (n134 == 4) {
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage.\nReason:\nStage name used (" + this.stagename + ").\nThe name '" + this.stagename + "' is already used by another published stage.\nPlease rename your stage.\n\n", "Stage Maker", 1);
                                    b6 = true;
                                }
                                if (n134 == 5) {
                                    JOptionPane.showMessageDialog(null, "Unable to create stage online!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                    b6 = true;
                                }
                                if (n134 > 5) {
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage fully!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                    b6 = true;
                                }
                                if (n134 == -4) {
                                    JOptionPane.showMessageDialog(null, "Unable to upload sound track!\nReason:\nAnother MOD Track is already uploaded with the same name, please rename your Track.\nOpen your 'mystages' folder then open 'mymusic' to find your MOD Track to rename it.\n\n", "Stage Maker", this.logged = 1);
                                    b6 = true;
                                }
                                if (n134 == -3) {
                                    JOptionPane.showMessageDialog(null, "Unable to upload sound track!\nReason:\nYour MOD Track\u2019s file size is too large, Track file size must be less then 700KB to be accepted.\n\n", "Stage Maker", this.logged = 1);
                                    b6 = true;
                                }
                                if (n134 == -2) {
                                    JOptionPane.showMessageDialog(null, "Unable to upload sound track!  Unknown Error.  Please try again later.", "Stage Maker", this.logged = 1);
                                    b6 = true;
                                }
                                if (!b6) {
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage!  Unknown Error.", "Stage Maker", 1);
                                }
                            }
                        }
                    }
                }
                if (this.logged == 3) {
                Label_40720_Outer:
                    for (int n136 = 0; n136 < this.nms; ++n136) {
                        this.rd.setColor(new Color(235, 235, 235));
                        if (this.xm > 11) {
                            if (this.xm < 789) {
                                if (this.ym > 142 + n136 * 20) {
                                    if (this.ym < 160 + n136 * 20) {
                                        this.rd.setColor(new Color(255, 255, 255));
                                    }
                                }
                            }
                        }
                        this.rd.fillRect(11, 142 + n136 * 20, 778, 18);
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.mystages[n136], 180 - this.ftm.stringWidth(this.mystages[n136]) / 2, 156 + n136 * 20);
                        this.rd.setColor(new Color(155, 155, 155));
                        this.rd.drawLine(350, 145 + n136 * 20, 350, 157 + n136 * 20);
                        if (this.pubt[n136] == -1) {
                            this.rd.drawString("-    Error Loading this stage's info!    -", 550 - this.ftm.stringWidth("-    Error Loading this stage's info!    -") / 2, 156 + n136 * 20);
                        }
                        else {
                            this.rd.drawLine(450, 145 + n136 * 20, 450, 157 + n136 * 20);
                            this.rd.drawLine(550, 145 + n136 * 20, 550, 157 + n136 * 20);
                            this.rd.drawLine(650, 145 + n136 * 20, 650, 157 + n136 * 20);
                            boolean b7 = false;
                            if (!this.maker[n136].toLowerCase().equals(this.tnick.getText().toLowerCase())) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString(this.maker[n136], 400 - this.ftm.stringWidth(this.maker[n136]) / 2, 156 + n136 * 20);
                            }
                            else {
                                b7 = true;
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("You", 400 - this.ftm.stringWidth("You") / 2, 156 + n136 * 20);
                            }
                            if (this.nad[n136] <= 1) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("None", 500 - this.ftm.stringWidth("None") / 2, 156 + n136 * 20);
                            }
                            else if (this.ovbutton("" + this.nad[n136] + " Players", 500, 156 + n136 * 20)) {
                                String s3 = "[ " + this.mystages[n136] + " ]  has been added by the following players to their accounts:     \n\n";
                                int n137 = 0;
                                for (int n138 = 0; n138 < this.nad[n136]; ++n138) {
                                    if (++n137 == 17) {
                                        s3 += "\n";
                                        n137 = 1;
                                    }
                                    s3 += this.addeda[n136][n138];
                                    if (n138 != this.nad[n136] - 1) {
                                        if (n138 == this.nad[n136] - 2) {
                                            if (n137 != 16) {
                                                s3 += " and ";
                                            }
                                            else {
                                                s3 += "\nand ";
                                                n137 = 0;
                                            }
                                        }
                                        else {
                                            s3 += ", ";
                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(null, s3 + "\n \n \n", "Stage Maker", 1);
                            }
                            if (this.pubt[n136] == 0) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Private", 600 - this.ftm.stringWidth("Private") / 2, 156 + n136 * 20);
                            }
                            if (this.pubt[n136] == 1) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Public", 600 - this.ftm.stringWidth("Public") / 2, 156 + n136 * 20);
                            }
                            if (this.pubt[n136] == 2) {
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("Super Public", 600 - this.ftm.stringWidth("Super Public") / 2, 156 + n136 * 20);
                            }
                            Label_41328: {
                                if (this.pubt[n136] != 2) {
                                    if (!b7) {
                                        break Label_41328;
                                    }
                                }
                                if (this.ovbutton("Download", 700, 156 + n136 * 20)) {
                                    int n139 = 0;
                                    for (int n140 = 0; n140 < this.slstage.getItemCount(); ++n140) {
                                        if (this.mystages[n136].equals(this.slstage.getItem(n140))) {
                                            n139 = JOptionPane.showConfirmDialog(null, "Replace the local " + this.mystages[n136] + " in your 'mystages' folder with the published online copy?", "Stage Maker", 0);
                                        }
                                    }
                                    if (n139 == 0) {
                                        this.setCursor(new Cursor(3));
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(225, 225, 225));
                                        this.rd.fillRect(11, 141, 779, 401);
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString("Downloading stage, please wait...", 400 - this.ftm.stringWidth("Downloading stage, please wait...") / 2, 250);
                                        this.repaint();
                                        try {
                                            final URL url = new URL(("http://multiplayer.needformadness.com/tracks/" + this.mystages[n136] + ".radq?reqlo=" + (int)(Math.random() * 1000.0) + "").replace(' ', '_'));
                                            final int contentLength = url.openConnection().getContentLength();
                                            final DataInputStream dataInputStream = new DataInputStream(url.openStream());
                                            final byte[] array32 = new byte[contentLength];
                                            dataInputStream.readFully(array32);
                                            dataInputStream.close();
                                            ZipInputStream zipInputStream = null;
                                            Label_40383: {
                                                if (array32[0] == 80) {
                                                    if (array32[1] == 75) {
                                                        if (array32[2] == 3) {
                                                            zipInputStream = new ZipInputStream(new ByteArrayInputStream(array32));
                                                            break Label_40383;
                                                        }
                                                    }
                                                }
                                                final byte[] array33 = new byte[contentLength - 40];
                                                for (int n141 = 0; n141 < contentLength - 40; ++n141) {
                                                    int n142 = 20;
                                                    if (n141 >= 500) {
                                                        n142 = 40;
                                                    }
                                                    array33[n141] = array32[n141 + n142];
                                                }
                                                zipInputStream = new ZipInputStream(new ByteArrayInputStream(array33));
                                            }
                                            final ZipEntry nextEntry = zipInputStream.getNextEntry();
                                            Label_41300: {
                                                if (nextEntry != null) {
                                                    String getstring = "";
                                                    int intValue = Integer.valueOf(nextEntry.getName());
                                                    final byte[] array34 = new byte[intValue];
                                                    int n143 = 0;
                                                    while (intValue > 0) {
                                                        final int read3 = zipInputStream.read(array34, n143, intValue);
                                                        n143 += read3;
                                                        intValue -= read3;
                                                    }
                                                    final String string3 = new String(array34) + "\n";
                                                    String s4 = "";
                                                    int n144 = 0;
                                                    int n145 = string3.indexOf("\n", 0);
                                                    while (true) {
                                                        while (n145 != -1) {
                                                            if (n144 >= string3.length()) {
                                                                final String string4 = s4.trim() + "\r\n\r\n";
                                                                final File file7 = new File("" + Madness.fpath + "mystages/");
                                                                if (!file7.exists()) {
                                                                    file7.mkdirs();
                                                                }
                                                                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "mystages/" + this.mystages[n136] + ".txt")));
                                                                bufferedWriter.write(string4);
                                                                bufferedWriter.close();
                                                                zipInputStream.close();
                                                                if (!getstring.equals("")) {
                                                                    try {
                                                                        this.rd.setColor(new Color(0, 0, 0));
                                                                        this.rd.drawString("Downloading stage's sound track...", 400 - this.ftm.stringWidth("Downloading stage's sound track...") / 2, 280);
                                                                        this.repaint();
                                                                        final URL url2 = new URL(("http://multiplayer.needformadness.com/tracks/music/" + getstring + ".zip").replace(' ', '_'));
                                                                        final int contentLength2 = url2.openConnection().getContentLength();
                                                                        final File file8 = new File("" + Madness.fpath + "mystages/mymusic/" + getstring + ".zip");
                                                                        if (file8.exists()) {
                                                                            if (file8.length() != contentLength2) {
                                                                                n139 = JOptionPane.showConfirmDialog(null, "Another track named '" + getstring + "' already exists in your Sound Tracks folder!\nReplace it with the one attached to this stage?", "Stage Maker", 0);
                                                                            }
                                                                            else {
                                                                                n139 = 1;
                                                                            }
                                                                        }
                                                                        if (n139 == 0) {
                                                                            final DataInputStream dataInputStream2 = new DataInputStream(url2.openStream());
                                                                            final byte[] array35 = new byte[contentLength2];
                                                                            dataInputStream2.readFully(array35);
                                                                            dataInputStream2.close();
                                                                            final FileOutputStream fileOutputStream2 = new FileOutputStream(file8);
                                                                            fileOutputStream2.write(array35);
                                                                            fileOutputStream2.close();
                                                                        }
                                                                    }
                                                                    catch (Exception ex11) {}
                                                                }
                                                                this.setCursor(new Cursor(0));
                                                                JOptionPane.showMessageDialog(null, "" + this.mystages[n136] + " has been successfully downloaded!", "Stage Maker", 1);
                                                                break Label_41300;
                                                            }
                                                            final String trim = string3.substring(n144, n145).trim();
                                                            n144 = n145 + 1;
                                                            n145 = string3.indexOf("\n", n144);
                                                            Label_40682: {
                                                                if (!trim.startsWith("stagemaker(")) {
                                                                    if (!trim.startsWith("publish(")) {
                                                                        s4 = s4 + "" + trim + "\r\n";
                                                                        break Label_40682;
                                                                    }
                                                                }
                                                                s4 = s4.trim() + "\r\n";
                                                            }
                                                            if (!trim.startsWith("soundtrack")) {
                                                                continue Label_40720_Outer;
                                                            }
                                                            getstring = this.getstring("soundtrack", trim, 0);
                                                        }
                                                        continue;
                                                    }
                                                }
                                                JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                            }
                                        }
                                        catch (Exception ex12) {
                                            JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                        }
                                    }
                                }
                            }
                        }
                        if (this.ovbutton("X", 765, 156 + n136 * 20)) {
                            if (JOptionPane.showConfirmDialog(null, "Remove " + this.mystages[n136] + " from your account?", "Stage Maker", 0) == 0) {
                                this.setCursor(new Cursor(3));
                                int servervalue = -1;
                                try {
                                    final Socket socket2 = new Socket("multiplayer.needformadness.com", 7061);
                                    final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                                    new PrintWriter(socket2.getOutputStream(), true).println("19|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.mystages[n136] + "|");
                                    final String line6 = bufferedReader2.readLine();
                                    if (line6 != null) {
                                        servervalue = this.servervalue(line6, 0);
                                    }
                                    socket2.close();
                                }
                                catch (Exception ex13) {
                                    servervalue = -1;
                                }
                                if (servervalue != 0) {
                                    this.setCursor(new Cursor(0));
                                    JOptionPane.showMessageDialog(null, "Failed to remove " + this.mystages[n136] + " from your account.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                }
                                else {
                                    this.logged = 1;
                                }
                            }
                        }
                    }
                }
                if (this.logged == 2) {
                    this.mystages[this.roto] = this.pubitem.getSelectedItem();
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(50, 150, 600, 150);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Loading " + this.mystages[this.roto] + "\u2018s info...", 400 - this.ftm.stringWidth("Loading " + this.mystages[this.roto] + "\u2018s info...") / 2, 220);
                    this.repaint();
                    this.maker[this.roto] = "Unkown";
                    this.pubt[this.roto] = -1;
                    this.nad[this.roto] = 0;
                    try {
                        String line7;
                        while ((line7 = new DataInputStream(new URL(("http://multiplayer.needformadness.com/tracks/" + this.mystages[this.roto] + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").replace(' ', '_')).openStream()).readLine()) != null) {
                            final String string5 = "" + line7.trim();
                            if (!string5.startsWith("details")) {
                                continue;
                            }
                            this.maker[this.roto] = this.getSvalue("details", string5, 0);
                            this.pubt[this.roto] = this.getvalue("details", string5, 1);
                            int n146 = 0;
                            while (n146 == 0) {
                                this.addeda[this.roto][this.nad[this.roto]] = this.getSvalue("details", string5, 2 + this.nad[this.roto]);
                                if (!this.addeda[this.roto][this.nad[this.roto]].equals("")) {
                                    final int[] nad = this.nad;
                                    final int roto = this.roto;
                                    ++nad[roto];
                                }
                                else {
                                    n146 = 1;
                                }
                            }
                        }
                        ++this.nms;
                        if (this.nms > 20) {
                            this.nms = 20;
                        }
                        ++this.roto;
                        if (this.roto >= 20) {
                            this.roto = 0;
                        }
                    }
                    catch (Exception ex14) {}
                    this.setCursor(new Cursor(0));
                    this.logged = 3;
                }
                if (this.logged == -1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Ready to publish...", 400 - this.ftm.stringWidth("Ready to publish...") / 2, 220);
                    this.rd.drawString("Click \u2018Publish\u2019 above to add stage: '" + this.stagename + "'.", 400 - this.ftm.stringWidth("Click \u2018Publish\u2019 above to add stage: '" + this.stagename + "'.") / 2, 280);
                }
                if (this.logged == 1) {
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(11, 141, 779, 401);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Loading your account's stage list...", 400 - this.ftm.stringWidth("Loading your account's stage list...") / 2, 220);
                    this.repaint();
                    this.pubitem.removeAll();
                    this.pubitem.add(this.rd, "Account Stage");
                    this.nms = 0;
                    this.roto = 0;
                    int n147 = 0;
                    try {
                        final DataInputStream dataInputStream3 = new DataInputStream(new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").openStream());
                        String line8;
                    Label_42879_Outer:
                        while ((line8 = dataInputStream3.readLine()) != null) {
                            final String string6 = "" + line8.trim();
                            if (!string6.startsWith("mystages")) {
                                continue Label_42879_Outer;
                            }
                            int n148 = 1;
                            while (true) {
                                while (n148 != 0) {
                                    if (n147 >= 700) {
                                        continue Label_42879_Outer;
                                    }
                                    final String svalue = this.getSvalue("mystages", string6, n147);
                                    if (!svalue.equals("")) {
                                        this.pubitem.add(this.rd, svalue);
                                        ++n147;
                                    }
                                    else {
                                        n148 = 0;
                                    }
                                }
                                continue;
                            }
                        }
                        this.setCursor(new Cursor(0));
                        this.logged = -1;
                        dataInputStream3.close();
                    }
                    catch (Exception ex2) {
                        if (("" + ex2).indexOf("FileNotFound") == -1) {
                            this.logged = 0;
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                        }
                        else {
                            this.setCursor(new Cursor(0));
                            this.logged = -1;
                        }
                    }
                    if (!this.justpubd.equals("")) {
                        this.pubitem.select(this.justpubd);
                        this.justpubd = "";
                    }
                }
                if (this.logged == 0) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Login to Retrieve your Account Stages", 400 - this.ftm.stringWidth("Login to Retrieve your Account Stages") / 2, 220);
                    this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 266);
                    if (!this.tnick.isShowing()) {
                        this.tnick.show();
                    }
                    this.movefield(this.tnick, 376, 250, 129, 23);
                    this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 296);
                    if (!this.tpass.isShowing()) {
                        this.tpass.show();
                    }
                    this.movefield(this.tpass, 376, 280, 129, 23);
                    if (this.button("       Login       ", 400, 340, 0, true)) {
                        this.setCursor(new Cursor(3));
                        int servervalue2 = -1;
                        try {
                            final Socket socket3 = new Socket("multiplayer.needformadness.com", 7061);
                            final BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(socket3.getInputStream()));
                            new PrintWriter(socket3.getOutputStream(), true).println("1|" + this.tnick.getText().toLowerCase() + "|" + this.tpass.getText() + "|");
                            final String line9 = bufferedReader3.readLine();
                            if (line9 != null) {
                                servervalue2 = this.servervalue(line9, 0);
                            }
                            socket3.close();
                        }
                        catch (Exception ex15) {
                            servervalue2 = -1;
                        }
                        Label_43495: {
                            if (servervalue2 != 0) {
                                if (servervalue2 != 3) {
                                    if (servervalue2 <= 10) {
                                        break Label_43495;
                                    }
                                }
                            }
                            this.tnick.hide();
                            this.tpass.hide();
                            this.logged = 1;
                            this.savesettings();
                        }
                        Label_43543: {
                            if (servervalue2 != 1) {
                                if (servervalue2 != 2) {
                                    break Label_43543;
                                }
                            }
                            this.setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Stage Maker", 0);
                        }
                        if (servervalue2 == -167) {
                            this.setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Sorry.  Your trial account cannot publish stages.  Please upgrade to a full account!   ", "Stage Maker", 0);
                        }
                        if (servervalue2 == -1) {
                            this.setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                        }
                    }
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Register a full account or if you have a trial account upgrade it!", 400 - this.ftm.stringWidth("Register a full account or if you have a trial account upgrade it!") / 2, 450);
                    if (this.button("   Register!   ", 340, 480, 0, true)) {
                        Madness.openurl("http://multiplayer.needformadness.com/register.html?ref=game");
                    }
                    if (this.button("   Upgrade!   ", 460, 480, 0, true)) {
                        Madness.openurl("http://multiplayer.needformadness.com/edit.pl");
                    }
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("You need a full account to publish your stages to the multiplayer game!", 400 - this.ftm.stringWidth("You need a full account to publish your stages to the multiplayer game!") / 2, 505);
                }
            }
            if (this.tabed != this.tab) {
                if (this.tabed != -2) {
                    this.tabed = this.tab;
                }
                else {
                    this.tabed = -1;
                }
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 25);
            if (this.onbtgame) {
                this.rd.drawImage(this.btgame[1], 620, 0, null);
            }
            else {
                this.rd.drawImage(this.btgame[0], 620, 0, null);
            }
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            final String[] array36 = { "Stage", "Build", "View & Edit", "Publish" };
            final int[] array37 = { 0, 0, 100, 90 };
            final int[] array38 = { 0, 25, 25, 0 };
            int n149 = 4;
            Label_44107: {
                if (!this.stagename.equals("")) {
                    if (this.sfase == 0) {
                        break Label_44107;
                    }
                }
                this.tab = 0;
                n149 = 1;
            }
            for (int tab = 0; tab < n149; ++tab) {
                this.rd.setColor(new Color(170, 170, 170));
                if (this.xm > array37[0]) {
                    if (this.xm < array37[3]) {
                        if (this.ym > 0) {
                            if (this.ym < 25) {
                                this.rd.setColor(new Color(200, 200, 200));
                            }
                        }
                    }
                }
                if (this.tab == tab) {
                    this.rd.setColor(new Color(225, 225, 225));
                }
                this.rd.fillPolygon(array37, array38, 4);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(array36[tab], tab * 100 + 45 - this.ftm.stringWidth(array36[tab]) / 2, 17);
                if (this.xm > array37[0]) {
                    if (this.xm < array37[3]) {
                        if (this.ym > 0) {
                            if (this.ym < 25) {
                                if (this.mouses == -1) {
                                    this.tab = tab;
                                }
                            }
                        }
                    }
                }
                for (int n150 = 0; n150 < 4; ++n150) {
                    final int[] array39 = array37;
                    final int n151 = n150;
                    array39[n151] += 100;
                }
            }
            if (this.mouses == -1) {
                this.mouses = 0;
            }
            this.drawms();
            this.repaint();
            if (this.exwist) {
                continue;
            }
            try {
                final Thread thredo2 = this.thredo;
                Thread.sleep(40L);
            }
            catch (InterruptedException ex16) {}
        }
        this.track.unload();
        this.track = null;
        this.rd.dispose();
        System.gc();
        if (Madness.endadv == 2) {
            Madness.advopen();
        }
    }
    
    public void removesp() {
        if (this.nundo < 5000) {
            this.undos[this.nundo] = this.bstage;
            ++this.nundo;
        }
        String s = "";
        if (this.co[this.esp].colok != 30 && this.co[this.esp].colok != 31 && this.co[this.esp].colok != 32 && this.co[this.esp].colok != 66) {
            s = "set(" + (this.co[this.esp].colok + 10) + "," + this.co[this.esp].x + "," + this.co[this.esp].z + "," + this.co[this.esp].roofat + ")";
        }
        if (this.co[this.esp].colok == 31) {
            s = "fix(" + (this.co[this.esp].colok + 10) + "," + this.co[this.esp].x + "," + this.co[this.esp].z + "," + this.co[this.esp].y + "," + this.co[this.esp].roofat + ")";
        }
        if (this.co[this.esp].colok == 30 || this.co[this.esp].colok == 32) {
            s = "chk(" + (this.co[this.esp].colok + 10) + "," + this.co[this.esp].x + "," + this.co[this.esp].z + "," + this.co[this.esp].roofat + ")";
        }
        if (this.co[this.esp].colok == 54) {
            s = "chk(" + (this.co[this.esp].colok + 10) + "," + this.co[this.esp].x + "," + this.co[this.esp].z + "," + this.co[this.esp].roofat + "," + this.co[this.esp].y + ")";
        }
        if (this.co[this.esp].colok == 66) {
            s = "pile(" + this.co[this.esp].srz + "," + this.co[this.esp].srx + "," + this.co[this.esp].sry + "," + this.co[this.esp].x + "," + this.co[this.esp].z + ")";
        }
        final int index = this.bstage.indexOf(s);
        int n = index + s.length();
        int index2 = -1;
        final int index3 = this.bstage.indexOf("set", n);
        if (index3 != -1) {
            index2 = index3;
        }
        final int index4 = this.bstage.indexOf("chk", n);
        if (index4 != -1 && index4 < index2) {
            index2 = index4;
        }
        final int index5 = this.bstage.indexOf("fix", n);
        if (index5 != -1 && index5 < index2) {
            index2 = index5;
        }
        if (index2 == -1) {
            index2 = this.bstage.indexOf("\r\n", n);
            if (index2 != -1) {
                ++index2;
            }
        }
        if (index2 != -1) {
            n = index2;
        }
        if (index != -1) {
            this.bstage = "" + this.bstage.substring(0, index) + "" + this.bstage.substring(n, this.bstage.length()) + "";
        }
        this.readstage(0);
    }
    
    public void copyesp(final boolean b) {
        this.sp = this.co[this.esp].colok;
        this.rot = this.co[this.esp].roofat;
        if (this.sp == 2) {
            this.rot -= 30;
        }
        if (this.sp == 3) {
            this.rot += 30;
        }
        if (this.sp == 15) {
            this.rot += 90;
        }
        if (this.sp == 20) {
            this.rot += 180;
        }
        if (this.sp == 26) {
            this.rot -= 90;
        }
        if (this.sp == 0) {
            this.sptyp = 0;
            this.spart = 0;
        }
        if (this.sp == 4) {
            this.sptyp = 0;
            this.spart = 1;
        }
        if (this.sp == 13) {
            this.sptyp = 0;
            this.spart = 2;
        }
        if (this.sp == 3) {
            this.sptyp = 0;
            this.spart = 3;
        }
        if (this.sp == 2) {
            this.sptyp = 0;
            this.spart = 4;
        }
        if (this.sp == 1) {
            this.sptyp = 0;
            this.spart = 5;
        }
        if (this.sp == 35) {
            this.sptyp = 0;
            this.spart = 6;
        }
        if (this.sp == 36) {
            this.sptyp = 0;
            this.spart = 7;
        }
        if (this.sp == 10) {
            this.sptyp = 0;
            this.spart = 8;
        }
        if (this.sp == 5) {
            this.sptyp = 0;
            this.spart = 9;
        }
        if (this.sp == 7) {
            this.sptyp = 0;
            this.spart = 10;
        }
        if (this.sp == 14) {
            this.sptyp = 0;
            this.spart = 11;
        }
        if (this.sp == 6) {
            this.sptyp = 0;
            this.spart = 12;
        }
        if (this.sp == 34) {
            this.sptyp = 0;
            this.spart = 13;
        }
        if (this.sp == 33) {
            this.sptyp = 0;
            this.spart = 14;
        }
        if (this.sp == 11) {
            this.sptyp = 0;
            this.spart = 15;
        }
        if (this.sp == 8) {
            this.sptyp = 0;
            this.spart = 16;
        }
        if (this.sp == 9) {
            this.sptyp = 0;
            this.spart = 17;
        }
        if (this.sp == 15) {
            this.sptyp = 0;
            this.spart = 18;
        }
        if (this.sp == 12) {
            this.sptyp = 0;
            this.spart = 19;
        }
        if (this.sp == 46) {
            this.sptyp = 0;
            this.spart = 20;
        }
        if (this.sp == 47) {
            this.sptyp = 0;
            this.spart = 21;
        }
        if (this.sp == 48) {
            this.sptyp = 0;
            this.spart = 23;
        }
        if (this.sp == 49) {
            this.sptyp = 0;
            this.spart = 24;
        }
        if (this.sp == 50) {
            this.sptyp = 0;
            this.spart = 22;
        }
        if (this.sp == 51) {
            this.sptyp = 0;
            this.spart = 25;
        }
        if (this.sp == 16) {
            this.sptyp = 1;
            this.spart = 0;
        }
        if (this.sp == 18) {
            this.sptyp = 1;
            this.spart = 1;
        }
        if (this.sp == 19) {
            this.sptyp = 1;
            this.spart = 2;
        }
        if (this.sp == 22) {
            this.sptyp = 1;
            this.spart = 3;
        }
        if (this.sp == 17) {
            this.sptyp = 1;
            this.spart = 4;
        }
        if (this.sp == 21) {
            this.sptyp = 1;
            this.spart = 5;
        }
        if (this.sp == 20) {
            this.sptyp = 1;
            this.spart = 6;
        }
        if (this.sp == 39) {
            this.sptyp = 1;
            this.spart = 7;
        }
        if (this.sp == 42) {
            this.sptyp = 1;
            this.spart = 8;
        }
        if (this.sp == 40) {
            this.sptyp = 1;
            this.spart = 9;
        }
        if (this.sp == 23) {
            this.sptyp = 1;
            this.spart = 10;
        }
        if (this.sp == 25) {
            this.sptyp = 1;
            this.spart = 11;
        }
        if (this.sp == 24) {
            this.sptyp = 1;
            this.spart = 12;
        }
        if (this.sp == 43) {
            this.sptyp = 1;
            this.spart = 13;
        }
        if (this.sp == 45) {
            this.sptyp = 1;
            this.spart = 14;
        }
        if (this.sp == 26) {
            this.sptyp = 1;
            this.spart = 15;
        }
        if (this.sp == 27) {
            this.sptyp = 2;
            this.spart = 0;
        }
        if (this.sp == 28) {
            this.sptyp = 2;
            this.spart = 1;
        }
        if (this.sp == 41) {
            this.sptyp = 2;
            this.spart = 2;
        }
        if (this.sp == 44) {
            this.sptyp = 2;
            this.spart = 3;
        }
        if (this.sp == 52) {
            this.sptyp = 2;
            this.spart = 4;
        }
        if (this.sp == 53) {
            this.sptyp = 2;
            this.spart = 5;
        }
        if (this.sp == 30 || this.sp == 32 || this.sp == 54) {
            this.sptyp = 3;
            this.spart = 0;
        }
        if (this.sp == 31) {
            this.sptyp = 4;
            this.spart = 0;
        }
        if (this.sp == 55) {
            this.sptyp = 5;
            this.spart = 0;
        }
        if (this.sp == 56) {
            this.sptyp = 5;
            this.spart = 1;
        }
        if (this.sp == 57) {
            this.sptyp = 5;
            this.spart = 2;
        }
        if (this.sp == 58) {
            this.sptyp = 5;
            this.spart = 3;
        }
        if (this.sp == 59) {
            this.sptyp = 5;
            this.spart = 4;
        }
        if (this.sp == 60) {
            this.sptyp = 5;
            this.spart = 5;
        }
        if (this.sp == 61) {
            this.sptyp = 5;
            this.spart = 6;
        }
        if (this.sp == 62) {
            this.sptyp = 5;
            this.spart = 7;
        }
        if (this.sp == 63) {
            this.sptyp = 5;
            this.spart = 8;
        }
        if (this.sp == 64) {
            this.sptyp = 5;
            this.spart = 9;
        }
        if (this.sp == 65) {
            this.sptyp = 5;
            this.spart = 10;
        }
        if (this.sp == 66) {
            if (b) {
                this.fgen = this.co[this.esp].srz;
            }
            else {
                this.fgen = 0;
            }
            this.pwd = this.co[this.esp].srx;
            this.phd = this.co[this.esp].sry;
            this.pgen = false;
            this.sptyp = 6;
        }
        if (this.sptyp == 0) {
            this.partroads();
            this.part.show();
        }
        if (this.sptyp == 1) {
            this.partramps();
            this.part.show();
        }
        if (this.sptyp == 2) {
            this.partobst();
            this.part.show();
        }
        if (this.sptyp == 5) {
            this.partrees();
            this.part.show();
        }
        this.ptyp.select(this.sptyp);
        this.part.select(this.spart);
    }
    
    public void partrees() {
        this.part.removeAll();
        this.part.add(this.rd, "Tree 1");
        this.part.add(this.rd, "Tree 2");
        this.part.add(this.rd, "Tree 3");
        this.part.add(this.rd, "Tree 4");
        this.part.add(this.rd, "Tree 5");
        this.part.add(this.rd, "Palm Tree 1");
        this.part.add(this.rd, "Palm Tree 2");
        this.part.add(this.rd, "Palm Tree 3");
        this.part.add(this.rd, "Cactus 1");
        this.part.add(this.rd, "Cactus 2");
        this.part.add(this.rd, "Cactus 3");
    }
    
    public void partroads() {
        this.part.removeAll();
        this.part.add(this.rd, "NormalRoad");
        this.part.add(this.rd, "NormalRoad Turn");
        this.part.add(this.rd, "NormalRoad End");
        this.part.add(this.rd, "NormalRoad TwistedLeft");
        this.part.add(this.rd, "NormalRoad TwistedRight");
        this.part.add(this.rd, "NormalRoad Edged");
        this.part.add(this.rd, "NormalRoad-Raised Ramp");
        this.part.add(this.rd, "NormalRoad Raised");
        this.part.add(this.rd, "Normal-Off-Road Blend");
        this.part.add(this.rd, "OffRoad");
        this.part.add(this.rd, "OffRoad Turn");
        this.part.add(this.rd, "OffRoad End");
        this.part.add(this.rd, "OffRoad BumpyGreen");
        this.part.add(this.rd, "OffRoad-BumpySides Start");
        this.part.add(this.rd, "OffRoad BumpySides");
        this.part.add(this.rd, "Off-Halfpipe-Road Blend");
        this.part.add(this.rd, "HalfpipeRoad");
        this.part.add(this.rd, "HalfpipeRoad Turn");
        this.part.add(this.rd, "HalfpipeRoad-Ramp Filler");
        this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
        this.part.add(this.rd, "Rollercoaster Start/End");
        this.part.add(this.rd, "Rollercoaster Road1");
        this.part.add(this.rd, "Rollercoaster Road2");
        this.part.add(this.rd, "Rollercoaster Road3");
        this.part.add(this.rd, "Rollercoaster Road4");
        this.part.add(this.rd, "Rollercoaster Road5");
    }
    
    public void partramps() {
        this.part.removeAll();
        this.part.add(this.rd, "Basic Ramp");
        this.part.add(this.rd, "Two-Way Ramp");
        this.part.add(this.rd, "Two-Way High-Low Ramp");
        this.part.add(this.rd, "Small Ramp");
        this.part.add(this.rd, "Crash Ramp");
        this.part.add(this.rd, "Big-Takeoff Ramp");
        this.part.add(this.rd, "Landing Ramp");
        this.part.add(this.rd, "Tunnel Side Ramp");
        this.part.add(this.rd, "Speed Ramp");
        this.part.add(this.rd, "Launch Pad Ramp");
        this.part.add(this.rd, "Offroad Bump Ramp");
        this.part.add(this.rd, "Offroad Ramp");
        this.part.add(this.rd, "Offroad Big Ramp");
        this.part.add(this.rd, "Offroad Hill Ramp");
        this.part.add(this.rd, "Offroad Big Hill Ramp");
        this.part.add(this.rd, "Halfpipe");
    }
    
    public void partobst() {
        this.part.removeAll();
        this.part.add(this.rd, "Spiky Pillars");
        this.part.add(this.rd, "Rail Doorway");
        this.part.add(this.rd, "The Net");
        this.part.add(this.rd, "Bump Slide");
        this.part.add(this.rd, "Offroad Dirt-Pile 1");
        this.part.add(this.rd, "Offroad Dirt-Pile 2");
    }
    
    @Override
    public void init() {
        this.setBackground(new Color(0, 0, 0));
        this.offImage = this.createImage(800, 550);
        if (this.offImage != null) {
            this.rd = (Graphics2D)this.offImage.getGraphics();
        }
        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.setLayout(null);
        this.slstage.setFont(new Font("Arial", 1, 13));
        this.slstage.add(this.rd, "Select a Stage...         ");
        this.slstage.setForeground(new Color(63, 80, 110));
        this.slstage.setBackground(new Color(209, 217, 230));
        this.srch.setFont(new Font("Arial", 1, 12));
        this.srch.setBackground(new Color(255, 255, 255));
        this.srch.setForeground(new Color(0, 0, 0));
        this.strtyp.setFont(new Font("Arial", 1, 12));
        this.strtyp.add(this.rd, "NormalRoad");
        this.strtyp.add(this.rd, "OffRoad");
        this.strtyp.setBackground(new Color(63, 80, 110));
        this.strtyp.setForeground(new Color(209, 217, 230));
        this.ptyp.setFont(new Font("Arial", 1, 12));
        this.ptyp.add(this.rd, "Roads");
        this.ptyp.add(this.rd, "Ramps");
        this.ptyp.add(this.rd, "Obstacles");
        this.ptyp.add(this.rd, "Checkpoint");
        this.ptyp.add(this.rd, "Fixing Hoop");
        this.ptyp.add(this.rd, "Trees");
        this.ptyp.add(this.rd, "Ground Pile");
        this.ptyp.setBackground(new Color(63, 80, 110));
        this.ptyp.setForeground(new Color(209, 217, 230));
        this.part.setFont(new Font("Arial", 1, 12));
        this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
        this.part.setBackground(new Color(63, 80, 110));
        this.part.setForeground(new Color(209, 217, 230));
        this.fixh.setFont(new Font("Arial", 1, 12));
        this.fixh.setBackground(new Color(255, 255, 255));
        this.fixh.setForeground(new Color(0, 0, 0));
        this.mgen.setFont(new Font("Arial", 1, 12));
        this.mgen.setBackground(new Color(255, 255, 255));
        this.mgen.setForeground(new Color(0, 0, 0));
        this.pfog.setFont(new Font("Arial", 1, 12));
        this.pfog.setBackground(new Color(225, 225, 225));
        this.pfog.setForeground(new Color(0, 0, 0));
        this.nlaps.setFont(new Font("Arial", 1, 12));
        for (int i = 0; i < 15; ++i) {
            this.nlaps.add(this.rd, " " + (i + 1) + " ");
        }
        this.nlaps.setBackground(new Color(63, 80, 110));
        this.nlaps.setForeground(new Color(209, 217, 230));
        this.tracks.setFont(new Font("Arial", 1, 12));
        this.tracks.add(this.rd, "Select MOD Track");
        this.tracks.setForeground(new Color(63, 80, 110));
        this.tracks.setBackground(new Color(209, 217, 230));
        this.witho.setFont(new Font("Arial", 1, 12));
        this.witho.add(this.rd, "With other cars");
        this.witho.add(this.rd, "Alone");
        this.witho.setBackground(new Color(63, 80, 110));
        this.witho.setForeground(new Color(209, 217, 230));
        this.tnick.setFont(new Font("Arial", 1, 13));
        this.tnick.setBackground(new Color(255, 255, 255));
        this.tnick.setForeground(new Color(0, 0, 0));
        this.tpass.setFont(new Font("Arial", 1, 13));
        this.tpass.setEchoCharacter('*');
        this.tpass.setBackground(new Color(255, 255, 255));
        this.tpass.setForeground(new Color(0, 0, 0));
        this.pubtyp.setFont(new Font("Arial", 1, 13));
        this.pubtyp.add(this.rd, "Private");
        this.pubtyp.add(this.rd, "Public");
        this.pubtyp.add(this.rd, "Super Public");
        this.pubtyp.setBackground(new Color(63, 80, 110));
        this.pubtyp.setForeground(new Color(209, 217, 230));
        this.pubitem.setFont(new Font("Arial", 1, 13));
        this.pubitem.add(this.rd, "Account Stages");
        this.pubitem.setBackground(new Color(209, 217, 230));
        this.pubitem.setForeground(new Color(63, 80, 110));
        this.add(this.tnick);
        this.add(this.tpass);
        this.add(this.srch);
        this.add(this.fixh);
        this.add(this.mgen);
        this.add(this.pfog);
        this.hidefields();
    }
    
    public void hidefields() {
        this.pubtyp.hide();
        this.pubitem.hide();
        this.tpass.hide();
        this.tnick.hide();
        this.witho.hide();
        this.strtyp.hide();
        this.srch.hide();
        this.slstage.hide();
        this.tracks.hide();
        this.nlaps.hide();
        this.pfog.hide();
        this.fixh.hide();
        this.mgen.hide();
        this.ptyp.hide();
        this.part.hide();
    }
    
    public void movefield(final Component component, int n, int n2, final int n3, final int n4) {
        n += this.apx;
        n2 += this.apy;
        if (component.getX() != n || component.getY() != n2 || component.getWidth() != n3 || component.getHeight() != n4) {
            component.setBounds(n, n2, n3, n4);
        }
    }
    
    public void drawms() {
        boolean b = false;
        if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            b = true;
        }
        if (this.pubitem.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            b = true;
        }
        if (this.slstage.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            b = true;
        }
        if (this.strtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            b = true;
        }
        int n = 0;
        if (this.preop) {
            n = -1000;
        }
        if (this.part.draw(this.rd, this.xm, this.ym + n, this.mousdr && !this.preop, 550, false)) {
            b = true;
        }
        if (this.ptyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            b = true;
            this.preop = true;
        }
        else {
            this.preop = false;
        }
        if (this.nlaps.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            b = true;
        }
        if (this.tracks.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            b = true;
        }
        if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            b = true;
        }
        if (b) {
            this.mouses = 0;
        }
    }
    
    @Override
    public void start() {
        if (this.thredo == null) {
            this.thredo = new Thread(this);
        }
        this.thredo.start();
    }
    
    @Override
    public void stop() {
        this.exwist = true;
    }
    
    @Override
    public void paint(final Graphics graphics) {
        this.apx = this.getWidth() / 2 - 400;
        this.apy = this.getHeight() / 2 - 275;
        graphics.drawImage(this.offImage, this.apx, this.apy, this);
    }
    
    @Override
    public void update(final Graphics graphics) {
        this.paint(graphics);
    }
    
    @Override
    public boolean mouseUp(final Event event, final int n, final int n2) {
        this.mousdr = false;
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        if (this.mouses == 1) {
            this.mouses = -1;
        }
        if (this.onbtgame) {
            Madness.game();
        }
        return false;
    }
    
    @Override
    public boolean mouseDown(final Event event, final int n, final int n2) {
        this.mousdr = true;
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        this.mouses = 1;
        this.requestFocus();
        this.focuson = true;
        return false;
    }
    
    @Override
    public boolean mouseMove(final Event event, final int n, final int n2) {
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        if (this.xm > 620 && this.xm < 774 && this.ym > 0 && this.ym < 23) {
            if (!this.onbtgame) {
                this.onbtgame = true;
                this.setCursor(new Cursor(12));
            }
        }
        else if (this.onbtgame) {
            this.onbtgame = false;
            this.setCursor(new Cursor(0));
        }
        return false;
    }
    
    @Override
    public boolean mouseDrag(final Event event, final int n, final int n2) {
        this.mousdr = true;
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        return false;
    }
    
    @Override
    public boolean keyDown(final Event event, final int n) {
        if (this.focuson) {
            if (n == 42 || n == 10 || n == 56 || n == 119 || n == 87 || n == 43 || n == 61) {
                this.zoomi = true;
            }
            if (n == 47 || n == 8 || n == 50 || n == 115 || n == 83 || n == 45) {
                this.zoomo = true;
            }
            if (n == 1006) {
                this.left = true;
            }
            if (n == 1007) {
                this.right = true;
            }
            if (n == 1005) {
                this.down = true;
            }
            if (n == 1004) {
                this.up = true;
            }
        }
        return false;
    }
    
    @Override
    public boolean keyUp(final Event event, final int n) {
        if (n == 42 || n == 10 || n == 56 || n == 119 || n == 87 || n == 43 || n == 61) {
            this.zoomi = false;
        }
        if (n == 47 || n == 8 || n == 50 || n == 115 || n == 83 || n == 45) {
            this.zoomo = false;
        }
        if (n == 1006) {
            this.left = false;
        }
        if (n == 1007) {
            this.right = false;
        }
        if (n == 1005) {
            this.down = false;
        }
        if (n == 1004) {
            this.up = false;
        }
        return false;
    }
    
    public void loadbase() {
        final String[] array = { "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet", "speedramp", "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6", "opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7", "tree8", "cac1", "cac2", "cac3" };
        try {
            final ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File("" + Madness.fpath + "data/models.zip")));
            for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
                int n = -1;
                for (int i = 0; i < 66; ++i) {
                    if (zipEntry.getName().startsWith(array[i])) {
                        n = i;
                    }
                }
                if (n != -1) {
                    int j = (int)zipEntry.getSize();
                    final byte[] array2 = new byte[j];
                    int n2 = 0;
                    while (j > 0) {
                        final int read = zipInputStream.read(array2, n2, j);
                        n2 += read;
                        j -= read;
                    }
                    this.bco[n] = new ContO(array2, this.m, this.t);
                    for (int k = 0; k < this.bco[n].npl; ++k) {
                        this.bco[n].p[k].loadprojf();
                    }
                    if (n == 31) {
                        this.bco[n].elec = true;
                    }
                }
            }
            zipInputStream.close();
            this.bco[66] = new ContO((int)(10000.0 * Math.random()), (int)this.pwd, (int)this.phd, this.m, this.t, 0, 0, 0);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to load file 'data/models.zip'!\nError:\n" + ex, "Stage Maker", 1);
        }
        System.gc();
    }
    
    public void readstage(final int n) {
        this.errd = 0;
        this.trackname = "";
        this.t.nt = 0;
        this.nob = 0;
        this.xnob = 0;
        this.cp.n = 0;
        this.cp.nsp = 0;
        this.cp.fn = 0;
        this.cp.haltall = false;
        this.cp.wasted = 0;
        this.cp.catchfin = 0;
        this.m.ground = 250;
        this.m.lightson = false;
        if (n == 0) {
            this.m.snap[0] = 0;
            this.m.snap[1] = 0;
            this.m.snap[2] = 0;
        }
        if (n == 3) {
            this.tstage = "";
            this.bstage = "";
        }
        String s = this.bstage;
        if (n == 1 || n == 2) {
            s = "" + this.tstage + "\r\n" + this.bstage + "";
        }
        int getint = 0;
        int getint2 = 100;
        int getint3 = 0;
        int getint4 = 100;
        int n2 = 1;
        int n3 = 1;
        String string = "";
        try {
            DataInputStream dataInputStream;
            if (n == 3) {
                dataInputStream = new DataInputStream(new FileInputStream(new File("" + Madness.fpath + "mystages/" + this.stagename + ".txt")));
                this.nundo = 0;
            }
            else {
                dataInputStream = new DataInputStream(new ByteArrayInputStream(s.getBytes()));
            }
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                string = "" + line.trim();
                if (string.startsWith("sky")) {
                    this.csky[0] = this.getint("sky", string, 0);
                    this.csky[1] = this.getint("sky", string, 1);
                    this.csky[2] = this.getint("sky", string, 2);
                    this.m.setsky(this.csky[0], this.csky[1], this.csky[2]);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("ground")) {
                    this.cgrnd[0] = this.getint("ground", string, 0);
                    this.cgrnd[1] = this.getint("ground", string, 1);
                    this.cgrnd[2] = this.getint("ground", string, 2);
                    this.m.setgrnd(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2]);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("polys")) {
                    this.m.setpolys(this.getint("polys", string, 0), this.getint("polys", string, 1), this.getint("polys", string, 2));
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("fog")) {
                    this.cfade[0] = this.getint("fog", string, 0);
                    this.cfade[1] = this.getint("fog", string, 1);
                    this.cfade[2] = this.getint("fog", string, 2);
                    this.m.setfade(this.cfade[0], this.cfade[1], this.cfade[2]);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("texture")) {
                    this.texture[0] = this.getint("texture", string, 0);
                    this.texture[1] = this.getint("texture", string, 1);
                    this.texture[2] = this.getint("texture", string, 2);
                    this.texture[3] = this.getint("texture", string, 3);
                    this.m.setexture(this.texture[0], this.texture[1], this.texture[2], this.texture[3]);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("clouds")) {
                    this.cldd[0] = this.getint("clouds", string, 0);
                    this.cldd[1] = this.getint("clouds", string, 1);
                    this.cldd[2] = this.getint("clouds", string, 2);
                    this.cldd[3] = this.getint("clouds", string, 3);
                    this.cldd[4] = this.getint("clouds", string, 4);
                    this.m.setcloads(this.cldd[0], this.cldd[1], this.cldd[2], this.cldd[3], this.cldd[4]);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (n != 2 && string.startsWith("snap")) {
                    this.m.setsnap(this.getint("snap", string, 0), this.getint("snap", string, 1), this.getint("snap", string, 2));
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("density")) {
                    this.m.fogd = (this.getint("density", string, 0) + 1) * 2 - 1;
                    if (this.m.fogd < 1) {
                        this.m.fogd = 1;
                    }
                    if (this.m.fogd > 30) {
                        this.m.fogd = 30;
                    }
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("mountains")) {
                    this.m.mgen = this.getint("mountains", string, 0);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("fadefrom")) {
                    this.m.fadfrom(this.getint("fadefrom", string, 0));
                    this.origfade = this.m.fade[0];
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("lightson")) {
                    this.m.lightson = true;
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("nlaps")) {
                    this.cp.nlaps = this.getint("nlaps", string, 0);
                    if (this.cp.nlaps < 1) {
                        this.cp.nlaps = 1;
                    }
                    if (this.cp.nlaps > 15) {
                        this.cp.nlaps = 15;
                    }
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("soundtrack")) {
                    this.trackname = this.getstring("soundtrack", string, 0);
                    this.trackvol = this.getint("soundtrack", string, 1);
                    this.tracksize = this.getint("soundtrack", string, 2);
                    if (n == 3) {
                        this.tstage = this.tstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("set")) {
                    int getint5 = this.getint("set", string, 0);
                    if (getint5 >= 10 && getint5 <= 25) {
                        this.m.loadnew = true;
                    }
                    getint5 -= 10;
                    this.co[this.nob] = new ContO(this.bco[getint5], this.getint("set", string, 1), this.m.ground - this.bco[getint5].grat, this.getint("set", string, 2), this.getint("set", string, 3));
                    this.co[this.nob].roofat = this.getint("set", string, 3);
                    this.co[this.nob].colok = getint5;
                    if (string.indexOf(")p") != -1) {
                        this.cp.x[this.cp.n] = this.getint("chk", string, 1);
                        this.cp.z[this.cp.n] = this.getint("chk", string, 2);
                        this.cp.y[this.cp.n] = 0;
                        this.cp.typ[this.cp.n] = 0;
                        if (string.indexOf(")pt") != -1) {
                            this.cp.typ[this.cp.n] = -1;
                        }
                        if (string.indexOf(")pr") != -1) {
                            this.cp.typ[this.cp.n] = -2;
                        }
                        if (string.indexOf(")po") != -1) {
                            this.cp.typ[this.cp.n] = -3;
                        }
                        if (string.indexOf(")ph") != -1) {
                            this.cp.typ[this.cp.n] = -4;
                        }
                        final CheckPoints cp = this.cp;
                        ++cp.n;
                    }
                    ++this.xnob;
                    ++this.nob;
                    if (n == 3) {
                        if (n3 != 0) {
                            this.bstage += "\r\n";
                            n3 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                    if (this.m.loadnew) {
                        this.m.loadnew = false;
                    }
                }
                if (string.startsWith("chk")) {
                    int getint6 = this.getint("chk", string, 0);
                    getint6 -= 10;
                    int getint7 = this.m.ground - this.bco[getint6].grat;
                    if (getint6 == 54) {
                        getint7 = this.getint("chk", string, 4);
                    }
                    this.co[this.nob] = new ContO(this.bco[getint6], this.getint("chk", string, 1), getint7, this.getint("chk", string, 2), this.getint("chk", string, 3));
                    this.co[this.nob].roofat = this.getint("chk", string, 3);
                    this.co[this.nob].colok = getint6;
                    this.cp.x[this.cp.n] = this.getint("chk", string, 1);
                    this.cp.z[this.cp.n] = this.getint("chk", string, 2);
                    this.cp.y[this.cp.n] = getint7;
                    if (this.getint("chk", string, 3) == 0) {
                        this.cp.typ[this.cp.n] = 1;
                    }
                    else {
                        this.cp.typ[this.cp.n] = 2;
                    }
                    this.cp.pcs = this.cp.n;
                    final CheckPoints cp2 = this.cp;
                    ++cp2.n;
                    this.co[this.nob].checkpoint = this.cp.nsp + 1;
                    if (string.indexOf(")r") != -1) {
                        this.co[this.nob].wh = this.cp.nsp + 1;
                    }
                    final CheckPoints cp3 = this.cp;
                    ++cp3.nsp;
                    ++this.xnob;
                    ++this.nob;
                    if (n == 3) {
                        if (n3 != 0) {
                            this.bstage += "\r\n";
                            n3 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("fix")) {
                    int getint8 = this.getint("fix", string, 0);
                    getint8 -= 10;
                    this.co[this.nob] = new ContO(this.bco[getint8], this.getint("fix", string, 1), this.getint("fix", string, 3), this.getint("fix", string, 2), this.getint("fix", string, 4));
                    this.co[this.nob].roofat = this.getint("fix", string, 4);
                    this.co[this.nob].colok = getint8;
                    this.cp.fx[this.cp.fn] = this.getint("fix", string, 1);
                    this.cp.fz[this.cp.fn] = this.getint("fix", string, 2);
                    this.cp.fy[this.cp.fn] = this.getint("fix", string, 3);
                    this.co[this.nob].elec = true;
                    if (this.getint("fix", string, 4) != 0) {
                        this.cp.roted[this.cp.fn] = true;
                        this.co[this.nob].roted = true;
                    }
                    else {
                        this.cp.roted[this.cp.fn] = false;
                    }
                    if (string.indexOf(")s") != -1) {
                        this.cp.special[this.cp.fn] = true;
                    }
                    else {
                        this.cp.special[this.cp.fn] = false;
                    }
                    final CheckPoints cp4 = this.cp;
                    ++cp4.fn;
                    ++this.xnob;
                    ++this.nob;
                    if (n == 3) {
                        if (n3 != 0) {
                            this.bstage += "\r\n";
                            n3 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("pile")) {
                    this.co[this.nob] = new ContO(this.getint("pile", string, 0), this.getint("pile", string, 1), this.getint("pile", string, 2), this.m, this.t, this.getint("pile", string, 3), this.getint("pile", string, 4), this.m.ground);
                    this.co[this.nob].srz = this.getint("pile", string, 0);
                    this.co[this.nob].srx = this.getint("pile", string, 1);
                    this.co[this.nob].sry = this.getint("pile", string, 2);
                    this.co[this.nob].colok = 66;
                    ++this.xnob;
                    ++this.nob;
                    if (n == 3) {
                        if (n3 != 0) {
                            this.bstage += "\r\n";
                            n3 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("maxr")) {
                    final int getint9 = this.getint("maxr", string, 0);
                    final int n4 = getint = this.getint("maxr", string, 1);
                    final int getint10 = this.getint("maxr", string, 2);
                    for (int i = 0; i < getint9; ++i) {
                        this.co[this.nob] = new ContO(this.bco[29], n4, this.m.ground - this.bco[29].grat, i * 4800 + getint10, 0);
                        if (n == 0) {
                            ++this.xnob;
                        }
                        else {
                            ++this.nob;
                        }
                    }
                    if (n == 3) {
                        if (n2 != 0) {
                            this.bstage += "\r\n";
                            n2 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("maxl")) {
                    final int getint11 = this.getint("maxl", string, 0);
                    final int n5 = getint2 = this.getint("maxl", string, 1);
                    final int getint12 = this.getint("maxl", string, 2);
                    for (int j = 0; j < getint11; ++j) {
                        this.co[this.nob] = new ContO(this.bco[29], n5, this.m.ground - this.bco[29].grat, j * 4800 + getint12, 180);
                        if (n == 0) {
                            ++this.xnob;
                        }
                        else {
                            ++this.nob;
                        }
                    }
                    if (n == 3) {
                        if (n2 != 0) {
                            this.bstage += "\r\n";
                            n2 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("maxt")) {
                    final int getint13 = this.getint("maxt", string, 0);
                    final int n6 = getint3 = this.getint("maxt", string, 1);
                    final int getint14 = this.getint("maxt", string, 2);
                    for (int k = 0; k < getint13; ++k) {
                        this.co[this.nob] = new ContO(this.bco[29], k * 4800 + getint14, this.m.ground - this.bco[29].grat, n6, 90);
                        if (n == 0) {
                            ++this.xnob;
                        }
                        else {
                            ++this.nob;
                        }
                    }
                    if (n == 3) {
                        if (n2 != 0) {
                            this.bstage += "\r\n";
                            n2 = 0;
                        }
                        this.bstage = this.bstage + "" + string + "\r\n";
                    }
                }
                if (string.startsWith("maxb")) {
                    final int getint15 = this.getint("maxb", string, 0);
                    final int n7 = getint4 = this.getint("maxb", string, 1);
                    final int getint16 = this.getint("maxb", string, 2);
                    for (int l = 0; l < getint15; ++l) {
                        this.co[this.nob] = new ContO(this.bco[29], l * 4800 + getint16, this.m.ground - this.bco[29].grat, n7, -90);
                        if (n == 0) {
                            ++this.xnob;
                        }
                        else {
                            ++this.nob;
                        }
                    }
                    if (n != 3) {
                        continue;
                    }
                    if (n2 != 0) {
                        this.bstage += "\r\n";
                        n2 = 0;
                    }
                    this.bstage = this.bstage + "" + string + "\r\n";
                }
            }
            dataInputStream.close();
            this.m.newpolys(getint2, getint - getint2, getint4, getint3 - getint4, this.t, this.nob);
            this.m.newclouds(getint2, getint, getint4, getint3);
            this.m.newmountains(getint2, getint, getint4, getint3);
            this.m.newstars();
        }
        catch (Exception ex) {
            System.out.println("Error in stage " + this.stagename);
            System.out.println("" + ex);
            System.out.println("At line: " + string);
            this.errd = 6;
            if (this.cp.fn >= 5) {
                this.errd = 5;
            }
            if (this.t.nt >= 6700) {
                this.errd = 1;
            }
            if (this.cp.n >= 140) {
                this.errd = 2;
            }
            if (this.nob >= 601) {
                this.errd = 4;
            }
        }
        if (this.m.nrw * this.m.ncl >= 16000) {
            this.errd = 3;
        }
        if (this.xnob >= 602) {
            this.errd = 4;
        }
        if (n == 3 && this.bstage.indexOf("set(47,0,0,0)") == -1 && this.bstage.indexOf("set(48,0,0,0)") == -1) {
            this.bstage += "set(47,0,0,0)\r\n";
        }
    }
    
    public void newstage() {
        if (!this.srch.getText().equals("")) {
            if (!new File("" + Madness.fpath + "mystages/" + this.srch.getText() + ".txt").exists()) {
                this.stagename = this.srch.getText();
                this.tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\r\nmountains(" + (int)(Math.random() * 100000.0) + ")\r\nnlaps(5)\r\n\r\n";
                if (this.strtyp.getSelectedIndex() == 1) {
                    this.bstage = "set(48,0,0,0)\r\n";
                }
                else {
                    this.bstage = "set(47,0,0,0)\r\n";
                }
                this.bstage += "\r\nmaxl(3,-7200,-4800)\r\nmaxb(3,-7200,-4800)\r\nmaxr(3,7200,-4800)\r\nmaxt(3,7200,-4800)\r\n";
                this.savefile();
                this.strtyp.hide();
                this.srch.hide();
                this.sfase = 0;
                this.tabed = -2;
            }
            else {
                JOptionPane.showMessageDialog(null, "A stage with that name already exists, please choose another name!", "Stage Maker", 1);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please enter a stage name first!", "Stage Maker", 1);
        }
    }
    
    public void sortop() {
        this.tstage = "snap(" + this.m.snap[0] + "," + this.m.snap[1] + "," + this.m.snap[2] + ")\r\nsky(" + this.csky[0] + "," + this.csky[1] + "," + this.csky[2] + ")\r\nfog(" + this.cfade[0] + "," + this.cfade[1] + "," + this.cfade[2] + ")\r\nclouds(" + this.cldd[0] + "," + this.cldd[1] + "," + this.cldd[2] + "," + this.cldd[3] + "," + this.cldd[4] + ")\r\nground(" + this.cgrnd[0] + "," + this.cgrnd[1] + "," + this.cgrnd[2] + ")\r\ntexture(" + this.texture[0] + "," + this.texture[1] + "," + this.texture[2] + "," + this.texture[3] + ")\r\nfadefrom(" + this.origfade + ")\r\ndensity(" + ((this.m.fogd + 1) / 2 - 1) + ")\r\nmountains(" + this.m.mgen + ")\r\nnlaps(" + this.cp.nlaps + ")\r\n";
        if (!this.trackname.equals("")) {
            this.tstage = this.tstage + "soundtrack(" + this.trackname + "," + this.trackvol + "," + this.tracksize + ")\r\n";
        }
        for (int i = 0; i < 3; ++i) {
            this.snap[i] = (int)(this.m.snap[i] / 1.2f + 50.0f);
        }
        if (this.snap[0] + this.snap[1] + this.snap[2] <= 110) {
            this.tstage += "lightson()\r\n";
        }
        this.tstage += "\r\n";
    }
    
    public void sortstage() {
        final int[] array = new int[this.nob * 2];
        final int[] array2 = new int[this.nob * 2];
        for (int i = 0; i < this.nob; ++i) {
            array[i] = 0;
        }
        int n = 0;
        int n2 = 0;
        array2[n2] = 0;
        ++n2;
        int j = 0;
        int n3 = 0;
        while (j == 0) {
            final int[] array3 = { this.co[n].x + this.atp[this.co[n].colok][0], this.co[n].x + this.atp[this.co[n].colok][2] };
            final int[] array4 = { this.co[n].z + this.atp[this.co[n].colok][1], this.co[n].z + this.atp[this.co[n].colok][3] };
            int roofat = this.co[n].roofat;
            if (this.co[n].colok == 2) {
                roofat += 30;
            }
            if (this.co[n].colok == 3) {
                roofat -= 30;
            }
            if (this.co[n].colok == 15) {
                roofat -= 90;
            }
            if (this.co[n].colok == 20) {
                roofat -= 180;
            }
            if (this.co[n].colok == 26) {
                roofat -= 90;
            }
            this.rot(array3, array4, this.co[n].x, this.co[n].z, roofat, 2);
            int n4 = -1;
            int n5 = -1;
            if (n3 != 0) {
                for (int k = 0; k < this.nob; ++k) {
                    boolean b = false;
                    if (n2 == 2 && k == 0) {
                        b = true;
                    }
                    if (n != k && !b && array[k] == 0 && (this.co[k].colok <= 14 || this.co[k].colok >= 33) && (this.co[k].colok < 39 || this.co[k].colok >= 46) && this.co[k].colok < 52) {
                        int n6 = 0;
                        if (this.co[k].colok != 2 && this.co[k].colok != 3 && this.co[k].colok != 4 && this.co[k].colok != 7 && this.co[k].colok != 9) {
                            if (n3 == 1 && this.co[k].z > this.co[n].z && Math.abs(this.co[k].x - this.co[n].x) < 1000 && (this.co[k].roofat == 180 || this.co[k].roofat == 0)) {
                                n6 = 1;
                            }
                            if (n3 == 2 && this.co[k].z < this.co[n].z && Math.abs(this.co[k].x - this.co[n].x) < 1000 && (this.co[k].roofat == 180 || this.co[k].roofat == 0)) {
                                n6 = 1;
                            }
                            if (n3 == 3 && this.co[k].x > this.co[n].x && Math.abs(this.co[k].z - this.co[n].z) < 1000 && (this.co[k].roofat == 90 || this.co[k].roofat == -90)) {
                                n6 = 1;
                            }
                            if (n3 == 4 && this.co[k].x < this.co[n].x && Math.abs(this.co[k].z - this.co[n].z) < 1000 && (this.co[k].roofat == 90 || this.co[k].roofat == -90)) {
                                n6 = 1;
                            }
                        }
                        else {
                            n6 = 2;
                        }
                        if (n6 != 0) {
                            final int[] array5 = { this.co[k].x + this.atp[this.co[k].colok][0], this.co[k].x + this.atp[this.co[k].colok][2] };
                            final int[] array6 = { this.co[k].z + this.atp[this.co[k].colok][1], this.co[k].z + this.atp[this.co[k].colok][3] };
                            int roofat2 = this.co[k].roofat;
                            if (this.co[k].colok == 2) {
                                roofat2 += 30;
                            }
                            if (this.co[k].colok == 3) {
                                roofat2 -= 30;
                            }
                            if (this.co[k].colok == 15) {
                                roofat2 -= 90;
                            }
                            if (this.co[k].colok == 20) {
                                roofat2 -= 180;
                            }
                            if (this.co[k].colok == 26) {
                                roofat2 -= 90;
                            }
                            this.rot(array5, array6, this.co[k].x, this.co[k].z, roofat2, 2);
                            if (k != 0) {
                                final int pyn = this.pyn(array5[0], array3[0], array6[0], array4[0]);
                                if (pyn >= 0 && (pyn < 100 || n6 != 2) && (pyn < n4 || n4 == -1)) {
                                    n4 = pyn;
                                    n5 = k;
                                }
                            }
                            final int pyn2 = this.pyn(array5[1], array3[0], array6[1], array4[0]);
                            if (pyn2 >= 0 && (pyn2 < 100 || n6 != 2) && (pyn2 < n4 || n4 == -1)) {
                                n4 = pyn2;
                                n5 = k;
                            }
                            if (n != 0) {
                                if (k != 0) {
                                    final int pyn3 = this.pyn(array5[0], array3[1], array6[0], array4[1]);
                                    if (pyn3 >= 0 && (pyn3 < 100 || n6 != 2) && pyn3 < n4) {
                                        n4 = pyn3;
                                        n5 = k;
                                    }
                                }
                                final int pyn4 = this.pyn(array5[1], array3[1], array6[1], array4[1]);
                                if (pyn4 >= 0 && (pyn4 < 100 || n6 != 2) && pyn4 < n4) {
                                    n4 = pyn4;
                                    n5 = k;
                                }
                            }
                        }
                    }
                }
            }
            if (n5 == -1) {
                for (int l = 0; l < this.nob; ++l) {
                    boolean b2 = false;
                    if (n2 == 2 && l == 0) {
                        b2 = true;
                    }
                    if (n != l && !b2 && array[l] == 0 && (this.co[l].colok <= 14 || this.co[l].colok >= 33) && (this.co[l].colok < 39 || this.co[l].colok >= 46) && this.co[l].colok < 52) {
                        final int[] array7 = { this.co[l].x + this.atp[this.co[l].colok][0], this.co[l].x + this.atp[this.co[l].colok][2] };
                        final int[] array8 = { this.co[l].z + this.atp[this.co[l].colok][1], this.co[l].z + this.atp[this.co[l].colok][3] };
                        int roofat3 = this.co[l].roofat;
                        if (this.co[l].colok == 2) {
                            roofat3 += 30;
                        }
                        if (this.co[l].colok == 3) {
                            roofat3 -= 30;
                        }
                        if (this.co[l].colok == 15) {
                            roofat3 -= 90;
                        }
                        if (this.co[l].colok == 20) {
                            roofat3 -= 180;
                        }
                        if (this.co[l].colok == 26) {
                            roofat3 -= 90;
                        }
                        this.rot(array7, array8, this.co[l].x, this.co[l].z, roofat3, 2);
                        if (l != 0) {
                            final int pyn5 = this.pyn(array7[0], array3[0], array8[0], array4[0]);
                            if (pyn5 >= 0 && (pyn5 < n4 || n4 == -1)) {
                                n4 = pyn5;
                                n5 = l;
                            }
                        }
                        final int pyn6 = this.pyn(array7[1], array3[0], array8[1], array4[0]);
                        if (pyn6 >= 0 && (pyn6 < n4 || n4 == -1)) {
                            n4 = pyn6;
                            n5 = l;
                        }
                        if (n != 0) {
                            if (l != 0) {
                                final int pyn7 = this.pyn(array7[0], array3[1], array8[0], array4[1]);
                                if (pyn7 >= 0 && pyn7 < n4) {
                                    n4 = pyn7;
                                    n5 = l;
                                }
                            }
                            final int pyn8 = this.pyn(array7[1], array3[1], array8[1], array4[1]);
                            if (pyn8 >= 0 && pyn8 < n4) {
                                n4 = pyn8;
                                n5 = l;
                            }
                        }
                    }
                }
            }
            if (n5 != -1) {
                n3 = 0;
                if (this.co[n5].colok != 2 && this.co[n5].colok != 3 && this.co[n5].colok != 4 && this.co[n5].colok != 7 && this.co[n5].colok != 9) {
                    if ((this.co[n5].roofat == 180 || this.co[n5].roofat == 0) && this.co[n5].z > this.co[n].z) {
                        n3 = 1;
                    }
                    if ((this.co[n5].roofat == 180 || this.co[n5].roofat == 0) && this.co[n5].z < this.co[n].z) {
                        n3 = 2;
                    }
                    if ((this.co[n5].roofat == 90 || this.co[n5].roofat == -90) && this.co[n5].x > this.co[n].x) {
                        n3 = 3;
                    }
                    if ((this.co[n5].roofat == 90 || this.co[n5].roofat == -90) && this.co[n5].x < this.co[n].x) {
                        n3 = 4;
                    }
                }
                if (this.co[n5].colok == 4 || this.co[n5].colok == 7 || this.co[n5].colok == 9) {
                    array[n5] = 2;
                }
                else {
                    array[n5] = 1;
                }
                if (this.co[n5].colok >= 46 && this.co[n5].colok <= 51) {
                    array[n5] = 6;
                }
                if ((n = n5) == 0) {
                    array[0] = 1;
                    j = 1;
                }
                else {
                    array2[n2] = n5;
                    ++n2;
                }
            }
            else {
                array[0] = 1;
                j = 1;
            }
        }
        for (int n7 = 0; n7 < this.nob; ++n7) {
            if (array[n7] == 0 && (this.co[n7].colok <= 14 || this.co[n7].colok >= 33) && (this.co[n7].colok < 39 || this.co[n7].colok >= 46) && this.co[n7].colok < 52) {
                array2[n2] = n7;
                ++n2;
            }
        }
        for (int n8 = 0; n8 < n2; ++n8) {
            if (this.co[array2[n8]].colok >= 46 && this.co[array2[n8]].colok <= 51) {
                for (int n9 = n8 + 1; n9 < n2; ++n9) {
                    final int pyn9 = this.pyn(this.co[array2[n8]].x, this.co[array2[n9]].x, this.co[array2[n8]].z, this.co[array2[n9]].z);
                    if (pyn9 >= 0 && (this.co[array2[n9]].colok < 46 || this.co[array2[n8]].colok > 51) && pyn9 < (this.co[array2[n8]].maxR + this.co[array2[n9]].maxR) / 100 * ((this.co[array2[n8]].maxR + this.co[array2[n9]].maxR) / 100)) {
                        final int n10 = array2[n9];
                        for (int n11 = n9; n11 > n8; --n11) {
                            array2[n11] = array2[n11 - 1];
                        }
                        array[array2[n8] = n10] = 0;
                        ++n8;
                    }
                }
            }
        }
        int n12 = 1;
        for (int n13 = 0; n13 < this.cp.nsp; ++n13) {
            for (int n14 = 0; n14 < this.nob; ++n14) {
                if (this.co[n14].wh == n13 + 1 && (this.co[n14].colok == 30 || this.co[n14].colok == 32 || this.co[n14].colok == 54)) {
                    int n15 = -1;
                    int n16 = -1;
                    for (int n17 = n12; n17 < n2; ++n17) {
                        if (this.co[array2[n17]].colok != 30 && this.co[array2[n17]].colok != 32 && this.co[array2[n17]].colok != 54) {
                            final int pyn10 = this.pyn(this.co[n14].x, this.co[array2[n17]].x, this.co[n14].z, this.co[array2[n17]].z);
                            if (pyn10 >= 0 && (pyn10 < n15 || n15 == -1)) {
                                n15 = pyn10;
                                n16 = n17;
                            }
                        }
                    }
                    if (n16 != -1) {
                        array[array2[n16]] = 0;
                        for (int n18 = n2; n18 > n16; --n18) {
                            array2[n18] = array2[n18 - 1];
                        }
                        array2[n16 + 1] = n14;
                        n12 = n16 + 1;
                        ++n2;
                    }
                    else {
                        array2[n2] = n14;
                        n12 = n2;
                        ++n2;
                    }
                }
            }
        }
        for (int n19 = 0; n19 < this.nob; ++n19) {
            if (this.co[n19].wh == 0 && (this.co[n19].colok == 30 || this.co[n19].colok == 32 || this.co[n19].colok == 54)) {
                int n20 = -1;
                int n21 = -1;
                for (int n22 = n12; n22 < n2; ++n22) {
                    if (this.co[array2[n22]].colok != 30 && this.co[array2[n22]].colok != 32 && this.co[array2[n22]].colok != 54) {
                        final int pyn11 = this.pyn(this.co[n19].x, this.co[array2[n22]].x, this.co[n19].z, this.co[array2[n22]].z);
                        if (pyn11 >= 0 && (pyn11 < n20 || n20 == -1)) {
                            n20 = pyn11;
                            n21 = n22;
                        }
                    }
                }
                if (n21 != -1) {
                    array[array2[n21]] = 0;
                    for (int n23 = n2; n23 > n21; --n23) {
                        array2[n23] = array2[n23 - 1];
                    }
                    array2[n21 + 1] = n19;
                    ++n2;
                }
                else {
                    array2[n2] = n19;
                    ++n2;
                }
            }
        }
        for (int n24 = 0; n24 < this.nob; ++n24) {
            if (this.co[n24].colok == 31) {
                int n25 = -1;
                int n26 = -1;
                for (int n27 = 0; n27 < n2; ++n27) {
                    final int pyn12 = this.pyn(this.co[n24].x, this.co[array2[n27]].x, this.co[n24].z, this.co[array2[n27]].z);
                    if (pyn12 >= 0 && (pyn12 < n25 || n25 == -1)) {
                        n25 = pyn12;
                        n26 = n27;
                    }
                }
                if (n26 != -1) {
                    for (int n28 = n2; n28 > n26; --n28) {
                        array2[n28] = array2[n28 - 1];
                    }
                    array2[n26] = n24;
                    ++n2;
                }
                else {
                    array2[n2] = n24;
                    ++n2;
                }
            }
        }
        for (int n29 = 0; n29 < this.nob; ++n29) {
            if (this.co[n29].colok == 15 || this.co[n29].colok == 27 || this.co[n29].colok == 28 || this.co[n29].colok == 41 || this.co[n29].colok == 44 || this.co[n29].colok == 52 || this.co[n29].colok == 53) {
                int n30 = -1;
                for (int n31 = 0; n31 < n2; ++n31) {
                    if ((this.co[array2[n31]].colok <= 14 || this.co[array2[n31]].colok >= 33) && this.co[array2[n31]].colok < 39) {
                        final int pyn13 = this.pyn(this.co[n29].x, this.co[array2[n31]].x, this.co[n29].z, this.co[array2[n31]].z);
                        if (pyn13 >= 0 && pyn13 < (this.co[n29].maxR + this.co[array2[n31]].maxR) / 100 * ((this.co[n29].maxR + this.co[array2[n31]].maxR) / 100)) {
                            n30 = n31;
                        }
                    }
                }
                if (n30 != -1) {
                    for (int n32 = n2; n32 > n30; --n32) {
                        array2[n32] = array2[n32 - 1];
                    }
                    array2[n30 + 1] = n29;
                    ++n2;
                }
                else {
                    array2[n2] = n29;
                    ++n2;
                }
            }
        }
        for (int n33 = 0; n33 < this.nob; ++n33) {
            if ((this.co[n33].colok >= 16 && this.co[n33].colok <= 25) || this.co[n33].colok == 40 || this.co[n33].colok == 42 || this.co[n33].colok == 43 || this.co[n33].colok == 45) {
                int n34 = -1;
                for (int n35 = 0; n35 < n2; ++n35) {
                    if ((this.co[array2[n35]].colok <= 14 || this.co[array2[n35]].colok >= 33) && this.co[array2[n35]].colok < 39) {
                        final int pyn14 = this.pyn(this.co[n33].x, this.co[array2[n35]].x, this.co[n33].z, this.co[array2[n35]].z);
                        if (pyn14 >= 0 && pyn14 < (this.co[n33].maxR + this.co[array2[n35]].maxR) / 100 * ((this.co[n33].maxR + this.co[array2[n35]].maxR) / 100)) {
                            if (array[array2[n35]] != 0) {
                                array[array2[n35]] = 0;
                                if (this.co[n33].colok != 20) {
                                    array[n33] = 3;
                                }
                                else {
                                    array[n33] = 5;
                                }
                            }
                            n34 = n35;
                        }
                    }
                }
                if (n34 == -1) {}
                if (n34 != -1) {
                    for (int n36 = n2; n36 > n34; --n36) {
                        array2[n36] = array2[n36 - 1];
                    }
                    array2[n34 + 1] = n33;
                    ++n2;
                }
                else {
                    array2[n2] = n33;
                    ++n2;
                }
            }
        }
        for (int n37 = 0; n37 < this.nob; ++n37) {
            if (this.co[n37].colok == 26 || this.co[n37].colok == 39) {
                boolean b3 = false;
                if (Math.random() > Math.random()) {
                    b3 = true;
                    if (this.co[n37].colok == 39) {
                        if (Math.random() > Math.random()) {
                            b3 = false;
                        }
                        else if (Math.random() > Math.random()) {
                            b3 = false;
                        }
                    }
                }
                int n38 = -1;
                for (int n39 = 0; n39 < n2; ++n39) {
                    if ((this.co[array2[n39]].colok <= 14 || this.co[array2[n39]].colok >= 33) && this.co[array2[n39]].colok < 39) {
                        final int pyn15 = this.pyn(this.co[n37].x, this.co[array2[n39]].x, this.co[n37].z, this.co[array2[n39]].z);
                        if (pyn15 >= 0 && pyn15 < (this.co[n37].maxR + this.co[array2[n39]].maxR) / 100 * ((this.co[n37].maxR + this.co[array2[n39]].maxR) / 100)) {
                            boolean b4 = false;
                            if (this.co[n37].colok == 26) {
                                if (this.co[n37].roofat == 90 && this.co[array2[n39]].x > this.co[n37].x) {
                                    b4 = true;
                                }
                                if (this.co[n37].roofat == -90 && this.co[array2[n39]].x < this.co[n37].x) {
                                    b4 = true;
                                }
                                if (this.co[n37].roofat == 0 && this.co[array2[n39]].z < this.co[n37].z) {
                                    b4 = true;
                                }
                                if (this.co[n37].roofat == 180 && this.co[array2[n39]].z > this.co[n37].z) {
                                    b4 = true;
                                }
                            }
                            if (this.co[n37].colok == 39) {
                                if (this.co[n37].roofat == 90 && this.co[array2[n39]].z > this.co[n37].z) {
                                    b4 = true;
                                }
                                if (this.co[n37].roofat == -90 && this.co[array2[n39]].z < this.co[n37].z) {
                                    b4 = true;
                                }
                                if (this.co[n37].roofat == 0 && this.co[array2[n39]].x > this.co[n37].x) {
                                    b4 = true;
                                }
                                if (this.co[n37].roofat == 180 && this.co[array2[n39]].x < this.co[n37].x) {
                                    b4 = true;
                                }
                            }
                            if (b4) {
                                if (array[array2[n39]] == 1 && b3) {
                                    array[array2[n39]] = 0;
                                    array[n37] = 4;
                                }
                                n38 = n39;
                            }
                        }
                    }
                }
                if (n38 != -1) {
                    for (int n40 = n2; n40 > n38; --n40) {
                        array2[n40] = array2[n40 - 1];
                    }
                    array2[n38 + 1] = n37;
                    ++n2;
                }
                else {
                    array2[n2] = n37;
                    ++n2;
                }
            }
        }
        for (int n41 = 0; n41 < this.nob; ++n41) {
            if ((this.co[n41].colok >= 55 && this.co[n41].colok <= 65) || this.co[n41].colok == 66) {
                array2[n2] = n41;
                ++n2;
            }
        }
        int n42 = 0;
        int n43 = 0;
        int n44 = 0;
        int n45 = 0;
        this.bstage = "";
        for (int n46 = 0; n46 < n2; ++n46) {
            if (this.co[array2[n46]].colok != 30 && this.co[array2[n46]].colok != 31 && this.co[array2[n46]].colok != 32 && this.co[array2[n46]].colok != 54 && this.co[array2[n46]].colok != 66) {
                String s = "";
                if (array[array2[n46]] == 1) {
                    s = "p";
                }
                if (array[array2[n46]] == 2) {
                    s = "pt";
                }
                if (array[array2[n46]] == 3) {
                    s = "pr";
                }
                if (array[array2[n46]] == 4) {
                    s = "ph";
                }
                if (array[array2[n46]] == 5) {
                    s = "pl";
                }
                if (array[array2[n46]] == 6) {
                    s = "pr";
                }
                this.bstage = this.bstage + "set(" + (this.co[array2[n46]].colok + 10) + "," + this.co[array2[n46]].x + "," + this.co[array2[n46]].z + "," + this.co[array2[n46]].roofat + ")" + s + "\r\n";
            }
            if (this.co[array2[n46]].colok == 30 || this.co[array2[n46]].colok == 32) {
                if (this.co[array2[n46]].roofat == 180) {
                    this.co[array2[n46]].roofat = 0;
                }
                String s2 = "";
                if (this.co[array2[n46]].wh != 0) {
                    s2 = "r";
                }
                this.bstage = this.bstage + "chk(" + (this.co[array2[n46]].colok + 10) + "," + this.co[array2[n46]].x + "," + this.co[array2[n46]].z + "," + this.co[array2[n46]].roofat + ")" + s2 + "\r\n";
            }
            if (this.co[array2[n46]].colok == 54) {
                if (this.co[array2[n46]].roofat == 180) {
                    this.co[array2[n46]].roofat = 0;
                }
                String s3 = "";
                if (this.co[array2[n46]].wh != 0) {
                    s3 = "r";
                }
                this.bstage = this.bstage + "chk(" + (this.co[array2[n46]].colok + 10) + "," + this.co[array2[n46]].x + "," + this.co[array2[n46]].z + "," + this.co[array2[n46]].roofat + "," + this.co[array2[n46]].y + ")" + s3 + "\r\n";
            }
            if (this.co[array2[n46]].colok == 31) {
                this.bstage = this.bstage + "fix(" + (this.co[array2[n46]].colok + 10) + "," + this.co[array2[n46]].x + "," + this.co[array2[n46]].z + "," + this.co[array2[n46]].y + "," + this.co[array2[n46]].roofat + ")\r\n";
            }
            if (this.co[array2[n46]].colok == 66) {
                this.bstage = this.bstage + "pile(" + this.co[array2[n46]].srz + "," + this.co[array2[n46]].srx + "," + this.co[array2[n46]].sry + "," + this.co[array2[n46]].x + "," + this.co[array2[n46]].z + ")\r\n";
            }
            if (this.co[array2[n46]].x + this.co[array2[n46]].maxR > n42) {
                n42 = this.co[array2[n46]].x + this.co[array2[n46]].maxR;
            }
            if (this.co[array2[n46]].x - this.co[array2[n46]].maxR < n44) {
                n44 = this.co[array2[n46]].x - this.co[array2[n46]].maxR;
            }
            if (this.co[array2[n46]].z + this.co[array2[n46]].maxR > n43) {
                n43 = this.co[array2[n46]].z + this.co[array2[n46]].maxR;
            }
            if (this.co[array2[n46]].z - this.co[array2[n46]].maxR < n45) {
                n45 = this.co[array2[n46]].z - this.co[array2[n46]].maxR;
            }
        }
        final int n47 = n44 - 0;
        final int n48 = n42 + 0;
        final int n49 = (int)((n48 - n47) / 4800.0f) + 1;
        final int n50 = (n49 * 4800 - (n48 - n47)) / 2;
        final int n51 = n47 - n50;
        final int n52 = n48 + n50;
        final int n53 = n51 + 2400;
        final int n54 = n45 - 0;
        final int n55 = n43 + 0;
        final int n56 = (int)((n55 - n54) / 4800.0f) + 1;
        final int n57 = (n56 * 4800 - (n55 - n54)) / 2;
        final int n58 = n54 - n57;
        final int n59 = n55 + n57;
        final int n60 = n58 + 2400;
        this.bstage = this.bstage + "\r\nmaxl(" + n56 + "," + n51 + "," + n60 + ")\r\nmaxb(" + n49 + "," + n58 + "," + n53 + ")\r\nmaxr(" + n56 + "," + n52 + "," + n60 + ")\r\nmaxt(" + n49 + "," + n59 + "," + n53 + ")\r\n";
    }
    
    public void savefile() {
        try {
            final File file = new File("" + Madness.fpath + "mystages/");
            if (!file.exists()) {
                file.mkdirs();
            }
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "mystages/" + this.stagename + ".txt")));
            bufferedWriter.write(this.tstage);
            bufferedWriter.write(this.bstage);
            bufferedWriter.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + ex, "Stage Maker", 1);
        }
        this.savesettings();
    }
    
    public void renstage(final String stagename) {
        if (stagename.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a New Stage Name!\n", "Stage Maker", 1);
        }
        else {
            try {
                if (new File("" + Madness.fpath + "mystages/" + this.stagename + ".txt").renameTo(new File("" + Madness.fpath + "mystages/" + stagename + ".txt"))) {
                    this.stagename = stagename;
                    this.sfase = 0;
                    this.hidefields();
                    this.tabed = -2;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Unable to rename stage to: '" + stagename + "', possible reason: stage name already used!\n", "Stage Maker", 1);
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + ex, "Stage Maker", 1);
            }
        }
    }
    
    public void delstage(final String s) {
        try {
            new File("" + Madness.fpath + "mystages/" + s + ".txt").delete();
            this.slstage.remove(s);
            this.slstage.select(0);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + ex, "Stage Maker", 1);
        }
    }
    
    public void deltrack() {
        try {
            new File("" + Madness.fpath + "mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip").delete();
            if (this.trackname.equals(this.tracks.getSelectedItem())) {
                this.trackname = "";
                this.sortop();
                this.savefile();
            }
            this.tracks.remove(this.tracks.getSelectedItem());
            this.tracks.select(0);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + ex, "Stage Maker", 1);
        }
    }
    
    public void loadsettings() {
        try {
            final File file = new File("" + Madness.fpath + "mystages/settings.data");
            if (file.exists()) {
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                final String line = bufferedReader.readLine();
                if (line != null) {
                    this.sstage = line;
                    this.stagename = this.sstage;
                }
                final String line2 = bufferedReader.readLine();
                if (line2 != null) {
                    this.suser = line2;
                    if (!this.suser.equals("Horaks")) {
                        this.tnick.setText(this.suser);
                    }
                }
                bufferedReader.close();
            }
        }
        catch (Exception ex) {}
    }
    
    public void savesettings() {
        if (!this.sstage.equals(this.stagename) || !this.suser.equals(this.tnick.getText())) {
            final String string = "" + this.stagename + "\n" + this.tnick.getText() + "\n\n";
            this.sstage = this.stagename;
            this.suser = this.tnick.getText();
            try {
                final File file = new File("" + Madness.fpath + "mystages/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "mystages/settings.data")));
                bufferedWriter.write(string);
                bufferedWriter.close();
            }
            catch (Exception ex) {}
        }
    }
    
    public void fixtext(final TextField textField) {
        final String replace = textField.getText().replace('\"', '#');
        final String s = "\\";
        String string = "";
        int i = 0;
        int n = -1;
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        while (i < replace.length()) {
            final String string2 = "" + replace.charAt(i);
            if (string2.equals("|") || string2.equals(",") || string2.equals("(") || string2.equals(")") || string2.equals("#") || string2.equals(s) || string2.equals("!") || string2.equals("?") || string2.equals("~") || string2.equals(".") || string2.equals("@") || string2.equals("$") || string2.equals("%") || string2.equals("^") || string2.equals("&") || string2.equals("*") || string2.equals("+") || string2.equals("=") || string2.equals(">") || string2.equals("<") || string2.equals("/") || string2.equals(";") || string2.equals(":") || this.ftm.stringWidth(string) > 274) {
                n = i;
            }
            else {
                string += string2;
            }
            ++i;
        }
        if (n != -1) {
            textField.setText(string);
            textField.select(n, n);
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
    
    public int xs(final int n, int cz) {
        if (cz < this.m.cz) {
            cz = this.m.cz;
        }
        return (cz - this.m.focus_point) * (this.m.cx - n) / cz + n;
    }
    
    public int ys(final int n, int cz) {
        if (cz < this.m.cz) {
            cz = this.m.cz;
        }
        return (cz - this.m.focus_point) * (this.m.cy - n) / cz + n;
    }
    
    public int py(final int n, final int n2, final int n3, final int n4) {
        return (int)Math.sqrt((n - n2) * (n - n2) + (n3 - n4) * (n3 - n4));
    }
    
    public int pyn(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) / 100 * ((n - n2) / 100) + (n3 - n4) / 100 * ((n3 - n4) / 100);
    }
    
    public String getstring(final String s, final String s2, final int n) {
        int n2 = 0;
        String string = "";
        for (int i = s.length() + 1; i < s2.length(); ++i) {
            final String string2 = "" + s2.charAt(i);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
                ++i;
            }
            if (n2 == n) {
                string += s2.charAt(i);
            }
        }
        return string;
    }
    
    public int getint(final String s, final String s2, final int n) {
        int n2 = 0;
        String string = "";
        for (int i = s.length() + 1; i < s2.length(); ++i) {
            final String string2 = "" + s2.charAt(i);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
                ++i;
            }
            if (n2 == n) {
                string += s2.charAt(i);
            }
        }
        return Integer.valueOf(string);
    }
    
    public Image getImage(final String s) {
        final Image image = Toolkit.getDefaultToolkit().createImage(s);
        final MediaTracker mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        }
        catch (Exception ex) {}
        return image;
    }
    
    public int servervalue(final String s, final int n) {
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
    
    public String serverSvalue(final String s, final int n) {
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
    
    public int getvalue(final String s, final String s2, final int n) {
        int n2 = 0;
        String string = "";
        for (int i = s.length() + 1; i < s2.length(); ++i) {
            final String string2 = "" + s2.charAt(i);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
                ++i;
            }
            if (n2 == n) {
                string += s2.charAt(i);
            }
        }
        return (int) Float.valueOf(string).floatValue();
    }
    
    public String getSvalue(final String s, final String s2, final int n) {
        String string = "";
        for (int n2 = 0, n3 = s.length() + 1; n3 < s2.length() && n2 <= n; ++n3) {
            final String string2 = "" + s2.charAt(n3);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
            }
            else if (n2 == n) {
                string += string2;
            }
        }
        return string;
    }
    
    public boolean button(final String s, final int n, final int n2, final int n3, final boolean b) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        final int stringWidth = this.ftm.stringWidth(s);
        boolean b2 = false;
        if (s.equals(" Cancel ") && this.epart && Math.abs(this.xm - n) < stringWidth / 2 + 12 && Math.abs(this.ym - n2 + 5) < 10) {
            this.overcan = true;
        }
        final boolean b3 = Math.abs(this.xm - n) < stringWidth / 2 + 12 && Math.abs(this.ym - n2 + 5) < 10 && this.mouses == 1;
        if (Math.abs(this.xm - n) < stringWidth / 2 + 12 && Math.abs(this.ym - n2 + 5) < 10 && this.mouses == -1) {
            this.mouses = 0;
            b2 = true;
        }
        boolean b4 = false;
        if (b) {
            if (this.tab == 0) {
                this.rd.setColor(new Color(207, 207, 207));
            }
            if (this.tab == 1) {
                this.rd.setColor(new Color(200, 200, 200));
            }
            if (this.tab == 2) {
                this.rd.setColor(new Color(170, 170, 170));
            }
            if (this.tab != 3) {
                this.rd.drawRect(n - stringWidth / 2 - 15, n2 - (22 - n3), stringWidth + 29, 34 - n3 * 2);
                if (n3 == 2 && this.tab == 1) {
                    this.rd.setColor(new Color(220, 220, 220));
                    this.rd.fillRect(n - stringWidth / 2 - 15, n2 - (22 - n3), stringWidth + 29, 34 - n3 * 2);
                }
            }
            else {
                b4 = true;
            }
        }
        if (!b3) {
            this.rd.setColor(new Color(220, 220, 220));
            if (b4) {
                this.rd.setColor(new Color(230, 230, 230));
            }
            this.rd.fillRect(n - stringWidth / 2 - 10, n2 - (17 - n3), stringWidth + 20, 25 - n3 * 2);
            this.rd.setColor(new Color(240, 240, 240));
            if (b4) {
                this.rd.setColor(new Color(255, 255, 255));
            }
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (18 - n3), n + stringWidth / 2 + 10, n2 - (18 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 - (19 - n3), n + stringWidth / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            if (b4) {
                this.rd.setColor(new Color(192, 192, 192));
            }
            this.rd.drawLine(n + stringWidth / 2 + 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + stringWidth / 2 + 11, n2 - (17 - n3), n + stringWidth / 2 + 11, n2 + (7 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            if (b4) {
                this.rd.setColor(new Color(192, 192, 192));
            }
            this.rd.drawLine(n + stringWidth / 2 + 12, n2 - (16 - n3), n + stringWidth / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (7 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (8 - n3), n + stringWidth / 2 + 10, n2 + (8 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 + (9 - n3), n + stringWidth / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            if (b4) {
                this.rd.setColor(new Color(255, 255, 255));
            }
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n - stringWidth / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 11, n2 - (17 - n3), n - stringWidth / 2 - 11, n2 + (7 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - stringWidth / 2 - 12, n2 - (16 - n3), n - stringWidth / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            if (s.equals("  Keyboard Controls  ")) {
                this.rd.setColor(new Color(100, 100, 100));
            }
            this.rd.drawString(s, n - stringWidth / 2, n2);
        }
        else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(n - stringWidth / 2 - 10, n2 - (17 - n3), stringWidth + 20, 25 - n3 * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (18 - n3), n + stringWidth / 2 + 10, n2 - (18 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 - (19 - n3), n + stringWidth / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(n + stringWidth / 2 + 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + stringWidth / 2 + 11, n2 - (17 - n3), n + stringWidth / 2 + 11, n2 + (7 - n3));
            this.rd.drawLine(n + stringWidth / 2 + 12, n2 - (16 - n3), n + stringWidth / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (7 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (8 - n3), n + stringWidth / 2 + 10, n2 + (8 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 + (9 - n3), n + stringWidth / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n - stringWidth / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 11, n2 - (17 - n3), n - stringWidth / 2 - 11, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 12, n2 - (16 - n3), n - stringWidth / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            if (s.equals("  Keyboard Controls  ")) {
                this.rd.setColor(new Color(100, 100, 100));
            }
            this.rd.drawString(s, n - stringWidth / 2 + 1, n2 + 1);
        }
        return b2;
    }
    
    public boolean ovbutton(final String s, final int n, final int n2) {
        this.rd.setFont(new Font("Arial", 0, 12));
        this.ftm = this.rd.getFontMetrics();
        if (s.equals("X") || s.equals("Download")) {
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
        }
        final int stringWidth = this.ftm.stringWidth(s);
        final int n3 = 4;
        boolean b = false;
        final boolean b2 = Math.abs(this.xm - n) < stringWidth / 2 + 12 && Math.abs(this.ym - n2 + 5) < 10 && this.mouses == 1;
        if (Math.abs(this.xm - n) < stringWidth / 2 + 12 && Math.abs(this.ym - n2 + 5) < 10 && this.mouses == -1) {
            this.mouses = 0;
            b = true;
        }
        if (!b2) {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(n - stringWidth / 2 - 10, n2 - (17 - n3), stringWidth + 20, 25 - n3 * 2);
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (18 - n3), n + stringWidth / 2 + 10, n2 - (18 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 - (19 - n3), n + stringWidth / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(n + stringWidth / 2 + 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + stringWidth / 2 + 11, n2 - (17 - n3), n + stringWidth / 2 + 11, n2 + (7 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(n + stringWidth / 2 + 12, n2 - (16 - n3), n + stringWidth / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (7 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (8 - n3), n + stringWidth / 2 + 10, n2 + (8 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 + (9 - n3), n + stringWidth / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n - stringWidth / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 11, n2 - (17 - n3), n - stringWidth / 2 - 11, n2 + (7 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - stringWidth / 2 - 12, n2 - (16 - n3), n - stringWidth / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            if (s.equals("X")) {
                this.rd.setColor(new Color(255, 0, 0));
            }
            if (s.equals("Download")) {
                this.rd.setColor(new Color(0, 64, 128));
            }
            this.rd.drawString(s, n - stringWidth / 2, n2);
        }
        else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(n - stringWidth / 2 - 10, n2 - (17 - n3), stringWidth + 20, 25 - n3 * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (18 - n3), n + stringWidth / 2 + 10, n2 - (18 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 - (19 - n3), n + stringWidth / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(n + stringWidth / 2 + 10, n2 - (17 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + stringWidth / 2 + 11, n2 - (17 - n3), n + stringWidth / 2 + 11, n2 + (7 - n3));
            this.rd.drawLine(n + stringWidth / 2 + 12, n2 - (16 - n3), n + stringWidth / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (7 - n3), n + stringWidth / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 + (8 - n3), n + stringWidth / 2 + 10, n2 + (8 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 9, n2 + (9 - n3), n + stringWidth / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(n - stringWidth / 2 - 10, n2 - (17 - n3), n - stringWidth / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 11, n2 - (17 - n3), n - stringWidth / 2 - 11, n2 + (7 - n3));
            this.rd.drawLine(n - stringWidth / 2 - 12, n2 - (16 - n3), n - stringWidth / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            if (s.equals("X")) {
                this.rd.setColor(new Color(255, 0, 0));
            }
            if (s.equals("Download")) {
                this.rd.setColor(new Color(0, 64, 128));
            }
            this.rd.drawString(s, n - stringWidth / 2 + 1, n2 + 1);
        }
        return b;
    }
    
    public void openlink() {
        Madness.openurl("http://www.needformadness.com/developer/help.html");
    }
    
    public void openhlink() {
        Madness.openurl("http://www.needformadness.com/developer/");
    }
}
