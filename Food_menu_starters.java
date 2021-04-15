import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Food_menu_starters extends JFrame {
	private JScrollPane p;
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food_menu_starters jf = new Food_menu_starters();
					jf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Food_menu_starters() {
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Arial", Font.BOLD, 20));
		setBackground(new Color(245, 222, 179));
		setType(Type.POPUP);
		setTitle("Annas Cafe");
		getContentPane().setBackground(Color.GRAY);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		setBounds(100, 100, 513, 461);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(10, 10, 481, 404);
		

		Object[][] data= new Object[20][3] ;
		String [] column = {"No.","Starters","Price"};
		
		// reads starters from menu the data from server.
		
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starters","root","Deshmukh@1");    
			Statement stmt = con.createStatement(); 
			
			ResultSet rs = stmt.executeQuery("Select * from starters");
			
			for(int i=0;rs.next();i++) {
				data[i][0] = i+1;
				data[i][1] = rs.getString(1);  // will store item
				data[i][2] = rs.getInt(2); 	   // will store the corresponding price.
			}
	     }
	     catch(Exception e1) {
	    	 System.out.println(e1);
	     }
		
		
		DefaultTableModel Model = new DefaultTableModel(data,column);
		final JTable t1 = new JTable(Model);
		t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		     int index = t1.getSelectedRow();
		     TableModel model = t1.getModel();
		     int t_no = Integer.parseInt(JOptionPane.showInputDialog("Order for which Table number"));
		     int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity"));
		    
		     
		     // sending data to database.
		     
		     try {
		    	 Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","Deshmukh@1");    
				Statement stmt = con.createStatement(); 
				
				String query = "INSERT INTO orders (t_no,item,qty) " + "VALUES(+" + t_no + "," +data[index][1]+","+quantity+");";
				stmt.executeQuery(query); 
		     }
		     catch(Exception e1) {
		    	 System.out.println(e1);
		     }
			}
		});
		t1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		t1.setRowHeight(20);
		
		t1.setSelectionForeground(new Color(128, 0, 0));
		t1.setSelectionBackground(new Color(127, 255, 0));
		t1.setGridColor(new Color(0, 0, 139));
		t1.setForeground(new Color(0, 0, 0));
		t1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		t1.setBackground(new Color(255, 250, 205));
		t1.addPropertyChangeListener(getName(), null);
		TableColumn tc1 = t1.getColumnModel().getColumn(0);
		tc1.setMinWidth(30);
		tc1.setMaxWidth(50);
		tc1.setPreferredWidth(30);
		panel_1.setLayout(null);
	
		p = new JScrollPane(t1);
		p.setFont(new Font("Goudy Old Style", Font.BOLD, 13));
		p.setBounds(10, 10, 457, 334);
		p.setBorder(new CompoundBorder());
		panel_1.add(p);
		getContentPane().add(panel_1);
		
		JButton submitbtn = new JButton("Submit");
		submitbtn.setBackground(new Color(127, 255, 0));
		submitbtn.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		submitbtn.setBounds(158, 354, 144, 40);
		panel_1.add(submitbtn);
	}
}
