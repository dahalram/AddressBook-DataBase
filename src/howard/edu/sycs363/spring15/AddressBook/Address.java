package howard.edu.sycs363.spring15.AddressBook;

public class Address {
	private String city, state, zip, street;
	
	
	/*
	 * Constructor for the Address Class
	 * @param newCity, the new value for the city data member
	 * @param newState, the new city value for the state data member
	 * @param newZip, the new Zip value for the zip data member
	 * @param newStreet, the new Street value for the street data member
	 */
	
	public Address(String newCity, String newState, String  newZip, String newStreet)
	{
		city = newCity;
		state = newState;
		zip = newZip;
		street = newStreet;
	}
	
	
	/*
	 * Constructor for the ADdress Class
	 * initializes all data members to an empty string
	 */
	
	public Address()
	{
		city = "";
		state = "";
		zip = "";
		street = "";
	}
	
	/*
	 * The transformer for the city attribute of the Address object
	 * @param string new_city, takes a new_city (string) value for the Address object data member
	 */
	public void editCity(String new_city)
	{
		city = new_city;
	}
	
	/*
	 * The transformer for the state attribute of the Address object
	 * @param string new_state, takes a new_zip (string) value for the Address object data member
	 */
	public void editState(String new_state)
	{
		state = new_state;
	}
	
	/*
	 * The transformer for the zip attribute of the Address object
	 * @param string new_zip, takes a new_zip (string) value for the Address object data member
	 */
	public void editZip(String new_zip)
	{
		zip = new_zip;
	}
	
	/*
	 * The transformer for the street attribute of the Address object
	 * @param string new_street, takes a new number value for the Address object data member
	 */
	public void editStreet(String new_street)
	{
		street = new_street;
	}
	
	/*
	 * The following methods are responsible for retrieving the values 
	 * of Address Object data members
	 * @return data members from this class of type String
	 */
	
	public String getCity(){
		return city;
	}
	
	public String getState(){
		return state;
	}
	
	public String getZip(){
		return zip;
	}
	
	public String getStreet(){
		return street;
	}
	
	/*
	 *  Method use to print the Address Object
	 *  
	 */
	public void print(){
		System.out.print("Address: ");
		System.out.print(this.street);
		System.out.print(this.city);
		System.out.print(this.state);
		System.out.print(this.zip);
	}

}
