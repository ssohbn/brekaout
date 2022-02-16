package components;

import processing.core.PApplet;

public class Ball extends CollidingObject {

    private static Ball INSTANCE;
    Direction dir = new Direction(1, -1);
    static int speed = 10;
    static Position pos;
    static Size size;

    private Ball(int x, int y, int width, int height) {
        super(x, y, width, height); 
        Ball.pos = super.position;
        Ball.size = super.size;
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
        dir.flip();
    }

}
