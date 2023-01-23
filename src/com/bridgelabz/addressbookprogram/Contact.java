package com.bridgelabz.addressbookprogram;

public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private long  phoneNumber;
	private String emailID;
	private String city;
	private String state;
	private long  zip;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Contact [\n firstName=" + firstName + ",\n lastName=" + lastName + ",\n address=" + address + ",\n phoneNumber="
				+ phoneNumber + ",\n emailID=" + emailID + ",\n city=" + city + ",\n state=" + state + ",\n zip=" + zip + "]";
	}
}
