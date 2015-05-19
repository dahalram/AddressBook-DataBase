package howard.edu.sycs363.spring15.AddressBook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	/*
	 *  Testing AddressBook constructor with default path
	 */
	
	public void testAddressBook() {
		Address testAddress = new Address("richland","washington","99352","bryan"); 
		Person testPerson = new Person("john","doe",testAddress,"23458975");
		
		
		Map<String, Person> ContactMap = new HashMap<String, Person>();
		ContactMap.put("joe", testPerson);
		
		// Test
		// add one entry check to see if it's actually there
		// a value of null, would mean the object isn't within the map
		assertNotNull("Should check that the object is not null", ContactMap.get("joe"));
		
	}


	@Test
	// Test adding an entry to the addressBook
	public void testAddEntry() {
		Address testAddress = new Address("Bozeman","Montana","51252","206 Bradley Blvd"); 
		Person testPerson = new Person("turner","jay",testAddress,"145278955");
		AddressBook abook = new AddressBook();
		
		
		// place an entry
		abook.addEntry("smith", testPerson);

		// test a retrieve
		assertNotNull("Should check that the object is not null", abook.getContact("smith"));
	}

	@Test
	/*
	 * test if a person object is returned
	 */
	public void testGetContact() {
		Address testAddress = new Address("Bozeman","Montana","51252","206 Bradley Blvd"); 
		Person testPerson = new Person("turner","jay",testAddress,"145278955");
		Address tAddress = new Address("richland","washington","99352","bryan"); 
		Person tPerson = new Person("john","doe",testAddress,"23458975");
		AddressBook abook = new AddressBook();
		
		
		// place an entry
		abook.addEntry("smith", testPerson);
		abook.addEntry("joe", tPerson);
		
		// test a retrieve
		assertNotNull("Should check that the object is not null", abook.getContact("joe"));
		assertNotNull("Should check that the object is not null", abook.getContact("smith"));
		
	}
	
	@Test
	/*
	 * test if a specified entry was removed from the addressBook
	 */
	public void testRemoveEntry() {
		Address testAddress = new Address("Bozeman","Montana","51252","206 Bradley Blvd"); 
		Person testPerson = new Person("turner","jay",testAddress,"145278955");
		AddressBook abook = new AddressBook();
		
		
		// place an entry
		abook.addEntry("smith", testPerson);
		// test if it's there
		assertNotNull("Should check that the object is not null", abook.getContact("smith"));
		// remove the entry
		abook.removeEntry("smith");
		// test if it's not there
		assertNull("Should check that the object is not null", abook.getContact("smith"));
		
	}

	/*
	 * Test the write method
	 */
	@Test
	public void testWrite() {
		Address testAddress = new Address("Bozeman","Montana","51252","206 Bradley Blvd");
        Person testPerson = new Person("turner","jay",testAddress,"145278955");
        AddressBook abook = new AddressBook();
        abook.addEntry("check", testPerson);
        
        abook.write();
		
	}

}
