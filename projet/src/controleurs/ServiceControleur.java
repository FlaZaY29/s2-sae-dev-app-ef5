package controleurs;

import modeles.CIUP;
import modeles.Service;
import modeles.MaisonInternationale;
import vues.AddServiceDialog;
import vues.EditServiceDialog;
import vues.ManageServicesDialog;

import javax.swing.*;

/**
 * Contr�leur pour la gestion des services dans l'application CIUP.
 * <p>
 * Cette classe impl�mente les fonctionnalit�s de gestion des services pour les maisons internationales,
 * notamment l'ajout, la modification, la suppression et l'affichage des services. Elle sert d'interm�diaire
 * entre les vues (interfaces utilisateur) et les mod�les de donn�es (Service, MaisonInternationale).
 * </p>
 * <p>
 * Le contr�leur g�re �galement la validation des donn�es et la g�n�ration des identifiants uniques pour
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
    /** Le mod�le de donn�es principal de l'application */
    private CIUP ciupModel;
    
    /** Le contr�leur principal de l'application */
    private MainControleur mainControleur;
    
    /**
     * Constructeur du contr�leur de services.
     * <p>
     * Initialise le contr�leur avec les r�f�rences n�cessaires au mod�le CIUP
     * et au contr�leur principal.
     * </p>
     * 
     * @param ciupModel Le mod�le CIUP contenant les donn�es de l'application
     * @param mainControleur Le contr�leur principal de l'application
     */
    public ServiceControleur(CIUP ciupModel, MainControleur mainControleur) {
        this.ciupModel = ciupModel;
        this.mainControleur = mainControleur;
    }
    
    /**
     * Affiche la bo�te de dialogue de gestion des services pour une maison internationale.
     * <p>
     * Cette m�thode cr�e et affiche une interface permettant de visualiser, ajouter,
     * modifier et supprimer les services associ�s � une maison internationale sp�cifique.
     * </p>
     * 
     * @param maisonInternationale La maison internationale dont on souhaite g�rer les services
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
     * Affiche la bo�te de dialogue d'ajout de service.
     * <p>
     * Cette m�thode cr�e et affiche un formulaire permettant d'ajouter un nouveau service
     * � une maison internationale sp�cifique.
     * </p>
     * 
     * @param maisonInternationale La maison internationale � laquelle ajouter le service
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
     * Affiche la bo�te de dialogue de modification de service.
     * <p>
     * Cette m�thode cr�e et affiche un formulaire pr�-rempli permettant de modifier
     * les informations d'un service existant.
     * </p>
     * 
     * @param service Le service � modifier
     * @param maisonInternationale La maison internationale � laquelle appartient le service
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
     * Ajoute un service au mod�le de donn�es.
     * <p>
     * Cette m�thode ajoute un nouveau service au mod�le CIUP et l'associe � la maison
     * internationale sp�cifi�e. Elle affiche �galement un message de confirmation � l'utilisateur.
     * </p>
     * 
     * @param service Le service � ajouter
     * @param maisonInternationale La maison internationale � laquelle associer le service
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
     * Met � jour un service dans le mod�le de donn�es.
     * <p>
     * Cette m�thode met � jour les informations d'un service existant et affiche
     * un message de confirmation � l'utilisateur.
     * </p>
     * 
     * @param service Le service mis � jour
     * @param maisonInternationale La maison internationale � laquelle appartient le service
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
     * Supprime un service du mod�le de donn�es.
     * <p>
     * Cette m�thode demande confirmation � l'utilisateur, puis supprime le service
     * du mod�le CIUP et de la maison internationale sp�cifi�e.
     * </p>
     * 
     * @param service Le service � supprimer
     * @param maisonInternationale La maison internationale � laquelle appartient le service
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
     * Cr�e un nouveau service avec les param�tres sp�cifi�s.
     * <p>
     * Cette m�thode instancie un nouvel objet Service avec les informations fournies.
     * </p>
     * 
     * @param num Num�ro unique du service
     * @param nom Nom du service
     * @param desc Description du service
     * @param heureOuv Heure d'ouverture (format 24h)
     * @param heureFerm Heure de fermeture (format 24h)
     * @return Le service nouvellement cr��
     */
    public Service createService(int num, String nom, String desc, int heureOuv, int heureFerm) {
        return new Service(num, nom, desc, heureOuv, heureFerm);
    }
    
    /**
     * G�n�re un nouveau num�ro de service unique.
     * <p>
     * Cette m�thode parcourt tous les services existants pour d�terminer
     * le prochain num�ro disponible (le plus grand num�ro existant + 1).
     * </p>
     * 
     * @return Un num�ro de service unique
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
     * V�rifie si un num�ro de service existe d�j�.
     * <p>
     * Cette m�thode parcourt tous les services existants pour v�rifier
     * si le num�ro sp�cifi� est d�j� utilis�.
     * </p>
     * 
     * @param num Le num�ro � v�rifier
     * @return true si le num�ro existe d�j�, false sinon
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
     * Retourne le mod�le CIUP.
     * 
     * @return Le mod�le CIUP contenant les donn�es de l'application
     */
    public CIUP getCiupModel() {
        return ciupModel;
    }
    
    /**
     * Retourne le contr�leur principal.
     * 
     * @return Le contr�leur principal de l'application
     */
    public MainControleur getMainControleur() {
        return mainControleur;
    }
}
/**
 * cette classe a �t� cr�e par @author Maksen Mouhou
 */
