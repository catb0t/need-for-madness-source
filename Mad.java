import java.awt.Color;

public class Mad
{
    Medium m;
    Record rpd;
    xtGraphics xt;
    int cn;
    int im;
    int mxz;
    int cxz;
    CarDefine cd;
    boolean[] dominate;
    boolean[] caught;
    int pzy;
    int pxy;
    float speed;
    float forca;
    float[] scy;
    float[] scz;
    float[] scx;
    float drag;
    boolean mtouch;
    boolean wtouch;
    int cntouch;
    boolean capsized;
    int txz;
    int fxz;
    int pmlt;
    int nmlt;
    int dcnt;
    int skid;
    boolean pushed;
    boolean gtouch;
    boolean pl;
    boolean pr;
    boolean pd;
    boolean pu;
    int loop;
    float ucomp;
    float dcomp;
    float lcomp;
    float rcomp;
    int lxz;
    int travxy;
    int travzy;
    int travxz;
    int trcnt;
    int capcnt;
    int srfcnt;
    boolean rtab;
    boolean ftab;
    boolean btab;
    boolean surfer;
    float powerup;
    int xtpower;
    float tilt;
    int[][] crank;
    int[][] lcrank;
    int squash;
    int nbsq;
    int hitmag;
    int cntdest;
    boolean dest;
    boolean newcar;
    int pan;
    int pcleared;
    int clear;
    int nlaps;
    int focus;
    float power;
    int missedcp;
    int lastcolido;
    int point;
    boolean nofocus;
    int rpdcatch;
    int newedcar;
    int fixes;
    int shakedam;
    int outshakedam;
    boolean colidim;
    
    public Mad(final CarDefine cd, final Medium m, final Record rpd, final xtGraphics xt, final int im) {
        this.cn = 0;
        this.im = 0;
        this.mxz = 0;
        this.cxz = 0;
        this.dominate = new boolean[8];
        this.caught = new boolean[8];
        this.pzy = 0;
        this.pxy = 0;
        this.speed = 0.0f;
        this.forca = 0.0f;
        this.scy = new float[4];
        this.scz = new float[4];
        this.scx = new float[4];
        this.drag = 0.5f;
        this.mtouch = false;
        this.wtouch = false;
        this.cntouch = 0;
        this.capsized = false;
        this.txz = 0;
        this.fxz = 0;
        this.pmlt = 1;
        this.nmlt = 1;
        this.dcnt = 0;
        this.skid = 0;
        this.pushed = false;
        this.gtouch = false;
        this.pl = false;
        this.pr = false;
        this.pd = false;
        this.pu = false;
        this.loop = 0;
        this.ucomp = 0.0f;
        this.dcomp = 0.0f;
        this.lcomp = 0.0f;
        this.rcomp = 0.0f;
        this.lxz = 0;
        this.travxy = 0;
        this.travzy = 0;
        this.travxz = 0;
        this.trcnt = 0;
        this.capcnt = 0;
        this.srfcnt = 0;
        this.rtab = false;
        this.ftab = false;
        this.btab = false;
        this.surfer = false;
        this.powerup = 0.0f;
        this.xtpower = 0;
        this.tilt = 0.0f;
        this.crank = new int[4][4];
        this.lcrank = new int[4][4];
        this.squash = 0;
        this.nbsq = 0;
        this.hitmag = 0;
        this.cntdest = 0;
        this.dest = false;
        this.newcar = false;
        this.pan = 0;
        this.pcleared = 0;
        this.clear = 0;
        this.nlaps = 0;
        this.focus = -1;
        this.power = 75.0f;
        this.missedcp = 0;
        this.lastcolido = 0;
        this.point = 0;
        this.nofocus = false;
        this.rpdcatch = 0;
        this.newedcar = 0;
        this.fixes = -1;
        this.shakedam = 0;
        this.outshakedam = 0;
        this.colidim = false;
        this.cd = cd;
        this.m = m;
        this.rpd = rpd;
        this.xt = xt;
        this.im = im;
    }
    
    public void reseto(final int cn, final ContO contO, final CheckPoints checkPoints) {
        this.cn = cn;
        for (int i = 0; i < 8; ++i) {
            this.dominate[i] = false;
            this.caught[i] = false;
        }
        this.mxz = 0;
        this.cxz = 0;
        this.pzy = 0;
        this.pxy = 0;
        this.speed = 0.0f;
        for (int j = 0; j < 4; ++j) {
            this.scy[j] = 0.0f;
            this.scx[j] = 0.0f;
            this.scz[j] = 0.0f;
        }
        this.forca = ((float)Math.sqrt(contO.keyz[0] * contO.keyz[0] + contO.keyx[0] * contO.keyx[0]) + (float)Math.sqrt(contO.keyz[1] * contO.keyz[1] + contO.keyx[1] * contO.keyx[1]) + (float)Math.sqrt(contO.keyz[2] * contO.keyz[2] + contO.keyx[2] * contO.keyx[2]) + (float)Math.sqrt(contO.keyz[3] * contO.keyz[3] + contO.keyx[3] * contO.keyx[3])) / 10000.0f * (float)(this.cd.bounce[this.cn] - 0.3);
        this.mtouch = false;
        this.wtouch = false;
        this.txz = 0;
        this.fxz = 0;
        this.pmlt = 1;
        this.nmlt = 1;
        this.dcnt = 0;
        this.skid = 0;
        this.pushed = false;
        this.gtouch = false;
        this.pl = false;
        this.pr = false;
        this.pd = false;
        this.pu = false;
        this.loop = 0;
        this.ucomp = 0.0f;
        this.dcomp = 0.0f;
        this.lcomp = 0.0f;
        this.rcomp = 0.0f;
        this.lxz = 0;
        this.travxy = 0;
        this.travzy = 0;
        this.travxz = 0;
        this.rtab = false;
        this.ftab = false;
        this.btab = false;
        this.powerup = 0.0f;
        this.xtpower = 0;
        this.trcnt = 0;
        this.capcnt = 0;
        this.tilt = 0.0f;
        for (int k = 0; k < 4; ++k) {
            for (int l = 0; l < 4; ++l) {
                this.crank[k][l] = 0;
                this.lcrank[k][l] = 0;
            }
        }
        this.pan = 0;
        this.pcleared = checkPoints.pcs;
        this.clear = 0;
        this.nlaps = 0;
        this.focus = -1;
        this.missedcp = 0;
        this.nofocus = false;
        this.power = 98.0f;
        this.lastcolido = 0;
        checkPoints.dested[this.im] = 0;
        this.squash = 0;
        this.nbsq = 0;
        this.hitmag = 0;
        this.cntdest = 0;
        this.dest = false;
        this.newcar = false;
        if (this.im == this.xt.im) {
            this.m.checkpoint = -1;
            this.m.lastcheck = false;
        }
        this.rpdcatch = 0;
        this.newedcar = 0;
        this.fixes = -1;
        if (checkPoints.nfix == 1) {
            this.fixes = 4;
        }
        if (checkPoints.nfix == 2) {
            this.fixes = 3;
        }
        if (checkPoints.nfix == 3) {
            this.fixes = 2;
        }
        if (checkPoints.nfix == 4) {
            this.fixes = 1;
        }
    }
    
