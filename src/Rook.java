import java.awt.Point;
import java.util.ArrayList;

public class Rook implements Piece {

    private boolean isWhite;

    public Rook(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public ArrayList<Point[]> getValidMoves(Piece[][] board){
        return new ArrayList<Point[]>();
    }

    public char getChar() { return isWhite ? 'R' : 'r'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Rook clone() { return new Rook(isWhite); }
    
}