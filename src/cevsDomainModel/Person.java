package cevsDomainModel;

import java.util.Date;

/*
 * Represents the Person Object.
 */
public class Person implements ISaveableObject
{

	/**
	 * @category Data Model
	 * Represents Person ID.
	 */
	private Integer personID;
 
 
	/**
	 * @category Data Model
	 * Represents Person first name.
	 */
	private String fistName;
 
 
	/**
	 * @category Data Model
	 * Represents Person last name.
	 */
	private String lastName;
	
	/**
	 * @category Data Model
	 * Represents Person ID.
	 */
	private Date dateOfBirth;
	 
	/**
	 * @category Data Model
	 * Represents Person Address.
	 */
	private Address address;
	
	
	/**
	 * @category Data Model
	 * Default constructor disabled.
	 */
	@SuppressWarnings("unused")
	private Person()
	{
	}

 
	/**
	 * 
	 * @param name
	 * @param lastName
	 */
	public Person(Integer _id, String _firstName, String _lastName, Date _dateOfBirth, Address _address)
	{
		this.setPersonID(_id);
		this.setFistName(_firstName);
		this.setLastName(_lastName);
		this.setAddress(_address);
	}


	/**
	 * 
	 * @return the person ID.
	 */
	public Integer getPersonID() {
		return personID;
	}


	/**
	 * 
	 * @param personID the person ID.
	 */
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}


	public String getFistName() {
		return fistName;
	}


	/**
	 * Sets the person's first name.
	 * @param fistName the first name of the person.
	 * 
	 */
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}


	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	/**
	 * <p>
	 *  Values to be added.
	 * </p>
	 * @return
	 */
	@Override
	public String values()
	{
		String values = "( PPERSON_ID, PFNAME, PLNAME, PDOB, PADDRESS_ID )  VALUES ("  + this.getPersonID() + ",'" +  this.getFistName() + "', '" +
	                     this.getLastName() + "', "  + this.getDateOfBirth() + ", " + this.getAddress().getAddressID() + ");";
		return values;
	}

	/***
	 * <p>
	 * Search will be made using this info.
	 * </p>
	 */
	@Override
	public String searchCriteria() 
	{
		return " PFNAME = '" + this.getFistName() + "'  AND  PLNAME = '" + this.getLastName() + "' " ;
	}

}