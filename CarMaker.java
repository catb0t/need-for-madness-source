import java.awt.TextComponent;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.MenuItem;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.FileReader;
import java.awt.FileDialog;
import java.awt.Frame;
import java.util.zip.ZipEntry;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.image.ImageObserver;
import java.io.File;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.PopupMenu;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.applet.Applet;

public class CarMaker extends Applet implements Runnable, ActionListener
{
    Graphics2D rd;
    Image offImage;
    Thread thredo;
    boolean exwist;
    FontMetrics ftm;
    int apx;
    int apy;
    boolean focuson;
    Image[] btgame;
    Image logo;
    boolean onbtgame;
    int tab;
    int tabed;
    boolean loadedfile;
    String carname;
    String scar;
    String suser;
    String sfont;
    int sthm;
    int sfase;
    Smenu slcar;
    boolean tutok;
    int flk;
    boolean changed;
    String lastedo;
    boolean prefs;
    boolean mirror;
    PopupMenu popupMenu;
    TextArea editor;
    TextField srch;
    TextField rplc;
    Smenu fontsel;
    String cfont;
    Smenu ctheme;
    Color defb;
    Color deff;
    int cthm;
    int cntprf;
    int cntpls;
    int cntchk;
    int npolys;
    boolean tomany;
    int ox;
    int oy;
    int oz;
    int oxz;
    int oxy;
    int ozy;
    Medium m;
    Trackers t;
    ContO o;
    ContO[] compo;
    boolean right;
    boolean left;
    boolean up;
    boolean down;
    boolean rotl;
    boolean rotr;
    boolean plus;
    boolean minus;
    boolean in;
    boolean out;
    boolean pflk;
    boolean breakbond;
    int polynum;
    int prflk;
    int bfo;
    int dtab;
    int dtabed;
    int mouseon;
    String fcol;
    String ofcol;
    String scol;
    String oscol;
    float[] fhsb;
    float[] shsb;
    int[] scale;
    int[] oscale;
    Smenu compcar;
    int compsel;
    int[] adna;
    boolean changed2;
    TextField[] wv;
    boolean defnow;
    String aply1;
    String aply2;
    boolean aplyd1;
    boolean aplyd2;
    boolean forwheels;
    Smenu cls;
    Smenu simcar;
    int[] stat;
    int[] rstat;
    int[][] carstat;
    int carsel;
    int clsel;
    boolean statdef;
    int pfase;
    int[] phys;
    int[] rphys;
    int[] crash;
    int[] rcrash;
    String[] pname;
    int[] pnx;
    String[] usage;
    int hitmag;
    int actmag;
    int squash;
    boolean crashok;
    boolean crashleft;
    soundClip[] crashs;
    soundClip[] lowcrashs;
    Smenu engine;
    soundClip[][] engs;
    int engsel;
    boolean engon;
    Smenu witho;
    boolean tested;
    boolean rateh;
    int handling;
    int logged;
    TextField tnick;
    TextField tpass;
    Smenu pubitem;
    Smenu pubtyp;
    int nmc;
    int roto;
    String[] mycars;
    String[] maker;
    int[] pubt;
    int[] clas;
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
    int sls;
    int sle;
    int crshturn;
    boolean crashup;
    boolean openm;
    boolean mousdr;
    boolean waso;
    boolean objfacend;
    boolean multf10;

    public CarMaker() {
        this.exwist = false;
        this.apx = 0;
        this.apy = 0;
        this.focuson = true;
        this.btgame = new Image[2];
        this.onbtgame = false;
        this.tab = 0;
        this.tabed = -1;
        this.loadedfile = false;
        this.carname = "";
        this.scar = "";
        this.suser = "Horaks";
        this.sfont = "Monospaced";
        this.sthm = 0;
        this.sfase = 0;
        this.slcar = new Smenu(2000);
        this.tutok = false;
        this.flk = 0;
        this.changed = false;
        this.lastedo = "";
        this.prefs = false;
        this.mirror = false;
        this.editor = new TextArea(20, 20);
        this.srch = new TextField("", 15);
        this.rplc = new TextField("", 15);
        this.fontsel = new Smenu(40);
        this.cfont = "Monospaced";
        this.ctheme = new Smenu(40);
        this.cthm = 0;
        this.cntprf = 0;
        this.cntpls = 0;
        this.cntchk = 0;
        this.npolys = 0;
        this.tomany = false;
        this.ox = 335;
        this.oy = 40;
        this.oz = 800;
        this.oxz = -90;
        this.oxy = 0;
        this.ozy = 0;
        this.m = new Medium();
        this.t = new Trackers();
        this.compo = new ContO[16];
        this.right = false;
        this.left = false;
        this.up = false;
        this.down = false;
        this.rotl = false;
        this.rotr = false;
        this.plus = false;
        this.minus = false;
        this.in = false;
        this.out = false;
        this.pflk = false;
        this.breakbond = false;
        this.polynum = -1;
        this.prflk = 0;
        this.bfo = 0;
        this.dtab = 0;
        this.dtabed = -1;
        this.mouseon = -1;
        this.fcol = "";
        this.ofcol = "";
        this.scol = "";
        this.oscol = "";
        this.fhsb = new float[] { 0.5f, 0.5f, 0.5f };
        this.shsb = new float[] { 0.5f, 0.5f, 0.5f };
        this.scale = new int[] { 100, 100, 100 };
        this.oscale = new int[] { 100, 100, 100 };
        this.compcar = new Smenu(40);
        this.compsel = 0;
        this.adna = new int[] { 276, 276, 276, 276, 276, 276 };
        this.changed2 = false;
        this.wv = new TextField[16];
        this.defnow = false;
        this.aply1 = "";
        this.aply2 = "";
        this.aplyd1 = false;
        this.aplyd2 = false;
        this.forwheels = false;
        this.cls = new Smenu(40);
        this.simcar = new Smenu(40);
        this.stat = new int[] { 100, 100, 100, 100, 100 };
        this.rstat = new int[] { 0, 0, 0, 0, 0 };
        this.carstat = new int[][] { { 110, 81, 131, 98, 100 }, { 200, 200, 88, 16, 16 }, { 108, 80, 93, 114, 125 }, { 146, 119, 100, 83, 72 }, { 109, 85, 141, 96, 93 }, { 128, 98, 102, 109, 123 }, { 115, 139, 96, 117, 133 }, { 120, 81, 145, 126, 128 }, { 140, 122, 101, 113, 124 }, { 110, 144, 100, 154, 92 }, { 133, 122, 144, 115, 126 }, { 107, 96, 96, 192, 189 }, { 192, 200, 106, 92, 90 }, { 88, 104, 88, 200, 200 }, { 148, 150, 197, 95, 90 }, { 112, 128, 120, 192, 128 } };
        this.carsel = 0;
        this.clsel = 0;
        this.statdef = false;
        this.pfase = 0;
        this.phys = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
        this.rphys = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
        this.crash = new int[] { 50, 50, 50 };
        this.rcrash = new int[] { 50, 50, 50 };
        this.pname = new String[] { "Handbrake", "Turning Sensitivity", "Tire Grip", "Bouncing", "Empty", "Lifts Others", "Gets Lifted", "Pushes Others", "Gets Pushed", "Aerial Rotation Speed", "Aerial Control/Gliding" };
        this.pnx = new int[] { 62, 20, 76, 71, 60, 38, 44, 20, 33, 320, 324 };
        this.usage = new String[] { "Handbrake:\nThis defines the hand braking power of the car.\nThe more handbrake the car has the faster it brakes when you press Spacebar while driving.\nBut also the lesser the Handbrake the more the car can drift when you press Spacebar.\n\n", "Turning Sensitivity:\nThis defines how fast the car turns (or how fast the wheels respond to turning).\nThe more turning sensitive the faster the car turns and responds.\n\nWhen designing a fast car that is more racing oriented high turning sensitivity is     \nrecommended for the car to be able to take sharp and quick turns.\nHowever too much turning sensitivity can make the car hard to drive!\n\nWhen designing a slower and bigger car (like El King) lower turning sensitivity is\nrecommended for a more realistic effect.\n\n", "Tires Grip:\nThis defines the griping power of the car\u2019s wheels on the ground.\n\nThe more griping the more the cars sticks to track.\nThe less gripping the more the car drifts in the turns.\n\nSome drifting can be helpful as it makes the car drive smoother while less drifting can\nmake the car more irritable, it depends on how you like to drive the car and how it\nfeels for you.\n\n", "Bouncing:\nThis defines how the car bounces back when it hits the ground or obstacles.\n\nBouncing can help when performing stunts as when you land up side down\nif the car bounces it can be filliped over before landing again to avoid a 'bad landing'.\n\nHowever bouncing is not helpful in controlling the car and in racing.\n\n", "If you can read this then you are decompiling the code! Please don\u2019t bother trying to allow the car maker to give you max stats, the stats get check on the server before the car can be accepted. Just to save you sometime.", "Lifts Others:\nThis defines if the car lifts up other cars when it collides with them from the front and\nhow high it can lift them.\n\nDoes the car have a pointy nose like MAX Revenge, Radical One or La Vita Crab, a\npointy nose/front part that can go under the wheels of other cars and lift them?\nIf so then give it some Lifts Others.\n\nIf it has a nose/front part that is a block like most cars then give it 0 Lifts Others.\n\n", "Gets Lifted:\nThis defines if the car can get lifted over other cars when it collides with them and how\nhigh it can get lifted.\n\nIs the car higher off the ground like Wow Caninaro or has big wheels like Dr Monstaa,\nshould its jump over cars when it collides with them?\nIf so then give it some Gets Lifted depending on how high it should go.\n\nIf the car is lower to the ground like most cars then it should have 0 Gets Lifted\n\n", "Pushes Others:\nThis defines if the car pushes other cars away when it collides with them and how far it\ncan push them.\n\nIs the car a heavy car with a strong body like MASHEEN or El King, where when it\ncollides with other cars it pushes them away?\nOr does the car have special bumpers or body parts for pushing cars away like Sword of\nJustice has?\nIf so then give it some Pushes Others depending how strong you think it can push cars.\n\nIf it is a car like any other car, with an average weight and body strength then you should\ngive it 0 Pushes Others.\n\n", "Gets Pushed:\nThis defines if the car gets pushed away when it collides with other cars and how far it\ngets pushed away.\n\nIf the car is lighter then most cars, then it should get pushed away when it collides with\nothers cars.\nGetting pushed can be helpful if the car is week because it gets it away from the danger\n(from the car that hit it) faster, making it take lesser hits and escape better.\nHowever getting pushed is not helpful when racing.\n\n", "Aerial Rotation Speed:\nThis adjusts how fast the car can rotate and flip in the air when its performing a stunt.\n\nThis variable also depends on how much the \u2018Stunts\u2019 stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf you think the car is rotating too fast or too slow in the air when performing a stunt use\nthis variable to adjust that.\n\nIf the aerial rotation is too fast it can make the car hard to control in the air as it flips and\nhard to land upright.\n\nIf the car is a big and heavy car like MASHHEN or El King then it should have low\naerial rotation for a realistic effect.\n\n", "Aerial Control/Gliding:\nThis adjusts the cars ability to push itself in the air and glide when performing stunts!\n\nIf you don\u2019t know, in the game:\nBackward looping pushes the car upwards. \nForward looping pushes the car forwards. \nLeft and right rolling pushes the car left and right. \n\nThis variable adjust the power if this aerial push.\n\nThe variable also depends on how much the \u2018Stunts\u2019 stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf the car has some kind of wings or fins like Radical One or Kool Kat have then it should\nhave higher aerial control and gliding ability.\n\n", "Crash Look Test!\nThis defines how the car will look when it gets damaged.\nOr in other words what the car will look like as it gets damaged until it becomes wasted!\n\nIMPORTANT:\nYou need to perform a 'Normal Crash' test with a 'Roof Crash' test until the car gets totally destroyed (gets wasted and burns).\nYou need to also try a 'Normal Crash' test alone (without the roof crash) until the car gets wasted!\nA 'Roof Crash' happens significantly more when the car falls on its roof from a high jumps.\nA 'Normal Crash' is what happens as the car crashes normally with other cars and obstacles.\n\nClick any of adjustment variable names \u2018Radius\u2019, \u2018Magnitude\u2019 and \u2018Roof Destruction\u2019 to learn about their effect.\n\n>  You must perform the crash test more then once in order to make sure that this is how your want the car to look as it gets damaged\nuntil total destruction.", "Crash Radius:\nThe radius around the crash at which the polygons/pieces that lay inside it get\naffected.\n\nOr basically in other words the number of pieces that get affected on collision (the pieces\naround the crash location).\n\nIncreasing the radius will result in more pieces/polygons around the point of collision\ngetting crashed and distorted.\nDecreasing the radius means less pieces/polygons around the collision point getting\ndistorted and crashed.\n\n", "Crash Magnitude:\nThe magnitude of the distortion and indentation to occur on the effected pieces/polygons.\n\nOr basically in other words the amount of destruction that happens to each piece when\ncrashed.\n\nHigher magnitude means the piece gets more destructed from an amount of damage,\nlower magnitude means the piece gets less destructed from that same amount of damage.\n\n", "Roof Destruction:\nThe amount of destruction to occur on the car\u2019s top.\nThe length of indentation and destruction to happen from above.\n\nTo really see this variable's effect try crashing the roof alone (without a normal crash),\ntry more then once while fixing the car and changing the variable\u2019s value to see the\ndifference.\n\nThe roof crash normally happens in the game when the car lands upside down from a\njump or when a big car like Dr Monstaa steps on it.\n\n" };
        this.hitmag = 0;
        this.actmag = 0;
        this.squash = 0;
        this.crashok = false;
        this.crashleft = false;
        this.crashs = new soundClip[3];
        this.lowcrashs = new soundClip[3];
        this.engine = new Smenu(40);
        this.engs = new soundClip[5][5];
        this.engsel = 0;
        this.engon = false;
        this.witho = new Smenu(40);
        this.tested = false;
        this.rateh = false;
        this.handling = 140;
        this.logged = 0;
        this.tnick = new TextField("", 15);
        this.tpass = new TextField("", 15);
        this.pubitem = new Smenu(707);
        this.pubtyp = new Smenu(40);
        this.nmc = 0;
        this.roto = 0;
        this.mycars = new String[20];
        this.maker = new String[20];
        this.pubt = new int[20];
        this.clas = new int[20];
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
        this.sls = -1;
        this.sle = -1;
        this.crshturn = 0;
        this.crashup = false;
        this.openm = false;
        this.mousdr = false;
        this.waso = false;
        this.objfacend = false;
        this.multf10 = false;
    }

