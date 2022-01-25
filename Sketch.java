import processing.core.PApplet;
import components.*;

public class Sketch extends PApplet {

  private BasicBrick brick;
  private BasicBrick brick2;
  private PlayerBrick player;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    
    brick = new BasicBrick(50, 50, 50, 50);
    brick2 = new BasicBrick(50, 50, 50, 50);
    player = new PlayerBrick(300, 50, 50, 50);
  }

  public void draw() {
    background(0);
    fill(0);
    brick.draw(this);
    brick2.draw(this);
    player.draw(this);

  }
  
}