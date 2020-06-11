package edu.hanu.social_media_desktop_client.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hanu.social_media_desktop_client.model.FriendList;
import edu.hanu.social_media_desktop_client.model.Profile;

public class FriendListDAO {
	private Client client = ClientBuilder.newClient();
	private final WebTarget baseTarget = client.target("http://localhost:8080/social-media-platform/webapi");
	private WebTarget resourceTarget = baseTarget.path("/{resourceName}");
	private WebTarget resourceTargetId;

	public FriendListDAO() {
		resourceTargetId = resourceTarget.path("/{resourceId}");
	}

	public FriendList get(String profilename) {
		FriendList friendList = resourceTargetId.resolveTemplate("resourceName", "friendlist")
				.resolveTemplate("resourceId", profilename).request(MediaType.APPLICATION_JSON).get(FriendList.class);
		return friendList;
	}

	public void save(FriendList friendList) {
		Response response = resourceTarget.resolveTemplate("resourceName", "friendlist").request()
				.post(Entity.json(friendList));
		if (response.getStatus() != 201) {
			System.err.println("FriendListDAO.save() " + response.getStatus());
		}
	}
	
	public List<FriendList> getAll() {
		List<FriendList> response = resourceTargetId.resolveTemplate("resourceName", "friendlist")
												.request(MediaType.APPLICATION_JSON)
												.get(new GenericType<List<FriendList>>() {});
		return response;
	}
	
	public void update(FriendList friendList) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "friendlist")
				.resolveTemplate("resourceId", friendList.getProfile().getProfileName())
				.request()
				.put(Entity.json(friendList));
		if (response.getStatus() != 204) {
			System.err.println("FriendListDAO.update()");
		}
	}
	
	public void delete(String profilename, String friendname) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "friendlist")
				.resolveTemplate("resourceId", profilename)
				.path("/{friendname}")
				.resolveTemplate("friendname", friendname)
				.request()
				.delete();
		if (response.getStatus() != 204) {
			System.err.println("FriendListDAO.delete()");
		}
	}
	public static void main(String[] args) {
//		Profile p = new Profile();
//		p.setFirstName("Ha");
//		p.setLastName("Nguyen");
//		p.setProfileName("ThuHa219");
//		p.setPassword("123456");
//		p.setQuestion("what is favorite book ?");
//		p.setAnswer("harry potter");
		FriendListDAO dao = new FriendListDAO();
//		dao.save(p);
		FriendList friendList = new FriendList();
		ProfileDAO prdao = new ProfileDAO();
		List<Profile> friends = dao.get("ThuHa219").getFriend();
		friends.add(prdao.get("QuangChien19"));
		friendList.setProfile(prdao.get("ThuHa219"));
		friendList.setFriend(friends);
		dao.save(friendList);
		
//		dao.delete("ThuHa219", "QuangChien21");
//		
//		System.out.println(dao.get("ThuHa219").toString());
	}
}
