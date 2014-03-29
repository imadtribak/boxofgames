/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : BoundOutreachedException.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.exception;

/**
 * Exception call when the user try to use an existing location
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class BoundOutreachedException extends Exception
{
	private static final long serialVersionUID = 1L;

	public BoundOutreachedException()
	{
		System.out.println("You are out of the array !");
	}
}