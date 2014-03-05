/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : ArrayIndexOuOfBoundsException.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package com.umons.exception;

/**
 * Exception call when the user try to use an existing location
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 * 
 */

public class ArrayIndexOuOfBoundsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ArrayIndexOuOfBoundsException()
	{
		System.out.println("You are out of the array, please chooce an other position");
	}
}