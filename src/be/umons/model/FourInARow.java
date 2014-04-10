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
 * <b> FourInARow is the class that permit to play to the Four in a Row game. </b>
 * 
 * <p> This class extend the class Game. </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class FourInARow extends Game {

	/**
	 * <b> Constructor initialize an array with a number of 6 rows and a number
	 * of 7 columns </b>
	 * 
	 * @param List <Object> list
	 * 			List of players
	 */

	public FourInARow(List <Object> list) {
		super(6, 7, list);
	}
	
	/**
	 * <b> Method that print the array. </b>
	 */
	
	public void displayArray() {
		int[][] array = getGameTable();	
		String display = " ";
		System.out.print("\n  ");

		for (int j = 0; j < array[0].length; j++) {
			System.out.print("  ");
			System.out.print(" " + j);
			System.out.print("");
		}
		System.out.print("\n   ");
		for (int j = 0; j < array[0].length; j++) {
			System.out.print("+---");
		}
		System.out.print("+\n");

		for (int i = 0; i < array.length; i++) {
				System.out.print("  ");
			
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0) display = getDISPLAYP1();
				else if (array[i][j] == 1) display = getDISPLAYP2();
				else display = " ";
				System.out.print(" | " + display);
			}
			System.out.print(" |");
			System.out.print("\n   ");

			for (int j = 0; j < array[0].length; j++) {
				System.out.print("+---");
			}
			System.out.print("+\n");	
		}	
		System.out.println("");
	}
	
	/**
	 * <b> Method that make possible to choose a position. </b>
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
			if (y >= 0 && y < array[x].length) {
				if (array[x][y] == 2)
					success = false;
				else {
					while (array[x][y] != 2)
						x--;
					success = false;
				}
			} else {
				displayArray();
				System.out.println("Your column is out of the array ! \n");
				displayPlayer();
			}
		} while (success);
		if (player == 0)
			array[x][y] = 0;
		else 
			array[x][y] = 1;
		setLastX(x);
		setLastY(y);
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
		if (i >= 6 || i < 0 || j >= 7 || j < 0)
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
	 * 			Player
	 * 
	 * @param di
	 * 			Random row number
	 * 
	 * @param dj
	 * 			Random column number
	 * 
	 * @return count
	 * 			How many elements are same that my currently move
	 */
	
	public int basisCheck(int i, int j, int player, int di, int dj) {
		int count = 1;
		if (get(i + di, j + dj) == player) {
			count += 1;
			if (get(i + 2 * di, j + 2 * dj) == player)
				count += 1;
			if (get(i + 3 * di, j + 3 * dj) == player)
				count += 1;
		}
		if (get(i - di, j - dj) == player) {
			count += 1;
			if (get(i - 2 * di, j - 2 * dj) == player)
				count += 1;
			if (get(i - 3 * di, j - 3 * dj) == player)
				count += 1;
		}
		return count;
	}
	
	/**
	 * <b> Method that tell if they are a winner or not. </b>
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

		if (basisCheck(i, j, player, 0, 1) >= 4)
			return 1;

		if (basisCheck(i, j, player, 1, 0) >= 4)
			return 2;

		if (basisCheck(i, j, player, 1, 1) >= 4)
			return 3;

		if (basisCheck(i, j, player, 1, -1) >= 4)
			return 4;
		return -1;
	}

	/**
	 * <b> Method that make possible to play to the game. </b>
	 * 
	 * @throws BoundOutreachedException 
	 * 			Generate exception
	 */
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		//choiceOfPlayers();
		do {
			displayArray();
			changePlayer();
			select(getActualPlayer());
			clearConsole();
		} while (checkWinner(getLastX(), getLastY(), getActualPlayer()) == -1);

		displayArray();

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 0)
			System.out.println("The game is tied !");

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 1)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his horizontal alignment !");

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 2)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his vertical alignment !");

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 3)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his first diagonal alignment !");

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 4)
			System.out.println(((Player) getListPlayer().get(getActualPlayer())).getName() +
					" won the game with his second diagonal alignment !");	
	}
}