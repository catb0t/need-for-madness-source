import java.awt.Color;

public class Record
{
    Medium m;
    int caught;
    boolean hcaught;
    boolean prepit;
    ContO[] ocar;
    int cntf;
    ContO[][] car;
    int[][] squash;
    int[] fix;
    int[] dest;
    int[][] x;
    int[][] y;
    int[][] z;
    int[][] xy;
    int[][] zy;
    int[][] xz;
    int[][] wxz;
    int[][] wzy;
    int[][] ns;
    int[][][] sspark;
    int[][][] sx;
    int[][][] sy;
    int[][][] sz;
    float[][][] smag;
    int[][][] scx;
    int[][][] scz;
    int[] nr;
    int[][] rspark;
    int[][] sprk;
    int[][] srx;
    int[][] sry;
    int[][] srz;
    float[][] rcx;
    float[][] rcy;
    float[][] rcz;
    int[][] nry;
    int[][][] ry;
    int[][][] magy;
    boolean[][] mtouch;
    int[][] nrx;
    int[][][] rx;
    int[][][] magx;
    int[][] nrz;
    int[][][] rz;
    int[][][] magz;
    int[] checkpoint;
    boolean[] lastcheck;
    int wasted;
    int whenwasted;
    int powered;
    int closefinish;
    ContO[] starcar;
    int[] hsquash;
    int[] hfix;
    int[] hdest;
    int[][] hx;
    int[][] hy;
    int[][] hz;
    int[][] hxy;
    int[][] hzy;
    int[][] hxz;
    int[][] hwxz;
    int[][] hwzy;
    int[][][] hsspark;
    int[][][] hsx;
    int[][][] hsy;
    int[][][] hsz;
    float[][][] hsmag;
    int[][][] hscx;
    int[][][] hscz;
    int[][] hrspark;
    int[][] hsprk;
    int[][] hsrx;
    int[][] hsry;
    int[][] hsrz;
    float[][] hrcx;
    float[][] hrcy;
    float[][] hrcz;
    int[][][] hry;
    int[][][] hmagy;
    int[][][] hrx;
    int[][][] hmagx;
    int[][][] hrz;
    int[][][] hmagz;
    boolean[][] hmtouch;
    int[] hcheckpoint;
    boolean[] hlastcheck;
    int[] cntdest;
    int lastfr;
    
    public Record(final Medium m) {
        this.caught = 0;
        this.hcaught = false;
        this.prepit = true;
        this.ocar = new ContO[8];
        this.cntf = 50;
        this.car = new ContO[6][8];
        this.squash = new int[6][8];
        this.fix = new int[8];
        this.dest = new int[8];
        this.x = new int[300][8];
        this.y = new int[300][8];
        this.z = new int[300][8];
        this.xy = new int[300][8];
        this.zy = new int[300][8];
        this.xz = new int[300][8];
        this.wxz = new int[300][8];
        this.wzy = new int[300][8];
        this.ns = new int[8][20];
        this.sspark = new int[8][20][30];
        this.sx = new int[8][20][30];
        this.sy = new int[8][20][30];
        this.sz = new int[8][20][30];
        this.smag = new float[8][20][30];
        this.scx = new int[8][20][30];
        this.scz = new int[8][20][30];
        this.nr = new int[8];
        this.rspark = new int[8][200];
        this.sprk = new int[8][200];
        this.srx = new int[8][200];
        this.sry = new int[8][200];
        this.srz = new int[8][200];
        this.rcx = new float[8][200];
        this.rcy = new float[8][200];
        this.rcz = new float[8][200];
        this.nry = new int[8][4];
        this.ry = new int[8][4][7];
        this.magy = new int[8][4][7];
        this.mtouch = new boolean[8][7];
        this.nrx = new int[8][4];
        this.rx = new int[8][4][7];
        this.magx = new int[8][4][7];
        this.nrz = new int[8][4];
        this.rz = new int[8][4][7];
        this.magz = new int[8][4][7];
        this.checkpoint = new int[300];
        this.lastcheck = new boolean[300];
        this.wasted = 0;
        this.whenwasted = 0;
        this.powered = 0;
        this.closefinish = 0;
        this.starcar = new ContO[8];
        this.hsquash = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.hfix = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
        this.hdest = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
        this.hx = new int[300][8];
        this.hy = new int[300][8];
        this.hz = new int[300][8];
        this.hxy = new int[300][8];
        this.hzy = new int[300][8];
        this.hxz = new int[300][8];
        this.hwxz = new int[300][8];
        this.hwzy = new int[300][8];
        this.hsspark = new int[8][20][30];
        this.hsx = new int[8][20][30];
        this.hsy = new int[8][20][30];
        this.hsz = new int[8][20][30];
        this.hsmag = new float[8][20][30];
        this.hscx = new int[8][20][30];
        this.hscz = new int[8][20][30];
        this.hrspark = new int[8][200];
        this.hsprk = new int[8][200];
        this.hsrx = new int[8][200];
        this.hsry = new int[8][200];
        this.hsrz = new int[8][200];
        this.hrcx = new float[8][200];
        this.hrcy = new float[8][200];
        this.hrcz = new float[8][200];
        this.hry = new int[8][4][7];
        this.hmagy = new int[8][4][7];
        this.hrx = new int[8][4][7];
        this.hmagx = new int[8][4][7];
        this.hrz = new int[8][4][7];
        this.hmagz = new int[8][4][7];
        this.hmtouch = new boolean[8][7];
        this.hcheckpoint = new int[300];
        this.hlastcheck = new boolean[300];
        this.cntdest = new int[8];
        this.lastfr = 0;
        this.m = m;
        this.cotchinow(this.caught = 0);
    }
    
