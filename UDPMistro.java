import java.util.Date;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;

public class UDPMistro implements Runnable
{
    Thread runner;
    int runon;
    udpOnline[] udpc;
    int porturn;
    udpServe[] usrv;
    int diledelay;
    long sendat;
    String sendcheck;
    int delay;
    int[] ldelays;
    int diled;
    int rate;
    float freg;
    boolean go;
    int im;
    int nplayers;
    String[][] info;
    int[][] frame;
    int[] lframe;
    int[] force;
    int[] lcframe;
    boolean[] isbot;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int[] gocnt;
    int[] out;
    String xtserver;
    int xtservport;
    int pgame;
    int wx;
    
    public UDPMistro() {
        this.runon = 0;
        this.udpc = new udpOnline[20];
        this.porturn = 0;
        this.usrv = new udpServe[13];
        this.diledelay = 0;
        this.sendat = 0L;
        this.sendcheck = "";
        this.delay = 0;
        this.ldelays = new int[5];
        this.diled = 0;
        this.rate = 30;
        this.freg = 0.0f;
        this.go = false;
        this.im = 0;
        this.nplayers = 0;
        this.info = new String[14][3];
        this.frame = new int[14][3];
        this.lframe = new int[8];
        this.force = new int[8];
        this.lcframe = new int[8];
        this.isbot = new boolean[8];
        this.gocnt = new int[8];
        this.out = new int[8];
        this.xtserver = "";
        this.xtservport = 0;
        this.pgame = 0;
        this.wx = 0;
    }
    
    public void UDPConnectOnline(final String s, final int n, final int nplayers, final int im) {
        this.diledelay = 0;
        this.delay = 0;
        for (int i = 0; i < 5; ++i) {
            this.ldelays[i] = 0;
        }
        this.diled = 0;
        this.go = false;
        this.freg = 0.0f;
        this.im = im;
        this.nplayers = nplayers;
        for (int j = 0; j < 8; ++j) {
            for (int k = 0; k < 3; ++k) {
                this.frame[j][k] = -1;
                this.info[j][k] = "";
            }
            this.isbot[j] = false;
            this.lframe[j] = 0;
            this.force[j] = 0;
            this.lcframe[j] = 0;
        }
        for (int l = 0; l < 20; ++l) {
            this.udpc[l] = new udpOnline(this, s, n + this.im, l, this.porturn);
        }
        if (this.porturn == 0) {
            this.porturn = 20;
        }
        else {
            this.porturn = 0;
        }
        if (this.im >= this.nplayers) {
            this.frame[this.im][0] = 11111;
            this.info[this.im][0] = "watching";
            while (this.info[this.im][0].length() < 110) {
                final StringBuilder sb = new StringBuilder();
                final String[] array = this.info[this.im];
                final int n2 = 0;
                array[n2] = sb.append(array[n2]).append("|").toString();
            }
            ++this.nplayers;
            this.go = true;
        }
        this.runon = 1;
        (this.runner = new Thread(this)).start();
    }
    
    public void UDPConnectLan(final String s, final int nplayers, final int im) {
        this.diledelay = 0;
        this.delay = 0;
        for (int i = 0; i < 5; ++i) {
            this.ldelays[i] = 0;
        }
        this.diled = 0;
        this.go = false;
        this.freg = 0.0f;
        this.im = im;
        this.nplayers = nplayers;
        for (int j = 0; j < 8; ++j) {
            for (int k = 0; k < 3; ++k) {
                this.frame[j][k] = -1;
                this.info[j][k] = "";
            }
            this.isbot[j] = false;
            this.lframe[j] = 0;
            this.force[j] = 0;
            this.lcframe[j] = 0;
        }
        if (this.im != 0) {
            for (int l = 0; l < 20; ++l) {
                this.udpc[l] = new udpOnline(this, s, 7060 + this.im, l, this.porturn);
            }
            if (this.porturn == 0) {
                this.porturn = 20;
            }
            else {
                this.porturn = 0;
            }
            if (this.im >= this.nplayers) {
                this.frame[this.im][0] = 11111;
                this.info[this.im][0] = "watching";
                while (this.info[this.im][0].length() < 110) {
                    final StringBuilder sb = new StringBuilder();
                    final String[] array = this.info[this.im];
                    final int n = 0;
                    array[n] = sb.append(array[n]).append("|").toString();
                }
                ++this.nplayers;
                this.go = true;
            }
            this.runon = 1;
        }
        else {
            try {
                this.socket = new Socket(this.xtserver, this.xtservport);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            }
            catch (Exception ex) {}
            this.runon = 4;
        }
        (this.runner = new Thread(this)).start();
    }
    
