package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Wuerfel extends JFrame {
	public static ImageIcon img1 = new ImageIcon("images/1wl.jpg");
	public static ImageIcon img2 = new ImageIcon("images/2wl.jpg");
	public static ImageIcon img3 = new ImageIcon("images/3wl.jpg");
	public static ImageIcon img4 = new ImageIcon("images/4wl.jpg");
	public static ImageIcon img5 =new ImageIcon("images/5wl.jpg");
	public static ImageIcon img6 =new ImageIcon("images/6wl.jpg");

	private static final Icon[] DICE_ICONS = { // Warum nicht gleich Bilder mit 60px²? Oo
			img1, img2, img3, img4, img5, img6};
			/*new ImageIcon(new ImageIcon("images/1wl.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
			new ImageIcon(new ImageIcon("images/2wl.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
			new ImageIcon(new ImageIcon("images/3wl.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
			new ImageIcon(new ImageIcon("images/4wl.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
			new ImageIcon(new ImageIcon("images/5wl.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
			new ImageIcon(new ImageIcon("images/6wl.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)) };*/

	private boolean rolling;
	private JLabel wuerfelLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wuerfel frame = new Wuerfel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Wuerfel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);

		wuerfelLabel = new JLabel(DICE_ICONS[0]);
		wuerfelLabel.setSize(60, 60);
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("läuft");
				if (rolling)
					return;
				letTheDiceRoll();
			}
		});
		contentPane.add(wuerfelLabel);

		pack();
	}

	private void letTheDiceRoll() {
		rolling = true;
		new Thread() {
			public void run() {
				double neuzeit = 10;
				double besch = 0.2;
				double gesamt = neuzeit;

				while (gesamt < 3000) {
					try {
						final int rand = ertragsWuerfel();

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								wuerfelLabel.setIcon(DICE_ICONS[rand]);
							}
						});

						TimeUnit.MILLISECONDS.sleep((long) neuzeit);

						neuzeit += neuzeit * besch;
						gesamt += neuzeit;
					} catch (InterruptedException e1) {
					}
				}
				rolling = false;
			}
		}.start();
	}

	// Wuerfeln
	public int ertragsWuerfel() {
		return (int) (Math.random() * 5 + 1);
	}
}
