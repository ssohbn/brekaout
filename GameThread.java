import components.BrickManager;
import components.BasicBrick;
import components.PlayerBrick;
import processing.core.PApplet;

public class GameThread extends Thread {
  // will control all logic while the other draw thingy does whatever it wants
  private static GameThread INSTANCE;
  private static PlayerBrick player;
  private static BrickManager brickmanager;
  private static PApplet sketch;

  private GameThread () {
    player = PlayerBrick.getInstance();
    brickmanager = BrickManager.getInstance();
  }
  private GameThread (PApplet sketchy) {
    player = PlayerBrick.getInstance();
    brickmanager = BrickManager.getInstance();
    sketch = sketchy;
  }

  @Override
  public void run() {
    while ( true ) {
      try {

        player.setX(sketch.mouseX);




        Thread.sleep(1000/30L);
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

  public static GameThread getInstance(PApplet sketch) {
    if ( INSTANCE == null )
      INSTANCE = new GameThread(sketch);
    return INSTANCE;
  }
}