import java.awt.Point;
import java.util.ArrayList;

public class Queen implements Piece {

    private boolean isWhite;

    public Queen(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public ArrayList<Point[]> getValidMoves(Piece[][] board){
        return new ArrayList<Point[]>();
    }

    public char getChar() { return isWhite ? 'Q' : 'q'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Queen clone() { return new Queen(isWhite); }
}