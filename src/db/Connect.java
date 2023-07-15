package db;
import java.sql.*;

public class Connect {
	private Connection con;

	public void closeCon() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/drivefullthrottle", 
					"root", 
					""
			);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
}
