import java.awt.Point;

public class Knight extends Piece {

    private boolean isWhite;

    public Knight(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) { return false; }
        // check if it is either one vertical and two horizontal or vice versa.
    	return (Math.abs(start.x - end.x) == 1 && Math.abs(start.y - end.y) == 2) || (Math.abs(start.x - end.x) == 2 && Math.abs(start.y - end.y) == 1);

    }

    public char getChar() { return isWhite ? 'N' : 'n'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Knight clone() { return new Knight(isWhite); }
    
}