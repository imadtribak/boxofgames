/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : AI.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 ***************************************************
 */

package be.umons.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * <b> AI is the class that permit to play versus a computer with different
 * levels </b>
 * 
 * @author AGOZZINO Terencio
 */

public class AI extends Player {

	private TicTacToe ttt;
	private FourInARow fiar;
	private Othello othello;
	private int difficulty;
	
	private int[][] gameTable;
	
	public AI(TicTacToe ttt) {
		this.ttt = ttt;
	}
	
	public AI(FourInARow fiar) {
		this.fiar = fiar;
	}
	
	public AI(Othello oth) {
		this.othello = oth;
	}
	
	public void setGameTable(int[][]table) {
		this.gameTable = table;
	}
	
	public int[][] getGameTable() {
		return gameTable;
	}
 
	/**
	 * <b> Method that give the level 'easy' of the Tic-Tac-Toe game. </b>
	 * 
	 * @return gameTable[x][y]
	 * 			Position in the array.	
	 */

	public int easyAITicTacToe() {	
		Random r = new Random();
		boolean success = true;
		do {
			int x = r.nextInt(3);
			int y = r.nextInt(3);
			
			if (this.gameTable[x][y] == 2) {
				success = false;
				ttt.setLastX(x); 
				ttt.setLastY(y);
				if (ttt.getActualPlayer() == 0) {
					ttt.delay(1);
					return this.gameTable[x][y] = 0;
				}
				else {
					ttt.delay(1);
					return this.gameTable[x][y] = 1;
				}
			}
		} while (success);
		return -1;
	}
	
	int row = 0;
	int column = 0;
	
	public int checkRows(int player) {
		int x = 0;
		for (int i = 0; i < ttt.getNRows(); i ++) {
			for (int j = 0; j < ttt.getNColumns(); j ++) {
				if (this.gameTable[row][column] == player)
					x ++;

				if (this.gameTable[row][column] == 2) {
					row = i;
					column = j;
				}
			}

			if (x == 2 && gameTable[row][column] == 2)
				return 1;
			
			else {
				x = 0;
				row = 0;
				column = 0;
			}
		}
		return -1;
	}
	
	public int checkColumns(int player) {
		int x = 0;
		for (int j = 0; j < ttt.getNRows(); j ++) {
			for (int i = 0; i < ttt.getNColumns(); i ++) {
				if (this.gameTable[row][column] == player)
					x ++;

				if (this.gameTable[row][column] == 2) {
					row = i;
					column = j;
				}
			}

			if (x == 2 && gameTable[row][column] == 2) {
				return 1;
			}
			
			else {
				x = 0;
				row = 0;
				column = 0;
			}
		}
		return -1;
	}
	
	public int checkFirstDiagonal(int player) {
		int x = 0;
		for (int i = 0; i < ttt.getNRows(); i ++) {
			for (int j = 0; j < ttt.getNColumns(); j ++) {
				if (this.gameTable[Math.abs(j - 2)][j] == player)
					x ++;

				if (this.gameTable[Math.abs(j - 2)][j] == 2) {
					row = Math.abs(j - 2);
					column = j;
				}
			}

			if (x == 2 && gameTable[row][column] == 2)
				return 1;
			
			else {
				x = 0;
				row = 0;
				column = 0;
			}
		}
		return -1;
	}
	
	public int checkSecondDiagonal(int player) {
		int x = 0;
		for (int i = 0; i < ttt.getNRows(); i ++) {
			for (int j = 0; j < ttt.getNColumns(); j ++ ) {
				if (this.gameTable[row][column] == player)
					x ++;

				if (this.gameTable[row][column] == 2) {
					row = j;
					column = j;
				}
			}

			if (x == 2 && gameTable[row][column] == 2) {
				return 1;
			}
			
			else {
				x = 0;
				row = 0;
				column = 0;
			}
		}
		return -1;
	}
	
