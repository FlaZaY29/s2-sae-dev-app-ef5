package view;

import controller.MainController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class HeaderPanel extends JPanel {
    private JLabel logoLabel;
    private JTextField searchField;
    private MainController controller;

    public HeaderPanel(MainController controller) {
        this.controller = controller;
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        // Logo
        URL logoUrl = getClass().getResource("/resources/ciup_logo.png");
        if (logoUrl != null) {
            ImageIcon logoIcon = new ImageIcon(logoUrl);
            Image scaledImage = logoIcon.getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH);
            logoLabel = new JLabel(new ImageIcon(scaledImage));
        } else {
            // Fallback if logo not found
            logoLabel = new JLabel("CITÉ INTERNATIONALE UNIVERSITAIRE DE PARIS");
            logoLabel.setFont(new Font("Arial", Font.BOLD, 14));
            logoLabel.setForeground(new Color(0, 150, 136));
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
        
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.searchHouses(searchField.getText());
            }
        });
    }
    
    private void layoutComponents() {
        // Left panel for logo
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.add(logoLabel);
        
        // Right panel for search
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.add(searchField);
        
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }
}
