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
 * <b> Player is the class that permit to initialize a player with his informations. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class Player {
	
	private String name;
	
	// NOTES: array, each place is a different game. 0 for TicTacToe, 
	// 1 for Four In A Line and 2 for Othello
	
	private int[] points;
	private int[] pointsIA;
	private int position;
	
	/**
	 * <b> Constructor that initialize a name and a new arrays with his number
	 * of points. </b>
	 * 
	 * @param name
	 * 			Name of the player
	 * 
	 * @param points
	 * 			Points of the player
	 * 
	 * @param pointsIA
	 * 			Points of the IA
	 */
	
	public Player(String name/*, int[] points, int[] pointsIA*/)
	{
		this.name = name;
		//this.points = points;
		//this.pointsIA = pointsIA;*/
	}
	
	/**
	 * <b> Default constructor that initialize a player. </b>
	 */

	public Player() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <b> Method that get the position of a player. </b>
	 * 
	 * @return position
	 * 			Position of a player
	 */

	public int getPosition()
	{
		return position;
	}
	
	/**
	 * <b> Method that set the position of a player. </b>
	 * 
	 * @param position
	 * 			Generate a position
	 */
	
	public void setPosition(int position)
	{
		this.position = position;
	}
	
	/** 
	 * <b> Method that get the name of a player. </b>
	 * 
	 * @return name
	 * 			Name of a player
	 */
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * <b> Method that set the name of a player. </b>
	 * 
	 * @param name
	 * 			Name of a player
	 */

	public void setName(String name)
	{
		this.name = name;
	}
}