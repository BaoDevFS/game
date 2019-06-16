package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.ButtonListener;
import model.BorderDecorator;
import model.CrossDecorator;

public class MainMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel contentBackground;
	private JButton playButton, coreButton, helpButton, exitButton;
	public JPanel buttonsPanel;
	

	public JButton getPlayButton() {
		return playButton;
	}


	public JButton getCoreButton() {
		return coreButton;
	}


	public JButton getHelpButton() {
		return helpButton;
	}


	public JButton getExitButton() {
		return exitButton;
	}


	public MainMenu() {

		this.contentBackground = new JLabel(new ImageIcon(getClass().getResource("menuBackground.gif")));
		SpringLayout layout = new SpringLayout();
		contentBackground.setLayout(layout);
		this.add(contentBackground);
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(4, 1, 5, 10));
		
		buttonsPanel.setOpaque(false);  // setting panel to transparent

		ImageIcon iplay = new ImageIcon("src/ImageGame/play.png");
		playButton = new JButton();
		playButton.setActionCommand("play");
		playButton.setIcon(iplay);
		playButton.setBorder(null);
		playButton.setFocusPainted(false);
		playButton.setContentAreaFilled(false);
		buttonsPanel.add(new BorderDecorator(playButton));

		ImageIcon icore = new ImageIcon("src/ImageGame/score.png");
		coreButton = new JButton();
		coreButton.setActionCommand("score");
		
		coreButton.setIcon(icore);
		coreButton.setBorder(null);
		coreButton.setFocusPainted(false);
		coreButton.setContentAreaFilled(false);
		buttonsPanel.add(new BorderDecorator(coreButton));

		ImageIcon ihelp = new ImageIcon("src/ImageGame/help.png");
		helpButton = new JButton();
		helpButton.setActionCommand("help");
		helpButton.setIcon(ihelp);
		helpButton.setBorder(null);
		helpButton.setFocusPainted(false);
		helpButton.setContentAreaFilled(false);
		buttonsPanel.add(new BorderDecorator(helpButton));

		ImageIcon iexit = new ImageIcon("src/ImageGame/exit.png");
		exitButton = new JButton();
		exitButton.setActionCommand("exit");
		exitButton.setIcon(iexit);
		exitButton.setBorder(null);
		exitButton.setFocusPainted(false);
		exitButton.setContentAreaFilled(false);
		buttonsPanel.add(new CrossDecorator(new BorderDecorator(exitButton)));

		contentBackground.add(buttonsPanel);

		layout.putConstraint(SpringLayout.NORTH, buttonsPanel,
				(int) (this.getPreferredSize().getHeight() / 2 - buttonsPanel.getPreferredSize().getHeight()),
				SpringLayout.NORTH, contentBackground);
		layout.putConstraint(SpringLayout.WEST, buttonsPanel,
				(int) (this.getPreferredSize().getWidth() / 2 - buttonsPanel.getPreferredSize().getWidth() / 2),
				SpringLayout.WEST, contentBackground);

		ButtonListener buttonListener = new ButtonListener(this);
		playButton.addActionListener(buttonListener);
		helpButton.addActionListener(buttonListener);
		coreButton.addActionListener(buttonListener);
		exitButton.addActionListener(buttonListener);

		this.setVisible(true);

	}

}
