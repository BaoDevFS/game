package model;

public class StoreObject {
	CreateObject createObject;
	public static final int BOOM=0;
	public static final int SAUCER=1;
	public static final int POWERUP=2;
	public static final int RADIUS = 6;
	public StoreObject(CreateObject createObject) {
		this.createObject = createObject;
	}
	public GameFigure createObject(int type) {
		return createObject.createObject(type);
	}
}
