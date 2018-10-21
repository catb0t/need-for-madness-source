public class Wheels
{
    int ground;
    int mast;
    int sparkat;
    int[] rc;
    float size;
    float depth;
    
    public Wheels() {
        this.ground = 0;
        this.mast = 0;
        this.sparkat = 0;
        this.rc = new int[] { 120, 120, 120 };
        this.size = 2.0f;
        this.depth = 3.0f;
        this.sparkat = 0;
        this.ground = 0;
    }
    
    public void setrims(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.rc[0] = n;
        this.rc[1] = n2;
        this.rc[2] = n3;
        this.size = n4 / 10.0f;
        if (this.size < 0.0f) {
            this.size = 0.0f;
        }
        this.depth = n5 / 10.0f;
        if (this.depth / this.size > 41.0f) {
            this.depth = this.size * 41.0f;
        }
        if (this.depth / this.size < -25.0f) {
            this.depth = -(this.size * 25.0f);
        }
    }
    
    public void make(final Medium medium, final Trackers trackers, final Plane[] array, int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        final int[] array2 = new int[20];
        final int[] array3 = new int[20];
        final int[] array4 = new int[20];
        final int[] array5 = { 45, 45, 45 };
        int n9 = 0;
        final float n10 = n6 / 10.0f;
        final float n11 = n7 / 10.0f;
        if (n5 == 11) {
            n9 = (int)(n2 + 4.0f * n10);
        }
        this.sparkat = (int)(n11 * 24.0f);
        this.ground = (int)(n3 + 13.0f * n11);
        int n12 = -1;
        if (n2 < 0) {
            n12 = 1;
        }
        for (int i = 0; i < 20; ++i) {
            array2[i] = (int)(n2 - 4.0f * n10);
        }
        array3[0] = (int)(n3 - 9.1923f * n11);
        array4[0] = (int)(n4 + 9.1923f * n11);
        array3[1] = (int)(n3 - 12.557f * n11);
        array4[1] = (int)(n4 + 3.3646f * n11);
        array3[2] = (int)(n3 - 12.557f * n11);
        array4[2] = (int)(n4 - 3.3646f * n11);
        array3[3] = (int)(n3 - 9.1923f * n11);
        array4[3] = (int)(n4 - 9.1923f * n11);
        array3[4] = (int)(n3 - 3.3646f * n11);
        array4[4] = (int)(n4 - 12.557f * n11);
        array3[5] = (int)(n3 + 3.3646f * n11);
        array4[5] = (int)(n4 - 12.557f * n11);
        array3[6] = (int)(n3 + 9.1923f * n11);
        array4[6] = (int)(n4 - 9.1923f * n11);
        array3[7] = (int)(n3 + 12.557f * n11);
        array4[7] = (int)(n4 - 3.3646f * n11);
        array3[8] = (int)(n3 + 12.557f * n11);
        array4[8] = (int)(n4 + 3.3646f * n11);
        array3[9] = (int)(n3 + 9.1923f * n11);
        array4[9] = (int)(n4 + 9.1923f * n11);
        array3[10] = (int)(n3 + 3.3646f * n11);
        array4[10] = (int)(n4 + 12.557f * n11);
        array3[11] = (int)(n3 - 3.3646f * n11);
        array4[11] = (int)(n4 + 12.557f * n11);
        array3[12] = n3;
        array4[12] = (int)(n4 + 10.0f * this.size);
        array3[13] = (int)(n3 + 8.66 * this.size);
        array4[13] = (int)(n4 + 5.0f * this.size);
        array3[14] = (int)(n3 + 8.66 * this.size);
        array4[14] = (int)(n4 - 5.0f * this.size);
        array3[15] = n3;
        array4[15] = (int)(n4 - 10.0f * this.size);
        array3[16] = (int)(n3 - 8.66 * this.size);
        array4[16] = (int)(n4 - 5.0f * this.size);
        array3[17] = (int)(n3 - 8.66 * this.size);
        array4[17] = (int)(n4 + 5.0f * this.size);
        array3[18] = n3;
        array4[18] = (int)(n4 + 10.0f * this.size);
        array3[19] = (int)(n3 - 3.3646f * n11);
        array4[19] = (int)(n4 + 12.557f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 20, array5, 0, n8, 0, n9, n3, n4, 7, 0, false, 0, false);
        array[n].master = 1;
        ++n;
        array2[2] = (int)(n2 - this.depth * n10);
        array3[2] = n3;
        array4[2] = n4;
        int n13 = (int)(n8 - this.depth / this.size * 4.0f);
        if (n13 < -16) {
            n13 = -16;
        }
        array3[0] = n3;
        array4[0] = (int)(n4 + 10.0f * this.size);
        array3[1] = (int)(n3 + 8.66 * this.size);
        array4[1] = (int)(n4 + 5.0f * this.size);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n13, 0, n9, n3, n4, 7, 0, false, 0, false);
        if (this.depth / this.size < 7.0f) {
            array[n].master = 2;
        }
        ++n;
        array3[0] = (int)(n3 + 8.66 * this.size);
        array4[0] = (int)(n4 + 5.0f * this.size);
        array3[1] = (int)(n3 + 8.66 * this.size);
        array4[1] = (int)(n4 - 5.0f * this.size);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n13, 0, n9, n3, n4, 7, 0, false, 0, false);
        if (this.depth / this.size < 7.0f) {
            array[n].master = 2;
        }
        ++n;
        array3[0] = (int)(n3 + 8.66 * this.size);
        array4[0] = (int)(n4 - 5.0f * this.size);
        array3[1] = n3;
        array4[1] = (int)(n4 - 10.0f * this.size);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n13, 0, n9, n3, n4, 7, 0, false, 0, false);
        if (this.depth / this.size < 7.0f) {
            array[n].master = 2;
        }
        ++n;
        array3[0] = n3;
        array4[0] = (int)(n4 - 10.0f * this.size);
        array3[1] = (int)(n3 - 8.66 * this.size);
        array4[1] = (int)(n4 - 5.0f * this.size);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n13, 0, n9, n3, n4, 7, 0, false, 0, false);
        if (this.depth / this.size < 7.0f) {
            array[n].master = 2;
        }
        ++n;
        array3[0] = (int)(n3 - 8.66 * this.size);
        array4[0] = (int)(n4 - 5.0f * this.size);
        array3[1] = (int)(n3 - 8.66 * this.size);
        array4[1] = (int)(n4 + 5.0f * this.size);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n13, 0, n9, n3, n4, 7, 0, false, 0, false);
        if (this.depth / this.size < 7.0f) {
            array[n].master = 2;
        }
        ++n;
        array3[0] = (int)(n3 - 8.66 * this.size);
        array4[0] = (int)(n4 + 5.0f * this.size);
        array3[1] = n3;
        array4[1] = (int)(n4 + 10.0f * this.size);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n13, 0, n9, n3, n4, 7, 0, false, 0, false);
        if (this.depth / this.size < 7.0f) {
            array[n].master = 2;
        }
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 - 12.557f * n11);
        array4[0] = (int)(n4 + 3.3646f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 - 12.557f * n11);
        array4[1] = (int)(n4 - 3.3646f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 - 12.557f * n11);
        array4[2] = (int)(n4 - 3.3646f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 - 12.557f * n11);
        array4[3] = (int)(n4 + 3.3646f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, -1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 - 9.1923f * n11);
        array4[0] = (int)(n4 - 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 - 12.557f * n11);
        array4[1] = (int)(n4 - 3.3646f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 - 12.557f * n11);
        array4[2] = (int)(n4 - 3.3646f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 - 9.1923f * n11);
        array4[3] = (int)(n4 - 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 - 9.1923f * n11);
        array4[0] = (int)(n4 - 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 - 3.3646f * n11);
        array4[1] = (int)(n4 - 12.557f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 - 3.3646f * n11);
        array4[2] = (int)(n4 - 12.557f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 - 9.1923f * n11);
        array4[3] = (int)(n4 - 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 - 3.3646f * n11);
        array4[0] = (int)(n4 - 12.557f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 + 3.3646f * n11);
        array4[1] = (int)(n4 - 12.557f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 + 3.3646f * n11);
        array4[2] = (int)(n4 - 12.557f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 - 3.3646f * n11);
        array4[3] = (int)(n4 - 12.557f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, -1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 + 9.1923f * n11);
        array4[0] = (int)(n4 - 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 + 3.3646f * n11);
        array4[1] = (int)(n4 - 12.557f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 + 3.3646f * n11);
        array4[2] = (int)(n4 - 12.557f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 + 9.1923f * n11);
        array4[3] = (int)(n4 - 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 + 9.1923f * n11);
        array4[0] = (int)(n4 - 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 + 12.557f * n11);
        array4[1] = (int)(n4 - 3.3646f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 + 12.557f * n11);
        array4[2] = (int)(n4 - 3.3646f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 + 9.1923f * n11);
        array4[3] = (int)(n4 - 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 + 12.557f * n11);
        array4[0] = (int)(n4 - 3.3646f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 + 12.557f * n11);
        array4[1] = (int)(n4 + 3.3646f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 + 12.557f * n11);
        array4[2] = (int)(n4 + 3.3646f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 + 12.557f * n11);
        array4[3] = (int)(n4 - 3.3646f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, -1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 + 9.1923f * n11);
        array4[0] = (int)(n4 + 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 + 12.557f * n11);
        array4[1] = (int)(n4 + 3.3646f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 + 12.557f * n11);
        array4[2] = (int)(n4 + 3.3646f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 + 9.1923f * n11);
        array4[3] = (int)(n4 + 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 + 9.1923f * n11);
        array4[0] = (int)(n4 + 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 + 3.3646f * n11);
        array4[1] = (int)(n4 + 12.557f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 + 3.3646f * n11);
        array4[2] = (int)(n4 + 12.557f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 + 9.1923f * n11);
        array4[3] = (int)(n4 + 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 + 3.3646f * n11);
        array4[0] = (int)(n4 + 12.557f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 - 3.3646f * n11);
        array4[1] = (int)(n4 + 12.557f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 - 3.3646f * n11);
        array4[2] = (int)(n4 + 12.557f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 + 3.3646f * n11);
        array4[3] = (int)(n4 + 12.557f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, -1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 - 9.1923f * n11);
        array4[0] = (int)(n4 + 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 - 3.3646f * n11);
        array4[1] = (int)(n4 + 12.557f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 - 3.3646f * n11);
        array4[2] = (int)(n4 + 12.557f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 - 9.1923f * n11);
        array4[3] = (int)(n4 + 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
        array2[0] = (int)(n2 - 4.0f * n10);
        array3[0] = (int)(n3 - 9.1923f * n11);
        array4[0] = (int)(n4 + 9.1923f * n11);
        array2[1] = (int)(n2 - 4.0f * n10);
        array3[1] = (int)(n3 - 12.557f * n11);
        array4[1] = (int)(n4 + 3.3646f * n11);
        array2[2] = (int)(n2 + 4.0f * n10);
        array3[2] = (int)(n3 - 12.557f * n11);
        array4[2] = (int)(n4 + 3.3646f * n11);
        array2[3] = (int)(n2 + 4.0f * n10);
        array3[3] = (int)(n3 - 9.1923f * n11);
        array4[3] = (int)(n4 + 9.1923f * n11);
        array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 1 * n12, n9, n3, n4, 7, 0, false, 0, true);
        ++n;
    }
}
