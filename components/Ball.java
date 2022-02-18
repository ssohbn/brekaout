package components;

import processing.core.PApplet;

public class Ball extends CollidingObject {

    private static Ball INSTANCE;
    Direction dir = new Direction(1, -1);
    int speed = 10;
    Position pos;
    Size size;

    private Ball(int x, int y, int width, int height) {
        super(x, y, width, height); 
        this.pos = new Position(x, y);
        this.size = new Size(width, height);
    }

    public void update(PApplet sketch) {
        position = new Position(position.x + (speed*dir.x), position.y + (speed*dir.y));
    }

    public static Ball getInstance() {
        if ( INSTANCE == null )
        INSTANCE = new Ball(300, 300, 50, 50);
        return INSTANCE;
    }

    public void update() {
       position.x += speed * dir.x;
       position.y += speed * dir.y;
    }

    
    @Override
    public void draw(PApplet sketch) {
        sketch.pushMatrix();
        sketch.ellipse(position.x, position.y, size.width, size.height);
        sketch.popMatrix();
    }

    public void flip() {
        this.dir.flip();
    }
}
