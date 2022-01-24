package components;
import processing.core.PApplet;

public class PlayerBrick extends CollidingObject {
  private int x=300, y, width, height;
  public PlayerBrick(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  // TODO: implement colliding object methods

  @Override
  public void onCollide(CollidingObject obj) {
    super.onCollide(obj);
  }  
  
  @Override
  public void draw(PApplet sketch) {
    super.draw(sketch);
  }

}