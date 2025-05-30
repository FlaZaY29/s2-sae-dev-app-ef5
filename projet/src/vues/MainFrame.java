package vues;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controleurs.MainControleur;

/**
 * Fenêtre principale de l'application
 * Contient tous les panneaux de l'interface
 */
public class MainFrame extends JFrame {
    private HeaderPanel headerPanel;
    private SidebarPanel sidebarPanel;
    private JPanel contentPanel;
    private HousesListPanel housesListPanel;
    private InscriptionPanel inscriptionPanel;
    private MainControleur controleur;

    /**
     * Constructeur de la fenêtre principale
     * @param controleur Le contrôleur principal
     */
    public MainFrame(MainControleur controleur) {
        this.controleur = controleur;

        setTitle("CIUP - Cité Internationale Universitaire de Paris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        initComponents();
        layoutComponents();
    }

    /**
     * Initialise les composants de la fenêtre
     */
    private void initComponents() {
        headerPanel = new HeaderPanel();
        sidebarPanel = new SidebarPanel();
        contentPanel = new JPanel(new CardLayout());

        housesListPanel = new HousesListPanel(controleur);
        inscriptionPanel = new InscriptionPanel(controleur);

        contentPanel.add(housesListPanel, "HOUSES");
        contentPanel.add(inscriptionPanel, "INSCRIPTION");
    }

    /**
     * Organise les composants dans la fenêtre
     */
    private void layoutComponents() {
        setLayout(new BorderLayout());

        add(headerPanel, BorderLayout.NORTH);
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    /**
     * Affiche un panneau spécifique
     * @param panelName Le nom du panneau à afficher
     */
    public void showPanel(String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
    }

    // Getters pour accéder aux différents panneaux
    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public SidebarPanel getSidebarPanel() {
        return sidebarPanel;
    }

    public HousesListPanel getHousesListPanel() {
        return housesListPanel;
    }

    public InscriptionPanel getInscriptionPanel() {
        return inscriptionPanel;
    }
}
