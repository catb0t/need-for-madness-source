import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpServe implements Runnable
{
    Thread servo;
    DatagramSocket dSocket;
    UDPMistro um;
    int mport;
    int im;
    int[] lsframe;

    public udpServe(final UDPMistro um, final int im) {
        this.mport = 7060;
        this.im = 0;
        this.lsframe = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
        this.um = um;
        this.im = im;
        this.mport = 7060 + this.im;
        (this.servo = new Thread(this)).start();
    }

    public void stopServe() {
        try {
            this.dSocket.close();
            this.dSocket = null;
        }
        catch (Exception ex) {}
        if (this.servo != null) {
          this.servo.stop();
          this.servo = null;
          /*try {
            this.servo.join(0);
            this.servo = null;
          } catch (InterruptedException ex) {
            // NOTE: caught here
          }*/
        }
    }

    @Override
    public void run() {
        try {
            this.dSocket = new DatagramSocket(this.mport);
            final byte[] array = new byte[128];
            while (true) {
                final DatagramPacket datagramPacket = new DatagramPacket(array, array.length);
                this.dSocket.receive(datagramPacket);
                final String s = new String(datagramPacket.getData());
                String svalue = this.getSvalue(s, 0);
                final int getvalue = this.getvalue(s, 1);
                if (getvalue == this.im && this.im < this.um.nplayers && this.um.out[getvalue] != 76) {
                    final int getvalue2 = this.getvalue(s, 2);
                    int n = 0;
                    for (int i = 0; i < 3; ++i) {
                        if (getvalue2 != this.um.frame[getvalue][i]) {
                            ++n;
                        }
                    }
                    if (n == 3) {
                        for (int j = 0; j < 3; ++j) {
                            if (getvalue2 > this.um.frame[getvalue][j]) {
                                for (int k = 2; k >= j + 1; --k) {
                                    this.um.frame[getvalue][k] = this.um.frame[getvalue][k - 1];
                                    this.um.info[getvalue][k] = this.um.info[getvalue][k - 1];
                                }
                                this.um.frame[getvalue][j] = getvalue2;
                                this.um.info[getvalue][j] = this.getSvalue(s, 3);
                                j = 3;
                            }
                        }
                    }
                    if (this.um.gocnt[getvalue] != 0) {
                        int n2 = 0;
                        for (int l = 0; l < this.um.nplayers; ++l) {
                            if (this.um.frame[l][0] >= 0) {
                                ++n2;
                            }
                        }
                        if (n2 == this.um.nplayers) {
                            svalue = "1111111";
                            final int[] gocnt = this.um.gocnt;
                            final int n3 = getvalue;
                            --gocnt[n3];
                        }
                    }
                    if (!this.um.go) {
                        int n4 = 0;
                        for (int n5 = 0; n5 < this.um.nplayers; ++n5) {
                            if (this.um.frame[n5][0] >= 0) {
                                ++n4;
                            }
                        }
                        if (n4 == this.um.nplayers) {
                            final int[] gocnt2 = this.um.gocnt;
                            final int n6 = 0;
                            --gocnt2[n6];
                        }
                        if (this.um.gocnt[0] <= 1) {
                            this.um.go = true;
                        }
                    }
                }
                final InetAddress address = datagramPacket.getAddress();
                final int port = datagramPacket.getPort();
                for (int n7 = 0; n7 < this.um.nplayers; ++n7) {
                    if (n7 != this.im) {
                        int n8 = -1;
                        for (int n9 = 0; n9 < 3; ++n9) {
                            if (this.um.frame[n7][n9] == this.lsframe[n7] + 1) {
                                n8 = n9;
                            }
                        }
                        if (n8 == -1) {
                            for (int n10 = 0; n10 < 3; ++n10) {
                                if (this.um.frame[n7][n10] > this.lsframe[n7]) {
                                    n8 = n10;
                                }
                            }
                        }
                        if (n8 == -1) {
                            n8 = 0;
                        }
                        this.lsframe[n7] = this.um.frame[n7][n8];
                        final byte[] bytes = ("" + svalue + "|" + n7 + "|" + this.um.frame[n7][n8] + "|" + this.um.info[n7][n8] + "|").getBytes();
                        this.dSocket.send(new DatagramPacket(bytes, bytes.length, address, port));
                    }
                }
            }
        }
        catch (Exception ex) {}
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
