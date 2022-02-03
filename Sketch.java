import processing.core.PApplet;
import components.*;
import logic.*;
import java.util.Iterator;

public class Sketch extends PApplet {

  private BasicBrick brick;
  private BasicBrick brick2;
  private PlayerBrick player;
  private BrickManager brickmanager;

  Iterator<BasicBrick> brickerator;
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    
    
    player = PlayerBrick.getInstance();
    
    GameThread gamethread = GameThread.getInstance();gamethread.start();

    brickmanager = BrickManager.getInstance(); 
    brickmanager.add( new BasicBrick(50, 50, 50, 50) );
    
    brickerator = BrickManager.getIterator();
    
  }

  public void draw() {
    background(0);
    fill(50);
    
    player.draw(this);

    // drawing bricks to screen
    while ( brickerator.hasNext() ) {
      brickerator.next().draw(this);
    }

  }
  
}