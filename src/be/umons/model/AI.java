package be.umons.model;

import java.util.Random;

/**
 * This class give the possibility to play versus a computer with different levels
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class AI extends Player
{
	
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
		
	// NOTE: Cette méthode ne fonctionne peut-être pas.
	
	public int easyDifficulty() {
		int[][] array = getGameTable();
		Random move = new Random();
		for (int i = 0; i < array.length ; i++) {
			for (int j = 0; j < array.length ; j++) {
				while (array[i][j] == 2) {
					int x = move.nextInt(3);
					int y = move.nextInt(3);
					if (gameTable[x][y] == 2)
						return gameTable[x][y];
				}
			}
		}
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