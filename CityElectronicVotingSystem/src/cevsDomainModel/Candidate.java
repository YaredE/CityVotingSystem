package cevsDomainModel;

import java.util.Date;

public class Candidate extends Person implements IRule
{
	/**
	 * <p>
	 *  Represents the candidate Id.
	 *  </p>
	 */
	private Integer candidateId;

	/**
	 * <p>
	 * Represents the party.
	 * <p>
	 */
	private Party affiliation;

	/**
	 * <p>
	 *  Represents the position candidate is running for.
	 *  </p>
	 */
	private Position officePosition;
	
	
	/**
	 * <p>
	 *  Constructor with parameters.
	 *  </p>
	 * @param _cand
	 * @param _party
	 * @param _pos
	 * @param _id
	 * @param _firstName
	 * @param _lastName
	 * @param _dateOfBirth
	 * @param _address
	 */
	public Candidate(Integer _cand, Party _party, Position _pos, Integer _id, String _firstName, String _lastName,
			Date _dateOfBirth, Address _address) {
		super(_id, _firstName, _lastName, _dateOfBirth, _address);
		this.setCandidateId(_cand);
		this.setAffiliation(_party);
		this.setOfficePosition(_pos);
	}
	
	/**
	 * @return the candidateId
	 */
	public Integer getCandidateId() {
		return candidateId;
	}


	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}


	/**
	 * @return the affiliation
	 */
	public Party getAffiliation() {
		return affiliation;
	}


	/**
	 * @param affiliation the affiliation to set
	 */
	public void setAffiliation(Party affiliation) {
		this.affiliation = affiliation;
	}


	/**
	 * @return the officePosition
	 */
	public Position getOfficePosition() {
		return officePosition;
	}


	/**
	 * @param officePosition the officePosition to set
	 */
	public void setOfficePosition(Position officePosition) {
		this.officePosition = officePosition;
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
		String values = "( CCANDIDATE_ID, CPERSON_ID, CPOSITION_ID, CPARTY_ID )  VALUES ("  + this.getCandidateId() + "," +  this.getPersonID() + ", " +
	                     this.getOfficePosition().getPositionID() + ", " +  this.getAffiliation().getPartyID() +  ");";
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
		return " CCANDIDATE_ID = " + this.getCandidateId();
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", affiliation="
				+ ", Fist Name=" + getFistName() + ", Last Name =" + getLastName() + "]";
	}

	
}