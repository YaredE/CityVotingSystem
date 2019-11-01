package cevsDomainModel;

public class PollingStation implements ISaveableObject
{	
	/**
	 * <p>
	 * The id of the party.
	 * </p>
	 */
	private Integer stationID;
	/**
	 * <p>
	 * The name of the party.
	 * </p>
	 */
	private String name;
	
	/**
	 * <p>
	 *  The address of the location.
	 *  </p> 
	 */
	private Address location;
	
	/**
	 * <p>
	 * Disabled constructor.
	 * </p>
	 */
	@SuppressWarnings("unused")
	private PollingStation()
	{	
	}
	
	/***
	 * <p>
	 *  Constructor with parameters.
	 *  </p> 
	 * @param _id
	 * @param _name
	 * @param _location
	 */
	public PollingStation( Integer _id, String _name, Address _location )
	{	
		this.setStationID(_id);
		this.setName(_name);
		this.setLocation(_location);
	}
	
	/**
	 * @return the stationID
	 */
	public Integer getStationID() {
		return stationID;
	}

	/**
	 * @param stationID the stationID to set
	 */
	public void setStationID(Integer stationID) {
		this.stationID = stationID;
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
	 * @return the location
	 */
	public Address getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Address location) {
		this.location = location;
	}

	@Override
	public String values() 
	{
		String values = "( PPOLLINGSTA_ID, PNAME, PADDRESS_ID )  VALUES ("  + this.getStationID()+ ",'" +  this.getName() + 	"', "  + 
	    this.getLocation().getAddressID() + " );" ;
		return values;
	}

	@Override
	public String searchCriteria()
	{
		return " PPOLLINGSTA_ID = " + this.getStationID();
	}
}