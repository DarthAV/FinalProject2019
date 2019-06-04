import java.awt.Point;
import java.util.ArrayList;

public class Bishop implements Piece {

    private boolean isWhite;

    public Bishop(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public ArrayList<Point[]> getValidMoves(Piece[][] board){
        return new ArrayList<Point[]>();
    }

    public char getChar() { return isWhite ? 'B' : 'b'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Bishop clone() { return new Bishop(isWhite); }
    
}