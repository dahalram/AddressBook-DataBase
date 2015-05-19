package howard.edu.sycs363.spring15.AddressBook;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseCon {
	
	/*
	 * All string necessary to form the url to make the connection to the Database are 
	 * declared and defined below.
	 */
	
	static Connection connection = null;
	
	String driverName = "org.postgresql.Driver";
	String serverAddress = "127.0.0.1";
	String portNumber = "5432";
	String dbName = "contactdb";
	String username = "ramhari";
	String password = "Siliconiosis.23";
	
	String url = "jdbc:postgresql://" + serverAddress + ":" + portNumber + "/" + dbName;

	
	public DatabaseCon(){
		
	}
	
	/*
	 * Make Connection is responsible for establishing the connection to the PostgreSQL Database
	 * @params none
	 * @return none (void)
	 */
	public void makeConnection(){
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName(driverName);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		try {
 
			connection = DriverManager.getConnection(url,username,password);
			
			
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			

			
		} else {
			System.out.println("Failed to make connection!");
		}
		
	}
	
	
	/*
	 * InsertToDB is responsible for adding rows to our address_book table
	 * @param string key, the unique identifier for a contact
	 * @param Person object, the person object will be used to extract the 
	 * fields within each contact, so that we can place them in their respective columns
	 * @return none (void)
	 */
	public static void insertToDB(String key, Person contact){
		try {
		// Create a Statement
		Statement stmt = connection.createStatement();
				
		// Execute a SQL Query
		String sql = "INSERT INTO address_book "
				+ " (city, state, zip, street, first_name, last_name, phone_num, uid)"
				+ " VALUES " + "(" + "'" + contact.getAddressCity() + "'" + "," + "'" + contact.getAddressState() + "'" + "," + "'" + contact.getAddressZip() + "'" + ',' + "'" + contact.getAddressStreet() + "'" + ',' + "'" + contact.getFirstName() + "'" + ',' + "'" + contact.getLastName() + "'" + ',' + "'" + contact.getNumber() + "'" + ',' + "'" + key + "'" + ")";
		
		stmt.executeUpdate(sql);
		
		System.out.println("Insert complete");
		
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * UpdateContactDB is responsible for modifying a record within our address_book table
	 * @params Person object, this is used to locate the contact we want to modify
	 * @params string newCity, the new value of the city field
	 * @params string newState, the new value of the state field
	 * @params string newZip, the new value of the zip field
	 * @params string newStreet, the new value of the street field
	 * @return none (void)
	 */
	public static void updateContactDB(Person contact, String newCity, String newState, String newZip, String newStreet)
	{
		try {
			Statement stmt = connection.createStatement();
			String sql = "UPDATE address_book "
					+ " SET city ='"+newCity+"'"
					+ ", state ='"+newState+"'"
					+ ", zip ='"+newZip+"'"
					+ ", street ='"+newStreet+"'"
					+" WHERE first_name='"+contact.getFirstName() +"'";
			
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
			
			System.out.println("Update Complete");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/*
	 * RetrieveContactByName is responsible for Querying our Table and returning the record requested
	 * @params Person Object, the person object's firstName property is used to locate the requested record
	 * @returns none (void)
	 */
	public void retrieveContactByName(Person contact){
		// retrieve/print by firstName
		try {
			// Create a Statement
			Statement stmt = connection.createStatement();
			
			// Execute a SQL Query
			String sql = "SELECT * FROM address_book WHERE first_name='"+contact.getFirstName()+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			// Process the Result Set
			while (rs.next()) {
				System.out.println("city: " + rs.getString(1) + "," + 
						"state: " + rs.getString(2) + "," + 
						"zip: " + rs.getString(3) + "," +
						"street: "+ rs.getString(4) + "," +
						"first name: " + rs.getString(5) + "," +
						"last name: "+ rs.getString(6) + "," +
						"phone number: " + rs.getString(7) + "," +
						"primary key: " + rs.getString(8));
			}
			stmt.close();
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	/*
	 * RetrieveAllContacts is responsible for printing all the records within our table
	 * @params none
	 * @returns none (void)
	 */
	
	public void retrieveAllContacts(){
		// retrieve/print all contacts
		try {
			// Create a Statement
			Statement stmt = connection.createStatement();
			
			// Execute a SQL Query
			ResultSet rs = stmt.executeQuery("SELECT * FROM address_book");
			
			// Process the Result Set
			while (rs.next()) {
				System.out.println("city: " + rs.getString(1) + "," + 
						"state: " + rs.getString(2) + "," + 
						"zip: " + rs.getString(3) + "," +
						"street: "+ rs.getString(4) + "," +
						"first name: " + rs.getString(5) + "," +
						"last name: "+ rs.getString(6) + "," +
						"phone number: " + rs.getString(7) + "," +
						"primary key: " + rs.getString(8));
			}
			stmt.close();
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		
	}

	public static void main(String[] args) {
		DatabaseCon con = new DatabaseCon();
		con.makeConnection();
//		con.insertToDB(null,null);
		
	}

}
