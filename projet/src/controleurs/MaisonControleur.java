package controleurs;

import modeles.CIUP;
import modeles.Maison;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;
import vues.AddHouseDialog;
import vues.EditHouseDialog;
import vues.HouseDetailsDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur pour la gestion des maisons
 */
public class MaisonControleur {
    private CIUP ciupModel;
    private MainControleur mainControleur;
    
    /**
     * Constructeur du contrôleur de maisons
     * @param ciupModel Le modèle CIUP
     * @param mainControleur Le contrôleur principal
     */
    public MaisonControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }
    
    /**
     * Affiche les détails d'une maison
     * @param maison La maison à afficher
     */
    public void showHouseDetails(Maison maison) {
        HouseDetailsDialog dialog = new HouseDetailsDialog(mainControleur.getMainFrame(), maison, mainControleur);
        dialog.setVisible(true);
    }
    
    /**
     * Affiche la boîte de dialogue d'ajout de maison
     */
    public void showAddHouseDialog() {
        AddHouseDialog dialog = new AddHouseDialog(mainControleur.getMainFrame(), mainControleur);
        
        // Ajouter les écouteurs d'événements aux boutons
        dialog.getSaveButton().addActionListener(e -> {
            // La logique de sauvegarde est maintenant dans la méthode saveHouse() de AddHouseDialog
        });
        
        dialog.getCancelButton().addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.setVisible(true);
    }
    
    /**
     * Ajoute une maison au modèle
     * @param maison La maison à ajouter
     */
    public void addHouse(Maison maison) {
        ciupModel.ajouterMaison(maison);
        
        // Rafraîchir la liste des maisons
        mainControleur.getMainFrame().getHousesListPanel().refreshHousesList();
        
        // Mettre à jour la liste des maisons dans le panel d'inscription
        mainControleur.getMainFrame().getInscriptionPanel().updateMaisonComboBox();
        
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Maison ajoutée avec succès: " + maison.getNom(),
            "Succès",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Proposer d'ajouter des étudiants à la nouvelle maison ou des services si c'est une maison internationale
        if (maison instanceof MaisonClassique) {
            int result = JOptionPane.showConfirmDialog(
                mainControleur.getMainFrame(),
                "Voulez-vous ajouter des étudiants à cette maison maintenant?",
                "Ajouter des étudiants",
                JOptionPane.YES_NO_OPTION
            );
            
            if (result == JOptionPane.YES_OPTION) {
                mainControleur.showInscription();
                // Sélectionner la nouvelle maison dans la liste déroulante
                mainControleur.getMainFrame().getInscriptionPanel().selectMaison(maison.getNom());
            }
        } else if (maison instanceof MaisonInternationale) {
            int result = JOptionPane.showConfirmDialog(
                mainControleur.getMainFrame(),
                "Voulez-vous ajouter des services à cette maison maintenant?",
                "Ajouter des services",
                JOptionPane.YES_NO_OPTION
            );
            
            if (result == JOptionPane.YES_OPTION) {
                mainControleur.getServiceControleur().showManageServicesDialog((MaisonInternationale) maison);
            }
        }
    }
    
    /**
     * Affiche la boîte de dialogue de modification de maison
     * @param maison La maison à modifier
     */
    public void showEditHouseDialog(Maison maison) {
        EditHouseDialog dialog = new EditHouseDialog(mainControleur.getMainFrame(), mainControleur, maison);
        dialog.setVisible(true);
    }

    /**
     * Met à jour une maison dans le modèle
     * @param maison La maison mise à jour
     */
    public void updateHouse(Maison maison) {
        // Rafraîchir la liste des maisons
        mainControleur.getMainFrame().getHousesListPanel().refreshHousesList();
        
        // Mettre à jour la liste des maisons dans le panel d'inscription
        mainControleur.getMainFrame().getInscriptionPanel().updateMaisonComboBox();
        
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Maison modifiée avec succès: " + maison.getNom(),
            "Succès",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Supprime une maison du modèle
     * @param maison La maison à supprimer
     */
    public void deleteHouse(Maison maison) {
        // Confirm deletion
        int result = JOptionPane.showConfirmDialog(
            mainControleur.getMainFrame(),
            "Êtes-vous sûr de vouloir supprimer la maison " + maison.getNom() + " ?",
            "Confirmation de suppression",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            ciupModel.supprMaison(maison);
            
            // Rafraîchir la liste des maisons
            mainControleur.getMainFrame().getHousesListPanel().refreshHousesList();
            
            // Mettre à jour la liste des maisons dans le panel d'inscription
            mainControleur.getMainFrame().getInscriptionPanel().updateMaisonComboBox();
            
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Maison supprimée avec succès",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    /**
     * Crée une nouvelle maison classique
     * @param num Numéro de la maison
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel Téléphone de la maison
     * @param localisation Localisation de la maison
     * @param directeur Directeur de la maison
     * @param anneeCreation Année de création de la maison
     * @param dateFete Date de la fête de la maison
     * @param dureeFete Durée de la fête de la maison
     * @param nationalite Nationalité de la maison
     * @param capacite Capacité de la maison
     * @return La maison classique créée
     */
    public MaisonClassique createMaisonClassique(int num, String nom, String desc, String tel, String localisation, 
                                                String directeur, int anneeCreation, String dateFete, int dureeFete, 
                                                String nationalite, int capacite) {
        MaisonClassique maison = new MaisonClassique(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
        maison.setNationalite(nationalite);
        maison.setCapacite(capacite);
        return maison;
    }
    
    /**
     * Crée une nouvelle maison internationale
     * @param num Numéro de la maison
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel Téléphone de la maison
     * @param localisation Localisation de la maison
     * @param directeur Directeur de la maison
     * @param anneeCreation Année de création de la maison
     * @param dateFete Date de la fête de la maison
     * @param dureeFete Durée de la fête de la maison
     * @return La maison internationale créée
     */
    public MaisonInternationale createMaisonInternationale(int num, String nom, String desc, String tel, String localisation, 
                                                          String directeur, int anneeCreation, String dateFete, int dureeFete) {
        return new MaisonInternationale(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
    }
}
/**
 * cette classe a été crée par @author Donald Se
 */