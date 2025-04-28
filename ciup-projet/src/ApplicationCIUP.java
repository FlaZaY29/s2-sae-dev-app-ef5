import vues.*;

import javax.swing.*;

public class ApplicationCIUP {
    public static void main(String[] args) {

        // Lancer l'application
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainFrame().setVisible(true);
                }
        });
    }
}
