package com.bridgelabz.addressbookprogram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	Contact contact = new Contact();
	// Creating array List
	static ArrayList<Contact> contactDetails = new ArrayList();
	// Taking Scanner Class Object
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, ArrayList<Contact>> hashmap = new HashMap<>();

	// method For Adding Multiple Address Book
	public static void multipleAddressBook(AddressBook addressBook) {
		int select = 0;
        do {
            System.out.println("1) Add Address Book \n2)Search \n3)Display Address book \n4) countPersonFromSame_City_State \n5) Sorted Contacts");
            System.out.println("choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    int ans;
                    do {
                        System.out.println("Enter Name For Address Book");
                        String AddressBookName = sc.next();
                        if (hashmap.containsKey(AddressBookName)) {
                            System.out.println("The AddressBook already contains");
                            break;
                        } else {
                            ArrayList<Contact> contactDetails1 = new ArrayList<>();
                            addressBook.menuChoose(addressBook, contactDetails1);
                            hashmap.put(AddressBookName, contactDetails1);
                        }
                        System.out.println("AddressBook Added" + hashmap + " ");
                        System.out.println("do you want to create another address book if press 1.");
                        ans = sc.nextInt();
                    } while (ans == 1);
                    break;
                case 2:
                    System.out.println("Enter name to search ");
                    String name = sc.next();
                    SearchInMultipleBook(name);
                    break;
                case 3:
                    addressBook.displayAddressBook();
                    break;
                case 4:
                    System.out.println("Enter city name or state name to Count Persons belonging from same city or state");
                    String countname = sc.next();
                    countFromSame_City_State(countname);
                    break;
                case 5:
                    System.out.println("Sorted Contacts are alphabetically :- ");
                    sortContact(hashmap);
                default:
            }System.out.println("if you do not want to create multiple address book press 1.");
            select = sc.nextInt();
        }while (select == 1);
    }

    private static List<Contact> SearchInMultipleBook(String name) {
        for (Map.Entry<String, ArrayList<Contact>> entry : hashmap.entrySet()) {
            for (Contact contacts1 : entry.getValue()) {
                if (contacts1.getCity().equals(name) || contacts1.getState().equals(name)) {
                    System.out.println("\nAddress Book Name :" + entry.getKey());
                    System.out.println("First Name :" + contacts1.getFirstName());
                    System.out.println("Last Name :" + contacts1.getLastName());
                    System.out.println("Mail-ID :" + contacts1.getEmailID());
                    System.out.println("Address :" + contacts1.getAddress());
                    System.out.println("City Name :" + contacts1.getCity());
                    System.out.println("Contact Number :" + contacts1.getPhoneNumber());
                }
            }
        }
        System.out.printf("No record found:");
        return null;
    }
    public void SearchInSingleBook(ArrayList<Contact> contactdetails){
        System.out.println("Enter name of city or state to search");
        String name=sc.next();
        ArrayList<Contact> contacts=new ArrayList<>();
        for (Contact contact:contactdetails){
            if(contact.getCity().equals(name)||contact.getState().equals(name))
            {
                contacts.add(contact);
            }
            System.out.println(contact);
        }
    }
    //Counting how many persons belonging from same city or state

    public static List<Contact> countFromSame_City_State(String name){
        int count=0;
        for (Map.Entry<String, ArrayList<Contact>> entry : hashmap.entrySet()){
            for (Contact v:entry.getValue()){
                if (v.getCity().equals(name)|| v.getState().equals(name)){
                    count++;
                }
            }
        }
        System.out.printf(count+"\t\nPersons belonging From =>"+name+ " \n");
        return null;
    }
    public static void sortContact(HashMap<String, ArrayList<Contact>> multipleAddressBook) {
        for(Map.Entry<String,ArrayList<Contact>> personSorted : multipleAddressBook.entrySet()){
            List<Contact> sortedContacts;
            sortedContacts = personSorted.getValue().stream().sorted(Comparator.comparing(contacts -> contacts.getFirstName() + contacts.getLastName())).collect(Collectors.toList());
            System.out.println("Sorted Contacts By Name : ");
            for (Contact item : sortedContacts){
                System.out.println(item.toString());
            }
        }
    }
		
	/*
	 * Create addDetails method create info contact Class object
	 */
	public static ArrayList<Contact> addDetails(ArrayList<Contact> contactsDetails) {
		Contact info = new Contact();
		if (contactsDetails.size() == 0) {
			System.out.println("Enter the First Name");
			info.setFirstName(sc.next());
			System.out.println("Enter the Last Name");
			info.setLastName(sc.next());
			System.out.println("Enter the Address");
			info.setAddress(sc.next());
			System.out.println("Enter the city");
			info.setCity(sc.next());
			System.out.println("Enter the State");
			info.setState(sc.next());
			System.out.println("Enter the your zip Code");
			info.setZip(sc.next());
			System.out.println("Enter the Contact Number");
			info.setPhoneNumber(sc.next());
			System.out.println("Enter the Email Id");
			info.setEmailID(sc.next());
			contactsDetails.add(info);
			System.out.println("Contact details added");
		} else {
			System.out.println("Enter first name");
			String firstName = sc.next();
			/*
			 * For searching the duplicate names in arraylist
			 */
			for (Contact contacts : contactsDetails) {
				// checking the duplicate name.
				if (contacts.getFirstName().equals(firstName)) {
					System.out.println("The Name is already present.");
					AddressBook.addDetails(contactsDetails);
				}
			}
			System.out.println("Re-enter first name");
			info.setFirstName(sc.next());
			System.out.println("Enter Last Name");
			info.setLastName(sc.next());
			System.out.println("Enter contact Number:");
			info.setPhoneNumber(sc.next());
			System.out.println("Enter Email: ");
			info.setEmailID(sc.next());
			System.out.println("Enter Address: ");
			info.setAddress(sc.next());
			System.out.println("Enter City Name: ");
			info.setCity(sc.next());
			System.out.println("Enter State: ");
			info.setState(sc.next());
			System.out.println("Enter Zip Code:");
			info.setZip(sc.next());
			contactsDetails.add(info);
		}
		return contactsDetails;
	}

	public void displayContacts(ArrayList<Contact> contactDetails) {
		for (Contact contactDetailsValue : contactDetails) {
			System.out.println(contactDetailsValue);
			System.out.println("---------------------------");
		}
	}
	  public static void displayAddressBook() {
	        for (Map.Entry<String, ArrayList<Contact>> entry : hashmap.entrySet())
	            for (Contact v : entry.getValue()) {
	                System.out.println("\n Address Book=>" + entry.getKey());
	                System.out.println("FirstName \t LastName \t Email \t Contact Number \t Address \t City \t State \t Zip Code ");
	                System.out.println(v.getFirstName() + "\t" + v.getLastName() + "\t" + v.getEmailID() + "\t" + v.getPhoneNumber() + "\t" + v.getAddress() +
	                        "\t" + v.getCity() + "\t" + v.getState() + "\t" + v.getZip());
	            }
	    }
	/*
	 * Another method is to create editDetails Edit details you want to editing in
	 * the respective information by using switch case
	 */
	public void editDetails(ArrayList<Contact> contactDetails) {
		System.out.println("Enter the first name you want to edit ");
		String searchFirstName = sc.next();
		// taking for each loop
		for (Contact contact : AddressBook.contactDetails) {
			// taking name variable and store the first name that you want to edit
			String name = contact.getFirstName();
			// checking if condition your input first name is equal to search first name or
			// not by equals function
			System.out.println(name);
			if (name.equals(searchFirstName)) {
				System.out.println("1. First Name \n2. Last Name \n3. Address \n4. City "
						+ "\n5. State \n6. Zip Code \n7. Contact No \n8. Email");
				System.out.println("Enter value to update: ");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					System.out.println("Enter the first name You want to update");
					String updatedFirstName = sc.next();
					contact.setFirstName(updatedFirstName);
					// displayContacts();
					break;
				case 2:
					System.out.println("Enter the Last Name You want to update");
					String updatedLastName = sc.next();
					contact.setLastName(updatedLastName);
					// displayContacts();
					break;
				case 3:
					System.out.println("Enter the Address You want to update");
					String updatedAddress = sc.next();
					contact.setAddress(updatedAddress);
					// displayContacts();
					break;
				case 4:
					System.out.println("Enter the City You want to update");
					String updatedCity = sc.next();
					contact.setCity(updatedCity);
					// displayContacts();
					break;
				case 5:
					System.out.println("Enter the State You want to update");
					String updatedState = sc.next();
					contact.setState(updatedState);
					// displayContacts();
					break;
				case 6:
					System.out.println("Enter the Zip code You want to update");
					String updatedZipCode = sc.next();
					contact.setZip(updatedZipCode);
					// displayContacts();
					break;
				case 7:
					System.out.println("Enter the Contact numberYou want to update");
					String updatedContact = sc.next();
					contact.setPhoneNumber(updatedContact);
					// displayContacts();
					break;
				case 8:
					System.out.println("Enter the email You want to update");
					String updatedEmail = sc.next();
					contact.setEmailID(updatedEmail);
					// displayContacts();
					break;
				default:
					System.out.println("Invalid number!");
				}
				System.out.println("details updated");
			} else
				System.out.println("No record found!");
		}
	}

	public void deleteContact(ArrayList<Contact> contactDetails) {
		System.out.println("Enter First Name for which you want to delete contact: ");
		String firstname = sc.next();
		Iterator<Contact> removeContact = AddressBook.contactDetails.iterator();
		/*
		 * Checking the next element where condition holds true till there is single
		 * element in the List using hasNext() method
		 */
		while (removeContact.hasNext()) {
			/* Move cursor to next element */
			Contact nextElement = removeContact.next();
			if (nextElement.getFirstName().equals(firstname)) {
				removeContact.remove();
				System.out.println("Contact is removed!");
				break;
			} else {
				System.out.println("Contact not found.");
			}
		}
	}

	public static void menuChoose(AddressBook addressBook, ArrayList<Contact> contactDetails) {
		Scanner sc = new Scanner(System.in);
		int chooseNumber;
		do {
			System.out.println("Enter the number that you want to choose to perform the certain task");
			System.out.println("1. Add Details \n2. Edit Details \n3. Delete Details \n4. Display Details \n5. exit ");
			chooseNumber = sc.nextInt();

			switch (chooseNumber) {
			/* Add contact details in address book */
			case 1:
				System.out.println("Add Details");
				addressBook.addDetails(contactDetails);
				break;
			case 2:
				/* Edit contact details in address book */
				System.out.println("Edit details");
				addressBook.editDetails(contactDetails);
				break;
			/* Delete contact details */
			case 3:
				System.out.println("Delete Details");
				addressBook.deleteContact(contactDetails);
				break;
			/* Display contact details */
			case 4:
				System.out.println("Display details");
				addressBook.displayContacts(contactDetails);
				break;
			case 5:
				System.out.println("Exit");
				break;
			default:
				System.out.println("invalid Option choose");
				break;
			}
		} while (chooseNumber != 5);
	}
}