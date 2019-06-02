import java.awt.Point;
import java.util.ArrayList;

public abstract class Piece {
	private char name;
	private Point spot;
	
	public abstract void move();
	public abstract char getChar();
	public abstract boolean getColor();
	public abstract ArrayList<Point> getValidMoves();
	public void move(Point goTo) {
		
	}
	
	
	
}