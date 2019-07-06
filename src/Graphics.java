import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Graphics {
	private JFrame startScreen;  
	private JFrame mainPanel;  
	private JFrame promotionMenu;
	private JFrame endScreen;
	private JPanel innerBoard;
	private JPanel whiteBoard;
	private JPanel blackBoard;
	private Piece[][] board;
	private PieceSelectionButton[] optionButtons;
	private Dimension screenSize;
	private BoardButton[][] buttons;
	private Piece chosenPiece = null;
	private boolean chosen = false;
	private boolean canContinue = false;
	private Map<String, Image> images = new HashMap<String, Image>();

	
	public Graphics(Piece[][] board) {  
		startScreen = new JFrame();
		endScreen = new JFrame();
		mainPanel = new JFrame();  
		innerBoard = new JPanel();
		whiteBoard = new JPanel();
		blackBoard = new JPanel();
		buttons = new BoardButton[8][8];
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.board = board;
		
		File[] files = new File("Resources/Images/").listFiles();
		for (File file : files) {
			try {
				images.put(file.getName(), resizeImages(ImageIO.read(file), (int)(screenSize.getWidth()*0.05), (int)(screenSize.getHeight()*0.09)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		mainPanel.setTitle("Chess");
		mainPanel.setResizable(false); 
		
		showStartScreen();
	}
	
	private void showStartScreen() {
		startScreen.setLayout(new BorderLayout());
		
		String text = "<html><div style='text-align: center;'>Welcome to Chess, by Ansh Verma and Ved Thiru</div></html>";
		JLabel textArea = new JLabel(text);
	    textArea.setFocusable(false);
		textArea.setFont(new Font("Arial", 60, 60));
		textArea.setOpaque(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		
		startScreen.add(textArea, BorderLayout.PAGE_START);
		
		//i have a good way to add bot difficulty selection
		
		JButton startButton = new JButton();
		startButton.setBorderPainted(false);
		startButton.setText("Play Chess!");
		startButton.setBackground(Color.GRAY);
	    startButton.setFocusable(false);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canContinue = true;
			}
		});
		startScreen.add(startButton, BorderLayout.CENTER);
		
		startScreen.setSize((int)(screenSize.getWidth()*0.31), (int)(screenSize.getHeight()*0.55)); 
		startScreen.setLocationRelativeTo(null);
		startScreen.setTitle("Start Screen");
		startScreen.setResizable(false); 
		startScreen.setVisible(true);
		startScreen.setDefaultCloseOperation(3); 
		
		
		while(!canContinue) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		startScreen.setVisible(false);
		populateBoard();
	}
	
	private void populateBoard() {
		
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new BoardButton(new Point(j, i));	
				
				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BoardButton clickedButton = (BoardButton) e.getSource();
						//first click?
						if(Game.clickedStart == null) {
							//is empty?
							if(Game.b.getBoard()[(int) clickedButton.getLocation().getY()][(int) clickedButton.getLocation().getX()] != null) {
								//is correct persons turn
								if(Game.b.getBoard()[(int) clickedButton.getLocation().getY()][(int) clickedButton.getLocation().getX()].isWhite() == Game.whiteTurn) {
									Game.clickedStart = clickedButton.getLocation();
									clickedButton.setBackground(Color.YELLOW);
									for(int i = 0; i < buttons.length; i++) {
										for(int j = 0; j < buttons.length; j++) {
											if(Game.b.getValidMoves(clickedButton.getLocation())[i][j]) {
												buttons[i][j].setBackground(Color.ORANGE);
											}
										}
									}
									System.out.println("\nstart = " + clickedButton.getLocation());
								}
							}
						}
						else {
							//are we clicking too fast
							if(Game.clickedStart != null && Game.clickedEnd == null) {
								//are the canceling first click?
								if(clickedButton.getLocation().equals(Game.clickedStart)) {
									Game.clickedStart = null;
								}
								else { 
									Game.clickedEnd = clickedButton.getLocation();
								}
								System.out.println("end = " + clickedButton.getLocation());
								for(int i = 0; i < buttons.length; i++) {
									for(int j = 0; j < buttons.length; j++) {
										if ((i+j) % 2 == 0)
											buttons[i][j].setBackground(Color.LIGHT_GRAY);
										else
											buttons[i][j].setBackground(Color.BLACK);
									}
								}
							}
							refreshPieces();
						}
					}
				});
				
				buttons[i][j].setSize(100, 100);
			    buttons[i][j].setFocusable(false);
			    if ((i+j) % 2 == 0)
					buttons[i][j].setBackground(Color.LIGHT_GRAY);
				else
		        	buttons[i][j].setBackground(Color.BLACK);
				
				innerBoard.add(buttons[i][j]);
			}
			
		}
		innerBoard.setLayout(new GridLayout(8,8));
		

		mainPanel.add(innerBoard, BorderLayout.CENTER);
		innerBoard.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.46), (int)(screenSize.getHeight()*0.92)));

		mainPanel.add(whiteBoard, BorderLayout.SOUTH);
		whiteBoard.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.46), (int)(screenSize.getHeight()*0.04)));
		whiteBoard.setBackground(Color.GREEN);
		
		mainPanel.add(blackBoard, BorderLayout.NORTH);
		blackBoard.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.46), (int)(screenSize.getHeight()*0.04)));
		blackBoard.setBackground(Color.BLACK);
		
		
		mainPanel.setSize((int)(screenSize.getWidth()*0.46), (int)(screenSize.getHeight()*0.92));
		mainPanel.setLocationRelativeTo(null);
		mainPanel.setVisible(true);
		mainPanel.setLayout(new BorderLayout()); 
		mainPanel.setDefaultCloseOperation(3); //ends program after closing window


	}  
	
	public void refreshPieces() {
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				if ((i+j) % 2 == 0)
					buttons[i][j].setBackground(Color.LIGHT_GRAY);
				else
					buttons[i][j].setBackground(Color.BLACK);

				if(board[i][j] != null) {
					String filePath = Character.isUpperCase(board[i][j].getChar()) ? "W" : "B";
					filePath += board[i][j].getChar() + ".png";
				    Image img = images.get(filePath);
				    
				    buttons[i][j].setIcon(new ImageIcon(img));
				}
				else {
					buttons[i][j].setIcon(null);
				}
				if(board[i][j] instanceof King && ((King)board[i][j]).isInCheck(board, new Point(j, i))) {
					buttons[i][j].setBackground(Color.RED);
				}
			}
		}
	}
	
	public void switchCurrentMovingPlayer() {
		whiteBoard.setBackground(Game.whiteTurn ? Color.GREEN : Color.BLACK);
		blackBoard.setBackground(Game.whiteTurn ? Color.BLACK : Color.GREEN);
		
	}

	public void showGameOverScreen(boolean whiteWon) {
		
		//disable the chess board until the piece is selected
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons.length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
		endScreen.setLayout(new BorderLayout());
		
		String text = "<html><div style='text-align: center;'>Game Over: White Won</div></html>";
		JLabel textArea = new JLabel(text);
	    textArea.setFocusable(false);
		textArea.setFont(new Font("Arial", 60, 60));
		textArea.setOpaque(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		
		startScreen.add(textArea, BorderLayout.PAGE_START);
		
		JButton restartButton = new JButton();
		restartButton.setBorderPainted(false);
		restartButton.setText("Play Again?");
		restartButton.setBackground(Color.GRAY);
	    restartButton.setFocusable(false);
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canContinue = true;
			}
		});
		endScreen.add(restartButton, BorderLayout.CENTER);

		JButton quitButton = new JButton();
		quitButton.setBorderPainted(false);
		quitButton.setText("Play Again?");
		quitButton.setBackground(Color.GRAY);
	    quitButton.setFocusable(false);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		endScreen.add(quitButton, BorderLayout.SOUTH);



		
		endScreen.setSize((int)(screenSize.getWidth()*0.31), (int)(screenSize.getHeight()*0.55)); 
		endScreen.setLocationRelativeTo(null);
		endScreen.setTitle("Game Over");
		endScreen.setResizable(false); 
		endScreen.setVisible(true);
		endScreen.setDefaultCloseOperation(3); 
		
		
		while(!canContinue) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		endScreen.setVisible(false);
		Game.restartGame();
	}
	
	public Piece showPawnPromotionMenu(boolean isWhite) {

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
			
			String filePath = isWhite ? "W" : "B";
			filePath += pieceType.getChar() + ".png";
			Image img = images.get(filePath);
			optionButtons[i].setIcon(new ImageIcon(img));
			
			promotionMenu.add(optionButtons[i]);
			
		}
		
		
	
		promotionMenu.setSize((int)(screenSize.getWidth()*0.31), (int)(screenSize.getHeight()*0.13)); 
		promotionMenu.setTitle("Promotion Menu");
		promotionMenu.setLayout(new GridLayout(1, 4));
		promotionMenu.setResizable(false); 
		promotionMenu.setLocationRelativeTo(null);
		promotionMenu.setVisible(true);
		promotionMenu.setDefaultCloseOperation(0); //if red x is pressed don't close menu
		
		while(!chosen) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
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

	private static BufferedImage resizeImages(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
	
	
}