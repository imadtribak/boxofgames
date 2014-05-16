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

import java.util.Random;

import be.umons.utility.Sound;

/**
 * <b> AI is the class that permit to play versus a AI with different
 * levels </b>
 * 
 * @author AGOZZINO Terencio
 */

public class AI extends Player {

	private TicTacToe ttt;
	private FourInARow fiar;
	private Othello othello;
	private int difficulty;
	
	Sound sound1;
	Sound sound2;
	
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
	
	int row = 0;
	int column = 0;
	
	/**
	 * <b> Method that count the element in the rows. </b>
	 * 
	 * @param player
	 *			Currently player
	 * 
	 * @return 1
	 * 			Two elements same
	 * 
	 * @return -1
	 * 			Not two element same	
	 */
	
	public int checkRows(int player) {
		int x = 0;
		for (int i = 0; i < ttt.getNRows(); i ++) {
			for (int j = 0; j < ttt.getNColumns(); j ++) {
				if (ttt.gameTable[row][column] == player)
					x ++;

				if (ttt.gameTable[row][column] == 2) {
					row = i;
					column = j;
				}
			}

			if (x == 2 && ttt.gameTable[row][column] == 2)
				return 1;
			
			else {
				x = 0;
				row = 0;
				column = 0;
			}
		}
		return -1;
	}
	
	/**
	 * <b> Method that count the element in the columns. </b>
	 * 
	 * @param player
	 *			Currently player
	 * 
	 * @return 1
	 * 			Two elements same
	 * 
	 * @return -1
	 * 			Not two element same	
	 */
	
