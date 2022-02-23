package components;
import components.data.Bounds;
import components.data.Position;
import components.data.Size;
import processing.core.PApplet;

public class Brick {
  public Position pos;
  public Size size;  

  public Brick(int x, int y, int width, int height) {
    this.pos = new Position(x, y);
    this.size = new Size(width, height);

    BrickManager.getInstance().add(this);
  }

  public Bounds getBounds() {
    return new Bounds(pos.x, pos.x+size.width, pos.y, pos.y+size.height);
  }

  public void draw(PApplet sketch) {
    sketch.fill(255);
    sketch.pushMatrix();
    sketch.rect(pos.x, pos.y, size.width, size.height);
    sketch.popMatrix();
  }
}
  