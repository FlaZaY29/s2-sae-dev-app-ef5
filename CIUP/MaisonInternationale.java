package CIUP;

import java.util.ArrayList;
import java.util.List;

public class MaisonInternationale {

	ArrayList<Service> sesServices;
	private String nom;
	private String desc;
	private ArrayList<Etudiant> listeEtudiant;
	private String localisation;
	private int anneeCreation;
	private String tel;

	// Constructeur
    public MaisonInternationale(String nom, String desc, String localisation, int annee, String tel) {
        this.nom = nom;
        this.desc = desc;
        this.localisation = localisation;
        this.anneeCreation = annee;
        this.tel = tel;
        this.sesServices = new ArrayList<>();
        this.listeEtudiant = new ArrayList<>();
    }

    // Méthode pour ajouter un service à la Maison Internationale
    public void ajoutService(Service service) {
        sesServices.add(service);
    }

    // Méthode pour ajouter un étudiant
    public void ajoutEtudiant(Etudiant etu) {
        listeEtudiant.add(etu);
    }

    // Méthode pour afficher les informations de la Maison Internationale
    public void afficheDesc() {
        System.out.println("Maison Internationale: " + nom);
        System.out.println("Description: " + desc);
        System.out.println("Localisation: " + localisation);
        System.out.println("Année de création: " + anneeCreation);
        System.out.println("Téléphone: " + tel);
    }

    // Méthode pour afficher les services proposés
    public void afficherServices() {
        System.out.println("Services proposés par la Maison Internationale:");
        for (Service service : sesServices) {
            System.out.println(service.getNom() + ": " + service.getDescription());
        }
    }

    // Méthode pour afficher la liste des étudiants
    public void afficherEtudiants() {
        System.out.println("Liste des étudiants dans la Maison Internationale:");
        for (Etudiant etu : listeEtudiant) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    // Getter et Setter pour les attributs
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

    public List<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }

    public void setListeEtudiant(ArrayList<Etudiant> listeEtu) {
        this.listeEtudiant = listeEtu;
    }
	

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getAnneeCreation() {
        return anneeCreation;
    }

    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

	public ArrayList<Service> getSesServices() {
		return sesServices;
	}

	public void setSesServices(ArrayList<Service> sesServices) {
		this.sesServices = sesServices;
	}
}