/**
 ****************************************************
 * @authors    : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.terencio@gmail.com
 * @file       : IGamesMenu.java
 * @date       : 20 april 2014
 * @projet     : BoxOfGames
 *****************************************************
 */

package com.umons.view;

/**
 * @authors AGOZZINO Terencio - PIZZIRUSSO Loris
 */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IGamesMenu extends JFrame
{
	
	private JPanel contentPane;
	private JTextField txtCopyright;
	private JTextField txtGames;

	/**
	 * Create the frame.
	 */
	
	public IGamesMenu()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Tic-Tac-Toe");
		btnNewButton.setBounds(28, 75, 106, 144);
		contentPane.add(btnNewButton);
		
		JButton btnInA = new JButton("Four in a Row");
		btnInA.setBounds(160, 75, 114, 144);
		contentPane.add(btnInA);
		
		JButton btnReversi = new JButton("Reversi");
		btnReversi.setBounds(303, 75, 106, 144);
		contentPane.add(btnReversi);
		
		txtCopyright = new JTextField();
		txtCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		txtCopyright.setText("Copyright 2014 by AGOZZINO Terencio - PIZZIRUSSO Loris");
		txtCopyright.setBounds(28, 230, 381, 20);
		contentPane.add(txtCopyright);
		txtCopyright.setColumns(10);
		
		txtGames = new JTextField();
		txtGames.setText("GAMES");
		txtGames.setHorizontalAlignment(SwingConstants.CENTER);
		txtGames.setFont(new Font("Arial Black", Font.PLAIN, 17));
		txtGames.setColumns(18);
		txtGames.setBackground(Color.GRAY);
		txtGames.setBounds(71, 11, 279, 37);
		contentPane.add(txtGames);
	}
}