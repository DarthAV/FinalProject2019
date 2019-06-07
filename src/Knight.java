import java.awt.Point;
import java.util.ArrayList;

public class Knight implements Piece {

    private boolean isWhite;

    public Knight(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public boolean[][] getValidMoves(Piece[][] board, Point pos){
        return new boolean[8][8];
    }

    public char getChar() { return isWhite ? 'N' : 'n'; }
    // checked online, N is the right repr
    
    public boolean isWhite() { return isWhite; }
    
    public Knight clone() { return new Knight(isWhite); }
    
}