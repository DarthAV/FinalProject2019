import java.awt.Point;
import java.util.ArrayList;

public class Knight implements Piece {

    private boolean isWhite;

    public Knight(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        
        // check if it is either one vertical and two horizontal or vice versa.
    	return (Math.abs(start.x - end.x) == 1 && Math.abs(start.y - end.y) == 3) || (Math.abs(start.x - end.x) == 3 && Math.abs(start.y - end.y) == 1);
    }

    public boolean[][] getValidMoves(Piece[][] board, Point pos){
    	boolean[][] r = new boolean[board.length][board[0].length];
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			r[i][j] = validateMove(board, pos, new Point(j, i));
    		}
    	}
    	return r;
    }

    public char getChar() { return isWhite ? 'N' : 'n'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Knight clone() { return new Knight(isWhite); }
    
}