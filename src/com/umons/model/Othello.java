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
	
	/**
	 * This method check if there are a winner
	 */
	
	@Override
	public boolean checkWinner()
	{
		return true;
	}
	
	/** 
	 * This method initialize a new game table
	 */
	
	public int[][] arrayGenerator (int rows, int columns)
	{
		int [][] array = new int [rows][columns];
		for (int i = 0; i < array.length; i++)  
		{
			for (int j = 0; j < array.length ; j++)
			{
				array[i][j] = 0;
			}
		}
		
		array[3][3] = 2;
		array[3][4] = 1;
		array[4][3] = 1;
		array[4][4] = 2;

		return array;
	}
	
	/** 
	 * This method make possible to play
	 */

	@Override
	public void letsPlay()
	{
		// TODO Auto-generated method stub
	}
}