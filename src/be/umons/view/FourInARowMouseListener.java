/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : FourInARowMouseListener.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 ***************************************************
 */

package be.umons.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.umons.model.AI;
import be.umons.model.FourInARow;
import be.umons.utility.Sound;

/**
 * <b> FourInARowMouseListener is the class that permit to play to a Four-In-ARow game </b>
 * 
 * @author AGOZZINO Terencio
 */

public class FourInARowMouseListener implements MouseListener {

	private JPanel panel;
	private JFrame frame;
	private int x, y;
	private FourInARow fiar;
	
	Sound sound1;
	Sound sound2;
	
	private boolean isClicked;
	private AI ai;
	private List<Object> list;
	private String player1;
	private String player2;
	boolean canPlay = true;
	public int result;
	public int result2;
	
	private JFourInARowBackGround fiarbgd;
	
	public ImageIcon P1 = null;
	public ImageIcon P2 = null;
	
	FourInARowMouseListener(JPanel panel, FourInARow fiar, List<Object> list, JFrame frame, JFourInARowBackGround fiarbgd, ImageIcon P1, ImageIcon P2) {
		this.panel = panel;
		this.frame = frame;
		this.fiar = fiar;
		this.ai = new AI(fiar); 
		this.list = list;
		this.player1 = (String) list.get(0);
		this.player2 = (String) list.get(1);
		this.fiarbgd = fiarbgd;
		this.P1 = P1;
		this.P2 = P2;
		fiar.setActualPlayer(0);
		if (player1 == "EASY AI")
			ai.easyAIFourInARow();
		
		if (player1 == "MEDIUM AI")
			ai.mediumAIFourInARow();
	
		if (player1 == "HARD AI")
			ai.hardAIFourInARow();
	}
	
	public void checkWinner() {

		if (fiar.checkWinner(fiar.getLastX(), fiar.getLastY(), fiar.getActualPlayer()) == 0) {
			new Thread(new Runnable() {
				public void run() {
					try { 
						Sound sound = new Sound("Ressource/Sound/end.mp3");
						sound.play();
					} catch (Exception ex) {
						System.out.println("File no found");
					}
				}
			}).start();
			JOptionPane.showMessageDialog (null, "Game is tied", "End", JOptionPane.INFORMATION_MESSAGE);
			canPlay = false;

			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					FourInARowGame frame = new FourInARowGame(list, P1, P2, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				FourInARowMenu frame2 = new FourInARowMenu(P1, P2);
				frame2.setVisible(true);
			}
		}

		if (fiar.checkWinner(fiar.getLastX(), fiar.getLastY(), fiar.getActualPlayer()) == 1) {
			if (fiar.getActualPlayer() == 0) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player1 + " won the game with his horizontal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result += 1;
				fiarbgd.setResult(result);
			}
			
			if (fiar.getActualPlayer() == 1) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player2 + " won the game with his horizontal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result2 += 1;
				fiarbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					FourInARowGame frame = new FourInARowGame(list, P1, P2, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				FourInARowMenu frame2 = new FourInARowMenu(P1, P2);
				frame2.setVisible(true);
			}	
		}

		if (fiar.checkWinner(fiar.getLastX(), fiar.getLastY(), fiar.getActualPlayer()) == 2) {
			if (fiar.getActualPlayer() == 0) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player1 + " won the game with his vertical alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result += 1;
				fiarbgd.setResult(result);
			}
			
