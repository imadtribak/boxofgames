/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : FourInARow.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

/**
 * This class give the possibility to play to FourInARow
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class FourInARow extends Game
{
	/**
	 * This constructor initialize an array with a number of 6 rows and a number of 7 columns
	 */
	
	public FourInARow()
	{
		super(6,7);
	}
	
	/**
	 * This method check if there are a winner
	 */

	
	/*@Override
	public int checkWinner(int j)
	{
		int[][] array = getGameTable();
				
		// NOTE: Je vais être OutOfBounds si je place un 'X' ou un 'O' dans un coin (Problème à régler) 
		
				if (array[i-1][j] == array[i][j] && array[i+1][j] == array[i][j])
					return 1; // Vertical line
				
				if (array[j-1][i] == array[i][j] && array[j+1][i] == array[i][j])
					return 2; // Horizontal line
				
				if (array[i-1][j-1] == array[i][j] && array[i+1][j+1] == array[i][j])
					return 3; // First diagonal line
				
				if (array[i+1][j-1] == array[i][j] && array[i-1][j+1] == array[i][j])
					return 4; // Second diagonal line
				
				if (isDraw()) 
					return 0;
				
				else
					return -1;	
	} */
	
	
	/**
	 * This method check if a pawn already exist in the location
	 * 
	 * @param j
	 * 			Number of column
	 */
	
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
		do
		{
			if (player == 1)
				select(p1.getPosition());
			else
				select(p2.getPosition());	
		}
		
		while (checkWinner() == -1);
		
		if (checkWinner(player.select) == 0)
			System.out.println("The game ends in a tie !");
		
		if (checkWinner() == 1)
			System.out.println(player.getName() + " won the game with his vertical alignment !");
		
		if (checkWinner() == 2)
			System.out.println(player.getName() + " won the game with his horizontal alignment !");
		
		if (checkWinner() == 3)
			System.out.println(player.getName() + " won the game with his first diagonal alignment !");
		
		if(checkWinner() == 4)
			System.out.println(player.getName() + " won the game with his second diagonal alignment !");	
	}
}