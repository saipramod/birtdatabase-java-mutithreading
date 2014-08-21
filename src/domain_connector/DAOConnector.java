package domain_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import domain_exception.DatabaseAccessException;

public class DAOConnector {

	private static Connection connection = null;
	
	public static Connection connectToDB(String Database_Url,String User_Name,String Password){
		if (connection == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(Database_Url, User_Name,Password);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				new DatabaseAccessException(e,e.getMessage());
				return null;
			}
		}
		return connection;
	}

		
}
