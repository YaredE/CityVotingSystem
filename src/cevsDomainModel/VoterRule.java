package cevsDomainModel;

public class VoterRule extends Rule
{

	/**
	 * <p>
	 * Represents the voter rule ID.
	 * </p>
	 */
	private Integer voterRuleUID;
	
	/**
	 * <p>
	 * Constructor with parameters.
	 * </p>
	 * @param _ruleID
	 * @param _objectType
	 * @param _attributeName
	 * @param _attributeValue
	 * @param _oper
	 */
	public VoterRule(Integer _vRuleID, Integer _ruleID, String _objectType,
			String _attributeName, String _attributeValue, Operator _oper)
	{
		super(_ruleID, _objectType, _attributeName, _attributeValue, _oper);
		this.setVoterRuleUID ( _vRuleID );
	}

	/**
	 * @return the voterRuleUID
	 */
	public Integer getVoterRuleUID() {
		return voterRuleUID;
	}

	/**
	 * @param voterRuleUID the voterRuleUID to set
	 */
	public void setVoterRuleUID(Integer voterRuleUID) {
		this.voterRuleUID = voterRuleUID;
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
		String values = "( VVOTERRULE_ID, VRULE_ID )  VALUES ("  + this.getVoterRuleUID() + "," +  this.getRuleID() + ")" ;
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
		return " VVOTERRULE_ID = " + this.getVoterRuleUID();
	}
	
}