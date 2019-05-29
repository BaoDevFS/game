package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelOption extends JPanel{
	Image image;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			image = ImageIO.read(getClass().getResource("menuBackground.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, null);
	}
}
