
public class Pawn implements Piece {

    private boolean isWhite;

    public Pawn(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove() {
        return false;
    }

    public int[][] getValidMoves(Board board){
        return new int[8][8];

    }

    public char getChar() { return isWhite ? 'P' : 'p'; }
    
    public boolean isWhite() { return isWhite; }
}