package components;
import processing.core.PApplet;

public class Brick {
  public Position position;
  public Bounds bounds;
  public Size size;  

  public Brick(int x, int y, int width, int height) {
    this.position = new Position(x, y);
    this.size = new Size(width, height);
    this.bounds = new Bounds(position.x, position.x+size.width, position.y, position.y+size.height);

    BrickManager.getInstance().add(this);
  }

  public void draw(PApplet sketch) {
    sketch.fill(255);
    sketch.pushMatrix();
    sketch.rect(position.x, position.y, size.width, size.height);
    sketch.popMatrix();
  }
}
  