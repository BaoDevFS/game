package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import controller.MouseMovementListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton pauseButton, startButton, resumeButton;
	public static JTextField enemyStats;
	public static JTextField powerStats;

	public PlayWindow() {
		// setPreferredSize(new Dimension(Main.WIN_WIDTH, Main.WIN_HEIGHT));
		setLayout(new BorderLayout());

		add(Main.gameBoard, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		ImageIcon istart = new ImageIcon("src/view/start.png");
		ImageIcon ipause = new ImageIcon("src/view/pause.png");
		ImageIcon iresume = new ImageIcon("src/view/resume.png");
		startButton = new JButton();
		pauseButton = new JButton();
		resumeButton = new JButton();

		startButton.setIcon(istart);
		startButton.setBorder(null);
		startButton.setFocusPainted(false);
		startButton.setContentAreaFilled(false);

		pauseButton.setIcon(ipause);
		pauseButton.setBorder(null);
		pauseButton.setFocusPainted(false);
		pauseButton.setContentAreaFilled(false);

		resumeButton.setIcon(iresume);
		resumeButton.setBorder(null);
		resumeButton.setFocusPainted(false);
		resumeButton.setContentAreaFilled(false);

		startButton.setVisible(true);
		pauseButton.setVisible(false);
		resumeButton.setVisible(false);

		southPanel.add(startButton);
		southPanel.add(resumeButton);
		southPanel.add(pauseButton);

		add(southPanel, BorderLayout.SOUTH);

		ButtonListener buttonListener = new ButtonListener();
		startButton.addActionListener(buttonListener);
		pauseButton.addActionListener(buttonListener);
		resumeButton.addActionListener(buttonListener);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));
		northPanel.add(enemyStats = new JTextField());
		northPanel.add(powerStats = new JTextField());
		enemyStats.setEditable(false);
		powerStats.setEditable(false);
		enemyStats.setFocusable(false);
		powerStats.setFocusable(false);
		add(northPanel, BorderLayout.NORTH);

		MouseController mouseController = new MouseController();
		Main.gameBoard.addMouseListener(mouseController);

		KeyController keyListener = new KeyController();

		Main.gameBoard.addKeyListener(keyListener);
		// Main.gameBoard.setFocusable(false);
		// // just have one Component "true", the rest must be "false"
		// startButton.setFocusable(false);
		// quitButton.setFocusable(false);

		MouseMovementListener mouseMovement = new MouseMovementListener();
		Main.gameBoard.addMouseMotionListener(mouseMovement);

		this.setVisible(false);

	}

}
