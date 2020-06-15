package edu.hanu.social_media_desktop_client.service;

import java.util.List;

import edu.hanu.social_media_desktop_client.dao.CommentDAO;
import edu.hanu.social_media_desktop_client.model.Comment;

public class CommentService {
	CommentDAO dao = new CommentDAO();

	public void addComment(Comment comment) {
		dao.save(comment);
	}

	public List<Comment> getAllComments() {
		return dao.getAll();
	}

	public static void main(String[] args) {
		CommentService commentService = new CommentService();
		List<Comment> cmts = commentService.getAllComments();
		for (Comment comment : cmts) {
			System.out.println(comment.toString());
		}
	}
}
