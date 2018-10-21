import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.RenderingHints;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.applet.Applet;

public class update extends Applet implements Runnable
{
    Graphics2D rd;
    FontMetrics ftm;
    Image offImage;
    Thread gamer;
    int xm;
    int ym;
    boolean moused;
    int scur;
    
    public update() {
        this.xm = 0;
        this.ym = 0;
        this.moused = false;
        this.scur = 0;
    }
    
    @Override
    public void run() {
        int n = 0;
        int n2 = 0;
        int i = 0;
        while (i == 0) {
            int scur = 0;
            this.rd.setColor(new Color(234, 240, 247));
            this.rd.fillRect(0, 0, 800, 300);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 15));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Need for Madness Update", 400 - this.ftm.stringWidth("Need for Madness Update") / 2, 30);
            this.rd.setFont(new Font("Arial", 1, 13));
            if (Madness.updateon == 1 || Madness.updateon == 2) {
                this.rd.drawString("The game has just been updated!  Please wait while the game updates itself.", 30, 70);
            }
            if (Madness.updateon == 3) {
                this.rd.drawString("Successfully finished updating.  Now you can close this window and start the game again.", 30, 70);
            }
            if (Madness.updateon == 2) {
                this.rd.setFont(new Font("Arial", 0, 13));
                this.rd.drawString(Madness.upfile, 30, 95);
                this.rd.setColor(new Color(71, 95, 120));
                this.rd.drawRect(50, 105, 700, 20);
                this.rd.fillRect(52, 107, n, 17);
                if (++n > 697) {
                    n = 0;
                }
            }
            if (Madness.updateon == 3) {
                this.rd.setFont(new Font("Arial", 0, 13));
                this.rd.drawString("Game update complete.", 30, 95);
                this.rd.setColor(new Color(71, 95, 120));
                this.rd.drawRect(50, 105, 700, 20);
                this.rd.fillRect(52, 107, 697, 17);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("To learn more about this update, visit the game's development blog!", 30, 210);
            this.rd.setColor(new Color(71, 95, 120));
            this.rd.drawString("http://multiplayer.needformadness.com/development.html", 30, 232);
            final int n3 = this.ftm.stringWidth("http://multiplayer.needformadness.com/development.html") + 30;
            this.rd.drawLine(30, 235, n3, 235);
            if (this.xm > 30 && this.xm < n3 && this.ym > 218 && this.ym < 237) {
                scur = 12;
                if (this.moused) {
                    Madness.openurl("http://multiplayer.needformadness.com/development.html");
                }
            }
            if (Madness.updateon == 3) {
                this.rd.drawString("Close updater to finish >", 400 - this.ftm.stringWidth("Close updater to finish >") / 2, 165);
                final int n4 = 400 - this.ftm.stringWidth("Close updater to finish >") / 2;
                final int n5 = this.ftm.stringWidth("Close updater to finish >") + n4;
                this.rd.drawLine(n4, 167, n5, 167);
                if (this.xm > n4 && this.xm < n5 && this.ym > 150 && this.ym < 169) {
                    scur = 12;
                    if (this.moused) {
                        Madness.exitsequance();
                        i = 1;
                    }
                }
            }
            else {
                this.rd.drawString(":: : : : : : : : : : : : : : : : : : : ::", 400 - this.ftm.stringWidth(":: : : : : : : : : : : : : : : : : : : ::") / 2, 165);
            }
            if (Madness.updateon == 3 && ++n2 == 1000) {
                Madness.exitsequance();
            }
            if (scur != this.scur) {
                this.setCursor(new Cursor(scur));
                this.scur = scur;
            }
            if (this.moused) {
                this.moused = false;
            }
            this.repaint();
            try {
                final Thread gamer = this.gamer;
                Thread.sleep(10L);
            }
            catch (InterruptedException ex) {}
        }
    }
    
    @Override
    public void init() {
        this.offImage = this.createImage(800, 300);
        if (this.offImage != null) {
            this.rd = (Graphics2D)this.offImage.getGraphics();
        }
        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    
    @Override
    public boolean mouseMove(final Event event, final int xm, final int ym) {
        this.xm = xm;
        this.ym = ym;
        return false;
    }
    
    @Override
    public boolean mouseUp(final Event event, final int xm, final int ym) {
        this.xm = xm;
        this.ym = ym;
        this.moused = true;
        return false;
    }
    
    @Override
    public void start() {
        if (this.gamer == null) {
            this.gamer = new Thread(this);
        }
        this.gamer.start();
    }
    
    @Override
    public void stop() {
        if (this.gamer != null) {
            this.gamer.stop();
        }
        this.gamer = null;
    }
    
    @Override
    public void paint(final Graphics graphics) {
        graphics.drawImage(this.offImage, 0, 0, this);
    }
    
    @Override
    public void update(final Graphics graphics) {
        this.paint(graphics);
    }
}
