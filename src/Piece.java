
// we can always change to abstract class later

public interface Piece {
    public boolean validateMove(); // should this return a Point instead?
    public int[][] getValidMoves(Board board); // should this return an ArrayList<Point> instead?
    public char getChar();
    public boolean isWhite();
}