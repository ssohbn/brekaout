package components;
import java.util.ArrayList;
import java.util.Iterator; 

public class BrickManager {
  private static BrickManager INSTANCE;
  private static ArrayList<Brick> bricks;
  
  private BrickManager() {
  bricks = new ArrayList<Brick>();  
  }

  public static ArrayList<Brick> getBricks() {
    return bricks;
  }

  public static BrickManager getInstance() {
    if ( INSTANCE == null )
      INSTANCE = new BrickManager();
    return INSTANCE;
  }

  public void add(Brick brick) {
    bricks.add(brick);
  }

  public static Iterator<Brick> getIterator() {
    return bricks.iterator();
  }
}