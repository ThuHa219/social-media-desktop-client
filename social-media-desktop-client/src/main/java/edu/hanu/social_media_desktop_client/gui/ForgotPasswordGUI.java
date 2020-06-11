package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

public class ForgotPasswordGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lbForgotPassword;
	private JLabel lbSomething;
	private PlaceHolderTextField textUserName;
	private PlaceHolderTextField textAnswer;
	private JButton btnResetPassword;
	private JLabel lbBackToLogin;
	@SuppressWarnings("rawtypes")
	private JComboBox listQuestions;
	private JLabel lbSelectQuestion;

	public ForgotPasswordGUI() {
		super("Forgot Password");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initPanels() {
		// TODO Auto-generated method stub
		lbForgotPassword = new JLabel("Forgot Password?");
		lbForgotPassword.setSize(140, 30);
		lbForgotPassword.setLocation(135, 30);
		add(lbForgotPassword);

		lbSomething = new JLabel("Fill in the information below to reset your password! ");
		lbSomething.setSize(300, 30);
		lbSomething.setLocation(45, 70);
		add(lbSomething);

		textUserName = new PlaceHolderTextField(30);
		textUserName.setPlaceholder("User Name");
		textUserName.setSize(200, 30);
		textUserName.setLocation(95, 120);
		add(textUserName);

		lbSelectQuestion = new JLabel("Please select one of those question below.");
		lbSelectQuestion.setSize(250, 30);
		lbSelectQuestion.setLocation(65, 150);
		add(lbSelectQuestion);
		
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
		listQuestions.setLocation(40, 185);
		add(listQuestions);

		textAnswer = new PlaceHolderTextField(30);
		textAnswer.setPlaceholder("Answer");
		textAnswer.setSize(200, 30);
		textAnswer.setLocation(95, 240);
		add(textAnswer);

		btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setSize(160, 30);
		btnResetPassword.setLocation(115, 290);
		add(btnResetPassword);

		lbBackToLogin = new JLabel("Back to Login");
		lbBackToLogin.setSize(160, 30);
		lbBackToLogin.setLocation(155, 330);
		lbBackToLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
			}
		});
		add(lbBackToLogin);
	}

	public static void main(String[] args) {
		ForgotPasswordGUI forgotPasswordGUI = new ForgotPasswordGUI();
		forgotPasswordGUI.setVisible(true);
	}
}
