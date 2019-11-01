package cevsDataAccessLayer;

import cevsDomainModel.Candidate;
import cevsDomainModel.ISaveableObject;
import cevsDomainModel.Person;

/**
 * <p>
 *  Represents an object to save a candidate.
 *  </p>
 * 
 * @author Yared
 *
 */
public class CandidateDataHandler extends PersonDataHandler
{

	/**
	 * <p>
	 *   CandidateDataHandler constructor.
	 *  </p>
	 * @param objToSave
	 * @param pdata
	 */
	public CandidateDataHandler(ISaveableObject objToSave,
			PersistDataChainHandler pdata) {
		super(objToSave, pdata);
	}
	
	/**
	 * <p>
	 *  Disabled constructor.
	 *  </p>
	 */
	@SuppressWarnings("unused")
	private CandidateDataHandler()
	{
		this(null,null);
	}
	
	/**
	 * <p>
	 * Save object handler logic here.
	 * </p>
	 */
	@Override
	protected void saveObjectHandler(ISaveableObject object) 
	{
		if ( this.getNextToProcess() == null )
    	{//The only gateway to the database to save anything is right in these two lines.
    		this.saveObject();
    	}
    	else
    	{
    		//First get the Address and Save it... 
    		AddressDataHandler adh = new AddressDataHandler(((Person)object).getAddress(),null);
    		adh.saveObject();//Address saved.
    		Candidate candidate = (Candidate)object;
    		Person person = new Person ( candidate.getPersonID(), candidate.getFistName(), candidate.getLastName(), candidate.getDateOfBirth(), candidate.getAddress());
    		PersonDataHandler pdh = new PersonDataHandler (person, null);
    		pdh.saveObject();
    		this.setNextToProcess(null);
    		this.saveObject();
    	}
	}

}
