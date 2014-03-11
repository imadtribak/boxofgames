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

import java.util.List;

/**
 * This class give the possibility to play to Othello
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class Othello extends Game
{
	/**
	 * This constructor initialize an array with a number of 8 rows and a number of 8 columns
	 */
	
	public Othello(List<Player>list)
	{
		super(8,8, list);
	}
	
	/**
	 * This method check if there are a winner
	 */
	
	@Override
	public int checkWinner(int i, int j)
	{
		// Conditions de victoire
		return 0;
	}
	
	/** 
	 * This method initialize a new game table with his default values
	 * 
	 * @param rows
	 * 			Number of rows
	 * 
	 * @param columns
	 * 			Number of columns
	 * 
	 * @return array
	 * 			New array
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