import GUI.Start2;

import javax.swing.*;
import java.awt.*;

/**
 * Launch the application.
 */
public class Main {
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
}
