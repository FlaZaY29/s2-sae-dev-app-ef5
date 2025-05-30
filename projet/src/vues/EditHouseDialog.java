package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controleurs.MainControleur;
import modeles.Maison;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;

/**
 * Boîte de dialogue pour modifier une maison
 */
public class EditHouseDialog extends JDialog {
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

    private JTextField imagePathField;
    private JButton browseButton;
    private String selectedImagePath;

    private JButton saveButton;
    private JButton cancelButton;

    private MainControleur controleur;
    private Maison maisonToEdit;

    /**
     * Constructeur de la boîte de dialogue de modification de maison
     * @param parent La fenêtre parente
     * @param controleur Le contrôleur principal
     * @param maison La maison à modifier
     */
    public EditHouseDialog(JFrame parent, MainControleur controleur, Maison maison) {
        super(parent, "Modifier la maison", true);
        this.controleur = controleur;
        this.maisonToEdit = maison;

        setSize(600, 650);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        initComponents();
        populateFields();
        layoutComponents();

        // Ajouter les écouteurs d'événements
        typeComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateFieldsVisibility((String) typeComboBox.getSelectedItem());
            }
        });

        saveButton.addActionListener(e -> saveHouse());

        cancelButton.addActionListener(e -> dispose());

        // Mettre à jour la visibilité des champs selon le type de maison
        updateFieldsVisibility((String) typeComboBox.getSelectedItem());
    }

    /**
     * Initialise les composants de la boîte de dialogue
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

        // Champs spécifiques pour MaisonClassique
        nationaliteField = new JTextField(20);
        capaciteField = new JTextField(10);

        // Image selection
        imagePathField = new JTextField(20);
        imagePathField.setEditable(false);
        browseButton = new JButton("Parcourir...");
        browseButton.addActionListener(e -> browseForImage());

        // Boutons
        saveButton = new JButton("Sauvegarder");
        cancelButton = new JButton("Annuler");
    }

    /**
     * Remplit les champs avec les données de la maison à modifier
     */
    private void populateFields() {
        numField.setText(String.valueOf(maisonToEdit.getNum()));
        nomField.setText(maisonToEdit.getNom());
        descField.setText(maisonToEdit.getDesc());
        telField.setText(maisonToEdit.getTel());
        localisationField.setText(maisonToEdit.getLocalisation());
        directeurField.setText(maisonToEdit.getDirecteur());
        anneeCreationField.setText(String.valueOf(maisonToEdit.getAnneeCreation()));
        dateFeteField.setText(maisonToEdit.getDateFete());
        dureeFeteField.setText(String.valueOf(maisonToEdit.getDureeFete()));

        // Définir le type de maison
        if (maisonToEdit instanceof MaisonClassique) {
            typeComboBox.setSelectedItem("Maison Classique");
            MaisonClassique maisonClassique = (MaisonClassique) maisonToEdit;
            nationaliteField.setText(maisonClassique.getNationalite());
            capaciteField.setText(String.valueOf(maisonClassique.getCapacite()));
        } else if (maisonToEdit instanceof MaisonInternationale) {
            typeComboBox.setSelectedItem("Maison Internationale");
        }

        // Image path
        if (maisonToEdit.hasProperty("imagePath")) {
            selectedImagePath = maisonToEdit.getProperty("imagePath");
            imagePathField.setText(selectedImagePath);
        }
    }

    /**
     * Organise les composants dans la boîte de dialogue
     */
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

        // Ajouter le panel principal à la fenêtre
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }

    /**
     * Met à jour la visibilité des champs en fonction du type de maison
     * @param type Le type de maison
     */
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

    /**
     * Ouvre un sélecteur de fichier pour choisir une image
     */
    private void browseForImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Sélectionner une image");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
			public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String name = f.getName().toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") ||
                       name.endsWith(".png") || name.endsWith(".gif");
            }
            @Override
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
     * Sauvegarde les modifications de la maison
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

            // Mettre à jour les propriétés communes
            maisonToEdit.setNum(num);
            maisonToEdit.setNom(nomField.getText());
            maisonToEdit.setDesc(descField.getText());
            maisonToEdit.setTel(telField.getText());
            maisonToEdit.setLocalisation(localisationField.getText());
            maisonToEdit.setDirecteur(directeurField.getText());
            maisonToEdit.setAnneeCreation(anneeCreation);
            maisonToEdit.setDateFete(dateFeteField.getText());
            maisonToEdit.setDureeFete(dureeFete);

            String type = (String) typeComboBox.getSelectedItem();

            if ("Maison Classique".equals(type) && maisonToEdit instanceof MaisonClassique) {
                // Valider les champs spécifiques
                if (nationaliteField.getText().isEmpty() || capaciteField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                        "Veuillez remplir tous les champs spécifiques.",
                        "Formulaire incomplet",
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int capacite = Integer.parseInt(capaciteField.getText());

                MaisonClassique maisonClassique = (MaisonClassique) maisonToEdit;
                maisonClassique.setNationalite(nationaliteField.getText());
                maisonClassique.setCapacite(capacite);
            }

            // Mettre à jour le chemin de l'image si une nouvelle image a été sélectionnée
            if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
                maisonToEdit.setProperty("imagePath", selectedImagePath);
            }

            // Notifier le contrôleur que la maison a été modifiée
            controleur.getMaisonControleur().updateHouse(maisonToEdit);

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
/**
 * cette classe a été crée par @author Donald Se
 */