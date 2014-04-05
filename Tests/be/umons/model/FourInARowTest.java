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
		int[][] array = fiar.getGameTable();
		array[5][0] = 0;
		array[5][1] = 0;
		array[5][2] = 0;
		assertTrue(fiar.checkWinner(5, 3, 0) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithVertical() throws Exception {
		int[][] array = fiar.getGameTable();
		array[5][0] = 0;
		array[4][0] = 0;
		array[3][0] = 0;
		assertTrue(fiar.checkWinner(2, 0, 0) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithFirstDiagonal() throws Exception {
		int[][] array = fiar.getGameTable();
		array[5][0] = 0;
		array[4][1] = 0;
		array[3][2] = 0;
		assertTrue(fiar.checkWinner(2, 1, 0) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithSecondDiagonal() throws Exception {
		int[][] array = fiar.getGameTable();
		array[0][0] = 0;
		array[1][1] = 0;
		array[2][2] = 0;
		assertTrue(fiar.checkWinner(3, 3, 0) == 4);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithHorizontal() throws Exception {
		int[][] array = fiar.getGameTable();
		array[5][0] = 0;
		array[5][1] = 0;
		array[5][2] = 0;
		assertTrue(fiar.checkWinner(5, 3, 1) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithVertical() throws Exception {
		int[][] array = fiar.getGameTable();
		array[5][0] = 0;
		array[4][0] = 0;
		array[3][0] = 0;
		assertTrue(fiar.checkWinner(2, 0, 1) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithFirstDiagonal() throws Exception {
		int[][] array = fiar.getGameTable();
		array[5][0] = 0;
		array[4][1] = 0;
		array[3][2] = 0;
		assertTrue(fiar.checkWinner(2, 1, 1) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithSecondDiagonal() throws Exception {
		int[][] array = fiar.getGameTable();
		array[0][0] = 0;
		array[1][1] = 0;
		array[2][2] = 0;
		assertTrue(fiar.checkWinner(3, 3, 1) == 4);
	}
}