	public int hardAITicTacToe() {

		Random r = new Random();
		int result;

		if (ttt.getActualPlayer() == 0) {
			if (
					checkRows(0) == 1 ||
					checkColumns(0) == 1||
					checkFirstDiagonal(0) == 1 ||
					checkSecondDiagonal(0) == 1 ||
					checkRows(1) == 1 ||
					checkColumns(1) == 1||
					checkFirstDiagonal(1)  == 1 ||
					checkSecondDiagonal(1) == 1
					) {
				ttt.setLastX(row);
				ttt.setLastY(column);
				return this.gameTable[row][column] = 0;
			}

			else {
				if (this.gameTable[1][0] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (this.gameTable[0][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							return this.gameTable[0][0] = 0;
						}
					}

					if (this.gameTable[0][2] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(2);
						return this.gameTable[0][2] = 0;
					}
				}

				if (this.gameTable[2][1] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (this.gameTable[2][0] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(0);
							return this.gameTable[2][0] = 0;
						}
					}

					if (this.gameTable[2][2] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(2);
						return this.gameTable[2][2] = 0;
					}
				}

				if (this.gameTable[1][2] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (this.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							return this.gameTable[0][2] = 0;
						}
					}

					if (this.gameTable[2][2] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(2);
						return this.gameTable[2][2] = 0;
					}
				}

				if (this.gameTable[0][1] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (this.gameTable[0][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							return this.gameTable[0][2] = 0;
						}
					}

					if (this.gameTable[0][2] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(2);
						return this.gameTable[0][2] = 0;
					}
				}

				if (this.gameTable[1][1] == 2) {
					ttt.setLastX(1);
					ttt.setLastY(1);
					return this.gameTable[1][1] = 0;
				}

				if (this.gameTable[2][2] == 2) {
					ttt.setLastX(2);
					ttt.setLastY(2);
					return this.gameTable[2][2] = 0;
				}

				if (this.gameTable[0][0] == 1) {
					if (this.gameTable[2][2] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(2);
						return this.gameTable[2][2] = 0;
					}
				}

				if (this.gameTable[0][2] == 1) {
					if (this.gameTable[2][0] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(0);
						return this.gameTable[2][0] = 0;
					}
				}

				if (this.gameTable[2][0] == 1) {
					if (this.gameTable[0][2] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(2);
						return this.gameTable[0][2] = 0;
					}
				}

				if (this.gameTable[2][2] == 1) {
					if (this.gameTable[0][0] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(0);
						return this.gameTable[0][0] = 0;
					}
				}
			}
		}

		if (ttt.getActualPlayer() == 1) {
			
			if (
					checkRows(1) == 1 ||
					checkColumns(1) == 1||
					checkFirstDiagonal(1) == 1 ||
					checkSecondDiagonal(1) == 1 ||
					checkRows(0) == 1 ||
					checkColumns(0) == 1||
					checkFirstDiagonal(0)  == 1 ||
					checkSecondDiagonal(0) == 1
					) {
				ttt.setLastX(row);
				ttt.setLastY(column);
				return this.gameTable[row][column] = 1;
			}

			else {
				if (this.gameTable[1][1] == 2) {
					ttt.setLastX(1);
					ttt.setLastY(1);
					return this.gameTable[1][1] = 1;
				}
				
				if (this.gameTable[1][1] == 0) {

					result = r.nextInt(4);

					if (result == 0) {
						if (this.gameTable[0][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							return this.gameTable[0][0] = 1;
						}
					}

					if (result == 1) {
						if (this.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							return this.gameTable[0][2] = 1;
						}
					}

					if (result == 2) {
						if (this.gameTable[2][0] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(0);
							return this.gameTable[2][0] = 1;
						}
					}

					if (result == 3) {
						if (this.gameTable[2][2] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							return this.gameTable[2][2] = 1;
						}
					}
				}
				else {
					if (this.gameTable[1][0] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (this.gameTable[0][0] == 2) {
								ttt.setLastX(0);
								ttt.setLastY(0);
								return this.gameTable[0][0] = 1;
							}
						}

						if (this.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							return this.gameTable[0][2] = 1;
						}
					}

					if (this.gameTable[2][1] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (this.gameTable[2][0] == 2) {
								ttt.setLastX(2);
								ttt.setLastY(0);
								return this.gameTable[2][0] = 1;
							}
						}

						if (this.gameTable[2][2] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							return this.gameTable[2][2] = 1;
						}
					}

					if (this.gameTable[1][2] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (this.gameTable[0][2] == 2) {
								ttt.setLastX(0);
								ttt.setLastY(2);
								return this.gameTable[0][2] = 1;
							}
						}

						if (this.gameTable[2][2] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							return this.gameTable[2][2] = 1;
						}
					}

					if (this.gameTable[0][1] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (this.gameTable[0][0] == 2) {
								ttt.setLastX(0);
								ttt.setLastY(0);
								return this.gameTable[0][2] = 1;
							}
						}

						if (this.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							return this.gameTable[0][2] = 1;
						}
					}

					if (this.gameTable[0][0] == 0) {
						if (this.gameTable[0][1] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							return this.gameTable[0][1] = 1;
						}
					}

					if (this.gameTable[0][2] == 0) {
						if (this.gameTable[0][1] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(0);
							return this.gameTable[0][1] = 1;
						}
					}

					if (this.gameTable[2][0] == 0) {
						if (this.gameTable[1][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							return this.gameTable[1][0] = 2;
						}
					}

					if (this.gameTable[2][2] == 0) {
						if (this.gameTable[1][2] == 2) {
							ttt.setLastX(1);
							ttt.setLastY(2);
							return this.gameTable[1][2] = 1;
						}
					}
				}
			}
		}
		return -1;
	}		

	public int mediumAITicTacToe() {
		Random r = new Random();

		if (ttt.getActualPlayer() == 0) {
			if (
					checkRows(0) == 1 ||
					checkColumns(0) == 1||
					checkFirstDiagonal(0) == 1 ||
					checkSecondDiagonal(0) == 1 ||
					checkRows(1) == 1 ||
					checkColumns(1) == 1||
					checkFirstDiagonal(1)  == 1 ||
					checkSecondDiagonal(1) == 1
					) {
				ttt.setLastX(row);
				ttt.setLastY(column);
				return this.gameTable[row][column] = 0;
			}
			
			if (this.gameTable[1][1] == 2) {
				ttt.setLastX(1);
				ttt.setLastY(1);
				return this.gameTable[1][1] = 0;
			}
			
			boolean success = true;
			do {
				int x = r.nextInt(3);
				int y = r.nextInt(3);

				if (this.gameTable[x][y] == 2) {
					success = false;
					ttt.setLastX(x); 
					ttt.setLastY(y);
					return this.gameTable[x][y] = 0;
				}
			} while (success);
		}

		if (ttt.getActualPlayer() == 1) {

			if (
					checkRows(1) == 1 ||
					checkColumns(1) == 1||
					checkFirstDiagonal(1) == 1 ||
					checkSecondDiagonal(1) == 1 ||
					checkRows(0) == 1 ||
					checkColumns(0) == 1||
					checkFirstDiagonal(0)  == 1 ||
					checkSecondDiagonal(0) == 1
					) {
				ttt.setLastX(row);
				ttt.setLastY(column);
				return this.gameTable[row][column] = 1;
			}
			
			if (this.gameTable[1][1] == 2) {
				ttt.setLastX(1);
				ttt.setLastY(1);
				return this.gameTable[1][1] = 1;
			}
			
			boolean success = true;
			do {
				int x = r.nextInt(3);
				int y = r.nextInt(3);
				
				if (this.gameTable[x][y] == 2) {
					success = false;
					ttt.setLastX(x); 
					ttt.setLastY(y);
					return this.gameTable[x][y] = 1;
				}
			} while (success);
		}
		return -1;
	}

	/**
	 * <b> Method that give the level 'easy' of the Four in a Row game. </b>
	 * 
	 * @return gameTable[x][y]
	 * 			Position in the array.	
	 */
	
	public int easyAIFourInARow() {
		int[][] array = fiar.getGameTable();
		Random r = new Random();
		int x = 5;
		boolean success = true;
		do {
			int y = r.nextInt(7);
			if (y >= 0 && y < array[x].length) {
				if (array[x][y] == 2) {
					success = false;
					fiar.setLastX(x);
					fiar.setLastY(y);
					if (fiar.getActualPlayer() == 0) {
						fiar.delay(1);
						return array[x][y] = 0;
					}
					else {
						fiar.delay(1);
						return array[x][y] = 1;
					}
				}
				else {
					if (array[0][y] != 2) {
						success = true;
					}
					
					else {
						while (array[x][y] != 2)
							x--;
						success = false;
					}
					success = false;
					fiar.setLastX(x);
					fiar.setLastY(y);
					if (fiar.getActualPlayer() == 0) {
						fiar.delay(0);
						return array[x][y] = 0;
					}
					else {
						fiar.delay(0);
						return array[x][y] = 1;
					}
				}
			}
		} while (success);
		return -1;
	}

	
	public int mediumAIFourInARow() {
		
		return -1;	
	}
	
	public int hardAIFourInARow() {
		return -1;
	}
	
	/**
	 * <b> Method that give the level 'easy' of the Othello game. </b>
	 * 
	 * @return gameTable[x][y]
	 * 			Position in the array.	
	 */

	public int easyAIOthello() {
		int[][] array = othello.getGameTable();
		Random r = new Random();
		boolean success = true;
		do {
			int x = r.nextInt(7);
			int y = r.nextInt(7);
			if (array[x][y] == 2 && othello.basisCheck(othello.getLastX(),
					othello.getLastY(), othello.getActualPlayer()) == false) {
				success = false;
				othello.setLastX(x);
				othello.setLastY(y);
				if (othello.getActualPlayer() == 0) {
					othello.delay(1);
					return array[x][y] = 0;
				}
				else {
					othello.delay(1);
					return array[x][y] = 1;
				}
			}
		} while (success);
		return -1;
	}
	
	public int mediumAIOthello() {
		return -1;	
	}
	
	public int hardAIOthello() {
		return -1;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public void levelGenerator() {
		if (difficulty == 0)
			easyAITicTacToe();
		
		else if (difficulty == 1)
			mediumAITicTacToe();
			
		else 
			hardAITicTacToe();
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
}