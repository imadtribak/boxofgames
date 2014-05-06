/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IMainMenuFourInARow.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import be.umons.exception.BoundOutreachedException;
import be.umons.model.FourInARow;

/**
 * <b> IMainMenuFourInARow is the class that initialize the menu of the
 * Four in a Row game. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class FourInARowMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JToggleButton btnPlay = new JToggleButton("Play");
	private JToggleButton btnOptions = new JToggleButton("Options");
	private JToggleButton btnQuit = new JToggleButton("Quit");
	
	Border black = BorderFactory.createLineBorder(Color.BLACK, 1);

	/**
	 * <b> Constructor that create the frame </b>
	 */

	public FourInARowMenu() {
		setTitle("Four in a Row Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getSource();

				int answer = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want to exit the application ?",
						"Exit Application", JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.YES_OPTION)
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				else
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		setBounds(100, 100, 1000, 500);
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/FourInARow/background.png");
		panel.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		panel.setBorder(black);

		Border grey = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		btnPlay = new JToggleButton(new ImageIcon("Ressource/Games/FourInARow/btnPlay.png"));
		btnPlay.setBounds(200, 166, 165, 165);
		panel.add(btnPlay);
		btnPlay.addActionListener(this);
		btnPlay.setRolloverIcon(new ImageIcon("Ressource/Games/FourInARow/btnPlay2.png"));
		btnPlay.setBorder(grey);
		
		btnOptions = new JToggleButton(new ImageIcon("Ressource/Games/FourInARow/btnOptions.png"));
		btnOptions.setBounds(417, 166, 165, 165);
		panel.add(btnOptions);
		btnOptions.addActionListener(this);
		btnOptions.setRolloverIcon(new ImageIcon("Ressource/Games/FourInARow/btnOptions2.png"));
		btnOptions.setBorder(grey);
		
		btnQuit = new JToggleButton(new ImageIcon("Ressource/Games/FourInARow/btnQuit.png"));
		btnQuit.setBounds(635, 166, 165, 165);
		panel.add(btnQuit);
		btnQuit.addActionListener(this);
		btnQuit.setRolloverIcon(new ImageIcon("Ressource/Games/FourInARow/btnQuit2.png"));
		btnQuit.setBorder(grey);
		
		JLabel lab = new JLabel(new ImageIcon("Ressource/copyright.png"));
		lab.setBounds(243, 370, 517, 64);
		panel.add(lab);

		JLabel lab2 = new JLabel(new ImageIcon("Ressource/Games/FourInARow/header.png"));
		lab2.setBounds(300, 11, 517, 144);
		panel.add(lab2);
		
		JLabel lab3 = new JLabel(new ImageIcon("Ressource/picture.jpg"));
		lab3.setBounds(230, 370, 60, 60);
		panel.add(lab3);
		
		JLabel lab4 = new JLabel(new ImageIcon("Ressource/picture2.jpg"));
		lab4.setBounds(650, 370, 60, 60);
		panel.add(lab4);
		
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
		if (source == btnPlay) {
			FourInARowChoiceMenu frame = new FourInARowChoiceMenu();
			frame.setVisible(true);
		}

		else if (source ==  btnOptions) {
			FourInARowOptions frame = new FourInARowOptions();
			frame.setVisible(true);
		}

		else if (source == btnQuit) {
			int answer = JOptionPane.showConfirmDialog(null,
					"Do you want back to the main menu ?",
					"Exit Application", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				GamesMenu frame = new GamesMenu();
				frame.setVisible(true);
			}
			dispose();
		}
	}
}