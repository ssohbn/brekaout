package components;
import java.util.ArrayList;
import java.util.Random;

public class BrickManager {
   private static BrickManager INSTANCE;
  private ArrayList<Brick> bricks;
  private int level = 0;

 public int getLevel() {
    return this.level;
  }
  
  private BrickManager() {
    bricks = new ArrayList<Brick>();  
  }

  public ArrayList<Brick> getBricks() {
    if (this.bricks.isEmpty()) {
      this.level+=1;
      genLevel();
    }

    return this.bricks;
  }

  public static void genLevel() {
    Random random = new Random();
    for ( int y=0; y<3; y++) {
      for ( int x=0; x<9; x++) {
        if (random.nextInt(2) == 1) {
          BrickManager.getInstance().add(new Brick(x*80, y*40, 60, 30));
        }
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