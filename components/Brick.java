package components;
import components.data.Bounds;
import components.data.Position;
import components.data.Size;
import processing.core.PApplet;

public class Brick {
  public final Position POS;
  public final Size SIZE;  
  public int health = 1;

  public Brick(int x, int y, int width, int height) {
    this.POS = new Position(x, y);
    this.SIZE = new Size(width, height);
    BrickManager.getInstance().add(this);
  }

  public Bounds getBounds() {
    return new Bounds(POS.x, POS.x+SIZE.width, POS.y, POS.y+SIZE.height);
  }

  public void draw(PApplet sketch) {
    sketch.fill(255);
    sketch.pushMatrix();
    sketch.rect(POS.x, POS.y, SIZE.width, SIZE.height);
    sketch.popMatrix();
  }
}
  