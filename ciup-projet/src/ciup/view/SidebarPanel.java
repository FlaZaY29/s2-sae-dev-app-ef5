package view;

import controller.MainController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SidebarPanel extends JPanel {
    private JPanel maisonsButton;
    private JPanel inscriptionButton;
    private MainController controller;
    
    // Colors
    private final Color ACTIVE_COLOR = new Color(0, 200, 150);
    private final Color HOVER_COLOR = new Color(0, 220, 170);
    private final Color INACTIVE_COLOR = new Color(230, 230, 230);
    private final Color TEXT_COLOR = Color.BLACK;

    public SidebarPanel(MainController controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(200, 0));
        setBackground(INACTIVE_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
        
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        // Maisons button
        maisonsButton = createMenuButton("Maisons", true);
        maisonsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setActiveButton(maisonsButton);
                controller.showHousesList();
            }
        });
        
        // Inscription button
        inscriptionButton = createMenuButton("Inscription", false);
        inscriptionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setActiveButton(inscriptionButton);
                controller.showInscription();
            }
        });
    }
    
    private void layoutComponents() {
        add(Box.createVerticalStrut(150)); // Space for logo
        add(maisonsButton);
        add(inscriptionButton);
        add(Box.createVerticalGlue()); // Push everything to the top
    }
    
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
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button.getBackground() != ACTIVE_COLOR) {
                    button.setBackground(HOVER_COLOR);
                    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (button.getBackground() != ACTIVE_COLOR) {
                    button.setBackground(INACTIVE_COLOR);
                    button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
        
        return button;
    }
    
    public void setActiveButton(JPanel activeButton) {
        maisonsButton.setBackground(maisonsButton == activeButton ? ACTIVE_COLOR : INACTIVE_COLOR);
        inscriptionButton.setBackground(inscriptionButton == activeButton ? ACTIVE_COLOR : INACTIVE_COLOR);
    }
}
