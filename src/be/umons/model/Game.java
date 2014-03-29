/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : Game.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.umons.exception.BoundOutreachedException;

/**
 * <b> Game is the superclass of all games. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public abstract class Game {
	
	private int actualPlayer = 2;
	private int[][] gameTable;
	private int lastX = -1, lastY = -1;

	private List <Object> listPlayer; 

	public abstract int checkWinner(int i, int j, int player) throws BoundOutreachedException;
	public abstract void letsPlay() throws BoundOutreachedException;
	public abstract void displayArray() ;
	
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
			for (int j = 0; j < array.length; j++) {
				array[i][j] = 0;
			}
		}
		return array;
	}

	/**
	 * <b> Method that make possible to choice a position.  </b>
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
			if (x < gameTable.length) { 
				if (y < gameTable[x].length) {
					if (gameTable[x][y] == 0) {
						success = false;
					} else {
						System.out.println("This emplacement is already taken ! \n");
					}
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
	}

	/**
	 * <b> Method that make possible to switch player. </b>
	 */

	public void changePlayer() {
		actualPlayer = (actualPlayer == 2) ? 1 : 2;
	}

	/**
	 * <b> Method that make possible to check if game tied or not. </b>
	 * 
	 * @return boolean
	 * 			<p> <b>False:</b> game not tied </p>
	 * 			<b>True:</b> game tied
	 */

	public boolean isDraw() {
		int[][] array = getGameTable();	
		for (int i = 0; i < array.length ; i++) {
			for (int j = 0; j < array.length ; j++) {
				if (array[i][j] == 0)
					return false;
			}
		}
		return true;
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
	 * This method make possible to choice the players.
	 */

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
		} catch (Exception ex) {
			System.out.println("ERROR: Invalid Type - Please, enter an integer number\n");
			choiceOfPlayers();
		}	
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
	 * <b> Method that make possible to get the array with his number of rows
	 * and his number of columns </b>
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
	 * <b> Method that make getLastY. </b>
	 * 
	 * @return lastY
	 *  			Y position
	 */

	public int getLastY() {
		return lastY;
	}

	/** 
	 * <b> Method that set LastY. <b>
	 */

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}

	/** 
	 * <b> Method that get listPlayer. </b>
	 * 
	 * @return listPlayer
	 *  			List of players
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
	 *  			Currently player
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
}