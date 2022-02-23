package components;
import components.data.Bounds;
import components.data.Position;
import components.data.Size;
import processing.core.PApplet;

public class Player {
  private static Player INSTANCE = null;
  Position pos;
  Size size;
  int lives;
  public boolean hasClicked;

  private Player(int x, int y, int width, int height) {
    this.pos = new Position(x, y);
    this.size = new Size(width, height);
    this.lives = 3;
  }

  public void decrementLives() {
    this.lives-=1;
  }
  
  public Bounds getBounds() {
    return new Bounds(this.pos.x, this.pos.x + this.size.width, this.pos.y, this.pos.y + this.size.height);
  }

  public static Player getInstance() {
    // locks to a single playerbrick
    if ( INSTANCE == null ) INSTANCE = new Player(350, 600, 100, 5);
    return INSTANCE;
  }

  public int getLives() {
    return this.lives;
  }

  public void update(PApplet sketch) {
    this.pos.x = sketch.mouseX;
  }  

  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.fill(255, 0, 0);
    if (hasClicked) {
      sketch.rect(pos.x, pos.y, size.width, size.height);
    } else {

      sketch.rect(pos.x+(size.width/2), pos.y-25, 20, 20);
      sketch.rect(pos.x, pos.y, size.width, size.height);
    }
    sketch.popMatrix();
  }
}