/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IMainMenuTicTacToe.java
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

import be.umons.model.TicTacToe;
import be.umons.utility.Sound;

/**
 * <b> IMainMenuTicTacToe is the class that initialize the menu of the Tic-Tac-Toe game. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class TicTacToeMenu extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JToggleButton btnPlay = new JToggleButton("Play");
	private JToggleButton btnOptions = new JToggleButton("Options");
	private JToggleButton btnQuit = new JToggleButton("Quit");
	
	private Sound sound;
	private Sound sound2;
	private Sound sound3;
	
	public ImageIcon lab5 = new ImageIcon("Ressource/Games/TicTacToe/XRed.png");
	public ImageIcon lab6 = new ImageIcon("Ressource/Games/TicTacToe/OBlue.png");
	
	Border black = BorderFactory.createLineBorder(Color.BLACK, 1);
	
	/**
	 * <b> Constructor that create the frame. </b>
	 */

	public TicTacToeMenu(ImageIcon lab5, ImageIcon lab6) {
		this.lab5 = lab5;
		this.lab6 = lab6;
		setTitle("Tic Tac Toe Menu");
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
		JPanelBackGround panel = new JPanelBackGround("Ressource/Games/TicTacToe/background.png");
		panel.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		panel.setBorder(black);

		Border grey = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		btnPlay = new JToggleButton(new ImageIcon("Ressource/Games/TicTacToe/btnPlay.png"));
		btnPlay.setBounds(200, 166, 165, 165);
		panel.add(btnPlay);
		btnPlay.addActionListener(this);
		btnPlay.addMouseListener(this);
		btnPlay.setRolloverIcon(new ImageIcon("Ressource/Games/TicTacToe/btnPlay2.png"));
		btnPlay.setBorder(grey);
		
		btnOptions = new JToggleButton(new ImageIcon("Ressource/Games/TicTacToe/btnOptions.png"));
		btnOptions.setBounds(417, 166, 165, 165);
		panel.add(btnOptions);
		btnOptions.addActionListener(this);
		btnOptions.addMouseListener(this);
		btnOptions.setRolloverIcon(new ImageIcon("Ressource/Games/TicTacToe/btnOptions2.png"));
		btnOptions.setBorder(grey);
		
		btnQuit = new JToggleButton(new ImageIcon("Ressource/Games/TicTacToe/btnQuit.png"));
		btnQuit.setBounds(635, 166, 165, 165);
		panel.add(btnQuit);
		btnQuit.addActionListener(this);
		btnQuit.addMouseListener(this);
		btnQuit.setRolloverIcon(new ImageIcon("Ressource/Games/TicTacToe/btnQuit2.png"));
		btnQuit.setBorder(grey);
		
		JLabel lab = new JLabel(new ImageIcon("Ressource/copyright.png"));
		lab.setBounds(220, 370, 517, 64);
		panel.add(lab);

		JLabel lab2 = new JLabel(new ImageIcon("Ressource/Games/TicTacToe/header.png"));
		lab2.setBounds(313, 34, 447, 98);
		panel.add(lab2);
		
		JLabel lab3 = new JLabel(new ImageIcon("Ressource/me.png"));
		lab3.setBounds(200, 350, 100, 100);
		panel.add(lab3);
		
		JLabel lab4 = new JLabel(new ImageIcon("Ressource/me.png"));
		lab4.setBounds(650, 350, 100, 100);
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
			dispose();
			TicTacToeChoiceMenu frame = new TicTacToeChoiceMenu(lab5, lab6);
			frame.setVisible(true);
		}

		else if (source ==  btnOptions) {
			dispose();
			TicTacToeOptions frame = new TicTacToeOptions();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object source = e.getSource();
		if (source == btnPlay) {
			new Thread(new Runnable() {
				public void run() {
					try { 
						Sound sound = new Sound("Ressource/Sound/menu.mp3");
						sound.play();
					} catch (Exception ex) {
						System.out.println("File no found");
					}
				}
			}).start();
		}

		else if (source ==  btnOptions) {
			if (source == btnOptions) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/menu.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
			}
		}

		else if (source == btnQuit) { 
			if (source == btnQuit) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/menu.mp3");
							sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
			}
		}	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}