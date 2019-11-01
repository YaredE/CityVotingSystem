/**
 * 
 */
package cevUserInterface;

import javax.swing.JRadioButton;

/**
 * @author Yared
 *
 */
public class VoteRadioButton extends JRadioButton 
{
	
	/**
	 * <p>
	 *  Generated serial version.
	 *  </p>
	 */
	private static final long serialVersionUID = -7097900788828897256L;

	/**
	 * @param positionName
	 */
	public VoteRadioButton(String positionName, String displayName) {
		super(displayName);
		this.positionName = positionName;
	}

	/**
	 * <p>
	 * The position name.
	 * <p>
	 */
	private String positionName;

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

}
