package edu.hanu.social_media_desktop_client.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.model.Status;
import edu.hanu.social_media_desktop_client.service.CommentService;
import edu.hanu.social_media_desktop_client.service.FriendListService;
import edu.hanu.social_media_desktop_client.service.LikeService;
import edu.hanu.social_media_desktop_client.service.ProfileService;
import edu.hanu.social_media_desktop_client.service.StatusService;
import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

public class StatusFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private JLabel lbName;
	private JLabel lbTime;
	private JLabel lbStatus;
	private JButton btnLike;
	private JLabel lbCommenterName;
	private JLabel lbCommentTime;
	private JLabel lbComment;
	private PlaceHolderTextField textComment;
	private JButton btnComment;
	FriendListService friendListService = new FriendListService();
	StatusService statusService = new StatusService();
	CommentService commentService = new CommentService();
	ProfileService profileService = new ProfileService();
	LikeService likeService = new LikeService();
	List<Profile> friends;
	List<Status> statuses = showFriendStatus("Chien4");
	//List<Comment> comments = getCommentInPost();

	public StatusFrame() {
		setSize(350, 380);
		// setPreferredSize(new Dimension(350, 380));
		setLocation(500, 100);
		setLayout(null);
		initPanels();
		setVisible(true);
	}

	private void initPanels() {
		JPanel jPanel = new JPanel();
		lbName = new JLabel("Vuong Khanh Linh");
		lbName.setSize(300, 40);
		lbName.setLocation(20, 0);
		add(lbName);

		lbTime = new JLabel("20/11/2020");
		lbTime.setSize(300, 40);
		lbTime.setLocation(20, 30);
		add(lbTime);

		lbStatus = new JLabel("It's awesome dayyyyyyyyyy.");
		lbStatus.setSize(300, 40);
		lbStatus.setLocation(20, 50);
		add(lbStatus);

		btnLike = new JButton("Like");
		// btnLike.setSize(60, 20);
		btnLike.setLocation(20, 90);
		btnLike.setPreferredSize(new Dimension(20, 20));
		add(btnLike);

		lbCommenterName = new JLabel("Tran Thu Hien");
		lbCommenterName.setSize(100, 20);
		lbCommenterName.setLocation(40, 110);
		add(lbCommenterName);

		lbCommentTime = new JLabel("22/22/2020");
		lbCommentTime.setSize(100, 20);
		lbCommentTime.setLocation(150, 110);
		add(lbCommentTime);

		lbComment = new JLabel("Ohh wowwwww");
		lbComment.setSize(100, 20);
		lbComment.setLocation(20, 140);
		add(lbComment);

		textComment = new PlaceHolderTextField(30);
		textComment.setPlaceholder("Write some comments about this post!");
		textComment.setSize(220, 70);
		textComment.setLocation(10, 180);
		add(textComment);

		btnComment = new JButton("Comment");
		btnComment.setSize(90, 30);
		btnComment.setLocation(240, 200);
		add(btnComment);

		JScrollPane js = new JScrollPane(jPanel);
		js.setPreferredSize(new Dimension(300, 300));
		add(js);
		
		System.out.println(statuses.size());
		for (Status status : statuses) {
			System.out.println(status);
		}
//		for (Comment comment : comments) {
//			System.out.println(comment.toString());
//		}
	}

	public List<Status> showFriendStatus(String profileName) {
		friends = friendListService.getFriendList(profileName);
		List<Status> statuses = statusService.getAllStatus();
		for (Status status : statuses) {
			System.out.println(status);
		}
		List<Status> filteredStatuses = new ArrayList<Status>();
		for (int i = 0; i < friends.size(); i++) {
			for (Status status : statuses) {
				if (status.getProfile().getProfileName().equals(friends.get(i).getProfileName())) {
					filteredStatuses.add(status);
				}
			}
		}
		Collections.reverse(filteredStatuses);
		return filteredStatuses;
	}

//	public List<Comment> getCommentInPost() {
//		List<Comment> comments = commentService.getAllComments();
//		return comments;
//	}

	public static void main(String[] args) {
		StatusFrame statusFrame = new StatusFrame();
		statusFrame.setVisible(true);
	}
}
