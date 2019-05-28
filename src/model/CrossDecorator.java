package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class CrossDecorator extends Decorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrossDecorator(JComponent c) {
		super(c);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(1, 0, this.getWidth(), this.getHeight() - 1);
		g.drawLine(this.getWidth(), 0, 0, this.getHeight() - 1);
		g.drawLine(this.getWidth() - 1, 0, 0, this.getHeight() - 2);
	}
}
