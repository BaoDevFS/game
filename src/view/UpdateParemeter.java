package view;

import java.util.Observable;

public class UpdateParemeter extends Observable {
	private int ufosDestroyed;
	private int powerUpsCollected;
	private int score;
	private static UpdateParemeter uniqueInstance  = new UpdateParemeter();
	

	public static UpdateParemeter getUniqueInstance() {
		return uniqueInstance;
	}

	public int getUfosDestroyed() {
		return ufosDestroyed;
	}

	public int getPowerUpsCollected() {
		return powerUpsCollected;
	}

	public int getScore() {
		return score;
	}

	private UpdateParemeter() {
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
