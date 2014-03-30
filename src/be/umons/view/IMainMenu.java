/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IMainMenu.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Frame of Main Menu
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class IMainMenu extends JFrame
{
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField txtBoxofgames;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMainMenu frame = new IMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public IMainMenu() {
		this.setTitle("Main Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getSource();
				
				int result = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want to exit the application?",
						"Exit Application", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION)
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnFdsef = new JButton("Quit");
		btnFdsef.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		btnFdsef.setBounds(147, 178, 147, 23);
		contentPane.add(btnFdsef);
		
		btnNewButton = new JButton("Options");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		btnNewButton.setBounds(147, 125, 147, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Games");
		btnNewButton_1.setBounds(147, 73, 147, 23);
		contentPane.add(btnNewButton_1);
		
		txtBoxofgames = new JTextField();
		txtBoxofgames.setFont(new Font("Arial Black", Font.PLAIN, 17));
		txtBoxofgames.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxofgames.setBackground(Color.GRAY);
		txtBoxofgames.setText("BoxOfGames");
		txtBoxofgames.setBounds(79, 11, 279, 37);
		contentPane.add(txtBoxofgames);
		txtBoxofgames.setColumns(18);
		
		textField = new JTextField();
		textField.setText("Copyright 2014 by AGOZZINO Terencio - PIZZIRUSO Loris");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(43, 230, 381, 20);
		contentPane.add(textField);
	}
}