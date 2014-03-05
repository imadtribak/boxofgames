/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : TicTacToe.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.model;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class Player
{
	/*
	 * *****************************************************************
	 * Attributes
	 * *****************************************************************
	 */
	
	private String name;
	// NOTES: array, each place is a different game. 0 for TicTacToe, 
	// 1 for Four In A Line and 2 for Othello
	private int[] points;
	private int[] pointsIA;
	
	private int position;
	
	/**
	 * This constructor initialize a name and a new array with his number of points
	 * 
	 * @param name
	 * 			Name of the player
	 * 
	 * @param points
	 * 			Array with his number of points
	 */
	
	public Player(String name, int[] points, int[] pointsIA)
	{
		this.name = name;
		this.points = points;
		this.pointsIA = pointsIA;
	}

	public int getPosition() {
		return position;
	} 

	public void setPosition(int position) {
		this.position = position;
	}
	
	
}