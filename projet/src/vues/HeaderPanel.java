package vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;
import java.io.File;

/**
 * Panneau d'en-tête de l'application
 * Contient le logo et le champ de recherche
 */
public class HeaderPanel extends JPanel {
    private JLabel logoLabel;
    private JTextField searchField;

    /**
     * Constructeur du panneau d'en-tête
     */
    public HeaderPanel() {
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        
        initComponents();
        layoutComponents();
    }
    
    /**
     * Initialise les composants du panneau
     */
    private void initComponents() {
        // Logo - essayer de charger le nouveau logo CIUP
        ImageIcon logoIcon = loadLogoImage();
        if (logoIcon != null) {
            Image scaledImage = logoIcon.getImage().getScaledInstance(152, 66, Image.SCALE_SMOOTH);
            logoLabel = new JLabel(new ImageIcon(scaledImage));
        } else {
            // Fallback si le logo n'est pas trouvé
            logoLabel = new JLabel("CIUP");
            logoLabel.setFont(new Font("Arial", Font.BOLD, 20));
            logoLabel.setForeground(new Color(0, 150, 136));
            logoLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 150, 136), 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
            ));
        }
        
        // Search field
        searchField = new JTextField(20);
        searchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        // Placeholder text
        searchField.setText("Rechercher ...");
        searchField.setForeground(Color.GRAY);
        
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("Rechercher ...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Rechercher ...");
                    searchField.setForeground(Color.GRAY);
                }
            }
        });
    }
    
    /**
     * Charge l'image du logo
     * @return L'icône du logo ou null si non trouvée
     */
    private ImageIcon loadLogoImage() {
        try {
            // Essayer de charger le nouveau logo CIUP
            String[] logoPaths = {
                "/resources/logo.png",
                "resources/logo.png"
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
            URL logoUrl = getClass().getClassLoader().getResource("resources/logo.png");
            if (logoUrl != null) {
                ImageIcon icon = new ImageIcon(logoUrl);
                if (icon.getIconWidth() > 0) {
                    return icon;
                }
            }
            
            // Essayer avec un chemin absolu
            String binPath = System.getProperty("user.dir") + File.separator + "bin" + File.separator + "resources" + File.separator + "logo.png";
            File logoFile = new File(binPath);
            if (logoFile.exists()) {
                ImageIcon icon = new ImageIcon(binPath);
                if (icon.getIconWidth() > 0) {
                    return icon;
                }
            }
            
            // Essayer avec un chemin relatif
            String relativePath = "resources" + File.separator + "logo.png";
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
     * Organise les composants dans le panneau
     */
    private void layoutComponents() {
        // Left panel for logo
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.add(logoLabel);
        
        // Center panel for title
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("CITÉ INTERNATIONALE UNIVERSITAIRE DE PARIS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 150, 136));
        centerPanel.add(titleLabel);
        
        // Right panel for search
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.add(searchField);
        
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }
    
    /**
     * Retourne le champ de recherche
     * @return Le champ de recherche
     */
    public JTextField getSearchField() {
        return searchField;
    }
}
/**
 * cette classe a été crée par @author Flavio Zamperlini
 */