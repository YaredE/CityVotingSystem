package cevsDomainModel;

/**
 * <p>
 *  Interface to enable object to be persisted in and searched from the database .
 *  </p>
 * @author Yared
 *
 */
public interface ISaveableObject 
{
	public String values();
	
	public String searchCriteria();	
}
