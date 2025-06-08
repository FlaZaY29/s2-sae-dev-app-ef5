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
 * Point d'entrée de l'application CIUP
 * Initialise le modèle, la vue principale et le contrôleur principal
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
        
        // Exécution de l'application dans l'EDT (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Vérifier si un fichier de sauvegarde existe
            File saveFile = new File(DEFAULT_SAVE_FILE);
            CIUP ciupModel;
            
            if (saveFile.exists()) {
                // Demander à l'utilisateur s'il souhaite charger les données sauvegardées
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Un fichier de sauvegarde a été trouvé. Voulez-vous charger les données sauvegardées?",
                    "Charger les données",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (response == JOptionPane.YES_OPTION) {
                    // Initialisation du contrôleur principal avec un modèle vide
                    ciupModel = new CIUP();
                    MainControleur mainControleur = new MainControleur(ciupModel);
                    
                    // Initialisation de la vue principale
                    MainFrame mainFrame = new MainFrame(mainControleur);
                    
                    // Connexion du contrôleur à la vue
                    mainControleur.setMainFrame(mainFrame);
                    
                    // Charger les données sauvegardées
                    mainControleur.loadData();
                    
                    // Affichage de la vue principale
                    mainFrame.setVisible(true);
                    return;
                }
            }
            
            // Initialisation du modèle avec des données de test
            ciupModel = initializeModel();
            
            // Initialisation du contrôleur principal
            MainControleur mainControleur = new MainControleur(ciupModel);
            
            // Initialisation de la vue principale
            MainFrame mainFrame = new MainFrame(mainControleur);
            
            // Connexion du contrôleur à la vue
            mainControleur.setMainFrame(mainFrame);
            
            // Affichage de la vue principale
            mainFrame.setVisible(true);
        });
    }
    
    /**
     * Initialise le modèle avec des données de test
     * @return Le modèle CIUP initialisé
     */
    private static CIUP initializeModel() {
        // Création du modèle CIUP
        CIUP ciup = new CIUP();
        
        // Création des maisons d'exemple
        MaisonInternationale maisonInternationale = FactoryCIUP.creeMaisonInternationale();
        MaisonClassique maisonFrancaise = FactoryCIUP.maisonFrancaise();
        MaisonClassique maisonJaponaise = FactoryCIUP.maisonJaponaise();
        
        // Création des services
        Service serviceRestauration = FactoryCIUP.creeServiceRestauration();
        Service serviceSecurite = FactoryCIUP.creeServiceSecurite();
        
        // Ajout des services à la maison internationale
        maisonInternationale.ajoutService(serviceRestauration);
        maisonInternationale.ajoutService(serviceSecurite);
        
        // Ajout des maisons au CIUP
        ciup.ajouterMaison(maisonInternationale);
        ciup.ajouterMaison(maisonFrancaise);
        ciup.ajouterMaison(maisonJaponaise);
        
        // Ajout des services au CIUP
        ciup.ajouterService(serviceRestauration);
        ciup.ajouterService(serviceSecurite);
        
        // Ajout des étudiants au CIUP
        for (Etudiant etudiant : maisonFrancaise.getListeEtudiant()) {
            ciup.ajouterEtudiant(etudiant);
        }
        for (Etudiant etudiant : maisonJaponaise.getListeEtudiant()) {
            ciup.ajouterEtudiant(etudiant);
        }
        
        // Affichage d'informations dans la console
        System.out.println("Application CIUP démarrée");
        System.out.println("Nombre de maisons: " + ciup.getListeMaison().size());
        System.out.println("Nombre d'étudiants: " + ciup.getListeEtudiant().size());
        
        return ciup;
    }
}
/**
 * cette classe a été crée par @author Flavio Zamperlini
 */