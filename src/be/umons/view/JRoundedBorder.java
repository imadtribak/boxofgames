/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : JRoundedBorder.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

/**
 * <b> JRoundedBorder is the class that make a rounder to a border. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class JRoundedBorder implements Border {

    private int radius;

    /**
     * <b> Constructor that initialize a new round to a border. </b>
     * 
     * @param radius
     * 			angle in radius.
     */
    
    JRoundedBorder(int radius) {
        this.radius = radius;
    }
    
	/** 
	 * <b> Method that get the border insets. </b>
	 * 
	 * @param Component c
	 *			Component
	 *
	 * @return Insets
	 * 			New insets
	 */
    
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

	/** 
	 * <b> Method that tell i the border is opaque or not. </b>
	 * 
	 * @return true
	 *			Opaque
	 */
    
    public boolean isBorderOpaque() {
        return true;
    }

	/** 
	 * <b> Method that draw the rounded to a border. </b>
	 * 
	 * @param Component c
	 * 			Component
	 * 
	 * @param Graphics g
	 * 			Draw the picture.
	 * 
	 * @param x
	 * 			X position
	 * 
	 * @param y
	 * 			Y position
	 * 
	 * @param width
	 * 			Width
	 * 
	 * @param height
	 * 			Height
	 */
    
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}