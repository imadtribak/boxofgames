/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : FourInALine.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class FourInALine extends Game
{
	/**
	 * This constructor initialize an array with a number of 6 rows and a number of 7 columns
	 */
	
	public FourInALine()
	{
		super(6,7);
	}
	
	@Override
	public boolean checkWinner()
	{
		int[][] array = getGameTable();

		array[0][0] = 1;
		array[1][1] = 1;
		array[2][2] = 1;
		array[3][3] = 1;

		int i = 0;	
		int j = 0;

		if (array[i][j] == (array[i][j+1]))
		{
			if (array[i][j] == (array[i][j+2]))
			{
				if (array[i][j] == (array[i][j+3]))
				{
					return true;
				}
			}
		}

		else if (array[i][j] == (array[i+1][j]))
		{
			if (array[i][j] == (array[i+2][j]))
			{
				if (array[i][j] == (array[i+3][j]))
				{
					return true;
				}
			}
		}

		else if (array[i][j] == (array[i+1][j+1]))
		{
			if (array[i][j] == (array[i+2][j+2]))
			{
				if (array[i][j] == (array[i+3][j+3]))
				{
					return true;
				}
			}
		}
		
	return false;
	}

	public int existingPawn(int j)
	{
		for (int i = 0; i < getGameTable().length; i++)
		{
			if (getGameTable()[5-i][j] == 0)
			{
				return i;	
			}
		}
		return 5;
	}
	
	/**
	 * This method make possible to play to the game
	 */
	
	@Override
	public void letsPlay()
	{
		while (checkWinner() == false)
		{
			for (int i = 0; i < getGameTable().length; i++)
			{
				for (int j = 0; j < getGameTable()[i].length; j++)
				{
					//select(p1.getPosition());		
				}
			}
		}
		System.out.println("You won the game !");	
	}
}