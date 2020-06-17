package edu.hanu.social_media_desktop_client.test;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import edu.hanu.social_media_desktop_client.gui.StatusPanel;

/** @see http://stackoverflow.com/questions/7818387 */
public class ScrollGrid extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatusPanel statusPanel = new StatusPanel();

	public ScrollGrid() {
		this.setLayout(new GridLayout(1, 2, 1, 1));
		this.add(statusPanel);
	}

	private void display() {
		JFrame f = new JFrame("ScrollGrid");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.pack();
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ScrollGrid().display();
			}
		});
	}
}