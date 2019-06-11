import java.awt.Point;
import java.util.ArrayList;

public class Queen implements Piece {

    private boolean isWhite;

    public Queen(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        // check if piece capture is same color
    	if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) { return false; }
    	// bishop
    	if (Math.abs(start.x - end.x) == Math.abs(start.y - end.y)) {
    		int dx = start.x - end.x; // delta x
    		int dy = start.y - end.y; // delta y
    		
       		for (int qx=(dx>=0)?1:-1, qy=(dy>=0)?1:-1; ((dx>=0 && qx<dx) || (dx<=0 && qx>dx)); qx+=(dx>=0)?1:-1, qy+=(dy>=0)?1:-1) {
    			if (board[start.y - qy][start.x - qx] != null) {
    				return false;
    			}
    		}
    		
    	}
	    // else rook:
    	if ((start.x == end.x) != (start.y == end.y)) {
        	for (int i = start.x; i < end.x; i++) {
        		if (board[start.y][i] != null) { return false; }
        	}
        	for (int i = end.x; i < start.x; i++) {
        		if (board[start.y][i] != null) { return false; }
        	}
        	for (int i = start.y; i < end.y; i++) {
        		if (board[i][start.x] != null) { return false; }
        	}
        	for (int i = end.y; i < start.y; i++) {
        		if (board[i][start.x] != null) { return false; }
        	}
    	}
        return false;
    }

    public boolean[][] getValidMoves(Piece[][] board, Point pos){
        return new boolean[8][8];
    }

    public char getChar() { return isWhite ? 'Q' : 'q'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Queen clone() { return new Queen(isWhite); }
}