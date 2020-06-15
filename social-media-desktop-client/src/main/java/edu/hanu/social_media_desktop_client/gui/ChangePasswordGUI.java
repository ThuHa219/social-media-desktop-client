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
import edu.hanu.social_media_desktop_client.utils.Validator;

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
	ProfileService profileService = new ProfileService();

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
		btnSave.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textPassword.getText().isEmpty() || textPassword.getText().equals("Password")
						|| textPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your password.");
				} else if (textConfirmPassword.getText().isEmpty() || textConfirmPassword.getText().equals("Password")
						|| textConfirmPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please confirm your password.");
				} else if (!Validator.isValidatePassword(textPassword.getText())) {
					JOptionPane.showMessageDialog(null,
							"INVALID PASSWORD. \nPassword must be above 8 characters, \ncontain at least one uppercase, one number, \nand one special character !");
				} else {
					if (!textPassword.getText().equals(textConfirmPassword.getText())) {
						JOptionPane.showMessageDialog(null, "PASSWORD DOES NOT MATCH.");
					} else {
						Profile profile = profileService.getProfile(LoginGUI.userName);
						profile.setPassword(textPassword.getText());
						profileService.updateProfile(profile);
						LoginGUI loginGUI = new LoginGUI();
						loginGUI.setVisible(true);
					}
				}
			}
		});
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
