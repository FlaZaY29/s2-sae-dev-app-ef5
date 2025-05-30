package controleurs;

import javax.swing.JOptionPane;

import modeles.CIUP;
import modeles.MaisonInternationale;
import modeles.Service;
import vues.AddServiceDialog;
import vues.EditServiceDialog;
import vues.ManageServicesDialog;

/**
 * Contr�leur pour la gestion des services
 */
public class ServiceControleur {
    private CIUP ciupModel;
    private MainControleur mainControleur;

    /**
     * Constructeur du contr�leur de services
     * @param ciupModel Le mod�le CIUP
     * @param mainControleur Le contr�leur principal
     */
    public ServiceControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }

    /**
     * Affiche la bo�te de dialogue de gestion des services pour une maison internationale
     * @param maisonInternationale La maison internationale
     */
    public void showManageServicesDialog(MaisonInternationale maisonInternationale) {
        ManageServicesDialog dialog = new ManageServicesDialog(
            mainControleur.getMainFrame(),
            maisonInternationale,
            this
        );
        dialog.setVisible(true);
    }

    /**
     * Affiche la bo�te de dialogue d'ajout de service
     * @param maisonInternationale La maison internationale
     */
    public void showAddServiceDialog(MaisonInternationale maisonInternationale) {
        AddServiceDialog dialog = new AddServiceDialog(
            mainControleur.getMainFrame(),
            this,
            maisonInternationale
        );
        dialog.setVisible(true);
    }

    /**
     * Affiche la bo�te de dialogue de modification de service
     * @param service Le service � modifier
     * @param maisonInternationale La maison internationale
     */
    public void showEditServiceDialog(Service service, MaisonInternationale maisonInternationale) {
        EditServiceDialog dialog = new EditServiceDialog(
            mainControleur.getMainFrame(),
            this,
            service,
            maisonInternationale
        );
        dialog.setVisible(true);
    }

    /**
     * Ajoute un service au mod�le
     * @param service Le service � ajouter
     * @param maisonInternationale La maison internationale
     */
    public void addService(Service service, MaisonInternationale maisonInternationale) {
        // Ajouter le service au mod�le CIUP
        ciupModel.ajouterService(service);

        // Ajouter le service � la maison internationale
        maisonInternationale.ajoutService(service);

        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Service ajout� avec succ�s: " + service.getNom(),
            "Succ�s",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Met � jour un service dans le mod�le
     * @param service Le service mis � jour
     * @param maisonInternationale La maison internationale
     */
    public void updateService(Service service, MaisonInternationale maisonInternationale) {
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Service modifi� avec succ�s: " + service.getNom(),
            "Succ�s",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Supprime un service du mod�le
     * @param service Le service � supprimer
     * @param maisonInternationale La maison internationale
     */
    public void deleteService(Service service, MaisonInternationale maisonInternationale) {
        // Confirmer la suppression
        int result = JOptionPane.showConfirmDialog(
            mainControleur.getMainFrame(),
            "�tes-vous s�r de vouloir supprimer le service " + service.getNom() + " ?",
            "Confirmation de suppression",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            // Supprimer le service de la maison internationale
            maisonInternationale.supprService(service);

            // Supprimer le service du mod�le CIUP
            ciupModel.supprService(service);

            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Service supprim� avec succ�s",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    /**
     * Cr�e un nouveau service
     * @param num Num�ro du service
     * @param nom Nom du service
     * @param desc Description du service
     * @param heureOuv Heure d'ouverture
     * @param heureFerm Heure de fermeture
     * @return Le service cr��
     */
    public Service createService(int num, String nom, String desc, int heureOuv, int heureFerm) {
        return new Service(num, nom, desc, heureOuv, heureFerm);
    }

    /**
     * G�n�re un nouveau num�ro de service unique
     * @return Le nouveau num�ro de service
     */
    public int generateNewServiceNumber() {
        int maxNum = 0;
        for (Service service : ciupModel.getListeService()) {
            if (service.getNum() > maxNum) {
                maxNum = service.getNum();
            }
        }
        return maxNum + 1;
    }

    /**
     * V�rifie si un num�ro de service existe d�j�
     * @param num Le num�ro � v�rifier
     * @return true si le num�ro existe, false sinon
     */
    public boolean serviceNumberExists(int num) {
        for (Service service : ciupModel.getListeService()) {
            if (service.getNum() == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne le mod�le CIUP
     * @return Le mod�le CIUP
     */
    public CIUP getCiupModel() {
        return ciupModel;
    }

    /**
     * Retourne le contr�leur principal
     * @return Le contr�leur principal
     */
    public MainControleur getMainControleur() {
        return mainControleur;
    }
}
