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

/**
 * This class give the possibility to play to Tic-Tac-Toe
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class TicTacToe extends Game
{

	private Player p1;
	private Player p2;

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
					return 0;
				
				else
					return -1;	
	}
	
	/**
	 * This method make possible to play to the game
	 * 
	 * @param player 
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