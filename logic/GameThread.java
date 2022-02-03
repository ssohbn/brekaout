package logic;

import java.util.concurrent.TimeUnit;
import components.BrickManager;
import components.BasicBrick;
import components.PlayerBrick;

public class GameThread extends Thread {
  // will control all logic while the other draw thingy does whatever it wants
  private static GameThread INSTANCE;
  private static PlayerBrick player;
  private static BrickManager brickmanager;

  private GameThread () {
    System.out.println("i exist i guess");
  }
  
  @Override
  public void run() {
    while ( true ) {
      
      try {
        Thread.sleep(1000/30L);
         // 30 updates a second?
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