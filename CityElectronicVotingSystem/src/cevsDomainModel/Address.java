package cevsDomainModel;

public class Address implements ISaveableObject
{
	
	/**
	 * <p>
	 * The id of the party.
	 * </p>
	 */
	private Integer addressID;
	
	/**
	 * <p>
	 *  The street address.
	 * </p>
	 */
	private String streetAddress;
	
	/**
	 * <p>
	 * The city.
	 * </p>
	 */
	private String city;
	
	/**
	 * <p>
	 * The zip
	 * </p>
	 */
	private String zip;
	
	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	
	/**
	 * <p>
	 * Disabled default constructor.
	 * </p>
	 */
	@SuppressWarnings("unused")
	private Address ()
	{	
	}
	
	/**
	 * 
	 * @param _street
	 * @param _city
	 * @param _zip
	 */
	public Address ( Integer _aID, String _street, String _city, String _zip )
	{
		this.setAddressID (_aID);
		this.setStreetAddress(_street);
		this.setCity(_city);
		this.setZip(_zip);
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * @return the addressID
	 */
	public Integer getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	/**
	 * <p>
	 *  Values to be added.
	 * </p>
	 * @return
	 */
	public String values()
	{
		String values = "( AADDRESS_ID, ASTREET,ACITY, AZIP )  VALUES ("
				+ this.getAddressID() + ",'" + this.getStreetAddress() + "'"
				+ ", '" + this.getCity() + "', '" + this.getZip() + "');";
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
		return " ASTREET = '" + this.getStreetAddress() + "'";
	}	
	
}