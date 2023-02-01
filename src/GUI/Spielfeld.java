package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Spielfeld extends JPanel {

	private Image background;
	/**
	 * Create the panel.
	 */
	public Spielfeld() {
		setLayout(new BorderLayout());
		background = Toolkit.getDefaultToolkit().createImage("background.png");

	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(background.getWidth(this), background.getHeight(this));
	}
	
	

}
