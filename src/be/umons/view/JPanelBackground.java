/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : JPanelBackground.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * <b> JPanelBackground is the class that set a background to a JFrame. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class JPanelBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage background;

	/**
	 * <b> Constructor that initialize a new background </b>
	 * 
	 * @param String bgRessource
	 * 			The repertory of the file
	 */
	
	public JPanelBackground(String bgRessource) {
		try {                
			background = ImageIO.read(new File(bgRessource));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	/** 
	 * <b> Method that draw the background. </b>
	 * 
	 * @param Graphics g
	 *			Draw the picture.
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);          
	}
}