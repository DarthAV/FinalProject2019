import java.awt.Point;
import java.util.ArrayList;

public class Bishop extends Piece {

    private boolean isWhite;

    public Bishop(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        // check if piece capture is same color
    	if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) { return false; }
    	// check
    	if (Math.abs(start.x - end.x) == Math.abs(start.y - end.y)) {
    		int dx = start.x - end.x; // delta x
    		int dy = start.y - end.y; // delta y
    		
       		for (int qx=(dx>=0)?1:-1, qy=(dy>=0)?1:-1; ((dx>=0 && qx<dx) || (dx<=0 && qx>dx)); qx+=(dx>=0)?1:-1, qy+=(dy>=0)?1:-1) {
    			if (board[start.y - qy][start.x - qx] != null) {
    				return false;
    			}
    		}
    		
    	}
        return true;
    }

    public char getChar() { return isWhite ? 'B' : 'b'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Bishop clone() { return new Bishop(isWhite); }
    
}