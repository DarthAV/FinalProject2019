import java.awt.Point;

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
    	boolean hit = false;
    	for (int i = start.x-1; i >= end.x; i--) {
    		if (hit) { return false; }
    		if (board[start.y][i] != null && board[start.y][i].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[start.y][i] != null) { return false; }
    	}
    	for (int i = start.x+1; i <= end.x; i++) {
    		if (hit) { return false; }
    		if (board[start.y][i] != null && board[start.y][i].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[start.y][i] != null) { return false; }
    	}
    	for (int i = start.y-1; i >= end.y; i--) {
    		if (hit) { return false; }
    		if (board[i][start.x] != null && board[i][start.x].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[i][start.x] != null) { return false; }
    	}
    	for (int i = start.y+1; i <= end.y; i++) {
    		if (hit) { return false; }
    		if (board[i][start.x] != null && board[i][start.x].isWhite() != this.isWhite) { hit = true; continue; }
    		if (board[i][start.x] != null) { return false; }

    	}
    	
    	
    	// xor !=, because rooks can't move like that
    	return (start.x == end.x) != (start.y == end.y);
    	}
    
    public char getChar() { return isWhite ? 'R' : 'r'; }
    
    public boolean isWhite() { return isWhite; }
   
    public boolean hasMoved() { return hasMoved; }

    public Rook clone() { return new Rook(isWhite); }
    
}