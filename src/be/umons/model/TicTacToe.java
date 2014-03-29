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
	 * Constructor that initialize an array with a number of 3 rows and a number of 3 columns
	 * and a list of player.
	 * 
	 * @param List <Object> list
	 * 			List of players
	 */
	
	public TicTacToe(List <Object> list) {
		super(3, 3, list);	
	}
	
	/**
	 * Method that give the possibility to choice a board size.
	 * 
	 */
	
	// NOTE: Cette méthode ne marche pas !
	
	public void printBoardSize() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("######################");
			System.out.println("##### BOARD SIZE #####");
			System.out.println("######################\n");
			System.out.println("1. 3x3\n");
			System.out.println("2. 4x4\n");
			System.out.println("3. 5x5\n");
			System.out.println("4. Quit\n");
			int choice = sc.nextInt();

			while (true) {
				switch (choice) {
					case 1:
						arrayGenerator(3, 3);
						break;
	
					case 2:
						arrayGenerator(4, 4);
						break;
	
					case 3:
						arrayGenerator(5, 5);
						break;
	
					case 4:
						System.exit(0);
						break;
	
					default:
						System.out.println("Please, choose a number between 1 and 4\n");
						printBoardSize();
				}
				break;
			}
			sc.close();
		} catch (Exception ex) {
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			printBoardSize();
		}
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
		if (i >= 3 || i < 0 || j >= 3 || j < 0)
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

	public int checkWinner(int i, int j, int player) {
		
		if (isDraw() == true)
			return 0;
		
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
	
	
	/**
	 * Method that make possible to play to the game.
	 * 
	 * @throws BoundOutreachedException 
	 * 			Generate exception
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
		
		if (checkWinner(getLastX(), getLastY(), getActualPlayer()) == 0)
			System.out.println(" The game is tied !");
			
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