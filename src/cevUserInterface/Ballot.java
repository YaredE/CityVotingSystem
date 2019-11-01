package cevUserInterface;
//Ballot
//private static final long serialVersionUID = 3558668331556164331L;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ballot extends JPanel 
{
	/**
	 * <p>
	 *  The controller.
	 *  </p> 
	 */
	private MainApplicationWindow mainAppWindow;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ballot(MainApplicationWindow _appWindow) 
	{
		setMainAppWindow(_appWindow);
		JLabel title = new JLabel("Click the \"Vote\" button once you have made your choices.", JLabel.CENTER);
		add(title);
		
		Hashtable<Integer, String> positions = UIToDataLayerBridge.getPositions();
	
		setLayout(new GridLayout(positions.size()+1, 2));
		add(new JLabel());
		
		Enumeration<Integer> posPairs = positions.keys();
		boolean isCandidate = true;
		while(posPairs.hasMoreElements())
		{
			Integer key = posPairs.nextElement();
			String postionName = positions.get(key);
			if ( postionName.contains("189"))
			{
				isCandidate = false;
			}
			JPanel choicePanel = createSimpleDialogBox(isCandidate,  postionName, key);
			choicePanel.setBorder(BorderFactory.createTitledBorder(this.getBorder()));
			add(choicePanel);
		 }


		final ArrayList<VotingChoice> choices = new ArrayList<VotingChoice>();
		
		JPanel panel = new JPanel();
		final JPanel parent = this;
		final JButton button = new JButton("Vote");
		button.setBounds(159, 5, 61, 23);
		button.setFont(new Font("Tahoma", Font.BOLD, 10));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) 
			{
				choices.clear();
				getVoterChoices (parent,  choices);
				String confirmationMessage = "";
				if ( choices.isEmpty() )
				{
					confirmationMessage = "You have not voted for anyone!";
					JOptionPane.showMessageDialog(getMainAppWindow(), confirmationMessage ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					confirmationMessage += "These are your choices \n";
					for ( int inx=0; inx < choices.size(); inx++ )
					{
						confirmationMessage += choices.get(inx).toString() + "\n";
					}
					confirmationMessage += "<html><font color=red>Do you want submit your vote now?</font></html>\n";
					int voterFinalDecision = JOptionPane.showConfirmDialog( getMainAppWindow(),	confirmationMessage,   CEVSGlobalL10Strings.CVES,   JOptionPane.YES_NO_OPTION);
					if ( voterFinalDecision == JOptionPane.YES_OPTION)
					{//The final decision is made record the vote.
						if ( getMainAppWindow().recordAVote ( choices ) )
						{
							confirmationMessage = " I Voted !";
							JOptionPane.showMessageDialog(getMainAppWindow(), confirmationMessage ,  CEVSGlobalL10Strings.CVES, JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}				
			}
		});
		panel.setLayout(null);
		panel.add(button);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(230, 5, 71, 23);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(btnCancel);
		add(panel);

	}

	private JPanel createSimpleDialogBox(boolean isCandidate, String title, Integer key)
	{
		JPanel voteChocicePanel = null;
		if (isCandidate)
		{
			voteChocicePanel = candidateVotingPanel(title, key);
		}
		else
		{
			voteChocicePanel = propositionPanel(title);
		}
		return voteChocicePanel;
	}

	private JPanel propositionPanel(String title) 
	{
		JPanel voteChocicePanel = null;
		ArrayList<String> arrayList =  CEVSGlobalL10Strings.getProposition();;
		JCheckBox[] radioButtons = new JCheckBox[arrayList.size()];
		final ButtonGroup group = new ButtonGroup();
		for ( int inx=0; inx < arrayList.size(); inx++ )
		{
			String nameDisplayed = "<html>Candidate " + (inx+1);
			if ( inx % 2 == 0 )
			{
				nameDisplayed +=": <font color=red>"+ arrayList.get(inx) + "</font></html>";
			}
			else if ( inx % 1 == 0 )
			{
				nameDisplayed +=": <font color=green>"+ arrayList.get(inx) + "</font></html>";
			}
			else
			{
				nameDisplayed +=": <font color=blue>"+ arrayList.get(inx) + "</font></html>";
			}
			radioButtons[inx] = new JCheckBox(nameDisplayed);
			String propositionChoiceName = arrayList.get(inx);
			radioButtons[inx].setActionCommand(propositionChoiceName);
			group.add(radioButtons[inx]);
		}
		voteChocicePanel = createPropositionPanel(title + ":",radioButtons);
		return voteChocicePanel;
	}

	private JPanel candidateVotingPanel(String title, Integer key)
	{
		JPanel voteChocicePanel = null;
		ArrayList<String> arrayList = UIToDataLayerBridge.getCandidates(key);
		VoteRadioButton[] radioButtons = new VoteRadioButton[arrayList.size()];
		final ButtonGroup group = new ButtonGroup();
		
		for ( int inx=0; inx < arrayList.size(); inx++ )
		{
			String nameDisplayed = "<html>Candidate " + (inx+1);
			if ( inx % 2 == 0 )
			{
				nameDisplayed +=": <font color=blue>"+ arrayList.get(inx) + "</font></html>";
			}
			else if ( inx % 3 == 1 )
			{
				nameDisplayed +=": <font color=green>"+ arrayList.get(inx) + "</font></html>";
			}
			else
			{
				nameDisplayed +=": <font color=red>"+ arrayList.get(inx) + "</font></html>";
			}
			radioButtons[inx] = new VoteRadioButton(title,nameDisplayed);
			String candidatedID =  arrayList.get(inx);
			radioButtons[inx].setActionCommand(candidatedID);
			group.add(radioButtons[inx]);
		}
		voteChocicePanel = createPane(title,radioButtons);
		return voteChocicePanel;
	}

	private JPanel createPane(String description, JRadioButton[] radioButtons) {
		int numChoices = radioButtons.length;
		JPanel box = new JPanel();
		JLabel label = new JLabel(description);

		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		box.add(label);

		for (int i = 0; i < numChoices; i++) {
			box.add(radioButtons[i]);
		}

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(box, BorderLayout.NORTH);
		return pane;
	}

	private JPanel createPropositionPanel(String description,
			JCheckBox[] radioButtons) {
		int numChoices = radioButtons.length;
		JPanel box = new JPanel();
		JLabel label = new JLabel(description);

		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		box.add(label);

		for (int i = 0; i < numChoices; i++) {
			box.add(radioButtons[i]);
		}
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(box, BorderLayout.NORTH);
		return pane;
	}

	/**
	 * <p>
	 *  Gets the voting choices made by this voter.
	 *  </p>
	 * @param container
	 * @param choices
	 */
	private void getVoterChoices(Container container, ArrayList<VotingChoice> choices)
	{
	    for (Component c : container.getComponents()) {
	        if (c instanceof VoteRadioButton) 
	        {
	        	VoteRadioButton btn = (VoteRadioButton)c;
	          if ( btn.isSelected() )
	          {
	        	  String command = btn.getActionCommand();
	        	  String position = btn.getPositionName();
	        	  choices.add(new VotingChoice(command,position));
	          }
	        }
	        else if (c instanceof JCheckBox) 
	        {
	        	  JCheckBox btn = (JCheckBox)c;
		          if ( btn.isSelected() )
		          {
		        	  String command = btn.getActionCommand();
		        	  choices.add(new VotingChoice(command,command));
		          }
		        }
	        else if (c instanceof Container)
	        {
	        	getVoterChoices((Container)c, choices);
	        }
	    }
	}

	public MainApplicationWindow getMainAppWindow() {
		return mainAppWindow;
	}

	public void setMainAppWindow(MainApplicationWindow mainAppWindow) {
		this.mainAppWindow = mainAppWindow;
	}
}