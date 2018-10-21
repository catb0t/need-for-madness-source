public class CheckPoints
{
    int[] x;
    int[] z;
    int[] y;
    int[] typ;
    int pcs;
    int nsp;
    int n;
    int[] fx;
    int[] fz;
    int[] fy;
    boolean[] roted;
    boolean[] special;
    int fn;
    int stage;
    int nlaps;
    int nfix;
    boolean notb;
    String name;
    String maker;
    int pubt;
    String trackname;
    int trackvol;
    int top20;
    int nto;
    int[] pos;
    int[] clear;
    int[] dested;
    float[] magperc;
    int wasted;
    boolean haltall;
    int pcleared;
    int[] opx;
    int[] opz;
    int[] onscreen;
    int[] omxz;
    int catchfin;
    int postwo;
    float prox;
    
    public CheckPoints() {
        this.x = new int[140];
        this.z = new int[140];
        this.y = new int[140];
        this.typ = new int[140];
        this.pcs = 0;
        this.nsp = 0;
        this.n = 0;
        this.fx = new int[5];
        this.fz = new int[5];
        this.fy = new int[5];
        this.roted = new boolean[5];
        this.special = new boolean[5];
        this.fn = 0;
        this.stage = (int)(Math.random() * 27.0) + 1;
        this.nlaps = 0;
        this.nfix = 0;
        this.notb = false;
        this.name = "hogan rewish";
        this.maker = "";
        this.pubt = 0;
        this.trackname = "";
        this.trackvol = 200;
        this.top20 = 0;
        this.nto = 0;
        this.pos = new int[] { 7, 7, 7, 7, 7, 7, 7, 7 };
        this.clear = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.dested = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        this.magperc = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.wasted = 0;
        this.haltall = false;
        this.pcleared = 0;
        this.opx = new int[8];
        this.opz = new int[8];
        this.onscreen = new int[8];
        this.omxz = new int[8];
        this.catchfin = 0;
        this.postwo = 0;
        this.prox = 0.0f;
    }
    
    public void checkstat(final Mad[] array, final ContO[] array2, final Record record, final int n, final int n2, final int n3) {
        if (!this.haltall) {
            this.pcleared = array[n2].pcleared;
            for (int i = 0; i < n; ++i) {
                this.magperc[i] = array[i].hitmag / array[i].cd.maxmag[array[i].cn];
                if (this.magperc[i] > 1.0f) {
                    this.magperc[i] = 1.0f;
                }
                this.pos[i] = 0;
                this.onscreen[i] = array2[i].dist;
                this.opx[i] = array2[i].x;
                this.opz[i] = array2[i].z;
                this.omxz[i] = array[i].mxz;
                if (this.dested[i] == 0) {
                    this.clear[i] = array[i].clear;
                }
                else {
                    this.clear[i] = -1;
                }
                array[i].outshakedam = array[i].shakedam;
                array[i].shakedam = 0;
            }
            for (int j = 0; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (this.clear[j] != this.clear[k]) {
                        if (this.clear[j] < this.clear[k]) {
                            final int[] pos = this.pos;
                            final int n4 = j;
                            ++pos[n4];
                        }
                        else {
                            final int[] pos2 = this.pos;
                            final int n5 = k;
                            ++pos2[n5];
                        }
                    }
                    else {
                        int n6 = array[j].pcleared + 1;
                        if (n6 >= this.n) {
                            n6 = 0;
                        }
                        while (this.typ[n6] <= 0) {
                            if (++n6 >= this.n) {
                                n6 = 0;
                            }
                        }
                        if (this.py(array2[j].x / 100, this.x[n6] / 100, array2[j].z / 100, this.z[n6] / 100) > this.py(array2[k].x / 100, this.x[n6] / 100, array2[k].z / 100, this.z[n6] / 100)) {
                            final int[] pos3 = this.pos;
                            final int n7 = j;
                            ++pos3[n7];
                        }
                        else {
                            final int[] pos4 = this.pos;
                            final int n8 = k;
                            ++pos4[n8];
                        }
                    }
                }
            }
            if (this.stage > 2) {
                for (int l = 0; l < n; ++l) {
                    if (this.clear[l] == this.nlaps * this.nsp && this.pos[l] == 0) {
                        if (l == n2) {
                            for (int postwo = 0; postwo < n; ++postwo) {
                                if (this.pos[postwo] == 1) {
                                    this.postwo = postwo;
                                }
                            }
                            if (this.py(this.opx[n2] / 100, this.opx[this.postwo] / 100, this.opz[n2] / 100, this.opz[this.postwo] / 100) < 14000 && this.clear[n2] - this.clear[this.postwo] == 1) {
                                this.catchfin = 30;
                            }
                        }
                        else if (this.pos[n2] == 1 && this.py(this.opx[n2] / 100, this.opx[l] / 100, this.opz[n2] / 100, this.opz[l] / 100) < 14000 && this.clear[l] - this.clear[n2] == 1) {
                            this.catchfin = 30;
                            this.postwo = l;
                        }
                    }
                }
            }
        }
        this.wasted = 0;
        for (int n9 = 0; n9 < n; ++n9) {
            if ((n2 != n9 || n3 >= 2) && array[n9].dest) {
                ++this.wasted;
            }
        }
        if (this.catchfin != 0 && n3 < 2) {
            --this.catchfin;
            if (this.catchfin == 0) {
                record.cotchinow(this.postwo);
                record.closefinish = this.pos[n2] + 1;
            }
        }
    }
    
    public void calprox() {
        int n = 0;
        for (int i = 0; i < this.n - 1; ++i) {
            for (int j = i + 1; j < this.n; ++j) {
                if (Math.abs(this.x[i] - this.x[j]) > n) {
                    n = Math.abs(this.x[i] - this.x[j]);
                }
                if (Math.abs(this.z[i] - this.z[j]) > n) {
                    n = Math.abs(this.z[i] - this.z[j]);
                }
            }
        }
        this.prox = n / 90.0f;
    }
    
    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
    }
}
