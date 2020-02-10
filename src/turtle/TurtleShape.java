package turtle;

public abstract class TurtleShape implements Cloneable
{  public void draw()
   {  Frame.addShape(this);
   }

   abstract void redraw(java.awt.Graphics g, TurtleGraphicsCoord coord);
        
   public Object clone()
   {  try
      { return super.clone(); }
      catch(CloneNotSupportedException e)
      { return null; }
   }
}
