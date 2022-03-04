import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;

import components.Ball;
import components.Brick;
import components.Player;
import components.PowerUp;
import components.data.Position;
import components.managey.BrickManager;
import components.managey.PowerUpManager;

public class Sketch extends PApplet {

  private SoundFile wiiMusic;
  private Player player;
  private Ball ball;
  PImage img;
  private boolean restart = false;

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    player = Player.getInstance();
    ball = Ball.getInstance();
    BrickManager.genLevel();
    img = loadImage("./ferris.png");
    wiiMusic =  new SoundFile(this, "./WiiSports.mp3" );
    wiiMusic.play();
  }

  public void draw() {
    // wiiMusic.play();
    background(10);
    image(img, 0, 0, width, height);

    if (!player.hasClicked) {
      if (restart) {
        gameOver();
      } else {
        gameStart();
      }
    } else if (player.getLives() != 0) {
      
      gamePlaying();

    } else {
      player.hasClicked = false;
      player.setPosition(new Position(350, 600)); // i should replace this as reset position 
      restart = true;
      player.setLives(3);
      BrickManager.getInstance().resetLevel();
      gameOver();
   }
  }

  void gamePlaying() {
      for ( PowerUp powerUp : PowerUpManager.getInstance().getPowerUps()) {
        powerUp.update();
      }
      fill(0, 255, 0);
      drawPowerUps();

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
  }

  void gameStart() {
    text("hit the mouse button to begin", 80, 300);  // Default depth, no z-value specified
  }
  
  void gameOver() {
    text("lives are gone. click to reset score and continue", 48, 240);
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