package view;

import controller.MainController;
import modele.CIUP;
import modele.Maison;
import modele.MaisonClassique;
import modele.MaisonInternationale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HousesListPanel extends JPanel {
    private JLabel titleLabel;
    private JButton addButton;
    private JPanel housesContainer;
    private JScrollPane scrollPane;
    private CIUP ciupModel;
    private MainController controller;

    public HousesListPanel(CIUP ciupModel, MainController controller) {
        this.ciupModel = ciupModel;
        this.controller = controller;
        
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        
        initComponents();
        layoutComponents();
        refreshHousesList();
    }
    
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
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showAddHouseDialog();
            }
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
    
    private void layoutComponents() {
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Add button in top-right corner
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.setBackground(Color.WHITE);
        topRightPanel.add(addButton);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
    }
    
    public void refreshHousesList() {
        housesContainer.removeAll();
        
        ArrayList<Maison> maisons = ciupModel.getListeMaison();
        for (Maison maison : maisons) {
            HouseCardPanel houseCard = new HouseCardPanel(maison, controller);
            housesContainer.add(houseCard);
        }
        
        // Revalidate and repaint
        housesContainer.revalidate();
        housesContainer.repaint();
    }
    
    public void filterHouses(String searchText) {
        housesContainer.removeAll();
        
        ArrayList<Maison> maisons = ciupModel.getListeMaison();
        for (Maison maison : maisons) {
            if (searchText.isEmpty() || 
                maison.getNom().toLowerCase().contains(searchText.toLowerCase())) {
                HouseCardPanel houseCard = new HouseCardPanel(maison, controller);
                housesContainer.add(houseCard);
            }
        }
        
        // Revalidate and repaint
        housesContainer.revalidate();
        housesContainer.repaint();
    }
}
