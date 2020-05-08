import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Log_In_page {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_In_page window = new Log_In_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField textFieldUS;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Log_In_page() {
		initialize();
		connection =  DAO.connect();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUS = new JTextField();
		textFieldUS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUS.setBounds(401, 111, 146, 23);
		frame.getContentPane().add(textFieldUS);
		textFieldUS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblNewLabel.setBounds(230, 104, 161, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblNewLabel_1.setBounds(240, 163, 133, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		Image img1= new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img1));

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					String query = "select * from accounts_info where username= ? and pass  = ?";
					PreparedStatement pst = connection.prepareStatement(query);
	
						pst.setString(1, textFieldUS.getText());
						pst.setString(2, passwordField.getText());
						
						ResultSet rs =  pst.executeQuery();
						int count = 0;
						while(rs.next()) {
								count++;
						}
						if(count==1) 
						{
							JOptionPane.showMessageDialog(null, "Login Successfull");
							frame.dispose();
							Jtable jframe = new Jtable();
							jframe.setVisible(true);
						}
						else if(count>1) 
						{
							JOptionPane.showMessageDialog(null, "Duplicate");
						}
						else {JOptionPane.showMessageDialog(null, "Incorrect username or password");}
			
						rs.close();
						pst.close();
					} catch (Exception ew) {
					JOptionPane.showMessageDialog(null, ew);
					}

					}
			}
		);
		btnLogin.setBackground(new Color(0, 255, 127));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(278, 275, 161, 57);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(401, 165, 146, 23);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(44, 89, 174, 174);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
