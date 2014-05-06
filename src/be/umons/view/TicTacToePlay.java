package be.umons.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import be.umons.exception.BoundOutreachedException;
import be.umons.model.TicTacToe;

public class TicTacToePlay {
	
	private List<Object> list;

	public TicTacToePlay(List<Object> list) {
		this.list = list;
	}

	public void letsPlay() throws BoundOutreachedException {

		TicTacToe ttt = new TicTacToe(list);

			if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 0)
				JOptionPane.showMessageDialog (null, "Game is tied", "End", JOptionPane.INFORMATION_MESSAGE);

			if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 1) {
				if (ttt.getActualPlayer() == 0) 
					JOptionPane.showMessageDialog (null, list.get(0) + "won the game with his horizontal alignment", "End", JOptionPane.INFORMATION_MESSAGE);

				if (ttt.getActualPlayer() == 1)
					JOptionPane.showMessageDialog (null, list.get(1) + "won the game with his horizontal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
			}

			if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 2) {
				if (ttt.getActualPlayer() == 0) 
					JOptionPane.showMessageDialog (null, list.get(0) + "won the game with his vertical alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				if (ttt.getActualPlayer() == 1)
					JOptionPane.showMessageDialog (null, list.get(1) + "won the game with his vertical alignment", "End", JOptionPane.INFORMATION_MESSAGE);
			}

			if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 3) {
				if (ttt.getActualPlayer() == 0) 
					JOptionPane.showMessageDialog (null, list.get(0) + "won the game with his first diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				if (ttt.getActualPlayer() == 1)
					JOptionPane.showMessageDialog (null, list.get(1) + "won the game with his first diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
			}


			if (ttt.checkWinner(ttt.getLastX(), ttt.getLastY(), ttt.getActualPlayer()) == 4) {
				if (ttt.getActualPlayer() == 0) 
					JOptionPane.showMessageDialog (null, list.get(0) + "won the game with his second diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
				if (ttt.getActualPlayer() == 1)
					JOptionPane.showMessageDialog (null, list.get(1) + "won the game with his second diagonal alignment", "End", JOptionPane.INFORMATION_MESSAGE);
			}
	}
}