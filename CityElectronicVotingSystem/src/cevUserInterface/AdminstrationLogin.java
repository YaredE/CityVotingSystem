package cevUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class AdminstrationLogin extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Object> cboUserLevel;
	private JPasswordField passwordField;
	private JTextField textField;
	
	private MainApplicationWindow mainApplicationWindow;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 * @param mainApplicationWindow 
	 * @param actionController 
	 */
	public AdminstrationLogin(MainApplicationWindow _mainApplicationWindow) 
	{
		mainApplicationWindow = _mainApplicationWindow;
		setBounds(100, 100, 536, 340);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel.setBackground(SystemColor.controlHighlight);
			contentPanel.add(panel);
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cboUserLevel = new JComboBox<Object>();
			cboUserLevel.setModel(new DefaultComboBoxModel<Object>(new String[] {"Please select or type...", "User", "Administrator"}));
			cboUserLevel.setSelectedIndex(0);
			cboUserLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cboUserLevel.setEditable(true);
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblLogin = new JLabel("Adminstration Login");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			JSeparator separator = new JSeparator();
			
			textField = new JTextField();
			textField.setColumns(10);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(cboUserLevel, 0, 225, Short.MAX_VALUE))))
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblLogin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(cboUserLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsername)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPassword))
						.addGap(20))
			);
			gl_panel.setHonorsVisibility(false);
			panel.setLayout(gl_panel);
		}

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		okButton.addActionListener(this);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(this);
		buttonPane.add(cancelButton);
	}
	
	private void clearTextFields(Container container)
	{
	    for (Component c : container.getComponents()) {
	        if (c instanceof JTextField) {
	           ((JTextField)c).setText("");
	        } else
	        if (c instanceof Container) {
	           clearTextFields((Container)c);
	        }
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(cancelButton))
		{
			clearTextFields (this);
			return;
		}
		
		String userID = textField.getText();
		@SuppressWarnings("deprecation")
		String passWord = passwordField.getText();
		if ( userID.isEmpty() )
		{
			String errorMessage = "UserID cannot be blank\n";
			if ( passWord.isEmpty() )
			{
				errorMessage += "Password cannot be empty!";
			}
			JOptionPane.showMessageDialog(mainApplicationWindow, errorMessage ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
			return;
			
		}
		if ( mainApplicationWindow != null )
		{
			boolean isUserValid = mainApplicationWindow.authenticateUser(userID, passWord);
			if (!isUserValid)
			{
				JOptionPane.showMessageDialog(mainApplicationWindow, "UserID-Password combination is wrong\n" ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(mainApplicationWindow, "You are now logged in as an adminstrator.\n" ,  CEVSGlobalL10Strings.CVES, JOptionPane.INFORMATION_MESSAGE);
				if ( mainApplicationWindow.getCurrentSelection() != null )
				{
					if(mainApplicationWindow.getCurrentSelection().getText().contains("Vote"))
					{
						mainApplicationWindow.updateUsingThisForm( new RegistrationForm( mainApplicationWindow, false ));
					}
					else if(mainApplicationWindow.getCurrentSelection().getText().contains("Candidate"))
					{
						mainApplicationWindow.updateUsingThisForm( new RegistrationForm( mainApplicationWindow, true ));
					}
				}
			}
		}	
	}
}
