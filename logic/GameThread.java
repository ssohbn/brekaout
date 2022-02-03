package logic;

import java.util.concurrent.TimeUnit;

public class GameThread extends Thread {
  // will control all logic while the other draw thingy does whatever it wants
  private static GameThread INSTANCE;
  private static int ticks = 0;
  private GameThread () {
    System.out.println("i exist i guess");
  }
  
  @Override
  public void run() {
    while ( true ) {
      

      try {
        Thread.sleep(1000/30L); // 30 updates a second?
        ticks++;
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
    
  }

  public static GameThread getInstance() {
    if ( INSTANCE == null )
      INSTANCE = new GameThread();
    return INSTANCE;
  }

  public static int getTicks() {
    return ticks;
  }
}