package components;

import processing.core.PApplet;

public class Ball extends CollidingObject {
    
    private Ball(int x, int y, int width, int height) {
        super(x, y, width, height); 
    }

    public Ball getInstance() {
    }

    @Override
    public void draw(PApplet sketch) {
        // TODO Auto-generated method stub
        sketch.pushMatrix();
        sketch.ellipse(50, 50, 50, 50);
        sketch.popMatrix();
    }
    
}
