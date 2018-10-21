import java.net.DatagramPacket;
import java.util.Date;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpOnline implements Runnable
{
    Thread con;
    UDPMistro um;
    int gameport;
    InetAddress IPAddress;
    DatagramSocket dSocket;
    long sendat;
    boolean started;
    boolean errd;
    int nu;

    public udpOnline(final UDPMistro um, final String s, final int gameport, final int nu, final int n) {
        this.gameport = 7001;
        this.sendat = 0L;
        this.started = false;
        this.errd = false;
        this.nu = 0;
        this.um = um;
        this.gameport = gameport;
        this.nu = nu;
        try {
            this.dSocket = new DatagramSocket(7010 + n + this.nu);
            this.errd = false;
            this.IPAddress = InetAddress.getByName(s);
        }
        catch (Exception ex) {
            System.out.println("Error preparing for UDP Connection: " + ex);
        }
    }

    public void spark() {
        if (this.errd) {
            try {
                this.dSocket = new DatagramSocket(7020 + this.nu);
                this.errd = false;
            }
            catch (Exception ex) {}
        }
        try {
            (this.con = new Thread(this)).start();
        }
        catch (Exception ex2) {}
    }

    public void closeSocket() {
        try {
            this.dSocket.close();
        }
        catch (Exception ex) {}
        this.dSocket = null;
        this.errd = true;
        if (this.con != null) {
          this.con.stop();
          this.con = null;

          /*try {
            this.con.join(0);
            this.con = null;
          } catch (InterruptedException ex) {
            // NOTE: caught here
          }*/
        }
        this.started = false;
    }

    public void stomp() {
        if (this.con != null) {
          this.con.stop();
          this.con = null;

          /*try {
            this.con.join(0);
            this.con = null;
          } catch (InterruptedException ex) {
            // NOTE: caught here
          }*/
        }
        this.started = false;
    }

    @Override
    public void run() {
        this.started = true;
        this.sendat = new Date().getTime();
        String sendcheck = "";
        if (!this.um.go) {
            sendcheck = "MAGNITUDE";
        }
        if (this.nu == 0 && this.um.diledelay == 0) {
            this.um.sendat = this.sendat;
            final String string = "" + this.sendat;
            sendcheck = string.substring(string.length() - 3, string.length());
            this.um.sendcheck = sendcheck;
            this.um.diledelay = 100;
        }
        try {
            final byte[] array = new byte[4];
            final DatagramPacket datagramPacket = new DatagramPacket(array, array.length, this.IPAddress, this.gameport);
            datagramPacket.setData(("" + sendcheck + "|" + this.um.im + "|" + this.um.frame[this.um.im][0] + "|" + this.um.info[this.um.im][0] + "|").getBytes());
            this.dSocket.send(datagramPacket);
            for (int i = 0; i < this.um.nplayers - 1; ++i) {
                this.dSocket.receive(datagramPacket);
                final String s = new String(datagramPacket.getData());
                if ((this.nu == 0 || !this.um.go) && i == 0) {
                    sendcheck = this.getSvalue(s, 0);
                    if (!this.um.go && sendcheck.equals("1111111")) {
                        this.um.go = true;
                    }
                }
                final int getvalue = this.getvalue(s, 1);
                if (getvalue >= 0 && getvalue < this.um.nplayers) {
                    final int getvalue2 = this.getvalue(s, 2);
                    int n = 0;
                    for (int j = 0; j < 3; ++j) {
                        if (getvalue2 != this.um.frame[getvalue][j]) {
                            ++n;
                        }
                    }
                    if (n == 3) {
                        for (int k = 0; k < 3; ++k) {
                            if (getvalue2 > this.um.frame[getvalue][k]) {
                                for (int l = 2; l >= k + 1; --l) {
                                    this.um.frame[getvalue][l] = this.um.frame[getvalue][l - 1];
                                    this.um.info[getvalue][l] = this.um.info[getvalue][l - 1];
                                }
                                this.um.frame[getvalue][k] = getvalue2;
                                this.um.info[getvalue][k] = this.getSvalue(s, 3);
                                k = 3;
                            }
                        }
                    }
                }
            }
            if (this.nu == 0 && this.um.diledelay != 0 && this.um.sendcheck.equals(sendcheck)) {
                final Date date = new Date();
                for (int n2 = 4; n2 > 0; --n2) {
                    this.um.ldelays[n2] = this.um.ldelays[n2 - 1];
                }
                this.um.ldelays[0] = (int)(date.getTime() - this.um.sendat);
                this.um.delay = 0;
                for (int n3 = 0; n3 < 5; ++n3) {
                    if (this.um.ldelays[n3] != 0 && (this.um.delay == 0 || this.um.ldelays[n3] < this.um.delay)) {
                        this.um.delay = this.um.ldelays[n3];
                    }
                }
                this.um.diledelay = 0;
                if (this.um.diled != 10) {
                    final UDPMistro um = this.um;
                    ++um.diled;
                }
            }
        }
        catch (Exception ex) {
            try {
                this.dSocket.close();
            }
            catch (Exception ex2) {}
            this.dSocket = null;
            this.errd = true;
        }
        this.started = false;
        this.con = null;
    }

    public int getvalue(final String s, final int n) {
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

    public String getSvalue(final String s, final int n) {
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
}
