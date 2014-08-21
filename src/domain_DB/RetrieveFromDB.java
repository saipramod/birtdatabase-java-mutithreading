package domain_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain_connector.ConnectionParameters;
import domain_connector.DAOConnector;
import domain_exception.FileParsingException;
import domain_pojo.Customer;
import domain_pojo.Employees;
import domain_pojo.Orders;

public class RetrieveFromDB implements ConnectionParameters{
	public static  List<Object> retrieveList(Object classname) {
		List<Object> objectlist = new ArrayList<>();
		String tablename = null;
		Connection connection = (DAOConnector.connectToDB(Database_Url,User_Name,Password));
		if (connection == null)
			return objectlist;
		try {
			if (classname.getClass().getName().equals("domain_pojo.Customer"))
				tablename = "customers";
			else if (classname.getClass().getName().equals("domain_pojo.Employees"))
				tablename = "employees";
			else if (classname.getClass().getName().equals("domain_pojo.Orders"))
				tablename = "orders";
			else
				throw new ClassNotFoundException();
			PreparedStatement pstmt = connection.prepareStatement("select * from "+tablename);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData metaData = rset.getMetaData();
		    Integer columns = metaData.getColumnCount();
			while (rset.next()){
				String[] readline = new String[columns];
				for (int  i=1 ;i<=columns;i++){
					try {
						if (rset.getString(i).equals(null))
							readline[i-1] = "0";
						else
							readline[i-1] = rset.getString(i);
					}
					catch (NullPointerException e){
							readline[i-1] = "0";
					}
				}
				if (classname.getClass().getName().equals("domain_pojo.Customer"))
					objectlist.add((Object) new Customer(readline));
				if (classname.getClass().getName().equals("domain_pojo.Employees"))
					objectlist.add((Object) new Employees(readline));
				
			}
			System.out.println("Data loading complete for "+classname.getClass().getName());
			//connection.close();
		} catch (SQLException | NullPointerException|ClassNotFoundException|NumberFormatException e) {
			// TODO Auto-generated catch block
			new FileParsingException(e,e.getMessage());
			System.out.println("Data retrieval not complete");
		}
		// TODO Auto-generated method stub
		return objectlist;
	}


	public static Integer retrieveRowFromDB(Object classname, Integer primarykey) {
			// TODO Auto-generated method stub
		Connection connection = (DAOConnector.connectToDB(Database_Url,User_Name,Password));
		String tablename;
		String fieldname;
		Integer rowcount = 0;
		if (connection == null)
				return rowcount;
		try {
			if (classname.getClass().getName().equals("domain_pojo.Customer")){
				tablename = "customers";
				fieldname = "customerNumber";
				}
			else if (classname.getClass().getName().equals("domain_pojo.Employees")){
				tablename = "employees";
				fieldname = "employeeNumber";}
				
			else if (classname.getClass().getName().equals("domain_pojo.Orders")){
				tablename = "orders";
				fieldname = "orderNumber";
			}
			else
				throw new ClassNotFoundException();
			PreparedStatement pstmt = connection.prepareStatement("select * from "+tablename+" where "+fieldname+"=?");
			pstmt.setInt(1, primarykey);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData metaData = rset.getMetaData();
		    Integer columns = metaData.getColumnCount();
			while (rset.next()){
				rowcount++;
				String[] readline = new String[columns];
				for (int  i=1 ;i<=columns;i++){
					try {
						if (rset.getString(i).equals(null))
							readline[i-1] = "0";
						else
							readline[i-1] = rset.getString(i);
					}
					catch (NullPointerException e){
							readline[i-1] = "0";
					}
				}
				if (classname.getClass().getName().equals("domain_pojo.Orders"))				
					System.out.println("Below are current order details\n" + new Orders(readline).toString());
				else if (classname.getClass().getName().equals("domain_pojo.Customer"))				
					System.out.println("Below are current order details\n" + new Customer(readline).toString());
				else if (classname.getClass().getName().equals("domain_pojo.Employees"))				
					System.out.println("Below are current order details\n" + new Employees(readline).toString());		
			}
			//connection.close();
		}
		catch (ClassNotFoundException | SQLException | FileParsingException e){
			
			new FileParsingException(e,e.getMessage());
			System.out.println("Data retrieveal not complete");
				
		}
		if (rowcount == 0)
			System.out.println("Order not present at DB");
		return rowcount;
		
	}
}
