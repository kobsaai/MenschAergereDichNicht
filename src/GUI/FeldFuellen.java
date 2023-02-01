package GUI;

import javax.swing.JPanel;

public class FeldFuellen {

	public FeldFuellen (JPanel pane, Spieler player) {
		int x1 = player.startFeld[0][0];
		int x2 = player.startFeld[1][0];
		int y1 = player.startFeld[0][1];
		int y2 = player.startFeld[2][1];
		SpielFigur yellow3 = new SpielFigur(player.img, player);
		yellow3.setBounds(40, 105, 53, 56);
		pane.add(yellow3);
	}
}
