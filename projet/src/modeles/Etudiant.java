package modeles;

import java.io.Serializable;

/**
 * Classe représentant un étudiant dans le système CIUP.
 * <p>
 * Cette classe modélise toutes les informations relatives à un étudiant :
 * informations personnelles, académiques, statut d'inscription et affectation
 * à une maison. Elle gère également les états particuliers comme l'attente
 * d'affectation.
 * </p>
 * <p>
 * Cette classe implémente Serializable pour permettre la sauvegarde des étudiants
 * sur le disque dur.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.1
 * @see Maison
 * @see MaisonClassique
 */
public class Etudiant implements Serializable {

    /** Identifiant de version pour la sérialisation */
    private static final long serialVersionUID = 1L;
    /** Num�ro unique d'identification de l'�tudiant */
    private int num;
    
    /** Nom de famille de l'�tudiant */
    private String nom;
    
    /** Pr�nom de l'�tudiant */
    private String prenom;
    
    /** Adresse de r�sidence de l'�tudiant */
    private String adresse;
    
    /** Nationalit� de l'�tudiant */
    private String nationalite;
    
    /** Date de naissance de l'�tudiant (format String) */
    private String dateNaissance;
    
    /** Num�ro de t�l�phone de l'�tudiant */
    private String tel;
    
    /** Adresse email de l'�tudiant */
    private String email;
    
    /** Promotion ou classe de l'�tudiant */
    private String promotion;
    
    /** Universit� d'origine de l'�tudiant */
    private String universite;
    
    /** R�f�rence du document d'identit� */
    private String pieceIdentite;
    
    /** Indique si l'�tudiant est actuellement en p�riode d'�tudes */
    private boolean actuEtudiant;
    
    /** Indique si l'�tudiant est en liste d'attente */
    private boolean enAttente;
    
    /** Maison � laquelle l'�tudiant est actuellement affect� */
    private Maison maisonActuelle;

    /**
     * Constructeur complet pour cr�er un �tudiant avec toutes ses informations.
     * <p>
     * Initialise un �tudiant avec le statut par d�faut : actuellement �tudiant,
     * non en attente, et sans affectation de maison.
     * </p>
     * 
     * @param num Num�ro unique d'identification
     * @param nom Nom de famille
     * @param prenom Pr�nom
     * @param adresse Adresse de r�sidence
     * @param nationalite Nationalit�
     * @param dateNaissance Date de naissance
     * @param tel Num�ro de t�l�phone
     * @param email Adresse email
     * @param promotion Promotion ou classe
     * @param universite Universit� d'origine
     * @param pieceIdentite R�f�rence du document d'identit�
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
     * Constructeur par d�faut.
     * <p>
     * Cr�e un �tudiant avec des valeurs par d�faut.
     * Utilis� principalement pour l'instanciation avant initialisation des champs.
     * </p>
     */
    public Etudiant() {}

    /**
     * Retourne une repr�sentation textuelle compl�te de l'�tudiant.
     * <p>
     * Format : num ; nom ; prenom ; adresse ; nationalite ; dateNaissance ; tel ; email ; promotion ; universite ; pieceIdentite ; actuEtudiant ; enAttente ; maisonActuelle
     * </p>
     * 
     * @return Cha�ne de caract�res repr�sentant l'�tudiant
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
     * Affiche toutes les informations de l'�tudiant sur la console.
     * <p>
     * Utilise la m�thode toString() pour afficher les informations compl�tes.
     * </p>
     */
    public void afficheInfo() {
        System.out.println(toString());
    }

    /**
     * Affiche un r�sum� des informations principales de l'�tudiant.
     * <p>
     * Format d'affichage : num ; nom ; prenom ; promotion ; universite
     * </p>
     */
    public void afficheInfoResume() {
        System.out.println(num + " ; " + nom + " ; " + prenom + " ; " + promotion + " ; " + universite);
    }

    // Getters et Setters avec documentation

    /**
     * Retourne le num�ro d'identification de l'�tudiant.
     * 
     * @return Le num�ro unique d'identification
     */
    public int getNum() {
        return num;
    }

