package components;
import components.data.Bounds;
import components.data.Position;
import components.data.Size;
import processing.core.PApplet;

public class Paddle {
  private static Paddle INSTANCE = null;
  Position pos;
  Size size;

  private Paddle(int x, int y, int width, int height) {
    this.pos = new Position(x, y);
    this.size = new Size(width, height);
  }

  public Bounds getBounds() {
    return new Bounds(this.pos.x, this.pos.x + this.size.width, this.pos.y, this.pos.y + this.size.height);
  }

  public static Paddle getInstance() {
    // locks to a single playerbrick
    if ( INSTANCE == null ) INSTANCE = new Paddle(350, 600, 100, 5);
    return INSTANCE;
  }

  public void update(PApplet sketch) {
    this.pos.x = sketch.mouseX;
  }  

  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.fill(255, 0, 0);
    sketch.rect(pos.x, pos.y, size.width, size.height);
    sketch.popMatrix();
  }
}