/**
 ****************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : TicTacToeBoard.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <b> ITicTacToe is the GUI class of a Tic-Tac-Toe board. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class OthelloGame extends JFrame {

	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public 	JLabel text = new JLabel();

	private List<Object> list;
	
	public ImageIcon pawn1 = null;	
	public ImageIcon pawn2 = null;
	
	public OthelloGame(List<Object> list, ImageIcon X, ImageIcon O, int result, int result2) {
		this.list = list;
		this.pawn1 = pawn1;
		this.pawn1 = pawn2;
		setTitle("Othello");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 520);
		setLocationRelativeTo(null);
		
		if (OS.indexOf("win") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
		
		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
				OS.indexOf("aix") >= 0 || OS.indexOf("mac") >= 0 ||
				OS.indexOf("sunos") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
		
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/Othello/gameboard.png");
		panel.setLayout(null);
		setContentPane(panel);
		
		JOthelloBackGround panel2 = new JOthelloBackGround(this, list, X, O, result, result2);
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.setOpaque(false);
	}

	public JLabel getText() {
		return text;
	}

	public void setText(JLabel text) {
		this.text = text;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
}