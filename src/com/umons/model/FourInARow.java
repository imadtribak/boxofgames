/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : FourInARow.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

import java.util.List;
import java.util.Scanner;

import com.umons.exception.BoundOutreachedException;

/**
 * This class give the possibility to play to FourInARow
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class FourInARow extends Game {
	/**
	 * This constructor initialize an array with a number of 6 rows and a number of 7 columns
	 */
	
	public FourInARow(List<Object> list) {
		super(6,7, list);
	}
	
	// NOTE: A modifier !
	
	/*@SuppressWarnings("resource")
	public void select(int player) {
		int x = 0, y = 0;
		boolean success = true;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Select a column: ");
			y = sc.nextInt();
			if (y < gameTable.length) { 
				if (getGameTable()[5-x][y] == 0) {
					return 5;	
				else
					System.out.println("This emplacement is already taken ! \n");
			} else {
				System.out.println("Your column is out of the array ! \n");
			}
		} else {
			System.out.println("Your row is out of the array ! \n");
		}	
	} while (success);
	
		if (player == 1) {
			gameTable[x][y] = 1;
		} else {
			gameTable[x][y] = 2;
		}
		setLastX(x);
		setLastY(y);
	}*/
	
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
		if (i >= 7 || i < 0 || j >= 8 || j < 0)
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

	// NOTE: A modifier !
	
	public int BasisCheck(int i, int j, int player, int di, int dj) {
		int count = 1;
		if (Get(i + di, j + dj) == player) {
			count += 1;
			
			if (Get(i + 2 * di, j + 2 * dj) == player)
				count += 1;
		}
		if (Get(i - di, j - dj) == player) {
			count += 1;
			
			if (Get(i - 2 * di, j - 2 * dj) == player)
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
	
	// NOTE: A modifier !

	public int checkWinner(int i, int j, int player) {
		if (BasisCheck(i, j, player, 0, 1) >= 3)
			return 1;
		if (BasisCheck(i, j, player, 1, 0) >= 3)
			return 2;
		if (BasisCheck(i, j, player, 1, 1) >= 3)
			return 3;
		if (BasisCheck(i, j, player, 1, -1) >= 3)
			return 4;
	return -1;
	}
	
	/**
	 * Method that print the array.
	 */
	
	public void displayArray() {
		int[][] array = getGameTable();	
		String display = " / ";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if(array[i][j] == 1) display = "*";
				else if(array[i][j] == 2) display = "O";
				else display = "/";
				System.out.print(" | " + display + " | ");
			}
			System.out.println("\n");
		}	
	}
	
	/**
	 * This method make possible to play to the game.
	 */
	
	// NOTE: A modifier !
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		//printBoardSize();
		//Game.choiceofPlayer();
		do {
			displayArray();
			changePlayer();
			select(getActualPlayer()); 
			} while (checkWinner(getLastX(), getLastY(), getActualPlayer()) == -1);
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 1)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() + " won the game with his horizontal alignment !");
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 2)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() + " won the game with his vertical alignment !");
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 3)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() + " won the game with his first diagonal alignment !");
		
		if(checkWinner(getLastX(), getLastY(), getActualPlayer()) == 4)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() + " won the game with his second diagonal alignment !");		
	}
}