    @Override
    public void run() {
        this.thredo.setPriority(10);
        this.btgame[0] = this.getImage("" + Madness.fpath + "data/backtogame1.gif");
        this.btgame[1] = this.getImage("" + Madness.fpath + "data/backtogame2.gif");
        this.logo = this.getImage("" + Madness.fpath + "data/carmakerlogo.gif");
        this.m.w = 700;
        this.m.cx = 350;
        this.m.y = -240;
        this.m.z = -400;
        this.m.zy = 4;
        this.m.focus_point = 800;
        this.m.fadfrom(8000);
        this.m.cfade[0] = 187;
        this.m.cfade[1] = 210;
        this.m.cfade[2] = 227;
        this.loadsounds();
        this.loadbase();
        this.m.loadnew = true;
        this.loadsettings();
        this.editor.setFont(new Font(this.cfont, 1, 14));
        this.srch.setFont(new Font(this.cfont, 1, 14));
        this.rplc.setFont(new Font(this.cfont, 1, 14));
        for (int i = 0; i < 16; ++i) {
            this.wv[i].setFont(new Font(this.cfont, 1, 14));
        }
        this.setheme();
        if (Madness.testdrive != 0) {
            if (Madness.testcar.equals("Failx12")) {
                JOptionPane.showMessageDialog(null, "Failed to load car! Please make sure car is saved before Test Drive.", "Car Maker", 1);
                this.thredo.stop();
            }
            else {
                this.carname = Madness.testcar;
                this.loadfile();
                if (this.loadedfile) {
                    this.tested = true;
                    this.tab = 2;
                    this.dtab = 6;
                    this.witho.select(Madness.testdrive - 1);
                }
            }
            Madness.testcar = "";
            Madness.testdrive = 0;
        }
        int n = 0;
        if (!this.carname.equals("")) {
            this.tutok = true;
            n = 1;
        }
        while (!this.exwist) {
            if (this.tab != this.tabed) {
                this.hidefields();
                if (this.tab == 1) {
                    this.editor.enable();
                }
                else {
                    this.editor.disable();
                }
                if (this.tabed == 2) {
                    if (!this.breakbond) {
                        if (!this.editor.getText().equals(this.lastedo)) {
                            this.editor.setText(this.lastedo);
                        }
                    }
                    else {
                        this.breakbond = false;
                    }
                }
                this.setCursor(new Cursor(0));
            }
            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(0, 0, 700, 550);
            this.rd.setColor(new Color(0, 0, 0));
            this.btn = 0;
            int n2 = 50;
            if (this.tab == 0) {
                if (this.tabed != this.tab) {
                    this.slcar.removeAll();
                    this.slcar.maxl = 200;
                    this.slcar.add(this.rd, "Select a Car                      ");
                    final String[] list = new File("" + Madness.fpath + "mycars/").list();
                    if (list != null) {
                        for (int j = 0; j < list.length; ++j) {
                            if (list[j].toLowerCase().endsWith(".rad")) {
                                this.slcar.add(this.rd, list[j].substring(0, list[j].length() - 4));
                            }
                        }
                    }
                    if (this.carname.equals("")) {
                        this.slcar.select(0);
                    }
                    else {
                        this.slcar.select(this.carname);
                        if (this.carname.equals(this.slcar.getSelectedItem())) {
                            this.loadfile();
                        }
                    }
                    this.mouseon = -1;
                    this.srch.setText("");
                    this.sfase = 0;
                }
                this.rd.setFont(new Font("Arial", 1, 13));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawImage(this.logo, 214, 35, null);
                if (this.xm > 214 && this.xm < 485 && this.ym > 25 && this.ym < 104 && !this.openm) {
                    if (this.mouseon == -1) {
                        this.mouseon = 3;
                        this.setCursor(new Cursor(12));
                    }
                }
                else if (this.mouseon == 3) {
                    this.mouseon = -1;
                    this.setCursor(new Cursor(0));
                }
                if (this.mouseon == 3 && this.mouses == -1) {
                    this.openhlink();
                }
                int n3 = 30;
                int n4 = 0;
                if (this.tutok) {
                    n3 = 250;
                    n4 = -70;
                }
                if (this.xm > 76 && this.xm < 624 && this.ym > 84 + n3 && this.ym < 167 + n3 && !this.openm) {
                    if (this.mouseon == -1) {
                        this.mouseon = 1;
                        this.setCursor(new Cursor(12));
                    }
                }
                else if (this.mouseon == 1) {
                    this.mouseon = -1;
                    this.setCursor(new Cursor(0));
                }
                int n5 = 0;
                if (!this.tutok && this.mouseon != 1 && n == 0) {
                    if (this.flk <= 0) {
                        this.rd.setColor(new Color(255, 0, 0));
                        --this.flk;
                        if (this.flk == -2) {
                            this.flk = 1;
                        }
                    }
                    else {
                        this.rd.setColor(new Color(0, 0, 255));
                        n5 = 2;
                        ++this.flk;
                        if (this.flk == 3) {
                            this.flk = 0;
                        }
                    }
                }
                this.rd.drawLine(76 + n5, 84 + n3, 76 + n5, 167 + n3);
                this.rd.drawLine(76 + n5, 84 + n3, 95 + n5, 84 + n3);
                this.rd.drawLine(76 + n5, 167 + n3, 95 + n5, 167 + n3);
                this.rd.drawLine(624 - n5, 84 + n3, 624 - n5, 167 + n3);
                this.rd.drawLine(624 - n5, 84 + n3, 605 - n5, 84 + n3);
                this.rd.drawLine(624 - n5, 167 + n3, 605 - n5, 167 + n3);
                if (this.mouseon == 1) {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                else {
                    this.rd.setColor(new Color(0, 0, 0));
                }
                this.rd.drawString("If this is your first time creating a car please follow the tutorial found at:", 106, 110 + n3);
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("http://www.needformadness.com/developer/simplecar.html", 106, 130 + n3);
                if (this.mouseon == 1) {
                    this.rd.setColor(new Color(0, 128, 255));
                }
                else {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                this.rd.drawLine(106, 131 + n3, 480, 131 + n3);
                if (this.mouseon == 1) {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                else {
                    this.rd.setColor(new Color(0, 0, 0));
                }
                this.rd.drawString("It is highly recommended that you follow this tutorial before trying anything!", 106, 150 + n3);
                if (this.mouseon == 1 && this.mouses == -1) {
                    this.openlink();
                    n = 1;
                }
                if (this.xm > 200 && this.xm < 500 && this.ym > 467 && this.ym < 504 && !this.openm) {
                    if (this.mouseon == -1) {
                        this.mouseon = 2;
                        this.setCursor(new Cursor(12));
                    }
                }
                else if (this.mouseon == 2) {
                    this.mouseon = -1;
                    this.setCursor(new Cursor(0));
                }
                this.ftm = this.rd.getFontMetrics();
                if (this.mouseon == 2) {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                else {
                    this.rd.setColor(new Color(0, 0, 0));
                }
                this.rd.drawString("For the Car Maker Homepage, Development Center and Forums :", 350 - this.ftm.stringWidth("For the Car Maker Homepage, Development Center and Forums :") / 2, 480);
                this.rd.setColor(new Color(0, 128, 255));
                final String s = "http://www.needformadness.com/developer/";
                this.rd.drawString(s, 350 - this.ftm.stringWidth(s) / 2, 500);
                if (this.mouseon == 2) {
                    this.rd.setColor(new Color(0, 128, 255));
                }
                else {
                    this.rd.setColor(new Color(0, 64, 128));
                }
                this.rd.drawLine(350 - this.ftm.stringWidth(s) / 2, 501, 350 + this.ftm.stringWidth(s) / 2, 501);
                if (this.mouseon == 2 && this.mouses == -1) {
                    this.openhlink();
                }
                int n6 = 0;
                if (this.sfase == 3) {
                    n6 = 100;
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRect(177 - n6, 202 + n4, 346 + n6 * 2, 167 + n6 / 5);
                if (this.sfase == 0) {
                    this.rd.drawString("Select Car to Edit", 350 - this.ftm.stringWidth("Select Car to Edit") / 2, 230 + n4);
                    this.slcar.move(250, 240 + n4);
                    if (this.slcar.getWidth() != 200) {
                        this.slcar.setSize(200, 21);
                    }
                    if (!this.slcar.isShowing()) {
                        this.slcar.show();
                    }
                    this.stringbutton("    Make new Car    ", 430, 296 + n4, 0, true);
                    this.stringbutton("     Rename Car     ", 270, 296 + n4, 0, false);
                    this.stringbutton("      Delete Car      ", 270, 336 + n4, 0, false);
                    this.stringbutton("     Import & Export     ", 430, 336 + n4, 0, false);
                    if (this.slcar.getSelectedIndex() != 0) {
                        if (!this.carname.equals(this.slcar.getSelectedItem())) {
                            this.tomany = false;
                            this.carname = this.slcar.getSelectedItem();
                            this.loadfile();
                            this.editor.select(0, 0);
                            this.tested = false;
                            this.requestFocus();
                        }
                    }
                    else {
                        this.carname = "";
                    }
                }
                if (this.sfase == 1) {
                    this.rd.drawString("Make a new Car", 350 - this.ftm.stringWidth("Make a new Car") / 2, 230 + n4);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New car name :", 228, 266 + n4);
                    this.movefield(this.srch, 335, 250 + n4, 129, 22);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    this.fixtext(this.srch);
                    this.stringbutton("    Make Car    ", 350, 306 + n4, 0, true);
                    this.stringbutton("  Cancel  ", 350, 346 + n4, 0, false);
                }
                if (this.sfase == 2) {
                    this.rd.drawString("Rename Car :  " + this.carname + "", 350 - this.ftm.stringWidth("Rename Car :  " + this.carname + "") / 2, 230 + n4);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New name :", 239, 266 + n4);
                    this.movefield(this.srch, 316, 250 + n4, 129, 22);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    this.fixtext(this.srch);
                    this.stringbutton("   Rename Car   ", 350, 306 + n4, 0, true);
                    this.stringbutton("  Cancel  ", 350, 346 + n4, 0, false);
                }
                if (this.sfase == 3) {
                    this.rd.drawString("Import a Wavefront OBJ 3D Model", 350 - this.ftm.stringWidth("Import a Wavefront OBJ 3D Model") / 2, 230 + n4);
                    if (this.xm > 116 && this.xm < 584 && this.ym > 246 + n4 && this.ym < 290 + n4) {
                        if (this.mouseon == -1) {
                            this.mouseon = 3;
                            this.setCursor(new Cursor(12));
                        }
                    }
                    else if (this.mouseon == 3) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                    this.ftm = this.rd.getFontMetrics();
                    if (this.mouseon == 3) {
                        this.rd.setColor(new Color(0, 64, 128));
                    }
                    else {
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    this.rd.drawString("Please read the important information about importing cars found at:", 350 - this.ftm.stringWidth("Please read the important information about importing cars, found here :") / 2, 260 + n4);
                    this.rd.setColor(new Color(0, 128, 255));
                    final String s2 = "http://www.needformadness.com/developer/extras.html";
                    this.rd.drawString(s2, 350 - this.ftm.stringWidth(s2) / 2, 280 + n4);
                    if (this.mouseon == 3) {
                        this.rd.setColor(new Color(0, 128, 255));
                    }
                    else {
                        this.rd.setColor(new Color(0, 64, 128));
                    }
                    this.rd.drawLine(350 - this.ftm.stringWidth(s2) / 2, 281 + n4, 350 + this.ftm.stringWidth(s2) / 2, 281 + n4);
                    if (this.mouseon == 3 && this.mouses == -1) {
                        this.openelink();
                    }
                    this.stringbutton("     Import Car     ", 350, 326 + n4, 0, true);
                    this.stringbutton("  Export >  ", 550, 326 + n4, 0, false);
                    this.stringbutton("  Cancel  ", 350, 366 + n4, 0, false);
                }
                if (this.sfase == 4) {
                    this.rd.drawString("Select Car to Export", 350 - this.ftm.stringWidth("Select Car to Export") / 2, 230 + n4);
                    this.slcar.move(250, 240 + n4);
                    if (this.slcar.getWidth() != 200) {
                        this.slcar.setSize(200, 21);
                    }
                    if (!this.slcar.isShowing()) {
                        this.slcar.show();
                    }
                    this.stringbutton("     Export Car     ", 350, 306 + n4, 0, true);
                    this.stringbutton("  Cancel  ", 350, 346 + n4, 0, false);
                    if (this.slcar.getSelectedIndex() != 0) {
                        if (!this.carname.equals(this.slcar.getSelectedItem())) {
                            this.tomany = false;
                            this.carname = this.slcar.getSelectedItem();
                            this.loadfile();
                            this.editor.select(0, 0);
                            this.tested = false;
                            this.requestFocus();
                        }
                    }
                    else {
                        this.carname = "";
                    }
                }
            }
            if (this.tab == 1) {
                if (this.tabed != this.tab) {
                    this.srch.setText("");
                    this.rplc.setText("");
                    this.cntchk = 1;
                    this.npolys = 0;
                    this.prefs = false;
                }
                this.movefield(this.editor, 5, 30, 690, 400);
                if (!this.openm) {
                    if (!this.editor.isShowing()) {
                        this.editor.show();
                        this.editor.requestFocus();
                    }
                }
                else if (this.editor.isShowing()) {
                    this.editor.hide();
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                if (this.prefs) {
                    this.rd.drawString("Code Font:", 10, 446);
                    this.fontsel.move(76, 430);
                    if (!this.fontsel.isShowing()) {
                        this.fontsel.show();
                        this.fontsel.select(this.cfont);
                    }
                    if (!this.cfont.equals(this.fontsel.getSelectedItem())) {
                        this.cntprf = 0;
                        this.cfont = this.fontsel.getSelectedItem();
                        this.editor.setFont(new Font(this.cfont, 1, 14));
                        this.srch.setFont(new Font(this.cfont, 1, 14));
                        this.rplc.setFont(new Font(this.cfont, 1, 14));
                        for (int k = 0; k < 16; ++k) {
                            this.wv[k].setFont(new Font(this.cfont, 1, 14));
                        }
                        this.editor.requestFocus();
                    }
                    this.rd.drawString("Code Theme:", 190, 446);
                    this.ctheme.move(271, 430);
                    if (!this.ctheme.isShowing()) {
                        this.ctheme.show();
                        this.ctheme.select(this.cthm);
                    }
                    if (this.cthm != this.ctheme.getSelectedIndex()) {
                        this.cntprf = 0;
                        this.cthm = this.ctheme.getSelectedIndex();
                        this.setheme();
                        this.editor.requestFocus();
                    }
                    this.stringbutton("<", 400, 446, 3, false);
                    ++this.cntprf;
                    if (this.cntprf == 200) {
                        this.prefs = false;
                    }
                }
                else {
                    this.stringbutton("Preferences", 52, 446, 3, false);
                    if (this.ctheme.isShowing()) {
                        this.ctheme.hide();
                    }
                    if (this.fontsel.isShowing()) {
                        this.fontsel.hide();
                    }
                    if (this.cntprf != 0) {
                        this.cntprf = 0;
                    }
                    if (this.cntchk == 0) {
                        this.npolys = 0;
                        int n7 = 0;
                        int n8 = 0;
                        while (n7 != -1 && this.mouses != 1) {
                            if (n8 == 0) {
                                n7 = this.editor.getText().indexOf("<p>", n7);
                            }
                            else {
                                n7 = this.editor.getText().indexOf("</p>", n7);
                            }
                            if (n7 != -1) {
                                if (n8 == 0) {
                                    n8 = 1;
                                }
                                else {
                                    n8 = 0;
                                    ++this.npolys;
                                }
                                n7 += 3;
                            }
                        }
                        if (this.mouses == 1) {
                            this.npolys = 0;
                        }
                        this.cntchk = 30;
                    }
                    else {
                        --this.cntchk;
                    }
                    if (this.npolys > 210) {
                        this.rd.setColor(new Color(255, 0, 0));
                    }
                    if (this.npolys != 0) {
                        this.rd.drawString("Number of Polygons :  " + this.npolys + " / 210", 200, 446);
                    }
                }
                if (!this.changed && !this.editor.getText().equals(this.lastedo)) {
                    this.changed = true;
                }
                this.stringbutton("  Save  ", 490, 455, 0, this.changed);
                this.stringbutton("  Save & Preview  >  ", 600, 455, 0, this.changed);
                this.mirror = false;
                this.polynum = -1;
                this.cntpls = 0;
                String selectedText = "";
                try {
                    selectedText = this.editor.getSelectedText();
                }
                catch (Exception ex2) {}
                if (!selectedText.equals("")) {
                    int n9 = selectedText.indexOf("<p>", 0);
                    while (n9 != -1 && n9 + 1 < selectedText.length()) {
                        if (!this.mirror) {
                            n9 = selectedText.indexOf("</p>", n9 + 1);
                            if (n9 != -1) {
                                this.mirror = true;
                                ++this.cntpls;
                            }
                        }
                        if (this.mirror) {
                            n9 = selectedText.indexOf("<p>", n9 + 1);
                            if (n9 == -1) {
                                continue;
                            }
                            this.mirror = false;
                        }
                    }
                }
                if (!this.mirror) {
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(5, 474, 494, 70);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Text to find:", 18, 500);
                    this.movefield(this.srch, 91, 484, 129, 22);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                    }
                    boolean b = false;
                    if (!this.srch.getText().equals("")) {
                        b = true;
                    }
                    this.stringbutton(" Find ", 117, 526, 2, b);
                    this.rd.drawString("Replace with:", 255, 500);
                    this.movefield(this.rplc, 338, 484, 129, 22);
                    if (!this.rplc.isShowing()) {
                        this.rplc.show();
                    }
                    boolean b2 = false;
                    if (!this.srch.getText().equals("") && !this.rplc.getText().equals("")) {
                        b2 = true;
                    }
                    this.stringbutton(" Replace ", 376, 526, 2, b2);
                }
                else {
                    if (this.srch.isShowing()) {
                        this.srch.hide();
                    }
                    if (this.rplc.isShowing()) {
                        this.rplc.hide();
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(5, 474, 450, 70);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Mirror [Selected] polygon(s) along:", 18, 490);
                    this.stringbutton(" Mirro Along X Axis ", 90, 525, 2, true);
                    this.stringbutton(" Mirro Along Y Axis ", 230, 525, 2, false);
                    this.stringbutton(" Mirro Along Z Axis ", 370, 525, 2, false);
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(465, 474, 230, 70);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Show [Selected] polygon(s):", 478, 490);
                    this.stringbutton(" Show in 3D  > ", 580, 523, 0, true);
                }
                if (this.npolys > 210 && !this.tomany) {
                    this.repaint();
                    JOptionPane.showMessageDialog(null, "Maximum number of polygons (pieces) allowed has been exceeded!\nThe maximum allowed is 210 polygons, please decrease.\n", "Car Maker", 1);
                    this.tomany = true;
                }
            }
            if (this.tab == 2) {
                if (this.tabed != this.tab) {
                    this.setupo();
                    this.dtabed = -1;
                }
                this.m.d(this.rd);
                this.o.d(this.rd);
                if (this.dtab == 2) {
                    if (this.compsel > 0 && this.compsel <= 16) {
                        this.compo[this.compsel - 1].x = this.o.x;
                        this.compo[this.compsel - 1].y = this.o.y;
                        this.compo[this.compsel - 1].z = this.o.z;
                        this.compo[this.compsel - 1].xz = this.o.xz;
                        this.compo[this.compsel - 1].xy = this.o.xy;
                        this.compo[this.compsel - 1].zy = this.o.zy;
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4f));
                        this.compo[this.compsel - 1].d(this.rd);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                    }
                    if (this.xm > 420 && this.xm < 690 && this.ym > 425 && this.ym < 540) {
                        final int[] array = { 50 + this.adna[0], -50 - this.adna[1], 0, 0, 0, 0 };
                        final int[] array2 = { 0, 0, 50 + this.adna[2], -50 - this.adna[3], 0, 0 };
                        final int[] array3 = { 0, 0, 0, 0, 50 + this.adna[4], -50 - this.adna[5] };
                        for (int l = 0; l < 6; ++l) {
                            final int[] array4 = array;
                            final int n10 = l;
                            array4[n10] += this.o.x - this.m.x;
                            final int[] array5 = array2;
                            final int n11 = l;
                            array5[n11] += this.o.y - this.m.y;
                            final int[] array6 = array3;
                            final int n12 = l;
                            array6[n12] += this.o.z - this.m.z;
                        }
                        this.rot(array, array2, this.o.x - this.m.x, this.o.y - this.m.y, this.o.xy, 6);
                        this.rot(array2, array3, this.o.y - this.m.y, this.o.z - this.m.z, this.o.zy, 6);
                        this.rot(array, array3, this.o.x - this.m.x, this.o.z - this.m.z, this.o.xz, 6);
                        this.rot(array, array3, this.m.cx, this.m.cz, this.m.xz, 6);
                        this.rot(array2, array3, this.m.cy, this.m.cz, this.m.zy, 6);
                        final int[] array7 = new int[6];
                        final int[] array8 = new int[6];
                        for (int n13 = 0; n13 < 6; ++n13) {
                            array7[n13] = this.xs(array[n13], array3[n13]);
                            array8[n13] = this.ys(array2[n13], array3[n13]);
                        }
                        this.rd.setColor(new Color(0, 150, 0));
                        this.rd.drawString("X+", array7[0] - 7, array8[0] + 4);
                        this.rd.drawString("-X", array7[1] - 5, array8[1] + 4);
                        this.rd.drawLine(array7[0], array8[0], array7[1], array8[1]);
                        this.rd.setColor(new Color(150, 0, 0));
                        this.rd.drawString("Y+", array7[2] - 7, array8[2] + 4);
                        this.rd.drawString("-Y", array7[3] - 5, array8[3] + 4);
                        this.rd.drawLine(array7[2], array8[2], array7[3], array8[3]);
                        this.rd.setColor(new Color(0, 0, 150));
                        this.rd.drawString("Z+", array7[4] - 7, array8[4] + 4);
                        this.rd.drawString("-Z", array7[5] - 5, array8[5] + 4);
                        this.rd.drawLine(array7[4], array8[4], array7[5], array8[5]);
                        for (int n14 = 0; n14 < 6; ++n14) {
                            if (Math.abs(array8[n14] - 207) * 1.91f > Math.abs(array7[n14] - 350)) {
                                if (Math.abs(Math.abs(array8[n14] - 207) - 170) > 10) {
                                    if (Math.abs(array8[n14] - 207) < 170) {
                                        final int[] adna = this.adna;
                                        final int n15 = n14;
                                        adna[n15] += 10;
                                    }
                                    else {
                                        final int[] adna2 = this.adna;
                                        final int n16 = n14;
                                        adna2[n16] -= 10;
                                    }
                                }
                            }
                            else if (Math.abs(Math.abs(array7[n14] - 350) - 338) > 10) {
                                if (Math.abs(array7[n14] - 350) < 338) {
                                    final int[] adna3 = this.adna;
                                    final int n17 = n14;
                                    adna3[n17] += 10;
                                }
                                else {
                                    final int[] adna4 = this.adna;
                                    final int n18 = n14;
                                    adna4[n18] -= 10;
                                }
                            }
                            if (this.adna[n14] > 276) {
                                this.adna[n14] = 276;
                            }
                            if (this.adna[n14] < 0) {
                                this.adna[n14] = 0;
                            }
                        }
                    }
                }
                this.rd.setColor(new Color(205, 200, 200));
                this.rd.fillRect(0, 390, 700, 20);
                this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillRect(0, 410, 700, 140);
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                final String[] array9 = { "3D Controls", "Color Edit", "Scale & Align", "Wheels", "Stats & Class", "Physics", "Test Drive" };
                final int[] array10 = { 0, 0, 100, 90 };
                final int[] array11 = { 390, 410, 410, 390 };
                for (int dtab = 0; dtab < 7; ++dtab) {
                    this.rd.setColor(new Color(170, 170, 170));
                    if (this.xm > array10[0] && this.xm < array10[3] && this.ym > 390 && this.ym < 410) {
                        this.rd.setColor(new Color(190, 190, 190));
                    }
                    if (this.dtab == dtab) {
                        this.rd.setColor(new Color(225, 225, 225));
                    }
                    this.rd.fillPolygon(array10, array11, 4);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(array9[dtab], dtab * 100 + 47 - this.ftm.stringWidth(array9[dtab]) / 2, 404);
                    if (this.xm > array10[0] && this.xm < array10[3] && this.ym > 390 && this.ym < 410 && this.mouses == -1) {
                        this.dtab = dtab;
                    }
                    for (int n19 = 0; n19 < 4; ++n19) {
                        final int[] array12 = array10;
                        final int n20 = n19;
                        array12[n20] += 100;
                    }
                }
                if (this.dtabed != this.dtab) {
                    if (this.dtabed != -1) {
                        if (!this.editor.getText().equals(this.lastedo)) {
                            this.editor.setText(this.lastedo);
                        }
                        this.setupo();
                    }
                    this.setCursor(new Cursor(0));
                    this.hidefields();
                    this.requestFocus();
                }
                this.rd.setColor(new Color(0, 0, 0));
                if (this.dtab == 0) {
                    this.rd.drawString("Rotate Car around its X & Z Axis using:  [ Keyboard Arrows ] ", 20, 440);
                    this.rd.drawString("Rotate Car fully around the Y Axis using:    [ < ]  &  [ > ]    or    [ A ]  &  [ D ]    or    [ 4 ]  &  [ 6 ]    Keys", 20, 465);
                    this.rd.drawString("Move Car Up and Down using:    [ - ]  &  [ + ]    Keys", 20, 490);
                    this.rd.drawString("Move Car Forwards and Backwards using:    [ W ]  &  [ S ]    or    [ 8 ]  &  [ 2 ]    or    [ Enter ]  &  [ Backspace ]    Keys", 20, 515);
                }
                if (this.dtab == 1) {
                    if (this.o.colok != 2) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("[  First & Second Color not defined yet  ]", 350 - this.ftm.stringWidth("[  First & Second Color not defined yet  ]") / 2, 450);
                        this.stringbutton(" Define 1st and 2nd Color ", 350, 490, 0, true);
                    }
                    else {
                        if (this.dtabed != this.dtab) {
                            this.fcol = "(" + this.o.fcol[0] + "," + this.o.fcol[1] + "," + this.o.fcol[2] + ")";
                            this.srch.setText(this.fcol);
                            this.ofcol = this.fcol;
                            Color.RGBtoHSB(this.o.fcol[0], this.o.fcol[1], this.o.fcol[2], this.fhsb);
                            final float n21 = this.fhsb[1];
                            this.fhsb[1] = this.fhsb[2];
                            this.fhsb[2] = n21;
                            this.scol = "(" + this.o.scol[0] + "," + this.o.scol[1] + "," + this.o.scol[2] + ")";
                            this.rplc.setText(this.scol);
                            this.oscol = this.scol;
                            Color.RGBtoHSB(this.o.scol[0], this.o.scol[1], this.o.scol[2], this.shsb);
                            final float n22 = this.shsb[1];
                            this.shsb[1] = this.shsb[2];
                            this.shsb[2] = n22;
                            this.bfo = 51;
                            this.mouseon = -1;
                        }
                        if (this.mouses != 1) {
                            this.mouseon = -1;
                        }
                        this.rd.setColor(new Color(170, 170, 170));
                        this.rd.drawRect(20, 425, 320, 110);
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(141, 419, 77, 9);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("First Color", 151, 428);
                        this.rd.drawString("Hue:", 75, 450);
                        this.rd.drawString("Brightness:", 35, 470);
                        this.rd.drawString("Saturation:", 38, 490);
                        this.rd.drawString("RGB Value:", 38, 520);
                        this.movefield(this.srch, 106, 504, 129, 22);
                        if (this.srch.hasFocus()) {
                            this.focuson = false;
                        }
                        if (!this.srch.isShowing()) {
                            this.srch.show();
                        }
                        for (int n23 = 0; n23 < 200; ++n23) {
                            this.rd.setColor(Color.getHSBColor((float)(n23 * 0.005), 1.0f, 1.0f));
                            this.rd.drawLine(110 + n23, 442, 110 + n23, 449);
                        }
                        for (int n24 = 0; n24 < 200; ++n24) {
                            this.rd.setColor(Color.getHSBColor(0.0f, 0.0f, 0.2f + (float)(n24 * 0.004)));
                            this.rd.drawLine(110 + n24, 462, 110 + n24, 469);
                        }
                        for (int n25 = 0; n25 < 200; ++n25) {
                            this.rd.setColor(Color.getHSBColor(this.fhsb[0], (float)(n25 * 0.005), this.fhsb[1]));
                            this.rd.drawLine(110 + n25, 482, 110 + n25, 489);
                        }
                        for (int mouseon = 0; mouseon < 3; ++mouseon) {
                            this.rd.setColor(new Color(0, 0, 0));
                            float n26 = this.fhsb[mouseon] * 200.0f;
                            if (mouseon == 1) {
                                n26 = (this.fhsb[mouseon] - 0.2f) * 250.0f;
                            }
                            this.rd.drawLine((int)(110.0f + n26), 442 + mouseon * 20, (int)(110.0f + n26), 449 + mouseon * 20);
                            this.rd.drawLine((int)(111.0f + n26), 442 + mouseon * 20, (int)(111.0f + n26), 449 + mouseon * 20);
                            this.rd.fillRect((int)(109.0f + n26), 450 + mouseon * 20, 4, 2);
                            this.rd.drawLine((int)(108.0f + n26), 452 + mouseon * 20, (int)(113.0f + n26), 452 + mouseon * 20);
                            if (this.xm > 107 && this.xm < 313 && this.ym > 439 + mouseon * 20 && this.ym < 452 + mouseon * 20 && this.mouses == 1 && this.mouseon == -1) {
                                this.mouseon = mouseon;
                            }
                            if (this.mouseon == mouseon) {
                                if (mouseon == 1) {
                                    this.fhsb[mouseon] = 0.2f + (this.xm - 110) / 250.0f;
                                    if (this.fhsb[mouseon] < 0.2) {
                                        this.fhsb[mouseon] = 0.2f;
                                    }
                                }
                                else {
                                    this.fhsb[mouseon] = (this.xm - 110) / 200.0f;
                                }
                                if (this.fhsb[mouseon] > 1.0f) {
                                    this.fhsb[mouseon] = 1.0f;
                                }
                                if (this.fhsb[mouseon] < 0.0f) {
                                    this.fhsb[mouseon] = 0.0f;
                                }
                            }
                        }
                        this.stringbutton(" Save ", 300, 520, 0, !this.fcol.equals(this.ofcol));
                        this.rd.setColor(new Color(170, 170, 170));
                        this.rd.drawRect(360, 425, 320, 110);
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(472, 419, 95, 9);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Second Color", 482, 428);
                        this.rd.drawString("Hue:", 415, 450);
                        this.rd.drawString("Brightness:", 375, 470);
                        this.rd.drawString("Saturation:", 378, 490);
                        this.rd.drawString("RGB Value:", 378, 520);
                        this.movefield(this.rplc, 446, 504, 129, 22);
                        if (this.rplc.hasFocus()) {
                            this.focuson = false;
                        }
                        if (!this.rplc.isShowing()) {
                            this.rplc.show();
                        }
                        for (int n27 = 0; n27 < 200; ++n27) {
                            this.rd.setColor(Color.getHSBColor((float)(n27 * 0.005), 1.0f, 1.0f));
                            this.rd.drawLine(450 + n27, 442, 450 + n27, 449);
                        }
                        for (int n28 = 0; n28 < 200; ++n28) {
                            this.rd.setColor(Color.getHSBColor(0.0f, 0.0f, 0.2f + (float)(n28 * 0.004)));
                            this.rd.drawLine(450 + n28, 462, 450 + n28, 469);
                        }
                        for (int n29 = 0; n29 < 200; ++n29) {
                            this.rd.setColor(Color.getHSBColor(this.shsb[0], (float)(n29 * 0.005), this.shsb[2]));
                            this.rd.drawLine(450 + n29, 482, 450 + n29, 489);
                        }
                        for (int n30 = 0; n30 < 3; ++n30) {
                            this.rd.setColor(new Color(0, 0, 0));
                            float n31 = this.shsb[n30] * 200.0f;
                            if (n30 == 1) {
                                n31 = (this.shsb[n30] - 0.2f) * 250.0f;
                            }
                            this.rd.drawLine((int)(450.0f + n31), 442 + n30 * 20, (int)(450.0f + n31), 449 + n30 * 20);
                            this.rd.drawLine((int)(451.0f + n31), 442 + n30 * 20, (int)(451.0f + n31), 449 + n30 * 20);
                            this.rd.fillRect((int)(449.0f + n31), 450 + n30 * 20, 4, 2);
                            this.rd.drawLine((int)(448.0f + n31), 452 + n30 * 20, (int)(453.0f + n31), 452 + n30 * 20);
                            if (this.xm > 447 && this.xm < 653 && this.ym > 439 + n30 * 20 && this.ym < 452 + n30 * 20 && this.mouses == 1 && this.mouseon == -1) {
                                this.mouseon = n30 + 3;
                            }
                            if (this.mouseon == n30 + 3) {
                                if (n30 == 1) {
                                    this.shsb[n30] = 0.2f + (this.xm - 450) / 250.0f;
                                    if (this.shsb[n30] < 0.2) {
                                        this.shsb[n30] = 0.2f;
                                    }
                                }
                                else {
                                    this.shsb[n30] = (this.xm - 450) / 200.0f;
                                }
                                if (this.shsb[n30] > 1.0f) {
                                    this.shsb[n30] = 1.0f;
                                }
                                if (this.shsb[n30] < 0.0f) {
                                    this.shsb[n30] = 0.0f;
                                }
                            }
                        }
                        this.stringbutton(" Save ", 640, 520, 0, !this.scol.equals(this.oscol));
                        if (this.fhsb[1] < 0.2) {
                            this.fhsb[1] = 0.2f;
                        }
                        if (this.shsb[1] < 0.2) {
                            this.shsb[1] = 0.2f;
                        }
                        for (int n32 = 0; n32 < this.o.npl; ++n32) {
                            if (this.o.p[n32].colnum == 1) {
                                this.o.p[n32].hsb[0] = this.fhsb[0];
                                this.o.p[n32].hsb[1] = this.fhsb[2];
                                this.o.p[n32].hsb[2] = this.fhsb[1];
                            }
                            if (this.o.p[n32].colnum == 2) {
                                this.o.p[n32].hsb[0] = this.shsb[0];
                                this.o.p[n32].hsb[1] = this.shsb[2];
                                this.o.p[n32].hsb[2] = this.shsb[1];
                            }
                        }
                        final String string = "(" + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed() + "," + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen() + "," + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue() + ")";
                        if (!this.fcol.equals(string)) {
                            this.fcol = string;
                            this.srch.setText(this.fcol);
                        }
                        final String string2 = "(" + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed() + "," + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen() + "," + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue() + ")";
                        if (!this.scol.equals(string2)) {
                            this.scol = string2;
                            this.rplc.setText(this.scol);
                        }
                        if (this.srch.getText().equals(this.fcol) && this.rplc.getText().equals(this.scol)) {
                            if (this.bfo < 50) {
                                ++this.bfo;
                            }
                            else if (this.bfo == 50) {
                                this.requestFocus();
                                this.bfo = 51;
                            }
                        }
                        else {
                            this.bfo = 0;
                            if (!this.srch.getText().equals(this.fcol)) {
                                this.fcol = this.srch.getText();
                                final int[] array13 = new int[3];
                                boolean b3 = true;
                                try {
                                    final int index = this.fcol.indexOf(",", 0);
                                    final int index2 = this.fcol.indexOf(",", index + 1);
                                    array13[0] = Integer.valueOf(this.fcol.substring(1, index));
                                    if (array13[0] < 0) {
                                        array13[0] = 0;
                                    }
                                    if (array13[0] > 255) {
                                        array13[0] = 255;
                                    }
                                    array13[1] = Integer.valueOf(this.fcol.substring(index + 1, index2));
                                    if (array13[1] < 0) {
                                        array13[1] = 0;
                                    }
                                    if (array13[1] > 255) {
                                        array13[1] = 255;
                                    }
                                    array13[2] = Integer.valueOf(this.fcol.substring(index2 + 1, this.fcol.length() - 1));
                                    if (array13[2] < 0) {
                                        array13[2] = 0;
                                    }
                                    if (array13[2] > 255) {
                                        array13[2] = 255;
                                    }
                                }
                                catch (Exception ex3) {
                                    b3 = false;
                                }
                                if (b3) {
                                    Color.RGBtoHSB(array13[0], array13[1], array13[2], this.fhsb);
                                    final float n33 = this.fhsb[1];
                                    this.fhsb[1] = this.fhsb[2];
                                    this.fhsb[2] = n33;
                                }
                            }
                            if (!this.rplc.getText().equals(this.scol)) {
                                this.scol = this.rplc.getText();
                                final int[] array14 = new int[3];
                                boolean b4 = true;
                                try {
                                    final int index3 = this.scol.indexOf(",", 0);
                                    final int index4 = this.scol.indexOf(",", index3 + 1);
                                    array14[0] = Integer.valueOf(this.scol.substring(1, index3));
                                    if (array14[0] < 0) {
                                        array14[0] = 0;
                                    }
                                    if (array14[0] > 255) {
                                        array14[0] = 255;
                                    }
                                    array14[1] = Integer.valueOf(this.scol.substring(index3 + 1, index4));
                                    if (array14[1] < 0) {
                                        array14[1] = 0;
                                    }
                                    if (array14[1] > 255) {
                                        array14[1] = 255;
                                    }
                                    array14[2] = Integer.valueOf(this.scol.substring(index4 + 1, this.scol.length() - 1));
                                    if (array14[2] < 0) {
                                        array14[2] = 0;
                                    }
                                    if (array14[2] > 255) {
                                        array14[2] = 255;
                                    }
                                }
                                catch (Exception ex4) {
                                    b4 = false;
                                }
                                if (b4) {
                                    Color.RGBtoHSB(array14[0], array14[1], array14[2], this.shsb);
                                    final float n34 = this.shsb[1];
                                    this.shsb[1] = this.shsb[2];
                                    this.shsb[2] = n34;
                                }
                            }
                        }
                    }
                }
                if (this.dtab == 2) {
                    if (this.dtabed != this.dtab) {
                        this.lastedo = this.editor.getText();
                        this.scale[0] = 100;
                        int index5 = this.editor.getText().indexOf("\nScaleX(", 0);
                        if (index5 != -1) {
                            ++index5;
                            try {
                                this.scale[0] = Integer.valueOf(this.editor.getText().substring(index5 + 7, this.editor.getText().indexOf(")", index5)));
                            }
                            catch (Exception ex5) {
                                this.scale[0] = 100;
                            }
                        }
                        this.oscale[0] = this.scale[0];
                        this.scale[1] = 100;
                        int index6 = this.editor.getText().indexOf("\nScaleY(", 0);
                        if (index6 != -1) {
                            ++index6;
                            try {
                                this.scale[1] = Integer.valueOf(this.editor.getText().substring(index6 + 7, this.editor.getText().indexOf(")", index6)));
                            }
                            catch (Exception ex6) {
                                this.scale[1] = 100;
                            }
                        }
                        this.oscale[1] = this.scale[1];
                        this.scale[2] = 100;
                        int index7 = this.editor.getText().indexOf("\nScaleZ(", 0);
                        if (index7 != -1) {
                            ++index7;
                            try {
                                this.scale[2] = Integer.valueOf(this.editor.getText().substring(index7 + 7, this.editor.getText().indexOf(")", index7)));
                            }
                            catch (Exception ex7) {
                                this.scale[2] = 100;
                            }
                        }
                        this.oscale[2] = this.scale[2];
                        this.bfo = 0;
                        this.compsel = 0;
                        this.compcar.select(this.compsel);
                        this.changed2 = false;
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(9, 425, 270, 115);
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(119, 419, 51, 9);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Scale", 129, 428);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Scale X", 25, 450);
                    this.stringbutton(" - ", 92, 450, 4, false);
                    this.rd.drawString("" + this.scale[0] / 100.0f + "", 126 - this.ftm.stringWidth("" + this.scale[0] / 100.0f + "") / 2, 450);
                    this.stringbutton(" + ", 160, 450, 4, false);
                    this.rd.drawString("Scale Y", 25, 474);
                    this.stringbutton(" - ", 92, 474, 4, false);
                    this.rd.drawString("" + this.scale[1] / 100.0f + "", 126 - this.ftm.stringWidth("" + this.scale[1] / 100.0f + "") / 2, 474);
                    this.stringbutton(" + ", 160, 474, 4, false);
                    this.rd.drawString("Scale Z", 25, 498);
                    this.stringbutton(" - ", 92, 498, 4, false);
                    this.rd.drawString("" + this.scale[2] / 100.0f + "", 126 - this.ftm.stringWidth("" + this.scale[2] / 100.0f + "") / 2, 498);
                    this.stringbutton(" + ", 160, 498, 4, false);
                    this.rd.drawString("Scale ALL", 25, 527);
                    this.stringbutton(" - ", 106, 527, 2, true);
                    this.stringbutton(" + ", 146, 527, 2, true);
                    this.stringbutton("   Save   ", 230, 454, 0, this.oscale[0] != this.scale[0] || this.oscale[1] != this.scale[1] || this.oscale[2] != this.scale[2]);
                    this.stringbutton(" Reset ", 230, 493, 0, false);
                    this.rd.drawString("Compare scale and", 296, 440);
                    this.rd.drawString("alignment with:", 308, 455);
                    this.compcar.move(288, 462);
                    if (this.compcar.hasFocus()) {
                        this.focuson = false;
                        ++this.bfo;
                        if (this.bfo == 100) {
                            this.requestFocus();
                        }
                    }
                    else {
                        this.bfo = 0;
                    }
                    if (!this.compcar.isShowing()) {
                        this.compcar.show();
                    }
                    if (this.compsel != this.compcar.getSelectedIndex()) {
                        this.compsel = this.compcar.getSelectedIndex();
                        this.requestFocus();
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(420, 425, 270, 115);
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(531, 419, 47, 9);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Align", 541, 428);
                    this.rd.drawString("Align in X", 433, 450);
                    this.stringbutton(" Rotate 90° ", 535, 450, 4, false);
                    this.stringbutton("+10", 607, 450, 4, false);
                    this.stringbutton("-10", 656, 450, 4, false);
                    this.rd.drawString("Align in Y", 433, 474);
                    this.stringbutton(" Rotate 90° ", 535, 474, 4, false);
                    this.stringbutton("+10", 607, 474, 4, false);
                    this.stringbutton("-10", 656, 474, 4, false);
                    this.rd.drawString("Align in Z", 433, 498);
                    this.stringbutton(" Rotate 90° ", 535, 498, 4, false);
                    this.stringbutton("+10", 607, 498, 4, false);
                    this.stringbutton("-10", 656, 498, 4, false);
                    this.stringbutton(" Reset ", 490, 527, 0, false);
                    this.stringbutton("      Save      ", 607, 527, 0, this.changed2);
                }
                if (this.dtab == 3) {
                    if (this.dtabed != this.dtab) {
                        int abs = 45;
                        int abs2 = 45;
                        int getvalue = 15;
                        int getvalue2 = 15;
                        int n35 = 76;
                        int n36 = -76;
                        int abs3 = 26;
                        int abs4 = 26;
                        int abs5 = 20;
                        int abs6 = 20;
                        int n37 = 18;
                        int n38 = 18;
                        int n39 = 10;
                        int n40 = 10;
                        int n41 = 0;
                        int n42 = 0;
                        String text = "(140,140,140)";
                        String text2 = "(140,140,140)";
                        int n43 = 0;
                        final String string3 = "" + this.editor.getText() + "\n";
                        int n44 = 0;
                        int n45 = string3.indexOf("\n", 0);
                        int getvalue3 = 0;
                        int getvalue4 = 15;
                        int getvalue5 = 20;
                        String string4 = "(140,140,140)";
                        while (n45 != -1 && n44 < string3.length()) {
                            final String trim = string3.substring(n44, n45).trim();
                            n44 = n45 + 1;
                            n45 = string3.indexOf("\n", n44);
                            try {
                                if (trim.startsWith("rims(")) {
                                    string4 = "(" + this.getvalue("rims", trim, 0) + "," + this.getvalue("rims", trim, 1) + "," + this.getvalue("rims", trim, 2) + ")";
                                    getvalue4 = this.getvalue("rims", trim, 3);
                                    getvalue5 = this.getvalue("rims", trim, 4);
                                }
                                if (trim.startsWith("gwgr(")) {
                                    getvalue3 = this.getvalue("gwgr", trim, 0);
                                }
                                if (!trim.startsWith("w(")) {
                                    continue;
                                }
                                final int getvalue6 = this.getvalue("w", trim, 2);
                                if (getvalue6 > 0) {
                                    abs = Math.abs(this.getvalue("w", trim, 0));
                                    getvalue = this.getvalue("w", trim, 1);
                                    n35 = getvalue6;
                                    abs3 = Math.abs(this.getvalue("w", trim, 4));
                                    abs5 = Math.abs(this.getvalue("w", trim, 5));
                                    text = string4;
                                    n37 = getvalue4;
                                    n39 = getvalue5;
                                    n41 = getvalue3;
                                }
                                else {
                                    abs2 = Math.abs(this.getvalue("w", trim, 0));
                                    getvalue2 = this.getvalue("w", trim, 1);
                                    n36 = getvalue6;
                                    abs4 = Math.abs(this.getvalue("w", trim, 4));
                                    abs6 = Math.abs(this.getvalue("w", trim, 5));
                                    text2 = string4;
                                    n38 = getvalue4;
                                    n40 = getvalue5;
                                    n42 = getvalue3;
                                }
                                ++n43;
                            }
                            catch (Exception ex8) {}
                        }
                        if (n43 != 4) {
                            this.defnow = true;
                        }
                        else {
                            this.defnow = false;
                        }
                        this.wv[0].setText("" + abs2 + "");
                        this.wv[1].setText("" + getvalue2 + "");
                        this.wv[2].setText("" + n36 + "");
                        this.wv[3].setText("" + abs6 + "");
                        this.wv[4].setText("" + abs4 + "");
                        this.srch.setText(text2);
                        this.wv[5].setText("" + n38 + "");
                        this.wv[6].setText("" + n40 + "");
                        this.wv[7].setText("" + n42 + "");
                        this.wv[8].setText("" + abs + "");
                        this.wv[9].setText("" + getvalue + "");
                        this.wv[10].setText("" + n35 + "");
                        this.wv[11].setText("" + abs5 + "");
                        this.wv[12].setText("" + abs3 + "");
                        this.rplc.setText(text);
                        this.wv[13].setText("" + n37 + "");
                        this.wv[14].setText("" + n39 + "");
                        this.wv[15].setText("" + n41 + "");
                        this.aply1 = "" + this.wv[0].getText() + "" + this.wv[1].getText() + "" + this.wv[2].getText() + "" + this.wv[3].getText() + "" + this.wv[4].getText() + "" + this.srch.getText() + "" + this.wv[5].getText() + "" + this.wv[6].getText() + "" + this.wv[7].getText() + "";
                        this.aply2 = "" + this.wv[8].getText() + "" + this.wv[9].getText() + "" + this.wv[10].getText() + "" + this.wv[11].getText() + "" + this.wv[12].getText() + "" + this.rplc.getText() + "" + this.wv[13].getText() + "" + this.wv[14].getText() + "" + this.wv[15].getText() + "";
                        this.aplyd1 = false;
                        this.aplyd2 = false;
                        this.changed2 = false;
                        this.mouseon = -1;
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("BACK Wheels :", 12, 424);
                    this.rd.drawString("±X :", 12, 449);
                    this.movefield(this.wv[0], 35, 433, 40, 22);
                    this.rd.drawString("Y :", 86, 449);
                    this.movefield(this.wv[1], 101, 433, 40, 22);
                    this.rd.drawString("Z :", 151, 449);
                    this.movefield(this.wv[2], 166, 433, 40, 22);
                    this.rd.drawString("Height :", 12, 479);
                    this.movefield(this.wv[3], 56, 463, 40, 22);
                    this.rd.drawString("Width :", 107, 479);
                    this.movefield(this.wv[4], 148, 463, 40, 22);
                    this.rd.drawString("Rims RGB Color :", 12, 509);
                    this.movefield(this.srch, 109, 493, 129, 22);
                    this.rd.drawString("Rims Size :", 12, 539);
                    this.movefield(this.wv[5], 76, 523, 40, 22);
                    this.rd.drawString("Rims Depth :", 126, 539);
                    this.movefield(this.wv[6], 199, 523, 40, 22);
                    if (this.xm > 245 && this.xm < 336 && this.ym > 524 && this.ym < 541) {
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawLine(248, 540, 279, 540);
                        this.rd.drawLine(327, 540, 334, 540);
                        if (this.mouseon == -1) {
                            this.mouseon = 1;
                            this.setCursor(new Cursor(12));
                        }
                    }
                    else if (this.mouseon == 1) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                    this.rd.drawString("Hide :                ?", 249, 539);
                    this.movefield(this.wv[7], 282, 523, 40, 22);
                    this.stringbutton("   Apply   ", 300, 440, 0, this.aplyd1);
                    this.stringbutton("   Save   ", 300, 477, 0, this.changed2);
                    this.rd.drawString("FRONT Wheels :", 362, 424);
                    this.rd.drawString("±X :", 362, 449);
                    this.movefield(this.wv[8], 385, 433, 40, 22);
                    this.rd.drawString("Y :", 436, 449);
                    this.movefield(this.wv[9], 451, 433, 40, 22);
                    this.rd.drawString("Z :", 501, 449);
                    this.movefield(this.wv[10], 516, 433, 40, 22);
                    this.rd.drawString("Height :", 362, 479);
                    this.movefield(this.wv[11], 406, 463, 40, 22);
                    this.rd.drawString("Width :", 457, 479);
                    this.movefield(this.wv[12], 498, 463, 40, 22);
                    this.rd.drawString("Rims RGB Color :", 362, 509);
                    this.movefield(this.rplc, 459, 493, 129, 22);
                    this.rd.drawString("Rims Size :", 362, 539);
                    this.movefield(this.wv[13], 426, 523, 40, 22);
                    this.rd.drawString("Rims Depth :", 476, 539);
                    this.movefield(this.wv[14], 549, 523, 40, 22);
                    if (this.xm > 595 && this.xm < 686 && this.ym > 524 && this.ym < 541) {
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawLine(598, 540, 629, 540);
                        this.rd.drawLine(677, 540, 684, 540);
                        if (this.mouseon == -1) {
                            this.mouseon = 2;
                            this.setCursor(new Cursor(12));
                        }
                    }
                    else if (this.mouseon == 2) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                    this.rd.drawString("Hide :                ?", 599, 539);
                    this.movefield(this.wv[15], 632, 523, 40, 22);
                    this.stringbutton("   Apply   ", 650, 440, 0, this.aplyd2);
                    this.stringbutton("   Save   ", 650, 477, 0, this.changed2);
                    if (this.mouses == -1 && (this.mouseon == 1 || this.mouseon == 2)) {
                        JOptionPane.showMessageDialog(null, "Use this variable to hide the car wheels inside the car if you need to (if they are getting drawn over the car when they\nshould be drawn behind it).\n\nIf you have created a car model with specific places for the wheels go inside them (inside the car), if when you place the\nwheels there they don\u2019t get drawn inside the car (they get drawn over it instead), use this variable to adjust that.\n\nYou can also use this variable to do the opposite, to make the wheels get drawn over the car if they are getting drawn\nbehind it when they shouldn\u2019t.\n\nThe Hide variable takes values from -40 to 40:\nA +ve value from 1 to 40 makes the wheels more hidden, where 40 is the maximum the car wheel can be hidden.\nA -ve value from -1 to -40 does exactly the opposite and makes the wheels more apparent (this if the car wheels appear\ninside the car when they should be outside).\nA 0 value means do nothing.\nMost of the time you will need to use this variable, it will be to enter +ve values from 1-40 for hiding the car wheels.\n\n", "Car Maker", 1);
                    }
                    for (int n46 = 0; n46 < 16; ++n46) {
                        if (this.wv[n46].hasFocus()) {
                            this.focuson = false;
                        }
                        if (!this.wv[n46].isShowing()) {
                            this.wv[n46].show();
                        }
                    }
                    if (this.srch.hasFocus()) {
                        this.focuson = false;
                    }
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                    }
                    if (this.rplc.hasFocus()) {
                        this.focuson = false;
                    }
                    if (!this.rplc.isShowing()) {
                        this.rplc.show();
                    }
                    if (!this.focuson) {
                        if (!this.aplyd1 && !this.aply1.equals("" + this.wv[0].getText() + "" + this.wv[1].getText() + "" + this.wv[2].getText() + "" + this.wv[3].getText() + "" + this.wv[4].getText() + "" + this.srch.getText() + "" + this.wv[5].getText() + "" + this.wv[6].getText() + "" + this.wv[7].getText() + "")) {
                            this.aplyd1 = true;
                        }
                        if (!this.aplyd2 && !this.aply2.equals("" + this.wv[8].getText() + "" + this.wv[9].getText() + "" + this.wv[10].getText() + "" + this.wv[11].getText() + "" + this.wv[12].getText() + "" + this.rplc.getText() + "" + this.wv[13].getText() + "" + this.wv[14].getText() + "" + this.wv[15].getText() + "")) {
                            this.aplyd2 = true;
                        }
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawLine(350, 410, 350, 550);
                    this.rd.drawLine(300, 409, 400, 409);
                }
                if (this.dtab == 4) {
                    if (this.dtabed != this.dtab) {
                        this.changed2 = false;
                        this.statdef = false;
                        final String string5 = "" + this.editor.getText() + "\n";
                        int n47 = 0;
                        int n48 = string5.indexOf("\n", 0);
                        while (n48 != -1 && n47 < string5.length()) {
                            final String trim2 = string5.substring(n47, n48).trim();
                            n47 = n48 + 1;
                            n48 = string5.indexOf("\n", n47);
                            try {
                                if (!trim2.startsWith("stat(")) {
                                    continue;
                                }
                                int n49 = 0;
                                for (int n50 = 0; n50 < 5; ++n50) {
                                    this.stat[n50] = this.getvalue("stat", trim2, n50);
                                    if (this.stat[n50] > 200) {
                                        this.stat[n50] = 200;
                                    }
                                    if (this.stat[n50] < 16) {
                                        this.stat[n50] = 16;
                                    }
                                    n49 += this.stat[n50];
                                }
                                int n51 = 0;
                                if (n49 > 680) {
                                    n51 = 680 - n49;
                                    this.changed2 = true;
                                }
                                if (n49 > 640 && n49 < 680) {
                                    n51 = 640 - n49;
                                    this.changed2 = true;
                                }
                                if (n49 > 600 && n49 < 640) {
                                    n51 = 600 - n49;
                                    this.changed2 = true;
                                }
                                if (n49 > 560 && n49 < 600) {
                                    n51 = 560 - n49;
                                    this.changed2 = true;
                                }
                                if (n49 > 520 && n49 < 560) {
                                    n51 = 520 - n49;
                                    this.changed2 = true;
                                }
                                if (n49 < 520) {
                                    n51 = 520 - n49;
                                    this.changed2 = true;
                                }
                                while (n51 != 0) {
                                    for (int n52 = 0; n52 < 5; ++n52) {
                                        if (n51 > 0 && this.stat[n52] < 200) {
                                            final int[] stat = this.stat;
                                            final int n53 = n52;
                                            ++stat[n53];
                                            --n51;
                                        }
                                        if (n51 < 0 && this.stat[n52] > 16) {
                                            final int[] stat2 = this.stat;
                                            final int n54 = n52;
                                            --stat2[n54];
                                            ++n51;
                                        }
                                    }
                                }
                                for (int n55 = 0; n55 < 5; ++n55) {
                                    this.rstat[n55] = this.stat[n55];
                                }
                                this.statdef = true;
                            }
                            catch (Exception ex9) {
                                this.statdef = false;
                            }
                        }
                        if (this.statdef) {
                            if (this.simcar.getItemCount() == 16) {
                                this.simcar.add(this.rd, "   ");
                            }
                        }
                        else if (this.simcar.getItemCount() == 17) {
                            this.simcar.remove("   ");
                        }
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    if (!this.statdef) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("To start, please select the most similar NFM car to this car", 350 - this.ftm.stringWidth("To start, please select the most similar NFM car to this car") / 2, 450);
                        this.simcar.move(288, 460);
                        if (!this.simcar.isShowing()) {
                            this.simcar.show();
                        }
                        this.stringbutton("   OK   ", 350, 515, 0, true);
                    }
                    else {
                        this.rd.drawString("Car Class", 54, 435);
                        this.cls.move(34, 440);
                        if (!this.cls.isShowing()) {
                            this.cls.show();
                        }
                        boolean b5 = false;
                        int n56 = 0;
                        for (int n57 = 0; n57 < 5; ++n57) {
                            n56 += this.stat[n57];
                            if (this.stat[n57] != this.rstat[n57]) {
                                b5 = true;
                            }
                        }
                        if (this.clsel != this.cls.getSelectedIndex()) {
                            this.clsel = this.cls.getSelectedIndex();
                            int n58 = (4 - this.clsel) * 40 + 520 - n56;
                            while (n58 != 0) {
                                for (int n59 = 0; n59 < 5; ++n59) {
                                    if (n58 > 0 && this.stat[n59] < 200) {
                                        final int[] stat3 = this.stat;
                                        final int n60 = n59;
                                        ++stat3[n60];
                                        --n58;
                                    }
                                    if (n58 < 0 && this.stat[n59] > 16) {
                                        final int[] stat4 = this.stat;
                                        final int n61 = n59;
                                        --stat4[n61];
                                        ++n58;
                                    }
                                }
                            }
                        }
                        if (4 - (n56 - 520) / 40 != this.cls.getSelectedIndex()) {
                            this.clsel = 4 - (n56 - 520) / 40;
                            this.cls.select(this.clsel);
                        }
                        this.rd.drawString("Most Similar Car", 36, 490);
                        this.simcar.move(20, 495);
                        if (!this.simcar.isShowing()) {
                            this.simcar.show();
                        }
                        if (this.carsel != this.simcar.getSelectedIndex()) {
                            this.carsel = this.simcar.getSelectedIndex();
                            if (this.carsel != 16) {
                                for (int n62 = 0; n62 < 5; ++n62) {
                                    this.stat[n62] = this.carstat[this.carsel][n62];
                                }
                            }
                            this.requestFocus();
                        }
                        int n63 = 60;
                        int carsel = 16;
                        for (int n64 = 0; n64 < 16; ++n64) {
                            int n65 = 0;
                            for (int n66 = 0; n66 < 5; ++n66) {
                                n65 += Math.abs(this.carstat[n64][n66] - this.stat[n66]);
                            }
                            if (n65 < n63) {
                                carsel = n64;
                                n63 = n65;
                            }
                        }
                        if (carsel != this.carsel) {
                            this.carsel = carsel;
                            if (this.carsel < this.simcar.getItemCount()) {
                                this.simcar.select(this.carsel);
                            }
                        }
                        this.rd.drawString("Speed :", 196, 435);
                        this.rd.drawString("Acceleration :", 160, 459);
                        this.rd.drawString("Stunts :", 195, 483);
                        this.rd.drawString("Strength :", 183, 507);
                        this.rd.drawString("Endurance :", 171, 531);
                        for (int n67 = 0; n67 < 5; ++n67) {
                            for (int n68 = 0; n68 < this.stat[n67]; ++n68) {
                                this.rd.setColor(Color.getHSBColor((float)(n68 * 7.0E-4), 1.0f, 1.0f));
                                this.rd.drawLine(250 + n68, 426 + n67 * 24, 250 + n68, 434 + n67 * 24);
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawLine(249, 426 + n67 * 24, 249, 434 + n67 * 24);
                            this.rd.drawLine(450, 426 + n67 * 24, 450, 434 + n67 * 24);
                            this.rd.drawLine(249, 435 + n67 * 24, 450, 435 + n67 * 24);
                            for (int n69 = 0; n69 < 7; ++n69) {
                                this.rd.drawLine(275 + n69 * 25, 434 + n67 * 24, 275 + n69 * 25, 430 + n67 * 24);
                            }
                            this.stringbutton(" - ", 480, 435 + n67 * 24, 4, false);
                            this.stringbutton(" + ", 520, 435 + n67 * 24, 4, false);
                        }
                        if (this.carsel < 16 && n63 != 0) {
                            this.stringbutton(" Reselect ", 80, 534, 4, true);
                        }
                        else {
                            this.stringbutton(" Reselect ", 80, -1000, 4, true);
                        }
                        this.stringbutton("      Save      ", 620, 459, 0, b5 || this.changed2);
                        this.stringbutton("   Reset   ", 620, 507, 0, false);
                    }
                }
                if (this.dtab == 5) {
                    if (this.dtabed != this.dtab) {
                        this.mouseon = -1;
                        this.pfase = 0;
                        if (this.o.keyz[0] <= 0 || this.o.keyx[0] >= 0) {
                            this.pfase = -1;
                        }
                        if (this.o.keyz[1] <= 0 || this.o.keyx[1] <= 0) {
                            this.pfase = -1;
                        }
                        if (this.o.keyz[2] >= 0 || this.o.keyx[2] >= 0) {
                            this.pfase = -1;
                        }
                        if (this.o.keyz[3] >= 0 || this.o.keyx[3] <= 0) {
                            this.pfase = -1;
                        }
                        this.crashok = false;
                        if (Math.random() > Math.random()) {
                            this.crashleft = false;
                        }
                        else {
                            this.crashleft = true;
                        }
                        this.engsel = 0;
                        if (this.pfase == 0) {
                            final String string6 = "" + this.editor.getText() + "\n";
                            int n70 = 0;
                            int n71 = string6.indexOf("\n", 0);
                            while (n71 != -1 && n70 < string6.length()) {
                                final String trim3 = string6.substring(n70, n71).trim();
                                n70 = n71 + 1;
                                n71 = string6.indexOf("\n", n70);
                                try {
                                    if (!trim3.startsWith("physics(")) {
                                        continue;
                                    }
                                    for (int n72 = 0; n72 < 11; ++n72) {
                                        this.phys[n72] = this.getvalue("physics", trim3, n72);
                                        if (this.phys[n72] > 100) {
                                            this.phys[n72] = 100;
                                        }
                                        if (this.phys[n72] < 0) {
                                            this.phys[n72] = 0;
                                        }
                                    }
                                    for (int n73 = 0; n73 < 11; ++n73) {
                                        this.rphys[n73] = this.phys[n73];
                                    }
                                    for (int n74 = 0; n74 < 3; ++n74) {
                                        this.crash[n74] = this.getvalue("physics", trim3, n74 + 11);
                                        if (this.crash[n74] > 100) {
                                            this.crash[n74] = 100;
                                        }
                                        if (this.crash[n74] < 0) {
                                            this.crash[n74] = 0;
                                        }
                                    }
                                    for (int n75 = 0; n75 < 3; ++n75) {
                                        this.rcrash[n75] = this.crash[n75];
                                    }
                                    this.engsel = this.getvalue("physics", trim3, 14);
                                    if (this.engsel > 4) {
                                        this.engsel = 0;
                                    }
                                    if (this.engsel < 0) {
                                        this.engsel = 0;
                                    }
                                    this.crashok = true;
                                }
                                catch (Exception ex10) {
                                    this.crashok = false;
                                }
                            }
                        }
                        this.engon = false;
                    }
                    int mouseon2 = -1;
                    if (this.pfase == 0) {
                        for (int n76 = 0; n76 < 4; ++n76) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.xm > this.pnx[n76] && this.xm < 230 && this.ym > 433 + n76 * 24 && this.ym < 453 + n76 * 24) {
                                mouseon2 = n76;
                                this.rd.setColor(new Color(176, 64, 0));
                                this.rd.drawLine(this.pnx[n76], 448 + n76 * 24, 128, 448 + n76 * 24);
                            }
                            this.rd.drawString("" + this.pname[n76] + " :", this.pnx[n76], 447 + n76 * 24);
                            this.rd.drawLine(140, 443 + n76 * 24, 230, 443 + n76 * 24);
                            for (int n77 = 1; n77 < 10; ++n77) {
                                this.rd.drawLine(140 + 10 * n77, 443 - n77 + n76 * 24, 140 + 10 * n77, 443 + n77 + n76 * 24);
                            }
                            this.rd.setColor(new Color(255, 0, 0));
                            final int n78 = (int)(this.phys[n76] / 1.1111f / 10.0f);
                            this.rd.fillRect(138 + (int)(this.phys[n76] / 1.1111f), 443 - n78 + n76 * 24, 5, n78 * 2 + 1);
                            this.rd.setColor(new Color(255, 128, 0));
                            this.rd.drawRect(139 + (int)(this.phys[n76] / 1.1111f), 434 + n76 * 24, 2, 18);
                            this.stringbutton(" - ", 260, 447 + n76 * 24, 4, false);
                            this.stringbutton(" + ", 300, 447 + n76 * 24, 4, false);
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("<  Click on any variable name to learn about its function & use!", 333, 447);
                        this.stringbutton(" Random ", 380, 496, 0, false);
                        this.stringbutton(" Reset ", 455, 496, 0, false);
                        this.stringbutton("       Next  >       ", 570, 496, 0, true);
                    }
                    if (this.pfase == 1) {
                        for (int n79 = 0; n79 < 4; ++n79) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.xm > this.pnx[n79 + 5] && this.xm < 211 && this.ym > 433 + n79 * 24 && this.ym < 453 + n79 * 24) {
                                mouseon2 = n79 + 5;
                                this.rd.setColor(new Color(176, 64, 0));
                                this.rd.drawLine(this.pnx[n79 + 5], 448 + n79 * 24, 109, 448 + n79 * 24);
                            }
                            this.rd.drawString("" + this.pname[n79 + 5] + " :", this.pnx[n79 + 5], 447 + n79 * 24);
                            this.rd.drawLine(121, 443 + n79 * 24, 211, 443 + n79 * 24);
                            for (int n80 = 1; n80 < 10; ++n80) {
                                this.rd.drawLine(121 + 10 * n80, 443 - n80 + n79 * 24, 121 + 10 * n80, 443 + n80 + n79 * 24);
                            }
                            this.rd.setColor(new Color(255, 0, 0));
                            final int n81 = (int)(this.phys[n79 + 5] / 1.1111f / 10.0f);
                            this.rd.fillRect(119 + (int)(this.phys[n79 + 5] / 1.1111f), 443 - n81 + n79 * 24, 5, n81 * 2 + 1);
                            this.rd.setColor(new Color(255, 128, 0));
                            this.rd.drawRect(120 + (int)(this.phys[n79 + 5] / 1.1111f), 434 + n79 * 24, 2, 18);
                            this.stringbutton(" - ", 241, 447 + n79 * 24, 4, false);
                            this.stringbutton(" + ", 281, 447 + n79 * 24, 4, false);
                        }
                        for (int n82 = 0; n82 < 2; ++n82) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.xm > this.pnx[n82 + 9] && this.xm < 548 && this.ym > 433 + n82 * 24 && this.ym < 453 + n82 * 24) {
                                mouseon2 = n82 + 9;
                                this.rd.setColor(new Color(176, 64, 0));
                                this.rd.drawLine(this.pnx[n82 + 9], 448 + n82 * 24, 446, 448 + n82 * 24);
                            }
                            this.rd.drawString("" + this.pname[n82 + 9] + " :", this.pnx[n82 + 9], 447 + n82 * 24);
                            this.rd.drawLine(458, 443 + n82 * 24, 548, 443 + n82 * 24);
                            for (int n83 = 1; n83 < 10; ++n83) {
                                this.rd.drawLine(458 + 10 * n83, 443 - n83 + n82 * 24, 458 + 10 * n83, 443 + n83 + n82 * 24);
                            }
                            this.rd.setColor(new Color(255, 0, 0));
                            final int n84 = (int)(this.phys[n82 + 9] / 1.1111f / 10.0f);
                            this.rd.fillRect(456 + (int)(this.phys[n82 + 9] / 1.1111f), 443 - n84 + n82 * 24, 5, n84 * 2 + 1);
                            this.rd.setColor(new Color(255, 128, 0));
                            this.rd.drawRect(457 + (int)(this.phys[n82 + 9] / 1.1111f), 434 + n82 * 24, 2, 18);
                            this.stringbutton(" - ", 578, 447 + n82 * 24, 4, false);
                            this.stringbutton(" + ", 618, 447 + n82 * 24, 4, false);
                        }
                        this.stringbutton(" Random ", 361, 519, 0, false);
                        this.stringbutton(" Reset ", 436, 519, 0, false);
                        this.stringbutton(" <  Back ", 509, 519, 0, false);
                        this.stringbutton("       Next  >       ", 603, 519, 0, true);
                    }
                    if (this.pfase == 2) {
                        if (this.xm > 40 && this.xm < 670 && this.ym > 416 && this.ym < 436) {
                            mouseon2 = 11;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(596, 431, 669, 431);
                        }
                        this.rd.drawString("[   Crash Test,  Damage :                                       ]                                                     What is this?", 180, 430);
                        if (this.hitmag < 0) {
                            this.hitmag = 0;
                        }
                        if (this.hitmag > 17000) {
                            this.crashok = true;
                            this.hitmag = 17000;
                            for (int n85 = 0; n85 < this.o.npl; ++n85) {
                                if ((this.o.p[n85].wz == 0 || this.o.p[n85].gr == -17 || this.o.p[n85].gr == -16) && this.o.p[n85].embos == 0) {
                                    this.o.p[n85].embos = 1;
                                }
                            }
                        }
                        this.rd.setColor(new Color(255, (int)(250.0f - this.hitmag / 68.0f), 0));
                        this.rd.fillRect(322, 423, (int)(this.hitmag / 170.0f), 7);
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawRect(322, 423, 100, 7);
                        if (mouseon2 != 11) {
                            this.rd.setColor(new Color(170, 170, 170));
                        }
                        else {
                            this.rd.setColor(new Color(176, 64, 0));
                        }
                        this.rd.drawString("Normal Crash", 39, 438);
                        this.rd.drawString("Roof Crash", 501, 438);
                        this.rd.drawLine(125, 426, 179, 426);
                        this.rd.drawLine(125, 426, 125, 440);
                        this.rd.drawLine(491, 426, 437, 426);
                        this.rd.drawLine(491, 426, 491, 440);
                        this.rd.drawRect(19, 440, 276, 91);
                        this.rd.drawRect(339, 440, 312, 67);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.xm > 50 && this.xm < 195 && this.ym > 446 && this.ym < 466) {
                            mouseon2 = 12;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(50, 461, 94, 461);
                        }
                        this.rd.drawString("Radius :", 50, 460);
                        this.rd.drawLine(105, 456, 195, 456);
                        for (int n86 = 1; n86 < 10; ++n86) {
                            this.rd.drawLine(105 + 10 * n86, 456 - n86, 105 + 10 * n86, 456 + n86);
                        }
                        this.rd.setColor(new Color(255, 0, 0));
                        final int n87 = (int)(this.crash[0] / 1.1111f / 10.0f);
                        this.rd.fillRect(103 + (int)(this.crash[0] / 1.1111f), 456 - n87, 5, n87 * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(104 + (int)(this.crash[0] / 1.1111f), 447, 2, 18);
                        this.stringbutton(" - ", 225, 460, 4, false);
                        this.stringbutton(" + ", 265, 460, 4, false);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.xm > 30 && this.xm < 195 && this.ym > 470 && this.ym < 490) {
                            mouseon2 = 13;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(30, 485, 94, 485);
                        }
                        this.rd.drawString("Magnitude :", 30, 484);
                        this.rd.drawLine(105, 480, 195, 480);
                        for (int n88 = 1; n88 < 10; ++n88) {
                            this.rd.drawLine(105 + 10 * n88, 480 - n88, 105 + 10 * n88, 480 + n88);
                        }
                        this.rd.setColor(new Color(255, 0, 0));
                        final int n89 = (int)(this.crash[1] / 1.1111f / 10.0f);
                        this.rd.fillRect(103 + (int)(this.crash[1] / 1.1111f), 480 - n89, 5, n89 * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(104 + (int)(this.crash[1] / 1.1111f), 471, 2, 18);
                        this.stringbutton(" - ", 225, 484, 4, false);
                        this.stringbutton(" + ", 265, 484, 4, false);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.xm > 350 && this.xm < 551 && this.ym > 446 && this.ym < 466) {
                            mouseon2 = 14;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(350, 461, 450, 461);
                        }
                        this.rd.drawString("Roof Destruction :", 350, 460);
                        this.rd.drawLine(461, 456, 551, 456);
                        for (int n90 = 1; n90 < 10; ++n90) {
                            this.rd.drawLine(461 + 10 * n90, 456 - n90, 461 + 10 * n90, 456 + n90);
                        }
                        this.rd.setColor(new Color(255, 0, 0));
                        final int n91 = (int)(this.crash[2] / 1.1111f / 10.0f);
                        this.rd.fillRect(459 + (int)(this.crash[2] / 1.1111f), 456 - n91, 5, n91 * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(460 + (int)(this.crash[2] / 1.1111f), 447, 2, 18);
                        this.stringbutton(" - ", 581, 460, 4, false);
                        this.stringbutton(" + ", 621, 460, 4, false);
                        this.stringbutton("    CRASH!    ", 143, 516, 0, true);
                        this.stringbutton("  Fix  ", 235, 516, 0, false);
                        this.stringbutton("    CRASH Roof!    ", 484, 492, 0, true);
                        this.stringbutton("  Fix  ", 591, 492, 0, false);
                        this.stringbutton(" Reset ", 435, 535, 0, false);
                        this.stringbutton(" <  Back ", 508, 535, 0, false);
                        this.stringbutton("       Next  >       ", 602, 535, 0, true);
                    }
                    if (this.pfase == 3) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Select the most suitable engine for your car :", 30, 440);
                        this.engine.move(293, 424);
                        if (!this.engine.isShowing()) {
                            this.engine.show();
                            this.engine.select(this.engsel);
                        }
                        if (this.engsel != this.engine.getSelectedIndex()) {
                            this.engsel = this.engine.getSelectedIndex();
                            for (int n92 = 0; n92 < 5; ++n92) {
                                for (int n93 = 0; n93 < 5; ++n93) {
                                    this.engs[n93][n92].stop();
                                    this.engs[n93][n92].checkopen();
                                }
                            }
                            this.engon = false;
                        }
                        if (this.engsel == 0) {
                            this.rd.drawString("Normal Engine:  Like Tornado Shark, Sword of Justice or Radical One's engine.", 30, 470);
                        }
                        if (this.engsel == 1) {
                            this.rd.drawString("V8 Engine:  High speed engine like Formula 7, Drifter X or Might Eight's engine.", 30, 470);
                        }
                        if (this.engsel == 2) {
                            this.rd.drawString("Retro Engine:  Like Wow Caninaro, Lead Oxide or Kool Kat\u2019s engine.", 30, 470);
                        }
                        if (this.engsel == 3) {
                            this.rd.drawString("Power Engine:  Turbo/super charged engine like Max Revenge, High Rider or Dr Monstaa\u2019s engine.", 30, 470);
                        }
                        if (this.engsel == 4) {
                            this.rd.drawString("Diesel Engine:  Big diesel powered engine for big cars like EL King or  M A S H E E N .", 30, 470);
                        }
                        this.rd.drawString("LISTEN :", 30, 500);
                        this.stringbutton(" Idle ", 108, 500, 0, true);
                        this.stringbutton(" RPM 1 ", 170, 500, 0, true);
                        this.stringbutton(" RPM 2 ", 240, 500, 0, true);
                        this.stringbutton(" RPM 3 ", 310, 500, 0, true);
                        this.stringbutton(" RPM MAX ", 389, 500, 0, true);
                        if (this.engon) {
                            this.stringbutton("          Stop Engine          ", 240, 535, 0, true);
                        }
                        else {
                            this.stringbutton("          Stop Engine          ", 240, -2500, 0, true);
                        }
                        this.stringbutton(" <  Back ", 500, 525, 0, false);
                        this.stringbutton("     Save & Finish!     ", 610, 525, 0, true);
                    }
                    if (this.pfase == 4) {
                        this.rd.drawString("Testing & Setting up Physics...", 265, 470);
                        this.repaint();
                        try {
                            final Thread thredo = this.thredo;
                            Thread.sleep(100L);
                        }
                        catch (InterruptedException ex11) {}
                        for (int n94 = 0; n94 < 4; ++n94) {
                            int n95 = 0;
                            int n96 = 4;
                            if (n94 == 1) {
                                n96 = 2;
                            }
                            if (n94 == 2) {
                                n95 = 2;
                            }
                            for (int n97 = 0; n97 < 10; ++n97) {
                                this.setupo();
                                this.o.xy = 0;
                                this.hitmag = 0;
                                int actmag = 0;
                                this.actmag = 0;
                                int n98 = n95;
                                int n99 = 0;
                                while (this.hitmag < 17000) {
                                    if (n99 != 0) {
                                        this.regx(n98, (int)(150.0 + 600.0 * Math.random()), true);
                                    }
                                    else {
                                        this.regz(n98, (int)(150.0 + 600.0 * Math.random()), true);
                                    }
                                    if (++n98 == n96) {
                                        final ContO o = this.o;
                                        o.xz += 45;
                                        final ContO o2 = this.o;
                                        o2.zy += 45;
                                        n98 = 0;
                                        if (n99 != 0) {
                                            n99 = 0;
                                        }
                                        else {
                                            n99 = 1;
                                        }
                                        if (actmag == this.actmag) {
                                            final int[] crash = this.crash;
                                            final int n100 = 0;
                                            crash[n100] += 10;
                                        }
                                        actmag = this.actmag;
                                    }
                                }
                            }
                            float n101 = 0.0f;
                            for (int n102 = 0; n102 < 10; ++n102) {
                                this.setupo();
                                this.o.xy = 0;
                                this.actmag = 0;
                                this.hitmag = 0;
                                int n103 = n95;
                                int n104 = 0;
                                while (this.hitmag < 17000) {
                                    if (n104 != 0) {
                                        this.regx(n103, (int)(150.0 + 600.0 * Math.random()), true);
                                    }
                                    else {
                                        this.regz(n103, (int)(150.0 + 600.0 * Math.random()), true);
                                    }
                                    if (++n103 == n96) {
                                        final ContO o3 = this.o;
                                        o3.xz += 45;
                                        final ContO o4 = this.o;
                                        o4.zy += 45;
                                        n103 = 0;
                                        if (n104 != 0) {
                                            n104 = 0;
                                        }
                                        else {
                                            n104 = 1;
                                        }
                                    }
                                }
                                n101 += this.actmag / this.hitmag;
                            }
                            this.actmag = (int)(this.hitmag * (n101 / 10.0f));
                            if (this.stat[4] > 200) {
                                this.stat[4] = 200;
                            }
                            if (this.stat[4] < 16) {
                                this.stat[4] = 16;
                            }
                            float n105 = 0.9f + (this.stat[4] - 90) * 0.01f;
                            if (n105 < 0.6) {
                                n105 = 0.6f;
                            }
                            if (this.stat[4] == 200 && this.stat[0] <= 88) {
                                n105 = 3.0f;
                            }
                            final int n106 = (int)(this.actmag * n105);
                            for (int n107 = 0; n107 < 12; ++n107) {
                                this.setupo();
                                this.o.xy = 0;
                                this.o.xz = 90 * n107;
                                if (this.o.xz >= 360) {
                                    final ContO o5 = this.o;
                                    o5.xz -= 360;
                                }
                                this.hitmag = 0;
                                int actmag2 = 0;
                                this.actmag = 0;
                                int n108 = n95;
                                int n109 = 0;
                                while (this.actmag < n106) {
                                    if (n109 != 0) {
                                        this.regx(n108, (int)(150.0 + 600.0 * Math.random()), true);
                                    }
                                    else {
                                        this.regz(n108, (int)(150.0 + 600.0 * Math.random()), true);
                                    }
                                    if (++n108 == n96) {
                                        if (n109 != 0) {
                                            n109 = 0;
                                        }
                                        else {
                                            n109 = 1;
                                        }
                                        n108 = 0;
                                        if (actmag2 == this.actmag) {
                                            final int[] crash2 = this.crash;
                                            final int n110 = 0;
                                            crash2[n110] += 10;
                                        }
                                        actmag2 = this.actmag;
                                    }
                                }
                            }
                            if (n94 == 3) {
                                float n111 = 0.0f;
                                for (int n112 = 0; n112 < 10; ++n112) {
                                    this.setupo();
                                    this.o.xy = 0;
                                    this.actmag = 0;
                                    this.hitmag = 0;
                                    int n113 = n95;
                                    int n114 = 0;
                                    while (this.hitmag < 17000) {
                                        if (n114 != 0) {
                                            this.regx(n113, (int)(150.0 + 600.0 * Math.random()), true);
                                        }
                                        else {
                                            this.regz(n113, (int)(150.0 + 600.0 * Math.random()), true);
                                        }
                                        if (++n113 == n96) {
                                            final ContO o6 = this.o;
                                            o6.xz += 45;
                                            final ContO o7 = this.o;
                                            o7.zy += 45;
                                            n113 = 0;
                                            if (n114 != 0) {
                                                n114 = 0;
                                            }
                                            else {
                                                n114 = 1;
                                            }
                                        }
                                    }
                                    n111 += this.actmag / this.hitmag;
                                }
                                this.actmag = (int)(this.hitmag * (n111 / 10.0f));
                            }
                        }
                        this.setupo();
                        final String string7 = "" + this.editor.getText() + "\n";
                        String s3 = "";
                        int n115 = 0;
                        int n116 = string7.indexOf("\n", 0);
                        while (n116 != -1 && n115 < string7.length()) {
                            final String trim4 = string7.substring(n115, n116).trim();
                            n115 = n116 + 1;
                            n116 = string7.indexOf("\n", n115);
                            if (!trim4.startsWith("physics(")) {
                                s3 = s3 + "" + trim4 + "\n";
                            }
                            else {
                                s3 = s3.trim() + "\n";
                            }
                        }
                        this.editor.setText(s3.trim() + "\n\n\nphysics(" + this.phys[0] + "," + this.phys[1] + "," + this.phys[2] + "," + this.phys[3] + "," + this.phys[4] + "," + this.phys[5] + "," + this.phys[6] + "," + this.phys[7] + "," + this.phys[8] + "," + this.phys[9] + "," + this.phys[10] + "," + this.crash[0] + "," + this.crash[1] + "," + this.crash[2] + "," + this.engsel + "," + this.actmag + ")\n\n\n\n");
                        this.savefile();
                        for (int n117 = 0; n117 < 11; ++n117) {
                            this.rphys[n117] = this.phys[n117];
                        }
                        for (int n118 = 0; n118 < 3; ++n118) {
                            this.rcrash[n118] = this.crash[n118];
                        }
                        this.pfase = 5;
                    }
                    if (this.pfase == 5) {
                        this.rd.drawString("Car physics has been successfully set up!", 231, 450);
                        this.rd.drawString("Test drive your car to see the results...", 242, 490);
                    }
                    if (mouseon2 != -1) {
                        if (this.mouseon == -1) {
                            this.mouseon = mouseon2;
                            this.setCursor(new Cursor(12));
                        }
                    }
                    else if (this.mouseon != -1) {
                        this.mouseon = -1;
                        this.setCursor(new Cursor(0));
                    }
                    if (this.mouses == -1 && mouseon2 != -1) {
                        JOptionPane.showMessageDialog(null, this.usage[mouseon2], "Car Maker", 1);
                    }
                }
                if (this.dtab == 6) {
                    if (this.dtab != this.dtabed) {
                        final String string8 = "" + this.editor.getText() + "\n";
                        int n119 = 0;
                        int n120 = string8.indexOf("\n", 0);
                        while (n120 != -1 && n119 < string8.length()) {
                            final String trim5 = string8.substring(n119, n120).trim();
                            n119 = n120 + 1;
                            n120 = string8.indexOf("\n", n119);
                            if (trim5.startsWith("handling(")) {
                                try {
                                    this.handling = this.getvalue("handling", trim5, 0);
                                    if (this.handling > 200) {
                                        this.handling = 200;
                                    }
                                    if (this.handling >= 50) {
                                        continue;
                                    }
                                    this.handling = 50;
                                }
                                catch (Exception ex12) {}
                            }
                        }
                        this.rateh = false;
                    }
                    if (!this.rateh) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Test Drive the Car", 350 - this.ftm.stringWidth("Test Drive the Car") / 2, 445);
                        this.witho.move(292, 455);
                        if (!this.witho.isShowing()) {
                            this.witho.show();
                        }
                        this.stringbutton("     TEST DRIVE!     ", 350, 505, 0, true);
                        if (this.tested) {
                            this.stringbutton("  Edit Stats & Class  ", 150, 471, 0, false);
                            this.stringbutton("  Edit Physics  ", 150, 505, 0, false);
                            this.stringbutton("     Rate Car Handling     ", 550, 471, 0, true);
                        }
                    }
                    else {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Based on you test drive(s), how do your rate " + this.carname + "'s handling?", 350 - this.ftm.stringWidth("Based on your test drive(s), how do you rate " + this.carname + "'s handling?") / 2, 445);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.drawString("Handling :", 183, 483);
                        for (int n121 = 0; n121 < this.handling; ++n121) {
                            this.rd.setColor(Color.getHSBColor((float)(n121 * 7.0E-4), 1.0f, 1.0f));
                            this.rd.drawLine(250 + n121, 474, 250 + n121, 482);
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawLine(249, 474, 249, 482);
                        this.rd.drawLine(450, 474, 450, 482);
                        this.rd.drawLine(249, 483, 450, 483);
                        for (int n122 = 0; n122 < 7; ++n122) {
                            this.rd.drawLine(275 + n122 * 25, 482, 275 + n122 * 25, 478);
                        }
                        this.stringbutton(" - ", 480, 483, 4, false);
                        this.stringbutton(" + ", 520, 483, 4, false);
                        this.stringbutton("       Save       ", 388, 525, 0, true);
                        this.stringbutton(" Cancel ", 298, 525, 0, false);
                    }
                }
                if (this.polynum >= 0 && this.cntpls > 0) {
                    for (int n123 = 0; n123 < this.o.npl; ++n123) {
                        if (n123 >= this.polynum && n123 < this.polynum + this.cntpls) {
                            if (this.pflk) {
                                this.o.p[n123].hsb[2] = 1.0f;
                            }
                            else {
                                this.o.p[n123].hsb[2] = 0.0f;
                                this.o.p[n123].hsb[0] = Math.abs(0.5f - this.o.p[n123].hsb[0]);
                                while (this.o.p[n123].hsb[0] > 1.0f) {
                                    final float[] hsb = this.o.p[n123].hsb;
                                    final int n124 = 0;
                                    --hsb[n124];
                                }
                            }
                        }
                        else if (this.prflk > 6 && this.prflk < 20) {
                            this.o.p[n123].gr = -13;
                        }
                        else {
                            this.o.p[n123].gr = 1;
                        }
                    }
                    if (this.pflk) {
                        this.pflk = false;
                    }
                    else {
                        this.pflk = true;
                    }
                    if (this.prflk < 40) {
                        ++this.prflk;
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("[ Showing " + this.cntpls + " Polygons Selected ]", 350 - this.ftm.stringWidth("[ Showing " + this.cntpls + " Polygons Selected ]") / 2, 45);
                    this.stringbutton("  Stop  ", 350, 67, 5, false);
                }
                n2 = 50;
                if (this.rotr) {
                    final ContO o8 = this.o;
                    o8.xz -= 5;
                    n2 = 15;
                }
                if (this.rotl) {
                    final ContO o9 = this.o;
                    o9.xz += 5;
                    n2 = 15;
                }
                if (this.left) {
                    final ContO o10 = this.o;
                    o10.xy -= 5;
                    n2 = 15;
                }
                if (this.right) {
                    final ContO o11 = this.o;
                    o11.xy += 5;
                    n2 = 15;
                }
                if (this.up) {
                    final ContO o12 = this.o;
                    o12.zy -= 5;
                    n2 = 15;
                }
                if (this.down) {
                    final ContO o13 = this.o;
                    o13.zy += 5;
                    n2 = 15;
                }
                if (this.plus) {
                    final ContO o14 = this.o;
                    o14.y += 5;
                    n2 = 15;
                }
                if (this.minus) {
                    final ContO o15 = this.o;
                    o15.y -= 5;
                    n2 = 15;
                }
                if (this.in) {
                    final ContO o16 = this.o;
                    o16.z += 10;
                    n2 = 15;
                }
                if (this.out) {
                    final ContO o17 = this.o;
                    o17.z -= 10;
                    n2 = 15;
                }
                this.ox = this.o.x;
                this.oy = this.o.y;
                this.oz = this.o.z;
                this.oxz = this.o.xz;
                this.oxy = this.o.xy;
                this.ozy = this.o.zy;
                if (this.dtabed != this.dtab) {
                    this.dtabed = this.dtab;
                }
                if (this.dtab == 5 && this.pfase == -1) {
                    this.repaint();
                    JOptionPane.showMessageDialog(null, "Car Wheels not defined or not defined correctly.\nBefore defining the car Physics car Wheels must be defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n", "Car Maker", 1);
                    this.dtab = 3;
                }
            }
            if (this.tab == 3) {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Publish Car :  [ " + this.carname + " ]", 30, 50);
                this.rd.drawString("Publishing Type :", 30, 80);
                this.pubtyp.move(150, 63);
                if (!this.pubtyp.isShowing()) {
                    this.pubtyp.show();
                    this.pubtyp.select(1);
                }
                this.stringbutton("       Publish  >       ", 102, 110, 0, true);
                this.pubitem.move(690 - this.pubitem.w, 96);
                if (!this.pubitem.isShowing()) {
                    this.pubitem.show();
                }
                if (this.pubitem.sel != 0) {
                    boolean b6 = false;
                    for (int n125 = 0; n125 < this.nmc; ++n125) {
                        if (this.pubitem.getSelectedItem().equals(this.mycars[n125])) {
                            b6 = true;
                        }
                    }
                    if (!b6) {
                        this.logged = 2;
                    }
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 0, 12));
                if (this.pubtyp.getSelectedIndex() == 0) {
                    this.rd.drawString("Private :  This means only you can use your car and no one else can add", 268, 72);
                    this.rd.drawString("it to their account to play with it !", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 1) {
                    this.rd.drawString("Public :  This means anyone can add this car to their account to play with it,", 268, 72);
                    this.rd.drawString("but only you can download it to your Car Maker (no one else can get it\u2019s code).", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 2) {
                    this.rd.drawString("Super Public :  This means anyone can add this car to their account to play", 268, 72);
                    this.rd.drawString("with it and anyone can also download it to their Car Maker to get its code.", 268, 88);
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("Car Name", 80 - this.ftm.stringWidth("Car Name") / 2, 138);
                this.rd.drawString("Car Class", 200 - this.ftm.stringWidth("Car Class") / 2, 138);
                this.rd.drawString("Created By", 300 - this.ftm.stringWidth("Created By") / 2, 138);
                this.rd.drawString("Added By", 400 - this.ftm.stringWidth("Added By") / 2, 138);
                this.rd.drawString("Publish Type", 500 - this.ftm.stringWidth("Publish Type") / 2, 138);
                this.rd.drawString("Options", 620 - this.ftm.stringWidth("Options") / 2, 138);
                this.rd.drawLine(150, 129, 150, 140);
                this.rd.drawLine(250, 129, 250, 140);
                this.rd.drawLine(350, 129, 350, 140);
                this.rd.drawLine(450, 129, 450, 140);
                this.rd.drawLine(550, 129, 550, 140);
                this.rd.drawRect(10, 140, 680, 402);
                if (this.logged == 0) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Login to Retrieve your Account Cars", 350 - this.ftm.stringWidth("Login to Retrieve your Account Cars") / 2, 220);
                    this.rd.drawString("Nickname:", 326 - this.ftm.stringWidth("Nickname:") - 14, 266);
                    this.movefield(this.tnick, 326, 250, 129, 22);
                    if (!this.tnick.isShowing()) {
                        this.tnick.show();
                    }
                    this.rd.drawString("Password:", 326 - this.ftm.stringWidth("Password:") - 14, 296);
                    this.movefield(this.tpass, 326, 280, 129, 22);
                    if (!this.tpass.isShowing()) {
                        this.tpass.show();
                    }
                    this.stringbutton("       Login       ", 350, 340, 0, true);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Register a full account or if you have a trial account upgrade it!", 350 - this.ftm.stringWidth("Register a full account or if you have a trial account upgrade it!") / 2, 450);
                    this.stringbutton("   Register!   ", 290, 480, 0, true);
                    this.stringbutton("   Upgrade!   ", 410, 480, 0, true);
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("You need a full account to publish your cars to the multiplayer game!", 350 - this.ftm.stringWidth("You need a full account to publish your cars to the multiplayer game!") / 2, 505);
                }
                if (this.logged == -1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Ready to publish...", 350 - this.ftm.stringWidth("Ready to publish...") / 2, 220);
                    this.rd.drawString("Click \u2018Publish\u2019 above to add car: '" + this.carname + "'.", 350 - this.ftm.stringWidth("Click \u2018Publish\u2019 above to add car: '" + this.carname + "'.") / 2, 280);
                }
                if (this.logged == 2) {
                    this.mycars[this.roto] = this.pubitem.getSelectedItem();
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(50, 150, 600, 150);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Loading " + this.mycars[this.roto] + "\u2018s info...", 350 - this.ftm.stringWidth("Loading " + this.mycars[this.roto] + "\u2018s info...") / 2, 220);
                    this.repaint();
                    this.maker[this.roto] = "Unkown";
                    this.pubt[this.roto] = -1;
                    this.clas[this.roto] = 0;
                    this.nad[this.roto] = 0;
                    try {
                        String line;
                        while ((line = new DataInputStream(new URL(("http://multiplayer.needformadness.com/cars/" + this.mycars[this.roto] + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").replace(' ', '_')).openStream()).readLine()) != null) {
                            final String string9 = "" + line.trim();
                            if (string9.startsWith("details")) {
                                this.maker[this.roto] = this.getSvalue("details", string9, 0);
                                this.pubt[this.roto] = this.getvalue("details", string9, 1);
                                this.clas[this.roto] = this.getvalue("details", string9, 2);
                                int n126 = 0;
                                while (n126 == 0) {
                                    this.addeda[this.roto][this.nad[this.roto]] = this.getSvalue("details", string9, 3 + this.nad[this.roto]);
                                    if (this.addeda[this.roto][this.nad[this.roto]].equals("")) {
                                        n126 = 1;
                                    }
                                    else {
                                        final int[] nad = this.nad;
                                        final int roto = this.roto;
                                        ++nad[roto];
                                    }
                                }
                            }
                        }
                        ++this.nmc;
                        if (this.nmc > 20) {
                            this.nmc = 20;
                        }
                        ++this.roto;
                        if (this.roto >= 20) {
                            this.roto = 0;
                        }
                    }
                    catch (Exception ex13) {}
                    this.logged = 3;
                }
                if (this.logged == 1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Loading your account car list...", 350 - this.ftm.stringWidth("Loading your account car list...") / 2, 220);
                    this.repaint();
                    this.pubitem.removeAll();
                    this.pubitem.add(this.rd, "Account Cars");
                    this.nmc = 0;
                    this.roto = 0;
                    int n127 = 0;
                    try {
                        final DataInputStream dataInputStream = new DataInputStream(new URL("http://multiplayer.needformadness.com/cars/lists/" + this.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").openStream());
                        String line2;
                        while ((line2 = dataInputStream.readLine()) != null) {
                            final String string10 = "" + line2.trim();
                            if (string10.startsWith("mycars")) {
                                int n128 = 1;
                                while (n128 != 0 && n127 < 700) {
                                    final String svalue = this.getSvalue("mycars", string10, n127);
                                    if (svalue.equals("")) {
                                        n128 = 0;
                                    }
                                    else {
                                        this.pubitem.add(this.rd, svalue);
                                        ++n127;
                                    }
                                }
                            }
                        }
                        this.setCursor(new Cursor(0));
                        this.logged = -1;
                        dataInputStream.close();
                    }
                    catch (Exception ex) {
                        if (("" + ex).indexOf("FileNotFound") != -1) {
                            this.setCursor(new Cursor(0));
                            this.logged = -1;
                        }
                        else {
                            this.logged = 0;
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                        }
                    }
                    if (!this.justpubd.equals("")) {
                        this.pubitem.select(this.justpubd);
                        this.justpubd = "";
                    }
                }
                if (this.logged == 3) {
                    for (int n129 = 0; n129 < this.nmc; ++n129) {
                        this.rd.setColor(new Color(235, 235, 235));
                        if (this.xm > 11 && this.xm < 689 && this.ym > 142 + n129 * 20 && this.ym < 160 + n129 * 20) {
                            this.rd.setColor(new Color(255, 255, 255));
                        }
                        this.rd.fillRect(11, 142 + n129 * 20, 678, 18);
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.mycars[n129], 80 - this.ftm.stringWidth(this.mycars[n129]) / 2, 156 + n129 * 20);
                        this.rd.setColor(new Color(155, 155, 155));
                        this.rd.drawLine(150, 145 + n129 * 20, 150, 157 + n129 * 20);
                        if (this.pubt[n129] != -1) {
                            this.rd.drawLine(250, 145 + n129 * 20, 250, 157 + n129 * 20);
                            this.rd.drawLine(350, 145 + n129 * 20, 350, 157 + n129 * 20);
                            this.rd.drawLine(450, 145 + n129 * 20, 450, 157 + n129 * 20);
                            this.rd.drawLine(550, 145 + n129 * 20, 550, 157 + n129 * 20);
                            this.rd.setColor(new Color(0, 0, 64));
                            String s4 = "C";
                            if (this.clas[n129] == 1) {
                                s4 = "B & C";
                            }
                            if (this.clas[n129] == 2) {
                                s4 = "B";
                            }
                            if (this.clas[n129] == 3) {
                                s4 = "A & B";
                            }
                            if (this.clas[n129] == 4) {
                                s4 = "A";
                            }
                            this.rd.drawString("Class " + s4 + "", 200 - this.ftm.stringWidth("Class " + s4 + "") / 2, 156 + n129 * 20);
                            boolean b7 = false;
                            if (this.maker[n129].toLowerCase().equals(this.tnick.getText().toLowerCase())) {
                                b7 = true;
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("You", 300 - this.ftm.stringWidth("You") / 2, 156 + n129 * 20);
                            }
                            else {
                                this.rd.drawString(this.maker[n129], 300 - this.ftm.stringWidth(this.maker[n129]) / 2, 156 + n129 * 20);
                            }
                            if (this.nad[n129] > 1) {
                                if (this.ovbutton("" + this.nad[n129] + " Players", 400, 156 + n129 * 20)) {
                                    String s5 = "[ " + this.mycars[n129] + " ]  has been added by the following players to their accounts:     \n\n";
                                    int n130 = 0;
                                    for (int n131 = 0; n131 < this.nad[n129]; ++n131) {
                                        if (++n130 == 17) {
                                            s5 += "\n";
                                            n130 = 1;
                                        }
                                        s5 += this.addeda[n129][n131];
                                        if (n131 != this.nad[n129] - 1) {
                                            if (n131 != this.nad[n129] - 2) {
                                                s5 += ", ";
                                            }
                                            else if (n130 == 16) {
                                                s5 += "\nand ";
                                                n130 = 0;
                                            }
                                            else {
                                                s5 += " and ";
                                            }
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, s5 + "\n \n \n", "Car Maker", 1);
                                }
                            }
                            else {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("None", 400 - this.ftm.stringWidth("None") / 2, 156 + n129 * 20);
                            }
                            if (this.pubt[n129] == 0) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Private", 500 - this.ftm.stringWidth("Private") / 2, 156 + n129 * 20);
                            }
                            if (this.pubt[n129] == 1) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Public", 500 - this.ftm.stringWidth("Public") / 2, 156 + n129 * 20);
                            }
                            if (this.pubt[n129] == 2) {
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("Super Public", 500 - this.ftm.stringWidth("Super Public") / 2, 156 + n129 * 20);
                            }
                            if ((this.pubt[n129] == 2 || b7) && this.ovbutton("Download", 600, 156 + n129 * 20)) {
                                int showConfirmDialog = 0;
                                for (int n132 = 0; n132 < this.slcar.getItemCount(); ++n132) {
                                    if (this.mycars[n129].equals(this.slcar.getItem(n132))) {
                                        showConfirmDialog = JOptionPane.showConfirmDialog(null, "Replace the local " + this.mycars[n129] + " in your 'mycars' folder with the published online copy?", "Car Maker", 0);
                                    }
                                }
                                if (showConfirmDialog == 0) {
                                    this.setCursor(new Cursor(3));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(225, 225, 225));
                                    this.rd.fillRect(11, 141, 679, 401);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Downloading car, please wait...", 350 - this.ftm.stringWidth("Downloading car, please wait...") / 2, 250);
                                    this.repaint();
                                    try {
                                        final URL url = new URL(("http://multiplayer.needformadness.com/cars/" + this.mycars[n129] + ".radq?reqlo=" + (int)(Math.random() * 1000.0) + "").replace(' ', '_'));
                                        final int contentLength = url.openConnection().getContentLength();
                                        final DataInputStream dataInputStream2 = new DataInputStream(url.openStream());
                                        final byte[] array15 = new byte[contentLength];
                                        dataInputStream2.readFully(array15);
                                        ZipInputStream zipInputStream;
                                        if (array15[0] == 80 && array15[1] == 75 && array15[2] == 3) {
                                            zipInputStream = new ZipInputStream(new ByteArrayInputStream(array15));
                                        }
                                        else {
                                            final byte[] array16 = new byte[contentLength - 40];
                                            for (int n133 = 0; n133 < contentLength - 40; ++n133) {
                                                int n134 = 20;
                                                if (n133 >= 500) {
                                                    n134 = 40;
                                                }
                                                array16[n133] = array15[n133 + n134];
                                            }
                                            zipInputStream = new ZipInputStream(new ByteArrayInputStream(array16));
                                        }
                                        final ZipEntry nextEntry = zipInputStream.getNextEntry();
                                        if (nextEntry != null) {
                                            int intValue = Integer.valueOf(nextEntry.getName());
                                            final byte[] array17 = new byte[intValue];
                                            int n135 = 0;
                                            while (intValue > 0) {
                                                final int read = zipInputStream.read(array17, n135, intValue);
                                                n135 += read;
                                                intValue -= read;
                                            }
                                            final String string11 = new String(array17) + "\n";
                                            String s6 = "";
                                            int n136 = 0;
                                            int n137 = string11.indexOf("\n", 0);
                                            while (n137 != -1 && n136 < string11.length()) {
                                                final String trim6 = string11.substring(n136, n137).trim();
                                                n136 = n137 + 1;
                                                n137 = string11.indexOf("\n", n136);
                                                if (!trim6.startsWith("carmaker(") && !trim6.startsWith("publish(")) {
                                                    s6 = s6 + "" + trim6 + "\n";
                                                }
                                                else {
                                                    s6 = s6.trim() + "\n";
                                                }
                                            }
                                            final String string12 = s6.trim() + "\n\n";
                                            final File file = new File("" + Madness.fpath + "mycars/");
                                            if (!file.exists()) {
                                                file.mkdirs();
                                            }
                                            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "mycars/" + this.mycars[n129] + ".rad")));
                                            bufferedWriter.write(string12);
                                            bufferedWriter.close();
                                            zipInputStream.close();
                                            if (this.carname.equals(this.mycars[n129])) {
                                                this.editor.setText(string12);
                                                this.lastedo = string12;
                                            }
                                            this.setCursor(new Cursor(0));
                                            JOptionPane.showMessageDialog(null, "" + this.mycars[n129] + " has been successfully downloaded!", "Car Maker", 1);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                                        }
                                    }
                                    catch (Exception ex14) {
                                        JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                                    }
                                }
                            }
                        }
                        else {
                            this.rd.drawString("-    Error Loading this car's info!    -", 350 - this.ftm.stringWidth("-    Error Loading this car's info!    -") / 2, 156 + n129 * 20);
                        }
                        if (this.ovbutton("X", 665, 156 + n129 * 20) && JOptionPane.showConfirmDialog(null, "Remove " + this.mycars[n129] + " from your account?", "Car Maker", 0) == 0) {
                            this.setCursor(new Cursor(3));
                            int servervalue = -1;
                            try {
                                final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                new PrintWriter(socket.getOutputStream(), true).println("9|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.mycars[n129] + "|");
                                final String line3 = bufferedReader.readLine();
                                if (line3 != null) {
                                    servervalue = this.servervalue(line3, 0);
                                }
                                socket.close();
                            }
                            catch (Exception ex15) {
                                servervalue = -1;
                            }
                            if (servervalue == 0) {
                                this.logged = 1;
                            }
                            else {
                                this.setCursor(new Cursor(0));
                                JOptionPane.showMessageDialog(null, "Failed to remove " + this.mycars[n129] + " from your account.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                            }
                        }
                    }
                }
            }
            if (this.tabed != this.tab) {
                this.tabed = this.tab;
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 700, 25);
            if (!this.onbtgame) {
                this.rd.drawImage(this.btgame[0], 520, 0, null);
            }
            else {
                this.rd.drawImage(this.btgame[1], 520, 0, null);
            }
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            final String[] array18 = { "Car", "Code Edit", "3D Edit", "Publish" };
            final int[] array19 = { 0, 0, 100, 90 };
            final int[] array20 = { 0, 25, 25, 0 };
            int n138 = 4;
            if (this.carname.equals("") || !this.loadedfile || this.sfase != 0) {
                this.tab = 0;
                n138 = 1;
            }
            for (int tab = 0; tab < n138; ++tab) {
                this.rd.setColor(new Color(170, 170, 170));
                if (this.xm > array19[0] && this.xm < array19[3] && this.ym > 0 && this.ym < 25) {
                    this.rd.setColor(new Color(200, 200, 200));
                }
                if (this.tab == tab) {
                    this.rd.setColor(new Color(225, 225, 225));
                }
                this.rd.fillPolygon(array19, array20, 4);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(array18[tab], tab * 100 + 45 - this.ftm.stringWidth(array18[tab]) / 2, 17);
                if (this.xm > array19[0] && this.xm < array19[3] && this.ym > 0 && this.ym < 25 && this.mouses == -1) {
                    if (this.tab != tab && this.tab == 1) {
                        this.savefile();
                    }
                    this.tab = tab;
                }
                for (int n139 = 0; n139 < 4; ++n139) {
                    final int[] array21 = array19;
                    final int n140 = n139;
                    array21[n140] += 100;
                }
            }
            this.drawms();
            this.ctachm();
            this.repaint();
            if (!this.exwist) {
                try {
                    final Thread thredo2 = this.thredo;
                    Thread.sleep(n2);
                }
                catch (InterruptedException ex16) {}
            }
        }
        this.rd.dispose();
        System.gc();
        if (Madness.endadv == 2) {
            Madness.advopen();
        }
    }

    public void ctachm() {
        int n = -1;
        for (int i = 0; i < this.btn; ++i) {
            if (Math.abs(this.xm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(this.ym - this.by[i]) < 14 && this.mouses == 1) {
                this.pessd[i] = true;
            }
            else {
                this.pessd[i] = false;
            }
            if (Math.abs(this.xm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(this.ym - this.by[i]) < 14 && this.mouses == -1) {
                n = i;
            }
        }
        if (this.mouses == -1) {
            this.mouses = 0;
        }
        if (this.tab == 0) {
            if (this.sfase == 0) {
                if (n == 0) {
                    this.sfase = 1;
                    n = -1;
                    this.hidefields();
                }
                if (n == 1) {
                    if (!this.carname.equals("")) {
                        this.srch.setText(this.carname);
                        this.sfase = 2;
                        n = -1;
                        this.hidefields();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please Select a Car to Rename!\n", "Car Maker", 1);
                    }
                }
                if (n == 2) {
                    this.delcar(this.carname);
                }
                if (n == 3) {
                    this.sfase = 3;
                    n = -1;
                    this.hidefields();
                }
            }
            if (this.sfase == 1) {
                if (n == 0) {
                    this.newcar(this.srch.getText());
                    n = -1;
                }
                if (n == 1) {
                    this.srch.setText("");
                    this.sfase = 0;
                    n = -1;
                    this.hidefields();
                }
            }
            if (this.sfase == 2) {
                if (n == 0) {
                    this.rencar(this.srch.getText());
                    n = -1;
                }
                if (n == 1) {
                    this.srch.setText("");
                    this.sfase = 0;
                    n = -1;
                    this.hidefields();
                }
            }
            if (this.sfase == 3) {
                if (n == 0) {
                    File file = null;
                    final FileDialog fileDialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    fileDialog.setFile("*.obj");
                    fileDialog.setMode(0);
                    fileDialog.setVisible(true);
                    try {
                        if (fileDialog.getFile() != null) {
                            file = new File("" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "");
                        }
                    }
                    catch (Exception ex4) {}
                    if (file != null) {
                        this.setCursor(new Cursor(3));
                        int n2 = 0;
                        if (this.tutok) {
                            n2 = -70;
                        }
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(116, 246 + n2, 468, 50);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Reading " + file.getName() + ", please wait...", 350 - this.ftm.stringWidth("Reading " + file.getName() + ", please wait...") / 2, 276 + n2);
                        this.repaint();
                        final int[] array = new int[6000];
                        final int[] array2 = new int[6000];
                        final int[] array3 = new int[6000];
                        int n3 = 0;
                        final int[][] array4 = new int[600][100];
                        final int[] array5 = new int[600];
                        int n4 = 0;
                        if (file.exists()) {
                            try {
                                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                                boolean b = false;
                                boolean b2 = false;
                                String line;
                                while ((line = bufferedReader.readLine()) != null) {
                                    if (line.startsWith("v ")) {
                                        if (n3 < 6000) {
                                            this.multf10 = true;
                                            array[n3] = this.objvalue(line, 0);
                                            array2[n3] = this.objvalue(line, 1);
                                            array3[n3] = this.objvalue(line, 2);
                                            ++n3;
                                        }
                                        else {
                                            b = true;
                                        }
                                    }
                                    if (line.startsWith("f ")) {
                                        if (n4 < 600) {
                                            this.multf10 = false;
                                            this.objfacend = false;
                                            array5[n4] = 0;
                                            while (!this.objfacend && array5[n4] < 100) {
                                                array4[n4][array5[n4]] = this.objvalue(line, array5[n4]);
                                                final int[] array6 = array5;
                                                final int n5 = n4;
                                                ++array6[n5];
                                            }
                                            ++n4;
                                        }
                                        else {
                                            b2 = true;
                                        }
                                    }
                                }
                                if (b) {
                                    JOptionPane.showMessageDialog(null, "Warning!\nThe number of Vertices in file " + file.getName() + " exceeded the maximum of 6000 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n", "Car Maker", 0);
                                }
                                if (b2) {
                                    JOptionPane.showMessageDialog(null, "Warning!\nThe number of Faces in file " + file.getName() + " exceeded the maximum of 600 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n", "Car Maker", 0);
                                }
                                bufferedReader.close();
                            }
                            catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Unable to load file! Error Deatials:\n" + ex, "Car Maker", 1);
                            }
                            this.rd.setColor(new Color(225, 225, 225));
                            this.rd.fillRect(116, 246 + n2, 468, 50);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Importing " + file.getName() + ", please wait...", 350 - this.ftm.stringWidth("Importing " + file.getName() + ", please wait...") / 2, 276 + n2);
                            this.repaint();
                            this.carname = file.getName();
                            if (this.carname.endsWith(".obj")) {
                                this.carname = this.carname.substring(0, this.carname.length() - 4);
                            }
                            String s = "\n// imported car: " + this.carname + "\n---------------------\n\n// Please read the helpful information about importing cars found at:\n// http://www.needformadness.com/developer/extras.html\n\n\n";
                            for (int j = 0; j < n4; ++j) {
                                String s2 = s + "<p>\nc(200,200,220)\n\n";
                                for (int k = 0; k < array5[j]; ++k) {
                                    if (array4[j][k] < 6000) {
                                        final int n6 = array4[j][k];
                                        s2 = s2 + "p(" + array[n6] + "," + -array2[n6] + "," + array3[n6] + ")\n";
                                    }
                                }
                                s = s2 + "</p>\n\n";
                            }
                            final String string = s + "\n\n\n\n";
                            final File file2 = new File("" + Madness.fpath + "mycars/");
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            final File file3 = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad");
                            int showConfirmDialog = 0;
                            if (file3.exists()) {
                                showConfirmDialog = JOptionPane.showConfirmDialog(null, "Another car with the name '" + this.carname + "' already exists, replace it?      \n", "Car Maker", 0);
                            }
                            if (showConfirmDialog == 0) {
                                try {
                                    final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file3));
                                    bufferedWriter.write(string);
                                    bufferedWriter.close();
                                    if (file3.exists()) {
                                        this.sfase = 0;
                                        this.hidefields();
                                        this.tabed = -1;
                                    }
                                    else {
                                        this.carname = "";
                                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                                    }
                                }
                                catch (Exception ex2) {
                                    this.carname = "";
                                    JOptionPane.showMessageDialog(null, "Unable to create file! Error Deatials:\n" + ex2, "Car Maker", 1);
                                }
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Error, " + file.getName() + " was not found!", "Car Maker", 1);
                        }
                        this.setCursor(new Cursor(0));
                    }
                }
                if (n == 1) {
                    this.sfase = 4;
                    n = -1;
                }
                if (n == 2) {
                    this.sfase = 0;
                    n = -1;
                }
            }
            if (this.sfase == 4) {
                if (n == 0) {
                    File file4 = null;
                    final FileDialog fileDialog2 = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    fileDialog2.setFile("" + this.carname + ".obj");
                    fileDialog2.setMode(1);
                    fileDialog2.setVisible(true);
                    try {
                        if (fileDialog2.getFile() != null) {
                            file4 = new File("" + fileDialog2.getDirectory() + "" + fileDialog2.getFile() + "");
                        }
                    }
                    catch (Exception ex5) {}
                    if (file4 != null) {
                        int showConfirmDialog2 = 0;
                        if (file4.exists()) {
                            showConfirmDialog2 = JOptionPane.showConfirmDialog(null, "File " + file4.getName() + " already exists, replace it?      \n", "Car Maker", 0);
                        }
                        if (showConfirmDialog2 == 0) {
                            this.setCursor(new Cursor(3));
                            this.setupo();
                            final int[] array7 = new int[6000];
                            final int[] array8 = new int[6000];
                            final int[] array9 = new int[6000];
                            int n7 = 0;
                            String s3 = "";
                            for (int l = 0; l < this.o.npl; ++l) {
                                for (int n8 = 0; n8 < this.o.p[l].n; ++n8) {
                                    boolean b3 = false;
                                    for (int n9 = 0; n9 < n7; ++n9) {
                                        if (array7[n9] == this.o.p[l].ox[n8] && array8[n9] == this.o.p[l].oy[n8] && array9[n9] == this.o.p[l].oz[n8]) {
                                            b3 = true;
                                        }
                                    }
                                    if (!b3 && n7 < 6000) {
                                        array7[n7] = this.o.p[l].ox[n8];
                                        array8[n7] = this.o.p[l].oy[n8];
                                        array9[n7] = this.o.p[l].oz[n8];
                                        ++n7;
                                    }
                                }
                            }
                            for (int n10 = 0; n10 < n7; ++n10) {
                                s3 = s3 + "v " + array7[n10] / 10.0f + " " + -array8[n10] / 10.0f + " " + array9[n10] / 10.0f + "\n";
                            }
                            for (int n11 = 0; n11 < this.o.npl; ++n11) {
                                if (this.o.p[n11].wz == 0) {
                                    String s4 = s3 + "f";
                                    for (int n12 = 0; n12 < this.o.p[n11].n; ++n12) {
                                        s4 += " ";
                                        for (int n13 = 0; n13 < n7; ++n13) {
                                            if (array7[n13] == this.o.p[n11].ox[n12] && array8[n13] == this.o.p[n11].oy[n12] && array9[n13] == this.o.p[n11].oz[n12]) {
                                                s4 = s4 + "" + (n13 + 1);
                                            }
                                        }
                                    }
                                    s3 = s4 + "\n";
                                }
                            }
                            try {
                                final BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file4));
                                bufferedWriter2.write(s3);
                                bufferedWriter2.close();
                                if (file4.exists()) {
                                    JOptionPane.showMessageDialog(null, "Car has been successfully exported to:\n" + file4.getAbsolutePath() + "          \n \n", "Car Maker", 1);
                                    this.sfase = 0;
                                    this.hidefields();
                                    this.tabed = -1;
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Failed to export car, unknown reason!\n", "Car Maker", 1);
                                }
                            }
                            catch (Exception ex3) {
                                JOptionPane.showMessageDialog(null, "Unable to create exported file! Error Deatials:\n" + ex3, "Car Maker", 1);
                            }
                            this.setCursor(new Cursor(0));
                        }
                    }
                }
                if (n == 1) {
                    this.sfase = 0;
                    n = -1;
                }
            }
        }
        if (this.tab == 1) {
            if (n == 0) {
                if (this.prefs) {
                    this.prefs = false;
                }
                else {
                    this.prefs = true;
                }
            }
            if (n == 1 || n == 2) {
                this.savefile();
                if (n == 2) {
                    this.tab = 2;
                }
            }
            if (!this.mirror) {
                boolean b4 = false;
                if (n == 4) {
                    if (this.sls != -1 && this.sle != -1 && this.editor.getSelectedText().equals(this.srch.getText())) {
                        this.editor.replaceText(this.rplc.getText(), this.sls, this.sle);
                        this.sls = -1;
                        this.sle = -1;
                        b4 = true;
                        try {
                            final Thread thredo = this.thredo;
                            Thread.sleep(100L);
                        }
                        catch (InterruptedException ex6) {}
                    }
                    n = 3;
                }
                if (n == 3 && !this.srch.getText().equals("")) {
                    this.editor.requestFocus();
                    this.sls = this.editor.getText().indexOf(this.srch.getText(), this.editor.getSelectionEnd());
                    if (this.sls != -1) {
                        this.sle = this.sls + this.srch.getText().length();
                        this.editor.select(this.sls, this.sle);
                    }
                    else if (!b4) {
                        JOptionPane.showMessageDialog(null, "Cannot find  '" + this.srch.getText() + "'  from Cursor position    ", "Car Maker", 1);
                    }
                }
            }
            else {
                if (n == 3 || n == 4 || n == 5) {
                    final String string2 = "" + this.editor.getSelectedText() + "\n";
                    final String s5 = "\n\n";
                    String s6;
                    if (this.cntpls == 1) {
                        s6 = s5 + "// Mirror of the polygon above along the ";
                    }
                    else {
                        s6 = s5 + "// Mirror of the " + this.cntpls + " polygons above along the ";
                    }
                    if (n == 3) {
                        s6 += "X axis:";
                    }
                    if (n == 4) {
                        s6 += "Y axis:";
                    }
                    if (n == 5) {
                        s6 += "Z axis:";
                    }
                    String s7 = s6 + "\n\n";
                    int n14 = 0;
                    int n15 = string2.indexOf("\n", 0);
                    while (n15 != -1 && n14 < string2.length()) {
                        String s8 = string2.substring(n14, n15).trim();
                        n14 = n15 + 1;
                        n15 = string2.indexOf("\n", n14);
                        if (s8.startsWith("fs(-")) {
                            s8 = "fs(" + s8.substring(4, s8.length()) + "";
                        }
                        else if (s8.startsWith("fs(")) {
                            s8 = "fs(-" + s8.substring(3, s8.length()) + "";
                        }
                        if (n == 3) {
                            if (s8.startsWith("p(-")) {
                                s8 = "p(" + s8.substring(3, s8.length()) + "";
                            }
                            else if (s8.startsWith("p(")) {
                                s8 = "p(-" + s8.substring(2, s8.length()) + "";
                            }
                        }
                        if (n == 4 && s8.startsWith("p(")) {
                            final int index = s8.indexOf(",", 0);
                            if (index >= 0) {
                                if (s8.startsWith(",-", index)) {
                                    s8 = "" + s8.substring(0, index) + "," + s8.substring(index + 2, s8.length()) + "";
                                }
                                else if (s8.startsWith(",", index)) {
                                    s8 = "" + s8.substring(0, index) + ",-" + s8.substring(index + 1, s8.length()) + "";
                                }
                            }
                        }
                        if (n == 5 && s8.startsWith("p(")) {
                            final int index2 = s8.indexOf(",", s8.indexOf(",", 0) + 1);
                            if (index2 >= 0) {
                                if (s8.startsWith(",-", index2)) {
                                    s8 = "" + s8.substring(0, index2) + "," + s8.substring(index2 + 2, s8.length()) + "";
                                }
                                else if (s8.startsWith(",", index2)) {
                                    s8 = "" + s8.substring(0, index2) + ",-" + s8.substring(index2 + 1, s8.length()) + "";
                                }
                            }
                        }
                        s7 = s7 + "" + s8 + "\n";
                    }
                    this.editor.insertText(s7 + "\n// End of mirror", this.editor.getSelectionEnd());
                }
                if (n == 6) {
                    this.polynum = 0;
                    int n16 = this.editor.getText().lastIndexOf("</p>", this.editor.getSelectionStart());
                    int n17 = 0;
                    while (n16 >= 0) {
                        if (n17 == 0) {
                            n16 = this.editor.getText().lastIndexOf("<p>", n16);
                            if (n16 != -1) {
                                n17 = 1;
                                ++this.polynum;
                            }
                        }
                        else {
                            n16 = this.editor.getText().lastIndexOf("</p>", n16);
                            if (n16 != -1) {
                                n17 = 0;
                            }
                        }
                        --n16;
                    }
                    this.prflk = 0;
                    this.tab = 2;
                }
            }
            n = -1;
        }
        if (this.tab == 2) {
            int n18 = 0;
            if (this.dtab == 1) {
                if (this.o.colok != 2) {
                    if (n == 0) {
                        JOptionPane.showMessageDialog(null, "Car Maker will attempt now to find the first and second colors automatically.\nPlease make sure that they are the correct colors!\n\nPlease note that these are also the colors that will be editable in the multiplayer game.      ", "Car Maker", 1);
                        final String string3 = "" + this.editor.getText() + "\n";
                        int n19 = 0;
                        int n20 = string3.indexOf("\n", 0);
                        int n21 = 0;
                        String s9 = "";
                        String s10 = "";
                        while (n20 != -1 && n19 < string3.length() && n21 != 2) {
                            final String trim = string3.substring(n19, n20).trim();
                            n19 = n20 + 1;
                            n20 = string3.indexOf("\n", n19);
                            if (trim.startsWith("c(")) {
                                final String substring = trim.substring(1, trim.indexOf(")") + 1);
                                if (n21 == 1 && !substring.equals(s10)) {
                                    s9 = s9 + "2ndColor" + substring + "\n\n\n";
                                    n21 = 2;
                                }
                                if (n21 != 0) {
                                    continue;
                                }
                                s10 = substring;
                                s9 = "1stColor" + substring + "\n";
                                n21 = 1;
                            }
                        }
                        if (n21 == 0) {
                            s9 = "1stColor(255,0,0)\n2ndColor(0,0,255)\n\n\n";
                            n21 = 2;
                        }
                        if (n21 == 1) {
                            s9 += "2ndColor(0,0,255)\n\n\n";
                        }
                        final int index3 = this.editor.getText().indexOf("<p>", 0);
                        this.editor.insertText(s9, index3);
                        this.editor.select(index3, index3 + s9.length() - 2);
                        this.breakbond = true;
                        this.tab = 1;
                    }
                    n18 = 1;
                }
                else {
                    if (n == 0) {
                        this.ofcol = "(" + this.o.fcol[0] + "," + this.o.fcol[1] + "," + this.o.fcol[2] + ")";
                        int index5;
                        for (int index4 = index5 = this.editor.getText().indexOf(this.ofcol, 0); index4 != -1; index4 = this.editor.getText().indexOf(this.ofcol, index4 + 1)) {
                            this.editor.replaceText(this.fcol, index4, index4 + this.ofcol.length());
                        }
                        this.ofcol = this.fcol;
                        this.editor.select(index5 - 8, index5 - 8);
                        this.savefile();
                        this.o.fcol[0] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed();
                        this.o.fcol[1] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen();
                        this.o.fcol[2] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue();
                    }
                    if (n == 1) {
                        this.oscol = "(" + this.o.scol[0] + "," + this.o.scol[1] + "," + this.o.scol[2] + ")";
                        int index7;
                        for (int index6 = index7 = this.editor.getText().indexOf(this.oscol, 0); index6 != -1; index6 = this.editor.getText().indexOf(this.oscol, index6 + 1)) {
                            this.editor.replaceText(this.scol, index6, index6 + this.oscol.length());
                        }
                        this.oscol = this.scol;
                        this.editor.select(index7 - 8, index7 - 8);
                        this.savefile();
                        this.o.scol[0] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed();
                        this.o.scol[1] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen();
                        this.o.scol[2] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue();
                    }
                    n18 = 2;
                }
            }
            if (this.dtab == 2) {
                if (n == 9) {
                    this.scale[0] = 100;
                    this.scale[1] = 100;
                    this.scale[2] = 100;
                }
                if (n == 0 || n == 1 || n == 6 || n == 7 || n == 9) {
                    if (n == 0 || n == 6) {
                        final int[] scale = this.scale;
                        final int n22 = 0;
                        scale[n22] -= 5;
                    }
                    if (n == 1 || n == 7) {
                        final int[] scale2 = this.scale;
                        final int n23 = 0;
                        scale2[n23] += 5;
                    }
                    if (this.scale[0] < 0) {
                        this.scale[0] = 0;
                    }
                    int index8 = this.editor.getText().indexOf("\nScaleX(", 0);
                    if (index8 != -1) {
                        ++index8;
                        final int index9 = this.editor.getText().indexOf(")", index8);
                        final int index10 = this.editor.getText().indexOf("\n", index8);
                        if (index10 > index9) {
                            this.editor.replaceText("ScaleX(" + this.scale[0] + ")", index8, index9 + 1);
                        }
                        else {
                            this.editor.replaceText("ScaleX(" + this.scale[0] + ")", index8, index10);
                        }
                    }
                    else {
                        final int index11 = this.editor.getText().indexOf("<p>", 0);
                        final int index12 = this.editor.getText().indexOf("\nScale", 0);
                        if (index12 < index11 && index12 != -1) {
                            this.editor.insertText("\nScaleX(" + this.scale[0] + ")", index12);
                        }
                        else {
                            this.editor.insertText("ScaleX(" + this.scale[0] + ")\n\n\n", index11);
                        }
                    }
                }
                if (n == 2 || n == 3 || n == 6 || n == 7 || n == 9) {
                    if (n == 2 || n == 6) {
                        final int[] scale3 = this.scale;
                        final int n24 = 1;
                        scale3[n24] -= 5;
                    }
                    if (n == 3 || n == 7) {
                        final int[] scale4 = this.scale;
                        final int n25 = 1;
                        scale4[n25] += 5;
                    }
                    if (this.scale[1] < 0) {
                        this.scale[1] = 0;
                    }
                    int index13 = this.editor.getText().indexOf("\nScaleY(", 0);
                    if (index13 != -1) {
                        ++index13;
                        final int index14 = this.editor.getText().indexOf(")", index13);
                        final int index15 = this.editor.getText().indexOf("\n", index13);
                        if (index15 > index14) {
                            this.editor.replaceText("ScaleY(" + this.scale[1] + ")", index13, index14 + 1);
                        }
                        else {
                            this.editor.replaceText("ScaleY(" + this.scale[1] + ")", index13, index15);
                        }
                    }
                    else {
                        final int index16 = this.editor.getText().indexOf("<p>", 0);
                        final int index17 = this.editor.getText().indexOf("\nScale", 0);
                        if (index17 < index16 && index17 != -1) {
                            this.editor.insertText("\nScaleY(" + this.scale[1] + ")", index17);
                        }
                        else {
                            this.editor.insertText("ScaleY(" + this.scale[1] + ")\n\n\n", index16);
                        }
                    }
                }
                if (n == 4 || n == 5 || n == 6 || n == 7 || n == 9) {
                    if (n == 4 || n == 6) {
                        final int[] scale5 = this.scale;
                        final int n26 = 2;
                        scale5[n26] -= 5;
                    }
                    if (n == 5 || n == 7) {
                        final int[] scale6 = this.scale;
                        final int n27 = 2;
                        scale6[n27] += 5;
                    }
                    if (this.scale[2] < 0) {
                        this.scale[2] = 0;
                    }
                    int index18 = this.editor.getText().indexOf("\nScaleZ(", 0);
                    if (index18 != -1) {
                        ++index18;
                        final int index19 = this.editor.getText().indexOf(")", index18);
                        final int index20 = this.editor.getText().indexOf("\n", index18);
                        if (index20 > index19) {
                            this.editor.replaceText("ScaleZ(" + this.scale[2] + ")", index18, index19 + 1);
                        }
                        else {
                            this.editor.replaceText("ScaleZ(" + this.scale[2] + ")", index18, index20);
                        }
                    }
                    else {
                        final int index21 = this.editor.getText().indexOf("<p>", 0);
                        final int index22 = this.editor.getText().indexOf("\nScale", 0);
                        if (index22 < index21 && index22 != -1) {
                            this.editor.insertText("\nScaleZ(" + this.scale[2] + ")", index22);
                        }
                        else {
                            this.editor.insertText("ScaleZ(" + this.scale[2] + ")\n\n\n", index21);
                        }
                    }
                }
                if (n == 0 || n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 9) {
                    this.setupo();
                }
                if (n == 8) {
                    this.savefile();
                    this.oscale[0] = this.scale[0];
                    this.oscale[1] = this.scale[1];
                    this.oscale[2] = this.scale[2];
                }
                Label_6860: {
                    if (n != 10 && n != 11 && n != 12 && n != 13 && n != 14 && n != 15 && n != 16 && n != 17) {
                        if (n != 18) {
                            break Label_6860;
                        }
                    }
                    try {
                        final String string4 = "" + this.editor.getText() + "\n";
                        String text = "";
                        int n28 = 0;
                        int n29 = string4.indexOf("\n", 0);
                        while (n29 != -1 && n28 < string4.length()) {
                            final String trim2 = string4.substring(n28, n29).trim();
                            n28 = n29 + 1;
                            n29 = string4.indexOf("\n", n28);
                            if (trim2.startsWith("p(")) {
                                final int index23 = trim2.indexOf(",", 0);
                                final int index24 = trim2.indexOf(",", index23 + 1);
                                final int index25 = trim2.indexOf(")", index24 + 1);
                                if (index23 != -1 && index24 != -1 && index25 != -1) {
                                    int intValue = (int) Float.valueOf( trim2.substring(2, index23) ).floatValue();
                                    int intValue2 = (int) Float.valueOf( trim2.substring(index23 + 1, index24) ).floatValue();
                                    int intValue3 = (int) Float.valueOf( trim2.substring(index24 + 1, index25) ).floatValue();
                                    if (n == 10) {
                                        final int n30 = intValue2;
                                        intValue2 = intValue3;
                                        intValue3 = -n30;
                                    }
                                    if (n == 11) {
                                        intValue += 10;
                                    }
                                    if (n == 12) {
                                        intValue -= 10;
                                    }
                                    if (n == 13) {
                                        final int n31 = intValue;
                                        intValue = -intValue3;
                                        intValue3 = n31;
                                    }
                                    if (n == 14) {
                                        intValue2 += 10;
                                    }
                                    if (n == 15) {
                                        intValue2 -= 10;
                                    }
                                    if (n == 16) {
                                        final int n32 = intValue2;
                                        intValue2 = -intValue;
                                        intValue = n32;
                                    }
                                    if (n == 17) {
                                        intValue3 += 10;
                                    }
                                    if (n == 18) {
                                        intValue3 -= 10;
                                    }
                                    text = text + "p(" + intValue + "," + intValue2 + "," + intValue3 + ")" + trim2.substring(index25 + 1, trim2.length()) + "\n";
                                }
                                else {
                                    text = text + "" + trim2 + "\n";
                                }
                            }
                            else {
                                text = text + "" + trim2 + "\n";
                            }
                        }
                        this.editor.setText(text);
                        this.setupo();
                        this.changed2 = true;
                    }
                    catch (Exception ex7) {}
                }
                if (n == 19) {
                    this.editor.setText(this.lastedo);
                    this.setupo();
                    this.changed2 = false;
                }
                if (n == 20 && this.changed2 && JOptionPane.showConfirmDialog(null, "Saving now will permanently change the point locations & numbers entered in the code!      \n\nContinue?", "Car Maker", 0) == 0) {
                    this.editor.setText(this.editor.getText().trim() + "\n\n\n\n");
                    this.savefile();
                    this.changed2 = false;
                }
                n18 = 21;
            }
            if (this.dtab == 3) {
                if (n == 0 || n == 2 || this.defnow) {
                    if (this.defnow) {
                        this.defnow = false;
                        this.repaint();
                        JOptionPane.showMessageDialog(null, "Car Maker will setup default Front and Back Wheels positions and adjustments.\n\nEnter the desired positions and adjustments then press ' Apply ' to view!\nDon't forget to press ' Save ' when finished!", "Car Maker", 1);
                    }
                    int n33 = 0;
                    try {
                        if ((int) Float.valueOf( this.wv[10].getText() ).floatValue() <= 0) {
                            n33 = 1;
                        }
                        if ((int) Float.valueOf( this.wv[2].getText() ).floatValue() >= 0) {
                            n33 = 2;
                        }
                        if ((int) Float.valueOf( this.wv[8].getText() ).floatValue() <= 0) {
                            n33 = 3;
                        }
                        if ((int) Float.valueOf( this.wv[0].getText() ).floatValue() <= 0) {
                            n33 = 4;
                        }
                        final int intValue4 = (int) Float.valueOf( this.wv[15].getText() ).floatValue();
                        if (intValue4 > 40) {
                            this.wv[15].setText("40");
                        }
                        if (intValue4 < -40) {
                            this.wv[15].setText("-40");
                        }
                        final int intValue5 = (int) Float.valueOf( this.wv[7].getText() ).floatValue();
                        if (intValue5 > 40) {
                            this.wv[7].setText("40");
                        }
                        if (intValue5 < -40) {
                            this.wv[7].setText("-40");
                        }
                    }
                    catch (Exception ex8) {}
                    if (n33 == 1) {
                        JOptionPane.showMessageDialog(null, "ERROR:\nThe Z location value of the FRONT Wheels must be greater then zero! (it should have a +ve value)\nZ :  '" + this.wv[10].getText() + "'  is less or equal to zero, where it should have +ve value!", "Car Maker", 1);
                    }
                    if (n33 == 2) {
                        JOptionPane.showMessageDialog(null, "ERROR:\nThe Z location value of the BACK Wheels must be smaller then zero! (it should have a -ve value)\nZ :  '" + this.wv[2].getText() + "'  is bigger or equal to zero, where it should have -ve value!", "Car Maker", 1);
                    }
                    if (n33 == 3) {
                        JOptionPane.showMessageDialog(null, "ERROR:\nThe ±X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n±X :  '" + this.wv[8].getText() + "'  is less or equal to zero, where it should have +ve value!", "Car Maker", 1);
                    }
                    if (n33 == 4) {
                        JOptionPane.showMessageDialog(null, "ERROR:\nThe ±X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n±X :  '" + this.wv[0].getText() + "'  is less or equal to zero, whenr it should have +ve value!", "Car Maker", 1);
                    }
                    if (n33 == 0) {
                        final String string5 = "" + this.editor.getText() + "\n";
                        String s11 = "";
                        int n34 = 0;
                        int n35 = string5.indexOf("\n", 0);
                        while (n35 != -1 && n34 < string5.length()) {
                            final String trim3 = string5.substring(n34, n35).trim();
                            n34 = n35 + 1;
                            n35 = string5.indexOf("\n", n34);
                            if (!trim3.startsWith("rims(") && !trim3.startsWith("gwgr(") && !trim3.startsWith("w(")) {
                                s11 = s11 + "" + trim3 + "\n";
                            }
                            else {
                                s11 = s11.trim() + "\n";
                            }
                        }
                        final String string6 = s11.trim() + "\n\n\ngwgr(" + this.wv[15].getText() + ")\n";
                        String substring2 = "140,140,140";
                        if (this.rplc.getText().startsWith("(") && this.rplc.getText().endsWith(")")) {
                            substring2 = this.rplc.getText().substring(1, this.rplc.getText().length() - 1);
                        }
                        final String string7 = string6 + "rims(" + substring2 + "," + this.wv[13].getText() + "," + this.wv[14].getText() + ")\n" + "w(-" + this.wv[8].getText() + "," + this.wv[9].getText() + "," + this.wv[10].getText() + ",11," + this.wv[12].getText() + "," + this.wv[11].getText() + ")\n" + "w(" + this.wv[8].getText() + "," + this.wv[9].getText() + "," + this.wv[10].getText() + ",11,-" + this.wv[12].getText() + "," + this.wv[11].getText() + ")\n" + "\ngwgr(" + this.wv[7].getText() + ")\n";
                        String substring3 = "140,140,140";
                        if (this.srch.getText().startsWith("(") && this.srch.getText().endsWith(")")) {
                            substring3 = this.srch.getText().substring(1, this.srch.getText().length() - 1);
                        }
                        this.editor.setText(string7 + "rims(" + substring3 + "," + this.wv[5].getText() + "," + this.wv[6].getText() + ")\n" + "w(-" + this.wv[0].getText() + "," + this.wv[1].getText() + "," + this.wv[2].getText() + ",0," + this.wv[4].getText() + "," + this.wv[3].getText() + ")\n" + "w(" + this.wv[0].getText() + "," + this.wv[1].getText() + "," + this.wv[2].getText() + ",0,-" + this.wv[4].getText() + "," + this.wv[3].getText() + ")\n\n\n\n");
                        this.forwheels = true;
                        this.setupo();
                        this.forwheels = false;
                        this.aply1 = "" + this.wv[0].getText() + "" + this.wv[1].getText() + "" + this.wv[2].getText() + "" + this.wv[3].getText() + "" + this.wv[4].getText() + "" + this.srch.getText() + "" + this.wv[5].getText() + "" + this.wv[6].getText() + "" + this.wv[7].getText() + "";
                        this.aply2 = "" + this.wv[8].getText() + "" + this.wv[9].getText() + "" + this.wv[10].getText() + "" + this.wv[11].getText() + "" + this.wv[12].getText() + "" + this.rplc.getText() + "" + this.wv[13].getText() + "" + this.wv[14].getText() + "" + this.wv[15].getText() + "";
                        this.aplyd1 = false;
                        this.aplyd2 = false;
                        this.changed2 = true;
                    }
                }
                if (n == 1 || n == 3) {
                    if (!this.o.errd) {
                        this.savefile();
                        this.changed2 = false;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Unable to Save, press  [ Apply ]  to find out why!", "Car Maker", 1);
                    }
                }
                n18 = 4;
            }
            if (this.dtab == 4) {
                if (!this.statdef) {
                    if (n == 0) {
                        this.carsel = this.simcar.getSelectedIndex();
                        int n36 = 0;
                        for (int n37 = 0; n37 < 5; ++n37) {
                            this.stat[n37] = this.carstat[this.carsel][n37];
                            this.rstat[n37] = this.stat[n37];
                            n36 += this.stat[n37];
                        }
                        this.clsel = 4 - (n36 - 520) / 40;
                        this.cls.select(this.clsel);
                        if (this.simcar.getItemCount() == 16) {
                            this.simcar.add(this.rd, "   ");
                        }
                        this.statdef = true;
                        this.changed2 = true;
                    }
                    n18 = 1;
                }
                else {
                    for (int n38 = 0; n38 < 5; ++n38) {
                        int n39 = 0;
                        if (n == 1 + n38 * 2 && this.stat[n38] < 200) {
                            n39 = 200 - this.stat[n38];
                            if (n39 > 4) {
                                n39 = 4;
                            }
                        }
                        if (n == n38 * 2 && this.stat[n38] > 16) {
                            n39 = 16 - this.stat[n38];
                            if (n39 < -4) {
                                n39 = -4;
                            }
                        }
                        int n40 = 0;
                        while (n39 != 0 && n40 != 5) {
                            n40 = 0;
                            for (int n41 = 0; n41 < 5; ++n41) {
                                if (n38 != n41 && (this.stat[n41] <= 200 || n39 > 0) && (this.stat[n41] >= 16 || n39 < 0) && n39 != 0) {
                                    if (n39 > 0) {
                                        final int[] stat = this.stat;
                                        final int n42 = n38;
                                        ++stat[n42];
                                        final int[] stat2 = this.stat;
                                        final int n43 = n41;
                                        --stat2[n43];
                                        --n39;
                                    }
                                    else {
                                        final int[] stat3 = this.stat;
                                        final int n44 = n38;
                                        --stat3[n44];
                                        final int[] stat4 = this.stat;
                                        final int n45 = n41;
                                        ++stat4[n45];
                                        ++n39;
                                    }
                                }
                                else {
                                    ++n40;
                                }
                            }
                        }
                    }
                    if (n == 10) {
                        this.carsel = this.simcar.getSelectedIndex();
                        int n46 = 0;
                        for (int n47 = 0; n47 < 5; ++n47) {
                            this.stat[n47] = this.carstat[this.carsel][n47];
                            n46 += this.stat[n47];
                        }
                        this.clsel = 4 - (n46 - 520) / 40;
                        this.cls.select(this.clsel);
                    }
                    if (n == 11) {
                        final String string8 = "" + this.editor.getText() + "\n";
                        String s12 = "";
                        int n48 = 0;
                        int n49 = string8.indexOf("\n", 0);
                        while (n49 != -1 && n48 < string8.length()) {
                            final String trim4 = string8.substring(n48, n49).trim();
                            n48 = n49 + 1;
                            n49 = string8.indexOf("\n", n48);
                            if (!trim4.startsWith("stat(")) {
                                s12 = s12 + "" + trim4 + "\n";
                            }
                            else {
                                s12 = s12.trim() + "\n";
                            }
                        }
                        this.editor.setText(s12.trim() + "\n\n\nstat(" + this.stat[0] + "," + this.stat[1] + "," + this.stat[2] + "," + this.stat[3] + "," + this.stat[4] + ")\n\n\n\n");
                        this.savefile();
                        for (int n50 = 0; n50 < 5; ++n50) {
                            this.rstat[n50] = this.stat[n50];
                        }
                        this.changed2 = false;
                    }
                    if (n == 12) {
                        for (int n51 = 0; n51 < 5; ++n51) {
                            this.stat[n51] = this.rstat[n51];
                        }
                    }
                    n18 = 13;
                }
            }
            if (this.dtab == 5) {
                if (this.pfase == 0) {
                    for (int n52 = 0; n52 < 4; ++n52) {
                        if (n == 1 + n52 * 2) {
                            final int[] phys = this.phys;
                            final int n53 = n52;
                            phys[n53] += 2;
                            if (this.phys[n52] > 100) {
                                this.phys[n52] = 100;
                            }
                        }
                        if (n == n52 * 2) {
                            final int[] phys2 = this.phys;
                            final int n54 = n52;
                            phys2[n54] -= 2;
                            if (this.phys[n52] < 0) {
                                this.phys[n52] = 0;
                            }
                        }
                    }
                    if (n == 8) {
                        for (int n55 = 0; n55 < 5; ++n55) {
                            this.phys[n55] = (int)(Math.random() * 100.0);
                        }
                    }
                    if (n == 9) {
                        for (int n56 = 0; n56 < 5; ++n56) {
                            this.phys[n56] = this.rphys[n56];
                        }
                    }
                    if (n == 10) {
                        this.pfase = 1;
                        n = -1;
                    }
                    n18 = 11;
                }
                if (this.pfase == 1) {
                    for (int n57 = 0; n57 < 6; ++n57) {
                        if (n == 1 + n57 * 2) {
                            final int[] phys3 = this.phys;
                            final int n58 = n57 + 5;
                            phys3[n58] += 2;
                            if (this.phys[n57 + 5] > 100) {
                                this.phys[n57 + 5] = 100;
                            }
                        }
                        if (n == n57 * 2) {
                            final int[] phys4 = this.phys;
                            final int n59 = n57 + 5;
                            phys4[n59] -= 2;
                            if (this.phys[n57 + 5] < 0) {
                                this.phys[n57 + 5] = 0;
                            }
                        }
                    }
                    if (n == 12) {
                        for (int n60 = 0; n60 < 6; ++n60) {
                            this.phys[n60 + 5] = (int)(Math.random() * 100.0);
                        }
                    }
                    if (n == 13) {
                        for (int n61 = 0; n61 < 6; ++n61) {
                            this.phys[n61 + 5] = this.rphys[n61 + 5];
                        }
                    }
                    if (n == 14) {
                        this.pfase = 0;
                        n = -1;
                    }
                    if (n == 15) {
                        this.pfase = 2;
                        n = -1;
                    }
                    n18 = 16;
                }
                if (this.pfase == 2) {
                    for (int n62 = 0; n62 < 3; ++n62) {
                        if (n == 1 + n62 * 2) {
                            final int[] crash = this.crash;
                            final int n63 = n62;
                            crash[n63] += 2;
                            if (this.crash[n62] > 100) {
                                this.crash[n62] = 100;
                            }
                        }
                        if (n == n62 * 2) {
                            final int[] crash2 = this.crash;
                            final int n64 = n62;
                            crash2[n64] -= 2;
                            if (this.crash[n62] < 0) {
                                this.crash[n62] = 0;
                            }
                        }
                    }
                    if (n == 6) {
                        int n65 = (int)(150.0 + 600.0 * Math.random());
                        boolean b5 = false;
                        boolean b6 = false;
                        if (Math.random() > Math.random()) {
                            b5 = true;
                        }
                        if (Math.random() > Math.random()) {
                            b6 = true;
                        }
                        final int[] array10 = { -101, -101, -101, -101 };
                        array10[0] = (int)(Math.random() * 4.0);
                        if (Math.random() > Math.random()) {
                            if (b6) {
                                array10[1] = array10[0] + 1;
                            }
                            else {
                                array10[1] = array10[0] - 1;
                            }
                            if (Math.random() > Math.random()) {
                                if (b6) {
                                    array10[2] = array10[1] + 1;
                                }
                                else {
                                    array10[2] = array10[1] - 1;
                                }
                                if (Math.random() > Math.random()) {
                                    if (b6) {
                                        array10[3] = array10[2] + 1;
                                    }
                                    else {
                                        array10[3] = array10[2] - 1;
                                    }
                                }
                            }
                        }
                        if (Math.random() > Math.random()) {
                            this.crashup = false;
                        }
                        else {
                            this.crashup = true;
                        }
                        for (int n66 = 0; n66 < 4; ++n66) {
                            if (array10[n66] != -101) {
                                if (array10[n66] >= 4) {
                                    final int[] array11 = array10;
                                    final int n67 = n66;
                                    array11[n67] -= 4;
                                }
                                if (array10[n66] <= -1) {
                                    final int[] array12 = array10;
                                    final int n68 = n66;
                                    array12[n68] += 4;
                                }
                                n65 -= 50 * n66;
                                if (n65 < 150) {
                                    n65 = 150;
                                }
                                if (b5) {
                                    this.regx(array10[n66], n65, false);
                                }
                                else {
                                    this.regz(array10[n66], n65, false);
                                }
                            }
                        }
                        if (this.hitmag < 17000) {
                            if (this.crashleft) {
                                final ContO o = this.o;
                                o.xz += 22;
                            }
                            else {
                                final ContO o2 = this.o;
                                o2.xz -= 22;
                            }
                        }
                    }
                    if (n == 8) {
                        if (Math.random() > Math.random()) {
                            this.crashup = false;
                        }
                        else {
                            this.crashup = true;
                        }
                        this.roofsqsh((int)(230.0 + Math.random() * 80.0));
                    }
                    if (n == 9 || n == 7) {
                        this.setupo();
                        if (Math.random() > Math.random()) {
                            this.crashleft = false;
                        }
                        else {
                            this.crashleft = true;
                        }
                    }
                    if (n == 10) {
                        for (int n69 = 0; n69 < 3; ++n69) {
                            this.crash[n69] = this.rcrash[n69];
                        }
                    }
                    if (n == 11) {
                        this.setupo();
                        this.pfase = 1;
                        n = -1;
                    }
                    if (n == 12) {
                        if (this.crashok) {
                            this.setupo();
                            this.pfase = 3;
                            n = -1;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, this.usage[11], "Car Maker", 1);
                        }
                    }
                    n18 = 13;
                }
                if (this.pfase == 3) {
                    for (int n70 = 0; n70 < 5; ++n70) {
                        if (n == n70) {
                            for (int n71 = 0; n71 < 5; ++n71) {
                                for (int n72 = 0; n72 < 5; ++n72) {
                                    this.engs[n72][n71].stop();
                                }
                            }
                            this.engs[this.engsel][n70].loop();
                            this.engon = true;
                        }
                        if (n == 5) {
                            for (int n73 = 0; n73 < 5; ++n73) {
                                for (int n74 = 0; n74 < 5; ++n74) {
                                    this.engs[n74][n73].stop();
                                }
                            }
                            this.engon = false;
                        }
                        if (n == 6) {
                            this.pfase = 2;
                            n = -1;
                            this.engine.hide();
                        }
                        if (n == 7) {
                            this.pfase = 4;
                            n = -1;
                            this.engine.hide();
                        }
                    }
                    n18 = 8;
                }
            }
            if (this.dtab == 6) {
                if (!this.rateh) {
                    if (n == 0 && this.checko("Test Drive")) {
                        Madness.testcar = this.carname;
                        Madness.testdrive = this.witho.getSelectedIndex() + 1;
                        Madness.game();
                    }
                    n18 = 1;
                    if (this.tested) {
                        if (n == 1) {
                            this.dtab = 4;
                            n = -1;
                        }
                        if (n == 2) {
                            this.dtab = 5;
                            n = -1;
                        }
                        if (n == 3) {
                            this.rateh = true;
                            this.hidefields();
                        }
                        n18 = 4;
                    }
                }
                else {
                    if (n == 0) {
                        this.handling -= 2;
                        if (this.handling < 50) {
                            this.handling = 50;
                        }
                    }
                    if (n == 1) {
                        this.handling += 2;
                        if (this.handling > 200) {
                            this.handling = 200;
                        }
                    }
                    if (n == 2) {
                        final String string9 = "" + this.editor.getText() + "\n";
                        String s13 = "";
                        int n75 = 0;
                        int n76 = string9.indexOf("\n", 0);
                        while (n76 != -1 && n75 < string9.length()) {
                            final String trim5 = string9.substring(n75, n76).trim();
                            n75 = n76 + 1;
                            n76 = string9.indexOf("\n", n75);
                            if (!trim5.startsWith("handling(")) {
                                s13 = s13 + "" + trim5 + "\n";
                            }
                            else {
                                s13 = s13.trim() + "\n";
                            }
                        }
                        this.editor.setText(s13.trim() + "\n\n\nhandling(" + this.handling + ")\n\n\n\n");
                        this.savefile();
                        this.rateh = false;
                    }
                    if (n == 3) {
                        this.rateh = false;
                    }
                    n18 = 4;
                }
            }
            if (n == n18) {
                for (int n77 = 0; n77 < this.o.npl; ++n77) {
                    Color.RGBtoHSB(this.o.p[n77].c[0], this.o.p[n77].c[1], this.o.p[n77].c[2], this.o.p[n77].hsb);
                    if (this.o.p[n77].gr == -13) {
                        this.o.p[n77].gr = 1;
                    }
                }
                this.polynum = -1;
            }
            n = -1;
        }
        if (this.tab == 3) {
            if (n == 0) {
                if (this.logged == 0) {
                    JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Car Maker", 1);
                }
                if ((this.logged == 3 || this.logged == -1) && this.checko("Publishing")) {
                    int showConfirmDialog3 = 0;
                    for (int n78 = 0; n78 < this.pubitem.no; ++n78) {
                        if (this.pubitem.opts[n78].equals(this.carname)) {
                            showConfirmDialog3 = JOptionPane.showConfirmDialog(null, "Replace your already online car '" + this.carname + "' with this one?", "Car Maker", 0);
                        }
                    }
                    if (showConfirmDialog3 == 0) {
                        this.setCursor(new Cursor(3));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(11, 141, 679, 401);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Connecting to Server...", 350 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
                        this.repaint();
                        int n79 = 0;
                        final String string10 = "" + this.editor.getText() + "\n";
                        for (int n80 = 0, n81 = string10.indexOf("\n", 0); n81 != -1 && n80 < string10.length(); n80 = n81 + 1, n81 = string10.indexOf("\n", n80), ++n79) {}
                        this.justpubd = this.carname;
                        int n82 = -1;
                        try {
                            final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                            final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            final PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                            printWriter.println("10|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.carname + "|" + this.pubtyp.getSelectedIndex() + "|");
                            final String line2 = bufferedReader2.readLine();
                            if (line2 != null) {
                                n82 = this.servervalue(line2, 0);
                            }
                            if (n82 == 0) {
                                int n83 = 0;
                                final String string11 = "" + this.editor.getText() + "\n";
                                int n84 = 0;
                                int n85 = string11.indexOf("\n", 0);
                                while (n85 != -1 && n84 < string11.length()) {
                                    printWriter.println(string11.substring(n84, n85).trim());
                                    n84 = n85 + 1;
                                    n85 = string11.indexOf("\n", n84);
                                    ++n83;
                                    this.rd.setColor(new Color(225, 225, 225));
                                    this.rd.fillRect(11, 141, 679, 401);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Publishing Car...", 350 - this.ftm.stringWidth("Publishing Car...") / 2, 250);
                                    this.rd.setColor(new Color(119, 147, 191));
                                    this.rd.fillRect(250, 270, (int)(n83 / n79 * 200.0f), 7);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawRect(250, 270, 200, 7);
                                    this.repaint();
                                    try {
                                        final Thread thredo2 = this.thredo;
                                        Thread.sleep(10L);
                                    }
                                    catch (InterruptedException ex9) {}
                                }
                                printWriter.println("QUITX1111");
                                this.rd.setColor(new Color(225, 225, 225));
                                this.rd.fillRect(11, 141, 679, 401);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Creating the car online...", 350 - this.ftm.stringWidth("Creating the car online...") / 2, 250);
                                this.rd.drawString("This may take a couple of minutes, please wait...", 350 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                this.repaint();
                                final String line3 = bufferedReader2.readLine();
                                if (line3 != null) {
                                    n82 = this.servervalue(line3, 0);
                                }
                            }
                            socket.close();
                        }
                        catch (Exception ex10) {
                            n82 = -1;
                        }
                        this.setCursor(new Cursor(0));
                        boolean b7 = false;
                        if (n82 == 0) {
                            this.logged = 1;
                            b7 = true;
                        }
                        if (n82 == 3) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car.\nReason:\nCar name is too large.  Please rename your car.  Car name must be less then 15 characters.", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 4) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car.\nReason:  Car name used (" + this.carname + ").\nThe name '" + this.carname + "' is already used by another published car.  Please rename your car.", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 6) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nError loading 3D model!  Format maybe incorrect!", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 7) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 8) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 9) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 10) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 210.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 11) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by " + (int)((this.o.maxR / 400.0f - 1.0f) * 100.0f) + "%.\n", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 12) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by " + (int)((120.0f / this.o.maxR - 1.0f) * 100.0f) + "%.\n", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 13) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 14) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 == 15) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n", "Car Maker", 1);
                            b7 = true;
                        }
                        if (n82 > 15) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car fully!  Unknown Error.  Please try again later.\n", "Car Maker", 1);
                            b7 = true;
                        }
                        if (!b7) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car!  Unknown Error.\n", "Car Maker", 1);
                        }
                    }
                }
            }
            if (this.logged == 0) {
                if (n == 1) {
                    this.setCursor(new Cursor(3));
                    int servervalue = -1;
                    try {
                        final Socket socket2 = new Socket("multiplayer.needformadness.com", 7061);
                        final BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                        new PrintWriter(socket2.getOutputStream(), true).println("1|" + this.tnick.getText().toLowerCase() + "|" + this.tpass.getText() + "|");
                        final String line4 = bufferedReader3.readLine();
                        if (line4 != null) {
                            servervalue = this.servervalue(line4, 0);
                        }
                        socket2.close();
                    }
                    catch (Exception ex11) {
                        servervalue = -1;
                    }
                    if (servervalue == 0 || servervalue == 3 || servervalue > 10) {
                        this.tnick.hide();
                        this.tpass.hide();
                        this.logged = 1;
                        this.savesettings();
                    }
                    if (servervalue == 1 || servervalue == 2) {
                        this.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Car Maker", 0);
                    }
                    if (servervalue == -167) {
                        this.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Your trial account cannot publish cars.  Please upgrade to a full account!   ", "Car Maker", 0);
                    }
                    if (servervalue == -1) {
                        this.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                    }
                }
                if (n == 2) {
                    Madness.openurl("http://multiplayer.needformadness.com/register.html?ref=game");
                }
                if (n == 3) {
                    Madness.openurl("http://multiplayer.needformadness.com/edit.pl");
                }
            }
        }
    }

    public void setupo() {
        this.o = new ContO(this.editor.getText().getBytes(), this.m, this.t);
        this.o.x = this.ox;
        this.o.y = this.oy;
        this.o.z = this.oz;
        this.o.xz = this.oxz;
        this.o.xy = this.oxy;
        this.o.zy = this.ozy;
        this.o.shadow = true;
        this.o.tnt = 0;
        this.o.disp = 0;
        this.o.disline = 7;
        this.o.grounded = 1.0f;
        this.o.noline = false;
        this.o.decor = false;
        if (this.o.errd && (!this.o.err.startsWith("Wheels Error:") || this.forwheels)) {
            JOptionPane.showMessageDialog(null, this.o.err, "Car Maker", 0);
        }
        if (this.o.maxR == 0) {
            this.o.maxR = 100;
        }
        this.squash = 0;
        this.hitmag = 0;
    }

    public void loadfile() {
        this.loadedfile = false;
        this.lastedo = "";
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("" + Madness.fpath + "mycars/" + this.carname + ".rad")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                this.lastedo = this.lastedo + "" + line + "\n";
            }
            this.loadedfile = true;
            bufferedReader.close();
        }
        catch (Exception ex) {
            this.loadedfile = false;
            this.lastedo = "";
            JOptionPane.showMessageDialog(null, "Unable to load file! Error Deatials:\n" + ex, "Car Maker", 1);
        }
        this.editor.setText(this.lastedo);
    }

    public void savefile() {
        if (!this.editor.getText().equals("")) {
            try {
                final File file = new File("" + Madness.fpath + "mycars/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "mycars/" + this.carname + ".rad")));
                bufferedWriter.write(this.editor.getText());
                bufferedWriter.close();
                this.changed = false;
                this.lastedo = this.editor.getText();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + ex, "Car Maker", 1);
            }
        }
        this.savesettings();
    }

    public void newcar(final String carname) {
        if (carname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a Car Name!\n", "Car Maker", 1);
        }
        else {
            final String string = "\n// car: " + carname + "\n---------------------\n\n// To start making you car you must start by reading the tutorial at:\n// http://www.needformadness.com/developer/simplecar.html\n\n\n<p>\nc(100,200,100)\n\np(-40,-50,80)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-50,80)\n</p>\n\n<p>\nc(100,150,200)\n\np(-40,-20,-100)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-20,-100)\n</p>\n\n\n\n";
            try {
                final File file = new File("" + Madness.fpath + "mycars/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.carname = carname;
                final File file2 = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad");
                if (!file2.exists()) {
                    final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                    bufferedWriter.write(string);
                    bufferedWriter.close();
                    if (file2.exists()) {
                        this.sfase = 0;
                        this.hidefields();
                        this.tabed = -1;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "A car with the name '" + this.carname + "' already exists, please choose another name!\n", "Car Maker", 1);
                }
            }
            catch (Exception ex) {
                this.carname = "";
                JOptionPane.showMessageDialog(null, "Unable to create file! Error Deatials:\n" + ex, "Car Maker", 1);
            }
        }
    }

    public void delcar(final String s) {
        if (s.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select a Car to Delete!\n", "Car Maker", 1);
        }
        else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete car :  " + s + " ?  ", "Car Maker", 0) == 0) {
            try {
                new File("" + Madness.fpath + "mycars/" + s + ".rad").delete();
                this.slcar.remove(s);
                this.slcar.select(0);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + ex, "Car Maker", 1);
            }
        }
    }

    public void rencar(final String carname) {
        if (carname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a New Car Name!\n", "Car Maker", 1);
        }
        else {
            try {
                if (new File("" + Madness.fpath + "mycars/" + this.carname + ".rad").renameTo(new File("" + Madness.fpath + "mycars/" + carname + ".rad"))) {
                    this.carname = carname;
                    this.sfase = 0;
                    this.hidefields();
                    this.tabed = -1;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Unable to rename car to: '" + carname + "', possible reason: Car name already used!\n", "Car Maker", 1);
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + ex, "Car Maker", 1);
            }
        }
    }

    public void loadsettings() {
        try {
            final File file = new File("" + Madness.fpath + "mycars/settings.data");
            if (file.exists()) {
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                final String line = bufferedReader.readLine();
                if (line != null) {
                    this.scar = line;
                    this.carname = this.scar;
                }
                final String line2 = bufferedReader.readLine();
                if (line2 != null) {
                    this.suser = line2;
                    if (!this.suser.equals("Horaks")) {
                        this.tnick.setText(this.suser);
                    }
                }
                final String line3 = bufferedReader.readLine();
                if (line3 != null) {
                    this.sfont = line3;
                    this.cfont = this.sfont;
                }
                final String line4 = bufferedReader.readLine();
                if (line4 != null) {
                    this.sthm = (int) Float.valueOf(line4).floatValue();
                    this.cthm = this.sthm;
                }
                bufferedReader.close();
            }
        }
        catch (Exception ex) {}
    }

    public void savesettings() {
        if (!this.scar.equals(this.carname) || !this.suser.equals(this.tnick.getText()) || !this.sfont.equals(this.cfont) || this.cthm != this.sthm) {
            final String string = "" + this.carname + "\n" + this.tnick.getText() + "\n" + this.cfont + "\n" + this.cthm + "\n\n";
            this.scar = this.carname;
            this.suser = this.tnick.getText();
            this.sfont = this.cfont;
            this.sthm = this.cthm;
            try {
                final File file = new File("" + Madness.fpath + "mycars/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "mycars/settings.data")));
                bufferedWriter.write(string);
                bufferedWriter.close();
            }
            catch (Exception ex) {}
        }
    }

    public boolean checko(final String s) {
        this.loadfile();
        this.setupo();
        if (this.o.colok < 2) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.\n", "Car Maker", 1);
            return false;
        }
        boolean b = true;
        if (this.o.keyz[0] <= 0 || this.o.keyx[0] >= 0) {
            b = false;
        }
        if (this.o.keyz[1] <= 0 || this.o.keyx[1] <= 0) {
            b = false;
        }
        if (this.o.keyz[2] >= 0 || this.o.keyx[2] >= 0) {
            b = false;
        }
        if (this.o.keyz[3] >= 0 || this.o.keyx[3] <= 0) {
            b = false;
        }
        if (!b) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n", "Car Maker", 1);
            return false;
        }
        if (this.o.npl <= 60) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.\n", "Car Maker", 1);
            return false;
        }
        if (this.o.npl > 286) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 210.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).\n", "Car Maker", 1);
            return false;
        }
        if (this.o.maxR > 400) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by " + (int)((this.o.maxR / 400.0f - 1.0f) * 100.0f) + "%.\n", "Car Maker", 1);
            return false;
        }
        if (this.o.maxR < 120) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by " + (int)((120.0f / this.o.maxR - 1.0f) * 100.0f) + "%.\n", "Car Maker", 1);
            return false;
        }
        final String string = "" + this.editor.getText() + "\n";
        int n = 0;
        int n2 = string.indexOf("\n", 0);
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        while (n2 != -1 && n < string.length()) {
            final String trim = string.substring(n, n2).trim();
            n = n2 + 1;
            n2 = string.indexOf("\n", n);
            if (trim.startsWith("stat(")) {
                b2 = true;
                try {
                    int n3 = 0;
                    for (int i = 0; i < 5; ++i) {
                        this.stat[i] = this.getvalue("stat", trim, i);
                        if (this.stat[i] > 200) {
                            b2 = false;
                        }
                        if (this.stat[i] < 16) {
                            b2 = false;
                        }
                        n3 += this.stat[i];
                    }
                    if (n3 != 680 && n3 != 640 && n3 != 600 && n3 != 560 && n3 != 520) {
                        b2 = false;
                    }
                }
                catch (Exception ex) {
                    b2 = false;
                }
            }
            if (trim.startsWith("physics(")) {
                b3 = true;
                try {
                    for (int j = 0; j < 11; ++j) {
                        this.phys[j] = this.getvalue("physics", trim, j);
                        if (this.phys[j] > 100) {
                            b3 = false;
                        }
                        if (this.phys[j] < 0) {
                            b3 = false;
                        }
                    }
                    for (int k = 0; k < 3; ++k) {
                        this.crash[k] = this.getvalue("physics", trim, k + 11);
                        if (k != 0 && this.crash[k] > 100) {
                            b3 = false;
                        }
                        if (this.crash[k] < 0) {
                            b3 = false;
                        }
                    }
                    this.engsel = this.getvalue("physics", trim, 14);
                    if (this.engsel > 4) {
                        b3 = false;
                    }
                    if (this.engsel < 0) {
                        b3 = false;
                    }
                }
                catch (Exception ex2) {
                    b3 = false;
                }
            }
            if (trim.startsWith("handling(")) {
                b4 = true;
                try {
                    final int getvalue = this.getvalue("handling", trim, 0);
                    if (getvalue > 200) {
                        b4 = false;
                    }
                    if (getvalue >= 0) {
                        continue;
                    }
                    b4 = false;
                }
                catch (Exception ex3) {
                    b4 = false;
                }
            }
        }
        if (!b2) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n", "Car Maker", 1);
            return false;
        }
        if (!b3) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n", "Car Maker", 1);
            return false;
        }
        if (!b4 && s.equals("Publishing")) {
            JOptionPane.showMessageDialog(null, "Car is not ready for " + s + "!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n", "Car Maker", 1);
            return false;
        }
        return true;
    }

    public void regx(final int n, float n2, final boolean b) {
        this.hitmag += (int)n2;
        if (!b) {
            this.crash(n2);
        }
        n2 *= 0.3f + this.crash[1] * 0.005f;
        if (Math.abs(n2) > 100.0f) {
            int n3 = (int)(this.crash[0] * this.crash[0] * 1.5);
            if (n3 < 1000) {
                n3 = 1000;
            }
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            for (int i = 0; i < this.o.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < this.o.p[i].n; ++j) {
                    if (this.o.p[i].wz == 0 && this.py(this.o.keyx[n], this.o.p[i].ox[j], this.o.keyz[n], this.o.p[i].oz[j]) < n3) {
                        ctmag = n2 / 20.0f * this.m.random();
                        final int[] oz = this.o.p[i].oz;
                        final int n4 = j;
                        oz[n4] -= (int)(ctmag * this.m.sin(this.o.xz) * this.m.cos(this.o.zy));
                        final int[] ox = this.o.p[i].ox;
                        final int n5 = j;
                        ox[n5] += (int)(ctmag * this.m.cos(this.o.xz) * this.m.cos(this.o.xy));
                        if (b) {
                            this.actmag += (int)Math.abs(ctmag);
                        }
                    }
                }
                if (ctmag != 0.0f) {
                    if (Math.abs(ctmag) >= 1.0f) {
                        this.o.p[i].chip = 1;
                        this.o.p[i].ctmag = ctmag;
                    }
                    if (!this.o.p[i].nocol && this.o.p[i].glass != 1) {
                        if (this.o.p[i].bfase > 20 && this.o.p[i].hsb[1] > 0.25) {
                            this.o.p[i].hsb[1] = 0.25f;
                        }
                        if (this.o.p[i].bfase > 25 && this.o.p[i].hsb[2] > 0.7) {
                            this.o.p[i].hsb[2] = 0.7f;
                        }
                        if (this.o.p[i].bfase > 30 && this.o.p[i].hsb[1] > 0.15) {
                            this.o.p[i].hsb[1] = 0.15f;
                        }
                        if (this.o.p[i].bfase > 35 && this.o.p[i].hsb[2] > 0.6) {
                            this.o.p[i].hsb[2] = 0.6f;
                        }
                        if (this.o.p[i].bfase > 40) {
                            this.o.p[i].hsb[0] = 0.075f;
                        }
                        if (this.o.p[i].bfase > 50 && this.o.p[i].hsb[2] > 0.5) {
                            this.o.p[i].hsb[2] = 0.5f;
                        }
                        if (this.o.p[i].bfase > 60) {
                            this.o.p[i].hsb[0] = 0.05f;
                        }
                        final Plane plane = this.o.p[i];
                        plane.bfase += (int)Math.abs(ctmag);
                        new Color(this.o.p[i].c[0], this.o.p[i].c[1], this.o.p[i].c[2]);
                        final Color hsbColor = Color.getHSBColor(this.o.p[i].hsb[0], this.o.p[i].hsb[1], this.o.p[i].hsb[2]);
                        this.o.p[i].c[0] = hsbColor.getRed();
                        this.o.p[i].c[1] = hsbColor.getGreen();
                        this.o.p[i].c[2] = hsbColor.getBlue();
                    }
                    if (this.o.p[i].glass == 1) {
                        final Plane plane2 = this.o.p[i];
                        plane2.gr += (int)Math.abs(ctmag * 1.5);
                    }
                }
            }
        }
    }

    public void regz(final int n, float n2, final boolean b) {
        this.hitmag += (int)n2;
        if (!b) {
            this.crash(n2);
        }
        n2 *= 0.3f + this.crash[1] * 0.005f;
        if (Math.abs(n2) > 100.0f) {
            int n3 = (int)(this.crash[0] * this.crash[0] * 1.5);
            if (n3 < 1000) {
                n3 = 1000;
            }
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            for (int i = 0; i < this.o.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < this.o.p[i].n; ++j) {
                    if (this.o.p[i].wz == 0 && this.py(this.o.keyx[n], this.o.p[i].ox[j], this.o.keyz[n], this.o.p[i].oz[j]) < n3) {
                        ctmag = n2 / 20.0f * this.m.random();
                        final int[] oz = this.o.p[i].oz;
                        final int n4 = j;
                        oz[n4] += (int)(ctmag * this.m.cos(this.o.xz) * this.m.cos(this.o.zy));
                        final int[] ox = this.o.p[i].ox;
                        final int n5 = j;
                        ox[n5] += (int)(ctmag * this.m.sin(this.o.xz) * this.m.cos(this.o.xy));
                        if (b) {
                            this.actmag += (int)Math.abs(ctmag);
                        }
                    }
                }
                if (ctmag != 0.0f) {
                    if (Math.abs(ctmag) >= 1.0f) {
                        this.o.p[i].chip = 1;
                        this.o.p[i].ctmag = ctmag;
                    }
                    if (!this.o.p[i].nocol && this.o.p[i].glass != 1) {
                        if (this.o.p[i].bfase > 20 && this.o.p[i].hsb[1] > 0.25) {
                            this.o.p[i].hsb[1] = 0.25f;
                        }
                        if (this.o.p[i].bfase > 25 && this.o.p[i].hsb[2] > 0.7) {
                            this.o.p[i].hsb[2] = 0.7f;
                        }
                        if (this.o.p[i].bfase > 30 && this.o.p[i].hsb[1] > 0.15) {
                            this.o.p[i].hsb[1] = 0.15f;
                        }
                        if (this.o.p[i].bfase > 35 && this.o.p[i].hsb[2] > 0.6) {
                            this.o.p[i].hsb[2] = 0.6f;
                        }
                        if (this.o.p[i].bfase > 40) {
                            this.o.p[i].hsb[0] = 0.075f;
                        }
                        if (this.o.p[i].bfase > 50 && this.o.p[i].hsb[2] > 0.5) {
                            this.o.p[i].hsb[2] = 0.5f;
                        }
                        if (this.o.p[i].bfase > 60) {
                            this.o.p[i].hsb[0] = 0.05f;
                        }
                        final Plane plane = this.o.p[i];
                        plane.bfase += (int)Math.abs(ctmag);
                        new Color(this.o.p[i].c[0], this.o.p[i].c[1], this.o.p[i].c[2]);
                        final Color hsbColor = Color.getHSBColor(this.o.p[i].hsb[0], this.o.p[i].hsb[1], this.o.p[i].hsb[2]);
                        this.o.p[i].c[0] = hsbColor.getRed();
                        this.o.p[i].c[1] = hsbColor.getGreen();
                        this.o.p[i].c[2] = hsbColor.getBlue();
                    }
                    if (this.o.p[i].glass == 1) {
                        final Plane plane2 = this.o.p[i];
                        plane2.gr += (int)Math.abs(ctmag * 1.5);
                    }
                }
            }
        }
    }

    public void roofsqsh(float n) {
        if (n > 100.0f) {
            this.crash(n);
            n -= 100.0f;
            final int n2 = (int)(2.0 + this.crash[2] / 7.6);
            int n3 = 0;
            int n4 = 1;
            for (int i = 0; i < this.o.npl; ++i) {
                float ctmag = 0.0f;
                if (Math.random() > 0.9) {
                    ctmag = n / 15.0f * this.m.random();
                }
                for (int j = 0; j < this.o.p[i].n; ++j) {
                    if (this.o.p[i].wz == 0 && (Math.abs(this.o.p[i].oy[j] - this.o.roofat - this.squash) < n2 * 3 || this.o.p[i].oy[j] < this.o.roofat + this.squash) && this.squash < n2) {
                        ctmag = n / 15.0f * this.m.random();
                        final int[] oy = this.o.p[i].oy;
                        final int n5 = j;
                        oy[n5] += (int)ctmag;
                        n3 += (int)ctmag;
                        ++n4;
                        this.hitmag += (int)Math.abs(ctmag);
                    }
                }
                if (!this.o.p[i].nocol && this.o.p[i].glass != 1) {
                    if (ctmag != 0.0f) {
                        if (this.o.p[i].bfase > 20 && this.o.p[i].hsb[1] > 0.25) {
                            this.o.p[i].hsb[1] = 0.25f;
                        }
                        if (this.o.p[i].bfase > 25 && this.o.p[i].hsb[2] > 0.7) {
                            this.o.p[i].hsb[2] = 0.7f;
                        }
                        if (this.o.p[i].bfase > 30 && this.o.p[i].hsb[1] > 0.15) {
                            this.o.p[i].hsb[1] = 0.15f;
                        }
                        if (this.o.p[i].bfase > 35 && this.o.p[i].hsb[2] > 0.6) {
                            this.o.p[i].hsb[2] = 0.6f;
                        }
                        if (this.o.p[i].bfase > 40) {
                            this.o.p[i].hsb[0] = 0.075f;
                        }
                        if (this.o.p[i].bfase > 50 && this.o.p[i].hsb[2] > 0.5) {
                            this.o.p[i].hsb[2] = 0.5f;
                        }
                        if (this.o.p[i].bfase > 60) {
                            this.o.p[i].hsb[0] = 0.05f;
                        }
                        final Plane plane = this.o.p[i];
                        plane.bfase += (int)ctmag;
                        new Color(this.o.p[i].c[0], this.o.p[i].c[1], this.o.p[i].c[2]);
                        final Color hsbColor = Color.getHSBColor(this.o.p[i].hsb[0], this.o.p[i].hsb[1], this.o.p[i].hsb[2]);
                        this.o.p[i].c[0] = hsbColor.getRed();
                        this.o.p[i].c[1] = hsbColor.getGreen();
                        this.o.p[i].c[2] = hsbColor.getBlue();
                    }
                }
                else if (this.o.p[i].glass == 1) {
                    final Plane plane2 = this.o.p[i];
                    plane2.gr += 5;
                }
                if (Math.abs(ctmag) >= 1.0f) {
                    this.o.p[i].chip = 1;
                    this.o.p[i].ctmag = ctmag;
                }
            }
            this.squash += n3 / n4;
        }
    }

    public void crash(float n) {
        if (n > 100.0f) {
            n -= 100.0f;
        }
        if (n < -100.0f) {
            n += 100.0f;
        }
        if (Math.abs(n) > 25.0f && Math.abs(n) < 170.0f) {
            this.lowcrashs[this.crshturn].play();
        }
        if (Math.abs(n) >= 170.0f) {
            this.crashs[this.crshturn].play();
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

    public void setheme() {
        if (this.cthm == 0) {
            this.editor.setForeground(this.deff);
            this.editor.setBackground(this.defb);
        }
        if (this.cthm == 1) {
            this.editor.setForeground(new Color(0, 0, 0));
            this.editor.setBackground(new Color(192, 192, 192));
        }
        if (this.cthm == 2) {
            this.editor.setForeground(new Color(192, 192, 192));
            this.editor.setBackground(new Color(0, 0, 0));
        }
        if (this.cthm == 3) {
            this.editor.setForeground(new Color(0, 0, 0));
            this.editor.setBackground(new Color(50, 200, 0));
        }
        if (this.cthm == 4) {
            this.editor.setForeground(new Color(67, 255, 77));
            this.editor.setBackground(new Color(0, 0, 0));
        }
        if (this.cthm == 5) {
            this.editor.setForeground(new Color(0, 172, 255));
            this.editor.setBackground(new Color(210, 234, 255));
        }
        if (this.cthm == 6) {
            this.editor.setForeground(new Color(255, 230, 0));
            this.editor.setBackground(new Color(255, 77, 67));
        }
        if (this.cthm == 7) {
            this.editor.setForeground(new Color(0, 159, 255));
            this.editor.setBackground(new Color(9, 47, 104));
        }
    }

    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
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

    @Override
    public void init() {
        this.setBackground(new Color(0, 0, 0));
        this.offImage = this.createImage(700, 550);
        if (this.offImage != null) {
            this.rd = (Graphics2D)this.offImage.getGraphics();
        }
        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        boolean b = true;
        if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1 || System.getProperty("java.vendor").toLowerCase().indexOf("sun") != -1) {
            b = false;
        }
        this.setLayout(null);
        this.slcar.setFont(new Font("Arial", 1, 13));
        this.slcar.add(this.rd, "Select a Car...         ");
        this.slcar.setForeground(new Color(63, 80, 110));
        this.slcar.setBackground(new Color(209, 217, 230));
        this.fontsel.setFont(new Font("Arial", 1, 12));
        this.fontsel.add(this.rd, "Arial");
        this.fontsel.add(this.rd, "Dialog");
        this.fontsel.add(this.rd, "DialogInput");
        this.fontsel.add(this.rd, "Monospaced");
        this.fontsel.add(this.rd, "Serif");
        this.fontsel.add(this.rd, "SansSerif");
        this.fontsel.add(this.rd, "Verdana");
        this.fontsel.setBackground(new Color(63, 80, 110));
        this.fontsel.setForeground(new Color(209, 217, 230));
        this.ctheme.setFont(new Font("Arial", 1, 12));
        this.ctheme.add(this.rd, "Default");
        this.ctheme.add(this.rd, "Author");
        this.ctheme.add(this.rd, "Dos");
        this.ctheme.add(this.rd, "Green");
        this.ctheme.add(this.rd, "The Matrix");
        this.ctheme.add(this.rd, "Ice Age");
        this.ctheme.add(this.rd, "Fire");
        this.ctheme.add(this.rd, "Ocean");
        this.ctheme.setBackground(new Color(63, 80, 110));
        this.ctheme.setForeground(new Color(209, 217, 230));
        this.compcar.setFont(new Font("Arial", 1, 12));
        this.compcar.add(this.rd, "Compare Car...");
        this.compcar.add(this.rd, "Tornado Shark");
        this.compcar.add(this.rd, "Formula 7");
        this.compcar.add(this.rd, "Wow Caninaro");
        this.compcar.add(this.rd, "La Vita Crab");
        this.compcar.add(this.rd, "Nimi");
        this.compcar.add(this.rd, "MAX Revenge");
        this.compcar.add(this.rd, "Lead Oxide");
        this.compcar.add(this.rd, "Kool Kat");
        this.compcar.add(this.rd, "Drifter X");
        this.compcar.add(this.rd, "Sword of Justice");
        this.compcar.add(this.rd, "High Rider");
        this.compcar.add(this.rd, "EL KING");
        this.compcar.add(this.rd, "Mighty Eight");
        this.compcar.add(this.rd, "M A S H E E N");
        this.compcar.add(this.rd, "Radical One");
        this.compcar.add(this.rd, "DR Monstaa");
        this.compcar.add(this.rd, " -  None  - ");
        this.compcar.setBackground(new Color(63, 80, 110));
        this.compcar.setForeground(new Color(209, 217, 230));
        this.cls.setFont(new Font("Arial", 1, 12));
        this.cls.add(this.rd, "Class A");
        this.cls.add(this.rd, "Class A & B");
        this.cls.add(this.rd, "Class B");
        this.cls.add(this.rd, "Class B & C");
        this.cls.add(this.rd, "Class C");
        this.cls.setBackground(new Color(63, 80, 110));
        this.cls.setForeground(new Color(209, 217, 230));
        this.simcar.setFont(new Font("Arial", 1, 12));
        this.simcar.add(this.rd, "Tornado Shark");
        this.simcar.add(this.rd, "Formula 7");
        this.simcar.add(this.rd, "Wow Caninaro");
        this.simcar.add(this.rd, "La Vita Crab");
        this.simcar.add(this.rd, "Nimi");
        this.simcar.add(this.rd, "MAX Revenge");
        this.simcar.add(this.rd, "Lead Oxide");
        this.simcar.add(this.rd, "Kool Kat");
        this.simcar.add(this.rd, "Drifter X");
        this.simcar.add(this.rd, "Sword of Justice");
        this.simcar.add(this.rd, "High Rider");
        this.simcar.add(this.rd, "EL KING");
        this.simcar.add(this.rd, "Mighty Eight");
        this.simcar.add(this.rd, "M A S H E E N");
        this.simcar.add(this.rd, "Radical One");
        this.simcar.add(this.rd, "DR Monstaa");
        this.simcar.setBackground(new Color(63, 80, 110));
        this.simcar.setForeground(new Color(209, 217, 230));
        this.witho.setFont(new Font("Arial", 1, 12));
        this.witho.add(this.rd, "With other cars");
        this.witho.add(this.rd, "Alone");
        this.witho.setBackground(new Color(63, 80, 110));
        this.witho.setForeground(new Color(209, 217, 230));
        this.engine.setFont(new Font("Arial", 1, 12));
        this.engine.add(this.rd, "Normal Engine");
        this.engine.add(this.rd, "V8 Engine");
        this.engine.add(this.rd, "Retro Engine");
        this.engine.add(this.rd, "Power Engine");
        this.engine.add(this.rd, "Diesel Engine");
        this.engine.setBackground(new Color(63, 80, 110));
        this.engine.setForeground(new Color(209, 217, 230));
        final MenuItem menuItem = new MenuItem("Cut");
        final MenuItem menuItem2 = new MenuItem("Copy");
        final MenuItem menuItem3 = new MenuItem("Paste");
        final MenuItem menuItem4 = new MenuItem("Select All");
        (this.popupMenu = new PopupMenu()).add(menuItem);
        this.popupMenu.add(menuItem2);
        this.popupMenu.add(menuItem3);
        this.popupMenu.add(menuItem4);
        menuItem.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        this.add(this.popupMenu);
        for (int i = 0; i < 16; ++i) {
            (this.wv[i] = new TextField("", 2)).setBackground(new Color(255, 255, 255));
            this.wv[i].setForeground(new Color(0, 0, 0));
            this.wv[i].setFont(new Font(this.cfont, 1, 14));
            if (b) {
                this.wv[i].addMouseListener(new MouseHandler(this.popupMenu, i));
            }
            this.add(this.wv[i]);
        }
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
        this.pubitem.add(this.rd, "Account Cars");
        this.pubitem.setBackground(new Color(209, 217, 230));
        this.pubitem.setForeground(new Color(63, 80, 110));
        this.srch.setBackground(new Color(255, 255, 255));
        this.srch.setForeground(new Color(0, 0, 0));
        if (b) {
            this.srch.addMouseListener(new MouseHandler(this.popupMenu, 16));
        }
        this.rplc.setBackground(new Color(255, 255, 255));
        this.rplc.setForeground(new Color(0, 0, 0));
        if (b) {
            this.rplc.addMouseListener(new MouseHandler(this.popupMenu, 17));
        }
        if (b) {
            this.editor.addMouseListener(new MouseHandler(this.popupMenu, 18));
        }
        this.add(this.tnick);
        this.add(this.tpass);
        this.add(this.editor);
        this.add(this.srch);
        this.add(this.rplc);
        this.defb = new Color(255, 255, 255);
        this.deff = new Color(0, 0, 0);
        this.hidefields();
    }

    public void hidefields() {
        this.pubtyp.hide();
        this.pubitem.hide();
        this.tpass.hide();
        this.tnick.hide();
        this.slcar.hide();
        this.witho.hide();
        for (int i = 0; i < 16; ++i) {
            this.wv[i].hide();
        }
        this.simcar.hide();
        this.engine.hide();
        this.cls.hide();
        this.compcar.hide();
        this.editor.hide();
        this.fontsel.hide();
        this.ctheme.hide();
        this.srch.hide();
        this.rplc.hide();
    }

    public void movefield(final Component component, int n, int n2, final int n3, final int n4) {
        n += this.apx;
        n2 += this.apy;
        if (component.getX() != n || component.getY() != n2 || component.getWidth() != n3 || component.getHeight() != n4) {
            component.setBounds(n, n2, n3, n4);
        }
    }

    public void drawms() {
        this.openm = false;
        if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            this.openm = true;
        }
        if (this.pubitem.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            this.openm = true;
        }
        if (this.fontsel.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            this.openm = true;
        }
        if (this.ctheme.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            this.openm = true;
        }
        if (this.compcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            this.openm = true;
        }
        if (this.cls.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            this.openm = true;
        }
        if (this.simcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            this.openm = true;
        }
        if (this.engine.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            this.openm = true;
        }
        if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
            this.openm = true;
        }
        if (this.slcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            this.openm = true;
        }
        if (this.openm) {
            this.waso = true;
            this.mouses = 0;
        }
    }

    public void openlink() {
        Madness.openurl("http://www.needformadness.com/developer/simplecar.html");
    }

    public void openhlink() {
        Madness.openurl("http://www.needformadness.com/developer/");
    }

    public void openelink() {
        Madness.openurl("http://www.needformadness.com/developer/extras.html");
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
        this.apx = this.getWidth() / 2 - 350;
        this.apy = this.getHeight() / 2 - 275;
        graphics.drawImage(this.offImage, this.apx, this.apy, this);
    }

    @Override
    public void update(final Graphics graphics) {
        this.paint(graphics);
    }

    @Override
    public boolean mouseUp(final Event event, final int n, final int n2) {
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        if (this.waso) {
            this.waso = false;
        }
        else {
            this.mouses = -1;
        }
        this.mousdr = false;
        if (this.onbtgame) {
            Madness.game();
        }
        return false;
    }

    @Override
    public boolean mouseDown(final Event event, final int n, final int n2) {
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        this.mouses = 1;
        this.mousdr = true;
        if (this.tab != 1) {
            this.requestFocus();
        }
        return false;
    }

    @Override
    public boolean mouseMove(final Event event, final int n, final int n2) {
        this.xm = n - this.apx;
        this.ym = n2 - this.apy;
        if (this.xm > 520 && this.xm < 674 && this.ym > 0 && this.ym < 23) {
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
    public boolean lostFocus(final Event event, final Object o) {
        return this.focuson = false;
    }

    @Override
    public boolean gotFocus(final Event event, final Object o) {
        this.focuson = true;
        return false;
    }

    @Override
    public boolean keyDown(final Event event, final int n) {
        if (this.focuson) {
            if (n == 54 || n == 46 || n == 100 || n == 68) {
                this.rotr = true;
            }
            if (n == 52 || n == 44 || n == 97 || n == 65) {
                this.rotl = true;
            }
            if (n == 43 || n == 61) {
                this.plus = true;
            }
            if (n == 45) {
                this.minus = true;
            }
            if (n == 42 || n == 10 || n == 56 || n == 119 || n == 87) {
                this.in = true;
            }
            if (n == 47 || n == 8 || n == 50 || n == 115 || n == 83) {
                this.out = true;
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
        if (n == 54 || n == 46 || n == 100 || n == 68) {
            this.rotr = false;
        }
        if (n == 52 || n == 44 || n == 97 || n == 65) {
            this.rotl = false;
        }
        if (n == 43 || n == 61) {
            this.plus = false;
        }
        if (n == 45) {
            this.minus = false;
        }
        if (n == 42 || n == 10 || n == 56 || n == 119 || n == 97) {
            this.in = false;
        }
        if (n == 47 || n == 8 || n == 50 || n == 115 || n == 83) {
            this.out = false;
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

    public void loadsounds() {
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
                for (int l = 0; l < 3; ++l) {
                    if (name.equals("crash" + (l + 1) + ".wav")) {
                        this.crashs[l] = new soundClip(array);
                    }
                }
                for (int n2 = 0; n2 < 3; ++n2) {
                    if (name.equals("lowcrash" + (n2 + 1) + ".wav")) {
                        this.lowcrashs[n2] = new soundClip(array);
                    }
                }
            }
            fileInputStream.close();
            zipInputStream.close();
        }
        catch (Exception ex) {
            System.out.println("Error Loading Sounds: " + ex);
        }
        System.gc();
    }

    public void loadbase() {
        final String[] array = { "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster" };
        try {
            final ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File("" + Madness.fpath + "data/models.zip")));
            for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
                int n = -1;
                for (int i = 0; i < 16; ++i) {
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
                    this.compo[n] = new ContO(array2, this.m, this.t);
                    this.compo[n].shadow = false;
                    this.compo[n].noline = true;
                }
            }
            zipInputStream.close();
        }
        catch (Exception ex) {
            System.out.println("Error Loading Models from Zip: " + ex);
        }
        System.gc();
    }

    public void fixtext(final TextField textField) {
        final String replace = textField.getText().replace('\"', '#');
        final String s = "\\";
        String string = "";
        int i = 0;
        int n = -1;
        while (i < replace.length()) {
            final String string2 = "" + replace.charAt(i);
            if (string2.equals("|") || string2.equals(",") || string2.equals("(") || string2.equals(")") || string2.equals("#") || string2.equals(s) || string2.equals("!") || string2.equals("?") || string2.equals("~") || string2.equals(".") || string2.equals("@") || string2.equals("$") || string2.equals("%") || string2.equals("^") || string2.equals("&") || string2.equals("*") || string2.equals("+") || string2.equals("=") || string2.equals(">") || string2.equals("<") || string2.equals("/") || string2.equals("'") || string2.equals(";") || string2.equals(":") || i > 15) {
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

    public int objvalue(final String s, final int n) {
        int n2 = 0;
        try {
            int n3 = 2;
            int n4 = 0;
            int n5 = 0;
            String s2 = "";
            int n6 = 0;
            while (n3 < s.length() && n5 != 2) {
                final String string = "" + s.charAt(n3);
                if (string.equals(" ")) {
                    if (n6 != 0) {
                        ++n4;
                        n6 = 0;
                    }
                    if (n5 == 1 || n4 > n) {
                        n5 = 2;
                    }
                }
                else {
                    if (n4 == n) {
                        s2 += string;
                        n5 = 1;
                    }
                    n6 = 1;
                }
                ++n3;
            }
            if (n3 >= s.length()) {
                this.objfacend = true;
            }
            if (s2.equals("")) {
                s2 = "0";
            }
            if (this.multf10) {
                n2 = (int)(Float.valueOf(s2) * 10.0f);
            }
            else {
                final int index = s2.indexOf("/", 0);
                if (index != -1) {
                    s2 = s2.substring(0, index);
                }
                n2 = (int) Float.valueOf(s2).floatValue() - 1;
                if (n2 < 0) {
                    n2 = 0;
                }
            }
        }
        catch (Exception ex) {}
        return n2;
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

    public void stringbutton(final String s, final int n, final int n2, final int n3, final boolean b) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        if (s.indexOf("Publish") != -1) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
        }
        this.bx[this.btn] = n;
        this.by[this.btn] = n2 - 5;
        this.bw[this.btn] = this.ftm.stringWidth(s);
        if (!this.pessd[this.btn]) {
            this.rd.setColor(new Color(220, 220, 220));
            if (b) {
                this.rd.setColor(new Color(230, 230, 230));
            }
            this.rd.fillRect(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), this.bw[this.btn] + 20, 25 - n3 * 2);
            this.rd.setColor(new Color(240, 240, 240));
            if (b) {
                this.rd.setColor(new Color(255, 255, 255));
            }
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (18 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (18 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 - (19 - n3), n + this.bw[this.btn] / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            if (b) {
                this.rd.setColor(new Color(192, 192, 192));
            }
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 11, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 11, n2 + (7 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 12, n2 - (16 - n3), n + this.bw[this.btn] / 2 + 12, n2 + (6 - n3));
            if (b) {
                this.rd.setColor(new Color(192, 192, 192));
            }
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (8 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (8 - n3));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 + (9 - n3), n + this.bw[this.btn] / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            if (b) {
                this.rd.setColor(new Color(255, 255, 255));
            }
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 11, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 11, n2 + (7 - n3));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 12, n2 - (16 - n3), n - this.bw[this.btn] / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, n - this.bw[this.btn] / 2, n2);
        }
        else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), this.bw[this.btn] + 20, 25 - n3 * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (18 - n3), n + this.bw[this.btn] / 2 + 10, n2 - (18 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 - (19 - n3), n + this.bw[this.btn] / 2 + 9, n2 - (19 - n3));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 10, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 11, n2 - (17 - n3), n + this.bw[this.btn] / 2 + 11, n2 + (7 - n3));
            this.rd.drawLine(n + this.bw[this.btn] / 2 + 12, n2 - (16 - n3), n + this.bw[this.btn] / 2 + 12, n2 + (6 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 + (8 - n3), n + this.bw[this.btn] / 2 + 10, n2 + (8 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 9, n2 + (9 - n3), n + this.bw[this.btn] / 2 + 9, n2 + (9 - n3));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 10, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 10, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 11, n2 - (17 - n3), n - this.bw[this.btn] / 2 - 11, n2 + (7 - n3));
            this.rd.drawLine(n - this.bw[this.btn] / 2 - 12, n2 - (16 - n3), n - this.bw[this.btn] / 2 - 12, n2 + (6 - n3));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, n - this.bw[this.btn] / 2 + 1, n2 + 1);
        }
        ++this.btn;
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

    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        TextComponent textComponent = this.wv[0];
        if (Madness.textid >= 0 && Madness.textid <= 15) {
            textComponent = this.wv[Madness.textid];
        }
        if (Madness.textid == 16) {
            textComponent = this.srch;
        }
        if (Madness.textid == 17) {
            textComponent = this.rplc;
        }
        if (Madness.textid == 18) {
            textComponent = this.editor;
        }
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Cut")) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(textComponent.getSelectedText()), null);
            if (Madness.textid == 18) {
                this.editor.replaceText("", this.editor.getSelectionStart(), this.editor.getSelectionEnd());
            }
            else {
                textComponent.setText(textComponent.getText().substring(0, textComponent.getSelectionStart()) + textComponent.getText().substring(textComponent.getSelectionEnd(), textComponent.getText().length()));
            }
        }
        if (actionCommand.equals("Copy")) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(textComponent.getSelectedText()), null);
        }
        if (actionCommand.equals("Paste")) {
            try {
                final String s = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                if (Madness.textid == 18) {
                    this.editor.replaceText(s, this.editor.getSelectionStart(), this.editor.getSelectionEnd());
                }
                else {
                    textComponent.setText(textComponent.getText().substring(0, textComponent.getSelectionStart()) + s + textComponent.getText().substring(textComponent.getSelectionEnd(), textComponent.getText().length()));
                }
            }
            catch (Exception ex) {}
        }
        if (actionCommand.equals("Select All")) {
            textComponent.selectAll();
        }
    }
}
