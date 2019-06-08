import java.awt.Point;

public class Main {
	public static void main(String[] args) {
		Board b = new Board();
		b.resetBoard();
		b.drawBoard();
		/* Tests */
		// White Pawn
		b.move(new Point(4, 6), new Point(4, 4));
		b.move(new Point(4, 4), new Point(4, 3));
		b.move(new Point(4, 3), new Point(5, 2));
		b.move(new Point(4, 3), new Point(4, 2));
		b.move(new Point(4, 2), new Point(5, 1));
		b.move(new Point(4, 2), new Point(5, 1));
		b.move(new Point(5, 1), new Point(6, 0)); //king is not going into check?
		// Black Pawn
		b.move(new Point(4, 1), new Point(4, 3));
		b.move(new Point(4, 3), new Point(4, 4));
		b.move(new Point(4, 4), new Point(4, 5));
		b.move(new Point(4, 5), new Point(4, 6));
		b.move(new Point(4, 6), new Point(3, 7));

		// Black King
		b.move(new Point(5, 0), new Point(6, 1));
	}
}