import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;



public class LineCanvas extends JPanel {

	// Creates the lines array list to be filled with lines later
	private ArrayList<Line2D> lines = new ArrayList<Line2D>();
	private TreeBranch tree;

	// Just runs super pain method and then runs foreach loop on the lines array list to draw every line
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < lines.size(); i++) {
			g2.draw(lines.get(i));
		}
		if(tree != null){
			tree.drawBranch(g);
		}
	}

	// Takes in a position, a length, and an angle in radians, and adds a line to the ArrayList lines to be drawn.
	public void drawLineAngle(Point pos, double length, double theta) {
		float x = (float) (Math.cos(theta) * length);
		float y = (float) (-1 * Math.sin(theta) * length);

		lines.add(new Line2D.Float(pos.x, pos.y, (pos.x + x), (pos.y + y)));

		//return new Point(x, y);
	}

	public void setTree(TreeBranch branch){
		tree = branch;
	}
}