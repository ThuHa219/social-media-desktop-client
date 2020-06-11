package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.hanu.social_media_desktop_client.utils.PlaceHolderPasswordField;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

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
