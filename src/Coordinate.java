//should we use points instead of this, this is making it complicated
public class Coordinate {
	
	private char letter;
	private char number;
	
	public Coordinate(char letter, char number) {
		this.letter = letter;
		this.number = number;
	}
	
	public char getLetter() { return letter; }
	public char getNumber() { return number; }
	
	public void setCoordinate(char letter, char number) {
		this.letter = letter;
		this.number = number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + letter + number;
	}
	
	
}
