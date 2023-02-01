package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SpielerAuswahl extends JPanel {

	/**
	 * Create the panel.
	 */
	public SpielerAuswahl() {
		setLayout(null);
		
		JButton btn2Player = new JButton("2 Player");
		btn2Player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn2Player.setBounds(171, 37, 89, 23);
		add(btn2Player);
		
		JButton btn3Player = new JButton("3 Player");
		btn3Player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn3Player.setBounds(171, 91, 89, 23);
		add(btn3Player);
		
		JButton btn4Player = new JButton("4 Player");
		btn4Player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn4Player.setBounds(171, 145, 89, 23);
		add(btn4Player);

	}
}
