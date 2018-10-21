import java.io.FileReader;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.net.URL;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;

public class CarDefine implements Runnable
{
    Trackers t;
    GameSparker gs;
    ContO[] bco;
    Medium m;
    Thread carloader;
    Thread actionloader;
    Thread stageaction;
    int[][] swits;
    float[][] acelf;
    int[] handb;
    float[] airs;
    int[] airc;
    int[] turn;
    float[] grip;
    float[] bounce;
    float[] simag;
    float[] moment;
    float[] comprad;
    int[] push;
    int[] revpush;
    int[] lift;
    int[] revlift;
    int[] powerloss;
    int[] flipy;
    int[] msquash;
    int[] clrad;
    float[] dammult;
    int[] maxmag;
    float[] dishandle;
    float[] outdam;
    int[] cclass;
    String[] names;
    int[] enginsignature;
    int lastload;
    int nlcars;
    int nlocars;
    int xnlocars;
    boolean[] include;
    String[] createdby;
    int[] publish;
    String[] loadnames;
    int nl;
    int action;
    boolean carlon;
    int reco;
    int[] lcardate;
    int haltload;
    int onloadingcar;
    int ac;
    String acname;
    String fails;
    String tnickey;
    String tclan;
    String tclankey;
    int loadlist;
    int[] adds;
    String viewname;
    int staction;
    String onstage;
    int inslot;
    int roundslot;
    String lastcar;
    int msloaded;
    int[] top20adds;

