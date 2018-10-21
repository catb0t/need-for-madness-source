import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;

public class ContO
{
    Medium m;
    Trackers t;
    Plane[] p;
    int npl;
    int x;
    int y;
    int z;
    int xz;
    int xy;
    int zy;
    int wxz;
    int wzy;
    int dist;
    int maxR;
    int disp;
    int disline;
    boolean shadow;
    boolean noline;
    boolean decor;
    float grounded;
    int grat;
    int[] keyx;
    int[] keyz;
    int sprkat;
    int[] txy;
    int[] tzy;
    int[][] tc;
    int[] tradx;
    int[] tradz;
    int[] trady;
    int[] tx;
    int[] ty;
    int[] tz;
    int[] skd;
    int[] dam;
    boolean[] notwall;
    int tnt;
    int[] stg;
    int[] sx;
    int[] sy;
    int[] sz;
    int[] scx;
    int[] scz;
    float[] osmag;
    int[] sav;
    float[][] smag;
    int[][] srgb;
    float[] sbln;
    int ust;
    int srx;
    int sry;
    int srz;
    float rcx;
    float rcy;
    float rcz;
    int sprk;
    int[] rtg;
    boolean[] rbef;
    int[] rx;
    int[] ry;
    int[] rz;
    float[] vrx;
    float[] vry;
    float[] vrz;
    boolean elec;
    boolean roted;
    int[] edl;
    int[] edr;
    int[] elc;
    boolean fix;
    int fcnt;
    int checkpoint;
    int[] fcol;
    int[] scol;
    int colok;
    boolean errd;
    String err;
    int roofat;
    int wh;

