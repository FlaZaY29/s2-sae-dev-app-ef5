package modeles;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe principale du modèle représentant la Cité Internationale Universitaire de Paris.
 * <p>
 * Cette classe constitue le point central du modèle de données de l'application.
 * Elle gère les collections principales de l'établissement : les maisons, les services
 * et les étudiants. Elle fournit les méthodes nécessaires pour manipuler ces collections
 * et effectuer des recherches.
 * </p>
 * <p>
 * La classe suit le pattern Singleton implicite en tant que modèle principal de l'application
 * et centralise toutes les opérations CRUD sur les entités principales.
 * </p>
 * <p>
 * Cette classe implémente Serializable pour permettre la sauvegarde de l'état de l'application
 * sur le disque dur.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.1
 * @see Maison
 * @see Service
 * @see Etudiant
 */
public class CIUP implements Serializable {
    
    /** Identifiant de version pour la sérialisation */
    private static final long serialVersionUID = 1L;

    /** Liste des maisons de la CIUP */
    private ArrayList<Maison> listeMaison = new ArrayList<>();
    
    /** Liste des services proposés par la CIUP */
    private ArrayList<Service> listeService = new ArrayList<>();
    
    /** Liste des étudiants inscrits à la CIUP */
    private ArrayList<Etudiant> listeEtudiant = new ArrayList<>();

    /**
     * Affiche la liste complète des maisons de la CIUP.
     * <p>
     * Cette méthode parcourt toutes les maisons enregistrées et affiche
     * leurs informations via la méthode afficheMaison() de chaque maison.
     * </p>
     */
    public void afficheListeMaison() {
        for (Maison maison : listeMaison) {
            maison.afficheMaison();
        }
    }

    /**
     * Affiche la liste complète des services de la CIUP.
     * <p>
     * Cette méthode parcourt tous les services enregistrés et affiche
     * leurs informations via la méthode afficheService() de chaque service.
     * </p>
     */
    public void afficheListeService() {
        for (Service service : listeService) {
            service.afficheService();
        }
    }

    /**
     * Affiche la liste complète des étudiants de la CIUP.
     * <p>
     * Cette méthode parcourt tous les étudiants enregistrés et affiche
     * un résumé de leurs informations via la méthode afficheInfoResume().
     * </p>
     */
    public void afficheListeEtudiant() {
        for (Etudiant etudiant : listeEtudiant) {
            etudiant.afficheInfoResume();
        }
    }

    /**
     * Ajoute une maison à la collection des maisons de la CIUP.
     * 
     * @param maison La maison à ajouter à la collection
     */
    public void ajouterMaison(Maison maison) {
        listeMaison.add(maison);
    }

    /**
     * Supprime une maison de la collection des maisons de la CIUP.
     * 
     * @param maison La maison à supprimer de la collection
     */
    public void supprMaison(Maison maison) {
        listeMaison.remove(maison);
    }

    /**
     * Ajoute un service à la collection des services de la CIUP.
     * 
     * @param service Le service à ajouter à la collection
     */
    public void ajouterService(Service service) {
        listeService.add(service);
    }

    /**
     * Supprime un service de la collection des services de la CIUP.
     * 
     * @param service Le service à supprimer de la collection
     */
    public void supprService(Service service) {
        listeService.remove(service);
    }

    /**
     * Ajoute un étudiant à la collection des étudiants de la CIUP.
     * 
     * @param etudiant L'étudiant à ajouter à la collection
     */
    public void ajouterEtudiant(Etudiant etudiant) {
        listeEtudiant.add(etudiant);
    }

    /**
     * Supprime un étudiant de la collection des étudiants de la CIUP.
     * 
     * @param etudiant L'étudiant à supprimer de la collection
     */
    public void supprEtudiant(Etudiant etudiant) {
        listeEtudiant.remove(etudiant);
    }

    /**
     * Recherche une maison par son nom.
     * <p>
     * La recherche est insensible à la casse (ignore majuscules/minuscules).
     * </p>
     * 
     * @param nom Le nom de la maison à rechercher
     * @return La maison trouvée ou null si aucune maison ne correspond
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
     * Recherche un étudiant par son nom et prénom.
     * <p>
     * La recherche est insensible à la casse pour les deux critères.
     * </p>
     * 
     * @param nom Le nom de famille de l'étudiant
     * @param prenom Le prénom de l'étudiant
     * @return L'étudiant trouvé ou null si aucun étudiant ne correspond
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
     * Retourne la liste des étudiants de la CIUP.
     * 
     * @return ArrayList contenant tous les étudiants
     */
    public ArrayList<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }
}
/**
 * cette classe a été crée par @author Flavio Zamperlini
 */