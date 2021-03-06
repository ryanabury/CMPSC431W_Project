package com.fusion.objects;

import java.util.ArrayList;

/**
 * This class represents one user. This class contains the same data for a user
 * that would be found stored in the user table.
 * 
 * @author Ethan Raymond
 */
public class User {

	/**
	 * Specified how many characters long the user id is.
	 */
	public static final int REG_ID_SIZE = 20;

	private ArrayList<Address> addresses;
	private byte age;
	private double annualSalary;
	private ArrayList<CreditCard> creditCards;
	private String emailAddress;
	private String firstName;
	private char gender;
	private boolean isActive;
	private String lastName;
	private String password;
	private String phoneNumber;
	private char[] regId;
	private String username;
	
	public User(char[] regID, String emailAddress, boolean isActive, String username, String password, String firstName, String lastName, byte age, String phoneNumber, char gender, float annualSalary) {
		this.regId = regID;
		this.emailAddress = emailAddress;
		this.isActive = isActive;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.annualSalary = annualSalary;
		addresses = new ArrayList<Address>();
	}
	
	/**
	 * Creates a default user. Use the setter methods for this class to fill in
	 * data.
	 */
	public User() {
		this(new char[REG_ID_SIZE], "", false, "", "", "", "", (byte) 0, "", 'm', (float) 0.0);
	}
	
	/**
	 * Adds a new address to the user's list of stored addresses.
	 */
	public void addAddress(Address address) {
		if (address == null) {
			throw new RuntimeException("Tried to a null address.");
		}
		getAddresses().add(address);
	}
	
	/**
	 * Adds a new credit card for this user.
	 */
	public void addCreditCard(CreditCard creditCard) {
		if (creditCard == null) {
			throw new RuntimeException("Tried to add a null credit card.");
		}
		creditCards.add(creditCard);
	}

	/**
	 * Returns the first entry in Addresses if it exists
	 */
	public String getPrimaryAddress() {
		if (addresses.isEmpty()) {
			return "No Address";
		}
		return addresses.get(0).toString();
	}
	
	/**
	 * @return a list of the user's addresses.
	 */
	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @return the age of the user
	 */
	public byte getAge() {
		return age;
	}
	
	/**
	 * @return the annual salary of the user
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @return the list of credit cards stored for this user
	 */
	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	/**
	 * @return the email address for this user.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return 'm' if this user is male, 'f' if this user is female.
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @return the user's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	/**
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the user's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the user ID
	 */
	public char[] getRegId() {
		return regId;
	}

	/**
	 * @return this user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return true if the user is active, false if the user is not active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Removes and address from the user's list of stored addresses.
	 */
	public void removeAddress(Address address) {
		getAddresses().remove(address);
	}

	/**
	 * Removed a credit card from this user.
	 */
	public void removeCreditCard(CreditCard creditCard) {
		creditCards.remove(creditCard);
	}

	/**
	 * Sets the 'active' flag for this user.
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Sets a new age for the user.
	 */
	public void setAge(byte age) {
		this.age = age;
	}

	/**
	 * Sets a new annual salary of this user.
	 */
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	/**
	 * Sets a new email address.
	 */
	public void setEmailAddress(String emailAddress) {
		if (emailAddress == null) {
			throw new RuntimeException("Tried to set the user's address to null.");
		}
		this.emailAddress = emailAddress;
	}

	/**
	 * Sets a new first name for the user.
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new RuntimeException("Tried to set the user's first name to null.");
		}
		this.firstName = firstName;
	}

	/**
	 * Sets the gender of this user
	 * 
	 * @param gender
	 *            only 'm' and 'f' are allowed. All else will be ignored.
	 */
	public void setGender(String gender) {
		if (gender != "m" && gender != "f") {
			return;
		}
		this.gender = gender.charAt(0);
	}

	/**
	 * Sets a new last name for the user.
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new RuntimeException("Tried to set the user's last name to null.");
		}
		this.lastName = lastName;
	}

	/**
	 * Sets a new password for this user.
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new RuntimeException("Tried to set the user's password to null.");
		}
		this.password = password;
	}

	/**
	 * Sets a new phone number for the user.
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
			throw new RuntimeException("Tried to set the user's phone number to null.");
		}
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Sets a new user ID.
	 */
	public void setRegId(char[] regId) {
		if (regId == null) {
			throw new RuntimeException("Tried to set the user's ID to null.");
		}
		if (regId.length >= REG_ID_SIZE) {
			throw new RuntimeException("Tried to set the user's ID to an invalid value [" + regId.toString() + "].");
		}
		this.regId = regId;
	}

	/**
	 * Sets a new username.
	 */
	public void setUsername(String username) {
		if (username == null) {
			throw new RuntimeException("Tried to set the user's username to null.");
		}
		this.username = username;
	}

}
