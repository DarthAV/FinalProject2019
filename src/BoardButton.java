import java.awt.Point;
import javax.swing.JButton;

public class BoardButton extends JButton {
	private Point location;
	
	public BoardButton(Point location) {
		this.location = location;
	}
	
	public Point getLocation() { return this.location; }
}
