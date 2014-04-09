/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : Main.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.run;

import be.umons.view.IGamesMenu;

/**
 * <b> Main is the class that launch the application. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class Main {

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		IGamesMenu frame = new IGamesMenu();
		frame.setVisible(true);
	}		
}