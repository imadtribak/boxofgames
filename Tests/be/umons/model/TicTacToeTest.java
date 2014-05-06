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
		ttt.getGameTable()[0][0] = 0;
		ttt.getGameTable()[0][1] = 0;
		assertTrue(ttt.checkWinner(0, 2, 0) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithVertical() throws Exception {
		ttt.getGameTable()[0][0] = 0;
		ttt.getGameTable()[1][0] = 0;
		assertTrue(ttt.checkWinner(2, 0, 0) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithFirstDiagonal() throws Exception {
		ttt.getGameTable()[0][2] = 0;
		ttt.getGameTable()[1][1] = 0;
		assertTrue(ttt.checkWinner(2, 0, 0) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheFirstPlayerWithSecondDiagonal() throws Exception {
		ttt.getGameTable()[0][0] = 0;
		ttt.getGameTable()[1][1] = 0;
		assertTrue(ttt.checkWinner(2, 2, 0) == 4);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithHorizontal() throws Exception {
		ttt.getGameTable()[0][0] = 1;
		ttt.getGameTable()[0][1] = 1;
		assertTrue(ttt.checkWinner(0, 2, 1) == 1);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithVertical() throws Exception {
		ttt.getGameTable()[0][0] = 1;
		ttt.getGameTable()[1][0] = 1;
		assertTrue(ttt.checkWinner(2, 0, 1) == 2);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithFirstDiagonal() throws Exception {
		ttt.getGameTable()[0][2] = 1;
		ttt.getGameTable()[1][1] = 1;
		assertTrue(ttt.checkWinner(2, 0, 1) == 3);
	}
	
	@Test
	public void testCheckWinnerForTheSecondPlayerWithSecondDiagonal() throws Exception {
		ttt.getGameTable()[0][0] = 1;
		ttt.getGameTable()[1][1] = 1;
		assertTrue(ttt.checkWinner(2, 2, 1) == 4);
	}
}