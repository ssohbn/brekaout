package components;

public class Bounds {
    public int left, right, top, bottom;
    public Bounds(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public void display() {
        System.out.println("left: " + this.left);
        System.out.println("right: " + this.right);
        System.out.println("top: " + this.top);
        System.out.println("bottom: " + this.bottom);
    }
    
}
