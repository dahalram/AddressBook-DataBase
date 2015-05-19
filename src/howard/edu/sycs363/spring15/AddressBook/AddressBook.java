package howard.edu.sycs363.spring15.AddressBook;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class AddressBook {
	// declaring a contact map
	private Map<String, Person> ContactMap = new HashMap<String, Person>();
	
	Scanner inFile;
	
	/*
	 * AddressBook constructor, this version of the constructor, 
	 * reads in Contacts from an already existing text file
	 * 
	 */
	public AddressBook(){
		
	    // read file from some default location of your choosing
		try {
		inFile = new Scanner(new FileReader("dbinfile.txt"));

	    while(inFile.hasNextLine())
	    {
	       String data = inFile.nextLine();
	       String[] input = data.split(",");
	       Address newAddress = new Address(input[3],input[4],input[5],input[6].trim());
	       Person newPerson = new Person(input[0],input[1], newAddress,input[2]);
	       DatabaseCon.insertToDB(input[7].trim(), newPerson);
	       ContactMap.put(input[7].trim(), newPerson);
	    }
		} catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	/*
	 *  Constructor for user provided file.
	 *  An overloaded version of the previous constructor.
	 *  @param string contactFile, takes in a string which represents a path
	 *  to a file. 
	 */
	public AddressBook(String contactFile) {
		
		try {
		inFile = new Scanner(new FileReader(contactFile));
		
	    while(inFile.hasNextLine())
	    {
	       String data = inFile.nextLine();
	       String[] input = data.split(",");
	       Address newAddress = new Address(input[3],input[4],input[5],input[6].trim());
	       Person newPerson = new Person(input[0],input[1], newAddress,input[2]);
	       ContactMap.put(input[0].trim(), newPerson);
	    }
		} catch(IOException ex){
			System.out.println(ex.getMessage());
		}	
		
}
	
	  
	/*
	 * This method is responsible for adding an entry to the addressBook
	 * @param string key   a unique identifier for the contact
	 * @param Person newContact  the person object, which serves as the value to a key
	 * 
	 */
	
	public void addEntry(String key, Person newContact){
		ContactMap.put(key, newContact);
	}
	
	/*
	 * This method is responsible for retrieving an entry from the addressBook
	 * @param string contactName (key) for finding a specific entry
	 * @return Person Object
	 * 
	 */
	public Person getContact(String contactName){
		return ContactMap.get(contactName);
	}
	
	/*
	 * This method is responsible for modifying an entry from an Addressbook
	 * @param String contactName, String newData, int option
	 * the option field determines whether or not we are modifying address attributes
	 * or the phoneNumber of a contact.
	 * The remaining parameters are necessary for finding the contact and providing
	 * the new values for the attributes. 
	 *
	 */
	public void editEntry(String contactName, String newData, int option){
		Person contact = getContact(contactName);
		if (option < 5){
			contact.editAddress(option, newData);
		}
		else {
			contact.setNumber(newData);
		}
	}
	
	
	/*
	 * This method is responsible for removing an entry from the addressBook
	 * @param string key a unique identifier for the contact
	 */
	public void removeEntry(String contactName){
		ContactMap.remove(contactName);
	}
	
	
	// using a Comparator to sort the classes
	
	/*
	 * This method sorts the Addressbook by last name.
	 */
	// sort the entire entry_list by last name
	public void sortByLastName(){
		  LastNameComparator lc = new LastNameComparator(ContactMap);
		  // The treeMap will put the keys in an order based on the comparator
		  TreeMap<String,Person> tm=new TreeMap<String,Person>(lc);
		  tm.putAll(ContactMap);
		  ContactMap = tm;
	}
		

	/*
	 * Method sorts the entire AddressBook by ZipCode
	 */
	public void sortByZip(){
		ZipComparator zc =new ZipComparator(ContactMap);
		  // The treeMap will put the keys in an order based on the comparator
		  TreeMap<String,Person> tm=new TreeMap<String,Person>(zc);
		  tm.putAll(ContactMap);
		  ContactMap = tm;
	}
	
	
	/*
	 * prints the contents of the AddressBook to a console
	 */
	public void printEntry(String contactName){
		getContact(contactName).print();
		
	}
	
	  /*
	   * Write
	   * creates a file called AddressBook.txt and writes the entries within our AddressBook
	   * to the new file.
	   * 
	   */
	  public void write() {
	       // write contents of in memory AddressBook to a file.
		  try {
			  File file = new File("Outfile.txt");
			  if (!file.exists()){
				  file.createNewFile();
			  }
			  
			  FileWriter fw = new FileWriter(file.getAbsolutePath());
			  BufferedWriter bw = new BufferedWriter(fw);
			  
        for (Map.Entry<String, Person> entry : ContactMap.entrySet()) {
            Person contact = entry.getValue();
            bw.write(entry.getKey() + "," +
                    contact.getFirstName() + "," +
                    contact.getLastName() + "," +
                    contact.getNumber() + "," +
                    contact.getAddressStreet() + "," +
                    contact.getAddressCity() + "," +
                    contact.getAddressState() + "," +
                    contact.getAddressZip() +
                    "\n");
        }
			  // close the writer, after writing all the entries within the address book
			  bw.close();
			  
		  } catch (IOException e){
			  e.printStackTrace();
		  }
		  
	  }

	/*
	 *  end of ContactMap Class
	 */
}

	/*
	 *  This method Utilizes Comparator to sort the unsorted Map by LastName
	 */
	
	class LastNameComparator implements Comparator{
		 private Map<String, Person> ContactMap;
		 
		 public LastNameComparator(Map<String, Person> ContactMap) {
		  this.ContactMap = ContactMap;
		 }
		 
		
		 public int compare(Object o1, Object o2) {
		  if(ContactMap.get(o1).getLastName().compareTo(ContactMap.get(o2).getLastName())>0){
		   return 1;  
		  }else {
		  return -1;
		  }
		 }
	}
		 

	/*
	 * This method Utilizes Comparator to sort the unsorted Map by ZipCode
	 */
			
	class ZipComparator implements Comparator{
		 private Map<String, Person> ContactMap;
		 
		 public ZipComparator(Map<String, Person> ContactMap) {
		  this.ContactMap = ContactMap;
		 }
		 
		 
		 public int compare(Object o1, Object o2) {
		  if(Integer.parseInt(ContactMap.get(o1).getAddressZip()) > Integer.parseInt(ContactMap.get(o2).getAddressZip())){
		   return 1;  
		  }else {
		  return -1;
		  }
		 }
	}

