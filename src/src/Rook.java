import java.awt.Point;
import java.util.ArrayList;

public class Rook extends Piece {
	private Point location;
	private boolean isWhite;
	private char displayChar;
	private boolean hasMoved; //for castling logic
	
	public Rook(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		this.hasMoved = false;
		if(isWhite) {
			this.displayChar = 'R';
		} else {
			this.displayChar = 'r';
		}
	}

	public char getChar() { return displayChar; }
	public boolean getColor() { return isWhite; } //returns true if it is white
	public Point getLocation() { return location; }

	@Override
	public void move() {
		
	}

	@Override
	public ArrayList<Point> getValidMoves() {
		return null;
	}
	
	
	
}
