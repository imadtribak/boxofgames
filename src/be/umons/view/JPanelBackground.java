package be.umons.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage background;

	public JPanelBackground() {
		try {                
			background = ImageIO.read(new File("Ressource/background.jpg"));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);          
	}
}