/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : DisplayMenu.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import be.umons.model.FourInARow;
import be.umons.model.Othello;
import be.umons.model.Player;
import be.umons.model.TicTacToe;

/**
 * <b> DisplayMenu is the class that permit have menu containing the different games: 
 * Tic-Tac-Toe, Four in a Row, Othello. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class DisplayMenu {

	/**
	 * <b> Method that make possible to choose a game.  </b>
	 */

	public static void printMenu() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Tic-Tac-Toe\n");
			System.out.println("2. Four in a Row\n");
			System.out.println("3. Othello\n");
			System.out.println("4. Quit\n");
			int choice = sc.nextInt();

			List<Object> list = new ArrayList<Object>();
			list.add(new Player());
			list.add(new Player());

			while (true) {
				switch (choice) {
				case 1:
					TicTacToe ttt = new TicTacToe(list);
					ttt.letsPlay();
					break;

				case 2:
					FourInARow fiar = new FourInARow(list);
					fiar.letsPlay();
					break;

				case 3:
					Othello othello = new Othello(list);
					othello.letsPlay();
					break;

				case 4:
					System.out.println("Goodbye !");
					System.exit(0);
					break;

				default:
					System.out.println("Please, choose a number between 1 and 4\n");
					printMenu();
				}
				break;
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			printMenu();
		}
	}
}