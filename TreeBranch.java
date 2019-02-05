import java.awt.Point;
import java.util.ArrayList;

public class TreeBranch{
	ArrayList<TreeBranch> branches;
	Point start;
	Point end;
	double angle;
	double length;

	public TreeBranch(double length, double theta, ArrayList<TreeBranch> children){
		branches = children();
		start = new Point();
		end = new Point();
		this.length = length;
		setAngle(theta);
	}

	public void updateAngle(){
		angle = Math.acos(length / (end.x - start.x));
	}

	public double getAngle(){
		updateAngle();
		return angle;
	}

	public void setAngle(double theta){
		angle = theta;
		end.x = length * Math.cos(theta) + start.x;
		end.y = -1 * length * Math.cos(theta) + start.y;
	}

	public Point getStartPoint(){
		return start;
	}

	public Point getEndPoint(){
		return end;
	}
}