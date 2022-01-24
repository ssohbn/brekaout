package interfaces;
import components.CollidingObject;

public abstract interface ICollidable {
  // i need to learn how to 
  // use this properly instead
  // of just bloating my
  // project
  public boolean isColliding(CollidingObject collidable);
  public void onCollide(CollidingObject collidable);
  // wow this is really useless so far i might delete it
}