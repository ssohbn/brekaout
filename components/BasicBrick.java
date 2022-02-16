package components;
import processing.core.PApplet;

public class BasicBrick extends CollidingObject {
  
  public BasicBrick(int x, int y, int width, int height) {
    super(x, y, width, height);
    this.position = super.position;
    this.size = super.size;
    this.bounds = super.bounds;
    BrickManager.getInstance().add(this);
  }

  @Override
  public void draw(PApplet sketch) {
    sketch.fill(255);
    super.draw(sketch);
  }
}
  