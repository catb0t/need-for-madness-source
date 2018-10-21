import javax.sound.sampled.Line;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioFormat;
import java.io.ByteArrayInputStream;
import javax.sound.sampled.SourceDataLine;

public class SuperClip implements Runnable
{
    int skiprate;
    Thread cliper;
    int stoped;
    SourceDataLine source;
    ByteArrayInputStream stream;
    int rollBackPos;
    int rollBackTrig;
    boolean changeGain;
    
    public SuperClip(final byte[] array, final int n, final int skiprate) {
        this.skiprate = 0;
        this.stoped = 1;
        this.source = null;
        this.rollBackPos = 0;
        this.rollBackTrig = 0;
        this.changeGain = false;
        this.stoped = 2;
        this.skiprate = skiprate;
        this.stream = new ByteArrayInputStream(array, 0, n);
    }
    
    @Override
    public void run() {
        try {
            final AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, this.skiprate, 16, 1, 2, this.skiprate, false);
            (this.source = (SourceDataLine)AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, audioFormat))).open(audioFormat);
            this.source.start();
        }
        catch (Exception ex2) {
            this.stoped = 1;
        }
        int n = 0;
        while (this.stoped == 0) {
            try {
                final int skiprate = this.skiprate;
                int available = this.stream.available();
                if (available % 2 != 0) {
                    ++available;
                }
                byte[] array = new byte[(available > skiprate) ? skiprate : available];
                final int read = this.stream.read(array, 0, array.length);
                if (read == -1 || (this.rollBackPos != 0 && available < this.rollBackTrig)) {
                    n = 1;
                }
                if (n != 0) {
                    if (read != -1) {
                        this.source.write(array, 0, array.length);
                    }
                    this.stream.reset();
                    if (this.rollBackPos != 0) {
                        this.stream.skip(this.rollBackPos);
                    }
                    int available2 = this.stream.available();
                    if (available2 % 2 != 0) {
                        ++available2;
                    }
                    array = new byte[(available2 > skiprate) ? skiprate : available2];
                    this.stream.read(array, 0, array.length);
                    n = 0;
                }
                this.source.write(array, 0, array.length);
            }
            catch (Exception ex) {
                System.out.println("Play error: " + ex);
                this.stoped = 1;
            }
            try {
                final Thread cliper = this.cliper;
                Thread.sleep(200L);
            }
            catch (InterruptedException ex3) {}
        }
        this.source.stop();
        this.source.close();
        this.source = null;
        this.stoped = 2;
    }
    
    public void play() {
        if (this.stoped == 2) {
            this.stoped = 0;
            try {
                this.stream.reset();
            }
            catch (Exception ex) {}
            (this.cliper = new Thread(this)).start();
        }
    }
    
    public void resume() {
        if (this.stoped == 2) {
            this.stoped = 0;
            (this.cliper = new Thread(this)).start();
        }
    }
    
    public void stop() {
        if (this.stoped == 0) {
            this.stoped = 1;
            if (this.source != null) {
                this.source.stop();
            }
        }
    }
    
    public void close() {
        try {
            this.stream.close();
            this.stream = null;
        }
        catch (Exception ex) {}
    }
}
