
import java.awt.Point;

public class Main {
	public static Point clickedStart;
	public static Point clickedEnd;
	public static Board b;
	public static void main(String[] args) {
		b = new Board();
		b.resetBoard();
		b.drawBoard();
		while(true) {
			while(clickedEnd == null|| clickedStart == null) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			b.move(clickedStart, clickedEnd);
		}
		/* Tests:
		 * 
		 * put a comment that says "should be invalid" next to all
		 * tests that should fail
		 *  
		 */
		// White Pawn
		/*b.move(new Point(4, 6), new Point(4, 4));
		b.move(new Point(4, 4), new Point(4, 3));
		b.move(new Point(4, 3), new Point(5, 2)); //should be invalid
		b.move(new Point(4, 3), new Point(4, 2));
		b.move(new Point(4, 2), new Point(5, 1));
		b.move(new Point(4, 2), new Point(5, 1)); //should be invalid
		b.move(new Point(5, 1), new Point(6, 0)); //king is not going into check?
		// Black Pawn
		b.move(new Point(4, 1), new Point(4, 2));
		b.move(new Point(4, 2), new Point(4, 3));
		b.move(new Point(4, 3), new Point(4, 4));
		b.move(new Point(4, 4), new Point(4, 5));
		b.move(new Point(4, 5), new Point(4, 4)); //should be invalid
		b.move(new Point(4, 5), new Point(4, 6));
		b.move(new Point(4, 6), new Point(3, 7));

		// White King
		b.move(new Point(4, 7), new Point(3, 7)); */

    // Rook
    //b.move(new Point(7, 7), new Point(7, 2));
    //b.drawBoard();
    // bishop
    //b.move(new Point(1, 6), new Point(1, 4));
    //b.move(new Point(2, 7), new Point(0, 5));
    //b.drawBoard();
        // System.out.print(b.getFEN());

	}
}
