import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  
  private PlayerBrick player;
  private BrickManager brickmanager;

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    GameThread gamethread = GameThread.getInstance(this);
    gamethread.start();

    player = PlayerBrick.getInstance();
    brickmanager = BrickManager.getInstance(); 
    
  }

  public void draw() {
    background(10);
    player.draw(this);

    // drawing bricks to screen

    for ( BasicBrick brick : BrickManager.getBricks() ) {
      brick.draw(this);
    }
  }
  
}