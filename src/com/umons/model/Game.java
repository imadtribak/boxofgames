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
import java.util.List;
import java.util.Scanner;

/**
 * This class give the possibility to make the legacy with other games
 * with same methods
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public abstract class Game 
{
	/*
	 * *****************************************************************
	 * Attributes
	 * *****************************************************************
	 */

	private List<Player> listPlayer;  
	private int actualPlayer = 1;
	private int[][] gameTable;
	private int lastX = -1 , lastY = -1;
	
	/**
	 * This constructor initialize an array with a number of rows and a number of columns
	 * and the list of players
	 * 
	 * @param rows
	 *  			Number of rows
	 * 
	 * @param columns
	 *  			Number of columns
	 * 
	 * @param List<Player> listPlayer
	 *  			List of players
	 *  
	 */
	
	public Game(int rows, int columns, List<Player> listPlayer)
	{
		gameTable = arrayGenerator(rows, columns);
		this.listPlayer = listPlayer;
	}
	
	public abstract int checkWinner(int i, int j);
	public abstract void letsPlay();
	
	/**
	 * This method generate a layout of a game
	 * 
	 * @param rows
	 * 			Number of rows
	 * 
	 * @param columns
	 * 			Number of columns
	 * 
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
	 * This method make possible to choice a position
	 * 
	 * @param player
	 * 			Number of players
	 * 
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
		
		// NOTE: Appelle d'une méthode de représentation du tableau (A faire)
		
		setLastX(x);
		setLastY(y);
	}
	
	/**
	 * This method make possible to switch player
	 * 
	 */
	
	public void changePlayer()
	{
		actualPlayer = (actualPlayer == 1) ? 1 : 2 ;
	}
	
	/**
	 * This method make possible to check if game tied or not
	 * 
	 * @return boolean
	 * 			false if the game isn't tied, true if the game is tied
	 * 
	 */
	
	public boolean isDraw()
	{
		int[][] array = getGameTable();
		
		for (int i = 0; i < array.length ; i++)
		{
			for (int j = 0; j < array.length ; j++)
			{
				if (array[i][j] == 0)
					return false;
			}
		}
		
		return true;
	}
	
	/**
	 * This method make possible to "textually represents" an object
	 * 
	 * @return A string representation of the object
	 * 
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
	 * 
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
	
	/*
	 * *****************************************************************
	 * Getters & Setters
	 * *****************************************************************
	 */
	
	/** 
	 * This method will make possible to get the array with his number of rows
	 * and his number of columns
	 * 
	 * @return gameTable
	 * 			The table of the game
	 * 
	 */
	
	public int[][] getGameTable()
	{
		return gameTable;
	}
	
	/**
	 * This method make possible to set a new array with a number of rows
	 * and a number of columns
	 * 
	 * @param gameTable
	 * 			Generate an array
	 * 
	 */
	
	public void setGameTable(int[][] gameTable)
	{
		this.gameTable = gameTable;
	}
	
	/** 
	 * This method will make possible to get the last X move of a player
	 * 
	 * @return lastX
	 * 			The X position		
	 * 	
	 */
	
	public int getLastX()
	{
		return lastX;
	}

	/** 
	 * This method will make possible to set the last X move of a player
	 * 
	 */
	
	public void setLastX(int lastX)
	{
		this.lastX = lastX;
	}

	/** 
	 * This method will make possible to get the last Y move of a player
	 * 
	 * @return lastY
	 *  			The Y position
	 *  
	 */
	
	public int getLastY()
	{
		return lastY;
	}

	/** 
	 * This method will make possible to set the last Y move of a player
	 * 
	 */
	
	public void setLastY(int lastY)
	{
		this.lastY = lastY;
	}

	/** 
	 * This method will make possible to get the list of players
	 * 
	 * @return listPlayer
	 *  			List of players
	 *  
	 */
	
	public List<Player> getListPlayer()
	{
		return listPlayer;
	}
	
	/** 
	 * This method will make possible to set the last move of a player
	 * 
	 */

	public void setListPlayer(List<Player> listPlayer)
	{
		this.listPlayer = listPlayer;
	}

	/** 
	 * This method will make possible to get the actual player
	 * 
	 * @return actualPlayer
	 *  			Currently player
	 *  
	 */
	
	public int getActualPlayer()
	{
		return actualPlayer;
	}

	/** 
	 * This method will make possible to set the last move of a player
	 * 
	 */
	
	public void setActualPlayer(int actualPlayer)
	{
		this.actualPlayer = actualPlayer;
	}
}