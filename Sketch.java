import processing.core.PApplet;
import processing.core.PImage;
import components.*;
import components.managey.BrickManager;
import components.managey.PowerUpManager;

public class Sketch extends PApplet {

  private Player player;
  private Ball ball;
  PImage img;

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    player = Player.getInstance();
    ball = Ball.getInstance();
    BrickManager.genLevel();
    img = loadImage("./ferris.png");
  }

  public void draw() {
    background(10);
    image(img, 0, 0, width, height);

    if (player.getLives() != 0) {
      if (!player.hasClicked) {
        text("hit the mouse button to begin", 80, 300);  // Default depth, no z-value specified
      }


      fill(0, 255, 0);
      for ( PowerUp powerUp : PowerUpManager.getInstance().getPowerUps()) {
        powerUp.update();
      }

      fill(255,0,0);
      player.draw(this);
      player.update(this);

      drawLivesAndScore();
      drawBricks();

      GameLogic.checkCollides(ball, this);
      
      fill(255,0,0);
      if (player.hasClicked) {
        ball.draw(this);
        ball.update(this);
      } 

    } else {
      text("lives are gone. time 2 restart ", 48, 240);
   }
  }

  public void mouseClicked() {
    player.hasClicked = true;
  }

  public void drawBricks() {
    for ( Brick brick : BrickManager.getInstance().getBricks() ) {
      brick.draw(this);
    }
  }

  public void drawPowerUps() {
    for ( PowerUp powerUp : PowerUpManager.getInstance().getPowerUps() ) {
      powerUp.draw(this);
    }
  }

  public void drawLivesAndScore() {
    text("lives: " + player.getLives(), 48, 240);
    text("score: " + BrickManager.getInstance().getLevel(), 48, 340);
  }

}