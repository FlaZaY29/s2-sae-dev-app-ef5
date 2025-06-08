package modeles;

import java.util.ArrayList;

/**
 * Classe repr�sentant la maison internationale dans le syst�me CIUP.
 * <p>
 * La maison internationale se distingue des maisons classiques par sa vocation
 * � accueillir des �tudiants de toutes nationalit�s et par sa gestion de services
 * sp�cialis�s. Elle ne g�re pas directement les �tudiants mais se concentre
 * sur l'offre de services � l'ensemble de la communaut� CIUP.
 * </p>
 * <p>
 * Cette classe impl�mente la gestion bidirectionnelle des services :
 * un service peut �tre propos� par plusieurs maisons internationales.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Maison
 * @see Service
 */
public class MaisonInternationale extends Maison {
	private static final long serialVersionUID = 1L;

    /** Liste des services propos�s par cette maison internationale */
    private ArrayList<Service> sesServices;

    /**
     * Constructeur complet pour cr�er une maison internationale.
     * <p>
     * Initialise automatiquement la liste des services.
     * </p>
     * 
     * @param num Num�ro unique d'identification
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel Num�ro de t�l�phone
     * @param localisation Localisation g�ographique
     * @param directeur Nom du directeur
     * @param anneeCreation Ann�e de cr�ation
     * @param dateFete Date de la f�te annuelle
     * @param dureeFete Dur�e de la f�te en jours
     */
    public MaisonInternationale(int num, String nom, String desc, String tel, String localisation, String directeur,
                                int anneeCreation, String dateFete, int dureeFete) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
        this.sesServices = new ArrayList<>();
    }

    /**
     * Constructeur par d�faut.
     * <p>
     * Cr�e une maison internationale avec des valeurs par d�faut et
     * initialise la liste des services.
     * </p>
     */
    public MaisonInternationale() {
        super();
        this.sesServices = new ArrayList<>();
    }

    /**
     * Ajoute un service � la maison internationale.
     * <p>
     * �tablit une relation bidirectionnelle : le service est ajout� � la maison
     * et la maison est ajout�e � la liste des maisons proposant ce service.
     * </p>
     * 
     * @param service Le service � ajouter
     */
    public void ajoutService(Service service) {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
        }
        sesServices.add(service);

        // Ajout de la maison � la liste des maisons proposant ce service
        service.ajoutMaison(this);
    }

    /**
     * Supprime un service de la maison internationale.
     * <p>
     * Supprime la relation bidirectionnelle : le service est retir� de la maison
     * et la maison est retir�e de la liste des maisons proposant ce service.
     * </p>
     * 
     * @param service Le service � supprimer
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
     * Affiche la liste des services propos�s par la maison.
     * <p>
     * Affiche le nom et la description de chaque service propos�.
     * </p>
     */
    public void afficheServices() {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
            System.out.println("Aucun service propos� par la Maison Internationale");
            return;
        }
        
        System.out.println("Services proposes par la Maison Internationale:");

        for (Service service : sesServices) {
            System.out.println(service.getNom() + ": " + service.getDesc());
        }
    }

    /**
     * Retourne la liste des services propos�s par la maison.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des services propos�s
     */
    public ArrayList<Service> getSesServices() {
        if (sesServices == null) {
            sesServices = new ArrayList<>();
        }
        return sesServices;
    }
}
/**
 * cette classe a �t� cr�e par @author Maksen Mouhou
 */