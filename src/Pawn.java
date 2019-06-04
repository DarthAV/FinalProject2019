

public class Pawn implements Piece {

    private boolean isWhite;

    public Pawn(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove() {
        return false;
    }

    public int[][] getValidMoves(Board board){
        return new int[8][8];

    }

    public char getChar() { return isWhite ? 'P' : 'p'; }
    
    public boolean isWhite() { return isWhite; }
}
/*
>master<
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
*/

