import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  
  private PlayerBrick player;
  private Ball ball;

  public void settings() {
    size(700, 700);
  }



  public void setup() {
    player = PlayerBrick.getInstance();
    ball = Ball.getInstance();
    GameLogic.firstLevel(BrickManager.getInstance());

  }

  public void draw() {
    background(10);
    player.draw(this);
    ball.draw(this);
    drawBricks();

    ball.update(this);
    player.update(this);
    GameLogic.checkCollides(ball, this);

  }

  public void drawBricks() {
    for ( Brick brick : BrickManager.getBricks() ) {
      if (brick.health != 0)
        brick.draw(this);
    }
  }
}