    public ContO(final byte[] array, final Medium m, final Trackers t) {
        this.npl = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        this.wxz = 0;
        this.wzy = 0;
        this.dist = 0;
        this.maxR = 0;
        this.disp = 0;
        this.disline = 14;
        this.shadow = false;
        this.noline = false;
        this.decor = false;
        this.grounded = 1.0f;
        this.grat = 0;
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.sprkat = 0;
        this.tnt = 0;
        this.ust = 0;
        this.srx = 0;
        this.sry = 0;
        this.srz = 0;
        this.rcx = 0.0f;
        this.rcy = 0.0f;
        this.rcz = 0.0f;
        this.sprk = 0;
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[] { 0, 0, 0, 0 };
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.fcol = new int[] { 0, 0, 0 };
        this.scol = new int[] { 0, 0, 0 };
        this.colok = 0;
        this.errd = false;
        this.err = "";
        this.roofat = 0;
        this.wh = 0;
        this.m = m;
        this.t = t;
        this.p = new Plane[286];
        final int[] array2 = new int[286];
        for (int i = 0; i < 286; ++i) {
            array2[i] = 0;
        }
        if (this.m.loadnew) {
            for (int j = 0; j < 4; ++j) {
                this.keyz[j] = 0;
            }
            this.shadow = true;
        }
        String string = "";
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        float n4 = 1.0f;
        float n5 = 1.0f;
        final float[] array3 = { 1.0f, 1.0f, 1.0f };
        final int[] array4 = new int[100];
        final int[] array5 = new int[100];
        final int[] array6 = new int[100];
        final int[] array7 = { 0, 0, 0 };
        boolean b = false;
        final Wheels wheels = new Wheels();
        boolean b2 = false;
        int n6 = 0;
        int getvalue = 1;
        int getvalue2 = 0;
        int getvalue3 = 0;
        int n7 = 0;
        int n8 = 0;
        boolean b3 = false;
        int n9 = 0;
        try {
            final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(array));
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                string = "" + line.trim();
                if (this.npl < 210) {
                    if (string.startsWith("<p>")) {
                        n = 1;
                        n3 = 0;
                        getvalue = 0;
                        getvalue2 = 0;
                        n7 = 0;
                        array2[this.npl] = 1;
                        if (n9 == 0) {
                            b3 = false;
                        }
                    }
                    if (n != 0) {
                        if (string.startsWith("gr(")) {
                            getvalue = this.getvalue("gr", string, 0);
                        }
                        if (string.startsWith("fs(")) {
                            getvalue2 = this.getvalue("fs", string, 0);
                            array2[this.npl] = 2;
                        }
                        if (string.startsWith("c(")) {
                            n8 = 0;
                            array7[0] = this.getvalue("c", string, 0);
                            array7[1] = this.getvalue("c", string, 1);
                            array7[2] = this.getvalue("c", string, 2);
                        }
                        if (string.startsWith("glass")) {
                            n8 = 1;
                        }
                        if (string.startsWith("gshadow")) {
                            n8 = 2;
                        }
                        if (string.startsWith("lightF")) {
                            n7 = 1;
                        }
                        if (string.startsWith("light")) {
                            n7 = 1;
                        }
                        if (string.startsWith("lightB")) {
                            n7 = 2;
                        }
                        if (string.startsWith("noOutline")) {
                            b3 = true;
                        }
                        if (string.startsWith("p(")) {
                            array4[n3] = (int)(this.getvalue("p", string, 0) * n4 * n5 * array3[0]);
                            array5[n3] = (int)(this.getvalue("p", string, 1) * n4 * array3[1]);
                            array6[n3] = (int)(this.getvalue("p", string, 2) * n4 * array3[2]);
                            final int maxR = (int)Math.sqrt(array4[n3] * array4[n3] + array5[n3] * array5[n3] + array6[n3] * array6[n3]);
                            if (maxR > this.maxR) {
                                this.maxR = maxR;
                            }
                            ++n3;
                        }
                    }
                    if (string.startsWith("</p>")) {
                        this.p[this.npl] = new Plane(this.m, this.t, array4, array6, array5, n3, array7, n8, getvalue, getvalue2, 0, 0, 0, this.disline, 0, b, n7, b3);
                        if (array7[0] == this.fcol[0] && array7[1] == this.fcol[1] && array7[2] == this.fcol[2] && n8 == 0) {
                            this.p[this.npl].colnum = 1;
                        }
                        if (array7[0] == this.scol[0] && array7[1] == this.scol[1] && array7[2] == this.scol[2] && n8 == 0) {
                            this.p[this.npl].colnum = 2;
                        }
                        ++this.npl;
                        n = 0;
                    }
                }
                if (string.startsWith("rims(")) {
                    wheels.setrims(this.getvalue("rims", string, 0), this.getvalue("rims", string, 1), this.getvalue("rims", string, 2), this.getvalue("rims", string, 3), this.getvalue("rims", string, 4));
                }
                if (string.startsWith("w(") && n6 < 4) {
                    this.keyx[n6] = (int)(this.getvalue("w", string, 0) * n4 * array3[0]);
                    this.keyz[n6] = (int)(this.getvalue("w", string, 2) * n4 * array3[2]);
                    wheels.make(this.m, this.t, this.p, this.npl, (int)(this.getvalue("w", string, 0) * n4 * n5 * array3[0]), (int)(this.getvalue("w", string, 1) * n4 * array3[1]), (int)(this.getvalue("w", string, 2) * n4 * array3[2]), this.getvalue("w", string, 3), (int)(this.getvalue("w", string, 4) * n4 * n5), (int)(this.getvalue("w", string, 5) * n4), getvalue3);
                    this.npl += 19;
                    if (this.m.loadnew) {
                        this.wh += (int)(this.getvalue("w", string, 5) * n4);
                        if (wheels.ground > 140) {
                            String s = "FRONT";
                            if (this.keyz[n6] < 0) {
                                s = "BACK";
                            }
                            this.err = "Wheels Error:\n" + s + " Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the " + s + " Wheels or decrease its height.     \n \n";
                            this.errd = true;
                            this.keyz[n6] = 0;
                            this.keyx[n6] = 0;
                        }
                        if (wheels.ground < -100) {
                            String s2 = "FRONT";
                            if (this.keyz[n6] < 0) {
                                s2 = "BACK";
                            }
                            this.err = "Wheels Error:\n" + s2 + " Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the " + s2 + " Wheels or increase its height.     \n \n";
                            this.errd = true;
                            this.keyz[n6] = 0;
                            this.keyx[n6] = 0;
                        }
                        if (Math.abs(this.keyx[n6]) > 400) {
                            String s3 = "FRONT";
                            if (this.keyz[n6] < 0) {
                                s3 = "BACK";
                            }
                            this.err = "Wheels Error:\n" + s3 + " Wheels are too far apart!    \n\nPlease decrease the ±X value of the " + s3 + " Wheels.     \n \n";
                            this.errd = true;
                            this.keyz[n6] = 0;
                            this.keyx[n6] = 0;
                        }
                        if (Math.abs(this.keyz[n6]) > 700) {
                            if (this.keyz[n6] < 0) {
                                this.err = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n";
                            }
                            else {
                                this.err = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n";
                            }
                            this.errd = true;
                            this.keyz[n6] = 0;
                            this.keyx[n6] = 0;
                        }
                        if ((int)(this.getvalue("w", string, 4) * n4 * n5) > 300) {
                            String s4 = "FRONT";
                            if (this.keyz[n6] < 0) {
                                s4 = "BACK";
                            }
                            this.err = "Wheels Error:\nWidth of the " + s4 + " Wheels is too large!    \n\nPlease decrease the width of the " + s4 + " Wheels.     \n \n";
                            this.errd = true;
                            this.keyz[n6] = 0;
                            this.keyx[n6] = 0;
                        }
                    }
                    ++n6;
                }
                if (string.startsWith("tracks")) {
                    final int getvalue4 = this.getvalue("tracks", string, 0);
                    this.txy = new int[getvalue4];
                    this.tzy = new int[getvalue4];
                    this.tc = new int[getvalue4][3];
                    this.tradx = new int[getvalue4];
                    this.tradz = new int[getvalue4];
                    this.trady = new int[getvalue4];
                    this.tx = new int[getvalue4];
                    this.ty = new int[getvalue4];
                    this.tz = new int[getvalue4];
                    this.skd = new int[getvalue4];
                    this.dam = new int[getvalue4];
                    this.notwall = new boolean[getvalue4];
                    b2 = true;
                }
                if (b2) {
                    if (string.startsWith("<track>")) {
                        n2 = 1;
                        this.notwall[this.tnt] = false;
                        this.dam[this.tnt] = 1;
                        this.skd[this.tnt] = 0;
                        this.ty[this.tnt] = 0;
                        this.tx[this.tnt] = 0;
                        this.tz[this.tnt] = 0;
                        this.txy[this.tnt] = 0;
                        this.tzy[this.tnt] = 0;
                        this.trady[this.tnt] = 0;
                        this.tradx[this.tnt] = 0;
                        this.tradz[this.tnt] = 0;
                        this.tc[this.tnt][0] = 0;
                        this.tc[this.tnt][1] = 0;
                        this.tc[this.tnt][2] = 0;
                    }
                    if (n2 != 0) {
                        if (string.startsWith("c")) {
                            this.tc[this.tnt][0] = this.getvalue("c", string, 0);
                            this.tc[this.tnt][1] = this.getvalue("c", string, 1);
                            this.tc[this.tnt][2] = this.getvalue("c", string, 2);
                        }
                        if (string.startsWith("xy")) {
                            this.txy[this.tnt] = this.getvalue("xy", string, 0);
                        }
                        if (string.startsWith("zy")) {
                            this.tzy[this.tnt] = this.getvalue("zy", string, 0);
                        }
                        if (string.startsWith("radx")) {
                            this.tradx[this.tnt] = (int)(this.getvalue("radx", string, 0) * n4);
                        }
                        if (string.startsWith("rady")) {
                            this.trady[this.tnt] = (int)(this.getvalue("rady", string, 0) * n4);
                        }
                        if (string.startsWith("radz")) {
                            this.tradz[this.tnt] = (int)(this.getvalue("radz", string, 0) * n4);
                        }
                        if (string.startsWith("ty")) {
                            this.ty[this.tnt] = (int)(this.getvalue("ty", string, 0) * n4);
                        }
                        if (string.startsWith("tx")) {
                            this.tx[this.tnt] = (int)(this.getvalue("tx", string, 0) * n4);
                        }
                        if (string.startsWith("tz")) {
                            this.tz[this.tnt] = (int)(this.getvalue("tz", string, 0) * n4);
                        }
                        if (string.startsWith("skid")) {
                            this.skd[this.tnt] = this.getvalue("skid", string, 0);
                        }
                        if (string.startsWith("dam")) {
                            this.dam[this.tnt] = 3;
                        }
                        if (string.startsWith("notwall")) {
                            this.notwall[this.tnt] = true;
                        }
                    }
                    if (string.startsWith("</track>")) {
                        n2 = 0;
                        ++this.tnt;
                    }
                }
                if (string.startsWith("disp(")) {
                    this.disp = this.getvalue("disp", string, 0);
                }
                if (string.startsWith("disline(")) {
                    this.disline = this.getvalue("disline", string, 0) * 2;
                }
                if (string.startsWith("shadow")) {
                    this.shadow = true;
                }
                if (string.startsWith("stonecold")) {
                    this.noline = true;
                }
                if (string.startsWith("newstone")) {
                    this.noline = true;
                    b3 = true;
                    n9 = 1;
                }
                if (string.startsWith("decorative")) {
                    this.decor = true;
                }
                if (string.startsWith("road")) {
                    b = true;
                }
                if (string.startsWith("notroad")) {
                    b = false;
                }
                if (string.startsWith("grounded(")) {
                    this.grounded = this.getvalue("grounded", string, 0) / 100.0f;
                }
                if (string.startsWith("div(")) {
                    n4 = this.getvalue("div", string, 0) / 10.0f;
                }
                if (string.startsWith("idiv(")) {
                    n4 = this.getvalue("idiv", string, 0) / 100.0f;
                }
                if (string.startsWith("iwid(")) {
                    n5 = this.getvalue("iwid", string, 0) / 100.0f;
                }
                if (string.startsWith("ScaleX(")) {
                    array3[0] = this.getvalue("ScaleX", string, 0) / 100.0f;
                }
                if (string.startsWith("ScaleY(")) {
                    array3[1] = this.getvalue("ScaleY", string, 0) / 100.0f;
                }
                if (string.startsWith("ScaleZ(")) {
                    array3[2] = this.getvalue("ScaleZ", string, 0) / 100.0f;
                }
                if (string.startsWith("gwgr(")) {
                    getvalue3 = this.getvalue("gwgr", string, 0);
                    if (this.m.loadnew) {
                        if (getvalue3 > 40) {
                            getvalue3 = 40;
                        }
                        if (getvalue3 < 0 && getvalue3 >= -15) {
                            getvalue3 = -16;
                        }
                        if (getvalue3 < -40) {
                            getvalue3 = -40;
                        }
                    }
                }
                if (string.startsWith("1stColor(")) {
                    this.fcol[0] = this.getvalue("1stColor", string, 0);
                    this.fcol[1] = this.getvalue("1stColor", string, 1);
                    this.fcol[2] = this.getvalue("1stColor", string, 2);
                    ++this.colok;
                }
                if (string.startsWith("2ndColor(")) {
                    this.scol[0] = this.getvalue("2ndColor", string, 0);
                    this.scol[1] = this.getvalue("2ndColor", string, 1);
                    this.scol[2] = this.getvalue("2ndColor", string, 2);
                    ++this.colok;
                }
            }
            dataInputStream.close();
        }
        catch (Exception ex) {
            if (!this.errd) {
                this.err = "Error While Loading 3D Model\n\nLine:     " + string + "\n\nError Detail:\n" + ex + "           \n \n";
                System.out.println(this.err);
                this.errd = true;
            }
        }
        this.grat = wheels.ground;
        this.sprkat = wheels.sparkat;
        if (this.shadow) {
            this.stg = new int[20];
            this.rtg = new int[100];
            for (int k = 0; k < 20; ++k) {
                this.stg[k] = 0;
            }
            for (int l = 0; l < 100; ++l) {
                this.rtg[l] = 0;
            }
        }
        if (this.m.loadnew) {
            if (n6 != 0) {
                this.wh /= n6;
            }
            int n10 = 0;
            for (int n11 = 0; n11 < this.npl; ++n11) {
                int n12 = 0;
                int n13 = this.p[n11].ox[0];
                int n14 = this.p[n11].ox[0];
                int n15 = this.p[n11].oy[0];
                int n16 = this.p[n11].oy[0];
                int n17 = this.p[n11].oz[0];
                int n18 = this.p[n11].oz[0];
                for (int n19 = 0; n19 < this.p[n11].n; ++n19) {
                    if (this.p[n11].ox[n19] > n13) {
                        n13 = this.p[n11].ox[n19];
                    }
                    if (this.p[n11].ox[n19] < n14) {
                        n14 = this.p[n11].ox[n19];
                    }
                    if (this.p[n11].oy[n19] > n15) {
                        n15 = this.p[n11].oy[n19];
                    }
                    if (this.p[n11].oy[n19] < n16) {
                        n16 = this.p[n11].oy[n19];
                    }
                    if (this.p[n11].oz[n19] > n17) {
                        n17 = this.p[n11].oz[n19];
                    }
                    if (this.p[n11].oz[n19] < n18) {
                        n18 = this.p[n11].oz[n19];
                    }
                }
                if (Math.abs(n13 - n14) <= Math.abs(n15 - n16) && Math.abs(n13 - n14) <= Math.abs(n17 - n18)) {
                    n12 = 1;
                }
                if (Math.abs(n15 - n16) <= Math.abs(n13 - n14) && Math.abs(n15 - n16) <= Math.abs(n17 - n18)) {
                    n12 = 2;
                }
                if (Math.abs(n17 - n18) <= Math.abs(n13 - n14) && Math.abs(n17 - n18) <= Math.abs(n15 - n16)) {
                    n12 = 3;
                }
                if (n12 == 2 && (n10 == 0 || (n15 + n16) / 2 < this.roofat)) {
                    this.roofat = (n15 + n16) / 2;
                    n10 = 1;
                }
                if (array2[n11] == 1) {
                    int n20 = 1000;
                    int n21 = 0;
                    for (int n22 = 0; n22 < this.p[n11].n; ++n22) {
                        int n23 = n22 + 1;
                        if (n23 >= this.p[n11].n) {
                            n23 -= this.p[n11].n;
                        }
                        int n24 = n22 + 2;
                        if (n24 >= this.p[n11].n) {
                            n24 -= this.p[n11].n;
                        }
                        if (n12 == 1) {
                            int abs = Math.abs((int)(Math.atan((this.p[n11].oz[n22] - this.p[n11].oz[n23]) / (this.p[n11].oy[n22] - this.p[n11].oy[n23])) / 0.017453292519943295));
                            int abs2 = Math.abs((int)(Math.atan((this.p[n11].oz[n24] - this.p[n11].oz[n23]) / (this.p[n11].oy[n24] - this.p[n11].oy[n23])) / 0.017453292519943295));
                            if (abs > 45) {
                                abs = 90 - abs;
                            }
                            else {
                                abs2 = 90 - abs2;
                            }
                            if (abs + abs2 < n20) {
                                n20 = abs + abs2;
                                n21 = n22;
                            }
                        }
                        if (n12 == 2) {
                            int abs3 = Math.abs((int)(Math.atan((this.p[n11].oz[n22] - this.p[n11].oz[n23]) / (this.p[n11].ox[n22] - this.p[n11].ox[n23])) / 0.017453292519943295));
                            int abs4 = Math.abs((int)(Math.atan((this.p[n11].oz[n24] - this.p[n11].oz[n23]) / (this.p[n11].ox[n24] - this.p[n11].ox[n23])) / 0.017453292519943295));
                            if (abs3 > 45) {
                                abs3 = 90 - abs3;
                            }
                            else {
                                abs4 = 90 - abs4;
                            }
                            if (abs3 + abs4 < n20) {
                                n20 = abs3 + abs4;
                                n21 = n22;
                            }
                        }
                        if (n12 == 3) {
                            int abs5 = Math.abs((int)(Math.atan((this.p[n11].oy[n22] - this.p[n11].oy[n23]) / (this.p[n11].ox[n22] - this.p[n11].ox[n23])) / 0.017453292519943295));
                            int abs6 = Math.abs((int)(Math.atan((this.p[n11].oy[n24] - this.p[n11].oy[n23]) / (this.p[n11].ox[n24] - this.p[n11].ox[n23])) / 0.017453292519943295));
                            if (abs5 > 45) {
                                abs5 = 90 - abs5;
                            }
                            else {
                                abs6 = 90 - abs6;
                            }
                            if (abs5 + abs6 < n20) {
                                n20 = abs5 + abs6;
                                n21 = n22;
                            }
                        }
                    }
                    if (n21 != 0) {
                        final int[] array8 = new int[this.p[n11].n];
                        final int[] array9 = new int[this.p[n11].n];
                        final int[] array10 = new int[this.p[n11].n];
                        for (int n25 = 0; n25 < this.p[n11].n; ++n25) {
                            array8[n25] = this.p[n11].ox[n25];
                            array9[n25] = this.p[n11].oy[n25];
                            array10[n25] = this.p[n11].oz[n25];
                        }
                        for (int n26 = 0; n26 < this.p[n11].n; ++n26) {
                            int n27 = n26 + n21;
                            if (n27 >= this.p[n11].n) {
                                n27 -= this.p[n11].n;
                            }
                            this.p[n11].ox[n26] = array8[n27];
                            this.p[n11].oy[n26] = array9[n27];
                            this.p[n11].oz[n26] = array10[n27];
                        }
                    }
                    if (n12 == 1) {
                        if (Math.abs(this.p[n11].oz[0] - this.p[n11].oz[1]) > Math.abs(this.p[n11].oy[0] - this.p[n11].oy[1])) {
                            if (this.p[n11].oz[0] > this.p[n11].oz[1]) {
                                if (this.p[n11].oy[1] > this.p[n11].oy[2]) {
                                    this.p[n11].fs = 1;
                                }
                                else {
                                    this.p[n11].fs = -1;
                                }
                            }
                            else if (this.p[n11].oy[1] > this.p[n11].oy[2]) {
                                this.p[n11].fs = -1;
                            }
                            else {
                                this.p[n11].fs = 1;
                            }
                        }
                        else if (this.p[n11].oy[0] > this.p[n11].oy[1]) {
                            if (this.p[n11].oz[1] > this.p[n11].oz[2]) {
                                this.p[n11].fs = -1;
                            }
                            else {
                                this.p[n11].fs = 1;
                            }
                        }
                        else if (this.p[n11].oz[1] > this.p[n11].oz[2]) {
                            this.p[n11].fs = 1;
                        }
                        else {
                            this.p[n11].fs = -1;
                        }
                    }
                    if (n12 == 2) {
                        if (Math.abs(this.p[n11].oz[0] - this.p[n11].oz[1]) > Math.abs(this.p[n11].ox[0] - this.p[n11].ox[1])) {
                            if (this.p[n11].oz[0] > this.p[n11].oz[1]) {
                                if (this.p[n11].ox[1] > this.p[n11].ox[2]) {
                                    this.p[n11].fs = -1;
                                }
                                else {
                                    this.p[n11].fs = 1;
                                }
                            }
                            else if (this.p[n11].ox[1] > this.p[n11].ox[2]) {
                                this.p[n11].fs = 1;
                            }
                            else {
                                this.p[n11].fs = -1;
                            }
                        }
                        else if (this.p[n11].ox[0] > this.p[n11].ox[1]) {
                            if (this.p[n11].oz[1] > this.p[n11].oz[2]) {
                                this.p[n11].fs = 1;
                            }
                            else {
                                this.p[n11].fs = -1;
                            }
                        }
                        else if (this.p[n11].oz[1] > this.p[n11].oz[2]) {
                            this.p[n11].fs = -1;
                        }
                        else {
                            this.p[n11].fs = 1;
                        }
                    }
                    if (n12 == 3) {
                        if (Math.abs(this.p[n11].oy[0] - this.p[n11].oy[1]) > Math.abs(this.p[n11].ox[0] - this.p[n11].ox[1])) {
                            if (this.p[n11].oy[0] > this.p[n11].oy[1]) {
                                if (this.p[n11].ox[1] > this.p[n11].ox[2]) {
                                    this.p[n11].fs = 1;
                                }
                                else {
                                    this.p[n11].fs = -1;
                                }
                            }
                            else if (this.p[n11].ox[1] > this.p[n11].ox[2]) {
                                this.p[n11].fs = -1;
                            }
                            else {
                                this.p[n11].fs = 1;
                            }
                        }
                        else if (this.p[n11].ox[0] > this.p[n11].ox[1]) {
                            if (this.p[n11].oy[1] > this.p[n11].oy[2]) {
                                this.p[n11].fs = -1;
                            }
                            else {
                                this.p[n11].fs = 1;
                            }
                        }
                        else if (this.p[n11].oy[1] > this.p[n11].oy[2]) {
                            this.p[n11].fs = 1;
                        }
                        else {
                            this.p[n11].fs = -1;
                        }
                    }
                    boolean b4 = false;
                    boolean b5 = false;
                    for (int n28 = 0; n28 < this.npl; ++n28) {
                        if (n28 != n11 && array2[n28] != 0) {
                            int n29 = this.p[n28].ox[0];
                            int n30 = this.p[n28].ox[0];
                            int n31 = this.p[n28].oy[0];
                            int n32 = this.p[n28].oy[0];
                            int n33 = this.p[n28].oz[0];
                            int n34 = this.p[n28].oz[0];
                            for (int n35 = 0; n35 < this.p[n28].n; ++n35) {
                                if (this.p[n28].ox[n35] > n29) {
                                    n29 = this.p[n28].ox[n35];
                                }
                                if (this.p[n28].ox[n35] < n30) {
                                    n30 = this.p[n28].ox[n35];
                                }
                                if (this.p[n28].oy[n35] > n31) {
                                    n31 = this.p[n28].oy[n35];
                                }
                                if (this.p[n28].oy[n35] < n32) {
                                    n32 = this.p[n28].oy[n35];
                                }
                                if (this.p[n28].oz[n35] > n33) {
                                    n33 = this.p[n28].oz[n35];
                                }
                                if (this.p[n28].oz[n35] < n34) {
                                    n34 = this.p[n28].oz[n35];
                                }
                            }
                            final int n36 = (n29 + n30) / 2;
                            final int n37 = (n31 + n32) / 2;
                            final int n38 = (n33 + n34) / 2;
                            final int n39 = (n13 + n14) / 2;
                            final int n40 = (n15 + n16) / 2;
                            final int n41 = (n17 + n18) / 2;
                            if (n12 == 1 && ((n37 <= n15 && n37 >= n16 && n38 <= n17 && n38 >= n18) || (n40 <= n31 && n40 >= n32 && n41 <= n33 && n41 >= n34))) {
                                if (n29 < n14) {
                                    b4 = true;
                                }
                                if (n30 > n13) {
                                    b5 = true;
                                }
                            }
                            if (n12 == 2 && ((n36 <= n13 && n36 >= n14 && n38 <= n17 && n38 >= n18) || (n39 <= n29 && n39 >= n30 && n41 <= n33 && n41 >= n34))) {
                                if (n31 < n16) {
                                    b4 = true;
                                }
                                if (n32 > n15) {
                                    b5 = true;
                                }
                            }
                            if (n12 == 3 && ((n36 <= n13 && n36 >= n14 && n37 <= n15 && n37 >= n16) || (n39 <= n29 && n39 >= n30 && n40 <= n31 && n40 >= n32))) {
                                if (n33 < n18) {
                                    b4 = true;
                                }
                                if (n34 > n17) {
                                    b5 = true;
                                }
                            }
                        }
                        if (b4 && b5) {
                            break;
                        }
                    }
                    boolean b6 = false;
                    if (b4 && !b5) {
                        b6 = true;
                    }
                    if (b5 && !b4) {
                        final Plane plane = this.p[n11];
                        plane.fs *= -1;
                        b6 = true;
                    }
                    if (b4 && b5) {
                        this.p[n11].fs = 0;
                        this.p[n11].gr = 40;
                        b6 = true;
                    }
                    if (!b6) {
                        int n42 = 0;
                        int n43 = 0;
                        if (n12 == 1) {
                            n42 = (n43 = (n13 + n14) / 2);
                        }
                        if (n12 == 2) {
                            n42 = (n43 = (n15 + n16) / 2);
                        }
                        if (n12 == 3) {
                            n42 = (n43 = (n17 + n18) / 2);
                        }
                        for (int n44 = 0; n44 < this.npl; ++n44) {
                            if (n44 != n11) {
                                boolean b7 = false;
                                final boolean[] array11 = new boolean[this.p[n44].n];
                                for (int n45 = 0; n45 < this.p[n44].n; ++n45) {
                                    array11[n45] = false;
                                    for (int n46 = 0; n46 < this.p[n11].n; ++n46) {
                                        if (this.p[n11].ox[n46] == this.p[n44].ox[n45] && this.p[n11].oy[n46] == this.p[n44].oy[n45] && this.p[n11].oz[n46] == this.p[n44].oz[n45]) {
                                            array11[n45] = true;
                                            b7 = true;
                                        }
                                    }
                                }
                                if (b7) {
                                    for (int n47 = 0; n47 < this.p[n44].n; ++n47) {
                                        if (!array11[n47]) {
                                            if (n12 == 1) {
                                                if (this.p[n44].ox[n47] > n42) {
                                                    n42 = this.p[n44].ox[n47];
                                                }
                                                if (this.p[n44].ox[n47] < n43) {
                                                    n43 = this.p[n44].ox[n47];
                                                }
                                            }
                                            if (n12 == 2) {
                                                if (this.p[n44].oy[n47] > n42) {
                                                    n42 = this.p[n44].oy[n47];
                                                }
                                                if (this.p[n44].oy[n47] < n43) {
                                                    n43 = this.p[n44].oy[n47];
                                                }
                                            }
                                            if (n12 == 3) {
                                                if (this.p[n44].oz[n47] > n42) {
                                                    n42 = this.p[n44].oz[n47];
                                                }
                                                if (this.p[n44].oz[n47] < n43) {
                                                    n43 = this.p[n44].oz[n47];
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (n12 == 1) {
                            if ((n42 + n43) / 2 > (n13 + n14) / 2) {
                                final Plane plane2 = this.p[n11];
                                plane2.fs *= -1;
                            }
                            else if ((n42 + n43) / 2 == (n13 + n14) / 2 && (n13 + n14) / 2 < 0) {
                                final Plane plane3 = this.p[n11];
                                plane3.fs *= -1;
                            }
                        }
                        if (n12 == 2) {
                            if ((n42 + n43) / 2 > (n15 + n16) / 2) {
                                final Plane plane4 = this.p[n11];
                                plane4.fs *= -1;
                            }
                            else if ((n42 + n43) / 2 == (n15 + n16) / 2 && (n15 + n16) / 2 < 0) {
                                final Plane plane5 = this.p[n11];
                                plane5.fs *= -1;
                            }
                        }
                        if (n12 == 3) {
                            if ((n42 + n43) / 2 > (n17 + n18) / 2) {
                                final Plane plane6 = this.p[n11];
                                plane6.fs *= -1;
                            }
                            else if ((n42 + n43) / 2 == (n17 + n18) / 2 && (n17 + n18) / 2 < 0) {
                                final Plane plane7 = this.p[n11];
                                plane7.fs *= -1;
                            }
                        }
                    }
                    this.p[n11].deltafntyp();
                }
            }
        }
    }

    public ContO(final ContO contO, final int x, final int y, final int z, final int n) {
        this.npl = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        this.wxz = 0;
        this.wzy = 0;
        this.dist = 0;
        this.maxR = 0;
        this.disp = 0;
        this.disline = 14;
        this.shadow = false;
        this.noline = false;
        this.decor = false;
        this.grounded = 1.0f;
        this.grat = 0;
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.sprkat = 0;
        this.tnt = 0;
        this.ust = 0;
        this.srx = 0;
        this.sry = 0;
        this.srz = 0;
        this.rcx = 0.0f;
        this.rcy = 0.0f;
        this.rcz = 0.0f;
        this.sprk = 0;
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[] { 0, 0, 0, 0 };
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.fcol = new int[] { 0, 0, 0 };
        this.scol = new int[] { 0, 0, 0 };
        this.colok = 0;
        this.errd = false;
        this.err = "";
        this.roofat = 0;
        this.wh = 0;
        this.m = contO.m;
        this.t = contO.t;
        this.npl = contO.npl;
        this.maxR = contO.maxR;
        this.disp = contO.disp;
        this.disline = contO.disline;
        this.noline = contO.noline;
        this.shadow = contO.shadow;
        this.grounded = contO.grounded;
        this.decor = contO.decor;
        if (this.m.loadnew && (n == 90 || n == -90)) {
            this.grounded += 10000.0f;
        }
        this.grat = contO.grat;
        this.sprkat = contO.sprkat;
        this.p = new Plane[contO.npl];
        for (int i = 0; i < this.npl; ++i) {
            if (contO.p[i].master == 1) {
                contO.p[i].n = 20;
            }
            this.p[i] = new Plane(this.m, this.t, contO.p[i].ox, contO.p[i].oz, contO.p[i].oy, contO.p[i].n, contO.p[i].oc, contO.p[i].glass, contO.p[i].gr, contO.p[i].fs, contO.p[i].wx, contO.p[i].wy, contO.p[i].wz, contO.disline, contO.p[i].bfase, contO.p[i].road, contO.p[i].light, contO.p[i].solo);
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        for (int j = 0; j < this.npl; ++j) {
            this.p[j].colnum = contO.p[j].colnum;
            this.p[j].master = contO.p[j].master;
            this.p[j].rot(this.p[j].ox, this.p[j].oz, 0, 0, n, this.p[j].n);
            this.p[j].loadprojf();
        }
        if (contO.tnt != 0) {
            for (int k = 0; k < contO.tnt; ++k) {
                this.t.xy[this.t.nt] = (int)(contO.txy[k] * this.m.cos(n) - contO.tzy[k] * this.m.sin(n));
                this.t.zy[this.t.nt] = (int)(contO.tzy[k] * this.m.cos(n) + contO.txy[k] * this.m.sin(n));
                for (int l = 0; l < 3; ++l) {
                    this.t.c[this.t.nt][l] = (int)(contO.tc[k][l] + contO.tc[k][l] * (this.m.snap[l] / 100.0f));
                    if (this.t.c[this.t.nt][l] > 255) {
                        this.t.c[this.t.nt][l] = 255;
                    }
                    if (this.t.c[this.t.nt][l] < 0) {
                        this.t.c[this.t.nt][l] = 0;
                    }
                }
                this.t.x[this.t.nt] = (int)(this.x + contO.tx[k] * this.m.cos(n) - contO.tz[k] * this.m.sin(n));
                this.t.z[this.t.nt] = (int)(this.z + contO.tz[k] * this.m.cos(n) + contO.tx[k] * this.m.sin(n));
                this.t.y[this.t.nt] = this.y + contO.ty[k];
                this.t.skd[this.t.nt] = contO.skd[k];
                this.t.dam[this.t.nt] = contO.dam[k];
                this.t.notwall[this.t.nt] = contO.notwall[k];
                if (this.decor) {
                    this.t.decor[this.t.nt] = true;
                }
                else {
                    this.t.decor[this.t.nt] = false;
                }
                int abs = Math.abs(n);
                if (abs == 180) {
                    abs = 0;
                }
                this.t.radx[this.t.nt] = (int)Math.abs(contO.tradx[k] * this.m.cos(abs) + contO.tradz[k] * this.m.sin(abs));
                this.t.radz[this.t.nt] = (int)Math.abs(contO.tradx[k] * this.m.sin(abs) + contO.tradz[k] * this.m.cos(abs));
                this.t.rady[this.t.nt] = contO.trady[k];
                final Trackers t = this.t;
                ++t.nt;
            }
        }
        for (int n2 = 0; n2 < 4; ++n2) {
            this.keyx[n2] = contO.keyx[n2];
            this.keyz[n2] = contO.keyz[n2];
        }
        if (this.shadow) {
            this.stg = new int[20];
            this.sx = new int[20];
            this.sy = new int[20];
            this.sz = new int[20];
            this.scx = new int[20];
            this.scz = new int[20];
            this.osmag = new float[20];
            this.sav = new int[20];
            this.smag = new float[20][8];
            this.srgb = new int[20][3];
            this.sbln = new float[20];
            this.ust = 0;
            for (int n3 = 0; n3 < 20; ++n3) {
                this.stg[n3] = 0;
            }
            this.rtg = new int[100];
            this.rbef = new boolean[100];
            this.rx = new int[100];
            this.ry = new int[100];
            this.rz = new int[100];
            this.vrx = new float[100];
            this.vry = new float[100];
            this.vrz = new float[100];
            for (int n4 = 0; n4 < 100; ++n4) {
                this.rtg[n4] = 0;
            }
        }
    }

    public ContO(final int n, final int n2, final int n3, final Medium m, final Trackers t, final int x, final int z, final int y) {
        this.npl = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        this.wxz = 0;
        this.wzy = 0;
        this.dist = 0;
        this.maxR = 0;
        this.disp = 0;
        this.disline = 14;
        this.shadow = false;
        this.noline = false;
        this.decor = false;
        this.grounded = 1.0f;
        this.grat = 0;
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.sprkat = 0;
        this.tnt = 0;
        this.ust = 0;
        this.srx = 0;
        this.sry = 0;
        this.srz = 0;
        this.rcx = 0.0f;
        this.rcy = 0.0f;
        this.rcz = 0.0f;
        this.sprk = 0;
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[] { 0, 0, 0, 0 };
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.fcol = new int[] { 0, 0, 0 };
        this.scol = new int[] { 0, 0, 0 };
        this.colok = 0;
        this.errd = false;
        this.err = "";
        this.roofat = 0;
        this.wh = 0;
        this.m = m;
        this.t = t;
        this.x = x;
        this.z = z;
        this.y = y;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        this.grat = 0;
        this.sprkat = 0;
        this.disline = 4;
        this.noline = true;
        this.shadow = false;
        this.grounded = 115.0f;
        this.decor = true;
        this.npl = 5;
        this.p = new Plane[5];
        final Random random = new Random(n);
        final int[] array = new int[8];
        final int[] array2 = new int[8];
        final int[] array3 = new int[8];
        final int[] array4 = new int[8];
        final int[] array5 = new int[8];
        float n4 = n2;
        float n5 = n3;
        if (n5 < 2.0f) {
            n5 = 2.0f;
        }
        if (n5 > 6.0f) {
            n5 = 6.0f;
        }
        if (n4 < 2.0f) {
            n4 = 2.0f;
        }
        if (n4 > 6.0f) {
            n4 = 6.0f;
        }
        final float n6 = n4 / 1.5f;
        final float n7 = n5 / 1.5f * (1.0f + (n6 - 2.0f) * 0.1786f);
        final float n8 = (float)(50.0 + 100.0 * random.nextDouble());
        array[0] = -(int)(n8 * n6 * 0.7071f);
        array2[0] = (int)(n8 * n6 * 0.7071f);
        final float n9 = (float)(50.0 + 100.0 * random.nextDouble());
        array[1] = 0;
        array2[1] = (int)(n9 * n6);
        final float n10 = (float)(50.0 + 100.0 * random.nextDouble());
        array[2] = (int)(n10 * n6 * 0.7071);
        array2[2] = (int)(n10 * n6 * 0.7071);
        array[3] = (int)((float)(50.0 + 100.0 * random.nextDouble()) * n6);
        array2[3] = 0;
        final float n11 = (float)(50.0 + 100.0 * random.nextDouble());
        array[4] = (int)(n11 * n6 * 0.7071);
        array2[4] = -(int)(n11 * n6 * 0.7071);
        final float n12 = (float)(50.0 + 100.0 * random.nextDouble());
        array[5] = 0;
        array2[5] = -(int)(n12 * n6);
        final float n13 = (float)(50.0 + 100.0 * random.nextDouble());
        array[6] = -(int)(n13 * n6 * 0.7071);
        array2[6] = -(int)(n13 * n6 * 0.7071);
        array[7] = -(int)((float)(50.0 + 100.0 * random.nextDouble()) * n6);
        array2[7] = 0;
        for (int i = 0; i < 8; ++i) {
            array3[i] = (int)(array[i] * (0.2 + 0.4 * random.nextDouble()));
            array4[i] = (int)(array2[i] * (0.2 + 0.4 * random.nextDouble()));
            array5[i] = -(int)((10.0 + 15.0 * random.nextDouble()) * n7);
        }
        this.maxR = 0;
        for (int j = 0; j < 8; ++j) {
            int n14 = j - 1;
            if (n14 == -1) {
                n14 = 7;
            }
            int n15 = j + 1;
            if (n15 == 8) {
                n15 = 0;
            }
            array[j] = ((array[n14] + array[n15]) / 2 + array[j]) / 2;
            array2[j] = ((array2[n14] + array2[n15]) / 2 + array2[j]) / 2;
            array3[j] = ((array3[n14] + array3[n15]) / 2 + array3[j]) / 2;
            array4[j] = ((array4[n14] + array4[n15]) / 2 + array4[j]) / 2;
            array5[j] = ((array5[n14] + array5[n15]) / 2 + array5[j]) / 2;
            final int maxR = (int)Math.sqrt(array[j] * array[j] + array2[j] * array2[j]);
            if (maxR > this.maxR) {
                this.maxR = maxR;
            }
            final int maxR2 = (int)Math.sqrt(array3[j] * array3[j] + array5[j] * array5[j] + array4[j] * array4[j]);
            if (maxR2 > this.maxR) {
                this.maxR = maxR2;
            }
        }
        this.disp = this.maxR / 17;
        final int[] array6 = new int[3];
        float n16 = -1.0f;
        float n17 = (n6 / n7 - 0.33f) / 33.4f;
        if (n17 < 0.005) {
            n17 = 0.0f;
        }
        if (n17 > 0.057) {
            n17 = 0.057f;
        }
        for (int k = 0; k < 4; ++k) {
            final int n18 = k * 2;
            int n19 = n18 + 2;
            if (n19 == 8) {
                n19 = 0;
            }
            final int[] array7 = new int[6];
            final int[] array8 = new int[6];
            final int[] array9 = new int[6];
            array7[0] = array[n18];
            array7[1] = array[n18 + 1];
            array7[2] = array[n19];
            array7[5] = array3[n18];
            array7[4] = array3[n18 + 1];
            array7[3] = array3[n19];
            array9[0] = array2[n18];
            array9[1] = array2[n18 + 1];
            array9[2] = array2[n19];
            array9[5] = array4[n18];
            array9[4] = array4[n18 + 1];
            array9[3] = array4[n19];
            array8[0] = 0;
            array8[2] = (array8[1] = 0);
            array8[5] = array5[n18];
            array8[4] = array5[n18 + 1];
            array8[3] = array5[n19];
            float n20;
            for (n20 = (float)((0.17 - n17) * random.nextDouble()); Math.abs(n16 - n20) < 0.03 - n17 * 0.176f; n20 = (float)((0.17 - n17) * random.nextDouble())) {}
            n16 = n20;
            for (int l = 0; l < 3; ++l) {
                if (this.m.trk == 2) {
                    array6[l] = (int)(390.0f / (2.2f + n20 - n17));
                }
                else {
                    array6[l] = (int)((this.m.cpol[l] + this.m.cgrnd[l]) / (2.2f + n20 - n17));
                }
            }
            this.p[k] = new Plane(this.m, this.t, array7, array9, array8, 6, array6, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
        }
        final float n21 = (float)(0.02 * random.nextDouble());
        for (int n22 = 0; n22 < 3; ++n22) {
            if (this.m.trk == 2) {
                array6[n22] = (int)(390.0f / (2.15f + n21));
            }
            else {
                array6[n22] = (int)((this.m.cpol[n22] + this.m.cgrnd[n22]) / (2.15f + n21));
            }
        }
        this.p[4] = new Plane(this.m, this.t, array3, array4, array5, 8, array6, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
        final int[] array10 = new int[2];
        final int[] array11 = new int[2];
        for (int n23 = 0; n23 < 4; ++n23) {
            final int n24 = n23 * 2 + 1;
            this.t.y[this.t.nt] = array5[n24] / 2;
            this.t.rady[this.t.nt] = Math.abs(array5[n24] / 2);
            if (n23 == 0 || n23 == 2) {
                this.t.z[this.t.nt] = (array2[n24] + array4[n24]) / 2;
                this.t.radz[this.t.nt] = Math.abs(this.t.z[this.t.nt] - array2[n24]);
                int n25 = n23 * 2 + 2;
                if (n25 == 8) {
                    n25 = 0;
                }
                this.t.x[this.t.nt] = (array[n23 * 2] + array[n25]) / 2;
                this.t.radx[this.t.nt] = Math.abs(this.t.x[this.t.nt] - array[n23 * 2]);
            }
            else {
                this.t.x[this.t.nt] = (array[n24] + array3[n24]) / 2;
                this.t.radx[this.t.nt] = Math.abs(this.t.x[this.t.nt] - array[n24]);
                int n26 = n23 * 2 + 2;
                if (n26 == 8) {
                    n26 = 0;
                }
                this.t.z[this.t.nt] = (array2[n23 * 2] + array2[n26]) / 2;
                this.t.radz[this.t.nt] = Math.abs(this.t.z[this.t.nt] - array2[n23 * 2]);
            }
            if (n23 == 0) {
                array11[0] = this.t.z[this.t.nt] - this.t.radz[this.t.nt];
                this.t.zy[this.t.nt] = (int)(Math.atan(this.t.rady[this.t.nt] / this.t.radz[this.t.nt]) / 0.017453292519943295);
                if (this.t.zy[this.t.nt] > 40) {
                    this.t.zy[this.t.nt] = 40;
                }
                this.t.xy[this.t.nt] = 0;
            }
            if (n23 == 1) {
                array10[0] = this.t.x[this.t.nt] - this.t.radx[this.t.nt];
                this.t.xy[this.t.nt] = (int)(Math.atan(this.t.rady[this.t.nt] / this.t.radx[this.t.nt]) / 0.017453292519943295);
                if (this.t.xy[this.t.nt] > 40) {
                    this.t.xy[this.t.nt] = 40;
                }
                this.t.zy[this.t.nt] = 0;
            }
            if (n23 == 2) {
                array11[1] = this.t.z[this.t.nt] + this.t.radz[this.t.nt];
                this.t.zy[this.t.nt] = -(int)(Math.atan(this.t.rady[this.t.nt] / this.t.radz[this.t.nt]) / 0.017453292519943295);
                if (this.t.zy[this.t.nt] < -40) {
                    this.t.zy[this.t.nt] = -40;
                }
                this.t.xy[this.t.nt] = 0;
            }
            if (n23 == 3) {
                array10[1] = this.t.x[this.t.nt] + this.t.radx[this.t.nt];
                this.t.xy[this.t.nt] = -(int)(Math.atan(this.t.rady[this.t.nt] / this.t.radx[this.t.nt]) / 0.017453292519943295);
                if (this.t.xy[this.t.nt] < -40) {
                    this.t.xy[this.t.nt] = -40;
                }
                this.t.zy[this.t.nt] = 0;
            }
            final int[] x2 = this.t.x;
            final int nt = this.t.nt;
            x2[nt] += this.x;
            final int[] z2 = this.t.z;
            final int nt2 = this.t.nt;
            z2[nt2] += this.z;
            final int[] y2 = this.t.y;
            final int nt3 = this.t.nt;
            y2[nt3] += this.y;
            for (int n27 = 0; n27 < 3; ++n27) {
                this.t.c[this.t.nt][n27] = this.p[n23].oc[n27];
            }
            this.t.skd[this.t.nt] = 2;
            this.t.dam[this.t.nt] = 1;
            this.t.notwall[this.t.nt] = false;
            this.t.decor[this.t.nt] = true;
            final int[] rady = this.t.rady;
            final int nt4 = this.t.nt;
            rady[nt4] += 10;
            final Trackers t2 = this.t;
            ++t2.nt;
        }
        this.t.y[this.t.nt] = 0;
        for (int n28 = 0; n28 < 8; ++n28) {
            final int[] y3 = this.t.y;
            final int nt5 = this.t.nt;
            y3[nt5] += array5[n28];
        }
        this.t.y[this.t.nt] /= 8;
        final int[] y4 = this.t.y;
        final int nt6 = this.t.nt;
        y4[nt6] += this.y;
        this.t.rady[this.t.nt] = 200;
        this.t.radx[this.t.nt] = array10[0] - array10[1];
        this.t.radz[this.t.nt] = array11[0] - array11[1];
        this.t.x[this.t.nt] = (array10[0] + array10[1]) / 2 + this.x;
        this.t.z[this.t.nt] = (array11[0] + array11[1]) / 2 + this.z;
        this.t.zy[this.t.nt] = 0;
        this.t.xy[this.t.nt] = 0;
        for (int n29 = 0; n29 < 3; ++n29) {
            this.t.c[this.t.nt][n29] = this.p[4].oc[n29];
        }
        this.t.skd[this.t.nt] = 4;
        this.t.dam[this.t.nt] = 1;
        this.t.notwall[this.t.nt] = false;
        this.t.decor[this.t.nt] = true;
        final Trackers t3 = this.t;
        ++t3.nt;
    }

    public void d(final Graphics2D graphics2D) {
        if (this.dist != 0) {
            this.dist = 0;
        }
        final int n = this.m.cx + (int)((this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
        final int n2 = this.m.cz + (int)((this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
        final int n3 = this.m.cz + (int)((this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n2 - this.m.cz) * this.m.cos(this.m.zy));
        int n4 = this.xs(n + this.maxR, n3) - this.xs(n - this.maxR, n3);
        if (this.xs(n + this.maxR * 2, n3) > this.m.iw && this.xs(n - this.maxR * 2, n3) < this.m.w && n3 > -this.maxR && (n3 < this.m.fade[this.disline] + this.maxR || this.m.trk != 0) && (n4 > this.disp || this.m.trk != 0) && (!this.decor || (this.m.resdown != 2 && this.m.trk != 1))) {
            if (this.shadow) {
                if (!this.m.crs) {
                    if (n3 < 2000) {
                        boolean b = false;
                        if (this.t.ncx != 0 || this.t.ncz != 0) {
                            int ncx = (this.x - this.t.sx) / 3000;
                            if (ncx > this.t.ncx) {
                                ncx = this.t.ncx;
                            }
                            if (ncx < 0) {
                                ncx = 0;
                            }
                            int ncz = (this.z - this.t.sz) / 3000;
                            if (ncz > this.t.ncz) {
                                ncz = this.t.ncz;
                            }
                            if (ncz < 0) {
                                ncz = 0;
                            }
                            for (int i = this.t.sect[ncx][ncz].length - 1; i >= 0; --i) {
                                final int n5 = this.t.sect[ncx][ncz][i];
                                if (Math.abs(this.t.zy[n5]) != 90 && Math.abs(this.t.xy[n5]) != 90 && Math.abs(this.x - this.t.x[n5]) < this.t.radx[n5] + this.maxR && Math.abs(this.z - this.t.z[n5]) < this.t.radz[n5] + this.maxR && (!this.t.decor[n5] || this.m.resdown != 2)) {
                                    b = true;
                                    break;
                                }
                            }
                        }
                        if (b) {
                            for (int j = 0; j < this.npl; ++j) {
                                this.p[j].s(graphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 0);
                            }
                        }
                        else {
                            final int n6 = this.m.cy + (int)((this.m.ground - this.m.cy) * this.m.cos(this.m.zy) - (n2 - this.m.cz) * this.m.sin(this.m.zy));
                            final int n7 = this.m.cz + (int)((this.m.ground - this.m.cy) * this.m.sin(this.m.zy) + (n2 - this.m.cz) * this.m.cos(this.m.zy));
                            if (this.ys(n6 + this.maxR, n7) > 0 && this.ys(n6 - this.maxR, n7) < this.m.h) {
                                for (int k = 0; k < this.npl; ++k) {
                                    this.p[k].s(graphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 1);
                                }
                            }
                        }
                        this.m.addsp(this.x - this.m.x, this.z - this.m.z, (int)(this.maxR * 0.8));
                    }
                    else {
                        this.lowshadow(graphics2D, n3);
                    }
                }
                else {
                    for (int l = 0; l < this.npl; ++l) {
                        this.p[l].s(graphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 2);
                    }
                }
            }
            final int n8 = this.m.cy + (int)((this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n2 - this.m.cz) * this.m.sin(this.m.zy));
            if (this.ys(n8 + this.maxR, n3) > this.m.ih && this.ys(n8 - this.maxR, n3) < this.m.h) {
                if (this.elec && this.m.noelec == 0) {
                    this.electrify(graphics2D);
                }
                if (this.fix) {
                    this.fixit(graphics2D);
                }
                if (this.checkpoint != 0 && this.checkpoint - 1 == this.m.checkpoint) {
                    n4 = -1;
                }
                if (this.shadow) {
                    this.dist = (int)Math.sqrt((this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x) + (this.m.z - this.z) * (this.m.z - this.z) + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y));
                    for (int n9 = 0; n9 < 20; ++n9) {
                        if (this.stg[n9] != 0) {
                            this.pdust(n9, graphics2D, true);
                        }
                    }
                    this.dsprk(graphics2D, true);
                }
                final int[] array = new int[this.npl];
                final int[] array2 = new int[this.npl];
                for (int n10 = 0; n10 < this.npl; ++n10) {
                    array[n10] = 0;
                }
                for (int n11 = 0; n11 < this.npl; ++n11) {
                    for (int n12 = n11 + 1; n12 < this.npl; ++n12) {
                        if (this.p[n11].av != this.p[n12].av) {
                            if (this.p[n11].av < this.p[n12].av) {
                                final int[] array3 = array;
                                final int n13 = n11;
                                ++array3[n13];
                            }
                            else {
                                final int[] array4 = array;
                                final int n14 = n12;
                                ++array4[n14];
                            }
                        }
                        else if (n11 > n12) {
                            final int[] array5 = array;
                            final int n15 = n11;
                            ++array5[n15];
                        }
                        else {
                            final int[] array6 = array;
                            final int n16 = n12;
                            ++array6[n16];
                        }
                    }
                    array2[array[n11]] = n11;
                }
                for (int n17 = 0; n17 < this.npl; ++n17) {
                    this.p[array2[n17]].d(graphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, this.wxz, this.wzy, this.noline, n4);
                }
                if (this.shadow) {
                    for (int n18 = 0; n18 < 20; ++n18) {
                        if (this.stg[n18] != 0) {
                            this.pdust(n18, graphics2D, false);
                        }
                    }
                    this.dsprk(graphics2D, false);
                }
                this.dist = (int)(Math.sqrt((int)Math.sqrt((this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x) + (this.m.z - this.z) * (this.m.z - this.z) + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y))) * this.grounded);
            }
        }
        if (this.shadow && this.dist == 0) {
            for (int n19 = 0; n19 < 20; ++n19) {
                if (this.stg[n19] != 0) {
                    this.stg[n19] = 0;
                }
            }
            for (int n20 = 0; n20 < 100; ++n20) {
                if (this.rtg[n20] != 0) {
                    this.rtg[n20] = 0;
                }
            }
            if (this.sprk != 0) {
                this.sprk = 0;
            }
        }
    }

    public void lowshadow(final Graphics2D graphics2D, final int n) {
        final int[] array = new int[4];
        final int[] array2 = new int[4];
        final int[] array3 = new int[4];
        int n2 = 1;
        int i;
        for (i = Math.abs(this.zy); i > 270; i -= 360) {}
        if (Math.abs(i) > 90) {
            n2 = -1;
        }
        array[0] = (int)(this.keyx[0] * 1.2 + this.x - this.m.x);
        array3[0] = (int)((this.keyz[0] + 30) * n2 * 1.2 + this.z - this.m.z);
        array[1] = (int)(this.keyx[1] * 1.2 + this.x - this.m.x);
        array3[1] = (int)((this.keyz[1] + 30) * n2 * 1.2 + this.z - this.m.z);
        array[2] = (int)(this.keyx[3] * 1.2 + this.x - this.m.x);
        array3[2] = (int)((this.keyz[3] - 30) * n2 * 1.2 + this.z - this.m.z);
        array[3] = (int)(this.keyx[2] * 1.2 + this.x - this.m.x);
        array3[3] = (int)((this.keyz[2] - 30) * n2 * 1.2 + this.z - this.m.z);
        this.rot(array, array3, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
        int n3 = (int)(this.m.crgrnd[0] / 1.5);
        int n4 = (int)(this.m.crgrnd[1] / 1.5);
        int n5 = (int)(this.m.crgrnd[2] / 1.5);
        for (int j = 0; j < 4; ++j) {
            array2[j] = this.m.ground;
        }
        if (this.t.ncx != 0 || this.t.ncz != 0) {
            int ncx = (this.x - this.t.sx) / 3000;
            if (ncx > this.t.ncx) {
                ncx = this.t.ncx;
            }
            if (ncx < 0) {
                ncx = 0;
            }
            int ncz = (this.z - this.t.sz) / 3000;
            if (ncz > this.t.ncz) {
                ncz = this.t.ncz;
            }
            if (ncz < 0) {
                ncz = 0;
            }
            for (int k = this.t.sect[ncx][ncz].length - 1; k >= 0; --k) {
                final int n6 = this.t.sect[ncx][ncz][k];
                int n7 = 0;
                for (int l = 0; l < 4; ++l) {
                    if (Math.abs(this.t.zy[n6]) != 90 && Math.abs(this.t.xy[n6]) != 90 && this.t.rady[n6] != 801 && Math.abs(array[l] - (this.t.x[n6] - this.m.x)) < this.t.radx[n6] && Math.abs(array3[l] - (this.t.z[n6] - this.m.z)) < this.t.radz[n6] && (!this.t.decor[n6] || this.m.resdown != 2)) {
                        ++n7;
                    }
                }
                if (n7 > 2) {
                    for (int n8 = 0; n8 < 4; ++n8) {
                        array2[n8] = this.t.y[n6] - this.m.y;
                        if (this.t.zy[n6] != 0) {
                            final int[] array4 = array2;
                            final int n9 = n8;
                            array4[n9] += (int)((array3[n8] - (this.t.z[n6] - this.m.z - this.t.radz[n6])) * this.m.sin(this.t.zy[n6]) / this.m.sin(90 - this.t.zy[n6]) - this.t.radz[n6] * this.m.sin(this.t.zy[n6]) / this.m.sin(90 - this.t.zy[n6]));
                        }
                        if (this.t.xy[n6] != 0) {
                            final int[] array5 = array2;
                            final int n10 = n8;
                            array5[n10] += (int)((array[n8] - (this.t.x[n6] - this.m.x - this.t.radx[n6])) * this.m.sin(this.t.xy[n6]) / this.m.sin(90 - this.t.xy[n6]) - this.t.radx[n6] * this.m.sin(this.t.xy[n6]) / this.m.sin(90 - this.t.xy[n6]));
                        }
                    }
                    n3 = (int)(this.t.c[n6][0] / 1.5);
                    n4 = (int)(this.t.c[n6][1] / 1.5);
                    n5 = (int)(this.t.c[n6][2] / 1.5);
                    break;
                }
            }
        }
        this.rot(array, array3, this.m.cx, this.m.cz, this.m.xz, 4);
        this.rot(array2, array3, this.m.cy, this.m.cz, this.m.zy, 4);
        boolean b = true;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        for (int n15 = 0; n15 < 4; ++n15) {
            array[n15] = this.xs(array[n15], array3[n15]);
            array2[n15] = this.ys(array2[n15], array3[n15]);
            if (array2[n15] < this.m.ih || array3[n15] < 10) {
                ++n11;
            }
            if (array2[n15] > this.m.h || array3[n15] < 10) {
                ++n12;
            }
            if (array[n15] < this.m.iw || array3[n15] < 10) {
                ++n13;
            }
            if (array[n15] > this.m.w || array3[n15] < 10) {
                ++n14;
            }
        }
        if (n13 == 4 || n11 == 4 || n12 == 4 || n14 == 4) {
            b = false;
        }
        if (b) {
            for (int n16 = 0; n16 < 16; ++n16) {
                if (n > this.m.fade[n16]) {
                    n3 = (n3 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                    n4 = (n4 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                    n5 = (n5 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                }
            }
            graphics2D.setColor(new Color(n3, n4, n5));
            graphics2D.fillPolygon(array, array2, 4);
        }
    }

    public void fixit(final Graphics2D graphics2D) {
        if (this.fcnt == 1) {
            for (int i = 0; i < this.npl; ++i) {
                this.p[i].hsb[0] = 0.57f;
                this.p[i].hsb[2] = 0.8f;
                this.p[i].hsb[1] = 0.8f;
                final Color hsbColor = Color.getHSBColor(this.p[i].hsb[0], this.p[i].hsb[1], this.p[i].hsb[2]);
                int n = (int)(hsbColor.getRed() + hsbColor.getRed() * (this.m.snap[0] / 100.0f));
                if (n > 255) {
                    n = 255;
                }
                if (n < 0) {
                    n = 0;
                }
                int n2 = (int)(hsbColor.getGreen() + hsbColor.getGreen() * (this.m.snap[1] / 100.0f));
                if (n2 > 255) {
                    n2 = 255;
                }
                if (n2 < 0) {
                    n2 = 0;
                }
                int n3 = (int)(hsbColor.getBlue() + hsbColor.getBlue() * (this.m.snap[2] / 100.0f));
                if (n3 > 255) {
                    n3 = 255;
                }
                if (n3 < 0) {
                    n3 = 0;
                }
                Color.RGBtoHSB(n, n2, n3, this.p[i].hsb);
                this.p[i].flx = 1;
            }
        }
        if (this.fcnt == 2) {
            for (int j = 0; j < this.npl; ++j) {
                this.p[j].flx = 1;
            }
        }
        if (this.fcnt == 4) {
            for (int k = 0; k < this.npl; ++k) {
                this.p[k].flx = 3;
            }
        }
        if ((this.fcnt == 1 || this.fcnt > 2) && this.fcnt != 9) {
            final int[] array = new int[8];
            final int[] array2 = new int[8];
            final int[] array3 = new int[4];
            for (int l = 0; l < 4; ++l) {
                array[l] = this.keyx[l] + this.x - this.m.x;
                array2[l] = this.grat + this.y - this.m.y;
                array3[l] = this.keyz[l] + this.z - this.m.z;
            }
            this.rot(array, array2, this.x - this.m.x, this.y - this.m.y, this.xy, 4);
            this.rot(array2, array3, this.y - this.m.y, this.z - this.m.y, this.zy, 4);
            this.rot(array, array3, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
            this.rot(array, array3, this.m.cx, this.m.cz, this.m.xz, 4);
            this.rot(array2, array3, this.m.cy, this.m.cz, this.m.zy, 4);
            int abs = 0;
            int abs2 = 0;
            int py = 0;
            for (int n4 = 0; n4 < 4; ++n4) {
                for (int n5 = 0; n5 < 4; ++n5) {
                    if (Math.abs(array[n4] - array[n5]) > abs) {
                        abs = Math.abs(array[n4] - array[n5]);
                    }
                    if (Math.abs(array2[n4] - array2[n5]) > abs2) {
                        abs2 = Math.abs(array2[n4] - array2[n5]);
                    }
                    if (this.py(array[n4], array[n5], array2[n4], array2[n5]) > py) {
                        py = this.py(array[n4], array[n5], array2[n4], array2[n5]);
                    }
                }
            }
            final int n6 = (int)(Math.sqrt(py) / 1.5);
            if (abs < n6) {
                abs = n6;
            }
            if (abs2 < n6) {
                abs2 = n6;
            }
            final int n7 = this.m.cx + (int)((this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
            final int n8 = this.m.cz + (int)((this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
            final int n9 = this.m.cy + (int)((this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n8 - this.m.cz) * this.m.sin(this.m.zy));
            final int n10 = this.m.cz + (int)((this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n8 - this.m.cz) * this.m.cos(this.m.zy));
            array[0] = this.xs((int)(n7 - abs / 0.8 - this.m.random() * (abs / 2.4)), n10);
            array2[0] = this.ys((int)(n9 - abs2 / 1.92 - this.m.random() * (abs2 / 5.67)), n10);
            array[1] = this.xs((int)(n7 - abs / 0.8 - this.m.random() * (abs / 2.4)), n10);
            array2[1] = this.ys((int)(n9 + abs2 / 1.92 + this.m.random() * (abs2 / 5.67)), n10);
            array[2] = this.xs((int)(n7 - abs / 1.92 - this.m.random() * (abs / 5.67)), n10);
            array2[2] = this.ys((int)(n9 + abs2 / 0.8 + this.m.random() * (abs2 / 2.4)), n10);
            array[3] = this.xs((int)(n7 + abs / 1.92 + this.m.random() * (abs / 5.67)), n10);
            array2[3] = this.ys((int)(n9 + abs2 / 0.8 + this.m.random() * (abs2 / 2.4)), n10);
            array[4] = this.xs((int)(n7 + abs / 0.8 + this.m.random() * (abs / 2.4)), n10);
            array2[4] = this.ys((int)(n9 + abs2 / 1.92 + this.m.random() * (abs2 / 5.67)), n10);
            array[5] = this.xs((int)(n7 + abs / 0.8 + this.m.random() * (abs / 2.4)), n10);
            array2[5] = this.ys((int)(n9 - abs2 / 1.92 - this.m.random() * (abs2 / 5.67)), n10);
            array[6] = this.xs((int)(n7 + abs / 1.92 + this.m.random() * (abs / 5.67)), n10);
            array2[6] = this.ys((int)(n9 - abs2 / 0.8 - this.m.random() * (abs2 / 2.4)), n10);
            array[7] = this.xs((int)(n7 - abs / 1.92 - this.m.random() * (abs / 5.67)), n10);
            array2[7] = this.ys((int)(n9 - abs2 / 0.8 - this.m.random() * (abs2 / 2.4)), n10);
            if (this.fcnt == 3) {
                this.rot(array, array2, this.xs(n7, n10), this.ys(n9, n10), 22, 8);
            }
            if (this.fcnt == 4) {
                this.rot(array, array2, this.xs(n7, n10), this.ys(n9, n10), 22, 8);
            }
            if (this.fcnt == 5) {
                this.rot(array, array2, this.xs(n7, n10), this.ys(n9, n10), 0, 8);
            }
            if (this.fcnt == 6) {
                this.rot(array, array2, this.xs(n7, n10), this.ys(n9, n10), -22, 8);
            }
            if (this.fcnt == 7) {
                this.rot(array, array2, this.xs(n7, n10), this.ys(n9, n10), -22, 8);
            }
            int n11 = (int)(191.0f + 191.0f * (this.m.snap[0] / 350.0f));
            if (n11 > 255) {
                n11 = 255;
            }
            if (n11 < 0) {
                n11 = 0;
            }
            int n12 = (int)(232.0f + 232.0f * (this.m.snap[1] / 350.0f));
            if (n12 > 255) {
                n12 = 255;
            }
            if (n12 < 0) {
                n12 = 0;
            }
            int n13 = (int)(255.0f + 255.0f * (this.m.snap[2] / 350.0f));
            if (n13 > 255) {
                n13 = 255;
            }
            if (n13 < 0) {
                n13 = 0;
            }
            graphics2D.setColor(new Color(n11, n12, n13));
            graphics2D.fillPolygon(array, array2, 8);
            array[0] = this.xs((int)(n7 - abs - this.m.random() * (abs / 4)), n10);
            array2[0] = this.ys((int)(n9 - abs2 / 2.4 - this.m.random() * (abs2 / 9.6)), n10);
            array[1] = this.xs((int)(n7 - abs - this.m.random() * (abs / 4)), n10);
            array2[1] = this.ys((int)(n9 + abs2 / 2.4 + this.m.random() * (abs2 / 9.6)), n10);
            array[2] = this.xs((int)(n7 - abs / 2.4 - this.m.random() * (abs / 9.6)), n10);
            array2[2] = this.ys((int)(n9 + abs2 + this.m.random() * (abs2 / 4)), n10);
            array[3] = this.xs((int)(n7 + abs / 2.4 + this.m.random() * (abs / 9.6)), n10);
            array2[3] = this.ys((int)(n9 + abs2 + this.m.random() * (abs2 / 4)), n10);
            array[4] = this.xs((int)(n7 + abs + this.m.random() * (abs / 4)), n10);
            array2[4] = this.ys((int)(n9 + abs2 / 2.4 + this.m.random() * (abs2 / 9.6)), n10);
            array[5] = this.xs((int)(n7 + abs + this.m.random() * (abs / 4)), n10);
            array2[5] = this.ys((int)(n9 - abs2 / 2.4 - this.m.random() * (abs2 / 9.6)), n10);
            array[6] = this.xs((int)(n7 + abs / 2.4 + this.m.random() * (abs / 9.6)), n10);
            array2[6] = this.ys((int)(n9 - abs2 - this.m.random() * (abs2 / 4)), n10);
            array[7] = this.xs((int)(n7 - abs / 2.4 - this.m.random() * (abs / 9.6)), n10);
            array2[7] = this.ys((int)(n9 - abs2 - this.m.random() * (abs2 / 4)), n10);
            int n14 = (int)(213.0f + 213.0f * (this.m.snap[0] / 350.0f));
            if (n14 > 255) {
                n14 = 255;
            }
            if (n14 < 0) {
                n14 = 0;
            }
            int n15 = (int)(239.0f + 239.0f * (this.m.snap[1] / 350.0f));
            if (n15 > 255) {
                n15 = 255;
            }
            if (n15 < 0) {
                n15 = 0;
            }
            int n16 = (int)(255.0f + 255.0f * (this.m.snap[2] / 350.0f));
            if (n16 > 255) {
                n16 = 255;
            }
            if (n16 < 0) {
                n16 = 0;
            }
            graphics2D.setColor(new Color(n14, n15, n16));
            graphics2D.fillPolygon(array, array2, 8);
        }
        if (this.fcnt > 7) {
            this.fcnt = 0;
            this.fix = false;
        }
        else {
            ++this.fcnt;
        }
    }

    public void electrify(final Graphics2D graphics2D) {
        for (int i = 0; i < 4; ++i) {
            if (this.elc[i] == 0) {
                this.edl[i] = (int)(380.0f - this.m.random() * 760.0f);
                this.edr[i] = (int)(380.0f - this.m.random() * 760.0f);
                this.elc[i] = 1;
            }
            final int n = (int)(this.edl[i] + (190.0f - this.m.random() * 380.0f));
            final int n2 = (int)(this.edr[i] + (190.0f - this.m.random() * 380.0f));
            final int n3 = (int)(this.m.random() * 126.0f);
            final int n4 = (int)(this.m.random() * 126.0f);
            final int[] array = new int[8];
            final int[] array2 = new int[8];
            final int[] array3 = new int[8];
            for (int j = 0; j < 8; ++j) {
                array3[j] = this.z - this.m.z;
            }
            array[0] = this.x - this.m.x - 504;
            array2[0] = this.y - this.m.y - this.edl[i] - 5 - (int)(this.m.random() * 5.0f);
            array[1] = this.x - this.m.x - 252 + n4;
            array2[1] = this.y - this.m.y - n - 5 - (int)(this.m.random() * 5.0f);
            array[2] = this.x - this.m.x + 252 - n3;
            array2[2] = this.y - this.m.y - n2 - 5 - (int)(this.m.random() * 5.0f);
            array[3] = this.x - this.m.x + 504;
            array2[3] = this.y - this.m.y - this.edr[i] - 5 - (int)(this.m.random() * 5.0f);
            array[4] = this.x - this.m.x + 504;
            array2[4] = this.y - this.m.y - this.edr[i] + 5 + (int)(this.m.random() * 5.0f);
            array[5] = this.x - this.m.x + 252 - n3;
            array2[5] = this.y - this.m.y - n2 + 5 + (int)(this.m.random() * 5.0f);
            array[6] = this.x - this.m.x - 252 + n4;
            array2[6] = this.y - this.m.y - n + 5 + (int)(this.m.random() * 5.0f);
            array[7] = this.x - this.m.x - 504;
            array2[7] = this.y - this.m.y - this.edl[i] + 5 + (int)(this.m.random() * 5.0f);
            if (this.roted) {
                this.rot(array, array3, this.x - this.m.x, this.z - this.m.z, 90, 8);
            }
            this.rot(array, array3, this.m.cx, this.m.cz, this.m.xz, 8);
            this.rot(array2, array3, this.m.cy, this.m.cz, this.m.zy, 8);
            boolean b = true;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            final int[] array4 = new int[8];
            final int[] array5 = new int[8];
            for (int k = 0; k < 8; ++k) {
                array4[k] = this.xs(array[k], array3[k]);
                array5[k] = this.ys(array2[k], array3[k]);
                if (array5[k] < this.m.ih || array3[k] < 10) {
                    ++n5;
                }
                if (array5[k] > this.m.h || array3[k] < 10) {
                    ++n6;
                }
                if (array4[k] < this.m.iw || array3[k] < 10) {
                    ++n7;
                }
                if (array4[k] > this.m.w || array3[k] < 10) {
                    ++n8;
                }
            }
            if (n7 == 8 || n5 == 8 || n6 == 8 || n8 == 8) {
                b = false;
            }
            if (b) {
                int n9 = (int)(160.0f + 160.0f * (this.m.snap[0] / 500.0f));
                if (n9 > 255) {
                    n9 = 255;
                }
                if (n9 < 0) {
                    n9 = 0;
                }
                int n10 = (int)(238.0f + 238.0f * (this.m.snap[1] / 500.0f));
                if (n10 > 255) {
                    n10 = 255;
                }
                if (n10 < 0) {
                    n10 = 0;
                }
                int n11 = (int)(255.0f + 255.0f * (this.m.snap[2] / 500.0f));
                if (n11 > 255) {
                    n11 = 255;
                }
                if (n11 < 0) {
                    n11 = 0;
                }
                int n12 = (n9 * 2 + 214 * (this.elc[i] - 1)) / (this.elc[i] + 1);
                int n13 = (n10 * 2 + 236 * (this.elc[i] - 1)) / (this.elc[i] + 1);
                if (this.m.trk == 1) {
                    n12 = 255;
                    n13 = 128;
                    n11 = 0;
                }
                graphics2D.setColor(new Color(n12, n13, n11));
                graphics2D.fillPolygon(array4, array5, 8);
                if (array3[0] < 4000) {
                    int n14 = (int)(150.0f + 150.0f * (this.m.snap[0] / 500.0f));
                    if (n14 > 255) {
                        n14 = 255;
                    }
                    if (n14 < 0) {
                        n14 = 0;
                    }
                    int n15 = (int)(227.0f + 227.0f * (this.m.snap[1] / 500.0f));
                    if (n15 > 255) {
                        n15 = 255;
                    }
                    if (n15 < 0) {
                        n15 = 0;
                    }
                    int n16 = (int)(255.0f + 255.0f * (this.m.snap[2] / 500.0f));
                    if (n16 > 255) {
                        n16 = 255;
                    }
                    if (n16 < 0) {
                        n16 = 0;
                    }
                    graphics2D.setColor(new Color(n14, n15, n16));
                    graphics2D.drawPolygon(array4, array5, 8);
                }
            }
            if (this.elc[i] > this.m.random() * 60.0f) {
                this.elc[i] = 0;
            }
            else {
                final int[] elc = this.elc;
                final int n17 = i;
                ++elc[n17];
            }
        }
        if (!this.roted || this.xz != 0) {
            this.xy += 11;
            if (this.xy > 360) {
                this.xy -= 360;
            }
        }
        else {
            this.zy += 11;
            if (this.zy > 360) {
                this.zy -= 360;
            }
        }
    }

    public void dust(final int n, final float n2, final float n3, final float n4, final int n5, final int n6, final float n7, final int n8, final boolean b) {
        boolean b2 = false;
        if (n8 > 5 && (n == 0 || n == 2)) {
            b2 = true;
        }
        if (n8 < -5 && (n == 1 || n == 3)) {
            b2 = true;
        }
        float n9 = (float)((Math.sqrt(n5 * n5 + n6 * n6) - 40.0) / 160.0);
        if (n9 > 1.0f) {
            n9 = 1.0f;
        }
        if (n9 > 0.2 && !b2) {
            ++this.ust;
            if (this.ust == 20) {
                this.ust = 0;
            }
            if (!b) {
                final float random = this.m.random();
                this.sx[this.ust] = (int)((n2 + this.x * random) / (1.0f + random));
                this.sz[this.ust] = (int)((n4 + this.z * random) / (1.0f + random));
                this.sy[this.ust] = (int)((n3 + this.y * random) / (1.0f + random));
            }
            else {
                this.sx[this.ust] = (int)((n2 + (this.x + n5)) / 2.0f);
                this.sz[this.ust] = (int)((n4 + (this.z + n6)) / 2.0f);
                this.sy[this.ust] = (int)n3;
            }
            if (this.sy[n] > 250) {
                this.sy[n] = 250;
            }
            this.osmag[this.ust] = n7 * n9;
            this.scx[this.ust] = n5;
            this.scz[this.ust] = n6;
            this.stg[this.ust] = 1;
        }
    }

    public void pdust(final int n, final Graphics2D graphics2D, final boolean b) {
        if (b) {
            this.sav[n] = (int)Math.sqrt((this.m.x + this.m.cx - this.sx[n]) * (this.m.x + this.m.cx - this.sx[n]) + (this.m.y + this.m.cy - this.sy[n]) * (this.m.y + this.m.cy - this.sy[n]) + (this.m.z - this.sz[n]) * (this.m.z - this.sz[n]));
        }
        if ((b && this.sav[n] > this.dist) || (!b && this.sav[n] <= this.dist)) {
            if (this.stg[n] == 1) {
                this.sbln[n] = 0.6f;
                boolean b2 = false;
                final int[] array = new int[3];
                for (int i = 0; i < 3; ++i) {
                    array[i] = (int)(255.0f + 255.0f * (this.m.snap[i] / 100.0f));
                    if (array[i] > 255) {
                        array[i] = 255;
                    }
                    if (array[i] < 0) {
                        array[i] = 0;
                    }
                }
                int ncx = (this.x - this.t.sx) / 3000;
                if (ncx > this.t.ncx) {
                    ncx = this.t.ncx;
                }
                if (ncx < 0) {
                    ncx = 0;
                }
                int ncz = (this.z - this.t.sz) / 3000;
                if (ncz > this.t.ncz) {
                    ncz = this.t.ncz;
                }
                if (ncz < 0) {
                    ncz = 0;
                }
                for (int j = 0; j < this.t.sect[ncx][ncz].length; ++j) {
                    final int n2 = this.t.sect[ncx][ncz][j];
                    if (Math.abs(this.t.zy[n2]) != 90 && Math.abs(this.t.xy[n2]) != 90 && Math.abs(this.sx[n] - this.t.x[n2]) < this.t.radx[n2] && Math.abs(this.sz[n] - this.t.z[n2]) < this.t.radz[n2]) {
                        if (this.t.skd[n2] == 0) {
                            this.sbln[n] = 0.2f;
                        }
                        if (this.t.skd[n2] == 1) {
                            this.sbln[n] = 0.4f;
                        }
                        if (this.t.skd[n2] == 2) {
                            this.sbln[n] = 0.45f;
                        }
                        for (int k = 0; k < 3; ++k) {
                            this.srgb[n][k] = (this.t.c[n2][k] + array[k]) / 2;
                        }
                        b2 = true;
                    }
                }
                if (!b2) {
                    for (int l = 0; l < 3; ++l) {
                        this.srgb[n][l] = (this.m.crgrnd[l] + array[l]) / 2;
                    }
                }
                float n3 = (float)(0.1 + this.m.random());
                if (n3 > 1.0f) {
                    n3 = 1.0f;
                }
                this.scx[n] *= (int)n3;
                this.scz[n] = (int)(this.scx[n] * n3);
                for (int n4 = 0; n4 < 8; ++n4) {
                    this.smag[n][n4] = this.osmag[n] * this.m.random() * 50.0f;
                }
                for (int n5 = 0; n5 < 8; ++n5) {
                    int n6 = n5 - 1;
                    if (n6 == -1) {
                        n6 = 7;
                    }
                    int n7 = n5 + 1;
                    if (n7 == 8) {
                        n7 = 0;
                    }
                    this.smag[n][n5] = ((this.smag[n][n6] + this.smag[n][n7]) / 2.0f + this.smag[n][n5]) / 2.0f;
                }
                this.smag[n][6] = this.smag[n][7];
            }
            final int n8 = this.m.cx + (int)((this.sx[n] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.sz[n] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
            final int n9 = this.m.cz + (int)((this.sx[n] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.sz[n] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
            final int n10 = this.m.cy + (int)((this.sy[n] - this.m.y - this.m.cy - this.smag[n][7]) * this.m.cos(this.m.zy) - (n9 - this.m.cz) * this.m.sin(this.m.zy));
            final int n11 = this.m.cz + (int)((this.sy[n] - this.m.y - this.m.cy - this.smag[n][7]) * this.m.sin(this.m.zy) + (n9 - this.m.cz) * this.m.cos(this.m.zy));
            final int[] sx = this.sx;
            sx[n] += this.scx[n] / (this.stg[n] + 1);
            final int[] sz = this.sz;
            sz[n] += this.scz[n] / (this.stg[n] + 1);
            final int[] array2 = new int[8];
            final int[] array3 = new int[8];
            array2[0] = this.xs((int)(n8 + this.smag[n][0] * 0.9238f * 1.5f), n11);
            array3[0] = this.ys((int)(n10 + this.smag[n][0] * 0.3826f * 1.5f), n11);
            array2[1] = this.xs((int)(n8 + this.smag[n][1] * 0.9238f * 1.5f), n11);
            array3[1] = this.ys((int)(n10 - this.smag[n][1] * 0.3826f * 1.5f), n11);
            array2[2] = this.xs((int)(n8 + this.smag[n][2] * 0.3826f), n11);
            array3[2] = this.ys((int)(n10 - this.smag[n][2] * 0.9238f), n11);
            array2[3] = this.xs((int)(n8 - this.smag[n][3] * 0.3826f), n11);
            array3[3] = this.ys((int)(n10 - this.smag[n][3] * 0.9238f), n11);
            array2[4] = this.xs((int)(n8 - this.smag[n][4] * 0.9238f * 1.5f), n11);
            array3[4] = this.ys((int)(n10 - this.smag[n][4] * 0.3826f * 1.5f), n11);
            array2[5] = this.xs((int)(n8 - this.smag[n][5] * 0.9238f * 1.5f), n11);
            array3[5] = this.ys((int)(n10 + this.smag[n][5] * 0.3826f * 1.5f), n11);
            array2[6] = this.xs((int)(n8 - this.smag[n][6] * 0.3826f * 1.7f), n11);
            array3[6] = this.ys((int)(n10 + this.smag[n][6] * 0.9238f), n11);
            array2[7] = this.xs((int)(n8 + this.smag[n][7] * 0.3826f * 1.7f), n11);
            array3[7] = this.ys((int)(n10 + this.smag[n][7] * 0.9238f), n11);
            for (int n12 = 0; n12 < 7; ++n12) {
                final float[] array4 = this.smag[n];
                final int n13 = n12;
                array4[n13] += 5.0f + this.m.random() * 15.0f;
            }
            this.smag[n][7] = this.smag[n][6];
            boolean b3 = true;
            int n14 = 0;
            int n15 = 0;
            int n16 = 0;
            int n17 = 0;
            for (int n18 = 0; n18 < 8; ++n18) {
                if (array3[n18] < this.m.ih || n11 < 10) {
                    ++n14;
                }
                if (array3[n18] > this.m.h || n11 < 10) {
                    ++n15;
                }
                if (array2[n18] < this.m.iw || n11 < 10) {
                    ++n16;
                }
                if (array2[n18] > this.m.w || n11 < 10) {
                    ++n17;
                }
            }
            if (n16 == 4 || n14 == 4 || n15 == 4 || n17 == 4) {
                b3 = false;
            }
            if (b3) {
                int n19 = this.srgb[n][0];
                int n20 = this.srgb[n][1];
                int n21 = this.srgb[n][2];
                for (int n22 = 0; n22 < 16; ++n22) {
                    if (this.sav[n] > this.m.fade[n22]) {
                        n19 = (n19 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                        n20 = (n20 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                        n21 = (n21 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                    }
                }
                graphics2D.setColor(new Color(n19, n20, n21));
                graphics2D.setComposite(AlphaComposite.getInstance(3, this.sbln[n] - this.stg[n] * (this.sbln[n] / 8.0f)));
                graphics2D.fillPolygon(array2, array3, 8);
                graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            }
            if (this.stg[n] == 7) {
                this.stg[n] = 0;
            }
            else {
                final int[] stg = this.stg;
                ++stg[n];
            }
        }
    }

    public void sprk(final float n, final float n2, final float n3, final float rcx, final float rcy, final float rcz, final int n4) {
        if (n4 != 1) {
            this.srx = (int)(n - this.sprkat * this.m.sin(this.xz));
            this.sry = (int)(n2 - this.sprkat * this.m.cos(this.zy) * this.m.cos(this.xy));
            this.srz = (int)(n3 + this.sprkat * this.m.cos(this.xz));
            this.sprk = 1;
        }
        else {
            ++this.sprk;
            if (this.sprk == 4) {
                this.srx = (int)(this.x + rcx);
                this.sry = (int)n2;
                this.srz = (int)(this.z + rcz);
                this.sprk = 5;
            }
            else {
                this.srx = (int)n;
                this.sry = (int)n2;
                this.srz = (int)n3;
            }
        }
        if (n4 == 2) {
            this.sprk = 6;
        }
        this.rcx = rcx;
        this.rcy = rcy;
        this.rcz = rcz;
    }

    public void dsprk(final Graphics2D graphics2D, final boolean b) {
        if (b && this.sprk != 0) {
            int n = (int)(Math.sqrt(this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz) / 10.0);
            if (n > 5) {
                boolean b2 = false;
                if (this.dist < Math.sqrt((this.m.x + this.m.cx - this.srx) * (this.m.x + this.m.cx - this.srx) + (this.m.y + this.m.cy - this.sry) * (this.m.y + this.m.cy - this.sry) + (this.m.z - this.srz) * (this.m.z - this.srz))) {
                    b2 = true;
                }
                if (n > 33) {
                    n = 33;
                }
                int n2 = 0;
                for (int i = 0; i < 100; ++i) {
                    if (this.rtg[i] == 0) {
                        this.rtg[i] = 1;
                        this.rbef[i] = b2;
                        ++n2;
                    }
                    if (n2 == n) {
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < 100; ++j) {
            if (this.rtg[j] != 0 && ((this.rbef[j] && b) || (!this.rbef[j] && !b))) {
                if (this.rtg[j] == 1) {
                    if (this.sprk < 5) {
                        this.rx[j] = this.srx + 3 - (int)(this.m.random() * 6.7);
                        this.ry[j] = this.sry + 3 - (int)(this.m.random() * 6.7);
                        this.rz[j] = this.srz + 3 - (int)(this.m.random() * 6.7);
                    }
                    else {
                        this.rx[j] = this.srx + 10 - (int)(this.m.random() * 20.0f);
                        this.ry[j] = this.sry - (int)(this.m.random() * 4.0f);
                        this.rz[j] = this.srz + 10 - (int)(this.m.random() * 20.0f);
                    }
                    final int n3 = (int)Math.sqrt(this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz);
                    final float n4 = 0.2f + 0.4f * this.m.random();
                    final float n5 = this.m.random() * this.m.random() * this.m.random();
                    float n6 = 1.0f;
                    if (this.m.random() > this.m.random()) {
                        if (this.m.random() > this.m.random()) {
                            n6 *= -1.0f;
                        }
                        this.vrx[j] = -((this.rcx + n3 * (1.0f - this.rcx / n3) * n5 * n6) * n4);
                    }
                    if (this.m.random() > this.m.random()) {
                        if (this.m.random() > this.m.random()) {
                            n6 *= -1.0f;
                        }
                        if (this.sprk == 5) {
                            n6 = 1.0f;
                        }
                        this.vry[j] = -((this.rcy + n3 * (1.0f - this.rcy / n3) * n5 * n6) * n4);
                    }
                    if (this.m.random() > this.m.random()) {
                        if (this.m.random() > this.m.random()) {
                            n6 *= -1.0f;
                        }
                        this.vrz[j] = -((this.rcz + n3 * (1.0f - this.rcz / n3) * n5 * n6) * n4);
                    }
                }
                final int[] rx = this.rx;
                final int n7 = j;
                rx[n7] += (int)this.vrx[j];
                final int[] ry = this.ry;
                final int n8 = j;
                ry[n8] += (int)this.vry[j];
                final int[] rz = this.rz;
                final int n9 = j;
                rz[n9] += (int)this.vrz[j];
                final int n10 = this.m.cx + (int)((this.rx[j] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.rz[j] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
                final int n11 = this.m.cz + (int)((this.rx[j] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.rz[j] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
                final int n12 = this.m.cy + (int)((this.ry[j] - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n11 - this.m.cz) * this.m.sin(this.m.zy));
                final int n13 = this.m.cz + (int)((this.ry[j] - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n11 - this.m.cz) * this.m.cos(this.m.zy));
                final int n14 = this.m.cx + (int)((this.rx[j] - this.m.x - this.m.cx + this.vrx[j]) * this.m.cos(this.m.xz) - (this.rz[j] - this.m.z - this.m.cz + this.vrz[j]) * this.m.sin(this.m.xz));
                final int n15 = this.m.cz + (int)((this.rx[j] - this.m.x - this.m.cx + this.vrx[j]) * this.m.sin(this.m.xz) + (this.rz[j] - this.m.z - this.m.cz + this.vrz[j]) * this.m.cos(this.m.xz));
                final int n16 = this.m.cy + (int)((this.ry[j] - this.m.y - this.m.cy + this.vry[j]) * this.m.cos(this.m.zy) - (n15 - this.m.cz) * this.m.sin(this.m.zy));
                final int n17 = this.m.cz + (int)((this.ry[j] - this.m.y - this.m.cy + this.vry[j]) * this.m.sin(this.m.zy) + (n15 - this.m.cz) * this.m.cos(this.m.zy));
                final int xs = this.xs(n10, n13);
                final int ys = this.ys(n12, n13);
                final int xs2 = this.xs(n14, n17);
                final int ys2 = this.ys(n16, n17);
                if (xs < this.m.iw && xs2 < this.m.iw) {
                    this.rtg[j] = 0;
                }
                if (xs > this.m.w && xs2 > this.m.w) {
                    this.rtg[j] = 0;
                }
                if (ys < this.m.ih && ys2 < this.m.ih) {
                    this.rtg[j] = 0;
                }
                if (ys > this.m.h && ys2 > this.m.h) {
                    this.rtg[j] = 0;
                }
                if (this.ry[j] > 250) {
                    this.rtg[j] = 0;
                }
                if (this.rtg[j] != 0) {
                    int n18 = 255;
                    int n19 = 197 - 30 * this.rtg[j];
                    int n20 = 0;
                    for (int k = 0; k < 16; ++k) {
                        if (n13 > this.m.fade[k]) {
                            n18 = (n18 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                            n19 = (n19 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                            n20 = (n20 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                        }
                    }
                    graphics2D.setColor(new Color(n18, n19, n20));
                    graphics2D.drawLine(xs, ys, xs2, ys2);
                    this.vrx[j] *= 0.8f;
                    this.vry[j] *= 0.8f;
                    this.vrz[j] *= 0.8f;
                    if (this.rtg[j] == 3) {
                        this.rtg[j] = 0;
                    }
                    else {
                        final int[] rtg = this.rtg;
                        final int n21 = j;
                        ++rtg[n21];
                    }
                }
            }
        }
        if (this.sprk != 0) {
            this.sprk = 0;
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

    public int getpy(final int n, final int n2, final int n3) {
        return (n - this.x) / 10 * ((n - this.x) / 10) + (n2 - this.y) / 10 * ((n2 - this.y) / 10) + (n3 - this.z) / 10 * ((n3 - this.z) / 10);
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
}
