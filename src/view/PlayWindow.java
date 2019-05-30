package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import controller.MouseMovementListener;
import model.BorderDecorator;

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
	public static JTextField otherObserverDisplay;
	public static JTextField scoreObserverDisplay;
	public static UpdateParemeter updateParemeter;

	public UpdateParemeter getUpdateParemeter() {
		return updateParemeter;
	}

	public PlayWindow() {
		updateParemeter = new UpdateParemeter();

		setLayout(new BorderLayout());

		add(Main.gameBoard, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		ImageIcon istart = new ImageIcon("src/imageGame/start.png");
		ImageIcon ipause = new ImageIcon("src/imageGame/pause.png");
		ImageIcon iresume = new ImageIcon("src/imageGame/resume.png");
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

		southPanel.add(new BorderDecorator(startButton));
		southPanel.add(new BorderDecorator(resumeButton));
		southPanel.add(new BorderDecorator(pauseButton));

		add(southPanel, BorderLayout.SOUTH);

		ButtonListener buttonListener = new ButtonListener();
		startButton.addActionListener(buttonListener);
		pauseButton.addActionListener(buttonListener);
		resumeButton.addActionListener(buttonListener);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));
		northPanel.add(otherObserverDisplay = new OtherObserver(updateParemeter));
		northPanel.add(scoreObserverDisplay = new ScoreObserver(updateParemeter));
		otherObserverDisplay.setEditable(false);
		scoreObserverDisplay.setEditable(false);
		otherObserverDisplay.setFocusable(false);
		scoreObserverDisplay.setFocusable(false);
		add(northPanel, BorderLayout.NORTH);

		MouseController mouseController = new MouseController();
		Main.gameBoard.addMouseListener(mouseController);

		KeyController keyListener = new KeyController();
		Main.gameBoard.addKeyListener(keyListener);
		MouseMovementListener mouseMovement = new MouseMovementListener();
		Main.gameBoard.addMouseMotionListener(mouseMovement);

		this.setVisible(false);

	}

}
