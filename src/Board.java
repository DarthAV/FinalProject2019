import java.awt.*;

public class Board {
    public Piece[][] board = new Piece[8][8];
    private Graphics g = new Graphics(board);
    
    public King whiteKing = new King(true);
    public King blackKing = new King(false);

    
    public void drawBoard() {
        g.refreshPieces();
        
    }

    public void resetBoard() {

		
		whiteKing.location = new Point(4, 7);
		blackKing.location = new Point(4, 0);


        // board[0][0] = new Rook(false);
        // board[0][1] = new Knight(false);
        // board[0][2] = new Bishop(false);
        // board[0][3] = new Rook(false);
        // board[blackKing.location.y][blackKing.location.x] = blackKing;
        // board[0][5] = new Bishop(false);
        // board[0][6] = new Knight(false);
        // board[0][7] = new Rook(false);
        
        // for (int i = 0; i < board.length; i++) {
        //     board[1][i] = new Pawn(false);
        //     board[6][i] = new Pawn(true);
        // }
        // board[7][0] = new Rook(true);
        // board[7][1] = new Knight(true);
        // board[7][2] = new Bishop(true);
		// board[7][3] = new Rook(true);
        // board[whiteKing.location.y][whiteKing.location.x] = whiteKing;
        // board[7][5] = new Bishop(true);
        // board[7][6] = new Knight(true);
		// board[7][7] = new Rook(true);

		// board[0][0] = new Rook(false);
        // board[0][1] = new Knight(false);
        // board[0][2] = new Bishop(false);
        // board[0][3] = new Queen(false);
        board[blackKing.location.y][blackKing.location.x] = blackKing;
        // board[0][5] = new Bishop(false);
        // board[0][6] = new Knight(false);
        // board[0][7] = new Rook(false);
        
        for (int i = 0; i < board.length; i++) {
            // board[1][i] = new Pawn(false);
            // board[6][i] = new Pawn(true);
        }
        board[1][3] = new Rook(true);
        board[2][3] = new Rook(true);
        // board[7][0] = new Rook(true);
        // board[7][1] = new Knight(true);
        // board[7][2] = new Bishop(true);
		board[3][5] = new Rook(true);
		board[1][6] = new Rook(true);
        board[whiteKing.location.y][whiteKing.location.x] = whiteKing;
        // board[7][5] = new Bishop(true);
        // board[7][6] = new Knight(true);
		// board[7][7] = new Rook(true);
		




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
				if(board[i][j] != null)
					copy[i][j] = board[i][j].clone();
    		}
		}
    	
    	if(board[start.y][start.x] != null) { 
	    	Piece movingPiece = board[start.y][start.x];
	    	if (movingPiece.validateMove(board.clone(), start, end)) {
	    		// swap op. Added benefit of taking out the piece
				// at terminal position
				
				//also moving rook in castling
				if(movingPiece instanceof King) {
					((King) movingPiece).location = end;
					if(((King) movingPiece).validateCastle(board, start, end)) {
						if(end.x == 6) {
							board[start.y][5] = board[start.y][7];
							board[start.y][7] = null;
						}
						else {
							board[start.y][3] = board[start.y][7];
							board[start.y][0] = null;
						}
					}
				}
	    		isValid = true;
	    		board[start.y][start.x] = null;
				board[end.y][end.x] = movingPiece;
			}

			if(isValid) {
				// self king's check
				if(board[end.y][end.x].isWhite() ? whiteKing.isInCheck(board, whiteKing.location) : blackKing.isInCheck(board, blackKing.location)) {
					isValid = false;
					System.out.println("Invalid: King put into check");
					for(int i = 0; i < board.length; i++) {
						for(int j = 0; j < board.length; j++) {
							if(copy[i][j] != null)
								board[i][j] = copy[i][j].clone();
							else 
								board[i][j] = null;
						}
					}
				}
			}

			if(isValid) {
				if (movingPiece instanceof Pawn && isValid) {
					((Pawn) movingPiece).hasMoved = true;
					if(((Pawn) movingPiece).eligibleForPromotion(board, end)) {
						board[end.y][end.x] = g.showPawnPromotionMenu(movingPiece.isWhite());
					}
				}
				else if(movingPiece instanceof Rook && isValid) {
					((Rook) movingPiece).hasMoved = true;
				}
				if(movingPiece instanceof King) {
					((King) movingPiece).location = start;
					if(isValid) {
						((King) movingPiece).hasMoved = true;
						((King) movingPiece).location = end;
					}
				}

			}

			if(isValid) {
				if(isCheckmate(board, blackKing.location)) {
					System.out.println("white wins");
					g.showGameOverScreen(true);
				}
				
				if(isCheckmate(board, whiteKing.location)) {
					System.out.println("black wins");
					g.showGameOverScreen(false);
				} 
				
				if(isStalemate(board, (movingPiece.isWhite() ? blackKing : whiteKing).location)) {
					System.out.println("draw: stalemate");
					//g.showGameOverScreen(true);
				}
			
				Game.whiteTurn = !Game.whiteTurn; g.switchCurrentMovingPlayer();
				this.drawBoard();
			}
		}
	
	


    	Game.clickedStart = null;
    	Game.clickedEnd = null;
		return isValid;
	
    }
    
    public boolean isCheckmate(Piece[][] board, Point kingPos) {
		King kingInQuestion = board[kingPos.y][kingPos.x].isWhite() ? whiteKing : blackKing;
		boolean[][] spots = kingInQuestion.getValidMoves(board, kingPos);
		
		if(!kingInQuestion.isInCheck(board, kingPos)) {
			return false;
		}

		Piece[][] copy = new Piece[8][8];
		for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++) {
				if(board[i][j] != null)
					copy[i][j] = board[i][j].clone();
    		}
		}
		
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				if(spots[i][j]) {
					copy[kingInQuestion.location.y][kingInQuestion.location.x] = null;
					copy[i][j] = kingInQuestion.clone();
					//move the king for checking in check
					if(kingInQuestion.isInCheck(copy, new Point(j, i))) {
						copy[kingInQuestion.location.y][kingInQuestion.location.x] = kingInQuestion;
						copy[i][j] = null;
					}
					else 
						return false;
				}
			}
		}
		return true; 
	
	}
    
    public boolean isStalemate(Piece[][] board, Point kingPos) {
		
		King kingInQuestion = board[kingPos.y][kingPos.x].isWhite() ? whiteKing : blackKing;

    	


		if(kingInQuestion.isInCheck(board, kingPos)) { return false; }
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] != null && !kingInQuestion.location.equals(new Point(j, i)) && kingInQuestion.isWhite == board[i][j].isWhite()) {
					boolean[][] moves = board[i][j].getValidMoves(board, new Point(j, i));
					if(moves.length > 0) { return false; }
				}
			}
		}

		Piece[][] copy = new Piece[8][8];
		for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++) {
				if(board[i][j] != null)
					copy[i][j] = board[i][j].clone();
    		}
		}
		boolean[][] spots = kingInQuestion.getValidMoves(board, kingPos);
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				
				if(spots[i][j]) {
					copy[kingInQuestion.location.y][kingInQuestion.location.x] = null;
					copy[i][j] = kingInQuestion.clone();
					//move the king for checking in check
					if(kingInQuestion.isInCheck(copy, new Point(j, i))) {
						copy[kingInQuestion.location.y][kingInQuestion.location.x] = kingInQuestion;
						copy[i][j] = null;
					}
					else 
						return false;
				}
			}
		}
		return true;
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

    public boolean[][] getValidMoves(Point pos) {
    	if(board[pos.y][pos.x] != null)
    		return board[pos.y][pos.x].getValidMoves(board, pos);
    	return new boolean[8][8];
    }
	
	

}