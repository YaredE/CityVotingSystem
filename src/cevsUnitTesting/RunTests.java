package cevsUnitTesting;

import java.io.IOException;
import java.util.Date;

import cevsDataAccessLayer.ConnectionManager;
import cevsDataAccessLayer.TransactionHandler;
import cevsDomainModel.Address;
import cevsDomainModel.Candidate;
import cevsDomainModel.CandidateRule;
import cevsDomainModel.Operator;
import cevsDomainModel.Party;
import cevsDomainModel.Person;
import cevsDomainModel.PollingStation;
import cevsDomainModel.Position;
import cevsDomainModel.Rule;
import cevsDomainModel.User;
import cevsDomainModel.Voter;
import cevsDomainModel.VoterRule;

public class RunTests 
{

	public static void main(String[] args) 
	{
		String current="";
		try {
			current = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Current dir:"+current);
		new ConnectionManager("TestDB.db");
		testAddDeleteParty();
		testAddDeletePosition();
		testAddAndDeleteAddress();
		testAddAndDeletePollingStation();
		testAddAndDeletePerson();
		testAddAndDeleteUser();
		testAddAndDeleteCandidate();
		testAddAndDeleteVoter();
		testAddAndDeleteRule();
		testAddAndDeleteCandidateRule();
		testAddAndDeleteVoterRule();
	}
	
	/**
	 *  <p>
	 *  Testing add(delete) Party.
	 *  </p>
	 */
	private static void testAddDeleteParty(   )
	{	
		TransactionHandler handler = new TransactionHandler();
		//Create a new Party.
		Party party = new Party(789,"Testing party");
		handler.processInsertTransaction(party);
		
		//Search that party.
		boolean searchResult = handler.searchRecord(party);
		System.out.println("Does this exist:"+  searchResult );
 
		
		Party noneExisting  = new Party(7890,"Testing party");
		searchResult = handler.searchRecord(noneExisting);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( party );
		searchResult = handler.searchRecord(party);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	private static void testAddDeletePosition(  )
	{
		TransactionHandler handler = new TransactionHandler();
		//Create a new Party.
		Position position = new Position(789,"City Mayor office");
		handler.processInsertTransaction(position);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(position);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( position );
		searchResult = handler.searchRecord(position);
		System.out.println("Does this exist:"+  searchResult );
		
	}
	
	
	private static void testAddAndDeleteAddress()
	{
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (789, "123 Main Street", "Minneapolis", "55434-1234");
		
		handler.processInsertTransaction(address);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(address);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( address );
		searchResult = handler.searchRecord(address);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	
	private static void testAddAndDeletePollingStation()
	{
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (789, "123 Main Street", "Minneapolis", "55434-1234");
		PollingStation station = new PollingStation ( 789, " Station ID", address );
		
		handler.processInsertTransaction(station);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(station);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( station );
		searchResult = handler.searchRecord(station);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	private static void testAddAndDeletePerson()
	{
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (789, "123 Main Street", "Minneapolis", "55434-1234");
		Person person = new Person ( 789, " Joe", "Foreman", new Date(), address );
		
		handler.processInsertTransaction(person);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(person);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( person );
		
		searchResult = handler.searchRecord(person);
		System.out.println("Does this exist:"+  searchResult );
	}
	

	private static void testAddAndDeleteUser()
	{
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (121, "123 Main Street", "Minneapolis", "55434-1234");
		User user = new User ( "Joe1231", "passJoe", 1, 897, " Joe", "Foreman", new Date(), address );
		
		handler.processInsertTransaction(user);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(user);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( user );
		searchResult = handler.searchRecord(user);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	
	private static void testAddAndDeleteCandidate()
	{
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (121, "123 Main Street", "Minneapolis", "55434-1234");
		Integer id = new Integer ((int)Math.random()*2048);
		Position position = new Position(id,"City Mayor office");
		Party party = new Party(id,"Testing party");
		
		Candidate cand = new Candidate ( 125, party, position, 125,  " Joe", "Foreman", new Date(), address );
		
		handler.processInsertTransaction(cand);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(cand);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( cand );
		searchResult = handler.searchRecord(cand);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	private static void testAddAndDeleteVoter()
	{
		TransactionHandler handler = new TransactionHandler();
		Address address = new Address (121, "123 Main Street", "Minneapolis", "55434-1234");
		Voter voter = new Voter ( 125, 789," Joe", "Foreman", new Date(), address );
		
		handler.processInsertTransaction(voter);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(voter);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( voter );
		searchResult = handler.searchRecord(voter);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	
	private static void testAddAndDeleteRule()
	{
		TransactionHandler handler = new TransactionHandler();
		Integer id = new Integer ((int)Math.random()*2048);
	
		Rule rule = new Rule( id,"Person", "DOB", "21",  Operator.EQUALS);
	
		handler.processInsertTransaction(rule);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(rule);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( rule );
		searchResult = handler.searchRecord(rule);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	private static void testAddAndDeleteCandidateRule()
	{
		TransactionHandler handler = new TransactionHandler();
		Integer id = new Integer (789);
		Integer cid = new Integer (789);
	
		CandidateRule rule = new CandidateRule( cid, id,"Person", "DOB", "21",  Operator.EQUALS);
	
		handler.processInsertTransaction(rule);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(rule);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( rule );
		searchResult = handler.searchRecord(rule);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	private static void testAddAndDeleteVoterRule()
	{
		TransactionHandler handler = new TransactionHandler();
		Integer id = new Integer (789);
		Integer cid = new Integer (789);
	
		VoterRule rule = new VoterRule( cid, id,"Person", "DOB", "21",  Operator.EQUALS);
	
		handler.processInsertTransaction(rule);
		
		//Search that Position.
		boolean searchResult = handler.searchRecord(rule);
		System.out.println("Does this exist:"+  searchResult );
		
		//Now delete it 
		handler.processDeleteTransaction ( rule );
		searchResult = handler.searchRecord(rule);
		System.out.println("Does this exist:"+  searchResult );
	}
	
	
}
