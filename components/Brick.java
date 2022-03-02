package components;
import components.data.Bounds;
import components.data.Position;
import components.data.Size;
import components.data.interfaces.Collide;
import components.data.interfaces.Draw;
import processing.core.PApplet;

public class Brick implements Collide, Draw {
  public final Position POS;
  public final Size SIZE;  
  public int health = 3;

  public Brick(int x, int y, int width, int height) {
    this.POS = new Position(x, y);
    this.SIZE = new Size(width, height);
  }

  public Bounds getBounds() {
    return new Bounds(POS.x, POS.x+SIZE.width, POS.y, POS.y+SIZE.height);
  }

  public void draw(PApplet sketch) {

    switch (health) {

      case 3:
        // geren
        sketch.fill(0, 255, 0);
        break;

      case 2: 
        sketch.fill(255, 255, 0);
        // yellow
        break;

      case 1:
        sketch.fill(255, 0, 0);
        // red
        break;
    }

    sketch.pushMatrix();
    sketch.rect(POS.x, POS.y, SIZE.width, SIZE.height);
    sketch.popMatrix();
  }
}
  