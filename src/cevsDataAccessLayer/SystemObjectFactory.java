package cevsDataAccessLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import cevUserInterface.VotingChoice;
import cevsDomainModel.Address;
import cevsDomainModel.Ballot;
import cevsDomainModel.Candidate;
import cevsDomainModel.Party;
import cevsDomainModel.Person;
import cevsDomainModel.Position;
import cevsDomainModel.User;
import cevsDomainModel.Voter;

public class SystemObjectFactory 
{
	
	
	/**
	 * <p>
	 * Responsible for creating a Voter Object 
	 * @Pattern Factory
	 * </p>
	 * @param _voterId
	 * @param _id
	 * @param _firstName
	 * @param _lastName
	 * @param _dateOfBirth
	 * @param _address
	 * @return
	 */
	public static Voter createVoter (String firstName, String middleName,
			String lastName, String suffix, Date dateOfBirth,
			String placeOfBirth, String lastFourSSN, String drivLic,
			String emailAddress, String streetAddress, String city, String zip)
	{
		
		Voter voter =null;
		try
		{
			Integer addressID = (int) (Math.random() * 512 * 6);
			Address address = createAddress(addressID, streetAddress, city, zip);

			java.util.Random random = new java.util.Random();
			int randID = random.nextInt(9999) + 100;
			Integer personID = new Integer(randID);

			randID = random.nextInt(9999) + 100;
			Integer voterID = new Integer(randID);
			
			voter = new Voter (voterID, personID, firstName, lastName, dateOfBirth, address );
			voter.validate();
			
			//Create a chain here ... 
			VoterDataHandler vdh=null;
			vdh = new VoterDataHandler(voter, vdh);
			vdh.setNextToProcess(vdh);
			vdh.saveObject();
		}
		catch ( Exception ex )
		{
			ex.printStackTrace();
		}
		return voter;
	}
	
	/**
	 * <p>
	 * Responsible for creating a candidate object @Pattern Factory
	 * </p>
	 * @param _cand
	 * @param _party
	 * @param _pos
	 * @param _id
	 * @param _firstName
	 * @param _lastName
	 * @param _dateOfBirth
	 * @param _address
	 * @return
	 */
	public static Candidate createCandidate(String firstName, String middleName,
			String lastName, String suffix, Date dateOfBirth,
			String placeOfBirth, String lastFourSSN, String drivLic,
			String emailAddress, String streetAddress, String city, String zip, String position, String partyName)
	{
		Candidate candidate = null;
		try
		{
			Integer addressID = (int) (Math.random() * 512 * 6);
			Address address = createAddress(addressID, streetAddress, city, zip);

			java.util.Random random = new java.util.Random();
			int randID = random.nextInt((int)(Math.random() * 1024 * 6)) + 100;
			Integer personID = new Integer(randID);

			randID = random.nextInt((int)(Math.random() * 2048 * 12)) + 100;
			Integer candidateID = new Integer(randID);
			
			Position pos = getPositionByName (position);
			Party party = getPartyByName(partyName);
			
			candidate = new Candidate (candidateID, party, pos, personID, firstName, lastName, dateOfBirth, address );
			candidate.validate();
			//Create a chain here ... 
			CandidateDataHandler cdh=null;
			cdh = new CandidateDataHandler(candidate, cdh);
			cdh.setNextToProcess(cdh);
			cdh.saveObject();
		}
		catch ( Exception ex )
		{
			ex.printStackTrace();
		}
		return candidate;		
	}
	
	private static Position getPositionByName(String position)
	{
		Position pos = null;
		TransactionHandler handler = new TransactionHandler();
		Hashtable<Integer, String> positions = handler.getPositions();
		Enumeration<Integer> posPairs = positions.keys();
		while(posPairs.hasMoreElements())
		{
			Integer key = posPairs.nextElement();
			String postionName = positions.get(key);
			if ( postionName.equalsIgnoreCase(position))
			{
				pos = new Position(key,position);
			}
		 }
		return pos;
	}

	/**
	 * <p> 
	 * @param partyName
	 * @return
	 */
	private static Party getPartyByName(String partyName)
	{
		Party party = null;
		TransactionHandler handler = new TransactionHandler();
		Hashtable<Integer, String> result = handler.getPartyByName ( partyName );
		Enumeration<Integer> posPairs = result.keys();
		while(posPairs.hasMoreElements())
		{
			Integer key = posPairs.nextElement();
			String parName = result.get(key);
			if ( parName.equalsIgnoreCase(partyName))
			{
				party = new Party(key,parName);
			}
		 }
		return party;
	}

