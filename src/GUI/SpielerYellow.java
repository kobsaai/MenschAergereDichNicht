package GUI;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SpielerYellow extends Spieler {

	public SpielerYellow() {
		int[][] startfeld = { { 40, 38 }, { 106, 38 }, { 40, 105 }, { 106, 105 } };
		this.startFeld = startfeld;
		int[] feld = { 40, 310 };
		this.firstField = feld;
		int[][] hausFeld = {{106, 446}, {40, 446}, {40, 378}, { 106, 378 }, { 172, 378 }, { 238, 378 }, { 304, 378 } };
		this.hausFeld = hausFeld;
		try {
			this.img = ImageIO.read(getClass().getResource("/images/FigureYellow.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SpielerYellow(JPanel contentPane) {
		this();
		this.active = true;
		SpielFigur yellow3 = new SpielFigur(this.img, this);
		yellow3.setBounds(40, 105, 53, 56);
		contentPane.add(yellow3);
		SpielFigur yellow4 = new SpielFigur(this.img, this);
		yellow4.setBounds(106, 105, 53, 56);
		contentPane.add(yellow4);
		
		SpielFigur yellow2 = new SpielFigur(this.img, this);
		yellow2.setBounds(106, 38, 53, 56);
		contentPane.add(yellow2);
		
		SpielFigur yellow1 = new SpielFigur(this.img, this);
		yellow1.setBounds(40, 38, 53, 56);
		contentPane.add(yellow1);
		this.figureList.add(yellow1);
		this.figureList.add(yellow2);
		this.figureList.add(yellow3);
		this.figureList.add(yellow4);
	}
	

}