	public int checkColumns(int player) {
		int x = 0;
		for (int j = 0; j < ttt.getNRows(); j ++) {
			for (int i = 0; i < ttt.getNColumns(); i ++) {
				if (ttt.gameTable[row][column] == player)
					x ++;

				if (ttt.gameTable[row][column] == 2) {
					row = i;
					column = j;
				}
			}

			if (x == 2 && ttt.gameTable[row][column] == 2) {
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
	
	/**
	 * <b> Method that count the element in the first diagonal. </b>
	 * 
	 * @param player
	 *			Currently player
	 * 
	 * @return 1
	 * 			Two elements same
	 * 
	 * @return -1
	 * 			Not two element same	
	 */
	
	public int checkFirstDiagonal(int player) {
		int x = 0;
		for (int i = 0; i < ttt.getNRows(); i ++) {
			for (int j = 0; j < ttt.getNColumns(); j ++) {
				if (ttt.gameTable[Math.abs(j - 2)][j] == player)
					x ++;

				if (ttt.gameTable[Math.abs(j - 2)][j] == 2) {
					row = Math.abs(j - 2);
					column = j;
				}
			}

			if (x == 2 && ttt.gameTable[row][column] == 2)
				return 1;
			
			else {
				x = 0;
				row = 0;
				column = 0;
			}
		}
		return -1;
	}
	
	/**
	 * <b> Method that count the element in the second diagonal. </b>
	 * 
	 * @param player
	 *			Currently player
	 * 
	 * @return 1
	 * 			Two elements same
	 * 
	 * @return -1
	 * 			Not two element same	
	 */
	
	public int checkSecondDiagonal(int player) {
		int x = 0;
		for (int i = 0; i < ttt.getNRows(); i ++) {
			for (int j = 0; j < ttt.getNColumns(); j ++ ) {
				if (ttt.gameTable[row][column] == player)
					x ++;

				if (ttt.gameTable[row][column] == 2) {
					row = j;
					column = j;
				}
			}

			if (x == 2 && ttt.gameTable[row][column] == 2) {
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
	
	/**
	 * <b> Method that give the level 'easy' of the Tic-Tac-Toe game. </b>
	 */

	public void easyAITicTacToe() {	
		Random r = new Random();
		boolean success = true;
		do {
			int x = r.nextInt(3);
			int y = r.nextInt(3);
			
			if (ttt.gameTable[x][y] == 2) {
				success = false;
				ttt.setLastX(x); 
				ttt.setLastY(y);
				if (ttt.getActualPlayer() == 0) {
					ttt.gameTable[x][y] = 0;
				}
				else {
					ttt.gameTable[x][y] = 1;
				}
			}
		} while (success);
		ttt.changePlayer();
	}
	
	/**
	 * <b> Method that give the level 'medium" of the Tic-Tac-Toe game. </b>	
	 */
	
	public void mediumAITicTacToe() {
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
				ttt.gameTable[row][column] = 0;
			}
			
			if (ttt.gameTable[1][1] == 2) {
				ttt.setLastX(1);
				ttt.setLastY(1);
				ttt.gameTable[1][1] = 0;
			}
			
			boolean success = true;
			do {
				int x = r.nextInt(3);
				int y = r.nextInt(3);

				if (ttt.gameTable[x][y] == 2) {
					success = false;
					ttt.setLastX(x); 
					ttt.setLastY(y);
					ttt.gameTable[x][y] = 0;
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
				ttt.gameTable[row][column] = 1;
			}
			
			if (this.gameTable[1][1] == 2) {
				ttt.setLastX(1);
				ttt.setLastY(1);
				ttt.gameTable[1][1] = 1;
			}
			
			boolean success = true;
			do {
				int x = r.nextInt(3);
				int y = r.nextInt(3);
				
				if (this.gameTable[x][y] == 2) {
					success = false;
					ttt.setLastX(x); 
					ttt.setLastY(y);
					ttt.gameTable[x][y] = 1;
				}
			} while (success);
		}
	}
	
	/**
	 * <b> Method that give the level 'hard' of the Tic-Tac-Toe game. </b>	
	 */
	
	public void hardAITicTacToe() {

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
				ttt.gameTable[row][column] = 0;
			}

			else {
				if (ttt.gameTable[1][0] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (ttt.gameTable[0][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							ttt.gameTable[0][0] = 0;
						}
					}

					if (ttt.gameTable[0][2] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(2);
						ttt.gameTable[0][2] = 0;
					}
				}

				if (ttt.gameTable[2][1] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (this.gameTable[2][0] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(0);
							ttt.gameTable[2][0] = 0;
						}
					}

					if (ttt.gameTable[2][2] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(2);
						ttt.gameTable[2][2] = 0;
					}
				}

				if (ttt.gameTable[1][2] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (ttt.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							ttt.gameTable[0][2] = 0;
						}
					}

					if (ttt.gameTable[2][2] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(2);
						ttt.gameTable[2][2] = 0;
					}
				}

				if (ttt.gameTable[0][1] == 1) {
					result = r.nextInt(2);
					if (result == 0) {
						if (this.gameTable[0][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							ttt.gameTable[0][2] = 0;
						}
					}

					if (ttt.gameTable[0][2] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(2);
						ttt.gameTable[0][2] = 0;
					}
				}

				if (ttt.gameTable[1][1] == 2) {
					ttt.setLastX(1);
					ttt.setLastY(1);
					ttt.gameTable[1][1] = 0;
				}

				if (ttt.gameTable[2][2] == 2) {
					ttt.setLastX(2);
					ttt.setLastY(2);
					ttt.gameTable[2][2] = 0;
				}

				if (ttt.gameTable[0][0] == 1) {
					if (this.gameTable[2][2] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(2);
						ttt.gameTable[2][2] = 0;
					}
				}

				if (ttt.gameTable[0][2] == 1) {
					if (this.gameTable[2][0] == 2) {
						ttt.setLastX(2);
						ttt.setLastY(0);
						ttt.gameTable[2][0] = 0;
					}
				}

				if (ttt.gameTable[2][0] == 1) {
					if (this.gameTable[0][2] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(2);
						ttt.gameTable[0][2] = 0;
					}
				}

				if (ttt.gameTable[2][2] == 1) {
					if (this.gameTable[0][0] == 2) {
						ttt.setLastX(0);
						ttt.setLastY(0);
						ttt.gameTable[0][0] = 0;
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
				ttt.gameTable[row][column] = 1;
			}

			else {
				if (ttt.gameTable[1][1] == 2) {
					ttt.setLastX(1);
					ttt.setLastY(1);
					ttt.gameTable[1][1] = 1;
				}
				
				if (ttt.gameTable[1][1] == 0) {

					result = r.nextInt(4);

					if (result == 0) {
						if (ttt.gameTable[0][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							ttt.gameTable[0][0] = 1;
						}
					}

					if (result == 1) {
						if (ttt.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(0);
							ttt.gameTable[0][2] = 1;
						}
					}

					if (result == 2) {
						if (ttt.gameTable[2][0] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(0);
							ttt.gameTable[2][0] = 1;
						}
					}

					if (result == 3) {
						if (ttt.gameTable[2][2] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							ttt.gameTable[2][2] = 1;
						}
					}
				}
				else {
					if (ttt.gameTable[1][0] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (ttt.gameTable[0][0] == 2) {
								ttt.setLastX(0);
								ttt.setLastY(0);
								ttt.gameTable[0][0] = 1;
							}
						}

						if (ttt.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							ttt.gameTable[0][2] = 1;
						}
					}

					if (ttt.gameTable[2][1] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (ttt.gameTable[2][0] == 2) {
								ttt.setLastX(2);
								ttt.setLastY(0);
								ttt.gameTable[2][0] = 1;
							}
						}

						if (ttt.gameTable[2][2] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							ttt.gameTable[2][2] = 1;
						}
					}

					if (ttt.gameTable[1][2] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (this.gameTable[0][2] == 2) {
								ttt.setLastX(0);
								ttt.setLastY(2);
								ttt.gameTable[0][2] = 1;
							}
						}

						if (ttt.gameTable[2][2] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							ttt.gameTable[2][2] = 1;
						}
					}

					if (ttt.gameTable[0][1] == 0) {
						result = r.nextInt(2);
						if (result == 0) {
							if (ttt.gameTable[0][0] == 2) {
								ttt.setLastX(0);
								ttt.setLastY(0);
								ttt.gameTable[0][2] = 1;
							}
						}

						if (ttt.gameTable[0][2] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							ttt.gameTable[0][2] = 1;
						}
					}

					if (ttt.gameTable[0][0] == 0) {
						if (ttt.gameTable[0][1] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(2);
							ttt.gameTable[0][1] = 1;
						}
					}

					if (ttt.gameTable[0][2] == 0) {
						if (ttt.gameTable[0][1] == 2) {
							ttt.setLastX(2);
							ttt.setLastY(0);
							ttt.gameTable[0][1] = 1;
						}
					}

					if (ttt.gameTable[2][0] == 0) {
						if (ttt.gameTable[1][0] == 2) {
							ttt.setLastX(0);
							ttt.setLastY(2);
							ttt.gameTable[1][0] = 2;
						}
					}

					if (ttt.gameTable[2][2] == 0) {
						if (ttt.gameTable[1][2] == 2) {
							ttt.setLastX(1);
							ttt.setLastY(2);
							ttt.gameTable[1][2] = 1;
						}
					}
				}
			}
		}
	}		

	/**
	 * <b> Method that give the level 'easy' of the Four in a Row game. </b>
	 */
	
	public void easyAIFourInARow() {
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
						fiar.gameTable[x][y] = 0;
					}
					else {
						fiar.gameTable[x][y] = 1;
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
						fiar.gameTable[x][y] = 0;
					}
					else {
						fiar.gameTable[x][y] = 1;
					}
				}
			}
		} while (success);
		fiar.changePlayer();
	}

	/**
	 * <b> Method that give the level 'medium' of the Four in a Row game. </b>
	 */
	
	public void mediumAIFourInARow() {
	
	}
	
	/**
	 * <b> Method that give the level 'hard' of the Four in a Row game. </b>
	 */
	
	public void hardAIFourInARow() {
	}
	
	/**
	 * <b> Method that give the level 'easy' of the Othello game. </b>
	 */

	public void easyAIOthello() {
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
					othello.gameTable[x][y] = 0;
				}
				else {
					othello.gameTable[x][y] = 1;
				}
			}
		} while (success);
		othello.changePlayer();
	}
	
	/**
	 * <b> Method that give the level 'medium' of the Othello game. </b>
	 */
	
	public void mediumAIOthello() {
		
	}
	
	/**
	 * <b> Method that give the level 'hard' of the Othello game. </b>
	 */
	
	public void hardAIOthello() {

	}
	
	/**
	 * <b> Method that get the level difficulty of an AI. </b>
	 * 
	 * @return difficulty
	 * 			Currently difficulty
	 */

	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * <b> Method that set the level difficulty of an AI. </b>
	 * 
	 * @param difficiculty
	 * 			Currently difficulty
	 */

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}