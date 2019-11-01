package cevsDataAccessLayer;

import cevsDomainModel.ISaveableObject;
import cevsDomainModel.Person;

public class PersonDataHandler extends PersistDataChainHandler 
{
	

	/**
	 * <p>
	 *  Constructor with param.
	 *  </p>
	 * @param objToSave
	 * @param pdata
	 */
	public PersonDataHandler(ISaveableObject objToSave,
			PersistDataChainHandler pdata) {
		super(objToSave, pdata);
	}
	
	
	/**
	 * <p>
	 * Disabled default constructor.
	 * </p>
	 */
	@SuppressWarnings("unused")
	private PersonDataHandler()
	{
		this (null,null);
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
    		this.setNextToProcess(null);
    		this.saveObject();//Person saved
    	}
	}
}
