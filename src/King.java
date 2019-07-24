import java.awt.Point;

public class King extends Piece {

    boolean isWhite;
    public boolean hasBeenChecked;
	public boolean hasMoved;
	public Point location;

    public King(boolean isWhite, boolean hasMoved, boolean hasBeenChecked) { this.isWhite = isWhite; this.hasMoved = hasMoved; this.hasBeenChecked = hasBeenChecked; }
    public King(boolean isWhite) { this(isWhite, false, false); }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	
    	
    	// check if capturing same color
        if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) {
        	return false;
		}
		
    	// check if castle
    	if (validateCastle(board, start, end) && Math.abs(start.x - end.x) == 2) { 
    		return true;
		}
		// check if moving in valid direction
        if (Math.abs(start.x - end.x) != 1 && Math.abs(start.y - end.y) != 1) {
        	return false;
        }
        // board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        
        // check if more than one square away from king
        if(Math.abs(end.x - start.x) > 1 || Math.abs(end.y - start.y) > 1) { return false; }
        return true; 
    }

    public char getChar() { return isWhite ? 'K' : 'k'; }

    public boolean isWhite() { return isWhite; }
    
    public King clone() { return new King(isWhite, hasMoved, hasBeenChecked); }
    
    public boolean validateCastle(Piece[][] board, Point start, Point end) {
		Point pos = new Point((end.x - start.x) > 0 ? start.x + 1 : start.x - 1, start.y);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] != null && board[i][j].isWhite() != this.isWhite && !(board[i][j] instanceof King)) {
					if(board[i][j].getValidMoves(board, new Point(j, i))[pos.y][pos.x]) {
						return false;
					}
				}
			}
		}
    	return board[start.y][start.x] instanceof King 
			&& !hasMoved
			&& !hasBeenChecked
			&& (end.x == 6 || end.x == 2) 
			&& (end.y == start.y) && (start.x == 4)  
			&& (board[start.y][(end.x - start.x) > 0 ? 7 : 0] instanceof Rook) 
			&& !(((Rook) board[start.y][(end.x - start.x) > 0 ? 7 : 0]).hasMoved())
			&& ((Rook) board[start.y][(end.x - start.x) > 0 ? 7 : 0]).validateMove(board, new Point(start.y, (end.x - start.x) > 0 ? 7 : 0), new Point(start.y, start.x+(end.x - start.x) > 0 ? 1 : -1))
			&& true;//isInCheck(board, new Point((end.x - start.x) > 0 ? start.x + 1 : start.x - 1, start.y));
		}

    public boolean isInCheck(Piece[][] board, Point pos) {
    	if (pos.x < 0 || pos.x > board.length || pos.y < 0 || pos.y > board.length) {
    		return true;
    	}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] != null && board[i][j].isWhite() != this.isWhite) {
					if(board[i][j].getValidMoves(board, new Point(j, i))[pos.y][pos.x]) {
						return true;
					}
				}
			}
		}

    	return false;
    }

}