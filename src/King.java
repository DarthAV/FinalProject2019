
public class King extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private char displayChar;
	
	public King(Coordinate location, boolean isWhite) {
		// TODO Auto-generated constructor stub
		this.location = location;
		this.isWhite = isWhite;
		if(isWhite) {
			this.displayChar = 'K';
		} else {
			this.displayChar = 'k';
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	public char getChar() {
		return displayChar;
	}
}
