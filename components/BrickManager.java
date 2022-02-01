package components;
import java.util.ArrayList;
import java.util.Iterator; 

public class BrickManager {
  private static BrickManager INSTANCE;
  private static ArrayList<BasicBrick> bricks;
  
  private BrickManager() {
  this.bricks = new ArrayList<BasicBrick>();  
  }

  public static BrickManager getInstance() {
    if ( INSTANCE == null )
      INSTANCE = new BrickManager();
    return INSTANCE;
  }

  public void add(BasicBrick brick) {
    this.bricks.add(brick);
  }

  public static Iterator getIterator() {
    return bricks.iterator();
  }
}