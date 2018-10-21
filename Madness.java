import java.net.URI;
import java.awt.Desktop;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.applet.Applet;
import java.awt.Frame;
import java.awt.Panel;

public class Madness extends Panel
{
    static Frame frame;
    static Applet applet;
    static String fpath;
    static boolean fullscreen;
    static int anti;
    static GraphicsDevice myDevice;
    static DisplayMode defdisp;
    static DisplayMode fulldisp;
    static int testdrive;
    static String testcar;
    static int textid;
    static int updateon;
    static String upfile;
    static boolean inisetup;
    static int endadv;
    static long advtime;

    public static void main(final String[] array) {
        System.runFinalizersOnExit(true);
        (Madness.frame = new Frame("[Dev] Need for Madness")).setBackground(new Color(0, 0, 0));
        Madness.frame.setIgnoreRepaint(true);
        Madness.fpath = "";
        int n = 0;
        for (final String s : array) {
            if (n == 0) {
                Madness.fpath += s;
                n = 1;
            }
            else {
                Madness.fpath = Madness.fpath + " " + s;
            }
        }
        if (!Madness.fpath.equals("")) {
            if (Madness.fpath.equals("manar")) {
                Madness.fpath = "";
                try {
                    final File file = new File("data/manar.ok");
                    if (!file.exists()) {
                        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                        bufferedWriter.write("" + (int)(Math.random() * 1000.0) + "");
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    }
                }
                catch (Exception ex) {}
            }
            else if (!new File("" + Madness.fpath + "data/models.zip").exists()) {
                Madness.fpath = "";
            }
        }
        Madness.frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "data/icon.png"));
        Madness.applet = new GameSparker();
        Madness.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent windowEvent) {
                Madness.exitsequance();
            }
        });
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.frame.setMinimumSize(new Dimension(930, 586));
        Madness.frame.setSize(930, 586);
        Madness.frame.setExtendedState(6);
        Madness.applet.init();
        Madness.applet.start();
        Madness.myDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Madness.defdisp = Madness.myDevice.getDisplayMode();
        checknupdate(36);
    }

    public static void gofullscreen() {
        final DisplayMode[] displayModes = Madness.myDevice.getDisplayModes();
        final String[] array = new String[100];
        final int[] array2 = new int[100];
        int n = 0;
        final float n2 = Madness.defdisp.getWidth() / Madness.defdisp.getHeight();
        float n3 = -1.0f;
        int n4 = 0;
        for (int i = 0; i < displayModes.length; ++i) {
            if (displayModes[i].getWidth() >= 800 && displayModes[i].getBitDepth() >= 16 && n4 < 100) {
                if (displayModes[i].getWidth() < 900) {
                    final float abs = Math.abs(n2 - displayModes[i].getWidth() / displayModes[i].getHeight());
                    if (abs <= n3 || n3 == -1.0f) {
                        n = n4;
                        n3 = abs;
                    }
                }
                array[n4] = "" + displayModes[i].getWidth() + " x " + displayModes[i].getHeight() + " Resolution   -   " + displayModes[i].getBitDepth() + " Bits   -   " + displayModes[i].getRefreshRate() + " Refresh Rate";
                array2[n4] = i;
                ++n4;
            }
        }
        if (n3 != -1.0f) {
            final StringBuilder sb = new StringBuilder();
            final String[] array3 = array;
            final int n5 = n;
            array3[n5] = sb.append(array3[n5]).append("     <  Recommended").toString();
        }
        try {
            final File file = new File("" + Madness.fpath + "data/full_screen.data");
            if (file.exists()) {
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                for (int n6 = 0; (line = bufferedReader.readLine()) != null && n6 == 0; n6 = 1) {
                    final String trim = line.trim();
                    int intValue;
                    try {
                        intValue = Integer.valueOf(trim);
                    }
                    catch (Exception ex) {
                        intValue = n;
                    }
                    n = intValue;
                    if (n < 0) {
                        n = 0;
                    }
                    if (n > n4 - 1) {
                        n = n4 - 1;
                    }
                }
                bufferedReader.close();
            }
        }
        catch (Exception ex2) {}
        final String[] array4 = new String[n4];
        for (int j = 0; j < n4; ++j) {
            array4[j] = array[j];
        }
        final String[] array5 = array4;
        final Object showInputDialog = JOptionPane.showInputDialog(
          // parentComponent
          null,
          // message
          "Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,",
          // messageType??
          "Fullscreen Options",
          //
          1,
          null,
          array5,
          array5[n]
        );
        int n7 = -1;
        if (showInputDialog != null) {
            for (int k = 0; k < n4; ++k) {
                if (showInputDialog.equals(array5[k])) {
                    n7 = array2[k];
                    n = k;
                    break;
                }
            }
        }
        if (n7 != -1) {
            try {
                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("" + Madness.fpath + "data/full_screen.data")));
                bufferedWriter.write("" + n + "");
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            catch (Exception ex3) {}
            Madness.fullscreen = true;
            Madness.frame.dispose();
            (Madness.frame = new Frame("Fullscreen Need for Madness")).setBackground(new Color(0, 0, 0));
            Madness.frame.setUndecorated(true);
            Madness.frame.setResizable(false);
            Madness.frame.setExtendedState(6);
            Madness.frame.setIgnoreRepaint(true);
            Madness.frame.add("Center", Madness.applet);
            Madness.frame.show();
            if (Madness.myDevice.isFullScreenSupported()) {
                try {
                    Madness.myDevice.setFullScreenWindow(Madness.frame);
                }
                catch (Exception ex4) {}
                if (Madness.myDevice.isDisplayChangeSupported()) {
                    try {
                        Madness.myDevice.setDisplayMode(displayModes[n7]);
                    }
                    catch (Exception ex5) {}
                }
            }
            Madness.applet.requestFocus();
        }
    }

    public static void exitfullscreen() {
        Madness.frame.dispose();
        (Madness.frame = new Frame("Need for Madness")).setBackground(new Color(0, 0, 0));
        Madness.frame.setIgnoreRepaint(true);
        Madness.frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "data/icon.gif"));
        Madness.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent windowEvent) {
                Madness.exitsequance();
            }
        });
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        if (Madness.myDevice.isFullScreenSupported()) {
            try {
                Madness.myDevice.setDisplayMode(Madness.defdisp);
            }
            catch (Exception ex) {}
            if (Madness.myDevice.isDisplayChangeSupported()) {
                try {
                    Madness.myDevice.setFullScreenWindow(null);
                }
                catch (Exception ex2) {}
            }
        }
        Madness.frame.setMinimumSize(new Dimension(930, 586));
        Madness.frame.setSize(800, 586);
        Madness.frame.setExtendedState(6);
        Madness.applet.requestFocus();
        Madness.fullscreen = false;
    }

    public static void exitsequance() {
        if (Madness.updateon == 0 || Madness.updateon == 3) {
            if (Madness.endadv == 1) {
                Madness.endadv = 2;
            }
            if (Madness.updateon != 3) {
                Madness.applet.stop();
            }
            Madness.frame.removeAll();
            try {
                Thread.sleep(200L);
            }
            catch (Exception ex) {}
            Madness.applet.destroy();
            Madness.applet = null;
            System.exit(0);
        }
    }

    public static void checknupdate(int n) {
        int i = 1;
        boolean b = false;
        String getfuncSvalue = "";
        int n2 = 0;
        final String[] array = new String[100];
        final String[] array2 = new String[100];
        while (i != 0) {
            i = 0;
            try {
                final URL url = new URL("http://multiplayer.needformadness.com/update/" + n + ".txt");
                url.openConnection().setConnectTimeout(5000);
                if (url.openConnection().getContentType().equals("text/plain")) {
                    String line;
                    while ((line = new DataInputStream(url.openStream()).readLine()) != null) {
                        final String trim = line.trim();
                        if (trim.startsWith("maddapp")) {
                            getfuncSvalue = getfuncSvalue("maddapp", trim, 0);
                            b = true;
                            i = 1;
                        }
                        if (trim.startsWith("file") && n2 < 100) {
                            array[n2] = getfuncSvalue("file", trim, 0);
                            array2[n2] = getfuncSvalue("file", trim, 1);
                            ++n2;
                            i = 1;
                        }
                    }
                }
                ++n;
            }
            catch (Exception ex) {}
        }
        if (b || n2 != 0) {
            Madness.updateon = 1;
            Madness.frame.dispose();
            while (Madness.inisetup) {}
            Madness.applet.stop();
            Madness.applet.destroy();
            if (Madness.fullscreen && Madness.myDevice.isFullScreenSupported()) {
                try {
                    Madness.myDevice.setDisplayMode(Madness.defdisp);
                }
                catch (Exception ex2) {}
                if (Madness.myDevice.isDisplayChangeSupported()) {
                    try {
                        Madness.myDevice.setFullScreenWindow(null);
                    }
                    catch (Exception ex3) {}
                }
            }
            (Madness.frame = new Frame("Updating Need for Madness...")).setBackground(new Color(234, 240, 247));
            Madness.frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(final WindowEvent windowEvent) {
                    Madness.exitsequance();
                }
            });
            Madness.applet = new update();
            Madness.frame.add("Center", Madness.applet);
            Madness.frame.show();
            Madness.frame.setSize(800, 300);
            Madness.frame.setResizable(false);
            Madness.frame.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800.0) / 2.0), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 300.0) / 2.0));
            Madness.applet.init();
            Madness.applet.start();
            if (n2 != 0) {
                for (int j = 0; j < n2; ++j) {
                    try {
                        Madness.upfile = "Downloading and updating file: " + array2[j] + "";
                        Madness.updateon = 2;
                        final URL url2 = new URL(array[j]);
                        final int contentLength = url2.openConnection().getContentLength();
                        final DataInputStream dataInputStream = new DataInputStream(url2.openStream());
                        final byte[] array3 = new byte[contentLength];
                        dataInputStream.readFully(array3);
                        final FileOutputStream fileOutputStream = new FileOutputStream(new File("" + Madness.fpath + "" + array2[j] + ""));
                        fileOutputStream.write(array3);
                        fileOutputStream.close();
                        dataInputStream.close();
                    }
                    catch (Exception ex4) {}
                }
            }
            if (b) {
                try {
                    Madness.upfile = "Downloading and updating game's code";
                    Madness.updateon = 2;
                    final URL url3 = new URL(getfuncSvalue);
                    final int contentLength2 = url3.openConnection().getContentLength();
                    final DataInputStream dataInputStream2 = new DataInputStream(url3.openStream());
                    final byte[] array4 = new byte[contentLength2];
                    dataInputStream2.readFully(array4);
                    final File file = new File("" + Madness.fpath + "madapp.jar");
                    if (file.exists()) {
                        final FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        fileOutputStream2.write(array4);
                        fileOutputStream2.close();
                    }
                    final File file2 = new File("" + Madness.fpath + "madapps.jar");
                    if (file2.exists()) {
                        final FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                        fileOutputStream3.write(array4);
                        fileOutputStream3.close();
                    }
                    final File file3 = new File("" + Madness.fpath + "data/madapp.jar");
                    if (file3.exists()) {
                        final FileOutputStream fileOutputStream4 = new FileOutputStream(file3);
                        fileOutputStream4.write(array4);
                        fileOutputStream4.close();
                    }
                    final File file4 = new File("" + Madness.fpath + "data/madapps.jar");
                    if (file4.exists()) {
                        final FileOutputStream fileOutputStream5 = new FileOutputStream(file4);
                        fileOutputStream5.write(array4);
                        fileOutputStream5.close();
                    }
                    final File file5 = new File("" + Madness.fpath + "Madness.app/Contents/Java/madapp.jar");
                    if (file5.exists()) {
                        final FileOutputStream fileOutputStream6 = new FileOutputStream(file5);
                        fileOutputStream6.write(array4);
                        fileOutputStream6.close();
                    }
                    final FileOutputStream fileOutputStream7 = new FileOutputStream(new File("" + Madness.fpath + "Game.jar"));
                    fileOutputStream7.write(array4);
                    fileOutputStream7.close();
                    dataInputStream2.close();
                }
                catch (Exception ex5) {}
            }
            Madness.updateon = 3;
        }
    }

    public static void carmaker() {
        Madness.applet.stop();
        Madness.frame.removeAll();
        try {
            Thread.sleep(400L);
        }
        catch (Exception ex) {}
        Madness.applet.destroy();
        Madness.applet = null;
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        }
        catch (Exception ex2) {}
        Madness.applet = new CarMaker();
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.applet.init();
        Madness.applet.start();
    }

    public static void stagemaker() {
        Madness.applet.stop();
        Madness.frame.removeAll();
        try {
            Thread.sleep(400L);
        }
        catch (Exception ex) {}
        Madness.applet.destroy();
        Madness.applet = null;
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        }
        catch (Exception ex2) {}
        Madness.applet = new StageMaker();
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.applet.init();
        Madness.applet.start();
    }

    public static void game() {
        Madness.applet.stop();
        Madness.frame.removeAll();
        try {
            Thread.sleep(400L);
        }
        catch (Exception ex) {}
        Madness.applet.destroy();
        Madness.applet = null;
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        }
        catch (Exception ex2) {}
        Madness.applet = new GameSparker();
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.applet.init();
        Madness.applet.start();
    }

    public static void advopen() {
        try {
            if (new File("" + Madness.fpath + "data/user.data").exists()) {
                final long time = new Date().getTime();
                if (Madness.advtime == 0L || time - Madness.advtime > 120000L) {
                    if (System.getProperty("os.name").toLowerCase().indexOf("win") != -1) {
                        final File file = new File("" + Madness.fpath + "data/adv.bat");
                        boolean b = false;
                        if (!file.exists()) {
                            b = true;
                        }
                        else if (file.length() != 81L) {
                            b = true;
                        }
                        if (b) {
                            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                            bufferedWriter.write("cd %programfiles%\\Internet Explorer");
                            bufferedWriter.newLine();
                            bufferedWriter.write("iexplore -k http://www.needformadness.com/");
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                        }
                        while (new DataInputStream(Runtime.getRuntime().exec(file.getAbsolutePath()).getInputStream()).readLine() != null) {}
                    }
                    else {
                        openurl("http://www.needformadness.com/");
                    }
                    Madness.advtime = time;
                    Madness.endadv = 1;
                }
            }
        }
        catch (Exception ex) {}
    }

    public static String urlopen() {
        String s = "explorer";
        final String lowerCase = System.getProperty("os.name").toLowerCase();
        if (lowerCase.indexOf("linux") != -1 || lowerCase.indexOf("unix") != -1 || lowerCase.equals("aix")) {
            s = "xdg-open";
        }
        if (lowerCase.indexOf("mac") != -1) {
            s = "open";
        }
        return s;
    }

    public static void openurl(final String s) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(s));
            }
            catch (Exception ex) {}
        }
        else {
            try {
                Runtime.getRuntime().exec("" + urlopen() + " " + s + "");
            }
            catch (Exception ex2) {}
        }
    }

    public static String getfuncSvalue(final String s, final String s2, final int n) {
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

    static {
        Madness.fpath = "";
        Madness.fullscreen = false;
        Madness.anti = 1;
        Madness.testdrive = 0;
        Madness.testcar = "";
        Madness.textid = 0;
        Madness.updateon = 0;
        Madness.upfile = "";
        Madness.inisetup = false;
        Madness.endadv = 0;
        Madness.advtime = 0L;
    }
}
