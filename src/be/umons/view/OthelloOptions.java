package be.umons.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class OthelloOptions extends JFrame implements ActionListener, MouseListener {

	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JPanel contentPane;
	private JLabel lblPiece1 = new JLabel("");
	private JLabel lblPiece2 = new JLabel("");
	private JLabel lblPiece3 = new JLabel("");
	private JLabel lblPiece4 = new JLabel("");
	private JLabel lblPiece5 = new JLabel("");
	private JLabel lblPiece6 = new JLabel("");
	private JLabel lblPiece7 = new JLabel("");
	private JLabel lblPiece8 = new JLabel("");
	private JLabel lblPiece9 = new JLabel("");
	private JLabel lblPiece10 = new JLabel("");
	private JLabel lblPiece11 = new JLabel("");
	private JLabel lblPiece12 = new JLabel("");
	private JLabel lblPiece13 = new JLabel("");
	private JLabel lblPiece14 = new JLabel("");
	
	private JButton btnOff = new JButton("OFF");
	private JButton btnOn = new JButton("ON");
	
	private JToggleButton btnOk = new JToggleButton("OK");
	
	Border black = BorderFactory.createLineBorder(Color.BLACK, 1);
	Border white = BorderFactory.createLineBorder(Color.WHITE, 1);
	
	/**
	 * Create the frame.
	 */
	public OthelloOptions() {
		setTitle("Options Menu");
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBorder(black);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		
		btnOn.setBounds(86, 31, 89, 23);
		btnOn.setBackground(Color.BLACK);
		btnOn.setForeground(Color.GREEN);
		btnOn.setBorder(white);
		btnOn.setFocusPainted(false);
		contentPane.add(btnOn);
		btnOn.addActionListener(this);
		
		btnOff.setBounds(177, 31, 89, 23);
		btnOff.setBackground(Color.BLACK);
		btnOff.setForeground(Color.RED);
		btnOff.setBorder(white);
		btnOff.setFocusPainted(false);
		contentPane.add(btnOff);
		btnOff.addActionListener(this);
		
		JLabel lblSound = new JLabel("Sound:");
		lblSound.setBounds(30, 35, 46, 14);
		lblSound.setForeground(Color.WHITE);
		contentPane.add(lblSound);
		
		JLabel lblPlayers1 = new JLabel("Player 1's pieces");
		lblPlayers1.setBounds(175, 80, 108, 23);
		lblPlayers1.setForeground(Color.WHITE);
		contentPane.add(lblPlayers1);
		
		lblPiece1 = new JLabel(new ImageIcon("Ressource/Games/Othello/Black.png"));
		lblPiece1.setBounds(15, 111, 50, 50);
		lblPiece1.setBorder(white);
		lblPiece1.addMouseListener(this);
		contentPane.add(lblPiece1);

		lblPiece2 = new JLabel(new ImageIcon("Ressource/Games/Othello/Blue.png"));
		lblPiece2.setBounds(75, 111, 50, 50);
		lblPiece2.addMouseListener(this);
		contentPane.add(lblPiece2);

		lblPiece3 = new JLabel(new ImageIcon("Ressource/Games/Othello/Red.png"));
		lblPiece3.setBounds(135, 111, 50, 50);
		lblPiece3.addMouseListener(this);
		contentPane.add(lblPiece3 );

		lblPiece4 = new JLabel(new ImageIcon("Ressource/Games/Othello/Orange.png"));
		lblPiece4.setBounds(195, 111, 50, 50);
		lblPiece4.addMouseListener(this);
		contentPane.add(lblPiece4);
		
		lblPiece5 = new JLabel(new ImageIcon("Ressource/Games/Othello/LightBlue.png"));
		lblPiece5.setBounds(255, 111, 50, 50);
		lblPiece5.addMouseListener(this);
		contentPane.add(lblPiece5);

		lblPiece6 = new JLabel(new ImageIcon("Ressource/Games/Othello/Yellow.png"));
		lblPiece6.setBounds(315, 111, 50, 50);
		lblPiece6.addMouseListener(this);
		contentPane.add(lblPiece6);
		
		lblPiece7 = new JLabel(new ImageIcon("Ressource/Games/Othello/Mauve.png"));
		lblPiece7.setBounds(375, 111, 50, 50);
		lblPiece7.addMouseListener(this);
		contentPane.add(lblPiece7);
		
		JLabel lblPlayers2 = new JLabel("Player 2's pieces");
		lblPlayers2.setBounds(175, 170, 108, 23);
		lblPlayers2.setForeground(Color.WHITE);
		contentPane.add(lblPlayers2);
		
		lblPiece8 = new JLabel(new ImageIcon("Ressource/Games/Othello/White.png"));
		lblPiece8.setBounds(15, 197, 50, 50);
		lblPiece8.setBorder(white);
		lblPiece8.addMouseListener(this);
		contentPane.add(lblPiece8);
		
		lblPiece9 = new JLabel(new ImageIcon("Ressource/Games/Othello/Blue.png"));
		lblPiece9.setBounds(75, 197, 50, 50);
		lblPiece9.addMouseListener(this);
		contentPane.add(lblPiece9);
		
		lblPiece10 = new JLabel(new ImageIcon("Ressource/Games/Othello/Red.png"));
		lblPiece10.setBounds(135, 197, 50, 50);
		lblPiece10.addMouseListener(this);
		contentPane.add(lblPiece10);
		
		lblPiece11 = new JLabel(new ImageIcon("Ressource/Games/Othello/Orange.png"));
		lblPiece11.setBounds(195, 197, 50, 50);
		lblPiece11.addMouseListener(this);
		contentPane.add(lblPiece11);

		lblPiece12 = new JLabel(new ImageIcon("Ressource/Games/Othello/Lightblue.png"));
		lblPiece12.setBounds(255, 197, 50, 50);
		lblPiece12.addMouseListener(this);
		contentPane.add(lblPiece12);
		
		lblPiece13 = new JLabel(new ImageIcon("Ressource/Games/Othello/Yellow.png"));
		lblPiece13.setBounds(315, 197, 50, 50);
		lblPiece13.addMouseListener(this);
		contentPane.add(lblPiece13);
		
		lblPiece14 = new JLabel(new ImageIcon("Ressource/Games/Othello/Mauve.png"));
		lblPiece14.setBounds(375, 197, 50, 50);
		lblPiece14.addMouseListener(this);
		contentPane.add(lblPiece14);
		
		btnOk.setBounds(160, 267, 89, 23);
		btnOk.setBackground(Color.BLACK);
		btnOk.setForeground(Color.WHITE);
		btnOk.setBorder(white);
		btnOk.setFocusPainted(false);
		contentPane.add(btnOk);
		
		if (OS.indexOf("win") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));

		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
				OS.indexOf("aix") >= 0 || OS.indexOf("mac") >= 0 ||
				OS.indexOf("sunos") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnOn) {
			
		}
		
		if (source == btnOff) {
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if (source == lblPiece1) {
			lblPiece1.setBorder(white);
			lblPiece2.setBorder(null);
			lblPiece3.setBorder(null);
			lblPiece4.setBorder(null);
			lblPiece5.setBorder(null);
			lblPiece6.setBorder(null);
			lblPiece7.setBorder(null);
		}
		
		if (source == lblPiece2) {
			lblPiece1.setBorder(null);
			lblPiece2.setBorder(white);
			lblPiece3.setBorder(null);
			lblPiece4.setBorder(null);
			lblPiece5.setBorder(null);
			lblPiece6.setBorder(null);
			lblPiece7.setBorder(null);
		}
		
		if (source == lblPiece3) {
			lblPiece1.setBorder(null);
			lblPiece2.setBorder(null);
			lblPiece3.setBorder(white);
			lblPiece4.setBorder(null);
			lblPiece5.setBorder(null);
			lblPiece6.setBorder(null);
			lblPiece7.setBorder(null);
		}
		
		if (source == lblPiece4) {
			lblPiece1.setBorder(null);
			lblPiece2.setBorder(null);
			lblPiece3.setBorder(null);
			lblPiece4.setBorder(white);
			lblPiece5.setBorder(null);
			lblPiece6.setBorder(null);
			lblPiece7.setBorder(null);
		}
		
		if (source == lblPiece5) {
			lblPiece1.setBorder(null);
			lblPiece2.setBorder(null);
			lblPiece3.setBorder(null);
			lblPiece4.setBorder(null);
			lblPiece5.setBorder(white);
			lblPiece6.setBorder(null);
			lblPiece7.setBorder(null);
		}
		
		if (source == lblPiece6) {
			lblPiece1.setBorder(null);
			lblPiece2.setBorder(null);
			lblPiece3.setBorder(null);
			lblPiece4.setBorder(null);
			lblPiece5.setBorder(null);
			lblPiece6.setBorder(white);
			lblPiece7.setBorder(null);
		}
		
		if (source == lblPiece7) {
			lblPiece1.setBorder(null);
			lblPiece2.setBorder(null);
			lblPiece3.setBorder(null);
			lblPiece4.setBorder(null);
			lblPiece5.setBorder(null);
			lblPiece6.setBorder(null);
			lblPiece7.setBorder(white);
		}
		
		if (source == lblPiece8) {
			lblPiece8.setBorder(white);
			lblPiece9.setBorder(null);
			lblPiece10.setBorder(null);
			lblPiece11.setBorder(null);
			lblPiece12.setBorder(null);
			lblPiece13.setBorder(null);
			lblPiece14.setBorder(null);
		}
		
		if (source == lblPiece9) {
			lblPiece8.setBorder(null);
			lblPiece9.setBorder(white);
			lblPiece10.setBorder(null);
			lblPiece11.setBorder(null);
			lblPiece12.setBorder(null);
			lblPiece13.setBorder(null);
			lblPiece14.setBorder(null);
		}
		
		if (source == lblPiece10) {
			lblPiece8.setBorder(null);
			lblPiece9.setBorder(null);
			lblPiece10.setBorder(white);
			lblPiece11.setBorder(null);
			lblPiece12.setBorder(null);
			lblPiece13.setBorder(null);
			lblPiece14.setBorder(null);
		}
		
		if (source == lblPiece11) {
			lblPiece8.setBorder(null);
			lblPiece9.setBorder(null);
			lblPiece10.setBorder(null);
			lblPiece11.setBorder(white);
			lblPiece12.setBorder(null);
			lblPiece13.setBorder(null);
			lblPiece14.setBorder(null);
		}
		
		if (source == lblPiece12) {
			lblPiece8.setBorder(null);
			lblPiece9.setBorder(null);
			lblPiece10.setBorder(null);
			lblPiece11.setBorder(null);
			lblPiece12.setBorder(white);
			lblPiece13.setBorder(null);
			lblPiece14.setBorder(null);
		}
		
		if (source == lblPiece13) {
			lblPiece8.setBorder(null);
			lblPiece9.setBorder(null);
			lblPiece10.setBorder(null);
			lblPiece11.setBorder(null);
			lblPiece12.setBorder(null);
			lblPiece13.setBorder(white);
			lblPiece14.setBorder(null);
		}
		
		if (source == lblPiece14) {
			lblPiece8.setBorder(null);
			lblPiece9.setBorder(null);
			lblPiece10.setBorder(null);
			lblPiece11.setBorder(null);
			lblPiece12.setBorder(null);
			lblPiece13.setBorder(null);
			lblPiece14.setBorder(white);
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
