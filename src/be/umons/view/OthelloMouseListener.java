package be.umons.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import be.umons.model.Othello;

public class OthelloMouseListener implements MouseListener {

	private JPanel panel;
	private int x, y;
	private Othello othello;

	OthelloMouseListener(JPanel panel, Othello othello) {
		this.panel = panel;
		this.othello = othello;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][0] = 0;
				}
				else {
					othello.getGameTable()[0][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][1] = 0;
				}
				else {
					othello.getGameTable()[0][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][2] = 0;
				}
				else {
					othello.getGameTable()[0][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][3] = 0;
				}
				else {
					othello.getGameTable()[0][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][4] = 0;
				}
				else {
					othello.getGameTable()[0][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][5] = 0;
				}
				else {
					othello.getGameTable()[0][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][6] = 0;
			}
				else {
					othello.getGameTable()[0][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[0][7] = 0;
				}
				else {
					othello.getGameTable()[0][7] = 1;
				}
			}
		}

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][0] = 0;
				}
				else {
					othello.getGameTable()[1][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][1] = 0;
				}
				else {
					othello.getGameTable()[1][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][2] = 0;
				}
				else {
					othello.getGameTable()[1][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][3] = 0;
				}
				else {
					othello.getGameTable()[1][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][4] = 0;
				}
				else {
					othello.getGameTable()[1][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][5] = 0;
				}
				else {
					othello.getGameTable()[1][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][6] = 0;
				}
				else {
					othello.getGameTable()[1][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[1][7] = 0;

				}
				else {
					othello.getGameTable()[1][7] = 1;
				}
			}
		}

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][0] = 0;
				}
				else {
					othello.getGameTable()[2][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][1] = 0;
				}
				else {
					othello.getGameTable()[2][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][2] = 0;
				}
				else {
					othello.getGameTable()[2][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][3] = 0;
				}
				else {
					othello.getGameTable()[2][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][4] = 0;
				}
				else {
					othello.getGameTable()[2][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][5] = 0;
				}
				else {
					othello.getGameTable()[2][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][6] = 0;
				}
				else {
					othello.getGameTable()[2][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[2][7] = 0;
				}
				else {
					othello.getGameTable()[2][7] = 1;
				}
			}
		}

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][0] = 0;
				}
				else {
					othello.getGameTable()[3][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][1] = 0;
				}
				else {
					othello.getGameTable()[3][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][2] = 0;
				}
				else {
					othello.getGameTable()[3][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][3] = 0;
				}
				else {
					othello.getGameTable()[3][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][4] = 0;
				}
				else {
					othello.getGameTable()[3][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][5] = 0;
				}
				else {
					othello.getGameTable()[3][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][6] = 0;
				}
				else {
					othello.getGameTable()[3][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[3][7] = 0;
				}
				else {
					othello.getGameTable()[3][7] = 1;
				}
			}
		}

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][0] = 0;
				}
				else {
					othello.getGameTable()[4][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][1] = 0;
				}
				else {
					othello.getGameTable()[4][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][2] = 0;
				}
				else {
					othello.getGameTable()[4][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][3] = 0;
				}
				else {
					othello.getGameTable()[4][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][4] = 0;
				}
				else {
					othello.getGameTable()[4][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][5] = 0;
				}
				else {
					othello.getGameTable()[4][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][6] = 0;
				}
				else {
					othello.getGameTable()[4][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[4][7] = 0;
				}
				else {
					othello.getGameTable()[4][7] = 1;
				}
			}
		}

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][0] = 0;
				}
				else {
					othello.getGameTable()[5][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][1] = 0;
				}
				else {
					othello.getGameTable()[5][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][2] = 0;
				}
				else {
					othello.getGameTable()[5][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][3] = 0;
				}
				else {
					othello.getGameTable()[5][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][4] = 0;
				}
				else {
					othello.getGameTable()[5][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][5] = 0;
				}
				else {
					othello.getGameTable()[5][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][6] = 0;
				}
				else {
					othello.getGameTable()[5][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[5][7] = 0;
				}
				else {
					othello.getGameTable()[5][7] = 1;
				}
			}
		}

		if (y < 94) {

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][0] = 0;
				}
				else {
					othello.getGameTable()[6][0] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][1] = 0;
				}
				else {
					othello.getGameTable()[6][1] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][2] = 0;
				}
				else {
					othello.getGameTable()[6][2] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][3] = 0;
				}
				else {
					othello.getGameTable()[6][3] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][4] = 0;
				}
				else {
					othello.getGameTable()[6][4] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][5] = 0;
				}
				else {
					othello.getGameTable()[6][5] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][6] = 0;
				}
				else {
					othello.getGameTable()[6][6] = 1;
				}
			}

			if (x < 158) {
				if (othello.getActualPlayer() == 0) {
					othello.getGameTable()[6][7] = 0;
				}
				else {
					othello.getGameTable()[6][7] = 1;
				}
			}

			if (y < 94) {

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][0] = 0;
					}
					else {
						othello.getGameTable()[7][0] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][1] = 0;
					}
					else {
						othello.getGameTable()[7][1] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][2] = 0;

					}
					else {
						othello.getGameTable()[7][2] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][3] = 0;
					}
					else {
						othello.getGameTable()[7][3] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][4] = 0;
					}
					else {
						othello.getGameTable()[7][4] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][5] = 0;
					}
					else {
						othello.getGameTable()[7][5] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][6] = 0;
					}
					else {
						othello.getGameTable()[7][6] = 1;
					}
				}

				if (x < 158) {
					if (othello.getActualPlayer() == 0) {
						othello.getGameTable()[7][7] = 0;
					}
					else {
						othello.getGameTable()[7][7] = 1;
					}
				}
			}
		}
		panel.repaint();	
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