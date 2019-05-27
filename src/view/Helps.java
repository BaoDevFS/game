package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Helps extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String strImagePath = "helpgame.PNG";
	public JLabel contentBackground;
	JLabel t;

	public Helps() {
		contentBackground = new JLabel(new ImageIcon(getClass().getResource(strImagePath)));
		add(contentBackground);

		t = new JLabel("<html> - Click Play to start playing the game <br>"
				+ "- Click Score to see the player's high score <br>" 
				+ "- Click Exit to exit the game screen </html>");
		t.setFocusable(false);
		add(t, BorderLayout.NORTH);

		JPanel p = new JPanel();
		JLabel l = new JLabel("---Wish you all good game---");
		p.add(l);
		add(p, BorderLayout.SOUTH);

		setTitle("Help");
		setSize(350, 350);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Helps();
	}
}
