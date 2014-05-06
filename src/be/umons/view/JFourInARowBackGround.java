package be.umons.view;

import be.umons.model.FourInARow;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;

public class JFourInARowBackGround extends JPanel {

	private JFrame frame;

	Image red = null;
	Image yellow = null;
		
	List<Object> list = new ArrayList<Object>();
	FourInARow fiar = new FourInARow(list);

	public JFourInARowBackGround(JFrame frame) {
		this.frame = frame;
		this.setBounds((frame.getSize().width - 436)/2, (frame.getSize().height - 520)/2, 433, 273);
		
		try {
			red = ImageIO.read(new File("Ressource/Games/FourInARow/red.png"));
			yellow = ImageIO.read(new File("Ressource/Games/FourInARow/yellow.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/FourInARow/gameboard.png");
		panel.add(this);				
		this.addMouseListener(new FourInARowMouseListener(this, fiar));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < fiar.getNRows(); i++) { 
			for (int j = 0; j < fiar.getNColumns(); j++) {
				/*if (fiar.getGameTable()[i][j] == 0) {
					g.drawImage(red, (433) / 6 * j, (273) / 7 * i,null);
				}

				if (fiar.getGameTable()[i][j] == 1) { */
						g.drawImage(yellow, (436) / 6 * j, (273) / 7 * i ,null);
				//}

			}
		}
	}
}