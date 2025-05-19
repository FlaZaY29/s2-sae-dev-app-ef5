package view;

import controller.MainController;
import modele.CIUP;
import modele.Etudiant;
import modele.FactoryCIUP;
import modele.MaisonClassique;
import modele.MaisonInternationale;
import modele.Service;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HeaderPanel headerPanel;
    private SidebarPanel sidebarPanel;
    private JPanel contentPanel;
    private HousesListPanel housesListPanel;
    private InscriptionPanel inscriptionPanel;
    private MainController controller;
    private CIUP ciupModel;

    public MainFrame(CIUP ciupModel) {
        this.ciupModel = ciupModel;
        this.controller = new MainController(ciupModel, this);
        
        setTitle("CIUP - Cité Internationale Universitaire de Paris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        
        initComponents();
        layoutComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {
        headerPanel = new HeaderPanel(controller);
        sidebarPanel = new SidebarPanel(controller);
        contentPanel = new JPanel(new CardLayout());
        
        housesListPanel = new HousesListPanel(ciupModel, controller);
        inscriptionPanel = new InscriptionPanel(ciupModel, controller);
        
        contentPanel.add(housesListPanel, "HOUSES");
        contentPanel.add(inscriptionPanel, "INSCRIPTION");
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        add(headerPanel, BorderLayout.NORTH);
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }
    
    public void showPanel(String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
    }
    
    // Getter pour accéder au panel des maisons
    public HousesListPanel getHousesListPanel() {
        return housesListPanel;
    }
    
    // Getter pour accéder au panel d'inscription
    public InscriptionPanel getInscriptionPanel() {
        return inscriptionPanel;
    }
    
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            // Créer une instance de CIUP
            CIUP ciup = new CIUP();
            
            // Ajouter des maisons d'exemple
            MaisonInternationale maisonInternationale = modele.FactoryCIUP.creeMaisonInternationale();
            MaisonClassique maisonFrancaise = modele.FactoryCIUP.maisonFrancaise();
            MaisonClassique maisonJaponaise = modele.FactoryCIUP.maisonJaponaise();
            
            // Ajouter des services à la maison internationale
            Service serviceRestauration = modele.FactoryCIUP.creeServiceRestauration();
            Service serviceSecurite = modele.FactoryCIUP.creeServiceSecurite();
            maisonInternationale.ajoutService(serviceRestauration);
            maisonInternationale.ajoutService(serviceSecurite);
            
            // Ajouter les maisons au CIUP
            ciup.ajouterMaison(maisonInternationale);
            ciup.ajouterMaison(maisonFrancaise);
            ciup.ajouterMaison(maisonJaponaise);
            
            // Ajouter les services au CIUP
            ciup.ajouterService(serviceRestauration);
            ciup.ajouterService(serviceSecurite);
            
            // Ajouter les étudiants au CIUP
            for (Etudiant etudiant : maisonFrancaise.getListeEtudiant()) {
                ciup.ajouterEtudiant(etudiant);
            }
            for (Etudiant etudiant : maisonJaponaise.getListeEtudiant()) {
                ciup.ajouterEtudiant(etudiant);
            }
            
            // Afficher quelques informations dans la console
            System.out.println("Application CIUP démarrée");
            System.out.println("Nombre de maisons: " + ciup.getListeMaison().size());
            System.out.println("Nombre d'étudiants: " + ciup.getListeEtudiant().size());
            
            // Créer et afficher la fenêtre principale
            new MainFrame(ciup);
        });
    }
}
