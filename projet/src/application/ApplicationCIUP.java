package application;

import modeles.CIUP;
import modeles.Etudiant;
import modeles.FactoryCIUP;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;
import modeles.Service;
import controleurs.MainControleur;
import vues.MainFrame;

import javax.swing.*;
import java.io.File;

/**
 * Point d'entr�e de l'application CIUP
 * Initialise le mod�le, la vue principale et le contr�leur principal
 */
public class ApplicationCIUP {
    
    private static final String DEFAULT_SAVE_FILE = "ciup_data.ser";
    
    public static void main(String[] args) {
        // Configuration du look and feel
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Ex�cution de l'application dans l'EDT (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(() -> {
            // V�rifier si un fichier de sauvegarde existe
            File saveFile = new File(DEFAULT_SAVE_FILE);
            CIUP ciupModel;
            
            if (saveFile.exists()) {
                // Demander � l'utilisateur s'il souhaite charger les donn�es sauvegard�es
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Un fichier de sauvegarde a �t� trouv�. Voulez-vous charger les donn�es sauvegard�es?",
                    "Charger les donn�es",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (response == JOptionPane.YES_OPTION) {
                    // Initialisation du contr�leur principal avec un mod�le vide
                    ciupModel = new CIUP();
                    MainControleur mainControleur = new MainControleur(ciupModel);
                    
                    // Initialisation de la vue principale
                    MainFrame mainFrame = new MainFrame(mainControleur);
                    
                    // Connexion du contr�leur � la vue
                    mainControleur.setMainFrame(mainFrame);
                    
                    // Charger les donn�es sauvegard�es
                    mainControleur.loadData();
                    
                    // Affichage de la vue principale
                    mainFrame.setVisible(true);
                    return;
                }
            }
            
            // Initialisation du mod�le avec des donn�es de test
            ciupModel = initializeModel();
            
            // Initialisation du contr�leur principal
            MainControleur mainControleur = new MainControleur(ciupModel);
            
            // Initialisation de la vue principale
            MainFrame mainFrame = new MainFrame(mainControleur);
            
            // Connexion du contr�leur � la vue
            mainControleur.setMainFrame(mainFrame);
            
            // Affichage de la vue principale
            mainFrame.setVisible(true);
        });
    }
    
    /**
     * Initialise le mod�le avec des donn�es de test
     * @return Le mod�le CIUP initialis�
     */
    private static CIUP initializeModel() {
        // Cr�ation du mod�le CIUP
        CIUP ciup = new CIUP();
        
        // Cr�ation des maisons d'exemple
        MaisonInternationale maisonInternationale = FactoryCIUP.creeMaisonInternationale();
        MaisonClassique maisonFrancaise = FactoryCIUP.maisonFrancaise();
        MaisonClassique maisonJaponaise = FactoryCIUP.maisonJaponaise();
        
        // Cr�ation des services
        Service serviceRestauration = FactoryCIUP.creeServiceRestauration();
        Service serviceSecurite = FactoryCIUP.creeServiceSecurite();
        
        // Ajout des services � la maison internationale
        maisonInternationale.ajoutService(serviceRestauration);
        maisonInternationale.ajoutService(serviceSecurite);
        
        // Ajout des maisons au CIUP
        ciup.ajouterMaison(maisonInternationale);
        ciup.ajouterMaison(maisonFrancaise);
        ciup.ajouterMaison(maisonJaponaise);
        
        // Ajout des services au CIUP
        ciup.ajouterService(serviceRestauration);
        ciup.ajouterService(serviceSecurite);
        
        // Ajout des �tudiants au CIUP
        for (Etudiant etudiant : maisonFrancaise.getListeEtudiant()) {
            ciup.ajouterEtudiant(etudiant);
        }
        for (Etudiant etudiant : maisonJaponaise.getListeEtudiant()) {
            ciup.ajouterEtudiant(etudiant);
        }
        
        // Affichage d'informations dans la console
        System.out.println("Application CIUP d�marr�e");
        System.out.println("Nombre de maisons: " + ciup.getListeMaison().size());
        System.out.println("Nombre d'�tudiants: " + ciup.getListeEtudiant().size());
        
        return ciup;
    }
}
/**
 * cette classe a �t� cr�e par @author Flavio Zamperlini
 */