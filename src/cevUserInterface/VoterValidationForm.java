package cevUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VoterValidationForm extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtVoterField;
	private JButton okButton;
	private JButton cancelButton;
	private static boolean status;
	
	private MainApplicationWindow mainAppWindow;
	

	

	public VoterValidationForm( MainApplicationWindow  _window)
	{
		mainAppWindow = _window;
		setBounds(100, 100, 536, 340);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel.setBackground(SystemColor.controlHighlight);
			contentPanel.add(panel);
			JLabel lblBoter = new JLabel("Enter your VoterID");
			lblBoter.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			JLabel lblLogin = new JLabel("Voter Validation Form");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			JSeparator separator = new JSeparator();
			
			txtVoterField = new JTextField();
			txtVoterField.setColumns(10);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblBoter, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtVoterField)
								.addGap(20))))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblLogin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblBoter)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtVoterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(84))
			);
			gl_panel.setHonorsVisibility(false);
			panel.setLayout(gl_panel);
		}

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		okButton.addActionListener( this );

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener( this);
		buttonPane.add(cancelButton);
	}

	public boolean getLoginStatus()
	{
		return status;
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource().equals(okButton))
		{
			if ( mainAppWindow != null )
			{
				String voterID = txtVoterField.getText();
				if ( voterID.isEmpty() )
				{
					JOptionPane.showMessageDialog(mainAppWindow, "Enter Voter ID\n" ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if (!mainAppWindow.authenticateVoter (voterID) )
					{
						JOptionPane.showMessageDialog(mainAppWindow, "Invalid  VoterID or VoterID does not exist.\n" ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						mainAppWindow.updateUsingThisForm(new Ballot(mainAppWindow));
					}
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(mainAppWindow, e.getLocalizedMessage() ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if (event.getSource().equals(cancelButton))
		{
			txtVoterField.setText("");
		}
	}
}
