package edu.hanu.social_media_desktop_client.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import edu.hanu.social_media_desktop_client.model.FriendList;
import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.FriendListService;
import edu.hanu.social_media_desktop_client.service.ProfileService;

public class SearchedFriendGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	ProfileService profileService = new ProfileService();
	FriendListService friendListService = new FriendListService();
	private Object data[][];
	String column[] = { "ID", "FIRST NAME", "LAST NAME", "PHONE", "EMAIL              ", " " };
	List<Profile> friends;
	private String searchName;

	public SearchedFriendGUI(String searchName) {
		setSearchName(searchName);
		List<Profile> notFollowing = notFollowing(searchName, LoginGUI.userName);
		System.out.println(notFollowing.size() + " check size");
		data = new Object[notFollowing.size()][5];
		System.out.println("Check check0");
		for (Profile profile : notFollowing) {
			System.out.println(profile.toString());
			System.out.println("Check check");
			System.out.println(notFollowing.indexOf(profile));
			data[notFollowing.indexOf(profile)][0] = notFollowing.indexOf(profile) + 1;
			data[notFollowing.indexOf(profile)][1] = profile.getFirstName();
			data[notFollowing.indexOf(profile)][2] = profile.getLastName();
			data[notFollowing.indexOf(profile)][3] = profile.getPhoneNumber();
			data[notFollowing.indexOf(profile)][4] = profile.getEmail();
		}
		DefaultTableModel tableModel = new DefaultTableModel(data, column);
		JTable table = new JTable(tableModel);
		table.getColumn(" ").setCellRenderer(new RendererAndEditor2(table, searchName));
		table.getColumn(" ").setCellEditor(new RendererAndEditor2(table, searchName));

		JFrame f = new JFrame();
		f.getContentPane().add(new JScrollPane(table));
		f.setBounds(50, 50, 1000, 400);
		f.setVisible(true);
	}

	public List<Profile> getProfiles(String searchName) {
		System.out.println("Name search for: " + searchName);
		String[] words = searchName.split("\\s");
		List<Profile> allProfiles = new ArrayList<Profile>();
		List<Profile> filteredProfiles = new ArrayList<Profile>();
		allProfiles = profileService.getAllProfiles();
		for (Profile profile : allProfiles) {
			for (String w : words) {
				if (w.equals(profile.getFirstName()) || w.equals(profile.getLastName())) {
					filteredProfiles.add(profile);
				}
			}
		}
		System.out.println("check 1");
		for (Profile profile : filteredProfiles) {
			System.out.println(profile.toString());
		}
		return filteredProfiles;
	}

	public List<Profile> notFollowing(String searchName, String profileName) {
		List<Profile> allFriends = friendListService.getFriendList(profileName);
		List<Profile> allSearch = getProfiles(searchName);
		List<Profile> notFollowing = new ArrayList<Profile>();
		if (allFriends.size() == 0) {
			return allSearch;
		} else {
			System.out.println("check 2");
			for (Profile p1 : allSearch) {
				int check = 0;
				for (Profile profile : allFriends) {
					if (p1.getProfileName().equals(profile.getProfileName())) {
						check++;
					}
				}
				if (check == 0) {
					System.out.println("Not contain");
					notFollowing.add(p1);
				} else {
					System.out.println("contain");
				}
			}
		}
		System.out.println("check 3");
		return notFollowing;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SearchedFriendGUI searchedFriendGUI = new SearchedFriendGUI("Chien");
	}
}

class RendererAndEditor2 implements TableCellRenderer, TableCellEditor {
	FriendListService friendListService = new FriendListService();
	List<Profile> friends;
	private JButton button;
	private int row;
	private String searchName;
	ProfileService profileService = new ProfileService();

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	RendererAndEditor2(JTable table, String searchName) {
		ProfileService profileService = new ProfileService();
		List<Profile> friends = friendListService.getFriendList(LoginGUI.userName);

		setSearchName(searchName);

		List<Profile> notFollowing = notFollowing(searchName, LoginGUI.userName);

		button = new JButton("Follow");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.removeRow(row);
				friends.add(notFollowing.get(row));
				FriendList friendList = new FriendList();
				friendList.setProfile(profileService.getProfile(LoginGUI.userName));
				friendList.setFriend(friends);
				friendListService.addFriend(friendList);
			}
		});
	}

	public List<Profile> notFollowing(String searchName, String profileName) {
		List<Profile> allFriends = friendListService.getFriendList(profileName);
		System.out.println(allFriends.size() + "Allfriend");
		for (Profile profile : allFriends) {
			System.out.println("opps");
			System.out.println(profile.toString());
		}
		List<Profile> allSearch = getProfiles(searchName);
		for (Profile profile : allSearch) {
			System.out.println(profile.toString() + "search");
		}
		List<Profile> notFollowing = new ArrayList<Profile>();
		if (allFriends.size() == 0) {
			return allSearch;
		} else {
			System.out.println("check 2");
			for (Profile p1 : allSearch) {
				int check = 0;
				for (Profile profile : allFriends) {
					if (p1.getProfileName().equals(profile.getProfileName())) {
						check++;
					}
				}
				if (check == 0) {
					System.out.println("Not contain");
					notFollowing.add(p1);
				} else {
					System.out.println("contain");
				}
			}
		}
		System.out.println("check 3");
		return notFollowing;
	}

	public List<Profile> getProfiles(String searchName) {
		System.out.println("Name search forhe: " + searchName);
		String[] words = searchName.split("\\s");
		List<Profile> allProfiles = new ArrayList<Profile>();
		List<Profile> filteredProfiles = new ArrayList<Profile>();
		allProfiles = profileService.getAllProfiles();
		for (Profile profile : allProfiles) {
			for (String w : words) {
				if (w.equals(profile.getFirstName()) || w.equals(profile.getLastName())) {
					filteredProfiles.add(profile);
				}
			}
		}
		System.out.println("check 1");
		return filteredProfiles;
	}

	public List<Profile> listFriend(String profileName) {
		return friends = friendListService.getFriendList(profileName);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return button;
	}

	@Override
	public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		this.row = row;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		return true;
	}

	@Override
	public void cancelCellEditing() {
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
	}
}
