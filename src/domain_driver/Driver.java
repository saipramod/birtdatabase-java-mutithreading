package domain_driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain_DB.DeleteFromDB;
import domain_DB.LoadToDB;
import domain_DB.RetrieveFromDB;
import domain_DB.UpdateDB;
import domain_pojo.Customer;
import domain_pojo.Employees;
import domain_pojo.Orders;
/*
 *  Author : Sai pramod Upadhyayula
 */
public class Driver {

	public static void main(String[] args) {
		
		Integer option = 0;
		Integer opinion = 0;
		List<Customer> customerlist = new ArrayList<>();
		List<Employees> employeelist = new ArrayList<>();
		Scanner reader = new Scanner(System.in);
		while(true){

			System.out.println("Please select one of the below options");
			System.out.println("1.Load database data into application\n2.Add/Update new order\n3.view/delete any customer\n4.view/delete any employee"
					+ "\n5.view all employees\n6.view all customers\n7.Exit");
			
			option = reader.nextInt();
			switch(option){
			case 1:// To load data from database into the application
				
				List <Object> Objectlist = RetrieveFromDB.retrieveList(new Customer());
				for (Object obj : Objectlist)
					customerlist.add((Customer)obj);
				 
				Objectlist = RetrieveFromDB.retrieveList(new Employees());
				for (Object obj : Objectlist)
					employeelist.add((Employees)obj);
				break;
			case 2://To Add,update and view order information
				System.out.println("Please select one of the below\n1.Add new Order file\n"
						+ "2.Add new Order\n3.Modify Existing Order Details\n4.View orderby Order number");
				
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
				else if (opinion.equals(new Integer("4"))){
					System.out.println("Please Order number");
					Integer ordernumber = reader.nextInt();
					RetrieveFromDB.retrieveRowFromDB(new Orders(), ordernumber);
				}
				else
					System.out.println("Invalid option");
				
				break;
			case 3://To view/delete by customer number
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
			case 4:// To view/delete by Employee number
				
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
			case 6: // to display all customer records
				if (customerlist.size() >0){
					for ( Customer customer : customerlist)
						System.out.println(customer.toString());
				}
				else
					System.out.println("Load data from database and then try viewing");
				break;
			case 5:// To display all employee records
				if (employeelist.size()>0){
					for (Employees employee : employeelist)
						System.out.println(employee.toString());
				}
				else
					System.out.println("Load data from database and then try viewing");
				break;
			case 7:// To close the reader and exit the program
				reader.close();
				System.exit(0);
				
			}
			
		}
	}
	
	
}
