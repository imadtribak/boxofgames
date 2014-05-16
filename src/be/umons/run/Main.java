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

import java.util.ArrayList;
import java.util.List;

import be.umons.model.FourInARow;
import be.umons.model.Player;
import be.umons.model.TicTacToe;
import be.umons.utility.Sound;
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
		
		/*List <Object> list = new ArrayList <Object>();
		TicTacToe ttt = new TicTacToe(list);
		ttt.letsPlay();*/
		GamesMenu frame = new GamesMenu();
		frame.setVisible(true);
		//Sound sound = new Sound("Ressource/Sound/Welcome.mp3");
		//sound.play();
	}		
}