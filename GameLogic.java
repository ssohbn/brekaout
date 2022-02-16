import components.BrickManager;

import java.util.Iterator;

import components.Ball;
import components.BasicBrick;
import components.Bounds;
import components.PlayerBrick;
import processing.core.PApplet;

public class GameLogic {

  public static void firstLevel(BrickManager brickManager) {
    for ( int y=1; y<6; y++) {
      for ( int x=0; x<10; x++) {
        brickManager.add(new BasicBrick(x*80, y*40, 60, 30));
      }
    }

  }

  public static void checkCollides(Ball ball, PApplet sketch) {
    boolean needs2flip = false;

    Iterator<BasicBrick> brickerator = BrickManager.getIterator();
    if ( brickerator.hasNext() ) {

      BasicBrick brick = brickerator.next();
      if ( ball.withinBounds( brick.bounds ) ) {
        System.out.println(ball.position.x + " " + ball.position.y + "   " + brick.bounds.left);
        brickerator.remove();
        needs2flip = true;
      }

      if ( ball.withinBounds(PlayerBrick.getInstance().bounds) ) {
        needs2flip = true;
      }
      
      if (  
        ball.withinBounds(new Bounds(0, sketch.width, 0, sketch.height))
      ) {
        needs2flip = true;
      }

      if ( needs2flip ) {
        ball.flip();
      }
    }
  }
}