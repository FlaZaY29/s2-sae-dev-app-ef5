package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modeles.Etudiant;
import vues.EtudiantPanel;

public class EtudiantController implements ActionListener {

    private EtudiantPanel etudiantPanel;

    public EtudiantController(EtudiantPanel panel) {
        this.etudiantPanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Logique pour gérer l'action (ex: ajout d'un étudiant)
        Etudiant etudiant = new Etudiant();
        etudiantPanel.ajouterEtudiant();
    }
}
