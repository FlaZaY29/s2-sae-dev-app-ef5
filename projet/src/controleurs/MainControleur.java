package controleurs;

import modeles.CIUP;
import vues.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Contr�leur principal de l'application
 * G�re les interactions entre les vues et le mod�le
 */
public class MainControleur {
    private CIUP ciupModel;
    private MainFrame mainFrame;
    
    // Sous-contr�leurs
    private MaisonControleur maisonControleur;
    private EtudiantControleur etudiantControleur;
    private ServiceControleur serviceControleur;
    private PersistenceControleur persistenceControleur;
    
    /**
     * Constructeur du contr�leur principal
     * @param ciupModel Le mod�le CIUP
     */
    public MainControleur(CIUP ciupModel) {
        this.ciupModel = ciupModel;
        
        // Initialisation des sous-contr�leurs
        this.maisonControleur = new MaisonControleur(ciupModel, this);
        this.etudiantControleur = new EtudiantControleur(ciupModel, this);
        this.serviceControleur = new ServiceControleur(ciupModel, this);
        this.persistenceControleur = new PersistenceControleur(this);
    }
    
    /**
     * D�finit la vue principale
     * @param mainFrame La vue principale
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        
        // Initialisation des �couteurs d'�v�nements
        initListeners();

        // Rafra�chir la liste des maisons au d�marrage
        mainFrame.getHousesListPanel().refreshHousesList();

        // Afficher le panel des maisons par d�faut
        showHousesList();
    }
    
    /**
     * Initialise les �couteurs d'�v�nements pour la vue principale
     */
    private void initListeners() {
        // �couteur pour le bouton de navigation vers la liste des maisons
        mainFrame.getSidebarPanel().getMaisonsButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.getSidebarPanel().setActiveButton(mainFrame.getSidebarPanel().getMaisonsButton());
                showHousesList();
            }
        });
        
        // �couteur pour le bouton de navigation vers le formulaire d'inscription
        mainFrame.getSidebarPanel().getInscriptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.getSidebarPanel().setActiveButton(mainFrame.getSidebarPanel().getInscriptionButton());
                showInscription();
            }
        });
        
        // �couteur pour le champ de recherche
        mainFrame.getHeaderPanel().getSearchField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchHouses(mainFrame.getHeaderPanel().getSearchField().getText());
            }
        });
    }
    
    /**
     * Affiche la liste des maisons
     */
    public void showHousesList() {
        // Rafra�chir la liste des maisons avant d'afficher le panel
        mainFrame.getHousesListPanel().refreshHousesList();
        mainFrame.showPanel("HOUSES");
    }
    
    /**
     * Affiche le formulaire d'inscription
     */
    public void showInscription() {
        // Mettre � jour la liste des maisons avant d'afficher le panel d'inscription
        mainFrame.getInscriptionPanel().updateMaisonComboBox();
        mainFrame.showPanel("INSCRIPTION");
    }
    
    /**
     * Recherche des maisons par nom
     * @param searchText Le texte de recherche
     */
    public void searchHouses(String searchText) {
        // R�cup�rer le panel des maisons et filtrer
        mainFrame.getHousesListPanel().filterHouses(searchText);
    }
    
    /**
     * Retourne le mod�le CIUP
     * @return Le mod�le CIUP
     */
    public CIUP getCiupModel() {
        return ciupModel;
    }
    
    /**
     * Retourne la vue principale
     * @return La vue principale
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    /**
     * Retourne le contr�leur de maisons
     * @return Le contr�leur de maisons
     */
    public MaisonControleur getMaisonControleur() {
        return maisonControleur;
    }
    
    /**
     * Retourne le contr�leur d'�tudiants
     * @return Le contr�leur d'�tudiants
     */
    public EtudiantControleur getEtudiantControleur() {
        return etudiantControleur;
    }
    
    /**
     * Retourne le contr�leur de services
     * @return Le contr�leur de services
     */
    public ServiceControleur getServiceControleur() {
        return serviceControleur;
    }

    /**
     * Sauvegarde les donn�es de l'application.
     * Affiche une bo�te de dialogue pour s�lectionner le fichier de sauvegarde.
     */
    public void saveDataWithDialog() {
        File file = persistenceControleur.showFileDialog(true);
        if (file != null) {
            persistenceControleur.saveData(file);
        }
    }

    /**
     * Sauvegarde les donn�es de l'application dans le fichier par d�faut.
     */
    public void saveData() {
        persistenceControleur.saveData();
    }

    /**
     * Charge les donn�es de l'application.
     * Affiche une bo�te de dialogue pour s�lectionner le fichier � charger.
     */
    public void loadDataWithDialog() {
        File file = persistenceControleur.showFileDialog(false);
        if (file != null) {
            CIUP loadedModel = persistenceControleur.loadData(file);
            if (loadedModel != null) {
                this.ciupModel = loadedModel;
                refreshAllViews();
            }
        }
    }

    /**
     * Charge les donn�es de l'application depuis le fichier par d�faut.
     */
    public void loadData() {
        CIUP loadedModel = persistenceControleur.loadData();
        if (loadedModel != null) {
            this.ciupModel = loadedModel;
            refreshAllViews();
        }
    }

    /**
     * Rafra�chit toutes les vues apr�s un chargement de donn�es.
     */
    private void refreshAllViews() {
        if (mainFrame != null) {
            mainFrame.getHousesListPanel().refreshHousesList();
            mainFrame.getInscriptionPanel().updateMaisonComboBox();
            mainFrame.getInscriptionPanel().updateStatsTable();
        }
    }

    /**
     * Retourne le contr�leur de persistance.
     * @return Le contr�leur de persistance
     */
    public PersistenceControleur getPersistenceControleur() {
        return persistenceControleur;
    }
}

/**
 * cette classe a �t� cr�e par @author Donald Se
 */