package controleurs;

import modeles.CIUP;
import modeles.Service;
import modeles.MaisonInternationale;
import vues.AddServiceDialog;
import vues.EditServiceDialog;
import vues.ManageServicesDialog;

import javax.swing.*;

/**
 * Contrôleur pour la gestion des services dans l'application CIUP.
 * <p>
 * Cette classe implémente les fonctionnalités de gestion des services pour les maisons internationales,
 * notamment l'ajout, la modification, la suppression et l'affichage des services. Elle sert d'intermédiaire
 * entre les vues (interfaces utilisateur) et les modèles de données (Service, MaisonInternationale).
 * </p>
 * <p>
 * Le contrôleur gère également la validation des données et la génération des identifiants uniques pour
 * les nouveaux services.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Service
 * @see MaisonInternationale
 * @see AddServiceDialog
 * @see EditServiceDialog
 * @see ManageServicesDialog
 */
public class ServiceControleur {
    /** Le modèle de données principal de l'application */
    private CIUP ciupModel;
    
    /** Le contrôleur principal de l'application */
    private MainControleur mainControleur;
    
    /**
     * Constructeur du contrôleur de services.
     * <p>
     * Initialise le contrôleur avec les références nécessaires au modèle CIUP
     * et au contrôleur principal.
     * </p>
     * 
     * @param ciupModel Le modèle CIUP contenant les données de l'application
     * @param mainControleur Le contrôleur principal de l'application
     */
    public ServiceControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }
    
    /**
     * Affiche la boîte de dialogue de gestion des services pour une maison internationale.
     * <p>
     * Cette méthode crée et affiche une interface permettant de visualiser, ajouter,
     * modifier et supprimer les services associés à une maison internationale spécifique.
     * </p>
     * 
     * @param maisonInternationale La maison internationale dont on souhaite gérer les services
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
     * Affiche la boîte de dialogue d'ajout de service.
     * <p>
     * Cette méthode crée et affiche un formulaire permettant d'ajouter un nouveau service
     * à une maison internationale spécifique.
     * </p>
     * 
     * @param maisonInternationale La maison internationale à laquelle ajouter le service
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
     * Affiche la boîte de dialogue de modification de service.
     * <p>
     * Cette méthode crée et affiche un formulaire pré-rempli permettant de modifier
     * les informations d'un service existant.
     * </p>
     * 
     * @param service Le service à modifier
     * @param maisonInternationale La maison internationale à laquelle appartient le service
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
     * Ajoute un service au modèle de données.
     * <p>
     * Cette méthode ajoute un nouveau service au modèle CIUP et l'associe à la maison
     * internationale spécifiée. Elle affiche également un message de confirmation à l'utilisateur.
     * </p>
     * 
     * @param service Le service à ajouter
     * @param maisonInternationale La maison internationale à laquelle associer le service
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
     * Met à jour un service dans le modèle de données.
     * <p>
     * Cette méthode met à jour les informations d'un service existant et affiche
     * un message de confirmation à l'utilisateur.
     * </p>
     * 
     * @param service Le service mis à jour
     * @param maisonInternationale La maison internationale à laquelle appartient le service
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
     * Supprime un service du modèle de données.
     * <p>
     * Cette méthode demande confirmation à l'utilisateur, puis supprime le service
     * du modèle CIUP et de la maison internationale spécifiée.
     * </p>
     * 
     * @param service Le service à supprimer
     * @param maisonInternationale La maison internationale à laquelle appartient le service
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
     * Crée un nouveau service avec les paramètres spécifiés.
     * <p>
     * Cette méthode instancie un nouvel objet Service avec les informations fournies.
     * </p>
     * 
     * @param num Numéro unique du service
     * @param nom Nom du service
     * @param desc Description du service
     * @param heureOuv Heure d'ouverture (format 24h)
     * @param heureFerm Heure de fermeture (format 24h)
     * @return Le service nouvellement créé
     */
    public Service createService(int num, String nom, String desc, int heureOuv, int heureFerm) {
        return new Service(num, nom, desc, heureOuv, heureFerm);
    }
    
    /**
     * Génère un nouveau numéro de service unique.
     * <p>
     * Cette méthode parcourt tous les services existants pour déterminer
     * le prochain numéro disponible (le plus grand numéro existant + 1).
     * </p>
     * 
     * @return Un numéro de service unique
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
     * Vérifie si un numéro de service existe déjà.
     * <p>
     * Cette méthode parcourt tous les services existants pour vérifier
     * si le numéro spécifié est déjà utilisé.
     * </p>
     * 
     * @param num Le numéro à vérifier
     * @return true si le numéro existe déjà, false sinon
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
     * Retourne le modèle CIUP.
     * 
     * @return Le modèle CIUP contenant les données de l'application
     */
    public CIUP getCiupModel() {
        return ciupModel;
    }
    
    /**
     * Retourne le contrôleur principal.
     * 
     * @return Le contrôleur principal de l'application
     */
    public MainControleur getMainControleur() {
        return mainControleur;
    }
}
/**
 * cette classe a été crée par @author Maksen Mouhou
 */
