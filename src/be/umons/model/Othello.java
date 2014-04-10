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
	 * <b> Constructor that initialize an array with a number of rows and
	 *  a number of columns. </b>
	 * 
	 * @param List <Object> list
	 * 			List of players
	 */

	public Othello(List <Object> list) {
		super(8, 8, list);
	}
	
	/** 
	 * <b> Method that initialize a new game table with his default values. </b>
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
	 *			Number of rows
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
	 * <b> Method that count how many elements are same that my currently 
	 * move.  </b>
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

			for (int x = i - 1; x >= 0; x--) {

				if (get(x, j) == 2) {
					if (get(x + 1, j) == player)
						break;
					up = 0;
					break;
				}

				if (get(x, j) != player)
					
					up += 1;

				if (get(x, j) == player) {
					if (get(x + 1, j) != player)
						break;
					up = 0;
					break;
				}
			}

			for (int x = i + 1; x >= 0; x++) {

				if (get(x, j) == 2) {
					if (get(x - 1, j) == player)
						break;
					down = 0;
					break;
				}

				if (get(x, j) != player)
					down += 1;

				if (get(x, j) == player) {
					if (get(x - 1, j) != player)
						break;
					down = 0;
					break;
				}
			}

			for (int y = j - 1; y >= 0; y--) {

				if (get(i, y) == 2) {
					if (get(i, y + 1) == player)
						break;
					left = 0;
					break;
				}

				if (get(i, y) != player)
					left += 1;

				if (get(i, y) == player) {
					if (get(i, y + 1) != player)
						break;
					left = 0;
					break;
				}
			}

			for (int y = j + 1; y >= 0; y++) {

				if (get(i, y) == 2) {
					if (get(i, y - 1) == player)
						break;
					right = 0;
					break;
				}

				if (get(i, y) != player)
					right += 1;

				if (get(i, y) == player) {
					if (get(i, y - 1) != player)
						break;
					right = 0;
					break;
				}
			}

			int x = i - 1;
			int y = j - 1;

			while (x >= 0 && y >= 0) {
				if (get(x, y) == 2) {
					if (get(x + 1, y + 1) == player)
						break;
					topleft = 0;
					break;
				}

				if (get(x, y) != player)
					topleft += 1;

				if (get(x,  y) == player) {
					if (get(x + 1, y + 1) != player)
						break;
					topleft = 0;
					break;
				}
				x--; 
				y--;
			}

			/*int x = i - 1;
			int y = j - 1;

			while (x >= 0 && y >= 0) {
				if (get(x, y) == 2) {
					if (get(x-1, y-1) == player)
						break;
					downright = 0;
					break;
				}

				if (get(x, y) != player)
					downright += 1;

				if (get(x, y) == player) {
					if (get(x-1, y-1) != player)
						break;
					downright = 0;
					break;
				}
			}

			int x = i - 1;
			int y = j - 1;

			while (x >= 0 && y >= 0) {
				if (get(x, y) == 2) {
					if (get(x+1, y-1) == player)
						break;
					topright = 0;
					break;
				}

				if (get(x, y) != player)
					topright += 1;

				if (get(x, y) == player) {
					if (get(x+1, y-1) != player)
						break;
					topright = 0;
					break;
				}
			}


			int x = i - 1;
			int y = j - 1;

			while (x >= 0 && y >= 0) {
				if (get(x, y) == 2) {
					if (get(x-1, y+1) == player)
						break;
					downleft = 0;
					break;
				}

				if (get(x, y) != player)
					downleft += 1;

				if (get(x, y) == player) {
					if (get(x-1, y+1) != player)
						break;
					downleft = 0;
					break;
				}
			}*/

		if (up != 0 || down != 0 || left != 0 || right != 0 || topleft != 0
				|| downright != 0 || topright != 0 || downleft != 0)
			return true;
		return false;
	}
	
	/**
	 * <b> Method that convert the pawns from different color between two 
	 * pawns same color. </b> 
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

		if (basisCheck(i, j, player) == true) {

			if (up != 0) {
				int x = i-1;
				while (up > 0) {
					array[x][j] = player;
					up -= 1;
					x--;
				}
			}

			if (down != 0) {
				int x = i+1;
				while (down > 0) {
					array[x][j] = player;
					down -= 1;
					x++;
				}
			}

			if (left != 0) {
				int y = j-1;
				while (left > 0) {
					array[i][y] = player;
					left -= 1;
					y--;
				}
			}

			if (right != 0) {
				int y = j+1;
				while (right > 0) {
					array[i][y] = player;
					right -= 1;
					y++;
				}
			}


			if (topleft != 0) {
				int x = i-1;
				int y = j-1;
				while (topleft > 0) {
					array[x][y] = player;
					topleft -= 1;
					x--;
					y--;
				}
			}

			if (downright != 0) {
				int x = i+1;
				int y = j+1;
				while (downright > 0) {
					array[x][y] = player;
					downright -= 1;
					x++;
					y++;
				}
			}

			if (topright != 0) {
				int x = i-1;
				int y = j+1;
				while (topright > 0) {
					array[x][y] = player;
					topright -= 1;
					x--;
					y++;
				}
			}

			if (downleft != 0) {
				int x = i+1;
				int y = j-1;
				while (downleft > 0) {
					array[x][y] = player;
					downleft -= 1;
					x++;
					y--;
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
	 * <b> Method that make possible to play to the game. </b> 
	 * 
	 * @throws BoundOutreachedException 
	 * 			Generate exception
	 */
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		int[][] array = getGameTable();
		//choiceofPlayer();
		arrayGenerator();
		do {
			displayArray();
			changePlayer();
			select(getActualPlayer()); 
			while(!basisCheck(getLastX(), getLastY(), getActualPlayer())) {
				array[getLastX()][getLastY()] = 2;
				clearConsole();
				displayArray();
				System.out.println("Movement not allowed, you must take at least one pawn ! \n");
				displayPlayer();
				select(getActualPlayer()); 	
			}
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