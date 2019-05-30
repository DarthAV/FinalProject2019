
public class Queen extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private char displayChar;
	
	public Queen(Coordinate location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		if(isWhite) {
			this.displayChar = 'Q';
		} else {
			this.displayChar = 'q';
		}
	}

	public char getChar() { return displayChar; }
	public boolean getColor() { return isWhite; } //returns true if it is white

	@Override
	public void move() {
		
	}

}
