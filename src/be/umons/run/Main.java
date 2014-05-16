/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : Main.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 ***************************************************
 */

package be.umons.run;

import be.umons.view.GamesMenu;

/**
 * <b> Main is the class that launch the application. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class Main {

	/**
	 * <b> Launch the application. </b>
	 * 
	 * @throws Exception 
	 */

	public static void main(String[] args) throws Exception {		
		GamesMenu frame = new GamesMenu();
		frame.setVisible(true);
	}		
}