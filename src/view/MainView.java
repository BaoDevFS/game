package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static PlayWindow playWindow;
	public static MainMenu mainMenu;
	public static JPanel panelParent;

	public MainView() {
		panelParent = new JPanel();
		panelParent.setLayout(new CardLayout());
		createMainMenu();
		createPlayWindow();

		this.add(panelParent);

	}

	private void createPlayWindow() {
		playWindow = new PlayWindow();
		panelParent.add(playWindow);

	}


	private void createMainMenu() {
		mainMenu = new MainMenu();
		panelParent.add(mainMenu);

	}

}
