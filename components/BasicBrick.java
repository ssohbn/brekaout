package components;
import processing.core.PApplet;

public class BasicBrick extends CollidingObject {
  
  public BasicBrick(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(PApplet sketch) {
    sketch.fill(255);
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

  @Override
  public void onCollide(CollidingObject collidable) {
    super.onCollide(collidable);
    // tbh this doesnt really matter 
    // for non playable things unless
  }
}