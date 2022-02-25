import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  private Player player;
  private Ball ball;

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    player = Player.getInstance();
    ball = Ball.getInstance();
    BrickManager.genLevel();

  }

  public void draw() {
    background(10);

    if (player.getLives() != 0) {
      if (!player.hasClicked) {
        text("hit the mouse button to begin", 80, 300);  // Default depth, no z-value specified
      }

      fill(255,0,0);
      player.draw(this);
      player.update(this);

      drawLives();
      drawBricks();

      GameLogic.checkCollides(ball, this);
      
      fill(255,0,0);
      if (player.hasClicked) {
        ball.draw(this);
        ball.update(this);
      } 
    } else {
      text("lives are gone. time 2 restart ", 48, 240);  // Default depth, no z-value specified
   }
  }

  public void mouseClicked() {
    player.hasClicked = true;
  }

  public void drawBricks() {
    for ( Brick brick : BrickManager.getBricks() ) {
      brick.draw(this);
    }
  }

  public void drawLives() {
    text("lives: " + player.getLives(), 48, 240);  // Default depth, no z-value specified
  }
}