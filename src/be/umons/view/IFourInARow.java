package be.umons.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class IFourInARow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IFourInARow frame = new IFourInARow();
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
	public IFourInARow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Four In A Row");
		setBounds(100, 100, 828, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 7 , 0, 0));
		
		JButton button = new JButton("");
		contentPane.add(button);
		
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
	}
}