    public void reset(final ContO[] array) {
        this.caught = 0;
        this.hcaught = false;
        this.wasted = 0;
        this.whenwasted = 0;
        this.closefinish = 0;
        this.powered = 0;
        for (int i = 0; i < 8; ++i) {
            if (this.prepit) {
                this.starcar[i] = new ContO(array[i], 0, 0, 0, 0);
            }
            this.fix[i] = -1;
            this.dest[i] = -1;
            this.cntdest[i] = 0;
        }
        for (int j = 0; j < 6; ++j) {
            for (int k = 0; k < 8; ++k) {
                this.car[j][k] = new ContO(array[k], 0, 0, 0, 0);
                this.squash[j][k] = 0;
            }
        }
        for (int l = 0; l < 8; ++l) {
            this.nr[l] = 0;
            for (int n = 0; n < 200; ++n) {
                this.rspark[l][n] = -1;
            }
            for (int n2 = 0; n2 < 20; ++n2) {
                this.ns[l][n2] = 0;
                for (int n3 = 0; n3 < 30; ++n3) {
                    this.sspark[l][n2][n3] = -1;
                }
            }
            for (int n4 = 0; n4 < 4; ++n4) {
                this.nry[l][n4] = 0;
                this.nrx[l][n4] = 0;
                this.nrz[l][n4] = 0;
                for (int n5 = 0; n5 < 7; ++n5) {
                    this.ry[l][n4][n5] = -1;
                    this.rx[l][n4][n5] = -1;
                    this.rz[l][n4][n5] = -1;
                }
            }
        }
        this.prepit = false;
    }
    
