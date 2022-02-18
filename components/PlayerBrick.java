package components;
import processing.core.PApplet;

public class PlayerBrick extends CollidingObject {
  private static PlayerBrick INSTANCE = null;
  // singleton because I only want one player

  private PlayerBrick(int x, int y, int width, int height) {
    super(x, y, width, height); 
  }

  
  public static PlayerBrick getInstance() {
    // locks to a single playerbrick
    if ( INSTANCE == null ) INSTANCE = new PlayerBrick(350, 600, 80, 25);
    return INSTANCE;
  }

  public void update(PApplet sketch) {
    position.x = sketch.mouseX;
  }  


  @Override
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.fill(255, 0, 0);
    sketch.rect(position.x, position.y, size.width, size.height);
    sketch.popMatrix();
  }
}