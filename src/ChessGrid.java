import java.awt.*;
import javax.swing.*;

public class ChessGrid {
	JFrame f;  
	public ChessGrid() {  
		f = new JFrame();  
		f.setTitle("Chess Game");
		
		JButton[][] buttons = new JButton[8][8];
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new JButton(/*i + 1 + ""*/);
			}
		}
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				if ((i+j) % 2 == 0) {
					buttons[i][j].setBackground(Color.WHITE);
		        } else {
		        	buttons[i][j].setBackground(Color.BLACK);
		        }
			}
		}
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				f.add(buttons[i][j]);
			}
		}
		
		f.setLayout(new GridLayout(8,8));  

		f.setSize(900,900);  
		f.setVisible(true);
	}  
}