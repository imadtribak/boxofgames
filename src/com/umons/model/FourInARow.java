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

import java.util.List;

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
	
	public FourInARow(List<Player>list)
	{
		super(6,7, list);
	}
	
	/**
	 * This method check if there are a winner
	 * 
	 * @param i
	 * 			Number of row
	 * 
	 * @param j
	 * 			Number of column
	 * 
	 * @return -1
	 * 			No winner
	 * 
	 * @return 0
	 * 			Draw
	 * 
	 * @return 1
	 * 			Winner with vertical line
	 * 
	 * @return 2
	 * 			Winner with horizontal line
	 * 
	 * @return 3
	 * 			Winner with first diagonal line
	 * 
	 * @return 4
	 *  		Winner with second diagonal line
	 */

	
	@Override
	public int checkWinner(int j)
	{
		int[][] array = getGameTable();
				
		// Conditions de victoires
				
				if (isDraw()) 
					return 0;
				
				else
					return -1;	
	}
	
	/**
	 * This method check if a pawn already exist in the location
	 * 
	 * @param j
	 * 			Number of column
	 * 
	 * @return i
	 * 			Line before the existing pawn
	 * 
	 * @return 5
	 * 			If no pawn existing
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
			changePlayer();
			select(getActualPlayer());
			
		}while (checkWinner(getLastX(), getLastY()) == -1);
		
		if (checkWinner(getLastX(), getLastY()) == 1)
			System.out.println(getListPlayer().get(getActualPlayer()).getName() + " won the game with his vertical alignment !");
		
		if (checkWinner(getLastX(), getLastY()) == 2)
			System.out.println(getListPlayer().get(getActualPlayer()).getName() + " won the game with his horizontal alignment !");
		
		if (checkWinner(getLastX(), getLastY()) == 3)
			System.out.println(getListPlayer().get(getActualPlayer()).getName() + " won the game with his first diagonal alignment !");
		
		if(checkWinner(getLastX(), getLastY()) == 4)
			System.out.println(getListPlayer().get(getActualPlayer()).getName() + " won the game with his second diagonal alignment !");		
	}
}