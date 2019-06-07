import javax.swing.JButton;

public class PieceSelectionButton extends JButton {
	public Piece heldPiece;
	
	public PieceSelectionButton(Piece heldPiece) {
		this.heldPiece = heldPiece;
	}
	
	public Piece getHeldPiece() { return this.heldPiece; }
}
