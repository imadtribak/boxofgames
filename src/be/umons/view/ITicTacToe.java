package be.umons.view;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ITicTacToe extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ITicTacToe frame = new ITicTacToe();
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
	public ITicTacToe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
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
		
		addMouseListener(new MouseListener() {
			
	        public void mouseReleased(MouseEvent e) {
	            System.out.println(e);
	        }

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
	    });	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Menu item actions
        String command = e.getActionCommand();
 
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