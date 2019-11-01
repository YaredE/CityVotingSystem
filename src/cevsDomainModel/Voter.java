package cevsDomainModel;

import java.util.Date;

public class Voter extends Person implements IRule
{
	/**
	 * <p>
	 * Represents the voter ID.
	 * </p>
	 */
	private Integer voterID;
	


	/**
	 * <p>
	 * Constructs the Voter Object.
	 * </p>
	 * @param _voterId
	 * @param _id
	 * @param _firstName
	 * @param _lastName
	 * @param _dateOfBirth
	 * @param _address
	 */
	public Voter(Integer _voterId, Integer _id, String _firstName, String _lastName,
			Date _dateOfBirth, Address _address) {
		super(_id, _firstName, _lastName, _dateOfBirth, _address);
		this.setVoterID(_voterId);
	}
	
	/**
	 * 
	 * @param validVoterID
	 */
	public Voter(Integer validVoterID)
	{
		super(validVoterID, null, null, null, null);
		this.setVoterID(validVoterID);
	}



	/**
	 * @return the voterID
	 */
	public Integer getVoterID() {
		return voterID;
	}



	/**
	 * @param voterID the voterID to set
	 */
	public void setVoterID(Integer voterID) {
		this.voterID = voterID;
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
		String values = "( VVOTER_ID, VPERSON_ID )  VALUES ("  + this.getVoterID() + "," +  this.getPersonID() + ");";
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
		return " VVOTER_ID = " + this.getVoterID();
	}



	@Override
	public boolean validate() 
	{// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString()
	{
		return this.getLastName() + ", " + this.getFistName() + "\n VOTERID : " + this.getVoterID();
	}
	
}