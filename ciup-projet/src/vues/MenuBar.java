package vues;

import controleurs.MainControleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Barre de menu de l'application CIUP.
 * <p>
 * Cette classe fournit une barre de menu avec des options pour
 * gérer les fichiers, les maisons, les étudiants et les services.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 */
public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
    
    private MainControleur controleur;
    
    /**
     * Constructeur de la barre de menu.
     * 
     * @param controleur Le contrôleur principal
     */
    public MenuBar(MainControleur controleur) {
        this.controleur = controleur;
        initMenus();
    }
    
    /**
     * Initialise les menus de la barre de menu.
     */
    private void initMenus() {
        // Menu Fichier
        JMenu fileMenu = new JMenu("Fichier");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem saveItem = new JMenuItem("Sauvegarder", KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveItem.addActionListener(e -> controleur.saveData());
        
        JMenuItem saveAsItem = new JMenuItem("Sauvegarder sous...");
        saveAsItem.addActionListener(e -> controleur.saveDataWithDialog());
        
        JMenuItem loadItem = new JMenuItem("Charger", KeyEvent.VK_O);
        loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        loadItem.addActionListener(e -> controleur.loadData());
        
        JMenuItem loadFromItem = new JMenuItem("Charger depuis...");
        loadFromItem.addActionListener(e -> controleur.loadDataWithDialog());
        
        JMenuItem exitItem = new JMenuItem("Quitter", KeyEvent.VK_Q);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(loadItem);
        fileMenu.add(loadFromItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        // Menu Maisons
        JMenu housesMenu = new JMenu("Maisons");
        housesMenu.setMnemonic(KeyEvent.VK_M);
        
        JMenuItem listHousesItem = new JMenuItem("Liste des maisons", KeyEvent.VK_L);
        listHousesItem.addActionListener(e -> controleur.showHousesList());
        
        JMenuItem addHouseItem = new JMenuItem("Ajouter une maison", KeyEvent.VK_A);
        addHouseItem.addActionListener(e -> controleur.getMaisonControleur().showAddHouseDialog());
        
        housesMenu.add(listHousesItem);
        housesMenu.add(addHouseItem);
        
        // Menu Étudiants
        JMenu studentsMenu = new JMenu("Étudiants");
        studentsMenu.setMnemonic(KeyEvent.VK_E);
        
        JMenuItem registerStudentItem = new JMenuItem("Inscrire un étudiant", KeyEvent.VK_I);
        registerStudentItem.addActionListener(e -> controleur.showInscription());
        
        studentsMenu.add(registerStudentItem);
        
        // Menu Aide
        JMenu helpMenu = new JMenu("Aide");
        helpMenu.setMnemonic(KeyEvent.VK_A);
        
        JMenuItem aboutItem = new JMenuItem("À propos", KeyEvent.VK_P);
        aboutItem.addActionListener(e -> showAboutDialog());
        
        helpMenu.add(aboutItem);
        
        // Ajouter les menus à la barre
        add(fileMenu);
        add(housesMenu);
        add(studentsMenu);
        add(helpMenu);
    }
    
    /**
     * Affiche la boîte de dialogue "À propos".
     */
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(
            controleur.getMainFrame(),
            "CIUP - Cité Internationale Universitaire de Paris\n" +
            "Version 1.1\n\n" +
            "Application de gestion des maisons et des étudiants\n" +
            "© 2025 CIUP Development Team",
            "À propos de CIUP",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
