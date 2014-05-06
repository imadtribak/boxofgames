package be.umons.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.JPanel;

import be.umons.model.TicTacToe;
import be.umons.utility.Sound;

public class TicTacToeMouseListener extends Observable implements MouseListener {

	private JPanel panel;
	private int x, y;
	private TicTacToe ttt;
	private Sound sound;
	
	TicTacToeMouseListener(JPanel panel, TicTacToe ttt) {
		this.panel = panel;
		this.ttt = ttt;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		if (y < 94) {

			if (x < 158) {
				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[0][0] = 0;
				}
				else {
					ttt.getGameTable()[0][0] = 1;
					
				}
			}

			if (x > 158 && x < 316) {
				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[0][1] = 0;
				}
				else {
					ttt.getGameTable()[0][1] = 1;
				}
			}

			if (x >= 316 && x <= 400) {
				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[0][2] = 0;
				}
				else {
					ttt.getGameTable()[0][2] = 1;
				}
			}
		}

		if (y > 94 && y < 189) {

			if (x < 158) {
				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[1][0] = 0;;
				}
				else {
					ttt.getGameTable()[1][0] = 1;;
				}
			}

			if (x > 158 && x < 316) {

				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[1][1] = 0;
				}

				else {
					ttt.getGameTable()[1][1] = 1;
				}
			}

			if (x > 316 && x < 474) {

				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[1][2] = 0;
				}

				else {
					ttt.getGameTable()[1][2] = 1;
				}
			}
		}

		if (y > 189 && y < 289) {

			if (x < 158) {

				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[2][0] = 0;
				}

				else {
					ttt.getGameTable()[2][0] = 1;
				}

			}

			if (x > 158 && x < 316) {

				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[2][1] = 0;

				}

				else {
					ttt.getGameTable()[2][1] = 1;
				}
			}

			if (x > 316 && x < 474) {

				if (ttt.getActualPlayer() == 0) {
					ttt.getGameTable()[2][2] = 0;
				}

				else {
					ttt.getGameTable()[2][2] = 1;
				}
			}
		}
		
		if (ttt.getActualPlayer() == 0) {
			try {
				sound = new Sound("Ressource/Sound/X.mp3");
				sound.play();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		
		try {
			sound = new Sound("Ressource/Sound/O.mp3");
			sound.play();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel.repaint();
		setChanged();
		notifyObservers();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}