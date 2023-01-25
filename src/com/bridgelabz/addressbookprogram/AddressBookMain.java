package com.bridgelabz.addressbookprogram;
import java.util.Scanner;
public class AddressBookMain {
      
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
           AddressBook addressBook = new AddressBook();
		Contact contact = new Contact();
		    System.out.println("0.Exit \n1.Add Contact \n2.Display Contact \n3.Edit contact\n4.delete contact");
			System.out.println("Enter the Operation Number : ");
			Scanner sc = new Scanner(System.in);
			int operationNumber = sc.nextInt();
			do {
			switch (operationNumber) {

			case 0:
				System.exit(0);
				break;
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.displayContact(contact);
				break;
			case 3:
				addressBook.editContact();
				break;
			case 4:
				addressBook.deleteContact();
				break;
			default:
				System.out.println("Invalid Input");
			}
			}while(operationNumber != 4);
		}
	}