    public void drive(final Control control, final ContO contO, final Trackers trackers, final CheckPoints checkPoints) {
        int n = 1;
        int n2 = 1;
        boolean zyinv = false;
        boolean b = false;
        boolean b2 = false;
        this.capsized = false;
        int i;
        for (i = Math.abs(this.pzy); i > 270; i -= 360) {}
        if (Math.abs(i) > 90) {
            zyinv = true;
        }
        int n3 = 0;
        int j;
        for (j = Math.abs(this.pxy); j > 270; j -= 360) {}
        if (Math.abs(j) > 90) {
            n3 = 1;
            n2 = -1;
        }
        int grat = contO.grat;
        if (zyinv) {
            if (n3 != 0) {
                n3 = 0;
                b = true;
            }
            else {
                n3 = 1;
                this.capsized = true;
            }
            n = -1;
        }
        else if (n3 != 0) {
            this.capsized = true;
        }
        if (this.capsized) {
            grat = this.cd.flipy[this.cn] + this.squash;
        }
        control.zyinv = zyinv;
        float n4 = 0.0f;
        float n5 = 0.0f;
        float n6 = 0.0f;
        if (this.mtouch) {
            this.loop = 0;
        }
        if (this.wtouch) {
            if (this.loop == 2 || this.loop == -1) {
                this.loop = -1;
                if (control.left) {
                    this.pl = true;
                }
                if (control.right) {
                    this.pr = true;
                }
                if (control.up) {
                    this.pu = true;
                }
                if (control.down) {
                    this.pd = true;
                }
            }
            this.ucomp = 0.0f;
            this.dcomp = 0.0f;
            this.lcomp = 0.0f;
            this.rcomp = 0.0f;
        }
        if (control.handb) {
            if (!this.pushed) {
                if (!this.wtouch) {
                    if (this.loop == 0) {
                        this.loop = 1;
                    }
                }
                else if (this.gtouch) {
                    this.pushed = true;
                }
            }
        }
        else {
            this.pushed = false;
        }
        if (this.loop == 1) {
            final float n7 = (this.scy[0] + this.scy[1] + this.scy[2] + this.scy[3]) / 4.0f;
            for (int k = 0; k < 4; ++k) {
                this.scy[k] = n7;
            }
            this.loop = 2;
        }
        if (!this.dest) {
            if (this.loop == 2) {
                if (control.up) {
                    if (this.ucomp == 0.0f) {
                        this.ucomp = 10.0f + (this.scy[0] + 50.0f) / 20.0f;
                        if (this.ucomp < 5.0f) {
                            this.ucomp = 5.0f;
                        }
                        if (this.ucomp > 10.0f) {
                            this.ucomp = 10.0f;
                        }
                        this.ucomp *= this.cd.airs[this.cn];
                    }
                    if (this.ucomp < 20.0f) {
                        this.ucomp += (float)(0.5 * this.cd.airs[this.cn]);
                    }
                    n4 = -this.cd.airc[this.cn] * this.m.sin(contO.xz) * n2;
                    n5 = this.cd.airc[this.cn] * this.m.cos(contO.xz) * n2;
                }
                else if (this.ucomp != 0.0f && this.ucomp > -2.0f) {
                    this.ucomp -= (float)(0.5 * this.cd.airs[this.cn]);
                }
                if (control.down) {
                    if (this.dcomp == 0.0f) {
                        this.dcomp = 10.0f + (this.scy[0] + 50.0f) / 20.0f;
                        if (this.dcomp < 5.0f) {
                            this.dcomp = 5.0f;
                        }
                        if (this.dcomp > 10.0f) {
                            this.dcomp = 10.0f;
                        }
                        this.dcomp *= this.cd.airs[this.cn];
                    }
                    if (this.dcomp < 20.0f) {
                        this.dcomp += (float)(0.5 * this.cd.airs[this.cn]);
                    }
                    n6 = -this.cd.airc[this.cn];
                }
                else if (this.dcomp != 0.0f && this.ucomp > -2.0f) {
                    this.dcomp -= (float)(0.5 * this.cd.airs[this.cn]);
                }
                if (control.left) {
                    if (this.lcomp == 0.0f) {
                        this.lcomp = 5.0f;
                    }
                    if (this.lcomp < 20.0f) {
                        this.lcomp += 2.0f * this.cd.airs[this.cn];
                    }
                    n4 = -this.cd.airc[this.cn] * this.m.cos(contO.xz) * n;
                    n5 = -this.cd.airc[this.cn] * this.m.sin(contO.xz) * n;
                }
                else if (this.lcomp > 0.0f) {
                    this.lcomp -= 2.0f * this.cd.airs[this.cn];
                }
                if (control.right) {
                    if (this.rcomp == 0.0f) {
                        this.rcomp = 5.0f;
                    }
                    if (this.rcomp < 20.0f) {
                        this.rcomp += 2.0f * this.cd.airs[this.cn];
                    }
                    n4 = this.cd.airc[this.cn] * this.m.cos(contO.xz) * n;
                    n5 = this.cd.airc[this.cn] * this.m.sin(contO.xz) * n;
                }
                else if (this.rcomp > 0.0f) {
                    this.rcomp -= 2.0f * this.cd.airs[this.cn];
                }
                this.pzy += (int)((this.dcomp - this.ucomp) * this.m.cos(this.pxy));
                if (zyinv) {
                    contO.xz += (int)((this.dcomp - this.ucomp) * this.m.sin(this.pxy));
                }
                else {
                    contO.xz -= (int)((this.dcomp - this.ucomp) * this.m.sin(this.pxy));
                }
                this.pxy += (int)(this.rcomp - this.lcomp);
            }
            else {
                float power = this.power;
                if (power < 40.0f) {
                    power = 40.0f;
                }
                if (control.down) {
                    if (this.speed > 0.0f) {
                        this.speed -= this.cd.handb[this.cn] / 2;
                    }
                    else {
                        int n8 = 0;
                        for (int l = 0; l < 2; ++l) {
                            if (this.speed <= -(this.cd.swits[this.cn][l] / 2 + power * this.cd.swits[this.cn][l] / 196.0f)) {
                                ++n8;
                            }
                        }
                        if (n8 != 2) {
                            this.speed -= this.cd.acelf[this.cn][n8] / 2.0f + power * this.cd.acelf[this.cn][n8] / 196.0f;
                        }
                        else {
                            this.speed = -(this.cd.swits[this.cn][1] / 2 + power * this.cd.swits[this.cn][1] / 196.0f);
                        }
                    }
                }
                if (control.up) {
                    if (this.speed < 0.0f) {
                        this.speed += this.cd.handb[this.cn];
                    }
                    else {
                        int n9 = 0;
                        for (int n10 = 0; n10 < 3; ++n10) {
                            if (this.speed >= this.cd.swits[this.cn][n10] / 2 + power * this.cd.swits[this.cn][n10] / 196.0f) {
                                ++n9;
                            }
                        }
                        if (n9 != 3) {
                            this.speed += this.cd.acelf[this.cn][n9] / 2.0f + power * this.cd.acelf[this.cn][n9] / 196.0f;
                        }
                        else {
                            this.speed = this.cd.swits[this.cn][2] / 2 + power * this.cd.swits[this.cn][2] / 196.0f;
                        }
                    }
                }
                if (control.handb && Math.abs(this.speed) > this.cd.handb[this.cn]) {
                    if (this.speed < 0.0f) {
                        this.speed += this.cd.handb[this.cn];
                    }
                    else {
                        this.speed -= this.cd.handb[this.cn];
                    }
                }
                if (this.loop == -1 && contO.y < 100) {
                    if (control.left) {
                        if (!this.pl) {
                            if (this.lcomp == 0.0f) {
                                this.lcomp = 5.0f * this.cd.airs[this.cn];
                            }
                            if (this.lcomp < 20.0f) {
                                this.lcomp += 2.0f * this.cd.airs[this.cn];
                            }
                        }
                    }
                    else {
                        if (this.lcomp > 0.0f) {
                            this.lcomp -= 2.0f * this.cd.airs[this.cn];
                        }
                        this.pl = false;
                    }
                    if (control.right) {
                        if (!this.pr) {
                            if (this.rcomp == 0.0f) {
                                this.rcomp = 5.0f * this.cd.airs[this.cn];
                            }
                            if (this.rcomp < 20.0f) {
                                this.rcomp += 2.0f * this.cd.airs[this.cn];
                            }
                        }
                    }
                    else {
                        if (this.rcomp > 0.0f) {
                            this.rcomp -= 2.0f * this.cd.airs[this.cn];
                        }
                        this.pr = false;
                    }
                    if (control.up) {
                        if (!this.pu) {
                            if (this.ucomp == 0.0f) {
                                this.ucomp = 5.0f * this.cd.airs[this.cn];
                            }
                            if (this.ucomp < 20.0f) {
                                this.ucomp += 2.0f * this.cd.airs[this.cn];
                            }
                        }
                    }
                    else {
                        if (this.ucomp > 0.0f) {
                            this.ucomp -= 2.0f * this.cd.airs[this.cn];
                        }
                        this.pu = false;
                    }
                    if (control.down) {
                        if (!this.pd) {
                            if (this.dcomp == 0.0f) {
                                this.dcomp = 5.0f * this.cd.airs[this.cn];
                            }
                            if (this.dcomp < 20.0f) {
                                this.dcomp += 2.0f * this.cd.airs[this.cn];
                            }
                        }
                    }
                    else {
                        if (this.dcomp > 0.0f) {
                            this.dcomp -= 2.0f * this.cd.airs[this.cn];
                        }
                        this.pd = false;
                    }
                    this.pzy += (int)((this.dcomp - this.ucomp) * this.m.cos(this.pxy));
                    if (zyinv) {
                        contO.xz += (int)((this.dcomp - this.ucomp) * this.m.sin(this.pxy));
                    }
                    else {
                        contO.xz -= (int)((this.dcomp - this.ucomp) * this.m.sin(this.pxy));
                    }
                    this.pxy += (int)(this.rcomp - this.lcomp);
                }
            }
        }
        float n11 = 20.0f * this.speed / (154.0f * this.cd.simag[this.cn]);
        if (n11 > 20.0f) {
            n11 = 20.0f;
        }
        contO.wzy -= (int)n11;
        if (contO.wzy < -30) {
            contO.wzy += 30;
        }
        if (contO.wzy > 30) {
            contO.wzy -= 30;
        }
        if (control.right) {
            contO.wxz -= this.cd.turn[this.cn];
            if (contO.wxz < -36) {
                contO.wxz = -36;
            }
        }
        if (control.left) {
            contO.wxz += this.cd.turn[this.cn];
            if (contO.wxz > 36) {
                contO.wxz = 36;
            }
        }
        if (contO.wxz != 0 && !control.left && !control.right) {
            if (Math.abs(this.speed) < 10.0f) {
                if (Math.abs(contO.wxz) == 1) {
                    contO.wxz = 0;
                }
                if (contO.wxz > 0) {
                    --contO.wxz;
                }
                if (contO.wxz < 0) {
                    ++contO.wxz;
                }
            }
            else {
                if (Math.abs(contO.wxz) < this.cd.turn[this.cn] * 2) {
                    contO.wxz = 0;
                }
                if (contO.wxz > 0) {
                    contO.wxz -= this.cd.turn[this.cn] * 2;
                }
                if (contO.wxz < 0) {
                    contO.wxz += this.cd.turn[this.cn] * 2;
                }
            }
        }
        int n12 = (int)(3600.0f / (this.speed * this.speed));
        if (n12 < 5) {
            n12 = 5;
        }
        if (this.speed < 0.0f) {
            n12 = -n12;
        }
        if (this.wtouch) {
            if (!this.capsized) {
                if (!control.handb) {
                    this.fxz = contO.wxz / (n12 * 3);
                }
                else {
                    this.fxz = contO.wxz / n12;
                }
                contO.xz += contO.wxz / n12;
            }
            this.wtouch = false;
            this.gtouch = false;
        }
        else {
            contO.xz += this.fxz;
        }
        if (this.speed > 30.0f || this.speed < -100.0f) {
            while (Math.abs(this.mxz - this.cxz) > 180) {
                if (this.cxz > this.mxz) {
                    this.cxz -= 360;
                }
                else {
                    if (this.cxz >= this.mxz) {
                        continue;
                    }
                    this.cxz += 360;
                }
            }
            if (Math.abs(this.mxz - this.cxz) < 30) {
                this.cxz += (int)((this.mxz - this.cxz) / 4.0f);
            }
            else {
                if (this.cxz > this.mxz) {
                    this.cxz -= 10;
                }
                if (this.cxz < this.mxz) {
                    this.cxz += 10;
                }
            }
        }
        final float[] array = new float[4];
        final float[] array2 = new float[4];
        final float[] array3 = new float[4];
        for (int n13 = 0; n13 < 4; ++n13) {
            array[n13] = contO.keyx[n13] + contO.x;
            array3[n13] = grat + contO.y;
            array2[n13] = contO.z + contO.keyz[n13];
            final float[] scy = this.scy;
            final int n14 = n13;
            scy[n14] += 7.0f;
        }
        this.rot(array, array3, contO.x, contO.y, this.pxy, 4);
        this.rot(array3, array2, contO.y, contO.z, this.pzy, 4);
        this.rot(array, array2, contO.x, contO.z, contO.xz, 4);
        boolean b3 = false;
        final int n15 = (int)((this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0f);
        final int n16 = (int)((this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0f);
        for (int n17 = 0; n17 < 4; ++n17) {
            if (this.scx[n17] - n15 > 200.0f) {
                this.scx[n17] = 200 + n15;
            }
            if (this.scx[n17] - n15 < -200.0f) {
                this.scx[n17] = n15 - 200;
            }
            if (this.scz[n17] - n16 > 200.0f) {
                this.scz[n17] = 200 + n16;
            }
            if (this.scz[n17] - n16 < -200.0f) {
                this.scz[n17] = n16 - 200;
            }
        }
        for (int n18 = 0; n18 < 4; ++n18) {
            final float[] array4 = array3;
            final int n19 = n18;
            array4[n19] += this.scy[n18];
            final float[] array5 = array;
            final int n20 = n18;
            array5[n20] += (this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0f;
            final float[] array6 = array2;
            final int n21 = n18;
            array6[n21] += (this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0f;
        }
        int ncx = (contO.x - trackers.sx) / 3000;
        if (ncx > trackers.ncx) {
            ncx = trackers.ncx;
        }
        if (ncx < 0) {
            ncx = 0;
        }
        int ncz = (contO.z - trackers.sz) / 3000;
        if (ncz > trackers.ncz) {
            ncz = trackers.ncz;
        }
        if (ncz < 0) {
            ncz = 0;
        }
        int n22 = 1;
        for (int n23 = 0; n23 < trackers.sect[ncx][ncz].length; ++n23) {
            final int n24 = trackers.sect[ncx][ncz][n23];
            if (Math.abs(trackers.zy[n24]) != 90 && Math.abs(trackers.xy[n24]) != 90 && Math.abs(contO.x - trackers.x[n24]) < trackers.radx[n24] && Math.abs(contO.z - trackers.z[n24]) < trackers.radz[n24] && (!trackers.decor[n24] || this.m.resdown != 2 || this.xt.multion != 0)) {
                n22 = trackers.skd[n24];
            }
        }
        if (this.mtouch) {
            float n25 = this.cd.grip[this.cn] - Math.abs(this.txz - contO.xz) * this.speed / 250.0f;
            if (control.handb) {
                n25 -= Math.abs(this.txz - contO.xz) * 4;
            }
            if (n25 < this.cd.grip[this.cn]) {
                if (this.skid != 2) {
                    this.skid = 1;
                }
                this.speed -= this.speed / 100.0f;
            }
            else if (this.skid == 1) {
                this.skid = 2;
            }
            if (n22 == 1) {
                n25 *= 0.75;
            }
            if (n22 == 2) {
                n25 *= 0.55;
            }
            int n26 = -(int)(this.speed * this.m.sin(contO.xz) * this.m.cos(this.pzy));
            int n27 = (int)(this.speed * this.m.cos(contO.xz) * this.m.cos(this.pzy));
            int n28 = -(int)(this.speed * this.m.sin(this.pzy));
            if (this.capsized || this.dest || checkPoints.haltall) {
                n26 = 0;
                n27 = 0;
                n28 = 0;
                n25 = this.cd.grip[this.cn] / 5.0f;
                if (this.speed > 0.0f) {
                    this.speed -= 2.0f;
                }
                else {
                    this.speed += 2.0f;
                }
            }
            if (Math.abs(this.speed) > this.drag) {
                if (this.speed > 0.0f) {
                    this.speed -= this.drag;
                }
                else {
                    this.speed += this.drag;
                }
            }
            else {
                this.speed = 0.0f;
            }
            if (this.cn == 8 && n25 < 5.0f) {
                n25 = 5.0f;
            }
            if (n25 < 1.0f) {
                n25 = 1.0f;
            }
            float n29 = 0.0f;
            float n30 = 0.0f;
            for (int n31 = 0; n31 < 4; ++n31) {
                if (Math.abs(this.scx[n31] - n26) > n25) {
                    if (this.scx[n31] < n26) {
                        final float[] scx = this.scx;
                        final int n32 = n31;
                        scx[n32] += n25;
                    }
                    else {
                        final float[] scx2 = this.scx;
                        final int n33 = n31;
                        scx2[n33] -= n25;
                    }
                }
                else {
                    this.scx[n31] = n26;
                }
                if (Math.abs(this.scz[n31] - n27) > n25) {
                    if (this.scz[n31] < n27) {
                        final float[] scz = this.scz;
                        final int n34 = n31;
                        scz[n34] += n25;
                    }
                    else {
                        final float[] scz2 = this.scz;
                        final int n35 = n31;
                        scz2[n35] -= n25;
                    }
                }
                else {
                    this.scz[n31] = n27;
                }
                if (Math.abs(this.scy[n31] - n28) > n25) {
                    if (this.scy[n31] < n28) {
                        final float[] scy2 = this.scy;
                        final int n36 = n31;
                        scy2[n36] += n25;
                    }
                    else {
                        final float[] scy3 = this.scy;
                        final int n37 = n31;
                        scy3[n37] -= n25;
                    }
                }
                else {
                    this.scy[n31] = n28;
                }
                if (n25 < this.cd.grip[this.cn]) {
                    if (this.txz != contO.xz) {
                        ++this.dcnt;
                    }
                    else if (this.dcnt != 0) {
                        this.dcnt = 0;
                    }
                    if (this.dcnt > 40.0f * n25 / this.cd.grip[this.cn] || this.capsized) {
                        float n38 = 1.0f;
                        if (n22 != 0) {
                            n38 = 1.2f;
                        }
                        if (this.m.random() > 0.65) {
                            contO.dust(n31, array[n31], array3[n31], array2[n31], (int)this.scx[n31], (int)this.scz[n31], n38 * this.cd.simag[this.cn], (int)this.tilt, this.capsized && this.mtouch);
                            if (this.im == this.xt.im && !this.capsized) {
                                this.xt.skid(n22, (float)Math.sqrt(this.scx[n31] * this.scx[n31] + this.scz[n31] * this.scz[n31]));
                            }
                        }
                    }
                    else {
                        if (n22 == 1 && this.m.random() > 0.8) {
                            contO.dust(n31, array[n31], array3[n31], array2[n31], (int)this.scx[n31], (int)this.scz[n31], 1.1f * this.cd.simag[this.cn], (int)this.tilt, this.capsized && this.mtouch);
                        }
                        if ((n22 == 2 || n22 == 3) && this.m.random() > 0.6) {
                            contO.dust(n31, array[n31], array3[n31], array2[n31], (int)this.scx[n31], (int)this.scz[n31], 1.15f * this.cd.simag[this.cn], (int)this.tilt, this.capsized && this.mtouch);
                        }
                    }
                }
                else if (this.dcnt != 0) {
                    this.dcnt -= 2;
                    if (this.dcnt < 0) {
                        this.dcnt = 0;
                    }
                }
                if (n22 == 3) {
                    this.scy[(int)(this.m.random() * 4.0f)] = (float)(-100.0f * this.m.random() * (this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
                }
                if (n22 == 4) {
                    this.scy[(int)(this.m.random() * 4.0f)] = (float)(-150.0f * this.m.random() * (this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
                }
                n29 += this.scx[n31];
                n30 += this.scz[n31];
            }
            this.txz = contO.xz;
            int n39;
            if (n29 > 0.0f) {
                n39 = -1;
            }
            else {
                n39 = 1;
            }
            this.mxz = (int)(Math.acos(n30 / Math.sqrt(n29 * n29 + n30 * n30)) / 0.017453292519943295 * n39);
            if (this.skid == 2) {
                if (!this.capsized) {
                    n29 /= 4.0f;
                    n30 /= 4.0f;
                    if (b) {
                        this.speed = -((float)Math.sqrt(n29 * n29 + n30 * n30) * this.m.cos(this.mxz - contO.xz));
                    }
                    else {
                        this.speed = (float)Math.sqrt(n29 * n29 + n30 * n30) * this.m.cos(this.mxz - contO.xz);
                    }
                }
                this.skid = 0;
            }
            if (this.capsized && n29 == 0.0f && n30 == 0.0f) {
                n22 = 0;
            }
            this.mtouch = false;
            b3 = true;
        }
        else if (this.skid != 2) {
            this.skid = 2;
        }
        int n40 = 0;
        final boolean[] array7 = new boolean[4];
        final boolean[] array8 = new boolean[4];
        final boolean[] array9 = new boolean[4];
        float n41 = 0.0f;
        for (int n42 = 0; n42 < 4; ++n42) {
            array9[n42] = (array8[n42] = false);
            if (array3[n42] > 245.0f) {
                ++n40;
                this.wtouch = true;
                this.gtouch = true;
                if (!b3 && this.scy[n42] != 7.0f) {
                    float n43 = this.scy[n42] / 333.33f;
                    if (n43 > 0.3) {
                        n43 = 0.3f;
                    }
                    float n44;
                    if (n22 == 0) {
                        n44 = (float)(n43 + 1.1);
                    }
                    else {
                        n44 = (float)(n43 + 1.2);
                    }
                    contO.dust(n42, array[n42], array3[n42], array2[n42], (int)this.scx[n42], (int)this.scz[n42], n44 * this.cd.simag[this.cn], 0, this.capsized && this.mtouch);
                }
                array3[n42] = 250.0f;
                array9[n42] = true;
                n41 += array3[n42] - 250.0f;
                float n45 = (Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy))) / 3.0f;
                if (n45 > 0.4) {
                    n45 = 0.4f;
                }
                float n46 = n45 + this.cd.bounce[this.cn];
                if (n46 < 1.1) {
                    n46 = 1.1f;
                }
                this.regy(n42, Math.abs(this.scy[n42] * n46), contO);
                if (this.scy[n42] > 0.0f) {
                    final float[] scy4 = this.scy;
                    final int n47 = n42;
                    scy4[n47] -= Math.abs(this.scy[n42] * n46);
                }
                if (this.capsized) {
                    array8[n42] = true;
                }
            }
            array7[n42] = false;
        }
        if (n40 != 0) {
            final float n48 = n41 / n40;
            for (int n49 = 0; n49 < 4; ++n49) {
                if (!array9[n49]) {
                    final float[] array10 = array3;
                    final int n50 = n49;
                    array10[n50] -= n48;
                }
            }
        }
        int n51 = 0;
        for (int n52 = 0; n52 < trackers.sect[ncx][ncz].length; ++n52) {
            final int n53 = trackers.sect[ncx][ncz][n52];
            int n54 = 0;
            int n55 = 0;
            for (int n56 = 0; n56 < 4; ++n56) {
                if (array8[n56] && (trackers.skd[n53] == 0 || trackers.skd[n53] == 1) && array[n56] > trackers.x[n53] - trackers.radx[n53] && array[n56] < trackers.x[n53] + trackers.radx[n53] && array2[n56] > trackers.z[n53] - trackers.radz[n53] && array2[n56] < trackers.z[n53] + trackers.radz[n53]) {
                    contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 1);
                    if (this.im == this.xt.im) {
                        this.xt.gscrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                    }
                }
                if (!array7[n56] && array[n56] > trackers.x[n53] - trackers.radx[n53] && array[n56] < trackers.x[n53] + trackers.radx[n53] && array2[n56] > trackers.z[n53] - trackers.radz[n53] && array2[n56] < trackers.z[n53] + trackers.radz[n53] && array3[n56] > trackers.y[n53] - trackers.rady[n53] && array3[n56] < trackers.y[n53] + trackers.rady[n53] && (!trackers.decor[n53] || this.m.resdown != 2 || this.xt.multion != 0)) {
                    if (trackers.xy[n53] == 0 && trackers.zy[n53] == 0 && trackers.y[n53] != 250 && array3[n56] > trackers.y[n53] - 5) {
                        ++n55;
                        this.wtouch = true;
                        this.gtouch = true;
                        if (!b3 && this.scy[n56] != 7.0f) {
                            float n57 = this.scy[n56] / 333.33f;
                            if (n57 > 0.3) {
                                n57 = 0.3f;
                            }
                            float n58;
                            if (n22 == 0) {
                                n58 = (float)(n57 + 1.1);
                            }
                            else {
                                n58 = (float)(n57 + 1.2);
                            }
                            contO.dust(n56, array[n56], array3[n56], array2[n56], (int)this.scx[n56], (int)this.scz[n56], n58 * this.cd.simag[this.cn], 0, this.capsized && this.mtouch);
                        }
                        array3[n56] = trackers.y[n53];
                        if (this.capsized && (trackers.skd[n53] == 0 || trackers.skd[n53] == 1)) {
                            contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 1);
                            if (this.im == this.xt.im) {
                                this.xt.gscrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                            }
                        }
                        float n59 = (Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy))) / 3.0f;
                        if (n59 > 0.4) {
                            n59 = 0.4f;
                        }
                        float n60 = n59 + this.cd.bounce[this.cn];
                        if (n60 < 1.1) {
                            n60 = 1.1f;
                        }
                        this.regy(n56, Math.abs(this.scy[n56] * n60), contO);
                        if (this.scy[n56] > 0.0f) {
                            final float[] scy5 = this.scy;
                            final int n61 = n56;
                            scy5[n61] -= Math.abs(this.scy[n56] * n60);
                        }
                        array7[n56] = true;
                    }
                    if (trackers.zy[n53] == -90 && array2[n56] < trackers.z[n53] + trackers.radz[n53] && (this.scz[n56] < 0.0f || trackers.radz[n53] == 287)) {
                        for (int n62 = 0; n62 < 4; ++n62) {
                            if (n56 != n62 && array2[n62] >= trackers.z[n53] + trackers.radz[n53]) {
                                final float[] array11 = array2;
                                final int n63 = n62;
                                array11[n63] -= array2[n56] - (trackers.z[n53] + trackers.radz[n53]);
                            }
                        }
                        array2[n56] = trackers.z[n53] + trackers.radz[n53];
                        if (trackers.skd[n53] != 2) {
                            final int[] array12 = this.crank[0];
                            final int n64 = n56;
                            ++array12[n64];
                        }
                        if (trackers.skd[n53] == 5 && this.m.random() > this.m.random()) {
                            final int[] array13 = this.crank[0];
                            final int n65 = n56;
                            ++array13[n65];
                        }
                        if (this.crank[0][n56] > 1) {
                            contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 0);
                            if (this.im == this.xt.im) {
                                this.xt.scrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                            }
                        }
                        float n66 = (Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy))) / 4.0f;
                        if (n66 > 0.3) {
                            n66 = 0.3f;
                        }
                        if (b3) {
                            n66 = 0.0f;
                        }
                        float n67 = (float)(n66 + (this.cd.bounce[this.cn] - 0.2));
                        if (n67 < 1.1) {
                            n67 = 1.1f;
                        }
                        this.regz(n56, Math.abs(this.scz[n56] * n67 * trackers.dam[n53]), contO);
                        final float[] scz3 = this.scz;
                        final int n68 = n56;
                        scz3[n68] += Math.abs(this.scz[n56] * n67);
                        this.skid = 2;
                        b2 = true;
                        array7[n56] = true;
                        if (!trackers.notwall[n53]) {
                            control.wall = n53;
                        }
                    }
                    if (trackers.zy[n53] == 90 && array2[n56] > trackers.z[n53] - trackers.radz[n53] && (this.scz[n56] > 0.0f || trackers.radz[n53] == 287)) {
                        for (int n69 = 0; n69 < 4; ++n69) {
                            if (n56 != n69 && array2[n69] <= trackers.z[n53] - trackers.radz[n53]) {
                                final float[] array14 = array2;
                                final int n70 = n69;
                                array14[n70] -= array2[n56] - (trackers.z[n53] - trackers.radz[n53]);
                            }
                        }
                        array2[n56] = trackers.z[n53] - trackers.radz[n53];
                        if (trackers.skd[n53] != 2) {
                            final int[] array15 = this.crank[1];
                            final int n71 = n56;
                            ++array15[n71];
                        }
                        if (trackers.skd[n53] == 5 && this.m.random() > this.m.random()) {
                            final int[] array16 = this.crank[1];
                            final int n72 = n56;
                            ++array16[n72];
                        }
                        if (this.crank[1][n56] > 1) {
                            contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 0);
                            if (this.im == this.xt.im) {
                                this.xt.scrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                            }
                        }
                        float n73 = (Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy))) / 4.0f;
                        if (n73 > 0.3) {
                            n73 = 0.3f;
                        }
                        if (b3) {
                            n73 = 0.0f;
                        }
                        float n74 = (float)(n73 + (this.cd.bounce[this.cn] - 0.2));
                        if (n74 < 1.1) {
                            n74 = 1.1f;
                        }
                        this.regz(n56, -Math.abs(this.scz[n56] * n74 * trackers.dam[n53]), contO);
                        final float[] scz4 = this.scz;
                        final int n75 = n56;
                        scz4[n75] -= Math.abs(this.scz[n56] * n74);
                        this.skid = 2;
                        b2 = true;
                        array7[n56] = true;
                        if (!trackers.notwall[n53]) {
                            control.wall = n53;
                        }
                    }
                    if (trackers.xy[n53] == -90 && array[n56] < trackers.x[n53] + trackers.radx[n53] && (this.scx[n56] < 0.0f || trackers.radx[n53] == 287)) {
                        for (int n76 = 0; n76 < 4; ++n76) {
                            if (n56 != n76 && array[n76] >= trackers.x[n53] + trackers.radx[n53]) {
                                final float[] array17 = array;
                                final int n77 = n76;
                                array17[n77] -= array[n56] - (trackers.x[n53] + trackers.radx[n53]);
                            }
                        }
                        array[n56] = trackers.x[n53] + trackers.radx[n53];
                        if (trackers.skd[n53] != 2) {
                            final int[] array18 = this.crank[2];
                            final int n78 = n56;
                            ++array18[n78];
                        }
                        if (trackers.skd[n53] == 5 && this.m.random() > this.m.random()) {
                            final int[] array19 = this.crank[2];
                            final int n79 = n56;
                            ++array19[n79];
                        }
                        if (this.crank[2][n56] > 1) {
                            contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 0);
                            if (this.im == this.xt.im) {
                                this.xt.scrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                            }
                        }
                        float n80 = (Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy))) / 4.0f;
                        if (n80 > 0.3) {
                            n80 = 0.3f;
                        }
                        if (b3) {
                            n80 = 0.0f;
                        }
                        float n81 = (float)(n80 + (this.cd.bounce[this.cn] - 0.2));
                        if (n81 < 1.1) {
                            n81 = 1.1f;
                        }
                        this.regx(n56, Math.abs(this.scx[n56] * n81 * trackers.dam[n53]), contO);
                        final float[] scx3 = this.scx;
                        final int n82 = n56;
                        scx3[n82] += Math.abs(this.scx[n56] * n81);
                        this.skid = 2;
                        b2 = true;
                        array7[n56] = true;
                        if (!trackers.notwall[n53]) {
                            control.wall = n53;
                        }
                    }
                    if (trackers.xy[n53] == 90 && array[n56] > trackers.x[n53] - trackers.radx[n53] && (this.scx[n56] > 0.0f || trackers.radx[n53] == 287)) {
                        for (int n83 = 0; n83 < 4; ++n83) {
                            if (n56 != n83 && array[n83] <= trackers.x[n53] - trackers.radx[n53]) {
                                final float[] array20 = array;
                                final int n84 = n83;
                                array20[n84] -= array[n56] - (trackers.x[n53] - trackers.radx[n53]);
                            }
                        }
                        array[n56] = trackers.x[n53] - trackers.radx[n53];
                        if (trackers.skd[n53] != 2) {
                            final int[] array21 = this.crank[3];
                            final int n85 = n56;
                            ++array21[n85];
                        }
                        if (trackers.skd[n53] == 5 && this.m.random() > this.m.random()) {
                            final int[] array22 = this.crank[3];
                            final int n86 = n56;
                            ++array22[n86];
                        }
                        if (this.crank[3][n56] > 1) {
                            contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 0);
                            if (this.im == this.xt.im) {
                                this.xt.scrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                            }
                        }
                        float n87 = (Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy))) / 4.0f;
                        if (n87 > 0.3) {
                            n87 = 0.3f;
                        }
                        if (b3) {
                            n87 = 0.0f;
                        }
                        float n88 = (float)(n87 + (this.cd.bounce[this.cn] - 0.2));
                        if (n88 < 1.1) {
                            n88 = 1.1f;
                        }
                        this.regx(n56, -Math.abs(this.scx[n56] * n88 * trackers.dam[n53]), contO);
                        final float[] scx4 = this.scx;
                        final int n89 = n56;
                        scx4[n89] -= Math.abs(this.scx[n56] * n88);
                        this.skid = 2;
                        b2 = true;
                        array7[n56] = true;
                        if (!trackers.notwall[n53]) {
                            control.wall = n53;
                        }
                    }
                    if (trackers.zy[n53] != 0 && trackers.zy[n53] != 90 && trackers.zy[n53] != -90) {
                        final int n90 = 90 + trackers.zy[n53];
                        float n91 = 1.0f + (50 - Math.abs(trackers.zy[n53])) / 30.0f;
                        if (n91 < 1.0f) {
                            n91 = 1.0f;
                        }
                        final float n92 = trackers.y[n53] + ((array3[n56] - trackers.y[n53]) * this.m.cos(n90) - (array2[n56] - trackers.z[n53]) * this.m.sin(n90));
                        float n93 = trackers.z[n53] + ((array3[n56] - trackers.y[n53]) * this.m.sin(n90) + (array2[n56] - trackers.z[n53]) * this.m.cos(n90));
                        if (n93 > trackers.z[n53] && n93 < trackers.z[n53] + 200) {
                            final float[] scy6 = this.scy;
                            final int n94 = n56;
                            scy6[n94] -= (n93 - trackers.z[n53]) / n91;
                            n93 = trackers.z[n53];
                        }
                        if (n93 > trackers.z[n53] - 30) {
                            if (trackers.skd[n53] == 2) {
                                ++n54;
                            }
                            else {
                                ++n51;
                            }
                            this.wtouch = true;
                            this.gtouch = false;
                            if (this.capsized && (trackers.skd[n53] == 0 || trackers.skd[n53] == 1)) {
                                contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 1);
                                if (this.im == this.xt.im) {
                                    this.xt.gscrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                                }
                            }
                            if (!b3 && n22 != 0) {
                                contO.dust(n56, array[n56], array3[n56], array2[n56], (int)this.scx[n56], (int)this.scz[n56], 1.4f * this.cd.simag[this.cn], 0, this.capsized && this.mtouch);
                            }
                        }
                        array3[n56] = trackers.y[n53] + ((n92 - trackers.y[n53]) * this.m.cos(-n90) - (n93 - trackers.z[n53]) * this.m.sin(-n90));
                        array2[n56] = trackers.z[n53] + ((n92 - trackers.y[n53]) * this.m.sin(-n90) + (n93 - trackers.z[n53]) * this.m.cos(-n90));
                        array7[n56] = true;
                    }
                    if (trackers.xy[n53] != 0 && trackers.xy[n53] != 90 && trackers.xy[n53] != -90) {
                        final int n95 = 90 + trackers.xy[n53];
                        float n96 = 1.0f + (50 - Math.abs(trackers.xy[n53])) / 30.0f;
                        if (n96 < 1.0f) {
                            n96 = 1.0f;
                        }
                        final float n97 = trackers.y[n53] + ((array3[n56] - trackers.y[n53]) * this.m.cos(n95) - (array[n56] - trackers.x[n53]) * this.m.sin(n95));
                        float n98 = trackers.x[n53] + ((array3[n56] - trackers.y[n53]) * this.m.sin(n95) + (array[n56] - trackers.x[n53]) * this.m.cos(n95));
                        if (n98 > trackers.x[n53] && n98 < trackers.x[n53] + 200) {
                            final float[] scy7 = this.scy;
                            final int n99 = n56;
                            scy7[n99] -= (n98 - trackers.x[n53]) / n96;
                            n98 = trackers.x[n53];
                        }
                        if (n98 > trackers.x[n53] - 30) {
                            if (trackers.skd[n53] == 2) {
                                ++n54;
                            }
                            else {
                                ++n51;
                            }
                            this.wtouch = true;
                            this.gtouch = false;
                            if (this.capsized && (trackers.skd[n53] == 0 || trackers.skd[n53] == 1)) {
                                contO.sprk(array[n56], array3[n56], array2[n56], this.scx[n56], this.scy[n56], this.scz[n56], 1);
                                if (this.im == this.xt.im) {
                                    this.xt.gscrape((int)this.scx[n56], (int)this.scy[n56], (int)this.scz[n56]);
                                }
                            }
                            if (!b3 && n22 != 0) {
                                contO.dust(n56, array[n56], array3[n56], array2[n56], (int)this.scx[n56], (int)this.scz[n56], 1.4f * this.cd.simag[this.cn], 0, this.capsized && this.mtouch);
                            }
                        }
                        array3[n56] = trackers.y[n53] + ((n97 - trackers.y[n53]) * this.m.cos(-n95) - (n98 - trackers.x[n53]) * this.m.sin(-n95));
                        array[n56] = trackers.x[n53] + ((n97 - trackers.y[n53]) * this.m.sin(-n95) + (n98 - trackers.x[n53]) * this.m.cos(-n95));
                        array7[n56] = true;
                    }
                }
            }
            if (n54 == 4) {
                this.mtouch = true;
            }
            if (n55 == 4) {
                n40 = 4;
            }
        }
        if (n51 == 4) {
            this.mtouch = true;
        }
        for (int n100 = 0; n100 < 4; ++n100) {
            for (int n101 = 0; n101 < 4; ++n101) {
                if (this.crank[n100][n101] == this.lcrank[n100][n101]) {
                    this.crank[n100][n101] = 0;
                }
                this.lcrank[n100][n101] = this.crank[n100][n101];
            }
        }
        int n102 = 0;
        int n103 = 0;
        int n104 = 0;
        int n105 = 0;
        if (this.scy[2] != this.scy[0]) {
            int n106;
            if (this.scy[2] < this.scy[0]) {
                n106 = -1;
            }
            else {
                n106 = 1;
            }
            final double n107 = Math.sqrt((array2[0] - array2[2]) * (array2[0] - array2[2]) + (array3[0] - array3[2]) * (array3[0] - array3[2]) + (array[0] - array[2]) * (array[0] - array[2])) / (Math.abs(contO.keyz[0]) + Math.abs(contO.keyz[2]));
            if (n107 >= 0.9998) {
                n102 = n106;
            }
            else {
                n102 = (int)(Math.acos(n107) / 0.017453292519943295 * n106);
            }
        }
        if (this.scy[3] != this.scy[1]) {
            int n108;
            if (this.scy[3] < this.scy[1]) {
                n108 = -1;
            }
            else {
                n108 = 1;
            }
            final double n109 = Math.sqrt((array2[1] - array2[3]) * (array2[1] - array2[3]) + (array3[1] - array3[3]) * (array3[1] - array3[3]) + (array[1] - array[3]) * (array[1] - array[3])) / (Math.abs(contO.keyz[1]) + Math.abs(contO.keyz[3]));
            if (n109 >= 0.9998) {
                n103 = n108;
            }
            else {
                n103 = (int)(Math.acos(n109) / 0.017453292519943295 * n108);
            }
        }
        if (this.scy[1] != this.scy[0]) {
            int n110;
            if (this.scy[1] < this.scy[0]) {
                n110 = -1;
            }
            else {
                n110 = 1;
            }
            final double n111 = Math.sqrt((array2[0] - array2[1]) * (array2[0] - array2[1]) + (array3[0] - array3[1]) * (array3[0] - array3[1]) + (array[0] - array[1]) * (array[0] - array[1])) / (Math.abs(contO.keyx[0]) + Math.abs(contO.keyx[1]));
            if (n111 >= 0.9998) {
                n104 = n110;
            }
            else {
                n104 = (int)(Math.acos(n111) / 0.017453292519943295 * n110);
            }
        }
        if (this.scy[3] != this.scy[2]) {
            int n112;
            if (this.scy[3] < this.scy[2]) {
                n112 = -1;
            }
            else {
                n112 = 1;
            }
            final double n113 = Math.sqrt((array2[2] - array2[3]) * (array2[2] - array2[3]) + (array3[2] - array3[3]) * (array3[2] - array3[3]) + (array[2] - array[3]) * (array[2] - array[3])) / (Math.abs(contO.keyx[2]) + Math.abs(contO.keyx[3]));
            if (n113 >= 0.9998) {
                n105 = n112;
            }
            else {
                n105 = (int)(Math.acos(n113) / 0.017453292519943295 * n112);
            }
        }
        if (b2) {
            int abs;
            for (abs = Math.abs(contO.xz + 45); abs > 180; abs -= 360) {}
            if (Math.abs(abs) > 90) {
                this.pmlt = 1;
            }
            else {
                this.pmlt = -1;
            }
            int abs2;
            for (abs2 = Math.abs(contO.xz - 45); abs2 > 180; abs2 -= 360) {}
            if (Math.abs(abs2) > 90) {
                this.nmlt = 1;
            }
            else {
                this.nmlt = -1;
            }
        }
        contO.xz += (int)(this.forca * (this.scz[0] * this.nmlt - this.scz[1] * this.pmlt + this.scz[2] * this.pmlt - this.scz[3] * this.nmlt + this.scx[0] * this.pmlt + this.scx[1] * this.nmlt - this.scx[2] * this.nmlt - this.scx[3] * this.pmlt));
        if (Math.abs(n103) > Math.abs(n102)) {
            n102 = n103;
        }
        if (Math.abs(n105) > Math.abs(n104)) {
            n104 = n105;
        }
        if (!zyinv) {
            this.pzy += n102;
        }
        else {
            this.pzy -= n102;
        }
        if (n3 == 0) {
            this.pxy += n104;
        }
        else {
            this.pxy -= n104;
        }
        if (n40 == 4) {
            int n114 = 0;
            while (this.pzy < 360) {
                this.pzy += 360;
                contO.zy += 360;
            }
            while (this.pzy > 360) {
                this.pzy -= 360;
                contO.zy -= 360;
            }
            if (this.pzy < 190 && this.pzy > 170) {
                this.pzy = 180;
                contO.zy = 180;
                ++n114;
            }
            if (this.pzy > 350 || this.pzy < 10) {
                this.pzy = 0;
                contO.zy = 0;
                ++n114;
            }
            while (this.pxy < 360) {
                this.pxy += 360;
                contO.xy += 360;
            }
            while (this.pxy > 360) {
                this.pxy -= 360;
                contO.xy -= 360;
            }
            if (this.pxy < 190 && this.pxy > 170) {
                this.pxy = 180;
                contO.xy = 180;
                ++n114;
            }
            if (this.pxy > 350 || this.pxy < 10) {
                this.pxy = 0;
                contO.xy = 0;
                ++n114;
            }
            if (n114 == 2) {
                this.mtouch = true;
            }
        }
        if (!this.mtouch && this.wtouch) {
            if (this.cntouch == 10) {
                this.mtouch = true;
            }
            else {
                ++this.cntouch;
            }
        }
        else {
            this.cntouch = 0;
        }
        contO.y = (int)((array3[0] + array3[1] + array3[2] + array3[3]) / 4.0f - grat * this.m.cos(this.pzy) * this.m.cos(this.pxy) + n6);
        int n115;
        if (zyinv) {
            n115 = -1;
        }
        else {
            n115 = 1;
        }
        contO.x = (int)((array[0] - contO.keyx[0] * this.m.cos(contO.xz) + n115 * contO.keyz[0] * this.m.sin(contO.xz) + array[1] - contO.keyx[1] * this.m.cos(contO.xz) + n115 * contO.keyz[1] * this.m.sin(contO.xz) + array[2] - contO.keyx[2] * this.m.cos(contO.xz) + n115 * contO.keyz[2] * this.m.sin(contO.xz) + array[3] - contO.keyx[3] * this.m.cos(contO.xz) + n115 * contO.keyz[3] * this.m.sin(contO.xz)) / 4.0f + grat * this.m.sin(this.pxy) * this.m.cos(contO.xz) - grat * this.m.sin(this.pzy) * this.m.sin(contO.xz) + n4);
        contO.z = (int)((array2[0] - n115 * contO.keyz[0] * this.m.cos(contO.xz) - contO.keyx[0] * this.m.sin(contO.xz) + array2[1] - n115 * contO.keyz[1] * this.m.cos(contO.xz) - contO.keyx[1] * this.m.sin(contO.xz) + array2[2] - n115 * contO.keyz[2] * this.m.cos(contO.xz) - contO.keyx[2] * this.m.sin(contO.xz) + array2[3] - n115 * contO.keyz[3] * this.m.cos(contO.xz) - contO.keyx[3] * this.m.sin(contO.xz)) / 4.0f + grat * this.m.sin(this.pxy) * this.m.sin(contO.xz) - grat * this.m.sin(this.pzy) * this.m.cos(contO.xz) + n5);
        if (Math.abs(this.speed) > 10.0f || !this.mtouch) {
            if (Math.abs(this.pxy - contO.xy) >= 4) {
                if (this.pxy > contO.xy) {
                    contO.xy += 2 + (this.pxy - contO.xy) / 2;
                }
                else {
                    contO.xy -= 2 + (contO.xy - this.pxy) / 2;
                }
            }
            else {
                contO.xy = this.pxy;
            }
            if (Math.abs(this.pzy - contO.zy) >= 4) {
                if (this.pzy > contO.zy) {
                    contO.zy += 2 + (this.pzy - contO.zy) / 2;
                }
                else {
                    contO.zy -= 2 + (contO.zy - this.pzy) / 2;
                }
            }
            else {
                contO.zy = this.pzy;
            }
        }
        if (this.wtouch && !this.capsized) {
            final float n116 = (float)(this.speed / this.cd.swits[this.cn][2] * 14.0f * (this.cd.bounce[this.cn] - 0.4));
            if (control.left && this.tilt < n116 && this.tilt >= 0.0f) {
                this.tilt += 0.4;
            }
            else if (control.right && this.tilt > -n116 && this.tilt <= 0.0f) {
                this.tilt -= 0.4;
            }
            else if (Math.abs(this.tilt) > 3.0 * (this.cd.bounce[this.cn] - 0.4)) {
                if (this.tilt > 0.0f) {
                    this.tilt -= (float)(3.0 * (this.cd.bounce[this.cn] - 0.3));
                }
                else {
                    this.tilt += (float)(3.0 * (this.cd.bounce[this.cn] - 0.3));
                }
            }
            else {
                this.tilt = 0.0f;
            }
            contO.xy += (int)this.tilt;
            if (this.gtouch) {
                contO.y -= (int)(this.tilt / 1.5);
            }
        }
        else if (this.tilt != 0.0f) {
            this.tilt = 0.0f;
        }
        if (this.wtouch && n22 == 2) {
            contO.zy += (int)((this.m.random() * 6.0f * this.speed / this.cd.swits[this.cn][2] - 3.0f * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
            contO.xy += (int)((this.m.random() * 6.0f * this.speed / this.cd.swits[this.cn][2] - 3.0f * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
        }
        if (this.wtouch && n22 == 1) {
            contO.zy += (int)((this.m.random() * 4.0f * this.speed / this.cd.swits[this.cn][2] - 2.0f * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
            contO.xy += (int)((this.m.random() * 4.0f * this.speed / this.cd.swits[this.cn][2] - 2.0f * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
        }
        if (this.hitmag >= this.cd.maxmag[this.cn] && !this.dest) {
            this.distruct(contO);
            if (this.cntdest == 7) {
                this.dest = true;
            }
            else {
                ++this.cntdest;
            }
            if (this.cntdest == 1) {
                this.rpd.dest[this.im] = 300;
            }
        }
        if (contO.dist == 0) {
            for (int n117 = 0; n117 < contO.npl; ++n117) {
                if (contO.p[n117].chip != 0) {
                    contO.p[n117].chip = 0;
                }
                if (contO.p[n117].embos != 0) {
                    contO.p[n117].embos = 13;
                }
            }
        }
        int focus = 0;
        int n118 = 0;
        int n119 = 0;
        int n120;
        if (this.nofocus) {
            n120 = 1;
        }
        else {
            n120 = 7;
        }
        for (int n121 = 0; n121 < checkPoints.n; ++n121) {
            if (checkPoints.typ[n121] > 0) {
                ++n119;
                if (checkPoints.typ[n121] == 1) {
                    if (this.clear == n119 + this.nlaps * checkPoints.nsp) {
                        n120 = 1;
                    }
                    if (Math.abs(contO.z - checkPoints.z[n121]) < 60.0f + Math.abs(this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0f && Math.abs(contO.x - checkPoints.x[n121]) < 700 && Math.abs(contO.y - checkPoints.y[n121] + 350) < 450 && this.clear == n119 + this.nlaps * checkPoints.nsp - 1) {
                        this.clear = n119 + this.nlaps * checkPoints.nsp;
                        this.pcleared = n121;
                        this.focus = -1;
                    }
                }
                if (checkPoints.typ[n121] == 2) {
                    if (this.clear == n119 + this.nlaps * checkPoints.nsp) {
                        n120 = 1;
                    }
                    if (Math.abs(contO.x - checkPoints.x[n121]) < 60.0f + Math.abs(this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0f && Math.abs(contO.z - checkPoints.z[n121]) < 700 && Math.abs(contO.y - checkPoints.y[n121] + 350) < 450 && this.clear == n119 + this.nlaps * checkPoints.nsp - 1) {
                        this.clear = n119 + this.nlaps * checkPoints.nsp;
                        this.pcleared = n121;
                        this.focus = -1;
                    }
                }
            }
            if (this.py(contO.x / 100, checkPoints.x[n121] / 100, contO.z / 100, checkPoints.z[n121] / 100) * n120 < n118 || n118 == 0) {
                focus = n121;
                n118 = this.py(contO.x / 100, checkPoints.x[n121] / 100, contO.z / 100, checkPoints.z[n121] / 100) * n120;
            }
        }
        if (this.clear == n119 + this.nlaps * checkPoints.nsp) {
            ++this.nlaps;
            if (this.xt.multion == 1 && this.im == this.xt.im) {
                if (this.xt.laptime < this.xt.fastestlap || this.xt.fastestlap == 0) {
                    this.xt.fastestlap = this.xt.laptime;
                }
                this.xt.laptime = 0;
            }
        }
        if (this.im == this.xt.im) {
            if (this.xt.multion == 1 && this.xt.starcnt == 0) {
                final xtGraphics xt = this.xt;
                ++xt.laptime;
            }
            this.m.checkpoint = this.clear;
            while (this.m.checkpoint >= checkPoints.nsp) {
                final Medium m = this.m;
                m.checkpoint -= checkPoints.nsp;
            }
            if (this.clear == checkPoints.nlaps * checkPoints.nsp - 1) {
                this.m.lastcheck = true;
            }
            if (checkPoints.haltall) {
                this.m.lastcheck = false;
            }
        }
        if (this.focus == -1) {
            if (this.im == this.xt.im) {
                focus += 2;
            }
            else {
                ++focus;
            }
            if (!this.nofocus) {
                int n122 = this.pcleared + 1;
                if (n122 >= checkPoints.n) {
                    n122 = 0;
                }
                while (checkPoints.typ[n122] <= 0) {
                    if (++n122 >= checkPoints.n) {
                        n122 = 0;
                    }
                }
                if (focus > n122 && (this.clear != this.nlaps * checkPoints.nsp || focus < this.pcleared)) {
                    focus = n122;
                    this.focus = focus;
                }
            }
            if (focus >= checkPoints.n) {
                focus -= checkPoints.n;
            }
            if (checkPoints.typ[focus] == -3) {
                focus = 0;
            }
            if (this.im == this.xt.im) {
                if (this.missedcp != -1) {
                    this.missedcp = -1;
                }
            }
            else if (this.missedcp != 0) {
                this.missedcp = 0;
            }
        }
        else {
            focus = this.focus;
            if (this.im == this.xt.im) {
                if (this.missedcp == 0 && this.mtouch && Math.sqrt(this.py(contO.x / 10, checkPoints.x[this.focus] / 10, contO.z / 10, checkPoints.z[this.focus] / 10)) > 800.0) {
                    this.missedcp = 1;
                }
                if (this.missedcp == -2 && Math.sqrt(this.py(contO.x / 10, checkPoints.x[this.focus] / 10, contO.z / 10, checkPoints.z[this.focus] / 10)) < 400.0) {
                    this.missedcp = 0;
                }
                if (this.missedcp != 0 && this.mtouch && Math.sqrt(this.py(contO.x / 10, checkPoints.x[this.focus] / 10, contO.z / 10, checkPoints.z[this.focus] / 10)) < 250.0) {
                    this.missedcp = 68;
                }
            }
            else {
                this.missedcp = 1;
            }
            if (this.nofocus) {
                this.focus = -1;
                this.missedcp = 0;
            }
        }
        if (this.nofocus) {
            this.nofocus = false;
        }
        this.point = focus;
        if (this.fixes != 0) {
            if (this.m.noelec == 0) {
                for (int n123 = 0; n123 < checkPoints.fn; ++n123) {
                    if (!checkPoints.roted[n123]) {
                        if (Math.abs(contO.z - checkPoints.fz[n123]) < 200 && this.py(contO.x / 100, checkPoints.fx[n123] / 100, contO.y / 100, checkPoints.fy[n123] / 100) < 30) {
                            if (contO.dist == 0) {
                                contO.fcnt = 8;
                            }
                            else {
                                if (this.im == this.xt.im && !contO.fix && !this.xt.mutes) {
                                    this.xt.carfixed.play();
                                }
                                contO.fix = true;
                            }
                            this.rpd.fix[this.im] = 300;
                        }
                    }
                    else if (Math.abs(contO.x - checkPoints.fx[n123]) < 200 && this.py(contO.z / 100, checkPoints.fz[n123] / 100, contO.y / 100, checkPoints.fy[n123] / 100) < 30) {
                        if (contO.dist == 0) {
                            contO.fcnt = 8;
                        }
                        else {
                            if (this.im == this.xt.im && !contO.fix && !this.xt.mutes) {
                                this.xt.carfixed.play();
                            }
                            contO.fix = true;
                        }
                        this.rpd.fix[this.im] = 300;
                    }
                }
            }
        }
        else {
            for (int n124 = 0; n124 < checkPoints.fn; ++n124) {
                if (this.rpy(contO.x / 100, checkPoints.fx[n124] / 100, contO.y / 100, checkPoints.fy[n124] / 100, contO.z / 100, checkPoints.fz[n124] / 100) < 760) {
                    this.m.noelec = 2;
                }
            }
        }
        if (contO.fcnt == 7 || contO.fcnt == 8) {
            this.squash = 0;
            this.nbsq = 0;
            this.hitmag = 0;
            this.cntdest = 0;
            this.dest = false;
            this.newcar = true;
            contO.fcnt = 9;
            if (this.fixes > 0) {
                --this.fixes;
            }
        }
        if (this.newedcar != 0) {
            --this.newedcar;
            if (this.newedcar == 10) {
                this.newcar = false;
            }
        }
        if (!this.mtouch) {
            if (this.trcnt != 1) {
                this.trcnt = 1;
                this.lxz = contO.xz;
            }
            if (this.loop == 2 || this.loop == -1) {
                this.travxy += (int)(this.rcomp - this.lcomp);
                if (Math.abs(this.travxy) > 135) {
                    this.rtab = true;
                }
                this.travzy += (int)(this.ucomp - this.dcomp);
                if (this.travzy > 135) {
                    this.ftab = true;
                }
                if (this.travzy < -135) {
                    this.btab = true;
                }
            }
            if (this.lxz != contO.xz) {
                this.travxz += this.lxz - contO.xz;
                this.lxz = contO.xz;
            }
            if (this.srfcnt < 10) {
                if (control.wall != -1) {
                    this.surfer = true;
                }
                ++this.srfcnt;
            }
        }
        else if (!this.dest) {
            if (!this.capsized) {
                if (this.capcnt != 0) {
                    this.capcnt = 0;
                }
                if (this.gtouch && this.trcnt != 0) {
                    if (this.trcnt == 9) {
                        this.powerup = 0.0f;
                        if (Math.abs(this.travxy) > 90) {
                            this.powerup += Math.abs(this.travxy) / 24.0f;
                        }
                        else if (this.rtab) {
                            this.powerup += 30.0f;
                        }
                        if (Math.abs(this.travzy) > 90) {
                            this.powerup += Math.abs(this.travzy) / 18.0f;
                        }
                        else {
                            if (this.ftab) {
                                this.powerup += 40.0f;
                            }
                            if (this.btab) {
                                this.powerup += 40.0f;
                            }
                        }
                        if (Math.abs(this.travxz) > 90) {
                            this.powerup += Math.abs(this.travxz) / 18.0f;
                        }
                        if (this.surfer) {
                            this.powerup += 30.0f;
                        }
                        this.power += this.powerup;
                        if (this.im == this.xt.im && (int)this.powerup > this.rpd.powered && this.rpd.wasted == 0 && (this.powerup > 60.0f || checkPoints.stage == 1 || checkPoints.stage == 2)) {
                            this.rpdcatch = 30;
                            if (this.rpd.hcaught) {
                                this.rpd.powered = (int)this.powerup;
                            }
                            if (this.xt.multion == 1 && this.powerup > this.xt.beststunt) {
                                this.xt.beststunt = (int)this.powerup;
                            }
                        }
                        if (this.power > 98.0f) {
                            this.power = 98.0f;
                            if (this.powerup > 150.0f) {
                                this.xtpower = 200;
                            }
                            else {
                                this.xtpower = 100;
                            }
                        }
                    }
                    if (this.trcnt == 10) {
                        this.travxy = 0;
                        this.travzy = 0;
                        this.travxz = 0;
                        this.ftab = false;
                        this.rtab = false;
                        this.btab = false;
                        this.trcnt = 0;
                        this.srfcnt = 0;
                        this.surfer = false;
                    }
                    else {
                        ++this.trcnt;
                    }
                }
            }
            else {
                if (this.trcnt != 0) {
                    this.travxy = 0;
                    this.travzy = 0;
                    this.travxz = 0;
                    this.ftab = false;
                    this.rtab = false;
                    this.btab = false;
                    this.trcnt = 0;
                    this.srfcnt = 0;
                    this.surfer = false;
                }
                if (this.capcnt == 0) {
                    int n125 = 0;
                    for (int n126 = 0; n126 < 4; ++n126) {
                        if (Math.abs(this.scz[n126]) < 70.0f && Math.abs(this.scx[n126]) < 70.0f) {
                            ++n125;
                        }
                    }
                    if (n125 == 4) {
                        this.capcnt = 1;
                    }
                }
                else {
                    ++this.capcnt;
                    if (this.capcnt == 30) {
                        this.speed = 0.0f;
                        contO.y += this.cd.flipy[this.cn];
                        this.pxy += 180;
                        contO.xy += 180;
                        this.capcnt = 0;
                    }
                }
            }
            if (this.trcnt == 0 && this.speed != 0.0f) {
                if (this.xtpower == 0) {
                    if (this.power > 0.0f) {
                        this.power -= this.power * this.power * this.power / this.cd.powerloss[this.cn];
                    }
                    else {
                        this.power = 0.0f;
                    }
                }
                else {
                    --this.xtpower;
                }
            }
        }
        if (this.im == this.xt.im) {
            if (control.wall != -1) {
                control.wall = -1;
            }
        }
        else if (this.lastcolido != 0 && !this.dest) {
            --this.lastcolido;
        }
        if (this.dest) {
            if (checkPoints.dested[this.im] == 0) {
                if (this.lastcolido == 0) {
                    checkPoints.dested[this.im] = 1;
                }
                else {
                    checkPoints.dested[this.im] = 2;
                }
            }
        }
        else if (checkPoints.dested[this.im] != 0 && checkPoints.dested[this.im] != 3) {
            checkPoints.dested[this.im] = 0;
        }
        if (this.im == this.xt.im && this.rpd.wasted == 0 && this.rpdcatch != 0) {
            --this.rpdcatch;
            if (this.rpdcatch == 0) {
                this.rpd.cotchinow(this.im);
                if (this.rpd.hcaught) {
                    this.rpd.whenwasted = (int)(185.0f + this.m.random() * 20.0f);
                }
            }
        }
    }
    
    public void distruct(final ContO contO) {
        for (int i = 0; i < contO.npl; ++i) {
            if (contO.p[i].wz == 0 || contO.p[i].gr == -17 || contO.p[i].gr == -16) {
                contO.p[i].embos = 1;
            }
        }
    }
    
    public int regy(final int n, float n2, final ContO contO) {
        int n3 = 0;
        boolean b = true;
        if (this.xt.multion == 1 && this.xt.im != this.im) {
            b = false;
        }
        if (this.xt.multion >= 2) {
            b = false;
        }
        if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) {
            b = true;
        }
        n2 *= this.cd.dammult[this.cn];
        if (n2 > 100.0f) {
            this.rpd.recy(n, n2, this.mtouch, this.im);
            n2 -= 100.0f;
            int n4 = 0;
            int n5 = 0;
            int i = contO.zy;
            int j = contO.xy;
            while (i < 360) {
                i += 360;
            }
            while (i > 360) {
                i -= 360;
            }
            if (i < 210 && i > 150) {
                n4 = -1;
            }
            if (i > 330 || i < 30) {
                n4 = 1;
            }
            while (j < 360) {
                j += 360;
            }
            while (j > 360) {
                j -= 360;
            }
            if (j < 210 && j > 150) {
                n5 = -1;
            }
            if (j > 330 || j < 30) {
                n5 = 1;
            }
            if (n5 * n4 == 0) {
                this.shakedam = (int)((Math.abs(n2) + this.shakedam) / 2.0f);
            }
            if (this.im == this.xt.im || this.colidim) {
                this.xt.crash(n2, n5 * n4);
            }
            if (n5 * n4 == 0 || this.mtouch) {
                for (int k = 0; k < contO.npl; ++k) {
                    float ctmag = 0.0f;
                    for (int l = 0; l < contO.p[k].n; ++l) {
                        if (contO.p[k].wz == 0 && this.py(contO.keyx[n], contO.p[k].ox[l], contO.keyz[n], contO.p[k].oz[l]) < this.cd.clrad[this.cn]) {
                            ctmag = n2 / 20.0f * this.m.random();
                            final int[] oz = contO.p[k].oz;
                            final int n6 = l;
                            oz[n6] += (int)(ctmag * this.m.sin(i));
                            final int[] ox = contO.p[k].ox;
                            final int n7 = l;
                            ox[n7] -= (int)(ctmag * this.m.sin(j));
                            if (b) {
                                this.hitmag += (int)Math.abs(ctmag);
                                n3 += (int)Math.abs(ctmag);
                            }
                        }
                    }
                    if (ctmag != 0.0f) {
                        if (Math.abs(ctmag) >= 1.0f) {
                            contO.p[k].chip = 1;
                            contO.p[k].ctmag = ctmag;
                        }
                        if (!contO.p[k].nocol && contO.p[k].glass != 1) {
                            if (contO.p[k].bfase > 20 && contO.p[k].hsb[1] > 0.25) {
                                contO.p[k].hsb[1] = 0.25f;
                            }
                            if (contO.p[k].bfase > 25 && contO.p[k].hsb[2] > 0.7) {
                                contO.p[k].hsb[2] = 0.7f;
                            }
                            if (contO.p[k].bfase > 30 && contO.p[k].hsb[1] > 0.15) {
                                contO.p[k].hsb[1] = 0.15f;
                            }
                            if (contO.p[k].bfase > 35 && contO.p[k].hsb[2] > 0.6) {
                                contO.p[k].hsb[2] = 0.6f;
                            }
                            if (contO.p[k].bfase > 40) {
                                contO.p[k].hsb[0] = 0.075f;
                            }
                            if (contO.p[k].bfase > 50 && contO.p[k].hsb[2] > 0.5) {
                                contO.p[k].hsb[2] = 0.5f;
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
            if (n5 * n4 == -1) {
                if (this.nbsq > 0) {
                    int n8 = 0;
                    int n9 = 1;
                    for (int n10 = 0; n10 < contO.npl; ++n10) {
                        float ctmag2 = 0.0f;
                        for (int n11 = 0; n11 < contO.p[n10].n; ++n11) {
                            if (contO.p[n10].wz == 0) {
                                ctmag2 = n2 / 15.0f * this.m.random();
                                if ((Math.abs(contO.p[n10].oy[n11] - this.cd.flipy[this.cn] - this.squash) < this.cd.msquash[this.cn] * 3 || contO.p[n10].oy[n11] < this.cd.flipy[this.cn] + this.squash) && this.squash < this.cd.msquash[this.cn]) {
                                    final int[] oy = contO.p[n10].oy;
                                    final int n12 = n11;
                                    oy[n12] += (int)ctmag2;
                                    n8 += (int)ctmag2;
                                    ++n9;
                                    if (b) {
                                        this.hitmag += (int)Math.abs(ctmag2);
                                        n3 += (int)Math.abs(ctmag2);
                                    }
                                }
                            }
                        }
                        if (contO.p[n10].glass == 1) {
                            final Plane plane3 = contO.p[n10];
                            plane3.gr += 5;
                        }
                        else if (ctmag2 != 0.0f) {
                            final Plane plane4 = contO.p[n10];
                            plane4.bfase += (int)ctmag2;
                        }
                        if (Math.abs(ctmag2) >= 1.0f) {
                            contO.p[n10].chip = 1;
                            contO.p[n10].ctmag = ctmag2;
                        }
                    }
                    this.squash += n8 / n9;
                    this.nbsq = 0;
                }
                else {
                    ++this.nbsq;
                }
            }
        }
        return n3;
    }
    
    public int regx(final int n, float n2, final ContO contO) {
        int n3 = 0;
        boolean b = true;
        if (this.xt.multion == 1 && this.xt.im != this.im) {
            b = false;
        }
        if (this.xt.multion >= 2) {
            b = false;
        }
        if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) {
            b = true;
        }
        n2 *= this.cd.dammult[this.cn];
        if (Math.abs(n2) > 100.0f) {
            this.rpd.recx(n, n2, this.im);
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            this.shakedam = (int)((Math.abs(n2) + this.shakedam) / 2.0f);
            if (this.im == this.xt.im || this.colidim) {
                this.xt.crash(n2, 0);
            }
            for (int i = 0; i < contO.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < contO.p[i].n; ++j) {
                    if (contO.p[i].wz == 0 && this.py(contO.keyx[n], contO.p[i].ox[j], contO.keyz[n], contO.p[i].oz[j]) < this.cd.clrad[this.cn]) {
                        ctmag = n2 / 20.0f * this.m.random();
                        final int[] oz = contO.p[i].oz;
                        final int n4 = j;
                        oz[n4] -= (int)(ctmag * this.m.sin(contO.xz) * this.m.cos(contO.zy));
                        final int[] ox = contO.p[i].ox;
                        final int n5 = j;
                        ox[n5] += (int)(ctmag * this.m.cos(contO.xz) * this.m.cos(contO.xy));
                        if (b) {
                            this.hitmag += (int)Math.abs(ctmag);
                            n3 += (int)Math.abs(ctmag);
                        }
                    }
                }
                if (ctmag != 0.0f) {
                    if (Math.abs(ctmag) >= 1.0f) {
                        contO.p[i].chip = 1;
                        contO.p[i].ctmag = ctmag;
                    }
                    if (!contO.p[i].nocol && contO.p[i].glass != 1) {
                        if (contO.p[i].bfase > 20 && contO.p[i].hsb[1] > 0.25) {
                            contO.p[i].hsb[1] = 0.25f;
                        }
                        if (contO.p[i].bfase > 25 && contO.p[i].hsb[2] > 0.7) {
                            contO.p[i].hsb[2] = 0.7f;
                        }
                        if (contO.p[i].bfase > 30 && contO.p[i].hsb[1] > 0.15) {
                            contO.p[i].hsb[1] = 0.15f;
                        }
                        if (contO.p[i].bfase > 35 && contO.p[i].hsb[2] > 0.6) {
                            contO.p[i].hsb[2] = 0.6f;
                        }
                        if (contO.p[i].bfase > 40) {
                            contO.p[i].hsb[0] = 0.075f;
                        }
                        if (contO.p[i].bfase > 50 && contO.p[i].hsb[2] > 0.5) {
                            contO.p[i].hsb[2] = 0.5f;
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
        return n3;
    }
    
    public int regz(final int n, float n2, final ContO contO) {
        int n3 = 0;
        boolean b = true;
        if (this.xt.multion == 1 && this.xt.im != this.im) {
            b = false;
        }
        if (this.xt.multion >= 2) {
            b = false;
        }
        if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) {
            b = true;
        }
        n2 *= this.cd.dammult[this.cn];
        if (Math.abs(n2) > 100.0f) {
            this.rpd.recz(n, n2, this.im);
            if (n2 > 100.0f) {
                n2 -= 100.0f;
            }
            if (n2 < -100.0f) {
                n2 += 100.0f;
            }
            this.shakedam = (int)((Math.abs(n2) + this.shakedam) / 2.0f);
            if (this.im == this.xt.im || this.colidim) {
                this.xt.crash(n2, 0);
            }
            for (int i = 0; i < contO.npl; ++i) {
                float ctmag = 0.0f;
                for (int j = 0; j < contO.p[i].n; ++j) {
                    if (contO.p[i].wz == 0 && this.py(contO.keyx[n], contO.p[i].ox[j], contO.keyz[n], contO.p[i].oz[j]) < this.cd.clrad[this.cn]) {
                        ctmag = n2 / 20.0f * this.m.random();
                        final int[] oz = contO.p[i].oz;
                        final int n4 = j;
                        oz[n4] += (int)(ctmag * this.m.cos(contO.xz) * this.m.cos(contO.zy));
                        final int[] ox = contO.p[i].ox;
                        final int n5 = j;
                        ox[n5] += (int)(ctmag * this.m.sin(contO.xz) * this.m.cos(contO.xy));
                        if (b) {
                            this.hitmag += (int)Math.abs(ctmag);
                            n3 += (int)Math.abs(ctmag);
                        }
                    }
                }
                if (ctmag != 0.0f) {
                    if (Math.abs(ctmag) >= 1.0f) {
                        contO.p[i].chip = 1;
                        contO.p[i].ctmag = ctmag;
                    }
                    if (!contO.p[i].nocol && contO.p[i].glass != 1) {
                        if (contO.p[i].bfase > 20 && contO.p[i].hsb[1] > 0.25) {
                            contO.p[i].hsb[1] = 0.25f;
                        }
                        if (contO.p[i].bfase > 25 && contO.p[i].hsb[2] > 0.7) {
                            contO.p[i].hsb[2] = 0.7f;
                        }
                        if (contO.p[i].bfase > 30 && contO.p[i].hsb[1] > 0.15) {
                            contO.p[i].hsb[1] = 0.15f;
                        }
                        if (contO.p[i].bfase > 35 && contO.p[i].hsb[2] > 0.6) {
                            contO.p[i].hsb[2] = 0.6f;
                        }
                        if (contO.p[i].bfase > 40) {
                            contO.p[i].hsb[0] = 0.075f;
                        }
                        if (contO.p[i].bfase > 50 && contO.p[i].hsb[2] > 0.5) {
                            contO.p[i].hsb[2] = 0.5f;
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
        return n3;
    }
    
    public void colide(final ContO contO, final Mad mad, final ContO contO2) {
        final float[] array = new float[4];
        final float[] array2 = new float[4];
        final float[] array3 = new float[4];
        final float[] array4 = new float[4];
        final float[] array5 = new float[4];
        final float[] array6 = new float[4];
        for (int i = 0; i < 4; ++i) {
            array[i] = contO.x + contO.keyx[i];
            if (this.capsized) {
                array2[i] = contO.y + this.cd.flipy[this.cn] + this.squash;
            }
            else {
                array2[i] = contO.y + contO.grat;
            }
            array3[i] = contO.z + contO.keyz[i];
            array4[i] = contO2.x + contO2.keyx[i];
            if (this.capsized) {
                array5[i] = contO2.y + this.cd.flipy[mad.cn] + mad.squash;
            }
            else {
                array5[i] = contO2.y + contO2.grat;
            }
            array6[i] = contO2.z + contO2.keyz[i];
        }
        this.rot(array, array2, contO.x, contO.y, contO.xy, 4);
        this.rot(array2, array3, contO.y, contO.z, contO.zy, 4);
        this.rot(array, array3, contO.x, contO.z, contO.xz, 4);
        this.rot(array4, array5, contO2.x, contO2.y, contO2.xy, 4);
        this.rot(array5, array6, contO2.y, contO2.z, contO2.zy, 4);
        this.rot(array4, array6, contO2.x, contO2.z, contO2.xz, 4);
        if (this.rpy(contO.x, contO2.x, contO.y, contO2.y, contO.z, contO2.z) < (contO.maxR * contO.maxR + contO2.maxR * contO2.maxR) * 1.5) {
            if (!this.caught[mad.im] && (this.speed != 0.0f || mad.speed != 0.0f)) {
                if (Math.abs(this.power * this.speed * this.cd.moment[this.cn]) != Math.abs(mad.power * mad.speed * this.cd.moment[mad.cn])) {
                    if (Math.abs(this.power * this.speed * this.cd.moment[this.cn]) > Math.abs(mad.power * mad.speed * this.cd.moment[mad.cn])) {
                        this.dominate[mad.im] = true;
                    }
                    else {
                        this.dominate[mad.im] = false;
                    }
                }
                else if (this.cd.moment[this.cn] > this.cd.moment[mad.cn]) {
                    this.dominate[mad.im] = true;
                }
                else {
                    this.dominate[mad.im] = false;
                }
                this.caught[mad.im] = true;
            }
        }
        else if (this.caught[mad.im]) {
            this.caught[mad.im] = false;
        }
        int n = 0;
        int n2 = 0;
        if (this.dominate[mad.im]) {
            final int n3 = (int)(((this.scz[0] - mad.scz[0] + this.scz[1] - mad.scz[1] + this.scz[2] - mad.scz[2] + this.scz[3] - mad.scz[3]) * (this.scz[0] - mad.scz[0] + this.scz[1] - mad.scz[1] + this.scz[2] - mad.scz[2] + this.scz[3] - mad.scz[3]) + (this.scx[0] - mad.scx[0] + this.scx[1] - mad.scx[1] + this.scx[2] - mad.scx[2] + this.scx[3] - mad.scx[3]) * (this.scx[0] - mad.scx[0] + this.scx[1] - mad.scx[1] + this.scx[2] - mad.scx[2] + this.scx[3] - mad.scx[3])) / 16.0f);
            int n4 = 7000;
            float n5 = 1.0f;
            if (this.xt.multion != 0) {
                n4 = 28000;
                n5 = 1.27f;
            }
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (this.rpy(array[j], array4[k], array2[j], array5[k], array3[j], array6[k]) < (n3 + n4) * (this.cd.comprad[mad.cn] + this.cd.comprad[this.cn])) {
                        if (Math.abs(this.scx[j] * this.cd.moment[this.cn]) > Math.abs(mad.scx[k] * this.cd.moment[mad.cn])) {
                            float n6 = mad.scx[k] * this.cd.revpush[this.cn];
                            if (n6 > 300.0f) {
                                n6 = 300.0f;
                            }
                            if (n6 < -300.0f) {
                                n6 = -300.0f;
                            }
                            float n7 = this.scx[j] * this.cd.push[this.cn];
                            if (n7 > 300.0f) {
                                n7 = 300.0f;
                            }
                            if (n7 < -300.0f) {
                                n7 = -300.0f;
                            }
                            final float[] scx = mad.scx;
                            final int n8 = k;
                            scx[n8] += n7;
                            if (this.im == this.xt.im) {
                                mad.colidim = true;
                            }
                            final int n9 = n + mad.regx(k, n7 * this.cd.moment[this.cn] * n5, contO2);
                            if (mad.colidim) {
                                mad.colidim = false;
                            }
                            final float[] scx2 = this.scx;
                            final int n10 = j;
                            scx2[n10] -= n6;
                            n2 += this.regx(j, -n6 * this.cd.moment[this.cn] * n5, contO);
                            final float[] scy = this.scy;
                            final int n11 = j;
                            scy[n11] -= this.cd.revlift[this.cn];
                            if (this.im == this.xt.im) {
                                mad.colidim = true;
                            }
                            n = n9 + mad.regy(k, this.cd.revlift[this.cn] * 7, contO2);
                            if (mad.colidim) {
                                mad.colidim = false;
                            }
                            if (this.m.random() > this.m.random()) {
                                contO2.sprk((array[j] + array4[k]) / 2.0f, (array2[j] + array5[k]) / 2.0f, (array3[j] + array6[k]) / 2.0f, (mad.scx[k] + this.scx[j]) / 4.0f, (mad.scy[k] + this.scy[j]) / 4.0f, (mad.scz[k] + this.scz[j]) / 4.0f, 2);
                            }
                        }
                        if (Math.abs(this.scz[j] * this.cd.moment[this.cn]) > Math.abs(mad.scz[k] * this.cd.moment[mad.cn])) {
                            float n12 = mad.scz[k] * this.cd.revpush[this.cn];
                            if (n12 > 300.0f) {
                                n12 = 300.0f;
                            }
                            if (n12 < -300.0f) {
                                n12 = -300.0f;
                            }
                            float n13 = this.scz[j] * this.cd.push[this.cn];
                            if (n13 > 300.0f) {
                                n13 = 300.0f;
                            }
                            if (n13 < -300.0f) {
                                n13 = -300.0f;
                            }
                            final float[] scz = mad.scz;
                            final int n14 = k;
                            scz[n14] += n13;
                            if (this.im == this.xt.im) {
                                mad.colidim = true;
                            }
                            final int n15 = n + mad.regz(k, n13 * this.cd.moment[this.cn] * n5, contO2);
                            if (mad.colidim) {
                                mad.colidim = false;
                            }
                            final float[] scz2 = this.scz;
                            final int n16 = j;
                            scz2[n16] -= n12;
                            n2 += this.regz(j, -n12 * this.cd.moment[this.cn] * n5, contO);
                            final float[] scy2 = this.scy;
                            final int n17 = j;
                            scy2[n17] -= this.cd.revlift[this.cn];
                            if (this.im == this.xt.im) {
                                mad.colidim = true;
                            }
                            n = n15 + mad.regy(k, this.cd.revlift[this.cn] * 7, contO2);
                            if (mad.colidim) {
                                mad.colidim = false;
                            }
                            if (this.m.random() > this.m.random()) {
                                contO2.sprk((array[j] + array4[k]) / 2.0f, (array2[j] + array5[k]) / 2.0f, (array3[j] + array6[k]) / 2.0f, (mad.scx[k] + this.scx[j]) / 4.0f, (mad.scy[k] + this.scy[j]) / 4.0f, (mad.scz[k] + this.scz[j]) / 4.0f, 2);
                            }
                        }
                        if (this.im == this.xt.im) {
                            mad.lastcolido = 70;
                        }
                        if (mad.im == this.xt.im) {
                            this.lastcolido = 70;
                        }
                        final float[] scy3 = mad.scy;
                        final int n18 = k;
                        scy3[n18] -= this.cd.lift[this.cn];
                    }
                }
            }
        }
        if (this.xt.multion == 1) {
            if (mad.im == this.xt.im && n != 0) {
                final int[] dcrashes = this.xt.dcrashes;
                final int im = this.im;
                dcrashes[im] += n;
            }
            if (this.im == this.xt.im && n2 != 0) {
                final int[] dcrashes2 = this.xt.dcrashes;
                final int im2 = mad.im;
                dcrashes2[im2] += n2;
            }
        }
    }
    
    public void rot(final float[] array, final float[] array2, final int n, final int n2, final int n3, final int n4) {
        if (n3 != 0) {
            for (int i = 0; i < n4; ++i) {
                final float n5 = array[i];
                final float n6 = array2[i];
                array[i] = n + ((n5 - n) * this.m.cos(n3) - (n6 - n2) * this.m.sin(n3));
                array2[i] = n2 + ((n5 - n) * this.m.sin(n3) + (n6 - n2) * this.m.cos(n3));
            }
        }
    }
    
    public int rpy(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        return (int)((n - n2) * (n - n2) + (n3 - n4) * (n3 - n4) + (n5 - n6) * (n5 - n6));
    }
    
    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
    }
}
