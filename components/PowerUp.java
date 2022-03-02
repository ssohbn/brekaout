package components;

import components.data.Bounds;
import components.data.Position;
import components.data.Size;
import components.data.interfaces.Collide;
import components.data.interfaces.Draw;
import components.data.interfaces.Move;
import processing.core.PApplet;

public class PowerUp implements Collide, Draw, Move {
    public Position pos;
    public final Size SIZE;  
    public final int SPEED = 10;

    public PowerUp(int x, int y, int width, int height) {
        this.pos = new Position(x, y);
        this.SIZE = new Size(width, height);
    }

    public Bounds getBounds() {
        return new Bounds(pos.x, pos.x+SIZE.width, pos.y, pos.y+SIZE.height);
    }

    public void update() {
        this.pos.y += SPEED;
    }

    public void draw(PApplet sketch) {
        sketch.pushMatrix();
        sketch.rect(pos.x, pos.y, SIZE.width, SIZE.height);
        sketch.popMatrix();
    }

}
