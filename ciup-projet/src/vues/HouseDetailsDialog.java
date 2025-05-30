package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleurs.MainControleur;
import modeles.Etudiant;
import modeles.Maison;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;
import modeles.Service;

/**
 * Boîte de dialogue affichant les détails d'une maison
 */
public class HouseDetailsDialog extends JDialog {
    private Maison maison;
    private MainControleur controleur;
    private JButton closeButton;
    private JButton manageServicesButton;

    /**
     * Constructeur de la boîte de dialogue de détails de maison
     * @param parent La fenêtre parente
     * @param maison La maison à afficher
     */
    public HouseDetailsDialog(JFrame parent, Maison maison) {
        super(parent, "Détails de la maison", true);
        this.maison = maison;

        setSize(800, 600); // Taille d'origine
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        initComponents();
    }

    /**
     * Constructeur avec contrôleur pour la gestion des services
     * @param parent La fenêtre parente
     * @param maison La maison à afficher
     * @param controleur Le contrôleur principal
     */
    public HouseDetailsDialog(JFrame parent, Maison maison, MainControleur controleur) {
        this(parent, maison);
        this.controleur = controleur;

        // Ajouter le bouton de gestion des services si c'est une maison internationale
        if (maison instanceof MaisonInternationale && controleur != null) {
            addManageServicesButton();
        }
    }

