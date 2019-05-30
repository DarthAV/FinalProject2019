
//our chess board has the numbers going down from the top left
//the letters go right from the top left
public class Board {

	public static void main(String[] args) {
		Piece[][] board = new Piece[8][8];
		setBoard(board);
		drawBoard(board);
	}
	
	public static void drawBoard(Piece[][] board) {
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
		System.out.print("     ");
		for(int i = 1; i < 9; i++) {
			System.out.print((char)(i+64) + "   ");
		}
		System.out.println();
		System.out.print("    ");
		for(int i = 1; i < 32; i++) {
			System.out.print("_");
		}
		System.out.println();
		for (int i = 0; i < visibleBoard.length; i++) {
			System.out.print(i+1 + "  ");
			for (int j = 0; j < visibleBoard[i].length; j++) {
				System.out.print("|_");
				System.out.print(visibleBoard[i][j]);
				System.out.print("_");
				
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	//sets the board to the starting position
	private static void setBoard(Piece[][] board) {
		//how do we want to do the grid system? Right now it is feeling weird
		//maybe we should use java.awt.Point
		board[0][0] = new Rook(new Coordinate((char)(1+64), '1'), false);
		board[0][1] = new Knight(new Coordinate((char)(2+64), '1'), false);
		board[0][2] = new Bishop(new Coordinate((char)(3+64), '1'), false);
		board[0][3] = new Queen(new Coordinate((char)(4+64), '1'), false);
		board[0][4] = new King(new Coordinate((char)(5+64), '1'), false);
		board[0][5] = new Bishop(new Coordinate((char)(6+64), '1'), false);
		board[0][6] = new Knight(new Coordinate((char)(7+64), '1'), false);
		board[0][7] = new Rook(new Coordinate((char)(8+64), '1'), false);
		for (int i = 0; i < board[1].length; i++) {
			board[1][i] = new Pawn(new Coordinate((char)(i+64), '2'), false);
		}
		for (int i = 0; i < board[1].length; i++) {
			board[6][i] = new Pawn(new Coordinate((char)(i+64), '7'), true);
		}
		board[7][0] = new Rook(new Coordinate((char)(1+64), '1'), true);
		board[7][1] = new Knight(new Coordinate((char)(2+64), '1'), true);
		board[7][2] = new Bishop(new Coordinate((char)(3+64), '1'), true);
		board[7][3] = new Queen(new Coordinate((char)(4+64), '1'), true);
		board[7][4] = new King(new Coordinate((char)(5+64), '1'), true);
		board[7][5] = new Bishop(new Coordinate((char)(6+64), '1'), true);
		board[7][6] = new Knight(new Coordinate((char)(7+64), '1'), true);
		board[7][7] = new Rook(new Coordinate((char)(8+64), '1'), true);
		
	}

}
