package controleurs;

import modeles.CIUP;

import javax.swing.*;
import java.io.*;

/**
 * Contr�leur pour la gestion de la persistance des donn�es.
 * <p>
 * Cette classe fournit des m�thodes pour sauvegarder et charger
 * le mod�le CIUP depuis le disque dur en utilisant la s�rialisation Java.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 */
public class PersistenceControleur {
    
    private MainControleur mainControleur;
    private static final String DEFAULT_SAVE_FILE = "ciup_data.ser";
    
    /**
     * Constructeur du contr�leur de persistance.
     * 
     * @param mainControleur Le contr�leur principal
     */
    public PersistenceControleur(MainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }
    
    /**
     * Sauvegarde le mod�le CIUP dans un fichier.
     * <p>
     * Utilise la s�rialisation Java pour enregistrer l'�tat complet
     * du mod�le CIUP sur le disque dur.
     * </p>
     * 
     * @param file Le fichier dans lequel sauvegarder les donn�es (optionnel)
     * @return true si la sauvegarde a r�ussi, false sinon
     */
    public boolean saveData(File file) {
        File saveFile = (file != null) ? file : new File(DEFAULT_SAVE_FILE);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            CIUP ciupModel = mainControleur.getCiupModel();
            oos.writeObject(ciupModel);
            
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Donn�es sauvegard�es avec succ�s dans " + saveFile.getAbsolutePath(),
                "Sauvegarde r�ussie",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Erreur lors de la sauvegarde des donn�es: " + e.getMessage(),
                "Erreur de sauvegarde",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Sauvegarde le mod�le CIUP dans le fichier par d�faut.
     * 
     * @return true si la sauvegarde a r�ussi, false sinon
     */
    public boolean saveData() {
        return saveData(null);
    }
    
    /**
     * Charge le mod�le CIUP depuis un fichier.
     * <p>
     * Utilise la d�s�rialisation Java pour restaurer l'�tat complet
     * du mod�le CIUP depuis le disque dur.
     * </p>
     * 
     * @param file Le fichier depuis lequel charger les donn�es (optionnel)
     * @return Le mod�le CIUP charg� ou null en cas d'�chec
     */
    public CIUP loadData(File file) {
        File loadFile = (file != null) ? file : new File(DEFAULT_SAVE_FILE);
        
        if (!loadFile.exists()) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Aucun fichier de sauvegarde trouv� � " + loadFile.getAbsolutePath(),
                "Fichier introuvable",
                JOptionPane.WARNING_MESSAGE
            );
            return null;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadFile))) {
            CIUP ciupModel = (CIUP) ois.readObject();
            
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Donn�es charg�es avec succ�s depuis " + loadFile.getAbsolutePath(),
                "Chargement r�ussi",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            return ciupModel;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Erreur lors du chargement des donn�es: " + e.getMessage(),
                "Erreur de chargement",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Charge le mod�le CIUP depuis le fichier par d�faut.
     * 
     * @return Le mod�le CIUP charg� ou null en cas d'�chec
     */
    public CIUP loadData() {
        return loadData(null);
    }
    
    /**
     * Affiche une bo�te de dialogue pour s�lectionner un fichier de sauvegarde.
     * 
     * @param forSaving true pour un dialogue de sauvegarde, false pour un dialogue d'ouverture
     * @return Le fichier s�lectionn� ou null si annul�
     */
    public File showFileDialog(boolean forSaving) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(forSaving ? "Sauvegarder les donn�es" : "Charger les donn�es");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".ser");
            }
            
            @Override
            public String getDescription() {
                return "Fichiers de donn�es CIUP (*.ser)";
            }
        });
        
        int result = forSaving 
            ? fileChooser.showSaveDialog(mainControleur.getMainFrame())
            : fileChooser.showOpenDialog(mainControleur.getMainFrame());
            
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            // Ajouter l'extension .ser si n�cessaire pour la sauvegarde
            if (forSaving && !selectedFile.getName().toLowerCase().endsWith(".ser")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".ser");
            }
            
            return selectedFile;
        }
        
        return null;
    }
}
/**
 * cette classe a �t� cr�e par @author Flavio Zamperlini
 */