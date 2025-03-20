package CIUP;

import java.util.ArrayList;
import java.util.List;

public class MaisonInternationale extends Maison {

	ArrayList<Service> sesServices;
	private String nom;
	private String desc;
	private String localisation;
	private int anneeCreation;
	private String tel;

	// Constructeur
    public MaisonInternationale(int num, String nom, String desc, String tel, String localisation, String directeur,
								int anneeCreation, String dateFete, int dureeFete) {
		super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
		this.nom = nom;
		this.desc = desc;
		this.localisation = localisation;
		this.anneeCreation = anneeCreation;
		this.tel = tel;

	}
    //constructeur vide
    public MaisonInternationale() {
    }

    // Méthode pour ajouter un service à la Maison Internationale
    public void ajoutService(Service service) {
        sesServices.add(service);
        service.ajoutMaison(this);  // Ajout de la maison à la liste des maisons proposant ce service
    }

    // Méthode pour supprimer un service de la Maison Internationale
    public void supprService(Service service) {
        sesServices.remove(service);
        service.supprMaison(this);  // Suppression de la maison de la liste des maisons proposant ce service
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
            System.out.println(service.getNom() + ": " + service.getDesc());
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