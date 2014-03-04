/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : Othello.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class Othello extends Game
{
	/**
	 * This constructor initialize an array with a number of 8 rows and a number of 8 columns
	 */
	
	public Othello()
	{
		super(8,8);
	}
	
	@Override
	public boolean checkWinner()
	{
		return true;
	}
}