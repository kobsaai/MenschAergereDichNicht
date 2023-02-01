package GUI;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SpielerRed extends Spieler {

	public SpielerRed() {
		int[][] startfeld = { { 634, 648 }, { 700, 648 }, { 634, 718 }, { 700, 718 } };
		this.startFeld = startfeld;
		int [] feld = {700, 446};
		this.firstField = feld;
		int[][] hausFeld = {{634, 310}, {700, 310}, {700, 378}, { 634, 378 }, { 568, 378 }, { 502, 378 }, { 436, 378 } };
		this.hausFeld = hausFeld;
		try {
			this.img = ImageIO.read(getClass().getResource("/images/FigureRed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SpielerRed(JPanel contentPane) {
		this();
		SpielFigur red1 = new SpielFigur(this.img, this);
		red1.setBounds(634, 648, 53, 56);
		contentPane.add(red1);
		
		SpielFigur red2 = new SpielFigur(this.img, this);
		red2.setBounds(700, 648, 53, 56);
		contentPane.add(red2);
		
		SpielFigur red3 = new SpielFigur(this.img, this);
		red3.setBounds(634, 718, 53, 56);
		contentPane.add(red3);
		
		SpielFigur red4 = new SpielFigur(this.img, this);
		red4.setBounds(700, 718, 53, 56);
		contentPane.add(red4);
		
		this.figureList.add(red1);
		this.figureList.add(red2);
		this.figureList.add(red3);
		this.figureList.add(red4);
	}
}
