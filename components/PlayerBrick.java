package components;
import processing.core.PApplet;

public class PlayerBrick {
  private static PlayerBrick INSTANCE = null;
  Position pos;
  Size size;

  private PlayerBrick(int x, int y, int width, int height) {
    this.pos = new Position(x, y);
    this.size = new Size(width, height);
  }

  public Bounds getBounds() {
    return new Bounds(this.pos.x, this.pos.x + this.size.width, this.pos.y, this.pos.y + this.size.height);
  }

  
  public static PlayerBrick getInstance() {
    // locks to a single playerbrick
    if ( INSTANCE == null ) INSTANCE = new PlayerBrick(350, 600, 80, 25);
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