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

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
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

	public JMenuBar MenuBar;
	public JMenu MenuFile;
	public JMenuItem ItemNew, ItemSave, ItemLoad, ItemClose;
	
	public FourInARowGame() {
		setTitle("Four in a Row");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 520);
		setLocationRelativeTo(null);
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/FourInARow/gameboard.png");
		panel.setLayout(null);
		setContentPane(panel);
		
		JFourInARowBackGround panel2 = new JFourInARowBackGround(this);
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.setOpaque(false);
		
		MenuBar = new JMenuBar();
        setJMenuBar(MenuBar);
        
        MenuFile = new JMenu("File");
        MenuFile.setMnemonic(KeyEvent.VK_F);
        MenuBar.add(MenuFile);
        
        JMenu ItemNew = new JMenu("New");
        
        ItemNew.add("Tic-Tac-Toe");
        ItemNew.add("Four in a Row");
        ItemNew.add("Othello");
        
        MenuFile.add(ItemNew);
        
        ItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        KeyStroke ctrlSKeyStroke = KeyStroke.getKeyStroke("control S");
        ItemSave.setAccelerator(ctrlSKeyStroke);
        MenuFile.add(ItemSave);
        
        ItemLoad = new JMenuItem("Load", KeyEvent.VK_L);
        KeyStroke ctrlLKeyStroke = KeyStroke.getKeyStroke("control L");
        ItemLoad.setAccelerator(ctrlLKeyStroke);
        MenuFile.add(ItemLoad);
        
        ItemClose = new JMenuItem("Close", KeyEvent.VK_W);
        KeyStroke ctrlWKeyStroke = KeyStroke.getKeyStroke("control W");
        ItemClose.setAccelerator(ctrlWKeyStroke);
        MenuFile.add(ItemClose);
	}
}