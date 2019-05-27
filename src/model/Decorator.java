package model;

import java.awt.BorderLayout;
import javax.swing.JComponent;

public class Decorator extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Decorator(JComponent c) {
		setLayout(new BorderLayout());
		add("Center", c);
	}
}
