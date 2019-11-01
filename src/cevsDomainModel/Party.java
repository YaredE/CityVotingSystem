package cevsDomainModel;

/**
 * <p>
 * Represents a Party Object.
 * </p>
 * @author Yared
 * 
 */
public class Party implements ISaveableObject{

	/**
	 * <p>
	 * The id of the party.
	 * </p>
	 */
	private Integer partyID;
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
	private Party() {
	}

	/**
	 * <p>
	 * Constructor with id and name.
	 * </p>
	 * 
	 * @param _id
	 * @param _name
	 */
	public Party(Integer _id, String _name) {
		this.partyID = _id;
		this.name = _name;
	}

	/**
	 * @return the partyID
	 */
	public Integer getPartyID() {
		return partyID;
	}

	/**
	 * @param partyID
	 *            the partyID to set
	 */
	public void setPartyID(Integer partyID) {
		this.partyID = partyID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	@Override
	public String values()
	{
		String values = "( PParty_ID, PNAME )  VALUES ("  + this.getPartyID() + ",'" +  this.getName() + "')" ;
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
		return " PNAME = '" + this.getName() + "'";
	}
}