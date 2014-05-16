/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : TicTacToeChoiceMenu.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 **************************************************
 */

package be.umons.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import be.umons.model.AI;
import be.umons.model.FourInARow;
import be.umons.model.TicTacToe;

/**
 * <b> TicTacToeChoiceMenu is the GUI class of a Tic-Tac-Toe menu choice. </b>
 * 
 * @author AGOZZINO Terencio
 */

public class FourInARowChoiceMenu extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private JToggleButton btnOk = new JToggleButton("OK");
	
	private ButtonGroup player1 = new ButtonGroup();
	private ButtonGroup player2 = new ButtonGroup();
	private ButtonGroup level1 = new ButtonGroup();
	private ButtonGroup level2 = new ButtonGroup();
	
	private JRadioButton btnHuman = new JRadioButton("Human");
	private JRadioButton btnHuman2 = new JRadioButton("Human");
	private JRadioButton btnAI = new JRadioButton("AI");
	private JRadioButton btnAI2 = new JRadioButton("AI");
    
	private JRadioButton btnEasy = new JRadioButton("Easy");
	private JRadioButton btnMedium = new JRadioButton("Medium");
	private JRadioButton btnHard = new JRadioButton("Hard");
	
	private JRadioButton btnEasy2 = new JRadioButton("Easy");
	private JRadioButton btnMedium2 = new JRadioButton("Medium");
	private JRadioButton btnHard2 = new JRadioButton("Hard");
	
	private JTextField name = new JTextField("Player 1");
	private JTextField name2 = new JTextField("Player 2");
	
	JLabel lab3 = new JLabel(new ImageIcon("Ressource/Games/FourInARow/choicetheme.png"));
	
	private FourInARow fiar;
	
	public ImageIcon P1 = null;
	public ImageIcon P2 = null;
	
	private boolean canPass;
	
	private JLabel lab;
	private JLabel lab2;
	
	Border black = BorderFactory.createLineBorder(Color.BLACK, 1);
	
	/**
	 * Create the frame.
	 */
	
	public FourInARowChoiceMenu(final ImageIcon P1, final ImageIcon P2) {
		this.P1 = P1;
		this.P2 = P2;
		lab = new JLabel(P1);
		lab2 = new JLabel(P2);
		setTitle("Menu of Players");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		lab3.setBounds(100, 100, 450, 300);
		setContentPane(lab3);
		lab3.setBorder(black);
		lab3.setLayout(null);
		setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				FourInARowMenu frame = new FourInARowMenu(P1, P2) ;
				frame.setVisible(true);
			}
		});
			
		name.setForeground(Color.GRAY);
		name2.setForeground(Color.GRAY);
		
		name.addMouseListener(new MouseAdapter() {
			
			public void mousePressed (MouseEvent e) {
				name.setText("");
				name.setForeground(Color.BLACK);
			}
		});
		
		name2.addMouseListener(new MouseAdapter() {
			
			public void mousePressed (MouseEvent e) {
				name2.setText("");
				name2.setForeground(Color.BLACK);
			}
		});
		
	    player1.add(btnHuman);
	    player1.add(btnAI);
	    player2.add(btnHuman2);
	    player2.add(btnAI2);
	    level1.add(btnEasy);
	    level1.add(btnMedium);
	    level1.add(btnHard);
	    level2.add(btnEasy2);
	    level2.add(btnMedium2);
	    level2.add(btnHard2);
	    
		 ActionListener radiobtnActionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	
			        
		          if (btnHuman.isSelected()) {
		        	    lab3.setIcon(new ImageIcon("Ressource/Games/FourInARow/choicetheme.png"));
			        	lab3.repaint();
			        	
			    		name.setBounds(220, 39, 115, 23);
			    		name.setColumns(10);
			        	name.setVisible(true);
			        	lab3.add(name);
			        	
			        	btnEasy.setVisible(false);
			        	btnMedium.setVisible(false);
			        	btnHard.setVisible(false);
			        }
			        
			        if (btnHuman2.isSelected()) {
			        	lab3.setIcon(new ImageIcon("Ressource/Games/FourInARow/choicetheme.png"));
			        	lab3.repaint();
			        	
			    		name2.setBounds(220, 140, 115, 23);
			    		name2.setColumns(10);
			        	name2.setVisible(true);
			        	lab3.add(name2);
			        	
			        	btnEasy2.setVisible(false);
			        	btnMedium2.setVisible(false);
			        	btnHard2.setVisible(false);
			        }			    			     
			        
			        if (btnAI.isSelected()) {
			        	lab3.setIcon(new ImageIcon("Ressource/Games/FourInARow/choicetheme2.png"));
			        	lab3.repaint();
			        	
			        	btnEasy.setBounds(194, 78, 56, 23);
			    		btnEasy.setFocusPainted(false);
			    		btnEasy.setOpaque(false);
			    		btnEasy.setForeground(Color.WHITE);
			    		btnEasy.setVisible(true);
			    		lab3.add(btnEasy);
			    		
			    		btnMedium.setBounds(252, 78, 77, 23);
			    		btnMedium.setFocusPainted(false);
			    		btnMedium.setOpaque(false);
			    		btnMedium.setForeground(Color.WHITE);
			    		btnMedium.setVisible(true);
			    		lab3.add(btnMedium);
			    		
			    		btnHard.setBounds(331, 78, 66, 23);
			    		btnHard.setFocusPainted(false);
			    		btnHard.setOpaque(false);
			    		btnHard.setForeground(Color.WHITE);
			    		btnHard.setVisible(true);
			    		lab3.add(btnHard);
			    		
			        	name.setVisible(false);
			        	name.setText("");
			        }
			        
			        if (btnAI2.isSelected()) {
			        	lab3.setIcon(new ImageIcon("Ressource/Games/FourInARow/choicetheme3.png"));
			        	lab3.repaint();
			        	
			    		btnEasy2.setBounds(194, 179, 56, 23);
			    		btnEasy2.setFocusPainted(false);
			    		btnEasy2.setOpaque(false);
			    		btnEasy2.setForeground(Color.WHITE);
			    		btnEasy2.setVisible(true);
			    		lab3.add(btnEasy2);
			    		
			    		btnMedium2.setBounds(252, 179, 77, 23);
			    		btnMedium2.setFocusPainted(false);
			    		btnMedium2.setOpaque(false);
			    		btnMedium2.setForeground(Color.WHITE);
			    		btnMedium2.setVisible(true);
			    		lab3.add(btnMedium2);
			    		
			    		btnHard2.setBounds(331, 179, 66, 23);
			    		btnHard2.setFocusPainted(false);
			    		btnHard2.setOpaque(false);
			    		btnHard2.setForeground(Color.WHITE);
			    		btnHard2.setVisible(true);
			    		lab3.add(btnHard2);
			    		
			        	name2.setVisible(false);
			        	name2.setText("");
			        }
			        
			        if (btnAI.isSelected() && btnAI2.isSelected()) {
		    			lab3.setIcon(new ImageIcon("Ressource/Games/FourInARow/choicetheme4.png"));
		    			lab3.repaint();		
		    			
	    				btnEasy2.setBounds(194, 179, 56, 23);
	    				btnEasy2.setFocusPainted(false);
	    				btnEasy2.setOpaque(false);
	    				btnEasy2.setForeground(Color.WHITE);
	    				btnEasy2.setVisible(true);
	    				lab3.add(btnEasy2);

	    				btnMedium2.setBounds(252, 179, 77, 23);
	    				btnMedium2.setFocusPainted(false);
	    				btnMedium2.setOpaque(false);
	    				btnMedium2.setForeground(Color.WHITE);
	    				btnMedium2.setVisible(true);
	    				lab3.add(btnMedium2);

	    				btnHard2.setBounds(331, 179, 66, 23);
	    				btnHard2.setFocusPainted(false);
	    				btnHard2.setOpaque(false);
	    				btnHard2.setForeground(Color.WHITE);
	    				btnHard2.setVisible(true);
	    				lab3.add(btnHard2);
	    				
	    				name2.setVisible(false);
	    				name2.setText("");	    				
		    		}
			      }
			    };
			    
		    if (btnAI.isSelected() && btnAI.isSelected()) {
		        	System.out.println("ok");
		        	lab3.setIcon(new ImageIcon("Ressource/Games/FourInARow/choicetheme4.png"));
		        	lab3.repaint();
		    }
			
			btnHuman.setBounds(148, 39, 66, 23);
			btnHuman.setFocusPainted(false);
			btnHuman.setOpaque(false);
			btnHuman.setForeground(Color.WHITE);
			lab3.add(btnHuman);
			btnHuman.addActionListener(radiobtnActionListener);

			btnAI.setBounds(148, 78, 47, 23);
			btnAI.setFocusPainted(false);
			btnAI.setOpaque(false);
			btnAI.setForeground(Color.WHITE);
			lab3.add(btnAI);
			btnAI.addActionListener(radiobtnActionListener);

			btnHuman2.setBounds(148, 139, 66, 23);
			btnHuman2.setFocusPainted(false);
			btnHuman2.setOpaque(false);
			btnHuman2.setForeground(Color.WHITE);
			lab3.add(btnHuman2);
			btnHuman2.addActionListener(radiobtnActionListener);

			btnAI2.setBounds(148, 179, 47, 23);
			btnAI2.setFocusPainted(false);
			btnAI2.setOpaque(false);
			btnAI2.setForeground(Color.WHITE);
			lab3.add(btnAI2);
			btnAI2.addActionListener(radiobtnActionListener);
			
		JLabel player = new JLabel("Player 1:");
		player.setBounds(74, 43, 56, 14);
		player.setForeground(Color.WHITE);
		player.setFont(new Font("Fixedsys", Font.BOLD, 13));
		lab3.add(player);

		JLabel player2 = new JLabel("Player 2:");
		player2.setBounds(74, 143, 56, 14);
		player2.setForeground(Color.WHITE);
		player2.setFont(new Font("Fixedsys", Font.BOLD, 13));
		lab3.add(player2);

		lab.setBounds(10, 25, 56, 51);
		lab3.add(lab);

		lab2.setBounds(10, 121, 56, 51);
		lab3.add(lab2);

		btnOk = new JToggleButton("OK");
		btnOk.setBounds(161, 227, 89, 23);
		btnOk.setFocusPainted(false);
		btnOk.addActionListener(this);
		lab3.add(btnOk);
		
		if (OS.indexOf("win") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));

		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
				OS.indexOf("aix") >= 0 || OS.indexOf("mac") >= 0 ||
				OS.indexOf("sunos") >= 0)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Ressource\\logo.png"));
	}
	
	
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	List<Object> list = new ArrayList<Object>();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnOk) {
			dispose();
			list.add(name.getText());
			list.add(name2.getText());		
					
			if (btnAI.isSelected()) {
				AI ai = new AI(fiar);
				if (btnEasy.isSelected()) {
					list.set(0, "EASY AI");
					ai.setDifficulty(0);
				}

				if (btnMedium.isSelected()) {
					list.set(0, "MEDIUM AI");
					ai.setDifficulty(1);
				}

				if (btnHard.isSelected()) {
					list.set(0, "HARD AI");
					ai.setDifficulty(2);
				}
			}


			if (btnAI2.isSelected()) {
				AI ai2 = new AI(fiar);
				if (btnEasy2.isSelected()) {
					list.set(1, "EASY AI");	
					ai2.setDifficulty(0);
				}

				if (btnMedium2.isSelected()) {
					list.set(1, "MEDIUM AI");	
					ai2.setDifficulty(1);
				}

				if (btnHard2.isSelected()) {
					list.set(1, "HARD AI");	
					ai2.setDifficulty(2);
				}
			}

			else if (name.getDocument().getLength() > 15) {
				canPass = false;
				JOptionPane.showMessageDialog (null, "The length of the name of the first player is too long !", "ERROR", JOptionPane.WARNING_MESSAGE);
				FourInARowChoiceMenu frame = new FourInARowChoiceMenu(P1, P2);			
				frame.setVisible(true);
			}
			
			else if (name2.getDocument().getLength() > 15) {
				canPass = false;
				JOptionPane.showMessageDialog (null, "The length of the name of the second player is too long !", "ERROR", JOptionPane.WARNING_MESSAGE);
				FourInARowChoiceMenu frame = new FourInARowChoiceMenu(P1, P2);		
				frame.setVisible(true);
			}
			
			else if (list.get(0).equals("")) {
				canPass = false;
				JOptionPane.showMessageDialog (null, "An error occurred when selecting players", "ERROR", JOptionPane.WARNING_MESSAGE);
				FourInARowChoiceMenu frame = new FourInARowChoiceMenu(P1, P2);		
				frame.setVisible(true);
			}

			else {
				if (canPass = true) {
					try {
						FourInARowGame frame = new FourInARowGame(list, P1, P2, 0, 0);
						frame.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}