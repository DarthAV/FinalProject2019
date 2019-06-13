import java.awt.Point;
import java.util.ArrayList;

public class Queen extends Piece {

    private boolean isWhite;

    public Queen(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	//as soon as bishop and rook are fixed, this will work
    	return (new Rook(this.isWhite).validateMove(board, start, end) 
    			|| new Bishop(this.isWhite).validateMove(board, start, end));
    }

    public char getChar() { return isWhite ? 'Q' : 'q'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Queen clone() { return new Queen(isWhite); }
}