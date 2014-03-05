/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : Main.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.run;

import com.umons.model.TicTacToe;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class Main
{
	/**
	 * Launch the application
	 */
	
		public static void main(String[] args)
		{
			TicTacToe tic_tac_toe = new TicTacToe();
			System.out.println(tic_tac_toe.checkWinner());
		}		
}