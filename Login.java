import java.awt.TextField;
import java.awt.Image;
import java.awt.Component;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.net.DatagramPacket;
import java.util.Date;
import java.awt.Cursor;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.net.URL;
import java.awt.Color;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.awt.image.ImageObserver;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Login implements Runnable
{
    Graphics2D rd;
    xtGraphics xt;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    int nmsgs;
    int nconf;
    int nfreq;
    int ncreq;
    int fclan;
    int fplayer;
    String clanapv;
    boolean justlog;
    int cntgame;
    int gamec;
    int groom;
    String gmaker;
    String gservern;
    Thread connector;
    int fase;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    boolean[] pessd;
    int[] bx;
    int[] by;
    int[] bw;
    int btn;
    int nflk;
    int ncnt;
    int errcnt;
    int lrgfase;
    String msg;
    String lnick;
    String lpass;
    String lemail;
    boolean onf;
    boolean nickero;
    boolean jflk;
    boolean ond;
    int opselect;
    int trans;
    int cntcl;
    boolean contrb;
    int nservers;
    String[] servers;
    InetAddress[] IPAddress;
    DatagramSocket[] dSocket;
    int[] serverdone;
    long[] servestart;
    String[] snames;
    boolean socketson;
    int srvtrn;
    int[] rmps;
    int[] rmwt;
    int recom;
    boolean resofaso;
    boolean checknote;
    int pend;
    boolean pendb;
    boolean gotcai;
    int cax;
    int cay;
    boolean btroom;
    boolean showtf;
    int[] bgmy;
    int flipo;
    int xrl;
    int xrr;
    boolean onr;
    int oxm;
    int oym;
    int lxm;
    int lym;

    public Login(final Medium m, final Graphics2D rd, final xtGraphics xt, final GameSparker gs) {
        this.nmsgs = 0;
        this.nconf = 0;
        this.nfreq = 0;
        this.ncreq = 0;
        this.fclan = 0;
        this.fplayer = 0;
        this.clanapv = "";
        this.justlog = false;
        this.cntgame = 0;
        this.gamec = -1;
        this.groom = 0;
        this.gmaker = "";
        this.gservern = "";
        this.fase = 0;
        this.pessd = new boolean[] { false, false, false, false, false, false };
        this.bx = new int[] { 0, 0, 0, 0, 0, 0 };
        this.by = new int[] { 0, 0, 0, 0, 0, 0 };
        this.bw = new int[] { 0, 0, 0, 0, 0, 0 };
        this.btn = 0;
        this.nflk = 0;
        this.ncnt = 0;
        this.errcnt = 0;
        this.lrgfase = 0;
        this.msg = "";
        this.lnick = "";
        this.lpass = "";
        this.lemail = "";
        this.onf = false;
        this.nickero = false;
        this.jflk = false;
        this.ond = false;
        this.opselect = 0;
        this.trans = 0;
        this.cntcl = 0;
        this.contrb = false;
        this.nservers = 2;
        this.servers = new String[] { "multiplayer.needformadness.com", "avenger.needformadness.com", "ghostrider.needformadness.com" };
        this.IPAddress = new InetAddress[3];
        this.dSocket = new DatagramSocket[3];
        this.serverdone = new int[] { -1, -1, -1 };
        this.servestart = new long[] { 0L, 0L, 0L };
        this.snames = new String[] { "Dominion", "Avenger", "Ghostrider" };
        this.socketson = false;
        this.srvtrn = 0;
        this.rmps = new int[] { 0, 0, 0, 0, 0 };
        this.rmwt = new int[] { 0, 0, 0, 0, 0 };
        this.recom = 0;
        this.resofaso = false;
        this.checknote = false;
        this.pend = 0;
        this.pendb = false;
        this.gotcai = false;
        this.cax = 0;
        this.cay = 0;
        this.btroom = false;
        this.showtf = false;
        this.bgmy = new int[] { 0, 400, 800 };
        this.flipo = 0;
        this.xrl = 0;
        this.xrr = 0;
        this.onr = false;
        this.oxm = 0;
        this.oym = 0;
        this.lxm = 0;
        this.lym = 0;
        this.m = m;
        this.rd = rd;
        this.xt = xt;
        this.gs = gs;
        if (this.xt.playingame != -1) {
            this.fase = 18;
        }
        if (this.xt.nofull) {
            this.nservers = 1;
        }
    }

    public void inishmulti() {
        this.gs.tnick.setVisible(false);
        this.gs.tnick.setEnabled(true);
        this.gs.tnick.setForeground(new Color(0, 0, 0));
        this.gs.tnick.setBackground(this.color2k(240, 240, 240));
        this.gs.tpass.setVisible(false);
        this.gs.tpass.setEnabled(true);
        this.gs.tpass.setForeground(new Color(0, 0, 0));
        this.gs.tpass.setBackground(this.color2k(240, 240, 240));
        this.gs.temail.setVisible(false);
        this.gs.temail.setEnabled(true);
        this.gs.temail.setForeground(new Color(0, 0, 0));
        this.gs.temail.setBackground(this.color2k(240, 240, 240));
        this.gs.keplo.setVisible(false);
        this.gs.keplo.setEnabled(true);
        this.gs.keplo.setForeground(new Color(0, 0, 0));
        this.gs.keplo.setBackground(new Color(193, 181, 142));
        this.gs.requestFocus();
        if (this.gs.tnick.getText().equals("")) {
            this.gs.tnick.setText("Nickname");
        }
        for (int i = 0; i < 6; ++i) {
            this.pessd[i] = false;
        }
        this.nflk = 0;
        this.ncnt = 0;
        this.errcnt = 0;
        this.onf = false;
        this.ond = false;
        this.msg = "";
        this.btroom = false;
        this.gotcai = false;
        this.m.crs = true;
        this.m.x = -335;
        this.m.y = 0;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 20;
        this.m.ground = -2000;
        this.pend = 0;
        this.pendb = false;
        this.resofaso = false;
        for (int j = 0; j < this.nservers; ++j) {
            this.serverdone[j] = -1;
            this.servestart[j] = 0L;
        }
        this.checknote = false;
        if (this.xt.gotlog) {
            this.checknote = true;
            this.socketson = false;
            this.fase = 12;
            (this.connector = new Thread(this)).start();
        }
        else {
            this.msg = "Login to access the multiplayer madness!";
            this.gs.tnick.setText(this.xt.nickname);
            this.fase = 3;
        }
    }

    public void exitfromlobby() {
        if (!this.xt.lan) {
            this.opselect = 0;
        }
        else {
            this.opselect = 1;
        }
        for (int i = 0; i < this.nservers; ++i) {
            this.serverdone[i] = -1;
            this.servestart[i] = 0L;
        }
        for (int j = 0; j < 6; ++j) {
            this.pessd[j] = false;
        }
        this.gotcai = false;
        this.btroom = false;
        this.m.crs = true;
        this.m.x = -335;
        this.m.y = 0;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 20;
        this.m.ground = -2000;
        this.pend = 0;
        this.pendb = false;
        this.gamec = -1;
        this.socketson = false;
        if (!this.xt.lan) {
            this.msg = "| Connecting to Servers |";
            this.trans = 0;
            this.fase = 13;
            this.nflk = 0;
        }
        else {
            this.fase = 12;
        }
        System.gc();
        (this.connector = new Thread(this)).start();
    }

    public void endcons() {
        for (int i = 0; i < this.nservers; ++i) {
            try {
                this.dSocket[i].close();
                this.dSocket[i] = null;
            }
            catch (Exception ex) {}
        }
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
        }
        catch (Exception ex2) {}
    }

    public void checknotifcations() {
        int nmsgs = 0;
        int fclan = 0;
        int fplayer = 0;
        int nfreq = 0;
        int nconf = 0;
        String svalue = "";
        int ncreq = 0;
        try {
            final URL url = new URL("http://multiplayer.needformadness.com/profiles/" + this.xt.nickname + "/notify.txt?req=" + (int)(Math.random() * 1000.0) + "");
            url.openConnection().setConnectTimeout(2000);
            if (url.openConnection().getContentType().equals("text/plain")) {
                final DataInputStream dataInputStream = new DataInputStream(url.openStream());
                String line;
                for (int n = 0; (line = dataInputStream.readLine()) != null && n < 5; ++n) {
                    final String trim = line.trim();
                    if (n == 0) {
                        for (String s = this.getSvalue(trim, nmsgs); !s.equals(""); s = this.getSvalue(trim, nmsgs)) {
                            if (s.startsWith("clan: ")) {
                                ++fclan;
                            }
                            else if (!s.startsWith("your clan")) {
                                ++fplayer;
                            }
                            ++nmsgs;
                        }
                    }
                    if (n == 1) {
                        int intValue;
                        try {
                            intValue = Integer.valueOf(trim);
                        }
                        catch (Exception ex) {
                            intValue = 0;
                        }
                        nfreq = intValue;
                    }
                    if (n == 2) {
                        int intValue2;
                        try {
                            intValue2 = Integer.valueOf(trim);
                        }
                        catch (Exception ex2) {
                            intValue2 = 0;
                        }
                        nconf = intValue2;
                    }
                    if (n == 3) {
                        svalue = this.getSvalue(trim, 0);
                    }
                    if (n == 4) {
                        for (String s2 = this.getSvalue(trim, ncreq); !s2.equals(""); s2 = this.getSvalue(trim, ncreq)) {
                            ++ncreq;
                        }
                    }
                }
                dataInputStream.close();
            }
        }
        catch (Exception ex3) {}
        this.nmsgs = nmsgs;
        this.fclan = fclan;
        this.fplayer = fplayer;
        this.nfreq = nfreq;
        this.nconf = nconf;
        this.clanapv = svalue;
        this.ncreq = ncreq;
    }

    public void gamealert() {
        try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("101|20|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.xt.servername + "|" + (this.xt.servport - 7070) + "|");
            this.din.readLine();
            this.socket.close();
            this.din.close();
            this.dout.close();
        }
        catch (Exception ex) {}
    }

    public void checkgamealerts() {
        try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("101|21|");
            final String line = this.din.readLine();
            if (line != null) {
                final int getvalue = this.getvalue(line, 0);
                if (getvalue != -1 && getvalue != this.gamec) {
                    final String svalue = this.getSvalue(line, 2);
                    final int getvalue2 = this.getvalue(line, 3);
                    boolean b = false;
                    if (!svalue.equals(this.xt.servername) || getvalue2 != this.xt.servport - 7070) {
                        for (int i = 0; i < this.nservers; ++i) {
                            if (svalue.equals(this.snames[i]) && this.xt.delays[i] < 300) {
                                b = true;
                            }
                        }
                    }
                    if (b) {
                        this.gmaker = this.getSvalue(line, 1);
                        if (this.gmaker.equals(this.xt.nickname)) {
                            this.gmaker = "You";
                        }
                        this.groom = getvalue2;
                        this.gservern = svalue;
                        this.gamec = getvalue;
                        this.cntgame = 0;
                    }
                }
            }
            this.socket.close();
            this.din.close();
            this.dout.close();
        }
        catch (Exception ex) {}
    }

    @Override
    public void run() {
        if (this.checknote) {
            this.checknotifcations();
            this.checknote = false;
        }
        if (this.fase == 2) {
            this.gs.setCursor(new Cursor(3));
            int getvalue = -1;
            int getvalue2 = -1;
            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("0|" + this.gs.tnick.getText() + "|");
                final String line = this.din.readLine();
                if (line != null) {
                    getvalue = this.getvalue(line, 0);
                    if (getvalue == 0) {
                        getvalue2 = this.getvalue(line, 1);
                        this.xt.hours = this.getvalue(line, 2);
                        this.xt.nickey = this.getSvalue(line, 3);
                    }
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            }
            catch (Exception ex) {}
            this.gs.tnick.setEnabled(true);
            if (getvalue == -1) {
                this.msg = "Unable to connect to any server at this moment.  Please try again later.";
                this.fase = 1;
            }
            if (getvalue == 0) {
                this.xt.nickname = this.gs.tnick.getText();
                if (getvalue2 != -1) {
                    this.xt.nfreeplays = getvalue2;
                }
                this.gs.tnick.setVisible(false);
                this.gs.tpass.setVisible(false);
                this.gs.temail.setVisible(false);
                this.gs.keplo.setVisible(false);
                this.gs.requestFocus();
                this.xt.logged = false;
                this.fase = 12;
                System.gc();
            }
            if (getvalue == 1) {
                this.msg = "This Nickname is being used by someone else right now.  Please use another.";
                this.nickero = true;
                this.gs.tnick.setForeground(new Color(255, 0, 0));
                this.gs.tnick.requestFocus();
                this.errcnt = 30;
                this.fase = 1;
            }
            if (getvalue == 2) {
                this.msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
                this.nickero = true;
                this.gs.tnick.setForeground(new Color(255, 0, 0));
                this.gs.tnick.requestFocus();
                this.errcnt = 30;
                this.fase = 1;
            }
            this.gs.setCursor(new Cursor(0));
        }
        if (this.fase == 4) {
            this.gs.setCursor(new Cursor(3));
            int getvalue3 = -1;
            int getvalue4 = -1;
            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
                final String line2 = this.din.readLine();
                if (line2 != null) {
                    getvalue3 = this.getvalue(line2, 0);
                    if (getvalue3 == 0 || getvalue3 == 3 || getvalue3 > 10 || getvalue3 == -167) {
                        this.xt.nickey = this.getSvalue(line2, 1);
                        if (getvalue3 != -167) {
                            this.xt.clan = this.getSvalue(line2, 2);
                            this.xt.clankey = this.getSvalue(line2, 3);
                        }
                        else {
                            this.xt.clan = "";
                            this.xt.clankey = "";
                            getvalue4 = this.getvalue(line2, 2);
                            this.xt.hours = this.getvalue(line2, 3);
                        }
                    }
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            }
            catch (Exception ex2) {}
            this.gs.tnick.setEnabled(true);
            this.gs.tpass.setEnabled(true);
            this.gs.keplo.setEnabled(true);
            if (getvalue3 == -1) {
                this.msg = "Unable to connect to server at this moment.  Please try again later.";
                this.fase = 3;
            }
            if (getvalue3 == 0 || getvalue3 == 3 || getvalue3 > 10 || getvalue3 == -167 || getvalue3 == 111) {
                this.xt.nickname = this.gs.tnick.getText();
                this.showtf = false;
                this.gs.tnick.setVisible(false);
                this.gs.tpass.setVisible(false);
                this.gs.temail.setVisible(false);
                this.gs.keplo.setVisible(false);
                this.gs.requestFocus();
                this.gs.setloggedcookie();
                this.btroom = false;
                this.xt.logged = true;
                this.xt.gotlog = true;
                if (getvalue3 == 0) {
                    this.xt.acexp = 0;
                }
                if (getvalue3 > 10) {
                    this.xt.acexp = getvalue3 - 10;
                }
                if (getvalue3 == 3) {
                    this.xt.acexp = -1;
                }
                if (getvalue3 == -167) {
                    this.xt.logged = false;
                    if (getvalue4 != -1) {
                        this.xt.nfreeplays = getvalue4;
                    }
                }
                if (this.xt.logged) {
                    this.xt.backlog = this.xt.nickname;
                }
                this.fase = 12;
                this.justlog = true;
                this.checknotifcations();
                System.gc();
            }
            if (getvalue3 == 1) {
                this.msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
                this.gs.tnick.setForeground(new Color(255, 0, 0));
                this.gs.tnick.requestFocus();
                this.errcnt = 40;
                this.fase = 3;
            }
            if (getvalue3 == 2) {
                this.msg = "Sorry.  The Password you have entered is incorrect.";
                this.gs.tpass.setForeground(new Color(255, 0, 0));
                this.gs.tpass.requestFocus();
                this.errcnt = 40;
                this.fase = 3;
            }
            this.gs.setCursor(new Cursor(0));
        }
        if (this.fase == 8) {
            this.gs.setCursor(new Cursor(3));
            int getvalue5 = -1;
            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("2|" + this.gs.temail.getText().toLowerCase() + "|");
                final String line3 = this.din.readLine();
                if (line3 != null) {
                    getvalue5 = this.getvalue(line3, 0);
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            }
            catch (Exception ex3) {}
            this.gs.temail.setEnabled(true);
            if (getvalue5 == -1) {
                this.msg = "Unable to connect to server at this moment.  Please try again later.";
                this.fase = 7;
            }
            if (getvalue5 == 0) {
                this.showtf = false;
                this.gs.temail.setVisible(false);
                this.msg = "Please check your Email: " + this.gs.temail.getText() + " to login.";
                this.gs.temail.setText("");
                this.gs.tnick.setText("");
                this.gs.tpass.setText("");
                this.fase = 3;
            }
            if (getvalue5 == 1) {
                this.msg = "Sorry.  This Email Address does not exist in our system!";
                this.gs.temail.setForeground(new Color(255, 0, 0));
                this.errcnt = 40;
                this.fase = 7;
            }
            this.gs.setCursor(new Cursor(0));
        }
        if ((this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) && !this.socketson) {
            for (int i = 0; i < this.nservers; ++i) {
                try {
                    this.serverdone[i] = -1;
                    this.IPAddress[i] = InetAddress.getByName(this.servers[i]);
                    this.dSocket[i] = new DatagramSocket(7001 + i);
                }
                catch (Exception ex4) {
                    this.serverdone[i] = 5;
                }
            }
            this.srvtrn = 0;
            this.socketson = true;
        }
        while (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
            if (this.srvtrn < this.nservers) {
                while (this.serverdone[this.srvtrn] < this.xt.cntptrys) {
                    if (this.serverdone[this.srvtrn] == -1) {
                        this.serverdone[this.srvtrn] = 0;
                    }
                    this.servestart[this.srvtrn] = new Date().getTime();
                    try {
                        final byte[] array = new byte[4];
                        final DatagramPacket datagramPacket = new DatagramPacket(array, array.length, this.IPAddress[this.srvtrn], 7000);
                        datagramPacket.setData(("" + this.xt.nickname + "|").getBytes());
                        this.dSocket[this.srvtrn].send(datagramPacket);
                        this.dSocket[this.srvtrn].receive(datagramPacket);
                        if (new String(datagramPacket.getData()).startsWith("OK")) {
                            final Date date = new Date();
                            if (date.getTime() - this.servestart[this.srvtrn] < this.xt.delays[this.srvtrn]) {
                                this.xt.delays[this.srvtrn] = (int)(date.getTime() - this.servestart[this.srvtrn]);
                            }
                        }
                    }
                    catch (Exception ex5) {
                        this.xt.delays[this.srvtrn] = 600;
                        this.serverdone[this.srvtrn] = 5;
                    }
                    final int[] serverdone = this.serverdone;
                    final int srvtrn = this.srvtrn;
                    ++serverdone[srvtrn];
                }
                ++this.srvtrn;
            }
            else if (this.fase == 13) {
                int n = -1;
                boolean b = false;
                for (int j = 0; j < this.nservers; ++j) {
                    if (this.xt.delays[j] < n || n == -1) {
                        n = this.xt.delays[j];
                        this.opselect = j;
                    }
                    if (this.xt.delays[j] >= 600) {
                        b = true;
                    }
                }
                if (!b) {
                    final xtGraphics xt = this.xt;
                    xt.cntptrys -= 2;
                    if (this.xt.cntptrys < 1) {
                        this.xt.cntptrys = 1;
                    }
                }
                this.fase = 14;
            }
            try {
                final Thread connector = this.connector;
                Thread.sleep(5L);
            }
            catch (InterruptedException ex6) {}
        }
        if (this.fase != 12 && this.fase != 13 && this.fase != 14 && this.fase != 15 && this.fase != 5 && this.socketson) {
            for (int k = 0; k < this.nservers; ++k) {
                try {
                    this.dSocket[k].close();
                    this.dSocket[k] = null;
                }
                catch (Exception ex7) {}
            }
            this.socketson = false;
        }
        if (this.fase == 16 || this.fase == 17) {
            int n2 = 0;
            int n3 = 0;
            int recom = -1;
            this.recom = 0;
            try {
                this.socket = new Socket(this.xt.server, 7067);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            }
            catch (Exception ex8) {}
            while ((this.fase == 16 || this.fase == 17) && n3 != 3) {
                String s = "";
                if (n2 == 0) {
                    try {
                        this.dout.println("10|");
                        final String line4 = this.din.readLine();
                        if (line4 == null) {
                            n2 = 1;
                        }
                        else {
                            s = line4;
                        }
                    }
                    catch (Exception ex9) {
                        n2 = 1;
                    }
                    if (n2 != 0) {
                        try {
                            this.socket.close();
                            this.socket = null;
                            this.din.close();
                            this.din = null;
                            this.dout.close();
                            this.dout = null;
                        }
                        catch (Exception ex10) {}
                        try {
                            this.socket = new Socket(this.xt.server, 7067);
                            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                            (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println("10|");
                            final String line5 = this.din.readLine();
                            if (line5 != null) {
                                n2 = 0;
                            }
                            else {
                                s = line5;
                            }
                        }
                        catch (Exception ex11) {
                            n2 = 1;
                        }
                    }
                    if (n2 != 0) {
                        try {
                            this.socket.close();
                            this.socket = null;
                        }
                        catch (Exception ex12) {}
                    }
                }
                if (n2 == 0) {
                    for (int l = 0; l < 5; ++l) {
                        this.rmps[l] = this.getvalue(s, l * 2);
                        this.rmwt[l] = this.getvalue(s, 1 + l * 2);
                    }
                    int abs = 1000;
                    for (int recom2 = 0; recom2 < 5; ++recom2) {
                        if (Math.abs(this.rmps[recom2] - 6) < abs) {
                            this.recom = recom2;
                            abs = Math.abs(this.rmps[recom2] - 6);
                        }
                    }
                    if (this.recom != recom) {
                        this.opselect = this.recom;
                        recom = this.recom;
                    }
                    if (this.fase == 16) {
                        this.fase = 17;
                    }
                }
                else {
                    this.msg = "Failed to connect to this Server!";
                    ++n3;
                }
                if (n3 != 3) {
                    try {
                        final Thread connector2 = this.connector;
                        Thread.sleep(2000L);
                    }
                    catch (InterruptedException ex13) {}
                }
            }
            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            }
            catch (Exception ex14) {}
            if (n3 == 3) {
                this.resofaso = true;
            }
        }
    }

    public void stopallnow() {
        if (this.connector != null) {
          this.connector.stop();
          this.connector = null;
          /*try {
            this.connector.join(0);
            this.connector = null;
          } catch (InterruptedException ex) {
            // NOTE: caught here
          }*/
        }
        this.endcons();
    }

    public void multimode(final ContO[] array) {
        this.btn = 0;
        this.xt.mainbg(4);
        for (int i = 0; i < 3; ++i) {
            this.rd.drawImage(this.xt.bgmain, 65, this.bgmy[i], null);
            final int[] bgmy = this.bgmy;
            final int n = i;
            bgmy[n] -= 4;
            if (this.bgmy[i] <= -400) {
                this.bgmy[i] = 800;
            }
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.2f));
        this.rd.drawImage(this.xt.bggo, 0, 0, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 425, 670, 25);
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        float n2 = 1.0f - (this.flipo - 10) / 80.0f;
        if (n2 > 1.0f) {
            n2 = 1.0f;
        }
        if (n2 < 0.0f) {
            n2 = 0.0f;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, n2));
        if (this.flipo > 10) {
            this.rd.drawImage(this.xt.logomadnes, 96 + (int)(2.0 - Math.random() * 4.0), 11 + (int)(2.0 - Math.random() * 4.0), null);
        }
        else {
            this.rd.drawImage(this.xt.logomadnes, 96, 11, null);
        }
        ++this.flipo;
        if (this.flipo > 50) {
            this.flipo = 0;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.drawSbutton(this.xt.exit, 690, 17);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
        this.rd.setColor(new Color(203, 227, 253));
        this.rd.fillRoundRect(319, 83, 180, 96, 20, 20);
        this.rd.fillRoundRect(173, 83, 132, 32, 20, 20);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setColor(this.color2k(90, 90, 90));
        this.rd.drawRoundRect(319, 83, 180, 96, 20, 20);
        this.rd.drawRoundRect(173, 83, 132, 32, 20, 20);
        if (!this.gotcai) {
            int n4;
            int n3 = n4 = array[this.xt.sc[0]].p[0].oz[0];
            int n6;
            int n5 = n6 = array[this.xt.sc[0]].p[0].oy[0];
            for (int j = 0; j < array[this.xt.sc[0]].npl; ++j) {
                for (int k = 0; k < array[this.xt.sc[0]].p[j].n; ++k) {
                    if (array[this.xt.sc[0]].p[j].oz[k] < n3) {
                        n3 = array[this.xt.sc[0]].p[j].oz[k];
                    }
                    if (array[this.xt.sc[0]].p[j].oz[k] > n4) {
                        n4 = array[this.xt.sc[0]].p[j].oz[k];
                    }
                    if (array[this.xt.sc[0]].p[j].oy[k] < n5) {
                        n5 = array[this.xt.sc[0]].p[j].oy[k];
                    }
                    if (array[this.xt.sc[0]].p[j].oy[k] > n6) {
                        n6 = array[this.xt.sc[0]].p[j].oy[k];
                    }
                }
            }
            this.cax = (n4 + n3) / 2;
            this.cay = (n6 + n5) / 2;
            this.gotcai = true;
        }
        array[this.xt.sc[0]].z = 1500;
        array[this.xt.sc[0]].y = 380 - this.cay;
        array[this.xt.sc[0]].x = 100 - this.cax;
        array[this.xt.sc[0]].zy = 0;
        array[this.xt.sc[0]].xz = -90;
        array[this.xt.sc[0]].xy = this.pend;
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        array[this.xt.sc[0]].d(this.rd);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!this.pendb) {
            this.pend += 2;
            if (this.pend > 80) {
                this.pendb = true;
            }
        }
        else {
            this.pend -= 2;
            if (this.pend < -10) {
                this.pendb = false;
            }
        }
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawString(this.xt.nickname, 239 - this.ftm.stringWidth(this.xt.nickname) / 2, 105);
        this.rd.setColor(this.color2k(90, 90, 90));
        this.rd.drawString("" + this.xt.cd.names[this.xt.sc[0]] + "", 409 - this.ftm.stringWidth("" + this.xt.cd.names[this.xt.sc[0]] + "") / 2, 81);
        this.rd.drawString("Nickname", 239 - this.ftm.stringWidth("Nickname") / 2, 81);
        this.drawbutton(this.xt.change, 570, 98);
        this.drawSbutton(this.xt.logout, 239, 135);
        this.rd.setColor(new Color(98, 56, 0));
        this.rd.drawString("Edit my Account", 239 - this.ftm.stringWidth("Edit my Account") / 2, 168);
        if (this.ond) {
            this.rd.drawLine(239 - this.ftm.stringWidth("Edit my Account") / 2, 169, 239 - this.ftm.stringWidth("Edit my Account") / 2 + this.ftm.stringWidth("Edit my Account"), 169);
        }
        if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
            final int srvtrn = this.srvtrn;
            if (srvtrn < this.nservers && this.serverdone[srvtrn] != -1 && new Date().getTime() - this.servestart[srvtrn] > 1500L) {
                if (this.connector != null) {
                  this.connector.stop();
                  this.connector = null;

                  /*try {
                    this.connector.join(0);
                    this.connector = null;
                  } catch (InterruptedException ex) {
                    // NOTE: caught here
                  }*/
                }
                this.xt.delays[srvtrn] = 600;
                this.serverdone[srvtrn] = 5;
                (this.connector = new Thread(this)).start();
            }
        }
        if (this.fase == 12) {
            if (this.xt.acexp == 0 || this.contrb) {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(205, 225, 390, 120, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                this.rd.setColor(this.color2k(90, 90, 90));
                this.rd.drawString("Multiplayer Mode", 400 - this.ftm.stringWidth("Multiplayer Mode") / 2, 220);
                this.rd.drawRoundRect(205, 225, 390, 120, 20, 20);
                if (this.opselect == 0 && !this.pessd[3]) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                    this.rd.setColor(new Color(203, 227, 253));
                    this.rd.fillRect(387 - this.xt.pon.getWidth(this.ob) / 2, 242, this.xt.pon.getWidth(this.ob) + 26, 26);
                    this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                }
                this.drawbutton(this.xt.pon, 400, 255);
                if (this.opselect == 1 && !this.pessd[4]) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                    this.rd.setColor(new Color(203, 227, 253));
                    this.rd.fillRect(387 - this.xt.pln.getWidth(this.ob) / 2, 302, this.xt.pln.getWidth(this.ob) + 26, 26);
                    this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                }
                this.drawbutton(this.xt.pln, 400, 315);
                if (!this.xt.logged) {
                    this.rd.setColor(new Color(30, 70, 110));
                    this.rd.drawString("You can play 5 multiplayer turns per day to try the game with your trial account.", 400 - this.ftm.stringWidth("You can play 1 multiplayer turn per day to try the game with your trial account.") / 2, 368);
                    this.rd.drawString("Upgrade your account to purchase the game.", 400 - this.ftm.stringWidth("You can play 1 multiplayer turn per day to try the game with your trial account.") / 2, 385);
                    this.drawSbutton(this.xt.upgrade, 400, 406);
                }
            }
            else {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(165, 219, 470, 135, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                this.rd.setColor(this.color2k(90, 90, 90));
                this.rd.drawRoundRect(165, 219, 470, 135, 20, 20);
                if (this.xt.acexp > 0) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
                    this.rd.drawString("Your account is due to expire in " + this.xt.acexp + " days.", 185, 265);
                    this.rd.drawString("Renew your registration soon!", 185, 295);
                    this.stringbutton("Renew my Account Registration now!", 345, 332, 0);
                    this.stringbutton("Renew Later", 524, 332, 0);
                }
                if (this.xt.acexp == -1) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
                    this.rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
                    this.rd.drawString("Please renew your registration.", 185, 295);
                    this.stringbutton("Renew my account registration now!", 362, 332, 0);
                    this.stringbutton("Cancel", 524, 332, 0);
                }
                if (this.xt.acexp == -2) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
                    this.rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
                    this.rd.drawString("You can only play the game online using your trial account.", 185, 295);
                    this.stringbutton("Play the multiplayer online!", 362, 332, 0);
                    this.stringbutton("Cancel", 524, 332, 0);
                }
                if (this.xt.acexp == -3) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Some one else is already logged in the game with your account.", 185, 245);
                    this.rd.drawString("If you where just in the game then quitted it suddenly, it could just", 185, 265);
                    this.rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.", 185, 285);
                    this.rd.drawString("Otherwise please consider changing your password.", 185, 305);
                    this.stringbutton("Change Password", 332, 336, 0);
                    this.stringbutton("Try Again", 494, 336, 0);
                }
            }
        }
        if (this.fase == 13 || this.fase == 14 || this.fase == 16 || this.fase == 17) {
            if (this.trans < 40) {
                this.rd.drawImage(this.xt.pon, 400 - this.xt.pon.getWidth(this.ob) / 2, 255 - this.xt.pon.getHeight(this.ob) / 2 - 12 - this.trans, null);
            }
            else {
                this.rd.drawImage(this.xt.pon, 400 - this.xt.pon.getWidth(this.ob) / 2, 215 - this.xt.pon.getHeight(this.ob) / 2 - 12, null);
            }
            if (this.trans >= 40) {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                this.rd.setColor(this.color2k(90, 90, 90));
                this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                this.drawbutton(this.xt.cancel, 583, 395);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.fase == 13) {
                    this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
                    if (this.msg.equals(". . . | Connecting to Servers | . . .") && this.ncnt == 0) {
                        this.msg = "| Connecting to Servers |";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". . | Connecting to Servers | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Connecting to Servers | . . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". | Connecting to Servers | .") && this.ncnt == 0) {
                        this.msg = ". . | Connecting to Servers | . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals("| Connecting to Servers |") && this.ncnt == 0) {
                        this.msg = ". | Connecting to Servers | .";
                        this.ncnt = 5;
                    }
                    if (this.ncnt != 0) {
                        --this.ncnt;
                    }
                }
                if (this.fase == 16) {
                    this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
                    if (this.msg.equals(". . . | Finding Rooms | . . .") && this.ncnt == 0) {
                        this.msg = "| Finding Rooms |";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". . | Finding Rooms | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Finding Rooms | . . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". | Finding Rooms | .") && this.ncnt == 0) {
                        this.msg = ". . | Finding Rooms | . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals("| Finding Rooms |") && this.ncnt == 0) {
                        this.msg = ". | Finding Rooms | .";
                        this.ncnt = 5;
                    }
                    if (this.ncnt != 0) {
                        --this.ncnt;
                    }
                }
                if (this.fase == 14) {
                    this.msg = "";
                    int n7 = 0;
                    if (!this.xt.nofull) {
                        for (int l = 0; l < this.nservers; ++l) {
                            if (this.xt.delays[l] >= 400) {
                                ++n7;
                            }
                        }
                    }
                    if (n7 != this.nservers) {
                        boolean b = false;
                        int n8 = 0;
                        for (int n9 = 0; n9 < this.nservers; ++n9) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.opselect == n9) {
                                this.rd.setColor(new Color(98, 56, 0));
                                this.rd.fillRoundRect(175, 230 + n9 * 20, 450, 20, 14, 14);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(175, 230 + n9 * 20, 450, 20, 14, 14);
                                this.rd.setColor(this.color2k(255, 255, 255));
                                if (this.xt.delays[n9] >= 400) {
                                    this.msg = "Your connection to this server is too slow!";
                                    n8 = 1;
                                }
                                if (this.xt.delays[n9] == 600) {
                                    this.msg = "This server is not responding!";
                                    n8 = 1;
                                }
                                if (this.xt.delays[n9] < 400) {
                                    for (int n10 = 0; n10 < this.nservers; ++n10) {
                                        if (this.xt.delays[n10] < this.xt.delays[n9] && n9 != n10) {
                                            b = true;
                                        }
                                    }
                                    if (b) {
                                        this.msg = "It is recommended to choose the fastest server.";
                                    }
                                    else if (this.xt.delays[n9] >= 300) {
                                        this.msg = "Your connection speed is not perfect.  You may encounter delay!";
                                    }
                                }
                            }
                            this.rd.drawString("Server Name :", 195, 245 + n9 * 20);
                            this.rd.drawString("|   Delay/Speed :", 385, 245 + n9 * 20);
                            int n11 = 0;
                            int n12 = 0;
                            String s = "" + this.xt.delays[n9] + "/";
                            if (this.xt.delays[n9] < 75) {
                                s += "EXCELENT *****";
                                n11 = 62;
                                n12 = 100;
                            }
                            if (this.xt.delays[n9] >= 75 && this.xt.delays[n9] < 150) {
                                s += "Perfect ****";
                                n11 = 62;
                                n12 = 100;
                            }
                            if (this.xt.delays[n9] >= 150 && this.xt.delays[n9] < 250) {
                                s += "Good ***";
                                n11 = 81;
                                n12 = 100;
                            }
                            if (this.xt.delays[n9] >= 250 && this.xt.delays[n9] < 400) {
                                s += "Acceptable **";
                                n11 = 100;
                                n12 = 100;
                            }
                            if (this.xt.delays[n9] >= 400 && this.xt.delays[n9] < 600) {
                                s += "Poor";
                                n11 = 100;
                                n12 = 0;
                            }
                            if (this.xt.delays[n9] == 600) {
                                s = "Not Responding";
                            }
                            if (this.opselect == n9) {
                                n11 *= (int)2.55f;
                                n12 *= (int)2.55f;
                            }
                            if (n11 > 255) {
                                n11 = 255;
                            }
                            if (n11 < 0) {
                                n11 = 0;
                            }
                            if (n12 > 255) {
                                n12 = 255;
                            }
                            if (n12 < 0) {
                                n12 = 0;
                            }
                            this.rd.setColor(new Color(n11, n12, 0));
                            this.rd.drawString("" + this.snames[n9] + "", 294, 245 + n9 * 20);
                            this.rd.drawString(s, 497, 245 + n9 * 20);
                        }
                        if (!this.xt.logged && this.xt.nfreeplays - this.xt.ndisco >= 5 && n8 == 0) {
                            this.msg = "You have played your 5 games today, please upgrade your account.";
                            n8 = 2;
                        }
                        if (this.xt.nofull) {
                            if (this.nflk % 4 != 0 || this.nflk == 0) {
                                this.rd.setFont(new Font("Arial", 0, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(200, 0, 0));
                                this.rd.drawString("Warning! You did not allow the game full permissions when you started it.", 175, 275);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 292);
                                this.rd.drawString("Because of this you will be able to connect to ONLY the game's main server:", 175, 309);
                                this.rd.drawString("'" + this.snames[0] + "', which is not necessarily the fastest server you can connect to.", 175, 326);
                                this.rd.drawString("Please allow Java full permissions next time to be able to play on all servers!", 175, 343);
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                            }
                        }
                        else {
                            if (n8 == 0) {
                                this.rd.setColor(new Color(98, 56, 0));
                            }
                            if (n8 == 1) {
                                this.rd.setColor(new Color(200, 0, 0));
                            }
                            if (n8 == 2) {
                                this.rd.setColor(new Color(30, 70, 110));
                            }
                            if (this.nflk % 4 != 0 || this.nflk == 0) {
                                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 360);
                            }
                            if (this.nflk != 0) {
                                --this.nflk;
                            }
                        }
                    }
                    else {
                        if (this.nflk % 4 != 0 || this.nflk == 0) {
                            this.rd.setColor(new Color(200, 0, 0));
                            this.rd.drawString("Sorry.  Your connection is currently not fast enough to play online!", 400 - this.ftm.stringWidth("Sorry.  Your connection is currently not fast enough to play online!") / 2, 242);
                        }
                        if (this.nflk != 0) {
                            --this.nflk;
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please make sure you or anyone else using this connection is not slowing", 181, 265);
                        this.rd.drawString("it down right now by downloading or streaming.", 181, 282);
                        this.rd.drawString("Also please make sure you don't have any other programs running on your", 181, 299);
                        this.rd.drawString("computer that maybe consuming your bandwidth.", 181, 316);
                        this.rd.drawString("Otherwise you may need to upgrade your connection speed to play!", 181, 333);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Press 'Cancel' to try again or to try playing a Lan game instead.", 400 - this.ftm.stringWidth("Press 'Cancel' to try again or to try playing a Lan game instead.") / 2, 357);
                    }
                    this.drawbutton(this.xt.play, 400, 395);
                }
                if (this.fase == 17) {
                    final int n13 = 14;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(": :   " + this.xt.servername + "   : :", 400 - this.ftm.stringWidth(": :   " + this.xt.servername + "   : :") / 2, 239);
                    for (int n14 = 0; n14 < 5; ++n14) {
                        if (this.opselect == n14) {
                            this.rd.setColor(new Color(98, 56, 0));
                            this.rd.fillRoundRect(300, 230 + n14 * 20 + n13, 200, 20, 14, 14);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(300, 230 + n14 * 20 + n13, 200, 20, 14, 14);
                            this.rd.setColor(this.color2k(255, 255, 255));
                        }
                        this.rd.drawString("Room " + (n14 + 1) + " :", 329, 245 + n14 * 20 + n13);
                        this.rd.drawString("" + this.rmps[n14] + "  Players", 471 - this.ftm.stringWidth("" + this.rmps[n14] + "  Players"), 245 + n14 * 20 + n13);
                        if (n14 == this.recom) {
                            if (this.opselect != n14) {
                                this.rd.setColor(new Color(125, 200, 0));
                            }
                            else {
                                this.rd.setColor(new Color(160, 255, 0));
                            }
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    this.drawbutton(this.xt.play, 400, 395);
                }
            }
            else {
                this.trans += 8;
            }
        }
        if (this.fase == 15) {
            if (this.trans < 100) {
                this.rd.drawImage(this.xt.pln, 400 - this.xt.pln.getWidth(this.ob) / 2, 315 - this.xt.pln.getHeight(this.ob) / 2 - 12 - this.trans, null);
            }
            else {
                this.rd.drawImage(this.xt.pln, 400 - this.xt.pln.getWidth(this.ob) / 2, 215 - this.xt.pln.getHeight(this.ob) / 2 - 12, null);
            }
            if (this.trans >= 100) {
                this.rd.setColor(this.color2k(255, 255, 255));
                this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.xt.nofull) {
                    if (this.nflk % 4 != 0 || this.nflk == 0) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(200, 0, 0));
                        this.rd.drawString("Sorry. You did not allow the game full permissions when you started it.", 175, 242);
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 262);
                        this.rd.drawString("Because of this the game will not be able to create LAN connections!", 175, 288);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please restart the game and allow Java full permissions to be able to", 175, 315);
                        this.rd.drawString("play LAN games!", 175, 332);
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("( Close ALL browser windows including this one then", 295, 332);
                        this.rd.drawString("start the game again but click 'Run' when asked to 'run this application'. )", 175, 349);
                    }
                    if (this.nflk != 0) {
                        --this.nflk;
                    }
                }
                else {
                    this.rd.drawString("Play a multiplayer game across your Local Area Network (LAN).", 179, 245);
                    this.rd.drawString("Experience the game live with zero delay and 100% real-time action!", 179, 262);
                    this.rd.setFont(new Font("Arial", 0, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("This is for if there is more then one computer connected to your network or", 179, 292);
                    this.rd.drawString("if you are in a computer lab or in an internet caf\u00e9.", 179, 309);
                    this.rd.drawString("You can also invite your friends to come over with their Laptop PCs or Macs", 179, 335);
                    this.rd.drawString("to log on to your internet connection/network and play with you!", 179, 352);
                }
                this.drawbutton(this.xt.cancel, 583, 395);
                this.drawbutton(this.xt.play, 400, 395);
            }
            else {
                this.trans += 10;
            }
        }
        if (this.resofaso) {
            this.resofaso = false;
            if (this.connector != null) {
              this.connector.stop();
              this.connector = null;

              /*try {
                this.connector.join(0);
                this.connector = null;
              } catch (InterruptedException ex) {
                // NOTE: caught here
              }*/
            }
            this.socketson = false;
            this.msg = "| Connecting to Servers |";
            this.fase = 13;
            (this.connector = new Thread(this)).start();
        }
    }

    public void multistart(final ContO[] array, final int oxm, final int oym, final boolean b) {
        this.btn = 0;
        this.xt.mainbg(4);
        for (int i = 0; i < 3; ++i) {
            this.rd.drawImage(this.xt.bgmain, 65, this.bgmy[i], null);
            final int[] bgmy = this.bgmy;
            final int n = i;
            bgmy[n] -= 4;
            if (this.bgmy[i] <= -400) {
                this.bgmy[i] = 800;
            }
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.2f));
        this.rd.drawImage(this.xt.bggo, 0, 0, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 425, 670, 25);
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        float n2 = 1.0f - (this.flipo - 10) / 80.0f;
        if (n2 > 1.0f) {
            n2 = 1.0f;
        }
        if (n2 < 0.0f) {
            n2 = 0.0f;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, n2));
        if (this.flipo > 10) {
            this.rd.drawImage(this.xt.logomadnes, 96 + (int)(2.0 - Math.random() * 4.0), 11 + (int)(2.0 - Math.random() * 4.0), null);
        }
        else {
            this.rd.drawImage(this.xt.logomadnes, 96, 11, null);
        }
        ++this.flipo;
        if (this.flipo > 50) {
            this.flipo = 0;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        int n3 = 0;
        if (oxm != this.oxm || oym != this.oym) {
            n3 = 1;
            this.oxm = oxm;
            this.oym = oym;
        }
        if (b) {
            n3 = 2;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3f));
        this.rd.drawImage(this.xt.dude[n3], 87, 76, null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
        this.rd.drawImage(this.xt.redy, 445, 153, null);
        this.drawSbutton(this.xt.exit, 690, 17);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (this.fase != 5) {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(246, 83, 180, 96, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
            this.rd.setColor(this.color2k(90, 90, 90));
            this.rd.drawString("" + this.xt.cd.names[this.xt.sc[0]] + "", 336 - this.ftm.stringWidth("" + this.xt.cd.names[this.xt.sc[0]] + "") / 2, 81);
            this.rd.drawRoundRect(246, 83, 180, 96, 20, 20);
            if (!this.gotcai) {
                int n5;
                int n4 = n5 = array[this.xt.sc[0]].p[0].oz[0];
                int n7;
                int n6 = n7 = array[this.xt.sc[0]].p[0].oy[0];
                for (int j = 0; j < array[this.xt.sc[0]].npl; ++j) {
                    for (int k = 0; k < array[this.xt.sc[0]].p[j].n; ++k) {
                        if (array[this.xt.sc[0]].p[j].oz[k] < n4) {
                            n4 = array[this.xt.sc[0]].p[j].oz[k];
                        }
                        if (array[this.xt.sc[0]].p[j].oz[k] > n5) {
                            n5 = array[this.xt.sc[0]].p[j].oz[k];
                        }
                        if (array[this.xt.sc[0]].p[j].oy[k] < n6) {
                            n6 = array[this.xt.sc[0]].p[j].oy[k];
                        }
                        if (array[this.xt.sc[0]].p[j].oy[k] > n7) {
                            n7 = array[this.xt.sc[0]].p[j].oy[k];
                        }
                    }
                }
                this.cax = (n5 + n4) / 2;
                this.cay = (n7 + n6) / 2;
                this.gotcai = true;
            }
            array[this.xt.sc[0]].z = 1500;
            array[this.xt.sc[0]].y = 380 - this.cay;
            array[this.xt.sc[0]].x = -170 - this.cax;
            array[this.xt.sc[0]].zy = 0;
            array[this.xt.sc[0]].xz = -90;
            array[this.xt.sc[0]].xy = this.pend;
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            array[this.xt.sc[0]].d(this.rd);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (!this.pendb) {
                this.pend += 2;
                if (this.pend > 80) {
                    this.pendb = true;
                }
            }
            else {
                this.pend -= 2;
                if (this.pend < -10) {
                    this.pendb = false;
                }
            }
            this.drawbutton(this.xt.change, 497, 98);
        }
        if (this.fase == 1 || this.fase == 2) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            this.rd.drawString("Enter a Nickname:", 400 - this.ftm.stringWidth("Enter a Nickname:") - 14, 241);
            if (this.fase == 2) {
                if (this.msg.equals(". . . | Checking Nickname | . . .") && this.ncnt == 0) {
                    this.msg = "| Checking Nickname |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Checking Nickname | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Checking Nickname | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Checking Nickname | .") && this.ncnt == 0) {
                    this.msg = ". . | Checking Nickname | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Checking Nickname |") && this.ncnt == 0) {
                    this.msg = ". | Checking Nickname | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0) {
                    --this.ncnt;
                }
                this.pessd[2] = true;
            }
            if (this.fase == 1 && !this.gs.tnick.isShowing()) {
                this.gs.tnick.setVisible(true);
                this.gs.tnick.requestFocus();
                if (this.gs.tnick.getText().equals("Nickname")) {
                    this.gs.tnick.select(8, 8);
                }
            }
            if (this.errcnt != 0) {
                --this.errcnt;
                if (this.errcnt == 0) {
                    this.gs.tnick.setForeground(new Color(0, 0, 0));
                }
            }
            this.drawbutton(this.xt.play, 400, 285);
            if (this.nflk > 0) {
                if (this.gs.tnick.getText().equals("")) {
                    this.gs.tnick.setText("Nickname");
                    if (this.nflk == 1) {
                        this.gs.tnick.select(8, 8);
                    }
                }
                else {
                    this.gs.tnick.setText("");
                }
                --this.nflk;
            }
            this.drawbutton(this.xt.login, 400, 340);
            this.drawbutton(this.xt.register, 400, 395);
            this.gs.movefield(this.gs.tnick, 400, 225, 129, 23);
            while (this.ftm.stringWidth(this.gs.tnick.getText()) > 86) {
                this.gs.tnick.setText(this.gs.tnick.getText().substring(0, this.gs.tnick.getText().length() - 1));
                this.gs.tnick.select(this.gs.tnick.getText().length(), this.gs.tnick.getText().length());
            }
            if (!this.gs.tnick.getText().equals(this.lnick)) {
                this.fixtext(this.gs.tnick);
                this.lnick = this.gs.tnick.getText();
            }
            if (this.xt.msgcheck(this.gs.tnick.getText())) {
                this.gs.tnick.setText("");
            }
            if (this.gs.tnick.getText().toLowerCase().indexOf("madbot") != -1) {
                this.gs.tnick.setText("");
            }
        }
        if (this.fase == 3 || this.fase == 4) {
            this.rd.drawImage(this.xt.ntrg, 97, 388, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25f));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(246, 212, 308, 142, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
            this.rd.setColor(this.color2k(90, 90, 90));
            this.rd.drawRoundRect(246, 212, 308, 142, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nflk % 4 != 0 || this.nflk == 0) {
                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            }
            if (this.nflk != 0) {
                --this.nflk;
            }
            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 237);
            this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 267);
            if (this.fase == 4) {
                if (this.msg.equals(". . . | Logging In | . . .") && this.ncnt == 0) {
                    this.msg = "| Logging In |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Logging In | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Logging In | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Logging In | .") && this.ncnt == 0) {
                    this.msg = ". . | Logging In | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Logging In |") && this.ncnt == 0) {
                    this.msg = ". | Logging In | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0) {
                    --this.ncnt;
                }
                this.pessd[2] = true;
            }
            if (this.fase == 3) {
                this.showtf = true;
                if (!this.gs.applejava) {
                    if (!this.gs.tpass.isShowing()) {
                        this.gs.tpass.setVisible(true);
                        if (!this.gs.tnick.getText().equals("")) {
                            this.gs.tpass.requestFocus();
                        }
                    }
                    if (!this.gs.tnick.isShowing()) {
                        this.gs.tnick.setVisible(true);
                        if (this.gs.tnick.getText().equals("")) {
                            this.gs.tnick.requestFocus();
                        }
                    }
                }
            }
            if (this.errcnt != 0) {
                --this.errcnt;
                if (this.errcnt == 0) {
                    this.gs.tpass.setText("");
                    this.gs.tnick.setForeground(new Color(0, 0, 0));
                    this.gs.tpass.setForeground(new Color(0, 0, 0));
                }
            }
            this.drawbutton(this.xt.login, 400, 315);
            if (this.onf) {
                this.rd.setColor(this.color2k(0, 72, 255));
            }
            else {
                this.rd.setColor(this.color2k(120, 120, 120));
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Forgot your nickname or password?", 400 - this.ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            final String s = "Register a full account here!";
            this.xrl = 400 - this.ftm.stringWidth(s) / 2;
            this.xrr = this.xrl + this.ftm.stringWidth(s);
            this.rd.drawString(s, this.xrl, 371);
            this.rd.drawLine(this.xrl, 372, this.xrr, 372);
            this.drawbutton(this.xt.register, 400, 395);
            this.gs.movefieldd(this.gs.tnick, 376, 221, 129, 23, this.showtf);
            if (!this.gs.tnick.getText().equals(this.lnick)) {
                this.fixtext(this.gs.tnick);
                this.lnick = this.gs.tnick.getText();
            }
            this.gs.movefieldd(this.gs.tpass, 376, 251, 129, 23, this.showtf);
            if (!this.gs.tpass.getText().equals(this.lpass)) {
                this.fixtext(this.gs.tpass);
                this.lpass = this.gs.tpass.getText();
            }
            if (this.fase == 3 && ((!this.gs.tpass.getText().equals("") && !this.gs.tnick.getText().equals("")) || !this.gs.applejava) && !this.gs.keplo.isShowing()) {
                this.gs.keplo.setVisible(true);
            }
            this.gs.movefield(this.gs.keplo, 376, 275, 129, 23);
        }
        if (this.fase == 5) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 141);
            this.gs.movefield(this.gs.tnick, 376, 125, 129, 23);
            while (this.ftm.stringWidth(this.gs.tnick.getText()) > 86) {
                this.gs.tnick.setText(this.gs.tnick.getText().substring(0, this.gs.tnick.getText().length() - 1));
                this.gs.tnick.select(this.gs.tnick.getText().length(), this.gs.tnick.getText().length());
            }
            if (!this.gs.tnick.getText().equals(this.lnick)) {
                this.fixtext(this.gs.tnick);
                this.lnick = this.gs.tnick.getText();
            }
            if (!this.gs.tnick.isShowing()) {
                this.gs.tnick.setVisible(true);
            }
            this.drawbutton(this.xt.register, 400, 325);
            this.drawbutton(this.xt.cancel, 400, 375);
        }
        if (this.fase == 7 || this.fase == 8) {
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nflk % 4 != 0 || this.nflk == 0) {
                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            }
            if (this.nflk != 0) {
                --this.nflk;
            }
            this.rd.drawString("Your Email:", 344 - this.ftm.stringWidth("Your Email:") - 14, 241);
            if (this.fase == 8) {
                if (this.msg.equals(". . . | Checking Email | . . .") && this.ncnt == 0) {
                    this.msg = "| Checking Email |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Checking Email | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Checking Email | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Checking Email | .") && this.ncnt == 0) {
                    this.msg = ". . | Checking Email | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Checking Email |") && this.ncnt == 0) {
                    this.msg = ". | Checking Email | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0) {
                    --this.ncnt;
                }
                this.pessd[2] = true;
            }
            if (this.fase == 7) {
                this.showtf = true;
                if (!this.gs.applejava && !this.gs.temail.isShowing()) {
                    this.gs.temail.setVisible(true);
                    this.gs.temail.requestFocus();
                }
            }
            if (this.errcnt != 0) {
                --this.errcnt;
                if (this.errcnt == 0) {
                    this.gs.temail.setForeground(new Color(0, 0, 0));
                }
            }
            this.drawbutton(this.xt.sdets, 400, 280);
            this.drawbutton(this.xt.cancel, 400, 375);
            this.gs.movefieldd(this.gs.temail, 344, 225, 199, 23, this.showtf);
            if (!this.gs.temail.getText().equals(this.lemail)) {
                this.fixtext(this.gs.temail);
                this.lemail = this.gs.temail.getText();
            }
        }
    }

    public void ctachm(final int lxm, final int lym, final int n, final Control control, final Lobby lobby) {
        int n2 = -1;
        if (this.fase != 2 && this.fase != 4 && this.fase != 6 && this.fase != 8 && this.fase != 9) {
            for (int i = 0; i < this.btn; ++i) {
                if (Math.abs(lxm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(lym - this.by[i]) < 14 && (n == 1 || n == 11)) {
                    this.pessd[i] = true;
                }
                else {
                    this.pessd[i] = false;
                }
                if (Math.abs(lxm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(lym - this.by[i]) < 14 && n <= -1) {
                    this.gs.mouses = 0;
                    n2 = i;
                }
                if (this.fase == 12 && Math.abs(lxm - this.bx[i]) < this.bw[i] / 2 + 12 && Math.abs(lym - this.by[i]) < 14 && (i == 3 || i == 4) && (lxm != this.lxm || lym != this.lym)) {
                    this.opselect = i - 3;
                }
            }
        }
        if (n2 == 0) {
            this.gs.tnick.setVisible(false);
            this.gs.tpass.setVisible(false);
            this.gs.keplo.setVisible(false);
            this.gs.temail.setVisible(false);
            this.gs.requestFocus();
            this.xt.fase = 24;
        }
        if (n2 == 1 && this.fase != 5) {
            this.gs.tnick.setVisible(false);
            this.gs.tpass.setVisible(false);
            this.gs.keplo.setVisible(false);
            this.gs.temail.setVisible(false);
            this.gs.requestFocus();
            this.xt.fase = 23;
        }
        final int n3 = 2;
        if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
            if (lxm > 176 && lym > 152 && lxm < 296 && lym < 174) {
                if (!this.ond) {
                    this.ond = true;
                    this.gs.setCursor(new Cursor(12));
                }
            }
            else if (this.ond) {
                this.ond = false;
                this.gs.setCursor(new Cursor(0));
            }
            if (this.cntcl == 0) {
                if (this.ond && n == 11) {
                    this.gs.editlink(this.xt.nickname, false);
                    this.cntcl = 10;
                }
            }
            else {
                --this.cntcl;
            }
            if (n2 == n3) {
                n2 = -1;
                if (this.xt.sc[0] >= 16) {
                    this.xt.sc[0] = 15;
                    this.gotcai = false;
                }
                this.xt.logged = false;
                this.xt.gotlog = false;
                this.gs.keplo.setState(false);
                this.gs.setloggedcookie();
                this.xt.cd.msloaded = 0;
                this.xt.cd.lastload = 0;
                this.msg = "Login to access the multiplayer madness!";
                this.fase = 3;
            }
        }
        if (this.fase == 12) {
            if (this.xt.acexp == 0 || this.contrb) {
                if (control.up) {
                    --this.opselect;
                    if (this.opselect == -1) {
                        this.opselect = 1;
                    }
                    control.up = false;
                }
                if (control.down) {
                    ++this.opselect;
                    if (this.opselect == 2) {
                        this.opselect = 0;
                    }
                    control.down = false;
                }
                if (control.enter) {
                    n2 = this.opselect + 3;
                    control.enter = false;
                }
                if (n2 == n3 + 1) {
                    this.msg = "| Connecting to Servers |";
                    this.opselect = 0;
                    this.trans = 0;
                    this.fase = 13;
                    this.nflk = 0;
                    n2 = -1;
                }
                if (n2 == n3 + 2) {
                    this.trans = 0;
                    this.fase = 15;
                    n2 = -1;
                }
                if (!this.xt.logged && n2 == n3 + 3) {
                    this.gs.editlink(this.xt.nickname, true);
                }
            }
            else {
                if (this.xt.acexp > 0) {
                    if (n2 == n3 + 1 || control.enter) {
                        this.gs.editlink(this.xt.nickname, false);
                        n2 = -1;
                    }
                    if (n2 == n3 + 2) {
                        this.opselect = 0;
                        this.contrb = true;
                        n2 = -1;
                    }
                }
                if (this.xt.acexp == -1) {
                    if (n2 == n3 + 1 || control.enter) {
                        this.gs.editlink(this.xt.nickname, false);
                        n2 = -1;
                    }
                    if (n2 == n3 + 2) {
                        n2 = -1;
                        if (this.xt.sc[0] >= 16) {
                            this.xt.sc[0] = 15;
                            this.gotcai = false;
                        }
                        this.xt.logged = false;
                        this.xt.cd.lastload = 0;
                        this.msg = "Login to access the multiplayer madness!";
                        this.fase = 3;
                    }
                }
                if (this.xt.acexp == -2) {
                    if (n2 == n3 + 1 || control.enter) {
                        this.gs.multlink();
                        n2 = -1;
                    }
                    if (n2 == n3 + 2) {
                        n2 = -1;
                        if (this.xt.sc[0] >= 16) {
                            this.xt.sc[0] = 15;
                            this.gotcai = false;
                        }
                        this.xt.logged = false;
                        this.xt.cd.lastload = 0;
                        this.msg = "Login to access the multiplayer madness!";
                        this.fase = 3;
                    }
                }
                if (this.xt.acexp == -3) {
                    if (n2 == n3 + 1 || control.enter) {
                        this.gs.editlink(this.xt.nickname, false);
                        n2 = -1;
                    }
                    if (n2 == n3 + 2) {
                        n2 = -1;
                        if (this.xt.sc[0] >= 16) {
                            this.xt.sc[0] = 15;
                            this.gotcai = false;
                        }
                        this.xt.logged = false;
                        this.xt.cd.lastload = 0;
                        this.msg = "Login to access the multiplayer madness!";
                        this.fase = 3;
                    }
                }
            }
        }
        if (this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
            if (control.exit) {
                n2 = 3;
            }
            if (n2 == n3 + 1) {
                if (this.fase == 15) {
                    this.opselect = 1;
                }
                else {
                    this.opselect = 0;
                }
                if (this.fase == 16 || this.fase == 17) {
                    if (this.connector != null) {
                      this.connector.stop();
                      this.connector = null;

                      /*try {
                        this.connector.join(0);
                        this.connector = null;
                      } catch (InterruptedException ex) {
                        // NOTE: caught here
                      }*/
                    }
                    try {
                        this.socket.close();
                        this.socket = null;
                        this.din.close();
                        this.din = null;
                        this.dout.close();
                        this.dout = null;
                    }
                    catch (Exception ex) {}
                    this.fase = 12;
                    (this.connector = new Thread(this)).start();
                }
                if (this.fase == 14) {
                    if (this.connector != null) {
                      this.connector.stop();
                      this.connector = null;
                      
                      /*try {
                        this.connector.join(0);
                        this.connector = null;
                      } catch (InterruptedException ex) {
                        // NOTE: caught here
                      }*/
                    }
                    for (int j = 0; j < this.nservers; ++j) {
                        try {
                            this.dSocket[j].close();
                            this.dSocket[j] = null;
                        }
                        catch (Exception ex2) {}
                    }
                    this.socketson = false;
                    this.fase = 12;
                    (this.connector = new Thread(this)).start();
                }
                this.fase = 12;
                this.gs.setCursor(new Cursor(0));
            }
        }
        if (this.fase == 14) {
            if (control.enter) {
                n2 = 4;
                this.pessd[4] = true;
            }
            if (control.up) {
                --this.opselect;
                if (this.opselect == -1) {
                    this.opselect = this.nservers - 1;
                }
                control.up = false;
            }
            if (control.down) {
                ++this.opselect;
                if (this.opselect == this.nservers) {
                    this.opselect = 0;
                }
                control.down = false;
            }
            for (int k = 0; k < this.nservers; ++k) {
                if (lxm > 175 && lym > 230 + k * 20 && lxm < 625 && lym < 250 + k * 20 && n == 1) {
                    this.opselect = k;
                }
            }
            if (n2 == n3 + 2) {
                if (this.xt.delays[this.opselect] >= 400 && !this.xt.nickname.equals("Fyre")) {
                    this.nflk = 30;
                }
                else {
                    this.xt.server = this.servers[this.opselect];
                    this.xt.servername = this.snames[this.opselect];
                    this.msg = "| Finding Rooms |";
                    this.opselect = 0;
                    this.nflk = 0;
                    n2 = -1;
                    this.fase = 16;
                }
            }
        }
        if (this.fase == 15) {
            if (control.enter) {
                n2 = 4;
                this.pessd[4] = true;
            }
            if (n2 == n3 + 2) {
                if (this.xt.nofull) {
                    this.nflk = 30;
                }
                else {
                    this.xt.server = this.servers[1];
                    this.xt.servername = this.snames[1];
                    this.xt.servport = 7067;
                    this.xt.lan = true;
                    n2 = -1;
                    this.fase = 18;
                    lobby.fase = 0;
                }
            }
        }
        if (this.fase == 17) {
            if (control.enter) {
                n2 = 4;
                this.pessd[4] = true;
            }
            if (control.up) {
                --this.opselect;
                if (this.opselect == -1) {
                    this.opselect = 4;
                }
                control.up = false;
            }
            if (control.down) {
                ++this.opselect;
                if (this.opselect == 5) {
                    this.opselect = 0;
                }
                control.down = false;
            }
            for (int l = 0; l < 5; ++l) {
                if (lxm > 175 && lym > 230 + l * 20 + 14 && lxm < 625 && lym < 250 + l * 20 + 14 && n == 1) {
                    this.opselect = l;
                }
            }
            if (n2 == n3 + 2) {
                this.xt.servport = 7071 + this.opselect;
                this.xt.lan = false;
                n2 = -1;
                this.fase = 18;
                lobby.fase = 0;
            }
        }
        if (this.fase == 3) {
            if (lxm > 295 && lym > 334 && lxm < 505 && lym < 348) {
                if (!this.onf) {
                    this.onf = true;
                    this.gs.setCursor(new Cursor(12));
                }
            }
            else if (this.onf) {
                this.onf = false;
                this.gs.setCursor(new Cursor(0));
            }
            if (this.onf && n == 11) {
                this.msg = "Please enter your Email Address to recover your account details.";
                this.gs.tnick.setForeground(new Color(0, 0, 0));
                this.gs.tpass.setForeground(new Color(0, 0, 0));
                this.gs.tnick.setVisible(false);
                this.gs.tpass.setVisible(false);
                this.gs.keplo.setVisible(false);
                this.onf = false;
                this.gs.setCursor(new Cursor(0));
                this.fase = 7;
            }
            if (lxm > this.xrl && lxm < this.xrr && lym > 360 && lym < 373) {
                if (!this.onr) {
                    this.onr = true;
                    this.gs.setCursor(new Cursor(12));
                }
            }
            else if (this.onr) {
                this.onr = false;
                this.gs.setCursor(new Cursor(0));
            }
            if (this.onr && n == 11) {
                this.gs.reglink();
                this.gs.mouses = 0;
            }
        }
        if (this.fase == 1) {
            if (control.enter) {
                n2 = 2;
                this.pessd[2] = true;
            }
            if (n2 == 2) {
                if (this.gs.tnick.getText().equals("Fyre") || this.gs.tnick.getText().equals("Nickname") || this.gs.tnick.getText().equals("")) {
                    this.msg = "Type in any Nickname to play...";
                    this.gs.tnick.setText("Nickname");
                    this.nflk = 30;
                }
                else {
                    this.msg = "| Checking Nickname |";
                    this.gs.tnick.setEnabled(false);
                    this.fase = 2;
                    (this.connector = new Thread(this)).start();
                }
            }
            if (n2 == 3) {
                if (this.gs.tnick.getText().equals("Nickname") || this.msg.startsWith("This")) {
                    this.gs.tnick.setText("");
                }
                this.msg = "Login to access the multiplayer madness!";
                this.gs.tnick.setForeground(new Color(0, 0, 0));
                this.fase = 3;
                n2 = -1;
            }
            if (n2 == 4) {
                if (this.nickero || this.gs.tnick.getText().equals("Nickname")) {
                    this.gs.tnick.setText("");
                    this.nickero = false;
                }
                this.gs.tnick.setForeground(new Color(0, 0, 0));
                this.gs.reglink();
            }
        }
        if (this.fase == 3) {
            if (control.enter || this.xt.autolog) {
                n2 = 2;
                this.pessd[2] = true;
                this.xt.autolog = false;
            }
            if (control.exit) {
                n2 = 3;
            }
            if (n2 == 2) {
                if (this.gs.tnick.getText().equals("")) {
                    this.msg = "Enter your Nickname!";
                    this.nflk = 30;
                }
                else if (this.gs.tpass.getText().equals("")) {
                    this.msg = "Enter your Password!";
                    this.nflk = 30;
                }
                else {
                    this.msg = "| Logging In |";
                    this.gs.tnick.setEnabled(false);
                    this.gs.tpass.setEnabled(false);
                    this.gs.keplo.setEnabled(false);
                    this.fase = 4;
                    (this.connector = new Thread(this)).start();
                }
            }
            if (n2 == 3) {
                this.gs.regnew();
            }
        }
        if (this.fase == 5) {
            if (control.enter) {
                n2 = 1;
                this.pessd[1] = true;
            }
            if (control.exit) {
                n2 = 2;
            }
            if (n2 == 1) {}
            if (n2 == 2) {
                this.fase = this.lrgfase;
                if (this.fase == 12) {
                    this.gs.tnick.setVisible(false);
                    (this.connector = new Thread(this)).start();
                }
            }
        }
        if (this.fase == 7) {
            if (control.enter) {
                n2 = 2;
                this.pessd[2] = true;
            }
            if (control.exit) {
                n2 = 3;
            }
            if (n2 == 2) {
                this.nflk = 0;
                if (this.gs.temail.getText().equals("")) {
                    this.msg = "Please type in your Email Address!";
                    this.nflk = 30;
                }
                if (this.nflk == 0) {
                    final String text = this.gs.temail.getText();
                    int n4 = 0;
                    int n5 = 0;
                    while (n4 < text.length()) {
                        final String string = "" + text.charAt(n4);
                        if (string.equals("@") && n5 == 0 && n4 != 0) {
                            n5 = 1;
                        }
                        if (string.equals(".") && n5 == 1 && n4 != text.length() - 1) {
                            n5 = 2;
                        }
                        ++n4;
                    }
                    if (n5 != 2) {
                        this.msg = "Please type in your Email Address correctly!";
                        this.nflk = 30;
                        this.errcnt = 40;
                        this.gs.temail.setForeground(new Color(255, 0, 0));
                    }
                }
                if (this.nflk == 0) {
                    this.msg = "| Checking Email |";
                    this.gs.temail.setEnabled(false);
                    this.fase = 8;
                    (this.connector = new Thread(this)).start();
                }
            }
            if (n2 == 3) {
                this.inishmulti();
                this.gs.temail.setText("");
                this.gs.tpass.setText("");
            }
        }
        this.lxm = lxm;
        this.lym = lym;
        control.enter = false;
        control.exit = false;
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

    public void drawbutton(final Image image, final int n, final int n2) {
        this.bx[this.btn] = n;
        this.by[this.btn] = n2;
        this.bw[this.btn] = image.getWidth(this.ob);
        if (!this.pessd[this.btn]) {
            this.rd.drawImage(image, n - this.bw[this.btn] / 2, n2 - image.getHeight(this.ob) / 2, null);
            this.rd.drawImage(this.xt.bol, n - this.bw[this.btn] / 2 - 15, n2 - 16, null);
            this.rd.drawImage(this.xt.bor, n + this.bw[this.btn] / 2 + 9, n2 - 16, null);
            this.rd.drawImage(this.xt.bot, n - this.bw[this.btn] / 2 - 9, n2 - 16, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bob, n - this.bw[this.btn] / 2 - 9, n2 + 13, this.bw[this.btn] + 18, 3, null);
        }
        else {
            this.rd.drawImage(image, n - this.bw[this.btn] / 2 + 1, n2 - image.getHeight(this.ob) / 2 + 1, null);
            this.rd.drawImage(this.xt.bolp, n - this.bw[this.btn] / 2 - 15, n2 - 16, null);
            this.rd.drawImage(this.xt.borp, n + this.bw[this.btn] / 2 + 9, n2 - 16, null);
            this.rd.drawImage(this.xt.bob, n - this.bw[this.btn] / 2 - 9, n2 - 16, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bot, n - this.bw[this.btn] / 2 - 9, n2 + 13, this.bw[this.btn] + 18, 3, null);
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

    public void fixtext(final TextField textField) {
        final String replace = textField.getText().replace('\"', '#');
        final String s = "\\";
        String string = "";
        int i = 0;
        int n = -1;
        while (i < replace.length()) {
            final String string2 = "" + replace.charAt(i);
            if (string2.equals("|") || string2.equals(",") || string2.equals("(") || string2.equals(")") || string2.equals("#") || string2.equals(s) || string2.equals("!") || string2.equals("?") || string2.equals(" ") || string2.equals("~") || string2.equals("$") || string2.equals("%") || string2.equals("^") || string2.equals("&") || string2.equals("*") || string2.equals("+") || string2.equals("=") || string2.equals(">") || string2.equals("<") || string2.equals("/") || string2.equals("'") || string2.equals(";") || string2.equals(":") || string2.equals(" ")) {
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
}
