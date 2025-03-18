package CIUP;

import java.util.*;

public class Service {

	Collection<MaisonInternationale> saMaison;
	private int num;
	private String nom;
	private String desc;
	private int heureOuv;
	private int heureFerm;

	// Constructeur
	public Service(int num, String nom, String desc, int heureOuv, int heureFerm) {
		this.num = num;
		this.nom = nom;
		this.desc = desc;
		this.heureOuv = heureOuv;
		this.heureFerm = heureFerm;
		this.saMaison = new ArrayList<>();
	}

	// Méthode pour ajouter un service
	public void ajoutService(MaisonInternationale maison) {
		saMaison.add(maison);
	}

	// Méthode pour supprimer un service
	public void supprService(MaisonInternationale maison) {
		saMaison.remove(maison);
	}

	// Getter pour le nom du service
	public String getNom() {
		return nom;
	}

	// Setter pour le nom du service
	public void setNom(String nom) {
		this.nom = nom;
	}
}