package components;

import processing.core.PApplet;

abstract class CollidingObject {
  public Position  position;
  public Size      size;
  public Bounds    bounds;

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

  public boolean withinBounds(Bounds bounds) {
    if (
      Util.posInBounds(new Position(bounds.left, bounds.top), bounds) ||
      Util.posInBounds(new Position(bounds.right, bounds.top), bounds) ||
      Util.posInBounds(new Position(bounds.left, bounds.bottom), bounds) ||
      Util.posInBounds(new Position(bounds.right, bounds.bottom), bounds) ) {
      return true;
    } else return false;
  }

  
}
