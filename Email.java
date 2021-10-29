package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private String email;
	private int defaultPasswordLength = 10;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";
	
	//constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//System.out.println("EMAIL CREATED: "+ this.firstName + " " + this.lastName);
		
		// call a method for asking department, return the department
		this.department = setDepartment();
	//	System.out.println("Department: " + this.department);
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password: " + this.password);
		
		//combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	//	System.out.println("Your email: " + email);
	}
	
	//ask for department
	private String setDepartment() {
		System.out.println("New worker:" + firstName + " " + lastName + "\nDEPARTMENT CODES\n1 For Sales\n2 For Development\n3 For Accounting\n0 For none\nEnter your department code please: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		}else if (depChoice == 2) {
			return "development";
		}else if(depChoice == 3) {
			return "accounting";
		}else {
			return "";
		}
	}
	
	//generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.*?-_!/#$&@%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change the password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	//get methods
	public int getMailboxCapacity(){
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	
	//show info
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
