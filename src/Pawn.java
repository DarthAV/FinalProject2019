
public class Pawn extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private char displayChar;
	
	public Pawn(Coordinate location, boolean isWhite) {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
	}
	
}
