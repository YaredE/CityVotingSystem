package cevUserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;


public class MainApplicationWindow  extends JPanel implements ItemListener  
{
    
    /**
	 * <p>
	 * serialVersionUID
	 * </p>
	 */
	private static final long serialVersionUID = -6125233850550688065L;


   
	/**
	 * <p>
	 *  The form panel currently in use.
	 *  </p>
	 */
	private JPanel formPanel;

	
	/**
	 * <p>
	 * The Vote button.
	 * </p>
	 */
	private JRadioButton rdbtnVote;


	/**
	 * <p>
	 * The login button.
	 * </p>
	 */
	private JRadioButton rdbtnLogin;


	/**
	 * <p>
	 * The candidate button.
	 * </p>
	 */
	private JRadioButton rdbtnCandidate;


	/**
	 * <p>
	 * The vote button.
	 * </p>
	 */
	private JRadioButton rdbtnVoter;


	/**
	 * <p>
	 * The pane where everything is added.
	 * </p>
	 */
	private JSplitPane splitPane;
	
	
	/**
	 * <p>
	 * Tracks if a voter is authenticated or not.
	 * </p>
	 */
	private boolean isVoterAuthenticated;
	
	
	/**
	 * <p>
	 *  Holds the voter ID.
	 *  </p>
	 */
	private String voterID;
	
	
	/**
	 * <p>
	 * Holds if user is an admin or not.
	 * </p>
	 */
	private boolean isUserAdmin = false;



	/**
	 * <p>
	 * Currently selected action.
	 * </p>
	 */
	private JRadioButton currentSelection = null;



 
    /**
	 * @return the isUserAdmin
	 */
	public boolean isUserAdmin() {
		return isUserAdmin;
	}

	public MainApplicationWindow() 
    {
        super(new BorderLayout());
        //These is where all the needed ( necessary ) initialization of system is done.
        UIToDataLayerBridge.initializeSystem();
        setBorder(new TitledBorder(null, "City Electronic Voting System", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaption));
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        add(splitPane, BorderLayout.CENTER);
        
        ButtonGroup buttonGroupRadio = new ButtonGroup();
 
        JPanel topHalf = new JPanel();
        JPanel listContainer = new JPanel(new GridLayout(1,1));
        listContainer.setBorder(BorderFactory.createTitledBorder("List"));

        topHalf.setMinimumSize(new Dimension(850, 50));
        topHalf.setPreferredSize(new Dimension(850, 50));
        splitPane.add(topHalf);
        
        rdbtnVote = new JRadioButton("Vote");
        rdbtnVote.setSelected(true);
        rdbtnVote.setBounds(49, 5, 63, 29);
        rdbtnVote.setFont(new Font("Tahoma", Font.BOLD, 16));
        rdbtnVote.addItemListener(this);
        topHalf.setLayout(null);
        buttonGroupRadio.add(rdbtnVote);
        topHalf.add(rdbtnVote);
        
        rdbtnLogin = new JRadioButton("Adminstration Login");
        rdbtnLogin.setBounds(141, 5, 191, 29);
        rdbtnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
        rdbtnLogin.addItemListener(this);
        buttonGroupRadio.add(rdbtnLogin);
        topHalf.add(rdbtnLogin);
        
        rdbtnCandidate = new JRadioButton("Register Candidate");
        rdbtnCandidate.setBounds(351, 5, 183, 29);
        rdbtnCandidate.setFont(new Font("Tahoma", Font.BOLD, 16));
        rdbtnCandidate.addItemListener(this);
        buttonGroupRadio.add(rdbtnCandidate);
        topHalf.add(rdbtnCandidate);
        
        rdbtnVoter = new JRadioButton("Register Voter");
        rdbtnVoter.setBounds(580, 5, 145, 29);
        rdbtnVoter.setFont(new Font("Tahoma", Font.BOLD, 16));
        rdbtnVoter.addItemListener(this);
        buttonGroupRadio.add(rdbtnVoter);
        topHalf.add(rdbtnVoter);
        formPanel = new VoterValidationForm( this );
        formPanel.setPreferredSize(new Dimension(750, 950));
        splitPane.add(formPanel);
        setVoterAuthenticated ( false );
        
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() 
    {
        JFrame frame = new JFrame("CEVS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new MainApplicationWindow();
        newContentPane.setOpaque(true);  
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setSize(1000, 900);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    /**
     * <p>
     *  Checks if a voter is authenticated or not.
     *  </p>
     * @return
     */
	public boolean isVoterAuthenticated() {
		return isVoterAuthenticated;
	}

	/**
	 * <p>
	 * Sets if a voter is authenticated or not.
	 * </p>
	 * @param isVoterAuthenticated
	 */
	public void setVoterAuthenticated(boolean isVoterAuthenticated) {
		this.isVoterAuthenticated = isVoterAuthenticated;
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent itemEvent)
	{
		if (itemEvent.getSource() instanceof JRadioButton)
		{
			JRadioButton instanceRadio = (JRadioButton) itemEvent.getSource();
			String _name = instanceRadio.getText();
			currentSelection = instanceRadio;
			boolean comparison = _name.compareToIgnoreCase("Vote") == 0 ;
			if ( isVoterAuthenticated() && comparison ) 
			{
				updateUsingThisForm(new Ballot(this));
			} else {
				if ( comparison )
				{
					updateUsingThisForm( new VoterValidationForm( this ));
				}
				else if ( instanceRadio.equals(rdbtnVoter))
				{
					if (isUserAdmin())
					{
						updateUsingThisForm( new RegistrationForm( this, false ));
					}
					else
					{
						updateUsingThisForm( new AdminstrationLogin( this ));
					}
				}
				else if ( instanceRadio.equals(rdbtnLogin))
				{
					updateUsingThisForm( new AdminstrationLogin( this ));
				}
				else if ( instanceRadio.equals(rdbtnCandidate))
				{
					if ( isUserAdmin())
					{
						updateUsingThisForm( new RegistrationForm( this, true ));
					}
					else
					{
						updateUsingThisForm( new AdminstrationLogin( this ));
					}
				}
			}
		}
	}

	public void updateUsingThisForm(JPanel _formPanel) 
	{
		try
		{
			splitPane.remove(formPanel);
			formPanel = _formPanel;
			splitPane.add(formPanel);
			formPanel.revalidate();
			formPanel.repaint();
			formPanel.setVisible(true);
		}
		catch ( Exception ex )
		{
			ex.printStackTrace();
		}
	}
 
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

 

	public boolean authenticateVoter(String _voterID) throws Exception
	{
		this.setVoterID(_voterID);
		return UIToDataLayerBridge.authenticateVoter(_voterID);
		
	}

	public boolean authenticateUser(String userID, String password) 
	{	
		isUserAdmin = UIToDataLayerBridge.authenticateUser(userID, password );
		return isUserAdmin;
	}
	/**
	 * <p>
	 *   Record the vote using the Bridge.
	 *  <p>
	 * @param choices
	 */
	public boolean recordAVote(ArrayList<VotingChoice> choices) 
	{
		 return UIToDataLayerBridge.recordVoterChoices(getVoterID(),choices);
	}

	/**
	 * @return the voterID
	 */
	public String getVoterID() {
		return voterID;
	}

	/**
	 * @param voterID the voterID to set
	 */
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	
	
	public JRadioButton getCurrentSelection()
	{
		return currentSelection ;
	}
 }

