import components.BrickManager;
import components.Collisions;

import java.util.Iterator;

import components.Ball;
import components.Brick;
import components.Bounds;
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
    boolean needs2flip = false;

    Iterator<Brick> brickerator = BrickManager.getIterator();
    if ( brickerator.hasNext() ) {
      Brick brick = brickerator.next();

      if ( ball.withinBounds( brick.bounds ) ) {
        brickerator.remove();
        needs2flip = true;
      }

      if ( ball.withinBounds(PlayerBrick.getInstance().getBounds()) ) {
        needs2flip = true;
      }
      if (Collisions.outOfBoundsX(ball.getBounds(), sketch)) {
        ball.flipX();
      }

      if (Collisions.outOfBoundsY(ball.getBounds(), sketch)) {
        ball.flipY();
      }

      if (needs2flip) {
        ball.flipY();
      }
    }
  }
}