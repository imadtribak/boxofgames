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

	int countplayer1, countplayer2 = 0;
	int up = 0;
	int down = 0;
	int left = 0;
	int right = 0;
	int topleft = 0; 
	int topright = 0;
	int downleft = 0;
	int downright = 0;
	
	/**
	 * This constructor initialize an array with a number of 8 rows and a number of 8 columns
	 * 
	 * @param List <Object> list
	 * 			List of players
	 */

	public Othello(List <Object> list) {
		super(8, 8, list);
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
		array[3][3] = 1;
		array[3][4] = 0;
		array[4][3] = 0;
		array[4][4] = 1;
		return array;
	}
	
	/**
	 * <b> Method that tell if we are inside the array or outside. </b>
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

	public int get(int i, int j) {
		int[][] array = getGameTable();
		if (i >= 8 || i < 0 || j >= 8 || j < 0)
			return -1;
		else
			return array[i][j];
	}
	
	/**
	 * <b> Method that count how many elements are same that my currently move </b>
	 * 
	 * @param i
	 * 			Number of rows
	 * 
	 * @param j
	 * 			Number of columns
	 * 
	 * @param player
	 * 			Currently player
	 * 
	 * @return <b> false </b>
	 * 			Converter no possible
	 * 
	 * @return <b> true </b>
	 * 			Converter possible
	 */
	
	public boolean basisCheck(int i, int j, int player) {
		int[][] array = getGameTable();

		if (get(i, j) != -1) { 
			while (array[i-1][j] != 2 && array[i-1][j] != player) {
				for (int y = i-1; y >= 0 && array[y][j] != player; y--) {
					up += 1;
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i+1][j] != 2 && array[i+1][j] != player) {
				for (int y = i+1; y >= 0 && array[y][j] != player; y++) {
					down += 1;
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i][j-1] != 2 && array[i][j-1] != player) {
				for (int x = j-1; x >= 0 && array[x][j] != player; x--) {
					left += 1;
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i][j+1] != 2 && array[i][j+1] != player) {
				for (int x = j+1; x >= 0 && array[x][j] != player; x++) {
					right += 1;
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i-1][j-1] != 2 && array[i-1][j-1] != player) {
				for (int y = i-1; y >= 0 && array[y][j] != player; y++) {
					for (int x = j-1; x >= 0 && array[i][x] != player; x++) {
						topleft += 1;	
					}
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i+1][j+1] != 2 && array[i+1][j+1] != player) {
				for (int y = i+1; y >= 0 && array[y][j] != player; y++) {
					for (int x = j+1; x >= 0 && array[i][x] != player; x++) {
						downright += 1;	
					}
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i-1][j+1] != 2 && array[i-1][j+1] != player) {
				for (int y = i-1; y >= 0 && array[y][j] != player; y++) {
					for (int x = j+1; x >= 0 && array[i][x] != player; x++) {
						topright += 1;	
					}
				}
			}
		}

		if (get(i, j) != -1) { 
			while (array[i+1][j-1] != 2 && array[i+1][j-1] != player) {
				for (int y = i+1; y >= 0 && array[y][j] != player; y++) {
					for (int x = j-1; x >= 0 && array[i][x] != player; x++) {
						downleft += 1;	
					}
				}
			}
		}

		if (up != 0 || down != 0 || left != 0 || right != 0 || topleft != 0
				|| downright != 0 || topright != 0 || downleft != 0)
			return true;
		return false;
	}
	
	/**
	 * <b> Method that count the number of pawns of two players. </b>
	 * 
	 * @param i
	 * 			Number of rows
	 * 
	 * @param j
	 * 			Number of columns
	 * 
	 * @param player
	 * 			Currently player
	 */

	public void converter(int i, int j, int player) {
		int[][] array = getGameTable();
		
		if (get(i + 0, j + 1) != -1 && get(i + 1, j + 0) != -1
				&& get(i + 1, j + 1) != -1 && get(i + 1, j - 1) != -1) {
			
			if (basisCheck(i, j, player) == true) {

				if (up != 0) {
					for (int y = i-1; y <= up; y--) {
						array[i][y] = player;
					}
				}

				if (down != 0) {
					for (int y = i+1; y <= down; y++) {
						array[i][y] = player;
					}
				}

				if (left != 0) {
					for (int x = j-1; x <= left; x--) {
						array[i][x] = player;
					}
				}

				if (right != 0) {
					for (int x = j+1; x <= right; x++) {
						array[i][x] = player;
					}
				}

				if (topleft != 0) {
					for (int y = i-1; y <= up; y--) {
						for (int x = j-1; x <= up; x--) {
							array[i][y] = player;
						}
					}
				}

				if (downright != 0) {
					for (int y = i+1; y <= up; y++) {
						for (int x = j+1; x <= up; x++) {
							array[i][y] = player;
						}
					}
				}

				if (topright != 0) {
					for (int y = i-1; y <= up; y--) {
						for (int x = j+1; x <= up; x++) {
							array[i][y] = player;
						}
					}
				}

				if (downleft != 0) {
					for (int y = i+1; y <= up; y++) {
						for (int x = j-1; x <= up; x--) {
							array[i][y] = player;
						}
					}
				}
			}
		}
	}
	
	/**
	 * <b> Method that count the number of pawns of two players. </b>
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
			converter(getLastX(), getLastY(), getActualPlayer());
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