package be.umons.view;

import be.umons.model.TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class JTicTacToeBackGround extends JPanel {

	private JFrame frame;
	private TicTacToeGame game;
	private List<Object> list;
	
	Border white = BorderFactory.createLineBorder(Color.WHITE, 1);
	
	TicTacToe ttt = new TicTacToe(list);
	
	private JLabel text1 = new JLabel();
	private JLabel score1 = new JLabel();
	private JLabel score2 = new JLabel();
	
	public int result;
	public int result2;

	ImageIcon X = null;
	ImageIcon O = null;

	public JTicTacToeBackGround(JFrame frame, List<Object> list, ImageIcon actualX, ImageIcon actualO, int result, int result2) {
		this.X = actualX;
		this.O = actualO;
		this.frame = frame;
		this.list = list;
		this.text1 = new JLabel();
		this.result = result;
		this.result2 = result2;
		this.score1 = new JLabel();
		this.score2 = new JLabel();
		this.setBounds((frame.getSize().width - 440)/2, (frame.getSize().height - 350)/2, 440, 350);
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/TicTacToe/gameboard.png");
		panel.add(this);
		
		text1.setBounds(430, 0, 500, 100);
		text1.setForeground(Color.RED);
		Font font = new Font("Arial", Font.BOLD, 15);
		text1.setFont(font);
		text1.setText(list.get(0) + "'s turn !");
		frame.add(text1);
		
		score1.setBounds(230, 0, 500, 100);
		score1.setForeground(Color.WHITE);
		Font font1 = new Font("Arial", Font.BOLD,15);
		score1.setFont(font1);
		score1.setText(list.get(0) + ": " + result);
		frame.add(score1);
		
		score2.setBounds(680, 0, 500, 100);	
		score2.setForeground(Color.WHITE);
		Font font2 = new Font("Arial", Font.BOLD,15);
		score2.setFont(font2);
		score2.setText(list.get(1) + ": " + result2);
		frame.add(score2);
				
		this.list = list;
		
		System.out.println("CA VA BUG !");
		this.addMouseListener(new TicTacToeMouseListener(this, ttt, list, frame, this, X, O));
	}
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getResult2() {
		return result2;
	}

	public void setResult2(int result2) {
		this.result2 = result2;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ttt.getNRows(); i++) { 
			for (int j = 0; j < ttt.getNColumns(); j++) {
				if (ttt.getGameTable()[i][j] == 0) {
					X.paintIcon(this, g, (500) / 3 * j, (280) / 3 * i);					
				}
				
				if (ttt.getGameTable()[i][j] == 1) {
					O.paintIcon(this, g, (500) / 3 * j, (280) / 3 * i);
				}
				
				if (ttt.getActualPlayer() == 0) {
					text1.setText(list.get(0) + "'s turn !");
				}
				
				if (ttt.getActualPlayer() == 1) {
					text1.setText(list.get(1) + "'s turn !");
				}
			}
		}
	}
}