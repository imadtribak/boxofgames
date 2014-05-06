package be.umons.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import be.umons.model.FourInARow;

public class FourInARowMouseListener implements MouseListener {

	private JPanel panel;
	private int x, y;
	private FourInARow fiar;
	
	FourInARowMouseListener(JPanel panel, FourInARow fiar) {
		this.panel = panel;
		this.fiar = fiar;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		if (y > 40 && y < 312) {

			if (x > 18 && x < 76) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][0] = 0;
					System.out.println("ZONE 1 X");
				}
				else {
					fiar.getGameTable()[0][0] = 1;
					System.out.println("ZONE 1 O");
				}
			}

			if (x > 76 && x < 134) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][1] = 0;
					System.out.println("ZONE 2 X");
				}
				else {
					fiar.getGameTable()[0][1] = 1;
					System.out.println("ZONE 2 O");
				}
			}

			if (x > 134 && x < 192) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][2] = 0;
					System.out.println("ZONE 3 X");
				}
				else {
					fiar.getGameTable()[0][2] = 1;
					System.out.println("ZONE 3 O");
				}
			}
				
			if (x > 192 && x < 250) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][2] = 0;
					System.out.println("ZONE 4 X");
				}
				else {
					fiar.getGameTable()[0][2] = 1;
					System.out.println("ZONE 4 O");
				}
			}
			
			if (x > 250 && x < 308) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][2] = 0;
					System.out.println("ZONE 5 X");
				}
				else {
					fiar.getGameTable()[0][2] = 1;
					System.out.println("ZONE 5 O");
				}
			}
			
			if (x > 308 && x < 360) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][2] = 0;
					System.out.println("ZONE 6 X");
				}
				else {
					fiar.getGameTable()[0][2] = 1;
					System.out.println("ZONE 6 O");
				}
			}
			
			if (x > 360 && x < 418) {
				if (fiar.getActualPlayer() == 0) {
					fiar.getGameTable()[0][2] = 0;
					System.out.println("ZONE 7 X");
				}
				else {
					fiar.getGameTable()[0][2] = 1;
					System.out.println("ZONE 7 O");
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