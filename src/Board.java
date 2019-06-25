import java.awt.*;
import java.util.*;

public class Board {
    public Piece[][] board = new Piece[8][8];
    private Graphics g = new Graphics(board);
    
    public King whiteKing = new King(true);
    public King blackKing = new King(false);

    
    public void drawBoard() {
        g.refreshPieces();
        
    }

    public void resetBoard() {
        board[0][0] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = blackKing;
        board[0][5] = new Bishop(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rook(false);
        
        for (int i = 0; i < board[1].length; i++) {
            board[1][i] = new Pawn(false);
            board[6][i] = new Pawn(true);
        }
        
        board[7][0] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = whiteKing;
        board[7][5] = new Bishop(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rook(true);


    }

    public Piece[][] getBoard() { return board; }

    
    /**
     * 
     * @param start
     * @param end
     * @return true if move was successful
     * @return false if move was not successful
     */
    public boolean move(Point start, Point end) {
    	boolean isValid = false;
    	Piece[][] copy = new Piece[8][8];
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++) {
    			copy[i][j] = board[i][j].clone();
    		}
		}
    	
    	if (board[start.y][start.x] != null) { 
	    	Piece p = board[start.y][start.x].clone();
	    	if (p.validateMove(board.clone(), start, end)) {
	    		// swap op. Added benefit of taking out the piece
	    		// at terminal position
	    		isValid = true;
	    		board[start.y][start.x] = null;
	    		board[end.y][end.x] = p;
	    	}
    		// king's check
   			/*if(board[start.y][start.x].isWhite() ? whiteKing.isInCheck(board, newstart.y][start.x] : blackKing.isInCheck(board, board[start.y][start.x]) {
   				
   			}*/
    		if (p instanceof Pawn && isValid && ((Pawn) p).eligibleForPromotion(board, end)) {
				board[end.y][end.x] = g.chooseNewPiece(p.isWhite());
    		}
    		if(p instanceof Pawn && isValid) {
    			 ((Pawn) p).hasMoved = true;
    		}
    		if(p instanceof King && isValid) {
   			 ((King) p).hasMoved = true;
   			 
    		}
    		
    		
    	}
    	System.out.println(isValid ? "VALID" : "INVALID");

    	//we switch the player that is moving
    	if(isValid) { Main.whiteTurn = !Main.whiteTurn; g.switchCurrentMovingPlayer();}
    	
    	this.drawBoard();
    	Main.clickedStart = null;
    	Main.clickedEnd = null;
    	return isValid;
    }
    
    public boolean[][] getValidMoves(Point pos) {
    	if(board[pos.y][pos.x] != null)
    		return board[pos.y][pos.x].getValidMoves(board, pos);
    	return new boolean[8][8];
    }
    
    // this doesn't work, see https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation
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