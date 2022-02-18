package components;

import processing.core.PApplet;

public class Ball {

    private static Ball INSTANCE;
    Direction dir = new Direction(1, -1);
    int speed = 10;
    Position pos;
    Size size;

    private Ball(int x, int y, int width, int height) {
        this.pos = new Position(x, y);
        this.size = new Size(width, height);
    }

    public void update(PApplet sketch) {
        pos= new Position(pos.x + (speed*dir.x), pos.y + (speed*dir.y));
    }

    public static Ball getInstance() {
        if ( INSTANCE == null )
        INSTANCE = new Ball(300, 300, 50, 50);
        return INSTANCE;
    }
    
    public Position getPosition() {
        return this.pos;
    }

    public Bounds getBounds() {
        return new Bounds(this.pos.x, this.pos.x + this.size.width, this.pos.y, this.pos.y + this.size.height);
    }

    public Size getSize() {
        return this.size;
    }

    public void update() {
       pos.x += speed * dir.x;
       pos.y += speed * dir.y;
    }

    static boolean posInBounds(Position pos, Bounds bounds) {
        if(
            pos.x <= bounds.right && pos.x >= bounds.left &&
            pos.y >= bounds.bottom && pos.y <= bounds.top 
        ) return true;
        else return false;
    }

    public boolean withinBounds(Bounds bounds) {
        // System.out.println("t: " + this.getBounds().top);
        // System.out.println("b: " + this.getBounds().bottom);
        // System.out.println("l: " + this.getBounds().left);
        // System.out.println("r: " + this.getBounds().right);
        if (
        posInBounds(new Position(this.getBounds().left, this.getBounds().top), bounds) ||
        posInBounds(new Position(this.getBounds().right, this.getBounds().top), bounds) ||
        posInBounds(new Position(this.getBounds().left, this.getBounds().bottom), bounds) ||
        posInBounds(new Position(this.getBounds().right, this.getBounds().bottom), bounds) ) {
        return true;
        } else return false;
    }
    
    public void draw(PApplet sketch) {
        sketch.pushMatrix();
        sketch.ellipse(pos.x, pos.y, size.width, size.height);
        sketch.popMatrix();
    }

    public void flip() {
        this.dir.flip();
    }
}
