package cevsDomainModel;

import java.util.Date;

public class User extends Person
{
	/**
	 * <p>
	 * The user Id.
	 * </p>
	 */
	private String userId;
	
	
	/**
	 * <p>
	 * Password associated with a user.
	 * </p>
	 */
	private String password;
	
	/**
	 * <p>
	 * The user level
	 * </p>
	 */
	private Integer userLevel;

	/**
	 * <p>
	 *  Constructs Person object.
	 * </p>
	 * @param _id
	 * @param _firstName
	 * @param _lastName
	 * @param _dateOfBirth
	 * @param _address
	 */
	public User(String _userID,  String _password, Integer _userLevel, Integer _id, String _firstName, String _lastName,
			Date _dateOfBirth, Address _address) {
		super(_id, _firstName, _lastName, _dateOfBirth, _address);
		this.setUserId(_userID);
		this.setUserLevel(_userLevel);
		this.setPassword(_password);
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userLevel
	 */
	public Integer getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel the userLevel to set
	 */
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
		String values = "( VVUSER_ID, VUSER_LEVEL, VPASSWORD, VPERSON_ID )  VALUES ('"  + this.getUserId() + "'," +  this.getUserLevel() +
				",'" + this.getPassword()+ "'," +    this.getPersonID() + ");";
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
		return " VVUSER_ID = '" + this.getUserId() + "'  AND  VPASSWORD = '" + this.getPassword() + "';";
	}
}