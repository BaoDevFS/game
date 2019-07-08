package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class OtherObserver extends JTextField implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ufosDestroyed = 0;
	private int powerUpsCollected = 0;

	public OtherObserver(Observable o) {
		display();
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UpdateParemeter) {
			this.ufosDestroyed = ((UpdateParemeter) o).getUfosDestroyed();
			this.powerUpsCollected = ((UpdateParemeter) o).getPowerUpsCollected();
			display();
		}

	}

	private void display() {
		this.setText("UFOs destroyed: " + ufosDestroyed + "     Power Up's Collected: " + powerUpsCollected);

	}

}
