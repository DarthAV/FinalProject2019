
import java.awt.Point;

public class Game {
	public static Point clickedStart;
	public static Point clickedEnd;
	public static Board b;
	public static boolean whiteTurn = true;
	public static void main(String[] args) {
		b = new Board();
		b.resetBoard();
		b.drawBoard();
		while(true) {
			while(clickedEnd == null || clickedStart == null) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			b.move(clickedStart, clickedEnd);
		}

        // System.out.print(b.getFEN());

	}
}
