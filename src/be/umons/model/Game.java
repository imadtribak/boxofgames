/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : Game.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import be.umons.exception.BoundOutreachedException;

/**
 * <b> Game is the superclass of all games. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public abstract class Game {

	private static String DISPLAYP1 = "*";
	private static String DISPLAYP2 = "o";

	private int actualPlayer = 1;
	private int[][] gameTable;
	private int lastX = -1, lastY = -1;

	private List <Object> listPlayer; 

	public abstract void letsPlay() throws BoundOutreachedException;

	/**
	 * <b> Constructor that initialize an array. </b>
	 * 
	 * @param rows
	 *			Number of rows
	 * 
	 * @param columns
	 * 			Number of columns
	 * 
	 * @param List <Object> listPlayer
	 *  		List of players
	 */

	public Game(int rows, int columns, List <Object> listPlayer) {
		gameTable = arrayGenerator(rows, columns);
		this.listPlayer = listPlayer;
	}

	/**
	 * <b> Method that generate a layout of a game. </b>
	 * 
	 * @param rows
	 * 			Number of rows
	 * 
	 * @param columns
	 *			Number of columns
	 */

	public int[][] arrayGenerator(int rows, int columns) {
		int [][] array = new int [rows][columns];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = 2;
			}
		}
		return array;
	}

	/**
	 * This method make possible to choice the players.
	 */

	// NOTE: This method don't working.

	public void choiceOfPlayers() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("######################");
			System.out.println("##### PLAYER 1 #####");
			System.out.println("######################\n");
			System.out.println("1. Human");
			System.out.println("2. Computer");
			int player1 = sc.nextInt();

			List<Player> list = new ArrayList<Player>();

			while (true) {
				switch (player1) {
				case 1:
					list.add(new Player());
					break;

				case 2:
					AI ai = new AI();
					ai.easyDifficulty();
					list.add(ai);
					break;

				default:
					System.out.println("Please, choose a number between 1 and 2\n");
					choiceOfPlayers();
				}

				System.out.println("######################");
				System.out.println("##### PLAYER 2 #####");
				System.out.println("######################\n");
				System.out.println("1. Human");
				System.out.println("2. Computer");
				int player2 = sc.nextInt();

				switch (player2) {
				case 1:
					list.add(new Player());
					break;

				case 2:
					AI ai = new AI();
					ai.easyDifficulty();
					list.add(ai);
					break;

				default:
					System.out.println("Please, choose a number between 1 and 2\n");
					choiceOfPlayers();
				}
				break;
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			choiceOfPlayers();
		}	
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
			System.out.print(" ");
			System.out.print(i);
			System.out.print("");

			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0) display = DISPLAYP1;
				else if (array[i][j] == 1) display = DISPLAYP2;
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
	 * <b> Method that print the player. </b>
	 */
	
	public void displayPlayer() {
		if (getActualPlayer() == 0) {
			System.out.println("+---------------------+");
			System.out.println("| Player 1's turn ("+ getDISPLAYP1() + ") |");
			System.out.println("+---------------------+ \n");
		} else {
			System.out.println("+---------------------+");
			System.out.println("| Player 2's turn ("+ getDISPLAYP2() + ") |");
			System.out.println("+---------------------+ \n");
		}
	}

	/**
	 * <b> Method that make possible to switch player. </b>
	 */

	public void changePlayer() {
		actualPlayer = (actualPlayer == 1) ? 0 : 1;
		displayPlayer();
	}

	/**
	 * <b> Method that make possible to choose a position.  </b>
	 * 
	 * @param player
	 * 			Currently player
	 */

	@SuppressWarnings("resource")
	public void select(int player) {
		int x = 0, y = 0;
		boolean success = true;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Select a row: ");
			x = sc.nextInt();
			System.out.println("Select a column: ");
			y = sc.nextInt();
			if (x >= 0 && x < gameTable.length) { 
				if (y >= 0 && y < gameTable[x].length) {
					if (gameTable[x][y] == 2)
						success = false;
					else {
						clearConsole();
						displayArray();
						System.out.println("This emplacement is already taken ! \n");
						displayPlayer();
					}
				} else {
					clearConsole();
					displayArray();
					System.out.println("Your column is out of the array ! \n");
					displayPlayer();
				}
			} else {
				clearConsole();
				displayArray();
				System.out.println("Your row is out of the array ! \n");
				displayPlayer();
			}
		} while (success);
		if (player == 0)
			gameTable[x][y] = 0;
		else 
			gameTable[x][y] = 1;
		setLastX(x);
		setLastY(y);
	}

	/**
	 * <b> Method that clear the console. </b>
	 */

	public void clearConsole() {
		try {
			if (System.getProperty("os.name").startsWith("Windows"))
				Runtime.getRuntime().exec("cls");
			else
				Runtime.getRuntime().exec("clear"); 
		} catch(Exception e) {
			for (int i = 0; i < 50; i++)
				System.out.println();
		}
	}

	/**
	 * Method that tell if a game is end or not.
	 * 
	 * @return <b> false </b>
	 * 			Not empty array
	 * 
	 * @return <b> true </b>
	 *  		Empty array
	 */

	public boolean endGame() {
		int[][] array = getGameTable();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 2)
					return false;
			}
		}
		return true;
	}

	/**
	 * <b> Method that make possible to have a delay.
	 * 
	 * @param seconds
	 * 			Time in seconds
	 */

	public void delay(int seconds) {
		int time = (int) seconds * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b> Method that make possible to "textually represents" an object. </b>
	 * 
	 * @return A string representation of the object
	 */

	@Override
	public String toString() {
		return "Game [gameTable=" + Arrays.toString(gameTable) + "]";
	}

	/** 
	 * <b> Method that get gameTable. </b>
	 * 
	 * @return gameTable
	 * 			Table of the game
	 */

	public int[][] getGameTable() {
		return gameTable;
	}

	/**
	 * <b> Method that set gameTable. </b>
	 * 
	 * @param gameTable
	 * 			Generate an array
	 */

	public void setGameTable(int[][] gameTable) {
		this.gameTable = gameTable;
	}

	/** 
	 * <b> Method that get lastX. </b>
	 * 
	 * @return lastX
	 * 			X position
	 */

	public int getLastX() {
		return lastX;
	}

	/** 
	 * <b> Method that set LastX. </b>
	 */

	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	/** 
	 * <b> Method that get lastY. </b>
	 * 
	 * @return lastY
	 *  		Y position
	 */

	public int getLastY() {
		return lastY;
	}

	/** 
	 * <b> Method that set lastY. <b>
	 */

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}

	/** 
	 * <b> Method that get listPlayer. </b>
	 * 
	 * @return listPlayer
	 *  		List of players
	 */

	public List<Object> getListPlayer() {
		return listPlayer;
	}

	/** 
	 * <b> Method that set listPlayer. </b>
	 */

	public void setListPlayer(List<Object> listPlayer) {
		this.listPlayer = listPlayer;
	}

	/** 
	 * <b> Method that get actualPlayer. </b>
	 * 
	 * @return actualPlayer
	 *  		Currently player
	 */

	public int getActualPlayer() {
		return actualPlayer;
	}

	/** 
	 * <b> Method that set actualPlayer. </b>
	 */

	public void setActualPlayer(int actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

	/** 
	 * <b> Method that get DISPLAYP1. </b>
	 * 
	 * @return DISPLAYP2
	 *			Display of the second player
	 */

	public static String getDISPLAYP1() {
		return DISPLAYP1;
	}

	/** 
	 * <b> Method that set DISPLAYP1. </b>
	 */

	public static void setDISPLAYP1(String dISPLAYP1) {
		DISPLAYP1 = dISPLAYP1;
	}

	/** 
	 * <b> Method that get DISPLAYP1. </b>
	 * 
	 * @return DISPLAYP2
	 *			Display of the second player
	 */

	public static String getDISPLAYP2() {
		return DISPLAYP2;
	}

	/** 
	 * <b> Method that set DISPLAYP2. </b>
	 */

	public static void setDISPLAYP2(String dISPLAYP2) {
		DISPLAYP2 = dISPLAYP2;
	}
}