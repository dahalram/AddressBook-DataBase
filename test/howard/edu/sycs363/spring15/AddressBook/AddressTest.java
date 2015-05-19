package howard.edu.sycs363.spring15.AddressBook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	/*
	 * Test the Address constructor that takes 4 strings from the user and
	 * sets those values to the object's attributes
	 */
	public void testAddressStringStringStringString() {
		Address testAddress = new Address("harlingen","texas","78552","1918 adrian"); 
		
		
		
		// Tests
		assertEquals("Should return harlingen", "harlingen", testAddress.getCity());
		assertEquals("Should return texas", "texas", testAddress.getState());
		assertEquals("Should return 78552", "78552", testAddress.getZip());
		assertEquals("Should return 1918 adrian", "1918 adrian", testAddress.getStreet());
	}

	@Test
	/*
	 * Tests the other address constructor that initializes the members to empty strings
	 */
	public void testAddress() {
		Address testAddress = new Address();
		
		// Tests
		assertEquals("Should return a blank string", "", testAddress.getCity());
		assertEquals("Should return a blank string", "", testAddress.getState());
		assertEquals("Should return a blank string", "", testAddress.getZip());
		assertEquals("Should return a blank string", "", testAddress.getStreet());
		
	}

	@Test
	/*
	 * tests the transformer for the city attribute of the address object
	 */
	public void testEditCity() {
		Address testAddress = new Address();
		testAddress.editCity("testVille");
		
		//test
		assertEquals("Should return testVille", "testVille", testAddress.getCity());
		
	}

	@Test
	/*
	 * tests the transformer for the state attribute of the address object
	 */
	public void testEditState() {
		Address testAddress = new Address();
		testAddress.editState("testafornia");
		
		//test
		assertEquals("Should return testafornia", "testafornia", testAddress.getState());
	}

	@Test
	/*
	 * tests the transformer for the zip attribute of the address object
	 */
	public void testEditZip() {
		Address testAddress = new Address();
		testAddress.editZip("23124");
		
		//test
		assertEquals("Should return 23124", "23124", testAddress.getZip());
	}

	@Test
	/*
	 * tests the transformer for the street attribute of the address object
	 */
	public void testEditStreet() {
		Address testAddress = new Address();
		testAddress.editStreet("27691 Bass Blvd");
		
		//test
		assertEquals("Should return 27691 Bass Blvd", "27691 Bass Blvd", testAddress.getStreet());
		
	}


}
