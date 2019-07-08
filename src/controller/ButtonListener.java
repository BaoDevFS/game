package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.Helps;
import view.MainMenu;
import view.MainView;
import view.PlayWindow;

public class ButtonListener implements ActionListener {
	JPanel pn;

	public ButtonListener(JPanel pn) {
		super();
		this.pn = pn;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "play":
			Animator.running = true;
			MainView.mainMenu.setVisible(false);
			MainView.playWindow.setVisible(true);
			Main.gameBoard.requestFocus();
			break;
		case "exit":
			try {
				int n = JOptionPane.showConfirmDialog(((MainMenu) pn).getExitButton(), "Are you sure you want to quit?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION)
					System.exit(0);
			} catch (Exception e2) {
			}
			break;
		case "score":
			MainView.mainMenu.setVisible(false);
			MainView.highScore.setVisible(true);
			Main.gameBoard.requestFocus();
			break;
		case "help":
			new Helps();
			break;
		case "back":
			MainView.mainMenu.setVisible(true);
			MainView.highScore.setVisible(false);
			Main.gameBoard.requestFocus();
			break;
		case "start":
			Main.gameData.start();
			((PlayWindow)pn).getPauseButton().setVisible(true);
			((PlayWindow)pn).getStartButton().setVisible(false);
			Main.gameBoard.requestFocus();
			break;
		case "pause":
			Animator.running = (Animator.running) ? false : true;
			((PlayWindow)pn).getPauseButton().setVisible(false);
			((PlayWindow)pn).getResumeButton().setVisible(true);
			break;
		case "resume":
			Animator.running = (Animator.running) ? false : true;
			((PlayWindow)pn).getResumeButton().setVisible(false);
			((PlayWindow)pn).getPauseButton().setVisible(true);
			Main.gameBoard.requestFocus();
			break;
		}
	}
}
