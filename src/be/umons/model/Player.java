/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : TicTacToe.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

/**
 * This class give the possibility to initialize a player with his informations
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
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
	 * 			Array with the number of points of the player
	 * 
	 * @param pointsIA
	 * 			Array with the number of points of the IA
	 */
	
	public Player(/*String name, int[] points, int[] pointsIA*/)
	{
		/*this.name = name;
		this.points = points;
		this.pointsIA = pointsIA;*/
	}
	
	public Player(String string) {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * This method will make possible to get the position of a player
	 * 
	 * @return position
	 * 			Position of a player
	 */

	public int getPosition()
	{
		return position;
	}
	
	/**
	 * This method make possible to set a position of a player
	 * 
	 * @param position
	 * 			Generate a position
	 */
	
	public void setPosition(int position)
	{
		this.position = position;
	}
	
	/** 
	 * This method will make possible to get the name of a player
	 * 
	 * @return name
	 * 			Name of a player
	 */
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method make possible to set a name  of a player
	 * 
	 * @param name
	 * 			Generate a position
	 */

	public void setName(String name)
	{
		this.name = name;
	}
}