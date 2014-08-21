package domain_connector_test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import domain_DB.DeleteFromDB;
import domain_DB.LoadToDB;
import domain_DB.RetrieveFromDB;
import domain_DB.UpdateDB;
import domain_connector.DAOConnector;
import domain_exception.DatabaseAccessException;
import domain_pojo.Customer;
import domain_pojo.Employees;

public class Mp3_test {

	@Test
	public void test() {
		Scanner reader = new Scanner(System.in);
		Integer option = 0;
		Integer opinion = 0;
		List<Customer> customerlist = new ArrayList<>();
		List<Employees> employeelist = new ArrayList<>();
		while(true){
			System.out.println("Please select one of the below options");
			System.out.println("1.Load database data into application\n2.Add/Update new order\n3.view/delete any customer\n4.view/delete any employee"
					+ "\n5.view all employees\n6.view all customers\n7.Exit");
			option = reader.nextInt();
			switch(option){
			case 1:
				
				List <Object> Objectlist = RetrieveFromDB.retrieveList(new Customer());
				for (Object obj : Objectlist)
					customerlist.add((Customer)obj);
				 
				Objectlist = RetrieveFromDB.retrieveList(new Employees());
				for (Object obj : Objectlist)
					employeelist.add((Employees)obj);
				break;
			case 2:
				System.out.println("Please select one of the below\n1.Add new Order file\n"
						+ "2.Add new Order\n3.Modify Existing Order Details");
				opinion = reader.nextInt();
				if (opinion.equals(new Integer("1"))){
					System.out.println("Please enter the path of the orders file");
					String orderfilename = reader.next();
					new LoadToDB(orderfilename).run();
				}
				else if (opinion.equals(new Integer("2"))){
					LoadToDB.addOrderToDB();
				}
				else if (opinion.equals(new Integer("3"))){
					UpdateDB.updateOrder();
				}
				else
					System.out.println("Invalid option");
				break;
			case 3:
				System.out.println("Please customer number");
				Integer customernumber = reader.nextInt();
				System.out.println("Would to like to\n1.View \n2.Delete");
				opinion = reader.nextInt();
				if (opinion.equals(new Integer("2")))
					DeleteFromDB.deleteFromDB(new Customer(),customernumber);
				else if (opinion.equals(new Integer("1")))
					RetrieveFromDB.retrieveRowFromDB(new Customer(),customernumber);
				else
					System.out.println("Invalid Option");
				break;
			case 4:
				System.out.println("Please Employee number");
				Integer employeenumber = reader.nextInt();
				System.out.println("Would to like to\n1.View \n2.Delete");
				opinion = reader.nextInt();
				if (opinion.equals(new Integer("2")))
					DeleteFromDB.deleteFromDB(new Employees(),employeenumber);
				else if (opinion.equals(new Integer("1")))
					RetrieveFromDB.retrieveRowFromDB(new Employees(),employeenumber);
				else
					System.out.println("Invalid Option");
				break;
			case 6:
				if (customerlist.size() >0){
					for ( Customer customer : customerlist)
						System.out.println(customer.toString());
				}
				else
					System.out.println("Load data from database and then try viewing");
				break;
			case 5:
				if (employeelist.size()>0){
					for (Employees employee : employeelist)
						System.out.println(employee.toString());
				}
				else
					System.out.println("Load data from database and then try viewing");
				break;
			case 7:
				System.exit(0);
			}
		}
		// data retrieval
		/*List<Customer> customerlist = new ArrayList<>(); 
		List <Object> Objectlist = RetrieveFromDB.retrieveList(new Customer());
		for (Object obj : Objectlist)
			customerlist.add((Customer)obj);
		List<Employees> employeelist = new ArrayList<>(); 
		Objectlist = RetrieveFromDB.retrieveList(new Employees());
		for (Object obj : Objectlist)
			employeelist.add((Employees)obj);
		// Retrieval complete
		*/
		
		// Delete customer order from DB
		/*
		System.out.println("Please customer number to delete");
		Integer customernumber = reader.nextInt();
		DeleteFromDB.deleteFromDB(new Customer(),customernumber);
		*/
		// New order to be added to the DB
		
		//LoadToDB.addOrderToDB();
		
		// Load an order file into DB
		/*System.out.println("Please enter the path of the orders file");
		String orderfilename = reader.next();
		new LoadToDB(orderfilename).run();
		*/
		/*
		System.out.println("Please enter the Order Number to be updated");
		Integer ordernumber = reader.nextInt();
		UpdateDB.updateOrder(ordernumber);
		*/
	}

}
