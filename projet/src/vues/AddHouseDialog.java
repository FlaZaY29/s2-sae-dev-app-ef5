package vues;

import controleurs.MainControleur;
import modeles.Maison;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;

/**
 * Bo�te de dialogue pour ajouter une maison
 */
public class AddHouseDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
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
    
    // Champs sp�cifiques pour MaisonClassique
    private JPanel maisonClassiquePanel;
    private JTextField nationaliteField;
    private JTextField capaciteField;

    private JTextField imagePathField;
    private JButton browseButton;
    private String selectedImagePath;
    
    private JButton saveButton;
    private JButton cancelButton;
    
    private MainControleur controleur;
    
    /**
     * Constructeur de la bo�te de dialogue d'ajout de maison
     * @param parent La fen�tre parente
     * @param controleur Le contr�leur principal
     */
    public AddHouseDialog(JFrame parent, MainControleur controleur) {
        super(parent, "Ajouter une maison", true);
        this.controleur = controleur;
        
        setSize(600, 650);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        
        initComponents();
        layoutComponents();
        
        // Ajouter les �couteurs d'�v�nements
        typeComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateFieldsVisibility((String) typeComboBox.getSelectedItem());
            }
        });
        
        saveButton.addActionListener(e -> saveHouse());
        
        cancelButton.addActionListener(e -> dispose());

        // Par d�faut, on affiche les champs pour MaisonClassique
        updateFieldsVisibility("Maison Classique");
    }
    
    /**
     * Initialise les composants de la bo�te de dialogue
     */
    private void initComponents() {
        // Type de maison
        String[] types = {"Maison Classique", "Maison Internationale"};
        typeComboBox = new JComboBox<>(types);
        
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
        
        // Champs sp�cifiques pour MaisonClassique
        nationaliteField = new JTextField(20);
        capaciteField = new JTextField(10);

        // Image selection
        imagePathField = new JTextField(20);
        imagePathField.setEditable(false);
        browseButton = new JButton("Parcourir...");
        browseButton.addActionListener(e -> browseForImage());
        
        // Boutons
        saveButton = new JButton("Enregistrer");
        cancelButton = new JButton("Annuler");
    }
    
    /**
     * Organise les composants dans la bo�te de dialogue
     */
    private void layoutComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Panel pour le type de maison
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typePanel.add(new JLabel("Type de maison:"));
        typePanel.add(typeComboBox);
        
        // Panel pour les informations g�n�rales
        JPanel generalPanel = new JPanel(new GridBagLayout());
        generalPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations g�n�rales",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Ligne 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        generalPanel.add(new JLabel("Num�ro:"), gbc);
        
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
        generalPanel.add(new JLabel("T�l�phone:"), gbc);
        
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
        generalPanel.add(new JLabel("Ann�e de cr�ation:"), gbc);
        
        gbc.gridx = 3;
        generalPanel.add(anneeCreationField, gbc);
        
        // Ligne 5
        gbc.gridx = 0;
        gbc.gridy = 4;
        generalPanel.add(new JLabel("Date de f�te:"), gbc);
        
        gbc.gridx = 1;
        generalPanel.add(dateFeteField, gbc);
        
        gbc.gridx = 2;
        generalPanel.add(new JLabel("Dur�e de f�te (jours):"), gbc);
        
        gbc.gridx = 3;
        generalPanel.add(dureeFeteField, gbc);
        
        // Panel pour les informations sp�cifiques � MaisonClassique
        maisonClassiquePanel = new JPanel(new GridBagLayout());
        maisonClassiquePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations sp�cifiques",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        GridBagConstraints gbcSpecific = new GridBagConstraints();
        gbcSpecific.fill = GridBagConstraints.HORIZONTAL;
        gbcSpecific.insets = new Insets(5, 5, 5, 5);
        
        // Ligne 1
        gbcSpecific.gridx = 0;
        gbcSpecific.gridy = 0;
        maisonClassiquePanel.add(new JLabel("Nationalit�:"), gbcSpecific);
        
        gbcSpecific.gridx = 1;
        maisonClassiquePanel.add(nationaliteField, gbcSpecific);
        
        // Ligne 2
        gbcSpecific.gridx = 0;
        gbcSpecific.gridy = 1;
        maisonClassiquePanel.add(new JLabel("Capacit�:"), gbcSpecific);
        
        gbcSpecific.gridx = 1;
        maisonClassiquePanel.add(capaciteField, gbcSpecific);

        // Image panel
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Image de la maison",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        JPanel imageFieldPanel = new JPanel(new BorderLayout());
        imageFieldPanel.add(new JLabel("Chemin de l'image:"), BorderLayout.WEST);
        imageFieldPanel.add(imagePathField, BorderLayout.CENTER);
        imageFieldPanel.add(browseButton, BorderLayout.EAST);
        
        imagePanel.add(imageFieldPanel);
        
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
        mainPanel.add(imagePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);
        
        // Ajouter le panel principal � la fen�tre
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }
    
    /**
     * Met � jour la visibilit� des champs en fonction du type de maison
     * @param type Le type de maison
     */
    private void updateFieldsVisibility(String type) {
        if ("Maison Classique".equals(type)) {
            maisonClassiquePanel.setVisible(true);
        } else {
            maisonClassiquePanel.setVisible(false);
        }
        
        // Redimensionner la fen�tre
        pack();
        setSize(getWidth(), Math.min(650, getHeight()));
    }

    /**
     * Ouvre un s�lecteur de fichier pour choisir une image
     */
    private void browseForImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("S�lectionner une image");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String name = f.getName().toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") || 
                       name.endsWith(".png") || name.endsWith(".gif");
            }
            public String getDescription() {
                return "Images (*.jpg, *.jpeg, *.png, *.gif)";
            }
        });
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            selectedImagePath = selectedFile.getAbsolutePath();
            imagePathField.setText(selectedImagePath);
        }
    }
    
    /**
     * Sauvegarde la maison cr�e
     */
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
                // Valider les champs sp�cifiques
                if (nationaliteField.getText().isEmpty() || capaciteField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Veuillez remplir tous les champs sp�cifiques.", 
                        "Formulaire incomplet", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int capacite = Integer.parseInt(capaciteField.getText());
                
                // Cr�er une MaisonClassique via le contr�leur
                MaisonClassique maison = controleur.getMaisonControleur().createMaisonClassique(
                    num, 
                    nomField.getText(), 
                    descField.getText(), 
                    telField.getText(), 
                    localisationField.getText(), 
                    directeurField.getText(), 
                    anneeCreation, 
                    dateFeteField.getText(), 
                    dureeFete,
                    nationaliteField.getText(),
                    capacite
                );

                // Set the image path if one was selected
                if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
                    // Store the image path in a property of the maison
                    maison.setProperty("imagePath", selectedImagePath);
                }
                
                // Ajouter la maison via le contr�leur
                controleur.getMaisonControleur().addHouse(maison);
            } else {
                // Cr�er une MaisonInternationale via le contr�leur
                MaisonInternationale maison = controleur.getMaisonControleur().createMaisonInternationale(
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

                // Set the image path if one was selected
                if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
                    // Store the image path in a property of the maison
                    maison.setProperty("imagePath", selectedImagePath);
                }
                
                // Ajouter la maison via le contr�leur
                controleur.getMaisonControleur().addHouse(maison);
            }
            
            // Fermer la fen�tre
            dispose();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Veuillez entrer des valeurs num�riques valides pour les champs num�riques.", 
                "Erreur de format", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Retourne le type de maison s�lectionn�
     * @return Le type de maison
     */
    public String getSelectedType() {
        return (String) typeComboBox.getSelectedItem();
    }
    
    /**
     * Retourne le num�ro de la maison
     * @return Le num�ro de la maison
     */
    public String getNumField() {
        return numField.getText();
    }
    
    /**
     * Retourne le nom de la maison
     * @return Le nom de la maison
     */
    public String getNomField() {
        return nomField.getText();
    }
    
    /**
     * Retourne la description de la maison
     * @return La description de la maison
     */
    public String getDescField() {
        return descField.getText();
    }
    
    /**
     * Retourne le t�l�phone de la maison
     * @return Le t�l�phone de la maison
     */
    public String getTelField() {
        return telField.getText();
    }
    
    /**
     * Retourne la localisation de la maison
     * @return La localisation de la maison
     */
    public String getLocalisationField() {
        return localisationField.getText();
    }
    
    /**
     * Retourne le directeur de la maison
     * @return Le directeur de la maison
     */
    public String getDirecteurField() {
        return directeurField.getText();
    }
    
    /**
     * Retourne l'ann�e de cr�ation de la maison
     * @return L'ann�e de cr�ation de la maison
     */
    public String getAnneeCreationField() {
        return anneeCreationField.getText();
    }
    
    /**
     * Retourne la date de f�te de la maison
     * @return La date de f�te de la maison
     */
    public String getDateFeteField() {
        return dateFeteField.getText();
    }
    
    /**
     * Retourne la dur�e de f�te de la maison
     * @return La dur�e de f�te de la maison
     */
    public String getDureeFeteField() {
        return dureeFeteField.getText();
    }
    
    /**
     * Retourne la nationalit� de la maison
     * @return La nationalit� de la maison
     */
    public String getNationaliteField() {
        return nationaliteField.getText();
    }
    
    /**
     * Retourne la capacit� de la maison
     * @return La capacit� de la maison
     */
    public String getCapaciteField() {
        return capaciteField.getText();
    }

    /**
     * Retourne le chemin de l'image s�lectionn�e
     * @return Le chemin de l'image
     */
    public String getSelectedImagePath() {
        return selectedImagePath;
    }
    
    /**
     * Retourne le bouton d'enregistrement
     * @return Le bouton d'enregistrement
     */
    public JButton getSaveButton() {
        return saveButton;
    }
    
    /**
     * Retourne le bouton d'annulation
     * @return Le bouton d'annulation
     */
    public JButton getCancelButton() {
        return cancelButton;
    }
    
    /**
     * Retourne la combobox de type
     * @return La combobox de type
     */
    public JComboBox<String> getTypeComboBox() {
        return typeComboBox;
    }
}
/**
 * cette classe a �t� cr�e par @author Donald Se
 */