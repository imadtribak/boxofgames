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
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * <b> ITicTacToe is the GUI class of a Tic-Tac-Toe board. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class FourInARowGame extends JFrame {
	
	private static String OS = System.getProperty("os.name").toLowerCase();

	public 	JLabel text = new JLabel();

	private List<Object> list;
	
	public ImageIcon P1 = null;	
	public ImageIcon P2 = null;
	
	public FourInARowGame(List<Object> list, ImageIcon P1, ImageIcon P2, int result, int result2) {
		this.list = list;
		this.P1 = P1;
		this.P2 = P2;
		setTitle("Four in a Row");
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
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/FourInARow/gameboard.png");
		panel.setLayout(null);
		setContentPane(panel);
		
		JFourInARowBackGround panel2 = new JFourInARowBackGround(this, list, P1, P2, result, result2);
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.setOpaque(false);
	}
}