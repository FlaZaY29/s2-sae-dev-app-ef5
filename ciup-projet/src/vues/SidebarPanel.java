package vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Panneau latéral de l'application
 * Contient les boutons de navigation
 */
public class SidebarPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
    private JPanel maisonsButton;
    private JPanel inscriptionButton;
    
    // Colors
    private final Color ACTIVE_COLOR = new Color(0, 200, 150);
    private final Color HOVER_COLOR = new Color(0, 220, 170);
    private final Color INACTIVE_COLOR = new Color(230, 230, 230);
    private final Color TEXT_COLOR = Color.BLACK;

    /**
     * Constructeur du panneau latéral
     */
    public SidebarPanel() {
        setPreferredSize(new Dimension(200, 0));
        setBackground(INACTIVE_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
        
        initComponents();
        layoutComponents();
    }
    
    /**
     * Initialise les composants du panneau
     */
    private void initComponents() {
        // Maisons button
        maisonsButton = createMenuButton("Maisons", true);
        
        // Inscription button
        inscriptionButton = createMenuButton("Inscription", false);
    }
    
    /**
     * Organise les composants dans le panneau
     */
    private void layoutComponents() {
        add(Box.createVerticalStrut(150)); // Space for logo
        add(maisonsButton);
        add(inscriptionButton);
        add(Box.createVerticalGlue()); // Push everything to the top
    }
    
    /**
     * Crée un bouton de menu
     * @param text Le texte du bouton
     * @param isActive Si le bouton est actif
     * @return Le bouton créé
     */
    private JPanel createMenuButton(String text, boolean isActive) {
        JPanel button = new JPanel();
        button.setLayout(new BorderLayout());
        button.setBackground(isActive ? ACTIVE_COLOR : INACTIVE_COLOR);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        button.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(TEXT_COLOR);
        
        button.add(label, BorderLayout.CENTER);
        
        return button;
    }
    
    /**
     * Définit le bouton actif
     * @param activeButton Le bouton à activer
     */
    public void setActiveButton(JPanel activeButton) {
        maisonsButton.setBackground(maisonsButton == activeButton ? ACTIVE_COLOR : INACTIVE_COLOR);
        inscriptionButton.setBackground(inscriptionButton == activeButton ? ACTIVE_COLOR : INACTIVE_COLOR);
    }
    
    /**
     * Retourne le bouton des maisons
     * @return Le bouton des maisons
     */
    public JPanel getMaisonsButton() {
        return maisonsButton;
    }
    
    /**
     * Retourne le bouton d'inscription
     * @return Le bouton d'inscription
     */
    public JPanel getInscriptionButton() {
        return inscriptionButton;
    }
}
/**
 * cette classe a été crée par @author Flavio Zamperlini
 */