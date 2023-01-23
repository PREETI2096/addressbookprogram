package com.bridgelabz.addressbookprogram;
import java.util.Scanner;
public class AddressBook {
	
	public void addContact() {
		 System.out.println("Create new contact :");
		 System.out.println("======================");
		 System.out.println("Enter first name:");
		 Scanner sc = new Scanner(System.in);
		 String firstName = sc.next();
		 System.out.println("Enter last name");
		 String lastName = sc.next();
		 System.out.println("Enter address");
		 String address = sc.next();
		 System.out.println("Enter phone number");
		 long  phoneNumber = sc.nextLong();
		 System.out.println("Enter email ID");
		 String emailID = sc.next();
		 System.out.println("Enter city:");
		 String city = sc.next();
		 System.out.println("Enter state :");
		 String state = sc.next();
		 System.out.println("Enter zip code");
		 long zip = sc.nextLong();
		 
		 Contact contact = new Contact();
		 
		 contact.setFirstName(firstName);
		 contact.setLastName(lastName);
		 contact.setAddress(address);
		 contact.setPhoneNumber(phoneNumber);
		 contact.setEmailID(emailID);
		 contact.setCity(city);
		 contact.setState(state);
		 contact.setZip(zip);
		 displayContact(contact );
		 sc.close();
	}
	public void displayContact(Contact contact) {
		System.out.println(contact);
	}
}

