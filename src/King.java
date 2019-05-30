
public class King extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private char displayChar;
	private boolean canCastle;
	
	public King(Coordinate location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		this.canCastle = true;
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

}
