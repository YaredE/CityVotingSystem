/**
 * 
 */
package cevsDataAccessLayer;

import cevsDomainModel.ISaveableObject;

/**
 * @author Yared
 *
 */
public class BallotDataHandler extends PersistDataChainHandler {

	/**
	 * <p>
	 * 
	 * @param objToSave
	 * @param pdata
	 */
	public BallotDataHandler(ISaveableObject objToSave,
			PersistDataChainHandler pdata) {
		super(objToSave, pdata);
	}

	/* (non-Javadoc)
	 * @see cevsDataAccessLayer.PersistDataChainHandler#saveObjectHandler(cevsDataModel.ISaveableObject)
	 */
	@Override
	protected void saveObjectHandler(ISaveableObject object) 
	{// TODO Auto-generated method stub
	}

}
