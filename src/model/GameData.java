package model;

import controller.Main;
import controller.Quadtree;
import view.GameBoard;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameData {
	public static HighScore highScore;
	private final int RADIUS = 6;
	public static Shooter shooter;
	public static WeaponComponent weapon;
	public final List<GameFigure> gameFigures;
	public final Quadtree quadtree;
	private boolean started = false; //////////////
	private final int MAX_SAUCERS = 10;
	private final int MAX_POWERUPS = 10;
	private final int MAX_BOMBS = 12;
	private StoreObject storeObject;
	private CreateObject createObject;
	public static Background bg;

	public GameData() {
		highScore = new HighScore();
		createObject = new CreateObject();
		storeObject = new StoreObject(createObject);
		gameFigures = Collections.synchronizedList(new ArrayList<GameFigure>());
		shooter = new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT / 2);

		gameFigures.add(shooter);
		weapon = new BasicWeapon();

		quadtree = new Quadtree(1, new Rectangle2D.Double(0, 0, Main.WIN_WIDTH, Main.WIN_HEIGHT));

		bg = new Background();

	}

	public void start() {
		while (PowerUp.powerAlive < MAX_POWERUPS) {
			addPower();
		}
		while (Bomb.bombsAlive < MAX_BOMBS) {
			addBomb();
		}
		while (FlyingSaucer.saucersAlive < MAX_SAUCERS) {
			addSaucer();
		}
		started = true;
	}

	public void addPower() {
		synchronized (gameFigures) {
			gameFigures.add(storeObject.createObject(StoreObject.POWERUP));
		}
	}

	public void addSaucer() {
		synchronized (gameFigures) {
			gameFigures.add(storeObject.createObject(StoreObject.SAUCER));
		}
	}

	public void addBomb() {
		synchronized (gameFigures) {
			gameFigures.add(storeObject.createObject(StoreObject.BOOM));
		}
	}

	public void update() {
		bg.update();
		synchronized (gameFigures) {
			ArrayList<GameFigure> remove = new ArrayList<>();
			GameFigure f;
			for (int i = 0; i < gameFigures.size(); i++) {
				f = gameFigures.get(i);
				if (f.state == GameFigure.STATE_DONE) {
					remove.add(f);
				}
			}

			for (int i = 0; i < remove.size(); i++) {
				remove.get(i).addDead();
			}
			gameFigures.removeAll(remove);

			quadtree.clear();
			if (started) {
				start();
			}

			for (GameFigure g : gameFigures) {
				g.update();
				quadtree.insert(g);
			}
		}
	}

}
