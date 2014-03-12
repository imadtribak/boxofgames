package com.umons.model;

import java.util.Random;

/**
 * This class give the possibility to play versus a computer with different levels
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class AI extends Player
{
	/*
	 * *****************************************************************
	 * Attributes
	 * *****************************************************************
	 */
	
	 private int[][] gameTable;
	
	/**
	 * This constructor initialize an array
	 */
	 
	 public AI(int rows, int columns)
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
	 * This method give the level 'easy' of the computer
	 * 
	 * @return gameTable[x][y]
	 * 			
	 */
	
	public int easyDifficulty()
	{
		int[][] array = getGameTable();
		Random move = new Random();
		for (int i = 0; i < array.length ; i++)
		{
			for (int j = 0; j < array.length ; j++)
			{
				while (array[i][j] == 0)
				{
					int x = move.nextInt(3);
					int y = move.nextInt(3);
					return gameTable[x][y];
				}	
			}
		}
		
		return -1;
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
}