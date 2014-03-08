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

import com.umons.model.TicTacToe;
import com.umons.model.FourInARow;
import com.umons.model.Othello;

/**
 * This class give the possibility to have menu containing the different games:
 * Tic-Tac-Toe, Four in a Row, Othello
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class DisplayMenu
{
	/**
	 * This method print the menu of games
	 */
	
	public static void printMenu()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Tic-Tac-Toe\n");
			System.out.println("2. Four-In-A-Line\n");
			System.out.println("3. Othello\n");
			System.out.println("4. Quit\n");
			int choice = sc.nextInt();
            
    		while (true)
    		{
				switch (choice)
				{
					case 1:
						TicTacToe tic_tac_toe = new TicTacToe();
						System.out.println(tic_tac_toe.getGameTable());
						break;
						
					case 2:
						FourInARow four_in_a_line = new FourInARow();
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
						System.out.println("Please, choose a number between 1 and 4\n");
						printMenu();
				}
				
			break;
    		}
    		
			sc.close();
		}
		
		catch (Exception ex)
		{
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			printMenu();
		}
	}
}