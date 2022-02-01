package components;
import processing.core.PApplet;

public class PlayerBrick extends CollidingObject {
  private static PlayerBrick INSTANCE = null;
  // singleton because I only want one player

  private int x, y, width, height;
  private PlayerBrick(int x, int y, int width, int height) {
    super(x, y, width, height); 
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @Override
  public void onCollide(CollidingObject obj) {
    super.onCollide(obj);
  }  
  
  public static PlayerBrick getInstance() {
    // locks to a single playerbrick
    if ( INSTANCE == null ) INSTANCE = new PlayerBrick(300, 50, 50, 50);
    return INSTANCE;
  }

  @Override
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.fill(255, 0, 0);
    sketch.rect(this.x, this.y, this.width, this.height);
    sketch.popMatrix();
  }
}