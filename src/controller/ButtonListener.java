package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainMenu;
import view.MainView;
import view.PlayWindow;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == MainMenu.playButton) {
			System.out.println("start");
			Animator.running = true;
			MainView.mainMenu.setVisible(false);
			MainView.playWindow.setVisible(true);
			Main.gameBoard.requestFocus();
		}

		if (ae.getSource() == PlayWindow.startButton) {
			Main.gameData.start();;
			PlayWindow.pauseButton.setVisible(true);
			PlayWindow.startButton.setVisible(false);
			Main.gameBoard.requestFocus();
		}

		if (ae.getSource() == PlayWindow.pauseButton) {
			Animator.running = (Animator.running) ? false : true;
			PlayWindow.pauseButton.setVisible(false);
			PlayWindow.resumeButton.setVisible(true);

		}

		if (ae.getSource() == PlayWindow.resumeButton) {
			Animator.running = (Animator.running) ? false : true;
			PlayWindow.resumeButton.setVisible(false);
			PlayWindow.pauseButton.setVisible(true);
			Main.gameBoard.requestFocus();
		}
	}

}
