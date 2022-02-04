package components;

import processing.core.PApplet;

public class CollidingObject {

  private int x, y, width, height;

  public CollidingObject(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.rect(this.x, this.y, width, height);
    sketch.popMatrix();

  }

  public boolean isColliding(CollidingObject collidable) {
    // this part is a pain :(
    int left = this.x;
    int right = this.x + this.width;
    int top = this.y;
    int bottom = this.y + this.height;
    // hitbox bounds

    if (
      pointInCollidingObject(left, top, collidable) ||
      pointInCollidingObject(right, top, collidable) ||
      pointInCollidingObject(left, bottom, collidable) ||
      pointInCollidingObject(right, bottom, collidable) ) {
      onCollide(collidable);
      return true;
    } else return false;
  }

  private boolean pointInCollidingObject(int x, int y, CollidingObject collidable) {
    int l = collidable.x;
    int r = collidable.x + collidable.width;
    int t = collidable.y;
    int b = collidable.y + collidable.height;

    if( x <= r && x >= l &&
      y <= b && y >= t 
    ) return true;
    else return false;
  }
  
  public void onCollide(CollidingObject object) {
    // idc
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

}
