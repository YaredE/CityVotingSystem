/**
 * 
 */
package cevsDataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import cevsDomainModel.Candidate;
import cevsDomainModel.ISaveableObject;
import cevsDomainModel.Position;

/**
 * @author Yared
 *
 */
public class TransactionHandler 
{
	
	/**
	 * <p>
	 *  SQLLITE database for the system.
	 *  </p>
	 */
	private final static String databaseName = "CEVSDatabaseV1.db"; 
	/**
	 * <p>
	 * 	It takes connection manager and connects for processing transactions.
	 * </p>
	 * @param _manger
	 */
	public TransactionHandler ()
	{	
	}

	/**
	 * <p>
	 * Saves the data to the database.
	 * </p>
	 * @param _object
	 */
	public void processInsertTransaction ( ISaveableObject _object )
	{
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    String _statment = "INSERT INTO " + _object.getClass().getSimpleName() + " " + _object.values() + ";";
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      stmt.executeUpdate(_statment);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	}
	
	/**
	 * <p>
	 * Delete object from the database.
	 * </p>
	 * @param _object
	 */
	public void processDeleteTransaction ( ISaveableObject _object )
	{
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    String _statment = "DELETE FROM " + _object.getClass().getSimpleName() + " WHERE "  + _object.searchCriteria() + ";";
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      stmt.executeUpdate(_statment);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records deleted successfully");
	}
	
	/**
	 * <p>
	 * Generic method to search for a record by its type and Id.
	 * </p>
	 * @param typeName
	 * @param iden
	 */
	public boolean searchRecord ( ISaveableObject _object )
	{
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    boolean isFound = false;
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql = "SELECT * FROM " + _object.getClass().getSimpleName() + " WHERE "  + _object.searchCriteria() + ";";
	      ResultSet rs = stmt.executeQuery( sql );
	      
	      while ( rs.next() ) 
	      {
	    	  isFound = true;
	    	  break;
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } 
	    catch ( Exception e )
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    return isFound;
	}
	
