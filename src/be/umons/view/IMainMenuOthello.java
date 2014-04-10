/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IMainMenuOthello.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Color;
import java.awt.EventQueue;
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
import be.umons.model.Othello;

/**
 * <b> IMainMenuOthello is the class that initialize the menu of the Othello game. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class IMainMenuOthello extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JToggleButton btnPlay = new JToggleButton("Play");
	private JToggleButton btnOptions = new JToggleButton("Options");
	private JToggleButton btnQuit = new JToggleButton("Quit");

	/**
	 * Constructor that create the frame.
	 */

	public IMainMenuOthello() {
		setTitle("Othello Menu");
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
		JPanelBackground panel = new JPanelBackground("Ressource/Games/Othello/background.png");
		panel.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		Border grey = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		btnPlay = new JToggleButton(new ImageIcon("Ressource/Games/Othello/btnPlay.png"));
		btnPlay.setBounds(200, 166, 165, 165);
		panel.add(btnPlay);
		btnPlay.addActionListener(this);
		btnPlay.setRolloverIcon(new ImageIcon("Ressource/Games/Othello/btnPlay2.png"));
		btnPlay.setBorder(grey);
		
		btnOptions = new JToggleButton(new ImageIcon("Ressource/Games/Othello/btnOptions.png"));
		btnOptions.setBounds(417, 166, 165, 165);
		panel.add(btnOptions);
		btnOptions.addActionListener(this);
		btnOptions.setRolloverIcon(new ImageIcon("Ressource/Games/Othello/btnOptions2.png"));
		btnOptions.setBorder(grey);
		
		btnQuit = new JToggleButton(new ImageIcon("Ressource/Games/Othello/btnQuit.png"));
		btnQuit.setBounds(635, 166, 165, 165);
		panel.add(btnQuit);
		btnQuit.addActionListener(this);
		btnQuit.setRolloverIcon(new ImageIcon("Ressource/Games/Othello/btnQuit2.png"));
		btnQuit.setBorder(grey);
		
		JLabel lab = new JLabel(new ImageIcon("Ressource/copyright.png"));
		lab.setBounds(243, 370, 517, 64);
		panel.add(lab);

		JLabel lab2 = new JLabel(new ImageIcon("Ressource/Games/Othello/header.png"));
		lab2.setBounds(313, 34, 447, 98);
		panel.add(lab2);
		
		if (OS.indexOf("win") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
		
		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
				OS.indexOf("aix") >= 0 || OS.indexOf("mac") >= 0 ||
				OS.indexOf("sunos") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		List<Object> list = new ArrayList<Object>();
		if (source == btnPlay) {
			Othello othello = new Othello(list);
			dispose();
			try {
				othello.letsPlay();
			} catch (BoundOutreachedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (source ==  btnOptions) {
			
		}

		else if (source == btnQuit) {
			
		}
	}
}