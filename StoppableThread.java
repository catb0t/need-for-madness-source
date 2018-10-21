import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoppableThread extends Thread {

  private static final Logger logger = Logger.getLogger("StoppableThread");

  private boolean stopping_thread = false;

  public StoppableThread() {
    super();
    this.logger.addHandler(new ConsoleHandler());
  }

  public StoppableThread(Runnable target, String name) {
    super(target, name);
  }

  public StoppableThread(Runnable target) {
    super(target);
  }

  public StoppableThread(String name) {
    super(name);
  }

  public boolean stopping() {
    return this.stopping_thread;
  }

  public void stop(boolean wait_end) {
    this.stopping_thread = true;
    if (wait_end) {
      this.wait_end();
    } else {
      this.stop();
    }
  }

  public void wait_end() {

    while( this.isAlive() ) {
      try {
        // ?? ?? Thread.sleep(100L);
        this.sleep(100L);
        this.yield();
      } catch (InterruptedException ie) {
        this.logger.log(Level.WARNING, ie.toString(), ie);
      }
    }
  }

}
