package domain_exception;

public class DatabaseAccessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4006704943471013650L;
	
	
	public <T> DatabaseAccessException (T e,String message){
		if ("com.mysql.jdbc.exceptions.jdbc4.CommunicationsException".equals(e.getClass().getName()))
			System.out.println("Ensure Mysql is up and running" + message);
		else if ("java.sql.SQLException".equals(e.getClass().getName()))
			System.out.println(message);
		else if ("com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException".equals(e.getClass().getName()))
			System.out.println(message);
		else if ("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException".equals(e.getClass().getName()))
			System.out.println(message);
		else if ("java.lang.IllegalArgumentException".equals(e.getClass().getName()))
			System.out.println("Incorrect input format,please try again");
		else {
			System.out.println("Un-handled exception caught,program will exit" + message);
			
			System.exit(0);
		}
	}

}
