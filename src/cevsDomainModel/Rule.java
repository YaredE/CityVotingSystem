package cevsDomainModel;

/**
 * <p>
 * Represents the Rule object.
 * </p>
 * @author Yared
 *
 */
public class Rule implements ISaveableObject
{

	/**
	 * <p>
	 * The name of the attribute.
	 * </p>
	 */
	private String attributeName;
	
	/**
	 * <p>
	 * Expected value of attribute.
	 * </p>
	 */
	private String attributeValue;
	
	
	/***
	 * <p>
	 * Operator Type
	 * </p>
	 */
	private Operator comparisonValue;
	
	 
 	/**
 	 * <p>
 	 * The name of the object.
 	 * </p>
 	 */
 	private String objectType;
 	
 	
 	/**
 	 * <p>
 	 * The rule ID.
 	 * </p>
 	 */
 	private Integer ruleID;
 	
 	
 	/**
	 * @return the ruleID
	 */
	public Integer getRuleID() {
		return ruleID;
	}

	/**
	 * @param ruleID the ruleID to set
	 */
	public void setRuleID(Integer ruleID) {
		this.ruleID = ruleID;
	}

	/**
 	 * <p>
 	 * Disabled constructor.
 	 * </p>
 	 */
 	@SuppressWarnings("unused")
	private Rule()
 	{	
 	}
 	
 	/**
 	 * <p>
 	 *  Constructor with valid parameters.
 	 *  </p>
 	 * @param _objectType
 	 * @param _attributeName
 	 * @param _attributeValue
 	 * @param _oper
 	 */
 	public Rule ( Integer _ruleID, String _objectType, String _attributeName, String _attributeValue , Operator _oper )
 	{	
 		this.setRuleID(_ruleID);
 		this.setObjectType(_objectType);
 		this.setAttributeName(_attributeName);
 		this.setAttributeValue(_attributeValue);
 		this.setComparisonValue(_oper);
 	}
 	
 	/**
 	 * @return the objectType
 	 */
 	public String getObjectType() {
 		return objectType;
 	}


 	/**
 	 * @param objectType the objectType to set
 	 */
 	public void setObjectType(String objectType) {
 		this.objectType = objectType;
 	}


 	/**
 	 * @return the attributeName
 	 */
 	public String getAttributeName() {
 		return attributeName;
 	}


 	/**
 	 * @param attributeName the attributeName to set
 	 */
 	public void setAttributeName(String attributeName) {
 		this.attributeName = attributeName;
 	}


 	/**
 	 * @return the attributeValue
 	 */
 	public String getAttributeValue() {
 		return attributeValue;
 	}


 	/**
 	 * @param attributeValue the attributeValue to set
 	 */
 	public void setAttributeValue(String attributeValue) {
 		this.attributeValue = attributeValue;
 	}


 	/**
 	 * @return the comparisonValue
 	 */
 	public Operator getComparisonValue() {
 		return comparisonValue;
 	}


 	/**
 	 * @param comparisonValue the comparisonValue to set
 	 */
 	public void setComparisonValue(Operator comparisonValue) {
 		this.comparisonValue = comparisonValue;
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
		String values = "( RRULE_ID, ROBJECTTYPE, RATTRIBUTEName, RATTRIBUTEVALUE, ROPERATION )  VALUES ("  + this.getRuleID() + ",'" +  this.getObjectType() + 
				"', '" + this.getAttributeName() + "' , '" + this.getAttributeValue() + "','" + this.getComparisonValue() + 	"')" ;
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
		return " RRULE_ID = " + this.getRuleID();
	}
}