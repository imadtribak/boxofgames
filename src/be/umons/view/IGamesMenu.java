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

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import be.umons.exception.BoundOutreachedException;
import be.umons.model.FourInARow;
import be.umons.model.Othello;
import be.umons.model.TicTacToe;

public class IGamesMenu extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtCopyright;
	private JTextField txtGames;
	
	private JButton btnTicTacToe = new JButton("Tic-Tac-Toe");
	private JButton btnFourInARow = new JButton("Four in a Row");
	private JButton btnOthello = new JButton("Othello");
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IGamesMenu frame = new IGamesMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame
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
		JPanelBackground panel = new JPanelBackground();
		panel.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		
		btnTicTacToe = new JButton(new ImageIcon("Ressource/tictactoe.jpg"));
		btnTicTacToe.setBounds(157, 166, 165, 165);
		panel.add(btnTicTacToe);
		btnTicTacToe.addActionListener(this);
		
		btnFourInARow = new JButton(new ImageIcon("Ressource/fourinarow.jpg"));
		btnFourInARow.setBounds(424, 166, 165, 165);
		panel.add(btnFourInARow);
		btnFourInARow.addActionListener(this);
		
		btnOthello = new JButton(new ImageIcon("Ressource/othello.jpg"));
		btnOthello.setBounds(698, 166, 165, 165);
		panel.add(btnOthello);
		btnOthello.addActionListener(this);
		
		JLabel lab = new JLabel(new ImageIcon("Ressource/copyright.jpg"));
		lab.setBounds(243, 370, 517, 64);
		panel.add(lab);
		
		JLabel lab2 = new JLabel(new ImageIcon("Ressource/header.jpg"));
		lab2.setBounds(243, 34, 447, 98);
		panel.add(lab2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		List<Object> list = new ArrayList<Object>();
		if (source == btnTicTacToe) {
			TicTacToe ttt = new TicTacToe(list);
			try {
				ttt.letsPlay();
			} catch (BoundOutreachedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (source ==  btnFourInARow) {
			FourInARow fiar = new FourInARow(list);
			try {
				fiar.letsPlay();
			} catch (BoundOutreachedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		else if (source == btnOthello) { 
			Othello othello = new Othello(list);
			try {
				othello.letsPlay();
			} catch (BoundOutreachedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}