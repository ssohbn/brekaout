package components;

import processing.core.PApplet;
import components.Util;

public class CollidingObject {
  public  Position  position;
  public  Size      size;
  public  Bounds    bounds;

  public CollidingObject(int x, int y, int width, int height) {
    this.position  = new Position(x, y);
    this.size      = new Size(width, height);
    this.bounds    = new Bounds(position.x, position.x+size.width, position.y, position.y+size.height);
  }

  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.rect(position.x, position.y, size.width, size.height);
    sketch.popMatrix();
  }

  public boolean isColliding(CollidingObject collidable) {
    if (
      Util.posInBounds(new Position(bounds.left, bounds.top), collidable.bounds) ||
      Util.posInBounds(new Position(bounds.right, bounds.top), collidable.bounds) ||
      Util.posInBounds(new Position(bounds.left, bounds.bottom), collidable.bounds) ||
      Util.posInBounds(new Position(bounds.right, bounds.bottom), collidable.bounds) ) {
      return true;
    } else return false;
  }

  
}
