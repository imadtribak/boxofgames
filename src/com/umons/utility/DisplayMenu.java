/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : MainMenu.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.utility;

import java.util.Scanner;

import com.umons.model.Game;
import com.umons.model.TicTacToe;
import com.umons.model.FourInALine;
import com.umons.model.Othello;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */
 
public class DisplayMenu
{
	/**
	 * This method print the menu of games
	 */
	
	public static void printMenu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the game you want to play:\n");
		System.out.println("1. Tic-Tac-Toe\n");
		System.out.println("2. Four-In-A-Line\n");
		System.out.println("3. Othello\n");
		System.out.println("4. Quit\n");
		int choice = sc.nextInt();

		while (choice > 0 && choice < 5)
		{
			System.out.println("Select the game you want to play:\n");
			System.out.println("1. Tic-Tac-Toe\n");
			System.out.println("2. Four-In-A-Line\n");
			System.out.println("3. Othello\n");
			System.out.println("4. Quit\n");
			choice = sc.nextInt();
		}		

		switch (choice)
		{
			case 1:
				TicTacToe tic_tac_toe = new TicTacToe();
				System.out.println(tic_tac_toe.getGameTable());
				break;
			
			case 2:
				FourInALine four_in_a_line = new FourInALine();
				System.out.println(four_in_a_line.getGameTable());
				break;
				
			case 3:
				Othello othello = new Othello();
				System.out.println(othello.getGameTable());
				break;

			case 4:
				System.exit(0);
				break;
				
			default:
				System.out.println("Please, try again");
		}
		
		sc.close();
	}
}