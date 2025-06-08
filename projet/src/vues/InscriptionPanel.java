package vues;

import controleurs.MainControleur;
import modeles.Etudiant;
import modeles.Maison;
import modeles.MaisonClassique;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panneau d'inscription des �tudiants
 */
public class InscriptionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
    private JLabel titleLabel;
    private JComboBox<String> maisonComboBox;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField adresseField;
    private JTextField nationaliteField;
    private JTextField dateNaissanceField;
    private JTextField telField;
    private JTextField emailField;
    private JTextField promotionField;
    private JTextField universiteField;
    private JButton submitButton;
    private JButton clearButton;
    
    private MainControleur controleur;
    private JTable statsTable;
    private Object[][] statsData = new Object[0][4];
    private String[] columnNames = {"Maison", "Capacit�", "Occup�e", "Attente"};

    /**
     * Constructeur du panneau d'inscription
     * @param controleur Le contr�leur principal
     */
    public InscriptionPanel(MainControleur controleur) {
        this.controleur = controleur;
        
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        
        initComponents();
        layoutComponents();
    }
    
    /**
     * Initialise les composants du panneau
     */
    private void initComponents() {
        titleLabel = new JLabel("Inscription");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Maison selection
        JLabel maisonLabel = new JLabel("Maison:");
        maisonComboBox = new JComboBox<>();
        
        // Student information fields
        nomField = new JTextField(20);
        prenomField = new JTextField(20);
        adresseField = new JTextField(20);
        nationaliteField = new JTextField(20);
        dateNaissanceField = new JTextField(20);
        telField = new JTextField(20);
        emailField = new JTextField(20);
        promotionField = new JTextField(20);
        universiteField = new JTextField(20);
        
        // Buttons
        submitButton = new JButton("S'inscrire");
        submitButton.setBackground(new Color(0, 150, 136));
        submitButton.setFocusPainted(false);
        
        clearButton = new JButton("Effacer");
        clearButton.setBackground(Color.LIGHT_GRAY);
        clearButton.setFocusPainted(false);

        // Dans la m�thode initComponents(), apr�s la cr�ation des boutons
        // Ajouter les �couteurs d'�v�nements
        submitButton.addActionListener(e -> {
            if (controleur.getEtudiantControleur().validateStudentFields(
                    nomField.getText(),
                    prenomField.getText(),
                    nationaliteField.getText(),
                    dateNaissanceField.getText(),
                    telField.getText(),
                    emailField.getText(),
                    promotionField.getText(),
                    universiteField.getText())) {

                boolean success = controleur.getEtudiantControleur().registerStudent(
                        getSelectedMaisonName(),
                        nomField.getText(),
                        prenomField.getText(),
                        adresseField.getText(),
                        nationaliteField.getText(),
                        dateNaissanceField.getText(),
                        telField.getText(),
                        emailField.getText(),
                        promotionField.getText(),
                        universiteField.getText());

                if (success) {
                    // Demander si l'utilisateur souhaite ajouter un autre �tudiant
                    int result = JOptionPane.showConfirmDialog(this,
                            "Voulez-vous ajouter un autre �tudiant?",
                            "Continuer",
                            JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {
                        clearForm();
                    } else {
                        clearForm();
                        controleur.showHousesList();
                    }
                }
            }
        });

        clearButton.addActionListener(e -> clearForm());
    }
    
    /**
     * Organise les composants dans le panneau
     */
    private void layoutComponents() {
        // Panel principal avec BorderLayout
        setLayout(new BorderLayout());
        
        // Panel de titre
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        titlePanel.add(titleLabel);
        
        // Panel central avec le formulaire et les informations
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Panel de formulaire (gauche)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        
        // S�lection de maison
        JPanel maisonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maisonPanel.setBackground(Color.WHITE);
        maisonPanel.add(new JLabel("Maison:"));
        maisonPanel.add(maisonComboBox);
        
        // Personal information
        JPanel personalInfoPanel = new JPanel(new GridBagLayout());
        personalInfoPanel.setBackground(Color.WHITE);
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations personnelles",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        GridBagConstraints gbcPersonal = new GridBagConstraints();
        gbcPersonal.fill = GridBagConstraints.HORIZONTAL;
        gbcPersonal.insets = new Insets(5, 5, 5, 5);
        
        // Row 1
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 0;
        personalInfoPanel.add(new JLabel("Nom:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(nomField, gbcPersonal);
        
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 1;
        personalInfoPanel.add(new JLabel("Pr�nom:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(prenomField, gbcPersonal);
        
        // Row 2
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 2;
        personalInfoPanel.add(new JLabel("Nationalit�:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(nationaliteField, gbcPersonal);
        
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 3;
        personalInfoPanel.add(new JLabel("Date de naissance:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(dateNaissanceField, gbcPersonal);
        
        // Row 3
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 4;
        personalInfoPanel.add(new JLabel("Adresse:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(adresseField, gbcPersonal);
        
        // Row 4
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 5;
        personalInfoPanel.add(new JLabel("T�l�phone:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(telField, gbcPersonal);
        
        gbcPersonal.gridx = 0;
        gbcPersonal.gridy = 6;
        personalInfoPanel.add(new JLabel("Email:"), gbcPersonal);
        
        gbcPersonal.gridx = 1;
        personalInfoPanel.add(emailField, gbcPersonal);
        
        // Academic information
        JPanel academicInfoPanel = new JPanel(new GridBagLayout());
        academicInfoPanel.setBackground(Color.WHITE);
        academicInfoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations acad�miques",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        GridBagConstraints gbcAcademic = new GridBagConstraints();
        gbcAcademic.fill = GridBagConstraints.HORIZONTAL;
        gbcAcademic.insets = new Insets(5, 5, 5, 5);
        
        // Row 1
        gbcAcademic.gridx = 0;
        gbcAcademic.gridy = 0;
        academicInfoPanel.add(new JLabel("Promotion:"), gbcAcademic);
        
        gbcAcademic.gridx = 1;
        academicInfoPanel.add(promotionField, gbcAcademic);
        
        gbcAcademic.gridx = 0;
        gbcAcademic.gridy = 1;
        academicInfoPanel.add(new JLabel("Universit�:"), gbcAcademic);
        
        gbcAcademic.gridx = 1;
        academicInfoPanel.add(universiteField, gbcAcademic);
        
        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(submitButton);
        
        // Add all panels to form panel
        formPanel.add(maisonPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(personalInfoPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(academicInfoPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(buttonsPanel);
        
        // Panel d'information (droite)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Informations sur l'inscription",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        // Ajouter des informations sur le processus d'inscription
        JTextArea infoText = new JTextArea(
            "Processus d'inscription � la CIUP\n\n" +
            "1. Remplissez le formulaire avec vos informations personnelles et acad�miques.\n\n" +
            "2. S�lectionnez la maison dans laquelle vous souhaitez r�sider.\n\n" +
            "3. Soumettez votre demande en cliquant sur le bouton \"S'inscrire\".\n\n" +
            "4. Votre demande sera examin�e par l'administration de la maison s�lectionn�e.\n\n" +
            "5. Si la maison est compl�te, vous serez plac� sur liste d'attente.\n\n" +
            "6. Vous recevrez une notification par email concernant le statut de votre demande.\n\n" +
            "Note: Assurez-vous que toutes les informations fournies sont exactes et compl�tes."
        );
        infoText.setEditable(false);
        infoText.setLineWrap(true);
        infoText.setWrapStyleWord(true);
        infoText.setBackground(new Color(245, 245, 245));
        infoText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Statistiques des maisons
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Statistiques des maisons",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        // Tableau des statistiques
        updateStatsTable(); // Mettre � jour les donn�es avant de cr�er la table
        statsTable = new JTable(statsData, columnNames);
        statsTable.setFillsViewportHeight(true);
        JScrollPane statsScrollPane = new JScrollPane(statsTable);
        statsScrollPane.setPreferredSize(new Dimension(300, 150));
        
        statsPanel.add(statsScrollPane);
        
        // Ajouter les composants au panel d'information
        infoPanel.add(new JScrollPane(infoText));
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(statsPanel);
        
        // Ajouter les panels au panel central
        centerPanel.add(formPanel);
        centerPanel.add(infoPanel);
        
        // Ajouter les panels principaux au panel d'inscription
        add(titlePanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
    
    /**
     * Met � jour la liste des maisons dans le ComboBox
     */
    public void updateMaisonComboBox() {
        if (controleur == null || controleur.getCiupModel() == null) {
            return;
        }
        
        String selectedMaison = null;
        if (maisonComboBox != null && maisonComboBox.getSelectedItem() != null) {
            selectedMaison = maisonComboBox.getSelectedItem().toString();
        }
        
        if (maisonComboBox != null) {
            maisonComboBox.removeAllItems();
            
            for (Maison maison : controleur.getCiupModel().getListeMaison()) {
                if (maison instanceof MaisonClassique) {
                    maisonComboBox.addItem(maison.getNom());
                }
            }
            
            // Restaurer la s�lection pr�c�dente si possible
            if (selectedMaison != null) {
                selectMaison(selectedMaison);
            }
        }
        
        // Mettre � jour le tableau des statistiques
        updateStatsTable();
        if (statsTable != null) {
            statsTable.repaint();
        }
    }
    
    /**
     * S�lectionne une maison sp�cifique dans le ComboBox
     * @param maisonName Le nom de la maison � s�lectionner
     */
    public void selectMaison(String maisonName) {
        if (maisonComboBox == null) return;
        
        for (int i = 0; i < maisonComboBox.getItemCount(); i++) {
            if (maisonComboBox.getItemAt(i).equals(maisonName)) {
                maisonComboBox.setSelectedIndex(i);
                return;
            }
        }
    }
    
    /**
     * Met � jour le tableau des statistiques
     */
    public void updateStatsTable() {
        if (controleur == null || controleur.getCiupModel() == null) {
            return;
        }
        
        int count = 0;
        for (Maison maison : controleur.getCiupModel().getListeMaison()) {
            if (maison instanceof MaisonClassique) {
                count++;
            }
        }
        
        statsData = new Object[count][4];
        
        int i = 0;
        for (Maison maison : controleur.getCiupModel().getListeMaison()) {
            if (maison instanceof MaisonClassique) {
                MaisonClassique maisonClassique = (MaisonClassique) maison;
                statsData[i][0] = maisonClassique.getNom();
                statsData[i][1] = maisonClassique.getCapacite();
                
                // V�rifier si la liste des �tudiants est initialis�e
                ArrayList<Etudiant> listeEtudiant = maisonClassique.getListeEtudiant();
                statsData[i][2] = (listeEtudiant != null) ? listeEtudiant.size() : 0;
                
                // V�rifier si la liste d'attente est initialis�e
                ArrayList<Etudiant> listeAttente = maisonClassique.getListeAttente();
                statsData[i][3] = (listeAttente != null) ? listeAttente.size() : 0;
                
                i++;
            }
        }
        
        // Mettre � jour le mod�le de donn�es du tableau si le tableau existe d�j�
        if (statsTable != null) {
            statsTable.setModel(new DefaultTableModel(statsData, columnNames));
        }
    }
    
    /**
     * Efface le formulaire
     */
    public void clearForm() {
        nomField.setText("");
        prenomField.setText("");
        adresseField.setText("");
        nationaliteField.setText("");
        dateNaissanceField.setText("");
        telField.setText("");
        emailField.setText("");
        promotionField.setText("");
        universiteField.setText("");
    }
    
    /**
     * Retourne le nom de la maison s�lectionn�e
     * @return Le nom de la maison s�lectionn�e
     */
    public String getSelectedMaisonName() {
        return (String) maisonComboBox.getSelectedItem();
    }
    
    /**
     * Retourne le champ de nom
     * @return Le champ de nom
     */
    public JTextField getNomField() {
        return nomField;
    }
    
    /**
     * Retourne le champ de pr�nom
     * @return Le champ de pr�nom
     */
    public JTextField getPrenomField() {
        return prenomField;
    }
    
    /**
     * Retourne le champ d'adresse
     * @return Le champ d'adresse
     */
    public JTextField getAdresseField() {
        return adresseField;
    }
    
    /**
     * Retourne le champ de nationalit�
     * @return Le champ de nationalit�
     */
    public JTextField getNationaliteField() {
        return nationaliteField;
    }
    
    /**
     * Retourne le champ de date de naissance
     * @return Le champ de date de naissance
     */
    public JTextField getDateNaissanceField() {
        return dateNaissanceField;
    }
    
    /**
     * Retourne le champ de t�l�phone
     * @return Le champ de t�l�phone
     */
    public JTextField getTelField() {
        return telField;
    }
    
    /**
     * Retourne le champ d'email
     * @return Le champ d'email
     */
    public JTextField getEmailField() {
        return emailField;
    }
    
    /**
     * Retourne le champ de promotion
     * @return Le champ de promotion
     */
    public JTextField getPromotionField() {
        return promotionField;
    }
    
    /**
     * Retourne le champ d'universit�
     * @return Le champ d'universit�
     */
    public JTextField getUniversiteField() {
        return null;
    }
}
/**
 * cette classe a �t� cr�e par @author Flavio Zamperlini
 */