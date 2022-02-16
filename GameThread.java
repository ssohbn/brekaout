import components.BrickManager;

import java.util.Iterator;

import components.Ball;
import components.BasicBrick;
import components.PlayerBrick;
import components.Position;
import processing.core.PApplet;

public class GameThread extends Thread {
  public boolean drawable;
  private static GameThread INSTANCE;
  private static PlayerBrick player;
  private static BrickManager brickmanager;
  private static PApplet sketch;
  private static Ball ball;

  private GameThread (PApplet sketchy) {
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
    ball = Ball.getInstance();
    player = PlayerBrick.getInstance();
    brickmanager = BrickManager.getInstance();
    firstLevel();

    while ( true ) {
      try {
        drawable = false;
        checkCollide();
        drawable = true;

        // PLAYER STUFF
        player.position = new Position(sketch.mouseX, 600);

        //ball
        ball.update();


        Thread.sleep(1000/30L);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
    
  }

  public void checkCollide() {
    boolean needs2flip = false;

    Iterator<BasicBrick> brickerator = BrickManager.getIterator();
    if ( brickerator.hasNext() ) {
      BasicBrick brick = brickerator.next();

      if ( ball.withinBounds( brick.bounds ) ) {
        brickerator.remove();
        needs2flip = true;
      }

      if ( ball.withinBounds(PlayerBrick.getInstance().bounds) ) {
        needs2flip = true;
      }
      
      if ( ball.position.x > 700 || ball.position.x < 0
          || ball.position.y > 700 || ball.position.y < 0 
      ) {
        needs2flip = true;
      }

      if ( needs2flip ) {
        ball.flip();
      }
    }
  }

  public static GameThread getInstance() {
    // instance is made in sketch
    // possible spaghetti but whatever
    return INSTANCE;
  }

  public static GameThread getInstance(PApplet sketch) {
    if ( INSTANCE == null )
      INSTANCE = new GameThread(sketch);
    return INSTANCE;
  }
}