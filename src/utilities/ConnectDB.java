/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author maida
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {
	public static Connection con = null;

	private static ConnectDB instance = new ConnectDB();	
	public static ConnectDB getInstance() {
		return instance;
	}

	public void connect() throws SQLException {				
			String url = "jdbc:sqlserver://localhost:1433;databasename=quan_ly_dan_cu";
			con = DriverManager.getConnection(url, "sa", "sa");
	}	
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {	e.printStackTrace();			}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl=
					"jdbc:sqlserver://localhost\\DESKTOP-4LD8N6N:1433;"
					+ "databaseName=quan_ly_dan_cu;"
					+ "user=sa;"
					+ "password=sa;"
					+ "encrypt=false";
			conn= DriverManager.getConnection(connectionUrl);
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return conn;
        
	}
        
       
        public static void main(String[] args) {
            System.out.println(getConnection());
        }
}
