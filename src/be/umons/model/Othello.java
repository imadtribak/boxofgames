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
 * <b> Othello is the class that permit to play to the Othello game. </b>
 * 
 * <p> This class extend the class Game. </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class Othello extends Game {

	private static int countplayer1, countplayer2 = 0;
	
	/**
	 * This constructor initialize an array with a number of 8 rows and a number of 8 columns
	 */

	public Othello(List <Object> list) {
		super(8, 8, list);
	}

	/**
	 * Method that tell if we are inside the array or outside.
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

	public int[][] arrayGenerator() {
		int[][] array = getGameTable();
		array[3][3] = 2;
		array[3][4] = 1;
		array[4][3] = 1;
		array[4][4] = 2;
		return array;
	}

	/**
	 * Method that count the number of pawns of two players .
	 * 
	 * @return 0
	 * 			Draw
	 * 
	 * @return 1
	 * 			Number of pawns by player 1
	 * 
	 * @return 2
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
			return countplayer1;

		return countplayer2;
	}

	/**
	 * This method make possible to play to the game.
	 * 
	 * @throws BoundOutreachedException 
	 * 			Generate exception
	 */
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		//choiceofPlayer();
		arrayGenerator();
		do {
			displayArray();
			changePlayer();
			select(getActualPlayer()); 
			clearConsole();
			} while (!endGame());
		
		if (checkWinner() == 0) {
			displayArray();
			System.out.println("The game is tied !");
		}
		
		if (checkWinner() == countplayer1) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with " + countplayer1 + " points");
		}
			
		if (checkWinner() == countplayer2) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with " + countplayer2 + " points");
		}
	}
}