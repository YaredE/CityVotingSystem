package cevUserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;


public class RegistrationForm extends JPanel  implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2449726970735019071L;
	

	private JTextField txtOtherParty;
	private JTextField txtStreetAddress;
	private JTextField txtAptNo;
	private JTextField txtCountry;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTextField txtDrivLic;
	private JTextField txtLastFourSSN;
	private JTextField txtEmailAddress;
	private JTextField txtPhone;
	private JTextField txtPlaceOfBirth;
	private JTextField txtSigniture;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JTextField txtSuffix;
	
	private JComboBox<String> cboPosition;
	private JComboBox<String> cboState;
	private JComboBox<String> cboGender;

	private JButton submitButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JPanel panel;


	private JPanel mainAppWinow;


	private JDateChooser dateDateOfBirth;


	private JRadioButton radioButtonDemo;


	private JRadioButton radioButtonRepo;


	private JRadioButton radioButtonLib;


	private JRadioButton radioButtonOther;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();


	/**
	 * Create the frame.
	 * @param <MainApplicationWindow>
	 */
	public RegistrationForm(JPanel _mainAppWinow, boolean isCandidate)
	{
		mainAppWinow = _mainAppWinow;
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 0, 941, 743);
		add(panel);
		JPanel panel_1 = new JPanel();
		if ( isCandidate )
		{		
			panel_1.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"),
					"POLITICAL PARTY AFFILIATION", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));

			radioButtonDemo = new JRadioButton("Democratic Party");
			buttonGroup.add(radioButtonDemo);
			radioButtonDemo.setFont(new Font("Tahoma", Font.BOLD, 14));

			radioButtonRepo = new JRadioButton("Republican Party");
			buttonGroup.add(radioButtonRepo);
			radioButtonRepo.setFont(new Font("Tahoma", Font.BOLD, 14));

			radioButtonLib = new JRadioButton("Libertarian");
			buttonGroup.add(radioButtonLib);
			radioButtonLib.setFont(new Font("Tahoma", Font.BOLD, 14));

			radioButtonOther = new JRadioButton("Other");
			buttonGroup.add(radioButtonOther);
			radioButtonOther.setFont(new Font("Tahoma", Font.BOLD, 14));

			txtOtherParty = new JTextField();
			txtOtherParty.setForeground(Color.BLUE);
			txtOtherParty.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtOtherParty.setColumns(10);
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1
					.setHorizontalGroup(gl_panel_1
							.createParallelGroup(Alignment.LEADING)
							.addGap(0, 790, Short.MAX_VALUE)
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addComponent(radioButtonDemo)
											.addPreferredGap(
													ComponentPlacement.UNRELATED)
											.addComponent(radioButtonRepo)
											.addPreferredGap(
													ComponentPlacement.UNRELATED)
											.addComponent(radioButtonLib)
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(radioButtonOther)
											.addGap(18)
											.addComponent(txtOtherParty,
													GroupLayout.PREFERRED_SIZE,
													238,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap(70,
													Short.MAX_VALUE)));
			gl_panel_1
					.setVerticalGroup(gl_panel_1
							.createParallelGroup(Alignment.LEADING)
							.addGap(0, 83, Short.MAX_VALUE)
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(25)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	radioButtonDemo)
															.addComponent(
																	radioButtonRepo)
															.addComponent(
																	radioButtonLib)
															.addComponent(
																	radioButtonOther)
															.addComponent(
																	txtOtherParty,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			panel_1.setLayout(gl_panel_1);
		}
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblRunningPositionoffice = new JLabel("Running Position (Office)");
		lblRunningPositionoffice.setFont(new Font("Tahoma", Font.BOLD, 14));
		if (isCandidate) 
		{
			Enumeration<Integer> posPairs = UIToDataLayerBridge.getPositions().keys();
			String positions [] = new String [UIToDataLayerBridge.getPositions().size()+1];
			int i = 1;
			positions [0] = "";
			while(posPairs.hasMoreElements())
			{
				String pos = UIToDataLayerBridge.getPositions().get(posPairs.nextElement());
				if ( pos.contains("189"))
				{
					continue;
				}
				positions[i] =  pos;
				i++;
			}
			cboPosition = new JComboBox<String>(positions);
			cboPosition.setFont(new Font("Tahoma", Font.BOLD, 12));
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel_2
							.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRunningPositionoffice)
							.addGap(18)
							.addComponent(cboPosition,
									GroupLayout.PREFERRED_SIZE, 255,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(462, Short.MAX_VALUE)));
			gl_panel_2
					.setVerticalGroup(gl_panel_2
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panel_2
											.createSequentialGroup()
											.addGap(5)
											.addGroup(
													gl_panel_2
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	lblRunningPositionoffice)
															.addComponent(
																	cboPosition,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))));
			panel_2.setLayout(gl_panel_2);
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaption));
		
		JLabel label_1 = new JLabel("Street Address where you live");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setForeground(Color.BLUE);
		txtStreetAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtStreetAddress.setColumns(10);
		
		JLabel label_2 = new JLabel("Apt/ Lot/ Unit No.");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAptNo = new JTextField();
		txtAptNo.setForeground(Color.BLUE);
		txtAptNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAptNo.setColumns(10);
		
		JLabel label_3 = new JLabel("County");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCountry = new JTextField();
		txtCountry.setForeground(Color.BLUE);
		txtCountry.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCountry.setColumns(10);
		
		JRadioButton rdBtnLivedYes = new JRadioButton("Yes");
		buttonGroup_1.add(rdBtnLivedYes);
		rdBtnLivedYes.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JRadioButton rdBtnLivedNo = new JRadioButton("No");
		buttonGroup_1.add(rdBtnLivedNo);
		rdBtnLivedNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_4 = new JLabel("Have you lived here for 30 days or more?");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCity = new JTextField();
		txtCity.setForeground(Color.BLUE);
		txtCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCity.setColumns(10);

		cboState = new JComboBox<String>(CEVSGlobalL10Strings.CEVS_UNITED_STATES);
		
		cboState.setForeground(Color.BLUE);
		cboState.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboState.setEditable(true);
		
		JLabel label_5 = new JLabel("City");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_6 = new JLabel("State");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtZip = new JTextField();
		txtZip.setForeground(Color.BLUE);
		txtZip.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtZip.setColumns(10);
		
		JLabel label_7 = new JLabel("Zip Code");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JDateChooser dtoDateOfMove = new JDateChooser();
		
		JLabel label_8 = new JLabel("If \"No,\" date moved?");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 790, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtStreetAddress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(txtAptNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(rdBtnLivedYes)
									.addGap(28)
									.addComponent(rdBtnLivedNo))
								.addComponent(label_4))))
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cboState, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_6)))
							.addGap(18)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(txtZip, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(label_7)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(dtoDateOfMove, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 121, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(64)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_1)
										.addComponent(label_2)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_6)
										.addComponent(label_7))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtStreetAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAptNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cboState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(64)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4)
										.addComponent(label_8))))
							.addGap(6)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(dtoDateOfMove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdBtnLivedYes)
									.addComponent(rdBtnLivedNo)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setAutoCreateGaps(true);
		gl_panel_3.setAutoCreateContainerGaps(true);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaption));
		
		txtDrivLic = new JTextField();
		txtDrivLic.setForeground(Color.BLUE);
		txtDrivLic.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDrivLic.setColumns(10);
		
		JLabel label_9 = new JLabel("Stated issued ID (Drivers license or State ID)");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_10 = new JLabel("Enter below the 4 Last Digit of your SSN");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtLastFourSSN = new JTextField();
		txtLastFourSSN.setForeground(Color.BLUE);
		txtLastFourSSN.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLastFourSSN.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 790, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtDrivLic, Alignment.LEADING)
						.addComponent(label_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_10)
						.addComponent(txtLastFourSSN, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 78, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDrivLic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLastFourSSN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaption));
		
		JLabel label_11 = new JLabel("Email Adress");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_12 = new JLabel("Gender");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cboGender = new JComboBox<String>(new String[]{"Male", "Female", "Other"});
		cboGender.setToolTipText("Year");
		cboGender.setForeground(Color.BLUE);
		cboGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboGender.setEditable(true);
		
		JLabel label_13 = new JLabel("Date of Birth");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		dateDateOfBirth = new JDateChooser();
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setForeground(Color.BLUE);
		txtEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmailAddress.setColumns(10);
		
		JLabel label_14 = new JLabel("Phone (Optional)");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtPhone = new JTextField();
		txtPhone.setForeground(Color.BLUE);
		txtPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPhone.setColumns(10);
		
		JLabel label_15 = new JLabel("State/ Country of Birth");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtPlaceOfBirth = new JTextField();
		txtPlaceOfBirth.setForeground(Color.BLUE);
		txtPlaceOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPlaceOfBirth.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 790, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(label_11)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(label_12)
							.addGap(18)
							.addComponent(cboGender, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateDateOfBirth, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmailAddress, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(label_14)
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(label_15)
							.addGap(18)
							.addComponent(txtPlaceOfBirth, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 81, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_15)
								.addComponent(txtPlaceOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(dateDateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_11)
							.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmailAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		int iHGap = 0;
		if ( isCandidate )
		{
			iHGap = 2;
			editorPane.setText(CEVSGlobalL10Strings.CEVS_CANDIDATE_WARNING_TEXT);
		}
		else
		{
			editorPane.setText(CEVSGlobalL10Strings.CEVS_VOTER_WARNING_TEXT);
		}
		editorPane.setFont(new Font("Arial Narrow", Font.BOLD, 10));
		editorPane.setBackground(SystemColor.scrollbar);
		
		JPanel panel_6 = new JPanel();
		
		JLabel label_16 = new JLabel("Electronic Signature (Type Your Full Name Here)");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSigniture = new JTextField();
		txtSigniture.setForeground(Color.BLUE);
		txtSigniture.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 18));
		txtSigniture.setColumns(10);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(this);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_16)
					.addGap(18)
					.addComponent(txtSigniture, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(363)
					.addComponent(submitButton)
					.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(93))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 94, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSigniture, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaption));
		
		txtLastName = new JTextField();
		txtLastName.setForeground(Color.BLUE);
		txtLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLastName.setColumns(10);
		
		JLabel label_17 = new JLabel("Last name or Surname");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFirstName = new JTextField();
		txtFirstName.setForeground(Color.BLUE);
		txtFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFirstName.setColumns(10);
		
		JLabel label_18 = new JLabel("First name");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtMiddleName = new JTextField();
		txtMiddleName.setForeground(Color.BLUE);
		txtMiddleName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMiddleName.setColumns(10);
		
		JLabel label_19 = new JLabel("Middle name");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_20 = new JLabel("Suffix(Jr,Sr, II,III)");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSuffix = new JTextField();
		txtSuffix.setForeground(Color.BLUE);
		txtSuffix.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSuffix.setColumns(10);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtLastName, Alignment.TRAILING)
						.addComponent(label_17, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtFirstName, Alignment.TRAILING)
						.addComponent(label_18, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(txtMiddleName, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_19))
					.addGap(36)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtSuffix, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
					.addGap(46))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_19)
						.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMiddleName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSuffix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 832, Short.MAX_VALUE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 832, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)))
					.addGap(18))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(iHGap)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
}
	

	
	void clearTextFields(Container container)
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
	public void actionPerformed(ActionEvent actionEvent) 
	{
		if (!actionEvent.getSource().equals(submitButton))
		{
			clearTextFields (mainAppWinow);
			return;
		}
		String errorMessage = "";
		String firstName="";
		String middleName = "";
		String lastName="";
		String suffix="";
		String placeOfBirth="";
		String lastFourSSN="";
		String streetAddress ="";
		String city="";
		@SuppressWarnings("unused")
		String phone = "";
		String emailAddress ="";
		@SuppressWarnings("unused")
		String signiture="";
		String position="";
		String drivLic="";
		String zip="";
		Date dateOfBirth = null;
		dateOfBirth = dateDateOfBirth.getDate();
		
		String partyName = "";
		if (radioButtonDemo != null && radioButtonDemo.isSelected() )
		{
			partyName = radioButtonDemo.getActionCommand();
		}
		if ( radioButtonRepo != null && radioButtonRepo.isSelected() )
		{
			partyName = radioButtonRepo.getActionCommand();
		}
		if ( radioButtonLib!= null && radioButtonLib.isSelected() )
		{
			partyName = radioButtonLib.getActionCommand();
		}
		if ( radioButtonOther != null && radioButtonOther.isSelected() )
		{
			partyName = "Other party";
			if ( !txtOtherParty.getText().isEmpty() )
			{
				partyName = this.txtOtherParty.getText();
			}
		}
		
		
		if ( txtFirstName.getText().isEmpty() )
		{
			errorMessage += ("First Name cannot be blank \n");
		}
		else
		{
			firstName = txtFirstName.getText();
		}
		if ( txtLastName.getText().isEmpty() )
		{
			errorMessage += ("Last Name cannot be blank \n");
		}
		else
		{
			lastName = txtLastName.getText();
		}
		if ( !txtMiddleName.getText().isEmpty() )
		{
			middleName = txtMiddleName.getText();
		}
		if ( !txtSuffix.getText().isEmpty() )
		{
			suffix = txtSuffix.getText();
		}
		if ( !txtPlaceOfBirth.getText().isEmpty() )
		{
			placeOfBirth = txtPlaceOfBirth.getText();
		}
		if ( !txtLastFourSSN.getText().isEmpty() )
		{
			lastFourSSN = txtLastFourSSN.getText();
		}
		if ( !txtDrivLic.getText().isEmpty() )
		{
			drivLic = txtDrivLic.getText();
		}
		if ( txtStreetAddress.getText().isEmpty() )
		{
			errorMessage += ("Street address cannot be blank \n");
		}
		else
		{
			streetAddress = txtStreetAddress.getText();
		}
		if ( !txtAptNo.getText().isEmpty() )
		{
			if ( streetAddress.isEmpty() )
			{
				errorMessage += ("You cannot have a blank street address \n");
			}
			else
			{
				streetAddress += txtAptNo.getText();
			}
		}
		if ( txtCity.getText().isEmpty() )
		{
			errorMessage += ("City cannot be empty.\n");
		}
		else
		{
			city = txtCity.getText();
		}
		if ( txtZip.getText().isEmpty() )
		{
			errorMessage += ("Zip cannot be empty.\n");
		}
		else
		{
			zip = txtZip.getText();
		}
		if ( txtCountry.getText().isEmpty() )
		{
			errorMessage += ("Country cannot be empty.\n");
		}
		if ( !txtPhone.getText().isEmpty() )
		{
			phone = txtPhone.getText();;
		}
		if ( !txtEmailAddress.getText().isEmpty() )
		{
			emailAddress = txtEmailAddress.getText();;
		}
		if ( !txtSigniture.getText().isEmpty() )
		{
			signiture = txtSigniture.getText();
		}
		if ( cboPosition != null  && cboPosition.isVisible() )
		{
			if ( cboPosition.getSelectedIndex() == 0 )
			{
				errorMessage += ("You must select office position for a candidate.\n");
			}
			else
			{
				if ( cboPosition.getSelectedItem() != null )
				{
					position = cboPosition.getSelectedItem().toString();
				}
			}
		}
		if ( !errorMessage.isEmpty() )
		{
			JOptionPane.showMessageDialog(mainAppWinow, errorMessage ,  CEVSGlobalL10Strings.CVES, JOptionPane.ERROR_MESSAGE);
			return;
		}
		else
		{
			if ( mainAppWinow != null )
			{
				Object obj = UIToDataLayerBridge.register( firstName,
														   middleName, lastName, suffix, dateOfBirth,
														   placeOfBirth, lastFourSSN, drivLic, emailAddress,
														   streetAddress, city, zip, position, partyName);
				
				JOptionPane.showMessageDialog(mainAppWinow, obj.toString() ,  CEVSGlobalL10Strings.CVES, JOptionPane.INFORMATION_MESSAGE);
				clearTextFields (mainAppWinow);
			}
		}
	}
}

