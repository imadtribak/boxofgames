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

import java.util.ArrayList;
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

public class TicTacToe extends AGame {

	/**
	 * <b> Constructor that initialize an array with a number of rows and a number.
	 * of columns and a list of players. </b>
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
	 * 			Same elements
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
	 * 			Winner with horizontal line
	 * 
	 * @return 2
	 * 			Winner with vertical line
	 * 
	 * @return 3
	 * 			Winner with first diagonal line
	 * 
	 * @return 4
	 *  		Winner with second diagonal line
	 */

	public int checkWinner(int i, int j, int player) {

		if (basisCheck(i, j, player, 0, 1) >= 3)
			return 1;

		if (basisCheck(i, j, player, 1, 0) >= 3)
			return 2;

		if (basisCheck(i, j, player, 1, -1) >= 3)
			return 3;
		
		if (basisCheck(i, j, player, 1, 1) >= 3)
			return 4;
		
		else if (endGame() == true)
			return 0;
		return -1;
	}
	
	public void choiceOfPlayers() {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("######################");
			System.out.println("###### PLAYER 1 ######");
			System.out.println("######################\n");
			System.out.println("1. Human");
			System.out.println("2. Computer");
			int player1 = sc.nextInt();
			List<Object> list = new ArrayList<Object>();	
			
			AI ai;

			while (true) {
				switch (player1) {
				case 1:
					list.add(new Player());
					break;

				case 2:
					ai = new AI(this);
					ai.setGameTable(getGameTable());
					list.add(ai);
					break;

				default:
					System.out.println("Please, choose a number between 1 and 2\n");
					choiceOfPlayers();
				}

				System.out.println("######################");
				System.out.println("###### PLAYER 2 ######");
				System.out.println("######################\n");
				System.out.println("1. Human");
				System.out.println("2. Computer");
				int player2 = sc.nextInt();

				switch (player2) {
				case 1:
					list.add(new Player());
					break;

				case 2:
					ai = new AI(this);
					ai.setGameTable(getGameTable());
					list.add(ai);
					
					break;

				default:
					System.out.println("Please, choose a number between 1 and 2\n");
					choiceOfPlayers();
				}
				break;
			}
			setListPlayer(list);
		} catch (Exception e) {
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			choiceOfPlayers();
		}	
	}

	/**
	 * <b> Method that make possible to play to the game. </b>
	 * 
	 * @throws BoundOutreachedException 
	 * 			Generate exception
	 */
	
	@Override
	public void letsPlay() throws BoundOutreachedException {
		choiceOfPlayers();
		do {
			displayArray();
			changePlayer();
			clearConsole();
		} while (checkWinner(getLastX(), getLastY(), getActualPlayer()) == -1);

		displayArray();

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 0)
			System.out.println("Game is tied !");

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 1) {
			if (getActualPlayer() == 0) 
				System.out.println("The player 1 ("+ getDISPLAYP1() + ") won the game with his "
						+ "horizontal alignment !");
			if (getActualPlayer() == 1)
				System.out.println("The player 2 ("+ getDISPLAYP2() + ") won the game with his "
						+ "horizontal alignment ! ");
		}

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 2) {
			if (getActualPlayer() == 0) 
				System.out.println("The player 1 ("+ getDISPLAYP1() + ") won the game with his "
						+ " vertical alignment !");
			if (getActualPlayer() == 1)
				System.out.println("The player 2 ("+ getDISPLAYP2() + ") won the game with his "
						+ "vertical alignment !");
		}

		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 3) {
			if (getActualPlayer() == 0) 
				System.out.println("The player 1 ("+ getDISPLAYP1() + ") won the game with his "
						+ "first diagonal alignment !");
			if (getActualPlayer() == 1)
				System.out.println("The player 2 ("+ getDISPLAYP2() + ") won the game with his "
						+ "first diagonal alignment !");
		}


		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 4) {
			if (getActualPlayer() == 0) 
				System.out.println("The player 1 ("+ getDISPLAYP1() + ") won the game with his "
						+ "second diagonal alignment !");
			if (getActualPlayer() == 1)
				System.out.println("The player 2 ("+ getDISPLAYP2() + ") won the game with his "
						+ "second diagonal alignment !");
		}
	}
}