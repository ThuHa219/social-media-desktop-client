package edu.hanu.social_media_desktop_client.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.hanu.social_media_desktop_client.utils.PlaceHolderTextField;

public class StatusListGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lbName;
	private JLabel lbTime;
	private JLabel lbStatus;
	private JLabel lbCommenterName;
	private JLabel lbCommentTime;
	private JLabel lbComment;
	private PlaceHolderTextField textComment;
	private JButton btnComment;

	public StatusListGUI() {

		JPanel listContainer;
		final JFrame frame = new JFrame("Homepage");
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		listContainer = new JPanel();
		listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
		JScrollPane jScrollPane = new JScrollPane(listContainer);
		frame.add(jScrollPane, BorderLayout.CENTER);
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridLayout(0, 2));

		for (int i = 1; i <= 20; i++) {
			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new GridLayout(0, 1));
			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(new FlowLayout());
			rightPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

			lbName = new JLabel("Vuong Khanh Linh" + i);
			leftPanel.add(lbName);

			lbTime = new JLabel("20/11/2020");
			leftPanel.add(lbTime);

			lbStatus = new JLabel("It's awesome dayyyyyyyyyy.");
			leftPanel.add(lbStatus);

			lbCommenterName = new JLabel("Tran Thu Hien");
			leftPanel.add(lbCommenterName);

			lbCommentTime = new JLabel("22/22/2020");
			leftPanel.add(lbCommentTime);

			lbComment = new JLabel("Ohh wowwwww");
			leftPanel.add(lbComment);

			textComment = new PlaceHolderTextField(30);
			textComment.setPlaceholder("Add comment about this post");
			textComment.setPreferredSize(new Dimension(400, 40));
			leftPanel.add(textComment);

			btnComment = new JButton("Comment");
			btnComment.setPreferredSize(new Dimension(100, 30));
			rightPanel.add(btnComment);
			leftPanel.add(rightPanel);

			JPanel cJp = new JPanel();
			cJp.setLayout(new GridLayout(1, 2));
			cJp.add(leftPanel);
			newPanel.add(cJp);
			newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));

			listContainer.add(newPanel);
			listContainer.revalidate();

		}

		frame.setVisible(true);

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		StatusListGUI homePageGUI = new StatusListGUI();
	}
}
