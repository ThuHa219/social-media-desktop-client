package edu.hanu.social_media_desktop_client.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.model.Status;
import edu.hanu.social_media_desktop_client.service.ProfileService;
import edu.hanu.social_media_desktop_client.service.StatusService;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

public class ProfileGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// nav-bar
	private JButton btnHome;
	private JButton btnProfile;
	private JButton btnMesssage;
	private PlaceHolderTextField textSearch;
	private JButton btnSearch;
	private JButton btnLogout;
	// end nav-bar
	private JLabel lbCreatePost;
	private JLabel lbHello;
	private PlaceHolderTextField textThinking;
	private JButton btnShare;

	private JLabel lbInformation;
	private JButton btnFollowing;
	private JButton btnShowStatus;
	private JButton btnEditProfile;

	private JLabel lbFirstName;
	private JLabel lbLastName;
	private JLabel lbEmail;
	private JLabel lbPhoneNumber;
	private JLabel lbAddress;

	private JButton btnChangePassword;

	ProfileService profileService = new ProfileService();
	Profile profile = profileService.getProfile(LoginGUI.userName);

	public ProfileGUI() {

		// TODO Auto-generated constructor stub
		super("Profile");
		setSize(400, 600);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
	}

	private void initPanels() {
		// hello
		lbHello = new JLabel();
		// lbHello.setText("Hello");
		lbHello.setText("Hello " + profile.getFirstName() + " " + profile.getLastName());
		lbHello.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				ProfileGUI profileGUI = new ProfileGUI();
				profileGUI.setVisible(true);
			}
		});
		lbHello.setSize(200, 30);
		lbHello.setLocation(150, 10);
		add(lbHello);
		// end hello

		// nav-bar
		btnHome = new JButton("Home");
		btnHome.setSize(100, 40);
		btnHome.setLocation(0, 50);
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomeGUI homeGUI = new HomeGUI();
				homeGUI.setVisible(true);
			}
		});
		add(btnHome);

		btnProfile = new JButton("Profile");
		btnProfile.setSize(100, 40);
		btnProfile.setLocation(100, 50);
		btnProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProfileGUI profileGUI = new ProfileGUI();
				profileGUI.setVisible(true);
			}
		});

		add(btnProfile);

		btnMesssage = new JButton("Message");
		btnMesssage.setSize(100, 40);
		btnMesssage.setLocation(200, 50);
		btnMesssage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ChatAppUI frame = new ChatAppUI();
							frame.setVisible(true);
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
							SwingUtilities.updateComponentTreeUI(frame);

							frame.connectWebSocketServer();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		add(btnMesssage);

		btnLogout = new JButton("Log out");
		btnLogout.setSize(100, 40);
		btnLogout.setLocation(300, 50);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				@SuppressWarnings("unused")
				LoginGUI loginGUI = new LoginGUI();
			}
		});
		add(btnLogout);

		textSearch = new PlaceHolderTextField(30);
		textSearch.setPlaceholder("Search people");
		textSearch.setSize(265, 40);
		textSearch.setLocation(0, 90);
		add(textSearch);

		btnSearch = new JButton("Search");
		btnSearch.setSize(130, 40);
		btnSearch.setLocation(260, 89);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("chekc search");
				SearchedFriendGUI searchedFriendGUI = new SearchedFriendGUI(textSearch.getText());
			}
		});
		add(btnSearch);
		// nav-bar end

		// create post
		lbCreatePost = new JLabel("Create a post");
		lbCreatePost.setSize(200, 30);
		lbCreatePost.setLocation(10, 130);
		add(lbCreatePost);

		textThinking = new PlaceHolderTextField(30);
		textThinking.setPlaceholder("What are you thinking?");
		textThinking.setSize(280, 70);
		textThinking.setLocation(10, 160);
		add(textThinking);

		btnShare = new JButton("Share");
		btnShare.setSize(80, 40);
		btnShare.setLocation(300, 175);
		btnShare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textThinking.getText().isEmpty() || textThinking.getText() == "What are you thinking?") {
					JOptionPane.showMessageDialog(null, "Please input your status.");
				} else {
					StatusService statusService = new StatusService();
					Status status = new Status();
					status.setProfile(profileService.getProfile(LoginGUI.userName));
					status.setStatus(textThinking.getText());
					statusService.addStatus(status);
					JOptionPane.showMessageDialog(null, "Status Posted.");
				}
			}
		});
		add(btnShare);
		// end-create-post

		lbInformation = new JLabel("YOUR INFORMATION");
		lbInformation.setSize(250, 30);
		lbInformation.setLocation(130, 250);
		add(lbInformation);

		lbFirstName = new JLabel("First Name:    " + profile.getFirstName());
		lbFirstName.setSize(250, 30);
		lbFirstName.setLocation(50, 290);
		add(lbFirstName);

		lbLastName = new JLabel("Last Name:     " + profile.getLastName());
		lbLastName.setSize(250, 30);
		lbLastName.setLocation(50, 330);
		add(lbLastName);

		lbEmail = new JLabel("Email:         " + profile.getEmail());
		lbEmail.setSize(250, 30);
		lbEmail.setLocation(50, 370);
		add(lbEmail);

		lbPhoneNumber = new JLabel("Phone Number:   " + profile.getPhoneNumber());
		lbPhoneNumber.setSize(250, 30);
		lbPhoneNumber.setLocation(50, 410);
		add(lbPhoneNumber);

		lbAddress = new JLabel("Address:       " + profile.getAddress());
		lbAddress.setSize(250, 30);
		lbAddress.setLocation(50, 450);
		add(lbAddress);

		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setSize(150, 30);
		btnChangePassword.setLocation(117, 480);
		btnChangePassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChangePasswordGUI2 changePasswordGUI2 = new ChangePasswordGUI2();
				changePasswordGUI2.setVisible(true);
			}
		});
		add(btnChangePassword);

		btnFollowing = new JButton("Following");
		btnFollowing.setSize(100, 30);
		btnFollowing.setLocation(10, 520);
		btnFollowing.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListFollowingGUI followingGUI = new ListFollowingGUI();

			}
		});
		add(btnFollowing);

		btnShowStatus = new JButton("Show Your Statuses");
		btnShowStatus.setSize(150, 30);
		btnShowStatus.setLocation(117, 520);
		btnShowStatus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserStatuses userStatuses = new UserStatuses();

			}
		});
		add(btnShowStatus);

		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setSize(100, 30);
		btnEditProfile.setLocation(275, 520);
		btnEditProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				EditProfileGUI editProfileGUI = new EditProfileGUI();
				editProfileGUI.setVisible(true);

			}
		});
		add(btnEditProfile);
	}

	public static void main(String[] args) {
		ProfileGUI profileGUI = new ProfileGUI();
		profileGUI.setVisible(true);
	}
}
