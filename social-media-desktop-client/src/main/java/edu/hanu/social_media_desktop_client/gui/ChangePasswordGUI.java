package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.hanu.social_media_desktop_client.utils.PlaceHolderPasswordField;

public class ChangePasswordGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8158082688694076948L;
	private JLabel lbChangePassword;
	private JLabel lbPassword;
	private JLabel lbConfirmPassword;
	private PlaceHolderPasswordField textPassword;
	private PlaceHolderPasswordField textConfirmPassword;
	private JButton btnSave;
	private JLabel lbBackToLogin;

	public ChangePasswordGUI() {
		super("Change Password");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
	}

	private void initPanels() {
		lbChangePassword = new JLabel("Change Password");
		lbChangePassword.setSize(200, 30);
		lbChangePassword.setLocation(140, 50);
		add(lbChangePassword);

		lbPassword = new JLabel("Password: ");
		lbPassword.setSize(100, 30);
		lbPassword.setLocation(20, 100);
		add(lbPassword);

		textPassword = new PlaceHolderPasswordField(30);
		textPassword.setPlaceholder("Password");
		textPassword.setSize(200, 30);
		textPassword.setLocation(140, 100);
		add(textPassword);

		lbConfirmPassword = new JLabel("Confirm Password: ");
		lbConfirmPassword.setSize(120, 30);
		lbConfirmPassword.setLocation(20, 150);
		add(lbConfirmPassword);

		textConfirmPassword = new PlaceHolderPasswordField(30);
		textConfirmPassword.setPlaceholder("Password");
		textConfirmPassword.setSize(200, 30);
		textConfirmPassword.setLocation(140, 150);
		add(textConfirmPassword);

		btnSave = new JButton("SAVE");
		btnSave.setSize(100, 30);
		btnSave.setLocation(140, 210);
		add(btnSave);

		lbBackToLogin = new JLabel("Back to Login");
		lbBackToLogin.setSize(160, 30);
		lbBackToLogin.setLocation(160, 260);
		lbBackToLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
			}
		});
		add(lbBackToLogin);
	}

	public static void main(String[] args) {
		ChangePasswordGUI changePasswordGUI = new ChangePasswordGUI();
		changePasswordGUI.setVisible(true);
	}
}
