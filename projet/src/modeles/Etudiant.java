package modeles;

/**
 * Classe représentant un étudiant dans le système CIUP.
 * <p>
 * Cette classe modélise toutes les informations relatives à un étudiant :
 * informations personnelles, académiques, statut d'inscription et affectation
 * à une maison. Elle gère également les états particuliers comme l'attente
 * d'affectation.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Maison
 * @see MaisonClassique
 */
public class Etudiant {

    /** Numéro unique d'identification de l'étudiant */
    private int num;
    
    /** Nom de famille de l'étudiant */
    private String nom;
    
    /** Prénom de l'étudiant */
    private String prenom;
    
    /** Adresse de résidence de l'étudiant */
    private String adresse;
    
    /** Nationalité de l'étudiant */
    private String nationalite;
    
    /** Date de naissance de l'étudiant (format String) */
    private String dateNaissance;
    
    /** Numéro de téléphone de l'étudiant */
    private String tel;
    
    /** Adresse email de l'étudiant */
    private String email;
    
    /** Promotion ou classe de l'étudiant */
    private String promotion;
    
    /** Université d'origine de l'étudiant */
    private String universite;
    
    /** Référence du document d'identité */
    private String pieceIdentite;
    
    /** Indique si l'étudiant est actuellement en période d'études */
    private boolean actuEtudiant;
    
    /** Indique si l'étudiant est en liste d'attente */
    private boolean enAttente;
    
    /** Maison à laquelle l'étudiant est actuellement affecté */
    private Maison maisonActuelle;

