/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : OthelloMouseListener.java
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
import be.umons.model.Othello;
import be.umons.utility.Sound;

/**
 * <b> OthelloMouseListener is the class that permit to play to a Othello game. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class OthelloMouseListener implements MouseListener {

	private JPanel panel;
	private JFrame frame;
	private int x, y;
	private Othello othello;
	
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
	
	private JOthelloBackGround othellobgd;
	
	public ImageIcon pawn1 = null;
	public ImageIcon pawn2 = null;

	OthelloMouseListener(JPanel panel, Othello othello, List<Object> list, JFrame frame, JOthelloBackGround tttbgd, ImageIcon pawn1, ImageIcon pawn2) {
		this.panel = panel;
		this.frame = frame;
		this.othello = othello;
		this.ai = new AI(othello); 
		this.list = list;
		this.player1 = (String) list.get(0);
		this.player2 = (String) list.get(1);
		this.othellobgd = othellobgd;
		this.pawn1 = pawn1;
		this.pawn2 = pawn2;
		othello.setActualPlayer(0);
		othello.arrayGenerator();
		if (player1 == "EASY AI")
			ai.easyAIOthello();
		
		if (player1 == "MEDIUM AI")
			ai.mediumAIOthello();
	
		if (player1 == "HARD AI")
			ai.hardAIOthello();		
	}
	

	public void checkWinner() {
		if (othello.checkWinner() == 0) {
			JOptionPane.showMessageDialog (null, "Game is tied", "End", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (othello.checkWinner() == othello.countplayer1) {
			JOptionPane.showMessageDialog (null, player1 + " won the game with " + othello.countplayer1 + " points", "End", JOptionPane.INFORMATION_MESSAGE);
		}
			
		if (othello.checkWinner() == othello.countplayer2) {
			JOptionPane.showMessageDialog (null, player2 + " won the game with " + othello.countplayer2 + " points", "End", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();

		if (y > 0 && y < 39) {
			
			if (x > 12 && x < 51) {
				othello.setLastX(0);
				othello.setLastY(0);
				if (othello.getGameTable()[0][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(0);
				othello.setLastY(1);
				if (othello.getGameTable()[0][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(0);
				othello.setLastY(2);
				if (othello.getGameTable()[0][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 129 && x < 168) {
				othello.setLastX(0);
				othello.setLastY(3);
				if (othello.getGameTable()[0][3] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][3] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 168 && x < 207) {
				othello.setLastX(0);
				othello.setLastY(4);
				if (othello.getGameTable()[0][4] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][4] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(0);
				othello.setLastY(5);
				if (othello.getGameTable()[0][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(0);
				othello.setLastY(6);
				if (othello.getGameTable()[0][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(0);
				othello.setLastY(7);
				if (othello.getGameTable()[0][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[0][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

		if (y > 39 && y < 78) {
			if (x > 12 && x < 51) {
				othello.setLastX(1);
				othello.setLastY(0);
				if (othello.getGameTable()[1][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(1);
				othello.setLastY(1);
				if (othello.getGameTable()[1][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(1);
				othello.setLastY(2);
				if (othello.getGameTable()[1][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 129 && x < 168) {
				othello.setLastX(1);
				othello.setLastY(3);
				if (othello.getGameTable()[1][3] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][3] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 168 && x < 207) {
				othello.setLastX(1);
				othello.setLastY(4);
				if (othello.getGameTable()[1][4] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][4] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(1);
				othello.setLastY(5);
				if (othello.getGameTable()[1][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(1);
				othello.setLastY(6);
				if (othello.getGameTable()[1][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(1);
				othello.setLastY(7);
				if (othello.getGameTable()[1][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[1][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

		if (y > 78 && y < 117) {
			
			if (x > 12 && x < 51) {
				othello.setLastX(2);
				othello.setLastY(0);
				if (othello.getGameTable()[2][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(2);
				othello.setLastY(1);
				if (othello.getGameTable()[2][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(2);
				othello.setLastY(2);
				if (othello.getGameTable()[2][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 129 && x < 168) {
				othello.setLastX(2);
				othello.setLastY(3);
				if (othello.getGameTable()[2][3] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][3] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 168 && x < 207) {
				othello.setLastX(2);
				othello.setLastY(4);
				if (othello.getGameTable()[2][4] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][4] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(2);
				othello.setLastY(5);
				if (othello.getGameTable()[2][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(2);
				othello.setLastY(6);
				if (othello.getGameTable()[2][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(2);
				othello.setLastY(7);
				if (othello.getGameTable()[2][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[2][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

		if (y > 117 && y < 156) {
			othello.setLastX(3);
			othello.setLastY(0);
			if (x > 12 && x < 51) {
				if (othello.getGameTable()[3][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[3][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(3);
				othello.setLastY(1);
				if (othello.getGameTable()[3][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[3][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(3);
				othello.setLastY(2);
				if (othello.getGameTable()[3][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[3][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(3);
				othello.setLastY(5);
				if (othello.getGameTable()[3][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[3][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(3);
				othello.setLastY(6);
				if (othello.getGameTable()[3][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[3][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(3);
				othello.setLastY(7);
				if (othello.getGameTable()[3][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[3][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

		if (y > 156 && y < 195) {
			if (x > 12 && x < 51) {
				othello.setLastX(4);
				othello.setLastY(0);
				if (othello.getGameTable()[4][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[4][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(4);
				othello.setLastY(1);
				if (othello.getGameTable()[4][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[4][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(4);
				othello.setLastY(2);
				if (othello.getGameTable()[4][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[4][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(4);
				othello.setLastY(5);
				if (othello.getGameTable()[4][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[4][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(4);
				othello.setLastY(6);
				if (othello.getGameTable()[4][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[4][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(4);
				othello.setLastY(7);
				if (othello.getGameTable()[4][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[4][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

		if (y > 195 && y < 234) {
			if (x > 12 && x < 51) {
				othello.setLastX(5);
				othello.setLastY(0);
				if (othello.getGameTable()[5][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(5);
				othello.setLastY(1);
				if (othello.getGameTable()[5][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(5);
				othello.setLastY(2);
				if (othello.getGameTable()[5][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 129 && x < 168) {
				othello.setLastX(5);
				othello.setLastY(3);
				if (othello.getGameTable()[5][3] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][3] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 168 && x < 207) {
				othello.setLastX(5);
				othello.setLastY(4);
				if (othello.getGameTable()[5][4] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][4] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(5);
				othello.setLastY(5);
				if (othello.getGameTable()[5][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(5);
				othello.setLastY(6);
				if (othello.getGameTable()[5][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(5);
				othello.setLastY(7);
				if (othello.getGameTable()[5][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[5][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

		if (y > 234 && y < 273) {
			if (x > 12 && x < 51) {
				othello.setLastX(6);
				othello.setLastY(0);
				if (othello.getGameTable()[6][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][0] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 51 && x < 90) {
				othello.setLastX(6);
				othello.setLastY(1);
				if (othello.getGameTable()[6][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][1] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 90 && x < 129) {
				othello.setLastX(6);
				othello.setLastY(2);
				if (othello.getGameTable()[6][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][2] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 129 && x < 168) {
				othello.setLastX(6);
				othello.setLastY(3);
				if (othello.getGameTable()[6][3] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][3] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 168 && x < 207) {
				othello.setLastX(6);
				othello.setLastY(4);
				if (othello.getGameTable()[6][4] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][4] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 207 && x < 246) {
				othello.setLastX(6);
				othello.setLastY(5);
				if (othello.getGameTable()[6][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][5] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 246 && x < 285) {
				othello.setLastX(6);
				othello.setLastY(6);
				if (othello.getGameTable()[6][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][6] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}

			if (x > 285 && x < 324) {
				othello.setLastX(6);
				othello.setLastY(7);
				if (othello.getGameTable()[6][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
					othello.getGameTable()[6][7] = othello.getActualPlayer();
					panel.repaint();
					isClicked = true;
				}
			}
		}

			if (y > 273 && y < 312) {
				if (x > 12 && x < 51) {
					othello.setLastX(7);
					othello.setLastY(0);
					if (othello.getGameTable()[7][0] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][0] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 51 && x < 90) {
					othello.setLastX(7);
					othello.setLastY(1);
					if (othello.getGameTable()[7][1] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][1] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 90 && x < 129) {
					othello.setLastX(7);
					othello.setLastY(2);
					if (othello.getGameTable()[7][2] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][2] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 129 && x < 168) {
					othello.setLastX(7);
					othello.setLastY(3);
					if (othello.getGameTable()[7][3] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][3] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 168 && x < 207) {
					othello.setLastX(7);
					othello.setLastY(4);
					if (othello.getGameTable()[7][4] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][4] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 207 && x < 246) {
					othello.setLastX(7);
					othello.setLastY(5);
					if (othello.getGameTable()[7][5] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][5] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 246 && x < 285) {
					othello.setLastX(7);
					othello.setLastY(6);
					if (othello.getGameTable()[7][6] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][6] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}

				if (x > 285 && x < 324) {
					othello.setLastX(7);
					othello.setLastY(7);
					if (othello.getGameTable()[7][7] == 2 && othello.basisCheck(othello.getLastX(), othello.getLastY(), othello.getActualPlayer())) {
						othello.getGameTable()[7][7] = othello.getActualPlayer();
						panel.repaint();
						isClicked = true;
					}
				}
			}
			
			if (e.getButton() == MouseEvent.BUTTON1 && isClicked == true) {	
				if (othello.getActualPlayer() == 0) {
		            new Thread(new Runnable() {
		                public void run() {
		                    try { 
		                		sound1 = new Sound("Ressource/Sound/black.mp3");
		                    	sound1.play();
		                    } catch (Exception ex) {}
		                }
		            }).start();
				}

				else {
		            new Thread(new Runnable() {
		                public void run() {
		                    try { 
		                		sound2 = new Sound("Ressource/Sound/white.mp3");
		                    	sound2.play();
		                    } catch (Exception ex) {}
		                }
		            }).start();
				}	
				
				othello.converter(othello.getLastX(), othello.getLastY(), othello.getActualPlayer());
				panel.repaint();
				checkWinner();
				othello.changePlayer();
			}  
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}