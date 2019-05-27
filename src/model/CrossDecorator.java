package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import view.MainMenu;

public class CrossDecorator extends Decorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean mouse_over; // true when mose over button
	private JComponent thisComp;

	public CrossDecorator(JComponent c) {
		super(c);
		mouse_over = false;
		thisComp = this; // save this component
		// catch mouse movements in inner class
		c.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				mouse_over = true; // set flag when mouse over

				thisComp.repaint();
			}

			public void mouseExited(MouseEvent e) {
				mouse_over = false; // clear flag when mouse not over
				thisComp.repaint();
			}
		});
	}

	// paint the button
	public void paint(Graphics g) {
		super.paint(g); // first draw the parent button
		if (mouse_over) {
			// if the mouse is not over the button
			// erase the borders
			Dimension size = super.getSize();
			// ImageIcon icore = new ImageIcon("src/model/ufo.png");
			// PlayWindow.pauseButton.setIcon(icore);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(0, 0, size.width - 1, size.height - 1);
			g.drawRect(1, 1, size.width - 3, size.height - 3);
			g.drawRect(2, 2, size.width - 5, size.height - 5);

		}
	}
}