	/**
	 * <p>
	 *  Responsible for creating a Address object @Pattern Factory
	 *  </p>
	 * @param _aID
	 * @param _street
	 * @param _city
	 * @param _zip
	 * @return
	 */
	private static Address createAddress ( Integer _aID, String _street, String _city, String _zip)
	{
		Address address = null;

		try {
			address = new Address(_aID, _street, _city, _zip);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return address;
	}

	public static boolean recordVote(String voterID, ArrayList<VotingChoice> choices)
	{// TODO Auto-generated method stub
		if ( voterID == null || voterID.isEmpty())
		{
			return false;
		}
		
		Integer validVoterID = new Integer(Integer.parseInt(voterID));
		Integer ballotID = validVoterID * 32;
		Voter voter = new Voter(validVoterID);
		for (int inx = 0; inx < choices.size(); inx++) {
			Ballot ballot = new Ballot(voter);
			ballot.setVoterID(validVoterID);
			ballot.setBallotID (ballotID);
			Candidate _candidate = getCandidateByName(choices.get(inx).getChoiceName());
			if ( _candidate == null )
			{
				continue;
			}
			ballot.addCandidatesChoosen(_candidate);
			BallotDataHandler bdh = new BallotDataHandler(ballot, null);
			bdh.saveObject();
		}
	
		System.out.println (" I Voted!");
		return true;
	}
	
	private static Candidate getCandidateByName(String candidateName)
	{
		TransactionHandler handler = new TransactionHandler();
		return handler.getCandidateByName(candidateName);
	}

	/**
	 * <p> System setup. </p>
	 */
	public static void initializeSystem()
	{
		TransactionHandler.intSystem();
		ArrayList<String> positions = new ArrayList<String>();
		positions.add("City Mayor");
		positions.add("County Sheriff");
		positions.add("County Judge");
		positions.add("Proposition 189");
		for ( int inx=0; inx < positions.size(); inx++ )
		{
			TransactionHandler handler = new TransactionHandler();
			Integer posid = new Integer ((int)(Math.random()*200*2014));
			Position pos = new Position( posid, positions.get(inx));
			if ( !handler.searchRecord(pos) )
			{
				handler.processInsertTransaction(pos);
			}
		}
		
		String [] party = new String [] {"Democratic Party","Republican Party", "Libertarian"};
		for ( int inx=0; inx < party.length; inx++ )
		{
			java.util.Random random = new java.util.Random();
			int randID = random.nextInt((int)(Math.random() * 1024 * 6)) + 100;
			Integer id = new Integer (randID);
			Party oparty = new Party(id, party[inx]);
			TransactionHandler handler = new TransactionHandler();
			if ( !handler.searchRecord(oparty) )
			{
				handler.processInsertTransaction(oparty);
			}
		}
		
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (121, "123 Main Street", "Minneapolis", "55434-1234");
		User user = new User ( "admin", "admin", 1, 897, " Admin", "Admin", new Date(), address );
		if ( !handler.searchRecord(user) )
		{
			handler.processInsertTransaction(user);
		}
	}

	public static Hashtable<Integer, String> getPositions() 
	{
		TransactionHandler handler = new TransactionHandler();
		return handler.getPositions();
	}

	public static ArrayList<String> getCandidates(Integer key) 
	{
		TransactionHandler handler = new TransactionHandler();
		return handler.getCandidates(key);
	}

	public static boolean authenticateVoter(String svoterID) throws Exception 
	{
		TransactionHandler handler = new TransactionHandler();
		Integer voterID =  Integer.parseInt( svoterID );
		Voter validationObject  = new Voter (voterID);
		if ( handler.searchRecord(validationObject) )
		{
			Ballot validationBallot = new Ballot(validationObject);
			if ( handler.searchRecord(validationBallot) )
			{
				throw new Exception ("You already voted!");
			}
			return true;
		}
		return false;
	}

	public static boolean authenticateUser(String userID, String password)
	{
		TransactionHandler handler = new TransactionHandler();
		User user = new User ( userID, password, 1, 897, " XXX", "XXX", new Date(), null );
		return handler.searchRecord(user);		
	}
}
