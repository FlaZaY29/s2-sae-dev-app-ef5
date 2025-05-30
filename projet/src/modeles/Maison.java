package modeles;

import java.io.Serializable;

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
 * <p>
 * Cette classe implémente Serializable pour permettre la sauvegarde des maisons
 * sur le disque dur.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.1
 * @see MaisonClassique
 * @see MaisonInternationale
 */
public abstract class Maison implements Serializable {

    /** Identifiant de version pour la sérialisation */
    private static final long serialVersionUID = 1L;

    /** Num�ro unique d'identification de la maison */
    private int num;
    
    /** Nom de la maison */
    private String nom;
    
    /** Description de la maison */
    private String desc;
    
    /** Num�ro de t�l�phone de la maison */
    private String tel;
    
    /** Localisation g�ographique de la maison */
    private String localisation;
    
    /** Nom du directeur de la maison */
    private String directeur;
    
    /** Ann�e de cr�ation de la maison */
    private int anneeCreation;
    
    /** Date de la f�te annuelle de la maison */
    private String dateFete;
    
    /** Dur�e en jours de la f�te annuelle */
    private int dureeFete;
    
    /** Syst�me de propri�t�s extensible pour stocker des informations additionnelles */
    private java.util.HashMap<String, String> properties = new java.util.HashMap<>();

    /**
     * Constructeur complet pour cr�er une maison avec toutes ses informations.
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
     * Constructeur par d�faut.
     * <p>
     * Cr�e une maison avec des valeurs par d�faut et initialise
     * le syst�me de propri�t�s.
     * </p>
     */
    public Maison() {}

    /**
     * Retourne une repr�sentation textuelle compl�te de la maison.
     * <p>
     * Format : num ; nom ; desc ; tel ; localisation ; directeur ; anneeCreation ; dateFete ; dureeFete
     * </p>
     * 
     * @return Cha�ne de caract�res repr�sentant la maison
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
     * Affiche la description compl�te de la maison sur la console.
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
     * Affichage simplifi� pour les listes.
     * </p>
     */
    public void afficheMaison() {
        System.out.println("Maison: " + nom);
        System.out.println();
    }

    /**
     * D�finit une propri�t� personnalis�e pour la maison.
     * <p>
     * Le syst�me de propri�t�s permet d'ajouter des informations
     * additionnelles sans modifier la structure de la classe.
     * </p>
     * 
     * @param key La cl� de la propri�t�
     * @param value La valeur de la propri�t�
     */
    public void setProperty(String key, String value) {
        if (properties == null) {
            properties = new java.util.HashMap<>();
        }
        properties.put(key, value);
    }
    
    /**
     * R�cup�re une propri�t� personnalis�e de la maison.
     * 
     * @param key La cl� de la propri�t�
     * @return La valeur de la propri�t� ou null si elle n'existe pas
     */
    public String getProperty(String key) {
        if (properties == null) {
            return null;
        }
        return properties.get(key);
    }
    
    /**
     * V�rifie si une propri�t� personnalis�e existe.
     * 
     * @param key La cl� de la propri�t�
     * @return true si la propri�t� existe, false sinon
     */
    public boolean hasProperty(String key) {
        if (properties == null) {
            return false;
        }
        return properties.containsKey(key);
    }

    // Getters et Setters avec documentation

    /**
     * Retourne le num�ro d'identification de la maison.
     * 
     * @return Le num�ro unique d'identification
     */
    public int getNum() {
        return num;
    }

    /**
     * D�finit le num�ro d'identification de la maison.
     * 
     * @param num Le num�ro unique d'identification
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
     * D�finit le nom de la maison.
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
     * D�finit la description de la maison.
     * 
     * @param desc La description de la maison
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Retourne le num�ro de t�l�phone de la maison.
     * 
     * @return Le num�ro de t�l�phone
     */
    public String getTel() {
        return tel;
    }

    /**
     * D�finit le num�ro de t�l�phone de la maison.
     * 
     * @param tel Le num�ro de t�l�phone
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Retourne la localisation de la maison.
     * 
     * @return La localisation g�ographique
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * D�finit la localisation de la maison.
     * 
     * @param localisation La localisation g�ographique
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
     * D�finit le nom du directeur de la maison.
     * 
     * @param directeur Le nom du directeur
     */
    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    /**
     * Retourne l'ann�e de cr�ation de la maison.
     * 
     * @return L'ann�e de cr�ation
     */
    public int getAnneeCreation() {
        return anneeCreation;
    }

    /**
     * D�finit l'ann�e de cr�ation de la maison.
     * 
     * @param anneeCreation L'ann�e de cr�ation
     */
    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    /**
     * Retourne la date de la f�te annuelle.
     * 
     * @return La date de la f�te annuelle
     */
    public String getDateFete() {
        return dateFete;
    }

    /**
     * D�finit la date de la f�te annuelle.
     * 
     * @param dateFete La date de la f�te annuelle
     */
    public void setDateFete(String dateFete) {
        this.dateFete = dateFete;
    }

    /**
     * Retourne la dur�e de la f�te annuelle.
     * 
     * @return La dur�e en jours
     */
    public int getDureeFete() {
        return dureeFete;
    }

    /**
     * D�finit la dur�e de la f�te annuelle.
     * 
     * @param dureeFete La dur�e en jours
     */
    public void setDureeFete(int dureeFete) {
        this.dureeFete = dureeFete;
    }
}
/**
 * cette classe a �t� cr�e par @author Donald Se
 */