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

public class HomeGUI extends JFrame {
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
	private JLabel lbShowStatus;
	ProfileService profileService = new ProfileService();
	Profile profile = profileService.getProfile(LoginGUI.userName);

	public HomeGUI() {
		// TODO Auto-generated constructor stub
		super("Home Page");
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
				if (textThinking.getText().isEmpty()
						|| textThinking.getText().equalsIgnoreCase("What are you thinking?")) {
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

		// show status
		lbShowStatus = new JLabel("CLICK HERE TO SEE FRIEND'S STATUSES!");
		lbShowStatus.setSize(250, 30);
		lbShowStatus.setLocation(80, 350);
		lbShowStatus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StatusListGUI statusListGUI = new StatusListGUI();
			}
		});
		add(lbShowStatus);
	}

	public static void main(String[] args) {
		HomeGUI homeGUI = new HomeGUI();
		homeGUI.setVisible(true);
	}
}
