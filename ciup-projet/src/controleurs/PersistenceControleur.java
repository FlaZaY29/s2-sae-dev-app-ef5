package controleurs;

import modeles.CIUP;

import javax.swing.*;
import java.io.*;

/**
 * Contrôleur pour la gestion de la persistance des données.
 * <p>
 * Cette classe fournit des méthodes pour sauvegarder et charger
 * le modèle CIUP depuis le disque dur en utilisant la sérialisation Java.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 */
public class PersistenceControleur {
    
    private MainControleur mainControleur;
    private static final String DEFAULT_SAVE_FILE = "ciup_data.ser";
    
    /**
     * Constructeur du contrôleur de persistance.
     * 
     * @param mainControleur Le contrôleur principal
     */
    public PersistenceControleur(MainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }
    
    /**
     * Sauvegarde le modèle CIUP dans un fichier.
     * <p>
     * Utilise la sérialisation Java pour enregistrer l'état complet
     * du modèle CIUP sur le disque dur.
     * </p>
     * 
     * @param file Le fichier dans lequel sauvegarder les données (optionnel)
     * @return true si la sauvegarde a réussi, false sinon
     */
    public boolean saveData(File file) {
        File saveFile = (file != null) ? file : new File(DEFAULT_SAVE_FILE);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            CIUP ciupModel = mainControleur.getCiupModel();
            oos.writeObject(ciupModel);
            
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Données sauvegardées avec succès dans " + saveFile.getAbsolutePath(),
                "Sauvegarde réussie",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Erreur lors de la sauvegarde des données: " + e.getMessage(),
                "Erreur de sauvegarde",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Sauvegarde le modèle CIUP dans le fichier par défaut.
     * 
     * @return true si la sauvegarde a réussi, false sinon
     */
    public boolean saveData() {
        return saveData(null);
    }
    
    /**
     * Charge le modèle CIUP depuis un fichier.
     * <p>
     * Utilise la désérialisation Java pour restaurer l'état complet
     * du modèle CIUP depuis le disque dur.
     * </p>
     * 
     * @param file Le fichier depuis lequel charger les données (optionnel)
     * @return Le modèle CIUP chargé ou null en cas d'échec
     */
    public CIUP loadData(File file) {
        File loadFile = (file != null) ? file : new File(DEFAULT_SAVE_FILE);
        
        if (!loadFile.exists()) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Aucun fichier de sauvegarde trouvé à " + loadFile.getAbsolutePath(),
                "Fichier introuvable",
                JOptionPane.WARNING_MESSAGE
            );
            return null;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadFile))) {
            CIUP ciupModel = (CIUP) ois.readObject();
            
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Données chargées avec succès depuis " + loadFile.getAbsolutePath(),
                "Chargement réussi",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            return ciupModel;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Erreur lors du chargement des données: " + e.getMessage(),
                "Erreur de chargement",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Charge le modèle CIUP depuis le fichier par défaut.
     * 
     * @return Le modèle CIUP chargé ou null en cas d'échec
     */
    public CIUP loadData() {
        return loadData(null);
    }
    
    /**
     * Affiche une boîte de dialogue pour sélectionner un fichier de sauvegarde.
     * 
     * @param forSaving true pour un dialogue de sauvegarde, false pour un dialogue d'ouverture
     * @return Le fichier sélectionné ou null si annulé
     */
    public File showFileDialog(boolean forSaving) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(forSaving ? "Sauvegarder les données" : "Charger les données");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".ser");
            }
            
            @Override
            public String getDescription() {
                return "Fichiers de données CIUP (*.ser)";
            }
        });
        
        int result = forSaving 
            ? fileChooser.showSaveDialog(mainControleur.getMainFrame())
            : fileChooser.showOpenDialog(mainControleur.getMainFrame());
            
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            // Ajouter l'extension .ser si nécessaire pour la sauvegarde
            if (forSaving && !selectedFile.getName().toLowerCase().endsWith(".ser")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".ser");
            }
            
            return selectedFile;
        }
        
        return null;
    }
}
/**
 * cette classe a été crée par @author Flavio Zamperlini
 */