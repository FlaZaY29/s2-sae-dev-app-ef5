package CIUP;

import java.util.ArrayList;

public class Service {

    // Liste des maisons proposant ce service
    public ArrayList<MaisonInternationale> sesMaison;

    private int num;
    private String nom;
    private String desc;
    private int heureOuv;
    private int heureFerm;

    // Constructeur
    public Service(int num, String nom, String desc, int heureOuv, int heureFerm) {
        this.sesMaison = new ArrayList<MaisonInternationale>();
        this.num = num;
        this.nom = nom;
        this.desc = desc;
        this.heureOuv = heureOuv;
        this.heureFerm = heureFerm;
    }

    // Constructeur vide
    public Service() {
        this.sesMaison = new ArrayList<MaisonInternationale>();
    }

    // Méthode toString
    public String toString() {
        String s = "";
        s += num;
        s += " ; " + nom;
        s += " ; " + desc;
        s += " ; " + heureOuv;
        s += " ; " + heureFerm;
        return s;
    }

    // Méthode pour ajouter un service
    public void ajoutMaison(MaisonInternationale maison) {
        sesMaison.add(maison);
    }

    // Méthode pour supprimer un service
    public void supprMaison(MaisonInternationale maison) {
        sesMaison.remove(maison);
    }

    // Méthode pour afficher le service
    public void afficheService() {
        System.out.println("Numéro Service: " + num);
        System.out.println("Nom Service: " + nom);
        System.out.println("Description: " + desc);
        System.out.println("Heure d'ouverture: " + heureOuv);
        System.out.println("Heure de fermeture: " + heureFerm);
        System.out.println("Maison(s) associee(s): ");
        for (MaisonInternationale maison : sesMaison) {
            System.out.println(maison.getNom());
        }
        System.out.println();
    }

    // Getter et Setter pour les attributs
    public ArrayList<MaisonInternationale> getSesMaison() {
        return sesMaison;
    }

    public void setSesMaison(ArrayList<MaisonInternationale> sesMaison) {
        this.sesMaison = sesMaison;
    }

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

    public int getHeureOuv() {
        return heureOuv;
    }

    public void setHeureOuv(int heureOuv) {
        this.heureOuv = heureOuv;
    }

    public int getHeureFerm() {
        return heureFerm;
    }

    public void setHeureFerm(int heureFerm) {
        this.heureFerm = heureFerm;
    }
}