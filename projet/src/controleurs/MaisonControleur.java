package controleurs;

import modeles.CIUP;
import modeles.Maison;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;
import vues.AddHouseDialog;
import vues.EditHouseDialog;
import vues.HouseDetailsDialog;

import javax.swing.*;

/**
 * Contr�leur pour la gestion des maisons
 */
public class MaisonControleur {
    private CIUP ciupModel;
    private MainControleur mainControleur;
    
    /**
     * Constructeur du contr�leur de maisons
     * @param ciupModel Le mod�le CIUP
     * @param mainControleur Le contr�leur principal
     */
    public MaisonControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }
    
    /**
     * Affiche les d�tails d'une maison
     * @param maison La maison � afficher
     */
    public void showHouseDetails(Maison maison) {
        HouseDetailsDialog dialog = new HouseDetailsDialog(mainControleur.getMainFrame(), maison, mainControleur);
        dialog.setVisible(true);
    }
    
    /**
     * Affiche la bo�te de dialogue d'ajout de maison
     */
    public void showAddHouseDialog() {
        AddHouseDialog dialog = new AddHouseDialog(mainControleur.getMainFrame(), mainControleur);
        
        // Ajouter les �couteurs d'�v�nements aux boutons
        dialog.getSaveButton().addActionListener(e -> {
            // La logique de sauvegarde est maintenant dans la m�thode saveHouse() de AddHouseDialog
        });
        
        dialog.getCancelButton().addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.setVisible(true);
    }
    
    /**
     * Ajoute une maison au mod�le
     * @param maison La maison � ajouter
     */
    public void addHouse(Maison maison) {
        ciupModel.ajouterMaison(maison);
        
        // Rafra�chir la liste des maisons
        mainControleur.getMainFrame().getHousesListPanel().refreshHousesList();
        
        // Mettre � jour la liste des maisons dans le panel d'inscription
        mainControleur.getMainFrame().getInscriptionPanel().updateMaisonComboBox();
        
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Maison ajout�e avec succ�s: " + maison.getNom(),
            "Succ�s",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Proposer d'ajouter des �tudiants � la nouvelle maison ou des services si c'est une maison internationale
        if (maison instanceof MaisonClassique) {
            int result = JOptionPane.showConfirmDialog(
                mainControleur.getMainFrame(),
                "Voulez-vous ajouter des �tudiants � cette maison maintenant?",
                "Ajouter des �tudiants",
                JOptionPane.YES_NO_OPTION
            );
            
            if (result == JOptionPane.YES_OPTION) {
                mainControleur.showInscription();
                // S�lectionner la nouvelle maison dans la liste d�roulante
                mainControleur.getMainFrame().getInscriptionPanel().selectMaison(maison.getNom());
            }
        } else if (maison instanceof MaisonInternationale) {
            int result = JOptionPane.showConfirmDialog(
                mainControleur.getMainFrame(),
                "Voulez-vous ajouter des services � cette maison maintenant?",
                "Ajouter des services",
                JOptionPane.YES_NO_OPTION
            );
            
            if (result == JOptionPane.YES_OPTION) {
                mainControleur.getServiceControleur().showManageServicesDialog((MaisonInternationale) maison);
            }
        }
    }
    
    /**
     * Affiche la bo�te de dialogue de modification de maison
     * @param maison La maison � modifier
     */
    public void showEditHouseDialog(Maison maison) {
        EditHouseDialog dialog = new EditHouseDialog(mainControleur.getMainFrame(), mainControleur, maison);
        dialog.setVisible(true);
    }

    /**
     * Met � jour une maison dans le mod�le
     * @param maison La maison mise � jour
     */
    public void updateHouse(Maison maison) {
        // Rafra�chir la liste des maisons
        mainControleur.getMainFrame().getHousesListPanel().refreshHousesList();
        
        // Mettre � jour la liste des maisons dans le panel d'inscription
        mainControleur.getMainFrame().getInscriptionPanel().updateMaisonComboBox();
        
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Maison modifi�e avec succ�s: " + maison.getNom(),
            "Succ�s",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Supprime une maison du mod�le
     * @param maison La maison � supprimer
     */
    public void deleteHouse(Maison maison) {
        // Confirm deletion
        int result = JOptionPane.showConfirmDialog(
            mainControleur.getMainFrame(),
            "�tes-vous s�r de vouloir supprimer la maison " + maison.getNom() + " ?",
            "Confirmation de suppression",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            ciupModel.supprMaison(maison);
            
            // Rafra�chir la liste des maisons
            mainControleur.getMainFrame().getHousesListPanel().refreshHousesList();
            
            // Mettre � jour la liste des maisons dans le panel d'inscription
            mainControleur.getMainFrame().getInscriptionPanel().updateMaisonComboBox();
            
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Maison supprim�e avec succ�s",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    /**
     * Cr�e une nouvelle maison classique
     * @param num Num�ro de la maison
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel T�l�phone de la maison
     * @param localisation Localisation de la maison
     * @param directeur Directeur de la maison
     * @param anneeCreation Ann�e de cr�ation de la maison
     * @param dateFete Date de la f�te de la maison
     * @param dureeFete Dur�e de la f�te de la maison
     * @param nationalite Nationalit� de la maison
     * @param capacite Capacit� de la maison
     * @return La maison classique cr�e
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
     * Cr�e une nouvelle maison internationale
     * @param num Num�ro de la maison
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel T�l�phone de la maison
     * @param localisation Localisation de la maison
     * @param directeur Directeur de la maison
     * @param anneeCreation Ann�e de cr�ation de la maison
     * @param dateFete Date de la f�te de la maison
     * @param dureeFete Dur�e de la f�te de la maison
     * @return La maison internationale cr�e
     */
    public MaisonInternationale createMaisonInternationale(int num, String nom, String desc, String tel, String localisation, 
                                                          String directeur, int anneeCreation, String dateFete, int dureeFete) {
        return new MaisonInternationale(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
    }
}

/**
 * cette classe a �t� cr�e par @author Donald Se
 */