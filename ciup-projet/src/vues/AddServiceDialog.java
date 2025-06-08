package vues;

import controleurs.ServiceControleur;
import modeles.MaisonInternationale;
import modeles.Service;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Boîte de dialogue pour ajouter un service
 */
public class AddServiceDialog extends JDialog {
    private static final long serialVersionUID = 1L;

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

        numField.setText(String.valueOf(serviceControleur.generateNewServiceNumber()));

        saveButton.addActionListener(e -> saveService());
        cancelButton.addActionListener(e -> dispose());
    }

    /**
     * Initialise les composants de la boîte de dialogue
     */
    private void initComponents() {
        numField = new JTextField(10);
        nomField = new JTextField(20);
        descField = new JTextField(30);

        heureOuvSpinner = new JSpinner(new SpinnerNumberModel(8, 0, 23, 1));
        heureFermSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 23, 1));

        saveButton = new JButton("Enregistrer");
        saveButton.setBackground(new Color(0, 150, 136));
        saveButton.setFocusPainted(false);

        cancelButton = new JButton("Annuler");
    }

    /**
     * Organise les composants dans la boîte de dialogue
     */
    private void layoutComponents() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 150, 136));
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Nouveau Service pour " + maisonInternationale.getNom());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

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

        gbc.gridx = 0;
        gbc.gridy = 0;
        infoPanel.add(new JLabel("Numéro:"), gbc);

        gbc.gridx = 1;
        infoPanel.add(numField, gbc);

        gbc.gridx = 2;
        infoPanel.add(new JLabel("Nom:"), gbc);

        gbc.gridx = 3;
        infoPanel.add(nomField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        infoPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        infoPanel.add(descField, gbc);

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

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(saveButton);

        mainPanel.add(infoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(buttonsPanel);

        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }

    /**
     * Sauvegarde le service créé
     */
    private void saveService() {
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

            if (heureOuv >= heureFerm) {
                JOptionPane.showMessageDialog(this,
                    "L'heure d'ouverture doit être antérieure à l'heure de fermeture.",
                    "Heures invalides",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (serviceControleur.serviceNumberExists(num)) {
                JOptionPane.showMessageDialog(this,
                    "Ce numéro de service existe déjà. Veuillez en choisir un autre.",
                    "Numéro existant",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            Service service = serviceControleur.createService(num, nom, desc, heureOuv, heureFerm);
            serviceControleur.addService(service, maisonInternationale);
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Veuillez entrer un numéro valide.",
                "Erreur de format",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTextField getNumField() {
        return numField;
    }

    public JTextField getNomField() {
        return nomField;
    }

    public JTextField getDescField() {
        return descField;
    }

    public JSpinner getHeureOuvSpinner() {
        return heureOuvSpinner;
    }

    public JSpinner getHeureFermSpinner() {
        return heureFermSpinner;
    }
}
/**
 * cette classe a יtי crיe par @author Maksen Mouhou
 */