    /**
     * D�finit le num�ro d'identification de l'�tudiant.
     * 
     * @param num Le num�ro unique d'identification
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Retourne le nom de famille de l'�tudiant.
     * 
     * @return Le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * D�finit le nom de famille de l'�tudiant.
     * 
     * @param nom Le nom de famille
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le pr�nom de l'�tudiant.
     * 
     * @return Le pr�nom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * D�finit le pr�nom de l'�tudiant.
     * 
     * @param prenom Le pr�nom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne l'adresse de r�sidence de l'�tudiant.
     * 
     * @return L'adresse de r�sidence
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * D�finit l'adresse de r�sidence de l'�tudiant.
     * 
     * @param adresse L'adresse de r�sidence
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Retourne la nationalit� de l'�tudiant.
     * 
     * @return La nationalit�
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * D�finit la nationalit� de l'�tudiant.
     * 
     * @param nationalite La nationalit�
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * Retourne la date de naissance de l'�tudiant.
     * 
     * @return La date de naissance (format String)
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * D�finit la date de naissance de l'�tudiant.
     * 
     * @param dateNaissance La date de naissance
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne le num�ro de t�l�phone de l'�tudiant.
     * 
     * @return Le num�ro de t�l�phone
     */
    public String getTel() {
        return tel;
    }

    /**
     * D�finit le num�ro de t�l�phone de l'�tudiant.
     * 
     * @param tel Le num�ro de t�l�phone
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Retourne l'adresse email de l'�tudiant.
     * 
     * @return L'adresse email
     */
    public String getEmail() {
        return email;
    }

    /**
     * D�finit l'adresse email de l'�tudiant.
     * 
     * @param email L'adresse email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retourne la promotion de l'�tudiant.
     * 
     * @return La promotion ou classe
     */
    public String getPromotion() {
        return promotion;
    }

    /**
     * D�finit la promotion de l'�tudiant.
     * 
     * @param promotion La promotion ou classe
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * Retourne l'universit� d'origine de l'�tudiant.
     * 
     * @return L'universit� d'origine
     */
    public String getUniversite() {
        return universite;
    }

    /**
     * D�finit l'universit� d'origine de l'�tudiant.
     * 
     * @param universite L'universit� d'origine
     */
    public void setUniversite(String universite) {
        this.universite = universite;
    }

    /**
     * Retourne la r�f�rence du document d'identit�.
     * 
     * @return La r�f�rence du document d'identit�
     */
    public String getPieceIdentite() {
        return pieceIdentite;
    }

    /**
     * D�finit la r�f�rence du document d'identit�.
     * 
     * @param pieceIdentite La r�f�rence du document d'identit�
     */
    public void setPieceIdentite(String pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }

    /**
     * Indique si l'�tudiant est actuellement en p�riode d'�tudes.
     * 
     * @return true si l'�tudiant est actuellement �tudiant, false sinon
     */
    public boolean isActuEtudiant() {
        return actuEtudiant;
    }

    /**
     * D�finit le statut d'�tudiant actuel.
     * 
     * @param actuEtudiant true si l'�tudiant est actuellement �tudiant
     */
    public void setActuEtudiant(boolean actuEtudiant) {
        this.actuEtudiant = actuEtudiant;
    }

    /**
     * Indique si l'�tudiant est en liste d'attente.
     * 
     * @return true si l'�tudiant est en attente, false sinon
     */
    public boolean isEnAttente() {
        return enAttente;
    }

    /**
     * D�finit le statut d'attente de l'�tudiant.
     * 
     * @param enAttente true si l'�tudiant est en attente
     */
    public void setEnAttente(boolean enAttente) {
        this.enAttente = enAttente;
    }

    /**
     * Retourne la maison actuellement affect�e � l'�tudiant.
     * 
     * @return La maison actuelle ou null si aucune affectation
     */
    public Maison getMaisonActuelle() {
        return maisonActuelle;
    }

    /**
     * D�finit la maison affect�e � l'�tudiant.
     * 
     * @param maisonActuelle La maison � affecter
     */
    public void setMaisonActuelle(Maison maisonActuelle) {
        this.maisonActuelle = maisonActuelle;
    }
}
/**
* cette classe a �t� cr�e par @author Flavio Zamperlini
*/