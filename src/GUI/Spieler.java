package GUI;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Spieler {
	int[][] startFeld;
	int[][] hausFeld;
	int[] firstField;
	Image img;
	boolean active = false;
	static int wuerfel;
	boolean imHaus = false;
	int[] hausMove;
	int[] hausRange;
	ArrayList<SpielFigur> figureList = new ArrayList<SpielFigur>();

	public int[] getHausMove() {
		return hausMove;
	}

	public void setHausMove(int[] hausMove) {
		this.hausMove = hausMove;
	}

	public int[] getHausRange() {
		return hausRange;
	}

	public void setHausRange(int[] hausRange) {
		this.hausRange = hausRange;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int[][] getStartFeld() {
		return startFeld;
	}

	public static int getWuerfel() {
		return wuerfel;
	}

	public static void setWuerfel(int wuerfel) {
		Spieler.wuerfel = wuerfel;
	}

	public void setStartFeld(int[][] startFeld) {
		this.startFeld = startFeld;
	}

	public int[][] getHausFeld() {
		return hausFeld;
	}

	public void setHausFeld(int[][] hausFeld) {
		this.hausFeld = hausFeld;
	}

	public boolean isImHaus() {
		return imHaus;
	}

	public void setImHaus(boolean imHaus) {
		this.imHaus = imHaus;
	}

	public int[] getFirstField() {
		return firstField;
	}

	public void setFirstField(int[] firstField) {
		this.firstField = firstField;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<SpielFigur> getFigureList() {
		return figureList;
	}

	public void setFigureList(ArrayList<SpielFigur> figureList) {
		this.figureList = figureList;
	}

	public static int wuerfel() {
		int augenzahl = (int) (Math.random() * 6 + 1);
		wuerfel = augenzahl;
		return augenzahl;
	}

	public static boolean pruefeFigur(JPanel figur, int[][] startBereich) {
		boolean check = true;
		int x = figur.getX();
		int y = figur.getY();
		for (int i = 0; i < startBereich.length; i++) {
			if (x == startBereich[i][0] && y == startBereich[i][1]) {
				check = false;
			}
		}
		return check;
	}

	public static void pruefeHaus(JPanel figur, Spieler p) {
		boolean check = false;
		int x = figur.getX();
		int y = figur.getY();

		p.setImHaus(check);
	}

	public static boolean pruefeRange(JPanel figur, Spieler p) {
		boolean check = false;
		int x = figur.getX();
		int y = figur.getY();
		for (int i = 0; i < p.getHausFeld().length; i++) {
			if (x == p.getHausFeld()[i][0] && y == p.getHausFeld()[i][1]) {
				check = true;
			}
		}
		return check;
	}

	// bewege allgemein
	public static int[] moveFigure(JPanel figur, int wuerfelZahl, Spieler spieler) {
		int[] koords = new int[2];
		if (pruefeFigur(figur, spieler.getStartFeld())) {
			while (wuerfelZahl != 0) {
				if (Spieler.pruefeRange(figur, spieler)) {
					koords = moveInRange(figur, wuerfelZahl, spieler);
					wuerfelZahl = 0;
					// figur.setLocation(figur.getX() + spieler.hausMove[0], figur.getY() +
					// spieler.hausMove[1]);
					// wuerfelZahl--;
				} else {
					koords = moveAround(figur, wuerfelZahl, spieler);
					wuerfelZahl = 0;
				}
			}
		} else {
			if (wuerfelZahl == 6) {
				koords = spieler.getFirstField();
				wuerfelZahl = 0;
			} /*
				 * else { koords[0] = figur.getX(); koords[1] = figur.getY(); }
				 */
		}

		return koords;
	}

	// bewege wenn in Reichweite von Haus
	public static int[] moveInRange(JPanel figur, int wuerfelZahl, Spieler spieler) {
		int[] koords = new int[2];
		int pos = 0;
		int x = figur.getX();
		int y = figur.getY();
		for (int i = 0; i < spieler.getHausFeld().length; i++) {
			if (x == spieler.getHausFeld()[i][0] && y == spieler.getHausFeld()[i][1]) {
				pos = i;
			}
		}
		if (wuerfelZahl + pos <= 6) {
			koords = spieler.getHausFeld()[pos + wuerfelZahl];
			// figur.setLocation(spieler.getHausFeld()[pos + wuerfelZahl][0],
			// spieler.getHausFeld()[pos+wuerfelZahl][1]);
		}

		return koords;
	}

	public static int[] moveAround(JPanel figur, int wuerfelZahl, Spieler spieler) {
		int[] koords = new int[2];
		koords[0] = figur.getX();
		koords[1] = figur.getY();
		System.out.println(koords[0] + "  |||  " + koords[1]);
		while (wuerfelZahl != 0) {
			if (koords[0] < 304 && koords[1] == 310) {
				koords[0] += 66;
			} else if (koords[0] == 304 && koords[1] > 38 && koords[1] < 400) {
				koords[1] -= 68;
			} else if (koords[0] < 436 && koords[1] == 38) {
				koords[0] += 66;
			} else if (koords[0] == 436 && koords[1] < 310) {
				koords[1] += 68;
			} else if (koords[0] < 700 && koords[1] == 310) {
				koords[0] += 66;
			} else if (koords[0] == 700 && koords[1] < 446) {
				koords[1] += 68;
			} else if (koords[0] > 436 && koords[1] == 446) {
				koords[0] -= 66;
			} else if (koords[0] == 436 && koords[1] < 718) {
				koords[1] += 68;
			} else if (koords[0] > 304 && koords[1] == 718) {
				koords[0] -= 66;
			} else if (koords[0] == 304 && koords[1] > 446) {
				koords[1] -= 68;
			} else if (koords[0] > 40 && koords[1] == 446) {
				koords[0] -= 66;
			} else if (koords[0] == 40 && koords[1] > 310) {
				koords[1] -= 68;
			}
			wuerfelZahl--;
			System.out.println(koords[0] + "  |||  " + koords[1] + "||||      " + wuerfelZahl);

		}
		return koords;
	}

	public static boolean testePositionFremd(int[] koords) {
		boolean newFieldGegner = false;
		int x = 0;
		int y = 0;
		for (int i = 0; i < Start2.spielerAnzahl; i++) {
			if (i != (Start2.activePlayer - 1)) {
				for (int j = 0; j < 4; j++) {
					x = (int) Start2.playerList.get(i).figureList.get(j).getLocation().getX();
					y = (int) Start2.playerList.get(i).figureList.get(j).getLocation().getY();
					if (x == koords[0] && y == koords[1]) {
						Spieler player = Start2.playerList.get(i);
						SpielFigur figur = player.figureList.get(j);
						int x1 = 0;
						int y1 = 0;
						for (int l = 3; l >= 0; l--) {
							x1 = player.startFeld[l][0];
							y1 = player.startFeld[l][1];
							System.out.println("X = " + x1 + " || Y = " + y1 + " || " + player + " || " + l);
							for (int k = 0; k < 4; k++) {
								if (x1 == player.figureList.get(k).getX() && y1 == player.figureList.get(k).getY()) {
									System.out.println(player.figureList.get(k).getX() + " ||  "
											+ player.figureList.get(k).getY());
								} else {
									System.out.println(x1 + " || " + y1);
									figur.setLocation(x1, y1);
								}
							}
						}

						newFieldGegner = true;
					}
				}
			}
		}

		return newFieldGegner;

	}

	public static boolean testePosition(int[] koords, Spieler p) {
		boolean newFieldOpen = true;
		int x = 0;
		int y = 0;
		for (int i = 0; i < 4; i++) {
			x = (int) p.figureList.get(i).getLocation().getX();
			y = (int) p.figureList.get(i).getLocation().getY();
			if (x == koords[0] && y == koords[1]) {
				newFieldOpen = false;
			}
		}
		return newFieldOpen;
	}

	// Setze Ativen Spieler
	public static void setActivePlayer() {
		if (Spieler.wuerfel != 6) {
			if (Start2.activePlayer < Start2.spielerAnzahl) {
				Start2.playerList.get(Start2.activePlayer - 1).setActive(false);
				Start2.playerList.get(Start2.activePlayer).setActive(true);
				Start2.activePlayer++;
			} else {
				Start2.playerList.get(Start2.activePlayer - 1).setActive(false);
				Start2.playerList.get(0).setActive(true);
				Start2.activePlayer = 1;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Du darfst nochmal wuerfeln!");
		}
	}

	public static boolean testeFigurDrausen(Spieler p) {
		boolean check = false;
		int[][] startBereich = p.startFeld;
		for (int j = 0; j < p.figureList.size(); j++) {
			SpielFigur figur = p.figureList.get(j);

			int x = figur.getX();
			int y = figur.getY();
			for (int i = 0; i < startBereich.length; i++) {
				if (x == startBereich[i][0] && y == startBereich[i][1]) {
				} else {
					check = true;
					break;
				}
			}
		}
		return check;
	}
}