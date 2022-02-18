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

    outOfBoundsChecks(ball, sketch);
    paddleCheck(ball);
    brickCheck(ball);


  }

  static void brickCheck(Ball ball) {
    for (int i = BrickManager.getBricks().size()-1; i >= 0; i--) {
      Brick brick = BrickManager.getBricks().get(i);
      if ( ball.withinBounds( brick.getBounds()) ) {
        ball.flipY();
        BrickManager.getBricks().remove(brick);
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