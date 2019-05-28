//our chessboard has the numbers going down from the top left
//the letters go right from the top left

public class Board {

	public static void main(String[] args) {
		Piece[][] board = new Piece[8][8];
		setBoard(board);
		
		
	}
	
	//sets the board to the starting position
	private static void setBoard(Piece[][] board) {
		
		
		for (int i = 0; i < board[1].length; i++) {
			board[2][i] = new Pawn(new Coordinate((char)(i+65), '2'), false);
		}
		for (int i = 0; i < board[1].length; i++) {
			board[2][i] = new Pawn(new Coordinate((char)(i+65), '2'), true);
		}
	}

}
