package view;

import controller.MainController;
import modele.Maison;
import modele.MaisonClassique;
import modele.MaisonInternationale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddHouseDialog extends JDialog {
    private JComboBox<String> typeComboBox;
    private JTextField numField;
    private JTextField nomField;
    private JTextField descField;
    private JTextField telField;
    private JTextField localisationField;
    private JTextField directeurField;
    private JTextField anneeCreationField;
    private JTextField dateFeteField;
    private JTextField dureeFeteField;
    
    // Champs spécifiques pour MaisonClassique
    private JPanel maisonClassiquePanel;
    private JTextField nationaliteField;
    private JTextField capaciteField;
    
    private JButton saveButton;
    private JButton cancelButton;
    
    private MainController controller;
    
    public AddHouseDialog(JFrame parent, MainController controller) {
        super(parent, "Ajouter une maison", true);
        this.controller = controller;
        
        setSize(600, 650);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        
        initComponents();
        layoutComponents();
        
        // Par défaut, on affiche les champs pour MaisonClassique
        updateFieldsVisibility("Maison Classique");
    }
    
    private void initComponents() {
        // Type de maison
        String[] types = {"Maison Classique", "Maison Internationale"};
        typeComboBox = new JComboBox<>(types);
        typeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateFieldsVisibility((String) typeComboBox.getSelectedItem());
                }
            }
        });
        
        // Champs communs
        numField = new JTextField(10);
        nomField = new JTextField(20);
        descField = new JTextField(20);
        telField = new JTextField(20);
        localisationField = new JTextField(20);
        directeurField = new JTextField(20);
        anneeCreationField = new JTextField(10);
        dateFeteField = new JTextField(10);
        dureeFeteField = new JTextField(10);
        
        // Champs spécifiques pour MaisonClassique
        nationaliteField = new JTextField(20);
        capaciteField = new JTextField(10);
        
        // Boutons
        saveButton = new JButton("Enregistrer");
        cancelButton = new JButton("Annuler");
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHouse();
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void layoutComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Panel pour le type de maison
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typePanel.add(new JLabel("Type de maison:"));
        typePanel.add(typeComboBox);
        
        // Panel pour les informations générales
        JPanel generalPanel = new JPanel(new GridBagLayout());
        generalPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations générales",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Ligne 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        generalPanel.add(new JLabel("Numéro:"), gbc);
        
        gbc.gridx = 1;
        generalPanel.add(numField, gbc);
        
        gbc.gridx = 2;
        generalPanel.add(new JLabel("Nom:"), gbc);
        
        gbc.gridx = 3;
        generalPanel.add(nomField, gbc);
        
        // Ligne 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        generalPanel.add(new JLabel("Description:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        generalPanel.add(descField, gbc);
        
        // Ligne 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        generalPanel.add(new JLabel("Téléphone:"), gbc);
        
        gbc.gridx = 1;
        generalPanel.add(telField, gbc);
        
        gbc.gridx = 2;
        generalPanel.add(new JLabel("Localisation:"), gbc);
        
        gbc.gridx = 3;
        generalPanel.add(localisationField, gbc);
        
        // Ligne 4
        gbc.gridx = 0;
        gbc.gridy = 3;
        generalPanel.add(new JLabel("Directeur:"), gbc);
        
        gbc.gridx = 1;
        generalPanel.add(directeurField, gbc);
        
        gbc.gridx = 2;
        generalPanel.add(new JLabel("Année de création:"), gbc);
        
        gbc.gridx = 3;
        generalPanel.add(anneeCreationField, gbc);
        
        // Ligne 5
        gbc.gridx = 0;
        gbc.gridy = 4;
        generalPanel.add(new JLabel("Date de fête:"), gbc);
        
        gbc.gridx = 1;
        generalPanel.add(dateFeteField, gbc);
        
        gbc.gridx = 2;
        generalPanel.add(new JLabel("Durée de fête (jours):"), gbc);
        
        gbc.gridx = 3;
        generalPanel.add(dureeFeteField, gbc);
        
        // Panel pour les informations spécifiques à MaisonClassique
        maisonClassiquePanel = new JPanel(new GridBagLayout());
        maisonClassiquePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations spécifiques",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        GridBagConstraints gbcSpecific = new GridBagConstraints();
        gbcSpecific.fill = GridBagConstraints.HORIZONTAL;
        gbcSpecific.insets = new Insets(5, 5, 5, 5);
        
        // Ligne 1
        gbcSpecific.gridx = 0;
        gbcSpecific.gridy = 0;
        maisonClassiquePanel.add(new JLabel("Nationalité:"), gbcSpecific);
        
        gbcSpecific.gridx = 1;
        maisonClassiquePanel.add(nationaliteField, gbcSpecific);
        
        // Ligne 2
        gbcSpecific.gridx = 0;
        gbcSpecific.gridy = 1;
        maisonClassiquePanel.add(new JLabel("Capacité:"), gbcSpecific);
        
        gbcSpecific.gridx = 1;
        maisonClassiquePanel.add(capaciteField, gbcSpecific);
        
        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        
        // Ajouter tous les panels au panel principal
        mainPanel.add(typePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(generalPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(maisonClassiquePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);
        
        // Ajouter le panel principal à la fenêtre
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }
    
    private void updateFieldsVisibility(String type) {
        if ("Maison Classique".equals(type)) {
            maisonClassiquePanel.setVisible(true);
        } else {
            maisonClassiquePanel.setVisible(false);
        }
        
        // Redimensionner la fenêtre
        pack();
        setSize(getWidth(), Math.min(650, getHeight()));
    }
    
    private void saveHouse() {
        // Valider les champs
        if (nomField.getText().isEmpty() || descField.getText().isEmpty() ||
            telField.getText().isEmpty() || localisationField.getText().isEmpty() ||
            directeurField.getText().isEmpty() || anneeCreationField.getText().isEmpty() ||
            dateFeteField.getText().isEmpty() || dureeFeteField.getText().isEmpty() ||
            numField.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "Veuillez remplir tous les champs obligatoires.", 
                "Formulaire incomplet", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int num = Integer.parseInt(numField.getText());
            int anneeCreation = Integer.parseInt(anneeCreationField.getText());
            int dureeFete = Integer.parseInt(dureeFeteField.getText());
            
            String type = (String) typeComboBox.getSelectedItem();
            
            if ("Maison Classique".equals(type)) {
                // Valider les champs spécifiques
                if (nationaliteField.getText().isEmpty() || capaciteField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Veuillez remplir tous les champs spécifiques.", 
                        "Formulaire incomplet", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int capacite = Integer.parseInt(capaciteField.getText());
                
                // Créer une MaisonClassique
                MaisonClassique maison = new MaisonClassique(
                    num, 
                    nomField.getText(), 
                    descField.getText(), 
                    telField.getText(), 
                    localisationField.getText(), 
                    directeurField.getText(), 
                    anneeCreation, 
                    dateFeteField.getText(), 
                    dureeFete
                );
                
                maison.setNationalite(nationaliteField.getText());
                maison.setCapacite(capacite);
                
                // Ajouter la maison
                controller.addHouse(maison);
            } else {
                // Créer une MaisonInternationale
                MaisonInternationale maison = new MaisonInternationale(
                    num, 
                    nomField.getText(), 
                    descField.getText(), 
                    telField.getText(), 
                    localisationField.getText(), 
                    directeurField.getText(), 
                    anneeCreation, 
                    dateFeteField.getText(), 
                    dureeFete
                );
                
                // Ajouter la maison
                controller.addHouse(maison);
            }
            
            // Fermer la fenêtre
            dispose();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Veuillez entrer des valeurs numériques valides pour les champs numériques.", 
                "Erreur de format", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
