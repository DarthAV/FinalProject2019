import java.awt.Point;

// STATUS: COMPLETE

public class Pawn extends Piece {

    private boolean isWhite;
    public boolean hasMoved;

    public Pawn(boolean isWhite, boolean hasMoved) { this.isWhite = isWhite; this.hasMoved = hasMoved; }
    public Pawn(boolean isWhite) { this(isWhite, false); }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        
    	if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) { return false; }
        // same column check, UNLESS CAPTURE, then check adjacent
        if (start.x != end.x && board[end.y][end.x] == null) { return false; } 
        if (start.x != end.x && (Math.abs(start.x - end.x) != 1 || Math.abs(start.y - end.y) != 1)) { return false; }
        
        // are they moving forward?
        if ((isWhite && (start.y - end.y) < 0) || (!isWhite && (end.y - start.y) < 0)) {
        	return false;
        }
        try {
            // check if piece in front
            if ((isWhite && start.x == end.x && board[start.y-1][start.x] != null) || (!isWhite && start.x == end.x && board[start.y+1][start.x] != null)) {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        
        
        // first move adv
        if ((!hasMoved && Math.abs(start.y - end.y) == 2)) {
        	// check if piece in between
        	if ((isWhite && board[start.y-2][start.x] != null) || (!isWhite && board[start.y+2][start.x] != null)) {
        		return false;
        	}
        	return true;
        }
        // normal case
    	if ((Math.abs(start.y - end.y) == 1)) {
    		return true;
    	}
        return false;
    }

    public char getChar() { return isWhite ? 'P' : 'p'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Pawn clone() { return new Pawn(isWhite, hasMoved); }
    
    public boolean eligibleForPromotion(Piece[][] board, Point pos) {
    	return pos.y == 0 || pos.y == board.length - 1;
    }
}





