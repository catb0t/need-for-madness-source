import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.Font;

public class Smenu
{
    int sel;
    String[] opts;
    String[] sopts;
    int no;
    int x;
    int y;
    Font font;
    Color bcol;
    Color fcol;
    int w;
    int h;
    FontMetrics ftm;
    boolean show;
    boolean open;
    boolean dis;
    int maxl;
    boolean rooms;
    int[] iroom;
    int kmoused;
    boolean alphad;
    boolean revup;
    boolean carsel;
    boolean flksel;
    boolean om;
    boolean onsc;
    int scro;
    int scra;
    
    public Smenu(final int n) {
        this.sel = 0;
        this.no = 0;
        this.x = 0;
        this.y = 0;
        this.font = new Font("Arial", 1, 13);
        this.bcol = new Color(255, 255, 255);
        this.fcol = new Color(0, 0, 0);
        this.w = 0;
        this.h = 0;
        this.show = false;
        this.open = false;
        this.dis = false;
        this.maxl = 0;
        this.rooms = false;
        this.kmoused = 0;
        this.alphad = false;
        this.revup = false;
        this.carsel = false;
        this.flksel = false;
        this.om = false;
        this.onsc = false;
        this.scro = 0;
        this.scra = 0;
        this.opts = new String[n];
        this.sopts = new String[n];
    }
    
    public void add(final Graphics2D graphics2D, String s) {
        graphics2D.setFont(this.font);
        this.ftm = graphics2D.getFontMetrics();
        if ((!this.rooms || this.no == 0) && this.ftm.stringWidth(s) + 30 > this.w) {
            this.w = this.ftm.stringWidth(s) + 30;
        }
        if (this.rooms) {
            this.iroom = new int[7];
            for (int i = 0; i < 7; ++i) {
                this.iroom[i] = 0;
            }
        }
        this.opts[this.no] = s;
        if (this.maxl != 0) {
            int length;
            for (length = s.length(); this.ftm.stringWidth(s.substring(0, length)) + 30 > this.maxl; --length) {}
            if (length != s.length()) {
                s = s.substring(0, length - 3);
                s += "...";
            }
        }
        this.sopts[this.no] = s;
        if (this.no < this.opts.length - 1) {
            ++this.no;
        }
    }
    
    public void addw(final String s, final String s2) {
        this.w = 300;
        this.opts[this.no] = s2;
        this.sopts[this.no] = s;
        if (this.no < this.opts.length - 1) {
            ++this.no;
        }
    }
    
    public void addstg(final String s) {
        if (this.ftm.stringWidth(s) + 30 > this.w) {
            this.w = this.ftm.stringWidth(s) + 30;
        }
        ++this.no;
        if (this.no > 701) {
            this.no = 701;
        }
        for (int i = this.no - 1; i > 1; --i) {
            this.opts[i] = this.opts[i - 1];
            this.sopts[i] = this.sopts[i - 1];
        }
        this.opts[1] = s;
        this.sopts[1] = s;
    }
    
    public void removeAll() {
        this.no = 0;
        this.w = 0;
        this.sel = 0;
    }
    
    public void select(final int sel) {
        if (sel >= 0 && sel < this.no) {
            this.sel = sel;
        }
    }
    
    public void select(final String s) {
        for (int i = 0; i < this.no; ++i) {
            if (this.opts[i].equals(s)) {
                this.sel = i;
                break;
            }
        }
    }
    
    public int getSelectedIndex() {
        return this.sel;
    }
    
    public String getSelectedItem() {
        return this.opts[this.sel];
    }
    
    public String getItem(final int n) {
        String s = "";
        if (n >= 0 && n < this.no) {
            s = this.opts[n];
        }
        return s;
    }
    
    public int getItemCount() {
        return this.no;
    }
    
    public void remove(final String s) {
        for (int i = 0; i < this.no; ++i) {
            if (this.opts[i].equals(s)) {
                for (int j = i; j < this.no; ++j) {
                    if (j != this.no - 1) {
                        this.opts[j] = this.opts[j + 1];
                        this.sopts[j] = this.sopts[j + 1];
                    }
                }
                --this.no;
                break;
            }
        }
    }
    
    public void setSize(final int w, final int h) {
        this.w = w;
        this.h = h;
    }
    
    public int getWidth() {
        return this.w;
    }
    
    public void setFont(final Font font) {
        this.font = font;
    }
    
    public void setBackground(final Color bcol) {
        this.bcol = bcol;
    }
    
    public void setForeground(final Color fcol) {
        this.fcol = fcol;
    }
    
    public Color getBackground() {
        return this.bcol;
    }
    
