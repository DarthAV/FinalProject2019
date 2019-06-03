
public class Knight implements Piece {

    private boolean isWhite;

    public Knight(boolean isWhite) { this.isWhite = isWhite; }

    public boolean validateMove() {
        return false;
    }

    public int[][] getValidMoves(Board board){
        return new int[8][8];
    }

    public char getChar() { return isWhite ? 'N' : 'n'; }
    // checked online, N is the right repr
    
    public boolean isWhite() { return isWhite; }
}