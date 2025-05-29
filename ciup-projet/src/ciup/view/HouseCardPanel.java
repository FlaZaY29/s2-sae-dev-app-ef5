package view;

import controller.MainController;
import modele.Maison;
import modele.MaisonClassique;
import modele.MaisonInternationale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class HouseCardPanel extends JPanel {
    private Maison maison;
    private JLabel imageLabel;
    private JLabel nameLabel;
    private JButton menuButton;
    private MainController controller;
    
    // House image paths - in a real app, these would be dynamically loaded
    private static final String DEFAULT_IMAGE_PATH = "/resources/default_house.jpg";
    private static final String MAISON_INTERNATIONALE_PATH = "/resources/maison_internationale.jpg";
    private static final String MAISON_JAPONAISE_PATH = "/resources/maison_japon.jpg";
    private static final String MAISON_FRANCAISE_PATH = "/resources/maison_france.jpg";

    public HouseCardPanel(Maison maison, MainController controller) {
        this.maison = maison;
        this.controller = controller;
        
        setBackground(new Color(240, 240, 240));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        setLayout(new BorderLayout());
        
        initComponents();
        layoutComponents();
        
        // Add click listener to open house details
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.showHouseDetails(maison);
            }
        });
    }
    
    private void initComponents() {
        // House image
        String imagePath = getImagePathForHouse(maison);
        ImageIcon imageIcon = loadImageIcon(imagePath);
        
        if (imageIcon != null) {
            Image scaledImage = imageIcon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(scaledImage));
        } else {
            // Fallback if image not found
            imageLabel = new JLabel();
            imageLabel.setPreferredSize(new Dimension(400, 250));
            imageLabel.setBackground(Color.LIGHT_GRAY);
            imageLabel.setOpaque(true);
        }
        
        // House name
        nameLabel = new JLabel(maison.getNom());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Menu button
        menuButton = new JButton("⋮");
        menuButton.setFont(new Font("Arial", Font.BOLD, 20));
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(false);
        
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPopupMenu(menuButton);
            }
        });
    }
    
    private void layoutComponents() {
        add(imageLabel, BorderLayout.CENTER);
        
        // Panel for name and menu button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(240, 240, 240));
        bottomPanel.add(nameLabel, BorderLayout.WEST);
        bottomPanel.add(menuButton, BorderLayout.EAST);
        
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private String getImagePathForHouse(Maison maison) {
        // In a real app, this would be more sophisticated
        if (maison instanceof MaisonInternationale) {
            return MAISON_INTERNATIONALE_PATH;
        } else if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            if ("Japonaise".equals(maisonClassique.getNationalite())) {
                return MAISON_JAPONAISE_PATH;
            } else if ("Francaise".equals(maisonClassique.getNationalite())) {
                return MAISON_FRANCAISE_PATH;
            }
        }
        return DEFAULT_IMAGE_PATH;
    }
    
    private ImageIcon loadImageIcon(String path) {
        try {
            return new ImageIcon(getClass().getResource(path));
        } catch (Exception e) {
            System.err.println("Failed to load image: " + path);
            return null;
        }
    }
    
    private void showPopupMenu(Component component) {
        JPopupMenu popupMenu = new JPopupMenu();
        
        JMenuItem viewItem = new JMenuItem("Voir détails");
        JMenuItem editItem = new JMenuItem("Modifier");
        JMenuItem deleteItem = new JMenuItem("Supprimer");
        
        viewItem.addActionListener(e -> controller.showHouseDetails(maison));
        editItem.addActionListener(e -> controller.showEditHouseDialog(maison));
        deleteItem.addActionListener(e -> controller.deleteHouse(maison));
        
        popupMenu.add(viewItem);
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        
        popupMenu.show(component, 0, component.getHeight());
    }
}
