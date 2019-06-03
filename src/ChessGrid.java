import java.awt.*;
import javax.swing.*;

public class ChessGrid {
	JFrame f;  
	ChessGrid(){  
		f = new JFrame();  
		JButton[] buttons = new JButton[64];
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(/*i + 1 + ""*/);
		}
		
		for(JButton i : buttons) {
			f.add(i);
		}
			f.setLayout(new GridLayout(8,8));  

			f.setSize(900,900);  
			f.setVisible(true);
		}  
	}