package howard.edu.sycs363.spring15.AddressBook;

public class Person {
	/*
	 * Declaring Attributes belonging to a Person Type
	 */
	private final String first_name, last_name;
	public String phone_num;
	public Address address;
	
	/*
	 * constructor, initializes and accepts attribute values for a person object once invoked
	 * @param new_fname 	is the new value first name attribute
	 * @param new_lname 	is the new last name attribute
	 * @param new_address 	is the new address attribute
	 * @param new_phone_num 	is the new phoneNumber attribute
	 */
	public Person (String new_fname, String new_lname, Address new_address, String new_phone_num)
	{
		first_name = new_fname;
		last_name = new_lname;
		address = new_address;
		phone_num = new_phone_num;
	}

	
	/*
	 *Method is responsible for editing existing information about a Person's address
	 * @param integer option  option indicates which aspect of the address the
	 *  user desires to modify. 
	 * @param string newValue  newValue represents the newData that will be within the data member
	 */
	public void editAddress(int option, String newValue)
	{
	switch(option) {	
		case 1: address.editCity(newValue);
		case 2: address.editState(newValue);
		case 3: address.editZip(newValue);
		case 4: address.editStreet(newValue);
		default:
			address.editCity(newValue);
		}
	}
	
	/* An overloaded method for editing a Person's address.  
	 *  This version of the method is called when a user wants
	 *   to modify all aspects of an address
	 *   
	 *   @param newCity  is the new value of the city attribute
	 *   @param newState is the new value of the state attribute
	 *   @param newZip  is the new value of the zip attribute
	 *   @param newStreet is the new value of the street attribute
	 */

	public void editAddress(String newCity, String newState, String newZip, String newStreet)
	{
		address.editCity(newCity);
		address.editState(newState);
		address.editZip(newZip);
		address.editStreet(newStreet);	
	}
	
	/*
	 * The transformer for the phoneNumber attribute of the Person object
	 * @param string newNum, takes a new number value for the Person object data member
	 */
	
	public void setNumber(String newNum)
	{
		phone_num = newNum;
	}
	
	
	/*
	 * The following methods are responsible for retrieving the values 
	 * of Person Object data members
	 * @return data members from this class
	 */

	public String getLastName(){
		return this.last_name;
	}

	public String getFirstName(){
		return this.first_name;
	}
	
	public String getAddressCity()
	{
		return address.getCity();
	}
	public String getAddressState()
	{
		return address.getState();
	}
	public String getAddressZip()
	{
		return address.getZip();
	}
	public String getAddressStreet()
	{
		return address.getStreet();
	}
	
	public String getNumber()
	{
		return phone_num;
	}
	
	
	/*
	 *  Method use to print the Person Object
	 *  
	 */
	public void print()
	{
		System.out.print("First Name " + this.first_name);
		System.out.print("Last Name " + this.last_name);
		System.out.print("Phone Number " + this.phone_num);
		this.address.print();
		System.out.print("\n");
	}
	
	
	
	
}
