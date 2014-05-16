package be.umons.view;

import be.umons.model.Othello;
import be.umons.model.TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.util.ArrayList;
import java.util.List;

public class JOthelloBackGround extends JPanel {
	
	private JFrame frame;
	private OthelloGame game;
	private List<Object> list;
	
	Border white = BorderFactory.createLineBorder(Color.WHITE, 1);
	
	Othello othello = new Othello(list);
	private JLabel text1 = new JLabel();
	private JLabel score1 = new JLabel();
	private JLabel score2 = new JLabel();
	public int result;
	public int result2;

	ImageIcon pawn1 = null;
	ImageIcon pawn2 = null;
	
	public JOthelloBackGround(JFrame frame, List<Object> list, ImageIcon pawn1, ImageIcon pawn2, int result, int result2) {
		this.pawn1 = pawn1;
		this.pawn2  = pawn2;
		this.frame = frame;
		this.list = list;
		this.text1 = new JLabel();
		this.result = result;
		this.result2 = result2;
		this.score1 = new JLabel();
		this.score2 = new JLabel();
		this.setBounds((frame.getSize().width - 333) /2, (frame.getSize().height - 333) /2, 333, 333);
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/Othello/gameboard.png");
		panel.add(this);
		text1.setBounds(450, 0, 500,  50);
		text1.setForeground(Color.RED);
		Font font = new Font("Arial", Font.BOLD, 15);
		text1.setFont(font);
		text1.setText(list.get(0) + "'s turn !");
		frame.add(text1);
		score1.setBounds(300, 0, 500, 50);
		score1.setForeground(Color.WHITE);
		Font font1 = new Font("Arial", Font.BOLD, 15);
		score1.setFont(font1);
		score1.setText(list.get(0) + ": " + result);
		frame.add(score1);
		score2.setBounds(620, 0, 100, 50);
		score2.setForeground(Color.WHITE);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		score2.setFont(font2);
		score2.setText(list.get(1) + ": " + result2);
		frame.add(score2);
		
		this.list = list;
		this.addMouseListener(new OthelloMouseListener(this, othello, list, frame, this, pawn1, pawn2));
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
		for (int i = 0; i < othello.getNRows(); i++) { 
			for (int j = 0; j < othello.getNColumns(); j++) {
				if (othello.getGameTable()[i][j] == 0) {
					pawn1.paintIcon(this, g, (320) / 8 * j, (302) / 8 * i);					
					text1.setText(list.get(1) + "'s turn !");
				}
				
				if (othello.getGameTable()[i][j] == 1) {
					pawn2.paintIcon(this, g, (320) / 8 * j, (302) / 8 * i);					
					text1.setText(list.get(0) + "'s turn !");
				}
			}
		}
	}
}