
package turtle;

public class TurtleLine extends TurtleShape {

   public TurtleLine(TurtlePoint s, TurtlePoint e)
   {  start = (TurtlePoint)s.clone();
      end = (TurtlePoint)e.clone();
   }

   /**
    * Default constructor
    */

   public TurtleLine() 
   {  start = new TurtlePoint();
      end = new TurtlePoint();
   }

   /**
    * Moves this graphical shape
    * @param dx the amount to move by in x direction
    * @param dy the amount to move by in y direction
    */

   public void move(double x, double y)
   {  start.move(x, y);
      end.move(x, y);
   }

   /**
    * Creates a copy of this object
    * @return a copy of this object
    */

   public Object clone()
   {  TurtleLine r = (TurtleLine)super.clone();
      r.start = (TurtlePoint)start.clone();
      r.end = (TurtlePoint)end.clone();
      return r;
   }

   void redraw(java.awt.Graphics g, TurtleGraphicsCoord coord)
   {  g.drawLine(coord.xToPixelPos(start.getX()), coord.yToPixelPos(start.getY()), 
         coord.xToPixelPos(end.getX()), coord.yToPixelPos(end.getY()));
   }
    
   /**
    * Creates a string representation of this object
    * @return a string representation of this object
    */

   public String toString()
   {  return "TurtleLine[start = " + start.toString() + "," + "end = " + end.toString() + "]";
   }

   /**
    * Tests if this object equals another
    * @param b the object to compare with
    * @return <tt>true</tt> if the two objects are equal
    */

   public boolean equals(Object b)
   {  if (b instanceof TurtleLine)
      {   TurtleLine pb = (TurtleLine)b;
          return start.equals(pb.start) && end.equals(pb.end);
      }
      else return false;
   }

   /**
    * Computes a has code for this object
    * @return a hash code for this object
    */

   public int hashCode()
   {  return 13 * start.hashCode() + 17 * end.hashCode();
   }

   /**
    * Gets the starting point of the line
    * @return the starting point of the line
    */

   public TurtlePoint getStart()
   {  return (TurtlePoint)start.clone();
   }

   /**
    * Gets the ending point of the line
    * @return the ending point of the line
    */

   public TurtlePoint getEnd()
   {  return (TurtlePoint)end.clone();
   }

   private TurtlePoint start;
   private TurtlePoint end;
}


