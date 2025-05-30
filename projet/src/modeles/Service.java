package modeles;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe représentant un service dans le système CIUP.
 * <p>
 * Un service est une prestation offerte aux étudiants de la CIUP par une ou
 * plusieurs maisons internationales. Chaque service a des horaires d'ouverture
 * et peut être proposé par plusieurs maisons simultanément.
 * </p>
 * <p>
 * Cette classe gère la relation bidirectionnelle avec les maisons internationales
 * qui proposent le service.
 * </p>
 * <p>
 * Cette classe implémente Serializable pour permettre la sauvegarde des services
 * sur le disque dur.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.1
 * @see MaisonInternationale
 */
public class Service implements Serializable {

    /** Identifiant de version pour la sérialisation */
    private static final long serialVersionUID = 1L;

    /** Liste des maisons internationales proposant ce service */
    private ArrayList<MaisonInternationale> sesMaison;

    /** Num�ro unique d'identification du service */
    private int num;
    
    /** Nom du service */
    private String nom;
    
    /** Description d�taill�e du service */
    private String desc;
    
    /** Heure d'ouverture du service (format 24h) */
    private int heureOuv;
    
    /** Heure de fermeture du service (format 24h) */
    private int heureFerm;

    /**
     * Constructeur complet pour cr�er un service.
     * <p>
     * Initialise automatiquement la liste des maisons proposant le service.
     * </p>
     * 
     * @param num Num�ro unique d'identification
     * @param nom Nom du service
     * @param desc Description du service
     * @param heureOuv Heure d'ouverture (0-23)
     * @param heureFerm Heure de fermeture (0-23)
     */
    public Service(int num, String nom, String desc, int heureOuv, int heureFerm) {
        this.sesMaison = new ArrayList<MaisonInternationale>();
        this.num = num;
        this.nom = nom;
        this.desc = desc;
        this.heureOuv = heureOuv;
        this.heureFerm = heureFerm;
    }

    /**
     * Constructeur par d�faut.
     * <p>
     * Cr�e un service avec des valeurs par d�faut et initialise
     * la liste des maisons.
     * </p>
     */
    public Service() {
        this.sesMaison = new ArrayList<MaisonInternationale>();
    }

    /**
     * Retourne une repr�sentation textuelle compl�te du service.
     * <p>
     * Format : num ; nom ; desc ; heureOuv ; heureFerm
     * </p>
     * 
     * @return Cha�ne de caract�res repr�sentant le service
     */
    public String toString() {
        String s = "";
        s += num;
        s += " ; " + nom;
        s += " ; " + desc;
        s += " ; " + heureOuv;
        s += " ; " + heureFerm;
        return s;
    }

    /**
     * Ajoute une maison internationale � la liste des maisons proposant ce service.
     * <p>
     * Cette m�thode est appel�e automatiquement lors de l'ajout d'un service
     * � une maison internationale pour maintenir la coh�rence bidirectionnelle.
     * </p>
     * 
     * @param maison La maison internationale � ajouter
     */
    public void ajoutMaison(MaisonInternationale maison) {
        if (sesMaison == null) {
            sesMaison = new ArrayList<>();
        }
        sesMaison.add(maison);
    }

    /**
     * Supprime une maison internationale de la liste des maisons proposant ce service.
     * <p>
     * Cette m�thode est appel�e automatiquement lors de la suppression d'un service
     * d'une maison internationale pour maintenir la coh�rence bidirectionnelle.
     * </p>
     * 
     * @param maison La maison internationale � supprimer
     */
    public void supprMaison(MaisonInternationale maison) {
        if (sesMaison == null) {
            sesMaison = new ArrayList<>();
            return;
        }
        sesMaison.remove(maison);
    }

    /**
     * Affiche les informations compl�tes du service sur la console.
     * <p>
     * Affiche toutes les informations du service ainsi que la liste
     * des maisons qui le proposent.
     * </p>
     */
    public void afficheService() {
        System.out.println("Numero Service: " + num);
        System.out.println("Nom Service: " + nom);
        System.out.println("Description: " + desc);
        System.out.println("Heure d'ouverture: " + heureOuv);
        System.out.println("Heure de fermeture: " + heureFerm);
        System.out.println("Maison(s) associee(s): ");
        
        if (sesMaison == null) {
            sesMaison = new ArrayList<>();
            System.out.println("Aucune maison associ�e");
        } else {
            for (MaisonInternationale maison : sesMaison) {
                System.out.println(maison.getNom());
            }
        }
        System.out.println();
    }

    // Getters et Setters avec documentation

    /**
     * Retourne la liste des maisons proposant ce service.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des maisons internationales
     */
    public ArrayList<MaisonInternationale> getSesMaison() {
        if (sesMaison == null) {
            sesMaison = new ArrayList<>();
        }
        return sesMaison;
    }

    /**
     * D�finit la liste des maisons proposant ce service.
     * 
     * @param sesMaison La nouvelle liste de maisons
     */
    public void setSesMaison(ArrayList<MaisonInternationale> sesMaison) {
        this.sesMaison = sesMaison;
    }

    /**
     * Retourne le num�ro d'identification du service.
     * 
     * @return Le num�ro unique d'identification
     */
    public int getNum() {
        return num;
    }

    /**
     * D�finit le num�ro d'identification du service.
     * 
     * @param num Le num�ro unique d'identification
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Retourne le nom du service.
     * 
     * @return Le nom du service
     */
    public String getNom() {
        return nom;
    }

    /**
     * D�finit le nom du service.
     * 
     * @param nom Le nom du service
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description du service.
     * 
     * @return La description du service
     */
    public String getDesc() {
        return desc;
    }

    /**
     * D�finit la description du service.
     * 
     * @param desc La description du service
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Retourne l'heure d'ouverture du service.
     * 
     * @return L'heure d'ouverture (0-23)
     */
    public int getHeureOuv() {
        return heureOuv;
    }

    /**
     * D�finit l'heure d'ouverture du service.
     * 
     * @param heureOuv L'heure d'ouverture (0-23)
     */
    public void setHeureOuv(int heureOuv) {
        this.heureOuv = heureOuv;
    }

    /**
     * Retourne l'heure de fermeture du service.
     * 
     * @return L'heure de fermeture (0-23)
     */
    public int getHeureFerm() {
        return heureFerm;
    }

    /**
     * D�finit l'heure de fermeture du service.
     * 
     * @param heureFerm L'heure de fermeture (0-23)
     */
    public void setHeureFerm(int heureFerm) {
        this.heureFerm = heureFerm;
    }
}
/**
 * cette classe a �t� cr�e par @author Maksen Mouhou
 */