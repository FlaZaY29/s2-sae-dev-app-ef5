package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleurs.ServiceControleur;
import modeles.MaisonInternationale;
import modeles.Service;

/**
 * Boîte de dialogue pour gérer les services d'une maison internationale
 */
public class ManageServicesDialog extends JDialog {
    private MaisonInternationale maisonInternationale;
    private ServiceControleur serviceControleur;

    private JTable servicesTable;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton closeButton;

    private String[] columnNames = {"ID", "Nom", "Description", "Ouverture", "Fermeture"};

    /**
     * Constructeur de la boîte de dialogue de gestion des services
     * @param parent La fenêtre parente
     * @param maisonInternationale La maison internationale
     * @param serviceControleur Le contrôleur de services
     */
    public ManageServicesDialog(JFrame parent, MaisonInternationale maisonInternationale,
                               ServiceControleur serviceControleur) {
        super(parent, "Gestion des services - " + maisonInternationale.getNom(), true);
        this.maisonInternationale = maisonInternationale;
        this.serviceControleur = serviceControleur;

        setSize(700, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        initComponents();
        layoutComponents();
        refreshServicesTable();
    }

    /**
     * Initialise les composants de la boîte de dialogue
     */
    private void initComponents() {
        // Table model
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };

        // Services table
        servicesTable = new JTable(tableModel);
        servicesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        servicesTable.getTableHeader().setReorderingAllowed(false);

        // Double-click to edit
        servicesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    editSelectedService();
                }
            }
        });

        // Selection listener for enabling/disabling buttons
        servicesTable.getSelectionModel().addListSelectionListener(e -> {
            boolean hasSelection = servicesTable.getSelectedRow() != -1;
            editButton.setEnabled(hasSelection);
            deleteButton.setEnabled(hasSelection);
        });

        // Buttons
        addButton = new JButton("Ajouter Service");
        addButton.setBackground(new Color(0, 150, 136));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addService());

        editButton = new JButton("Modifier");
        editButton.setEnabled(false);
        editButton.addActionListener(e -> editSelectedService());

        deleteButton = new JButton("Supprimer");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(e -> deleteSelectedService());

        closeButton = new JButton("Fermer");
        closeButton.addActionListener(e -> dispose());
    }

    /**
     * Organise les composants dans la boîte de dialogue
     */
    private void layoutComponents() {
        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 150, 136));
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Services de " + maisonInternationale.getNom());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Table panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(20, 20, 10, 20));

        JScrollPane scrollPane = new JScrollPane(servicesTable);
        scrollPane.setPreferredSize(new Dimension(650, 300));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setBorder(new EmptyBorder(0, 20, 10, 20));
        buttonsPanel.add(addButton);
        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        bottomPanel.add(closeButton);

        // Add panels to dialog
        add(headerPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(buttonsPanel, BorderLayout.WEST);
        southPanel.add(bottomPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Rafraîchit le tableau des services
     */
    public void refreshServicesTable() {
        // Clear existing data
        tableModel.setRowCount(0);

        // Add services data
        ArrayList<Service> services = maisonInternationale.getSesServices();
        if (services != null) {
            for (Service service : services) {
                Object[] rowData = {
                    service.getNum(),
                    service.getNom(),
                    service.getDesc(),
                    service.getHeureOuv() + "h",
                    service.getHeureFerm() + "h"
                };
                tableModel.addRow(rowData);
            }
        }

        // Update button states
        boolean hasSelection = servicesTable.getSelectedRow() != -1;
        editButton.setEnabled(hasSelection);
        deleteButton.setEnabled(hasSelection);
    }

    /**
     * Ajoute un nouveau service
     */
    private void addService() {
        serviceControleur.showAddServiceDialog(maisonInternationale);
        refreshServicesTable(); // Refresh after potential addition
    }

    /**
     * Modifie le service sélectionné
     */
    private void editSelectedService() {
        int selectedRow = servicesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Veuillez sélectionner un service à modifier.",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get service ID from table
        int serviceId = (Integer) tableModel.getValueAt(selectedRow, 0);

        // Find the service object
        Service selectedService = null;
        ArrayList<Service> services = maisonInternationale.getSesServices();
        if (services != null) {
            for (Service service : services) {
                if (service.getNum() == serviceId) {
                    selectedService = service;
                    break;
                }
            }
        }

        if (selectedService != null) {
            serviceControleur.showEditServiceDialog(selectedService, maisonInternationale);
            refreshServicesTable(); // Refresh after potential modification
        }
    }

    /**
     * Supprime le service sélectionné
     */
    private void deleteSelectedService() {
        int selectedRow = servicesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Veuillez sélectionner un service à supprimer.",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get service ID from table
        int serviceId = (Integer) tableModel.getValueAt(selectedRow, 0);

        // Find the service object
        Service selectedService = null;
        ArrayList<Service> services = maisonInternationale.getSesServices();
        if (services != null) {
            for (Service service : services) {
                if (service.getNum() == serviceId) {
                    selectedService = service;
                    break;
                }
            }
        }

        if (selectedService != null) {
            serviceControleur.deleteService(selectedService, maisonInternationale);
            refreshServicesTable(); // Refresh after deletion
        }
    }

    /**
     * Retourne la maison internationale
     * @return La maison internationale
     */
    public MaisonInternationale getMaisonInternationale() {
        return maisonInternationale;
    }

    /**
     * Retourne le tableau des services
     * @return Le tableau des services
     */
    public JTable getServicesTable() {
        return servicesTable;
    }
}
/**
 * cette classe a été crée par @Maksen
 */