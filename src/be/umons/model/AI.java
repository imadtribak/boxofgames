package be.umons.model;

import java.util.Random;

import be.umons.model.Game;

/**
 * This class give the possibility to play versus a computer with different levels
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class AI extends Player {
	
	 private int[][] gameTable;
	
	/**
	 * This constructor initialize an AI.
	 */
	 
		public AI() {
			
		}

		/**
		 * This method generate a layout of a game
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
	 * This method give the level 'easy' of the computer.
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
	 * Method that implement an AI with AlphaBetaNegaMax algorithm
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