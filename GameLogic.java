import components.BrickManager;
import components.Ball;
import components.Brick;
import components.PlayerBrick;
import components.data.Collisions;
import processing.core.PApplet;
import java.util.ArrayList;

public class GameLogic {

  public static void firstLevel(BrickManager brickManager) {
    for ( int y=1; y<6; y++) {
      for ( int x=0; x<10; x++) {
        brickManager.add(new Brick(x*80, y*40, 60, 30));
      }
    }
  }

  public static void checkCollides(Ball ball, PApplet sketch) {

    if (brickCheck(ball)||paddleCheck(ball)) {
      ball.flipY();
    } else {
      outOfBoundsChecks(ball, sketch);
    }
  }

  static boolean brickCheck(Ball ball) {
    ArrayList<Brick> bricks = BrickManager.getBricks();
    for (int i = bricks.size()-1; i >= 0; i--) {
      Brick brick = bricks.get(i);
      if ( ball.withinBounds( brick.getBounds()) ) {
        System.out.println(bricks.remove(i));
        return true;
      }
    }
    return false;
  }

  static boolean paddleCheck(Ball ball) {
    if ( ball.withinBounds(PlayerBrick.getInstance().getBounds()) ) {
      return true;
    }
    return false;
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