    public Color getForeground() {
        return this.fcol;
    }
    
    public void hide() {
        this.show = false;
        this.open = false;
    }
    
    public void show() {
        this.show = true;
    }
    
    public boolean isShowing() {
        return this.show;
    }
    
    public void move(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean hasFocus() {
        return false;
    }
    
    public void disable() {
        this.dis = true;
    }
    
    public void enable() {
        this.dis = false;
    }
    
    public boolean isEnabled() {
        return !this.dis;
    }
    
    public boolean draw(final Graphics2D graphics2D, final int n, final int n2, final boolean b, final int n3, boolean b2) {
        boolean b3 = false;
        if (this.revup) {
            if (b2) {
                b2 = false;
            }
            else {
                b2 = true;
            }
            this.revup = false;
        }
        if (this.show) {
            if (this.alphad) {
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.7f));
            }
            int n4 = 0;
            if (b) {
                if (!this.om) {
                    this.om = true;
                    n4 = 1;
                }
            }
            else if (this.om) {
                this.om = false;
            }
            boolean b4 = false;
            if ((this.bcol.getRed() + this.bcol.getGreen() + this.bcol.getBlue()) / 3 > (this.fcol.getRed() + this.fcol.getGreen() + this.fcol.getBlue()) / 3) {
                b4 = true;
            }
            boolean b5 = false;
            if (n > this.x && n < this.x + this.w && n2 > this.y + 1 && n2 < this.y + 22 && !this.open && !this.dis) {
                b5 = true;
            }
            if (!this.open && b5 && n4 != 0 && !this.dis) {
                this.open = true;
                n4 = 0;
            }
            graphics2D.setFont(this.font);
            this.ftm = graphics2D.getFontMetrics();
            if (this.open) {
                final int n5 = 4 + (this.ftm.getHeight() + 2) * this.no;
                if (!b2) {
                    int n6 = 0;
                    graphics2D.setColor(this.bcol);
                    graphics2D.fillRect(this.x, this.y + 23, this.w, n5);
                    graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                    graphics2D.drawRect(this.x, this.y + 23, this.w, n5);
                    if (this.y + 23 + n5 > n3) {
                        graphics2D.drawLine(this.x + this.w - 18, this.y + 17, this.x + this.w - 18, n3);
                        if (b4) {
                            graphics2D.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
                        }
                        else {
                            graphics2D.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
                        }
                        graphics2D.fillRect(this.x + this.w - 15, this.y + 25 + this.scra, 13, 30);
                        graphics2D.setColor(this.fcol);
                        graphics2D.drawRect(this.x + this.w - 15, this.y + 25 + this.scra, 12, 30);
                        graphics2D.setColor(new Color(0, 0, 0));
                        graphics2D.drawLine(this.x + this.w - 12, this.y + 9 + 29 + this.scra, this.x + this.w - 12, this.y + 10 + 29 + this.scra);
                        graphics2D.drawLine(this.x + this.w - 11, this.y + 10 + 29 + this.scra, this.x + this.w - 11, this.y + 11 + 29 + this.scra);
                        graphics2D.drawLine(this.x + this.w - 10, this.y + 11 + 29 + this.scra, this.x + this.w - 10, this.y + 12 + 29 + this.scra);
                        graphics2D.drawLine(this.x + this.w - 9, this.y + 12 + 29 + this.scra, this.x + this.w - 9, this.y + 13 + 29 + this.scra);
                        graphics2D.drawLine(this.x + this.w - 8, this.y + 11 + 29 + this.scra, this.x + this.w - 8, this.y + 12 + 29 + this.scra);
                        graphics2D.drawLine(this.x + this.w - 7, this.y + 10 + 29 + this.scra, this.x + this.w - 7, this.y + 11 + 29 + this.scra);
                        graphics2D.drawLine(this.x + this.w - 6, this.y + 9 + 29 + this.scra, this.x + this.w - 6, this.y + 10 + 29 + this.scra);
                        n6 = -18;
                        if (b) {
                            if (n > this.x + this.w - 18 && n < this.x + this.w && n2 > this.y + 25 && n2 < n3) {
                                n4 = 0;
                                this.onsc = true;
                            }
                        }
                        else if (this.onsc) {
                            this.onsc = false;
                        }
                        if (this.onsc) {
                            this.scra = n2 - (this.y + 25) - 15;
                            if (this.scra < 0) {
                                this.scra = 0;
                            }
                            final int scra = n3 - (this.y + 25) - 33;
                            if (this.scra > scra) {
                                this.scra = scra;
                            }
                            this.scro = -(this.scra * ((this.no * (this.ftm.getHeight() + 2) - scra - this.ftm.getHeight() / 2) / scra));
                        }
                    }
                    for (int i = 0; i < this.no; ++i) {
                        if (Math.abs(this.scro) < (i + 1) * (this.ftm.getHeight() + 2)) {
                            graphics2D.setColor(this.fcol);
                            if (n > this.x && n < this.x + this.w && n2 > this.y + 25 + this.scro + i * (this.ftm.getHeight() + 2) && n2 < this.y + 25 + this.scro + (i + 1) * (this.ftm.getHeight() + 2)) {
                                if (b4) {
                                    graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                                }
                                else {
                                    graphics2D.setColor(this.fcol);
                                }
                                graphics2D.fillRect(this.x + 1, this.y + 25 + this.scro + i * (this.ftm.getHeight() + 2), this.w - 1 + n6, this.ftm.getHeight() + 2);
                                graphics2D.setColor(this.bcol);
                                if (n4 != 0) {
                                    if (!this.rooms || !this.opts[i].equals("full")) {
                                        this.sel = i;
                                        if (this.rooms && i != 0) {
                                            this.sopts[i] = " ";
                                        }
                                    }
                                    else {
                                        this.kmoused = 20;
                                    }
                                    this.open = false;
                                }
                            }
                            if (this.rooms && this.sopts[i].indexOf("10 / 10") != -1) {
                                graphics2D.setColor(new Color(255, 0, 0));
                            }
                            graphics2D.drawString(this.sopts[i], this.x + 4, this.y + 38 + this.scro + i * (this.ftm.getHeight() + 2));
                        }
                    }
                    if (n6 != 0) {
                        graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                        graphics2D.drawLine(this.x, n3 - 1, this.x + this.w, n3 - 1);
                    }
                }
                else {
                    int n7 = 0;
                    graphics2D.setColor(this.bcol);
                    graphics2D.fillRect(this.x, this.y - n5, this.w, n5);
                    graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                    graphics2D.drawRect(this.x, this.y - n5, this.w, n5);
                    if (this.y - n5 < 0) {
                        graphics2D.drawLine(this.x + this.w - 18, 0, this.x + this.w - 18, this.y);
                        if (b4) {
                            graphics2D.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
                        }
                        else {
                            graphics2D.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
                        }
                        graphics2D.fillRect(this.x + this.w - 15, this.y - this.scra - 33, 13, 30);
                        graphics2D.setColor(this.fcol);
                        graphics2D.drawRect(this.x + this.w - 15, this.y - this.scra - 33, 12, 30);
                        graphics2D.setColor(new Color(0, 0, 0));
                        graphics2D.drawLine(this.x + this.w - 12, this.y + 13 - 29 - this.scra, this.x + this.w - 12, this.y + 12 - 29 - this.scra);
                        graphics2D.drawLine(this.x + this.w - 11, this.y + 12 - 29 - this.scra, this.x + this.w - 11, this.y + 11 - 29 - this.scra);
                        graphics2D.drawLine(this.x + this.w - 10, this.y + 11 - 29 - this.scra, this.x + this.w - 10, this.y + 10 - 29 - this.scra);
                        graphics2D.drawLine(this.x + this.w - 9, this.y + 10 - 29 - this.scra, this.x + this.w - 9, this.y + 9 - 29 - this.scra);
                        graphics2D.drawLine(this.x + this.w - 8, this.y + 11 - 29 - this.scra, this.x + this.w - 8, this.y + 10 - 29 - this.scra);
                        graphics2D.drawLine(this.x + this.w - 7, this.y + 12 - 29 - this.scra, this.x + this.w - 7, this.y + 11 - 29 - this.scra);
                        graphics2D.drawLine(this.x + this.w - 6, this.y + 13 - 29 - this.scra, this.x + this.w - 6, this.y + 12 - 29 - this.scra);
                        n7 = -18;
                        if (b) {
                            if (n > this.x + this.w - 18 && n < this.x + this.w && n2 > 0 && n2 < this.y - 3) {
                                n4 = 0;
                                this.onsc = true;
                            }
                        }
                        else if (this.onsc) {
                            this.onsc = false;
                        }
                        if (this.onsc) {
                            this.scra = this.y - 3 - 15 - n2;
                            if (this.scra < 0) {
                                this.scra = 0;
                            }
                            final int scra2 = this.y - 35;
                            if (this.scra > scra2) {
                                this.scra = scra2;
                            }
                            this.scro = this.scra * ((this.no * (this.ftm.getHeight() + 2) - scra2 - this.ftm.getHeight() / 2) / scra2);
                        }
                    }
                    for (int j = 0; j < this.no; ++j) {
                        if (Math.abs(this.scro) < (j + 1) * (this.ftm.getHeight() + 2)) {
                            graphics2D.setColor(this.fcol);
                            if (n > this.x && n < this.x + this.w && n2 < this.y - 18 + this.scro - (j - 1) * (this.ftm.getHeight() + 2) && n2 > this.y - 18 + this.scro - j * (this.ftm.getHeight() + 2)) {
                                if (b4) {
                                    graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                                }
                                else {
                                    graphics2D.setColor(this.fcol);
                                }
                                graphics2D.fillRect(this.x + 1, this.y - 18 + this.scro - j * (this.ftm.getHeight() + 2), this.w - 1 + n7, this.ftm.getHeight() + 2);
                                graphics2D.setColor(this.bcol);
                                if (n4 != 0) {
                                    this.sel = j;
                                    this.open = false;
                                }
                            }
                            graphics2D.drawString(this.sopts[j], this.x + 4, this.y - 5 + this.scro - j * (this.ftm.getHeight() + 2));
                        }
                    }
                    if (n7 != 0) {
                        graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                        graphics2D.drawLine(this.x, 0, this.x + this.w, 0);
                    }
                }
                b3 = true;
                if (n4 != 0) {
                    this.open = false;
                }
            }
            else {
                if (this.scro != 0) {
                    this.scro = 0;
                }
                if (this.scra != 0) {
                    this.scra = 0;
                }
            }
            if (b5) {
                if (b4) {
                    graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                }
                else {
                    graphics2D.setColor(this.fcol);
                }
            }
            else {
                graphics2D.setColor(this.bcol);
            }
            graphics2D.fillRect(this.x, this.y + 1, this.w, 21);
            graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
            graphics2D.drawRect(this.x, this.y + 1, this.w, 21);
            if (b4) {
                graphics2D.setColor(new Color((this.bcol.getRed() + 255) / 2, (this.bcol.getGreen() + 255) / 2, (this.bcol.getBlue() + 255) / 2));
            }
            else {
                graphics2D.setColor(new Color((this.fcol.getRed() + 255) / 2, (this.fcol.getGreen() + 255) / 2, (this.fcol.getBlue() + 255) / 2));
            }
            graphics2D.drawRect(this.x + 1, this.y + 2, this.w - 2, 19);
            graphics2D.drawLine(this.x + this.w - 17, this.y + 3, this.x + this.w - 17, this.y + 20);
            graphics2D.setColor(this.fcol);
            if (this.dis) {
                graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3));
            }
            graphics2D.drawRect(this.x + this.w - 16, this.y + 3, 14, 17);
            if (b4) {
                graphics2D.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
            }
            else {
                graphics2D.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
            }
            graphics2D.fillRect(this.x + this.w - 15, this.y + 4, 13, 16);
            graphics2D.setColor(new Color(0, 0, 0));
            if (this.dis) {
                graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3));
            }
            graphics2D.drawLine(this.x + this.w - 12, this.y + 9, this.x + this.w - 12, this.y + 10);
            graphics2D.drawLine(this.x + this.w - 11, this.y + 10, this.x + this.w - 11, this.y + 11);
            graphics2D.drawLine(this.x + this.w - 10, this.y + 11, this.x + this.w - 10, this.y + 12);
            graphics2D.drawLine(this.x + this.w - 9, this.y + 12, this.x + this.w - 9, this.y + 13);
            graphics2D.drawLine(this.x + this.w - 8, this.y + 11, this.x + this.w - 8, this.y + 12);
            graphics2D.drawLine(this.x + this.w - 7, this.y + 10, this.x + this.w - 7, this.y + 11);
            graphics2D.drawLine(this.x + this.w - 6, this.y + 9, this.x + this.w - 6, this.y + 10);
            if (b5) {
                graphics2D.setColor(this.bcol);
            }
            else {
                graphics2D.setColor(this.fcol);
            }
            if (this.dis) {
                graphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3));
            }
            if (this.carsel && !b5) {
                if (this.flksel) {
                    graphics2D.setColor(new Color(240, 240, 240));
                    this.flksel = false;
                }
                else {
                    this.flksel = true;
                }
            }
            graphics2D.drawString(this.sopts[this.sel], this.x + 4, this.y + (this.ftm.getHeight() + 2));
            if (this.alphad) {
                graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            }
        }
        else {
            if (this.scro != 0) {
                this.scro = 0;
            }
            if (this.scra != 0) {
                this.scra = 0;
            }
        }
        return b3;
    }
}
