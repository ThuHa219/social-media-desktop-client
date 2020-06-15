package edu.hanu.social_media_desktop_client.service;

import java.util.List;

import edu.hanu.social_media_desktop_client.dao.StatusDAO;
import edu.hanu.social_media_desktop_client.model.Status;

public class StatusService {
	private StatusDAO dao = new StatusDAO();

	public StatusService() {

	}

	public Status addStatus(Status status) {
		dao.save(status);
		return status;
	}

	public List<Status> getAllStatus() {
		List<Status> statuses = dao.getAll();
		return statuses;
	}

	public Status getStatus(long id) {
		Status status = dao.get(id);
		return status;
	}

	public void deleteStatus(String id) {
		dao.delete(Long.parseLong(id));
	}
}
