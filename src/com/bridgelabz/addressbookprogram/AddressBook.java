package com.bridgelabz.addressbookprogram;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
	 static Scanner sc = new Scanner(System.in);
	   ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

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
	public void editContact(){
        Scanner sc = new Scanner(System.in);
	    System.out.println("Enter person name : "); 
	     String name = sc.next();   
	    for(Contact contact: contactArrayList ){
	    	
	        if(contact.getFirstName().equals(name) || contact.getLastName().equals(name)){
	        	
	            System.out.println("What you want to edit : \n" +
	                    "1.first name \n" +
	                    "2.last name \n" +
	                    "3.address \n" +
	                    "4.phone number \n" +
	                    "5.emailIDstate \n" +
	                    "6.city \n" +
	                    "7. state \n" +
	                    "8.zip");
	            int ch = (sc.nextInt());
	            switch (ch){
	                case 1:
	                    System.out.println("Enter first name :");
	                    contact.setFirstName(sc.next());
	                    System.out.println("Contact updated!");
	                    break;
	                case 2:
	                    System.out.println("Enter last name :");
	                    contact.setLastName(sc.next());
	                    System.out.println("Contact updated!");
	                    break;
	                case 3:
	                    System.out.println("Enter address :");
	                    contact.setAddress(sc.next());
	                    System.out.println("Contact updated!");
	                    break;
	                case 4:
	                	System.out.println("Enter contact number :");
	                    contact.setPhoneNumber(sc.nextLong());
	                    System.out.println("Contact updated!");
	                    break;
	                case 5:
	                	 System.out.println("Enter email :");
	                     contact.setEmailID(sc.next());
	                     System.out.println("Contact updated!");
	                   
	                    break;
	                case 6:
	                	System.out.println("Enter city :");
	                    contact.setCity(sc.next());
	                    System.out.println("Contact updated!");

	                    break;
	                case 7:
	                	 System.out.println("Enter state :");
	                     contact.setState(sc.next());
	                     System.out.println("Contact updated!");
	                    break;
	                case 8:
	                	System.out.println("Enter zip code :");
	                    contact.setZip(sc.nextLong());
	                    System.out.println("Contact updated!");
	                    break;
	                default:
	                    System.out.println("Invalid input.");
	                    editContact();
	            }
	        }
	        }
	        System.out.println(name + " not found");
		}	
}