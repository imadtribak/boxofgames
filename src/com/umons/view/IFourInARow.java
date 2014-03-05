/**
 ****************************************************
 * @authors    : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.terencio@gmail.com
 * @file       : IFourInARow.java
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class IFourInARow extends JFrame
{

	private JPanel contentPane;
	private JTextField txtFourInA;

	/**
	 * Create the frame.
	 */
	
	public IFourInARow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFourInA = new JTextField();
		txtFourInA.setText("FOUR IN A ROW");
		txtFourInA.setHorizontalAlignment(SwingConstants.CENTER);
		txtFourInA.setFont(new Font("Arial Black", Font.PLAIN, 17));
		txtFourInA.setColumns(18);
		txtFourInA.setBackground(Color.GRAY);
		txtFourInA.setBounds(79, 11, 279, 37);
		contentPane.add(txtFourInA);
		
		JButton btnPlayer = new JButton("One Player");
		btnPlayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		btnPlayer.setBounds(167, 82, 115, 23);
		contentPane.add(btnPlayer);
		
		JButton btnTwoPlayers = new JButton("Two Player");
		btnTwoPlayers.setBounds(167, 136, 115, 23);
		contentPane.add(btnTwoPlayers);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(167, 188, 115, 23);
		contentPane.add(btnQuit);
	}
}