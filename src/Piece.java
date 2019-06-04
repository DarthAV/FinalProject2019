import java.awt.Point;
import java.util.ArrayList;

// we can always change to abstract class later

public interface Piece {
    public boolean validateMove(Piece[][] board, Point start, Point end);
    public ArrayList<Point[]> getValidMoves(Piece[][] board); // should this return an ArrayList<Point> instead?
    public char getChar();
    public boolean isWhite();
    public Piece clone();
}