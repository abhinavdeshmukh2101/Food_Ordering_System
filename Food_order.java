import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

import java.awt.Image;
import java.awt.Event;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Food_order extends JFrame {
	
	private static final int SERVER_PORT = 5500;
	private int current_row = 0;
	Object[][] data;
	Object[][] order_table;
	private String menu;
	int total_items;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food_order jf = new Food_order();
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
	
	
	public Food_order() {
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Arial", Font.BOLD, 20));
		setBackground(new Color(245, 222, 179));
		setType(Type.POPUP);
		setTitle("Annas Cafe");
		getContentPane().setBackground(Color.GRAY);
		initialize();
	}
	
	private void display_orders() {
		for(int i=0;i<20;i++) {
			data[i][0] = i+1;
			data[i][1] = order_table[i][1];
			data[i][2] = order_table[i][2];
		}
	}
	
	private void update_tbl_no(String order) {
		data[current_row][1] = Integer.parseInt(order.substring(0,1));
		current_row++;
	}
	
	private void temp_storage(String order) {
		
		order_table = new Object[20][3];  // temporary storage of order.
    	
    	if(order.contains("starters")) {
    		menu = "starters";
    		order.replace("starters", "");
    	}
    	else if(order.contains("main course")) {
    		menu = "main course";
    		order.replace("main course", "");
    	}
    	else if(order.contains("snacks")) {
    		menu = "snacks";
    		order.replace("snacks", "");
    	}
    	else if(order.contains("dessert")) {
    		menu = "dessert";
    		order.replace("dessert","");
    	}
    	
    	try {
    	   	Class.forName("com.mysql.cj.jdbc.Driver");  
    	   	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + menu ,"root","Deshmukh@1");  
    	   	Statement stmt = con.createStatement();
    	   	String sql = "select * from "+menu;
    	   	ResultSet rs = stmt.executeQuery(sql);
    	   	
    	   	int i = 1;
    	   	while(order != "") {
    	   		String item_id = order.substring(0,2);
    	   		int q = Integer.parseInt(order.substring(2,3));
    	   		
    	   		while(rs.next()) {
        	   		if(rs.getString("id") == item_id) {
        	   			order_table[i-1][0] = i;
        	   			order_table[i-1][1] = rs.getString("item");
        	   			order_table[i-1][2] = q;
        	   		}
        	   	}
    	   		
    	   		order.replace(order.substring(0,3), "");
    	   	}
    	}
    	catch(Exception e1) {
    		 	System.out.println(e1);
    	}
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 * @return 
	 */
	private void initialize() {
		ImageIcon i1 = new ImageIcon("C:\\Users\\Abhinav Deshmukh\\eclipse-workspace\\JavaSCE\\src\\Image_source\\baseline_add_to_photos_black_18dp.png");
		Image i2 = i1.getImage().getScaledInstance(30, 40, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		setBounds(100, 100, 835, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		// top panel.
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 821, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Food Menu");
		btnNewButton.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.setBounds(58, 7, 104, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Billing History");
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton_1.setBounds(172, 7, 104, 30);
		panel.add(btnNewButton_1);
		
		//left panel
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 50, 230, 303);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		//right panel
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(270, 62, 528, 277);
		
		
		// making table on left panel
		Object[][] data1= new Object[20][3];
		String [] column1 = {"Sr. No.","Ordered Items","Quantity"};
		
		DefaultTableModel Model = new DefaultTableModel(data1,column1);
		JTable t2 = new JTable(Model) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		
		t2.setFont(new Font("Arial Black", Font.BOLD, 12));
		t2.setRowHeight(20);
		t2.setToolTipText("Ordered Items");
		t2.setSelectionForeground(new Color(128, 0, 0));
		t2.setSelectionBackground(new Color(0, 255, 255));
		t2.setGridColor(new Color(0, 0, 139));
		t2.setForeground(new Color(0, 0, 0));
		t2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		t2.setBackground(new Color(173, 255, 47));
		t2.addPropertyChangeListener(getName(), null);
		TableColumn tc01 = t2.getColumnModel().getColumn(0);
//		TableColumn tc2 = ;
		tc01.setMinWidth(10);
		tc01.setMaxWidth(20);
		tc01.setPreferredWidth(20);
		panel_1.setLayout(null);
		
		JScrollPane p1 = new JScrollPane(t2);
		p1.setBorder(new CompoundBorder());
		p1.setBounds(5, 5, 150, 300);
		panel_1.add(p1);
		getContentPane().add(panel_1);
        p1.setVisible(false);    // will be visible is table1 button is click.
       
			
		// table on right panel
		data= new Object[20][2] ;
		String [] column = {"No.","Table Number"};

		
//		data[0][0]=1;
//		data[0][1] = 1; // table number
//		data[1][0]=2;
//		data[1][1]=8; // table number
		
		DefaultTableModel Model1 = new DefaultTableModel(data,column);
		JTable t1 = new JTable(Model1) { // disables the editing inside the table
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
			
		};
		
		// for displaying the order in server table
		t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p1.setVisible(true);
			    int index = t1.getSelectedRow();
			    TableModel model = t1.getModel();
			    
			    
			}
		});
		
		
		
		
		t1.setFont(new Font("Arial Black", Font.BOLD, 12));
		t1.setRowHeight(20);
		t1.setToolTipText("Recent Orders");
		t1.setSelectionForeground(new Color(128, 0, 0));
		t1.setSelectionBackground(new Color(0, 255, 255));
		t1.setGridColor(new Color(0, 0, 139));
		t1.setForeground(new Color(0, 0, 0));
		t1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		t1.setBackground(new Color(173, 255, 47));
		t1.addPropertyChangeListener(getName(), null);
		TableColumn tc1 = t1.getColumnModel().getColumn(0);
		tc1.setMinWidth(30);
		tc1.setMaxWidth(30);
		tc1.setPreferredWidth(30);
		panel_2.setLayout(null);
	
		JScrollPane p = new JScrollPane(t1);
		p.setBorder(new CompoundBorder());
		p.setBounds(41, 29, 452, 225);
		panel_2.add(p);
		getContentPane().add(panel_2);
		
		
		try {
	    	System.out.println("SERVER - started");
	    	ServerSocket listener = new ServerSocket(SERVER_PORT);
	    	System.out.println("SERVER - waiting for client connection...");
	    	Socket socket = listener.accept();   // single socket
	    	System.out.println("SERVER - connected to client!");
	    	
	    	BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	String order = br.readLine();
	    	
	    	System.out.println("Client order: " + order);
	    	
	    	//update table no.
	    	update_tbl_no(order);
	    	order.replace(order.substring(0,1), "");
	    	total_items = Integer.parseInt(order.substring(0,1));
	    	order.replace(order.substring(0,1), "");

	    	temp_storage(order);   // temporary storage of order in order_table variable.	
	    	
	    	display_orders();
	    	
	    	listener.close();
	    	socket.close();
	    	
	    }
	    catch(Exception e1) {
	    	System.out.println(e1);
	    }
		
	}
}
