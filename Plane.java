import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Color;

public class Plane
{
    Medium m;
    Trackers t;
    int[] ox;
    int[] oy;
    int[] oz;
    int n;
    int[] c;
    int[] oc;
    float[] hsb;
    int glass;
    int gr;
    int fs;
    int disline;
    boolean road;
    boolean solo;
    int light;
    int master;
    int wx;
    int wz;
    int wy;
    float deltaf;
    float projf;
    int av;
    int bfase;
    boolean nocol;
    int chip;
    float ctmag;
    int cxz;
    int cxy;
    int czy;
    int[] cox;
    int[] coz;
    int[] coy;
    int dx;
    int dy;
    int dz;
    int vx;
    int vy;
    int vz;
    int embos;
    int typ;
    int pa;
    int pb;
    int flx;
    int colnum;
    
    public Plane(final Medium m, final Trackers t, final int[] array, final int[] array2, final int[] array3, final int n, final int[] array4, final int glass, final int gr, final int fs, final int wx, final int wy, final int wz, final int disline, final int bfase, final boolean road, final int light, final boolean solo) {
        this.c = new int[3];
        this.oc = new int[3];
        this.hsb = new float[3];
        this.glass = 0;
        this.gr = 0;
        this.fs = 0;
        this.disline = 7;
        this.road = false;
        this.solo = false;
        this.light = 0;
        this.master = 0;
        this.wx = 0;
        this.wz = 0;
        this.wy = 0;
        this.deltaf = 1.0f;
        this.projf = 1.0f;
        this.av = 0;
        this.bfase = 0;
        this.nocol = false;
        this.chip = 0;
        this.ctmag = 0.0f;
        this.cxz = 0;
        this.cxy = 0;
        this.czy = 0;
        this.cox = new int[3];
        this.coz = new int[3];
        this.coy = new int[3];
        this.dx = 0;
        this.dy = 0;
        this.dz = 0;
        this.vx = 0;
        this.vy = 0;
        this.vz = 0;
        this.embos = 0;
        this.typ = 0;
        this.pa = 0;
        this.pb = 0;
        this.flx = 0;
        this.colnum = 0;
        this.m = m;
        this.t = t;
        this.n = n;
        this.ox = new int[this.n];
        this.oz = new int[this.n];
        this.oy = new int[this.n];
        for (int i = 0; i < this.n; ++i) {
            this.ox[i] = array[i];
            this.oy[i] = array3[i];
            this.oz[i] = array2[i];
        }
        for (int j = 0; j < 3; ++j) {
            this.oc[j] = array4[j];
        }
        if (gr == -15) {
            if (array4[0] == 211) {
                final int n2 = (int)(Math.random() * 40.0 - 20.0);
                final int n3 = (int)(Math.random() * 40.0 - 20.0);
                for (int k = 0; k < this.n; ++k) {
                    final int[] ox = this.ox;
                    final int n4 = k;
                    ox[n4] += n2;
                    final int[] oz = this.oz;
                    final int n5 = k;
                    oz[n5] += n3;
                }
            }
            final int n6 = (int)(185.0 + Math.random() * 20.0);
            array4[0] = (217 + n6) / 2;
            if (array4[0] == 211) {
                array4[0] = 210;
            }
            array4[1] = (189 + n6) / 2;
            array4[2] = (132 + n6) / 2;
            for (int l = 0; l < this.n; ++l) {
                if (Math.random() > Math.random()) {
                    final int[] ox2 = this.ox;
                    final int n7 = l;
                    ox2[n7] += (int)(8.0 * Math.random() - 4.0);
                }
                if (Math.random() > Math.random()) {
                    final int[] oy = this.oy;
                    final int n8 = l;
                    oy[n8] += (int)(8.0 * Math.random() - 4.0);
                }
                if (Math.random() > Math.random()) {
                    final int[] oz2 = this.oz;
                    final int n9 = l;
                    oz2[n9] += (int)(8.0 * Math.random() - 4.0);
                }
            }
        }
        if (array4[0] == array4[1] && array4[1] == array4[2]) {
            this.nocol = true;
        }
        if (glass == 0) {
            for (int n10 = 0; n10 < 3; ++n10) {
                this.c[n10] = (int)(array4[n10] + array4[n10] * (this.m.snap[n10] / 100.0f));
                if (this.c[n10] > 255) {
                    this.c[n10] = 255;
                }
                if (this.c[n10] < 0) {
                    this.c[n10] = 0;
                }
            }
        }
        if (glass == 1) {
            for (int n11 = 0; n11 < 3; ++n11) {
                this.c[n11] = (this.m.csky[n11] * this.m.fade[0] * 2 + this.m.cfade[n11] * 3000) / (this.m.fade[0] * 2 + 3000);
            }
        }
        if (glass == 2) {
            for (int n12 = 0; n12 < 3; ++n12) {
                this.c[n12] = (int)(this.m.crgrnd[n12] * 0.925f);
            }
        }
        if (glass == 3) {
            for (int n13 = 0; n13 < 3; ++n13) {
                this.c[n13] = array4[n13];
            }
        }
        this.disline = disline;
        this.bfase = bfase;
        this.glass = glass;
        Color.RGBtoHSB(this.c[0], this.c[1], this.c[2], this.hsb);
        if (glass == 3 && this.m.trk != 2) {
            final float[] hsb = this.hsb;
            final int n14 = 1;
            hsb[n14] += 0.05f;
            if (this.hsb[1] > 1.0f) {
                this.hsb[1] = 1.0f;
            }
        }
        if (!this.nocol && this.glass != 1) {
            if (this.bfase > 20 && this.hsb[1] > 0.25) {
                this.hsb[1] = 0.25f;
            }
            if (this.bfase > 25 && this.hsb[2] > 0.7) {
                this.hsb[2] = 0.7f;
            }
            if (this.bfase > 30 && this.hsb[1] > 0.15) {
                this.hsb[1] = 0.15f;
            }
            if (this.bfase > 35 && this.hsb[2] > 0.6) {
                this.hsb[2] = 0.6f;
            }
            if (this.bfase > 40) {
                this.hsb[0] = 0.075f;
            }
            if (this.bfase > 50 && this.hsb[2] > 0.5) {
                this.hsb[2] = 0.5f;
            }
            if (this.bfase > 60) {
                this.hsb[0] = 0.05f;
            }
        }
        this.road = road;
        this.light = light;
        this.solo = solo;
        this.gr = gr;
        this.fs = fs;
        this.wx = wx;
        this.wy = wy;
        this.wz = wz;
        this.deltafntyp();
    }
    
