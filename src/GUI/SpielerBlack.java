package GUI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SpielerBlack extends Spieler {

	public SpielerBlack() {
		int[][] startfeld = { { 40, 648 }, { 108, 648 }, { 40, 718 }, { 108, 718 } };
		this.startFeld = startfeld;
		int[] feld = { 304, 718 };
		this.firstField = feld;
		int[][] hausFeld = { { 436, 648 }, { 436, 718 }, { 370, 718 }, { 370, 648 }, { 370, 580 }, { 370, 512 },
				{ 370, 444 } };
		this.hausFeld = hausFeld;
		try {
			this.img = ImageIO.read(getClass().getResource("/images/FigureBlack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SpielerBlack(JPanel contentPane) {
		this();
		SpielFigur black2 = new SpielFigur(this.img, this);
		//black2.
		black2.setBounds(108, 648, 53, 56);
		contentPane.add(black2);
		
		SpielFigur black4 = new SpielFigur(this.img, this);
		black4.setBounds(108, 718, 53, 56);
		contentPane.add(black4);
		
		SpielFigur black3 = new SpielFigur(this.img, this);
		black3.setBounds(40, 718, 53, 56);
		contentPane.add(black3);
		
		SpielFigur black1 = new SpielFigur(this.img, this);
		black1.setBounds(40, 648, 53, 56);
		contentPane.add(black1);
		
		this.figureList.add(black1);
		this.figureList.add(black2);
		this.figureList.add(black3);
		this.figureList.add(black4);
	}
}
