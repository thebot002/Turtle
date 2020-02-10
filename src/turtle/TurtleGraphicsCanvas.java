package turtle;

public class TurtleGraphicsCanvas extends java.awt.Canvas {
    TurtleGraphicsCoord coord;
    static java.util.Vector shapes;

    public TurtleGraphicsCanvas() {
        shapes = new java.util.Vector();
        coord = new TurtleGraphicsCoord();
    }

    public void paint(java.awt.Graphics g) {
        for (int i = 0; i < shapes.size(); i++)
            ((TurtleShape)shapes.elementAt(i)).redraw(g, coord);
    }

    public void setBounds(int x, int y, int w, int h)
    {  int s = Math.min(w, h);
        x += (w - s) / 2;
        y += (h - s) / 2;
        super.setBounds(x, y, s, s);
        coord.setPixel(getSize().width, getSize().height);
    }

    public void setCoord(double xleft, double ytop, double xright, double ybottom)
    {  coord.setCoord(xleft, ytop, xright, ybottom);
    }


    TurtlePoint getPointFromPixelPosition(int x, int y)
    {  return new TurtlePoint(coord.xFromPixelPos(x),
            coord.yFromPixelPos(y));
    }


    void addShape(TurtleShape s)
    {  shapes.addElement(s.clone());
        s.redraw(getGraphics(), coord);
    }
}