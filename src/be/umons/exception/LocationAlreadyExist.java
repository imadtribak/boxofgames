/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : LocationAlreadyExist.java
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

public class LocationAlreadyExist extends Exception
{
	private static final long serialVersionUID = 1L;

	public LocationAlreadyExist()
	{
		System.out.println("Please, select an other position. Thanks");
	}
}