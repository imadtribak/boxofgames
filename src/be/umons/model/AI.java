/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : AI.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import java.util.Random;

import be.umons.model.Game;

/**
 * <b> AI is the class that permit to play versus a computer with different
 * levels </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class AI extends Player {

	private int[][] gameTable;

	/**
	 * <b> Default constructor that initialize an AI. </b>
	 */

	public AI() {

	}

	/**
	 * <b> Method that generate a layout of a game. </b>
	 * 
	 * @param rows
	 * 			Number of rows
	 * 
	 * @param columns
	 * 			Number of columns
	 */

	public int[][] arrayGenerator (int rows, int columns) {
		int [][] array = new int [rows][columns];
		for (int i = 0; i < array.length; i++)  {
			for (int j = 0; j < array.length ; j++) {
				array[i][j] = 0;
			}
		}
		return array;
	}

	/**
	 * <b> Method that give the level 'easy' of the Tic-Tac-Toe game. </b>
	 * 
	 * @return gameTable[x][y]
	 * 			Position in the array.	
	 */

	public int easyAITicTacToe() {
		int[][] array = getGameTable();
		Random Math = new Random();
		boolean success = true;
		do {
			int x = Math.nextInt(3);
			int y = Math.nextInt(3);
			if (array[x][y] == 2) {
				success = false;
				setLastX(x);
				setLastY(y);
				return array[x][y] = 1;
			}
		} while (success);
		return -1;
	}

	/**
	 * <b> Method that give the level 'easy' of the Four in a Row game. </b>
	 * 
	 * @return gameTable[x][y]
	 * 			Position in the array.	
	 */
	
	public int easyAIFourInARow() {
		int[][] array = getGameTable();
		Random Math = new Random();
		int x = 5;
		boolean success = true;
		do {
			int y = Math.nextInt(7);
			if (y >= 0 && y < array[x].length) {
				if (array[x][y] == 2) {
					success = false;
					setLastX(x);
					setLastY(y);
					return array[x][y] = 1;
				}
				else {
					while (array[x][y] != 2)
						x--;
					success = false;
					setLastX(x);
					setLastY(y);
					return array[x][y] = 1;
				}
			}
		} while (success);
		return -1;
	}


	/**
	 * <b> Method that implement an AI with AlphaBetaNegaMax algorithm. </b>
	 * 
	 * @param depth
	 * 			Deep
	 * 
	 * @param alpha
	 * 			alpha
	 * 
	 * @param beta
	 * 			beta
	 */

	// NOTE: Cette méthode ne marche pas !

	/*public int alphaBetaNega(int depth, int alpha, int beta) {

		if (depth == 0 || gameTable[i][j] == 0)
			return heuristic(gameTable[i][j]);

		for (gameTable[x][y]) {
			beta = Math.max(alpha, -alphaBetaNega(depth -1, -alpha, -beta));
			if (alpha >= beta)
				return alpha;
			alpha = Math.max(alpha, beta);	
		}
		return alpha;
	}

	public void heuristic(int depth)
	{
		if(gameTable[x][y] == getActualPlayer())
			return -1000;
	 */

	/**
	 * <b> Method that get gameTable. </b>
	 * 
	 * @param gameTable
	 * 			Generate an array
	 */
	
	public int[][] getGameTable() {
		return gameTable;
	}

	/**
	 * <b> Method that set gameTable. </b>
	 * 
	 * @param gameTable
	 * 			Generate an array
	 */

	public void setGameTable(int[][] gameTable) {
		this.gameTable = gameTable;
	}
}