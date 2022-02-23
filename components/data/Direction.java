package components.data;

public class Direction {
    public int x, y;
    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void flip() {
        this.x *= -1;
        this.y *= -1;
    }
}
