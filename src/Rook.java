import java.awt.Point;
import java.util.ArrayList;

public class Rook extends Piece {

    private boolean isWhite;
    private boolean hasMoved;

    public Rook(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        // check if piece capture is same color
    	if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) { return false; }
    	// check
    	
    	for (int i = end.x; i < start.x; i++) {
    		if (board[i][start.x] != null) { return false; }
    	}
    	
    	for (int i = end.y; i < start.y; i++) {
    		if (board[start.y][i] != null) { return false; }
    	}
    	
    	
    	// xor !=, because rooks can't move like that
        return (start.x == end.x) != (start.y == end.y);
    }
    
    public char getChar() { return isWhite ? 'R' : 'r'; }
    
    public boolean isWhite() { return isWhite; }
    
    public boolean hasMoved() { return hasMoved; }
    
    public Rook clone() { return new Rook(isWhite); }
    
}