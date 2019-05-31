import java.util.ArrayList;

public class Pawn extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private boolean hasMoved;
	private char displayChar;
	
	public Pawn(Coordinate location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		if(isWhite) {
			this.displayChar = 'P';
		} else {
			this.displayChar = 'p';
		}
	}
	
	public char getChar() { return displayChar; }
	public boolean getColor() { return isWhite; } //returns true if it is white

	@Override
	public void move() {
		this.hasMoved = true;
	}

	@Override
	public ArrayList<Coordinate> getValidMoves() {
		ArrayList<Coordinate> spots = new ArrayList<Coordinate>();
		if(this.hasMoved) {
			
		}
		return spots;

	}
	
}
