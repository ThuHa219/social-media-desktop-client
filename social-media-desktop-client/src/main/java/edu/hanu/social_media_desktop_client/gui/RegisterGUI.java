package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.hanu.social_media_desktop_client.model.FriendList;
import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.FriendListService;
import edu.hanu.social_media_desktop_client.service.ProfileService;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderPasswordField;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;
import edu.hanu.social_media_desktop_client.utils.Validator;

public class RegisterGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbCreateAccount;
	private PlaceHolderTextField textFirstName;
	private PlaceHolderTextField textLastName;
	private PlaceHolderTextField textUserName;
	private PlaceHolderTextField textAddress;
	private PlaceHolderTextField textEmail;
	private PlaceHolderTextField textPhoneNumber;
	private PlaceHolderPasswordField textPassword;
	private PlaceHolderPasswordField textConfirmPassword;
	private PlaceHolderTextField textAnswer;
	private JLabel lbLogin;
	private JLabel lbHavingAccount;
	private JButton btnRegister;
	private JLabel lbSelectQuestion;
	@SuppressWarnings("rawtypes")
	private JComboBox listQuestions;

	ProfileService profileService = new ProfileService();

	public RegisterGUI() {
		// TODO Auto-generated constructor stub
		super("Register");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initPanels() {
		// TODO Auto-generated method stub
		lbCreateAccount = new JLabel("Create Account");
		lbCreateAccount.setSize(100, 30);
		lbCreateAccount.setLocation(155, 30);
		add(lbCreateAccount);

		textFirstName = new PlaceHolderTextField(30);
		textFirstName.setPlaceholder("First Name");
		textFirstName.setSize(150, 30);
		textFirstName.setLocation(20, 100);
		add(textFirstName);

		textLastName = new PlaceHolderTextField(30);
		textLastName.setPlaceholder("Last Name");
		textLastName.setSize(150, 30);
		textLastName.setLocation(20, 150);
		add(textLastName);

		textUserName = new PlaceHolderTextField(30);
		textUserName.setPlaceholder("UserName");
		textUserName.setSize(150, 30);
		textUserName.setLocation(20, 200);
		add(textUserName);

		textAddress = new PlaceHolderTextField(30);
		textAddress.setPlaceholder("Address");
		textAddress.setSize(150, 30);
		textAddress.setLocation(20, 250);
		add(textAddress);

		textEmail = new PlaceHolderTextField(30);
		textEmail.setPlaceholder("Email");
		textEmail.setSize(150, 30);
		textEmail.setLocation(215, 250);
		add(textEmail);

		textPhoneNumber = new PlaceHolderTextField(30);
		textPhoneNumber.setPlaceholder("Phone Number");
		textPhoneNumber.setSize(150, 30);
		textPhoneNumber.setLocation(215, 100);
		add(textPhoneNumber);

		textPassword = new PlaceHolderPasswordField(30);
		textPassword.setPlaceholder("Password");
		textPassword.setSize(150, 30);
		textPassword.setLocation(215, 150);
		add(textPassword);

		textConfirmPassword = new PlaceHolderPasswordField(30);
		textConfirmPassword.setPlaceholder("Password");
		textConfirmPassword.setSize(150, 30);
		textConfirmPassword.setLocation(215, 200);
		add(textConfirmPassword);

		textAnswer = new PlaceHolderTextField(30);
		textAnswer.setPlaceholder("Answer");
		textAnswer.setSize(200, 30);
		textAnswer.setLocation(90, 380);
		add(textAnswer);

		lbHavingAccount = new JLabel("Already having an account?");
		lbHavingAccount.setSize(200, 30);
		lbHavingAccount.setLocation(80, 420);
		add(lbHavingAccount);

		lbLogin = new JLabel("Login");
		lbLogin.setSize(100, 30);
		lbLogin.setLocation(240, 420);
		lbLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
			}
		});
		add(lbLogin);

		btnRegister = new JButton("Register");
		btnRegister.setSize(100, 30);
		btnRegister.setLocation(155, 470);
		btnRegister.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Check " + profileService.getProfile(textUserName.getText()).toString());
				if (textFirstName.getText().isEmpty() || textFirstName.getText().equals("First Name")
						|| textFirstName.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your first name.");
				} else if (textLastName.getText().isEmpty() || textLastName.getText().equals("Last Name")
						|| textLastName.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your last name.");
				} else if (textUserName.getText().isEmpty() || textUserName.getText().equals("UserName")
						|| textUserName.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your user name.");
				} else if (textAddress.getText().isEmpty() || textAddress.getText().equals("Address")
						|| textAddress.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your address.");
				} else if (textPhoneNumber.getText().isEmpty() || textPhoneNumber.getText().equals("Phone Number")
						|| textPhoneNumber.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your phone number.");
				} else if (textPassword.getText().isEmpty() || textPassword.getText().equals("Password")
						|| textPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your password.");
				} else if (textConfirmPassword.getText().isEmpty() || textConfirmPassword.getText().equals("Password")
						|| textConfirmPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please confirm your password.");
				} else if (textEmail.getText().isEmpty() || textEmail.getText().equals("Email")
						|| textEmail.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your email.");
				} else if (textAnswer.getText().isEmpty() || textAnswer.getText().equals("Answer")
						|| textAnswer.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your answer.");
				} else {
					if (!Validator.isStringNumeric(textPhoneNumber.getText())) {
						JOptionPane.showMessageDialog(null, "INVALID PHONE NUMBER.");
					} else if (!Validator.isValidEmail(textEmail.getText())) {
						JOptionPane.showMessageDialog(null, "INVALID EMAIL.");
					} else if (!Validator.isValidatePassword(textPassword.getText())) {
						JOptionPane.showMessageDialog(null,
								"INVALID PASSWORD. \nPassword must be above 8 characters, \ncontain at least one uppercase, one number, \nand one special character !");
					} else if (!textPassword.getText().equals(textConfirmPassword.getText())) {
						JOptionPane.showMessageDialog(null, "PASSWORD DOES NOT MATCH.");
					} else if (profileService.getProfile(textUserName.getText()).getCreated() != null) {
						JOptionPane.showMessageDialog(null, "USER NAME ALREADY EXISTS.");
					} else {
						Profile profile = new Profile();
						profile.setFirstName(textFirstName.getText());
						profile.setLastName(textLastName.getText());
						profile.setProfileName(textUserName.getText());
						profile.setAddress(textAddress.getText());
						profile.setPhoneNumber(textPhoneNumber.getText());
						profile.setPassword(textPassword.getText());
						profile.setEmail(textEmail.getText());
						profile.setQuestion((String) listQuestions.getSelectedItem());
						profile.setAnswer(textAnswer.getText());
						profileService.addProfile(profile);
						LoginGUI loginGUI = new LoginGUI();
						loginGUI.setVisible(true);

					}
				}
			}
		});
		add(btnRegister);

		String questions[] = { "What is your favorite book?", "What is your nickname?", "What is your favorite food?",
				"What is your pet's name?", "What kinds of instrument do you know how to play?" };
		listQuestions = new JComboBox(questions);
		listQuestions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == listQuestions) {
					System.out.println(listQuestions.getSelectedItem() + "selected");
				}
			}
		});
		listQuestions.setSize(300, 30);
		listQuestions.setLocation(35, 340);
		add(listQuestions);

		lbSelectQuestion = new JLabel("Please select one of those question below.");
		lbSelectQuestion.setSize(250, 30);
		lbSelectQuestion.setLocation(65, 300);
		add(lbSelectQuestion);
	}

	public static void main(String[] args) {
		RegisterGUI registerGUI = new RegisterGUI();
		registerGUI.setVisible(true);
	}
}
