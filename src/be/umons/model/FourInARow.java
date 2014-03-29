/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : FourInARow.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import java.util.List;
import java.util.Scanner;

import be.umons.exception.BoundOutreachedException;

/**
 * This class give the possibility to play to Four-In-A-Row.
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class FourInARow extends Game {
	
	/**
	 * This constructor initialize an array with a number of 6 rows and a number of 7 columns
	 * 
	 * @param List <Object> list
	 * 			List of players
	 */
	
	public FourInARow(List<Object> list) {
		super(6, 7, list);
	}
	
	/**
	 * <b> Method that make possible to choice a position.  </b>
	 * 
	 * @param player
	 * 			Currently player
	 */
	
	@SuppressWarnings("resource")
	public void select(int player) {
		
		int[][] array = getGameTable();	
		int x = 5, y = 0;
		boolean success = true;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Select a column: ");
			y = sc.nextInt();
			if (x >= 0 && x < array.length) { 
				if (y >= 0 && y < array[x].length) {
					if (array[x][y] == 0)
						success = false;
					else {
						while (array[x][y] != 0)
							x--;
						success = false;
					}
			} else
				System.out.println("Your column is out of the array ! \n");
				
		} else
			System.out.println("Your row is out of the array ! \n");
			
	} while (success);
		
		if (player == 1) 
			array[x][y] = 1;
		
		else
			array[x][y] = 2;
		
		setLastX(x);
		setLastY(y);
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
		
		if (i >= 6 || i < 0 || j >= 7 || j < 0)
			return -1;
		
		else
			return array[i][j];
	}
	
	/**
	 * Method that count how many elements are same that my currently move
	 * 
	 * @param i
	 * 			Number of rows
	 * 
	 * @param j
	 * 			Number of columns
	 * 
	 * @param player
	 * 			Player
	 * 
	 * @param di
	 * 			Random rows number
	 * 
	 * @param dj
	 * 			Random columns number
	 * 
	 * @return count
	 * 			How many elements are same that my currently move
	 */
	
	public int BasisCheck(int i, int j, int player, int di, int dj) {
		
		int count = 1;

		if (Get(i + di, j + dj) == player) {
			count += 1;
			
			if (Get(i + 2 * di, j + 2 * dj) == player)
				count += 1;
			
				if (Get(i + 3 * di, j + 3 * dj) == player)
					count += 1;
		}
		
		if (Get(i - di, j - dj) == player) {
			count += 1;
			
			if (Get(i - 2 * di, j - 2 * dj) == player)
				count += 1;
			
				if (Get(i - 3 * di, j - 3 * dj) == player)
					count += 1;
		}
		
		return count;
	}
	
	/**
	 * Method that tell if they are a winner or not.
	 * 
	 * @param i
	 * 			Number of rows
	 * 
	 * @param j
	 * 			Number of columns
	 * 
	 * @param player
	 * 			Player
	 * 
	 * @return -1
	 * 			No winner
	 * 
	 * @return 1
	 * 			Winner with vertical line
	 * 
	 * @return 2
	 * 			Winner with horizontal line
	 * 
	 * @return 3
	 * 			Winner with first diagonal line
	 * 
	 * @return 4
	 *  		Winner with second diagonal line
	 */
	
	public int checkWinner(int i, int j, int player) {
		
		if (BasisCheck(i, j, player, 0, 1) >= 4)
			return 1;
		
		if (BasisCheck(i, j, player, 1, 0) >= 4)
			return 2;
		
		if (BasisCheck(i, j, player, 1, 1) >= 4)
			return 3;
		
		if (BasisCheck(i, j, player, 1, -1) >= 4)
			return 4;
		
	return -1;
	}
	
	/**
	 * This method make possible to play to the game.
	 */
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		//printBoardSize();
		//Game.choiceofPlayer();
		do {
			displayArray();
			changePlayer();
			select(getActualPlayer()); 
			} while (checkWinner(getLastX(), getLastY(), getActualPlayer()) == -1);
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 0) {
			displayArray();
			System.out.println(" The game is tied !");
		}
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 1) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his horizontal alignment !");
		}
			
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 2) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his vertical alignment !");
		}
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 3) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his first diagonal alignment !");
		}
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 4) {
			displayArray();
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his second diagonal alignment !");	
		}
	}
}