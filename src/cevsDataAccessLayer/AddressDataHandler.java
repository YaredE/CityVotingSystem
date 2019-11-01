package cevsDataAccessLayer;

import cevsDomainModel.ISaveableObject;

/**
 * <p>
 *   Represents the AddressDataHandler
 *   </p>
 * @author estifano
 *
 */
public class AddressDataHandler extends PersistDataChainHandler
{
	/**
	 * <p>
	 * 
	 * @param objToSave
	 * @param pdata
	 */
	public AddressDataHandler(ISaveableObject objToSave,
			PersistDataChainHandler pdata) {
		super(objToSave, pdata);
	}

	@Override
	protected void saveObjectHandler(ISaveableObject object)
	{
		TransactionHandler handler = new TransactionHandler();
		if ( !handler.searchRecord(this.getDataToProcess()) ) 
		{
			this.saveObject();
		}
	}
}
