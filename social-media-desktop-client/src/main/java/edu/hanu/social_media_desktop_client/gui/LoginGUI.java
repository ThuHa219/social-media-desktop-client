package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.ProfileService;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderPasswordField;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

public class LoginGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbLogin;
	private JLabel lbForgotPassword;
	private JLabel lbRegister;

	private PlaceHolderTextField textUserName;
	private PlaceHolderPasswordField textPassword;

	private JButton btnLogin;
	static String userName = "";

	public LoginGUI() {
		// TODO Auto-generated constructor stub
		super("Login Social Media Web");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
		this.dispose();
	}

	private void initPanels() {
		// TODO Auto-generated method stub

		lbLogin = new JLabel("LOGIN");
		lbLogin.setSize(100, 30);
		lbLogin.setLocation(170, 30);
		add(lbLogin);

		textUserName = new PlaceHolderTextField(30);
		textUserName.setPlaceholder("Username");
		textUserName.setSize(200, 30);
		textUserName.setLocation(100, 80);
		add(textUserName);

		textPassword = new PlaceHolderPasswordField(30);
		textPassword.setPlaceholder("Password");
		textPassword.setSize(200, 30);
		textPassword.setLocation(100, 130);
		add(textPassword);

		lbForgotPassword = new JLabel("Forgot Password?");
		lbForgotPassword.setSize(150, 30);
		lbForgotPassword.setLocation(150, 165);
		lbForgotPassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ForgotPasswordGUI forgotPasswordGUI = new ForgotPasswordGUI();
				forgotPasswordGUI.setVisible(true);
			}
		});
		add(lbForgotPassword);

		lbRegister = new JLabel("Register");
		lbRegister.setSize(150, 30);
		lbRegister.setLocation(180, 195);
		lbRegister.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				RegisterGUI registerGUI = new RegisterGUI();
				registerGUI.setVisible(true);
			}
		});
		add(lbRegister);

		btnLogin = new JButton("Login");
		btnLogin.setSize(100, 30);
		btnLogin.setLocation(150, 235);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "unused" })
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textUserName.getText().isEmpty() || textUserName.getText() == null
						|| textUserName.getText().equals("Username")) {
					JOptionPane.showMessageDialog(null, "Please input username");
				} else if (textPassword.getText().isEmpty() || textPassword.getText() == null
						|| textPassword.getText().equals("Password")) {
					JOptionPane.showMessageDialog(null, "Please input password");
				} else {
					ProfileService profileService = new ProfileService();
					userName = textUserName.getText();
					String password = textPassword.getText();
					if (profileService.checkAuthetication(userName, password)) {
						Profile profile = new Profile();
						profile = profileService.getProfile(userName);
						JOptionPane.showMessageDialog(null, "WELCOME " + userName);
						StatusListGUI homePageGUI = new StatusListGUI();
						homePageGUI.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "INVALID ACCOUNT. PLEASE TRY AGAIN");
					}
				}
			}

		});
		add(btnLogin);
	}

	public static void main(String[] args) {
		LoginGUI gui = new LoginGUI();
		gui.setVisible(true);
		System.out.println(userName);
	}
}
