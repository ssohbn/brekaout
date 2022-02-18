import components.BrickManager;
import components.Collisions;

import java.util.Iterator;

import components.Ball;
import components.Brick;
import components.PlayerBrick;
import processing.core.PApplet;

public class GameLogic {

  public static void firstLevel(BrickManager brickManager) {
    for ( int y=1; y<6; y++) {
      for ( int x=0; x<10; x++) {
        brickManager.add(new Brick(x*80, y*40, 60, 30));
      }
    }
  }

  public static void checkCollides(Ball ball, PApplet sketch) {

    brickCheck(ball);
    paddleCheck(ball);
    outOfBoundsChecks(ball, sketch);


  }

  static void brickCheck(Ball ball) {
    Iterator<Brick> brickerator = BrickManager.getIterator();
    if ( brickerator.hasNext() ) {
      Brick brick = brickerator.next();

      if ( ball.withinBounds( brick.getBounds()) ) {
        brickerator.remove();
        ball.flipY();
      }
    }
  }


  static void paddleCheck(Ball ball) {
    if ( ball.withinBounds(PlayerBrick.getInstance().getBounds()) ) {
          ball.flipY();
    }
  }

  static void outOfBoundsChecks(Ball ball, PApplet sketch) {
    if (Collisions.outOfBoundsX(ball.getBounds(), sketch)) {
      ball.flipX();
    }

    if (Collisions.outOfBoundsY(ball.getBounds(), sketch)) {
      ball.flipY();
    }


  }
}