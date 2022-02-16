import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  
  private PlayerBrick player;
  private Ball ball;
  GameThread gamethread;

  public void settings() {
    size(700, 700);
  }


  public void setup() {
    GameThread gamethread = GameThread.getInstance(this);
    gamethread.start();

    player = PlayerBrick.getInstance();
    ball = Ball.getInstance();
  }

  public void draw() {
    background(10);
    player.draw(this);
    ball.draw(this);

    if ( gamethread.drawable ) {
      drawBricks();
    }
    
  }

  public void drawBricks() {
    for ( BasicBrick brick : BrickManager.getBricks() ) {
      brick.draw(this);
    }
  }
  
}