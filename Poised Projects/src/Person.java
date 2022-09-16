import java.util.Scanner;

public class Person {
    // Class Attributes
	private String name;
	private String surname;
	private String phoneNumber; 
	private String emailAddress;
	private String physicalAddress;
	
	public Person() {
		
	}
	
	public Person(String surname, String name, String phoneNumber, String emailAddress, String physicalAddress) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}
    
	public String toString() {
		return "Name: " + this.name +" Surname: " + this.surname;
	}
	
	Scanner input = new Scanner(System.in);
	public Person createPerson(String person) {
		
		Person newPerson = new Person();		
		System.out.println("Now Enter the Surname of the project " + person);	
		String surname = input.nextLine();
		
		System.out.println("Please enter the name of the project " + person);
		String name = input.nextLine();
		
		System.out.println("Enter the telephone number of the project " + person);
		String phoneNumber ="0"+ inputInteger();
		
		System.out.println("Enter the " +person+ "'s the e-mail address\n");
		String emailAddress = input.nextLine();
		
		System.out.println("Please enter the address for the project "
	           + person + "\ne.g 9 Albaster, Cape Town, 8000");
		String physicalAddress = input.nextLine();
		
		newPerson.setSurname(surname);
		newPerson.setName(name);
		newPerson.setPhoneNumber(phoneNumber);
		newPerson.setPhysicalAddress(physicalAddress);
		newPerson.setEmailAddress(emailAddress);
		
		return newPerson;
	}

	/**
	 * takes in a user string & tries to converts it to an integer
     * returns integer to program if conversion is successful.
	 * @param none
	 * @return int convertedToInt
	 */
	public int inputInteger() {
		int convertedToInt = 0;
		boolean condition = true;
		do {
			try {
				String userInput = input.nextLine();
				convertedToInt = Integer.parseInt(userInput);
				condition = false;
			} catch (NumberFormatException e) {
				//Auto-generated catch block
				e.printStackTrace();
				System.out.println("You need to enter an integer value, please"
						+ " try again...");
			}
			
		} while (condition);
		
		return convertedToInt;
	}

	
	// Class Methods: Getters.
	public String getName(){
		return this.name;
	}

	public String getSurname(){
		return this.surname;
	}	
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public String getEmailAddress(){
		return this.emailAddress;
	}
	
	public String getPhysicalAddress(){
		return this.physicalAddress;
	}

	// Class Methods: Setters.
	public void setName(String name){
		this.name = name;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}	
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String emailAddress ){
		this.emailAddress = emailAddress;
	}
	
	public void setPhysicalAddress(String physicalAddress){
		this.physicalAddress = physicalAddress;
	}
}
