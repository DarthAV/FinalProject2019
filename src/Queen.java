import java.awt.Point;
import java.util.ArrayList;

public class Queen implements Piece {

    private boolean isWhite;

    public Queen(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
        return false;
    }

    public boolean[][] getValidMoves(Piece[][] board, Point pos){
        return new boolean[8][8];
    }

    public char getChar() { return isWhite ? 'Q' : 'q'; }
    
    public boolean isWhite() { return isWhite; }
    
    public Queen clone() { return new Queen(isWhite); }
}