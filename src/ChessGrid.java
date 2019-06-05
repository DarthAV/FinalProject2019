import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.*;
import javax.swing.*;

public class ChessGrid {
	JFrame f;  
	BoardButton[][] buttons;
	public ChessGrid(char[][] visibleBoard) {  
		f = new JFrame();  
		f.setTitle("Chess Game");
		
		buttons = new BoardButton[8][8];
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new BoardButton(j, i);	
				
				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton clickedButton = (JButton) e.getSource();
						System.out.println("x = " + clickedButton.getX() + "\n y = " + clickedButton.getY());
					}
				});
				
				
				if ((i+j) % 2 == 0)
					buttons[i][j].setBackground(Color.WHITE);
				else
		        	buttons[i][j].setBackground(Color.BLACK);
				
				buttons[i][j].setSize(100, 100);
			}
		}
		refreshGrid(visibleBoard);
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				f.add(buttons[i][j]);
				
				
			}
		}

		f.setSize(1000,1000);  
		f.setVisible(true);
		f.setLayout(new GridLayout(8,8)); 
		f.setDefaultCloseOperation(3); //ends program after closing window
		
	}  
	
	//im not sure how well this works
	public void refreshGrid(char[][] newBoard) {
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				if(newBoard[i][j] != '\0') {
					String filePath = "images/";
					if(Character.isUpperCase(newBoard[i][j]))
						filePath += "W" + newBoard[i][j] + ".png";
					else
						filePath += "B" + newBoard[i][j] + ".png";
					try {
					    Image img = ImageIO.read(getClass().getResource(filePath));
					    ImageIcon hi = new ImageIcon(img);
					    buttons[i][j].setIcon(new ImageIcon(img));
					    
					} catch (Exception e) { System.out.println(e);}
				
				
				}	
			}
		}
	}
}