    public void cotchinow(final int wasted) {
        if (this.caught >= 300) {
            this.wasted = wasted;
            for (int i = 0; i < 8; ++i) {
                this.starcar[i] = new ContO(this.car[0][i], 0, 0, 0, 0);
                this.hsquash[i] = this.squash[0][i];
                this.hfix[i] = this.fix[i];
                this.hdest[i] = this.dest[i];
            }
            for (int j = 0; j < 300; ++j) {
                for (int k = 0; k < 8; ++k) {
                    this.hx[j][k] = this.x[j][k];
                    this.hy[j][k] = this.y[j][k];
                    this.hz[j][k] = this.z[j][k];
                    this.hxy[j][k] = this.xy[j][k];
                    this.hzy[j][k] = this.zy[j][k];
                    this.hxz[j][k] = this.xz[j][k];
                    this.hwxz[j][k] = this.wxz[j][k];
                    this.hwzy[j][k] = this.wzy[j][k];
                }
                this.hcheckpoint[j] = this.checkpoint[j];
                this.hlastcheck[j] = this.lastcheck[j];
            }
            for (int l = 0; l < 8; ++l) {
                for (int n = 0; n < 20; ++n) {
                    for (int n2 = 0; n2 < 30; ++n2) {
                        this.hsspark[l][n][n2] = this.sspark[l][n][n2];
                        this.hsx[l][n][n2] = this.sx[l][n][n2];
                        this.hsy[l][n][n2] = this.sy[l][n][n2];
                        this.hsz[l][n][n2] = this.sz[l][n][n2];
                        this.hsmag[l][n][n2] = this.smag[l][n][n2];
                        this.hscx[l][n][n2] = this.scx[l][n][n2];
                        this.hscz[l][n][n2] = this.scz[l][n][n2];
                    }
                }
                for (int n3 = 0; n3 < 200; ++n3) {
                    this.hrspark[l][n3] = this.rspark[l][n3];
                    this.hsprk[l][n3] = this.sprk[l][n3];
                    this.hsrx[l][n3] = this.srx[l][n3];
                    this.hsry[l][n3] = this.sry[l][n3];
                    this.hsrz[l][n3] = this.srz[l][n3];
                    this.hrcx[l][n3] = this.rcx[l][n3];
                    this.hrcy[l][n3] = this.rcy[l][n3];
                    this.hrcz[l][n3] = this.rcz[l][n3];
                }
            }
            for (int n4 = 0; n4 < 8; ++n4) {
                for (int n5 = 0; n5 < 4; ++n5) {
                    for (int n6 = 0; n6 < 7; ++n6) {
                        this.hry[n4][n5][n6] = this.ry[n4][n5][n6];
                        this.hmagy[n4][n5][n6] = this.magy[n4][n5][n6];
                        this.hrx[n4][n5][n6] = this.rx[n4][n5][n6];
                        this.hmagx[n4][n5][n6] = this.magx[n4][n5][n6];
                        this.hrz[n4][n5][n6] = this.rz[n4][n5][n6];
                        this.hmagz[n4][n5][n6] = this.magz[n4][n5][n6];
                    }
                }
            }
            for (int n7 = 0; n7 < 8; ++n7) {
                for (int n8 = 0; n8 < 7; ++n8) {
                    this.hmtouch[n7][n8] = this.mtouch[n7][n8];
                }
            }
            this.hcaught = true;
        }
    }
    
