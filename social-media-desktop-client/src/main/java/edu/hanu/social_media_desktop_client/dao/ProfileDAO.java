package edu.hanu.social_media_desktop_client.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hanu.social_media_desktop_client.model.Profile;

public class ProfileDAO implements DAO<Profile>{
	private Client client = ClientBuilder.newClient();
	private final WebTarget baseTarget = client.target("http://localhost:8080/social-media-platform/webapi");
	private WebTarget resourceTarget = baseTarget.path("/{resourceName}");
	private WebTarget resourceTargetId;

	public ProfileDAO() {
		resourceTargetId = resourceTarget.path("/{resourceId}");
	}

	public Profile get(String profilename) {
		Profile profile = resourceTargetId.resolveTemplate("resourceName", "profiles")
				.resolveTemplate("resourceId", profilename).request(MediaType.APPLICATION_JSON).get(Profile.class);
		return profile;
	}

	public void save(Profile profile) {
		//C1
		Response response = resourceTarget.resolveTemplate("resourceName", "profiles").request()
				.post(Entity.json(profile));
		if (response.getStatus() != 201) {
			System.err.println("error");
		}
		//C2
//		Invocation.Builder builder = resourceTarget.resolveTemplate("resourceName", "profiles").request().accept(MediaType.APPLICATION_JSON);
//		Response response = builder.post(Entity.json(profile));
//		if (response.getStatus() != 201) {
//			System.err.println("error");
//		}
	}

	public List<Profile> getAll() {
		List<Profile> response = resourceTarget.resolveTemplate("resourceName", "profiles")
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Profile>>() {
				});
		return response;
	}

	public void update(Profile profile) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "profiles")
				.resolveTemplate("resourceId", profile.getProfileName()).request().put(Entity.json(profile));
		System.out.println(response.getStatus());
		if (response.getStatus() != 200) {
			System.err.println("ProfileDAO.update()");
		}
	}
	
	public void edit(Profile profile) {
		Response response = resourceTarget.resolveTemplate("resourceName", "profiles").path("/edit/{resourceId}")
				.resolveTemplate("resourceId", profile.getProfileName()).request().put(Entity.json(profile));
		System.out.println(response.getStatus());
		if (response.getStatus() != 200) {
			System.err.println("ProfileDAO.edit()");
		}
	}

	public void delete(String profilename) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "profiles")
				.resolveTemplate("resourceId", profilename).request().delete();
		if (response.getStatus() != 204) {
			System.err.println("ProfileDAO.delete()");
		}
	}

	public static void main(String[] args) {
		Profile p = new Profile();
		p.setFirstName("Haaaa");
		p.setLastName("Phamm");
		p.setProfileName("QuangChien19");
		p.setPassword("Quagchien17@");
//		p.setQuestion("what is favorite book ?");
//		p.setAnswer("harry potter");
		System.out.println(p.toString());
		ProfileDAO dao = new ProfileDAO();
		dao.edit(p);
//		for(Profile p : dao.getAll()) {
//			System.out.println(p.toString());
//		}

		System.out.println(dao.get("QuangChien19").toString());
	}
	
	@SuppressWarnings(value = { "unused" })
	@Override
	public Profile get(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings(value = { "unused" })
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
}
