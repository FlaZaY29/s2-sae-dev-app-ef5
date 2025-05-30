package modeles;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Classe principale du mod�le repr�sentant la Cit� Internationale Universitaire de Paris.
 * <p>
 * Cette classe constitue le point central du mod�le de donn�es de l'application.
 * Elle g�re les collections principales de l'�tablissement : les maisons, les services
 * et les �tudiants. Elle fournit les m�thodes n�cessaires pour manipuler ces collections
 * et effectuer des recherches.
 * </p>
 * <p>
 * La classe suit le pattern Singleton implicite en tant que mod�le principal de l'application
 * et centralise toutes les op�rations CRUD sur les entit�s principales.
 * * </p>
 * <p>
 * Cette classe implémente Serializable pour permettre la sauvegarde de l'état de l'application
 * sur le disque dur.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Maison
 * @see Service
 * @see Etudiant
 */
public class CIUP implements Serializable {
    
    /** Identifiant de version pour la sérialisation */
    private static final long serialVersionUID = 1L;
    /** Liste des maisons de la CIUP */
    private ArrayList<Maison> listeMaison = new ArrayList<>();
    
    /** Liste des services propos�s par la CIUP */
    private ArrayList<Service> listeService = new ArrayList<>();
    
    /** Liste des �tudiants inscrits � la CIUP */
    private ArrayList<Etudiant> listeEtudiant = new ArrayList<>();

    /**
     * Affiche la liste compl�te des maisons de la CIUP.
     * <p>
     * Cette m�thode parcourt toutes les maisons enregistr�es et affiche
     * leurs informations via la m�thode afficheMaison() de chaque maison.
     * </p>
     */
    public void afficheListeMaison() {
        for (Maison maison : listeMaison) {
            maison.afficheMaison();
        }
    }

    /**
     * Affiche la liste compl�te des services de la CIUP.
     * <p>
     * Cette m�thode parcourt tous les services enregistr�s et affiche
     * leurs informations via la m�thode afficheService() de chaque service.
     * </p>
     */
    public void afficheListeService() {
        for (Service service : listeService) {
            service.afficheService();
        }
    }

    /**
     * Affiche la liste compl�te des �tudiants de la CIUP.
     * <p>
     * Cette m�thode parcourt tous les �tudiants enregistr�s et affiche
     * un r�sum� de leurs informations via la m�thode afficheInfoResume().
     * </p>
     */
    public void afficheListeEtudiant() {
        for (Etudiant etudiant : listeEtudiant) {
            etudiant.afficheInfoResume();
        }
    }

    /**
     * Ajoute une maison � la collection des maisons de la CIUP.
     * 
     * @param maison La maison � ajouter � la collection
     */
    public void ajouterMaison(Maison maison) {
        listeMaison.add(maison);
    }

    /**
     * Supprime une maison de la collection des maisons de la CIUP.
     * 
     * @param maison La maison � supprimer de la collection
     */
    public void supprMaison(Maison maison) {
        listeMaison.remove(maison);
    }

    /**
     * Ajoute un service � la collection des services de la CIUP.
     * 
     * @param service Le service � ajouter � la collection
     */
    public void ajouterService(Service service) {
        listeService.add(service);
    }

    /**
     * Supprime un service de la collection des services de la CIUP.
     * 
     * @param service Le service � supprimer de la collection
     */
    public void supprService(Service service) {
        listeService.remove(service);
    }

    /**
     * Ajoute un �tudiant � la collection des �tudiants de la CIUP.
     * 
     * @param etudiant L'�tudiant � ajouter � la collection
     */
    public void ajouterEtudiant(Etudiant etudiant) {
        listeEtudiant.add(etudiant);
    }

    /**
     * Supprime un �tudiant de la collection des �tudiants de la CIUP.
     * 
     * @param etudiant L'�tudiant � supprimer de la collection
     */
    public void supprEtudiant(Etudiant etudiant) {
        listeEtudiant.remove(etudiant);
    }

    /**
     * Recherche une maison par son nom.
     * <p>
     * La recherche est insensible � la casse (ignore majuscules/minuscules).
     * </p>
     * 
     * @param nom Le nom de la maison � rechercher
     * @return La maison trouv�e ou null si aucune maison ne correspond
     */
    public Maison rechercherMaisonParNom(String nom) {
        for (Maison maison : listeMaison) {
            if (maison.getNom().equalsIgnoreCase(nom)) {
                return maison;
            }
        }
        return null;
    }

    /**
     * Recherche un �tudiant par son nom et pr�nom.
     * <p>
     * La recherche est insensible � la casse pour les deux crit�res.
     * </p>
     * 
     * @param nom Le nom de famille de l'�tudiant
     * @param prenom Le pr�nom de l'�tudiant
     * @return L'�tudiant trouv� ou null si aucun �tudiant ne correspond
     */
    public Etudiant rechercherEtudiantParNomPrenom(String nom, String prenom) {
        for (Etudiant etudiant : listeEtudiant) {
            if (etudiant.getNom().equalsIgnoreCase(nom) && etudiant.getPrenom().equalsIgnoreCase(prenom)) {
                return etudiant;
            }
        }
        return null;
    }

    /**
     * Retourne la liste des maisons de la CIUP.
     * 
     * @return ArrayList contenant toutes les maisons
     */
    public ArrayList<Maison> getListeMaison() {
        return listeMaison;
    }

    /**
     * Retourne la liste des services de la CIUP.
     * 
     * @return ArrayList contenant tous les services
     */
    public ArrayList<Service> getListeService() {
        return listeService;
    }

    /**
     * Retourne la liste des �tudiants de la CIUP.
     * 
     * @return ArrayList contenant tous les �tudiants
     */
    public ArrayList<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }
}
/**
 * cette classe a �t� cr�e par @author Flavio Zamperlini
 */