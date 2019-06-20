import java.awt.Point;
import java.util.ArrayList;

public class Bishop extends Piece {

    private boolean isWhite;

    public Bishop(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x >= board[0].length) { return false; }
        if (end.x < 0 || end.x >= board.length) { return false; }
        // check if piece capture is same color
    	if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) { return false; }
    	if (Math.abs(start.x - end.x) != Math.abs(start.y - end.y)) { return false; }
    	// check
		int dx = end.x - start.x; // delta x
		int dy = start.y - end.y; // delta y
		boolean hit = false;
    	for (int i = start.x-1, j = start.y-1; (i >= end.x || j >= end.y); i--, j--) {
    		if (i < 0 || i >= board[0].length) { break; }
            if (j < 0 || j >= board.length) { break; }
    		if (hit) { System.out.println(0); return false; }
    		if (board[j][i] != null && board[j][i].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[j][i] != null && board[j][i].isWhite() == this.isWhite) { System.out.println(10); break; }
    	}
    	hit = false;
    	for (int i = start.x-1, j = start.y+1; (i >= end.x || j <= end.y); i--, j++) {
    		if (i < 0 || i >= board[0].length) { break; }
            if (j < 0 || j >= board.length) { break; }
    		if (hit) { System.out.println(1); return false; }
    		if (board[j][i] != null && board[j][i].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[j][i] != null && board[j][i].isWhite() == this.isWhite) { System.out.println(20); break; }
    	}
    	hit = false;
    	for (int i = start.x+1, j = start.y-1; (i <= end.x || j >= end.y) ; i++, j--) {
    		if (i < 0 || i >= board[0].length) { break; }
            if (j < 0 || j >= board.length) { break; }
    		if (hit) { System.out.println(2); return false; }
    		if (board[j][i] != null && board[j][i].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[j][i] != null && board[j][i].isWhite() == this.isWhite) { System.out.println(30); return false; }
    	}
    	hit = false;
    	for (int i = start.x+1, j = start.y+1; (i <= end.x || j <= end.y); i++, j++) {
    		if (i < 0 || i >= board[0].length) { break; }
    		if (j < 0 || j >= board.length) { break; }
    		if (hit) { System.out.println(3); return false; }
    		if (board[j][i] != null && board[j][i].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[j][i] != null && board[j][i].isWhite() == this.isWhite) { System.out.println(40); break; }
    	}
    		
    		
//       		for (int qx=(dx>=0)?1:-1, qy=(dy>=0)?1:-1; ((dx>=0 && qx<dx) || (dx<=0 && qx>dx)); qx+=(dx>=0)?1:-1, qy+=(dy>=0)?1:-1) {
//    			if (board[start.y - qy][start.x - qx] != null) {
//    				return false;
//    			}
//    		}
    		
        return true;
    }

    public char getChar() { return isWhite ? 'B' : 'b'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Bishop clone() { return new Bishop(isWhite); }
    
}