# rules for moving pieces

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

- [ ] moving
    - one square only in any direction
- [ ] castling
    - hasMovedAlready
    - check Rook as well
    - check for pieces in between
- [ ] check same color capture
- [ ] check board boundaries
- [ ] check(mate)

# rook

- [ ] moving
    - check if in same column or row not both
    - can't travel over pieces
- [ ] castling
    - hasMovedAlready
- [ ] check same color capture

# bishop
- [ ] moving
    - check diagonals
    - can't travel over pieces
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
- [ ] check same color capture
