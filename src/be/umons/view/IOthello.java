/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : IOthello.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * <b> IOthello is the GUI class of a Othello board. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class IOthello extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * <b> Launch the application. </b>
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IOthello frame = new IOthello();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * <b> Constructor that create the frame. </b>
	 */
	
	public IOthello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Othello");
		setBounds(100, 100, 828, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 8 , 0, 0));
		
		JButton button1 = new JButton("");
		contentPane.add(button1);
		
		JButton button2 = new JButton("");
		contentPane.add(button2);
		
		JButton button3 = new JButton("");
		contentPane.add(button3);		
	
		JButton button4 = new JButton("");
		contentPane.add(button4);

		JButton button5 = new JButton("");
		contentPane.add(button5);

		JButton button6 = new JButton("");
		contentPane.add(button6);

		JButton button7 = new JButton("");
		contentPane.add(button7);	

		JButton button8 = new JButton("");
		contentPane.add(button8);

		JButton button9 = new JButton("");
		contentPane.add(button9);

		JButton button10 = new JButton("");
		contentPane.add(button10);

		JButton button11 = new JButton("");
		contentPane.add(button11);

		JButton button12 = new JButton("");
		contentPane.add(button12);

		JButton button13 = new JButton("");
		contentPane.add(button13);

		JButton button14 = new JButton("");
		contentPane.add(button14);

		JButton button15 = new JButton("");
		contentPane.add(button15);

		JButton button16 = new JButton("");
		contentPane.add(button16);

		JButton button17 = new JButton("");
		contentPane.add(button17);

		JButton button18 = new JButton("");
		contentPane.add(button18);

		JButton button19 = new JButton("");
		contentPane.add(button19);

		JButton button20 = new JButton("");
		contentPane.add(button20);
		
		JButton button21 = new JButton("");
		contentPane.add(button21);
		
		JButton button22 = new JButton("");
		contentPane.add(button22);
		
		JButton button23 = new JButton("");
		contentPane.add(button23);		
	
		JButton button24 = new JButton("");
		contentPane.add(button24);

		JButton button25 = new JButton("");
		contentPane.add(button25);

		JButton button26 = new JButton("");
		contentPane.add(button26);

		JButton button27 = new JButton("");
		contentPane.add(button27);	

		JButton button28 = new JButton("");
		contentPane.add(button28);

		JButton button29 = new JButton("");
		contentPane.add(button29);

		JButton button30 = new JButton("");
		contentPane.add(button30);

		JButton button31 = new JButton("");
		contentPane.add(button31);

		JButton button32 = new JButton("");
		contentPane.add(button32);

		JButton button33 = new JButton("");
		contentPane.add(button33);

		JButton button34 = new JButton("");
		contentPane.add(button34);

		JButton button35 = new JButton("");
		contentPane.add(button35);

		JButton button36 = new JButton("");
		contentPane.add(button36);

		JButton button37 = new JButton("");
		contentPane.add(button37);

		JButton button38 = new JButton("");
		contentPane.add(button38);

		JButton button39 = new JButton("");
		contentPane.add(button39);

		JButton button40 = new JButton("");
		contentPane.add(button40);
		
		JButton button41 = new JButton("");
		contentPane.add(button41);

		JButton button42 = new JButton("");
		contentPane.add(button42);
		
		JButton button43 = new JButton("");
		contentPane.add(button43);
		
		JButton button44 = new JButton("");
		contentPane.add(button44);
		
		JButton button45 = new JButton("");
		contentPane.add(button45);
		
		JButton button46 = new JButton("");
		contentPane.add(button46);
		
		JButton button47 = new JButton("");
		contentPane.add(button47);
		
		JButton button48 = new JButton("");
		contentPane.add(button48);
		
		JButton button49 = new JButton("");
		contentPane.add(button49);
		
		JButton button50 = new JButton("");
		contentPane.add(button50);
		
		JButton button51 = new JButton("");
		contentPane.add(button51);
		
		JButton button52 = new JButton("");
		contentPane.add(button52);
		
		JButton button53 = new JButton("");
		contentPane.add(button53);
		
		JButton button54 = new JButton("");
		contentPane.add(button54);
		
		JButton button55 = new JButton("");
		contentPane.add(button55);
		
		JButton button56 = new JButton("");
		contentPane.add(button56);
		
		JButton button57 = new JButton("");
		contentPane.add(button57);
		
		JButton button58 = new JButton("");
		contentPane.add(button58);
		
		JButton button59 = new JButton("");
		contentPane.add(button59);
		
		JButton button60 = new JButton("");
		contentPane.add(button60);
		
		JButton button61 = new JButton("");
		contentPane.add(button61);
		
		JButton button62 = new JButton("");
		contentPane.add(button62);
		
		JButton button63 = new JButton("");
		contentPane.add(button63);
		
		JButton button64 = new JButton("");
		contentPane.add(button64);
	}
}