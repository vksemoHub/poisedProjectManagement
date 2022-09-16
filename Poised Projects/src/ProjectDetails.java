import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProjectDetails{
	private int projectNumber = 0;
	private String projectName = "";
	private String buildingType = "";
	private String physicalAddress = "";
	private int erfNumber = 0;
	private double projectFee = 0;
	private double amountPaid = 0.0;
	private Date projectDeadline;
	private Person projectArchitect;
	private Person projectContractor;
	private Person projectCustomer;
	
	public ProjectDetails(int projectNumber, String projectName, 
			String buildingType, String physicalAddress, int erfNumber,
			double projectFee, double amountPaid, String projectDeadline,
			Person projectArchitect, Person projectContractor, 
			Person projectCustomer) {
		//super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		this.erfNumber = erfNumber;
		this.projectFee = projectFee;
		this.amountPaid = amountPaid;
		this.projectDeadline = stringToDate(projectDeadline);
		this.projectArchitect = projectArchitect;
		this.projectContractor = projectContractor;
		this.projectCustomer = projectCustomer;
	}

	public ProjectDetails() {
		// Auto-generated constructor stub
	}
	
	public String toString() {
		return projectName + ", " + projectArchitect.getName() + ", "
			   ;	
	}
	
	Scanner input = new Scanner(System.in);
	/**
	 * 
	 */
   public ProjectDetails captureDetails() {
	    ProjectDetails newDetails = new ProjectDetails();
		System.out.print("You have chosen to create a new project, \n"
				+ "please follow the prompts & supply project information as "
				+ "required.\n\n");

	    System.out.print("Please enter a name for the project:\n"); String
		ProjectName = input.nextLine(); 
	    newDetails.setProjectName(ProjectName);
		  
		System.out.print("Enter the type of building being designed:\n"); 
		String buildingType = input.nextLine(); 
		newDetails.setBuildingType(buildingType);
		  
		System.out.println("Please enter the physical address for the project\n" +
		"e.g 9 Albaster, Cape Town, 8000");
		newDetails.setPhysicalAddress(input.nextLine());
		  
		System.out.print("Please enter the ERF number for the building:\n");
		erfNumber = inputInteger(); System.out.println(erfNumber + 1);
		newDetails.setErfNumber(erfNumber);
		  
		System.out.print("Please enter the total fee for the project" +
		" E.g 2500,50:\n"); newDetails.setProjectFee(inputDouble());
		  
		System.out.print("Please enter the total amount paid to date:\n" +
		" E.g 2500,50:\n"); newDetails.setAmountPaid(inputDouble());
		  
		System.out.print("Please enter the deadline date for the project\n" +
		"Use this format--> (01/09/2022)=(dd/MM/YYYY):\n"); 
		String stringDate =input.next(); 
		newDetails.setProjectDeadline(stringToDate(stringDate));
		  
		System.out.print("In this Section you will enter the architect's "
				+ "details:\n");
		Person architect = new Person();
		architect.createPerson("architect");
		System.out.print("In this Section you will enter the contractor's "
				+ "details:\n");
		Person contractor = new Person();
        contractor.createPerson("contractor");
		System.out.print("In this Section you will enter the customer's "
				+ "details:\n");
		Person customer = new Person();
		customer.createPerson("customer");
		newDetails.setProjectArchitect(architect);
		newDetails.setProjectContractor(contractor);
		newDetails.setProjectCustomer(customer);
	    newDetails = new ProjectDetails();
		return newDetails;
	}

	/**
	 * takes in a user string & tries to converts it to a double
     * returns double to program if conversion is successful.
	 * @param none
	 * @return double convertedToDouble
	 */
	public double inputDouble() {
		double convertedToDouble = 0.0;
		boolean condition = true;
		do {
			try {
				//String userInput = input.next();
				double temp = Double.parseDouble(input.nextLine());
				convertedToDouble = temp;
				condition = false;
			} catch (NumberFormatException e) {
				//Auto-generated catch block
				System.out.println("You need to enter a double, please"
						+ " try again...");
			}
			
		} while (condition);
		
		return convertedToDouble;
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

	/**
	 * Takes in a string date & returns it in Date format
	 * @param String rawDate
	 * @return Date projectDeadline
	 */
	public Date stringToDate(String rawDate) {
		boolean condition = true;
		Date projectDeadline = null;
		while (condition) {
			//this.projectDeadline = projectDeadline;		
			try {
				projectDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(rawDate);
				condition = false;
			} catch (ParseException e) {
				// Auto-generated catch block
				e.printStackTrace();
				System.out.println("You have entered your date incorrectly, "
						+ "Please try again."
						+ "\nMake sure you are using this format --> "
						+ "(01/09/2022)=(dd/MM/YYYY)");
				rawDate = input.nextLine();
			} 
		}
		return projectDeadline;
	}	

	/**
	 * @return
	 */
	public String getInputString() {
		String physicalAddress;
		physicalAddress = input.nextLine();
		return physicalAddress;
	}
	
	// Methods: Getters

	public int getProjectNumber() {
		return projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public int getErfNumber() {
		return erfNumber;
	}
	public double getProjectFee() {
		return projectFee;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public Date getProjectDeadline() {
		return projectDeadline;
	}
	public Person getProjectArchitect() {
		return projectArchitect;
	}
	public Person getProjectContractor() {
		return projectContractor;
	}
	public Person getProjectCustomer() {
		return projectCustomer;
	}

	// Setters
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @param buildingType the buildingType to set
	 */
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	/**
	 * @param physicalAddress the physicalAddress to set
	 */
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	/**
	 * @param erfNumber the erfNumber to set
	 */
	public void setErfNumber(int erfNumber) {
		this.erfNumber = erfNumber;
	}

	/**
	 * @param projectFee the projectFee to set
	 */
	public void setProjectFee(double projectFee) {
		this.projectFee = projectFee;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @param projectDeadline the projectDeadline to set
	 */
	public void setProjectDeadline(Date projectDeadline) {
		
		this.projectDeadline = projectDeadline;
	}

	/**
	 * @param projectArchitect the projectArchitect to set
	 */
	public void setProjectArchitect(Person projectArchitect) {
		this.projectArchitect = projectArchitect;
	}

	/**
	 * @param projectContractor the projectContractor to set
	 */
	public void setProjectContractor(Person projectContractor) {
		this.projectContractor = projectContractor;
	}

	/**
	 * @param projectCustomer the projectCustomer to set
	 */
	public void setProjectCustomer(Person projectCustomer) {
		this.projectCustomer = projectCustomer;
	}

}
