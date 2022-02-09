import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  
  private PlayerBrick player;
  private BrickManager brickmanager;

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    background(10);
    
    player = PlayerBrick.getInstance();
    
    GameThread gamethread = GameThread.getInstance(this);
    gamethread.start();

    brickmanager = BrickManager.getInstance(); 
    brickmanager.add( new BasicBrick(50, 50, 50, 50) );
    
  }

  public void draw() {
    background(0);
    player.draw(this);

    // drawing bricks to screen
    for ( BasicBrick brick : BrickManager.getBricks() ) {
      brick.draw(this);
    }
  }
  
}