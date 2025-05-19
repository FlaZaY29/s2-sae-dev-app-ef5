package controller;

import modele.CIUP;
import modele.Maison;
import view.AddHouseDialog;
import view.HouseDetailsDialog;
import view.HousesListPanel;
import view.InscriptionPanel;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainController {
    private CIUP ciupModel;
    private MainFrame mainFrame;
    
    public MainController(CIUP ciupModel, MainFrame mainFrame) {
        this.ciupModel = ciupModel;
        this.mainFrame = mainFrame;
    }
    
    public void showHousesList() {
        mainFrame.showPanel("HOUSES");
    }
    
    public void showInscription() {
        // Mettre à jour la liste des maisons avant d'afficher le panel d'inscription
        InscriptionPanel inscriptionPanel = mainFrame.getInscriptionPanel();
        if (inscriptionPanel != null) {
            inscriptionPanel.updateMaisonComboBox();
        }
        mainFrame.showPanel("INSCRIPTION");
    }
    
    public void searchHouses(String searchText) {
        // Récupérer le panel des maisons et filtrer
        HousesListPanel housesPanel = mainFrame.getHousesListPanel();
        if (housesPanel != null) {
            housesPanel.filterHouses(searchText);
        }
    }
    
    public void showHouseDetails(Maison maison) {
        HouseDetailsDialog dialog = new HouseDetailsDialog(mainFrame, maison);
        dialog.setVisible(true);
    }
    
    public void showAddHouseDialog() {
        AddHouseDialog dialog = new AddHouseDialog(mainFrame, this);
        dialog.setVisible(true);
    }
    
    public void addHouse(Maison maison) {
        ciupModel.ajouterMaison(maison);
        
        // Rafraîchir la liste des maisons
        HousesListPanel housesPanel = mainFrame.getHousesListPanel();
        if (housesPanel != null) {
            housesPanel.refreshHousesList();
        }
        
        // Mettre à jour la liste des maisons dans le panel d'inscription
        InscriptionPanel inscriptionPanel = mainFrame.getInscriptionPanel();
        if (inscriptionPanel != null) {
            inscriptionPanel.updateMaisonComboBox();
        }
        
        JOptionPane.showMessageDialog(
            mainFrame,
            "Maison ajoutée avec succès: " + maison.getNom(),
            "Succès",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Proposer d'ajouter des étudiants à la nouvelle maison
        int result = JOptionPane.showConfirmDialog(
            mainFrame,
            "Voulez-vous ajouter des étudiants à cette maison maintenant?",
            "Ajouter des étudiants",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            showInscription();
            // Sélectionner la nouvelle maison dans la liste déroulante
            if (inscriptionPanel != null) {
                inscriptionPanel.selectMaison(maison.getNom());
            }
        }
    }
    
    public void showEditHouseDialog(Maison maison) {
        // Cette fonctionnalité pourrait être implémentée plus tard
        JOptionPane.showMessageDialog(
            mainFrame,
            "Fonctionnalité de modification de maison à implémenter pour: " + maison.getNom(),
            "Information",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void deleteHouse(Maison maison) {
        // Confirm deletion
        int result = JOptionPane.showConfirmDialog(
            mainFrame,
            "Êtes-vous sûr de vouloir supprimer la maison " + maison.getNom() + " ?",
            "Confirmation de suppression",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            ciupModel.supprMaison(maison);
            
            // Rafraîchir la liste des maisons
            HousesListPanel housesPanel = mainFrame.getHousesListPanel();
            if (housesPanel != null) {
                housesPanel.refreshHousesList();
            }
            
            // Mettre à jour la liste des maisons dans le panel d'inscription
            InscriptionPanel inscriptionPanel = mainFrame.getInscriptionPanel();
            if (inscriptionPanel != null) {
                inscriptionPanel.updateMaisonComboBox();
            }
            
            JOptionPane.showMessageDialog(
                mainFrame,
                "Maison supprimée avec succès",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
