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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import be.umons.model.AI;
import be.umons.model.TicTacToe;
import be.umons.utility.Sound;

/**
 * <b> ITicTacToe is the GUI class of a Tic-Tac-Toe board. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class TicTacToeGame extends JFrame {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public 	JLabel text = new JLabel();

	private List<Object> list;
	
	public ImageIcon X = null;	
	public ImageIcon O = null;
	
	public TicTacToeGame(List<Object> list, ImageIcon X, ImageIcon O, int result, int result2) throws Exception {	
		this.list = list;
		this.X = X;
		this.O = O;
		setTitle("Tic-Tac-Toe");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 540);
		setLocationRelativeTo(null);
		
		if (OS.indexOf("win") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
		
		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
				OS.indexOf("aix") >= 0 || OS.indexOf("mac") >= 0 ||
				OS.indexOf("sunos") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/TicTacToe/gameboard.png");
		panel.setLayout(null);
		setContentPane(panel);
		text.setBounds(266, 0, 123, 22);
		panel.add(text);
		
		JTicTacToeBackGround panel2 = new JTicTacToeBackGround(this, list, X, O, result, result2);
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.setOpaque(false);
		
		final GamesMenu lol = new GamesMenu();
		new Thread(new Runnable() {
			public void run() {
				try { 
					lol.getSound().stop();
				} catch (Exception ex) {
					System.out.println("File no found");
				}
			}
		}).start();
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