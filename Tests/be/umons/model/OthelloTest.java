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

import java.util.ArrayList;
import java.util.List;

import be.umons.model.Othello;

import org.junit.Test;

/**
 * <b> OthelloTest is the test class that permit to test the Othello game. </b>
 * 
 * <p> This class extend the class TicTacToe. </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class OthelloTest {

	List<Object> list = new ArrayList<Object>();
	Othello othello = new Othello(list);

	@Test
	public void testCheckWinnerIfDraw() throws Exception {
		othello.countplayer1 = 50;
		othello.countplayer2 = 50;
		assertTrue(othello.checkWinner() == 0);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayer() throws Exception {
		othello.countplayer1 = 51;
		assertTrue(othello.checkWinner() == othello.countplayer1);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayer() throws Exception {
		othello.countplayer2 = 51;
		assertTrue(othello.checkWinner() == othello.countplayer2);
	}
}