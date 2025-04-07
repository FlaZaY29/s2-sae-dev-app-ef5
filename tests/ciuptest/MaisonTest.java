package CIUP;

public class Maison {

    private int num;
    private String nom;
    private String desc;
    private String tel;
    private String localisation;
    private String directeur;
    private int anneeCreation;
    private String dateFete;
    private int dureeFete;

    // Constructeur
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

    //constructeur Vide
    public Maison() {}

    // Méthode toString
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDirecteur() {
        return directeur;
    }

    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    public int getAnneeCreation() {
        return anneeCreation;
    }

    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public String getDateFete() {
        return dateFete;
    }

    public void setDateFete(String dateFete) {
        this.dateFete = dateFete;
    }

    public int getDureeFete() {
        return dureeFete;
    }

    public void setDureeFete(int dureeFete) {
        this.dureeFete = dureeFete;
    }
}