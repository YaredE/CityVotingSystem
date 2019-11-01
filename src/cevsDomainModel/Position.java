package cevsDomainModel;

/**
 * <p>
 * Represents the position a candidate is running for.
 * </p>
 * @author Yared
 *
 */
public class Position implements ISaveableObject
{
	/**
	 * <p>
	 * The id of the party.
	 * </p>
	 */
	private Integer positionID;
	/**
	 * <p>
	 * The name of the party.
	 * </p>
	 */
	private String name;
	
	
	/**
	 * <p>
	 * Disabled constructor.
	 * </p>
	 */
	@SuppressWarnings("unused")
	private Position() {
	}

	/**
	 * <p>
	 * Constructor with id and name.
	 * </p>
	 * 
	 * @param _id
	 * @param _name
	 */
	public Position(Integer _id, String _name) {
		this.setPositionID(_id);
		this.setName(_name);
	}
	
	
	/**
	 * @return the positionID
	 */
	public Integer getPositionID() {
		return positionID;
	}
	/**
	 * @param positionID the positionID to set
	 */
	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <p>
	 *  Values to be added.
	 * </p>
	 * @return
	 */
	public String values()
	{
		String values = "( PPOSITION_ID, PNAME )  VALUES ("  + this.getPositionID() + ",'" +  this.getName() + "')" ;
		return values;
	}

	/***
	 * <p>
	 * Search will be made using this info.
	 * </p>
	 */
	@Override
	public String searchCriteria() 
	{
		return " PNAME LIKE '" + this.getName() + "'";
	}

}