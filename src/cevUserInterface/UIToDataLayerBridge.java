package cevUserInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import cevsDataAccessLayer.SystemObjectFactory;
import cevsDomainModel.ISaveableObject;

public class UIToDataLayerBridge
{

	/**
	 * <p>
	 * Responsible for creating the object.
	 * </p>
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param suffix
	 * @param dateOfBirth
	 * @param placeOfBirth
	 * @param lastFourSSN
	 * @param drivLic
	 * @param emailAddress
	 * @param streetAddress
	 * @param city
	 * @param zip
	 * @param position
	 * @return
	 */
	public static ISaveableObject register(String firstName, String middleName,
			String lastName, String suffix, Date dateOfBirth,
			String placeOfBirth, String lastFourSSN, String drivLic,
			String emailAddress, String streetAddress, String city, String zip,
			String position, String partyName) {
		
		if (position == null || position.isEmpty())
		{
			ISaveableObject voter = SystemObjectFactory.createVoter(firstName, middleName, lastName, suffix, dateOfBirth, placeOfBirth, lastFourSSN, drivLic, emailAddress, streetAddress, city, zip);
			return voter;
		}
		else 
		{
			ISaveableObject candidate = SystemObjectFactory.createCandidate(firstName, middleName, lastName, suffix, dateOfBirth, placeOfBirth, lastFourSSN, drivLic, emailAddress, streetAddress, city, zip, position,partyName	);
			return candidate;
		}
	}

	/**
	 * <p>
	 *   Responsible for recording the vote.
	 *  </p>
	 * @param voterID
	 * @param choices
	 */
	public static boolean recordVoterChoices(String voterID,ArrayList<VotingChoice> choices) 
	{
		boolean status = SystemObjectFactory.recordVote (voterID, choices);
		return status;
	}
	
	
	/**
	 * <p>
	 * Creates the database and necessary objects.
	 * </p>
	 */
	public static void initializeSystem()
	{
		SystemObjectFactory.initializeSystem();
	}
	
	
	public static Hashtable<Integer, String> getPositions()
	{
		return SystemObjectFactory.getPositions();
	}

	/**
	 * <p>
	 *  All of the candidates.
	 *  </p>
	 * @param key 
	 * @return
	 */
	public static ArrayList<String> getCandidates(Integer key)
	{
		return SystemObjectFactory.getCandidates(key);
	}

	public static boolean authenticateVoter(String voterID) throws Exception
	{
		return SystemObjectFactory.authenticateVoter( voterID );
	}

	public static boolean authenticateUser(String userID, String password) 
	{
		return SystemObjectFactory.authenticateUser(userID,password);
	}
}
