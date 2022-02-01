import processing.core.PApplet;
import components.*;
import logic.*;

public class Sketch extends PApplet {

  private BasicBrick brick;
  private BasicBrick brick2;
  private PlayerBrick player;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    
    Iterator brickerator; // import this  later
    brick = new BasicBrick(50, 50, 50, 50);
    brick2 = new BasicBrick(50, 50, 50, 50);
    
    player = PlayerBrick.getInstance();
    
    
    GameThread gamethread = GameThread.getInstance();
    // le create game thread
  }

  public void draw() {
    background(0);
    fill(0);
    
    while ( BrickManager.getInstance()
      .getIterator().hasNext() ) {
          // draw brickys
      }  
    player.draw(this);

  }
  
}