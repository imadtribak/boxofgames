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

import java.util.Arrays;
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

	private int[][] gameTable;
	
	/**
	 * This constructor initialize an array with a number of rows and a number of columns
	 */
	
	public Game(int rows, int columns)
	{
		gameTable = arrayGenerator(rows, columns);
	}
	
	public abstract boolean checkWinner();
	public abstract void letsPlay();
	
	/**
	 * This method generate a layout of a game
	 * 
	 * @param rows
	 * 			Number of rows
	 * 
	 * @param columns
	 * 			Number of columns
	 */

	public int[][] arrayGenerator (int rows, int columns)
	{
		int [][] array = new int [rows][columns];
		for (int i = 0; i < array.length; i++)  
		{
			for (int j = 0; j < array.length ; j++)
			{
				array[i][j] = 0;
			}
		}
		return array;
	}
	
	/** 
	 * This method will make possible to get the array with his number of rows
	 * and his number of columns
	 * 
	 * @return gameTable
	 */
	
	public int[][] getGameTable()
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
	
	public void setGameTable(int[][] gameTable)
	{
		this.gameTable = gameTable;
	}
	
	/**
	 * This method make possible to choice a position
	 * 
	 * @param player
	 * 			Number of players
	 * 
	 * @return gameTable[x][y]
	 * 			Replace the row and the column for the value
	 */
	
	public void select(int player)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a row: ");
		int x = sc.nextInt();
		System.out.println("Select a column: ");
		int y = sc.nextInt();
		sc.close();
		if (player == 1)
			gameTable[x][y] = 1;
		else 
			gameTable[x][y] = 2;
	}
	
	/**
	 * This method make possible to "textually represents" an object
	 * 
	 * @return A string representation of the object
	 */
	
	@Override
	public String toString()
	{
		return "Game [gameTable=" + Arrays.toString(gameTable) + "]";
	}

	/**
	 * This method make possible to have a delay
	 * 
	 * @param seconds
	 * 			Time in seconds
	 */
	
	public void delay(int seconds)
	{
	  int time = (int)seconds * 1000;
	  try
	  {
	     Thread.sleep(time);
	  }
	  catch(InterruptedException e)
	  {
	     e.printStackTrace();
	  }
	}
}