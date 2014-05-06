/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : ArrayIndexOutOfBoundsException.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 ***************************************************
 */

package be.umons.exception;

/**
 * <b> Exception call when the user try to use an existing location. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class ArrayIndexOutOfBoundsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ArrayIndexOutOfBoundsException() {
		System.out.println("You are out of the array, please chooce an other position");
	}
}