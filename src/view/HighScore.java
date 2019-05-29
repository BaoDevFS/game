package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.Main;
 
public class HighScore extends JPanel{
	JPanel jPanel;
	Image image;
	JLabel lb;
	public HighScore() {
		createPanel();
		setLayOut();
		setVisible(false);
	}
	private void setLayOut() {
		  SpringLayout layout = new SpringLayout();

	        layout.putConstraint(SpringLayout.NORTH,jPanel, (int) ((Main.WIN_HEIGHT - jPanel.getPreferredSize().getHeight()) / 2),
	              SpringLayout.NORTH, this);
	       layout.putConstraint(SpringLayout.WEST, jPanel, (int) ((Main.WIN_WIDTH - jPanel.getPreferredSize().getWidth()) / 2),
	               SpringLayout.WEST, this);
//	        this.setBackground(Color.gray);
	        this.setLayout(layout);
	}
	private void createPanel() {
		jPanel = new PanelOption();
	    jPanel.setPreferredSize(new Dimension(250, 350));
	    jPanel.setMaximumSize(new Dimension(250, 350));
	    jPanel.setMinimumSize(new Dimension(250, 350));
	    jPanel.setLayout(new GridLayout(3, 2, 2, 2));
	    for (int i = 0; i <model.HighScore.MAXELEMENT; i++) {
			lb= new JLabel((i+1)+":");
			lb.setForeground(Color.green);
			jPanel.add(lb);
			lb = new JLabel(model.HighScore.highScore.get(i));
			lb.setForeground(Color.GREEN);
			jPanel.add(lb);
			}
	    add(jPanel);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			 image=ImageIO.read(getClass().getResource("menuBackground.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, null);
		
	}
}
