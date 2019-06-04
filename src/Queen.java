
public class Queen implements Piece {

    private boolean isWhite;

    public Queen(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove() {
        return false;
    }

    public int[][] getValidMoves(Board board){
        return new int[8][8];

    }

    public char getChar() { return isWhite ? 'Q' : 'q'; }
    
    public boolean isWhite() { return isWhite; }
}
