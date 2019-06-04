import java.awt.Point;

public class Main {
    public static void main(String[] args) {
    	Board b = new Board();
        b.setBoard();
        b.drawBoard();
        b.move(new Point(4, 6), new Point(4, 4));
        b.move(new Point(4, 4), new Point(4, 3));
        // invcheck 2
        b.move(new Point(4, 3), new Point(3, 2));
        b.move(new Point(4, 3), new Point(4, 4));
        b.move(new Point(4, 3), new Point(4, 2));
        // invcheck 1
        b.move(new Point(4, 2), new Point(4, 1));
        b.move(new Point(4, 2), new Point(3, 1));
        b.drawBoard();
    }
}
