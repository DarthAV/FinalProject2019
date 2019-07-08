
import java.awt.Point;

public class Game {
	public static Point clickedStart;
	public static Point clickedEnd;
	public static Board b;
	public static boolean whiteTurn = true;
	public static void main(String[] args) {
		b = new Board();
		restartGame();
        // System.out.print(b.getFEN());

	}
	
	public static void restartGame() {
		clickedStart = null;
		clickedEnd = null;
		b.resetBoard();
		b.drawBoard();
		play();
	}
	
	public static void play() {
		while(true) {
			while(clickedEnd == null || clickedStart == null) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(b.move(clickedStart, clickedEnd) ? "VALID" : "INVALID");
		}
	}

	
}
