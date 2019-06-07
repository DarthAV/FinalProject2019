import java.awt.Point;

public class Main {
    public static void main(String[] args) {
    	Board b = new Board();
        b.setBoard();
        b.drawBoard();
        /* Tests 
        // White Pawn 
        b.move(new Point(4, 6), new Point(4, 4));
        b.drawBoard();
        b.move(new Point(4, 4), new Point(4, 3));
        b.drawBoard();
        b.move(new Point(4, 3), new Point(3, 2));
        b.drawBoard();
        b.move(new Point(4, 3), new Point(4, 2));
        b.drawBoard();
        b.move(new Point(4, 2), new Point(5, 1));
        b.drawBoard();
        // Black Pawn
        b.move(new Point(4, 1), new Point(4, 3));
        b.drawBoard();
        b.move(new Point(4, 3), new Point(4, 4));
        b.drawBoard();
        b.move(new Point(4, 4), new Point(4, 5));
        b.drawBoard();
        b.move(new Point(4, 5), new Point(4, 6));
        b.drawBoard();
        b.move(new Point(4, 6), new Point(3, 7));
        b.drawBoard();
        */
    }
}