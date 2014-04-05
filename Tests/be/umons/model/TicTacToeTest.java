package be.umons.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import be.umons.model.TicTacToe;

import org.junit.Test;

public class TicTacToeTest {
	
	List<Object> list = new ArrayList<Object>();
	TicTacToe ttt = new TicTacToe(list);

	@Test
	public void testCheckWinnerForTheFirstPlayerWithHorizontal() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][0] = 0;
		array[0][1] = 0;
		assertTrue(ttt.checkWinner(0, 2, 0) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithVertical() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][0] = 0;
		array[1][0] = 0;
		assertTrue(ttt.checkWinner(2, 0, 0) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithFirstDiagonal() throws Exception {
		int[][] array =  ttt.getGameTable();
		array[0][2] = 0;
		array[1][1] = 0;
		assertTrue(ttt.checkWinner(2, 0, 0) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithSecondDiagonal() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][0] = 0;
		array[1][1] = 0;
		assertTrue(ttt.checkWinner(2, 2, 0) == 4);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithHorizontal() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][0] = 0;
		array[0][1] = 0;
		assertTrue(ttt.checkWinner(0, 2, 1) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithVertical() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][0] = 0;
		array[1][0] = 0;
		assertTrue(ttt.checkWinner(2, 0, 1) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithFirstDiagonal() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][2] = 0;
		array[1][1] = 0;
		assertTrue(ttt.checkWinner(2, 0, 1) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithSecondDiagonal() throws Exception {
		int[][] array = ttt.getGameTable();
		array[0][0] = 0;
		array[1][1] = 0;
		assertTrue(ttt.checkWinner(2, 2, 1) == 4);
	}
}