    public CarDefine(final ContO[] bco, final Medium m, final Trackers t, final GameSparker gs) {
        this.swits = new int[][] { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 }, { 76, 195, 298 }, { 70, 170, 275 }, { 70, 202, 293 }, { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 }, { 90, 190, 276 }, { 70, 200, 295 }, { 50, 160, 270 }, { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 }, { 70, 210, 290 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        this.acelf = new float[][] { { 11.0f, 5.0f, 3.0f }, { 14.0f, 7.0f, 5.0f }, { 10.0f, 5.0f, 3.5f }, { 11.0f, 6.0f, 3.5f }, { 10.0f, 5.0f, 3.5f }, { 12.0f, 6.0f, 3.0f }, { 7.0f, 9.0f, 4.0f }, { 11.0f, 5.0f, 3.0f }, { 12.0f, 7.0f, 4.0f }, { 12.0f, 7.0f, 3.5f }, { 11.5f, 6.5f, 3.5f }, { 9.0f, 5.0f, 3.0f }, { 13.0f, 7.0f, 4.5f }, { 7.5f, 3.5f, 3.0f }, { 11.0f, 7.5f, 4.0f }, { 12.0f, 6.0f, 3.5f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f } };
        this.handb = new int[] { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.airs = new float[] { 1.0f, 1.2f, 0.95f, 1.0f, 2.2f, 1.0f, 0.9f, 0.8f, 1.0f, 0.9f, 1.15f, 0.8f, 1.0f, 0.3f, 1.3f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.airc = new int[] { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.turn = new int[] { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.grip = new float[] { 20.0f, 27.0f, 18.0f, 22.0f, 19.0f, 20.0f, 25.0f, 20.0f, 19.0f, 24.0f, 22.5f, 25.0f, 30.0f, 27.0f, 25.0f, 27.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.bounce = new float[] { 1.2f, 1.05f, 1.3f, 1.15f, 1.3f, 1.2f, 1.15f, 1.1f, 1.2f, 1.1f, 1.15f, 0.8f, 1.05f, 0.8f, 1.1f, 1.15f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.simag = new float[] { 0.9f, 0.85f, 1.05f, 0.9f, 0.85f, 0.9f, 1.05f, 0.9f, 1.0f, 1.05f, 0.9f, 1.1f, 0.9f, 1.3f, 0.9f, 1.15f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.moment = new float[] { 1.3f, 0.75f, 1.4f, 1.2f, 1.1f, 1.38f, 1.43f, 1.48f, 1.35f, 1.7f, 1.42f, 2.0f, 1.26f, 3.0f, 1.5f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.comprad = new float[] { 0.5f, 0.4f, 0.8f, 0.5f, 0.4f, 0.5f, 0.5f, 0.5f, 0.5f, 0.8f, 0.5f, 1.5f, 0.5f, 0.8f, 0.5f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.push = new int[] { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.revpush = new int[] { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.lift = new int[] { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.revlift = new int[] { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.powerloss = new int[] { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000, 2750000, 4500000, 3500000, 16700000, 3000000, 5500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.flipy = new int[] { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.msquash = new int[] { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.clrad = new int[] { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.dammult = new float[] { 0.75f, 0.8f, 0.45f, 0.8f, 0.42f, 0.7f, 0.72f, 0.6f, 0.58f, 0.41f, 0.67f, 0.45f, 0.61f, 0.25f, 0.38f, 0.52f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.maxmag = new int[] { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 45000, 5800, 18000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.dishandle = new float[] { 0.65f, 0.6f, 0.55f, 0.77f, 0.62f, 0.9f, 0.6f, 0.72f, 0.45f, 0.8f, 0.95f, 0.4f, 0.87f, 0.42f, 1.0f, 0.95f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.outdam = new float[] { 0.68f, 0.35f, 0.8f, 0.5f, 0.42f, 0.76f, 0.82f, 0.76f, 0.72f, 0.62f, 0.79f, 0.95f, 0.77f, 1.0f, 0.85f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.cclass = new int[] { 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.names = new String[] { "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
        this.enginsignature = new int[] { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.lastload = 0;
        this.nlcars = 0;
        this.nlocars = 0;
        this.xnlocars = 0;
        this.include = new boolean[40];
        this.createdby = new String[40];
        this.publish = new int[40];
        this.loadnames = new String[20];
        this.nl = 0;
        this.action = 0;
        this.carlon = false;
        this.reco = -2;
        this.lcardate = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.haltload = 0;
        this.onloadingcar = 0;
        this.ac = -1;
        this.acname = "Radical One";
        this.fails = "";
        this.tnickey = "";
        this.tclan = "";
        this.tclankey = "";
        this.loadlist = 0;
        this.adds = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.viewname = "";
        this.staction = 0;
        this.onstage = "";
        this.inslot = -1;
        this.roundslot = 0;
        this.lastcar = "";
        this.msloaded = 0;
        this.top20adds = new int[20];
        this.bco = bco;
        this.m = m;
        this.t = t;
        this.gs = gs;
    }

    public void loadstat(final byte[] array, final String s, final int n, final int n2, final int n3, final int n4) {
        this.names[n4] = s;
        boolean b = false;
        boolean b2 = false;
        final int[] array2 = { 128, 128, 128, 128, 128 };
        int n5 = 640;
        final int[] array3 = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
        final int[] array4 = { 50, 50, 50 };
        this.enginsignature[n4] = 0;
        float n6 = 0.0f;
        this.publish[n4 - 16] = 0;
        this.createdby[n4 - 16] = "Unkown User";
        try {
            final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(array));
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                final String trim = line.trim();
                if (trim.startsWith("stat(")) {
                    try {
                        n5 = 0;
                        for (int i = 0; i < 5; ++i) {
                            array2[i] = this.getvalue("stat", trim, i);
                            if (array2[i] > 200) {
                                array2[i] = 200;
                            }
                            if (array2[i] < 16) {
                                array2[i] = 16;
                            }
                            n5 += array2[i];
                        }
                        b = true;
                    }
                    catch (Exception ex2) {
                        b = false;
                    }
                }
                if (trim.startsWith("physics(")) {
                    try {
                        for (int j = 0; j < 11; ++j) {
                            array3[j] = this.getvalue("physics", trim, j);
                            if (array3[j] > 100) {
                                array3[j] = 100;
                            }
                            if (array3[j] < 0) {
                                array3[j] = 0;
                            }
                        }
                        for (int k = 0; k < 3; ++k) {
                            array4[k] = this.getvalue("physics", trim, k + 11);
                            if (k != 0 && array4[k] > 100) {
                                array4[k] = 100;
                            }
                            if (array4[k] < 0) {
                                array4[k] = 0;
                            }
                        }
                        this.enginsignature[n4] = this.getvalue("physics", trim, 14);
                        if (this.enginsignature[n4] > 4) {
                            this.enginsignature[n4] = 0;
                        }
                        if (this.enginsignature[n4] < 0) {
                            this.enginsignature[n4] = 0;
                        }
                        n6 = this.getvalue("physics", trim, 15);
                        if (n6 > 0.0f) {
                            b2 = true;
                        }
                    }
                    catch (Exception ex3) {
                        b2 = false;
                    }
                }
                if (trim.startsWith("handling(")) {
                    try {
                        int getvalue = this.getvalue("handling", trim, 0);
                        if (getvalue > 200) {
                            getvalue = 200;
                        }
                        if (getvalue < 50) {
                            getvalue = 50;
                        }
                        this.dishandle[n4] = getvalue / 200.0f;
                    }
                    catch (Exception ex4) {}
                }
                if (trim.startsWith("carmaker(")) {
                    this.createdby[n4 - 16] = this.getSvalue("carmaker", trim, 0);
                }
                if (trim.startsWith("publish(")) {
                    this.publish[n4 - 16] = this.getvalue("publish", trim, 0);
                }
            }
            dataInputStream.close();
        }
        catch (Exception ex) {
            System.out.println("Error Loading Car Stat: " + ex);
        }
        if (b && b2) {
            int l = 0;
            if (n5 > 680) {
                l = 680 - n5;
            }
            if (n5 > 640 && n5 < 680) {
                l = 640 - n5;
            }
            if (n5 > 600 && n5 < 640) {
                l = 600 - n5;
            }
            if (n5 > 560 && n5 < 600) {
                l = 560 - n5;
            }
            if (n5 > 520 && n5 < 560) {
                l = 520 - n5;
            }
            if (n5 < 520) {
                l = 520 - n5;
            }
            while (l != 0) {
                for (int n7 = 0; n7 < 5; ++n7) {
                    if (l > 0 && array2[n7] < 200) {
                        final int[] array5 = array2;
                        final int n8 = n7;
                        ++array5[n8];
                        --l;
                    }
                    if (l < 0 && array2[n7] > 16) {
                        final int[] array6 = array2;
                        final int n9 = n7;
                        --array6[n9];
                        ++l;
                    }
                }
            }
            int n10 = 0;
            for (int n11 = 0; n11 < 5; ++n11) {
                n10 += array2[n11];
            }
            if (n10 == 520) {
                this.cclass[n4] = 0;
            }
            if (n10 == 560) {
                this.cclass[n4] = 1;
            }
            if (n10 == 600) {
                this.cclass[n4] = 2;
            }
            if (n10 == 640) {
                this.cclass[n4] = 3;
            }
            if (n10 == 680) {
                this.cclass[n4] = 4;
            }
            int n12 = 0;
            int n13 = 0;
            float n14 = 0.5f;
            if (array2[0] == 200) {
                n12 = 1;
                n13 = 1;
            }
            if (array2[0] > 192 && array2[0] < 200) {
                n12 = 12;
                n13 = 1;
                n14 = (array2[0] - 192) / 8.0f;
            }
            if (array2[0] == 192) {
                n12 = 12;
                n13 = 12;
            }
            if (array2[0] > 148 && array2[0] < 192) {
                n12 = 14;
                n13 = 12;
                n14 = (array2[0] - 148) / 44.0f;
            }
            if (array2[0] == 148) {
                n12 = 14;
                n13 = 14;
            }
            if (array2[0] > 133 && array2[0] < 148) {
                n12 = 10;
                n13 = 14;
                n14 = (array2[0] - 133) / 15.0f;
            }
            if (array2[0] == 133) {
                n12 = 10;
                n13 = 10;
            }
            if (array2[0] > 112 && array2[0] < 133) {
                n12 = 15;
                n13 = 10;
                n14 = (array2[0] - 112) / 21.0f;
            }
            if (array2[0] == 112) {
                n12 = 15;
                n13 = 15;
            }
            if (array2[0] > 107 && array2[0] < 112) {
                n12 = 11;
                n13 = 15;
                n14 = (array2[0] - 107) / 5.0f;
            }
            if (array2[0] == 107) {
                n12 = 11;
                n13 = 11;
            }
            if (array2[0] > 88 && array2[0] < 107) {
                n12 = 13;
                n13 = 11;
                n14 = (array2[0] - 88) / 19.0f;
            }
            if (array2[0] == 88) {
                n12 = 13;
                n13 = 13;
            }
            if (array2[0] > 88) {
                this.swits[n4][0] = (int)((this.swits[n13][0] - this.swits[n12][0]) * n14 + this.swits[n12][0]);
                this.swits[n4][1] = (int)((this.swits[n13][1] - this.swits[n12][1]) * n14 + this.swits[n12][1]);
                this.swits[n4][2] = (int)((this.swits[n13][2] - this.swits[n12][2]) * n14 + this.swits[n12][2]);
            }
            else {
                float n15 = array2[0] / 88.0f;
                if (n15 < 0.76) {
                    n15 = 0.76f;
                }
                this.swits[n4][0] = (int)(50.0f * n15);
                this.swits[n4][1] = (int)(130.0f * n15);
                this.swits[n4][2] = (int)(210.0f * n15);
            }
            int n16 = 0;
            int n17 = 0;
            float n18 = 0.5f;
            if (array2[1] == 200) {
                n16 = 1;
                n17 = 1;
            }
            if (array2[1] > 150 && array2[1] < 200) {
                n16 = 14;
                n17 = 1;
                n18 = (array2[1] - 150) / 50.0f;
            }
            if (array2[1] == 150) {
                n16 = 14;
                n17 = 14;
            }
            if (array2[1] > 144 && array2[1] < 150) {
                n16 = 9;
                n17 = 14;
                n18 = (array2[1] - 144) / 6.0f;
            }
            if (array2[1] == 144) {
                n16 = 9;
                n17 = 9;
            }
            if (array2[1] > 139 && array2[1] < 144) {
                n16 = 6;
                n17 = 9;
                n18 = (array2[1] - 139) / 5.0f;
            }
            if (array2[1] == 139) {
                n16 = 6;
                n17 = 6;
            }
            if (array2[1] > 128 && array2[1] < 139) {
                n16 = 15;
                n17 = 6;
                n18 = (array2[1] - 128) / 11.0f;
            }
            if (array2[1] == 128) {
                n16 = 15;
                n17 = 15;
            }
            if (array2[1] > 122 && array2[1] < 128) {
                n16 = 10;
                n17 = 15;
                n18 = (array2[1] - 122) / 6.0f;
            }
            if (array2[1] == 122) {
                n16 = 10;
                n17 = 10;
            }
            if (array2[1] > 119 && array2[1] < 122) {
                n16 = 3;
                n17 = 10;
                n18 = (array2[1] - 119) / 3.0f;
            }
            if (array2[1] == 119) {
                n16 = 3;
                n17 = 3;
            }
            if (array2[1] > 98 && array2[1] < 119) {
                n16 = 5;
                n17 = 3;
                n18 = (array2[1] - 98) / 21.0f;
            }
            if (array2[1] == 98) {
                n16 = 5;
                n17 = 5;
            }
            if (array2[1] > 81 && array2[1] < 98) {
                n16 = 0;
                n17 = 5;
                n18 = (array2[1] - 81) / 17.0f;
            }
            if (array2[1] == 81) {
                n16 = 0;
                n17 = 0;
            }
            if (array2[1] <= 80) {
                n16 = 2;
                n17 = 2;
            }
            if (array2[0] <= 88) {
                n16 = 13;
                n17 = 13;
            }
            this.acelf[n4][0] = (this.acelf[n17][0] - this.acelf[n16][0]) * n18 + this.acelf[n16][0];
            this.acelf[n4][1] = (this.acelf[n17][1] - this.acelf[n16][1]) * n18 + this.acelf[n16][1];
            this.acelf[n4][2] = (this.acelf[n17][2] - this.acelf[n16][2]) * n18 + this.acelf[n16][2];
            if (array2[1] <= 70 && array2[0] > 88) {
                this.acelf[n4][0] = 9.0f;
                this.acelf[n4][1] = 4.0f;
                this.acelf[n4][2] = 3.0f;
            }
            float n19 = (array2[2] - 88) / 109.0f;
            if (n19 > 1.0f) {
                n19 = 1.0f;
            }
            if (n19 < -0.55) {
                n19 = -0.55f;
            }
            this.airs[n4] = 0.55f + 0.45f * n19 + 0.4f * (array3[9] / 100.0f);
            if (this.airs[n4] < 0.3) {
                this.airs[n4] = 0.3f;
            }
            this.airc[n4] = (int)(10.0f + 70.0f * n19 + 30.0f * (array3[10] / 100.0f));
            if (this.airc[n4] < 0) {
                this.airc[n4] = 0;
            }
            int n20 = (int)(670.0f - (array3[9] + array3[10]) / 200.0f * 420.0f);
            if (array2[0] <= 88) {
                n20 = (int)(1670.0f - (array3[9] + array3[10]) / 200.0f * 1420.0f);
            }
            if (array2[2] > 190 && n20 < 300) {
                n20 = 300;
            }
            this.powerloss[n4] = n20 * 10000;
            this.moment[n4] = 0.7f + (array2[3] - 16) / 184.0f * 1.0f;
            if (array2[0] < 110) {
                this.moment[n4] = 0.75f + (array2[3] - 16) / 184.0f * 1.25f;
            }
            if (array2[3] == 200 && array2[4] == 200 && array2[0] <= 88) {
                this.moment[n4] = 3.0f;
            }
            float n21 = 0.9f + (array2[4] - 90) * 0.01f;
            if (n21 < 0.6) {
                n21 = 0.6f;
            }
            if (array2[4] == 200 && array2[0] <= 88) {
                n21 = 3.0f;
            }
            this.maxmag[n4] = (int)(n6 * n21);
            this.outdam[n4] = 0.35f + (n21 - 0.6f) * 0.5f;
            if (this.outdam[n4] < 0.35) {
                this.outdam[n4] = 0.35f;
            }
            if (this.outdam[n4] > 1.0f) {
                this.outdam[n4] = 1.0f;
            }
            this.clrad[n4] = (int)(array4[0] * array4[0] * 1.5);
            if (this.clrad[n4] < 1000) {
                this.clrad[n4] = 1000;
            }
            this.dammult[n4] = 0.3f + array4[1] * 0.005f;
            this.msquash[n4] = (int)(2.0 + array4[2] / 7.6);
            this.flipy[n4] = n2;
            this.handb[n4] = (int)(7.0f + array3[0] / 100.0f * 8.0f);
            this.turn[n4] = (int)(4.0f + array3[1] / 100.0f * 6.0f);
            this.grip[n4] = 16.0f + array3[2] / 100.0f * 14.0f;
            if (this.grip[n4] < 21.0f) {
                final int[] array7 = this.swits[n4];
                final int n22 = 0;
                array7[n22] += (int)(40.0f * ((21.0f - this.grip[n4]) / 5.0f));
                if (this.swits[n4][0] > 100) {
                    this.swits[n4][0] = 100;
                }
            }
            this.bounce[n4] = 0.8f + array3[3] / 100.0f * 0.6f;
            if (array3[3] > 67) {
                final float[] airs = this.airs;
                airs[n4] *= 0.76f + (1.0f - array3[3] / 100.0f) * 0.24f;
                final int[] airc = this.airc;
                airc[n4] *= (int)(0.76f + (1.0f - array3[3] / 100.0f) * 0.24f);
            }
            this.lift[n4] = (int)(array3[5] * array3[5] / 10000.0f * 30.0f);
            this.revlift[n4] = (int)(array3[6] / 100.0f * 32.0f);
            this.push[n4] = (int)(2.0f + array3[7] / 100.0f * 2.0f * ((30 - this.lift[n4]) / 30));
            this.revpush[n4] = (int)(1.0f + array3[8] / 100.0f * 2.0f);
            this.comprad[n4] = n / 400.0f + (array2[3] - 16) / 184.0f * 0.2f;
            if (this.comprad[n4] < 0.4) {
                this.comprad[n4] = 0.4f;
            }
            this.simag[n4] = (n3 - 17) * 0.0167f + 0.85f;
        }
        else {
            this.names[n4] = "";
        }
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

    public String getSvalue(final String s, final String s2, final int n) {
        String string = "";
        for (int n2 = 0, n3 = s.length() + 1; n3 < s2.length() && n2 <= n; ++n3) {
            final String string2 = "" + s2.charAt(n3);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
            }
            else if (n2 == n) {
                string += string2;
            }
        }
        return string;
    }

    public int servervalue(final String s, final int n) {
        int intValue = -1;
        try {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            String string = "";
            while (n2 < s.length() && n4 != 2) {
                final String string2 = "" + s.charAt(n2);
                if (string2.equals("|")) {
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
            if (string.equals("")) {
                string = "-1";
            }
            intValue = Integer.valueOf(string);
        }
        catch (Exception ex) {}
        return intValue;
    }

    public String serverSvalue(final String s, final int n) {
        String s2 = "";
        try {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            String string = "";
            while (n2 < s.length() && n4 != 2) {
                final String string2 = "" + s.charAt(n2);
                if (string2.equals("|")) {
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

    public void loadready() {
        this.m.csky[0] = 170;
        this.m.csky[1] = 220;
        this.m.csky[2] = 255;
        this.m.cfade[0] = 255;
        this.m.cfade[1] = 220;
        this.m.cfade[2] = 220;
        this.m.snap[0] = 0;
        this.m.snap[1] = 0;
        this.m.snap[2] = 0;
        this.fails = "";
        for (int i = 0; i < 20; ++i) {
            this.loadnames[i] = "";
        }
        this.nl = 0;
        this.action = 0;
    }

    public void sparkactionloader() {
        (this.actionloader = new Thread(this)).start();
    }

    public void sparkcarloader() {
        if (!this.carlon) {
            (this.carloader = new Thread(this)).start();
            this.carlon = true;
        }
    }

    public void sparkstageaction() {
        (this.stageaction = new Thread(this)).start();
    }

    public void stopallnow() {
        this.staction = 0;
        this.action = 0;
        if (this.carloader != null) {
            this.carloader.stop();
            this.carloader = null;
        }
        if (this.actionloader != null) {
            this.actionloader.stop();
            this.actionloader = null;
        }
        if (this.stageaction != null) {
            this.stageaction.stop();
            this.stageaction = null;
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread() == this.actionloader) {
            if (this.action == 10) {
                int servervalue = -1;
                try {
                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println("9|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.names[this.ac] + "|");
                    final String line = bufferedReader.readLine();
                    if (line != null) {
                        servervalue = this.servervalue(line, 0);
                    }
                    socket.close();
                    bufferedReader.close();
                    printWriter.close();
                }
                catch (Exception ex3) {
                    servervalue = -1;
                }
                if (servervalue == 0) {
                    this.action = 3;
                }
                else {
                    this.action = -10;
                }
                System.gc();
            }
            if (this.action == 1) {
                this.reco = -1;
                try {
                    final Socket socket2 = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                    final PrintWriter printWriter2 = new PrintWriter(socket2.getOutputStream(), true);
                    printWriter2.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
                    final String line2 = bufferedReader2.readLine();
                    if (line2 != null) {
                        this.reco = this.servervalue(line2, 0);
                        if (this.reco == 0 || this.reco == 3 || this.reco > 10) {
                            this.tnickey = this.serverSvalue(line2, 1);
                            if (this.reco != -167) {
                                this.tclan = this.serverSvalue(line2, 2);
                                this.tclankey = this.serverSvalue(line2, 3);
                            }
                            else {
                                this.tclan = "";
                                this.tclankey = "";
                            }
                        }
                    }
                    socket2.close();
                    bufferedReader2.close();
                    printWriter2.close();
                }
                catch (Exception ex4) {
                    this.reco = -1;
                }
                if (this.reco == 0 || this.reco == 3 || this.reco > 10) {
                    this.action = 2;
                }
                else {
                    this.action = 0;
                }
                System.gc();
            }
            while (this.action == 2) {}
            if (this.action == 3) {
                final String[] array = new String[700];
                this.nl = 0;
                try {
                    final DataInputStream dataInputStream = new DataInputStream(new URL("http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").openStream());
                    String line3;
                    while ((line3 = dataInputStream.readLine()) != null) {
                        final String string = "" + line3.trim();
                        if (string.startsWith("mycars")) {
                            int n = 1;
                            while (n != 0 && this.nl < 700) {
                                array[this.nl] = this.getSvalue("mycars", string, this.nl);
                                if (array[this.nl].equals("")) {
                                    n = 0;
                                }
                                else {
                                    ++this.nl;
                                }
                            }
                        }
                    }
                    if (this.nl > 0) {
                        this.action = 4;
                    }
                    else {
                        this.action = -1;
                    }
                    dataInputStream.close();
                }
                catch (Exception ex) {
                    if (("" + ex).indexOf("FileNotFound") != -1) {
                        this.action = -1;
                    }
                    else {
                        this.action = -2;
                    }
                }
                if (this.action == 4) {
                    this.gs.mcars.hide();
                    this.gs.mcars.removeAll();
                    for (int i = 0; i < this.nl; ++i) {
                        this.gs.mcars.add(this.gs.rd, array[i]);
                    }
                    if (this.lastcar.equals("")) {
                        this.gs.mcars.select(0);
                    }
                    else {
                        this.gs.mcars.select(this.lastcar);
                        this.lastcar = "";
                    }
                    for (int j = 0; j < 40; ++j) {
                        this.include[j] = false;
                    }
                    this.roundslot = 16;
                    this.nlocars = 16;
                }
            }
            if (this.action == 4) {
                this.m.csky[0] = 170;
                this.m.csky[1] = 220;
                this.m.csky[2] = 255;
                this.m.cfade[0] = 255;
                this.m.cfade[1] = 220;
                this.m.cfade[2] = 220;
                this.m.snap[0] = 0;
                this.m.snap[1] = 0;
                this.m.snap[2] = 0;
                if (this.loadonlinecar(this.gs.mcars.getSelectedItem(), this.roundslot) == this.roundslot) {
                    this.inslot = this.roundslot;
                    ++this.roundslot;
                    if (this.roundslot == 36) {
                        this.roundslot = 16;
                    }
                    if (this.nlocars < 36) {
                        ++this.nlocars;
                    }
                    this.lastload = 2;
                    this.action = 5;
                }
                else {
                    if (this.lastload == 2) {
                        this.lastload = 0;
                    }
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 6) {
                int servervalue2 = -1;
                try {
                    if (this.ac != -1) {
                        this.acname = this.names[this.ac];
                    }
                    final Socket socket3 = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(socket3.getInputStream()));
                    final PrintWriter printWriter3 = new PrintWriter(socket3.getOutputStream(), true);
                    printWriter3.println("8|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.acname + "|");
                    final String line4 = bufferedReader3.readLine();
                    if (line4 != null) {
                        servervalue2 = this.servervalue(line4, 0);
                    }
                    socket3.close();
                    bufferedReader3.close();
                    printWriter3.close();
                }
                catch (Exception ex5) {
                    servervalue2 = -1;
                }
                if (servervalue2 == 0) {
                    if (this.lastload == 2) {
                        this.lastload = -2;
                        this.lastcar = this.gs.mcars.getSelectedItem();
                    }
                    this.action = 7;
                }
                if (servervalue2 == 3) {
                    this.action = -7;
                }
                if (servervalue2 == 4) {
                    this.action = -8;
                }
                if (this.action == 6) {
                    this.action = -9;
                }
                System.gc();
            }
            if (this.action == 11) {
                this.nl = 0;
                try {
                    String s = "all";
                    if (this.loadlist == 1) {
                        s = "Wall";
                    }
                    if (this.loadlist == 2) {
                        s = "WA";
                    }
                    if (this.loadlist == 3) {
                        s = "WAB";
                    }
                    if (this.loadlist == 4) {
                        s = "WB";
                    }
                    if (this.loadlist == 5) {
                        s = "WBC";
                    }
                    if (this.loadlist == 6) {
                        s = "WC";
                    }
                    if (this.loadlist == 7) {
                        s = "Mall";
                    }
                    if (this.loadlist == 8) {
                        s = "MA";
                    }
                    if (this.loadlist == 9) {
                        s = "MAB";
                    }
                    if (this.loadlist == 10) {
                        s = "MB";
                    }
                    if (this.loadlist == 11) {
                        s = "MBC";
                    }
                    if (this.loadlist == 12) {
                        s = "MC";
                    }
                    if (this.loadlist == 13) {
                        s = "Sall";
                    }
                    if (this.loadlist == 14) {
                        s = "SA";
                    }
                    if (this.loadlist == 15) {
                        s = "SAB";
                    }
                    if (this.loadlist == 16) {
                        s = "SB";
                    }
                    if (this.loadlist == 17) {
                        s = "SBC";
                    }
                    if (this.loadlist == 18) {
                        s = "SC";
                    }
                    if (this.loadlist == 19) {
                        s = "Aall";
                    }
                    if (this.loadlist == 20) {
                        s = "AA";
                    }
                    if (this.loadlist == 21) {
                        s = "AAB";
                    }
                    if (this.loadlist == 22) {
                        s = "AB";
                    }
                    if (this.loadlist == 23) {
                        s = "ABC";
                    }
                    if (this.loadlist == 24) {
                        s = "AC";
                    }
                    final DataInputStream dataInputStream2 = new DataInputStream(new URL("http://multiplayer.needformadness.com/cars/top20/" + s + ".txt").openStream());
                    String line5;
                    while ((line5 = dataInputStream2.readLine()) != null) {
                        final String string2 = "" + line5.trim();
                        if (string2.startsWith("cars")) {
                            int n2 = 1;
                            while (n2 != 0 && this.nl < 20) {
                                this.loadnames[this.nl] = this.getSvalue("cars", string2, this.nl);
                                if (this.loadnames[this.nl].equals("")) {
                                    n2 = 0;
                                }
                                else {
                                    ++this.nl;
                                }
                            }
                        }
                        if (string2.startsWith("adds")) {
                            for (int k = 0; k < this.nl; ++k) {
                                this.adds[k] = this.getvalue("adds", string2, k);
                            }
                        }
                    }
                    if (this.nl > 0) {
                        this.action = 12;
                    }
                    else {
                        this.action = -1;
                    }
                    dataInputStream2.close();
                }
                catch (Exception ex6) {
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 12) {
                this.m.csky[0] = 170;
                this.m.csky[1] = 220;
                this.m.csky[2] = 255;
                this.m.cfade[0] = 255;
                this.m.cfade[1] = 220;
                this.m.cfade[2] = 220;
                this.m.snap[0] = 0;
                this.m.snap[1] = 0;
                this.m.snap[2] = 0;
                this.xnlocars = 36;
                final int nl = this.nl;
                this.nl = 0;
                while (this.nl < nl) {
                    if (this.xnlocars < 56 && this.loadonlinecar(this.loadnames[this.nl], this.xnlocars) == this.xnlocars) {
                        ++this.xnlocars;
                    }
                    ++this.nl;
                }
                this.nl = 0;
                if (this.xnlocars > 36) {
                    this.action = 13;
                }
                else {
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 101) {
                this.nl = 0;
                try {
                    final DataInputStream dataInputStream3 = new DataInputStream(new URL("http://multiplayer.needformadness.com/cars/lists/" + this.viewname + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").openStream());
                    String line6;
                    while ((line6 = dataInputStream3.readLine()) != null) {
                        final String string3 = "" + line6.trim();
                        if (string3.startsWith("mycars")) {
                            int n3 = 1;
                            while (n3 != 0 && this.nl < 20) {
                                this.loadnames[this.nl] = this.getSvalue("mycars", string3, this.nl);
                                if (this.loadnames[this.nl].equals("")) {
                                    n3 = 0;
                                }
                                else {
                                    ++this.nl;
                                }
                            }
                        }
                    }
                    if (this.nl > 0) {
                        this.action = 102;
                    }
                    else {
                        this.action = -2;
                    }
                    dataInputStream3.close();
                }
                catch (Exception ex2) {
                    if (("" + ex2).indexOf("FileNotFound") != -1) {
                        this.action = -2;
                    }
                    else {
                        this.action = -1;
                    }
                }
                System.gc();
            }
            if (this.action == 102) {
                this.m.csky[0] = 170;
                this.m.csky[1] = 220;
                this.m.csky[2] = 255;
                this.m.cfade[0] = 255;
                this.m.cfade[1] = 220;
                this.m.cfade[2] = 220;
                this.m.snap[0] = 0;
                this.m.snap[1] = 0;
                this.m.snap[2] = 0;
                for (int l = 0; l < 40; ++l) {
                    this.include[l] = false;
                }
                this.xnlocars = 36;
                final int nl2 = this.nl;
                this.nl = 0;
                while (this.nl < nl2) {
                    if (this.xnlocars < 56 && this.loadonlinecar(this.loadnames[this.nl], this.xnlocars) == this.xnlocars) {
                        ++this.xnlocars;
                    }
                    ++this.nl;
                }
                this.nl = 0;
                if (this.xnlocars > 36) {
                    this.action = 103;
                }
                else {
                    this.action = -1;
                }
                System.gc();
            }
            this.actionloader = null;
        }
        if (Thread.currentThread() == this.carloader) {
            while (this.nl > 0) {
                int n4 = 0;
                for (int n5 = 16; n5 < 56; ++n5) {
                    if (this.loadnames[this.nl - 1].equals(this.names[n5])) {
                        n4 = -1;
                    }
                }
                if (this.fails.indexOf("|" + this.loadnames[this.nl - 1] + "|") != -1) {
                    n4 = -1;
                }
                if (n4 != -1) {
                    int n6 = this.lcardate[0];
                    int n7 = 36;
                    if (this.haltload > 0) {
                        n7 = 36 + this.haltload;
                        n6 = this.lcardate[this.haltload];
                    }
                    int n8 = n7;
                    for (int n9 = n7; n9 < 56; ++n9) {
                        if (this.lcardate[n9 - 36] < n6) {
                            n6 = this.lcardate[n9 - 36];
                            n8 = n9;
                        }
                    }
                    this.onloadingcar = n8 - 35;
                    if (this.loadonlinecar(this.loadnames[this.nl - 1], n8) == -1) {
                        this.fails = this.fails + "|" + this.loadnames[this.nl - 1] + "|";
                    }
                    else {
                        final int[] lcardate = this.lcardate;
                        final int n10 = n8 - 36;
                        ++lcardate[n10];
                    }
                    this.onloadingcar = 0;
                }
                --this.nl;
                try {
                    final Thread carloader = this.carloader;
                    Thread.sleep(20L);
                }
                catch (InterruptedException ex7) {}
            }
            this.carlon = false;
            this.carloader = null;
        }
        if (Thread.currentThread() == this.stageaction) {
            if (this.staction == 1) {
                int servervalue3 = -1;
                try {
                    final Socket socket4 = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(socket4.getInputStream()));
                    final PrintWriter printWriter4 = new PrintWriter(socket4.getOutputStream(), true);
                    printWriter4.println("19|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.onstage + "|");
                    final String line7 = bufferedReader4.readLine();
                    if (line7 != null) {
                        servervalue3 = this.servervalue(line7, 0);
                    }
                    socket4.close();
                    bufferedReader4.close();
                    printWriter4.close();
                }
                catch (Exception ex8) {
                    servervalue3 = -1;
                }
                if (servervalue3 == 0) {
                    try {
                        this.gs.mstgs.remove(this.onstage);
                    }
                    catch (Exception ex9) {}
                    this.gs.mstgs.select(0);
                    this.staction = 0;
                }
                else {
                    this.staction = -1;
                }
            }
            if (this.staction == 4) {
                this.reco = -1;
                try {
                    final Socket socket5 = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedReader5 = new BufferedReader(new InputStreamReader(socket5.getInputStream()));
                    final PrintWriter printWriter5 = new PrintWriter(socket5.getOutputStream(), true);
                    printWriter5.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
                    final String line8 = bufferedReader5.readLine();
                    if (line8 != null) {
                        this.reco = this.servervalue(line8, 0);
                        if (this.reco == 0 || this.reco == 3 || this.reco > 10) {
                            this.tnickey = this.serverSvalue(line8, 1);
                            if (this.reco != -167) {
                                this.tclan = this.serverSvalue(line8, 2);
                                this.tclankey = this.serverSvalue(line8, 3);
                            }
                            else {
                                this.tclan = "";
                                this.tclankey = "";
                            }
                        }
                    }
                    socket5.close();
                    bufferedReader5.close();
                    printWriter5.close();
                }
                catch (Exception ex10) {
                    this.reco = -1;
                }
                if (this.reco == 0 || this.reco == 3 || this.reco > 10) {
                    this.staction = 5;
                }
                else {
                    this.staction = 3;
                }
                System.gc();
                while (this.staction == 5) {}
            }
            if (this.staction == 2) {
                int servervalue4 = -1;
                if (this.msloaded == 1) {
                    for (int n11 = 1; n11 < this.gs.mstgs.getItemCount(); ++n11) {
                        if (this.gs.mstgs.getItem(n11).equals(this.onstage)) {
                            servervalue4 = 3;
                        }
                    }
                }
                if (servervalue4 == -1) {
                    try {
                        final Socket socket6 = new Socket("multiplayer.needformadness.com", 7061);
                        final BufferedReader bufferedReader6 = new BufferedReader(new InputStreamReader(socket6.getInputStream()));
                        final PrintWriter printWriter6 = new PrintWriter(socket6.getOutputStream(), true);
                        printWriter6.println("18|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.onstage + "|");
                        final String line9 = bufferedReader6.readLine();
                        if (line9 != null) {
                            servervalue4 = this.servervalue(line9, 0);
                        }
                        socket6.close();
                        bufferedReader6.close();
                        printWriter6.close();
                    }
                    catch (Exception ex11) {
                        servervalue4 = -1;
                    }
                }
                this.staction = -1;
                if (servervalue4 == 0) {
                    this.staction = 0;
                    if (this.msloaded == 1) {
                        this.gs.mstgs.addstg(this.onstage);
                    }
                }
                if (servervalue4 == 3) {
                    this.staction = -2;
                }
                if (servervalue4 == 4) {
                    this.staction = -3;
                }
            }
            this.stageaction = null;
        }
    }

    public int loadonlinecar(final String s, int n) {
        try {
            final URL url = new URL(("http://multiplayer.needformadness.com/cars/" + s + ".radq").replace(' ', '_'));
            final int contentLength = url.openConnection().getContentLength();
            final DataInputStream dataInputStream = new DataInputStream(url.openStream());
            final byte[] array = new byte[contentLength];
            dataInputStream.readFully(array);
            ZipInputStream zipInputStream;
            if (array[0] == 80 && array[1] == 75 && array[2] == 3) {
                zipInputStream = new ZipInputStream(new ByteArrayInputStream(array));
            }
            else {
                final byte[] array2 = new byte[contentLength - 40];
                for (int i = 0; i < contentLength - 40; ++i) {
                    int n2 = 20;
                    if (i >= 500) {
                        n2 = 40;
                    }
                    array2[i] = array[i + n2];
                }
                zipInputStream = new ZipInputStream(new ByteArrayInputStream(array2));
            }
            final ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                int j = Integer.valueOf(nextEntry.getName());
                final byte[] array3 = new byte[j];
                int n3 = 0;
                while (j > 0) {
                    final int read = zipInputStream.read(array3, n3, j);
                    n3 += read;
                    j -= read;
                }
                this.m.loadnew = true;
                this.bco[n] = new ContO(array3, this.m, this.t);
                if (this.bco[n].errd || this.bco[n].npl <= 60 || this.bco[n].maxR < 120) {
                    n = -1;
                }
                if (n != -1) {
                    this.bco[n].shadow = true;
                    this.bco[n].noline = false;
                    this.bco[n].decor = false;
                    this.bco[n].tnt = 0;
                    this.bco[n].disp = 0;
                    this.bco[n].disline = 7;
                    this.bco[n].grounded = 1.0f;
                    boolean b = true;
                    if (this.bco[n].keyz[0] < 0 || this.bco[n].keyx[0] > 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[1] < 0 || this.bco[n].keyx[1] < 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[2] > 0 || this.bco[n].keyx[2] > 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[3] > 0 || this.bco[n].keyx[3] < 0) {
                        b = false;
                    }
                    if (!b) {
                        n = -1;
                    }
                }
                if (n != -1) {
                    this.loadstat(array3, s, this.bco[n].maxR, this.bco[n].roofat, this.bco[n].wh, n);
                    if (this.names[n].equals("")) {
                        n = -1;
                    }
                }
                this.m.loadnew = false;
                dataInputStream.close();
                zipInputStream.close();
            }
            else {
                n = -1;
            }
        }
        catch (Exception ex) {
            n = -1;
        }
        System.gc();
        return n;
    }

    public void loadmystages(final CheckPoints checkPoints) {
        final String[] array = new String[700];
        int n = 0;
        try {
            final DataInputStream dataInputStream = new DataInputStream(new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "").openStream());
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                final String string = "" + line.trim();
                if (string.startsWith("mystages")) {
                    int n2 = 1;
                    while (n2 != 0 && n < 700) {
                        array[n] = this.getSvalue("mystages", string, n);
                        if (array[n].equals("")) {
                            n2 = 0;
                        }
                        else {
                            ++n;
                        }
                    }
                }
            }
            if (n > 0) {
                this.msloaded = 1;
            }
            else {
                this.msloaded = -2;
            }
            dataInputStream.close();
        }
        catch (Exception ex) {
            if (("" + ex).indexOf("FileNotFound") != -1) {
                this.msloaded = -2;
            }
            else {
                this.msloaded = -1;
            }
        }
        if (this.msloaded == 1) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "Select Stage");
            int n3 = 0;
            for (int i = 0; i < n; ++i) {
                this.gs.mstgs.add(this.gs.rd, array[i]);
                if (checkPoints.name.equals(array[i])) {
                    n3 = i + 1;
                    checkPoints.top20 = 0;
                }
            }
            this.gs.mstgs.select(n3);
            this.gs.mstgs.show();
        }
        if (this.msloaded == -2) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "You have not published or added any stages...");
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
        }
        if (this.msloaded == -1) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "Failed to load stages, please try again later.");
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
        }
        System.gc();
    }

    public void loadtop20(final int msloaded) {
        final String[] array = new String[20];
        int n = 0;
        try {
            String s = "A";
            if (msloaded == 3) {
                s = "W";
            }
            if (msloaded == 4) {
                s = "M";
            }
            final DataInputStream dataInputStream = new DataInputStream(new URL("http://multiplayer.needformadness.com/tracks/top20/" + s + ".txt").openStream());
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                final String string = "" + line.trim();
                if (string.startsWith("stages")) {
                    int n2 = 1;
                    while (n2 != 0 && n < 20) {
                        array[n] = this.getSvalue("stages", string, n);
                        if (array[n].equals("")) {
                            n2 = 0;
                        }
                        else {
                            ++n;
                        }
                    }
                }
                if (string.startsWith("adds")) {
                    for (int i = 0; i < n; ++i) {
                        this.top20adds[i] = this.getvalue("adds", string, i);
                    }
                }
            }
            if (n > 0) {
                this.msloaded = msloaded;
            }
            else {
                this.msloaded = -2;
            }
            dataInputStream.close();
        }
        catch (Exception ex) {
            if (("" + ex).indexOf("FileNotFound") != -1) {
                this.msloaded = -2;
            }
            else {
                this.msloaded = -1;
            }
        }
        if (this.msloaded == msloaded) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "Select Stage");
            for (int j = 0; j < n; ++j) {
                this.gs.mstgs.add(this.gs.rd, "N#" + (j + 1) + " " + array[j]);
            }
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
        }
        if (this.msloaded == -1 || this.msloaded == -2) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "Failed to load Top20 list, please try again later.");
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
        }
        System.gc();
    }

    public void loadclanstages(final String s) {
        if (!s.equals("")) {
            final String[] array = new String[700];
            int n = 0;
            try {
                DataInputStream dataInputStream;
                String line;
                for (dataInputStream = new DataInputStream(new URL("http://multiplayer.needformadness.com/clans/" + s + "/stages.txt").openStream()); (line = dataInputStream.readLine()) != null && n < 700; ++n) {
                    array[n] = line;
                }
                if (n > 0) {
                    this.msloaded = 7;
                }
                else {
                    this.msloaded = -2;
                }
                dataInputStream.close();
            }
            catch (Exception ex) {
                if (("" + ex).indexOf("FileNotFound") != -1) {
                    this.msloaded = -2;
                }
                else {
                    this.msloaded = -1;
                }
            }
            if (this.msloaded == 7) {
                this.gs.mstgs.hide();
                this.gs.mstgs.removeAll();
                this.gs.mstgs.add(this.gs.rd, "Select Stage");
                for (int i = 0; i < n; ++i) {
                    this.gs.mstgs.add(this.gs.rd, array[i]);
                }
                this.gs.mstgs.select(0);
                this.gs.mstgs.show();
            }
            if (this.msloaded == -1) {
                this.gs.mstgs.hide();
                this.gs.mstgs.removeAll();
                this.gs.mstgs.add(this.gs.rd, "Failed to load clan stages, please try again later.");
                this.gs.mstgs.select(0);
                this.gs.mstgs.show();
            }
            if (this.msloaded == -2) {
                this.gs.mstgs.hide();
                this.gs.mstgs.removeAll();
                this.gs.mstgs.add(this.gs.rd, "No stages have been added to your clan yet.");
                this.gs.mstgs.select(0);
                this.gs.mstgs.show();
            }
            System.gc();
        }
        else {
            this.msloaded = -2;
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "You are not a member of any clan yet.");
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
        }
    }

    public void loadstagemaker() {
        this.gs.mstgs.hide();
        this.gs.mstgs.removeAll();
        this.gs.mstgs.add(this.gs.rd, "Select Stage");
        int n = 0;
        if (new File("" + Madness.fpath + "mystages/").exists()) {
            final String[] list = new File("" + Madness.fpath + "mystages/").list();
            for (int i = 0; i < list.length; ++i) {
                if (list[i].toLowerCase().endsWith(".txt") && n < 200) {
                    this.gs.mstgs.add(this.gs.rd, list[i].substring(0, list[i].length() - 4));
                    ++n;
                }
            }
        }
        if (n != 0) {
            this.msloaded = 2;
        }
        else {
            this.gs.mstgs.add(this.gs.rd, "No stages where found in your 'mystages' folder.");
            this.msloaded = -1;
        }
        this.gs.mstgs.select(0);
        this.gs.mstgs.show();
    }

    public void loadcarmaker() {
        this.m.csky[0] = 170;
        this.m.csky[1] = 220;
        this.m.csky[2] = 255;
        this.m.cfade[0] = 255;
        this.m.cfade[1] = 220;
        this.m.cfade[2] = 220;
        this.m.snap[0] = 0;
        this.m.snap[1] = 0;
        this.m.snap[2] = 0;
        for (int i = 0; i < 40; ++i) {
            this.include[i] = false;
        }
        this.nlcars = 16;
        if (new File("" + Madness.fpath + "mycars/").exists()) {
            final String[] list = new File("" + Madness.fpath + "mycars/").list();
            for (int j = 0; j < list.length; ++j) {
                if (list[j].toLowerCase().endsWith(".rad") && this.nlcars < 56 && this.loadcar(list[j].substring(0, list[j].length() - 4), this.nlcars) == this.nlcars) {
                    ++this.nlcars;
                }
            }
        }
        System.gc();
        if (this.nlcars > 16) {
            this.lastload = 1;
        }
    }

    public int loadcar(final String s, int n) {
        try {
            final File file = new File("" + Madness.fpath + "mycars/" + s + ".rad");
            if (file.exists()) {
                String string = "";
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    string = string + "" + line + "\n";
                }
                bufferedReader.close();
                this.m.loadnew = true;
                this.bco[n] = new ContO(string.getBytes(), this.m, this.t);
                if (this.bco[n].errd || this.bco[n].npl <= 60) {
                    n = -1;
                }
                if (n != -1) {
                    this.bco[n].shadow = true;
                    this.bco[n].noline = false;
                    this.bco[n].decor = false;
                    this.bco[n].tnt = 0;
                    this.bco[n].disp = 0;
                    this.bco[n].disline = 7;
                    this.bco[n].grounded = 1.0f;
                    boolean b = true;
                    if (this.bco[n].keyz[0] < 0 || this.bco[n].keyx[0] > 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[1] < 0 || this.bco[n].keyx[1] < 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[2] > 0 || this.bco[n].keyx[2] > 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[3] > 0 || this.bco[n].keyx[3] < 0) {
                        b = false;
                    }
                    if (!b) {
                        n = -1;
                    }
                }
                if (n != -1) {
                    this.loadstat(string.getBytes(), s, this.bco[n].maxR, this.bco[n].roofat, this.bco[n].wh, n);
                    if (this.names[n].equals("")) {
                        n = -1;
                    }
                }
                this.m.loadnew = false;
            }
            else {
                n = -1;
            }
        }
        catch (Exception ex) {
            n = -1;
            System.out.println("Error Loading Car: " + ex);
        }
        System.gc();
        return n;
    }
}
