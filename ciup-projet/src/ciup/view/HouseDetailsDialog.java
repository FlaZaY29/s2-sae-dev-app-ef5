package view;

import modele.Etudiant;
import modele.Maison;
import modele.MaisonClassique;
import modele.MaisonInternationale;
import modele.Service;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HouseDetailsDialog extends JDialog {
    private Maison maison;
    
    public HouseDetailsDialog(JFrame parent, Maison maison) {
        super(parent, "Détails de la maison", true);
        this.maison = maison;
        
        setSize(800, 600);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        
        initComponents();
    }
    
    private void initComponents() {
        // Header panel with house name
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 150, 136));
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel(maison.getNom());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        // Content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // House information
        JPanel infoPanel = createInfoPanel();
        contentPanel.add(infoPanel);
        
        // If it's a MaisonClassique, show students
        if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            // Vérifier si la liste des étudiants est initialisée
            if (maisonClassique.getListeEtudiant() != null && !maisonClassique.getListeEtudiant().isEmpty()) {
                JPanel studentsPanel = createStudentsPanel(maisonClassique);
                contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                contentPanel.add(studentsPanel);
            }
        }
        
        // If it's a MaisonInternationale, show services
        if (maison instanceof MaisonInternationale) {
            MaisonInternationale maisonInternationale = (MaisonInternationale) maison;
            // Vérifier si la liste des services est initialisée et non vide
            if (maisonInternationale.getSesServices() != null && !maisonInternationale.getSesServices().isEmpty()) {
                JPanel servicesPanel = createServicesPanel(maisonInternationale);
                contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                contentPanel.add(servicesPanel);
            }
        }
        
        // Close button
        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(closeButton);
        
        // Add panels to dialog
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder("Informations générales"));
        
        // Add house information
        addLabelAndValue(panel, "Numéro:", String.valueOf(maison.getNum()));
        addLabelAndValue(panel, "Nom:", maison.getNom());
        addLabelAndValue(panel, "Description:", maison.getDesc());
        addLabelAndValue(panel, "Téléphone:", maison.getTel());
        addLabelAndValue(panel, "Localisation:", maison.getLocalisation());
        addLabelAndValue(panel, "Directeur:", maison.getDirecteur());
        addLabelAndValue(panel, "Année de création:", String.valueOf(maison.getAnneeCreation()));
        addLabelAndValue(panel, "Date de fête:", maison.getDateFete());
        addLabelAndValue(panel, "Durée de fête:", maison.getDureeFete() + " jour(s)");
        
        // Add specific information for MaisonClassique
        if (maison instanceof MaisonClassique) {
            MaisonClassique maisonClassique = (MaisonClassique) maison;
            addLabelAndValue(panel, "Nationalité:", maisonClassique.getNationalite());
            addLabelAndValue(panel, "Capacité:", String.valueOf(maisonClassique.getCapacite()));
            
            // Vérifier si la liste des étudiants est initialisée
            ArrayList<Etudiant> listeEtudiant = maisonClassique.getListeEtudiant();
            int nbEtudiants = (listeEtudiant != null) ? listeEtudiant.size() : 0;
            addLabelAndValue(panel, "Nombre d'étudiants:", String.valueOf(nbEtudiants));
            
            // Vérifier si la liste d'attente est initialisée
            ArrayList<Etudiant> listeAttente = maisonClassique.getListeAttente();
            int nbAttente = (listeAttente != null) ? listeAttente.size() : 0;
            addLabelAndValue(panel, "Liste d'attente:", String.valueOf(nbAttente));
        }
        
        return panel;
    }
    
    private JPanel createStudentsPanel(MaisonClassique maisonClassique) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder("Étudiants"));
        
        // Vérifier si la liste des étudiants est initialisée
        ArrayList<Etudiant> listeEtudiant = maisonClassique.getListeEtudiant();
        if (listeEtudiant == null) {
            // Si la liste est null, afficher un message
            JLabel emptyLabel = new JLabel("Aucun étudiant dans cette maison");
            emptyLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(emptyLabel, BorderLayout.CENTER);
            return panel;
        }
        
        // Create table model
        String[] columnNames = {"ID", "Nom", "Prénom", "Nationalité", "Promotion", "Université"};
        Object[][] data = new Object[listeEtudiant.size()][6];
        
        int i = 0;
        for (Etudiant etudiant : listeEtudiant) {
            data[i][0] = etudiant.getNum();
            data[i][1] = etudiant.getNom();
            data[i][2] = etudiant.getPrenom();
            data[i][3] = etudiant.getNationalite();
            data[i][4] = etudiant.getPromotion();
            data[i][5] = etudiant.getUniversite();
            i++;
        }
        
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createServicesPanel(MaisonInternationale maisonInternationale) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder("Services"));
        
        // Vérifier si la liste des services est initialisée
        ArrayList<Service> sesServices = maisonInternationale.getSesServices();
        if (sesServices == null || sesServices.isEmpty()) {
            // Si la liste est null ou vide, afficher un message
            JLabel emptyLabel = new JLabel("Aucun service dans cette maison");
            emptyLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(emptyLabel, BorderLayout.CENTER);
            return panel;
        }
        
        // Create table model
        String[] columnNames = {"ID", "Nom", "Description", "Heures d'ouverture", "Heures de fermeture"};
        Object[][] data = new Object[sesServices.size()][5];
        
        int i = 0;
        for (Service service : sesServices) {
            data[i][0] = service.getNum();
            data[i][1] = service.getNom();
            data[i][2] = service.getDesc();
            data[i][3] = service.getHeureOuv() + "h";
            data[i][4] = service.getHeureFerm() + "h";
            i++;
        }
        
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void addLabelAndValue(JPanel panel, String labelText, String value) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        
        JLabel valueLabel = new JLabel(value);
        
        panel.add(label);
        panel.add(valueLabel);
    }
}
