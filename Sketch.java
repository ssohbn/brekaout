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

    player.update(this);
    player.draw(this);

    ball.update(this);
    ball.draw(this);

    GameLogic.checkCollides(ball, this);
    drawBricks();
    
  }

  public void drawBricks() {
    for ( Brick brick : BrickManager.getBricks() ) {
      brick.draw(this);
    }
  }

  
}