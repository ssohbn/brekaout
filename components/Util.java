package components;

public class Util {
    public static boolean posInBounds(Position pos, Bounds bounds) {
        if(
            pos.x <= bounds.right && pos.x >= bounds.left &&
            pos.y <= bounds.bottom && pos.y >= bounds.top 
        ) return true;
        else return false;
    }
    
}
