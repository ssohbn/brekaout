package components;
import processing.core.PApplet;

public class PlayerBrick extends CollidingObject {
  private static PlayerBrick INSTANCE = null;
  // singleton because I only want one player

  private PlayerBrick(int x, int y, int width, int height) {
    super(x, y, width, height); 
  }

  @Override
  public void onCollide(CollidingObject obj) {
    super.onCollide(obj);
  }  
  
  public static PlayerBrick getInstance() {
    // locks to a single playerbrick
    if ( INSTANCE == null ) INSTANCE = new PlayerBrick(350, 600, 80, 25);
    return INSTANCE;
  }

  @Override
  public void setX(int x) {
      // TODO Auto-generated method stub
      super.setX(x);
  }

  @Override
  public void setY(int y) {
      // TODO Auto-generated method stub
      super.setY(y);
  }


  @Override
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.fill(255, 0, 0);
    sketch.rect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    sketch.popMatrix();
  }
}