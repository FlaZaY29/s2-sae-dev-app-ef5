package vues;

import controleurs.MainControleur;
import modeles.Maison;
import modeles.MaisonClassique;
import modeles.MaisonInternationale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;

/**
 * Panneau représentant une carte de maison
 */
public class HouseCardPanel extends JPanel {
    private Maison maison;
    private JPanel imagePanel;
    private JLabel nameLabel;
    private JButton menuButton;
    private MainControleur controleur;
    
    // House image paths - chemins relatifs depuis la racine des ressources
    private static final String MAISON_INTERNATIONALE_PATH = "resources/maison_internationale.jpg";
    private static final String MAISON_JAPONAISE_PATH = "resources/maison_japon.jpg";
    private static final String MAISON_FRANCAISE_PATH = "resources/maison_france.jpg";

    /**
     * Constructeur du panneau de carte de maison
     * @param maison La maison à afficher
     * @param controleur Le contrôleur principal
     */
    public HouseCardPanel(Maison maison, MainControleur controleur) {
        this.maison = maison;
        this.controleur = controleur;
        
        setBackground(new Color(240, 240, 240));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300)); // Taille d'origine
        
        initComponents();
        layoutComponents();

        // Ajouter un écouteur pour ouvrir les détails de la maison lors d'un clic
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controleur.getMaisonControleur().showHouseDetails(maison);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(new Color(0, 150, 136), 2, true));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
                setCursor(Cursor.getDefaultCursor());
            }
        });

        // Ajouter un écouteur pour le bouton de menu
        menuButton.addActionListener(e -> {
            showPopupMenu(menuButton);
        });
    }
    
    /**
     * Initialise les composants du panneau
     */
    private void initComponents() {
        // Créer le panel d'image avec la taille d'origine
        imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(380, 200)); // Taille d'origine
        imagePanel.setMinimumSize(new Dimension(380, 200));
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        // Créer un panel coloré selon le type de maison (sera visible si l'image ne se charge pas)
        Color backgroundColor = getColorForHouse(maison);
        imagePanel.setBackground(backgroundColor);
        
        // Ajouter un label avec le nom de la maison au centre du panel (sera visible si l'image ne se charge pas)
        JLabel houseTypeLabel = new JLabel(getLabelTextForHouse(maison));
        houseTypeLabel.setHorizontalAlignment(JLabel.CENTER);
        houseTypeLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Taille d'origine
        imagePanel.add(houseTypeLabel, BorderLayout.CENTER);
        
        // Vérifier si la maison a une image personnalisée
        boolean imageLoaded = false;
        if (maison.hasProperty("imagePath")) {
            String imagePath = maison.getProperty("imagePath");
            try {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    ImageIcon icon = new ImageIcon(imagePath);
                    Image scaledImage = icon.getImage().getScaledInstance(380, 200, Image.SCALE_SMOOTH); // Taille d'origine
                    JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                    imagePanel.removeAll();
                    imagePanel.add(imageLabel, BorderLayout.CENTER);
                    imageLoaded = true;
                }
            } catch (Exception e) {
                // Silently fail and use default image
            }
        }
        
        // Si aucune image personnalisée n'a été chargée, essayer de charger l'image par défaut
        if (!imageLoaded) {
            try {
                String imagePath = getImagePathForHouse(maison);
                URL imageUrl = getClass().getResource("/" + imagePath);
                if (imageUrl != null) {
                    ImageIcon originalIcon = new ImageIcon(imageUrl);
                    Image originalImage = originalIcon.getImage();
                    
                    if (originalImage.getWidth(null) > 0) {
                        Image scaledImage = originalImage.getScaledInstance(380, 200, Image.SCALE_SMOOTH); // Taille d'origine
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        
                        JLabel imageLabel = new JLabel(scaledIcon);
                        imageLabel.setHorizontalAlignment(JLabel.CENTER);
                        
                        imagePanel.removeAll();
                        imagePanel.add(imageLabel, BorderLayout.CENTER);
                    }
                }
            } catch (Exception e) {
                // Silently fail and use colored background with text
            }
        }
        
        // House name
        nameLabel = new JLabel(maison.getNom());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Taille d'origine
        nameLabel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding d'origine
        
        // Menu button
        menuButton = new JButton("⋮");
        menuButton.setFont(new Font("Arial", Font.BOLD, 20)); // Taille d'origine
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setPreferredSize(new Dimension(30, 30)); // Taille d'origine
    }
    
    /**
     * Retourne la couleur de fond pour une maison
     * @param maison La maison
     * @return La couleur de fond
     */
    private Color getColorForHouse(Maison maison) {
        if (maison instanceof MaisonInternationale) {
            return new Color(70, 130, 180); // Steel Blue
        } else if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            String nationalite = maisonClassique.getNationalite();
            
            if ("Japonaise".equalsIgnoreCase(nationalite)) {
                return new Color(220, 20, 60); // Crimson
            } else if ("Francaise".equalsIgnoreCase(nationalite)) {
                return new Color(0, 100, 0); // Dark Green
            }
        }
        return Color.GRAY;
    }
    
    /**
     * Retourne le texte du label pour une maison
     * @param maison La maison
     * @return Le texte du label
     */
    private String getLabelTextForHouse(Maison maison) {
        if (maison instanceof MaisonInternationale) {
            return "Maison Internationale";
        } else if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            String nationalite = maisonClassique.getNationalite();
            
            if ("Japonaise".equalsIgnoreCase(nationalite)) {
                return "Maison Japonaise";
            } else if ("Francaise".equalsIgnoreCase(nationalite)) {
                return "Maison Française";
            }
        }
        return maison.getNom();
    }
    
    /**
     * Organise les composants dans le panneau
     */
    private void layoutComponents() {
        add(imagePanel, BorderLayout.CENTER);
        
        // Panel for name and menu button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(240, 240, 240));
        bottomPanel.add(nameLabel, BorderLayout.WEST);
        bottomPanel.add(menuButton, BorderLayout.EAST);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Forcer la revalidation et le repaint
        revalidate();
        repaint();
    }
    
    /**
     * Retourne le chemin de l'image pour une maison
     * @param maison La maison
     * @return Le chemin de l'image
     */
    private String getImagePathForHouse(Maison maison) {
        if (maison instanceof MaisonInternationale) {
            return MAISON_INTERNATIONALE_PATH;
        } else if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            String nationalite = maisonClassique.getNationalite();
            
            if ("Japonaise".equalsIgnoreCase(nationalite)) {
                return MAISON_JAPONAISE_PATH;
            } else if ("Francaise".equalsIgnoreCase(nationalite)) {
                return MAISON_FRANCAISE_PATH;
            }
        }
        return MAISON_INTERNATIONALE_PATH; // Default fallback
    }
    
    /**
     * Retourne la maison
     * @return La maison
     */
    public Maison getMaison() {
        return maison;
    }
    
    /**
     * Retourne le bouton de menu
     * @return Le bouton de menu
     */
    public JButton getMenuButton() {
        return menuButton;
    }

    /**
     * Affiche le menu contextuel pour les actions sur la maison
     * @param component Le composant sur lequel afficher le menu
     */
    private void showPopupMenu(Component component) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem viewItem = new JMenuItem("Voir détails");
        JMenuItem editItem = new JMenuItem("Modifier");
        JMenuItem deleteItem = new JMenuItem("Supprimer");

        viewItem.addActionListener(e -> controleur.getMaisonControleur().showHouseDetails(maison));
        editItem.addActionListener(e -> controleur.getMaisonControleur().showEditHouseDialog(maison));
        deleteItem.addActionListener(e -> controleur.getMaisonControleur().deleteHouse(maison));

        popupMenu.add(viewItem);
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        popupMenu.show(component, 0, component.getHeight());
    }

    // Ajouter cette nouvelle méthode pour obtenir juste le nom du fichier image
    private String getImageNameForHouse(Maison maison) {
        if (maison instanceof MaisonInternationale) {
            return "maison_internationale.jpg";
        } else if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            String nationalite = maisonClassique.getNationalite();
            
            if ("Japonaise".equalsIgnoreCase(nationalite)) {
                return "maison_japon.jpg";
            } else if ("Francaise".equalsIgnoreCase(nationalite)) {
                return "maison_france.jpg";
            }
        }
        return "maison_internationale.jpg"; // Default fallback
    }
}
/**
 * cette classe a été crée par @author Donald Se Maksen Mouhou
 */