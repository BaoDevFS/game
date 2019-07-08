package controller;

import javax.swing.JFrame;
import model.GameData;
import view.GameBoard;
import view.MainView;

public class Main {

	public static GameBoard gameBoard;
	public static GameData gameData;
	public static Animator animator;

	public static int WIN_WIDTH = 700;
	public static int WIN_HEIGHT = 600;

	public static void main(String[] args) {

		animator = new Animator();
		gameData = new GameData();
		gameBoard = new GameBoard();

		JFrame game = new MainView();
		//dw
		game.setTitle("UFO KILLER");
		game.setSize(WIN_WIDTH, WIN_HEIGHT);
		game.setLocation(100, 0);
		game.setResizable(false); // window size cannot change
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLocationRelativeTo(null);
		game.setVisible(true);

		// start animation
		new Thread(animator).start();

	}
}
