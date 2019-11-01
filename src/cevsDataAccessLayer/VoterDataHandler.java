package cevsDataAccessLayer;

import cevsDomainModel.ISaveableObject;
import cevsDomainModel.Person;
import cevsDomainModel.Voter;

public class VoterDataHandler extends PersonDataHandler {

	/**
	 * <p>
	 *  Constructor with parameters.
	 *  </p>
	 * @param objToSave
	 * @param pdata
	 */
	public VoterDataHandler(ISaveableObject objToSave,
			PersistDataChainHandler pdata) {
		super(objToSave, pdata);
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
    		Voter voter = (Voter)object;
    		Person person = new Person ( voter.getPersonID(), voter.getFistName(), voter.getLastName(), voter.getDateOfBirth(), voter.getAddress());
    		PersonDataHandler pdh = new PersonDataHandler (person, null);
    		pdh.saveObject();
    		this.setNextToProcess(null);
    		this.saveObject();
    	}
	}

}
