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

import java.util.List;

/**
 * This class give the possibility to play to Tic-Tac-Toe
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class TicTacToe extends Game
{
	/**
	 * This constructor initialize an array with a number of 3 rows and a number of 3 columns
	 */
	
	public TicTacToe(List<Player>list)
	{
		super(3,3, list);	
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
	public int checkWinner(int i, int j)
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
				{
					System.out.println("The game ends in a tie !");
					return 0;
				}
				
				else
					return -1;	
	}
	
	/**
	 * This method make possible to play to the game
	 */
	
	@Override
	public void letsPlay()
	{
		System.out.println("  +---+---+---+");
		System.out.println("0 | " + " " + " | " + " " + " | " + " " + " | ");
		System.out.println("  +---+---+---+");
		System.out.println("1 | " + " " + " | " + " " + " | " + " " + " | ");
		System.out.println("  +---+---+---+");
		System.out.println("2 | " + " " + " | " + " " + " | " + " " + " | ");
		System.out.println("  +---+---+---+");
		System.out.println("   0   1   2");
		System.out.println("");
		
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