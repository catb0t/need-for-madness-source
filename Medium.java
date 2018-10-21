import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Medium
{
    int focus_point;
    int ground;
    int skyline;
    int[] fade;
    int[] cldd;
    int[] clds;
    int[] osky;
    int[] csky;
    int[] ogrnd;
    int[] cgrnd;
    int[] texture;
    int[] cpol;
    int[] crgrnd;
    int[] cfade;
    int[] snap;
    int fogd;
    int mgen;
    boolean loadnew;
    boolean lightson;
    boolean darksky;
    int lightn;
    int lilo;
    boolean lton;
    int noelec;
    int trk;
    boolean crs;
    int cx;
    int cy;
    int cz;
    int xz;
    int zy;
    int x;
    int y;
    int z;
    int iw;
    int ih;
    int w;
    int h;
    int nsp;
    int[] spx;
    int[] spz;
    int[] sprad;
    boolean td;
    int bcxz;
    boolean bt;
    int vxz;
    int adv;
    boolean vert;
    float[] tcos;
    float[] tsin;
    int lastmaf;
    int checkpoint;
    boolean lastcheck;
    float elecr;
    boolean cpflik;
    boolean nochekflk;
    int cntrn;
    boolean[] diup;
    int[] rand;
    int trn;
    int hit;
    int ptr;
    int ptcnt;
    int nrnd;
    long trx;
    long trz;
    long atrx;
    long atrz;
    int fallen;
    float fo;
    float gofo;
    int fvect;
    int[][] ogpx;
    int[][] ogpz;
    float[][] pvr;
    int[] cgpx;
    int[] cgpz;
    int[] pmx;
    float[] pcv;
    int sgpx;
    int sgpz;
    int nrw;
    int ncl;
    int noc;
    int[] clx;
    int[] clz;
    int[] cmx;
    int[][][] clax;
    int[][][] clay;
    int[][][] claz;
    int[][][][] clc;
    int nmt;
    int[] mrd;
    int[] nmv;
    int[][] mtx;
    int[][] mty;
    int[][] mtz;
    int[][][] mtc;
    int nst;
    int[] stx;
    int[] stz;
    int[][][] stc;
    boolean[] bst;
    int[] twn;
    int resdown;
    int rescnt;

    public Medium() {
        this.focus_point = 400;
        this.ground = 250;
        this.skyline = -300;
        this.fade = new int[] { 3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 18000, 19500, 21000, 22500, 24000, 25500 };
        this.cldd = new int[] { 210, 210, 210, 1, -1000 };
        this.clds = new int[] { 210, 210, 210 };
        this.osky = new int[] { 170, 220, 255 };
        this.csky = new int[] { 170, 220, 255 };
        this.ogrnd = new int[] { 205, 200, 200 };
        this.cgrnd = new int[] { 205, 200, 200 };
        this.texture = new int[] { 0, 0, 0, 50 };
        this.cpol = new int[] { 215, 210, 210 };
        this.crgrnd = new int[] { 205, 200, 200 };
        this.cfade = new int[] { 255, 220, 220 };
        this.snap = new int[] { 0, 0, 0 };
        this.fogd = 7;
        this.mgen = (int)(Math.random() * 100000.0);
        this.loadnew = false;
        this.lightson = false;
        this.darksky = false;
        this.lightn = -1;
        this.lilo = 217;
        this.lton = false;
        this.noelec = 0;
        this.trk = 0;
        this.crs = false;
        this.cx = 400;
        this.cy = 225;
        this.cz = 50;
        this.xz = 0;
        this.zy = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.iw = 0;
        this.ih = 0;
        this.w = 800;
        this.h = 450;
        this.nsp = 0;
        this.spx = new int[7];
        this.spz = new int[7];
        this.sprad = new int[7];
        this.td = false;
        this.bcxz = 0;
        this.bt = false;
        this.vxz = 180;
        this.adv = 500;
        this.vert = false;
        this.tcos = new float[360];
        this.tsin = new float[360];
        this.lastmaf = 0;
        this.checkpoint = -1;
        this.lastcheck = false;
        this.elecr = 0.0f;
        this.cpflik = false;
        this.nochekflk = false;
        this.cntrn = 0;
        this.diup = new boolean[] { false, false, false };
        this.rand = new int[] { 0, 0, 0 };
        this.trn = 0;
        this.hit = 45000;
        this.ptr = 0;
        this.ptcnt = -10;
        this.nrnd = 0;
        this.trx = 0L;
        this.trz = 0L;
        this.atrx = 0L;
        this.atrz = 0L;
        this.fallen = 0;
        this.fo = 1.0f;
        this.gofo = (float)(0.33000001311302185 + Math.random() * 1.34);
        this.fvect = 200;
        this.ogpx = null;
        this.ogpz = null;
        this.pvr = null;
        this.cgpx = null;
        this.cgpz = null;
        this.pmx = null;
        this.pcv = null;
        this.sgpx = 0;
        this.sgpz = 0;
        this.nrw = 0;
        this.ncl = 0;
        this.noc = 0;
        this.clx = null;
        this.clz = null;
        this.cmx = null;
        this.clax = null;
        this.clay = null;
        this.claz = null;
        this.clc = null;
        this.nmt = 0;
        this.mrd = null;
        this.nmv = null;
        this.mtx = null;
        this.mty = null;
        this.mtz = null;
        this.mtc = null;
        this.nst = 0;
        this.stx = null;
        this.stz = null;
        this.stc = null;
        this.bst = null;
        this.twn = null;
        this.resdown = 0;
        this.rescnt = 5;
        for (int i = 0; i < 360; ++i) {
            this.tcos[i] = (float)Math.cos(i * 0.017453292519943295);
        }
        for (int j = 0; j < 360; ++j) {
            this.tsin[j] = (float)Math.sin(j * 0.017453292519943295);
        }
    }

    public float random() {
        if (this.cntrn == 0) {
            for (int i = 0; i < 3; ++i) {
                this.rand[i] = (int)(10.0 * Math.random());
                if (Math.random() > Math.random()) {
                    this.diup[i] = false;
                }
                else {
                    this.diup[i] = true;
                }
            }
            this.cntrn = 20;
        }
        else {
            --this.cntrn;
        }
        for (int j = 0; j < 3; ++j) {
            if (this.diup[j]) {
                final int[] rand = this.rand;
                final int n = j;
                ++rand[n];
                if (this.rand[j] == 10) {
                    this.rand[j] = 0;
                }
            }
            else {
                final int[] rand2 = this.rand;
                final int n2 = j;
                --rand2[n2];
                if (this.rand[j] == -1) {
                    this.rand[j] = 9;
                }
            }
        }
        ++this.trn;
        if (this.trn == 3) {
            this.trn = 0;
        }
        return this.rand[this.trn] / 10.0f;
    }

    public void watch(final ContO contO, final int n) {
        if (this.td) {
            this.y = (int)(contO.y - 300 - 1100.0f * this.random());
            this.x = contO.x + (int)((contO.x + 400 - contO.x) * this.cos(n) - (contO.z + 5000 - contO.z) * this.sin(n));
            this.z = contO.z + (int)((contO.x + 400 - contO.x) * this.sin(n) + (contO.z + 5000 - contO.z) * this.cos(n));
            this.td = false;
        }
        int n2 = 0;
        if (contO.x - this.x - this.cx > 0) {
            n2 = 180;
        }
        int i = -(int)(90 + n2 + Math.atan((contO.z - this.z) / (contO.x - this.x - this.cx)) / 0.017453292519943295);
        int n3 = 0;
        if (contO.y - this.y - this.cy < 0) {
            n3 = -180;
        }
        final int n4 = (int)(90 + n3 - Math.atan((int)Math.sqrt((contO.z - this.z) * (contO.z - this.z) + (contO.x - this.x - this.cx) * (contO.x - this.x - this.cx)) / (contO.y - this.y - this.cy)) / 0.017453292519943295);
        while (i < 0) {
            i += 360;
        }
        while (i > 360) {
            i -= 360;
        }
        this.xz = i;
        this.zy += (n4 - this.zy) / 5;
        if ((int)Math.sqrt((contO.z - this.z) * (contO.z - this.z) + (contO.x - this.x - this.cx) * (contO.x - this.x - this.cx) + (contO.y - this.y - this.cy) * (contO.y - this.y - this.cy)) > 6000) {
            this.td = true;
        }
    }

    public void aroundtrack(final CheckPoints checkPoints) {
        this.y = -this.hit;
        this.x = this.cx + (int)this.trx + (int)(17000.0f * this.cos(this.vxz));
        this.z = (int)this.trz + (int)(17000.0f * this.sin(this.vxz));
        if (this.hit > 5000) {
            if (this.hit == 45000) {
                this.fo = 1.0f;
                this.zy = 67;
                this.atrx = (checkPoints.x[0] - this.trx) / 116L;
                this.atrz = (checkPoints.z[0] - this.trz) / 116L;
                this.focus_point = 400;
            }
            if (this.hit == 20000) {
                this.fallen = 500;
                this.fo = 1.0f;
                this.zy = 67;
                this.atrx = (checkPoints.x[0] - this.trx) / 116L;
                this.atrz = (checkPoints.z[0] - this.trz) / 116L;
                this.focus_point = 400;
            }
            this.hit -= this.fallen;
            this.fallen += 7;
            this.trx += this.atrx;
            this.trz += this.atrz;
            if (this.hit < 17600) {
                this.zy -= 2;
            }
            if (this.fallen > 500) {
                this.fallen = 500;
            }
            if (this.hit <= 5000) {
                this.hit = 5000;
                this.fallen = 0;
            }
            this.vxz += 3;
        }
        else {
            this.focus_point = (int)(400.0f * this.fo);
            if (Math.abs(this.fo - this.gofo) > 0.005) {
                if (this.fo < this.gofo) {
                    this.fo += 0.005f;
                }
                else {
                    this.fo -= 0.005f;
                }
            }
            else {
                this.gofo = (float)(0.3499999940395355 + Math.random() * 1.3);
            }
            ++this.vxz;
            this.trx -= (this.trx - checkPoints.x[this.ptr]) / 10L;
            this.trz -= (this.trz - checkPoints.z[this.ptr]) / 10L;
            if (this.ptcnt == 7) {
                ++this.ptr;
                if (this.ptr == checkPoints.n) {
                    this.ptr = 0;
                    ++this.nrnd;
                }
                this.ptcnt = 0;
            }
            else {
                ++this.ptcnt;
            }
        }
        if (this.vxz > 360) {
            this.vxz -= 360;
        }
        this.xz = -this.vxz - 90;
        if (-this.y - this.cy < 0) {}
        final int n = (int)Math.sqrt((this.trz - this.z + this.cz) * (this.trz - this.z + this.cz) + (this.trx - this.x - this.cx) * (this.trx - this.x - this.cx));
        if (this.cpflik) {
            this.cpflik = false;
        }
        else {
            this.cpflik = true;
        }
    }

    public void around(final ContO contO, final boolean b) {
        if (!b) {
            if (!this.vert) {
                this.adv += 2;
            }
            else {
                this.adv -= 2;
            }
            if (this.adv > 900) {
                this.vert = true;
            }
            if (this.adv < -500) {
                this.vert = false;
            }
        }
        else {
            this.adv -= 14;
            if (this.adv < 617) {
                this.adv = 617;
            }
        }
        int n = 500 + this.adv;
        if (b && n < 1300) {
            n = 1300;
        }
        if (n < 1000) {
            n = 1000;
        }
        this.y = contO.y - this.adv;
        if (this.y > 10) {
            this.vert = false;
        }
        this.x = contO.x + (int)((contO.x - n - contO.x) * this.cos(this.vxz));
        this.z = contO.z + (int)((contO.x - n - contO.x) * this.sin(this.vxz));
        if (!b) {
            this.vxz += 2;
        }
        else {
            this.vxz += 4;
        }
        int n2 = 0;
        int y = this.y;
        if (y > 0) {
            y = 0;
        }
        if (contO.y - y - this.cy < 0) {
            n2 = -180;
        }
        int n3 = (int)(90 + n2 - Math.atan((int)Math.sqrt((contO.z - this.z + this.cz) * (contO.z - this.z + this.cz) + (contO.x - this.x - this.cx) * (contO.x - this.x - this.cx)) / (contO.y - y - this.cy)) / 0.017453292519943295);
        this.xz = -this.vxz + 90;
        if (b) {
            n3 -= 15;
        }
        this.zy += (n3 - this.zy) / 10;
    }

    public void getaround(final ContO contO) {
        if (!this.vert) {
            this.adv += 2;
        }
        else {
            this.adv -= 2;
        }
        if (this.adv > 1700) {
            this.vert = true;
        }
        if (this.adv < -500) {
            this.vert = false;
        }
        if (contO.y - this.adv > 10) {
            this.vert = false;
        }
        int n = 500 + this.adv;
        if (n < 1000) {
            n = 1000;
        }
        final int y = contO.y - this.adv;
        final int x = contO.x + (int)((contO.x - n - contO.x) * this.cos(this.vxz));
        final int z = contO.z + (int)((contO.x - n - contO.x) * this.sin(this.vxz));
        int n2 = 0;
        if (Math.abs(y - this.y) > this.fvect) {
            if (this.y < y) {
                this.y += this.fvect;
            }
            else {
                this.y -= this.fvect;
            }
        }
        else {
            this.y = y;
            ++n2;
        }
        if (Math.abs(x - this.x) > this.fvect) {
            if (this.x < x) {
                this.x += this.fvect;
            }
            else {
                this.x -= this.fvect;
            }
        }
        else {
            this.x = x;
            ++n2;
        }
        if (Math.abs(z - this.z) > this.fvect) {
            if (this.z < z) {
                this.z += this.fvect;
            }
            else {
                this.z -= this.fvect;
            }
        }
        else {
            this.z = z;
            ++n2;
        }
        if (n2 == 3) {
            this.fvect = 200;
        }
        else {
            this.fvect += 2;
        }
        this.vxz += 2;
        while (this.vxz > 360) {
            this.vxz -= 360;
        }
        int i = -this.vxz + 90;
        int n3 = 0;
        if (contO.x - this.x - this.cx > 0) {
            n3 = 180;
        }
        int j = -(int)(90 + n3 + Math.atan((contO.z - this.z) / (contO.x - this.x - this.cx)) / 0.017453292519943295);
        int y2 = this.y;
        int n4 = 0;
        if (y2 > 0) {
            y2 = 0;
        }
        if (contO.y - y2 - this.cy < 0) {
            n4 = -180;
        }
        final int n5 = (int)Math.sqrt((contO.z - this.z + this.cz) * (contO.z - this.z + this.cz) + (contO.x - this.x - this.cx) * (contO.x - this.x - this.cx));
        int n6 = 25;
        if (n5 != 0) {
            n6 = (int)(90 + n4 - Math.atan(n5 / (contO.y - y2 - this.cy)) / 0.017453292519943295);
        }
        while (i < 0) {
            i += 360;
        }
        while (i > 360) {
            i -= 360;
        }
        while (j < 0) {
            j += 360;
        }
        while (j > 360) {
            j -= 360;
        }
        if ((Math.abs(i - j) < 30 || Math.abs(i - j) > 330) && n2 == 3) {
            if (Math.abs(i - this.xz) > 7 && Math.abs(i - this.xz) < 353) {
                if (Math.abs(i - this.xz) > 180) {
                    if (this.xz > i) {
                        this.xz += 7;
                    }
                    else {
                        this.xz -= 7;
                    }
                }
                else if (this.xz < i) {
                    this.xz += 7;
                }
                else {
                    this.xz -= 7;
                }
            }
            else {
                this.xz = i;
            }
        }
        else if (Math.abs(j - this.xz) > 6 && Math.abs(j - this.xz) < 354) {
            if (Math.abs(j - this.xz) > 180) {
                if (this.xz > j) {
                    this.xz += 3;
                }
                else {
                    this.xz -= 3;
                }
            }
            else if (this.xz < j) {
                this.xz += 3;
            }
            else {
                this.xz -= 3;
            }
        }
        else {
            this.xz = j;
        }
        this.zy += (n6 - this.zy) / 10;
    }

    public void transaround(final ContO contO, final ContO contO2, final int n) {
        final int n2 = (contO.x * (20 - n) + contO2.x * n) / 20;
        final int n3 = (contO.y * (20 - n) + contO2.y * n) / 20;
        final int n4 = (contO.z * (20 - n) + contO2.z * n) / 20;
        if (!this.vert) {
            this.adv += 2;
        }
        else {
            this.adv -= 2;
        }
        if (this.adv > 900) {
            this.vert = true;
        }
        if (this.adv < -500) {
            this.vert = false;
        }
        int n5 = 500 + this.adv;
        if (n5 < 1000) {
            n5 = 1000;
        }
        this.y = n3 - this.adv;
        if (this.y > 10) {
            this.vert = false;
        }
        this.x = n2 + (int)((n2 - n5 - n2) * this.cos(this.vxz));
        this.z = n4 + (int)((n2 - n5 - n2) * this.sin(this.vxz));
        this.vxz += 2;
        int n6 = 0;
        int y = this.y;
        if (y > 0) {
            y = 0;
        }
        if (n3 - y - this.cy < 0) {
            n6 = -180;
        }
        final int n7 = (int)(90 + n6 - Math.atan((int)Math.sqrt((n4 - this.z + this.cz) * (n4 - this.z + this.cz) + (n2 - this.x - this.cx) * (n2 - this.x - this.cx)) / (n3 - y - this.cy)) / 0.017453292519943295);
        this.xz = -this.vxz + 90;
        this.zy += (n7 - this.zy) / 10;
    }

    public void follow(final ContO contO, int n, final int n2) {
        this.zy = 10;
        int n3 = 2 + Math.abs(this.bcxz) / 4;
        if (n3 > 20) {
            n3 = 20;
        }
        if (n2 != 0) {
            if (n2 == 1) {
                if (this.bcxz < 180) {
                    this.bcxz += n3;
                }
                if (this.bcxz > 180) {
                    this.bcxz = 180;
                }
            }
            if (n2 == -1) {
                if (this.bcxz > -180) {
                    this.bcxz -= n3;
                }
                if (this.bcxz < -180) {
                    this.bcxz = -180;
                }
            }
        }
        else if (Math.abs(this.bcxz) > n3) {
            if (this.bcxz > 0) {
                this.bcxz -= n3;
            }
            else {
                this.bcxz += n3;
            }
        }
        else if (this.bcxz != 0) {
            this.bcxz = 0;
        }
        n += this.bcxz;
        this.xz = -n;
        this.x = contO.x - this.cx + (int)(-(contO.z - 800 - contO.z) * this.sin(n));
        this.z = contO.z - this.cz + (int)((contO.z - 800 - contO.z) * this.cos(n));
        this.y = contO.y - 250 - this.cy;
    }

    public void getfollow(final ContO contO, int n, final int n2) {
        this.zy = 10;
        int n3 = 2 + Math.abs(this.bcxz) / 4;
        if (n3 > 20) {
            n3 = 20;
        }
        if (n2 != 0) {
            if (n2 == 1) {
                if (this.bcxz < 180) {
                    this.bcxz += n3;
                }
                if (this.bcxz > 180) {
                    this.bcxz = 180;
                }
            }
            if (n2 == -1) {
                if (this.bcxz > -180) {
                    this.bcxz -= n3;
                }
                if (this.bcxz < -180) {
                    this.bcxz = -180;
                }
            }
        }
        else if (Math.abs(this.bcxz) > n3) {
            if (this.bcxz > 0) {
                this.bcxz -= n3;
            }
            else {
                this.bcxz += n3;
            }
        }
        else if (this.bcxz != 0) {
            this.bcxz = 0;
        }
        n += this.bcxz;
        this.xz = -n;
        final int x = contO.x - this.cx + (int)(-(contO.z - 800 - contO.z) * this.sin(n));
        final int z = contO.z - this.cz + (int)((contO.z - 800 - contO.z) * this.cos(n));
        final int y = contO.y - 250 - this.cy;
        int n4 = 0;
        if (Math.abs(y - this.y) > this.fvect) {
            if (this.y < y) {
                this.y += this.fvect;
            }
            else {
                this.y -= this.fvect;
            }
        }
        else {
            this.y = y;
            ++n4;
        }
        if (Math.abs(x - this.x) > this.fvect) {
            if (this.x < x) {
                this.x += this.fvect;
            }
            else {
                this.x -= this.fvect;
            }
        }
        else {
            this.x = x;
            ++n4;
        }
        if (Math.abs(z - this.z) > this.fvect) {
            if (this.z < z) {
                this.z += this.fvect;
            }
            else {
                this.z -= this.fvect;
            }
        }
        else {
            this.z = z;
            ++n4;
        }
        if (n4 == 3) {
            this.fvect = 200;
        }
        else {
            this.fvect += 2;
        }
    }

    public void newpolys(final int n, final int n2, final int n3, final int n4, final Trackers trackers, final int n5) {
        final Random random = new Random((n5 + this.cgrnd[0] + this.cgrnd[1] + this.cgrnd[2]) * 1671);
        this.nrw = n2 / 1200 + 9;
        this.ncl = n4 / 1200 + 9;
        this.sgpx = n - 4800;
        this.sgpz = n3 - 4800;
        this.ogpx = null;
        this.ogpz = null;
        this.pvr = null;
        this.cgpx = null;
        this.cgpz = null;
        this.pmx = null;
        this.pcv = null;
        this.ogpx = new int[this.nrw * this.ncl][8];
        this.ogpz = new int[this.nrw * this.ncl][8];
        this.pvr = new float[this.nrw * this.ncl][8];
        this.cgpx = new int[this.nrw * this.ncl];
        this.cgpz = new int[this.nrw * this.ncl];
        this.pmx = new int[this.nrw * this.ncl];
        this.pcv = new float[this.nrw * this.ncl];
        int n6 = 0;
        int n7 = 0;
        for (int i = 0; i < this.nrw * this.ncl; ++i) {
            this.cgpx[i] = this.sgpx + n6 * 1200 + (int)(random.nextDouble() * 1000.0 - 500.0);
            this.cgpz[i] = this.sgpz + n7 * 1200 + (int)(random.nextDouble() * 1000.0 - 500.0);
            if (trackers != null) {
                for (int j = 0; j < trackers.nt; ++j) {
                    if (trackers.zy[j] == 0 && trackers.xy[j] == 0) {
                        if (trackers.radx[j] < trackers.radz[j] && Math.abs(this.cgpz[i] - trackers.z[j]) < trackers.radz[j]) {
                            while (Math.abs(this.cgpx[i] - trackers.x[j]) < trackers.radx[j]) {
                                final int[] cgpx = this.cgpx;
                                final int n8 = i;
                                cgpx[n8] += (int)(random.nextDouble() * trackers.radx[j] * 2.0 - trackers.radx[j]);
                            }
                        }
                        if (trackers.radz[j] < trackers.radx[j] && Math.abs(this.cgpx[i] - trackers.x[j]) < trackers.radx[j]) {
                            while (Math.abs(this.cgpz[i] - trackers.z[j]) < trackers.radz[j]) {
                                final int[] cgpz = this.cgpz;
                                final int n9 = i;
                                cgpz[n9] += (int)(random.nextDouble() * trackers.radz[j] * 2.0 - trackers.radz[j]);
                            }
                        }
                    }
                }
            }
            if (++n6 == this.nrw) {
                n6 = 0;
                ++n7;
            }
        }
        for (int k = 0; k < this.nrw * this.ncl; ++k) {
            final float n10 = (float)(0.3 + 1.6 * random.nextDouble());
            this.ogpx[k][0] = 0;
            this.ogpz[k][0] = (int)((100.0 + random.nextDouble() * 760.0) * n10);
            this.ogpx[k][1] = (int)((100.0 + random.nextDouble() * 760.0) * 0.7071 * n10);
            this.ogpz[k][1] = this.ogpx[k][1];
            this.ogpx[k][2] = (int)((100.0 + random.nextDouble() * 760.0) * n10);
            this.ogpz[k][2] = 0;
            this.ogpx[k][3] = (int)((100.0 + random.nextDouble() * 760.0) * 0.7071 * n10);
            this.ogpz[k][3] = -this.ogpx[k][3];
            this.ogpx[k][4] = 0;
            this.ogpz[k][4] = -(int)((100.0 + random.nextDouble() * 760.0) * n10);
            this.ogpx[k][5] = -(int)((100.0 + random.nextDouble() * 760.0) * 0.7071 * n10);
            this.ogpz[k][5] = this.ogpx[k][5];
            this.ogpx[k][6] = -(int)((100.0 + random.nextDouble() * 760.0) * n10);
            this.ogpz[k][6] = 0;
            this.ogpx[k][7] = -(int)((100.0 + random.nextDouble() * 760.0) * 0.7071 * n10);
            this.ogpz[k][7] = -this.ogpx[k][7];
            for (int l = 0; l < 8; ++l) {
                int n11 = l - 1;
                if (n11 == -1) {
                    n11 = 7;
                }
                int n12 = l + 1;
                if (n12 == 8) {
                    n12 = 0;
                }
                this.ogpx[k][l] = ((this.ogpx[k][n11] + this.ogpx[k][n12]) / 2 + this.ogpx[k][l]) / 2;
                this.ogpz[k][l] = ((this.ogpz[k][n11] + this.ogpz[k][n12]) / 2 + this.ogpz[k][l]) / 2;
                this.pvr[k][l] = (float)(1.1 + random.nextDouble() * 0.8);
                final int n13 = (int)Math.sqrt((int)(this.ogpx[k][l] * this.ogpx[k][l] * this.pvr[k][l] * this.pvr[k][l] + this.ogpz[k][l] * this.ogpz[k][l] * this.pvr[k][l] * this.pvr[k][l]));
                if (n13 > this.pmx[k]) {
                    this.pmx[k] = n13;
                }
            }
            this.pcv[k] = (float)(0.97 + random.nextDouble() * 0.03);
            if (this.pcv[k] > 1.0f) {
                this.pcv[k] = 1.0f;
            }
            if (random.nextDouble() > random.nextDouble()) {
                this.pcv[k] = 1.0f;
            }
        }
    }

    public void groundpolys(final Graphics2D graphics2D) {
        int n = (this.x - this.sgpx) / 1200 - 12;
        if (n < 0) {
            n = 0;
        }
        int nrw = n + 25;
        if (nrw > this.nrw) {
            nrw = this.nrw;
        }
        if (nrw < n) {
            nrw = n;
        }
        int n2 = (this.z - this.sgpz) / 1200 - 12;
        if (n2 < 0) {
            n2 = 0;
        }
        int ncl = n2 + 25;
        if (ncl > this.ncl) {
            ncl = this.ncl;
        }
        if (ncl < n2) {
            ncl = n2;
        }
        final int[][] array = new int[nrw - n][ncl - n2];
        for (int i = n; i < nrw; ++i) {
            for (int j = n2; j < ncl; ++j) {
                array[i - n][j - n2] = 0;
                final int n3 = i + j * this.nrw;
                if (this.resdown < 2 || n3 % 2 == 0) {
                    final int n4 = this.cx + (int)((this.cgpx[n3] - this.x - this.cx) * this.cos(this.xz) - (this.cgpz[n3] - this.z - this.cz) * this.sin(this.xz));
                    final int n5 = this.cz + (int)((250 - this.y - this.cy) * this.sin(this.zy) + (this.cz + (int)((this.cgpx[n3] - this.x - this.cx) * this.sin(this.xz) + (this.cgpz[n3] - this.z - this.cz) * this.cos(this.xz)) - this.cz) * this.cos(this.zy));
                    if (this.xs(n4 + this.pmx[n3], n5) > 0 && this.xs(n4 - this.pmx[n3], n5) < this.w && n5 > -this.pmx[n3] && n5 < this.fade[2]) {
                        array[i - n][j - n2] = n5;
                        final int[] array2 = new int[8];
                        final int[] array3 = new int[8];
                        final int[] array4 = new int[8];
                        for (int k = 0; k < 8; ++k) {
                            array2[k] = (int)(this.ogpx[n3][k] * this.pvr[n3][k] + this.cgpx[n3] - this.x);
                            array3[k] = (int)(this.ogpz[n3][k] * this.pvr[n3][k] + this.cgpz[n3] - this.z);
                            array4[k] = this.ground;
                        }
                        this.rot(array2, array3, this.cx, this.cz, this.xz, 8);
                        this.rot(array4, array3, this.cy, this.cz, this.zy, 8);
                        final int[] array5 = new int[8];
                        final int[] array6 = new int[8];
                        int n6 = 0;
                        int n7 = 0;
                        int n8 = 0;
                        int n9 = 0;
                        boolean b = true;
                        for (int l = 0; l < 8; ++l) {
                            array5[l] = this.xs(array2[l], array3[l]);
                            array6[l] = this.ys(array4[l], array3[l]);
                            if (array6[l] < 0 || array3[l] < 10) {
                                ++n6;
                            }
                            if (array6[l] > this.h || array3[l] < 10) {
                                ++n7;
                            }
                            if (array5[l] < 0 || array3[l] < 10) {
                                ++n8;
                            }
                            if (array5[l] > this.w || array3[l] < 10) {
                                ++n9;
                            }
                        }
                        if (n8 == 8 || n6 == 8 || n7 == 8 || n9 == 8) {
                            b = false;
                        }
                        if (b) {
                            int n10 = (int)((this.cpol[0] * this.pcv[n3] + this.cgrnd[0]) / 2.0f);
                            int n11 = (int)((this.cpol[1] * this.pcv[n3] + this.cgrnd[1]) / 2.0f);
                            int n12 = (int)((this.cpol[2] * this.pcv[n3] + this.cgrnd[2]) / 2.0f);
                            if (n5 - this.pmx[n3] > this.fade[0]) {
                                n10 = (n10 * 7 + this.cfade[0]) / 8;
                                n11 = (n11 * 7 + this.cfade[1]) / 8;
                                n12 = (n12 * 7 + this.cfade[2]) / 8;
                            }
                            if (n5 - this.pmx[n3] > this.fade[1]) {
                                n10 = (n10 * 7 + this.cfade[0]) / 8;
                                n11 = (n11 * 7 + this.cfade[1]) / 8;
                                n12 = (n12 * 7 + this.cfade[2]) / 8;
                            }
                            graphics2D.setColor(new Color(n10, n11, n12));
                            graphics2D.fillPolygon(array5, array6, 8);
                        }
                    }
                }
            }
        }
        for (int n13 = n; n13 < nrw; ++n13) {
            for (int n14 = n2; n14 < ncl; ++n14) {
                if (array[n13 - n][n14 - n2] != 0) {
                    final int n15 = n13 + n14 * this.nrw;
                    final int[] array7 = new int[8];
                    final int[] array8 = new int[8];
                    final int[] array9 = new int[8];
                    for (int n16 = 0; n16 < 8; ++n16) {
                        array7[n16] = this.ogpx[n15][n16] + this.cgpx[n15] - this.x;
                        array8[n16] = this.ogpz[n15][n16] + this.cgpz[n15] - this.z;
                        array9[n16] = this.ground;
                    }
                    this.rot(array7, array8, this.cx, this.cz, this.xz, 8);
                    this.rot(array9, array8, this.cy, this.cz, this.zy, 8);
                    final int[] array10 = new int[8];
                    final int[] array11 = new int[8];
                    int n17 = 0;
                    int n18 = 0;
                    int n19 = 0;
                    int n20 = 0;
                    boolean b2 = true;
                    for (int n21 = 0; n21 < 8; ++n21) {
                        array10[n21] = this.xs(array7[n21], array8[n21]);
                        array11[n21] = this.ys(array9[n21], array8[n21]);
                        if (array11[n21] < 0 || array8[n21] < 10) {
                            ++n17;
                        }
                        if (array11[n21] > this.h || array8[n21] < 10) {
                            ++n18;
                        }
                        if (array10[n21] < 0 || array8[n21] < 10) {
                            ++n19;
                        }
                        if (array10[n21] > this.w || array8[n21] < 10) {
                            ++n20;
                        }
                    }
                    if (n19 == 8 || n17 == 8 || n18 == 8 || n20 == 8) {
                        b2 = false;
                    }
                    if (b2) {
                        int n22 = (int)(this.cpol[0] * this.pcv[n15]);
                        int n23 = (int)(this.cpol[1] * this.pcv[n15]);
                        int n24 = (int)(this.cpol[2] * this.pcv[n15]);
                        if (array[n13 - n][n14 - n2] - this.pmx[n15] > this.fade[0]) {
                            n22 = (n22 * 7 + this.cfade[0]) / 8;
                            n23 = (n23 * 7 + this.cfade[1]) / 8;
                            n24 = (n24 * 7 + this.cfade[2]) / 8;
                        }
                        if (array[n13 - n][n14 - n2] - this.pmx[n15] > this.fade[1]) {
                            n22 = (n22 * 7 + this.cfade[0]) / 8;
                            n23 = (n23 * 7 + this.cfade[1]) / 8;
                            n24 = (n24 * 7 + this.cfade[2]) / 8;
                        }
                        graphics2D.setColor(new Color(n22, n23, n24));
                        graphics2D.fillPolygon(array10, array11, 8);
                    }
                }
            }
        }
    }

    public void newclouds(int n, int n2, int n3, int n4) {
        this.clx = null;
        this.clz = null;
        this.cmx = null;
        this.clax = null;
        this.clay = null;
        this.claz = null;
        this.clc = null;
        n = n / 20 - 10000;
        n2 = n2 / 20 + 10000;
        n3 = n3 / 20 - 10000;
        n4 = n4 / 20 + 10000;
        this.noc = (n2 - n) * (n4 - n3) / 16666667;
        this.clx = new int[this.noc];
        this.clz = new int[this.noc];
        this.cmx = new int[this.noc];
        this.clax = new int[this.noc][3][12];
        this.clay = new int[this.noc][3][12];
        this.claz = new int[this.noc][3][12];
        this.clc = new int[this.noc][2][6][3];
        for (int i = 0; i < this.noc; ++i) {
            this.clx[i] = (int)(n + (n2 - n) * Math.random());
            this.clz[i] = (int)(n3 + (n4 - n3) * Math.random());
            final float n5 = (float)(0.25 + Math.random() * 1.25);
            final float n6 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][0] = (int)(n6 * 0.3826);
            this.claz[i][0][0] = (int)(n6 * 0.9238);
            this.clay[i][0][0] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n7 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][1] = (int)(n7 * 0.7071);
            this.claz[i][0][1] = (int)(n7 * 0.7071);
            this.clay[i][0][1] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n8 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][2] = (int)(n8 * 0.9238);
            this.claz[i][0][2] = (int)(n8 * 0.3826);
            this.clay[i][0][2] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n9 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][3] = (int)(n9 * 0.9238);
            this.claz[i][0][3] = -(int)(n9 * 0.3826);
            this.clay[i][0][3] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n10 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][4] = (int)(n10 * 0.7071);
            this.claz[i][0][4] = -(int)(n10 * 0.7071);
            this.clay[i][0][4] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n11 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][5] = (int)(n11 * 0.3826);
            this.claz[i][0][5] = -(int)(n11 * 0.9238);
            this.clay[i][0][5] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n12 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][6] = -(int)(n12 * 0.3826);
            this.claz[i][0][6] = -(int)(n12 * 0.9238);
            this.clay[i][0][6] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n13 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][7] = -(int)(n13 * 0.7071);
            this.claz[i][0][7] = -(int)(n13 * 0.7071);
            this.clay[i][0][7] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n14 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][8] = -(int)(n14 * 0.9238);
            this.claz[i][0][8] = -(int)(n14 * 0.3826);
            this.clay[i][0][8] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n15 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][9] = -(int)(n15 * 0.9238);
            this.claz[i][0][9] = (int)(n15 * 0.3826);
            this.clay[i][0][9] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n16 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][10] = -(int)(n16 * 0.7071);
            this.claz[i][0][10] = (int)(n16 * 0.7071);
            this.clay[i][0][10] = (int)((25.0 - Math.random() * 50.0) * n5);
            final float n17 = (float)((200.0 + Math.random() * 700.0) * n5);
            this.clax[i][0][11] = -(int)(n17 * 0.3826);
            this.claz[i][0][11] = (int)(n17 * 0.9238);
            this.clay[i][0][11] = (int)((25.0 - Math.random() * 50.0) * n5);
            for (int j = 0; j < 12; ++j) {
                int n18 = j - 1;
                if (n18 == -1) {
                    n18 = 11;
                }
                int n19 = j + 1;
                if (n19 == 12) {
                    n19 = 0;
                }
                this.clax[i][0][j] = ((this.clax[i][0][n18] + this.clax[i][0][n19]) / 2 + this.clax[i][0][j]) / 2;
                this.clay[i][0][j] = ((this.clay[i][0][n18] + this.clay[i][0][n19]) / 2 + this.clay[i][0][j]) / 2;
                this.claz[i][0][j] = ((this.claz[i][0][n18] + this.claz[i][0][n19]) / 2 + this.claz[i][0][j]) / 2;
            }
            for (int k = 0; k < 12; ++k) {
                final float n20 = (float)(1.2 + 0.6 * Math.random());
                this.clax[i][1][k] = (int)(this.clax[i][0][k] * n20);
                this.claz[i][1][k] = (int)(this.claz[i][0][k] * n20);
                this.clay[i][1][k] = (int)(this.clay[i][0][k] - 100.0 * Math.random());
                final float n21 = (float)(1.1 + 0.3 * Math.random());
                this.clax[i][2][k] = (int)(this.clax[i][1][k] * n21);
                this.claz[i][2][k] = (int)(this.claz[i][1][k] * n21);
                this.clay[i][2][k] = (int)(this.clay[i][1][k] - 240.0 * Math.random());
            }
            this.cmx[i] = 0;
            for (int l = 0; l < 12; ++l) {
                int n22 = l - 1;
                if (n22 == -1) {
                    n22 = 11;
                }
                int n23 = l + 1;
                if (n23 == 12) {
                    n23 = 0;
                }
                this.clay[i][1][l] = ((this.clay[i][1][n22] + this.clay[i][1][n23]) / 2 + this.clay[i][1][l]) / 2;
                this.clay[i][2][l] = ((this.clay[i][2][n22] + this.clay[i][2][n23]) / 2 + this.clay[i][2][l]) / 2;
                final int n24 = (int)Math.sqrt(this.clax[i][2][l] * this.clax[i][2][l] + this.claz[i][2][l] * this.claz[i][2][l]);
                if (n24 > this.cmx[i]) {
                    this.cmx[i] = n24;
                }
            }
            for (int n25 = 0; n25 < 6; ++n25) {
                final double random = Math.random();
                final double random2 = Math.random();
                for (int n26 = 0; n26 < 3; ++n26) {
                    final float n27 = this.clds[n26] * 1.05f - this.clds[n26];
                    this.clc[i][0][n25][n26] = (int)(this.clds[n26] + n27 * random);
                    if (this.clc[i][0][n25][n26] > 255) {
                        this.clc[i][0][n25][n26] = 255;
                    }
                    if (this.clc[i][0][n25][n26] < 0) {
                        this.clc[i][0][n25][n26] = 0;
                    }
                    this.clc[i][1][n25][n26] = (int)(this.clds[n26] * 1.05f + n27 * random2);
                    if (this.clc[i][1][n25][n26] > 255) {
                        this.clc[i][1][n25][n26] = 255;
                    }
                    if (this.clc[i][1][n25][n26] < 0) {
                        this.clc[i][1][n25][n26] = 0;
                    }
                }
            }
        }
    }

    public void drawclouds(final Graphics2D graphics2D) {
        for (int i = 0; i < this.noc; ++i) {
            final int n = this.cx + (int)((this.clx[i] - this.x / 20 - this.cx) * this.cos(this.xz) - (this.clz[i] - this.z / 20 - this.cz) * this.sin(this.xz));
            final int n2 = this.cz + (int)((this.cldd[4] - this.y / 20 - this.cy) * this.sin(this.zy) + (this.cz + (int)((this.clx[i] - this.x / 20 - this.cx) * this.sin(this.xz) + (this.clz[i] - this.z / 20 - this.cz) * this.cos(this.xz)) - this.cz) * this.cos(this.zy));
            final int xs = this.xs(n + this.cmx[i], n2);
            final int xs2 = this.xs(n - this.cmx[i], n2);
            if (xs > 0 && xs2 < this.w && n2 > -this.cmx[i] && xs - xs2 > 20) {
                final int[][] array = new int[3][12];
                final int[][] array2 = new int[3][12];
                final int[][] array3 = new int[3][12];
                final int[] array4 = new int[12];
                final int[] array5 = new int[12];
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 12; ++k) {
                        array[j][k] = this.clax[i][j][k] + this.clx[i] - this.x / 20;
                        array3[j][k] = this.claz[i][j][k] + this.clz[i] - this.z / 20;
                        array2[j][k] = this.clay[i][j][k] + this.cldd[4] - this.y / 20;
                    }
                    this.rot(array[j], array3[j], this.cx, this.cz, this.xz, 12);
                    this.rot(array2[j], array3[j], this.cy, this.cz, this.zy, 12);
                }
                for (int l = 0; l < 12; l += 2) {
                    int n3 = 0;
                    int n4 = 0;
                    int n5 = 0;
                    int n6 = 0;
                    boolean b = true;
                    int n7 = 0;
                    int n8 = 0;
                    int n9 = 0;
                    for (int n10 = 0; n10 < 6; ++n10) {
                        int n11 = 0;
                        int n12 = 1;
                        if (n10 == 0) {
                            n11 = l;
                        }
                        if (n10 == 1) {
                            n11 = l + 1;
                            if (n11 >= 12) {
                                n11 -= 12;
                            }
                        }
                        if (n10 == 2) {
                            n11 = l + 2;
                            if (n11 >= 12) {
                                n11 -= 12;
                            }
                        }
                        if (n10 == 3) {
                            n11 = l + 2;
                            if (n11 >= 12) {
                                n11 -= 12;
                            }
                            n12 = 2;
                        }
                        if (n10 == 4) {
                            n11 = l + 1;
                            if (n11 >= 12) {
                                n11 -= 12;
                            }
                            n12 = 2;
                        }
                        if (n10 == 5) {
                            n11 = l;
                            n12 = 2;
                        }
                        array4[n10] = this.xs(array[n12][n11], array3[n12][n11]);
                        array5[n10] = this.ys(array2[n12][n11], array3[n12][n11]);
                        n8 += array[n12][n11];
                        n7 += array2[n12][n11];
                        n9 += array3[n12][n11];
                        if (array5[n10] < 0 || array3[0][n10] < 10) {
                            ++n3;
                        }
                        if (array5[n10] > this.h || array3[0][n10] < 10) {
                            ++n4;
                        }
                        if (array4[n10] < 0 || array3[0][n10] < 10) {
                            ++n5;
                        }
                        if (array4[n10] > this.w || array3[0][n10] < 10) {
                            ++n6;
                        }
                    }
                    if (n5 == 6 || n3 == 6 || n4 == 6 || n6 == 6) {
                        b = false;
                    }
                    if (b) {
                        final int n13 = n8 / 6;
                        final int n14 = n7 / 6;
                        final int n15 = n9 / 6;
                        final int n16 = (int)Math.sqrt((this.cy - n14) * (this.cy - n14) + (this.cx - n13) * (this.cx - n13) + n15 * n15);
                        if (n16 < this.fade[7]) {
                            int n17 = this.clc[i][1][l / 2][0];
                            int n18 = this.clc[i][1][l / 2][1];
                            int n19 = this.clc[i][1][l / 2][2];
                            for (int n20 = 0; n20 < 16; ++n20) {
                                if (n16 > this.fade[n20]) {
                                    n17 = (n17 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                    n18 = (n18 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                    n19 = (n19 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                                }
                            }
                            graphics2D.setColor(new Color(n17, n18, n19));
                            graphics2D.fillPolygon(array4, array5, 6);
                        }
                    }
                }
                for (int n21 = 0; n21 < 12; n21 += 2) {
                    int n22 = 0;
                    int n23 = 0;
                    int n24 = 0;
                    int n25 = 0;
                    boolean b2 = true;
                    int n26 = 0;
                    int n27 = 0;
                    int n28 = 0;
                    for (int n29 = 0; n29 < 6; ++n29) {
                        int n30 = 0;
                        int n31 = 0;
                        if (n29 == 0) {
                            n30 = n21;
                        }
                        if (n29 == 1) {
                            n30 = n21 + 1;
                            if (n30 >= 12) {
                                n30 -= 12;
                            }
                        }
                        if (n29 == 2) {
                            n30 = n21 + 2;
                            if (n30 >= 12) {
                                n30 -= 12;
                            }
                        }
                        if (n29 == 3) {
                            n30 = n21 + 2;
                            if (n30 >= 12) {
                                n30 -= 12;
                            }
                            n31 = 1;
                        }
                        if (n29 == 4) {
                            n30 = n21 + 1;
                            if (n30 >= 12) {
                                n30 -= 12;
                            }
                            n31 = 1;
                        }
                        if (n29 == 5) {
                            n30 = n21;
                            n31 = 1;
                        }
                        array4[n29] = this.xs(array[n31][n30], array3[n31][n30]);
                        array5[n29] = this.ys(array2[n31][n30], array3[n31][n30]);
                        n27 += array[n31][n30];
                        n26 += array2[n31][n30];
                        n28 += array3[n31][n30];
                        if (array5[n29] < 0 || array3[0][n29] < 10) {
                            ++n22;
                        }
                        if (array5[n29] > this.h || array3[0][n29] < 10) {
                            ++n23;
                        }
                        if (array4[n29] < 0 || array3[0][n29] < 10) {
                            ++n24;
                        }
                        if (array4[n29] > this.w || array3[0][n29] < 10) {
                            ++n25;
                        }
                    }
                    if (n24 == 6 || n22 == 6 || n23 == 6 || n25 == 6) {
                        b2 = false;
                    }
                    if (b2) {
                        final int n32 = n27 / 6;
                        final int n33 = n26 / 6;
                        final int n34 = n28 / 6;
                        final int n35 = (int)Math.sqrt((this.cy - n33) * (this.cy - n33) + (this.cx - n32) * (this.cx - n32) + n34 * n34);
                        if (n35 < this.fade[7]) {
                            int n36 = this.clc[i][0][n21 / 2][0];
                            int n37 = this.clc[i][0][n21 / 2][1];
                            int n38 = this.clc[i][0][n21 / 2][2];
                            for (int n39 = 0; n39 < 16; ++n39) {
                                if (n35 > this.fade[n39]) {
                                    n36 = (n36 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                    n37 = (n37 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                    n38 = (n38 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                                }
                            }
                            graphics2D.setColor(new Color(n36, n37, n38));
                            graphics2D.fillPolygon(array4, array5, 6);
                        }
                    }
                }
                int n40 = 0;
                int n41 = 0;
                int n42 = 0;
                int n43 = 0;
                boolean b3 = true;
                int n44 = 0;
                int n45 = 0;
                int n46 = 0;
                for (int n47 = 0; n47 < 12; ++n47) {
                    array4[n47] = this.xs(array[0][n47], array3[0][n47]);
                    array5[n47] = this.ys(array2[0][n47], array3[0][n47]);
                    n45 += array[0][n47];
                    n44 += array2[0][n47];
                    n46 += array3[0][n47];
                    if (array5[n47] < 0 || array3[0][n47] < 10) {
                        ++n40;
                    }
                    if (array5[n47] > this.h || array3[0][n47] < 10) {
                        ++n41;
                    }
                    if (array4[n47] < 0 || array3[0][n47] < 10) {
                        ++n42;
                    }
                    if (array4[n47] > this.w || array3[0][n47] < 10) {
                        ++n43;
                    }
                }
                if (n42 == 12 || n40 == 12 || n41 == 12 || n43 == 12) {
                    b3 = false;
                }
                if (b3) {
                    final int n48 = n45 / 12;
                    final int n49 = n44 / 12;
                    final int n50 = n46 / 12;
                    final int n51 = (int)Math.sqrt((this.cy - n49) * (this.cy - n49) + (this.cx - n48) * (this.cx - n48) + n50 * n50);
                    if (n51 < this.fade[7]) {
                        int n52 = this.clds[0];
                        int n53 = this.clds[1];
                        int n54 = this.clds[2];
                        for (int n55 = 0; n55 < 16; ++n55) {
                            if (n51 > this.fade[n55]) {
                                n52 = (n52 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                n53 = (n53 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                n54 = (n54 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                            }
                        }
                        graphics2D.setColor(new Color(n52, n53, n54));
                        graphics2D.fillPolygon(array4, array5, 12);
                    }
                }
            }
        }
    }

    public void newmountains(final int n, final int n2, final int n3, final int n4) {
        final Random random = new Random(this.mgen);
        this.nmt = (int)(20.0 + 10.0 * random.nextDouble());
        final int n5 = (n + n2) / 60;
        final int n6 = (n3 + n4) / 60;
        final int n7 = Math.max(n2 - n, n4 - n3) / 60;
        this.mrd = null;
        this.nmv = null;
        this.mtx = null;
        this.mty = null;
        this.mtz = null;
        this.mtc = null;
        this.mrd = new int[this.nmt];
        this.nmv = new int[this.nmt];
        this.mtx = new int[this.nmt][];
        this.mty = new int[this.nmt][];
        this.mtz = new int[this.nmt][];
        this.mtc = new int[this.nmt][][];
        final int[] array = new int[this.nmt];
        final int[] array2 = new int[this.nmt];
        for (int i = 0; i < this.nmt; ++i) {
            array[i] = (int)(10000.0 + random.nextDouble() * 10000.0);
            final int n8 = (int)(random.nextDouble() * 360.0);
            float n9;
            float n10;
            int n11;
            if (random.nextDouble() > random.nextDouble()) {
                n9 = (float)(0.2 + random.nextDouble() * 0.35);
                n10 = (float)(0.2 + random.nextDouble() * 0.35);
                this.nmv[i] = (int)(n9 * (24.0 + 16.0 * random.nextDouble()));
                n11 = (int)(85.0 + 10.0 * random.nextDouble());
            }
            else {
                n9 = (float)(0.3 + random.nextDouble() * 1.1);
                n10 = (float)(0.2 + random.nextDouble() * 0.35);
                this.nmv[i] = (int)(n9 * (12.0 + 8.0 * random.nextDouble()));
                n11 = (int)(104.0 - 10.0 * random.nextDouble());
            }
            this.mtx[i] = new int[this.nmv[i] * 2];
            this.mty[i] = new int[this.nmv[i] * 2];
            this.mtz[i] = new int[this.nmv[i] * 2];
            this.mtc[i] = new int[this.nmv[i]][3];
            for (int j = 0; j < this.nmv[i]; ++j) {
                this.mtx[i][j] = (int)((j * 500 + (random.nextDouble() * 800.0 - 400.0) - 250 * (this.nmv[i] - 1)) * n9);
                this.mtx[i][j + this.nmv[i]] = (int)((j * 500 + (random.nextDouble() * 800.0 - 400.0) - 250 * (this.nmv[i] - 1)) * n9);
                this.mtx[i][this.nmv[i]] = (int)(this.mtx[i][0] - (100.0 + random.nextDouble() * 600.0) * n9);
                this.mtx[i][this.nmv[i] * 2 - 1] = (int)(this.mtx[i][this.nmv[i] - 1] + (100.0 + random.nextDouble() * 600.0) * n9);
                if (j == 0 || j == this.nmv[i] - 1) {
                    this.mty[i][j] = (int)((-400.0 - 1200.0 * random.nextDouble()) * n10 + this.ground);
                }
                if (j == 1 || j == this.nmv[i] - 2) {
                    this.mty[i][j] = (int)((-1000.0 - 1450.0 * random.nextDouble()) * n10 + this.ground);
                }
                if (j > 1 && j < this.nmv[i] - 2) {
                    this.mty[i][j] = (int)((-1600.0 - 1700.0 * random.nextDouble()) * n10 + this.ground);
                }
                this.mty[i][j + this.nmv[i]] = this.ground - 70;
                this.mtz[i][j] = n6 + n7 + array[i];
                this.mtz[i][j + this.nmv[i]] = n6 + n7 + array[i];
                final float n12 = (float)(0.5 + random.nextDouble() * 0.5);
                this.mtc[i][j][0] = (int)(170.0f * n12 + 170.0f * n12 * (this.snap[0] / 100.0f));
                if (this.mtc[i][j][0] > 255) {
                    this.mtc[i][j][0] = 255;
                }
                if (this.mtc[i][j][0] < 0) {
                    this.mtc[i][j][0] = 0;
                }
                this.mtc[i][j][1] = (int)(n11 * n12 + 85.0f * n12 * (this.snap[1] / 100.0f));
                if (this.mtc[i][j][1] > 255) {
                    this.mtc[i][j][1] = 255;
                }
                if (this.mtc[i][j][1] < 1) {
                    this.mtc[i][j][1] = 0;
                }
                this.mtc[i][j][2] = 0;
            }
            for (int k = 1; k < this.nmv[i] - 1; ++k) {
                this.mty[i][k] = ((this.mty[i][k - 1] + this.mty[i][k + 1]) / 2 + this.mty[i][k]) / 2;
            }
            this.rot(this.mtx[i], this.mtz[i], n5, n6, n8, this.nmv[i] * 2);
            array2[i] = 0;
        }
        for (int l = 0; l < this.nmt; ++l) {
            for (int n13 = l + 1; n13 < this.nmt; ++n13) {
                if (array[l] < array[n13]) {
                    final int[] array3 = array2;
                    final int n14 = l;
                    ++array3[n14];
                }
                else {
                    final int[] array4 = array2;
                    final int n15 = n13;
                    ++array4[n15];
                }
            }
            this.mrd[array2[l]] = l;
        }
    }

    public void drawmountains(final Graphics2D graphics2D) {
        for (int i = 0; i < this.nmt; ++i) {
            final int n = this.mrd[i];
            final int n2 = this.cx + (int)((this.mtx[n][0] - this.x / 30 - this.cx) * this.cos(this.xz) - (this.mtz[n][0] - this.z / 30 - this.cz) * this.sin(this.xz));
            final int n3 = this.cz + (int)((this.mty[n][0] - this.y / 30 - this.cy) * this.sin(this.zy) + (this.cz + (int)((this.mtx[n][0] - this.x / 30 - this.cx) * this.sin(this.xz) + (this.mtz[n][0] - this.z / 30 - this.cz) * this.cos(this.xz)) - this.cz) * this.cos(this.zy));
            if (this.xs(this.cx + (int)((this.mtx[n][this.nmv[n] - 1] - this.x / 30 - this.cx) * this.cos(this.xz) - (this.mtz[n][this.nmv[n] - 1] - this.z / 30 - this.cz) * this.sin(this.xz)), this.cz + (int)((this.mty[n][this.nmv[n] - 1] - this.y / 30 - this.cy) * this.sin(this.zy) + (this.cz + (int)((this.mtx[n][this.nmv[n] - 1] - this.x / 30 - this.cx) * this.sin(this.xz) + (this.mtz[n][this.nmv[n] - 1] - this.z / 30 - this.cz) * this.cos(this.xz)) - this.cz) * this.cos(this.zy))) > 0 && this.xs(n2, n3) < this.w) {
                final int[] array = new int[this.nmv[n] * 2];
                final int[] array2 = new int[this.nmv[n] * 2];
                final int[] array3 = new int[this.nmv[n] * 2];
                for (int j = 0; j < this.nmv[n] * 2; ++j) {
                    array[j] = this.mtx[n][j] - this.x / 30;
                    array2[j] = this.mty[n][j] - this.y / 30;
                    array3[j] = this.mtz[n][j] - this.z / 30;
                }
                final int n4 = (int)Math.sqrt(array[this.nmv[n] / 4] * array[this.nmv[n] / 4] + array3[this.nmv[n] / 4] * array3[this.nmv[n] / 4]);
                this.rot(array, array3, this.cx, this.cz, this.xz, this.nmv[n] * 2);
                this.rot(array2, array3, this.cy, this.cz, this.zy, this.nmv[n] * 2);
                final int[] array4 = new int[4];
                final int[] array5 = new int[4];
                for (int k = 0; k < this.nmv[n] - 1; ++k) {
                    int n5 = 0;
                    int n6 = 0;
                    int n7 = 0;
                    int n8 = 0;
                    boolean b = true;
                    for (int l = 0; l < 4; ++l) {
                        int n9 = l + k;
                        if (l == 2) {
                            n9 = k + this.nmv[n] + 1;
                        }
                        if (l == 3) {
                            n9 = k + this.nmv[n];
                        }
                        array4[l] = this.xs(array[n9], array3[n9]);
                        array5[l] = this.ys(array2[n9], array3[n9]);
                        if (array5[l] < 0 || array3[n9] < 10) {
                            ++n5;
                        }
                        if (array5[l] > this.h || array3[n9] < 10) {
                            ++n6;
                        }
                        if (array4[l] < 0 || array3[n9] < 10) {
                            ++n7;
                        }
                        if (array4[l] > this.w || array3[n9] < 10) {
                            ++n8;
                        }
                    }
                    if (n7 == 4 || n5 == 4 || n6 == 4 || n8 == 4) {
                        b = false;
                    }
                    if (b) {
                        float n10 = n4 / 2500.0f + (8000.0f - this.fade[0]) / 1000.0f - 2.0f - (Math.abs(this.y) - 250.0f) / 5000.0f;
                        if (n10 > 0.0f && n10 < 10.0f) {
                            if (n10 < 3.5) {
                                n10 = 3.5f;
                            }
                            graphics2D.setColor(new Color((int)((this.mtc[n][k][0] + this.cgrnd[0] + this.csky[0] * n10 + this.cfade[0] * n10) / (2.0f + n10 * 2.0f)), (int)((this.mtc[n][k][1] + this.cgrnd[1] + this.csky[1] * n10 + this.cfade[1] * n10) / (2.0f + n10 * 2.0f)), (int)((this.mtc[n][k][2] + this.cgrnd[2] + this.csky[2] * n10 + this.cfade[2] * n10) / (2.0f + n10 * 2.0f))));
                            graphics2D.fillPolygon(array4, array5, 4);
                        }
                    }
                }
            }
        }
    }

    public void newstars() {
        this.stx = null;
        this.stz = null;
        this.stc = null;
        this.bst = null;
        this.twn = null;
        this.nst = 0;
        if (this.lightson) {
            final Random random = new Random((long)(Math.random() * 100000.0));
            this.nst = 40;
            this.stx = new int[this.nst];
            this.stz = new int[this.nst];
            this.stc = new int[this.nst][2][3];
            this.bst = new boolean[this.nst];
            this.twn = new int[this.nst];
            for (int i = 0; i < this.nst; ++i) {
                this.stx[i] = (int)(2000.0 * random.nextDouble() - 1000.0);
                this.stz[i] = (int)(2000.0 * random.nextDouble() - 1000.0);
                int n = (int)(3.0 * random.nextDouble());
                if (n >= 3) {
                    n = 0;
                }
                if (n <= -1) {
                    n = 2;
                }
                int n2 = n + 1;
                if (random.nextDouble() > random.nextDouble()) {
                    n2 = n - 1;
                }
                if (n2 == 3) {
                    n2 = 0;
                }
                if (n2 == -1) {
                    n2 = 2;
                }
                for (int j = 0; j < 3; ++j) {
                    this.stc[i][0][j] = 200;
                    if (n == j) {
                        final int[] array = this.stc[i][0];
                        final int n3 = j;
                        array[n3] += (int)(55.0 * random.nextDouble());
                    }
                    if (n2 == j) {
                        final int[] array2 = this.stc[i][0];
                        final int n4 = j;
                        array2[n4] += 55;
                    }
                    this.stc[i][0][j] = (this.stc[i][0][j] * 2 + this.csky[j]) / 3;
                    this.stc[i][1][j] = (this.stc[i][0][j] + this.csky[j]) / 2;
                }
                this.twn[i] = (int)(4.0 * random.nextDouble());
                if (random.nextDouble() > 0.8) {
                    this.bst[i] = true;
                }
                else {
                    this.bst[i] = false;
                }
            }
        }
    }

    public void drawstars(final Graphics2D graphics2D) {
        for (int i = 0; i < this.nst; ++i) {
            final int n = this.cx + (int)(this.stx[i] * this.cos(this.xz) - this.stz[i] * this.sin(this.xz));
            final int n2 = this.cz + (int)(this.stx[i] * this.sin(this.xz) + this.stz[i] * this.cos(this.xz));
            final int n3 = this.cy + (int)(-200.0f * this.cos(this.zy) - n2 * this.sin(this.zy));
            final int n4 = this.cz + (int)(-200.0f * this.sin(this.zy) + n2 * this.cos(this.zy));
            final int xs = this.xs(n, n4);
            final int ys = this.ys(n3, n4);
            if (xs - 1 > this.iw && xs + 3 < this.w && ys - 1 > this.ih && ys + 3 < this.h) {
                if (this.twn[i] == 0) {
                    int n5 = (int)(3.0 * Math.random());
                    if (n5 >= 3) {
                        n5 = 0;
                    }
                    if (n5 <= -1) {
                        n5 = 2;
                    }
                    int n6 = n5 + 1;
                    if (Math.random() > Math.random()) {
                        n6 = n5 - 1;
                    }
                    if (n6 == 3) {
                        n6 = 0;
                    }
                    if (n6 == -1) {
                        n6 = 2;
                    }
                    for (int j = 0; j < 3; ++j) {
                        this.stc[i][0][j] = 200;
                        if (n5 == j) {
                            final int[] array = this.stc[i][0];
                            final int n7 = j;
                            array[n7] += (int)(55.0 * Math.random());
                        }
                        if (n6 == j) {
                            final int[] array2 = this.stc[i][0];
                            final int n8 = j;
                            array2[n8] += 55;
                        }
                        this.stc[i][0][j] = (this.stc[i][0][j] * 2 + this.csky[j]) / 3;
                        this.stc[i][1][j] = (this.stc[i][0][j] + this.csky[j]) / 2;
                    }
                    this.twn[i] = 3;
                }
                else {
                    final int[] twn = this.twn;
                    final int n9 = i;
                    --twn[n9];
                }
                int n10 = 0;
                if (this.bst[i]) {
                    n10 = 1;
                }
                graphics2D.setColor(new Color(this.stc[i][1][0], this.stc[i][1][1], this.stc[i][1][2]));
                graphics2D.fillRect(xs - 1, ys, 3 + n10, 1 + n10);
                graphics2D.fillRect(xs, ys - 1, 1 + n10, 3 + n10);
                graphics2D.setColor(new Color(this.stc[i][0][0], this.stc[i][0][1], this.stc[i][0][2]));
                graphics2D.fillRect(xs, ys, 1 + n10, 1 + n10);
            }
        }
    }

    public void d(final Graphics2D graphics2D) {
        this.nsp = 0;
        if (this.zy > 90) {
            this.zy = 90;
        }
        if (this.zy < -90) {
            this.zy = -90;
        }
        if (this.xz > 360) {
            this.xz -= 360;
        }
        if (this.xz < 0) {
            this.xz += 360;
        }
        if (this.y > 0) {
            this.y = 0;
        }
        this.ground = 250 - this.y;
        final int[] array = new int[4];
        final int[] array2 = new int[4];
        int n = this.cgrnd[0];
        int n2 = this.cgrnd[1];
        int n3 = this.cgrnd[2];
        int n4 = this.crgrnd[0];
        int n5 = this.crgrnd[1];
        int n6 = this.crgrnd[2];
        int h = this.h;
        for (int i = 0; i < 16; ++i) {
            int n7 = this.fade[i];
            int ground = this.ground;
            if (this.zy != 0) {
                ground = this.cy + (int)((this.ground - this.cy) * this.cos(this.zy) - (this.fade[i] - this.cz) * this.sin(this.zy));
                n7 = this.cz + (int)((this.ground - this.cy) * this.sin(this.zy) + (this.fade[i] - this.cz) * this.cos(this.zy));
            }
            array[0] = this.iw;
            array2[0] = this.ys(ground, n7);
            if (array2[0] < this.ih) {
                array2[0] = this.ih;
            }
            if (array2[0] > this.h) {
                array2[0] = this.h;
            }
            array[1] = this.iw;
            array2[1] = h;
            array[2] = this.w;
            array2[2] = h;
            array[3] = this.w;
            array2[3] = array2[0];
            h = array2[0];
            if (i > 0) {
                n4 = (n4 * 7 + this.cfade[0]) / 8;
                n5 = (n5 * 7 + this.cfade[1]) / 8;
                n6 = (n6 * 7 + this.cfade[2]) / 8;
                if (i < 3) {
                    n = (n * 7 + this.cfade[0]) / 8;
                    n2 = (n2 * 7 + this.cfade[1]) / 8;
                    n3 = (n3 * 7 + this.cfade[2]) / 8;
                }
                else {
                    n = n4;
                    n2 = n5;
                    n3 = n6;
                }
            }
            if (array2[0] < this.h && array2[1] > this.ih) {
                graphics2D.setColor(new Color(n, n2, n3));
                graphics2D.fillPolygon(array, array2, 4);
            }
        }
        if (this.lightn != -1 && this.lton) {
            if (this.lightn < 16) {
                if (this.lilo > this.lightn + 217) {
                    this.lilo -= 3;
                }
                else {
                    this.lightn = (int)(16.0f + 16.0f * this.random());
                }
            }
            else if (this.lilo < this.lightn + 217) {
                this.lilo += 7;
            }
            else {
                this.lightn = (int)(16.0f * this.random());
            }
            this.csky[0] = (int)(this.lilo + this.lilo * (this.snap[0] / 100.0f));
            if (this.csky[0] > 255) {
                this.csky[0] = 255;
            }
            if (this.csky[0] < 0) {
                this.csky[0] = 0;
            }
            this.csky[1] = (int)(this.lilo + this.lilo * (this.snap[1] / 100.0f));
            if (this.csky[1] > 255) {
                this.csky[1] = 255;
            }
            if (this.csky[1] < 0) {
                this.csky[1] = 0;
            }
            this.csky[2] = (int)(this.lilo + this.lilo * (this.snap[2] / 100.0f));
            if (this.csky[2] > 255) {
                this.csky[2] = 255;
            }
            if (this.csky[2] < 0) {
                this.csky[2] = 0;
            }
        }
        int n8 = this.csky[0];
        int n9 = this.csky[1];
        int n10 = this.csky[2];
        int n11 = n8;
        int n12 = n9;
        int n13 = n10;
        int ys = this.ys(this.cy + (int)((this.skyline - 700 - this.cy) * this.cos(this.zy) - (7000 - this.cz) * this.sin(this.zy)), this.cz + (int)((this.skyline - 700 - this.cy) * this.sin(this.zy) + (7000 - this.cz) * this.cos(this.zy)));
        int ih = this.ih;
        for (int j = 0; j < 16; ++j) {
            int n14 = this.fade[j];
            int skyline = this.skyline;
            if (this.zy != 0) {
                skyline = this.cy + (int)((this.skyline - this.cy) * this.cos(this.zy) - (this.fade[j] - this.cz) * this.sin(this.zy));
                n14 = this.cz + (int)((this.skyline - this.cy) * this.sin(this.zy) + (this.fade[j] - this.cz) * this.cos(this.zy));
            }
            array[0] = this.iw;
            array2[0] = this.ys(skyline, n14);
            if (array2[0] > this.h) {
                array2[0] = this.h;
            }
            if (array2[0] < this.ih) {
                array2[0] = this.ih;
            }
            array[1] = this.iw;
            array2[1] = ih;
            array[2] = this.w;
            array2[2] = ih;
            array[3] = this.w;
            array2[3] = array2[0];
            ih = array2[0];
            if (j > 0) {
                n8 = (n8 * 7 + this.cfade[0]) / 8;
                n9 = (n9 * 7 + this.cfade[1]) / 8;
                n10 = (n10 * 7 + this.cfade[2]) / 8;
            }
            if (array2[1] < ys) {
                n11 = n8;
                n12 = n9;
                n13 = n10;
            }
            if (array2[0] > this.ih && array2[1] < this.h) {
                graphics2D.setColor(new Color(n8, n9, n10));
                graphics2D.fillPolygon(array, array2, 4);
            }
        }
        array[0] = this.iw;
        array2[0] = ih;
        array[1] = this.iw;
        array2[1] = h;
        array[2] = this.w;
        array2[2] = h;
        array[3] = this.w;
        array2[3] = ih;
        if (array2[0] < this.h && array2[1] > this.ih) {
            float n15 = (Math.abs(this.y) - 250.0f) / (this.fade[0] * 2);
            if (n15 < 0.0f) {
                n15 = 0.0f;
            }
            if (n15 > 1.0f) {
                n15 = 1.0f;
            }
            graphics2D.setColor(new Color((int)((n8 * (1.0f - n15) + n4 * (1.0f + n15)) / 2.0f), (int)((n9 * (1.0f - n15) + n5 * (1.0f + n15)) / 2.0f), (int)((n10 * (1.0f - n15) + n6 * (1.0f + n15)) / 2.0f)));
            graphics2D.fillPolygon(array, array2, 4);
        }
        if (this.resdown != 2) {
            for (int k = 1; k < 20; ++k) {
                int n16 = 7000;
                int n17 = this.skyline - 700 - k * 70;
                if (this.zy != 0 && k != 19) {
                    n17 = this.cy + (int)((this.skyline - 700 - k * 70 - this.cy) * this.cos(this.zy) - (7000 - this.cz) * this.sin(this.zy));
                    n16 = this.cz + (int)((this.skyline - 700 - k * 70 - this.cy) * this.sin(this.zy) + (7000 - this.cz) * this.cos(this.zy));
                }
                array[0] = this.iw;
                if (k != 19) {
                    array2[0] = this.ys(n17, n16);
                    if (array2[0] > this.h) {
                        array2[0] = this.h;
                    }
                    if (array2[0] < this.ih) {
                        array2[0] = this.ih;
                    }
                }
                else {
                    array2[0] = this.ih;
                }
                array[1] = this.iw;
                array2[1] = ys;
                array[2] = this.w;
                array2[2] = ys;
                array[3] = this.w;
                array2[3] = array2[0];
                ys = array2[0];
                n11 *= (int)0.991;
                n12 *= (int)0.991;
                n13 *= (int)0.998;
                if (array2[1] > this.ih && array2[0] < this.h) {
                    graphics2D.setColor(new Color(n11, n12, n13));
                    graphics2D.fillPolygon(array, array2, 4);
                }
            }
            if (this.lightson) {
                this.drawstars(graphics2D);
            }
            this.drawmountains(graphics2D);
            this.drawclouds(graphics2D);
        }
        this.groundpolys(graphics2D);
        if (this.noelec != 0) {
            --this.noelec;
        }
        if (this.cpflik) {
            this.cpflik = false;
        }
        else {
            this.cpflik = true;
            this.elecr = this.random() * 15.0f - 6.0f;
        }
    }

    public void addsp(final int n, final int n2, final int n3) {
        if (this.nsp != 7) {
            this.spx[this.nsp] = n;
            this.spz[this.nsp] = n2;
            this.sprad[this.nsp] = n3;
            ++this.nsp;
        }
    }

    public void setsnap(final int n, final int n2, final int n3) {
        this.snap[0] = n;
        this.snap[1] = n2;
        this.snap[2] = n3;
    }

    public void setsky(final int n, final int n2, final int n3) {
        this.osky[0] = n;
        this.osky[1] = n2;
        this.osky[2] = n3;
        for (int i = 0; i < 3; ++i) {
            this.clds[i] = (this.osky[i] * this.cldd[3] + this.cldd[i]) / (this.cldd[3] + 1);
            this.clds[i] += (int)(this.clds[i] * (this.snap[i] / 100.0f));
            if (this.clds[i] > 255) {
                this.clds[i] = 255;
            }
            if (this.clds[i] < 0) {
                this.clds[i] = 0;
            }
        }
        this.csky[0] = (int)(n + n * (this.snap[0] / 100.0f));
        if (this.csky[0] > 255) {
            this.csky[0] = 255;
        }
        if (this.csky[0] < 0) {
            this.csky[0] = 0;
        }
        this.csky[1] = (int)(n2 + n2 * (this.snap[1] / 100.0f));
        if (this.csky[1] > 255) {
            this.csky[1] = 255;
        }
        if (this.csky[1] < 0) {
            this.csky[1] = 0;
        }
        this.csky[2] = (int)(n3 + n3 * (this.snap[2] / 100.0f));
        if (this.csky[2] > 255) {
            this.csky[2] = 255;
        }
        if (this.csky[2] < 0) {
            this.csky[2] = 0;
        }
        // NOTE: does nothing, as this.darksky is never read from
        /*
        final float[] array = new float[3];
        Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], array);
        if (array[2] < 0.6) {
            this.darksky = true;
        }
        else {
            this.darksky = false;
        }
        */
    }

    public void setcloads(final int n, final int n2, final int n3, int n4, int n5) {
        if (n4 < 0) {
            n4 = 0;
        }
        if (n4 > 10) {
            n4 = 10;
        }
        if (n5 < -1500) {
            n5 = -1500;
        }
        if (n5 > -500) {
            n5 = -500;
        }
        this.cldd[0] = n;
        this.cldd[1] = n2;
        this.cldd[2] = n3;
        this.cldd[3] = n4;
        this.cldd[4] = n5;
        for (int i = 0; i < 3; ++i) {
            this.clds[i] = (this.osky[i] * this.cldd[3] + this.cldd[i]) / (this.cldd[3] + 1);
            this.clds[i] += (int)(this.clds[i] * (this.snap[i] / 100.0f));
            if (this.clds[i] > 255) {
                this.clds[i] = 255;
            }
            if (this.clds[i] < 0) {
                this.clds[i] = 0;
            }
        }
    }

    public void setgrnd(final int n, final int n2, final int n3) {
        this.ogrnd[0] = n;
        this.ogrnd[1] = n2;
        this.ogrnd[2] = n3;
        for (int i = 0; i < 3; ++i) {
            this.cpol[i] = (this.ogrnd[i] * this.texture[3] + this.texture[i]) / (1 + this.texture[3]);
            this.cpol[i] += (int)(this.cpol[i] * (this.snap[i] / 100.0f));
            if (this.cpol[i] > 255) {
                this.cpol[i] = 255;
            }
            if (this.cpol[i] < 0) {
                this.cpol[i] = 0;
            }
        }
        this.cgrnd[0] = (int)(n + n * (this.snap[0] / 100.0f));
        if (this.cgrnd[0] > 255) {
            this.cgrnd[0] = 255;
        }
        if (this.cgrnd[0] < 0) {
            this.cgrnd[0] = 0;
        }
        this.cgrnd[1] = (int)(n2 + n2 * (this.snap[1] / 100.0f));
        if (this.cgrnd[1] > 255) {
            this.cgrnd[1] = 255;
        }
        if (this.cgrnd[1] < 0) {
            this.cgrnd[1] = 0;
        }
        this.cgrnd[2] = (int)(n3 + n3 * (this.snap[2] / 100.0f));
        if (this.cgrnd[2] > 255) {
            this.cgrnd[2] = 255;
        }
        if (this.cgrnd[2] < 0) {
            this.cgrnd[2] = 0;
        }
        for (int j = 0; j < 3; ++j) {
            this.crgrnd[j] = (int)((this.cpol[j] * 0.99 + this.cgrnd[j]) / 2.0);
        }
    }

    public void setexture(int n, int n2, int n3, int n4) {
        if (n4 < 20) {
            n4 = 20;
        }
        if (n4 > 60) {
            n4 = 60;
        }
        this.texture[0] = n;
        this.texture[1] = n2;
        this.texture[2] = n3;
        this.texture[3] = n4;
        n = (this.ogrnd[0] * n4 + n) / (1 + n4);
        n2 = (this.ogrnd[1] * n4 + n2) / (1 + n4);
        n3 = (this.ogrnd[2] * n4 + n3) / (1 + n4);
        this.cpol[0] = (int)(n + n * (this.snap[0] / 100.0f));
        if (this.cpol[0] > 255) {
            this.cpol[0] = 255;
        }
        if (this.cpol[0] < 0) {
            this.cpol[0] = 0;
        }
        this.cpol[1] = (int)(n2 + n2 * (this.snap[1] / 100.0f));
        if (this.cpol[1] > 255) {
            this.cpol[1] = 255;
        }
        if (this.cpol[1] < 0) {
            this.cpol[1] = 0;
        }
        this.cpol[2] = (int)(n3 + n3 * (this.snap[2] / 100.0f));
        if (this.cpol[2] > 255) {
            this.cpol[2] = 255;
        }
        if (this.cpol[2] < 0) {
            this.cpol[2] = 0;
        }
        for (int i = 0; i < 3; ++i) {
            this.crgrnd[i] = (int)((this.cpol[i] * 0.99 + this.cgrnd[i]) / 2.0);
        }
    }

    public void setpolys(final int n, final int n2, final int n3) {
        this.cpol[0] = (int)(n + n * (this.snap[0] / 100.0f));
        if (this.cpol[0] > 255) {
            this.cpol[0] = 255;
        }
        if (this.cpol[0] < 0) {
            this.cpol[0] = 0;
        }
        this.cpol[1] = (int)(n2 + n2 * (this.snap[1] / 100.0f));
        if (this.cpol[1] > 255) {
            this.cpol[1] = 255;
        }
        if (this.cpol[1] < 0) {
            this.cpol[1] = 0;
        }
        this.cpol[2] = (int)(n3 + n3 * (this.snap[2] / 100.0f));
        if (this.cpol[2] > 255) {
            this.cpol[2] = 255;
        }
        if (this.cpol[2] < 0) {
            this.cpol[2] = 0;
        }
        for (int i = 0; i < 3; ++i) {
            this.crgrnd[i] = (int)((this.cpol[i] * 0.99 + this.cgrnd[i]) / 2.0);
        }
    }

    public void setfade(final int n, final int n2, final int n3) {
        this.cfade[0] = (int)(n + n * (this.snap[0] / 100.0f));
        if (this.cfade[0] > 255) {
            this.cfade[0] = 255;
        }
        if (this.cfade[0] < 0) {
            this.cfade[0] = 0;
        }
        this.cfade[1] = (int)(n2 + n2 * (this.snap[1] / 100.0f));
        if (this.cfade[1] > 255) {
            this.cfade[1] = 255;
        }
        if (this.cfade[1] < 0) {
            this.cfade[1] = 0;
        }
        this.cfade[2] = (int)(n3 + n3 * (this.snap[2] / 100.0f));
        if (this.cfade[2] > 255) {
            this.cfade[2] = 255;
        }
        if (this.cfade[2] < 0) {
            this.cfade[2] = 0;
        }
    }

    public void fadfrom(int n) {
        if (n > 8000) {
            n = 8000;
        }
        for (int i = 1; i < 17; ++i) {
            this.fade[i - 1] = n / 2 * (i + 1);
        }
    }

    public void adjstfade(final float n, final float n2, final int n3, final GameSparker gameSparker) {
        if (this.resdown != 2) {
            if (n == 5.0f) {
                if (this.resdown == 0 && this.rescnt == 0) {
                    gameSparker.moto = 0;
                    Madness.anti = 0;
                    this.fadfrom(this.fade[0] = 3000);
                    this.resdown = 1;
                    this.rescnt = 10;
                }
                if (this.resdown == 1 && this.rescnt == 0) {
                    this.resdown = 2;
                }
                if ((n3 == 0 || this.resdown == 0) && n2 <= -20.0f) {
                    --this.rescnt;
                }
            }
            else if (this.resdown == 0) {
                this.rescnt = 5;
            }
            else {
                this.rescnt = 10;
            }
        }
    }

    public int xs(final int n, int cz) {
        if (cz < this.cz) {
            cz = this.cz;
        }
        return (cz - this.focus_point) * (this.cx - n) / cz + n;
    }

    public int ys(final int n, int n2) {
        if (n2 < 10) {
            n2 = 10;
        }
        return (n2 - this.focus_point) * (this.cy - n) / n2 + n;
    }

    public float cos(int i) {
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return this.tcos[i];
    }

    public float sin(int i) {
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return this.tsin[i];
    }

    public void rot(final int[] array, final int[] array2, final int n, final int n2, final int n3, final int n4) {
        if (n3 != 0) {
            for (int i = 0; i < n4; ++i) {
                final int n5 = array[i];
                final int n6 = array2[i];
                array[i] = n + (int)((n5 - n) * this.cos(n3) - (n6 - n2) * this.sin(n3));
                array2[i] = n2 + (int)((n5 - n) * this.sin(n3) + (n6 - n2) * this.cos(n3));
            }
        }
    }
}
