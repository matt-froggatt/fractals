import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;

public class LineWindow extends JFrame {

	// Have to research later, put it in temporarily to avoid warning
	private static final long serialVersionUID = 1L;

	// Gets the size of the screen so that it can centre itself
	private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	// Creates the lines array list to be filled with lines later
	private ArrayList<Line2D> lines = new ArrayList<Line2D>();

	// Constructor that sets size based on given Dimension, place itself in the middle of the screen, sets
	// its default close to exit, and then makes itself invisible to be made visible later.
	public LineWindow(Dimension d) {
		setSize(d);
		setLocation(new Point((SCREEN_SIZE.width - d.width) / 2, (SCREEN_SIZE.height - d.height) / 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(false);
	}

	// Just runs super pain method and then runs foreach loop on the lines array list to draw every line
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < lines.size(); i++) {
			g2.draw(lines.get(i));
		}
	}

	// Takes in a position, a length, and an angle in radians, and adds a line to the ArrayList lines to be drawn.
	// Will change later to custom line object to make my code prettier, and more extensible.
	public void drawLineAngle(Point pos, double length, double theta) {
		float x = (float) (Math.cos(theta) * length);
		float y = (float) (-1 * Math.sin(theta) * length);

		lines.add(new Line2D.Float(pos.x, pos.y, (pos.x + x), (pos.y + y)));

		//return new Point(x, y);
	}
}