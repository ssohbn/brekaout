import components.BrickManager;
import components.Ball;
import components.Brick;
import components.Player;
import components.data.Collisions;
import processing.core.PApplet;
import java.util.ArrayList;

public class GameLogic {

  public static void checkCollides(Ball ball, PApplet sketch) {
    if (Player.getInstance().hasClicked) {
      if (brickCheck(ball)||paddleCheck(ball)) {
        ball.flipY();
      } else {
        outOfBoundsChecks(ball, sketch);
      }
    }
 }

  static boolean brickCheck(Ball ball) {
    ArrayList<Brick> bricks = BrickManager.getBricks();
    for (int i = bricks.size()-1; i >= 0; i--) {
      Brick brick = bricks.get(i);
      if (brick.health ==0) continue;

      if ( ball.withinBounds( brick.getBounds()) ) {
        brick.health -= 1;
        if (brick.health==0) {
          bricks.remove(brick);
        }
        return true;
      }
    }
    return false;
  }

  static boolean paddleCheck(Ball ball) {
    if ( ball.withinBounds(Player.getInstance().getBounds()) ) {
      return true;
    }
    return false;
  }

  static void outOfBoundsChecks(Ball ball, PApplet sketch) {
    if (Collisions.outOfBoundsX(ball.getBounds(), sketch)) {
      ball.flipX();
    }

    if (Collisions.outOfBoundsY(ball.getBounds(), sketch)) {
      if (Collisions.belowScreenHeight(ball.getBounds(), sketch)) {
        Player.getInstance().decrementLives();
      }
      // flips no matter if lives are lost
      ball.flipY();
    }

  }
}