package edu.hanu.social_media_desktop_client.gui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.FriendListService;

public class FollowingGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private Object data[][];
	String column[] = { "ID", "FIRST NAME", "LAST NAME", "PHONE", "EMAIL              " };
	private JTable tblFollowing;
	private JScrollPane jScrollPane;
	private JButton btnUnfollow;
	FriendListService friendListService = new FriendListService();
	List<Profile> friends;

	public FollowingGUI() {
		// TODO Auto-generated constructor stub
		super("Following");
		setSize(900, 400);
		setLocation(300, 100);
		//setLayout(null);
		System.out.println("check 1");
		initPanels();
	}

	private void initPanels() {
		btnUnfollow = new JButton("Unfollow");
		btnUnfollow.setLocation(390, 250);
		btnUnfollow.setSize(100, 40);
		add(btnUnfollow);

		List<Profile> friends = listFriend("Chien4");
		System.out.println("check 2");
		data = new Object[friends.size() + 1][5];
		for (Profile profile : friends) {
			System.out.println(friends.indexOf(profile));
			data[friends.indexOf(profile)][0] = friends.indexOf(profile) + 1;
			data[friends.indexOf(profile)][1] = profile.getFirstName();
			data[friends.indexOf(profile)][2] = profile.getLastName();
			data[friends.indexOf(profile)][3] = profile.getPhoneNumber();
			data[friends.indexOf(profile)][4] = profile.getEmail();

		}
		System.out.println("check 5");
		tblFollowing = new JTable(data, column);
		jScrollPane = new JScrollPane(tblFollowing);
		
		add(jScrollPane);
		System.out.println("check 6");
	}

	public List<Profile> listFriend(String profileName) {
		return friends = friendListService.getFriendList(profileName);
	}

	public static void main(String[] args) {
		FollowingGUI followingGUI = new FollowingGUI();
		followingGUI.setVisible(true);
	}
}
