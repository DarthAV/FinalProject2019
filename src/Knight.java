import java.awt.Point;
import java.util.ArrayList;

public class Knight extends Piece {
	private Point location;
	private boolean isWhite;
	private char displayChar;
	
	public Knight(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		if(isWhite) {
			this.displayChar = 'K';
		} else {
			this.displayChar = 'k';
		}
	}

	public char getChar() { return displayChar; }
	public boolean getColor() { return isWhite; } //returns true if it is white

	@Override
	public void move() {
		
	}

	@Override
	public ArrayList<Point> getValidMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
