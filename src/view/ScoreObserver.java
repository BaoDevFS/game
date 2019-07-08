package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

public class ScoreObserver extends JTextField implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int score = 0;

	public ScoreObserver(Observable o) {
		o.addObserver(this);
		display();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UpdateParemeter) {
			this.score = ((UpdateParemeter) o).getScore();
			display();
		}

	}

	private void display() {
		this.setText("Score " + this.score);
		
	}

}
