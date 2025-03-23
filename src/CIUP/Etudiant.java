package CIUP;

public class Etudiant {

    private int num;
    private String nom;
    private String prenom;
    private String adresse;
    private String nationalite;
    private String dateNaissance;
    private String tel;
    private String email;
    private String promotion;
    private String universite;
    private String pieceIdentite;
    private boolean actuEtudiant;
    private boolean enAttente;
    private Maison maisonActuelle;

    // Constructeur
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

    // Constructeur vide
    public Etudiant() {}

    // Méthode toString
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
        return s;
    }

    // Affiche les informations des attributs
    public void afficheInfo() {
        System.out.println(toString());
    }

    // Affiche le résumé l'informations
    public void afficheInfoResume() {
        System.out.println(num + " ; " + nom + " ; " + prenom + " ; " + promotion + " ; " + universite);
    }

    // Getter et Setter pour les attributs
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getPieceIdentite() {
        return pieceIdentite;
    }

    public void setPieceIdentite(String pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }

    public boolean isActuEtudiant() {
        return actuEtudiant;
    }

    public void setActuEtudiant(boolean actuEtudiant) {
        this.actuEtudiant = actuEtudiant;
    }

    public boolean isEnAttente() {
        return enAttente;
    }

    public void setEnAttente(boolean enAttente) {
        this.enAttente = enAttente;
    }

    public Maison getMaisonActuelle() {
        return maisonActuelle;
    }

    public void setMaisonActuelle(Maison maisonActuelle) {
        this.maisonActuelle = maisonActuelle;
    }
}