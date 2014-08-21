package domain_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import domain_connector.ConnectionParameters;
import domain_connector.DAOConnector;
import domain_exception.FileParsingException;
import domain_pojo.Orders;

public class UpdateDB implements ConnectionParameters{

	public static void updateOrder() {
		// TODO Auto-generated method stub
		System.out.println("Please enter the orderNumber");
		Scanner reader = new Scanner(System.in);
		Integer ordernumber = reader.nextInt();
//		System.out.println(RetrieveFromDB.retrieveRowFromDB(new Orders(),ordernumber));
		if (RetrieveFromDB.retrieveRowFromDB(new Orders(),ordernumber)>0){
			try {
				Thread.sleep(1000);
				Connection connection = (DAOConnector.connectToDB(Database_Url,User_Name,Password));
				if (connection == null)
					return;
				String[] Record = new String[new Orders().getClass().getDeclaredFields().length];
				System.out.println("Please enter Order Date in the format yyyy-mm-dd");
				Record[1] = reader.next();
				System.out.println("Please enter Required Date in the format yyyy-mm-dd");
				Record[2] = reader.next();
				System.out.println("Please enter Shipped Date in the format yyyy-mm-dd");
				Record[3] = reader.next();
				System.out.println("Please enter Status");
				Record[4] = reader.next();
				System.out.println("Please enter Comments");
				Record[5] = reader.next();
				System.out.println("Please enter Customer Number");
				Record[6] = reader.next();
				PreparedStatement pstmt;
				pstmt = connection.prepareStatement("update orders set orderDate=?,requiredDate=?,shippedDate=?,status=?,comments=?,customerNumber=? where orderNumber=?");
				pstmt.setDate(1,java.sql.Date.valueOf(Record[1]));
				pstmt.setDate(2,java.sql.Date.valueOf(Record[2]));
				pstmt.setDate(3,java.sql.Date.valueOf(Record[3]));
				pstmt.setString(4, Record[4]);
				pstmt.setString(5, Record[5]);
				pstmt.setInt(6,Integer.parseInt(Record[6]) );
				pstmt.setInt(7,ordernumber);
				System.out.println(pstmt.executeUpdate() + " rows successfully updated");
				connection.close();
			} catch (NullPointerException | SQLException |IllegalArgumentException | InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Order not updated");
				new FileParsingException(e,e.getMessage());
			}
			
		}
		else
			System.out.println("Order number not found in the system");
	}
	
	

}
