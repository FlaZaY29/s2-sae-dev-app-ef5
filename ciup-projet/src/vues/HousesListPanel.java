package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controleurs.MainControleur;
import modeles.Maison;

/**
 * Panneau affichant la liste des maisons
 */
public class HousesListPanel extends JPanel {
    private JLabel titleLabel;
    private JButton addButton;
    private JPanel housesContainer;
    private JScrollPane scrollPane;
    private MainControleur controleur;

    /**
     * Constructeur du panneau de liste des maisons
     * @param controleur Le contrôleur principal
     */
    public HousesListPanel(MainControleur controleur) {
        this.controleur = controleur;

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        initComponents();
        layoutComponents();
    }

    /**
     * Initialise les composants du panneau
     */
    private void initComponents() {
        // Title and add button panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        titleLabel = new JLabel("Listes des maisons");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setFocusPainted(false);
        addButton.setBackground(Color.WHITE);
        addButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        addButton.setPreferredSize(new Dimension(40, 40));

        // Dans la méthode initComponents(), après la création du bouton addButton
        addButton.addActionListener(e -> {
            controleur.getMaisonControleur().showAddHouseDialog();
        });

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(addButton, BorderLayout.EAST);

        // Houses container with grid layout
        housesContainer = new JPanel();
        housesContainer.setBackground(Color.WHITE);
        housesContainer.setLayout(new GridLayout(0, 2, 20, 20)); // 2 columns, variable rows

        // Scroll pane for houses
        scrollPane = new JScrollPane(housesContainer);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    }

    /**
     * Organise les composants dans le panneau
     */
    private void layoutComponents() {
        // Panel de titre
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.setBackground(Color.WHITE);
        topRightPanel.add(addButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);

        // Ajouter les composants au panel principal
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Rafraîchit la liste des maisons
     */
    public void refreshHousesList() {
        if (controleur == null || controleur.getCiupModel() == null) {
            System.out.println("Erreur: controleur ou modèle null dans refreshHousesList()");
            return;
        }

        housesContainer.removeAll();

        ArrayList<Maison> maisons = controleur.getCiupModel().getListeMaison();
        System.out.println("Nombre de maisons à afficher: " + maisons.size());

        for (Maison maison : maisons) {
            System.out.println("Ajout de la maison: " + maison.getNom());
            HouseCardPanel houseCard = new HouseCardPanel(maison, controleur);
            housesContainer.add(houseCard);
        }

        // Revalidate and repaint
        housesContainer.revalidate();
        housesContainer.repaint();

        // Forcer la mise à jour de la fenêtre
        SwingUtilities.invokeLater(() -> {
            scrollPane.revalidate();
            scrollPane.repaint();
            revalidate();
            repaint();
        });
    }

    /**
     * Filtre les maisons par nom
     * @param searchText Le texte de recherche
     */
    public void filterHouses(String searchText) {
        if (controleur == null || controleur.getCiupModel() == null) {
            return;
        }

        housesContainer.removeAll();

        ArrayList<Maison> maisons = controleur.getCiupModel().getListeMaison();
        for (Maison maison : maisons) {
            if (searchText.isEmpty() ||
                maison.getNom().toLowerCase().contains(searchText.toLowerCase())) {
                HouseCardPanel houseCard = new HouseCardPanel(maison, controleur);
                housesContainer.add(houseCard);
            }
        }

        // Revalidate and repaint
        housesContainer.revalidate();
        housesContainer.repaint();
    }

    /**
     * Retourne le bouton d'ajout
     * @return Le bouton d'ajout
     */
    public JButton getAddButton() {
        return addButton;
    }
}
/**
 * cette classe a été crée par @Donald
 */