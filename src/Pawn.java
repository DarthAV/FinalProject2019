import java.awt.Point;
import java.util.ArrayList;

public class Pawn extends Piece {
	private Point location;
	private boolean isWhite;
	private boolean hasMoved;
	private char displayChar;
	
	public Pawn(Point location, boolean isWhite) {
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
	public void move(Point goTo) {
		this.hasMoved = true;
		if(getValidMoves().contains(goTo)) {
			
		}
	}

	@Override
	public ArrayList<Point> getValidMoves() {
		Piece[][] board = Board.getBoard();
		ArrayList<Point> spots = new ArrayList<Point>();
		if(this.hasMoved) {
			
		}
		if(this.isWhite) {
			if(board[location.x][location.y-1] instanceof Piece) {
				if(board[location.x][location.y].getColor()) {
						
				}
			}
		}
		return spots;

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
