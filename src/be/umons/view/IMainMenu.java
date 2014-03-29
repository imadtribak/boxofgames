/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IMainMenu.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */
package com.umons.view;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IMainMenu extends JFrame
{
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField txtBoxofgames;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	
	public IMainMenu()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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