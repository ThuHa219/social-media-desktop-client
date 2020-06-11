package edu.hanu.social_media_desktop_client.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hanu.social_media_desktop_client.model.Like;

public class LikeDAO implements DAO<Like>{
	private Client client = ClientBuilder.newClient();
	private final WebTarget baseTarget = client.target("http://localhost:8080/social-media-platform-server/webapi");
	private WebTarget resourceTarget = baseTarget.path("/{resourceName}");
	private WebTarget resourceTargetId;

	public LikeDAO() {
		resourceTargetId = resourceTarget.path("/{resourceId}");
	}

	public Like get(long id) {
		Like like = resourceTargetId.resolveTemplate("resourceName", "likes")
				.resolveTemplate("resourceId", id).request(MediaType.APPLICATION_JSON).get(Like.class);
		return like;
	}

	public void save(Like like) {
		Response response = resourceTarget.resolveTemplate("resourceName", "likes").request()
				.post(Entity.json(like));
		if (response.getStatus() != 201) {
			System.err.println("error");
		}
	}
	
	public List<Like> getAll() {
		List<Like> response = resourceTargetId.resolveTemplate("resourceName", "likes")
												.request(MediaType.APPLICATION_JSON)
												.get(new GenericType<List<Like>>() {});
		return response;
	}
	
	public void update(Like like) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "likes")
				.resolveTemplate("resourceId", like.getId())
				.request()
				.put(Entity.json(like));
		if (response.getStatus() != 204) {
			System.err.println("LikeDAO.update()");
		}
	}
	
	public void delete(long id) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "likes")
				.resolveTemplate("resourceId", id)
				.request()
				.delete();
		if (response.getStatus() != 204) {
			System.err.println("LikeDAO.delete()");
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
		LikeDAO dao = new LikeDAO();
//		dao.save(p);
		
		System.out.println(dao.get(1).toString());
	}
}
