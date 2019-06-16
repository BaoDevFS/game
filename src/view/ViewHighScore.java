package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.ButtonListener;
import controller.Main;
 
public class ViewHighScore extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jPanel, panel ;
	Image image;
	JLabel lb;
	private JButton backOnHighScore;
	
	public JButton getBackOnHighScore() {
		return backOnHighScore;
	}
	public ViewHighScore() {
		
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
	       layout.putConstraint(SpringLayout.SOUTH, panel, (int) ((Main.WIN_HEIGHT - panel.getPreferredSize().getWidth())),
	               SpringLayout.WEST, this);
	       layout.putConstraint(SpringLayout.WEST, panel, (int) ((Main.WIN_WIDTH - panel.getPreferredSize().getWidth())/2),
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
	    backOnHighScore = new JButton("back");
	    backOnHighScore.setActionCommand("back");
	    ButtonListener buttonListener = new ButtonListener(this);
	    backOnHighScore.addActionListener(buttonListener);
	    for (int i = 0; i <model.HighScore.MAXELEMENT; i++) {
			lb= new JLabel((i+1)+":");
			lb.setForeground(Color.green);
			jPanel.add(lb);
			lb = new JLabel(model.HighScore.highScore.get(i));
			lb.setForeground(Color.GREEN);
			jPanel.add(lb);
			}
	    panel = new JPanel();
	    panel.add(backOnHighScore);
	    add(jPanel);
	    add(panel);
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
