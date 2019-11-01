package cevUserInterface;

import java.util.ArrayList;


public class CEVSGlobalL10Strings
{
	
	/**
	 * <p>
	 *  Registration Menu.
	 *  </p>
	 */
	public static final String CEVS_REGISTRATION = "Registration";


	public static final String CEVS_CANDIDATEREGISTRATION = "Candidate Registration";
	
	
	public static final String CEVS_VOTERREGISTRATION = "Voter Registration";
	
	public static final String CEVS_CANDIDATE_WARNING_TEXT = " I certify that I will be at least 18 years old on election day. I am a citizen of the United States. I will have resided in this State for 30 days immediately preceding election. I maintain residence at the address given on the registration form.I am not under court-ordered guardianship in which the court order revokes my right to be a candidate. I have not been found by a court to be legally incompetent to be a candidate. I have the right to vote because, if I have been convicted of a felony, my felony sentence has expired (been completed) or I have been discharged from my sentence. And I have read and understand this statement, that giving false information is a felony punishable by not more than 5 years imprisonment or a fine of not more than $10, 000, or both.";
	
	public static final String CEVS_VOTER_WARNING_TEXT = " I certify that I will be at least 18 years old on election day. I am a citizen of the United States. I will have resided in this State for 30 days immediately preceding election. I maintain residence at the address given on the registration form.I am not under court-ordered guardianship in which the court order revokes my right to vote. I have not been found by a court to be legally incompetent to vote. I have the right to vote because, if I have been convicted of a felony, my felony sentence has expired (been completed) or I have been discharged from my sentence. And I have read and understand this statement, that giving false information is a felony punishable by not more than 5 years imprisonment or a fine of not more than $10, 000, or both.";


	/**
	 * <p>
	 *  Vote Menu.
	 *  </p>
	 */
	public static final String CEVS_VOTE = "Vote";
	
	
	/**
	 * <p>
	 *   Voter 
	 */
	public static final String CEVS_VOTER_NOT_FOUND = "You have to register to vote.";
	
	public static final String CVES = "City Electronic Voting System(CEVS)";
	/**
	 * <p>
	 *  Main Menu String.
	 *  </p>
	 */
	public static String CEVS_MAIN_MENU = "City Electronic Voting System Main Menu";
	
	/**
	 * <p>
	 *  Menu action items available for selection.
	 * </p>
	 */
	public static String [] CEVS_UNITED_STATES = new String [] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
	
	
	/**
	 * <p>
	 *  Cancel button.
	 * </p>
	 */
	public static String CEVS_CANCEL_BUTTON = "Cancel";
	
	
	/**
	 * <p>
	 *  Submit - ok button.
	 *  </p>
	 */
	public static String CEVS_OK_BUTTON = "Submit";


	public static ArrayList<String> getProposition()
	{
		ArrayList<String> propositions = new ArrayList<String>();
		propositions.add("YES : Shut down the power plant.");
		propositions.add(" NO : Leave the power plant open.");
		return propositions;
	}
}
