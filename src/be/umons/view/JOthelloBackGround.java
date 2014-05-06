package be.umons.view;

import be.umons.model.Othello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;

public class JOthelloBackGround extends JPanel {
	
	private JFrame frame;
	
	Image black = null;
	Image white = null;
	
	List<Object> list = new ArrayList<Object>();
	Othello othello = new Othello(list);
	
	public JOthelloBackGround(JFrame frame) {
		this.frame = frame;
		this.setBounds((frame.getSize().width - 474)/2, (frame.getSize().height - 289)/2, 474, 289);
		
		try {
			black = ImageIO.read(new File("Ressource/Games/Othello/Black.png"));
			white = ImageIO.read(new File("Ressource/Games/Othello/White.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/Othello/gameboard.png");
        panel.add(this);				
		this.addMouseListener(new OthelloMouseListener(this, othello));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < othello.getNRows(); i++) { 
			for (int j = 0; j < othello.getNColumns(); j++) {
				if (othello.getGameTable()[i][j] == 0)
					g.drawImage(black, (550) / 3 * j, (250) / 3 * i, null);

				if (othello.getGameTable()[i][j] == 1)
						g.drawImage(white, (550) / 3 * j, (250) / 3 * i, null);
			}
		}
	}
}