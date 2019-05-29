
public class Rook extends Piece {
	private Coordinate location;
	private boolean isWhite;
	private char displayChar;
	
	public Rook(Coordinate location, boolean isWhite) {
		// TODO Auto-generated constructor stub
		this.location = location;
		this.isWhite = isWhite;
		if(isWhite) {
			this.displayChar = 'R';
		} else {
			this.displayChar = 'r';
		}
	}

	public char getChar() { return displayChar; }
	public boolean getColor() { return isWhite; } //returns true if it is white

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}


}
