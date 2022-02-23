import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  private Paddle player;
  private Ball ball;

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    player = Paddle.getInstance();
    ball = Ball.getInstance();
    GameLogic.firstLevel(BrickManager.getInstance());

  }

  public void draw() {
    background(10);

    player.draw(this);
    player.update(this);

    if (player.hasClicked) {
      ball.draw(this);
      ball.update(this);
    }

    drawBricks();
    GameLogic.checkCollides(ball, this);

  }

  public void mouseClicked() {
    player.hasClicked = true;
  }

  public void drawBricks() {
    for ( Brick brick : BrickManager.getBricks() ) {
      if (brick.health != 0)
        brick.draw(this);
    }
  }
}