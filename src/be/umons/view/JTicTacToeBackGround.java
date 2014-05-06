package be.umons.view;

import be.umons.model.TicTacToe;
import be.umons.utility.Sound;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class JTicTacToeBackGround extends JPanel implements Observer {

	private JFrame frame;

	Image X = null;
	Image O = null;
	
	List<Object> list = new ArrayList<Object>();
	TicTacToe ttt = new TicTacToe(list);

	public JTicTacToeBackGround(JFrame frame) {
		this.frame = frame;
		this.setBounds((frame.getSize().width - 474)/2, (frame.getSize().height - 289)/2, 474, 289);
		
		try {
			X = ImageIO.read(new File("Ressource/Games/TicTacToe/XBig.png"));
			O = ImageIO.read(new File("Ressource/Games/TicTacToe/OBig.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/TicTacToe/gameboard.png");
		panel.add(this);
		this.addMouseListener(new TicTacToeMouseListener(this, ttt));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ttt.getNRows(); i++) { 
			for (int j = 0; j < ttt.getNColumns(); j++) {
				if (ttt.getGameTable()[i][j] == 0) {
					g.drawImage(X, (550) / 3 * j, (250) / 3 * i, null);
				}

				if (ttt.getGameTable()[i][j] == 1) {
						g.drawImage(O, (550) / 3 * j, (250) / 3 * i, null);
	
				}

			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}