# BOARD MOVE
- [ ] a move cannot put that piece's king in check.

# pawn

- [x] moving
    - one square up
    - capturing
    - first move advantage
- [x] capture
    - diagonal not forward
    - only if piece to capture
- [x] check same color capture
- [x] check board boundaries

# king

- [x] moving
    - one square only in any direction
    - [x] castling
    - hasMovedAlready
    - check Rook as well
    - check for pieces in between
- [x] check same color capture
- [x] check board boundaries
- [x] check
    - in other words, is its position in any of the other color's pieces' valid moves?
- [x] checkmate
    - is it in check?
    - are all the positions that the king can move into in other color's pieces' valid moves?

# rook (NOT WORKING, ONLY MOVES UP AND LEFT)

- [x] moving
    - check if in same column or row not both
    - can't travel over pieces
- [x] castling
    - hasMovedAlready
- [x] check same color capture

# bishop (NOT WORKING, VALVE, PLS FIX)
- [x] moving
    - check diagonals
    - can't travel over pieces
- [x] check same color capture

# queen (NOT MOVING)
- [x] moving
    - check if it is moving like rook or bishop
    - then use respective method
- [x] check same color capture

# knight (MOVES ONE EXTRA SQUARE, ALSO, CAN CAPTURE TEAMMATES)
- [x] moving
    - only 8 places to move
    - *can* travel over pieces
- [x] check same color capture

# board
if we're going to use a chess engine the uci protocol is supported by StockFish which takes in a FEN representation of the board as i have implemented in getFEN()  
StockFish returns a message like below:  
`'bestmove e2e4 ponder e7e5'`  
where `bestmove` is the computer's move
and `ponder` is the best move for the opponent
after the computer has moved.