			if (fiar.getActualPlayer() == 1) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player2 + " won the game with his vertical alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result2 += 1;
				fiarbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					FourInARowGame frame = new FourInARowGame(list, P1, P2, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				FourInARowMenu frame2 = new FourInARowMenu(P1, P2);
				frame2.setVisible(true);
			}	
		}


		if (fiar.checkWinner(fiar.getLastX(), fiar.getLastY(), fiar.getActualPlayer()) == 3) {
			
			if (fiar.getActualPlayer() == 0) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player1 + " won the game with his first diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result += 1;
				fiarbgd.setResult(result);
			}
			
			if (fiar.getActualPlayer() == 1) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player2 + " won the game with his first diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result2 += 1;
				fiarbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					FourInARowGame frame = new FourInARowGame(list, P1, P2, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				FourInARowMenu frame2 = new FourInARowMenu(P1, P2);
				frame2.setVisible(true);
			}	
		}



		if (fiar.checkWinner(fiar.getLastX(), fiar.getLastY(), fiar.getActualPlayer()) == 4) {
			
			if (fiar.getActualPlayer() == 0) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player1 + " won the game with his second diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result += 1;
				fiarbgd.setResult(result);
			}
			
			if (fiar.getActualPlayer() == 1) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/end.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
				JOptionPane.showMessageDialog (null, player2 + " won the game with his second diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				canPlay = false;
				result2 += 1;
				fiarbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					FourInARowGame frame = new FourInARowGame(list, P1, P2, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				FourInARowMenu frame2 = new FourInARowMenu(P1, P2);
				frame2.setVisible(true);
			}	
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void jeCheck() {
		if (player1 == "EASY AI") {
			ai.easyAIFourInARow();
		}
		
		if (player1 == "MEDIUM AI") {
			ai.mediumAIFourInARow();
		}
		
		if (player1 == "HARD AI") {
			ai.hardAIFourInARow();
		}	
	}
	
	public void jeCheck2() {
		if (player2 == "EASY AI") {
			ai.easyAIFourInARow();
		}
		
		if (player2 == "MEDIUM AI") {
			ai.mediumAIFourInARow();
		}
		
		if (player2 == "HARD AI") {
			ai.hardAIFourInARow();
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();		
		isClicked = false;	
		int row = 5;

		if (canPlay == true) {
			if (y > 27 && y < 312) {
				if (x > 18 && x < 76) {
					if (fiar.getGameTable()[0][0] == 2) {
						if (fiar.getGameTable()[row][0] == 2) {
							fiar.getGameTable()[row][0] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(0);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][0] != 2)
								row--;
							fiar.getGameTable()[row][0] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(0);
							panel.repaint();
							isClicked = true;	
						}
					}
				}

				if (x > 76 && x < 134) {
					if (fiar.getGameTable()[0][1] == 2) {
						if (fiar.getGameTable()[row][1] == 2) {
							fiar.getGameTable()[row][1] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(1);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][1] != 2 && fiar.getGameTable()[0][1] == 2)
								row--;
							fiar.getGameTable()[row][1] = fiar.getActualPlayer();
							panel.repaint();
							isClicked = true;	
						}
					}
				}

				if (x > 134 && x < 192) {
					if (fiar.getGameTable()[0][2] == 2) {
						if (fiar.getGameTable()[row][2] == 2) {
							fiar.getGameTable()[row][2] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(2);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][2] != 2 && fiar.getGameTable()[0][2] == 2)
								row--;
							fiar.getGameTable()[row][2] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(2);
							panel.repaint();
							isClicked = true;	
						}
					}
				}

				if (x > 192 && x < 250) {
					if (fiar.getGameTable()[0][3] == 2) {
						if (fiar.getGameTable()[row][3] == 2) {
							fiar.getGameTable()[row][3] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(3);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][3] != 2 && fiar.getGameTable()[0][3] == 2)
								row--;
							fiar.getGameTable()[row][3] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(3);
							panel.repaint();
							isClicked = true;	
						}
					}
				}

				if (x > 250 && x < 308) {
					if (fiar.getGameTable()[0][4] == 2) {
						if (fiar.getGameTable()[row][4] == 2) {
							fiar.getGameTable()[row][4] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(4);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][4] != 2 && fiar.getGameTable()[0][4] == 2)
								row--;
							fiar.getGameTable()[row][4] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(4);
							panel.repaint();
							isClicked = true;	
						}
					}
				}

				if (x > 308 && x < 360) {
					if (fiar.getGameTable()[0][5] == 2) {
						if (fiar.getGameTable()[row][5] == 2) {
							fiar.getGameTable()[row][5] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(5);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][5] != 2 && fiar.getGameTable()[0][5] == 2)
								row--;
							fiar.getGameTable()[row][5] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(5);
							panel.repaint();
							isClicked = true;	
						}
					}
				}

				if (x > 360 && x < 418) {
					if (fiar.getGameTable()[0][6] == 2) {
						if (fiar.getGameTable()[row][6] == 2) {
							fiar.getGameTable()[row][6] = fiar.getActualPlayer();
							fiar.setLastX(row);
							fiar.setLastY(6);
							panel.repaint();
							isClicked = true;
						}
	
						else {
							while (fiar.getGameTable()[row][6] != 2 && fiar.getGameTable()[0][6] == 2)
								row--;
							fiar.getGameTable()[row][6] = fiar.getActualPlayer();
							panel.repaint();
							fiar.setLastX(row);
							fiar.setLastY(6);
							isClicked = true;					
						}
					}
				}
			}
		}
		
		if (e.getButton() == MouseEvent.BUTTON1 && isClicked == true) {	
			if (fiar.getActualPlayer() == 0) {
	            new Thread(new Runnable() {
	                public void run() {
	                    try { 
	                		sound1 = new Sound("Ressource/Sound/P1.mp3");
	                    	sound1.play();
	                    } catch (Exception ex) {}
	                }
	            }).start();
			}

			else {
	            new Thread(new Runnable() {
	                public void run() {
	                    try { 
	                		sound2 = new Sound("Ressource/Sound/P2.mp3");
	                    	sound2.play();
	                    } catch (Exception ex) {}
	                }
	            }).start();
			}		
			checkWinner();
			fiar.changePlayer();
			if (fiar.getActualPlayer() == 0) {
				jeCheck();
			}
			
			if (fiar.getActualPlayer() == 1) {
				jeCheck2();
			}
			panel.repaint();	
		}   
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}