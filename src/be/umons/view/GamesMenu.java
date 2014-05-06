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

import be.umons.utility.Sound;
import be.umons.view.TicTacToeMenu;
import be.umons.view.FourInARowMenu;
import be.umons.view.OthelloMenu;

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

public class GamesMenu extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JToggleButton btnTicTacToe = new JToggleButton("Tic-Tac-Toe");
	private JToggleButton btnFourInARow = new JToggleButton("Four in a Row");
	private JToggleButton btnOthello = new JToggleButton("Othello");
	
	private boolean activateSound = true;
	private Sound sound;
	private Sound sound2;
	private Sound sound3;
	
	Border black = BorderFactory.createLineBorder(Color.BLACK, 1);

	/**
	 * <b> Constructor that create the frame. </b>
	 */

	public GamesMenu() {
		setTitle("Games Menu");
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
		JPanelBackGround panel = new JPanelBackGround("Ressource/background.png");
		panel.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		panel.setBorder(black);
		
		Border grey = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		btnTicTacToe = new JToggleButton(new ImageIcon("Ressource/btnTicTacToe.png"));
		btnTicTacToe.setBounds(200, 166, 165, 165);
		panel.add(btnTicTacToe);
		btnTicTacToe.addActionListener(this);
		btnTicTacToe.addMouseListener(this);
		btnTicTacToe.setRolloverIcon(new ImageIcon("Ressource/btnTicTacToe2.png"));
		btnTicTacToe.setBorder(grey);
		
		btnFourInARow = new JToggleButton(new ImageIcon("Ressource/btnFourInARow.png"));
		btnFourInARow.setBounds(417, 166, 165, 165);
		panel.add(btnFourInARow);
		btnFourInARow.addActionListener(this);
		btnFourInARow.addMouseListener(this);
		btnFourInARow.setRolloverIcon(new ImageIcon("Ressource/btnFourInARow2.png"));
		btnFourInARow.setBorder(grey);

		btnOthello = new JToggleButton(new ImageIcon("Ressource/btnOthello.png"));
		btnOthello.setBounds(635, 166, 165, 165);
		panel.add(btnOthello);
		btnOthello.addActionListener(this);
		btnOthello.addMouseListener(this);
		btnOthello.setRolloverIcon(new ImageIcon("Ressource/btnOthello2.png"));
		btnOthello.setBorder(grey);
		
		JLabel lab = new JLabel(new ImageIcon("Ressource/copyright.png"));
		lab.setBounds(220, 370, 517, 64);
		panel.add(lab);

		JLabel lab2 = new JLabel(new ImageIcon("Ressource/header.png"));
		lab2.setBounds(313, 34, 447, 98);
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

	public boolean getActivateSound() {
		return activateSound;
	}
	

	public void setActivateSound(boolean activateSound) {
		this.activateSound = activateSound;
	}

	public void stopMusic() throws Exception {
		sound.stop();
	}
	/**
	 * <b> Method that permit to listen a button. </b>
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		if (source == btnTicTacToe) {
			dispose();
			TicTacToeMenu frame = new TicTacToeMenu();
			frame.setVisible(true);
			new Thread(new Runnable() {
				public void run() {
					try { 
						sound = new Sound("Ressource/Sound/Arcis - Pallas.mp3");
						//sound.play();
					} catch (Exception ex) {}
				}
			}).start();
		}

		else if (source ==  btnFourInARow) {
			dispose();
			FourInARowMenu frame = new FourInARowMenu();
			frame.setVisible(true);
			if (activateSound == true) {
	            new Thread(new Runnable() {
	                public void run() {
	                    try { 
	                        sound2 = new Sound("Ressource/Sound/Arcis - Arcis.mp3");
	                       // sound2.play();
	                    } catch (Exception ex) {}
	                }
	            }).start();
			}
		}

		else if (source == btnOthello) { 
			dispose();
			OthelloMenu frame = new OthelloMenu();
			frame.setVisible(true);
			if (activateSound == true) {
	            new Thread(new Runnable() {
	                public void run() {
	                    try { 
	                    	sound3 = new Sound("Ressource/Sound/Arcis - Sonny Rico.mp3");
	                    	//sound3.play();
	                    } catch (Exception ex) {}
	                }
	            }).start();
			}
		}
	}
	
	/**
	 * <b> Method that permit to listen a click from the mouse. </b>
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * <b> Method that permit to listen the cursor of the mouse. </b>
	 */

	@Override
	public void mouseEntered(MouseEvent e) {
		Object source = e.getSource();
		if (source == btnTicTacToe) {
			new Thread(new Runnable() {
				public void run() {
					try { 
						Sound sound = new Sound("Ressource/Sound/Ok.mp3");
						System.out.println(sound);
						//sound.play();
					} catch (Exception ex) {
						System.out.println("File no found");
					}
				}
			}).start();
		}

		else if (source ==  btnFourInARow) {
			if (source == btnFourInARow) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/Ok.mp3");
							//sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
			}
		}

		else if (source == btnOthello) { 
			if (source == btnOthello) {
				new Thread(new Runnable() {
					public void run() {
						try { 
							Sound sound = new Sound("Ressource/Sound/Ok.mp3");
							//sound.play();
						} catch (Exception ex) {
							System.out.println("File no found");
						}
					}
				}).start();
			}
		}
	}
	
	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public Sound getSound2() {
		return sound2;
	}

	public void setSound2(Sound sound2) {
		this.sound2 = sound2;
	}

	public Sound getSound3() {
		return sound3;
	}

	public void setSound3(Sound sound3) {
		this.sound3 = sound3;
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
	}

	/**
	 * <b> Method that permit to listen the cursor of the mouse. </b>
	 */
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}