/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : ITicTacToe.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import be.umons.model.TicTacToe;

/**
 * <b> ITicTacToe is the GUI class of a Tic-Tac-Toe board. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class ITicTacToe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton button =  new JButton();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JButton button4 = new JButton();
	private JButton button5 = new JButton();
	private JButton button6 = new JButton();
	private JButton button7 = new JButton();
	private JButton button8 = new JButton();
	ImageIcon X = new ImageIcon("Ressource/X.jpg");
	ImageIcon O = new ImageIcon("Ressource/O.jpg");
	
	List<Object> list = new ArrayList<Object>();
	TicTacToe ttt = new TicTacToe(list);
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ITicTacToe frame = new ITicTacToe();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor that initialize the frame.
	 */
	
	public ITicTacToe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
		button = new JButton("");
		button.setBackground(Color.WHITE);
		contentPane.add(button);
		button.addActionListener(this);
		
		button1 = new JButton("");
		button1.setBackground(Color.WHITE);
		contentPane.add(button1);
		button1.addActionListener(this);
		
		button2 = new JButton("");
		button2.setBackground(Color.WHITE);
		contentPane.add(button2);
		button2.addActionListener(this);
		
		button3 = new JButton("");
		button3.setBackground(Color.WHITE);
		contentPane.add(button3);
		button3.addActionListener(this);
		
		button4 = new JButton("");
		button4.setBackground(Color.WHITE);
		contentPane.add(button4);
		button4.addActionListener(this);
		
		button5 = new JButton("");
		button5.setBackground(Color.WHITE);
		contentPane.add(button5);
		button5.addActionListener(this);
		
		button6 = new JButton("");
		button6.setBackground(Color.WHITE);
		contentPane.add(button6);
		button6.addActionListener(this);
		
		button7 = new JButton("");
		button7.setBackground(Color.WHITE);
		contentPane.add(button7);
		button7.addActionListener(this);
		
		button8 = new JButton("");
		button8.setBackground(Color.WHITE);
		contentPane.add(button8);
		button8.addActionListener(this);
		
		 // Name the JMenu & Add Items
        JMenu file = new JMenu("File");
        file.add(makeMenuItem("New game"));
        file.add(makeMenuItem("Load game"));
        file.add(makeMenuItem("Save game"));
        
        JMenu options = new JMenu("Options");
        options.add(makeMenuItem("Background"));
        options.add(makeMenuItem("Pawn's color"));
        
        JMenu about = new JMenu("About");
        
        JMenu quit = new JMenu("Quit");
 
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(options);
        menuBar.add(about);
        menuBar.add(quit);
        setJMenuBar(menuBar);
        setSize(300, 300);
        setLocation(200, 200);
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Menu item actions
        String command = e.getActionCommand();
        Object source = e.getSource(); 
        if (source == button) {
        		button.setIcon(X);
        }
        if (source == button1) {
        		button1.setIcon(O);
        }
        if (source == button2) {
        		button2.setIcon(X);
        }
        
        if (source == button3) {
        		button3.setIcon(O);
        }
        
        if (source == button4) {
        		button4.setIcon(X);
        }
        
        if (source == button5) {
        		button5.setIcon(O);
        }
        
        if (source == button6) {
        		button6.setIcon(X);
        }
        
        if (source == button7) {
        		button7.setIcon(O);
        }
        
        if (source == button8) {
        		button8.setIcon(X);
        }
        
 
        if (command.equals("Quit")) {
            System.exit(0);
        } else if (command.equals("Open")) {
            // Open menu item action
            System.out.println("Open menu item clicked");
        } else if (command.equals("Save")) {
            // Save menu item action
            System.out.println("Save menu item clicked");
        }		
	}
	
    private JMenuItem makeMenuItem(String name) {
        JMenuItem m = new JMenuItem(name);
        m.addActionListener(this);
        return m;
    }
}