import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;

public class Graphics {
	private JFrame startScreen;  
	private JFrame mainPanel;  
	private JFrame promotionMenu;
	private char[][] charBoard;
	private PieceSelectionButton[] optionButtons;
	private BoardButton[][] buttons;
	private Piece chosenPiece = null;
	private boolean chosen = false;
	private boolean canContinue = false;
	
	
	
	public Graphics(char[][] visibleBoard) {  
		startScreen = new JFrame();
		mainPanel = new JFrame();  
		buttons = new BoardButton[8][8];
		charBoard = visibleBoard;
		
		mainPanel.setTitle("Chess Game");
		mainPanel.setResizable(false); 
		
		showStartScreen();
	}
	
	private void showStartScreen() {
		startScreen.setLayout(new BorderLayout());
		
		String text = "<html><div style='text-align: center;'>Welcome to Chess, by Ansh Verma and Ved Thiru</div></html>";
		JLabel textArea = new JLabel(text);
	    textArea.setFocusable(false);
		textArea.setFont(new Font("Comic Sans MS", 60, 60));
		
		
		startScreen.add(textArea, BorderLayout.PAGE_START);
		
		//i have a good way to add bot difficulty selection
		
		JButton startButton = new JButton();
		startButton.setText("Play Chess!");
		startButton.setBackground(Color.YELLOW);
	    startButton.setFocusable(false);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canContinue = true;
			}
		});
		startScreen.add(startButton, BorderLayout.CENTER);
		
		startScreen.setSize(600,600); 
		startScreen.setLocationRelativeTo(null);
		startScreen.setTitle("Start Screen");
		startScreen.setResizable(false); 
		startScreen.setVisible(true);
		startScreen.setDefaultCloseOperation(3); 
		
		
		while(!canContinue) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		startScreen.setVisible(false);
		populateBoard();
	}
	
	private void populateBoard() {
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
			    buttons[i][j].setFocusable(false);
				
				mainPanel.add(buttons[i][j]);
			}
		}
		
		mainPanel.setSize(1000,1000); 
		mainPanel.setLocationRelativeTo(null);
		mainPanel.setVisible(true);
		mainPanel.setLayout(new GridLayout(8,8)); 
		mainPanel.setDefaultCloseOperation(3); //ends program after closing window
			
	}  
		
	public void setNewSource(char[][] newBoard) {
		this.charBoard = newBoard;
	}
	
	public void refreshPieces() {
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				if(charBoard[i][j] != '\0') {
					String filePath = "Images/";
					filePath += Character.isUpperCase(charBoard[i][j]) ? "W" : "B";
					filePath += charBoard[i][j] + ".png";
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
			optionButtons[i].setFocusable(false);
			
			
			optionButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PieceSelectionButton caller = (PieceSelectionButton) e.getSource();
					chosenPiece = caller.getHeldPiece();
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
		promotionMenu.setLocationRelativeTo(null);
		promotionMenu.setVisible(true);
		promotionMenu.setDefaultCloseOperation(0); //if red x is pressed don't close menu
		System.out.println("Choose a piece to promote to");
		
		while(!chosen) {
			try {
				Thread.sleep(300);
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
		chosen = false;
		return chosenPiece;
		
	}
	
	
}