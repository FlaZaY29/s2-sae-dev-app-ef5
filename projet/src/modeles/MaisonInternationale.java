package modeles;

import java.util.ArrayList;

/**
 * Classe représentant la maison internationale dans le système CIUP.
 * <p>
 * La maison internationale se distingue des maisons classiques par sa vocation
 * à accueillir des étudiants de toutes nationalités et par sa gestion de services
 * spécialisés. Elle ne gère pas directement les étudiants mais se concentre
 * sur l'offre de services à l'ensemble de la communauté CIUP.
 * </p>
 * <p>
 * Cette classe implémente la gestion bidirectionnelle des services :
 * un service peut être proposé par plusieurs maisons internationales.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Maison
 * @see Service
 */
public class MaisonInternationale extends Maison {

    /** Liste des services proposés par cette maison internationale */
    private ArrayList<Service> sesServices;

    /**
     * Constructeur complet pour créer une maison internationale.
     * <p>
     * Initialise automatiquement la liste des services.
     * </p>
     * 
     * @param num Numéro unique d'identification
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel Numéro de téléphone
     * @param localisation Localisation géographique
     * @param directeur Nom du directeur
     * @param anneeCreation Année de création
     * @param dateFete Date de la fête annuelle
     * @param dureeFete Durée de la fête en jours
     */
    public MaisonInternationale(int num, String nom, String desc, String tel, String localisation, String directeur,
                                int anneeCreation, String dateFete, int dureeFete) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
        this.sesServices = new ArrayList<>();
    }

    /**
     * Constructeur par défaut.
     * <p>
     * Crée une maison internationale avec des valeurs par défaut et
     * initialise la liste des services.
     * </p>
     */
    public MaisonInternationale() {
        super();
        this.sesServices = new ArrayList<>();
    }

    /**
     * Ajoute un service à la maison internationale.
     * <p>
     * Établit une relation bidirectionnelle : le service est ajouté à la maison
     * et la maison est ajoutée à la liste des maisons proposant ce service.
     * </p>
     * 
     * @param service Le service à ajouter
     */
    public void ajoutService(Service service) {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
        }
        sesServices.add(service);

        // Ajout de la maison à la liste des maisons proposant ce service
        service.ajoutMaison(this);
    }

    /**
     * Supprime un service de la maison internationale.
     * <p>
     * Supprime la relation bidirectionnelle : le service est retiré de la maison
     * et la maison est retirée de la liste des maisons proposant ce service.
     * </p>
     * 
     * @param service Le service à supprimer
     */
    public void supprService(Service service) {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
            return;
        }
        sesServices.remove(service);

        // Suppression de la maison de la liste des maisons proposant ce service
        service.supprMaison(this);
    }

    /**
     * Affiche la liste des services proposés par la maison.
     * <p>
     * Affiche le nom et la description de chaque service proposé.
     * </p>
     */
    public void afficheServices() {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
            System.out.println("Aucun service proposé par la Maison Internationale");
            return;
        }
        
        System.out.println("Services proposes par la Maison Internationale:");

        for (Service service : sesServices) {
            System.out.println(service.getNom() + ": " + service.getDesc());
        }
    }

    /**
     * Retourne la liste des services proposés par la maison.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des services proposés
     */
    public ArrayList<Service> getSesServices() {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
        }
        return sesServices;
    }
}
