package howard.edu.sycs363.spring15.AddressBook;

public class AddressBookMain {

	public static void main(String[] args) {
		DatabaseCon con = new DatabaseCon();
		con.makeConnection();
		// Create a new instance of AddressBook
		AddressBook SampleBook = new AddressBook();
		
		// create a new address
		Address SampleAddress = new Address("Bozeman","Montana","51252","206 Bradley Blvd");
		
		// create a new Person
	    Person SamplePerson = new Person("turner","jay",SampleAddress,"145278955");
	    
	    // Insert to Database
	    con.insertToDB("test", SamplePerson);
	    
	    // Retrieve from database by name
	    con.retrieveContactByName(SamplePerson);
	    System.out.println("\n");
	    
		
		// Insert the contacts within "infile.txt" to our Database
		SampleBook.write();
		
		
		// Update a Table in the Database
		Address testAddress = new Address("richland","washington","99352","bryan");
		Person testPerson = new Person("john","doe",testAddress,"23458975");
		
		con.insertToDB("sample", testPerson);
		
		System.out.println("Contact in DB before Edit:");
		con.retrieveContactByName(testPerson);
		
		testPerson.editAddress("Billings", "Montana", "67543", "21 Awesome Blvd.");
		con.updateContactDB(testPerson,"Billings", "Montana", "67543", "21 Awesome Blvd.");
		
		System.out.println("Contact in DB after Update Operation is performed:");
		con.retrieveContactByName(testPerson);
		
		
		
		
		// Print Contacts stored within the database to the console
		System.out.print("\n\n\n");
		System.out.println("All the Records within our Database:");
		con.retrieveAllContacts();
	    
	}

}
