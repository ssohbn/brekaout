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

  public static void genLevel() {
    for ( int y=0; y<3; y++) {
      for ( int x=0; x<9; x++) {
        //brick automatically adds itself to the brickmanager
        new Brick(x*80, y*40, 60, 30);
      }
    }
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