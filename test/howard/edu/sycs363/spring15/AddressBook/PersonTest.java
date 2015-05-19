package howard.edu.sycs363.spring15.AddressBook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	/*
	 * Test the person constructor, which intializes a person object
	 */
	public void testPerson() {
		Address testAddress = new Address("harlingen","texas","78552","adrian"); 
		Person testPerson = new Person("john","stacy",testAddress,"934347320");
		
		
		// Tests
		assertEquals("Should return texas", "texas", testPerson.getAddressState());
		assertEquals("Should return john", "john", testPerson.getFirstName());
		assertEquals("Should return stacy", "stacy", testPerson.getLastName());
		assertEquals("Should return 934347320", "934347320", testPerson.getNumber());
		
	}

	@Test
	/*
	 * test the edit address functionality that takes params (int, string)
	 */
	public void testEditAddressIntString() {
		Address testAddress = new Address("harlingen","texas","78552","adrian"); 
		Person testPerson = new Person("john","stacy",testAddress,"934347320");
		
		testPerson.editAddress(3,"23456");
		assertEquals("Should return 23456", "23456", testPerson.getAddressZip());
		testPerson.editAddress(18,"Denver");
		assertEquals("Should return Denver", "Denver", testPerson.getAddressCity());
		
		
		
	}

	@Test
	/*
	 * test the edit address functionality that takes params 
	 * (string, string, string. string)
	 */
	public void testEditAddressStringStringStringString() {
		Address testAddress = new Address("harlingen","texas","78552","adrian"); 
		Person testPerson = new Person("john","stacy",testAddress,"934347320");
		
		testPerson.editAddress("la feria", "new mexico", "78550", "234 main St.");
		assertEquals("Should return la feria", "la feria", testPerson.getAddressCity());
		assertEquals("Should return new mexico", "new mexico", testPerson.getAddressState());
		assertEquals("Should return 78550", "78550", testPerson.getAddressZip());
		assertEquals("Should return 234 main St.", "234 main St.", testPerson.getAddressStreet());
		
	}

	@Test
	/*
	 * test the method that changes the phone number member of the Person class
	 */
	public void testSetNumber() {
		Address testAddress = new Address("harlingen","texas","78552","adrian"); 
		Person testPerson = new Person("john","stacy",testAddress,"934347320");
		
		testPerson.setNumber("8675309");
		assertEquals("Should return 8675309", "8675309", testPerson.getNumber());
		
	}

}
