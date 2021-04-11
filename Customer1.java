package java_Practise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Customer1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer1 window = new Customer1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 215, 0));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 825, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Food Ordering System");
		lblNewLabel.setBounds(152, 37, 549, 125);
		lblNewLabel.setBackground(new Color(165, 42, 42));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Starters");
		btnNewButton.setBounds(37, 291, 175, 57);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Food_menu_starters();
				Food_menu_starters.NewScreen();
			}
		});
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Snacks");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(222, 291, 175, 57);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Main Course");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(407, 291, 175, 57);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(220, 20, 60));
		btnNewButton_2.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dessert");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(592, 291, 175, 57);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(220, 20, 60));
		btnNewButton_3.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Generate Bill");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(295, 388, 217, 63);
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(128, 0, 128));
		btnNewButton_4.setFont(new Font("Goudy Old Style", Font.BOLD, 28));
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("*Select the items to place order*");
		lblNewLabel_2.setBounds(199, 172, 409, 76);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Script MT Bold", Font.BOLD, 30));
	}
}
