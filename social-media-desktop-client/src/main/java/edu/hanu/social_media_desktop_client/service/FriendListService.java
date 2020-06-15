package edu.hanu.social_media_desktop_client.service;

import java.util.List;

import edu.hanu.social_media_desktop_client.dao.FriendListDAO;
import edu.hanu.social_media_desktop_client.model.FriendList;
import edu.hanu.social_media_desktop_client.model.Profile;

public class FriendListService {
	FriendListDAO dao = new FriendListDAO();

	public FriendListService() {
		super();
	}

	public List<Profile> getFriendList(String profileName) {
		FriendList friendlist = dao.get(profileName);
		return friendlist.getFriend();
	}

	public void deleteFriend(String profileName, String friendName) {
		dao.delete(profileName, friendName);
	}
	public void addFriend(FriendList friendList) {
		dao.save(friendList);
	}
}
