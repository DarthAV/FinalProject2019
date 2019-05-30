public abstract class Piece {
	private char name;
	private Coordinate spot;
	
	public abstract void move();
	public abstract char getChar();
	public abstract Coordinate[] getValidMoves();
	
	
	
}
