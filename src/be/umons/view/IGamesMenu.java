/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IGamesMenu.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import be.umons.view.IMainMenuTicTacToe;
import be.umons.view.IMainMenuFourInARow;
import be.umons.view.IMainMenuOthello;

/**
 * <b> IGamesMenu is the super-class that initialize the menu of the three games: </b>
 * 
 * <p> Tic-Tac-Toe </p>
 * 
 * <p> Four in a Row </p>
 * 
 * <p> Othello </p>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class IGamesMenu extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JToggleButton btnTicTacToe = new JToggleButton("Tic-Tac-Toe");
	private JToggleButton btnFourInARow = new JToggleButton("Four in a Row");
	private JToggleButton btnOthello = new JToggleButton("Othello");

	/**
	 * <b> Constructor that create the frame. </b>
	 */

	public IGamesMenu() {
		setTitle("Games Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getSource();

				int answer = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want to exit the application?",
						"Exit Application", JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.YES_OPTION)
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		setBounds(100, 100, 1000, 500);
		JPanelBackground panel = new JPanelBackground("Ressource/background.png");
		panel.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		Border grey = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		btnTicTacToe = new JToggleButton(new ImageIcon("Ressource/btnTicTacToe.png"));
		btnTicTacToe.setBounds(200, 166, 165, 165);
		btnTicTacToe.setBorder(new JRoundedBorder(20));
		panel.add(btnTicTacToe);
		btnTicTacToe.addActionListener(this);
		btnTicTacToe.setRolloverIcon(new ImageIcon("Ressource/btnTicTacToe2.png"));
		btnTicTacToe.setBorder(grey);
		
		btnFourInARow = new JToggleButton(new ImageIcon("Ressource/btnFourInARow.png"));
		btnFourInARow.setBounds(417, 166, 165, 165);
		panel.add(btnFourInARow);
		btnFourInARow.addActionListener(this);
		btnFourInARow.setRolloverIcon(new ImageIcon("Ressource/btnFourInARow2.png"));
		btnFourInARow.setBorder(grey);

		btnOthello = new JToggleButton(new ImageIcon("Ressource/btnOthello.png"));
		btnOthello.setBounds(635, 166, 165, 165);
		panel.add(btnOthello);
		btnOthello.addActionListener(this);
		btnOthello.setRolloverIcon(new ImageIcon("Ressource/btnOthello2.png"));
		btnOthello.setBorder(grey);
		
		JLabel lab = new JLabel(new ImageIcon("Ressource/copyright.png"));
		lab.setBounds(243, 370, 517, 64);
		panel.add(lab);

		JLabel lab2 = new JLabel(new ImageIcon("Ressource/header.png"));
		lab2.setBounds(313, 34, 447, 98);
		panel.add(lab2);
		
		
		if (OS.indexOf("win") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
		
		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
				OS.indexOf("aix") >= 0 || OS.indexOf("mac") >= 0 ||
				OS.indexOf("sunos") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
	}

	/**
	 * <b> Method that permit to listen a button. </b>
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		if (source == btnTicTacToe) {
			IMainMenuTicTacToe frame = new IMainMenuTicTacToe();
			frame.setVisible(true);
			dispose();
		}

		else if (source ==  btnFourInARow) {
			IMainMenuFourInARow frame = new IMainMenuFourInARow();
			frame.setVisible(true);
			dispose();
		}

		else if (source == btnOthello) { 
			IMainMenuOthello frame = new IMainMenuOthello();
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * <b> Method that permit to listen a click from the mouse. </b>
	 */

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * <b> Method that permit to listen the cursor of the mouse. </b>
	 */

	@Override
	public void mouseEntered(MouseEvent e) {
		Object source = e.getSource();
		if (source == btnTicTacToe) {
			//AudioMp3.playSound("Ressource/723.wav");
		}
		else if (source ==  btnFourInARow) {
			//AudioMp3.playSound("Ressource/723.wav");
		}

		else if (source == btnOthello) { 
			//AudioMp3.playSound("Ressource/723.wav");
		}

	}

	/**
	 * <b> Method that permit to listen the cursor of the mouse. </b>
	 */
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * <b> Method that permit to listen the cursor of the mouse. </b>
	 */

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * <b> Method that permit to listen the cursor of the mouse. </b>
	 */
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}