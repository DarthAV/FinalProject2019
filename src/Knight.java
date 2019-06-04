import java.awt.Point;
import java.util.ArrayList;

public class Knight implements Piece {

    private boolean isWhite;

    public Knight(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public ArrayList<Point[]> getValidMoves(Piece[][] board){
        return new ArrayList<Point[]>();
    }

    public char getChar() { return isWhite ? 'N' : 'n'; }
    // checked online, N is the right repr
    
    public boolean isWhite() { return isWhite; }
    
    public Knight clone() { return new Knight(isWhite); }
    
}