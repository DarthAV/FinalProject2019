
public class King implements Piece {

    private boolean isWhite;

    public Rook(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove() {
        return false;
    }

    public int[][] getValidMoves(Board board){
        return new int[][];
    }

    public char getChar() { return isWhite ? 'R' : 'r'; }
}