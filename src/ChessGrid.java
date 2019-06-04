import java.awt.*;
import javax.swing.*;

public class ChessGrid {
	JFrame f;  
	public ChessGrid() {  
		f = new JFrame();  
		f.setTitle("Chess Game");
		
		JButton[] buttons = new JButton[64];
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(/*i + 1 + ""*/);
		}
		
		
		for(int i = 0; i < buttons.length; i++) {
			if(i == 0) 
				buttons[i].setBackground(Color.BLACK);
			
			else if(buttons[i-1].getBackground().equals(Color.BLACK))
				buttons[i].setBackground(Color.WHITE);
			else
				buttons[i].setBackground(Color.BLACK);
		}
		
		for(JButton i : buttons) {
			f.add(i);
		}
		f.setLayout(new GridLayout(8,8));  

		f.setSize(900,900);  
		f.setVisible(true);
	}  
}