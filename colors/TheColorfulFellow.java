package colors;

public class TheColorfulFellow {
  private static TheColorfulFellow INSTANCE = null;
  private ArrayList<Colory> colorz;
  private TheColorfulFellow() {
    /**
     *this fellow is very
     * colorful and will
     * manage all of the colors for us!!
     * thank the colorful man
    */

  }

  public static TheColorfulFellow getInstance() {
    if ( INSTANCE != null )
      INSTANCE = new TheColorfulFellow();
    return INSTANCE;
  }

  public void registerColor() {
    /**
      * check file for color or something idk 
      * i had an idea and then forgort
      */
  }
}