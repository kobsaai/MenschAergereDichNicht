package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import GUI.Start;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpielFigur extends BackgroundPanel implements MouseListener {
	Spieler s;

	public SpielFigur(Image img, Spieler s) {
		super(img);
		this.s = s;
		this.addMouseListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (Spieler.wuerfel == 0) {
			JOptionPane.showMessageDialog(getParent(), "Du musst zuerst Wuerfeln!");
		} else {
			if (!s.active) {
				JOptionPane.showMessageDialog(getParent(), "Falsche Figur, ziehe mit deiner Farbe!");
			} else {
				int[] koords = Spieler.moveFigure(SpielFigur.this, Spieler.wuerfel, s);
				if (koords[0] == 0 && koords[1] == 0) {
					if (!Spieler.testeFigurDrausen(s)) {
						JOptionPane.showMessageDialog(getParent(),
								"Du musst eine 6 Wuerfeln um aus dem StartBereich zu kommen");
						Spieler.setActivePlayer();
						Start2.txtpnZugVonSpieler.setText("Zug von Spieler " + Start2.activePlayer);
						Spieler.wuerfel = 0;
					} else {
						JOptionPane.showMessageDialog(getParent(), "Mit dieser Figur kannst du nicht treten");

					}
				} else {
					if (Spieler.testePosition(koords, s)) {
						if (Spieler.testePositionFremd(koords)) {
							JOptionPane.showMessageDialog(getParent(), "Ups du hast deinen Gegner geschlagen");
						}
						SpielFigur.this.setLocation(koords[0], koords[1]);
						Spieler.setActivePlayer();
						Start2.txtpnZugVonSpieler.setText("Zug von Spieler " + Start2.activePlayer);
						Spieler.wuerfel = 0;

					} else {

						JOptionPane.showMessageDialog(getParent(), "Leider kannst du mit dieser Figur keine "
								+ Spieler.wuerfel + " Felder laufen! \nBitte neue Figur waehlen");

					}
					// Spieler.setWuerfel(0);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * { JLabel background; ImageIcon img = new ImageIcon("background.png");
	 * 
	 * background = new JLabel("",img,JLabel.CENTER);
	 * background.setBounds(0,0,900,800); add(background); setVisible(true); }
	 */

}
