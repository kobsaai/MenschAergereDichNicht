package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

public class Start2 extends JFrame {
	private JPanel contentPane;
	public static int spielerAnzahl;
	public static ArrayList<Spieler> playerList = new ArrayList<Spieler>();
	public static int activePlayer;
	public JButton btnRoll;
	public JTextField wuerfelZahl;
	public static JTextPane txtpnZugVonSpieler;
	public JLabel lblWuerfel;

	public JTextField getWuerfelZahl() {
		return wuerfelZahl;
	}

	public void setWuerfelZahl(JTextField wuerfelZahl) {
		this.wuerfelZahl = wuerfelZahl;
	}

	/*
	 * public BackgroundPanel green1; public BackgroundPanel green3; public
	 * BackgroundPanel green2; public BackgroundPanel green4; public BackgroundPanel
	 * red1; public BackgroundPanel red2; public BackgroundPanel red3; public
	 * BackgroundPanel red4; public BackgroundPanel black2; public BackgroundPanel
	 * black4; public BackgroundPanel black3; public BackgroundPanel black1; public
	 * BackgroundPanel yellow1; public BackgroundPanel yellow2; public
	 * BackgroundPanel yellow3;
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start2 frame = new Start2(Integer
							.parseInt(JOptionPane.showInputDialog("Wie Viele Spieler moechten Spielen? (2-4 moeglich)")));
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

	public Start2(int count) {
		Start2.spielerAnzahl = count;
		Start2.activePlayer = 1;
		Image backgroundImg = null;
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

		Spieler pRed; // = new SpielerRed();
		Spieler pYellow;// = new SpielerYellow(contentPane);
		Spieler pGreen;// = new SpielerGreen();
		Spieler pBlack;// = new SpielerBlack();

		// Erstellt die Spieler & Spielfiguren
		switch (count) {
		case 2: {
			playerList.add(new SpielerYellow(contentPane));
			playerList.add(new SpielerRed(contentPane));
			break;
		}
		case 3: {
			playerList.add(new SpielerYellow(contentPane));
			playerList.add(new SpielerGreen(contentPane));
			playerList.add(new SpielerRed(contentPane));
			break;
		}
		case 4: {
			playerList.add(new SpielerYellow(contentPane));
			playerList.add(new SpielerGreen(contentPane));
			playerList.add(new SpielerRed(contentPane));
			playerList.add(new SpielerBlack(contentPane));
			break;
		}

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 810, 850);
		// ImageIcon image = new ImageIcon("background.png");

		btnRoll = new JButton("Wuerfeln");
		btnRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wuerfelZahl.setText(Spieler.wuerfel() + "");
				Spieler p = Start2.playerList.get(Start2.activePlayer-1);
				if (!Spieler.testeFigurDrausen(p) & Spieler.wuerfel != 6) {
					JOptionPane.showMessageDialog(rootPane, "Du kannst nichts machen! \nZug Beendet");
					Spieler.setActivePlayer();
					Start2.txtpnZugVonSpieler.setText("Zug von Spieler " + Start2.activePlayer);
					Spieler.wuerfel = 0;
				}
				switch (Spieler.wuerfel) {
				case 1:
					lblWuerfel.setIcon(new ImageIcon(Start2.class.getResource("/GUI/1wl.jpg")));
					break;
				case 2:
					lblWuerfel.setIcon(new ImageIcon(Start2.class.getResource("/GUI/2wl.jpg")));
					break;
				case 3:
					lblWuerfel.setIcon(new ImageIcon(Start2.class.getResource("/GUI/3wl.jpg")));
					break;
				case 4:
					lblWuerfel.setIcon(new ImageIcon(Start2.class.getResource("/GUI/4wl.jpg")));
					break;
				case 5:
					lblWuerfel.setIcon(new ImageIcon(Start2.class.getResource("/GUI/5wl.jpg")));
					break;
				case 6:
					lblWuerfel.setIcon(new ImageIcon(Start2.class.getResource("/GUI/6wl.jpg")));
					break;
				}
				JOptionPane.showMessageDialog(rootPane, "Die Würfel sind gefallen! \nDu hast eine " + Spieler.wuerfel + " gewürfelt!");
				//wuerfel = Integer.parseInt(wuerfelZahl.getText());


			}
		});
		btnRoll.setBounds(353, 412, 89, 35);
		contentPane.add(btnRoll);

		txtpnZugVonSpieler = new JTextPane();
		txtpnZugVonSpieler.setEditable(false);
		txtpnZugVonSpieler.setBackground(Color.decode("#FFFF99"));
		txtpnZugVonSpieler.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtpnZugVonSpieler.setText("Zug von Spieler " + Start2.activePlayer);
		txtpnZugVonSpieler.setBounds(353, 368, 89, 47);
		contentPane.add(txtpnZugVonSpieler);

		wuerfelZahl = new JTextField();
		wuerfelZahl.setEditable(false);
		wuerfelZahl.setBounds(517, 664, 86, 20);
		contentPane.add(wuerfelZahl);
		wuerfelZahl.setColumns(10);
		
		lblWuerfel = new JLabel("New label");
		lblWuerfel.setIcon(new ImageIcon("C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\eclipse-workspace\\Wochenaufgabe\\src\\GUI\\4wl.jpg"));
		lblWuerfel.setBounds(517, 682, 105, 105);
		contentPane.add(lblWuerfel);

	}
}
