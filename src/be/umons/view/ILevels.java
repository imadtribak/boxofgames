/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : ILevels.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

/**
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ILevels extends JFrame
{
	private JPanel contentPane;
	private JTextField txtLevels;

	/**
	 * Constructor that create the frame.
	 */
	
	public ILevels()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLevels = new JTextField();
		txtLevels.setText("LEVEL");
		txtLevels.setHorizontalAlignment(SwingConstants.CENTER);
		txtLevels.setFont(new Font("Arial Black", Font.PLAIN, 17));
		txtLevels.setColumns(18);
		txtLevels.setBackground(Color.GRAY);
		txtLevels.setBounds(82, 11, 279, 37);
		contentPane.add(txtLevels);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(146, 89, 157, 23);
		contentPane.add(btnEasy);
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.setBounds(146, 145, 157, 23);
		contentPane.add(btnMedium);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(146, 205, 157, 23);
		contentPane.add(btnHard);
	}
}