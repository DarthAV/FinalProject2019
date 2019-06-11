import java.awt.Point;
import java.util.Scanner;

// Board handles moving, classes tell whether move is valid.
// STATUS: INCOMPLETE
// see move method

public class Board {
    public Piece[][] board = new Piece[8][8];

    public void drawBoard() {
        char[][] visibleBoard = new char[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Piece spot = board[i][j];
                if(spot == null) {
                    //visibleBoard[i][j] = '.';
                } else {
                    visibleBoard[i][j] = spot.getChar();
                }

            }
        }

        //we still need to work on this
        System.out.print("    ");
        for(int i = 1; i < 32; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < visibleBoard.length; i++) {
            System.out.print(8-i + "  ");
            for (int j = 0; j < visibleBoard[i].length; j++) {
                System.out.print("|_");
                System.out.print(visibleBoard[i][j]);
                System.out.print("_");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
        System.out.print("     ");
        for(int i = 1; i < 9; i++) {
            System.out.print((char)(i+64) + "   ");
        }
        System.out.println();
    }

    public void setBoard() {

        //how do we want to do the grid system? Right now it is feeling weird

        //maybe we should use java.awt.Point

        board[0][0] = new Rook(false);

        board[0][1] = new Knight(false);

        board[0][2] = new Bishop(false);

        board[0][3] = new Queen(false);

        board[0][4] = new King(false);

        board[0][5] = new Bishop(false);

        board[0][6] = new Knight(false);

        board[0][7] = new Rook(false);

        for (int i = 0; i < board[1].length; i++) {

            board[1][i] = new Pawn(false);

        }

        for (int i = 0; i < board[1].length; i++) {

            board[6][i] = new Pawn(true);

        }

        board[7][0] = new Rook(true);

        board[7][1] = new Knight(true);

        board[7][2] = new Bishop(true);

        board[7][3] = new Queen(true);

        board[7][4] = new King(true);

        board[7][5] = new Bishop(true);

        board[7][6] = new Knight(true);

        board[7][7] = new Rook(true);

    }

    public Piece[][] getBoard() {

        return board;

    }

    /**
     * 
     * @param start
     * @param end
     * @return true if move was successful
     * @return false if move was not successful
     */
    public boolean move(Point start, Point end) {
    	boolean success = false;
    	if (board[start.y][start.x] != null) { 
	    	Piece p = board[start.y][start.x].clone();
	    	if (p.validateMove(board, start, end)) {
	    		// swap op. Added benefit of taking out the piece
	    		// at terminal position
	    		success = true;
	    		board[start.y][start.x] = null;
	    		board[end.y][end.x] = p;
	    		System.out.println("VALID");
	    	}
	    	// we need to work on this promotion thing
    		if (p instanceof Pawn && ((Pawn) p).eligibleForPromotion(board, end)) {
    			Scanner sc = new Scanner(System.in);
    			System.out.print("Promote to? (Q, R, N, B) ");
    			char x = sc.next().charAt(0);
    			board[end.y][end.x] = null;
    			if (x == 'Q') board[end.y][end.x] = new Queen(p.isWhite());
    			if (x == 'R') board[end.y][end.x] = new Rook(p.isWhite());
    			if (x == 'N') board[end.y][end.x] = new Knight(p.isWhite());
    			if (x == 'B') board[end.y][end.x] = new Bishop(p.isWhite());
    		}
    		// king's check
    		
    		
    	}
    	return success;
    }
    // this doesn't work, see https://en.wikipedia.org/wiki/Forsyth–Edwards_Notation
    public String getFEN() {
    	String r = "";
    	for (Piece[] row: board) {
    		for (Piece p : row) {
    			r += (p == null) ? '0' : p.getChar();
    		}
    		r += '/';
    	}
    	r = r.replace("00000000","8");
    	return r;
    }

}