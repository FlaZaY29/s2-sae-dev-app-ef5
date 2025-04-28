package vues;

import modeles.Etudiant;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class EtudiantPanel extends JPanel {

    private JTextField nomField;
    private JTextField prenomField;
    private JButton ajouterButton;
    private JList<Etudiant> etudiantsList;
    private DefaultListModel<Etudiant> listModel;

    private List<Etudiant> etudiants;

    public EtudiantPanel() {
        etudiants = new ArrayList<>();
        setLayout(new BorderLayout());

        // Panel de formulaire pour ajouter un étudiant
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        JLabel nomLabel = new JLabel("Nom:");
        JLabel prenomLabel = new JLabel("Prénom:");

        nomField = new JTextField();
        prenomField = new JTextField();
        ajouterButton = new JButton("Ajouter");

        formPanel.add(nomLabel);
        formPanel.add(nomField);
        formPanel.add(prenomLabel);
        formPanel.add(prenomField);
        formPanel.add(ajouterButton);

        // Panel pour afficher la liste des étudiants
        listModel = new DefaultListModel<>();
        etudiantsList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(etudiantsList);

        // Ajout des panneaux à la fenêtre
        add(formPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.CENTER);

        // ActionListener pour ajouter un étudiant
        ajouterButton.addActionListener(e -> ajouterEtudiant());
    }

    /**
     * Méthode pour ajouter un étudiant à la liste et mettre à jour l'affichage.
     */
    public void ajouterEtudiant() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();

        if (!nom.isEmpty() && !prenom.isEmpty()) {
            Etudiant etudiant = new Etudiant();
            etudiants.add(etudiant);
            listModel.addElement(etudiant);

            // Réinitialiser les champs de texte
            nomField.setText("");
            prenomField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir les champs Nom et Prénom", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retourner la liste des étudiants.
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
}
