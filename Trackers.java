public class Trackers
{
    int[] x;
    int[] y;
    int[] z;
    int[] xy;
    int[] zy;
    int[] skd;
    int[] dam;
    boolean[] notwall;
    boolean[] decor;
    int[][] c;
    int[] radx;
    int[] radz;
    int[] rady;
    int nt;
    int sx;
    int sz;
    int ncx;
    int ncz;
    int[][][] sect;
    
    public Trackers() {
        this.x = new int[6700];
        this.y = new int[6700];
        this.z = new int[6700];
        this.xy = new int[6700];
        this.zy = new int[6700];
        this.skd = new int[6700];
        this.dam = new int[6700];
        this.notwall = new boolean[6700];
        this.decor = new boolean[6700];
        this.c = new int[6700][3];
        this.radx = new int[6700];
        this.radz = new int[6700];
        this.rady = new int[6700];
        this.nt = 0;
        this.sx = 0;
        this.sz = 0;
        this.ncx = 0;
        this.ncz = 0;
        this.sect = null;
    }
    
    public void devidetrackers(final int sx, final int n, final int sz, final int n2) {
        this.sect = null;
        this.sx = sx;
        this.sz = sz;
        this.ncx = n / 3000;
        if (this.ncx <= 0) {
            this.ncx = 1;
        }
        this.ncz = n2 / 3000;
        if (this.ncz <= 0) {
            this.ncz = 1;
        }
        this.sect = new int[this.ncx][this.ncz][];
        for (int i = 0; i < this.ncx; ++i) {
            for (int j = 0; j < this.ncz; ++j) {
                final int n3 = this.sx + i * 3000 + 1500;
                final int n4 = this.sz + j * 3000 + 1500;
                final int[] array = new int[6700];
                int n5 = 0;
                for (int k = 0; k < this.nt; ++k) {
                    final int py = this.py(n3, this.x[k], n4, this.z[k]);
                    if (py < 20250000 && py > 0 && this.dam[k] != 167) {
                        array[n5] = k;
                        ++n5;
                    }
                }
                if (i == 0 || j == 0 || i == this.ncx - 1 || j == this.ncz - 1) {
                    for (int l = 0; l < this.nt; ++l) {
                        if (this.dam[l] == 167) {
                            array[n5] = l;
                            ++n5;
                        }
                    }
                }
                if (n5 == 0) {
                    array[n5] = 0;
                    ++n5;
                }
                this.sect[i][j] = new int[n5];
                for (int n6 = 0; n6 < n5; ++n6) {
                    this.sect[i][j][n6] = array[n6];
                }
            }
        }
        for (int n7 = 0; n7 < this.nt; ++n7) {
            if (this.dam[n7] == 167) {
                this.dam[n7] = 1;
            }
        }
        --this.ncx;
        --this.ncz;
    }
    
    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
    }
}
