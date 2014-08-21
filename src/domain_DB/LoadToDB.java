package domain_DB;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain_connector.ConnectionParameters;
import domain_connector.DAOConnector;
import domain_exception.FileParsingException;
import domain_pojo.Orders;
import au.com.bytecode.opencsv.CSVReader;

public class LoadToDB implements Runnable,ConnectionParameters {
	private List<Orders> details = new ArrayList<>();
	private String filename;
	private Connection connection;
	public LoadToDB(String filename) {
		this.filename = filename;
	}

	private void getDataFromPath() {
		CSVReader reader;

		try {
			reader = new CSVReader(new FileReader(filename));

			String[] readline;
			while ((readline = reader.readNext()) != null) {
				for (int i = 0; i < readline.length; i++) {
					if ((readline[i].trim().length() == 0) || (readline[i].equals("NULL")))
						readline[i] = "0";
				}
				this.details.add(new Orders(readline));
			}
		} catch (IOException | NumberFormatException | FileParsingException e) {
			// TODO Auto-generated catch block
			new FileParsingException(e, e.getMessage());
			//System.exit(0);
			//e.printStackTrace();
		}

		// TODO Auto-generated method stub
	}

	private synchronized void addOrderListToDB() {
		// TODO Auto-generated method stub
		String[] Record = new String[new Orders().getClass().getDeclaredFields().length];
		Integer countRowsadded = 0;
		for (Orders obj : this.details){
			try {
				Record[0] = obj.getOrder_nbr().toString();
				Record[1] = obj.getOrder_date();
				Record[2] = obj.getRequired_date();
				Record[3] = obj.getShipped_date();
				Record[4] = obj.getStatus();
				Record[5] = obj.getComments();
				Record[6] = obj.getCustomer_number().toString();
				PreparedStatement pstmt;
				pstmt = connection.prepareStatement("insert into orders values (?,?,?,?,?,?,?);");
				pstmt.setInt(1,Integer.parseInt(Record[0]));
				pstmt.setDate(2,java.sql.Date.valueOf(Record[1]));
				pstmt.setDate(3,java.sql.Date.valueOf(Record[2]));
				pstmt.setDate(4,java.sql.Date.valueOf(Record[3]));
				pstmt.setString(5, Record[4]);
				pstmt.setString(6, Record[5]);
				pstmt.setInt(7,Integer.parseInt(Record[6]) );
				pstmt.executeUpdate();
				countRowsadded ++;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				new FileParsingException(e, e.getMessage());
			}
			
		}
		System.out.println(countRowsadded + " rows successfully added");
	}
	
	

	@Override
	public void run() {
		this.connection = (DAOConnector.connectToDB(Database_Url,User_Name,Password));
		if (this.connection == null)
			return;
		getDataFromPath();
		addOrderListToDB();
	}

	public static void addOrderToDB(){
		// TODO Auto-generated method stub
		Connection connection = (DAOConnector.connectToDB(Database_Url,User_Name,Password));
		String[] Record = new String[new Orders().getClass().getDeclaredFields().length];
		try {
			Scanner reader = new Scanner(System.in);
			System.out.println("Please enter Order Number");
			Record[0] = reader.next();
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
			PreparedStatement pstmt = connection.prepareStatement("insert into orders values (?,?,?,?,?,?,?);");
			pstmt.setInt(1,Integer.parseInt(Record[0]));
			pstmt.setDate(2,java.sql.Date.valueOf(Record[1]));
			pstmt.setDate(3,java.sql.Date.valueOf(Record[2]));
			pstmt.setDate(4,java.sql.Date.valueOf(Record[3]));
			pstmt.setString(5, Record[4]);
			pstmt.setString(6, Record[5]);
			pstmt.setInt(7,Integer.parseInt(Record[6]) );
			System.out.println(pstmt.executeUpdate() + " rows successfully added");
			System.out.println("Order Successfully Added");
			//connection.close();
			reader.close();
		} catch (NullPointerException | SQLException |IllegalArgumentException e) {
			new FileParsingException(e,e.getMessage());	
			System.out.println("Order not added");
			//e.printStackTrace();
			//new FileParsingException(e,e.getMessage());
			//e.printStackTrace();
		}
		
	}
	


}
