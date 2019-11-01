package cevsDomainModel;

import java.util.ArrayList;

public class Ballot implements ISaveableObject
{
	/**
	 * <p>
	 * ID given to a Ballot.
	 * </p>
	 */
	private Integer ballotID;
	
	/**
	 * <p>
	 * The voter ID associated with the vote.
	 * <p>
	 */
	private Integer voterID;
	
	/**
	 * <p>
	 * Candidates on the ballot who are elected.
	 * </p>
	 */
	private ArrayList<Candidate> candidatesChoosen;
	
	
	/**
	 * <p>
	 *  Represents a Ballot object.
	 *  </p>
	 * @param _voting
	 */
	public Ballot( Voter _voting )
	{
		this.setVoterID(_voting.getVoterID());
		candidatesChoosen = new ArrayList<Candidate>() ;
	}
	
	/**
	 * @return the ballotID
	 */
	public Integer getBallotID() 
	{
		return ballotID;
	}

	/**
	 * @param ballotID the ballotID to set
	 */
	public void setBallotID(Integer ballotID) {
		this.ballotID = ballotID;
	}

	/**
	 * @return the candidatesChoosen
	 */
	public ArrayList<Candidate> getCandidatesChoosen() {
		return candidatesChoosen;
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
	 *   When user is Chosen the candidate.
	 * </p>
	 * @param _candidate
	 */
	public void addCandidatesChoosen( Candidate _candidate )
	{
		this.getCandidatesChoosen().add(_candidate);
	}
	
	@Override
	public String values() 
	{
		String values = "( BALLOT_ID, BVOTER_ID, BCANDIDATE_ID, BPOSITION_ID, BPOLLINGSTA_ID )  VALUES ("  + this.getBallotID() + "," +  this.getVoterID() + ", " +
            this.getCandidatesChoosen().get(0).getCandidateId() + ", " + this.getCandidatesChoosen().get(0).getOfficePosition().getPositionID() + "," +  123546 +  ");";
		return values;
	}

	@Override
	public String searchCriteria() 
	{
		return " BVOTER_ID = " + this.getVoterID();
	}
	
}