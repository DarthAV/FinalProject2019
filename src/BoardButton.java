import javax.swing.*;

public class BoardButton extends JButton {
	public int x;
	public int y;
	
	public BoardButton(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return this.x; }
	public int getY() { return this.y; }
}
