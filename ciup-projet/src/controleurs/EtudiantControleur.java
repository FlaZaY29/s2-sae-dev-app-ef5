package controleurs;

import javax.swing.JOptionPane;

import modeles.CIUP;
import modeles.Etudiant;
import modeles.Maison;
import modeles.MaisonClassique;

/**
 * Contrôleur pour la gestion des étudiants
 */
public class EtudiantControleur {
    private CIUP ciupModel;
    private MainControleur mainControleur;

    /**
     * Constructeur du contrôleur d'étudiants
     * @param ciupModel Le modèle CIUP
     * @param mainControleur Le contrôleur principal
     */
    public EtudiantControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }

    /**
     * Inscrit un nouvel étudiant
     * @param selectedMaisonName Nom de la maison sélectionnée
     * @param nom Nom de l'étudiant
     * @param prenom Prénom de l'étudiant
     * @param adresse Adresse de l'étudiant
     * @param nationalite Nationalité de l'étudiant
     * @param dateNaissance Date de naissance de l'étudiant
     * @param tel Téléphone de l'étudiant
     * @param email Email de l'étudiant
     * @param promotion Promotion de l'étudiant
     * @param universite Université de l'étudiant
     * @return true si l'inscription a réussi, false sinon
     */
    public boolean registerStudent(String selectedMaisonName, String nom, String prenom, String adresse,
                                  String nationalite, String dateNaissance, String tel, String email,
                                  String promotion, String universite) {
        // Rechercher la maison sélectionnée
        MaisonClassique selectedMaison = null;

        for (Maison maison : ciupModel.getListeMaison()) {
            if (maison.getNom().equals(selectedMaisonName) && maison instanceof MaisonClassique) {
                selectedMaison = (MaisonClassique) maison;
                break;
            }
        }

        if (selectedMaison == null) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Veuillez sélectionner une maison valide.",
                "Erreur",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        // Créer un nouvel étudiant
        int newId = ciupModel.getListeEtudiant().size() + 1;
        Etudiant newEtudiant = new Etudiant(
            newId,
            nom,
            prenom,
            adresse,
            nationalite,
            dateNaissance,
            tel,
            email,
            promotion,
            universite,
            nom + "_" + prenom + ".jpg"
        );

        // Ajouter l'étudiant à la maison et au CIUP
        selectedMaison.ajoutEtudiant(newEtudiant);
        ciupModel.ajouterEtudiant(newEtudiant);

        // Mettre à jour le tableau des statistiques
        mainControleur.getMainFrame().getInscriptionPanel().updateStatsTable();

        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Inscription réussie !",
            "Succès",
            JOptionPane.INFORMATION_MESSAGE
        );

        return true;
    }

    /**
     * Vérifie si les champs du formulaire d'inscription sont valides
     * @param nom Nom de l'étudiant
     * @param prenom Prénom de l'étudiant
     * @param nationalite Nationalité de l'étudiant
     * @param dateNaissance Date de naissance de l'étudiant
     * @param tel Téléphone de l'étudiant
     * @param email Email de l'étudiant
     * @param promotion Promotion de l'étudiant
     * @param universite Université de l'étudiant
     * @return true si les champs sont valides, false sinon
     */
    public boolean validateStudentFields(String nom, String prenom, String nationalite, String dateNaissance,
                                        String tel, String email, String promotion, String universite) {
        if (nom.isEmpty() || prenom.isEmpty() || nationalite.isEmpty() || dateNaissance.isEmpty() ||
            tel.isEmpty() || email.isEmpty() || promotion.isEmpty() || universite.isEmpty()) {

            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Veuillez remplir tous les champs obligatoires.",
                "Formulaire incomplet",
                JOptionPane.WARNING_MESSAGE
            );
            return false;
        }

        return true;
    }
}
