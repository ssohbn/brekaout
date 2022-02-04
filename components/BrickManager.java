package components;
import java.util.ArrayList;
import java.util.Iterator; 

public class BrickManager {
  private static BrickManager INSTANCE;
  private static ArrayList<BasicBrick> bricks;
  
  private BrickManager() {
  bricks = new ArrayList<BasicBrick>();  
  }

  public static ArrayList<BasicBrick> getBricks() {
    return bricks;
  }

  public static BrickManager getInstance() {
    if ( INSTANCE == null )
      INSTANCE = new BrickManager();
    return INSTANCE;
  }

  public void add(BasicBrick brick) {
    bricks.add(brick);
  }

  public static Iterator<BasicBrick> getIterator() {
    return bricks.iterator();
  }
}