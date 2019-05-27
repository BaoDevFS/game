package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.GameBoard;

public class Background {

	private Image bgImage1;
	private Image bgImage2;

	private float width;
	private float height;
	private float y;

	private float scrollAmount = 2.0f;

	Background() {
		height = GameBoard.height;
		width = GameBoard.width;
		y = 0;
		bgImage1 = null;
		bgImage2 = null;
		try {
			bgImage1 = ImageIO.read(getClass().getResource("Parallax60.png"));
			bgImage2 = ImageIO.read(getClass().getResource("Parallax60.png"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: Cannot open bgImage.png");
			System.exit(-1);
		}
	}

	public void update() {
		height = GameBoard.height;
		width = GameBoard.width;
		y += scrollAmount;
		if (y > GameBoard.height) {
			y = 0;
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(bgImage1, 0, (int) (y), (int) width, (int) height, null);
		g.setColor(Color.green);
		g.drawLine(0, (int) y, (int) GameBoard.width, (int)y);
		g.drawImage(bgImage2, 0, (int) (y - height), (int) width, (int) height, null);

	}

}
