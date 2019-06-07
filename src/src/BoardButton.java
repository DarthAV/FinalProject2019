import javax.swing.JButton;

public class BoardButton extends JButton {
	public int xLocation;
	public int yLocation;
	
	public BoardButton(int xLocation, int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	public int getXLocation() { return this.xLocation; }
	public int getYLocation() { return this.yLocation; }
}
