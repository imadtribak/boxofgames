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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import be.umons.exception.BoundOutreachedException;
import be.umons.model.AI;
import be.umons.model.TicTacToe;
import be.umons.utility.Sound;

/**
 * <b> ITicTacToe is the GUI class of a Tic-Tac-Toe board. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class TicTacToeGame extends JFrame implements ActionListener {
	
	public JMenuBar MenuBar;
	public JMenu MenuFile;
	public JMenuItem ItemNew, ItemSave, ItemLoad, ItemClose;

	private List<Object> list;
	
	public TicTacToeGame(List<Object> list) throws Exception {		
		this.list = list;
		setTitle("Tic-Tac-Toe");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 540);
		setLocationRelativeTo(null);
		
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/TicTacToe/gameboard.png");
		panel.setLayout(null);
		setContentPane(panel);
		
		JTicTacToeBackGround panel2 = new JTicTacToeBackGround(this);
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
          
		TicTacToePlay ttt = new TicTacToePlay(list);
		ttt.letsPlay();
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}