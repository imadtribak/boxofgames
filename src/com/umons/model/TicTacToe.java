/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : TicTacToe.java
 * @date       : 15 mai 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

import java.util.Scanner;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class TicTacToe extends Game
{
	/**
	 * This constructor initialize an array with a number of 3 rows and a number of 3 columns
	 */
	
	public TicTacToe()
	{
		super(3,3);
	}

	/**
	 * This method check if there are a winner
	 */
	
	@Override
	public boolean checkWinner()
	{
		String[][] array = getGameTable();
		

		array[0][0] = "X";
		array[1][1] = "X";
		array[2][2] = "X";

		int i = 0;	
		int j = 0;

		if (array[i][j] == (array[i][j+1]))
		{
			if (array[i][j] == (array[i][j+2]))
			{
				return true;
			}
		}

		else if (array[i][j] == (array[i+1][j]))
		{
			if (array[i][j] == (array[i+2][j]))
			{
				return true;

			}
		}

		else if (array[i][j] == (array[i+1][j+1]))
		{
			if (array[i][j] == (array[i+2][j+2]))
			{
				return true;
			}
		}

	return false;
	}

	/**
	 * This method make possible to play to the game
	 */
	
	/*@Override
	public void letsPlay()
	{
		while (checkWinner() == false)
		{
			for (int i = 0; i < gameTable.length; i++)
			{
				for (int j = 0; j < gameTable.length; j++)
				{
					select();	
				}
			}
		}
		
		System.out.println("You won the game !");
	}
	*/
	
}