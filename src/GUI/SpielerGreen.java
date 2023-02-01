package GUI;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SpielerGreen extends Spieler {

	public SpielerGreen() {
		int[][] startfeld = { { 634, 38 }, { 700, 38 }, { 634, 104 }, { 700, 104 } };
		this.startFeld = startfeld;
		int[] feld = { 436, 38 };
		this.firstField = feld;
		int[][] hausFeld = { { 304, 104 }, { 304, 38 }, { 370, 38 }, { 370, 104 }, { 370, 172 }, { 370, 240 },
				{ 370, 308 } };
		this.hausFeld = hausFeld;
		try {
			this.img = ImageIO.read(getClass().getResource("/images/FigureGreen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SpielerGreen(JPanel contentPane) {
		this();
		SpielFigur green1 = new SpielFigur(this.img, this);
		green1.setBounds(634, 38, 53, 56);
		green1.setVisible(true);
		contentPane.add(green1);

		SpielFigur green3 = new SpielFigur(this.img, this);
		green3.setBounds(634, 104, 53, 56);
		green3.setVisible(true);
		contentPane.add(green3);

		SpielFigur green2 = new SpielFigur(this.img, this);
		green2.setBounds(700, 38, 53, 56);
		green2.setVisible(true);
		contentPane.add(green2);

		SpielFigur green4 = new SpielFigur(this.img, this);
		green4.setBounds(700, 104, 53, 56);
		green4.setVisible(true);
		contentPane.add(green4);
		this.figureList.add(green1);
		this.figureList.add(green2);
		this.figureList.add(green3);
		this.figureList.add(green4);

	}
}
