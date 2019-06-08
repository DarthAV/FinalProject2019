import java.awt.Point;
import java.util.ArrayList;

public class Rook implements Piece {

    private boolean isWhite;
    private boolean hasMoved;

    public Rook(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	//if ((start.x != end.x))
    	
    	
		return true;
    }

    public boolean[][] getValidMoves(Piece[][] board, Point pos){
        return new boolean[8][8];
    }

    public char getChar() { return isWhite ? 'R' : 'r'; }
    
    public boolean isWhite() { return isWhite; }
    
    public boolean hasMoved() { return hasMoved; }
    
    public Rook clone() { return new Rook(isWhite); }
    
}