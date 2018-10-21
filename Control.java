public class Control
{
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    boolean handb;
    int lookback;
    boolean enter;
    boolean exit;
    boolean arrace;
    boolean mutem;
    boolean mutes;
    boolean radar;
    int chatup;
    int multion;
    Medium m;
    int pan;
    int attack;
    int acr;
    boolean afta;
    int[] fpnt;
    int trfix;
    boolean forget;
    boolean bulistc;
    int runbul;
    int acuracy;
    int upwait;
    boolean agressed;
    float skiplev;
    int clrnce;
    int rampp;
    int turntyp;
    float aim;
    int saftey;
    boolean perfection;
    float mustland;
    boolean usebounce;
    float trickprf;
    int stuntf;
    boolean zyinv;
    boolean lastl;
    boolean wlastl;
    int hold;
    int wall;
    int lwall;
    int stcnt;
    int statusque;
    int turncnt;
    int randtcnt;
    int upcnt;
    int trickfase;
    int swat;
    boolean udcomp;
    boolean lrcomp;
    boolean udbare;
    boolean lrbare;
    boolean onceu;
    boolean onced;
    boolean oncel;
    boolean oncer;
    int lrdirect;
    int uddirect;
    int lrstart;
    int udstart;
    int oxy;
    int ozy;
    int flycnt;
    boolean lrswt;
    boolean udswt;
    boolean gowait;
    int actwait;
    int cntrn;
    int revstart;
    int oupnt;
    int wtz;
    int wtx;
    int frx;
    int frz;
    int frad;
    int apunch;
    boolean exitattack;
    int avoidnlev;

    public Control(final Medium m) {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.lookback = 0;
        this.enter = false;
        this.exit = false;
        this.arrace = false;
        this.mutem = false;
        this.mutes = false;
        this.radar = false;
        this.chatup = 0;
        this.multion = 0;
        this.pan = 0;
        this.attack = 0;
        this.acr = 0;
        this.afta = false;
        this.fpnt = new int[5];
        this.trfix = 0;
        this.forget = false;
        this.bulistc = false;
        this.runbul = 0;
        this.acuracy = 0;
        this.upwait = 0;
        this.agressed = false;
        this.skiplev = 1.0f;
        this.clrnce = 5;
        this.rampp = 0;
        this.turntyp = 0;
        this.aim = 0.0f;
        this.saftey = 30;
        this.perfection = false;
        this.mustland = 0.5f;
        this.usebounce = false;
        this.trickprf = 0.5f;
        this.stuntf = 0;
        this.zyinv = false;
        this.lastl = false;
        this.wlastl = false;
        this.hold = 0;
        this.wall = -1;
        this.lwall = -1;
        this.stcnt = 0;
        this.statusque = 0;
        this.turncnt = 0;
        this.randtcnt = 0;
        this.upcnt = 0;
        this.trickfase = 0;
        this.swat = 0;
        this.udcomp = false;
        this.lrcomp = false;
        this.udbare = false;
        this.lrbare = false;
        this.onceu = false;
        this.onced = false;
        this.oncel = false;
        this.oncer = false;
        this.lrdirect = 0;
        this.uddirect = 0;
        this.lrstart = 0;
        this.udstart = 0;
        this.oxy = 0;
        this.ozy = 0;
        this.flycnt = 0;
        this.lrswt = false;
        this.udswt = false;
        this.gowait = false;
        this.actwait = 0;
        this.cntrn = 0;
        this.revstart = 0;
        this.oupnt = 0;
        this.wtz = 0;
        this.wtx = 0;
        this.frx = 0;
        this.frz = 0;
        this.frad = 0;
        this.apunch = 0;
        this.exitattack = false;
        this.avoidnlev = 0;
        this.m = m;
    }

    public void falseo(final int n) {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.lookback = 0;
        this.enter = false;
        this.exit = false;
        if (n != 1) {
            this.radar = false;
            this.arrace = false;
            this.chatup = 0;
            if (n != 2) {
                this.multion = 0;
            }
            if (n != 3) {
                this.mutem = false;
                this.mutes = false;
            }
        }
    }

    public void reset(final CheckPoints checkPoints, final int n) {
        this.pan = 0;
        this.attack = 0;
        this.acr = 0;
        this.afta = false;
        this.trfix = 0;
        this.acuracy = 0;
        this.upwait = 0;
        this.forget = false;
        this.bulistc = false;
        this.runbul = 0;
        this.revstart = 0;
        this.oupnt = 0;
        this.gowait = false;
        this.apunch = 0;
        this.exitattack = false;
        if (checkPoints.stage == 16 || checkPoints.stage == 18) {
            this.hold = 50;
        }
        if (checkPoints.stage == 17) {
            this.hold = 10;
        }
        if (checkPoints.stage == 20) {
            this.hold = 30;
        }
        if (checkPoints.stage == 21) {
            if (n != 13) {
                this.hold = 35;
                this.revstart = 25;
            }
            else {
                this.hold = 5;
            }
            this.statusque = 0;
        }
        if (checkPoints.stage == 22) {
            if (n != 13) {
                this.hold = (int)(20.0f + 10.0f * this.m.random());
                this.revstart = (int)(10.0f + 10.0f * this.m.random());
            }
            else {
                this.hold = 5;
            }
            this.statusque = 0;
        }
        if (checkPoints.stage == 24) {
            this.hold = 30;
            this.statusque = 0;
            if (n != 14) {
                this.revstart = 1;
            }
        }
        if (checkPoints.stage == 25) {
            this.hold = 40;
        }
        if (checkPoints.stage == 26) {
            this.hold = 20;
        }
        if (checkPoints.stage != 19 && checkPoints.stage != 26) {
            for (int i = 0; i < checkPoints.fn; ++i) {
                int py = -10;
                for (int j = 0; j < checkPoints.n; ++j) {
                    if (this.py(checkPoints.fx[i] / 100, checkPoints.x[j] / 100, checkPoints.fz[i] / 100, checkPoints.z[j] / 100) < py || py == -10) {
                        py = this.py(checkPoints.fx[i] / 100, checkPoints.x[j] / 100, checkPoints.fz[i] / 100, checkPoints.z[j] / 100);
                        this.fpnt[i] = j;
                    }
                }
            }
            for (int k = 0; k < checkPoints.fn; ++k) {
                final int[] fpnt = this.fpnt;
                final int n2 = k;
                fpnt[n2] -= 4;
                if (this.fpnt[k] < 0) {
                    final int[] fpnt2 = this.fpnt;
                    final int n3 = k;
                    fpnt2[n3] += checkPoints.nsp;
                }
            }
        }
        else {
            if (checkPoints.stage == 19) {
                this.fpnt[0] = 14;
                this.fpnt[1] = 36;
            }
            if (checkPoints.stage == 26) {
                this.fpnt[3] = 39;
            }
        }
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.lookback = 0;
        this.arrace = false;
        this.mutem = false;
        this.mutes = false;
    }

    public void preform(final Mad mad, final ContO contO, final CheckPoints checkPoints, final Trackers trackers) {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        if (!mad.dest) {
            if (mad.mtouch) {
                if (this.stcnt > this.statusque) {
                    int stage = checkPoints.stage;
                    if (stage > 10) {
                        stage -= 10;
                    }
                    this.acuracy = (7 - checkPoints.pos[mad.im]) * checkPoints.pos[0] * (6 - stage * 2);
                    if (this.acuracy < 0 || checkPoints.stage == -1) {
                        this.acuracy = 0;
                    }
                    this.clrnce = 5;
                    if (checkPoints.stage == 16 || checkPoints.stage == 21) {
                        this.clrnce = 2;
                    }
                    if (checkPoints.stage == 22 && (mad.pcleared == 27 || mad.pcleared == 17)) {
                        this.clrnce = 3;
                    }
                    if (checkPoints.stage == 26 && mad.pcleared == 33) {
                        this.clrnce = 3;
                    }
                    float n = 0.0f;
                    if (checkPoints.stage == 1) {
                        n = 2.0f;
                    }
                    if (checkPoints.stage == 2) {
                        n = 1.5f;
                    }
                    if (checkPoints.stage == 3 && mad.cn != 6) {
                        n = 0.5f;
                    }
                    if (checkPoints.stage == 4) {
                        n = 0.5f;
                    }
                    if (checkPoints.stage == 11) {
                        n = 2.0f;
                    }
                    if (checkPoints.stage == 12) {
                        n = 1.5f;
                    }
                    if (checkPoints.stage == 13 && mad.cn != 9) {
                        n = 0.5f;
                    }
                    if (checkPoints.stage == 14) {
                        n = 0.5f;
                    }
                    this.upwait = (int)((checkPoints.pos[0] - checkPoints.pos[mad.im]) * (checkPoints.pos[0] - checkPoints.pos[mad.im]) * (checkPoints.pos[0] - checkPoints.pos[mad.im]) * n);
                    if (this.upwait > 80) {
                        this.upwait = 80;
                    }
                    if ((checkPoints.stage == 11 || checkPoints.stage == 1) && this.upwait < 20) {
                        this.upwait = 20;
                    }
                    float skiplev = 0.0f;
                    if (checkPoints.stage == 1 || checkPoints.stage == 2) {
                        skiplev = 1.0f;
                    }
                    if (checkPoints.stage == 4) {
                        skiplev = 0.5f;
                    }
                    if (checkPoints.stage == 7) {
                        skiplev = 0.5f;
                    }
                    if (checkPoints.stage == 10) {
                        skiplev = 0.5f;
                    }
                    if (checkPoints.stage == 11 || checkPoints.stage == 12) {
                        skiplev = 1.0f;
                    }
                    if (checkPoints.stage == 13) {
                        skiplev = 0.5f;
                    }
                    if (checkPoints.stage == 14) {
                        skiplev = 0.5f;
                    }
                    if (checkPoints.stage == 15) {
                        skiplev = 0.2f;
                    }
                    if (checkPoints.pos[mad.im] - checkPoints.pos[0] >= -1) {
                        this.skiplev -= 0.1;
                        if (this.skiplev < 0.0f) {
                            this.skiplev = 0.0f;
                        }
                    }
                    else {
                        this.skiplev += 0.2;
                        if (this.skiplev > skiplev) {
                            this.skiplev = skiplev;
                        }
                    }
                    if (checkPoints.stage == 18) {
                        if (mad.pcleared >= 10 && mad.pcleared <= 24) {
                            this.skiplev = 1.0f;
                        }
                        else {
                            this.skiplev = 0.0f;
                        }
                    }
                    if (checkPoints.stage == 21) {
                        this.skiplev = 0.0f;
                        if (mad.pcleared == 5) {
                            this.skiplev = 1.0f;
                        }
                        if (mad.pcleared == 28 || mad.pcleared == 35) {
                            this.skiplev = 0.5f;
                        }
                    }
                    if (checkPoints.stage == 23) {
                        this.skiplev = 0.5f;
                    }
                    if (checkPoints.stage == 24 || checkPoints.stage == 22) {
                        this.skiplev = 1.0f;
                    }
                    if (checkPoints.stage == 26 || checkPoints.stage == 25 || checkPoints.stage == 20) {
                        this.skiplev = 0.0f;
                    }
                    this.rampp = (int)(this.m.random() * 4.0f - 2.0f);
                    if (mad.power == 98.0f) {
                        this.rampp = -1;
                    }
                    if (mad.power < 75.0f && this.rampp == -1) {
                        this.rampp = 0;
                    }
                    if (mad.power < 60.0f) {
                        this.rampp = 1;
                    }
                    if (checkPoints.stage == 6) {
                        this.rampp = 2;
                    }
                    if (checkPoints.stage == 18 && mad.pcleared >= 45) {
                        this.rampp = 2;
                    }
                    if (checkPoints.stage == 22 && mad.pcleared == 17) {
                        this.rampp = 2;
                    }
                    if (checkPoints.stage == 25 || checkPoints.stage == 26) {
                        this.rampp = 0;
                    }
                    if (this.cntrn == 0) {
                        this.agressed = false;
                        this.turntyp = (int)(this.m.random() * 4.0f);
                        if (checkPoints.stage == 3 && mad.cn == 6) {
                            this.turntyp = 1;
                            if (this.attack == 0) {
                                this.agressed = true;
                            }
                        }
                        if (checkPoints.stage == 9 && mad.cn == 15) {
                            this.turntyp = 1;
                            if (this.attack == 0) {
                                this.agressed = true;
                            }
                        }
                        if (checkPoints.stage == 13 && mad.cn == 9) {
                            this.turntyp = 1;
                            if (this.attack == 0) {
                                this.agressed = true;
                            }
                        }
                        if (checkPoints.pos[0] - checkPoints.pos[mad.im] < 0) {
                            this.turntyp = (int)(this.m.random() * 2.0f);
                        }
                        if (checkPoints.stage == 10) {
                            this.turntyp = 2;
                        }
                        if (checkPoints.stage == 18) {
                            this.turntyp = 2;
                        }
                        if (checkPoints.stage == 20) {
                            this.turntyp = 0;
                        }
                        if (checkPoints.stage == 23) {
                            this.turntyp = 1;
                        }
                        if (checkPoints.stage == 24) {
                            this.turntyp = 0;
                        }
                        if (this.attack != 0) {
                            this.turntyp = 2;
                            if (checkPoints.stage == 9 || checkPoints.stage == 10 || checkPoints.stage == 19 || checkPoints.stage == 21 || checkPoints.stage == 23 || checkPoints.stage == 27) {
                                this.turntyp = (int)(this.m.random() * 3.0f);
                            }
                            if (checkPoints.stage == 26 && checkPoints.clear[mad.im] - checkPoints.clear[0] >= 5) {
                                this.turntyp = 0;
                            }
                        }
                        if (checkPoints.stage == 6) {
                            this.turntyp = 1;
                            this.agressed = true;
                        }
                        if (checkPoints.stage == 7 || checkPoints.stage == 9 || checkPoints.stage == 10 || checkPoints.stage == 16 || checkPoints.stage == 17 || checkPoints.stage == 19 || checkPoints.stage == 20 || checkPoints.stage == 21 || checkPoints.stage == 22 || checkPoints.stage == 24 || checkPoints.stage == 26 || checkPoints.stage == 27) {
                            this.agressed = true;
                        }
                        if (checkPoints.stage == -1) {
                            if (this.m.random() > this.m.random()) {
                                this.agressed = true;
                            }
                            else {
                                this.agressed = false;
                            }
                        }
                        this.cntrn = 5;
                    }
                    else {
                        --this.cntrn;
                    }
                    this.saftey = (int)((98.0f - mad.power) / 2.0f * (this.m.random() / 2.0f + 0.5));
                    if (this.saftey > 20) {
                        this.saftey = 20;
                    }
                    float n2 = 0.0f;
                    if (checkPoints.stage == 1 || checkPoints.stage == 11) {
                        n2 = 0.9f;
                    }
                    if (checkPoints.stage == 2 || checkPoints.stage == 12) {
                        n2 = 0.7f;
                    }
                    if (checkPoints.stage == 4 || checkPoints.stage == 13) {
                        n2 = 0.4f;
                    }
                    this.mustland = n2 + (float)(this.m.random() / 2.0f - 0.25);
                    float n3 = 1.0f;
                    if (checkPoints.stage == 1 || checkPoints.stage == 11) {
                        n3 = 5.0f;
                    }
                    if (checkPoints.stage == 2 || checkPoints.stage == 12) {
                        n3 = 2.0f;
                    }
                    if (checkPoints.stage == 4 || checkPoints.stage == 13) {
                        n3 = 1.5f;
                    }
                    if (mad.power > 50.0f) {
                        if (checkPoints.pos[0] - checkPoints.pos[mad.im] > 0) {
                            this.saftey *= (int)n3;
                        }
                        else {
                            this.mustland = 0.0f;
                        }
                    }
                    else {
                        this.mustland -= 0.5f;
                    }
                    if (checkPoints.stage == 18 || checkPoints.stage == 20 || checkPoints.stage == 22 || checkPoints.stage == 24) {
                        this.mustland = 0.0f;
                    }
                    this.stuntf = 0;
                    if (checkPoints.stage == 8) {
                        this.stuntf = 17;
                    }
                    if (checkPoints.stage == 18 && mad.pcleared == 57) {
                        this.stuntf = 1;
                    }
                    if (checkPoints.stage == 19 && mad.pcleared == 3) {
                        this.stuntf = 2;
                    }
                    if (checkPoints.stage == 20) {
                        if (checkPoints.pos[0] < checkPoints.pos[mad.im] || Math.abs(checkPoints.clear[0] - mad.clear) >= 2 || mad.clear < 2) {
                            this.stuntf = 4;
                            this.saftey = 10;
                        }
                        else {
                            this.stuntf = 3;
                        }
                    }
                    if (checkPoints.stage == 21 && mad.pcleared == 21) {
                        this.stuntf = 1;
                    }
                    if (checkPoints.stage == 24) {
                        this.saftey = 10;
                        if (mad.pcleared >= 4 && mad.pcleared < 70) {
                            this.stuntf = 4;
                        }
                        else if (mad.cn == 12 || mad.cn == 8) {
                            this.stuntf = 2;
                        }
                        if (mad.cn == 14) {
                            this.stuntf = 6;
                        }
                    }
                    if (checkPoints.stage == 26) {
                        this.mustland = 0.0f;
                        this.saftey = 10;
                        if ((mad.pcleared == 15 || mad.pcleared == 51) && (this.m.random() > 0.4 || this.trfix != 0)) {
                            this.stuntf = 7;
                        }
                        if (mad.pcleared == 42) {
                            this.stuntf = 1;
                        }
                        if (mad.pcleared == 77) {
                            this.stuntf = 7;
                        }
                        this.avoidnlev = (int)(2700.0f * this.m.random());
                    }
                    this.trickprf = (mad.power - 38.0f) / 50.0f - this.m.random() / 2.0f;
                    if (mad.power < 60.0f) {
                        this.trickprf = -1.0f;
                    }
                    if (checkPoints.stage == 6 && this.trickprf > 0.5) {
                        this.trickprf = 0.5f;
                    }
                    if (checkPoints.stage == 3 && mad.cn == 6 && this.trickprf > 0.7) {
                        this.trickprf = 0.7f;
                    }
                    if (checkPoints.stage == 13 && mad.cn == 9 && this.trickprf > 0.7) {
                        this.trickprf = 0.7f;
                    }
                    if (checkPoints.stage == 16 && this.trickprf > 0.3) {
                        this.trickprf = 0.3f;
                    }
                    if (checkPoints.stage == 18 && this.trickprf > 0.2) {
                        this.trickprf = 0.2f;
                    }
                    if (checkPoints.stage == 19) {
                        if (this.trickprf > 0.5) {
                            this.trickprf = 0.5f;
                        }
                        if ((mad.im == 6 || mad.im == 5) && this.trickprf > 0.3) {
                            this.trickprf = 0.3f;
                        }
                    }
                    if (checkPoints.stage == 21 && this.trickprf != -1.0f) {
                        this.trickprf *= 0.75f;
                    }
                    if (checkPoints.stage == 22 && (mad.pcleared == 55 || mad.pcleared == 7)) {
                        this.trickprf = -1.0f;
                        this.stuntf = 5;
                    }
                    if (checkPoints.stage == 23 && this.trickprf > 0.4) {
                        this.trickprf = 0.4f;
                    }
                    if (checkPoints.stage == 24 && this.trickprf > 0.5) {
                        this.trickprf = 0.5f;
                    }
                    if (checkPoints.stage == 27) {
                        this.trickprf = -1.0f;
                    }
                    if (this.m.random() > mad.power / 100.0f) {
                        this.usebounce = true;
                    }
                    else {
                        this.usebounce = false;
                    }
                    if (checkPoints.stage == 9) {
                        this.usebounce = false;
                    }
                    if (checkPoints.stage == 14 || checkPoints.stage == 16) {
                        this.usebounce = true;
                    }
                    if (checkPoints.stage == 20 || checkPoints.stage == 24) {
                        this.usebounce = false;
                    }
                    if (this.m.random() > mad.hitmag / mad.cd.maxmag[mad.cn]) {
                        this.perfection = false;
                    }
                    else {
                        this.perfection = true;
                    }
                    if (100.0f * mad.hitmag / mad.cd.maxmag[mad.cn] > 60.0f) {
                        this.perfection = true;
                    }
                    if (checkPoints.stage == 3 && mad.cn == 6) {
                        this.perfection = true;
                    }
                    if (checkPoints.stage == 6 || checkPoints.stage == 8 || checkPoints.stage == 9 || checkPoints.stage == 10 || checkPoints.stage == 16 || checkPoints.stage == 18 || checkPoints.stage == 19 || checkPoints.stage == 20 || checkPoints.stage == 21 || checkPoints.stage == 22 || checkPoints.stage == 24 || checkPoints.stage == 26 || checkPoints.stage == 27) {
                        this.perfection = true;
                    }
                    if (this.attack == 0) {
                        boolean afta = true;
                        if (checkPoints.stage == 3 || checkPoints.stage == 1 || checkPoints.stage == 4 || checkPoints.stage == 9 || checkPoints.stage == 13 || checkPoints.stage == 11 || checkPoints.stage == 14 || checkPoints.stage == 19 || checkPoints.stage == 23 || checkPoints.stage == 26) {
                            afta = this.afta;
                        }
                        if (checkPoints.stage == 8 || checkPoints.stage == 6 || checkPoints.stage == 18 || checkPoints.stage == 16 || checkPoints.stage == 20 || checkPoints.stage == 24) {
                            afta = false;
                        }
                        if (checkPoints.stage == 3 && mad.cn == 6) {
                            afta = false;
                        }
                        if (checkPoints.stage == -1 && this.m.random() > this.m.random()) {
                            afta = false;
                        }
                        boolean b = false;
                        if (checkPoints.stage == 13 && mad.cn == 9) {
                            b = true;
                        }
                        if (checkPoints.stage == 18 && mad.cn == 11) {
                            b = true;
                        }
                        if (checkPoints.stage == 19 && checkPoints.clear[0] >= 20) {
                            b = true;
                        }
                        if (checkPoints.stage == 4 || checkPoints.stage == 10 || checkPoints.stage == 21 || checkPoints.stage == 22 || checkPoints.stage == 23 || checkPoints.stage == 25 || checkPoints.stage == 26) {
                            b = true;
                        }
                        if (checkPoints.stage == 3 && mad.cn == 6) {
                            b = true;
                        }
                        int n4 = 60;
                        if (checkPoints.stage == 5) {
                            n4 = 40;
                        }
                        if (checkPoints.stage == 6 && this.bulistc) {
                            n4 = 40;
                        }
                        if (checkPoints.stage == 9 && this.bulistc) {
                            n4 = 30;
                        }
                        if (checkPoints.stage == 3 || checkPoints.stage == 13 || checkPoints.stage == 21 || checkPoints.stage == 27 || checkPoints.stage == 20 || checkPoints.stage == 18) {
                            n4 = 30;
                        }
                        if ((checkPoints.stage == 12 || checkPoints.stage == 23) && mad.cn == 13) {
                            n4 = 50;
                        }
                        if (checkPoints.stage == 14) {
                            n4 = 20;
                        }
                        if (checkPoints.stage == 15 && mad.im != 6) {
                            n4 = 40;
                        }
                        if (checkPoints.stage == 17) {
                            n4 = 40;
                        }
                        if (checkPoints.stage == 18 && mad.cn == 11) {
                            n4 = 40;
                        }
                        if (checkPoints.stage == 19 && b) {
                            n4 = 30;
                        }
                        if (checkPoints.stage == 21 && this.bulistc) {
                            n4 = 30;
                        }
                        if (checkPoints.stage == 22) {
                            n4 = 50;
                        }
                        if (checkPoints.stage == 25 && this.bulistc) {
                            n4 = 40;
                        }
                        if (checkPoints.stage == 26) {
                            if (mad.cn == 11 && checkPoints.clear[0] == 27) {
                                n4 = 0;
                            }
                            if (mad.cn == 15 || mad.cn == 9) {
                                n4 = 50;
                            }
                            if (mad.cn == 11) {
                                n4 = 40;
                            }
                            if (checkPoints.pos[0] > checkPoints.pos[mad.im]) {
                                n4 = 80;
                            }
                        }
                        for (int i = 0; i < 7; ++i) {
                            if (i != mad.im && checkPoints.clear[i] != -1) {
                                int j = contO.xz;
                                if (this.zyinv) {
                                    j += 180;
                                }
                                while (j < 0) {
                                    j += 360;
                                }
                                while (j > 180) {
                                    j -= 360;
                                }
                                int n5 = 0;
                                if (checkPoints.opx[i] - contO.x >= 0) {
                                    n5 = 180;
                                }
                                int k;
                                float divisor = checkPoints.opx[i] - contO.x;
                                if (divisor == 0.0f) {
                                  divisor = 1;
                                }
                                for (
                                  k = (int)(90 + n5 + Math.atan((checkPoints.opz[i] - contO.z) / (divisor)) / 0.017453292519943295);
                                  k < 0;
                                  k += 360
                                ) {}
                                while (k > 180) {
                                    k -= 360;
                                }
                                int n6 = Math.abs(j - k);
                                if (n6 > 180) {
                                    n6 = Math.abs(n6 - 360);
                                }
                                int n7 = 2000 * (Math.abs(checkPoints.clear[i] - mad.clear) + 1);
                                if ((checkPoints.stage == 6 || checkPoints.stage == 9) && this.bulistc) {
                                    n7 = 6000;
                                }
                                if (checkPoints.stage == 3 && mad.cn == 6 && checkPoints.wasted < 2 && n7 > 4000) {
                                    n7 = 4000;
                                }
                                if (checkPoints.stage == 13 && mad.cn == 9 && n7 < 12000) {
                                    n7 = 12000;
                                }
                                if (checkPoints.stage == 14 && n7 < 4000) {
                                    n7 = 4000;
                                }
                                if (checkPoints.stage == 18 && mad.cn == 11) {
                                    if (n7 < 12000) {
                                        n7 = 12000;
                                    }
                                    n6 = 10;
                                }
                                if (checkPoints.stage == 19 && (mad.pcleared == 13 || mad.pcleared == 33 || b) && n7 < 12000) {
                                    n7 = 12000;
                                }
                                if (checkPoints.stage == 21) {
                                    if (this.bulistc) {
                                        n7 = 8000;
                                        n6 = 10;
                                        this.afta = true;
                                    }
                                    else if (n7 < 6000) {
                                        n7 = 6000;
                                    }
                                }
                                if (checkPoints.stage == 22 && this.bulistc) {
                                    n7 = 6000;
                                    n6 = 10;
                                }
                                if (checkPoints.stage == 23) {
                                    n7 = 21000;
                                }
                                if (checkPoints.stage == 25) {
                                    n7 *= Math.abs(checkPoints.clear[i] - mad.clear) + 1;
                                    if (this.bulistc) {
                                        n7 = 4000 * (Math.abs(checkPoints.clear[i] - mad.clear) + 1);
                                        n6 = 10;
                                    }
                                }
                                if (checkPoints.stage == 20) {
                                    n7 = 16000;
                                }
                                if (checkPoints.stage == 26) {
                                    if (mad.cn == 13 && this.bulistc) {
                                        if (this.oupnt == 33) {
                                            n7 = 17000;
                                        }
                                        if (this.oupnt == 51) {
                                            n7 = 30000;
                                        }
                                        if (this.oupnt == 15 && checkPoints.clear[0] >= 14) {
                                            n7 = 60000;
                                        }
                                        n6 = 10;
                                    }
                                    if (mad.cn == 15 || mad.cn == 9) {
                                        n7 *= Math.abs(checkPoints.clear[i] - mad.clear) + 1;
                                    }
                                    if (mad.cn == 11) {
                                        n7 = 4000 * (Math.abs(checkPoints.clear[i] - mad.clear) + 1);
                                    }
                                }
                                int n8 = 85 + 15 * (Math.abs(checkPoints.clear[i] - mad.clear) + 1);
                                if (checkPoints.stage == 23) {
                                    n8 = 45;
                                }
                                if (checkPoints.stage == 26 && (mad.cn == 15 || mad.cn == 9 || mad.cn == 11 || mad.cn == 14)) {
                                    n8 = 50 + 70 * Math.abs(checkPoints.clear[i] - mad.clear);
                                }
                                if (n6 < n8 && this.py(contO.x / 100, checkPoints.opx[i] / 100, contO.z / 100, checkPoints.opz[i] / 100) < n7 && this.afta && mad.power > n4) {
                                    float n9 = 35 - Math.abs(checkPoints.clear[i] - mad.clear) * 10;
                                    if (n9 < 1.0f) {
                                        n9 = 1.0f;
                                    }
                                    float n10 = (checkPoints.pos[mad.im] + 1) * (5 - checkPoints.pos[i]) / n9;
                                    if (checkPoints.stage != 27 && n10 > 0.7) {
                                        n10 = 0.7f;
                                    }
                                    if (i != 0 && checkPoints.pos[0] < checkPoints.pos[mad.im]) {
                                        n10 = 0.0f;
                                    }
                                    if (i != 0 && b) {
                                        n10 = 0.0f;
                                    }
                                    if (b && checkPoints.stage == 3 && i == 0) {
                                        if (checkPoints.wasted >= 2) {
                                            n10 *= 0.5f;
                                        }
                                        else {
                                            n10 = 0.0f;
                                        }
                                    }
                                    if ((checkPoints.stage == 3 || checkPoints.stage == 9) && i == 4) {
                                        n10 = 0.0f;
                                    }
                                    if (checkPoints.stage == 6) {
                                        n10 = 0.0f;
                                        if (this.bulistc && i == 0) {
                                            n10 = 1.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 8) {
                                        n10 = 0.0f;
                                        if (this.bulistc && mad.cn != 11 && mad.cn != 13) {
                                            n10 = 1.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 9 && mad.cn == 15) {
                                        n10 = 0.0f;
                                    }
                                    if (checkPoints.stage == 9 && this.bulistc) {
                                        if (i == 0) {
                                            n10 = 1.0f;
                                        }
                                        else {
                                            n10 = 0.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 9 && (checkPoints.pos[i] == 4 || checkPoints.pos[i] == 3)) {
                                        n10 = 0.0f;
                                    }
                                    if (checkPoints.stage == 13) {
                                        if (mad.cn == 9 || (mad.cn == 13 && this.bulistc)) {
                                            n10 *= 2.0f;
                                        }
                                        else {
                                            n10 *= 0.5f;
                                        }
                                    }
                                    if (checkPoints.stage == 16) {
                                        n10 = 0.0f;
                                    }
                                    if (checkPoints.stage == 17 && mad.im == 6 && i == 0) {
                                        n10 *= 1.5;
                                    }
                                    if (checkPoints.stage == 18) {
                                        if (mad.cn == 11 || (mad.cn == 13 && this.bulistc)) {
                                            n10 *= 1.5f;
                                        }
                                        else {
                                            n10 = 0.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 19) {
                                        if (i != 0) {
                                            n10 *= 0.5;
                                        }
                                        if (mad.pcleared != 13 && mad.pcleared != 33 && !b) {
                                            n10 *= 0.5f;
                                        }
                                        if ((mad.im == 6 || mad.im == 5) && i != 0) {
                                            n10 = 0.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 20) {
                                        n10 = 0.0f;
                                        if (this.bulistc && mad.cn != 11 && mad.cn != 13) {
                                            n10 = 1.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 21 && this.bulistc && i == 0) {
                                        n10 = 1.0f;
                                    }
                                    if (checkPoints.stage == 22) {
                                        if (mad.cn != 11 && mad.cn != 13) {
                                            n10 = 0.0f;
                                        }
                                        if (mad.cn == 13 && i == 0) {
                                            n10 = 1.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 24) {
                                        n10 = 0.0f;
                                    }
                                    if (checkPoints.stage == 25) {
                                        if (checkPoints.pos[mad.im] == 0) {
                                            n10 *= 0.5;
                                        }
                                        if (checkPoints.pos[0] < checkPoints.pos[mad.im]) {
                                            n10 *= 2.0f;
                                        }
                                        if (this.bulistc && i == 0) {
                                            n10 = 1.0f;
                                        }
                                    }
                                    if (checkPoints.stage == 26) {
                                        if (mad.cn != 14) {
                                            if (checkPoints.pos[0] < checkPoints.pos[mad.im] && checkPoints.clear[0] - checkPoints.clear[mad.im] != 1) {
                                                n10 *= 2.0f;
                                            }
                                        }
                                        else {
                                            n10 *= 0.5;
                                        }
                                        if (mad.cn == 13 && i == 0) {
                                            n10 = 1.0f;
                                        }
                                        if (checkPoints.pos[mad.im] == 0 || (checkPoints.pos[mad.im] == 1 && checkPoints.pos[0] == 0)) {
                                            n10 = 0.0f;
                                        }
                                        if (checkPoints.clear[mad.im] - checkPoints.clear[0] >= 5 && i == 0) {
                                            n10 = 1.0f;
                                        }
                                        if (mad.cn == 10 || mad.cn == 12) {
                                            n10 = 0.0f;
                                        }
                                    }
                                    if (this.m.random() < n10) {
                                        this.attack = 40 * (Math.abs(checkPoints.clear[i] - mad.clear) + 1);
                                        if (this.attack > 500) {
                                            this.attack = 500;
                                        }
                                        this.aim = 0.0f;
                                        if (checkPoints.stage == 13 && mad.cn == 9 && this.m.random() > this.m.random()) {
                                            this.aim = 1.0f;
                                        }
                                        if (checkPoints.stage == 14) {
                                            if (i == 0 && checkPoints.pos[0] < checkPoints.pos[mad.im]) {
                                                this.aim = 1.5f;
                                            }
                                            else {
                                                this.aim = this.m.random();
                                            }
                                        }
                                        if (checkPoints.stage == 15) {
                                            this.aim = this.m.random() * 1.5f;
                                        }
                                        if (checkPoints.stage == 17 && mad.im != 6 && (this.m.random() > this.m.random() || checkPoints.pos[0] < checkPoints.pos[mad.im])) {
                                            this.aim = 1.0f;
                                        }
                                        if (checkPoints.stage == 18 && mad.cn == 11 && this.m.random() > this.m.random()) {
                                            this.aim = 0.76f + this.m.random() * 0.76f;
                                        }
                                        if (checkPoints.stage == 19 && (mad.pcleared == 13 || mad.pcleared == 33)) {
                                            this.aim = 1.0f;
                                        }
                                        if (checkPoints.stage == 21) {
                                            if (this.bulistc) {
                                                this.aim = 0.7f;
                                                if (this.attack > 150) {
                                                    this.attack = 150;
                                                }
                                            }
                                            else {
                                                this.aim = this.m.random();
                                            }
                                        }
                                        if (checkPoints.stage == 22) {
                                            if (this.m.random() > this.m.random()) {
                                                this.aim = 0.7f;
                                            }
                                            if (this.bulistc && this.attack > 150) {
                                                this.attack = 150;
                                            }
                                        }
                                        if (checkPoints.stage == 23 && this.attack > 60) {
                                            this.attack = 60;
                                        }
                                        if (checkPoints.stage == 25) {
                                            this.aim = this.m.random() * 1.5f;
                                            this.attack /= 2;
                                            if (this.m.random() > this.m.random()) {
                                                this.exitattack = true;
                                            }
                                            else {
                                                this.exitattack = false;
                                            }
                                        }
                                        if (checkPoints.stage == 26) {
                                            if (mad.cn == 13) {
                                                this.aim = 0.76f;
                                                this.attack = 150;
                                            }
                                            else {
                                                this.aim = this.m.random() * 1.5f;
                                                if (Math.abs(checkPoints.clear[i] - mad.clear) <= 2 || mad.cn == 14) {
                                                    this.attack /= 3;
                                                }
                                            }
                                        }
                                        if (checkPoints.stage == -1 && this.m.random() > this.m.random()) {
                                            this.aim = this.m.random() * 1.5f;
                                        }
                                        this.acr = i;
                                        this.turntyp = (int)(1.0f + this.m.random() * 2.0f);
                                    }
                                }
                                if (afta && n6 > 100 && this.py(contO.x / 100, checkPoints.opx[i] / 100, contO.z / 100, checkPoints.opz[i] / 100) < 300 && this.m.random() > 0.6 - checkPoints.pos[mad.im] / 10.0f) {
                                    this.clrnce = 0;
                                    this.acuracy = 0;
                                }
                            }
                        }
                    }
                    boolean b2 = false;
                    if (checkPoints.stage == 6 || checkPoints.stage == 8) {
                        b2 = true;
                    }
                    if (checkPoints.stage == 9 && mad.cn == 15) {
                        b2 = true;
                    }
                    if (checkPoints.stage == 16 || checkPoints.stage == 20 || checkPoints.stage == 21 || checkPoints.stage == 27) {
                        b2 = true;
                    }
                    if (checkPoints.stage == 18 && mad.pcleared != 73) {
                        b2 = true;
                    }
                    if (checkPoints.stage == -1 && this.m.random() > this.m.random()) {
                        b2 = true;
                    }
                    if (this.trfix != 3) {
                        this.trfix = 0;
                        int n11 = 50;
                        if (checkPoints.stage == 26) {
                            n11 = 40;
                        }
                        if (100.0f * mad.hitmag / mad.cd.maxmag[mad.cn] > n11) {
                            this.trfix = 1;
                        }
                        if (!b2) {
                            int n12 = 80;
                            if (checkPoints.stage == 18 && mad.cn != 11) {
                                n12 = 50;
                            }
                            if (checkPoints.stage == 19) {
                                n12 = 70;
                            }
                            if (checkPoints.stage == 25 && mad.pcleared == 91) {
                                n12 = 50;
                            }
                            if (checkPoints.stage == 26 && checkPoints.clear[mad.im] - checkPoints.clear[0] >= 5 && mad.cn != 10 && mad.cn != 12) {
                                n12 = 50;
                            }
                            if (100.0f * mad.hitmag / mad.cd.maxmag[mad.cn] > n12) {
                                this.trfix = 2;
                            }
                        }
                    }
                    else {
                        this.upwait = 0;
                        this.acuracy = 0;
                        this.skiplev = 1.0f;
                        this.clrnce = 2;
                    }
                    if (!this.bulistc) {
                        if (checkPoints.stage == 18 && mad.cn == 11 && mad.pcleared == 35) {
                            mad.pcleared = 73;
                            mad.clear = 0;
                            this.bulistc = true;
                            this.runbul = (int)(100.0f * this.m.random());
                        }
                        if (checkPoints.stage == 21 && mad.cn == 13) {
                            this.bulistc = true;
                        }
                        if (checkPoints.stage == 22 && mad.cn == 13) {
                            this.bulistc = true;
                        }
                        if (checkPoints.stage == 25 && checkPoints.clear[0] - mad.clear >= 3 && this.trfix == 0) {
                            this.bulistc = true;
                            this.oupnt = -1;
                        }
                        if (checkPoints.stage == 26) {
                            if (mad.cn == 13 && checkPoints.pcleared == 8) {
                                this.bulistc = true;
                                this.attack = 0;
                            }
                            if (mad.cn == 11 && checkPoints.clear[0] - mad.clear >= 2 && this.trfix == 0) {
                                this.bulistc = true;
                                this.oupnt = -1;
                            }
                        }
                        if ((checkPoints.stage == 6 || checkPoints.stage == 8 || checkPoints.stage == 12 || checkPoints.stage == 13 || checkPoints.stage == 14 || checkPoints.stage == 15 || checkPoints.stage == 18 || checkPoints.stage == 20 || checkPoints.stage == 23) && mad.cn == 13 && Math.abs(checkPoints.clear[0] - mad.clear) >= 2) {
                            this.bulistc = true;
                        }
                        if ((checkPoints.stage == 8 || checkPoints.stage == 20) && mad.cn == 11 && Math.abs(checkPoints.clear[0] - mad.clear) >= 1) {
                            this.bulistc = true;
                        }
                        if (checkPoints.stage == 6 && mad.cn == 11) {
                            this.bulistc = true;
                        }
                        if (checkPoints.stage == 9 && this.afta && (checkPoints.pos[mad.im] == 4 || checkPoints.pos[mad.im] == 3) && mad.cn != 15 && this.trfix != 0) {
                            this.bulistc = true;
                        }
                    }
                    else if (checkPoints.stage == 18) {
                        --this.runbul;
                        if (mad.pcleared == 10) {
                            this.runbul = 0;
                        }
                        if (this.runbul <= 0) {
                            this.bulistc = false;
                        }
                    }
                    this.stcnt = 0;
                    this.statusque = (int)(20.0f * this.m.random());
                }
                else {
                    ++this.stcnt;
                }
            }
            boolean b3;
            if (this.usebounce) {
                b3 = mad.wtouch;
            }
            else {
                b3 = mad.mtouch;
            }
            if (b3) {
                if (this.trickfase != 0) {
                    this.trickfase = 0;
                }
                if (this.trfix == 2 || this.trfix == 3) {
                    this.attack = 0;
                }
                if (this.attack == 0) {
                    if (this.upcnt < 30) {
                        if (this.revstart <= 0) {
                            this.up = true;
                        }
                        else {
                            this.down = true;
                            --this.revstart;
                        }
                    }
                    if (this.upcnt < 25 + this.actwait) {
                        ++this.upcnt;
                    }
                    else {
                        this.upcnt = 0;
                        this.actwait = this.upwait;
                    }
                    int n13 = mad.point;
                    int n14 = 50;
                    if (checkPoints.stage == 9) {
                        n14 = 20;
                    }
                    if (checkPoints.stage == 18) {
                        n14 = 20;
                    }
                    if (checkPoints.stage == 25) {
                        n14 = 40;
                    }
                    if (checkPoints.stage == 26) {
                        n14 = 20;
                    }
                    if (!this.bulistc || this.trfix == 2 || this.trfix == 3 || this.trfix == 4 || mad.power < n14) {
                        if (this.rampp == 1 && checkPoints.typ[n13] <= 0) {
                            int n15 = n13 + 1;
                            if (n15 >= checkPoints.n) {
                                n15 = 0;
                            }
                            if (checkPoints.typ[n15] == -2) {
                                n13 = n15;
                            }
                        }
                        if (this.rampp == -1 && checkPoints.typ[n13] == -2 && ++n13 >= checkPoints.n) {
                            n13 = 0;
                        }
                        if (this.m.random() > this.skiplev) {
                            int n16 = n13;
                            int n17 = 0;
                            if (checkPoints.typ[n16] > 0) {
                                int n18 = 0;
                                for (int l = 0; l < checkPoints.n; ++l) {
                                    if (checkPoints.typ[l] > 0 && l < n16) {
                                        ++n18;
                                    }
                                }
                                n17 = ((mad.clear != n18 + mad.nlaps * checkPoints.nsp) ? 1 : 0);
                            }
                            while (checkPoints.typ[n16] == 0 || checkPoints.typ[n16] == -1 || checkPoints.typ[n16] == -3 || n17 != 0) {
                                n13 = n16;
                                if (++n16 >= checkPoints.n) {
                                    n16 = 0;
                                }
                                n17 = 0;
                                if (checkPoints.typ[n16] > 0) {
                                    int n19 = 0;
                                    for (int n20 = 0; n20 < checkPoints.n; ++n20) {
                                        if (checkPoints.typ[n20] > 0 && n20 < n16) {
                                            ++n19;
                                        }
                                    }
                                    n17 = ((mad.clear != n19 + mad.nlaps * checkPoints.nsp) ? 1 : 0);
                                }
                            }
                        }
                        else if (this.m.random() > this.skiplev) {
                            while (checkPoints.typ[n13] == -1) {
                                if (++n13 >= checkPoints.n) {
                                    n13 = 0;
                                }
                            }
                        }
                        if (checkPoints.stage == 18 && mad.pcleared == 73 && this.trfix == 0 && mad.clear != 0) {
                            n13 = 10;
                        }
                        if (checkPoints.stage == 19 && mad.pcleared == 18 && this.trfix == 0) {
                            n13 = 27;
                        }
                        if (checkPoints.stage == 21) {
                            if (mad.pcleared == 5 && this.trfix == 0 && mad.power < 70.0f) {
                                if (n13 <= 16) {
                                    n13 = 16;
                                }
                                else {
                                    n13 = 21;
                                }
                            }
                            if (mad.pcleared == 50) {
                                n13 = 57;
                            }
                        }
                        if (checkPoints.stage == 22 && (mad.pcleared == 27 || mad.pcleared == 37)) {
                            while (checkPoints.typ[n13] == -1) {
                                if (++n13 >= checkPoints.n) {
                                    n13 = 0;
                                }
                            }
                        }
                        if (checkPoints.stage == 23) {
                            while (checkPoints.typ[n13] == -1) {
                                if (++n13 >= checkPoints.n) {
                                    n13 = 0;
                                }
                            }
                        }
                        if (checkPoints.stage == 24) {
                            while (checkPoints.typ[n13] == -1) {
                                if (++n13 >= checkPoints.n) {
                                    n13 = 0;
                                }
                            }
                            if (!mad.gtouch) {
                                while (checkPoints.typ[n13] == -2) {
                                    if (++n13 >= checkPoints.n) {
                                        n13 = 0;
                                    }
                                }
                            }
                            if (this.oupnt >= 68) {
                                n13 = 70;
                            }
                            else {
                                this.oupnt = n13;
                            }
                        }
                        if (checkPoints.stage == 25) {
                            if ((mad.pcleared != 91 && checkPoints.pos[0] < checkPoints.pos[mad.im] && mad.cn != 13) || (checkPoints.pos[mad.im] == 0 && (mad.clear == 12 || mad.clear == 20))) {
                                while (checkPoints.typ[n13] == -4) {
                                    if (++n13 >= checkPoints.n) {
                                        n13 = 0;
                                    }
                                }
                            }
                            if (mad.pcleared == 9) {
                                if (this.py(contO.x / 100, 297, contO.z / 100, 347) < 400) {
                                    this.oupnt = 1;
                                }
                                if (this.oupnt == 1 && n13 < 22) {
                                    n13 = 22;
                                }
                            }
                            if (mad.pcleared == 67) {
                                if (this.py(contO.x / 100, 28, contO.z / 100, 494) < 4000) {
                                    this.oupnt = 2;
                                }
                                if (this.oupnt == 2) {
                                    n13 = 76;
                                }
                            }
                            if (mad.pcleared == 76) {
                                if (this.py(contO.x / 100, -50, contO.z / 100, 0) < 2000) {
                                    this.oupnt = 3;
                                }
                                if (this.oupnt == 3) {
                                    n13 = 91;
                                }
                                else {
                                    n13 = 89;
                                }
                            }
                        }
                        if (checkPoints.stage == 26) {
                            if (mad.pcleared == 128) {
                                if (this.py(contO.x / 100, 0, contO.z / 100, 229) < 1500 || contO.z > 23000) {
                                    this.oupnt = 128;
                                }
                                if (this.oupnt != 128) {
                                    n13 = 3;
                                }
                            }
                            if (mad.pcleared == 8) {
                                if (this.py(contO.x / 100, -207, contO.z / 100, 549) < 1500 || contO.x < -20700) {
                                    this.oupnt = 8;
                                }
                                if (this.oupnt != 8) {
                                    n13 = 12;
                                }
                            }
                            if (mad.pcleared == 33) {
                                if (this.py(contO.x / 100, -60, contO.z / 100, 168) < 250 || contO.z > 17000) {
                                    this.oupnt = 331;
                                }
                                if (this.py(contO.x / 100, -112, contO.z / 100, 414) < 10000 || contO.z > 40000) {
                                    this.oupnt = 332;
                                }
                                if (this.oupnt != 331 && this.oupnt != 332) {
                                    if (this.trfix != 1) {
                                        n13 = 38;
                                    }
                                    else {
                                        n13 = 39;
                                    }
                                }
                                if (this.oupnt == 331) {
                                    n13 = 71;
                                }
                            }
                            if (mad.pcleared == 42) {
                                if (this.py(contO.x / 100, -269, contO.z / 100, 493) < 100 || contO.x < -27000) {
                                    this.oupnt = 142;
                                }
                                if (this.oupnt != 142) {
                                    n13 = 47;
                                }
                            }
                            if (mad.pcleared == 51) {
                                if (this.py(contO.x / 100, -352, contO.z / 100, 260) < 100 || contO.z < 25000) {
                                    this.oupnt = 511;
                                }
                                if (this.py(contO.x / 100, -325, contO.z / 100, 10) < 2000 || contO.x > -32000) {
                                    this.oupnt = 512;
                                }
                                if (this.oupnt != 511 && this.oupnt != 512) {
                                    n13 = 80;
                                }
                                if (this.oupnt == 511) {
                                    n13 = 61;
                                }
                            }
                            if (mad.pcleared == 77) {
                                if (this.py(contO.x / 100, -371, contO.z / 100, 319) < 100 || contO.z < 31000) {
                                    this.oupnt = 77;
                                }
                                if (this.oupnt != 77) {
                                    n13 = 78;
                                    mad.nofocus = true;
                                }
                            }
                            if (mad.pcleared == 105) {
                                if (this.py(contO.x / 100, -179, contO.z / 100, 10) < 2300 || contO.z < 1050) {
                                    this.oupnt = 105;
                                }
                                if (this.oupnt != 105) {
                                    n13 = 65;
                                }
                                else {
                                    n13 = 125;
                                }
                            }
                            if (this.trfix == 3) {
                                if (this.py(contO.x / 100, -52, contO.z / 100, 448) < 100 || contO.z > 45000) {
                                    this.oupnt = 176;
                                }
                                if (this.oupnt != 176) {
                                    n13 = 41;
                                }
                                else {
                                    n13 = 43;
                                }
                            }
                            if (checkPoints.clear[mad.im] - checkPoints.clear[0] >= 2 && this.py(contO.x / 100, checkPoints.opx[0] / 100, contO.z / 100, checkPoints.opz[0] / 100) < 1000 + this.avoidnlev) {
                                int xz = contO.xz;
                                if (this.zyinv) {
                                    xz += 180;
                                }
                                while (xz < 0) {
                                    xz += 360;
                                }
                                while (xz > 180) {
                                    xz -= 360;
                                }
                                int n21 = 0;
                                if (checkPoints.opx[0] - contO.x >= 0) {
                                    n21 = 180;
                                }
                                int n22;
                                for (n22 = (int)(90 + n21 + Math.atan((checkPoints.opz[0] - contO.z) / (checkPoints.opx[0] - contO.x)) / 0.017453292519943295); n22 < 0; n22 += 360) {}
                                while (n22 > 180) {
                                    n22 -= 360;
                                }
                                int n23 = Math.abs(xz - n22);
                                if (n23 > 180) {
                                    n23 = Math.abs(n23 - 360);
                                }
                                if (n23 < 90) {
                                    this.wall = 0;
                                }
                            }
                        }
                        if (this.rampp == 2) {
                            int n24 = n13 + 1;
                            if (n24 >= checkPoints.n) {
                                n24 = 0;
                            }
                            if (checkPoints.typ[n24] == -2 && n13 != mad.point && --n13 < 0) {
                                n13 += checkPoints.n;
                            }
                        }
                        if (this.bulistc) {
                            mad.nofocus = true;
                            if (this.gowait) {
                                this.gowait = false;
                            }
                        }
                    }
                    else {
                        if ((checkPoints.stage != 25 && checkPoints.stage != 26) || this.runbul == 0) {
                            n13 -= 2;
                            if (n13 < 0) {
                                n13 += checkPoints.n;
                            }
                            if (checkPoints.stage == 9 && n13 > 76) {
                                n13 = 76;
                            }
                            while (checkPoints.typ[n13] == -4) {
                                if (--n13 < 0) {
                                    n13 += checkPoints.n;
                                }
                            }
                        }
                        if (checkPoints.stage == 21) {
                            if (n13 >= 14 && n13 <= 19) {
                                n13 = 13;
                            }
                            if (this.oupnt == 72 && n13 != 56) {
                                n13 = 57;
                            }
                            else if (this.oupnt == 54 && n13 != 52) {
                                n13 = 53;
                            }
                            else if (this.oupnt == 39 && n13 != 37) {
                                n13 = 38;
                            }
                            else {
                                this.oupnt = n13;
                            }
                        }
                        if (checkPoints.stage == 22) {
                            if (!this.gowait) {
                                if (checkPoints.clear[0] == 0) {
                                    this.wtx = -3500;
                                    this.wtz = 19000;
                                    this.frx = -3500;
                                    this.frz = 39000;
                                    this.frad = 12000;
                                    this.oupnt = 37;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if (checkPoints.clear[0] == 7) {
                                    this.wtx = -44800;
                                    this.wtz = 40320;
                                    this.frx = -44800;
                                    this.frz = 34720;
                                    this.frad = 30000;
                                    this.oupnt = 27;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if (checkPoints.clear[0] == 10) {
                                    this.wtx = 0;
                                    this.wtz = 48739;
                                    this.frx = 0;
                                    this.frz = 38589;
                                    this.frad = 90000;
                                    this.oupnt = 55;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if (checkPoints.clear[0] == 14) {
                                    this.wtx = -3500;
                                    this.wtz = 19000;
                                    this.frx = -14700;
                                    this.frz = 39000;
                                    this.frad = 45000;
                                    this.oupnt = 37;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if (checkPoints.clear[0] == 18) {
                                    this.wtx = -48300;
                                    this.wtz = -4550;
                                    this.frx = -48300;
                                    this.frz = 5600;
                                    this.frad = 90000;
                                    this.oupnt = 17;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                            }
                            if (this.gowait) {
                                if (this.py(contO.x / 100, this.wtx / 100, contO.z / 100, this.wtz / 100) < 10000 && mad.speed > 50.0f) {
                                    this.up = false;
                                }
                                if (this.py(contO.x / 100, this.wtx / 100, contO.z / 100, this.wtz / 100) < 200) {
                                    this.up = false;
                                    this.handb = true;
                                }
                                if (checkPoints.pcleared == this.oupnt && this.py(checkPoints.opx[0] / 100, this.frx / 100, checkPoints.opz[0] / 100, this.frz / 100) < this.frad) {
                                    this.afta = true;
                                    this.gowait = false;
                                }
                                if (this.py(contO.x / 100, checkPoints.opx[0] / 100, contO.z / 100, checkPoints.opz[0] / 100) < 25) {
                                    this.afta = true;
                                    this.gowait = false;
                                    this.attack = 200;
                                    this.acr = 0;
                                }
                            }
                        }
                        if (checkPoints.stage == 25) {
                            if (this.oupnt == -1) {
                                int py = -10;
                                for (int oupnt = 0; oupnt < checkPoints.n; ++oupnt) {
                                    if ((checkPoints.typ[oupnt] == -2 || checkPoints.typ[oupnt] == -4) && (oupnt < 50 || oupnt > 54) && (this.py(contO.x / 100, checkPoints.x[oupnt] / 100, contO.z / 100, checkPoints.z[oupnt] / 100) < py || py == -10)) {
                                        py = this.py(contO.x / 100, checkPoints.x[oupnt] / 100, contO.z / 100, checkPoints.z[oupnt] / 100);
                                        this.oupnt = oupnt;
                                    }
                                }
                                --this.oupnt;
                                if (n13 < 0) {
                                    this.oupnt += checkPoints.n;
                                }
                            }
                            if (this.oupnt >= 0 && this.oupnt < checkPoints.n) {
                                n13 = this.oupnt;
                                if (this.py(contO.x / 100, checkPoints.x[n13] / 100, contO.z / 100, checkPoints.z[n13] / 100) < 800) {
                                    this.oupnt = -(int)(75.0f + this.m.random() * 200.0f);
                                    this.runbul = (int)(50.0f + this.m.random() * 100.0f);
                                }
                            }
                            if (this.oupnt < -1) {
                                ++this.oupnt;
                            }
                            if (this.runbul != 0) {
                                --this.runbul;
                            }
                        }
                        if (checkPoints.stage == 26) {
                            boolean b4 = false;
                            if (mad.cn == 13) {
                                if (!this.gowait) {
                                    if (checkPoints.clear[0] == 1) {
                                        if (this.m.random() > 0.5) {
                                            this.wtx = -14000;
                                            this.wtz = 48000;
                                            this.frx = -5600;
                                            this.frz = 47600;
                                            this.frad = 88000;
                                            this.oupnt = 33;
                                        }
                                        else {
                                            this.wtx = -5600;
                                            this.wtz = 8000;
                                            this.frx = -7350;
                                            this.frz = -4550;
                                            this.frad = 22000;
                                            this.oupnt = 15;
                                        }
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if (checkPoints.clear[0] == 4) {
                                        this.wtx = -12700;
                                        this.wtz = 14000;
                                        this.frx = -31000;
                                        this.frz = 1050;
                                        this.frad = 11000;
                                        this.oupnt = 51;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if (checkPoints.clear[0] == 14) {
                                        this.wtx = -35350;
                                        this.wtz = 6650;
                                        this.frx = -48300;
                                        this.frz = 54950;
                                        this.frad = 11000;
                                        this.oupnt = 15;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if (checkPoints.clear[0] == 17) {
                                        this.wtx = -42700;
                                        this.wtz = 41000;
                                        this.frx = -40950;
                                        this.frz = 49350;
                                        this.frad = 7000;
                                        this.oupnt = 42;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if (checkPoints.clear[0] == 21) {
                                        this.wtx = -1750;
                                        this.wtz = -15750;
                                        this.frx = -25900;
                                        this.frz = -14000;
                                        this.frad = 11000;
                                        this.oupnt = 125;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                }
                                if (this.gowait) {
                                    if (this.py(contO.x / 100, this.wtx / 100, contO.z / 100, this.wtz / 100) < 10000 && mad.speed > 50.0f) {
                                        this.up = false;
                                    }
                                    if (this.py(contO.x / 100, this.wtx / 100, contO.z / 100, this.wtz / 100) < 200) {
                                        this.up = false;
                                        this.handb = true;
                                    }
                                    if (checkPoints.pcleared == this.oupnt && this.py(checkPoints.opx[0] / 100, this.frx / 100, checkPoints.opz[0] / 100, this.frz / 100) < this.frad) {
                                        this.runbul = 0;
                                        this.afta = true;
                                        this.gowait = false;
                                    }
                                    if (this.py(contO.x / 100, checkPoints.opx[0] / 100, contO.z / 100, checkPoints.opz[0] / 100) < 25) {
                                        this.afta = true;
                                        this.gowait = false;
                                        this.attack = 200;
                                        this.acr = 0;
                                    }
                                    if (checkPoints.clear[0] == 21 && this.oupnt != 125) {
                                        this.gowait = false;
                                    }
                                }
                                if ((checkPoints.clear[0] >= 11 && !this.gowait) || (mad.power < 60.0f && checkPoints.clear[0] < 21)) {
                                    b4 = true;
                                    if (!this.exitattack) {
                                        this.oupnt = -1;
                                        this.exitattack = true;
                                    }
                                }
                                else if (this.exitattack) {
                                    this.exitattack = false;
                                }
                            }
                            if (mad.cn == 11) {
                                b4 = true;
                            }
                            if (b4) {
                                if (this.oupnt == -1) {
                                    int py2 = -10;
                                    for (int oupnt2 = 0; oupnt2 < checkPoints.n; ++oupnt2) {
                                        if (checkPoints.typ[oupnt2] == -4 && ((this.py(contO.x / 100, checkPoints.x[oupnt2] / 100, contO.z / 100, checkPoints.z[oupnt2] / 100) < py2 && this.m.random() > 0.6) || py2 == -10)) {
                                            py2 = this.py(contO.x / 100, checkPoints.x[oupnt2] / 100, contO.z / 100, checkPoints.z[oupnt2] / 100);
                                            this.oupnt = oupnt2;
                                        }
                                    }
                                    --this.oupnt;
                                    if (n13 < 0) {
                                        this.oupnt += checkPoints.n;
                                    }
                                }
                                if (this.oupnt >= 0 && this.oupnt < checkPoints.n) {
                                    n13 = this.oupnt;
                                    if (this.py(contO.x / 100, checkPoints.x[n13] / 100, contO.z / 100, checkPoints.z[n13] / 100) < 800) {
                                        this.oupnt = -(int)(75.0f + this.m.random() * 200.0f);
                                        this.runbul = (int)(50.0f + this.m.random() * 100.0f);
                                    }
                                }
                                if (this.oupnt < -1) {
                                    ++this.oupnt;
                                }
                                if (this.runbul != 0) {
                                    --this.runbul;
                                }
                            }
                        }
                        mad.nofocus = true;
                    }
                    if (checkPoints.stage != 27) {
                        if (checkPoints.stage == 10 || checkPoints.stage == 19 || (checkPoints.stage == 18 && mad.pcleared == 73) || checkPoints.stage == 26) {
                            this.forget = true;
                        }
                        if ((mad.missedcp == 0 || this.forget || this.trfix == 4) && this.trfix != 0) {
                            int n25 = 0;
                            if (checkPoints.stage == 25 || checkPoints.stage == 26) {
                                n25 = 3;
                            }
                            if (this.trfix == 2) {
                                int py3 = -10;
                                int n26 = 0;
                                for (int n27 = n25; n27 < checkPoints.fn; ++n27) {
                                    if (this.py(contO.x / 100, checkPoints.x[this.fpnt[n27]] / 100, contO.z / 100, checkPoints.z[this.fpnt[n27]] / 100) < py3 || py3 == -10) {
                                        py3 = this.py(contO.x / 100, checkPoints.x[this.fpnt[n27]] / 100, contO.z / 100, checkPoints.z[this.fpnt[n27]] / 100);
                                        n26 = n27;
                                    }
                                }
                                if (checkPoints.stage == 18 || checkPoints.stage == 22) {
                                    n26 = 1;
                                }
                                n13 = this.fpnt[n26];
                                if (checkPoints.special[n26]) {
                                    this.forget = true;
                                }
                                else {
                                    this.forget = false;
                                }
                            }
                            for (int n28 = n25; n28 < checkPoints.fn; ++n28) {
                                if (this.py(contO.x / 100, checkPoints.x[this.fpnt[n28]] / 100, contO.z / 100, checkPoints.z[this.fpnt[n28]] / 100) < 2000) {
                                    this.forget = false;
                                    this.actwait = 0;
                                    this.upwait = 0;
                                    this.turntyp = 2;
                                    this.randtcnt = -1;
                                    this.acuracy = 0;
                                    this.rampp = 0;
                                    this.trfix = 3;
                                }
                            }
                            if (this.trfix == 3) {
                                mad.nofocus = true;
                            }
                        }
                    }
                    if (this.turncnt > this.randtcnt) {
                        if (!this.gowait) {
                            int n29 = 0;
                            if (checkPoints.x[n13] - contO.x >= 0) {
                                n29 = 180;
                            }
                            float divisor = checkPoints.x[n13] - contO.x;
                            if (divisor == 0.0f) {
                              divisor = 1;
                            }
                            this.pan = (int)(90 + n29 + Math.atan((checkPoints.z[n13] - contO.z) / (divisor)) / 0.017453292519943295);
                        }
                        else {
                            int n30 = 0;
                            if (this.wtx - contO.x >= 0) {
                                n30 = 180;
                            }
                            this.pan = (int)(90 + n30 + Math.atan((this.wtz - contO.z) / (this.wtx - contO.x)) / 0.017453292519943295);
                        }
                        this.turncnt = 0;
                        this.randtcnt = (int)(this.acuracy * this.m.random());
                    }
                    else {
                        ++this.turncnt;
                    }
                }
                else {
                    this.up = true;
                    int n31 = 0;
                    final int n32 = (int)(this.pys(contO.x, checkPoints.opx[this.acr], contO.z, checkPoints.opz[this.acr]) / 2.0f * this.aim);
                    final int n33 = (int)(checkPoints.opx[this.acr] - n32 * this.m.sin(checkPoints.omxz[this.acr]));
                    final int n34 = (int)(checkPoints.opz[this.acr] + n32 * this.m.cos(checkPoints.omxz[this.acr]));
                    if (n33 - contO.x >= 0) {
                        n31 = 180;
                    }
                    float divisor = n33 - contO.x;
                    if (divisor == 0.0f) {
                      divisor = 1;
                    }
                    this.pan = (int)(90 + n31 + Math.atan((n34 - contO.z) / (divisor)) / 0.017453292519943295);
                    --this.attack;
                    if (this.attack <= 0) {
                        this.attack = 0;
                    }
                    if (checkPoints.stage == 25 && this.exitattack && !this.bulistc && mad.missedcp != 0) {
                        this.attack = 0;
                    }
                    if (checkPoints.stage == 26 && mad.cn == 13 && (checkPoints.clear[0] == 4 || checkPoints.clear[0] == 13 || checkPoints.clear[0] == 21)) {
                        this.attack = 0;
                    }
                    if (checkPoints.stage == 26 && mad.missedcp != 0 && (checkPoints.pos[mad.im] == 0 || (checkPoints.pos[mad.im] == 1 && checkPoints.pos[0] == 0))) {
                        this.attack = 0;
                    }
                    if (checkPoints.stage == 26 && checkPoints.pos[0] > checkPoints.pos[mad.im] && mad.power < 80.0f) {
                        this.attack = 0;
                    }
                }
                int xz2 = contO.xz;
                if (this.zyinv) {
                    xz2 += 180;
                }
                while (xz2 < 0) {
                    xz2 += 360;
                }
                while (xz2 > 180) {
                    xz2 -= 360;
                }
                while (this.pan < 0) {
                    this.pan += 360;
                }
                while (this.pan > 180) {
                    this.pan -= 360;
                }
                if (this.wall != -1 && this.hold == 0) {
                    this.clrnce = 0;
                }
                if (this.hold == 0) {
                    if (Math.abs(xz2 - this.pan) < 180) {
                        if (Math.abs(xz2 - this.pan) > this.clrnce) {
                            if (xz2 < this.pan) {
                                this.left = true;
                                this.lastl = true;
                            }
                            else {
                                this.right = true;
                                this.lastl = false;
                            }
                            if (Math.abs(xz2 - this.pan) > 50 && mad.speed > mad.cd.swits[mad.cn][0] && this.turntyp != 0) {
                                if (this.turntyp == 1) {
                                    this.down = true;
                                }
                                if (this.turntyp == 2) {
                                    this.handb = true;
                                }
                                if (!this.agressed) {
                                    this.up = false;
                                }
                            }
                        }
                    }
                    else if (Math.abs(xz2 - this.pan) < 360 - this.clrnce) {
                        if (xz2 < this.pan) {
                            this.right = true;
                            this.lastl = false;
                        }
                        else {
                            this.left = true;
                            this.lastl = true;
                        }
                        if (Math.abs(xz2 - this.pan) < 310 && mad.speed > mad.cd.swits[mad.cn][0] && this.turntyp != 0) {
                            if (this.turntyp == 1) {
                                this.down = true;
                            }
                            if (this.turntyp == 2) {
                                this.handb = true;
                            }
                            if (!this.agressed) {
                                this.up = false;
                            }
                        }
                    }
                }
                if (checkPoints.stage == 24 && this.wall != -1) {
                    if (trackers.dam[this.wall] == 0 || mad.pcleared == 45) {
                        this.wall = -1;
                    }
                    if (mad.pcleared == 58 && checkPoints.opz[mad.im] < 36700) {
                        this.wall = -1;
                        this.hold = 0;
                    }
                }
                if (this.wall != -1) {
                    if (this.lwall != this.wall) {
                        if (this.lastl) {
                            this.left = true;
                        }
                        else {
                            this.right = true;
                        }
                        this.wlastl = this.lastl;
                        this.lwall = this.wall;
                    }
                    else if (this.wlastl) {
                        this.left = true;
                    }
                    else {
                        this.right = true;
                    }
                    if (trackers.dam[this.wall] != 0) {
                        int n35 = 1;
                        if (trackers.skd[this.wall] == 1) {
                            n35 = 3;
                        }
                        this.hold += n35;
                        if (this.hold > 10 * n35) {
                            this.hold = 10 * n35;
                        }
                    }
                    else {
                        this.hold = 1;
                    }
                    this.wall = -1;
                }
                else if (this.hold != 0) {
                    --this.hold;
                }
            }
            else {
                if (this.trickfase == 0) {
                    final int n36 = (int)((mad.scy[0] + mad.scy[1] + mad.scy[2] + mad.scy[3]) * (contO.y - 300) / 4000.0f);
                    int n37 = 3;
                    if (checkPoints.stage == 25) {
                        n37 = 10;
                    }
                    if (n36 > 7 && (this.m.random() > this.trickprf / n37 || this.stuntf == 4 || this.stuntf == 3 || this.stuntf == 5 || this.stuntf == 6 || checkPoints.stage == 26)) {
                        this.oxy = mad.pxy;
                        this.ozy = mad.pzy;
                        this.flycnt = 0;
                        this.uddirect = 0;
                        this.lrdirect = 0;
                        this.udswt = false;
                        this.lrswt = false;
                        this.trickfase = 1;
                        if (n36 < 16) {
                            if (this.stuntf != 6) {
                                this.uddirect = -1;
                                this.udstart = 0;
                                this.udswt = false;
                            }
                            else if (this.oupnt != 70) {
                                this.uddirect = 1;
                                this.udstart = 0;
                                this.udswt = false;
                            }
                        }
                        else if ((this.m.random() > this.m.random() && this.stuntf != 1) || this.stuntf == 4 || this.stuntf == 6 || this.stuntf == 7 || this.stuntf == 17) {
                            if ((this.m.random() > this.m.random() || this.stuntf == 2 || this.stuntf == 7) && this.stuntf != 4 && this.stuntf != 6) {
                                this.uddirect = -1;
                            }
                            else {
                                this.uddirect = 1;
                            }
                            this.udstart = (int)(10.0f * this.m.random() * this.trickprf);
                            if (this.stuntf == 6) {
                                this.udstart = 0;
                            }
                            if (checkPoints.stage == 26) {
                                this.udstart = 0;
                            }
                            if (checkPoints.stage == 24 && (this.oupnt == 68 || this.oupnt == 69)) {
                                this.apunch = 20;
                                this.oupnt = 70;
                            }
                            if (this.m.random() > 0.85 && this.stuntf != 4 && this.stuntf != 3 && this.stuntf != 6 && this.stuntf != 17 && checkPoints.stage != 26) {
                                this.udswt = true;
                            }
                            if (this.m.random() > this.trickprf + 0.3f && this.stuntf != 4 && this.stuntf != 6) {
                                if (this.m.random() > this.m.random()) {
                                    this.lrdirect = -1;
                                }
                                else {
                                    this.lrdirect = 1;
                                }
                                this.lrstart = (int)(30.0f * this.m.random());
                                if (this.m.random() > 0.75) {
                                    this.lrswt = true;
                                }
                            }
                        }
                        else {
                            if (this.m.random() > this.m.random()) {
                                this.lrdirect = -1;
                            }
                            else {
                                this.lrdirect = 1;
                            }
                            this.lrstart = (int)(10.0f * this.m.random() * this.trickprf);
                            if (this.m.random() > 0.75 && checkPoints.stage != 26) {
                                this.lrswt = true;
                            }
                            if (this.m.random() > this.trickprf + 0.3f) {
                                if (this.m.random() > this.m.random()) {
                                    this.uddirect = -1;
                                }
                                else {
                                    this.uddirect = 1;
                                }
                                this.udstart = (int)(30.0f * this.m.random());
                                if (this.m.random() > 0.85) {
                                    this.udswt = true;
                                }
                            }
                        }
                        if (this.trfix == 3 || this.trfix == 4) {
                            if (checkPoints.stage != 18 && checkPoints.stage != 8) {
                                if (checkPoints.stage != 25 && this.lrdirect == -1) {
                                    if (checkPoints.stage != 19) {
                                        this.uddirect = -1;
                                    }
                                    else {
                                        this.uddirect = 1;
                                    }
                                }
                                this.lrdirect = 0;
                                if ((checkPoints.stage == 19 || checkPoints.stage == 25) && this.uddirect == -1) {
                                    this.uddirect = 1;
                                }
                                if (mad.power < 60.0f) {
                                    this.uddirect = -1;
                                }
                            }
                            else {
                                if (this.uddirect != 0) {
                                    this.uddirect = -1;
                                }
                                this.lrdirect = 0;
                            }
                            if (checkPoints.stage == 20) {
                                this.uddirect = 1;
                                this.lrdirect = 0;
                            }
                            if (checkPoints.stage == 26) {
                                this.uddirect = -1;
                                this.lrdirect = 0;
                                if (mad.cn != 11 && mad.cn != 13) {
                                    this.udstart = 7;
                                    if (mad.cn == 14 && mad.power > 30.0f) {
                                        this.udstart = 14;
                                    }
                                }
                                else {
                                    this.udstart = 0;
                                }
                                if (mad.cn == 11) {
                                    this.lrdirect = -1;
                                    this.lrstart = 0;
                                }
                            }
                        }
                    }
                    else {
                        this.trickfase = -1;
                    }
                    if (!this.afta) {
                        this.afta = true;
                    }
                    if (this.trfix == 3) {
                        this.trfix = 4;
                        this.statusque += 30;
                    }
                }
                if (this.trickfase == 1) {
                    ++this.flycnt;
                    if (this.lrdirect != 0 && this.flycnt > this.lrstart) {
                        if (this.lrswt && Math.abs(mad.pxy - this.oxy) > 180) {
                            if (this.lrdirect == -1) {
                                this.lrdirect = 1;
                            }
                            else {
                                this.lrdirect = -1;
                            }
                            this.lrswt = false;
                        }
                        if (this.lrdirect == -1) {
                            this.handb = true;
                            this.left = true;
                        }
                        else {
                            this.handb = true;
                            this.right = true;
                        }
                    }
                    if (this.uddirect != 0 && this.flycnt > this.udstart) {
                        if (this.udswt && Math.abs(mad.pzy - this.ozy) > 180) {
                            if (this.uddirect == -1) {
                                this.uddirect = 1;
                            }
                            else {
                                this.uddirect = -1;
                            }
                            this.udswt = false;
                        }
                        if (this.uddirect == -1) {
                            this.handb = true;
                            this.down = true;
                        }
                        else {
                            this.handb = true;
                            this.up = true;
                            if (this.apunch > 0) {
                                this.down = true;
                                --this.apunch;
                            }
                        }
                    }
                    if ((mad.scy[0] + mad.scy[1] + mad.scy[2] + mad.scy[3]) * 100.0f / (contO.y - 300) < -this.saftey) {
                        this.onceu = false;
                        this.onced = false;
                        this.oncel = false;
                        this.oncer = false;
                        this.lrcomp = false;
                        this.udcomp = false;
                        this.udbare = false;
                        this.lrbare = false;
                        this.trickfase = 2;
                        this.swat = 0;
                    }
                }
                if (this.trickfase == 2) {
                    if (this.swat == 0) {
                        if (mad.dcomp != 0.0f || mad.ucomp != 0.0f) {
                            this.udbare = true;
                        }
                        if (mad.lcomp != 0.0f || mad.rcomp != 0.0f) {
                            this.lrbare = true;
                        }
                        this.swat = 1;
                    }
                    if (mad.wtouch) {
                        if (this.swat == 1) {
                            this.swat = 2;
                        }
                    }
                    else if (this.swat == 2) {
                        if (mad.capsized && this.m.random() > this.mustland) {
                            if (this.udbare) {
                                this.lrbare = true;
                                this.udbare = false;
                            }
                            else if (this.lrbare) {
                                this.udbare = true;
                                this.lrbare = false;
                            }
                        }
                        this.swat = 3;
                    }
                    if (this.udbare) {
                        int n38;
                        for (n38 = mad.pzy + 90; n38 < 0; n38 += 360) {}
                        while (n38 > 180) {
                            n38 -= 360;
                        }
                        final int abs = Math.abs(n38);
                        if (mad.lcomp - mad.rcomp < 5.0f && (this.onced || this.onceu)) {
                            this.udcomp = true;
                        }
                        if (mad.dcomp > mad.ucomp) {
                            if (mad.capsized) {
                                if (this.udcomp) {
                                    if (abs > 90) {
                                        this.up = true;
                                    }
                                    else {
                                        this.down = true;
                                    }
                                }
                                else if (!this.onced) {
                                    this.down = true;
                                }
                            }
                            else {
                                if (this.udcomp) {
                                    if (this.perfection && Math.abs(abs - 90) > 30) {
                                        if (abs > 90) {
                                            this.up = true;
                                        }
                                        else {
                                            this.down = true;
                                        }
                                    }
                                }
                                else if (this.m.random() > this.mustland) {
                                    this.up = true;
                                }
                                this.onced = true;
                            }
                        }
                        else if (mad.capsized) {
                            if (this.udcomp) {
                                if (abs > 90) {
                                    this.up = true;
                                }
                                else {
                                    this.down = true;
                                }
                            }
                            else if (!this.onceu) {
                                this.up = true;
                            }
                        }
                        else {
                            if (this.udcomp) {
                                if (this.perfection && Math.abs(abs - 90) > 30) {
                                    if (abs > 90) {
                                        this.up = true;
                                    }
                                    else {
                                        this.down = true;
                                    }
                                }
                            }
                            else if (this.m.random() > this.mustland) {
                                this.down = true;
                            }
                            this.onceu = true;
                        }
                    }
                    if (this.lrbare) {
                        int n39 = mad.pxy + 90;
                        if (this.zyinv) {
                            n39 += 180;
                        }
                        while (n39 < 0) {
                            n39 += 360;
                        }
                        while (n39 > 180) {
                            n39 -= 360;
                        }
                        final int abs2 = Math.abs(n39);
                        if (mad.lcomp - mad.rcomp < 10.0f && (this.oncel || this.oncer)) {
                            this.lrcomp = true;
                        }
                        if (mad.lcomp > mad.rcomp) {
                            if (mad.capsized) {
                                if (this.lrcomp) {
                                    if (abs2 > 90) {
                                        this.left = true;
                                    }
                                    else {
                                        this.right = true;
                                    }
                                }
                                else if (!this.oncel) {
                                    this.left = true;
                                }
                            }
                            else {
                                if (this.lrcomp) {
                                    if (this.perfection && Math.abs(abs2 - 90) > 30) {
                                        if (abs2 > 90) {
                                            this.left = true;
                                        }
                                        else {
                                            this.right = true;
                                        }
                                    }
                                }
                                else if (this.m.random() > this.mustland) {
                                    this.right = true;
                                }
                                this.oncel = true;
                            }
                        }
                        else if (mad.capsized) {
                            if (this.lrcomp) {
                                if (abs2 > 90) {
                                    this.left = true;
                                }
                                else {
                                    this.right = true;
                                }
                            }
                            else if (!this.oncer) {
                                this.right = true;
                            }
                        }
                        else {
                            if (this.lrcomp) {
                                if (this.perfection && Math.abs(abs2 - 90) > 30) {
                                    if (abs2 > 90) {
                                        this.left = true;
                                    }
                                    else {
                                        this.right = true;
                                    }
                                }
                            }
                            else if (this.m.random() > this.mustland) {
                                this.left = true;
                            }
                            this.oncer = true;
                        }
                    }
                }
            }
        }
    }

    public int py(final int n, final int n2, final int n3, final int n4) {
        return (n - n2) * (n - n2) + (n3 - n4) * (n3 - n4);
    }

    public int pys(final int n, final int n2, final int n3, final int n4) {
        return (int)Math.sqrt((n - n2) * (n - n2) + (n3 - n4) * (n3 - n4));
    }
}
