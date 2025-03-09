package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 8;
	private String companySuffix = "company.com"; 
	
	//constructor to receive first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED: "+ this.firstName + " " + this.lastName);

		//call a method asking for department - return the department
		this.department = setDepartment();
//		System.out.println("Department: "+this.department);
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: "+ this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "."+ lastName.toLowerCase() + "@" + department + "." + companySuffix;
//		System.out.println("Your email is: "+ email);
	}
	
	// Ask for department 
	private String setDepartment() {
		System.out.println( "New Worker: " + firstName + ". DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "sales";
		}else if (depChoice ==2 ) {
			return "dev";
		}else if(depChoice == 3) {
			return "acct";
		}else {
			return "";
		}
	}
	
	
	// Generate a random password 
	private String randomPassword(int length) {
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
		
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email 
	public void setAlernateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password 
	public void changePassword(String password) {
		this.password = password;
	}
	
	//Get mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	//Get alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	//Get password
	public String getPassword() {
		return password;
	}
	
	// Display Name, Email, Mailbox capacity
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
				
	}
	
	
}
