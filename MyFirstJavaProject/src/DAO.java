import java.sql.*;

	
import javax.swing.JOptionPane;

public class DAO {
	//Connection conn = null;
	public static Connection connect ()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/accounts","root","jska@jessicajosephson#12");
		JOptionPane.showMessageDialog(null, "Connection Successful");
		return conn; 	
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
		return null;
		}
	}
}
