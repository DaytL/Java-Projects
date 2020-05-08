import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Jtable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtable frame = new Jtable();
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
	Connection connection = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public Jtable() {
		connection = DAO.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Employees Data");
		btnLoadTable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select * from contacts ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
					pst.close();
					rs.close();
				} catch (Exception eq) {
					JOptionPane.showMessageDialog(null, eq);}
				
			}
		});
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLoadTable.setBounds(498, 35, 282, 41);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(352, 114, 623, 431);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("First Name*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(21, 88, 103, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(21, 148, 103, 32);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNp = new JLabel("Phone no.");
		lblPhoneNp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNp.setBounds(21, 209, 103, 32);
		contentPane.add(lblPhoneNp);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(21, 271, 103, 32);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(134, 93, 154, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 153, 154, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 214, 154, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(134, 276, 154, 29);
		contentPane.add(textField_3);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into contacts(first_name, last_name, phone_number, email, Eid) values(?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setInt(3, Integer.parseInt(textField_2.getText()));
					pst.setString(4, textField_3.getText());
					pst.setInt(5, Integer.parseInt(textField_4.getText()));
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					
					
				}catch (Exception er) {
					JOptionPane.showMessageDialog(null, er);
				}
			}
		});
		btnSave.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		btnSave.setBounds(30, 348, 127, 41);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "update contacts set first_name = '"+textField.getText()+"' , last_name = '"+textField_1.getText()+"' , phone_number = "+Integer.parseInt(textField_2.getText())+" , email = '"+textField_3.getText()+"' , Eid = "+Integer.parseInt(textField_4.getText())+" where id = "+Integer.parseInt(textField_5.getText());
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
					
				}catch (Exception er) {
					JOptionPane.showMessageDialog(null, er);
				}
			}
		});
		btnUpdate.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		btnUpdate.setBounds(30, 399, 127, 41);
		contentPane.add(btnUpdate);
		
		JLabel lblEid = new JLabel("Eid");
		lblEid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEid.setBounds(21, 40, 103, 32);
		contentPane.add(lblEid);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(134, 37, 154, 29);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(203, 409, 61, 32);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(173, 405, 34, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from contacts where id= "+Integer.parseInt(textField_6.getText());
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
					
				}catch (Exception er) {
					JOptionPane.showMessageDialog(null, er);
				}
			}
		});
		btnDelete.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		btnDelete.setBounds(30, 450, 127, 41);
		contentPane.add(btnDelete);
		
		JLabel label = new JLabel("Id");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(173, 456, 34, 32);
		contentPane.add(label);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(203, 460, 61, 32);
		contentPane.add(textField_6);
	}
}
