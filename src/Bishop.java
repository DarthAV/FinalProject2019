
public class Bishop extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private char displayChar;
	
	public Bishop(Coordinate location, boolean isWhite) {
		// TODO Auto-generated constructor stub
		this.location = location;
		this.isWhite = isWhite;
		if(isWhite) {
			this.displayChar = 'B';
		} else {
			this.displayChar = 'b';
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