    public void UDPLanServer(final int n, final String xtserver, final int xtservport, final int pgame) {
        this.xtserver = xtserver;
        this.xtservport = xtservport;
        this.pgame = pgame;
        for (int i = 0; i < 8; ++i) {
            this.gocnt[i] = 3;
            this.out[i] = 0;
            for (int j = 0; j < 3; ++j) {
                this.frame[i][j] = -1;
                this.info[i][j] = "";
            }
            this.lframe[i] = 0;
            this.force[i] = 0;
            this.lcframe[i] = 0;
        }
        for (int k = 0; k < this.nplayers + 5; ++k) {
            this.usrv[k] = new udpServe(this, k + 1);
        }
    }
    
    public void UDPquit() {
        if (this.runon == 1) {
            this.runon = 2;
        }
        if (this.runon == 4) {
            this.runon = 5;
        }
    }
    
    @Override
    public void run() {
        int n = 0;
        while (this.runon == 1) {
            if (!this.udpc[0].started) {
                this.udpc[0].spark();
                n = 1;
            }
            else {
                final Date date = new Date();
                if (n > this.delay / this.rate && date.getTime() - this.udpc[0].sendat > this.rate - 5) {
                    this.udpc[0].spark();
                    n = 1;
                }
            }
            if (this.delay > this.rate && n <= this.delay / this.rate && n >= 1 && n < 20) {
                final long n2 = new Date().getTime() - this.udpc[n - 1].sendat;
                if (n2 >= this.rate - 5 && n2 < this.rate * 2) {
                    this.udpc[n].spark();
                    ++n;
                }
            }
            if (this.diled == 10) {
                for (int i = 0; i < 20; ++i) {
                    if (this.udpc[i].started) {
                        final long n3 = new Date().getTime() - this.udpc[i].sendat;
                        if (n3 > this.delay * 1.5 && n3 > this.rate) {
                            this.udpc[i].stomp();
                        }
                    }
                }
            }
            if (this.diledelay > 0) {
                --this.diledelay;
            }
            try {
                final Thread runner = this.runner;
                Thread.sleep(5L);
            }
            catch (InterruptedException ex) {}
        }
        int n4 = 0;
        int n5 = 0;
        while (this.runon == 4) {
            for (int j = 0; j < this.nplayers; ++j) {
                boolean b = false;
                if (this.info[j][0].length() > 16 && !("" + this.info[j][0].charAt(15)).equals("0")) {
                    b = true;
                }
                if (!b && this.out[j] == 77) {
                    this.out[j] = 0;
                }
                if (this.out[j] < 76) {
                    if (this.frame[j][0] > 6) {
                        if (this.lcframe[j] != this.frame[j][0] && !b) {
                            this.lcframe[j] = this.frame[j][0];
                            this.out[j] = 0;
                        }
                        else {
                            if (this.out[j] < 70) {
                                this.out[j] = 71;
                            }
                            final int[] out = this.out;
                            final int n6 = j;
                            ++out[n6];
                            if (b) {
                                this.out[j] = 77;
                            }
                            if (this.out[j] == 76) {
                                this.info[j][0] = "disco";
                                final int[] array = this.frame[j];
                                final int n7 = 0;
                                array[n7] += 10;
                            }
                        }
                    }
                    else {
                        final int[] out2 = this.out;
                        final int n8 = j;
                        ++out2[n8];
                        if (this.out[j] == 30) {
                            this.frame[j][0] = 7;
                        }
                    }
                }
            }
            if (n5 == 10) {
                final String string = "3|" + this.pgame + "|alive|";
                if (n4 == 0) {
                    try {
                        this.dout.println(string);
                        if (this.din.readLine() == null) {
                            n4 = 1;
                        }
                    }
                    catch (Exception ex2) {
                        n4 = 1;
                    }
                }
                if (n4 == 1) {
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
                        this.socket = new Socket(this.xtserver, this.xtservport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        (this.dout = new PrintWriter(this.socket.getOutputStream(), true)).println(string);
                        if (this.din.readLine() != null) {
                            n4 = 0;
                        }
                    }
                    catch (Exception ex4) {}
                }
                if (n4 == 1) {
                    try {
                        this.socket.close();
                        this.socket = null;
                    }
                    catch (Exception ex5) {}
                    n4 = 2;
                }
                n5 = 0;
            }
            else {
                ++n5;
            }
            try {
                final Thread runner2 = this.runner;
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex6) {}
        }
        int n9 = 0;
        while (this.runon == 2) {
            int n10 = 0;
            for (int k = 0; k < 20; ++k) {
                if (!this.udpc[k].started) {
                    ++n10;
                }
            }
            if (n10 != 20) {
                ++n9;
            }
            if (n9 == 400 || n10 == 20) {
                for (int l = 0; l < 20; ++l) {
                    this.udpc[l].closeSocket();
                    this.udpc[l] = null;
                }
                this.runon = 3;
            }
            try {
                final Thread runner3 = this.runner;
                Thread.sleep(5L);
            }
            catch (InterruptedException ex7) {}
        }
        if (this.runon == 3) {
            System.gc();
            System.runFinalization();
            this.runon = 0;
            this.runner = null;
        }
        if (this.runon == 5) {
            for (int n11 = 0; n11 < this.nplayers + 2; ++n11) {
                try {
                    this.usrv[n11].stopServe();
                    this.usrv[n11] = null;
                }
                catch (Exception ex8) {}
            }
            final String string2 = "3|" + this.pgame + "|finish|";
            try {
                this.dout.println(string2);
                this.din.readLine();
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            }
            catch (Exception ex9) {}
            System.gc();
            System.runFinalization();
            this.runon = 0;
            this.runner = null;
        }
    }
    
