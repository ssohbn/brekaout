package components.data;

import processing.core.PApplet;

public class Collisions {
    public static boolean posInBounds(Position pos, Bounds bounds) {
        if(
            pos.x <= bounds.right && pos.x >= bounds.left &&
            pos.y <= bounds.bottom && pos.y >= bounds.top 
        ) return true;
        else return false;
    }

    public static boolean outOfBoundsX(Bounds pBounds, PApplet sketch) {
        if ( pBounds.left < 0  || pBounds.right > sketch.width )  {
            return true;
        }
        return false;
    }

    public static boolean outOfBoundsY(Bounds pBounds, PApplet sketch) {
        if ( pBounds.top < 0 || pBounds.bottom < 0 || pBounds.top > sketch.height || pBounds.bottom > sketch.height ) {
            return true;
        }
        return false;
    }

    public static boolean belowScreenHeight(Bounds pBounds, PApplet sketch) {
        if (pBounds.bottom > sketch.height) {
            return true;
        }
        return false;
    }
}