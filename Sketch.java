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
    
     // import this  later
    brick = new BasicBrick(50, 50, 50, 50);
    brick2 = new BasicBrick(50, 50, 50, 50);
    
    player = PlayerBrick.getInstance();
    
    GameThread gamethread = GameThread.getInstance();gamethread.start();
    brickmanager = BrickManager.getInstance(); 
    Iterator brickerator = BrickManager.getIterator();
    // le create game thread
  }

  public void draw() {
    background(0);
    
    
    player.draw(this);
    
    fill(50);
    rect(50,50,50,50);
    
  }
  
}