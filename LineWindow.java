import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Line2D;

import javax.swing.JFrame;

public class LineWindow extends JFrame {
    // Gets the size of the screen so that it can centre itself
    private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private LineCanvas canvas;

    // Constructor that sets size based on given Dimension, place itself in the middle of the screen, sets
    // its default close to exit, and then makes itself invisible to be made visible later.
    public LineWindow(Dimension d) {
        canvas = new LineCanvas();
        setPreferredSize(d);
        setLocation(new Point((SCREEN_SIZE.width - d.width) / 2, (SCREEN_SIZE.height - d.height) / 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(canvas);
        this.pack();

        setVisible(false);
    }

	public void setTree(TreeBranch branch){
		canvas.setTree(branch);
	}

    public void drawLineAngle(Point pos, double length, double theta) {
        canvas.drawLineAngle(pos, length, theta);
    }
}