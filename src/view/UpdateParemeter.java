package view;

import java.util.Observable;

public class UpdateParemeter extends Observable {
	public int ufosDestroyed;
	public int powerUpsCollected;
	public int score;

	public UpdateParemeter() {
		this.ufosDestroyed = 0;
		this.powerUpsCollected = 0;
		this.score = 0;
	}

	public void measurementsChanged() {
		updateScore();
		setChanged();
		notifyObservers();
	}

	public void updateUFOsDestroyed() {
		this.ufosDestroyed++;
		measurementsChanged();
	}

	public void updatePowerUpsCollected() {
		this.powerUpsCollected++;
		measurementsChanged();
	}

	public void updateScore() {
		this.score = this.powerUpsCollected + this.ufosDestroyed * 5;
	}

}
