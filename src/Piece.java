import java.awt.Point;
import java.util.ArrayList;

// we can always change to abstract class later

public abstract class Piece {
    public abstract boolean validateMove(Piece[][] board, Point start, Point end);
    public boolean[][] getValidMoves(Piece[][] board, Point pos){
    	boolean[][] r = new boolean[board.length][board[0].length];
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			r[i][j] = validateMove(board, pos, new Point(j, i));
    		}
    	}
    	return r;
    }
    public abstract char getChar();
    public abstract boolean isWhite();
    public abstract Piece clone();
}