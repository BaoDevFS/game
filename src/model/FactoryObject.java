package model;

import view.GameBoard;

public class FactoryObject {
	GameFigure gameFigure;
	public static final int BOOM=0;
	public static final int POWERUP=1;
	public static final int RADIUS=6;
	public static final int SAUCER=2;
	public GameFigure createObject(int type) {
		if(type==FactoryObject.BOOM) {
			return gameFigure = new Bomb((float) (Math.random() * GameBoard.width), -5.0f);
		}else if(type==FactoryObject.POWERUP) {
			return gameFigure = new PowerUp((int) (Math.random() * GameBoard.width),
					(int) (Math.random() * GameBoard.height), FactoryObject.RADIUS);
		}else if(type==FactoryObject.SAUCER) {
			return gameFigure = new FlyingSaucer((int) (Math.random() * GameBoard.width),
					(int) (Math.random() * (GameBoard.height / 2)));
		}
		return null;
	}
}
