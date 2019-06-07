# pawn

- [x] moving
    - one square up
    - capturing
    - first move advantage
    - can't put its king in check
- [x] capture
    - diagonal not forward
    - only if piece to capture
- [x] check same color capture
- [x] check board boundaries

# king

- [x] moving
    - one square only in any direction
    - can't put itself in check
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

# rook

- [ ] moving
    - check if in same column or row not both
    - can't travel over pieces
    - can't put its king in check
- [ ] castling
    - hasMovedAlready
- [ ] check same color capture

# bishop
- [ ] moving
    - check diagonals
    - can't travel over pieces
    - can't put its king in check
- [ ] check same color capture

# queen
- [ ] moving
    - check if it is moving like rook or bishop
    - then use respective method
- [ ] check same color capture

# knight
- [ ] moving
    - only 8 places to move
    - *can* travel over pieces
    - can't put its king in checks
- [ ] check same color capture
