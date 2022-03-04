import components.Ball;
import components.Brick;
import components.Player;
import components.PowerUp;
import components.data.Collisions;
import components.managey.BrickManager;
import components.managey.PowerUpManager;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
  private static final Player PLAYER = Player.getInstance();
  static Random random = new Random();  

  public static void checkCollides(Ball ball, PApplet sketch) {
    if (PLAYER.hasClicked) {

      powerUpCheck();
      if (brickCheck(ball)||paddleCheck(ball)) {
        ball.flipY();
      } else {
        outOfBoundsChecks(ball, sketch);
      }
    }
 }

  static boolean brickCheck(Ball ball) {
    ArrayList<Brick> bricks = BrickManager.getInstance().getBricks();
    for (int i = bricks.size()-1; i >= 0; i--) {
      Brick brick = bricks.get(i);
      if (brick.health ==0) continue;

      if ( ball.withinBounds( brick.getBounds()) ) {
        brick.health -= 1;
        if (brick.health==0) {
          brickDied(brick);
          bricks.remove(brick);
        }
        return true;
      }
    }
    return false;
  }

  static void brickDied(Brick brick) {
    if (random.nextBoolean()) {
      PowerUpManager.getInstance().add(new PowerUp(brick.POS.x, brick.POS.y, 5, 5));
    }
  }

  static void powerUpCheck() {
    for ( int i = 0; i < PowerUpManager.getInstance().getPowerUps().size(); i++ ) {
      // bricks do not get removed out of bounds as a feature
      // as the game goes on, u will leak memory 
      // unless the jvm gets aggressive
      if ( PowerUpManager.getInstance().getPowerUps().get(i).withinBounds(PLAYER.getBounds()) ) {
        PLAYER.setLives(PLAYER.getLives()+1);
        PowerUpManager.getInstance()
          .getPowerUps()
          .remove(PowerUpManager
          .getInstance()
          .getPowerUps()
          .get( // funky pyramid :)
            (
              (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (
                                          (
                                            (
                                              (
                                                (
                                                  (
                                                    (
                                                      (
                                                        (
                                                          (
                                                            (
                                                              (
                                                                (
                                                                  (
                                                                    (
                                                                      (
                                                                        (
                                                                          (
                                                                            (
                                                                              (
                                                                                (
                                                                                  (
                                                                                    i
                                                                                  )
                                                                                )
                                                                              )
                                                                            )
                                                                          )
                                                                        )
                                                                      )
                                                                    )
                                                                  )
                                                                )
                                                              )
                                                            )
                                                          )
                                                        )
                                                      )
                                                    )
                                                  )
                                                )
                                              )
                                            )
                                          )
                                        )
                                      )
                                    )
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        );
      }
    }
  }

  static boolean paddleCheck(Ball ball) {
    if ( ball.withinBounds(PLAYER.getBounds()) ) {
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
        PLAYER.decrementLives();
      }
      // flips no matter if lives are lost
      ball.flipY();
    }
  }
}