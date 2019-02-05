import javax.swing.JFrame;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

public class FractalsMain{

	// Recursively calls itself to draw the tree.
	public static void drawTreeRecurse(LineWindow window, Point pos, int length, double theta){
		if(length >= 1){
			window.drawLineAngle(pos, length, theta);

			// Hacky fix to avoid memory overloads and to avoid weird positioning, so that new Point objects don't need
			// to be created. I'll fix it later when I add custom line classes and such.
			float x = (float) (Math.cos(theta) * length) + pos.x;
			float y = (float) (-1 * Math.sin(theta) * length) + pos.y;

			// Part of hacky fix, just sets the position of pos so that the same Point object can be used
			// and then calls recursively to this method with new parameters.
			pos.setLocation(x, y);
			drawTreeRecurse(window, pos, length / 2, theta + (Math.PI / 4));
			
			// Same as above. Positioning reset was required to avoid weird positioning issue caused by using the same
			// Point object, since the previous positioning carries back through recursion.
			pos.setLocation(x, y);			
			drawTreeRecurse(window, pos, length / 2, theta - (Math.PI / 4));

			// Repaints the window to make sure the tree shows up.
			window.repaint();
		}
	}

	// Small wrapper method for the recursive method just to make it easier to call. Most of the parameters in here shouldn't
	// be changed anyways, but I should create constants for them or something. Need to take in window so I can pass it from
	// the main method and draw new lines in the recursive method.
	public static void drawTree (LineWindow window){
		drawTreeRecurse(window, new Point(window.getWidth() / 2, window.getHeight()), window.getHeight() / 2, Math.PI / 2);
	}

	public static void main(String[] args) {
		//Sets up window for display
		final Dimension SIZE = new Dimension(1280, 720);
		LineWindow window = new LineWindow(SIZE);
		window.setVisible(true);

		//Calls to drawTree() to let the recursive fun begin! 
		drawTree(window);
	}
}