package controleurs;

import javax.swing.JOptionPane;

import modeles.CIUP;
import modeles.MaisonInternationale;
import modeles.Service;
import vues.AddServiceDialog;
import vues.EditServiceDialog;
import vues.ManageServicesDialog;

/**
 * Contrôleur pour la gestion des services
 */
public class ServiceControleur {
    private CIUP ciupModel;
    private MainControleur mainControleur;

    /**
     * Constructeur du contrôleur de services
     * @param ciupModel Le modèle CIUP
     * @param mainControleur Le contrôleur principal
     */
    public ServiceControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }

    /**
     * Affiche la boîte de dialogue de gestion des services pour une maison internationale
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
     * Affiche la boîte de dialogue d'ajout de service
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
     * Affiche la boîte de dialogue de modification de service
     * @param service Le service à modifier
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
     * Ajoute un service au modèle
     * @param service Le service à ajouter
     * @param maisonInternationale La maison internationale
     */
    public void addService(Service service, MaisonInternationale maisonInternationale) {
        // Ajouter le service au modèle CIUP
        ciupModel.ajouterService(service);

        // Ajouter le service à la maison internationale
        maisonInternationale.ajoutService(service);

        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Service ajouté avec succès: " + service.getNom(),
            "Succès",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Met à jour un service dans le modèle
     * @param service Le service mis à jour
     * @param maisonInternationale La maison internationale
     */
    public void updateService(Service service, MaisonInternationale maisonInternationale) {
        JOptionPane.showMessageDialog(
            mainControleur.getMainFrame(),
            "Service modifié avec succès: " + service.getNom(),
            "Succès",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Supprime un service du modèle
     * @param service Le service à supprimer
     * @param maisonInternationale La maison internationale
     */
    public void deleteService(Service service, MaisonInternationale maisonInternationale) {
        // Confirmer la suppression
        int result = JOptionPane.showConfirmDialog(
            mainControleur.getMainFrame(),
            "Êtes-vous sûr de vouloir supprimer le service " + service.getNom() + " ?",
            "Confirmation de suppression",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            // Supprimer le service de la maison internationale
            maisonInternationale.supprService(service);

            // Supprimer le service du modèle CIUP
            ciupModel.supprService(service);

            JOptionPane.showMessageDialog(
                mainControleur.getMainFrame(),
                "Service supprimé avec succès",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    /**
     * Crée un nouveau service
     * @param num Numéro du service
     * @param nom Nom du service
     * @param desc Description du service
     * @param heureOuv Heure d'ouverture
     * @param heureFerm Heure de fermeture
     * @return Le service créé
     */
    public Service createService(int num, String nom, String desc, int heureOuv, int heureFerm) {
        return new Service(num, nom, desc, heureOuv, heureFerm);
    }

    /**
     * Génère un nouveau numéro de service unique
     * @return Le nouveau numéro de service
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
     * Vérifie si un numéro de service existe déjà
     * @param num Le numéro à vérifier
     * @return true si le numéro existe, false sinon
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
     * Retourne le modèle CIUP
     * @return Le modèle CIUP
     */
    public CIUP getCiupModel() {
        return ciupModel;
    }

    /**
     * Retourne le contrôleur principal
     * @return Le contrôleur principal
     */
    public MainControleur getMainControleur() {
        return mainControleur;
    }
}
