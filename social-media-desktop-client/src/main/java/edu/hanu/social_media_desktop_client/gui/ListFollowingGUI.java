package edu.hanu.social_media_desktop_client.gui;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;

import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.service.FriendListService;

import java.awt.Component;
import java.awt.event.*;
import java.util.EventObject;
import java.util.List;

public class ListFollowingGUI {
	private Object data[][];
	String column[] = { "ID", "FIRST NAME", "LAST NAME", "PHONE", "EMAIL              ", " " };
	FriendListService friendListService = new FriendListService();
	List<Profile> friends;

	public ListFollowingGUI() {
		List<Profile> friends = listFriend(LoginGUI.userName);
		System.out.println("check 2");
		data = new Object[friends.size()][5];
		for (Profile profile : friends) {
			System.out.println(friends.indexOf(profile));
			data[friends.indexOf(profile)][0] = friends.indexOf(profile) + 1;
			data[friends.indexOf(profile)][1] = profile.getFirstName();
			data[friends.indexOf(profile)][2] = profile.getLastName();
			data[friends.indexOf(profile)][3] = profile.getPhoneNumber();
			data[friends.indexOf(profile)][4] = profile.getEmail();

		}
		// TODO Auto-generated constructor stub
		DefaultTableModel tableModel = new DefaultTableModel(data, column);
		JTable table = new JTable(tableModel);
		table.getColumn(" ").setCellRenderer(new RendererAndEditor(table));
		table.getColumn(" ").setCellEditor(new RendererAndEditor(table));

		JFrame f = new JFrame();
		f.getContentPane().add(new JScrollPane(table));
		f.setBounds(50, 50, 1000, 400);
		f.setVisible(true);
	}

	public List<Profile> listFriend(String profileName) {
		return friends = friendListService.getFriendList(profileName);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ListFollowingGUI buttonInTable = new ListFollowingGUI();
	}
}

class RendererAndEditor implements TableCellRenderer, TableCellEditor {
	FriendListService friendListService = new FriendListService();
	List<Profile> friends;
	private JButton button;
	private int row;

	RendererAndEditor(JTable table) {
		List<Profile> friends = listFriend(LoginGUI.userName);
		button = new JButton("Unfollow");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.removeRow(row);
				friendListService.deleteFriend(LoginGUI.userName, friends.get(row).getProfileName());
			}
		});
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