    /**
     * Constructeur complet pour créer un étudiant avec toutes ses informations.
     * <p>
     * Initialise un étudiant avec le statut par défaut : actuellement étudiant,
     * non en attente, et sans affectation de maison.
     * </p>
     * 
     * @param num Numéro unique d'identification
     * @param nom Nom de famille
     * @param prenom Prénom
     * @param adresse Adresse de résidence
     * @param nationalite Nationalité
     * @param dateNaissance Date de naissance
     * @param tel Numéro de téléphone
     * @param email Adresse email
     * @param promotion Promotion ou classe
     * @param universite Université d'origine
     * @param pieceIdentite Référence du document d'identité
     */
    public Etudiant(int num, String nom, String prenom, String adresse, String nationalite, String dateNaissance, String tel, String email, String promotion, String universite, String pieceIdentite) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.nationalite = nationalite;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
        this.email = email;
        this.promotion = promotion;
        this.universite = universite;
        this.pieceIdentite = pieceIdentite;
        this.actuEtudiant = true; // l'etudiant est actuellement dans sa periode d'etude
        this.maisonActuelle = null; // l'etudiant n'est pas encore affecte a une maison
        this.enAttente = false; // l'etudiant n'est pas en attente
    }

    /**
     * Constructeur par défaut.
     * <p>
     * Crée un étudiant avec des valeurs par défaut.
     * Utilisé principalement pour l'instanciation avant initialisation des champs.
     * </p>
     */
    public Etudiant() {}

    /**
     * Retourne une représentation textuelle complète de l'étudiant.
     * <p>
     * Format : num ; nom ; prenom ; adresse ; nationalite ; dateNaissance ; tel ; email ; promotion ; universite ; pieceIdentite ; actuEtudiant ; enAttente ; maisonActuelle
     * </p>
     * 
     * @return Chaîne de caractères représentant l'étudiant
     */
    public String toString() {
        String s = "";
        s += num;
        s += " ; " + nom;
        s += " ; " + prenom;
        s += " ; " + adresse;
        s += " ; " + nationalite;
        s += " ; " + dateNaissance;
        s += " ; " + tel;
        s += " ; " + email;
        s += " ; " + promotion;
        s += " ; " + universite;
        s += " ; " + pieceIdentite;
        s += " ; " + actuEtudiant;
        s += " ; " + enAttente;
        s += " ; " + maisonActuelle;
        return s;
    }

    /**
     * Affiche toutes les informations de l'étudiant sur la console.
     * <p>
     * Utilise la méthode toString() pour afficher les informations complètes.
     * </p>
     */
    public void afficheInfo() {
        System.out.println(toString());
    }

    /**
     * Affiche un résumé des informations principales de l'étudiant.
     * <p>
     * Format d'affichage : num ; nom ; prenom ; promotion ; universite
     * </p>
     */
    public void afficheInfoResume() {
        System.out.println(num + " ; " + nom + " ; " + prenom + " ; " + promotion + " ; " + universite);
    }

    // Getters et Setters avec documentation

    /**
     * Retourne le numéro d'identification de l'étudiant.
     * 
     * @return Le numéro unique d'identification
     */
    public int getNum() {
        return num;
    }

    /**
     * Définit le numéro d'identification de l'étudiant.
     * 
     * @param num Le numéro unique d'identification
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Retourne le nom de famille de l'étudiant.
     * 
     * @return Le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de famille de l'étudiant.
     * 
     * @param nom Le nom de famille
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom de l'étudiant.
     * 
     * @return Le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de l'étudiant.
     * 
     * @param prenom Le prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne l'adresse de résidence de l'étudiant.
     * 
     * @return L'adresse de résidence
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit l'adresse de résidence de l'étudiant.
     * 
     * @param adresse L'adresse de résidence
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Retourne la nationalité de l'étudiant.
     * 
     * @return La nationalité
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * Définit la nationalité de l'étudiant.
     * 
     * @param nationalite La nationalité
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * Retourne la date de naissance de l'étudiant.
     * 
     * @return La date de naissance (format String)
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Définit la date de naissance de l'étudiant.
     * 
     * @param dateNaissance La date de naissance
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne le numéro de téléphone de l'étudiant.
     * 
     * @return Le numéro de téléphone
     */
    public String getTel() {
        return tel;
    }

    /**
     * Définit le numéro de téléphone de l'étudiant.
     * 
     * @param tel Le numéro de téléphone
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Retourne l'adresse email de l'étudiant.
     * 
     * @return L'adresse email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse email de l'étudiant.
     * 
     * @param email L'adresse email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retourne la promotion de l'étudiant.
     * 
     * @return La promotion ou classe
     */
    public String getPromotion() {
        return promotion;
    }

    /**
     * Définit la promotion de l'étudiant.
     * 
     * @param promotion La promotion ou classe
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * Retourne l'université d'origine de l'étudiant.
     * 
     * @return L'université d'origine
     */
    public String getUniversite() {
        return universite;
    }

    /**
     * Définit l'université d'origine de l'étudiant.
     * 
     * @param universite L'université d'origine
     */
    public void setUniversite(String universite) {
        this.universite = universite;
    }

    /**
     * Retourne la référence du document d'identité.
     * 
     * @return La référence du document d'identité
     */
    public String getPieceIdentite() {
        return pieceIdentite;
    }

    /**
     * Définit la référence du document d'identité.
     * 
     * @param pieceIdentite La référence du document d'identité
     */
    public void setPieceIdentite(String pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }

    /**
     * Indique si l'étudiant est actuellement en période d'études.
     * 
     * @return true si l'étudiant est actuellement étudiant, false sinon
     */
    public boolean isActuEtudiant() {
        return actuEtudiant;
    }

    /**
     * Définit le statut d'étudiant actuel.
     * 
     * @param actuEtudiant true si l'étudiant est actuellement étudiant
     */
    public void setActuEtudiant(boolean actuEtudiant) {
        this.actuEtudiant = actuEtudiant;
    }

    /**
     * Indique si l'étudiant est en liste d'attente.
     * 
     * @return true si l'étudiant est en attente, false sinon
     */
    public boolean isEnAttente() {
        return enAttente;
    }

    /**
     * Définit le statut d'attente de l'étudiant.
     * 
     * @param enAttente true si l'étudiant est en attente
     */
    public void setEnAttente(boolean enAttente) {
        this.enAttente = enAttente;
    }

    /**
     * Retourne la maison actuellement affectée à l'étudiant.
     * 
     * @return La maison actuelle ou null si aucune affectation
     */
    public Maison getMaisonActuelle() {
        return maisonActuelle;
    }

    /**
     * Définit la maison affectée à l'étudiant.
     * 
     * @param maisonActuelle La maison à affecter
     */
    public void setMaisonActuelle(Maison maisonActuelle) {
        this.maisonActuelle = maisonActuelle;
    }
}
/**
* cette classe a été crée par @author Flavio Zamperlini
*/