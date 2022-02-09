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


  private void firstLevel() {
    for ( int y=1; y<6; y++) {
      for ( int x=0; x<10; x++) {
        brickmanager.add(new BasicBrick(x*80, y*40, 60, 30));
      }
    }

  }

  @Override
  public void run() {
    firstLevel();

    while ( true ) {
      try {
        // PLAYER STUFF
        player.setX(sketch.mouseX);


        // BRICKY STUFF


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