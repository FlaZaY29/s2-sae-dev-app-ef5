package vues;

import controleurs.MainControleur;
import vues.MenuBar;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * Fenêtre principale de l'application
 * Contient tous les panneaux de l'interface
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
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
        setIconImage(loadIconImage().getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        
        initComponents();
        layoutComponents();
    }
    
    private ImageIcon loadIconImage() {
    try {
        // Essayer de charger le nouveau logo CIUP
        String[] logoPaths = {
            "/resources/icon.png",
            "resources/icon.png"
        };

        for (String path : logoPaths) {
            URL logoUrl = getClass().getResource(path);
            if (logoUrl != null) {
                ImageIcon icon = new ImageIcon(logoUrl);
                if (icon.getIconWidth() > 0) {
                    return icon;
                }
            }
        }

        // Essayer avec le ClassLoader
        URL logoUrl = getClass().getClassLoader().getResource("resources/icon.png");
        if (logoUrl != null) {
            ImageIcon icon = new ImageIcon(logoUrl);
            if (icon.getIconWidth() > 0) {
                return icon;
            }
        }

        // Essayer avec un chemin absolu
        String binPath = System.getProperty("user.dir") + File.separator + "bin" + File.separator + "resources" + File.separator + "icon.png";
        File logoFile = new File(binPath);
        if (logoFile.exists()) {
            ImageIcon icon = new ImageIcon(binPath);
            if (icon.getIconWidth() > 0) {
                return icon;
            }
        }

        // Essayer avec un chemin relatif
        String relativePath = "resources" + File.separator + "icon.png";
        File relativeFile = new File(relativePath);
        if (relativeFile.exists()) {
            ImageIcon icon = new ImageIcon(relativePath);
            if (icon.getIconWidth() > 0) {
                return icon;
            }
        }

        return null;

    } catch (Exception e) {
        return null;
    }
}

    /**
     * Initialise les composants de la fenêtre
     */
    private void initComponents() {
        setJMenuBar(new MenuBar(controleur));
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
/**
 * cette classe a été crée par @author Flavio Zamperlini
 */