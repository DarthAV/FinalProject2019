import java.awt.Point;
import java.util.ArrayList;

public class King implements Piece {

    private boolean isWhite;

    public King(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public ArrayList<Point[]> getValidMoves(Piece[][] board){
        return new ArrayList<Point[]>();
    }

    public char getChar() { return isWhite ? 'K' : 'k'; }

    public boolean isWhite() { return isWhite; }
    
    public King clone() { return new King(isWhite); }
    
}