    public void readinfo(final Mad mad, final ContO contO, final Control control, final int n, final int[] array) {
        if (this.go && this.force[n] != 7 && !this.isbot[n]) {
            this.freg += 0.05;
            int n2 = -1;
            if (n2 == -1) {
                for (int i = 0; i < 3; ++i) {
                    if (this.frame[n][i] == this.lframe[n] + 1) {
                        if ((n2 = i) == 1) {
                            this.freg -= 0.1;
                        }
                        if (i == 2) {
                            this.freg -= 0.15;
                        }
                    }
                }
            }
            if (n2 == -1) {
                int n3 = 0;
                for (int j = 0; j < 3; ++j) {
                    if (this.frame[n][j] > this.lframe[n] + 1) {
                        ++n3;
                    }
                }
                if (n3 == 3) {
                    n2 = 2;
                }
            }
            if (n2 == -1 && this.force[n] == 1) {
                for (int k = 0; k < 3; ++k) {
                    if (this.frame[n][k] >= this.lframe[n]) {
                        n2 = k;
                    }
                }
                if (n2 == -1) {
                    this.freg += 0.2;
                }
            }
            if (this.freg < -15.0f) {
                this.freg = -15.0f;
            }
            if (this.freg > 0.0f) {
                this.freg = 0.0f;
            }
            if (n2 != -1) {
                this.force[n] = 0;
                final String s = this.info[n][n2];
                final String svalue = this.getSvalue(s, 0);
                if (svalue.length() == 16) {
                    if (("" + svalue.charAt(0)).equals("0")) {
                        control.left = false;
                    }
                    else {
                        control.left = true;
                    }
                    if (("" + svalue.charAt(1)).equals("0")) {
                        control.right = false;
                    }
                    else {
                        control.right = true;
                    }
                    if (("" + svalue.charAt(2)).equals("0")) {
                        control.up = false;
                    }
                    else {
                        control.up = true;
                    }
                    if (("" + svalue.charAt(3)).equals("0")) {
                        control.down = false;
                    }
                    else {
                        control.down = true;
                    }
                    if (("" + svalue.charAt(4)).equals("0")) {
                        control.handb = false;
                    }
                    else {
                        control.handb = true;
                    }
                    if (("" + svalue.charAt(5)).equals("0")) {
                        mad.newcar = false;
                    }
                    else {
                        mad.newcar = true;
                    }
                    if (("" + svalue.charAt(6)).equals("0")) {
                        mad.mtouch = false;
                    }
                    else {
                        mad.mtouch = true;
                    }
                    if (("" + svalue.charAt(7)).equals("0")) {
                        mad.wtouch = false;
                    }
                    else {
                        mad.wtouch = true;
                    }
                    if (("" + svalue.charAt(8)).equals("0")) {
                        mad.pushed = false;
                    }
                    else {
                        mad.pushed = true;
                    }
                    if (("" + svalue.charAt(9)).equals("0")) {
                        mad.gtouch = false;
                    }
                    else {
                        mad.gtouch = true;
                    }
                    if (("" + svalue.charAt(10)).equals("0")) {
                        mad.pl = false;
                    }
                    else {
                        mad.pl = true;
                    }
                    if (("" + svalue.charAt(11)).equals("0")) {
                        mad.pr = false;
                    }
                    else {
                        mad.pr = true;
                    }
                    if (("" + svalue.charAt(12)).equals("0")) {
                        mad.pd = false;
                    }
                    else {
                        mad.pd = true;
                    }
                    if (("" + svalue.charAt(13)).equals("0")) {
                        mad.pu = false;
                    }
                    else {
                        mad.pu = true;
                    }
                    if (("" + svalue.charAt(14)).equals("0")) {
                        mad.dest = false;
                    }
                    else {
                        mad.dest = true;
                    }
                }
                else if (svalue.equals("disco")) {
                    array[n] = 3;
                    mad.hitmag = mad.cd.maxmag[mad.cn] + 100;
                    this.force[n] = 7;
                }
                if (this.force[n] != 7) {
                    final int getncoms = this.getncoms(s);
                    this.wx = 0;
                    if (getncoms > 1) {
                        contO.x = this.getvalue(s, 1);
                    }
                    if (getncoms > 2) {
                        contO.y = this.getvalue(s, 0);
                    }
                    if (getncoms > 3) {
                        contO.z = this.getvalue(s, 0);
                    }
                    if (getncoms > 4) {
                        contO.xz = this.getvalue(s, 0);
                    }
                    if (getncoms > 5) {
                        contO.xy = this.getvalue(s, 0);
                    }
                    if (getncoms > 6) {
                        contO.zy = this.getvalue(s, 0);
                    }
                    if (getncoms > 7) {
                        mad.speed = this.getvalue(s, 0) / 100.0f;
                    }
                    if (getncoms > 8) {
                        mad.power = this.getvalue(s, 0) / 100.0f;
                    }
                    if (getncoms > 9) {
                        mad.mxz = this.getvalue(s, 0);
                    }
                    if (getncoms > 10) {
                        mad.pzy = this.getvalue(s, 0);
                    }
                    if (getncoms > 11) {
                        mad.pxy = this.getvalue(s, 0);
                    }
                    if (getncoms > 12) {
                        mad.txz = this.getvalue(s, 0);
                    }
                    if (getncoms > 13) {
                        mad.loop = this.getvalue(s, 0);
                    }
                    if (getncoms > 14) {
                        contO.wxz = this.getvalue(s, 0);
                    }
                    if (getncoms > 15) {
                        mad.pcleared = this.getvalue(s, 0);
                    }
                    if (getncoms > 16) {
                        mad.clear = this.getvalue(s, 0);
                    }
                    if (getncoms > 17) {
                        mad.nlaps = this.getvalue(s, 0);
                    }
                    if (getncoms > 18) {
                        mad.hitmag = (int)(this.getvalue(s, 0) / 100.0f * mad.cd.maxmag[mad.cn]);
                    }
                }
                this.lframe[n] = this.frame[n][n2];
            }
            else if (this.force[n] == 0) {
                final int[] lframe = this.lframe;
                ++lframe[n];
                this.force[n] = 1;
            }
        }
    }
    
