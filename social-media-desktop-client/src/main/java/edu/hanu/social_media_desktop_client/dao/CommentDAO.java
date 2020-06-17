package edu.hanu.social_media_desktop_client.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hanu.social_media_desktop_client.model.Comment;

public class CommentDAO implements DAO<Comment> {
	private Client client = ClientBuilder.newClient();
	private final WebTarget baseTarget = client.target("http://localhost:8080/social-media-platform-server/webapi");
	private WebTarget resourceTarget = baseTarget.path("/{resourceName}");
	private WebTarget resourceTargetId;

	public CommentDAO() {
		resourceTargetId = resourceTarget.path("/{resourceId}");
	}

	public Comment get(long id) {
		Comment comment = resourceTargetId.resolveTemplate("resourceName", "comments").resolveTemplate("resourceId", id)
				.request(MediaType.APPLICATION_JSON).get(Comment.class);
		return comment;
	}

	public void save(Comment comment) {
		Response response = resourceTarget.resolveTemplate("resourceName", "comments").request()
				.post(Entity.json(comment));
		if (response.getStatus() != 201) {
			System.err.println("error");
		}
	}

	public List<Comment> getAll() {
		List<Comment> response = resourceTarget.resolveTemplate("resourceName", "comments")
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Comment>>() {
				});
		return response;
	}

	public void update(Comment comment) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "comments")
				.resolveTemplate("resourceId", comment.getId()).request().put(Entity.json(comment));
		if (response.getStatus() != 204) {
			System.err.println("CommentDAO.update()");
		}
	}

	public void delete(long id) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "comments")
				.resolveTemplate("resourceId", id).request().delete();
		if (response.getStatus() != 204) {
			System.err.println("CommentDAO.delete()");
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
		CommentDAO dao = new CommentDAO();
//		dao.save(p);

		System.out.println(dao.get(1).toString());
	}
}
