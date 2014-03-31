/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : OthelloTest.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <b> OthelloTest is the test class that permit to test the Othello game. </b>
 * 
 * <p> This class extend the class TicTacToe. </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class OthelloTest extends Othello {

	/**
	 * <b> Constructor that initialize a list of player. </b>
	 * 
	 * @param List <Object> listPlayer
	 *  		List of players
	 */
	
	public OthelloTest(List <Object> list) {
		super(list);
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckWinnerIfDraw() throws Exception {
		countplayer1 = 50;
		countplayer2 = 50;
		assertTrue(checkWinner() == 0);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayer() throws Exception {
		countplayer1 = 51;
		assertTrue(checkWinner() == countplayer1);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayer() throws Exception {
		countplayer2 = 51;
		assertTrue(checkWinner() == countplayer2);
	}
}
