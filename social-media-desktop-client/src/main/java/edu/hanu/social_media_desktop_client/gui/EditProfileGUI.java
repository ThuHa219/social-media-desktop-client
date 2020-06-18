package edu.hanu.social_media_desktop_client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.ProfileService;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;
import edu.hanu.social_media_desktop_client.utils.Validator;

public class EditProfileGUI extends JFrame {
	private JLabel lbEditProfile;
	private JLabel lbFirstName;
	private JLabel lbLastName;
	private JLabel lbEmail;
	private JLabel lbAddress;
	private JLabel lbPhoneNumber;
	private JButton btnEdit;
	private JButton btnBackToProfile;

	private PlaceHolderTextField textFirstName;
	private PlaceHolderTextField textLastName;
	private PlaceHolderTextField textAddress;
	private PlaceHolderTextField textEmail;
	private PlaceHolderTextField textPhoneNumber;
	ProfileService profileService = new ProfileService();
	private static final long serialVersionUID = 1L;

	public EditProfileGUI() {
		// TODO Auto-generated constructor stub
		super("Edit Profile");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
	}

	private void initPanels() {
		lbEditProfile = new JLabel("Edit Profile");
		lbEditProfile.setSize(200, 30);
		lbEditProfile.setLocation(170, 50);
		add(lbEditProfile);

		lbFirstName = new JLabel("First Name: ");
		lbFirstName.setSize(100, 30);
		lbFirstName.setLocation(20, 120);
		add(lbFirstName);

		textFirstName = new PlaceHolderTextField(30);
		textFirstName.setPlaceholder(profileService.getProfile(LoginGUI.userName).getFirstName());
		textFirstName.setSize(230, 30);
		textFirstName.setLocation(130, 120);
		add(textFirstName);

		lbLastName = new JLabel("Last Name: ");
		lbLastName.setSize(100, 30);
		lbLastName.setLocation(20, 170);
		add(lbLastName);

		textLastName = new PlaceHolderTextField(30);
		textLastName.setPlaceholder(profileService.getProfile(LoginGUI.userName).getLastName());
		textLastName.setSize(230, 30);
		textLastName.setLocation(130, 170);
		add(textLastName);

		lbEmail = new JLabel("Email: ");
		lbEmail.setSize(100, 30);
		lbEmail.setLocation(20, 220);
		add(lbEmail);

		textEmail = new PlaceHolderTextField(30);
		textEmail.setPlaceholder(profileService.getProfile(LoginGUI.userName).getEmail());
		textEmail.setSize(230, 30);
		textEmail.setLocation(130, 220);
		add(textEmail);

		lbPhoneNumber = new JLabel("Phone Number: ");
		lbPhoneNumber.setSize(100, 30);
		lbPhoneNumber.setLocation(20, 270);
		add(lbPhoneNumber);

		textPhoneNumber = new PlaceHolderTextField(30);
		textPhoneNumber.setPlaceholder(profileService.getProfile(LoginGUI.userName).getPhoneNumber());
		textPhoneNumber.setSize(230, 30);
		textPhoneNumber.setLocation(130, 270);
		add(textPhoneNumber);

		lbAddress = new JLabel("Address:  ");
		lbAddress.setSize(100, 30);
		lbAddress.setLocation(20, 320);
		add(lbAddress);

		textAddress = new PlaceHolderTextField(30);
		textAddress.setPlaceholder(profileService.getProfile(LoginGUI.userName).getAddress());
		textAddress.setSize(230, 30);
		textAddress.setLocation(130, 320);
		add(textAddress);

		btnEdit = new JButton("EDIT");
		btnEdit.setSize(100, 30);
		btnEdit.setLocation(150, 370);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textFirstName.getText().isEmpty() || textFirstName.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your first name.");
				} else if (textLastName.getText().isEmpty() || textLastName.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your last name.");
				} else if (textEmail.getText().isEmpty() || textEmail.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your email.");
				} else if (textPhoneNumber.getText().isEmpty() || textPhoneNumber.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your phone number.");
				} else if (textAddress.getText().isEmpty() || textAddress.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please input your address.");
				} else if (!Validator.isValidEmail(textEmail.getText())) {
					JOptionPane.showMessageDialog(null, "INVALID EMAIL.");
				} else if (!Validator.isStringNumeric(textPhoneNumber.getText())) {
					JOptionPane.showMessageDialog(null, "INVALID PHONE NUMBER.");
				} else {
					Profile profile = new Profile();
					profile.setFirstName(textFirstName.getText());
					profile.setLastName(textLastName.getText());
					profile.setEmail(textEmail.getText());
					profile.setPhoneNumber(textPhoneNumber.getText());
					profile.setAddress(textAddress.getText());
					profile.setProfileName(LoginGUI.userName);
					profile.setPassword(profileService.getProfile(LoginGUI.userName).getPassword());
					profileService.editProfile(profile);
					JOptionPane.showMessageDialog(null, "Edit successfully!");
					dispose();
					ProfileGUI profileGUI = new ProfileGUI();
					profileGUI.setVisible(true);
				}
			}
		});
		add(btnEdit);

		btnBackToProfile = new JButton("BACK");
		btnBackToProfile.setSize(100, 30);
		btnBackToProfile.setLocation(20, 480);
		add(btnBackToProfile);
	}

	public static void main(String[] args) {
		EditProfileGUI editProfileGUI = new EditProfileGUI();
		editProfileGUI.setVisible(true);
	}
}
