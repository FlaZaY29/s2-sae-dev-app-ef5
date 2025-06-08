package controleurs;

import modeles.CIUP;
import modeles.Etudiant;
import modeles.Maison;
import modeles.MaisonClassique;

import javax.swing.*;

/**
 * Contr�leur pour la gestion des �tudiants
 */
public class EtudiantControleur {
    private CIUP ciupModel;
    private MainControleur mainControleur;
    
    /**
     * Constructeur du contr�leur d'�tudiants
     * @param ciupModel Le mod�le CIUP
     * @param mainControleur Le contr�leur principal
     */
    public EtudiantControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }
    
    /**
     * Inscrit un nouvel �tudiant
     * @param selectedMaisonName Nom de la maison s�lectionn�e
     * @param nom Nom de l'�tudiant
     * @param prenom Pr�nom de l'�tudiant
     * @param adresse Adresse de l'�tudiant
     * @param nationalite Nationalit� de l'�tudiant
     * @param dateNaissance Date de naissance de l'�tudiant
     * @param tel T�l�phone de l'�tudiant
     * @param email Email de l'�tudiant
     * @param promotion Promotion de l'�tudiant
     * @param universite Universit� de l'�tudiant
     * @return true si l'inscription a r�ussi, false sinon
     */
    public boolean registerStudent(String selectedMaisonName, String nom, String prenom, String adresse, 
                                  String nationalite, String dateNaissance, String tel, String email, 
                                  String promotion, String universite) {
        // Rechercher la maison s�lectionn�e
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
                "Veuillez s�lectionner une maison valide.",
                "Erreur",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        
        // Cr�er un nouvel �tudiant
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
        
        // Ajouter l'�tudiant � la maison et au CIUP
        selectedMaison.ajoutEtudiant(newEtudiant);
        ciupModel.ajouterEtudiant(newEtudiant);
        
        // Mettre � jour le tableau des statistiques
        mainControleur.getMainFrame().getInscriptionPanel().updateStatsTable();
        
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Inscription r�ussie !",
            "Succ�s",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        return true;
    }
    
    /**
     * V�rifie si les champs du formulaire d'inscription sont valides
     * @param nom Nom de l'�tudiant
     * @param prenom Pr�nom de l'�tudiant
     * @param nationalite Nationalit� de l'�tudiant
     * @param dateNaissance Date de naissance de l'�tudiant
     * @param tel T�l�phone de l'�tudiant
     * @param email Email de l'�tudiant
     * @param promotion Promotion de l'�tudiant
     * @param universite Universit� de l'�tudiant
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
/**
 * cette classe a �t� cr�e par @author Flavio Zamperlini
 */