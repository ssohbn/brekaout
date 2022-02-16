package components;
import processing.core.PApplet;

public class BasicBrick extends CollidingObject {
  public Position position;
  public Bounds bounds;
  public Size size;  

  public BasicBrick(int x, int y, int width, int height) {
    super(x, y, width, height);
    this.position = new Position(x, y);
    this.size = new Size(width, height);
    this.bounds = new Bounds(position.x, position.x+size.width, position.y, position.y+size.height);

    BrickManager.getInstance().add(this);
  }

  @Override
  public void draw(PApplet sketch) {
    sketch.fill(255);
    super.draw(sketch);
  }
}
  