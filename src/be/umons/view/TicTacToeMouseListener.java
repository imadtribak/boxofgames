/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : TicTacToeMouseListener.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 ***************************************************
 */

package be.umons.view;

import java.awt.event.MouseEvent;

import be.umons.view.JTicTacToeBackGround;

import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.umons.model.AI;
import be.umons.model.TicTacToe;
import be.umons.utility.Sound;

/**
 * <b> TicTacToeMouseListener is the class that permit to play to a TicTacToe game </b>
 * 
 * @author AGOZZINO Terencio
 */

public class TicTacToeMouseListener implements MouseListener {

	private JPanel panel;
	private JFrame frame;
	private int x, y;
	private TicTacToe ttt;
	
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
	
	private JTicTacToeBackGround tttbgd;
	
	public ImageIcon X = null;
	public ImageIcon O = null;
	
	TicTacToeMouseListener(JPanel panel, TicTacToe ttt, List<Object> list, JFrame frame, JTicTacToeBackGround tttbgd, ImageIcon X, ImageIcon O) {
		this.panel = panel;
		this.frame = frame;
		this.ttt = ttt;
		this.ai = new AI(ttt); 
		this.list = list;
		this.player1 = (String) list.get(0);
		this.player2 = (String) list.get(1);
		this.tttbgd = tttbgd;
		this.X = X;
		this.O = O;
		ttt.setActualPlayer(0);
		if (player1 == "EASY AI")
			ai.easyAITicTacToe();
		
		if (player1 == "MEDIUM AI")
			ai.mediumAITicTacToe();
	
		if (player1 == "HARD AI")
			ai.hardAITicTacToe();
	}
	
	public void checkWinner() {
		
		if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 0) {
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
					TicTacToeGame frame = new TicTacToeGame(list, X, O, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				TicTacToeMenu frame2 = new TicTacToeMenu(X, O);
				frame2.setVisible(true);
			}
		}
		
		if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 1) {
			if (ttt.getActualPlayer() == 0) {
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
				tttbgd.setResult(result);
			}
			
			if (ttt.getActualPlayer() == 1) {
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
				tttbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					TicTacToeGame frame = new TicTacToeGame(list, X, O, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				TicTacToeMenu frame2 = new TicTacToeMenu(X, O);
				frame2.setVisible(true);
			}
		}

		if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 2) {
			if (ttt.getActualPlayer() == 0) {
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
				tttbgd.setResult(result);
			}
				
			if (ttt.getActualPlayer() == 1) {
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
				tttbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					TicTacToeGame frame = new TicTacToeGame(list, X, O, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				TicTacToeMenu frame2 = new TicTacToeMenu(X, O);
				frame2.setVisible(true);
			}
		}

		if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 3) {
			if (ttt.getActualPlayer() == 0) {
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
				tttbgd.setResult(result);
			}
			
			if (ttt.getActualPlayer() == 1) {
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
				tttbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					TicTacToeGame frame = new TicTacToeGame(list, X, O, result2, result);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				TicTacToeMenu frame2 = new TicTacToeMenu(X, O);
				frame2.setVisible(true);
			}
		}


		if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 4) {
			if (ttt.getActualPlayer() == 0) {
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
				tttbgd.setResult(result);
			}
			
			if (ttt.getActualPlayer() == 1) {
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
				tttbgd.setResult2(result2);
			}
			
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want to play again ?",
					"Replay", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				frame.dispose();
				try {
					list.set(0, player2);
					list.set(1, player1);
					TicTacToeGame frame = new TicTacToeGame(list, X, O, result, result2);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				frame.dispose();
				TicTacToeMenu frame2 = new TicTacToeMenu(X, O);
				frame2.setVisible(true);
			}
		}
	}
	
	public void jeCheck() {
		if (player1 == "EASY AI") {
			ai.easyAITicTacToe();
		}
		
		if (player1 == "MEDIUM AI") {
			ai.mediumAITicTacToe();
		}
		
		if (player1 == "HARD AI") {
			ai.hardAITicTacToe();
		}	
	}
	
	public void jeCheck2() {
		if (player2 == "EASY AI") {
			ai.easyAITicTacToe();
		}
		
		if (player2 == "MEDIUM AI") {
			ai.mediumAITicTacToe();
		}
		
		if (player2 == "HARD AI") {
			ai.hardAITicTacToe();
		}	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		isClicked = false;
		
		if (canPlay == true) {
			if (y < 94) {
				if (x < 142) {
					ttt.setLastX(0);
					ttt.setLastY(0);
					if (ttt.getGameTable()[0][0] == 2) {
						ttt.getGameTable()[0][0] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 156 && x < 320) {
					ttt.setLastX(0);
					ttt.setLastY(1);
					if (ttt.getGameTable()[0][1] == 2) {
						ttt.getGameTable()[0][1] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 338 && x < 447) {
					ttt.setLastX(0);
					ttt.setLastY(2);
					if (ttt.getGameTable()[0][2] == 2) {
						ttt.getGameTable()[0][2] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}
			}

			if (y > 94 && y < 189) {

				if (x < 142) {
					ttt.setLastX(1);
					ttt.setLastY(0);
					if (ttt.getGameTable()[1][0] == 2) {
						ttt.getGameTable()[1][0] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 156 && x < 320) {
					ttt.setLastX(1);
					ttt.setLastY(1);
					if (ttt.getGameTable()[1][1] == 2) {
						ttt.getGameTable()[1][1] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 338 && x < 447) {
					ttt.setLastX(1);
					ttt.setLastY(2);
					if (ttt.getGameTable()[1][2] == 2)  {
						ttt.getGameTable()[1][2] = ttt.getActualPlayer();
						panel.repaint();				
						isClicked = true;
					}
				}
			}

			if (y > 189 && y < 289) {

				if (x < 142) {
					ttt.setLastX(2);
					ttt.setLastY(0);
					if (ttt.getGameTable()[2][0] == 2)  {
						ttt.getGameTable()[2][0] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 156 && x < 320) {
					ttt.setLastX(2);
					ttt.setLastY(1);
					if (ttt.getGameTable()[2][1] == 2) {
						ttt.getGameTable()[2][1] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 338 && x < 447) {
					ttt.setLastX(2);
					ttt.setLastY(2);
					if (ttt.getGameTable()[2][2] == 2) {
						ttt.getGameTable()[2][2] = ttt.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}
			}
		}

		if (e.getButton() == MouseEvent.BUTTON1 && isClicked == true) {	
			if (ttt.getActualPlayer() == 0) {
	            new Thread(new Runnable() {
	                public void run() {
	                    try { 
	                		sound1 = new Sound("Ressource/Sound/X.mp3");
	                    	sound1.play();
	                    } catch (Exception ex) {}
	                }
	            }).start();
			}

			else {
	            new Thread(new Runnable() {
	                public void run() {
	                    try { 
	                		sound2 = new Sound("Ressource/Sound/O.mp3");
	                    	sound2.play();
	                    } catch (Exception ex) {}
	                }
	            }).start();
			}		
			checkWinner();
			ttt.changePlayer();
			if (ttt.getActualPlayer() == 0) {
				jeCheck();
			}
			
			if (ttt.getActualPlayer() == 1) {
				jeCheck2();
			}
			panel.repaint();		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}