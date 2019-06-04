import java.awt.Point;
import java.util.ArrayList;

public class Pawn implements Piece {

    private boolean isWhite;
    private boolean hasMoved;

    public Pawn(boolean isWhite, boolean hasMoved) { this.isWhite = isWhite; this.hasMoved = hasMoved; }
    public Pawn(boolean isWhite) { this(isWhite, false); }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        ArrayList<Point[]> gvm = this.getValidMoves(board);
        
        // same column check, UNLESS CAPTURE
        
        if (start.x != end.x && board[end.y][end.x] != null) {
        	return false;
        }
        
        // are they moving forward?
        if ((isWhite && (start.y - end.y) < 0) || (!isWhite && (end.y - start.y) < 0)) {
        	return false;
        }
        // check if piece in front
        if (board[end.y][end.x] != null) {
        	return false;
        }
        
        // first move adv
        if ((!hasMoved && Math.abs(start.y - end.y) == 2)) {
        	// check if piece in between
        	if (board[end.y+1][end.x] != null) {
        		return false;
        	}
        	hasMoved = true;
        	return true;
        }
        // normal case
    	if ((Math.abs(start.y - end.y) == 1)) {
    		hasMoved = true;
    		return true;
    	}
        return false;
    }

    public ArrayList<Point[]> getValidMoves(Piece[][] board){
        return new ArrayList<Point[]>();
    }

    public char getChar() { return isWhite ? 'P' : 'p'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Pawn clone() { return new Pawn(isWhite, hasMoved); }
}