	/**
	 * <p>
	 *  Get all candidates.
	 *  </p>
	 * @return
	 */
	public ArrayList <String> getAllCandidates()
	{
		ArrayList <String> _allCandidates = new ArrayList <String>();
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql = "SELECT *  FROM PERSON WHERE PPERSON_ID IN ( SELECT CPERSON_ID FROM CANDIDATE );";
	      ResultSet rs = stmt.executeQuery( sql );
	      
	      while ( rs.next() ) 
	      {
	    	  String fistName = rs.getString("PFNAME");
	    	  String lastName = rs.getString("PLNAME");
	    	  _allCandidates.add( lastName + "," + fistName );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } 
	    catch ( Exception e )
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
		return _allCandidates;
	}
	
	
	public static void intSystem()
	{
		new ConnectionManager(databaseName);
		ArrayList<String> creates = getAllTableToCreate();
		for (String _statment : creates) 
		{
			new ConnectionManager(databaseName);
			Connection c = ConnectionManager.getInstance().getConnection();
			Statement stmt = null;
			try {
				c.setAutoCommit(false);
				stmt = c.createStatement();
				stmt.executeUpdate(_statment);
				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());
				System.exit(0);
			}
		}
	}
	
	/**
	 * <p>
	 * These are our tables.
	 * Due to lack of time we are using this method to get the create statements but it should be read from file.
	 * </p>
	 * @return
	 */
	private static ArrayList<String> getAllTableToCreate()
	{
		ArrayList<String> createSQL = new ArrayList<String>();
		createSQL.add( "create table IF NOT EXISTS  PARTY(	PPARTY_ID     INTEGER                not null,    PNAME   CHAR(30)               		   null,    constraint PK_PARTY primary key (PPARTY_ID) )");
		createSQL.add("create table IF NOT EXISTS  POSITION(	PPOSITION_ID     INTEGER                not null,    PNAME   CHAR(30)               		   null,    constraint PK_POSITION primary key (PPOSITION_ID))");
		createSQL.add("create table IF NOT EXISTS  ADDRESS(	AADDRESS_ID     INTEGER                not null,    ASTREET		    CHAR(50)               null,	ACITY		    CHAR(30)               null,	AZIP		    CHAR(10)               null,    constraint PK_ADDRESS primary key (AADDRESS_ID))");
		createSQL.add("create table IF NOT EXISTS  POLLINGSTATION (	PPOLLINGSTA_ID     INTEGER                not null, PNAME              CHAR(30)                   null,	PADDRESS_ID        INTEGER                not null,    constraint PK_POLLINGSTATION primary key (PPOLLINGSTA_ID))");
		createSQL.add("create table IF NOT EXISTS  PERSON (	PPERSON_ID     INTEGER                not null,    PFNAME         CHAR(30)               	 null,	PLNAME         CHAR(30)               	 null,	PDOB                                     DATE,	PADDRESS_ID    INTEGER                not null,    constraint PK_PERSON primary key (PPERSON_ID))");
		createSQL.add("create table IF NOT EXISTS  USER ( VVUSER_ID      CHAR(10)               not null,    VUSER_LEVEL    INTEGER                not null, 	VPASSWORD      CHAR(15)               not null,	VPERSON_ID     INTEGER                not null, 	constraint PK_VUSER primary key (VVUSER_ID, VUSER_LEVEL, VPERSON_ID))");
		createSQL.add("create table IF NOT EXISTS  CANDIDATE (    CCANDIDATE_ID      INTEGER                not null,    CPERSON_ID         INTEGER                not null, 	CPOSITION_ID       INTEGER                not null, 	CPARTY_ID          INTEGER                not null, 	constraint PK_CANDIDATE primary key (CCANDIDATE_ID, CPERSON_ID, CPOSITION_ID))");
		createSQL.add("create table IF NOT EXISTS  VOTER (    VVOTER_ID      INTEGER                not null,    VPERSON_ID         INTEGER                not null, 	constraint PK_VOTER primary key (VVOTER_ID, VPERSON_ID))");
		createSQL.add("create table IF NOT EXISTS  RULE (    RRULE_ID         INTEGER                not null,    ROBJECTTYPE      CHAR(30)                   null,	RATTRIBUTEName   CHAR(30)                   null, 	RATTRIBUTEVALUE  CHAR(30)                   null, 	ROPERATION       INTEGER					null,	constraint PK_CANDIDATE primary key (RRULE_ID))");
		createSQL.add("create table IF NOT EXISTS  CANDIDATERULE (    CCANDIDATERULE_ID         INTEGER                not null,    CRULE_ID                  INTEGER                not null,	constraint PK_CANDIDATERULE primary key (CCANDIDATERULE_ID,CRULE_ID))");
		createSQL.add("create table IF NOT EXISTS  VOTERRULE (    VVOTERRULE_ID         INTEGER                not null,    VRULE_ID                  INTEGER                not null,	constraint PK_VOTERRULE primary key (VVOTERRULE_ID,VRULE_ID))");
		createSQL.add("create table IF NOT EXISTS  BALLOT(    BALLOT_ID       INTEGER                not null, BVOTER_ID       INTEGER                not null,   BCANDIDATE_ID   INTEGER                not null,	BPOSITION_ID    INTEGER                not null, 	BPOLLINGSTA_ID  INTEGER                not null,	constraint PK_CANDIDATE primary key (BALLOT_ID, BCANDIDATE_ID,BPOSITION_ID,BPOLLINGSTA_ID))");
		return createSQL;
	}

	public Hashtable<Integer, String> getPositions()
	{
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    Hashtable<Integer, String> result=null;
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql = "SELECT *  FROM POSITION;";
	      ResultSet rs = stmt.executeQuery( sql );
	      result = new Hashtable<Integer, String>();
	      
	      while ( rs.next() ) 
	      {
	    	  Integer positionID = rs.getInt("PPOSITION_ID");
	    	  String positionName = rs.getString("PNAME");
	    	  result.put(positionID, positionName);
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } 
	    catch ( Exception e )
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    return result;
	}

	public Hashtable<Integer, String> getPartyByName(String partyName)
	{
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    Hashtable<Integer, String> result=null;
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql = "SELECT *  FROM PARTY WHERE PNAME = '" + partyName + "';";
	      ResultSet rs = stmt.executeQuery( sql );
	      result = new Hashtable<Integer, String>();
	      
	      while ( rs.next() ) 
	      {
	    	  Integer positionID = rs.getInt("PParty_ID");
	    	  String positionName = rs.getString("PNAME");
	    	  result.put(positionID, positionName);
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } 
	    catch ( Exception e )
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    return result;
	}

	public ArrayList<String> getCandidates(Integer key) 
	{
		ArrayList<String> _allCandidates = new ArrayList<String>();
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    try {
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql = "SELECT PERSON.PFNAME, PERSON.PLNAME FROM PERSON INNER JOIN CANDIDATE ON PERSON.PPERSON_ID=CANDIDATE.CPERSON_ID WHERE CANDIDATE.CPOSITION_ID = " + key + ";";
	      ResultSet rs = stmt.executeQuery( sql );
	      
	      while ( rs.next() ) 
	      {
	    	  String fistName = rs.getString("PFNAME");
	    	  String lastName = rs.getString("PLNAME");
	    	  String presentableName =  lastName + "," + fistName;
	    	  _allCandidates.add(presentableName);	    	  
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } 
	    catch ( Exception e )
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
		return _allCandidates;
	}

	public Candidate getCandidateByName(String candidateName) 
	{
		Candidate candidate = null;
		new ConnectionManager(databaseName);
		Connection c = ConnectionManager.getInstance().getConnection();
	    Statement stmt = null;
	    try 
	    {
	       String[] nameArray = candidateName.split(",");
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql ="SELECT CANDIDATE.CCANDIDATE_ID,CANDIDATE.CPERSON_ID, CANDIDATE.CPOSITION_ID, CANDIDATE.CPARTY_ID FROM CANDIDATE WHERE ";
	      sql += " CANDIDATE.CPERSON_ID IN ( SELECT PERSON.PPERSON_ID FROM PERSON WHERE  PERSON.PFNAME ='";
	      sql +=  nameArray[1] + "' AND PERSON.PLNAME = '" + nameArray[0] + "');";
	      ResultSet rs = stmt.executeQuery( sql );
	      
	      while ( rs.next() ) 
	      {
	    	  Integer candidateID = rs.getInt("CCANDIDATE_ID");
	    	  Integer personID = rs.getInt("CPERSON_ID");
	    	  Integer positionID = rs.getInt("CPOSITION_ID");
	    	  candidate = new Candidate(candidateID, null, new Position(positionID,""), personID, nameArray[1], nameArray[0], null, null);    	  
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } 
	    catch ( Exception e )
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
		return candidate;
	}
}
