/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : OutOfBoundsExceptionjava
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.exception;

/**
 * Exception call when the user try to use a location out of bounds
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class OutOfBoundsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public OutOfBoundsException()
	{
		System.out.println("Out of bounds !");
	}
}