    /**
     * Initialise les composants de la boîte de dialogue
     */
    private void initComponents() {
        // Header panel with house name
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 150, 136));
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(maison.getNom());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // House information
        JPanel infoPanel = createInfoPanel();
        contentPanel.add(infoPanel);

        // If it's a MaisonClassique, show students
        if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            // Vérifier si la liste des étudiants est initialisée
            if (maisonClassique.getListeEtudiant() != null && !maisonClassique.getListeEtudiant().isEmpty()) {
                JPanel studentsPanel = createStudentsPanel(maisonClassique);
                contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                contentPanel.add(studentsPanel);
            }
        }

        // If it's a MaisonInternationale, show services
        if (maison instanceof MaisonInternationale) {
            MaisonInternationale maisonInternationale = (MaisonInternationale) maison;
            JPanel servicesPanel = createServicesPanel(maisonInternationale);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            contentPanel.add(servicesPanel);
        }

        // Close button
        closeButton = new JButton("Fermer");
        closeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(closeButton);

        // Add panels to dialog
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Ajoute le bouton de gestion des services
     */
    private void addManageServicesButton() {
        if (manageServicesButton == null) {
            manageServicesButton = new JButton("Gérer les Services");
            manageServicesButton.setBackground(new Color(0, 150, 136));
            manageServicesButton.setForeground(Color.WHITE);
            manageServicesButton.setFocusPainted(false);
            manageServicesButton.addActionListener(e -> {
                if (controleur != null && maison instanceof MaisonInternationale) {
                    controleur.getServiceControleur().showManageServicesDialog((MaisonInternationale) maison);
                }
            });

            // Find the button panel and add the manage services button
            Component[] components = getContentPane().getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    JPanel panel = (JPanel) component;
                    if (panel.getLayout() instanceof FlowLayout) {
                        FlowLayout layout = (FlowLayout) panel.getLayout();
                        if (layout.getAlignment() == FlowLayout.RIGHT) {
                            panel.remove(closeButton);
                            panel.add(manageServicesButton);
                            panel.add(closeButton);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Crée le panneau d'informations générales
     * @return Le panneau d'informations
     */
    private JPanel createInfoPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder("Informations générales"));

        // Add house information
        addLabelAndValue(panel, "Numéro:", String.valueOf(maison.getNum()));
        addLabelAndValue(panel, "Nom:", maison.getNom());
        addLabelAndValue(panel, "Description:", maison.getDesc());
        addLabelAndValue(panel, "Téléphone:", maison.getTel());
        addLabelAndValue(panel, "Localisation:", maison.getLocalisation());
        addLabelAndValue(panel, "Directeur:", maison.getDirecteur());
        addLabelAndValue(panel, "Année de création:", String.valueOf(maison.getAnneeCreation()));
        addLabelAndValue(panel, "Date de fête:", maison.getDateFete());
        addLabelAndValue(panel, "Durée de fête:", maison.getDureeFete() + " jour(s)");

        // Add specific information for MaisonClassique
        if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            addLabelAndValue(panel, "Nationalité:", maisonClassique.getNationalite());
            addLabelAndValue(panel, "Capacité:", String.valueOf(maisonClassique.getCapacite()));

            // Vérifier si la liste des étudiants est initialisée
            ArrayList<Etudiant> listeEtudiant = maisonClassique.getListeEtudiant();
            int nbEtudiants = (listeEtudiant != null) ? listeEtudiant.size() : 0;
            addLabelAndValue(panel, "Nombre d'étudiants:", String.valueOf(nbEtudiants));

            // Vérifier si la liste d'attente est initialisée
            ArrayList<Etudiant> listeAttente = maisonClassique.getListeAttente();
            int nbAttente = (listeAttente != null) ? listeAttente.size() : 0;
            addLabelAndValue(panel, "Liste d'attente:", String.valueOf(nbAttente));
        }

        // Add specific information for MaisonInternationale
        if (maison instanceof MaisonInternationale) {
            MaisonInternationale maisonInternationale = (MaisonInternationale) maison;
            ArrayList<Service> services = maisonInternationale.getSesServices();
            int nbServices = (services != null) ? services.size() : 0;
            addLabelAndValue(panel, "Nombre de services:", String.valueOf(nbServices));
        }

        mainPanel.add(panel, BorderLayout.CENTER);

        // Add image if available
        if (maison.hasProperty("imagePath")) {
            String imagePath = maison.getProperty("imagePath");
            try {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    JPanel imageDisplayPanel = new JPanel(new BorderLayout());
                    imageDisplayPanel.setBorder(BorderFactory.createTitledBorder("Image de la maison"));
                    imageDisplayPanel.setBackground(Color.WHITE);

                    ImageIcon originalIcon = new ImageIcon(imagePath);
                    Image originalImage = originalIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // Taille d'origine
                    JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                    imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    imageDisplayPanel.add(imageLabel, BorderLayout.CENTER);
                    mainPanel.add(imageDisplayPanel, BorderLayout.EAST);
                }
            } catch (Exception e) {
                // Silently fail and continue without showing the image
            }
        }

        return mainPanel;
    }

    /**
     * Crée le panneau d'étudiants
     * @param maisonClassique La maison classique
     * @return Le panneau d'étudiants
     */
    private JPanel createStudentsPanel(MaisonClassique maisonClassique) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder("Étudiants"));

        // Vérifier si la liste des étudiants est initialisée
        ArrayList<Etudiant> listeEtudiant = maisonClassique.getListeEtudiant();
        if (listeEtudiant == null) {
            // Si la liste est null, afficher un message
            JLabel emptyLabel = new JLabel("Aucun étudiant dans cette maison");
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(emptyLabel, BorderLayout.CENTER);
            return panel;
        }

        // Create table model
        String[] columnNames = {"ID", "Nom", "Prénom", "Nationalité", "Promotion", "Université"};
        Object[][] data = new Object[listeEtudiant.size()][6];

        int i = 0;
        for (Etudiant etudiant : listeEtudiant) {
            data[i][0] = etudiant.getNum();
            data[i][1] = etudiant.getNom();
            data[i][2] = etudiant.getPrenom();
            data[i][3] = etudiant.getNationalite();
            data[i][4] = etudiant.getPromotion();
            data[i][5] = etudiant.getUniversite();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Crée le panneau de services
     * @param maisonInternationale La maison internationale
     * @return Le panneau de services
     */
    private JPanel createServicesPanel(MaisonInternationale maisonInternationale) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Header with title and manage button
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Services");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        if (controleur != null) {
            JButton manageButton = new JButton("Gérer");
            manageButton.setBackground(new Color(0, 150, 136));
            manageButton.setForeground(Color.WHITE);
            manageButton.setFocusPainted(false);
            manageButton.setPreferredSize(new Dimension(80, 25));
            manageButton.addActionListener(e -> {
                controleur.getServiceControleur().showManageServicesDialog(maisonInternationale);
            });
            headerPanel.add(manageButton, BorderLayout.EAST);
        }

        panel.add(headerPanel, BorderLayout.NORTH);

        // Vérifier si la liste des services est initialisée
        ArrayList<Service> sesServices = maisonInternationale.getSesServices();
        if (sesServices == null || sesServices.isEmpty()) {
            // Si la liste est null ou vide, afficher un message
            JLabel emptyLabel = new JLabel("Aucun service dans cette maison");
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            emptyLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
            panel.add(emptyLabel, BorderLayout.CENTER);
            return panel;
        }

        // Create table model
        String[] columnNames = {"ID", "Nom", "Description", "Ouverture", "Fermeture"};
        Object[][] data = new Object[sesServices.size()][5];

        int i = 0;
        for (Service service : sesServices) {
            data[i][0] = service.getNum();
            data[i][1] = service.getNom();
            data[i][2] = service.getDesc();
            data[i][3] = service.getHeureOuv() + "h";
            data[i][4] = service.getHeureFerm() + "h";
            i++;
        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Ajoute un label et une valeur au panneau
     * @param panel Le panneau
     * @param labelText Le texte du label
     * @param value La valeur
     */
    private void addLabelAndValue(JPanel panel, String labelText, String value) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel valueLabel = new JLabel(value);

        panel.add(label);
        panel.add(valueLabel);
    }

    /**
     * Retourne le bouton de fermeture
     * @return Le bouton de fermeture
     */
    public JButton getCloseButton() {
        return closeButton;
    }
}
