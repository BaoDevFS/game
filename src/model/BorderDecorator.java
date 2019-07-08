package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class BorderDecorator extends Decorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean mouse_over; // true when mose over button

	public BorderDecorator(JComponent c) {
		super(c);
		mouse_over = false;
		c.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				mouse_over = true;
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				mouse_over = false;
				repaint();
			}
		});
	}

	// paint the button
	public void paint(Graphics g) {
		super.paint(g); // first draw the parent button
		if (mouse_over) {
			Dimension size = super.getSize();
			g.setColor(Color.YELLOW);
			g.drawRect(0, 0, size.width - 1, size.height - 1);
			g.drawRect(1, 1, size.width - 3, size.height - 3);
			g.drawRect(2, 2, size.width - 5, size.height - 5);

		}
	}
}
