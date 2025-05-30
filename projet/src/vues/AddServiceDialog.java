package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controleurs.ServiceControleur;
import modeles.MaisonInternationale;
import modeles.Service;

/**
 * Boîte de dialogue pour ajouter un service
 */
public class AddServiceDialog extends JDialog {
    private ServiceControleur serviceControleur;
    private MaisonInternationale maisonInternationale;

    private JTextField numField;
    private JTextField nomField;
    private JTextField descField;
    private JSpinner heureOuvSpinner;
    private JSpinner heureFermSpinner;

    private JButton saveButton;
    private JButton cancelButton;

    /**
     * Constructeur de la boîte de dialogue d'ajout de service
     * @param parent La fenêtre parente
     * @param serviceControleur Le contrôleur de services
     * @param maisonInternationale La maison internationale
     */
    public AddServiceDialog(JFrame parent, ServiceControleur serviceControleur,
                           MaisonInternationale maisonInternationale) {
        super(parent, "Ajouter un service", true);
        this.serviceControleur = serviceControleur;
        this.maisonInternationale = maisonInternationale;

        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        initComponents();
        layoutComponents();

        // Set default service number
        numField.setText(String.valueOf(serviceControleur.generateNewServiceNumber()));

        // Add event listeners
        saveButton.addActionListener(e -> saveService());
        cancelButton.addActionListener(e -> dispose());
    }

    /**
     * Initialise les composants de la boîte de dialogue
     */
    private void initComponents() {
        // Service information fields
        numField = new JTextField(10);
        nomField = new JTextField(20);
        descField = new JTextField(30);

        // Hour spinners
        heureOuvSpinner = new JSpinner(new SpinnerNumberModel(8, 0, 23, 1));
        heureFermSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 23, 1));

        // Buttons
        saveButton = new JButton("Enregistrer");
        saveButton.setBackground(new Color(0, 150, 136));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);

        cancelButton = new JButton("Annuler");
    }

    /**
     * Organise les composants dans la boîte de dialogue
     */
    private void layoutComponents() {
        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 150, 136));
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Nouveau Service pour " + maisonInternationale.getNom());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Service information panel
        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "Informations du service",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Row 1: Number and Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        infoPanel.add(new JLabel("Numéro:"), gbc);

        gbc.gridx = 1;
        infoPanel.add(numField, gbc);

        gbc.gridx = 2;
        infoPanel.add(new JLabel("Nom:"), gbc);

        gbc.gridx = 3;
        infoPanel.add(nomField, gbc);

        // Row 2: Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        infoPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        infoPanel.add(descField, gbc);

        // Row 3: Hours
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        infoPanel.add(new JLabel("Heure d'ouverture:"), gbc);

        gbc.gridx = 1;
        infoPanel.add(heureOuvSpinner, gbc);

        gbc.gridx = 2;
        infoPanel.add(new JLabel("Heure de fermeture:"), gbc);

        gbc.gridx = 3;
        infoPanel.add(heureFermSpinner, gbc);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(saveButton);

        // Add panels to main panel
        mainPanel.add(infoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(buttonsPanel);

        // Add panels to dialog
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }

    /**
     * Sauvegarde le service créé
     */
    private void saveService() {
        // Validate fields
        if (nomField.getText().trim().isEmpty() || descField.getText().trim().isEmpty() ||
            numField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                "Veuillez remplir tous les champs obligatoires.",
                "Formulaire incomplet",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int num = Integer.parseInt(numField.getText().trim());
            String nom = nomField.getText().trim();
            String desc = descField.getText().trim();
            int heureOuv = (Integer) heureOuvSpinner.getValue();
            int heureFerm = (Integer) heureFermSpinner.getValue();

            // Validate hours
            if (heureOuv >= heureFerm) {
                JOptionPane.showMessageDialog(this,
                    "L'heure d'ouverture doit être antérieure à l'heure de fermeture.",
                    "Heures invalides",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Check if service number already exists
            if (serviceControleur.serviceNumberExists(num)) {
                JOptionPane.showMessageDialog(this,
                    "Ce numéro de service existe déjà. Veuillez en choisir un autre.",
                    "Numéro existant",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Create service
            Service service = serviceControleur.createService(num, nom, desc, heureOuv, heureFerm);

            // Add service
            serviceControleur.addService(service, maisonInternationale);

            // Close dialog
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Veuillez entrer un numéro valide.",
                "Erreur de format",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retourne le champ de numéro
     * @return Le champ de numéro
     */
    public JTextField getNumField() {
        return numField;
    }

    /**
     * Retourne le champ de nom
     * @return Le champ de nom
     */
    public JTextField getNomField() {
        return nomField;
    }

    /**
     * Retourne le champ de description
     * @return Le champ de description
     */
    public JTextField getDescField() {
        return descField;
    }

    /**
     * Retourne le spinner d'heure d'ouverture
     * @return Le spinner d'heure d'ouverture
     */
    public JSpinner getHeureOuvSpinner() {
        return heureOuvSpinner;
    }

    /**
     * Retourne le spinner d'heure de fermeture
     * @return Le spinner d'heure de fermeture
     */
    public JSpinner getHeureFermSpinner() {
        return heureFermSpinner;
    }
}
/**
 * cette classe a été crée par @author Maksen Mouhou
 */