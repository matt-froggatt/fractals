import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class TreeBranch {
	private ArrayList < TreeBranch > branches;
	private Point start;
	private Point end;
	private double angle;
	private double length;

	public TreeBranch(Point startPoint, double length, double theta, ArrayList < TreeBranch > children) {
		branches = children;
		start = startPoint;
		//calc based on angle
		end = new Point();
		this.length = length;
		setAngle(theta);
		end.setLocation(length * Math.cos(theta) + start.getX(), -1 * length * Math.cos(theta) + start.getY());
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double theta) {
		angle = theta;
		end.setLocation(length * Math.cos(theta) + start.getX(), -1 * length * Math.cos(theta) + start.getY());
	}

	public Point getStartPoint() {
		return start;
	}

	public Point getEndPoint() {
		return end;
	}

	public void drawBranch(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(start.x, start.y, end.x, end.y);
//		System.out.printf("Start: %d, %d\nEnd: %d, %d\n", start.x, start.y, end.x, end.y);
		if (branches != null) {
			for (int i = 0; i < branches.size(); i++) {
				branches.get(i).drawBranch(g);
			}
		}
	}

	public double getLength() {
		return length;
	}

	public ArrayList < TreeBranch > getRestTree() {
		return branches;
	}
}