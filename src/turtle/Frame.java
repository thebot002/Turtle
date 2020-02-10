package turtle;

import javax.swing.*;
import java.awt.*;

public abstract class Frame extends JFrame {

    private TurtlePoint cur, prev;
    private int angle = 0;
    private boolean initialized = false;
    private boolean pendown = true;

    private TurtleGraphicsCanvas graph;

    private static Frame theFrame;

    {theFrame = this;}

    public Frame() throws HeadlessException {
        setSize(400,400);
        setTitle("Turtle");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        init();
        setVisible(true);

        run();
    }

    private void add(Component c, GridBagLayout gbl,
                     GridBagConstraints gbc, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(c, gbc);
        add(c);
    }

    public void init() {
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 100;
        gbc.weighty = 100;
        gbc.fill = GridBagConstraints.BOTH;
        graph = new TurtleGraphicsCanvas();
        add(graph, gbl, gbc, 0, 0, 2, 1);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
//      label = new java.awt.Label();
//      add(label, gbl, gbc, 0, 1, 2, 1);
//      textbox = new java.awt.TextField();
//      add(textbox, gbl, gbc, 0, 2, 1, 1);
//      gbc.weightx = 0;
//      java.awt.Button enter = new java.awt.Button("Enter");
//      add(enter, gbl, gbc, 1, 2, 1, 1);
//      add(new java.awt.Label(), gbl, gbc, 0, 3, 1, 1);
        graph.setCoord(-10, 10, 10, -10);

    }

    public static void clearWindow() {
        TurtleGraphicsCanvas.shapes = new java.util.Vector();
        Dimension d = theFrame.graph.getSize();
        // CSH 1998-02-02 changed getSize to size for 1.0 compatibility
        Graphics g = theFrame.graph.getGraphics();
        g.setColor(theFrame.graph.getBackground());
        g.fillRect(0, 0, d.width, d.height);
        g.dispose();
        theFrame.repaint();
    }

    static void addShape(TurtleShape s) { theFrame.graph.addShape(s); }

    /**
     * Sets the coordinate system for drawing graphics
     * @param xleft the x coordinate of the left border
     * @param ytop the y coordinate of the top border
     * @param xright the x coordinate of the right border
     * @param ybottom the y coordinate of the bottom border
     */

    public void setCoord(double xleft, double ytop, double xright, double ybottom)
    {  graph.setCoord(xleft, ytop, xright, ybottom);
    }


    public void newPaper() {
        setCoord(0,0,10000,10000);
        clearWindow();
        cur = new TurtlePoint(5000,5000);
        prev = new TurtlePoint(5000,5000);
        angle = 0;
        initialized = true;
    }

    public void penUp() { pendown=false; }

    public void penDown() { pendown=true; }

    public void advance(int step) {
        if (!initialized) return;
        cur.move(Math.cos((angle/360.0) * 2*Math.PI)*step, Math.sin((angle/360.0) * 2*Math.PI)*step);
        if (pendown) {
            TurtleLine l = new TurtleLine(prev,cur);
            l.draw();
        }
        prev = (TurtlePoint)(cur.clone());
    }

    public void turn(int an) { angle = (angle+an) % 360; }

    public abstract void run();
}
