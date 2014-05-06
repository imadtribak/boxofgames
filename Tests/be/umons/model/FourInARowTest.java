/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : FourInARowTest.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import be.umons.model.FourInARow;

import org.junit.Test;

/**
 * <b> FourInARowTest is the test class that permit to test the Four in a Row game. </b>
 * 
 * <p> This class extend the class TicTacToe. </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class FourInARowTest {

	List<Object> list = new ArrayList<Object>();
	FourInARow fiar = new FourInARow(list);
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithHorizontal() throws Exception {
		fiar.getGameTable()[5][0] = 0;
		fiar.getGameTable()[5][1] = 0;
		fiar.getGameTable()[5][2] = 0;
		assertTrue(fiar.checkWinner(5, 3, 0) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithVertical() throws Exception {
		fiar.getGameTable()[5][0] = 0;
		fiar.getGameTable()[4][0] = 0;
		fiar.getGameTable()[3][0] = 0;
		assertTrue(fiar.checkWinner(2, 0, 0) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithFirstDiagonal() throws Exception {
		fiar.getGameTable()[5][0] = 0;
		fiar.getGameTable()[4][1] = 0;
		fiar.getGameTable()[3][2] = 0;
		assertTrue(fiar.checkWinner(2, 3, 0) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithSecondDiagonal() throws Exception {
		fiar.getGameTable()[0][0] = 0;
		fiar.getGameTable()[1][1] = 0;
		fiar.getGameTable()[2][2] = 0;
		assertTrue(fiar.checkWinner(3, 3, 0) == 4);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithHorizontal() throws Exception {
		fiar.getGameTable()[5][0] = 1;
		fiar.getGameTable()[5][1] = 1;
		fiar.getGameTable()[5][2] = 1;
		assertTrue(fiar.checkWinner(5, 3, 1) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithVertical() throws Exception {
		fiar.getGameTable()[5][0] = 1;
		fiar.getGameTable()[4][0] = 1;
		fiar.getGameTable()[3][0] = 1;
		assertTrue(fiar.checkWinner(2, 0, 1) == 2);
	}
	
	@Test
	public void testCheckWinnerForThSecondPlayerWithFirstDiagonal() throws Exception {
		fiar.getGameTable()[5][0] = 1;
		fiar.getGameTable()[4][1] = 1;
		fiar.getGameTable()[3][2] = 1;
		assertTrue(fiar.checkWinner(2, 3, 1) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithSecondDiagonal() throws Exception {
		fiar.getGameTable()[0][0] = 1;
		fiar.getGameTable()[1][1] = 1;
		fiar.getGameTable()[2][2] = 1;
		assertTrue(fiar.checkWinner(3, 3, 1) == 4);
	}
}