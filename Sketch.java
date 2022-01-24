import processing.core.PApplet;
import components.BasicBrick;

public class Sketch extends PApplet {

  private BasicBrick brick;
  private BasicBrick brick2;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    
    brick = new BasicBrick(50, 50, 50, 50);
    brick2 = new BasicBrick(50, 50, 50, 50);
  }

  public void draw() {
    background(0);
    brick.draw(this);
    brick2.draw(this);
    brick.setX(mouseX);
    brick.setY(mouseY);
    System.out.println(brick.isColliding(brick2));
  }
  
}