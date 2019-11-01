package cevsDataAccessLayer;

import cevsDomainModel.ISaveableObject;

/**
 * <p>
 *  Represents a class for persisting data.
 *  </p>
 * @author Yared
 *
 */
public abstract class PersistDataChainHandler
{
	
   /**
	 * <p>
	 *   This must be saved before the current object to save.
	 *   </p>
	 */
    protected PersistDataChainHandler pHandler;
    
	
    /**
     * <p>
     *  The object to save.
     *  </p>  
     */
	private ISaveableObject dataToProcess;
	
	
	/**
	 * <p>
	 *  Constructor with parameter.
	 *  </p>
	 * @param objToSave
	 * @param pdata
	 */
	public PersistDataChainHandler (ISaveableObject objToSave, PersistDataChainHandler pdata)
	{
		this.setDataToProcess(objToSave);
		this.setNextToProcess(pdata);
	}
	

	/**
	 * @param dataToProcess the dataToProcess to set
	 */
	public void setDataToProcess(ISaveableObject dataToProcess) {
		this.dataToProcess = dataToProcess;
	}
 
    public void setNextToProcess(PersistDataChainHandler _pHandler) 
    {
    	pHandler = _pHandler;
    }
 
    /**
     * <p>
     *  Saves an object to the database.
     *  </p>
     * @param objectToSave
     */
    public void saveObject() 
    { 
    	if ( pHandler == null )
    	{//The only gateway to the database to save anything is right in these two lines.
    		TransactionHandler handler = new TransactionHandler();
    		handler.processInsertTransaction(this.getDataToProcess());
    	}
    	else
    	{
    		pHandler.saveObjectHandler (pHandler.getDataToProcess());
    	}
    }
    
    
	/**
	 * @return the dataToProcess
	 */
	public ISaveableObject getDataToProcess()
	{
		return dataToProcess;
	}
	
	
	/**
	 * @return the pHandler
	 */
	public PersistDataChainHandler getNextToProcess() {
		return pHandler;
	}

    abstract protected void saveObjectHandler(ISaveableObject object);
}


