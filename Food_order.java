import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Image;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Window.Type;


public class Food_order extends JFrame {
	
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon i1 = new ImageIcon("C:\\Users\\rohit\\eclipse-workspace\\SCE\\src\\Image_source\\baseline_add_to_photos_black_18dp.png");
		Image i2 = i1.getImage().getScaledInstance(30, 40, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		setBounds(100, 100, 835, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 50, 230, 303);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(270, 62, 528, 277);

		Object[][] data= new Object[20][2] ;
		String [] column = {"No.","Pending Order"};
		data[0][0]=1;
		data[0][1]="Table No. 2";
		data[1][0]=3;
		data[1][1]="table No. 8";
		DefaultTableModel Model = new DefaultTableModel(data,column);
		JTable t1 = new JTable(Model);
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
	}
}
