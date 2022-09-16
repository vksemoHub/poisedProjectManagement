import java.util.ArrayList;
import java.util.Date;

public class Project {
	// Class Attributes
	private int projectNumber;
	private String projectName ;
	private String buildingType;
	private String physicalAddress;
	private int erfNumber;
	private double projectFee;
	private double amountPaid;
	private Date projectDeadline;
	private Person projectArchitect;
	private Person projectContractor;
	private Person projectCustomer;
	private boolean finalised;
	private Date completionDate;

	// Default constructor
	public Project(){
		
	}	
	
	// Constructor
	public Project(String projectName, String buildingType,
			String physicalAddress,int erfNumber, double projectFee,
			double amountPaid, Date projectDeadline, Person projectArchitect,
			Person projectContractor, Person projectCustomer) {
		this.projectNumber = 0;  // Default number for all new projects
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		this.erfNumber = erfNumber;
		this.projectFee = projectFee;
		this.amountPaid = amountPaid;
		this.projectDeadline = projectDeadline;
		this.projectArchitect = projectArchitect;
		this.projectContractor = projectContractor;
		this.projectCustomer = projectCustomer;
		this.setFinalised(false);
		this.projectArchitect = projectArchitect;
		this.projectContractor = projectContractor;
		this.projectCustomer = projectCustomer;
	}
	
	public String toString() {
		return "< Project number: " + projectNumber 
				+ ", Project name: " + projectName + ">";
	}
	
	// Method to add newly created project into projects list.
	public void addToProjects(Project newProject, 
	     ArrayList<Project> projects) {
		projects.add(newProject);
		// Sets the project number to index position of projects list.
		newProject.setProjectNumber(projects.indexOf(newProject));
	}
	// Method to finalise the project.
	public void markAsFinalised(Project finaliseObject) {
		finaliseObject.setFinalised(true);
	}
	// Methods: getters.
	public int getProjectNumber(){
		return this.projectNumber;
	}
	public String getProjectName(){
		return this.projectName;
	}

	public String getuBuildingType(){
		return this.buildingType;
	}

	public String getPhysicalAddress(){
		return this.physicalAddress;
	}

	public int getErfNumber(){
		return this.erfNumber;
	}
        
	public double getProjectFee(){
		return this.projectFee;
	}

	public double getAmountPaid() {
		return this.amountPaid;
	}
	public Date getProjectDeadline(){
		return this.projectDeadline;
	}

	public Person getProjectArchitect(){
		return this.projectArchitect;
	}

	public Person getProjectContractor(){
		return this.projectContractor;
	}

	public Person getProjectCustomer(){
		return this.projectCustomer;
	}		

	// Methods: Setters
	public void setProjectNumber(int projectNumber){
		this.projectNumber = projectNumber;
	}
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}

	public void setuBuildingType(String buildingType){
		this.buildingType = buildingType;
	}

	public void setPhysicalAddress(String physicalAddress){
		this.physicalAddress = physicalAddress;
	}

	public void setErfNumber(int erfNumber ){
		this.erfNumber = erfNumber;
	}

	public void setProjectFee(double projectFee){
		this.projectFee = projectFee;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public void setProjectDeadline(Date projectDeadline){
		this.projectDeadline = projectDeadline;
	}

	public void setProjectArchitect(Person projectArchitect){
		this.projectArchitect = projectArchitect;
	}

	public void setProjectContractor(Person projectContractor){
		this.projectContractor = projectContractor;
	}

	public void setProjectCustomer(Person projectCustomer){
		this.projectCustomer = projectCustomer;
	}
	/**
	 * @return boolean finalised  // State of project completion.
	 */
	public boolean isFinalised() {
		return finalised ;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * Takes in a date & assigns it to completionDate parameter
	 * @param Date completionDate 
	 * @return void
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @param finalised // Sets whether project is finalised or not
	 */
	public void setFinalised(boolean finalised) {
		this.finalised = finalised;
	}


}
