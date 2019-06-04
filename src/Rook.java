
public class Rook implements Piece {

    private boolean isWhite;

    public Rook(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove() {
        return false;
    }

    public int[][] getValidMoves(Board board){
        return new int[8][8];

    }

    public char getChar() { return isWhite ? 'R' : 'r'; }
    
    public boolean isWhite() { return isWhite; }
}