    public void rec(final ContO contO, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n == n5) {
            ++this.caught;
        }
        if (this.cntf == 50) {
            for (int i = 0; i < 5; ++i) {
                this.car[i][n] = new ContO(this.car[i + 1][n], 0, 0, 0, 0);
                this.squash[i][n] = this.squash[i + 1][n];
            }
            this.car[5][n] = new ContO(contO, 0, 0, 0, 0);
            this.squash[5][n] = n2;
            this.cntf = 0;
        }
        else {
            ++this.cntf;
        }
        final int[] fix = this.fix;
        --fix[n];
        if (n4 != 0) {
            final int[] dest = this.dest;
            --dest[n];
        }
        if (this.dest[n] == 230) {
            if (n == n5) {
                this.cotchinow(n5);
                this.whenwasted = 229;
            }
            else if (n3 != 0) {
                this.cotchinow(n);
                this.whenwasted = 165 + n3;
            }
        }
        for (int j = 0; j < 299; ++j) {
            this.x[j][n] = this.x[j + 1][n];
            this.y[j][n] = this.y[j + 1][n];
            this.z[j][n] = this.z[j + 1][n];
            this.zy[j][n] = this.zy[j + 1][n];
            this.xy[j][n] = this.xy[j + 1][n];
            this.xz[j][n] = this.xz[j + 1][n];
            this.wxz[j][n] = this.wxz[j + 1][n];
            this.wzy[j][n] = this.wzy[j + 1][n];
        }
        this.x[299][n] = contO.x;
        this.y[299][n] = contO.y;
        this.z[299][n] = contO.z;
        this.xy[299][n] = contO.xy;
        this.zy[299][n] = contO.zy;
        this.xz[299][n] = contO.xz;
        this.wxz[299][n] = contO.wxz;
        this.wzy[299][n] = contO.wzy;
        if (n == n5) {
            for (int k = 0; k < 299; ++k) {
                this.checkpoint[k] = this.checkpoint[k + 1];
                this.lastcheck[k] = this.lastcheck[k + 1];
            }
            this.checkpoint[299] = contO.m.checkpoint;
            this.lastcheck[299] = contO.m.lastcheck;
        }
        for (int l = 0; l < 20; ++l) {
            if (contO.stg[l] == 1) {
                this.sspark[n][l][this.ns[n][l]] = 300;
                this.sx[n][l][this.ns[n][l]] = contO.sx[l];
                this.sy[n][l][this.ns[n][l]] = contO.sy[l];
                this.sz[n][l][this.ns[n][l]] = contO.sz[l];
                this.smag[n][l][this.ns[n][l]] = contO.osmag[l];
                this.scx[n][l][this.ns[n][l]] = contO.scx[l];
                this.scz[n][l][this.ns[n][l]] = contO.scz[l];
                final int[] array = this.ns[n];
                final int n6 = l;
                ++array[n6];
                if (this.ns[n][l] == 30) {
                    this.ns[n][l] = 0;
                }
            }
            for (int n7 = 0; n7 < 30; ++n7) {
                final int[] array2 = this.sspark[n][l];
                final int n8 = n7;
                --array2[n8];
            }
        }
        if (contO.sprk != 0) {
            this.rspark[n][this.nr[n]] = 300;
            this.sprk[n][this.nr[n]] = contO.sprk;
            this.srx[n][this.nr[n]] = contO.srx;
            this.sry[n][this.nr[n]] = contO.sry;
            this.srz[n][this.nr[n]] = contO.srz;
            this.rcx[n][this.nr[n]] = contO.rcx;
            this.rcy[n][this.nr[n]] = contO.rcy;
            this.rcz[n][this.nr[n]] = contO.rcz;
            final int[] nr = this.nr;
            ++nr[n];
            if (this.nr[n] == 200) {
                this.nr[n] = 0;
            }
        }
        for (int n9 = 0; n9 < 200; ++n9) {
            final int[] array3 = this.rspark[n];
            final int n10 = n9;
            --array3[n10];
        }
        for (int n11 = 0; n11 < 4; ++n11) {
            for (int n12 = 0; n12 < 7; ++n12) {
                final int[] array4 = this.ry[n][n11];
                final int n13 = n12;
                --array4[n13];
                final int[] array5 = this.rx[n][n11];
                final int n14 = n12;
                --array5[n14];
                final int[] array6 = this.rz[n][n11];
                final int n15 = n12;
                --array6[n15];
            }
        }
    }
    
    public void play(final ContO contO, final Mad mad, final int n, final int n2) {
        contO.x = this.x[n2][n];
        contO.y = this.y[n2][n];
        contO.z = this.z[n2][n];
        contO.zy = this.zy[n2][n];
        contO.xy = this.xy[n2][n];
        contO.xz = this.xz[n2][n];
        contO.wxz = this.wxz[n2][n];
        contO.wzy = this.wzy[n2][n];
        if (n == 0) {
            contO.m.checkpoint = this.checkpoint[n2];
            contO.m.lastcheck = this.lastcheck[n2];
        }
        if (n2 == 0) {
            this.cntdest[n] = 0;
        }
        if (this.dest[n] == n2) {
            this.cntdest[n] = 7;
        }
        if (n2 == 0 && this.dest[n] < -1) {
            for (int i = 0; i < contO.npl; ++i) {
                if (contO.p[i].wz == 0 || contO.p[i].gr == -17 || contO.p[i].gr == -16) {
                    contO.p[i].embos = 13;
                }
            }
        }
        if (this.cntdest[n] != 0) {
            for (int j = 0; j < contO.npl; ++j) {
                if (contO.p[j].wz == 0 || contO.p[j].gr == -17 || contO.p[j].gr == -16) {
                    contO.p[j].embos = 1;
                }
            }
            final int[] cntdest = this.cntdest;
            --cntdest[n];
        }
        for (int k = 0; k < 20; ++k) {
            for (int l = 0; l < 30; ++l) {
                if (this.sspark[n][k][l] == n2) {
                    contO.stg[k] = 1;
                    contO.sx[k] = this.sx[n][k][l];
                    contO.sy[k] = this.sy[n][k][l];
                    contO.sz[k] = this.sz[n][k][l];
                    contO.osmag[k] = this.smag[n][k][l];
                    contO.scx[k] = this.scx[n][k][l];
                    contO.scz[k] = this.scz[n][k][l];
                }
            }
        }
        for (int n3 = 0; n3 < 200; ++n3) {
            if (this.rspark[n][n3] == n2) {
                contO.sprk = this.sprk[n][n3];
                contO.srx = this.srx[n][n3];
                contO.sry = this.sry[n][n3];
                contO.srz = this.srz[n][n3];
                contO.rcx = this.rcx[n][n3];
                contO.rcy = this.rcy[n][n3];
                contO.rcz = this.rcz[n][n3];
            }
        }
        for (int n4 = 0; n4 < 4; ++n4) {
            for (int n5 = 0; n5 < 7; ++n5) {
                if (this.ry[n][n4][n5] == n2) {
                    this.regy(n4, this.magy[n][n4][n5], this.mtouch[n][n5], contO, mad);
                }
                if (this.rx[n][n4][n5] == n2) {
                    this.regx(n4, this.magx[n][n4][n5], contO, mad);
                }
                if (this.rz[n][n4][n5] == n2) {
                    this.regz(n4, this.magz[n][n4][n5], contO, mad);
                }
            }
        }
    }
    
    public void playh(final ContO contO, final Mad mad, final int n, final int lastfr, final int n2) {
        contO.x = this.hx[lastfr][n];
        contO.y = this.hy[lastfr][n];
        contO.z = this.hz[lastfr][n];
        contO.zy = this.hzy[lastfr][n];
        contO.xy = this.hxy[lastfr][n];
        contO.xz = this.hxz[lastfr][n];
        contO.wxz = this.hwxz[lastfr][n];
        contO.wzy = this.hwzy[lastfr][n];
        if (n == n2) {
            contO.m.checkpoint = this.hcheckpoint[lastfr];
            contO.m.lastcheck = this.hlastcheck[lastfr];
        }
        if (lastfr == 0) {
            this.cntdest[n] = 0;
        }
        if (this.hdest[n] == lastfr) {
            this.cntdest[n] = 7;
        }
        if (lastfr == 0 && this.hdest[n] < -1) {
            for (int i = 0; i < contO.npl; ++i) {
                if (contO.p[i].wz == 0 || contO.p[i].gr == -17 || contO.p[i].gr == -16) {
                    contO.p[i].embos = 13;
                }
            }
        }
        if (this.cntdest[n] != 0) {
            for (int j = 0; j < contO.npl; ++j) {
                if (contO.p[j].wz == 0 || contO.p[j].gr == -17 || contO.p[j].gr == -16) {
                    contO.p[j].embos = 1;
                }
            }
            final int[] cntdest = this.cntdest;
            --cntdest[n];
        }
        for (int k = 0; k < 20; ++k) {
            for (int l = 0; l < 30; ++l) {
                if (this.hsspark[n][k][l] == lastfr) {
                    contO.stg[k] = 1;
                    contO.sx[k] = this.hsx[n][k][l];
                    contO.sy[k] = this.hsy[n][k][l];
                    contO.sz[k] = this.hsz[n][k][l];
                    contO.osmag[k] = this.hsmag[n][k][l];
                    contO.scx[k] = this.hscx[n][k][l];
                    contO.scz[k] = this.hscz[n][k][l];
                }
            }
        }
        for (int n3 = 0; n3 < 200; ++n3) {
            if (this.hrspark[n][n3] == lastfr) {
                contO.sprk = this.hsprk[n][n3];
                contO.srx = this.hsrx[n][n3];
                contO.sry = this.hsry[n][n3];
                contO.srz = this.hsrz[n][n3];
                contO.rcx = this.hrcx[n][n3];
                contO.rcy = this.hrcy[n][n3];
                contO.rcz = this.hrcz[n][n3];
            }
        }
        for (int n4 = 0; n4 < 4; ++n4) {
            for (int n5 = 0; n5 < 7; ++n5) {
                if (this.hry[n][n4][n5] == lastfr && this.lastfr != lastfr) {
                    this.regy(n4, this.hmagy[n][n4][n5], this.hmtouch[n][n5], contO, mad);
                }
                if (this.hrx[n][n4][n5] == lastfr) {
                    if (this.lastfr != lastfr) {
                        this.regx(n4, this.hmagx[n][n4][n5], contO, mad);
                    }
                    else {
                        this.chipx(n4, this.hmagx[n][n4][n5], contO, mad);
                    }
                }
                if (this.hrz[n][n4][n5] == lastfr) {
                    if (this.lastfr != lastfr) {
                        this.regz(n4, this.hmagz[n][n4][n5], contO, mad);
                    }
                    else {
                        this.chipz(n4, this.hmagz[n][n4][n5], contO, mad);
                    }
                }
            }
        }
        this.lastfr = lastfr;
    }
    
    public void recy(final int n, final float n2, final boolean b, final int n3) {
        this.ry[n3][n][this.nry[n3][n]] = 300;
        this.magy[n3][n][this.nry[n3][n]] = (int)n2;
        this.mtouch[n3][this.nry[n3][n]] = b;
        final int[] array = this.nry[n3];
        ++array[n];
        if (this.nry[n3][n] == 7) {
            this.nry[n3][n] = 0;
        }
    }
    
    public void recx(final int n, final float n2, final int n3) {
        this.rx[n3][n][this.nry[n3][n]] = 300;
        this.magx[n3][n][this.nry[n3][n]] = (int)n2;
        final int[] array = this.nrx[n3];
        ++array[n];
        if (this.nrx[n3][n] == 7) {
            this.nrx[n3][n] = 0;
        }
    }
    
    public void recz(final int n, final float n2, final int n3) {
        this.rz[n3][n][this.nry[n3][n]] = 300;
        this.magz[n3][n][this.nry[n3][n]] = (int)n2;
        final int[] array = this.nrz[n3];
        ++array[n];
        if (this.nrz[n3][n] == 7) {
            this.nrz[n3][n] = 0;
        }
    }
    
    public void regy(final int n, float n2, final boolean b, final ContO contO, final Mad mad) {
        if (n2 > 100.0f) {
            n2 -= 100.0f;
            int n3 = 0;
            int n4 = 0;
            int i = contO.zy;
            int j = contO.xy;
            while (i < 360) {
                i += 360;
            }
            while (i > 360) {
                i -= 360;
            }
            if (i < 210 && i > 150) {
                n3 = -1;
            }
            if (i > 330 || i < 30) {
                n3 = 1;
            }
            while (j < 360) {
                j += 360;
            }
            while (j > 360) {
                j -= 360;
            }
            if (j < 210 && j > 150) {
                n4 = -1;
            }
            if (j > 330 || j < 30) {
                n4 = 1;
            }
            if (n4 * n3 == 0 || b) {
                for (int k = 0; k < contO.npl; ++k) {
                    float ctmag = 0.0f;
                    for (int l = 0; l < contO.p[k].n; ++l) {
                        if (contO.p[k].wz == 0 && this.py(contO.keyx[n], contO.p[k].ox[l], contO.keyz[n], contO.p[k].oz[l]) < mad.cd.clrad[mad.cn]) {
                            ctmag = n2 / 20.0f * this.m.random();
                            final int[] oz = contO.p[k].oz;
                            final int n5 = l;
                            oz[n5] += (int)(ctmag * this.m.sin(i));
                            final int[] ox = contO.p[k].ox;
                            final int n6 = l;
                            ox[n6] -= (int)(ctmag * this.m.sin(j));
                        }
                    }
                    if (ctmag != 0.0f) {
                        if (Math.abs(ctmag) >= 1.0f) {
                            contO.p[k].chip = 1;
                            contO.p[k].ctmag = ctmag;
                        }
                        if (!contO.p[k].nocol && contO.p[k].glass != 1) {
                            if (contO.p[k].bfase > 20 && contO.p[k].hsb[1] > 0.2) {
                                contO.p[k].hsb[1] = 0.2f;
                            }
                            if (contO.p[k].bfase > 30) {
                                if (contO.p[k].hsb[2] < 0.5) {
                                    contO.p[k].hsb[2] = 0.5f;
                                }
                                if (contO.p[k].hsb[1] > 0.1) {
                                    contO.p[k].hsb[1] = 0.1f;
                                }
                            }
                            if (contO.p[k].bfase > 40) {
                                contO.p[k].hsb[1] = 0.05f;
                            }
                            if (contO.p[k].bfase > 50) {
                                if (contO.p[k].hsb[2] > 0.8) {
                                    contO.p[k].hsb[2] = 0.8f;
                                }
                                contO.p[k].hsb[0] = 0.075f;
                                contO.p[k].hsb[1] = 0.05f;
                            }
                            if (contO.p[k].bfase > 60) {
                                contO.p[k].hsb[0] = 0.05f;
                            }
                            final Plane plane = contO.p[k];
                            plane.bfase += (int)ctmag;
                            new Color(contO.p[k].c[0], contO.p[k].c[1], contO.p[k].c[2]);
                            final Color hsbColor = Color.getHSBColor(contO.p[k].hsb[0], contO.p[k].hsb[1], contO.p[k].hsb[2]);
                            contO.p[k].c[0] = hsbColor.getRed();
                            contO.p[k].c[1] = hsbColor.getGreen();
                            contO.p[k].c[2] = hsbColor.getBlue();
                        }
                        if (contO.p[k].glass == 1) {
                            final Plane plane2 = contO.p[k];
                            plane2.gr += (int)Math.abs(ctmag * 1.5);
                        }
                    }
                }
            }
            if (n4 * n3 == -1) {
                int n7 = 0;
                int n8 = 1;
                for (int n9 = 0; n9 < contO.npl; ++n9) {
                    float ctmag2 = 0.0f;
                    for (int n10 = 0; n10 < contO.p[n9].n; ++n10) {
                        if (contO.p[n9].wz == 0) {
                            ctmag2 = n2 / 15.0f * this.m.random();
                            if ((Math.abs(contO.p[n9].oy[n10] - mad.cd.flipy[mad.cn] - this.squash[0][mad.im]) < mad.cd.msquash[mad.cn] * 3 || contO.p[n9].oy[n10] < mad.cd.flipy[mad.cn] + this.squash[0][mad.im]) && this.squash[0][mad.im] < mad.cd.msquash[mad.cn]) {
                                final int[] oy = contO.p[n9].oy;
                                final int n11 = n10;
                                oy[n11] += (int)ctmag2;
                                n7 += (int)ctmag2;
                                ++n8;
                            }
                        }
                    }
                    if (contO.p[n9].glass == 1) {
                        final Plane plane3 = contO.p[n9];
                        plane3.gr += 5;
                    }
                    else if (ctmag2 != 0.0f) {
                        final Plane plane4 = contO.p[n9];
                        plane4.bfase += (int)ctmag2;
                    }
                    if (Math.abs(ctmag2) >= 1.0f) {
                        contO.p[n9].chip = 1;
                        contO.p[n9].ctmag = ctmag2;
                    }
                }
                final int[] array = this.squash[0];
                final int im = mad.im;
                array[im] += n7 / n8;
            }
        }
    }
    
    public void regx(final int n, float n2, final ContO contO, final Mad mad) {
        if (Math.abs(n2) > 100.0f) {
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            for (int i = 0; i < contO.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < contO.p[i].n; ++j) {
                    if (contO.p[i].wz == 0 && this.py(contO.keyx[n], contO.p[i].ox[j], contO.keyz[n], contO.p[i].oz[j]) < mad.cd.clrad[mad.cn]) {
                        ctmag = n2 / 20.0f * this.m.random();
                        final int[] oz = contO.p[i].oz;
                        final int n3 = j;
                        oz[n3] -= (int)(ctmag * this.m.sin(contO.xz) * this.m.cos(contO.zy));
                        final int[] ox = contO.p[i].ox;
                        final int n4 = j;
                        ox[n4] += (int)(ctmag * this.m.cos(contO.xz) * this.m.cos(contO.xy));
                    }
                }
                if (ctmag != 0.0f) {
                    if (Math.abs(ctmag) >= 1.0f) {
                        contO.p[i].chip = 1;
                        contO.p[i].ctmag = ctmag;
                    }
                    if (!contO.p[i].nocol && contO.p[i].glass != 1) {
                        if (contO.p[i].bfase > 20 && contO.p[i].hsb[1] > 0.2) {
                            contO.p[i].hsb[1] = 0.2f;
                        }
                        if (contO.p[i].bfase > 30) {
                            if (contO.p[i].hsb[2] < 0.5) {
                                contO.p[i].hsb[2] = 0.5f;
                            }
                            if (contO.p[i].hsb[1] > 0.1) {
                                contO.p[i].hsb[1] = 0.1f;
                            }
                        }
                        if (contO.p[i].bfase > 40) {
                            contO.p[i].hsb[1] = 0.05f;
                        }
                        if (contO.p[i].bfase > 50) {
                            if (contO.p[i].hsb[2] > 0.8) {
                                contO.p[i].hsb[2] = 0.8f;
                            }
                            contO.p[i].hsb[0] = 0.075f;
                            contO.p[i].hsb[1] = 0.05f;
                        }
                        if (contO.p[i].bfase > 60) {
                            contO.p[i].hsb[0] = 0.05f;
                        }
                        final Plane plane = contO.p[i];
                        plane.bfase += (int)Math.abs(ctmag);
                        new Color(contO.p[i].c[0], contO.p[i].c[1], contO.p[i].c[2]);
                        final Color hsbColor = Color.getHSBColor(contO.p[i].hsb[0], contO.p[i].hsb[1], contO.p[i].hsb[2]);
                        contO.p[i].c[0] = hsbColor.getRed();
                        contO.p[i].c[1] = hsbColor.getGreen();
                        contO.p[i].c[2] = hsbColor.getBlue();
                    }
                    if (contO.p[i].glass == 1) {
                        final Plane plane2 = contO.p[i];
                        plane2.gr += (int)Math.abs(ctmag * 1.5);
                    }
                }
            }
        }
    }
    
    public void regz(final int n, float n2, final ContO contO, final Mad mad) {
        if (Math.abs(n2) > 100.0f) {
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            for (int i = 0; i < contO.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < contO.p[i].n; ++j) {
                    if (contO.p[i].wz == 0 && this.py(contO.keyx[n], contO.p[i].ox[j], contO.keyz[n], contO.p[i].oz[j]) < mad.cd.clrad[mad.cn]) {
                        ctmag = n2 / 20.0f * this.m.random();
                        final int[] oz = contO.p[i].oz;
                        final int n3 = j;
                        oz[n3] += (int)(ctmag * this.m.cos(contO.xz) * this.m.cos(contO.zy));
                        final int[] ox = contO.p[i].ox;
                        final int n4 = j;
                        ox[n4] += (int)(ctmag * this.m.sin(contO.xz) * this.m.cos(contO.xy));
                    }
                }
                if (ctmag != 0.0f) {
                    if (Math.abs(ctmag) >= 1.0f) {
                        contO.p[i].chip = 1;
                        contO.p[i].ctmag = ctmag;
                    }
                    if (!contO.p[i].nocol && contO.p[i].glass != 1) {
                        if (contO.p[i].bfase > 20 && contO.p[i].hsb[1] > 0.2) {
                            contO.p[i].hsb[1] = 0.2f;
                        }
                        if (contO.p[i].bfase > 30) {
                            if (contO.p[i].hsb[2] < 0.5) {
                                contO.p[i].hsb[2] = 0.5f;
                            }
                            if (contO.p[i].hsb[1] > 0.1) {
                                contO.p[i].hsb[1] = 0.1f;
                            }
                        }
                        if (contO.p[i].bfase > 40) {
                            contO.p[i].hsb[1] = 0.05f;
                        }
                        if (contO.p[i].bfase > 50) {
                            if (contO.p[i].hsb[2] > 0.8) {
                                contO.p[i].hsb[2] = 0.8f;
                            }
                            contO.p[i].hsb[0] = 0.075f;
                            contO.p[i].hsb[1] = 0.05f;
                        }
                        if (contO.p[i].bfase > 60) {
                            contO.p[i].hsb[0] = 0.05f;
                        }
                        final Plane plane = contO.p[i];
                        plane.bfase += (int)Math.abs(ctmag);
                        new Color(contO.p[i].c[0], contO.p[i].c[1], contO.p[i].c[2]);
                        final Color hsbColor = Color.getHSBColor(contO.p[i].hsb[0], contO.p[i].hsb[1], contO.p[i].hsb[2]);
                        contO.p[i].c[0] = hsbColor.getRed();
                        contO.p[i].c[1] = hsbColor.getGreen();
                        contO.p[i].c[2] = hsbColor.getBlue();
                    }
                    if (contO.p[i].glass == 1) {
                        final Plane plane2 = contO.p[i];
                        plane2.gr += (int)Math.abs(ctmag * 1.5);
                    }
                }
            }
        }
    }
    
    public void chipx(final int n, float n2, final ContO contO, final Mad mad) {
        if (Math.abs(n2) > 100.0f) {
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            for (int i = 0; i < contO.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < contO.p[i].n; ++j) {
                    if (contO.p[i].wz == 0 && this.py(contO.keyx[n], contO.p[i].ox[j], contO.keyz[n], contO.p[i].oz[j]) < mad.cd.clrad[mad.cn]) {
                        ctmag = n2 / 20.0f * this.m.random();
                    }
                }
                if (ctmag != 0.0f && Math.abs(ctmag) >= 1.0f) {
                    contO.p[i].chip = 1;
                    contO.p[i].ctmag = ctmag;
                }
            }
        }
    }
    
    public void chipz(final int n, float n2, final ContO contO, final Mad mad) {
        if (Math.abs(n2) > 100.0f) {
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            for (int i = 0; i < contO.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < contO.p[i].n; ++j) {
                    if (contO.p[i].wz == 0 && this.py(contO.keyx[n], contO.p[i].ox[j], contO.keyz[n], contO.p[i].oz[j]) < mad.cd.clrad[mad.cn]) {
                        ctmag = n2 / 20.0f * this.m.random();
                    }
                }
                if (ctmag != 0.0f && Math.abs(ctmag) >= 1.0f) {
                    contO.p[i].chip = 1;
                    contO.p[i].ctmag = ctmag;
                }
            }
        }
    }
    
    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
    }
}
