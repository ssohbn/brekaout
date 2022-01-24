package components;
import interfaces.ICollidable;
import processing.core.PApplet;

public class BasicBrick extends CollidingObject {
  
  public BasicBrick(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(PApplet sketch) {
    super.draw(sketch);
  }

  @Override
  public void setX(int x) {
    super.setX(x);
  }

  @Override
  public void setY(int y) {
    super.setY(y);
  }

  @Override
  public boolean isColliding(CollidingObject collidable) {
    return super.isColliding(collidable);
  }
}