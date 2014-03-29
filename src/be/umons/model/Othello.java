/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : Othello.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import java.util.List;

import be.umons.exception.BoundOutreachedException;

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
	
	public Othello(List<Object> list)
	{
		super(8,8, list);
	}
	
	/**
	 * Method that tell if we are inside the array or outside
	 * 
	 * @param i
	 * 			Number of rows
	 * 
	 * @param j
	 * 			Number of columns
	 * 
	 * @return -1
	 * 			Outside the array
	 * 
	 * @return array[i][j]
	 * 			The actual position in the array
	 */
	
	public int Get(int i, int j) {
		int[][] array = getGameTable();
		if (i >= 8 || i < 0 || j >= 8 || j < 0)
			return -1;
		else
			return array[i][j];
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
	
	public int[][] arrayGenerator()
	{
		int[][] array = getGameTable();
		array[3][3] = 2;
		array[3][4] = 1;
		array[4][3] = 1;
		array[4][4] = 2;
		
		return array;
	}
	
	// NOTE: A modifier !
	/*
	public boolean autorisedMoves(int player)
	{
		int[][] array = getGameTable();
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length; j++)
			{
				if ()
					return true;
			}	
		}
	} */
	
	// NOTE: Cette méthode peut aider, ou non.
	// NOTE: A modifier
	
	/*public int capturePawns(int i, int j)
	{
		int[][] array = getGameTable();
		
		for (int i = 0; i < array.length; i++)
		{
			
		}
	} */
	
	/**
	 * Method that tell if a game is end or not.
	 * 
	 * @return <b> false </b>
	 * 			Not empty array
	 * 
	 *  @return <b> true </b>
	 *  		Empty array
	 */
	
	public boolean endGame() {
		int[][] array = getGameTable();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Method that count the number of pawns by two players .
	 * 
	 * @return 0
	 * 			Draw
	 * 
	 * @return accountplayer1
	 * 			Number of pawns by player 1
	 * 
	 * @return accountplayer2
	 * 			Number of pawns by player 2
	 */

	public int checkWinner() {
		int[][] array = getGameTable();
		int countplayer1 = 0;
		int countplayer2 = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 1)
					countplayer1 += 1;
				countplayer2 += 1;
			}
		}
		
		if (countplayer1 == countplayer2)
			return 0;
		
		else if (countplayer1 > countplayer2)
			return 1;
		
		return 2;
	}
	
	/**
	 * This method make possible to play to the game.
	 */
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		//printBoardSize();
		//Game.choiceofPlayer();
		arrayGenerator();
		do {
			displayArray();
			changePlayer();
			select(getActualPlayer()); 
			} while (!endGame());
		
		if (checkWinner() == 0) {
			displayArray();
			System.out.println(" The game is tied !");
		}
		
		if (checkWinner() == 1) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his horizontal alignment !");
		}
			
		
		if (checkWinner() == 2) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his vertical alignment !");
		}
	}
}