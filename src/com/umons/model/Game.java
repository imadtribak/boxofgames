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

import java.util.Scanner;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public abstract class Game 
{
	/*
	 * *****************************************************************
	 * Attributes
	 * *****************************************************************
	 */

	private String[][] gameTable;
	
	/**
	 * This constructor initialize an array with a number of rows and a number of columns
	 */
	
	public Game(int rows, int columns)
	{
		gameTable = arrayGenerator(rows, columns);
	}
	
	/**
	 * This method generate a layout of a game
	 * 
	 * @param rows
	 * 			Number of rows
	 * 
	 * @param columns
	 * 			Number of columns
	 */

	public final String[][] arrayGenerator (int rows, int columns)
	{
		String [][] array = new String [rows][columns];
		for (int i = 0; i < array.length; i++)  
		{
			for (int j = 0; j < array.length ; j++)
			{
				array[i][j] = "[ ]";
			}
		}

		return array;
	}

	public abstract boolean checkWinner();
	//public abstract void letsPlay();
	
	/** 
	 * This method will make possible to get the array with his number of rows
	 * and his number of columns
	 * 
	 * @return gameTable
	 */
	
	public String[][] getGameTable()
	{
		return gameTable;
	}
	
	/**
	 * This method make possible to set a new array with a number of rows
	 * and a numbers of columns
	 * 
	 * @param gameTable
	 * 			Generate an array
	 */
	
	public void setGameTable(String[][] gameTable)
	{
		this.gameTable = gameTable;
	}
	
	/**
	 * This method make possible to "textually represents" an object
	 * 
	 * @return gameTable[x][y]
	 * 			Replacerow and the columns gaven
	 */
	
	/*public int select()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a row: ");
		int x = sc.nextInt();
		System.out.println("Select a column: ");
		int y = sc.nextInt();
		return gameTable[x][y] = 'X';
		sc.close();
	}
	*/
	
	/**
	 * This method make possible to "textually represents" an object
	 * 
	 * @return A string representation of the object.
	 */

	public String toString()
	{
		return gameTable.toString();
	}
}