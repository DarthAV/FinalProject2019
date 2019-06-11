import java.awt.Point;
import java.util.ArrayList;

public class King implements Piece {

    private boolean isWhite;
    private boolean hasMoved;

    public King(boolean isWhite, boolean hasMoved) { this.isWhite = isWhite; this.hasMoved = hasMoved; }
    public King(boolean isWhite) { this(isWhite, false); }

    public boolean validateMove(Piece[][] board, Point start, Point end) {
    	// check if castle
    	if (validateCastle(board, start, end)) { 
    		return false;
    	}
    	
    	// check if moving in valid direction
        if (Math.abs(start.x - end.x) != 1 && Math.abs(start.y - end.y) != 1) {
        	return false;
        }
    	// check if capturing same color
        if (board[end.y][end.x] != null && board[end.y][end.x].isWhite() == this.isWhite) {
        	return false;
        }
        // board boundaries
        if (end.x < 0 || end.x > board[0].length) { return false; }
        if (end.y < 0 || end.y > board.length) { return false; }
        
    	return true;
    }

    public boolean[][] getValidMoves(Piece[][] board, Point pos){
    	boolean[][] r = new boolean[board.length][board[0].length];
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			r[i][j] = validateMove(board, pos, new Point(j, i));
    		}
    	}
    	return r;
    }

    public char getChar() { return isWhite ? 'K' : 'k'; }

    public boolean isWhite() { return isWhite; }
    
    public King clone() { return new King(isWhite, hasMoved); }
    
    public boolean validateCastle(Piece[][] board, Point start, Point end) {
    	// a nightmare, i know.
    	return board[start.y][start.x] instanceof King && !hasMoved && (end.x == 7 || end.x == 2) && (end.y == start.y) && (start.x == 4) && (board[start.y][(end.x - start.x) > 0 ? 7 : 0] instanceof Rook) && (((Rook) board[start.y][(end.x - start.x) > 0 ? 7 : 0]).hasMoved()) && ((Rook) board[start.y][(end.x - start.x) > 0 ? 7 : 0]).validateMove(board, new Point(start.y, (end.x - start.x) > 0 ? 7 : 0), new Point(start.y, start.x+(end.x - start.x) > 0 ? 1 : -1));
    }
    
    public boolean check(Piece[][] board, Point pos) {
    	if (pos.x < 0 || pos.x > board[0].length || pos.y < 0 || pos.y > board[0].length) {
    		return true;
    	}
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j].isWhite() != this.isWhite) {
    				if (board[i][j].getValidMoves(board, new Point(j, i))[i][j]) {
    					return false;
    				}
    			}
    		}
    	}
    	
    	return true;
    }

    public boolean checkmate(Piece[][] board, Point pos) {
    	return this.check(board, pos) && this.check(board, new Point(pos.x, pos.y-1)) && this.check(board, new Point(pos.x, pos.y+1)) && this.check(board, new Point(pos.x-1, pos.y)) && this.check(board, new Point(pos.x+1, pos.y-1)) && this.check(board, new Point(pos.x-1, pos.y-1)) && this.check(board, new Point(pos.x-1, pos.y+1)) && this.check(board, new Point(pos.x+1, pos.y-1)) && this.check(board, new Point(pos.x+1, pos.y+1));
    }
}