
public class Invoice {
	private Person projectCustomer;
	private double amountOwed;
	
	public Invoice( Project project){
		this.projectCustomer = project.getProjectCustomer();
		this.amountOwed = project.getProjectFee() - project.getAmountPaid();
	}
    // Generates customer invoice.
	public String toString() {
		String invoice;
		invoice = "\nINVOICE issued to:\t" + projectCustomer.getName();
		invoice += " " + projectCustomer.getSurname() + "\n";
		invoice += "\nContact Details:\nPhone Number:\t\t";
		invoice += projectCustomer.getPhoneNumber();
		invoice += "\nEmail Address:\t\t" + projectCustomer.getEmailAddress();
		invoice += "\nPhysical Address:\t";
		invoice += projectCustomer.getPhysicalAddress();
		invoice += "\nTotal Amount Owed\tR " + this.amountOwed;
		return invoice;
	}

	/**
	 * Returns the total amount owed by a customer
	 * @return the amountOwed
	 */
	public double getAmountOwed() {
		return amountOwed;
	}

	/**
	 * Sets the total amount owed by a customer.
	 * @param amountOwed the amountOwed to set
	 */
	public void setAmountOwed(double amountOwed) {
		this.amountOwed = amountOwed;
	}
	
}
