package model;

import controller.Main;
import view.GameBoard;

public class CreateObject {
	GameFigure gameFigure;
	public GameFigure createObject(int type) {
		if(type==StoreObject.BOOM) {
			return gameFigure = new Bomb((float) (Math.random() * GameBoard.width), -5.0f);
		}else if(type==StoreObject.POWERUP) {
			return gameFigure = new PowerUp((int) (Math.random() * GameBoard.width),
					(int) (Math.random() * GameBoard.height), StoreObject.RADIUS);
		}else if(type==StoreObject.SAUCER) {
			return gameFigure = new FlyingSaucer((int) (Math.random() * GameBoard.width),
					(int) (Math.random() * (GameBoard.height / 2)));
		}
		return null;
	}
}
