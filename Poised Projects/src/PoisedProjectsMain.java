//-----------------------------------------------------------------------------
//Capstone Project I
//References:
//1. PDF L2T07 (SE L2T07 - Capstone Project I - OOP)
//2. Example programs in L2T04 folder
//3.  What are the six types of relationships in UML class diagrams? 
//    - Visual Paradigm Blog. [online] Available at: <https://bit.ly/3xk0YxJ> 
//   [Accessed 30 August 2022].
//3. Lucid Software, 2022. UML Class Diagram Tutorial. [video] Available at:
//   <https://youtu.be/UI6lqHOVHic> [Accessed 25 August 2022].
//----------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class PoisedProjectsMain {
     //static Scanner input; //= new Scanner(System.in);
	public static void main(String[] args) {
		
		ArrayList<Project> projects = new ArrayList<Project>();
		//ArrayList<Project> finalisedProjects = new ArrayList<Project>();
		Person testContractor = new Person("Smith", "John", "0118015150", 
				"smith@mail.com", "9 Arend, Westgate, 1780");
		Person testArchitect = new Person("Maseko", "Adam", "0133518560", 
				"maseko@mail.com", "9 Amethyst, Kagiso, 1786");
		Person testCustomer = new Person("Nkosi", "Lungelo", "0138518911", 
				"nkosi@mail.com", "9 Hills, Pretoria, 2000");
		UpdateProject testUp = new UpdateProject();
		Date testDate = testUp.stringToDate("15/09/2022");
		Project test = new Project("Capstone", "Stone Building",
				"9 Hyperion Av, Capetown, 8000", 5426, 10000.50, 1000.50,
				testDate, testArchitect, testContractor, testCustomer);
		projects.add(test);
		
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		while (condition) {
			System.out.print("\nWelcome to the Poised Project Database\n" 
		            + "Please Select an option below to proceed:\n"
					+ "c - Capture Project Details & create project\n"
					+ "d - Change project due date\n"
					+ "p - Change fee paid\n" 
					+ "u - Update contractor's details\n" 
					+ "f - Finalise project\n"
					+ "e - exit\n");
			char menuChoice = input.next().charAt(0);
			
			// Capture Details & Create New Project.
			if (menuChoice == 'c' || menuChoice == 'C') { 
				ProjectDetails details = new ProjectDetails();
				details = details.captureDetails();
				Project newProject = new Project();
				newProject = new Project(newProject.getProjectName(),
					newProject.getuBuildingType(),
					newProject.getPhysicalAddress(),newProject.getErfNumber(),
					newProject.getProjectFee(), newProject.getAmountPaid(),
					newProject.getProjectDeadline(), 
					newProject.getProjectArchitect(),
					newProject.getProjectContractor(),
					newProject.getProjectCustomer());
				projects.add(newProject);
				// sets index of newProject in the projects list to be project
				//  number.
				newProject.setProjectNumber(projects.indexOf(newProject));
			}
            
			// Change project due date
			else if (menuChoice == 'd'|| menuChoice == 'D') {
				System.out.print("You have opted to change a project's due"
						+ " date,\n");
				processUserChoice(projects, menuChoice);
					
			}
            
			// Change fee paid
			else if (menuChoice == 'p'|| menuChoice == 'P') {    
				System.out.print("You have opted to change the amount paid to"
						+ " date,\n");
				processUserChoice(projects, menuChoice);
			}
            
			// Update contractor's details
			else if (menuChoice == 'u'|| menuChoice == 'U') {   
				System.out.print("You have opted to change the contractor's "
						+ "details");
				processUserChoice(projects, menuChoice);
			}
			else if (menuChoice == 'f'|| menuChoice == 'F') {   // Finalise project	
				System.out.print("You have opted to finalise a project\n");
				processUserChoice(projects, menuChoice);		    
			}

			else if (menuChoice == 'e'|| menuChoice == 'E') {   // Terminate program
				System.out.print("Goodbye!");
				System.exit(0);
			}
			
		}
		input.close();
	}
	
	/**
	 * @param projects
	 * @param menuChoice
	 */
	public static void processUserChoice(ArrayList<Project> projects,
			char menuChoice) {	
		UpdateProject select = new UpdateProject();
		Project chosenProject = new Project();
		
		if (!(projects.isEmpty())){
		    chosenProject = pickProject(projects, select, chosenProject);
			select.updateUserInterface(menuChoice, chosenProject);
		} else {
			System.out.println("However, you have not created any project, \n"
					+ "Please create a project before choosing this option");
		}
	}
	
	/**
	 * Picks a project from the projects list
	 * @param ArrayList projects
	 * @param UpdateProject projectUpdater
	 * @param Project updateThisProject
	 */
	public static Project pickProject(ArrayList<Project> projects, 
			UpdateProject projectUpdater, Project chosenProject) {
	
			projectUpdater.showAllProjects(projects);
		    //Pick a project from the list of created objects.	
		    chosenProject = projectUpdater.chooseProject(projects);
		    System.out.println("You have chosen to update this project: \n" 
		          + chosenProject);
		    
		    return chosenProject;
	}

	    
}
