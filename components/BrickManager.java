package components;
import java.util.ArrayList;

public class BrickManager {
  private static BrickManager INSTANCE;
  private static ArrayList<Brick> bricks;
  
  private BrickManager() {
    bricks = new ArrayList<Brick>();  
  }

  public static ArrayList<Brick> getBricks() {
    return bricks;
  }

  // i dont remember why i made this a singleton
  public static BrickManager getInstance() {
    if ( INSTANCE == null )
      INSTANCE = new BrickManager();
    return INSTANCE;
  }

  public void add(Brick brick) {
    bricks.add(brick);
  }
}