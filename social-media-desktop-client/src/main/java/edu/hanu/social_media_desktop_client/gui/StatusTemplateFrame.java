package edu.hanu.social_media_desktop_client.gui;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

public class StatusTemplateFrame extends Frame {
	/**
	 * 
	 */
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

	public StatusTemplateFrame() {
		setSize(350, 380);
		setLocation(500, 100);
		setLayout(null);
		initPanels();
		setVisible(true);
	}

	private void initPanels() {
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
//alo để mình show cái dạng status cho nhé
		btnLike = new JButton("Like");
		btnLike.setSize(60, 20);
		btnLike.setLocation(20, 90);
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

//		lbName = new JLabel("Vuong Khanh Linh");
//		lbName.setSize(300, 40);
//		lbName.setLocation(20, 250);
//		add(lbName);
//
//		lbTime = new JLabel("20/11/2020");
//		lbTime.setSize(300, 40);
//		lbTime.setLocation(20, 300);
//		add(lbTime);
//
//		lbStatus = new JLabel("It's awesome dayyyyyyyyyy.");
//		lbStatus.setSize(300, 40);
//		lbStatus.setLocation(20, 350);
//		add(lbStatus);
//
//		btnLike = new JButton("Like");
//		btnLike.setSize(60, 20);
//		btnLike.setLocation(20, 400);
//		add(btnLike);
//
//		lbCommenterName = new JLabel("Tran Thu Hien");
//		lbCommenterName.setSize(100, 20);
//		lbCommenterName.setLocation(40, 450);
//		add(lbCommenterName);
//
//		lbCommentTime = new JLabel("22/22/2020");
//		lbCommentTime.setSize(100, 20);
//		lbCommentTime.setLocation(150, 500);
//		add(lbCommentTime);
//
//		lbComment = new JLabel("Ohh wowwwww");
//		lbComment.setSize(100, 20);
//		lbComment.setLocation(20, 550);
//		add(lbComment);
//
//		textComment = new PlaceHolderTextField(30);
//		textComment.setPlaceholder("Write some comments about this post!");
//		textComment.setSize(220, 70);
//		textComment.setLocation(10, 600);
//		add(textComment);
//
//		btnComment = new JButton("Comment");
//		btnComment.setSize(90, 30);
//		btnComment.setLocation(240, 650);
//		add(btnComment);

	}

	public static void main(String[] args) {
		StatusPanel statusPanel = new StatusPanel();
		statusPanel.setVisible(true);
	}
}
