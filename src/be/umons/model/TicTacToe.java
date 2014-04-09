/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : TicTacToe.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import java.util.List;
import java.util.Scanner;

import be.umons.exception.BoundOutreachedException;

/**
 * <b> TicTacToe is the class that permit to play to the Tic-Tac-Toe game. </b>
 * 
 * <p> This class extend the class Game. </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class TicTacToe extends Game {

	/**
	 * Constructor that initialize an array with a number of rows and a number of columns
	 * and a list of players.
	 * 
	 * @param List <Object> list
	 * 			List of players
	 */
	
	public TicTacToe(List <Object> list) {
		super(3, 3, list);	
		setDISPLAYP1("X");
		setDISPLAYP2("O");
	}
	
	/**
	 * <b> Method that give the possibility to choice a board size. </b>
	 */
	
	// NOTE: This method don't working.
	
	public void printBoardSize() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("######################");
			System.out.println("##### BOARD SIZE #####");
			System.out.println("######################\n");
			System.out.println("1. 3x3\n");
			System.out.println("2. 4x4\n");
			System.out.println("3. 5x5\n");
			int choice = sc.nextInt();
			
			while (true) {
				switch (choice) {
					case 1:
						break;
	
					case 2:
						arrayGenerator(4, 4);
						break;
	
					case 3:
						arrayGenerator(5, 5);
						break;

					default:
						System.out.println("Please, choose a number between 1 and 3\n");
						printBoardSize();
				}
				break;
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			printBoardSize();
		}
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
		if (i >= 3 || i < 0 || j >= 3 || j < 0)
			return -1;
		else
			return array[i][j];
	}
	
	/**
	 * <b> Method that count how many elements are same that my currently move. </b>
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
		} 
		if (get(i - di, j - dj) == player) {
			count += 1;
			if (get(i - 2 * di, j - 2 * dj) == player)
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

		if (endGame() == true)
			return 0;

		if (basisCheck(i, j, player, 0, 1) >= 3)
			return 1;

		if (basisCheck(i, j, player, 1, 0) >= 3)
			return 2;

		if (basisCheck(i, j, player, 1, 1) >= 3)
			return 3;

		if (basisCheck(i, j, player, 1, -1) >= 3)
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
		//printBoardSize();
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