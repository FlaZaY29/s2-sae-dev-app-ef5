package modeles;

/**
 * Classe abstraite représentant une maison dans le système CIUP.
 * <p>
 * Cette classe constitue la base pour tous les types de maisons de la CIUP.
 * Elle définit les propriétés communes à toutes les maisons : informations
 * administratives, coordonnées, et événements. Elle utilise également un
 * système de propriétés extensible pour stocker des informations additionnelles.
 * </p>
 * <p>
 * Les classes dérivées doivent implémenter les spécificités de chaque type
 * de maison (classique, internationale).
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see MaisonClassique
 * @see MaisonInternationale
 */
public abstract class Maison {

    /** Numéro unique d'identification de la maison */
    private int num;
    
    /** Nom de la maison */
    private String nom;
    
    /** Description de la maison */
    private String desc;
    
    /** Numéro de téléphone de la maison */
    private String tel;
    
    /** Localisation géographique de la maison */
    private String localisation;
    
    /** Nom du directeur de la maison */
    private String directeur;
    
    /** Année de création de la maison */
    private int anneeCreation;
    
    /** Date de la fête annuelle de la maison */
    private String dateFete;
    
    /** Durée en jours de la fête annuelle */
    private int dureeFete;
    
    /** Système de propriétés extensible pour stocker des informations additionnelles */
    private java.util.HashMap<String, String> properties = new java.util.HashMap<>();

    /**
     * Constructeur complet pour créer une maison avec toutes ses informations.
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
    public Maison(int num, String nom, String desc, String tel, String localisation, String directeur,
                  int anneeCreation, String dateFete, int dureeFete) {
        this.num = num;
        this.nom = nom;
        this.desc = desc;
        this.tel = tel;
        this.localisation = localisation;
        this.directeur = directeur;
        this.anneeCreation = anneeCreation;
        this.dateFete = dateFete;
        this.dureeFete = dureeFete;
    }

    /**
     * Constructeur par défaut.
     * <p>
     * Crée une maison avec des valeurs par défaut et initialise
     * le système de propriétés.
     * </p>
     */
    public Maison() {}

    /**
     * Retourne une représentation textuelle complète de la maison.
     * <p>
     * Format : num ; nom ; desc ; tel ; localisation ; directeur ; anneeCreation ; dateFete ; dureeFete
     * </p>
     * 
     * @return Chaîne de caractères représentant la maison
     */
    public String toString() {
        String s = "";
        s += num;
        s += " ; " + nom;
        s += " ; " + desc;
        s += " ; " + tel;
        s += " ; " + localisation;
        s += " ; " + directeur;
        s += " ; " + anneeCreation;
        s += " ; " + dateFete;
        s += " ; " + dureeFete;
        return s;
    }

    /**
     * Affiche la description complète de la maison sur la console.
     * <p>
     * Affiche toutes les informations de la maison dans un format lisible.
     * </p>
     */
    public void afficheDesc() {
        System.out.println("Maison: " + nom);
        System.out.println("Description: " + desc);
        System.out.println("Telephone: " + tel);
        System.out.println("Localisation: " + localisation);
        System.out.println("Directeur: " + directeur);
        System.out.println("Annee de creation: " + anneeCreation);
        System.out.println("Date de la fete: " + dateFete);
        System.out.println("Duree de la fete: " + dureeFete + " jours");
        System.out.println();
    }

    /**
     * Affiche le nom de la maison sur la console.
     * <p>
     * Affichage simplifié pour les listes.
     * </p>
     */
    public void afficheMaison() {
        System.out.println("Maison: " + nom);
        System.out.println();
    }

    /**
     * Définit une propriété personnalisée pour la maison.
     * <p>
     * Le système de propriétés permet d'ajouter des informations
     * additionnelles sans modifier la structure de la classe.
     * </p>
     * 
     * @param key La clé de la propriété
     * @param value La valeur de la propriété
     */
    public void setProperty(String key, String value) {
        if (properties == null) {
            properties = new java.util.HashMap<>();
        }
        properties.put(key, value);
    }
    
    /**
     * Récupère une propriété personnalisée de la maison.
     * 
     * @param key La clé de la propriété
     * @return La valeur de la propriété ou null si elle n'existe pas
     */
    public String getProperty(String key) {
        if (properties == null) {
            return null;
        }
        return properties.get(key);
    }
    
    /**
     * Vérifie si une propriété personnalisée existe.
     * 
     * @param key La clé de la propriété
     * @return true si la propriété existe, false sinon
     */
    public boolean hasProperty(String key) {
        if (properties == null) {
            return false;
        }
        return properties.containsKey(key);
    }

    // Getters et Setters avec documentation

    /**
     * Retourne le numéro d'identification de la maison.
     * 
     * @return Le numéro unique d'identification
     */
    public int getNum() {
        return num;
    }

    /**
     * Définit le numéro d'identification de la maison.
     * 
     * @param num Le numéro unique d'identification
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Retourne le nom de la maison.
     * 
     * @return Le nom de la maison
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la maison.
     * 
     * @param nom Le nom de la maison
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description de la maison.
     * 
     * @return La description de la maison
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Définit la description de la maison.
     * 
     * @param desc La description de la maison
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Retourne le numéro de téléphone de la maison.
     * 
     * @return Le numéro de téléphone
     */
    public String getTel() {
        return tel;
    }

    /**
     * Définit le numéro de téléphone de la maison.
     * 
     * @param tel Le numéro de téléphone
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Retourne la localisation de la maison.
     * 
     * @return La localisation géographique
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * Définit la localisation de la maison.
     * 
     * @param localisation La localisation géographique
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    /**
     * Retourne le nom du directeur de la maison.
     * 
     * @return Le nom du directeur
     */
    public String getDirecteur() {
        return directeur;
    }

    /**
     * Définit le nom du directeur de la maison.
     * 
     * @param directeur Le nom du directeur
     */
    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    /**
     * Retourne l'année de création de la maison.
     * 
     * @return L'année de création
     */
    public int getAnneeCreation() {
        return anneeCreation;
    }

    /**
     * Définit l'année de création de la maison.
     * 
     * @param anneeCreation L'année de création
     */
    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    /**
     * Retourne la date de la fête annuelle.
     * 
     * @return La date de la fête annuelle
     */
    public String getDateFete() {
        return dateFete;
    }

    /**
     * Définit la date de la fête annuelle.
     * 
     * @param dateFete La date de la fête annuelle
     */
    public void setDateFete(String dateFete) {
        this.dateFete = dateFete;
    }

    /**
     * Retourne la durée de la fête annuelle.
     * 
     * @return La durée en jours
     */
    public int getDureeFete() {
        return dureeFete;
    }

    /**
     * Définit la durée de la fête annuelle.
     * 
     * @param dureeFete La durée en jours
     */
    public void setDureeFete(int dureeFete) {
        this.dureeFete = dureeFete;
    }
}
/**
 * cette classe a été crée par @author Donald Se
 */