    public void readContOinfo(final ContO contO, final int n) {
        if (this.go && this.force[n] == 1 && !this.isbot[n]) {
            int n2 = -2;
            if (n2 == -2) {
                for (int i = 0; i < 3; ++i) {
                    if (this.frame[n][i] == this.lframe[n] + 1) {
                        n2 = -1;
                    }
                }
            }
            if (n2 == -1) {
                for (int j = 0; j < 3; ++j) {
                    if (this.frame[n][j] == this.lframe[n]) {
                        n2 = j;
                    }
                }
            }
            if (n2 > 0) {
                final String s = this.info[n][n2];
                final int getncoms = this.getncoms(s);
                this.wx = 0;
                if (getncoms > 1) {
                    contO.x = this.getvalue(s, 1);
                }
                if (getncoms > 1) {
                    contO.y = this.getvalue(s, 0);
                }
                if (getncoms > 1) {
                    contO.z = this.getvalue(s, 0);
                }
                if (getncoms > 1) {
                    contO.xz = this.getvalue(s, 0);
                }
                if (getncoms > 1) {
                    contO.xy = this.getvalue(s, 0);
                }
                if (getncoms > 1) {
                    contO.zy = this.getvalue(s, 0);
                }
            }
        }
    }
    
    public void setinfo(final Mad mad, final ContO contO, final Control control, final int n, final float n2, final boolean b, final int n3) {
        this.info[n3][0] = "";
        if (control.left) {
            final StringBuilder sb = new StringBuilder();
            final String[] array = this.info[n3];
            final int n4 = 0;
            array[n4] = sb.append(array[n4]).append("1").toString();
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            final String[] array2 = this.info[n3];
            final int n5 = 0;
            array2[n5] = sb2.append(array2[n5]).append("0").toString();
        }
        if (control.right) {
            final StringBuilder sb3 = new StringBuilder();
            final String[] array3 = this.info[n3];
            final int n6 = 0;
            array3[n6] = sb3.append(array3[n6]).append("1").toString();
        }
        else {
            final StringBuilder sb4 = new StringBuilder();
            final String[] array4 = this.info[n3];
            final int n7 = 0;
            array4[n7] = sb4.append(array4[n7]).append("0").toString();
        }
        if (control.up) {
            final StringBuilder sb5 = new StringBuilder();
            final String[] array5 = this.info[n3];
            final int n8 = 0;
            array5[n8] = sb5.append(array5[n8]).append("1").toString();
        }
        else {
            final StringBuilder sb6 = new StringBuilder();
            final String[] array6 = this.info[n3];
            final int n9 = 0;
            array6[n9] = sb6.append(array6[n9]).append("0").toString();
        }
        if (control.down) {
            final StringBuilder sb7 = new StringBuilder();
            final String[] array7 = this.info[n3];
            final int n10 = 0;
            array7[n10] = sb7.append(array7[n10]).append("1").toString();
        }
        else {
            final StringBuilder sb8 = new StringBuilder();
            final String[] array8 = this.info[n3];
            final int n11 = 0;
            array8[n11] = sb8.append(array8[n11]).append("0").toString();
        }
        if (control.handb) {
            final StringBuilder sb9 = new StringBuilder();
            final String[] array9 = this.info[n3];
            final int n12 = 0;
            array9[n12] = sb9.append(array9[n12]).append("1").toString();
        }
        else {
            final StringBuilder sb10 = new StringBuilder();
            final String[] array10 = this.info[n3];
            final int n13 = 0;
            array10[n13] = sb10.append(array10[n13]).append("0").toString();
        }
        if (mad.newcar) {
            final StringBuilder sb11 = new StringBuilder();
            final String[] array11 = this.info[n3];
            final int n14 = 0;
            array11[n14] = sb11.append(array11[n14]).append("1").toString();
        }
        else {
            final StringBuilder sb12 = new StringBuilder();
            final String[] array12 = this.info[n3];
            final int n15 = 0;
            array12[n15] = sb12.append(array12[n15]).append("0").toString();
        }
        if (mad.mtouch) {
            final StringBuilder sb13 = new StringBuilder();
            final String[] array13 = this.info[n3];
            final int n16 = 0;
            array13[n16] = sb13.append(array13[n16]).append("1").toString();
        }
        else {
            final StringBuilder sb14 = new StringBuilder();
            final String[] array14 = this.info[n3];
            final int n17 = 0;
            array14[n17] = sb14.append(array14[n17]).append("0").toString();
        }
        if (mad.wtouch) {
            final StringBuilder sb15 = new StringBuilder();
            final String[] array15 = this.info[n3];
            final int n18 = 0;
            array15[n18] = sb15.append(array15[n18]).append("1").toString();
        }
        else {
            final StringBuilder sb16 = new StringBuilder();
            final String[] array16 = this.info[n3];
            final int n19 = 0;
            array16[n19] = sb16.append(array16[n19]).append("0").toString();
        }
        if (mad.pushed) {
            final StringBuilder sb17 = new StringBuilder();
            final String[] array17 = this.info[n3];
            final int n20 = 0;
            array17[n20] = sb17.append(array17[n20]).append("1").toString();
        }
        else {
            final StringBuilder sb18 = new StringBuilder();
            final String[] array18 = this.info[n3];
            final int n21 = 0;
            array18[n21] = sb18.append(array18[n21]).append("0").toString();
        }
        if (mad.gtouch) {
            final StringBuilder sb19 = new StringBuilder();
            final String[] array19 = this.info[n3];
            final int n22 = 0;
            array19[n22] = sb19.append(array19[n22]).append("1").toString();
        }
        else {
            final StringBuilder sb20 = new StringBuilder();
            final String[] array20 = this.info[n3];
            final int n23 = 0;
            array20[n23] = sb20.append(array20[n23]).append("0").toString();
        }
        if (mad.pl) {
            final StringBuilder sb21 = new StringBuilder();
            final String[] array21 = this.info[n3];
            final int n24 = 0;
            array21[n24] = sb21.append(array21[n24]).append("1").toString();
        }
        else {
            final StringBuilder sb22 = new StringBuilder();
            final String[] array22 = this.info[n3];
            final int n25 = 0;
            array22[n25] = sb22.append(array22[n25]).append("0").toString();
        }
        if (mad.pr) {
            final StringBuilder sb23 = new StringBuilder();
            final String[] array23 = this.info[n3];
            final int n26 = 0;
            array23[n26] = sb23.append(array23[n26]).append("1").toString();
        }
        else {
            final StringBuilder sb24 = new StringBuilder();
            final String[] array24 = this.info[n3];
            final int n27 = 0;
            array24[n27] = sb24.append(array24[n27]).append("0").toString();
        }
        if (mad.pd) {
            final StringBuilder sb25 = new StringBuilder();
            final String[] array25 = this.info[n3];
            final int n28 = 0;
            array25[n28] = sb25.append(array25[n28]).append("1").toString();
        }
        else {
            final StringBuilder sb26 = new StringBuilder();
            final String[] array26 = this.info[n3];
            final int n29 = 0;
            array26[n29] = sb26.append(array26[n29]).append("0").toString();
        }
        if (mad.pu) {
            final StringBuilder sb27 = new StringBuilder();
            final String[] array27 = this.info[n3];
            final int n30 = 0;
            array27[n30] = sb27.append(array27[n30]).append("1").toString();
        }
        else {
            final StringBuilder sb28 = new StringBuilder();
            final String[] array28 = this.info[n3];
            final int n31 = 0;
            array28[n31] = sb28.append(array28[n31]).append("0").toString();
        }
        if (mad.dest) {
            final StringBuilder sb29 = new StringBuilder();
            final String[] array29 = this.info[n3];
            final int n32 = 0;
            array29[n32] = sb29.append(array29[n32]).append("1").toString();
        }
        else {
            final StringBuilder sb30 = new StringBuilder();
            final String[] array30 = this.info[n3];
            final int n33 = 0;
            array30[n33] = sb30.append(array30[n33]).append("0").toString();
        }
        if (b) {
            final StringBuilder sb31 = new StringBuilder();
            final String[] array31 = this.info[n3];
            final int n34 = 0;
            array31[n34] = sb31.append(array31[n34]).append("1").toString();
        }
        else {
            final StringBuilder sb32 = new StringBuilder();
            final String[] array32 = this.info[n3];
            final int n35 = 0;
            array32[n35] = sb32.append(array32[n35]).append("0").toString();
        }
        final StringBuilder sb33 = new StringBuilder();
        final String[] array33 = this.info[n3];
        final int n36 = 0;
        array33[n36] = sb33.append(array33[n36]).append(",").append(contO.x).append(",").append(contO.y).append(",").append(contO.z).append(",").append(contO.xz).append(",").append(contO.xy).append(",").append(contO.zy).append(",").append((int)(mad.speed * 100.0f)).append(",").append((int)(mad.power * 100.0f)).append(",").append(mad.mxz).append(",").append(mad.pzy).append(",").append(mad.pxy).append(",").append(mad.txz).append(",").append(mad.loop).append(",").append(contO.wxz).append(",").append(mad.pcleared).append(",").append(mad.clear).append(",").append(mad.nlaps).append(",").append((int)(n2 * 100.0f)).append(",").append(n).append(",").toString();
        while (this.info[n3][0].length() < 110) {
            final StringBuilder sb34 = new StringBuilder();
            final String[] array34 = this.info[n3];
            final int n37 = 0;
            array34[n37] = sb34.append(array34[n37]).append("|").toString();
        }
        if (this.runon == 2) {
            mad.hitmag = mad.cd.maxmag[mad.cn] + 100;
        }
        final int[] array35 = this.frame[n3];
        final int n38 = 0;
        ++array35[n38];
    }
    
    public int getvalue(final String s, final int n) {
        int intValue = -1;
        try {
            int n2 = 0;
            int n3 = 0;
            String string = "";
            while (this.wx < s.length() && n3 != 2) {
                final String string2 = "" + s.charAt(this.wx);
                if (string2.equals(",")) {
                    ++n2;
                    if (n3 == 1 || n2 > n) {
                        n3 = 2;
                    }
                }
                else if (n2 == n) {
                    string += string2;
                    n3 = 1;
                }
                ++this.wx;
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
                if (string2.equals(",")) {
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
    
    public int getncoms(final String s) {
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (("" + s.charAt(i)).equals(",")) {
                ++n;
            }
        }
        return n;
    }
}
