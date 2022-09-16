//-----------------------------------------------------------------------------
//Capstone Project I
//References:
//1. PDF L2T07 (SE L2T07 - Capstone Project I - OOP)
//2. Example programs in L2T04 folder
//3.  What are the six types of relationships in UML class diagrams? 
//    - Visual Paradigm Blog. [online] Available at: <https://bit.ly/3xk0YxJ> 
//   [Accessed 30 August 2022].
//4. Lucid Software, 2022. UML Class Diagram Tutorial. [video] Available at:
//   <https://youtu.be/UI6lqHOVHic> [Accessed 25 August 2022].
//----------------------------------------------------------------------------

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UpdateProject extends ProjectDetails {
	Project chosenProject;
	Person personToUpdate;
	
	
	public UpdateProject() {
		
	}
	
	public UpdateProject(Project projectToUpdate, Person personToUpdate) {
		super();
		this.chosenProject = projectToUpdate;
		this.personToUpdate = personToUpdate;
	}
	Scanner input = new Scanner(System.in);
	public  void updateUserInterface(char userChoice, Project chosenProject) {
		// Change due date of project
		if (userChoice == 'd'|| userChoice == 'D') {
			SimpleDateFormat displayDate = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("\nYour current due date is " 
		            + displayDate.format(chosenProject.getProjectDeadline())
		            + "\nPlease enter the new due date,\nPlease use this format"
		            + " --> (01/09/2022)=(dd/MM/YYYY)\n");
			String dateString =input.nextLine();
			chosenProject.setProjectDeadline(stringToDate(dateString));
			System.out.print("\nYour new due date is " 
			+ displayDate.format(chosenProject.getProjectDeadline()) + "\n");
		}

		// Change the total amount of the fee paid to date.
		else if (userChoice == 'p'|| userChoice == 'P') {
			System.out.print("\nYour current total amount paid is "
					+ chosenProject.getAmountPaid());
			System.out.println(chosenProject.getProjectContractor());
			System.out.print("\nPlease enter the new amount paid to date" );
			chosenProject.setAmountPaid(super.inputDouble());
			System.out.print("\nYour updated total amount paid is "
					+ chosenProject.getAmountPaid());
		}
 
		// Update contractor's details.
		else if (userChoice == 'u'|| userChoice == 'U') { 
			//System.out.println(chosenProject.getProjectContractor());
			Person contractor = chosenProject.getProjectContractor();
			System.out.print("\nIn the project above, you have specifically "
					+ "chosen to update the \ncustomer's contact details.\n");

			boolean condition = true;
			while(condition) {
				System.out.print("\nPlease Select a contact detail to update "
						+ "below:\n"
						+ "m - Email Address\n"
						+ "n - Phone Number\n"
						+ "p - Physical Address\n"
						+ "e - Back to main menu\n"
						);
				char updateChoice = input.next().charAt(0);

				if (updateChoice == 'm'|| updateChoice == 'M') {

					System.out.println("\nPlease enter a new Email address:");
						String emailAddress = input.next();
						contractor.setEmailAddress(emailAddress);
						System.out.println("\nNew contractor Email address: "
								+ contractor.getEmailAddress());
				
				}else if (updateChoice == 'n'|| updateChoice == 'N') {
					System.out.print("Please enter a new Phone Number"
							+ "Enter 10 digits like this --> 0135625479\n:");					
					int phoneNumber = super.inputInteger();
					//contractor.setPhoneNumber("phoneNumber");
					// Count number of digits in entered phoneNumber.
					int numOfDigits = 0;
					int tempNum = phoneNumber;
					while(tempNum > 0) {
						tempNum = tempNum/10;
						numOfDigits = numOfDigits + 1;
					}		
                    // Update phone number
					if (numOfDigits == 10 || numOfDigits == 9){
						updatePhoneNum(contractor, phoneNumber, numOfDigits);
						// Display updated phone number
						System.out.print("New contractor phone number: \n");
						System.out.println(contractor.getPhoneNumber());
					}else {
						System.out.print("\nEnter 10 digits like this -->"
								+ " 0135625479:"
								+ "\nWe will take you back to the contact "
								+ "details menu...\n");
					}
					
				}else if (updateChoice == 'p'|| updateChoice == 'P') {
					System.out.println("Please enter a new Physical "
							+ "address:\n");
					String physicalAddress;
					physicalAddress = getInputString();
					contractor.setPhysicalAddress(physicalAddress);
					System.out.println("New contractor physical address: "
							+ contractor.getPhysicalAddress() + "\n");
					
				}else if (updateChoice == 'e'|| updateChoice == 'E') {
					condition = false;
				}else {
					System.out.println("That is not a valid option. Try "
							+ "again");
				}
			}
	    // Finalise Project
		}else if (userChoice == 'f'|| userChoice == 'F') {
			System.out.println(chosenProject.isFinalised());
		    if (!chosenProject.isFinalised()) {
			    double amountOwed = chosenProject.getProjectFee() - 
			    		chosenProject.getAmountPaid();   
			    if (amountOwed > 0) {  // Displays customer invoice.
			    	Invoice genereateInvoice = new Invoice(chosenProject);
			    	System.out.println(genereateInvoice);
			    } else {
			    	// Mark Project as finalised
			    	chosenProject.markAsFinalised(chosenProject); //= true;
			    	System.out.print("May you please enter the date of "
			    			+ "project completion:\n"
			    			+ "Please use this format --> (01/09/2022)"
			    			+ "=(dd/MM/YYYY)\n");
			    	String stringDate = input.nextLine();
			    	Date completionDate = super.stringToDate(stringDate);
			    	chosenProject.setCompletionDate(completionDate);
			    }  
		    } else {
			   System.out.println("\nThe project has been finalised already");
		    }
		}
	}


	public void updatePhoneNum(Person contractor, int phoneNumber,
			int numOfDigits) {
		if (numOfDigits == 10) {
			contractor.setPhoneNumber("" + phoneNumber);
		}else {
			contractor.setPhoneNumber("0" + phoneNumber);
		}
	}

	/**
	 * Displays all the projects created so far.
	 * @param projects
	 */
	public void showAllProjects(ArrayList<Project> projects) {
		System.out.println("Here is a list of projects you have "
				+ "created:");
		for (int index=0; index <projects.size(); index++) {
			System.out.println(projects.get(index));
		}
	}

	/**
	 * Chooses a project from the a list by project number
	 * @param ArrayList of projects
	 * @return projects.get(projectNumber) // a project from projects list
	 */
	public Project chooseProject(ArrayList<Project> projects) {
		System.out.print("\nEnter the number of a project from the list\n:");
		int projectNumber = super.inputInteger();
		try {
			chosenProject = projects.get(projectNumber);
		} catch (Exception e) {
			System.out.println("\nThere's no project with that number,\n"
					+ "Try again & choose a valid project number.\n");
			chooseProject(projects);
		}
		return chosenProject;
    }
	
}
