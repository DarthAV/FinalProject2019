import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;

public class Graphics {
	private JFrame mainPanel;  
	private JFrame promotionMenu;
	
	private PieceSelectionButton[] optionButtons;
	private BoardButton[][] buttons;
	
	private Piece chosenPiece = null;
	private boolean chosen = false;
	
	public Graphics(char[][] visibleBoard) {  
		mainPanel = new JFrame();  
		buttons = new BoardButton[8][8];
		
		mainPanel.setTitle("Chess Game");
		mainPanel.setResizable(false); 
		
		
		
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new BoardButton(j, i);	
				
				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BoardButton clickedButton = (BoardButton) e.getSource();
						System.out.println("x = " + clickedButton.getXLocation());
						System.out.println("y = " + clickedButton.getYLocation());
					}
				});
				
				if ((i+j) % 2 == 0)
					buttons[i][j].setBackground(Color.WHITE);
				else
		        	buttons[i][j].setBackground(Color.BLACK);
				
				buttons[i][j].setSize(100, 100);
				
				if(visibleBoard[i][j] != '\0') {
					String filePath = "Images/";
					filePath += Character.isUpperCase(visibleBoard[i][j]) ? "W" : "B";
					filePath += visibleBoard[i][j] + ".png";
					try {
					    Image img = ImageIO.read(getClass().getResource(filePath));
					    buttons[i][j].setIcon(new ImageIcon(img));
					    
					} catch (Exception e) { System.out.println(e);}
				}	
					
		
				mainPanel.add(buttons[i][j]);
			}
		}
		mainPanel.setSize(1000,1000); 
		mainPanel.setVisible(true);
		mainPanel.setLayout(new GridLayout(8,8)); 
		mainPanel.setDefaultCloseOperation(3); //ends program after closing window
			
	}  
	
	
	
	
	//im not sure how well this works
	public void refresh(char[][] newBoard) {
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				if(newBoard[i][j] != '\0') {
					String filePath = "Images/";
					filePath += Character.isUpperCase(newBoard[i][j]) ? "W" : "B";
					filePath += newBoard[i][j] + ".png";
					try {
					    Image img = ImageIO.read(getClass().getResource(filePath));
					    buttons[i][j].setIcon(new ImageIcon(img));
					    
					} catch (Exception e) { System.out.println(e);}
				
				
				}
				else {
					buttons[i][j].setIcon(null);
				}
			}
		}
	}
	
	
	
	
	public Piece chooseNewPiece(boolean isWhite) {

		//disable the chess board until the piece is selected
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
		
		promotionMenu = new JFrame(); 
		optionButtons = new PieceSelectionButton[4];
		
		for(int i = 0; i < optionButtons.length; i++) {
			Piece pieceType;
			if(i == 0) pieceType = new Knight(isWhite); 
			else if(i == 1) pieceType = new Rook(isWhite);
			else if(i == 2) pieceType = new Bishop(isWhite);
			else pieceType = new Queen(isWhite);
			
			optionButtons[i] = new PieceSelectionButton(pieceType);	
			optionButtons[i].setBackground(isWhite ? Color.WHITE : Color.BLACK);
			
			
			optionButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PieceSelectionButton caller = (PieceSelectionButton) e.getSource();
					chosenPiece = caller.getHeldPiece();
					System.out.println(chosenPiece.getChar());
					chosen = true;
					promotionMenu.dispose();
				}
			});
			
			String filePath = "Images/";
			filePath += isWhite ? "W" : "B";
			filePath += pieceType.getChar() + ".png";
			try {
				 Image img = ImageIO.read(getClass().getResource(filePath));
				 optionButtons[i].setIcon(new ImageIcon(img));
			} catch (Exception e) { 
				System.out.println(e);
			}
			
			promotionMenu.add(optionButtons[i]);
			
		}
		
		
	
		promotionMenu.setSize(600,175); 
		promotionMenu.setTitle("Promotion Menu");
		promotionMenu.setLayout(new GridLayout(1, 4));
		promotionMenu.setResizable(false); 
		promotionMenu.setVisible(true);
		promotionMenu.setDefaultCloseOperation(0); //if red x is pressed dont close menu
		System.out.println("Choose a piece to promote to");
		
		while(!chosen) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//reenable the chess board until the piece is selected
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j].setEnabled(true);
			}
		}
		
		return chosenPiece;
		
	}
	
	
}