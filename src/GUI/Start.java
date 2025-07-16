package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

public class Start extends JFrame {
    public int wuerfel;
	private JPanel contentPane;
	public JPanel yellow4;
	public int spielerAnzahl;

	public JButton btnRoll;
	public JTextField wuerfelZahl;
	
	
	public JTextField getWuerfelZahl() {
		return wuerfelZahl;
	}

	public void setWuerfelZahl(JTextField wuerfelZahl) {
		this.wuerfelZahl = wuerfelZahl;
	}

	public BackgroundPanel green1;
	public BackgroundPanel green3;
	public BackgroundPanel green2;
	public BackgroundPanel green4;
	public BackgroundPanel red1;
	public BackgroundPanel red2;
	public BackgroundPanel red3;
	public BackgroundPanel red4;
	public BackgroundPanel black2;
	public BackgroundPanel black4;
	public BackgroundPanel black3;
	public BackgroundPanel black1;
	public BackgroundPanel yellow1;
	public BackgroundPanel yellow2;
	public BackgroundPanel yellow3;
	public Spieler pRed = new SpielerRed();
	public Spieler pYellow = new SpielerYellow();
	public Spieler pGreen = new SpielerGreen();
	public Spieler pBlack = new SpielerBlack();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 810, 850);
		//ImageIcon image = new ImageIcon("background.png");
		Image backgroundImg = null;
		Image blackImg = null;
		try {
			backgroundImg = ImageIO.read(getClass().getResource("/images/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new BackgroundPanel(backgroundImg);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			blackImg = ImageIO.read(getClass().getResource("/images/FigureBlack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnRoll = new JButton("Wuerfeln");
		btnRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				wuerfelZahl.setText(Spieler.wuerfel() + "");
				wuerfel = Integer.parseInt(wuerfelZahl.getText());
				
			}
		});
		btnRoll.setBounds(353, 412, 89, 35);
		contentPane.add(btnRoll);
		
		
		new FeldFuellen(contentPane, pYellow);
		/*yellow3 = new SpielFigur(pYellow.img, pYellow);
		yellow3.setBounds(40, 105, 53, 56);
		contentPane.add(yellow3);*/
		
		yellow4 = new SpielFigur(pYellow.img, pYellow);
		yellow4.setBounds(106, 105, 53, 56);
		contentPane.add(yellow4);
		
		yellow2 = new SpielFigur(pYellow.img, pYellow);
		yellow2.setBounds(106, 38, 53, 56);
		contentPane.add(yellow2);
		
		yellow1 = new SpielFigur(pYellow.img, pYellow);
		yellow1.setBounds(40, 38, 53, 56);
		contentPane.add(yellow1);
		
		JTextPane txtpnZugVonSpieler = new JTextPane();
		txtpnZugVonSpieler.setEditable(false);
		txtpnZugVonSpieler.setBackground(Color.decode("#FFFF99"));
		txtpnZugVonSpieler.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtpnZugVonSpieler.setText("Zug von Spieler1");
		txtpnZugVonSpieler.setBounds(353, 368, 89, 47);
		contentPane.add(txtpnZugVonSpieler);
		
		wuerfelZahl = new JTextField();
		wuerfelZahl.setEditable(false);
		wuerfelZahl.setBounds(517, 664, 86, 20);
		contentPane.add(wuerfelZahl);
		wuerfelZahl.setColumns(10);
		
		green1 = new SpielFigur(pGreen.img, pGreen);
		green1.setBounds(634, 38, 53, 56);
		green1.setVisible(false);
		contentPane.add(green1);
		
		green3 = new SpielFigur(pGreen.img, pGreen);
		green3.setBounds(634, 104, 53, 56);
		green3.setVisible(false);
		contentPane.add(green3);
		
		green2 = new SpielFigur(pGreen.img, pGreen);
		green2.setBounds(700, 38, 53, 56);
		green2.setVisible(false);
		contentPane.add(green2);
		
		green4 = new SpielFigur(pGreen.img, pGreen);
		green4.setBounds(700, 104, 53, 56);
		green4.setVisible(false);
		contentPane.add(green4);
		
		red1 = new SpielFigur(pRed.img, pRed);
		red1.setBounds(634, 648, 53, 56);
		contentPane.add(red1);
		
		red2 = new SpielFigur(pRed.img, pRed);
		red2.setBounds(700, 648, 53, 56);
		contentPane.add(red2);
		
		red3 = new SpielFigur(pRed.img, pRed);
		red3.setBounds(634, 718, 53, 56);
		contentPane.add(red3);
		
		red4 = new SpielFigur(pRed.img, pRed);
		red4.setBounds(700, 718, 53, 56);
		contentPane.add(red4);
		
		black2 = new SpielFigur(pBlack.img, pBlack);
		//black2.
		black2.setBounds(108, 648, 53, 56);
		contentPane.add(black2);
		
		black4 = new SpielFigur(pBlack.img, pBlack);
		black4.setBounds(108, 718, 53, 56);
		contentPane.add(black4);
		
		black3 = new SpielFigur(pBlack.img, pBlack);
		black3.setBounds(40, 718, 53, 56);
		contentPane.add(black3);
		
		black1 = new SpielFigur(pBlack.img, pBlack);
		black1.setBounds(40, 648, 53, 56);
		contentPane.add(black1);
		
	}
}
