package controller;

import java.util.ArrayList;
import java.util.List;
import model.FlyingSaucer;
import model.GameFigure;
import model.PowerUp;
import model.Shooter;
import view.MainView;
import view.PlayWindow;

public class Animator implements Runnable {

	public static boolean running = false;
	private final int FRAMES_PER_SECOND = 15;

	@Override
	public void run() {
		while (true) {
			
			if (running) {

				long startTime = System.currentTimeMillis();
				processCollisions();
				Main.gameData.update();
				Main.gameBoard.gameRender();
				Main.gameBoard.printScreen();

				long endTime = System.currentTimeMillis();
				int sleepTime = (int) (1000 / FRAMES_PER_SECOND) - (int) (endTime - startTime);

				if (sleepTime > 0) {
					try {
						Thread.sleep(sleepTime); // ms
					} catch (InterruptedException e) {

					}
				}
			}
			// System.out.println(running);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private synchronized void processCollisions() {
		List<GameFigure> returnObjects = new ArrayList<GameFigure>();
		for (int i = 0; i < Main.gameData.gameFigures.size(); i++) {
			GameFigure figure = Main.gameData.gameFigures.get(i);

			returnObjects.clear();
			Main.gameData.quadtree.retrieve(returnObjects, figure);
			for (GameFigure returnObject : returnObjects) {

				// Run collision detection algorithm between objects
				if (returnObject.getCollisionBox().intersects(figure.getCollisionBox())) {
					// objects with same alliance cannot collide
					if (figure.alliance != returnObject.alliance && figure.state == GameFigure.STATE_ALIVE
							&& returnObject.state == GameFigure.STATE_ALIVE) {
						// enemy and friend collide
						if (!(figure instanceof PowerUp) && !(returnObject instanceof PowerUp)) {
							if ((figure instanceof Shooter) || (returnObject instanceof Shooter)) {
								returnObject.nextState();
								figure.nextState();
								return;
							}
							returnObject.nextState();
						}
						// friend and powerup collide
						else if (figure.alliance != GameFigure.ALLIANCE_ENEMY
								&& returnObject.alliance != GameFigure.ALLIANCE_ENEMY) {
							// shooter eats powerUp's
							if (figure instanceof Shooter) {
								returnObject.nextState();
								Shooter.powerUpsCollected++;
							}
						}
						// enemy and powerup
						else if (figure.alliance != GameFigure.ALLIANCE_FRIEND
								&& returnObject.alliance != GameFigure.ALLIANCE_FRIEND) {
							// enemy eats powerUp's
							if (figure.alliance == GameFigure.ALLIANCE_ENEMY) {
								returnObject.nextState();
								figure.powerUpCollected();
							}
						}
					}
				}
			}
		}

		// Score Update
		PlayWindow.enemyStats.setText("UFOs destroyed: " + FlyingSaucer.saucersDead + "     Power Up's Collected: "
				+ Shooter.powerUpsCollected);
		PlayWindow.powerStats.setText("Score: " + (Shooter.powerUpsCollected + FlyingSaucer.saucersDead * 5));

	}

}
