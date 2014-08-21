package domain_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain_connector.ConnectionParameters;
import domain_connector.DAOConnector;
import domain_exception.FileParsingException;

public class DeleteFromDB implements ConnectionParameters{
	public static void deleteFromDB(Object classname, Integer primarykey) {
		// TODO Auto-generated method stub
		Connection connection = (DAOConnector.connectToDB(Database_Url,User_Name,Password));
		String tablename;
		String fieldname;
		if (connection == null)
			return;
		try {
			if (classname.getClass().getName().equals("domain_pojo.Customer")){
				tablename = "customers";
				fieldname = "customerNumber";
			}
			else if (classname.getClass().getName().equals("domain_pojo.Employees")){
				tablename = "employees";
				fieldname = "employeeNumber";
			}
			else
			throw new ClassNotFoundException();
			PreparedStatement pstmt = connection.prepareStatement("delete from "+tablename+" where "+fieldname+"=?");
			pstmt.setInt(1,primarykey);
			System.out.println(pstmt.executeUpdate() + " rows successfully deleted");
		}
		catch (ClassNotFoundException | SQLException e){
			
			new FileParsingException(e,e.getMessage());
			System.out.println("Data deletion not complete");
			
		}
	}

}
