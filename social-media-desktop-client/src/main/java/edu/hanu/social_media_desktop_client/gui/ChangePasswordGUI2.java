package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.ProfileService;
import edu.hanu.social_media_desktop_client.utils.PasswordAuthentication;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderPasswordField;
import edu.hanu.social_media_desktop_client.utils.Validator;

public class ChangePasswordGUI2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbChangePassword;
	private JLabel lbCurrentPassword;
	private JLabel lbPassword;
	private JLabel lbConfirmPassword;
	private PlaceHolderPasswordField textCurrentPassword;
	private PlaceHolderPasswordField textPassword;
	private PlaceHolderPasswordField textConfirmPassword;
	private JButton btnSave;
	ProfileService profileService = new ProfileService();
	PasswordAuthentication auth = new PasswordAuthentication();

	public ChangePasswordGUI2() {
		// TODO Auto-generated constructor stub
		super("Change Password");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
	}

	private void initPanels() {
		// TODO Auto-generated method stub
		lbChangePassword = new JLabel("Change Password");
		lbChangePassword.setSize(200, 30);
		lbChangePassword.setLocation(140, 50);
		add(lbChangePassword);

		lbCurrentPassword = new JLabel("Curent Password:");
		lbCurrentPassword.setSize(120, 30);
		lbCurrentPassword.setLocation(20, 110);
		add(lbCurrentPassword);

		textCurrentPassword = new PlaceHolderPasswordField(30);
		textCurrentPassword.setPlaceholder("Password");
		textCurrentPassword.setSize(200, 30);
		textCurrentPassword.setLocation(140, 110);
		add(textCurrentPassword);

		lbPassword = new JLabel("New Password: ");
		lbPassword.setSize(100, 30);
		lbPassword.setLocation(20, 160);
		add(lbPassword);

		textPassword = new PlaceHolderPasswordField(30);
		textPassword.setPlaceholder("Password");
		textPassword.setSize(200, 30);
		textPassword.setLocation(140, 160);
		add(textPassword);

		lbConfirmPassword = new JLabel("Confirm Password: ");
		lbConfirmPassword.setSize(120, 30);
		lbConfirmPassword.setLocation(20, 210);
		add(lbConfirmPassword);

		textConfirmPassword = new PlaceHolderPasswordField(30);
		textConfirmPassword.setPlaceholder("Password");
		textConfirmPassword.setSize(200, 30);
		textConfirmPassword.setLocation(140, 210);
		add(textConfirmPassword);

		btnSave = new JButton("CHANGE");
		btnSave.setSize(100, 30);
		btnSave.setLocation(140, 260);
		btnSave.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textCurrentPassword.getText().isEmpty() || textCurrentPassword.getText().equals("Password")
						|| textCurrentPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your current password.");
				} else if (textPassword.getText().isEmpty() || textPassword.getText().equals("Password")
						|| textPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your new password.");
				} else if (textConfirmPassword.getText().isEmpty() || textConfirmPassword.getText().equals("Password")
						|| textConfirmPassword.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please confirm your new password.");
				} else if (!Validator.isValidatePassword(textPassword.getText())) {
					JOptionPane.showMessageDialog(null,
							"INVALID PASSWORD. \nPassword must be above 8 characters, \ncontain at least one uppercase, one number, \nand one special character !");
				} else {
					System.out.println(profileService.getProfile(LoginGUI.userName).getPassword());
					if (!auth.checkPassword(textCurrentPassword.getText(),
							profileService.getProfile(LoginGUI.userName).getPassword())) {
						JOptionPane.showMessageDialog(null, "CURRENT PASSWORD DOES NOT MATCH.");
					} else if (!textPassword.getText().equals(textConfirmPassword.getText())) {
						JOptionPane.showMessageDialog(null, "PASSWORD DOES NOT MATCH.");
					} else if (textCurrentPassword.getText().equals(textPassword.getText())) {
						JOptionPane.showMessageDialog(null, "NEW PASSWORD CAN NOT BE THE SAME.");
					} else {
						Profile profile = profileService.getProfile(LoginGUI.userName);
						profile.setPassword(textPassword.getText());
						profileService.updateProfile(profile);
						JOptionPane.showMessageDialog(null, "CHANGE PASSWORD SUCCESSFULLY.");
						dispose();
						LoginGUI loginGUI = new LoginGUI();
						loginGUI.setVisible(true);
					}
				}
			}
		});

		add(btnSave);

	}

	public static void main(String[] args) {
		ChangePasswordGUI2 changePasswordGUI2 = new ChangePasswordGUI2();
		changePasswordGUI2.setVisible(true);
	}
}
