
package turtle;

public class TurtlePoint extends TurtleShape
{  /**
    * Creates a point object
    * @param xx the x coordinate
    * @param yy the y coordinate
    */
  
   public TurtlePoint(double xx, double yy)
   {  x = xx;
      y = yy;
   }

   /**
    * Default constructor
    */
  
   public TurtlePoint() /* CSH 1998-02-28 */
   {  x = 0;
      y = 0;
   }

   /**
    * Gets the x coordinate of this point
    * @return the x coordinate of this point
    */

   public double getX()
   {  return x;
   }

   /**
    * Gets the y coordinate of this point
    * @return the y coordinate of this point
    */

   public double getY()
   {  return y;
   }

   /**
    * Moves this graphical shape
    * @param dx the amount to move by in x direction
    * @param dy the amount to move by in y direction
    */

   public void move(double dx, double dy)
   {  x += dx;
      y += dy;
   }

   void redraw(java.awt.Graphics g, TurtleGraphicsCoord coord)
   {  g.fillOval(coord.xToPixelPos(x) - 2,
      coord.yToPixelPos(y) - 2, 5, 5);
   }

   /**
    * Tests if this object equals another
    * @param b the object to compare with
    * @return <tt>true</tt> if the two objects are equal
    */

   public boolean equals(Object b)
   {  if (b instanceof TurtlePoint)
      {  TurtlePoint pb = (TurtlePoint)b;
         return x == pb.x && y == pb.y;
      }
      else return false;
   }
        
   /**
    * Creates a string representation of this object
    * @return a string representation of this object
    */

   public String toString()
   {  return "Point[x=" + x + ",y=" + y + "]";
   }
        
   /**
    * Computes a hash code for this object
    * @return a hash code for this object
    */

   public int hashCode()
   {  return (int)(7 * x + 11 * y);
   }

   private double x;
   private double y;
}

