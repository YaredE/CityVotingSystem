package cevsDomainModel;

public class CandidateRule extends Rule 
{
	/**
	 * <p>
	 * Represents the candidate rule ID.
	 * <p>
	 */
	private Integer candidateRuleID;
	
	/**
	 * <p>
	 * Constructor With parameters.
	 * </p>
	 * @param _ruleID
	 * @param _objectType
	 * @param _attributeName
	 * @param _attributeValue
	 * @param _oper
	 */
	public CandidateRule(Integer _cID, Integer _ruleID, String _objectType,
			String _attributeName, String _attributeValue, Operator _oper) {
		super(_ruleID, _objectType, _attributeName, _attributeValue, _oper);
		this.setCandidateRuleID (_cID);
	}

	/**
	 * @return the candidateRuleID
	 */
	public Integer getCandidateRuleID() {
		return candidateRuleID;
	}

	/**
	 * @param candidateRuleID the candidateRuleID to set
	 */
	public void setCandidateRuleID(Integer candidateRuleID) {
		this.candidateRuleID = candidateRuleID;
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
		String values = "( CCANDIDATERULE_ID, CRULE_ID )  VALUES ("  + this.getCandidateRuleID() + "," +  this.getRuleID() + ")" ;
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
		return " CCANDIDATERULE_ID = " + this.getCandidateRuleID();
	}
	
	
}