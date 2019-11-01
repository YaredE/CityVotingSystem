package cevUserInterface;

/**
 * <p>
 *  Represents an object a wrapper for voting choices.
 *  </p>
 * @author Yared
 *
 */
public class VotingChoice
{	
	/**
	 * @param choiceName
	 * @param positionName
	 */
	public VotingChoice(String choiceName, String positionName)
	{
		super();
		this.choiceName = choiceName;
		this.positionName = positionName;
	}


	/**
	 * <p>
	 *  The name of the choice ( Candidate name or proposition name )
	 *  </p>
	 */
	private String choiceName;
	
	
	/**
	 * <p>
	 *  The name of the position or the proposition.
	 */
	private String  positionName;
	
	/**
	 * @return the choiceName
	 */
	public String getChoiceName()
	{
		return choiceName;
	}


	/**
	 * @param choiceName the choiceName to set
	 */
	public void setChoiceName(String choiceName) {
		this.choiceName = choiceName;
	}


	/**
	 * @return the positionName
	 */
	public String getPositionName() {
		return positionName;
	}


	/**
	 * @param positionName the positionName to set
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "  [choiceName=" + this.getChoiceName() + ", positionName="
				+ this.getPositionName() + "]";
	}


}
