package domain_exception;

public class FileParsingException extends Exception {

	private static final long serialVersionUID = 7892576051768893243L;

	public <T> FileParsingException(T e, String message) {
		// TODO Auto-generated constructor stub
		if ("java.io.FileNotFoundException".equals(e.getClass().getName())) {
			System.out.println("The Input file name is incorrect," + message);
			//exit_program();
		} else if ("java.lang.NumberFormatException".equals(e.getClass().getName())) {
			System.out.println("Please check the data file," + message);
			//exit_program();
		} else if ("java.lang.NullPointerException".equals(e.getClass().getName())) {
			System.out	.println("Please check the values to be inserted, one or all of them are null,"	+ message);
			//exit_program();
		} else if ("java.lang.ArrayIndexOutOfBoundsException".equals(e.getClass().getName())) {
			System.out.println("Incorrect index, exceeds array length,"+ message);
			//exit_program();
		} else if ("java.lang.ClassNotFoundException".equals(e.getClass().getName())){
			System.out.println("Invalid Class"+ message);
			//exit_program();
		}
		else if ("java.text.ParseException".equals(e.getClass().getName())){
			System.out.println("Check input string date parsing failed"+ message);
			//exit_program();
		}
		else if ("java.io.StreamCorruptedException".equals(e.getClass().getName())){
			System.out.println("Cannot deserialize this file" + message);
		}
		else
			new DatabaseAccessException(e,message);

	}

}