    public void deltafntyp() {
        final int abs = Math.abs(this.ox[2] - this.ox[1]);
        final int abs2 = Math.abs(this.oy[2] - this.oy[1]);
        final int abs3 = Math.abs(this.oz[2] - this.oz[1]);
        if (abs2 <= abs && abs2 <= abs3) {
            this.typ = 2;
        }
        if (abs <= abs2 && abs <= abs3) {
            this.typ = 1;
        }
        if (abs3 <= abs && abs3 <= abs2) {
            this.typ = 3;
        }
        this.deltaf = 1.0f;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (j != i) {
                    this.deltaf *= (float)(Math.sqrt((this.ox[j] - this.ox[i]) * (this.ox[j] - this.ox[i]) + (this.oy[j] - this.oy[i]) * (this.oy[j] - this.oy[i]) + (this.oz[j] - this.oz[i]) * (this.oz[j] - this.oz[i])) / 100.0);
                }
            }
        }
        this.deltaf /= 3.0f;
    }
    
    public void loadprojf() {
        this.projf = 1.0f;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (j != i) {
                    this.projf *= (float)(Math.sqrt((this.ox[i] - this.ox[j]) * (this.ox[i] - this.ox[j]) + (this.oz[i] - this.oz[j]) * (this.oz[i] - this.oz[j])) / 100.0);
                }
            }
        }
        this.projf /= 3.0f;
    }
    
    public void d(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int cxz, final int cxy, final int czy, final int n4, final int n5, boolean b, final int n6) {
        if (this.master == 1) {
            if (this.av > 1500 && !this.m.crs) {
                this.n = 12;
            }
            else {
                this.n = 20;
            }
        }
        final int[] array = new int[this.n];
        final int[] array2 = new int[this.n];
        final int[] array3 = new int[this.n];
        if (this.embos == 0) {
            for (int i = 0; i < this.n; ++i) {
                array[i] = this.ox[i] + n;
                array3[i] = this.oy[i] + n2;
                array2[i] = this.oz[i] + n3;
            }
            if ((this.gr == -11 || this.gr == -12 || this.gr == -13) && this.m.lastmaf == 1) {
                for (int j = 0; j < this.n; ++j) {
                    array[j] = -this.ox[j] + n;
                    array3[j] = this.oy[j] + n2;
                    array2[j] = -this.oz[j] + n3;
                }
            }
        }
        else {
            if (this.embos <= 11 && this.m.random() > 0.5 && this.glass != 1) {
                for (int k = 0; k < this.n; ++k) {
                    array[k] = (int)(this.ox[k] + n + (15.0f - this.m.random() * 30.0f));
                    array3[k] = (int)(this.oy[k] + n2 + (15.0f - this.m.random() * 30.0f));
                    array2[k] = (int)(this.oz[k] + n3 + (15.0f - this.m.random() * 30.0f));
                }
                this.rot(array, array3, n, n2, cxy, this.n);
                this.rot(array3, array2, n2, n3, czy, this.n);
                this.rot(array, array2, n, n3, cxz, this.n);
                this.rot(array, array2, this.m.cx, this.m.cz, this.m.xz, this.n);
                this.rot(array3, array2, this.m.cy, this.m.cz, this.m.zy, this.n);
                final int[] array4 = new int[this.n];
                final int[] array5 = new int[this.n];
                for (int l = 0; l < this.n; ++l) {
                    array4[l] = this.xs(array[l], array2[l]);
                    array5[l] = this.ys(array3[l], array2[l]);
                }
                graphics2D.setColor(new Color(230, 230, 230));
                graphics2D.fillPolygon(array4, array5, this.n);
            }
            float n7 = 1.0f;
            if (this.embos <= 4) {
                n7 = 1.0f + this.m.random() / 5.0f;
            }
            if (this.embos > 4 && this.embos <= 7) {
                n7 = 1.0f + this.m.random() / 4.0f;
            }
            if (this.embos > 7 && this.embos <= 9) {
                n7 = 1.0f + this.m.random() / 3.0f;
                if (this.hsb[2] > 0.7) {
                    this.hsb[2] = 0.7f;
                }
            }
            if (this.embos > 9 && this.embos <= 10) {
                n7 = 1.0f + this.m.random() / 2.0f;
                if (this.hsb[2] > 0.6) {
                    this.hsb[2] = 0.6f;
                }
            }
            if (this.embos > 10 && this.embos <= 12) {
                n7 = 1.0f + this.m.random() / 1.0f;
                if (this.hsb[2] > 0.5) {
                    this.hsb[2] = 0.5f;
                }
            }
            if (this.embos == 12) {
                this.chip = 1;
                this.ctmag = 2.0f;
                this.bfase = -7;
            }
            if (this.embos == 13) {
                this.hsb[1] = 0.2f;
                this.hsb[2] = 0.4f;
            }
            if (this.embos == 16) {
                this.pa = (int)(this.m.random() * this.n);
                this.pb = (int)(this.m.random() * this.n);
                while (this.pa == this.pb) {
                    this.pb = (int)(this.m.random() * this.n);
                }
            }
            if (this.embos >= 16) {
                int n8 = 1;
                int n9 = 1;
                int abs;
                for (abs = Math.abs(czy); abs > 270; abs -= 360) {}
                if (Math.abs(abs) > 90) {
                    n8 = -1;
                }
                int abs2;
                for (abs2 = Math.abs(cxy); abs2 > 270; abs2 -= 360) {}
                if (Math.abs(abs2) > 90) {
                    n9 = -1;
                }
                final int[] array6 = new int[3];
                final int[] array7 = new int[3];
                array[0] = this.ox[this.pa] + n;
                array3[0] = this.oy[this.pa] + n2;
                array2[0] = this.oz[this.pa] + n3;
                array[1] = this.ox[this.pb] + n;
                array3[1] = this.oy[this.pb] + n2;
                array2[1] = this.oz[this.pb] + n3;
                while (Math.abs(array[0] - array[1]) > 100) {
                    if (array[1] > array[0]) {
                        final int[] array8 = array;
                        final int n10 = 1;
                        array8[n10] -= 30;
                    }
                    else {
                        final int[] array9 = array;
                        final int n11 = 1;
                        array9[n11] += 30;
                    }
                }
                while (Math.abs(array2[0] - array2[1]) > 100) {
                    if (array2[1] > array2[0]) {
                        final int[] array10 = array2;
                        final int n12 = 1;
                        array10[n12] -= 30;
                    }
                    else {
                        final int[] array11 = array2;
                        final int n13 = 1;
                        array11[n13] += 30;
                    }
                }
                final int n14 = (int)(Math.abs(array[0] - array[1]) / 3 * (0.5 - this.m.random()));
                final int n15 = (int)(Math.abs(array2[0] - array2[1]) / 3 * (0.5 - this.m.random()));
                array[2] = (array[0] + array[1]) / 2 + n14;
                array2[2] = (array2[0] + array2[1]) / 2 + n15;
                final int n16 = (int)((Math.abs(array[0] - array[1]) + Math.abs(array2[0] - array2[1])) / 1.5 * (this.m.random() / 2.0f + 0.5));
                array3[2] = (array3[0] + array3[1]) / 2 - n8 * n9 * n16;
                this.rot(array, array3, n, n2, cxy, 3);
                this.rot(array3, array2, n2, n3, czy, 3);
                this.rot(array, array2, n, n3, cxz, 3);
                this.rot(array, array2, this.m.cx, this.m.cz, this.m.xz, 3);
                this.rot(array3, array2, this.m.cy, this.m.cz, this.m.zy, 3);
                for (int n17 = 0; n17 < 3; ++n17) {
                    array6[n17] = this.xs(array[n17], array2[n17]);
                    array7[n17] = this.ys(array3[n17], array2[n17]);
                }
                int n18 = (int)(255.0f + 255.0f * (this.m.snap[0] / 400.0f));
                if (n18 > 255) {
                    n18 = 255;
                }
                if (n18 < 0) {
                    n18 = 0;
                }
                int n19 = (int)(169.0f + 169.0f * (this.m.snap[1] / 300.0f));
                if (n19 > 255) {
                    n19 = 255;
                }
                if (n19 < 0) {
                    n19 = 0;
                }
                int n20 = (int)(89.0f + 89.0f * (this.m.snap[2] / 200.0f));
                if (n20 > 255) {
                    n20 = 255;
                }
                if (n20 < 0) {
                    n20 = 0;
                }
                graphics2D.setColor(new Color(n18, n19, n20));
                graphics2D.fillPolygon(array6, array7, 3);
                array[0] = this.ox[this.pa] + n;
                array3[0] = this.oy[this.pa] + n2;
                array2[0] = this.oz[this.pa] + n3;
                array[1] = this.ox[this.pb] + n;
                array3[1] = this.oy[this.pb] + n2;
                array2[1] = this.oz[this.pb] + n3;
                while (Math.abs(array[0] - array[1]) > 100) {
                    if (array[1] > array[0]) {
                        final int[] array12 = array;
                        final int n21 = 1;
                        array12[n21] -= 30;
                    }
                    else {
                        final int[] array13 = array;
                        final int n22 = 1;
                        array13[n22] += 30;
                    }
                }
                while (Math.abs(array2[0] - array2[1]) > 100) {
                    if (array2[1] > array2[0]) {
                        final int[] array14 = array2;
                        final int n23 = 1;
                        array14[n23] -= 30;
                    }
                    else {
                        final int[] array15 = array2;
                        final int n24 = 1;
                        array15[n24] += 30;
                    }
                }
                array[2] = (array[0] + array[1]) / 2 + n14;
                array2[2] = (array2[0] + array2[1]) / 2 + n15;
                array3[2] = (array3[0] + array3[1]) / 2 - n8 * n9 * (int)(n16 * 0.8);
                this.rot(array, array3, n, n2, cxy, 3);
                this.rot(array3, array2, n2, n3, czy, 3);
                this.rot(array, array2, n, n3, cxz, 3);
                this.rot(array, array2, this.m.cx, this.m.cz, this.m.xz, 3);
                this.rot(array3, array2, this.m.cy, this.m.cz, this.m.zy, 3);
                for (int n25 = 0; n25 < 3; ++n25) {
                    array6[n25] = this.xs(array[n25], array2[n25]);
                    array7[n25] = this.ys(array3[n25], array2[n25]);
                }
                int n26 = (int)(255.0f + 255.0f * (this.m.snap[0] / 400.0f));
                if (n26 > 255) {
                    n26 = 255;
                }
                if (n26 < 0) {
                    n26 = 0;
                }
                int n27 = (int)(207.0f + 207.0f * (this.m.snap[1] / 300.0f));
                if (n27 > 255) {
                    n27 = 255;
                }
                if (n27 < 0) {
                    n27 = 0;
                }
                int n28 = (int)(136.0f + 136.0f * (this.m.snap[2] / 200.0f));
                if (n28 > 255) {
                    n28 = 255;
                }
                if (n28 < 0) {
                    n28 = 0;
                }
                graphics2D.setColor(new Color(n26, n27, n28));
                graphics2D.fillPolygon(array6, array7, 3);
            }
            for (int n29 = 0; n29 < this.n; ++n29) {
                if (this.typ == 1) {
                    array[n29] = (int)(this.ox[n29] * n7 + n);
                }
                else {
                    array[n29] = this.ox[n29] + n;
                }
                if (this.typ == 2) {
                    array3[n29] = (int)(this.oy[n29] * n7 + n2);
                }
                else {
                    array3[n29] = this.oy[n29] + n2;
                }
                if (this.typ == 3) {
                    array2[n29] = (int)(this.oz[n29] * n7 + n3);
                }
                else {
                    array2[n29] = this.oz[n29] + n3;
                }
            }
            if (this.embos != 70) {
                ++this.embos;
            }
            else {
                this.embos = 16;
            }
        }
        if (this.wz != 0) {
            this.rot(array3, array2, this.wy + n2, this.wz + n3, n5, this.n);
        }
        if (this.wx != 0) {
            this.rot(array, array2, this.wx + n, this.wz + n3, n4, this.n);
        }
        if (this.chip == 1 && (this.m.random() > 0.6 || this.bfase == 0)) {
            this.chip = 0;
            if (this.bfase == 0 && this.nocol) {
                this.bfase = 1;
            }
        }
        if (this.chip != 0) {
            if (this.chip == 1) {
                this.cxz = cxz;
                this.cxy = cxy;
                this.czy = czy;
                final int n30 = (int)(this.m.random() * this.n);
                this.cox[0] = this.ox[n30];
                this.coz[0] = this.oz[n30];
                this.coy[0] = this.oy[n30];
                if (this.ctmag > 3.0f) {
                    this.ctmag = 3.0f;
                }
                if (this.ctmag < -3.0f) {
                    this.ctmag = -3.0f;
                }
                this.cox[1] = (int)(this.cox[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.cox[2] = (int)(this.cox[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coy[1] = (int)(this.coy[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coy[2] = (int)(this.coy[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coz[1] = (int)(this.coz[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coz[2] = (int)(this.coz[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.dx = 0;
                this.dy = 0;
                this.dz = 0;
                if (this.bfase != -7) {
                    this.vx = (int)(this.ctmag * (30.0f - this.m.random() * 60.0f));
                    this.vz = (int)(this.ctmag * (30.0f - this.m.random() * 60.0f));
                    this.vy = (int)(this.ctmag * (30.0f - this.m.random() * 60.0f));
                }
                else {
                    this.vx = (int)(this.ctmag * (10.0f - this.m.random() * 20.0f));
                    this.vz = (int)(this.ctmag * (10.0f - this.m.random() * 20.0f));
                    this.vy = (int)(this.ctmag * (10.0f - this.m.random() * 20.0f));
                }
                this.chip = 2;
            }
            final int[] array16 = new int[3];
            final int[] array17 = new int[3];
            final int[] array18 = new int[3];
            for (int n31 = 0; n31 < 3; ++n31) {
                array16[n31] = this.cox[n31] + n;
                array18[n31] = this.coy[n31] + n2;
                array17[n31] = this.coz[n31] + n3;
            }
            this.rot(array16, array18, n, n2, this.cxy, 3);
            this.rot(array18, array17, n2, n3, this.czy, 3);
            this.rot(array16, array17, n, n3, this.cxz, 3);
            for (int n32 = 0; n32 < 3; ++n32) {
                final int[] array19 = array16;
                final int n33 = n32;
                array19[n33] += this.dx;
                final int[] array20 = array18;
                final int n34 = n32;
                array20[n34] += this.dy;
                final int[] array21 = array17;
                final int n35 = n32;
                array21[n35] += this.dz;
            }
            this.dx += this.vx;
            this.dz += this.vz;
            this.dy += this.vy;
            this.vy += 7;
            if (array18[0] > this.m.ground) {
                this.chip = 19;
            }
            this.rot(array16, array17, this.m.cx, this.m.cz, this.m.xz, 3);
            this.rot(array18, array17, this.m.cy, this.m.cz, this.m.zy, 3);
            final int[] array22 = new int[3];
            final int[] array23 = new int[3];
            for (int n36 = 0; n36 < 3; ++n36) {
                array22[n36] = this.xs(array16[n36], array17[n36]);
                array23[n36] = this.ys(array18[n36], array17[n36]);
            }
            final int n37 = (int)(this.m.random() * 3.0f);
            if (this.bfase != -7) {
                if (n37 == 0) {
                    graphics2D.setColor(new Color(this.c[0], this.c[1], this.c[2]).darker());
                }
                if (n37 == 1) {
                    graphics2D.setColor(new Color(this.c[0], this.c[1], this.c[2]));
                }
                if (n37 == 2) {
                    graphics2D.setColor(new Color(this.c[0], this.c[1], this.c[2]).brighter());
                }
            }
            else {
                graphics2D.setColor(Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2]));
            }
            graphics2D.fillPolygon(array22, array23, 3);
            ++this.chip;
            if (this.chip == 20) {
                this.chip = 0;
            }
        }
        this.rot(array, array3, n, n2, cxy, this.n);
        this.rot(array3, array2, n2, n3, czy, this.n);
        this.rot(array, array2, n, n3, cxz, this.n);
        if ((cxy != 0 || czy != 0 || cxz != 0) && this.m.trk != 2) {
            this.projf = 1.0f;
            for (int n38 = 0; n38 < 3; ++n38) {
                for (int n39 = 0; n39 < 3; ++n39) {
                    if (n39 != n38) {
                        this.projf *= (float)(Math.sqrt((array[n38] - array[n39]) * (array[n38] - array[n39]) + (array2[n38] - array2[n39]) * (array2[n38] - array2[n39])) / 100.0);
                    }
                }
            }
            this.projf /= 3.0f;
        }
        this.rot(array, array2, this.m.cx, this.m.cz, this.m.xz, this.n);
        boolean b2 = false;
        final int[] array24 = new int[this.n];
        final int[] array25 = new int[this.n];
        int n40 = 500;
        for (int n41 = 0; n41 < this.n; ++n41) {
            array24[n41] = this.xs(array[n41], array2[n41]);
            array25[n41] = this.ys(array3[n41], array2[n41]);
        }
        int n42 = 0;
        int n43 = 1;
        for (int n44 = 0; n44 < this.n; ++n44) {
            for (int n45 = n44; n45 < this.n; ++n45) {
                if (n44 != n45 && Math.abs(array24[n44] - array24[n45]) - Math.abs(array25[n44] - array25[n45]) < n40) {
                    n43 = n44;
                    n42 = n45;
                    n40 = Math.abs(array24[n44] - array24[n45]) - Math.abs(array25[n44] - array25[n45]);
                }
            }
        }
        if (array25[n42] < array25[n43]) {
            final int n46 = n42;
            n42 = n43;
            n43 = n46;
        }
        if (this.spy(array[n42], array2[n42]) > this.spy(array[n43], array2[n43])) {
            b2 = true;
            int n47 = 0;
            for (int n48 = 0; n48 < this.n; ++n48) {
                if (array2[n48] < 50 && array3[n48] > this.m.cy) {
                    b2 = false;
                }
                else if (array3[n48] == array3[0]) {
                    ++n47;
                }
            }
            if (n47 == this.n && array3[0] > this.m.cy) {
                b2 = false;
            }
        }
        this.rot(array3, array2, this.m.cy, this.m.cz, this.m.zy, this.n);
        int n49 = 1;
        final int[] array26 = new int[this.n];
        final int[] array27 = new int[this.n];
        int n50 = 0;
        int n51 = 0;
        int n52 = 0;
        int n53 = 0;
        int n54 = 0;
        for (int n55 = 0; n55 < this.n; ++n55) {
            array26[n55] = this.xs(array[n55], array2[n55]);
            array27[n55] = this.ys(array3[n55], array2[n55]);
            if (array27[n55] < this.m.ih || array2[n55] < 10) {
                ++n50;
            }
            if (array27[n55] > this.m.h || array2[n55] < 10) {
                ++n51;
            }
            if (array26[n55] < this.m.iw || array2[n55] < 10) {
                ++n52;
            }
            if (array26[n55] > this.m.w || array2[n55] < 10) {
                ++n53;
            }
            if (array2[n55] < 10) {
                ++n54;
            }
        }
        if (n52 == this.n || n50 == this.n || n51 == this.n || n53 == this.n) {
            n49 = 0;
        }
        if ((this.m.trk == 1 || this.m.trk == 4) && (n52 != 0 || n50 != 0 || n51 != 0 || n53 != 0)) {
            n49 = 0;
        }
        if (this.m.trk == 3 && n54 != 0) {
            n49 = 0;
        }
        if (n54 != 0) {
            b = true;
        }
        if (n49 != 0 && n6 != -1) {
            int abs3 = 0;
            int abs4 = 0;
            for (int n56 = 0; n56 < this.n; ++n56) {
                for (int n57 = n56; n57 < this.n; ++n57) {
                    if (n56 != n57) {
                        if (Math.abs(array26[n56] - array26[n57]) > abs3) {
                            abs3 = Math.abs(array26[n56] - array26[n57]);
                        }
                        if (Math.abs(array27[n56] - array27[n57]) > abs4) {
                            abs4 = Math.abs(array27[n56] - array27[n57]);
                        }
                    }
                }
            }
            if (abs3 == 0 || abs4 == 0) {
                n49 = 0;
            }
            else if (abs3 < 3 && abs4 < 3 && ((n6 / abs3 > 15 && n6 / abs4 > 15) || b) && (!this.m.lightson || this.light == 0)) {
                n49 = 0;
            }
        }
        if (n49 != 0) {
            int lastmaf = 1;
            int gr = this.gr;
            if (gr < 0 && gr >= -15) {
                gr = 0;
            }
            if (this.gr == -11) {
                gr = -90;
            }
            if (this.gr == -12) {
                gr = -75;
            }
            if (this.gr == -14 || this.gr == -15) {
                gr = -50;
            }
            if (this.glass == 2) {
                gr = 200;
            }
            if (this.fs != 0) {
                int n58;
                int n59;
                if (Math.abs(array27[0] - array27[1]) > Math.abs(array27[2] - array27[1])) {
                    n58 = 0;
                    n59 = 2;
                }
                else {
                    n58 = 2;
                    n59 = 0;
                    lastmaf *= -1;
                }
                if (array27[1] > array27[n58]) {
                    lastmaf *= -1;
                }
                if (array26[1] > array26[n59]) {
                    lastmaf *= -1;
                }
                if (this.fs != 22) {
                    lastmaf *= this.fs;
                    if (lastmaf == -1) {
                        gr += 40;
                        lastmaf = -111;
                    }
                }
            }
            if (this.m.lightson && this.light == 2) {
                gr -= 40;
            }
            int n60 = array3[0];
            int n61 = array3[0];
            int n62 = array[0];
            int n63 = array[0];
            int n64 = array2[0];
            int n65 = array2[0];
            for (int n66 = 0; n66 < this.n; ++n66) {
                if (array3[n66] > n60) {
                    n60 = array3[n66];
                }
                if (array3[n66] < n61) {
                    n61 = array3[n66];
                }
                if (array[n66] > n62) {
                    n62 = array[n66];
                }
                if (array[n66] < n63) {
                    n63 = array[n66];
                }
                if (array2[n66] > n64) {
                    n64 = array2[n66];
                }
                if (array2[n66] < n65) {
                    n65 = array2[n66];
                }
            }
            final int n67 = (n60 + n61) / 2;
            final int n68 = (n62 + n63) / 2;
            final int n69 = (n64 + n65) / 2;
            this.av = (int)Math.sqrt((this.m.cy - n67) * (this.m.cy - n67) + (this.m.cx - n68) * (this.m.cx - n68) + n69 * n69 + gr * gr * gr);
            if (this.m.trk == 0 && (this.av > this.m.fade[this.disline] || this.av == 0)) {
                n49 = 0;
            }
            if (lastmaf == -111 && this.av > 4500 && !this.road) {
                n49 = 0;
            }
            if (lastmaf == -111 && this.av > 1500) {
                b = true;
            }
            if (this.av > 3000 && this.m.adv <= 900) {
                b = true;
            }
            if (this.fs == 22 && this.av < 11200) {
                this.m.lastmaf = lastmaf;
            }
            if (this.gr == -13 && (!this.m.lastcheck || n6 != -1)) {
                n49 = 0;
            }
            if (this.master == 2 && this.av > 1500 && !this.m.crs) {
                n49 = 0;
            }
            if ((this.gr == -14 || this.gr == -15 || this.gr == -12) && (this.av > 11000 || b2 || lastmaf == -111 || this.m.resdown == 2) && this.m.trk != 2 && this.m.trk != 3) {
                n49 = 0;
            }
            if (this.gr == -11 && this.av > 11000 && this.m.trk != 2 && this.m.trk != 3) {
                n49 = 0;
            }
            if (this.glass == 2 && (this.m.trk != 0 || this.av > 6700)) {
                n49 = 0;
            }
            if (this.flx != 0 && this.m.random() > 0.3 && this.flx != 77) {
                n49 = 0;
            }
        }
        if (n49 != 0) {
            float n70 = (float)(this.projf / this.deltaf + 0.3);
            if (b && !this.solo) {
                boolean b3 = false;
                if (n70 > 1.0f) {
                    if (n70 >= 1.27) {
                        b3 = true;
                    }
                    n70 = 1.0f;
                }
                if (b3) {
                    n70 *= 0.89;
                }
                else {
                    n70 *= 0.86;
                }
                if (n70 < 0.37) {
                    n70 = 0.37f;
                }
                if (this.gr == -9) {
                    n70 = 0.7f;
                }
                if (this.gr == -4) {
                    n70 = 0.74f;
                }
                if (this.gr != -7 && this.m.trk == 0 && b2) {
                    n70 = 0.32f;
                }
                if (this.gr == -8 || this.gr == -14 || this.gr == -15) {
                    n70 = 1.0f;
                }
                if (this.gr == -11 || this.gr == -12) {
                    n70 = 0.6f;
                    if (n6 == -1) {
                        if (this.m.cpflik || (this.m.nochekflk && !this.m.lastcheck)) {
                            n70 = 1.0f;
                        }
                        else {
                            n70 = 0.76f;
                        }
                    }
                }
                if (this.gr == -13 && n6 == -1) {
                    if (this.m.cpflik) {
                        n70 = 0.0f;
                    }
                    else {
                        n70 = 0.76f;
                    }
                }
                if (this.gr == -6) {
                    n70 = 0.62f;
                }
                if (this.gr == -5) {
                    n70 = 0.55f;
                }
            }
            else {
                if (n70 > 1.0f) {
                    n70 = 1.0f;
                }
                if (n70 < 0.6 || b2) {
                    n70 = 0.6f;
                }
            }
            Color color = Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2] * n70);
            if (this.m.trk == 1) {
                final float[] array28 = new float[3];
                Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], array28);
                array28[0] = 0.15f;
                array28[1] = 0.3f;
                color = Color.getHSBColor(array28[0], array28[1], array28[2] * n70 + 0.0f);
            }
            if (this.m.trk == 3) {
                final float[] array29 = new float[3];
                Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], array29);
                array29[0] = 0.6f;
                array29[1] = 0.14f;
                color = Color.getHSBColor(array29[0], array29[1], array29[2] * n70 + 0.0f);
            }
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            if (this.m.lightson && (this.light != 0 || ((this.gr == -11 || this.gr == -12) && n6 == -1))) {
                red = this.oc[0];
                if (red > 255) {
                    red = 255;
                }
                if (red < 0) {
                    red = 0;
                }
                green = this.oc[1];
                if (green > 255) {
                    green = 255;
                }
                if (green < 0) {
                    green = 0;
                }
                blue = this.oc[2];
                if (blue > 255) {
                    blue = 255;
                }
                if (blue < 0) {
                    blue = 0;
                }
            }
            if (this.m.trk == 0) {
                for (int n71 = 0; n71 < 16; ++n71) {
                    if (this.av > this.m.fade[n71]) {
                        red = (red * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                        green = (green * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                        blue = (blue * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                    }
                }
            }
            graphics2D.setColor(new Color(red, green, blue));
            graphics2D.fillPolygon(array26, array27, this.n);
            if (this.m.trk != 0 && this.gr == -10) {
                b = false;
            }
            if (!b) {
                if (this.flx == 0) {
                    if (!this.solo) {
                        int n72 = 0;
                        int n73 = 0;
                        int n74 = 0;
                        if (this.m.lightson && this.light != 0) {
                            n72 = this.oc[0] / 2;
                            if (n72 > 255) {
                                n72 = 255;
                            }
                            if (n72 < 0) {
                                n72 = 0;
                            }
                            n73 = this.oc[1] / 2;
                            if (n73 > 255) {
                                n73 = 255;
                            }
                            if (n73 < 0) {
                                n73 = 0;
                            }
                            n74 = this.oc[2] / 2;
                            if (n74 > 255) {
                                n74 = 255;
                            }
                            if (n74 < 0) {
                                n74 = 0;
                            }
                        }
                        if (Madness.anti == 1) {
                            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        }
                        graphics2D.setColor(new Color(n72, n73, n74));
                        graphics2D.drawPolygon(array26, array27, this.n);
                        if (Madness.anti == 1) {
                            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                        }
                    }
                }
                else {
                    if (this.flx == 2) {
                        graphics2D.setColor(new Color(0, 0, 0));
                        graphics2D.drawPolygon(array26, array27, this.n);
                    }
                    if (this.flx == 1) {
                        final boolean b4 = false;
                        int n75 = (int)(223.0f + 223.0f * (this.m.snap[1] / 100.0f));
                        if (n75 > 255) {
                            n75 = 255;
                        }
                        if (n75 < 0) {
                            n75 = 0;
                        }
                        int n76 = (int)(255.0f + 255.0f * (this.m.snap[2] / 100.0f));
                        if (n76 > 255) {
                            n76 = 255;
                        }
                        if (n76 < 0) {
                            n76 = 0;
                        }
                        graphics2D.setColor(new Color((int)(b4 ? 1 : 0), n75, n76));
                        graphics2D.drawPolygon(array26, array27, this.n);
                        this.flx = 2;
                    }
                    if (this.flx == 3) {
                        final boolean b5 = false;
                        int n77 = (int)(255.0f + 255.0f * (this.m.snap[1] / 100.0f));
                        if (n77 > 255) {
                            n77 = 255;
                        }
                        if (n77 < 0) {
                            n77 = 0;
                        }
                        int n78 = (int)(223.0f + 223.0f * (this.m.snap[2] / 100.0f));
                        if (n78 > 255) {
                            n78 = 255;
                        }
                        if (n78 < 0) {
                            n78 = 0;
                        }
                        graphics2D.setColor(new Color((int)(b5 ? 1 : 0), n77, n78));
                        graphics2D.drawPolygon(array26, array27, this.n);
                        this.flx = 2;
                    }
                    if (this.flx == 77) {
                        graphics2D.setColor(new Color(16, 198, 255));
                        graphics2D.drawPolygon(array26, array27, this.n);
                        this.flx = 0;
                    }
                }
            }
            else if (this.road && this.av <= 3000 && this.m.trk == 0 && this.m.fade[0] > 4000) {
                red -= 10;
                if (red < 0) {
                    red = 0;
                }
                green -= 10;
                if (green < 0) {
                    green = 0;
                }
                blue -= 10;
                if (blue < 0) {
                    blue = 0;
                }
                graphics2D.setColor(new Color(red, green, blue));
                graphics2D.drawPolygon(array26, array27, this.n);
            }
            if (this.gr == -10) {
                if (this.m.trk == 0) {
                    int n79 = this.c[0];
                    int n80 = this.c[1];
                    int n81 = this.c[2];
                    if (n6 == -1 && this.m.cpflik) {
                        n79 *= (int)1.6;
                        if (n79 > 255) {
                            n79 = 255;
                        }
                        n80 *= (int)1.6;
                        if (n80 > 255) {
                            n80 = 255;
                        }
                        n81 *= (int)1.6;
                        if (n81 > 255) {
                            n81 = 255;
                        }
                    }
                    for (int n82 = 0; n82 < 16; ++n82) {
                        if (this.av > this.m.fade[n82]) {
                            n79 = (n79 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                            n80 = (n80 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                            n81 = (n81 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                        }
                    }
                    graphics2D.setColor(new Color(n79, n80, n81));
                    graphics2D.drawPolygon(array26, array27, this.n);
                }
                else if (this.m.cpflik && this.m.hit == 5000) {
                    int n83 = (int)(Math.random() * 115.0);
                    int n84 = n83 * 2 - 54;
                    if (n84 < 0) {
                        n84 = 0;
                    }
                    if (n84 > 255) {
                        n84 = 255;
                    }
                    int n85 = 202 + n83 * 2;
                    if (n85 < 0) {
                        n85 = 0;
                    }
                    if (n85 > 255) {
                        n85 = 255;
                    }
                    n83 += 101;
                    if (n83 < 0) {
                        n83 = 0;
                    }
                    if (n83 > 255) {
                        n83 = 255;
                    }
                    graphics2D.setColor(new Color(n84, n83, n85));
                    graphics2D.drawPolygon(array26, array27, this.n);
                }
            }
            if (this.gr == -18 && this.m.trk == 0) {
                int n86 = this.c[0];
                int n87 = this.c[1];
                int n88 = this.c[2];
                if (this.m.cpflik && this.m.elecr >= 0.0f) {
                    n86 = (int)(25.5f * this.m.elecr);
                    if (n86 > 255) {
                        n86 = 255;
                    }
                    n87 = (int)(128.0f + 12.8f * this.m.elecr);
                    if (n87 > 255) {
                        n87 = 255;
                    }
                    n88 = 255;
                }
                for (int n89 = 0; n89 < 16; ++n89) {
                    if (this.av > this.m.fade[n89]) {
                        n86 = (n86 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                        n87 = (n87 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                        n88 = (n88 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                    }
                }
                graphics2D.setColor(new Color(n86, n87, n88));
                graphics2D.drawPolygon(array26, array27, this.n);
            }
        }
    }
    
    public void s(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        final int[] array = new int[this.n];
        final int[] array2 = new int[this.n];
        final int[] array3 = new int[this.n];
        for (int i = 0; i < this.n; ++i) {
            array[i] = this.ox[i] + n;
            array3[i] = this.oy[i] + n2;
            array2[i] = this.oz[i] + n3;
        }
        this.rot(array, array3, n, n2, n5, this.n);
        this.rot(array3, array2, n2, n3, n6, this.n);
        this.rot(array, array2, n, n3, n4, this.n);
        int n8 = (int)(this.m.crgrnd[0] / 1.5);
        int n9 = (int)(this.m.crgrnd[1] / 1.5);
        int n10 = (int)(this.m.crgrnd[2] / 1.5);
        for (int j = 0; j < this.n; ++j) {
            array3[j] = this.m.ground;
        }
        if (n7 == 0) {
            int n11 = 0;
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            for (int k = 0; k < this.n; ++k) {
                int n15 = 0;
                int n16 = 0;
                int n17 = 0;
                int n18 = 0;
                for (int l = 0; l < this.n; ++l) {
                    if (array[k] >= array[l]) {
                        ++n15;
                    }
                    if (array[k] <= array[l]) {
                        ++n16;
                    }
                    if (array2[k] >= array2[l]) {
                        ++n17;
                    }
                    if (array2[k] <= array2[l]) {
                        ++n18;
                    }
                }
                if (n15 == this.n) {
                    n11 = array[k];
                }
                if (n16 == this.n) {
                    n12 = array[k];
                }
                if (n17 == this.n) {
                    n13 = array2[k];
                }
                if (n18 == this.n) {
                    n14 = array2[k];
                }
            }
            final int n19 = (n11 + n12) / 2;
            final int n20 = (n13 + n14) / 2;
            int ncx = (n19 - this.t.sx + this.m.x) / 3000;
            if (ncx > this.t.ncx) {
                ncx = this.t.ncx;
            }
            if (ncx < 0) {
                ncx = 0;
            }
            int ncz = (n20 - this.t.sz + this.m.z) / 3000;
            if (ncz > this.t.ncz) {
                ncz = this.t.ncz;
            }
            if (ncz < 0) {
                ncz = 0;
            }
            for (int n21 = this.t.sect[ncx][ncz].length - 1; n21 >= 0; --n21) {
                final int n22 = this.t.sect[ncx][ncz][n21];
                int n23 = 0;
                if (Math.abs(this.t.zy[n22]) != 90 && Math.abs(this.t.xy[n22]) != 90 && this.t.rady[n22] != 801 && Math.abs(n19 - (this.t.x[n22] - this.m.x)) < this.t.radx[n22] && Math.abs(n20 - (this.t.z[n22] - this.m.z)) < this.t.radz[n22] && (!this.t.decor[n22] || this.m.resdown != 2)) {
                    ++n23;
                }
                if (n23 != 0) {
                    for (int n24 = 0; n24 < this.n; ++n24) {
                        array3[n24] = this.t.y[n22] - this.m.y;
                        if (this.t.zy[n22] != 0) {
                            final int[] array4 = array3;
                            final int n25 = n24;
                            array4[n25] += (int)((array2[n24] - (this.t.z[n22] - this.m.z - this.t.radz[n22])) * this.m.sin(this.t.zy[n22]) / this.m.sin(90 - this.t.zy[n22]) - this.t.radz[n22] * this.m.sin(this.t.zy[n22]) / this.m.sin(90 - this.t.zy[n22]));
                        }
                        if (this.t.xy[n22] != 0) {
                            final int[] array5 = array3;
                            final int n26 = n24;
                            array5[n26] += (int)((array[n24] - (this.t.x[n22] - this.m.x - this.t.radx[n22])) * this.m.sin(this.t.xy[n22]) / this.m.sin(90 - this.t.xy[n22]) - this.t.radx[n22] * this.m.sin(this.t.xy[n22]) / this.m.sin(90 - this.t.xy[n22]));
                        }
                    }
                    n8 = (int)(this.t.c[n22][0] / 1.5);
                    n9 = (int)(this.t.c[n22][1] / 1.5);
                    n10 = (int)(this.t.c[n22][2] / 1.5);
                    break;
                }
            }
        }
        int n27 = 1;
        final int[] array6 = new int[this.n];
        final int[] array7 = new int[this.n];
        if (n7 == 2) {
            n8 = 87;
            n9 = 85;
            n10 = 57;
        }
        else {
            for (int n28 = 0; n28 < this.m.nsp; ++n28) {
                for (int n29 = 0; n29 < this.n; ++n29) {
                    if (Math.abs(array[n29] - this.m.spx[n28]) < this.m.sprad[n28] && Math.abs(array2[n29] - this.m.spz[n28]) < this.m.sprad[n28]) {
                        n27 = 0;
                    }
                }
            }
        }
        if (n27 != 0) {
            this.rot(array, array2, this.m.cx, this.m.cz, this.m.xz, this.n);
            this.rot(array3, array2, this.m.cy, this.m.cz, this.m.zy, this.n);
            int n30 = 0;
            int n31 = 0;
            int n32 = 0;
            int n33 = 0;
            for (int n34 = 0; n34 < this.n; ++n34) {
                array6[n34] = this.xs(array[n34], array2[n34]);
                array7[n34] = this.ys(array3[n34], array2[n34]);
                if (array7[n34] < this.m.ih || array2[n34] < 10) {
                    ++n30;
                }
                if (array7[n34] > this.m.h || array2[n34] < 10) {
                    ++n31;
                }
                if (array6[n34] < this.m.iw || array2[n34] < 10) {
                    ++n32;
                }
                if (array6[n34] > this.m.w || array2[n34] < 10) {
                    ++n33;
                }
            }
            if (n32 == this.n || n30 == this.n || n31 == this.n || n33 == this.n) {
                n27 = 0;
            }
        }
        if (n27 != 0) {
            for (int n35 = 0; n35 < 16; ++n35) {
                if (this.av > this.m.fade[n35]) {
                    n8 = (n8 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                    n9 = (n9 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                    n10 = (n10 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                }
            }
            graphics2D.setColor(new Color(n8, n9, n10));
            graphics2D.fillPolygon(array6, array7, this.n);
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
    
    public int spy(final int n, final int n2) {
        return (int)Math.sqrt((n - this.m.cx) * (n - this.m.cx) + n2 * n2);
    }
}
