package CIUP;

import java.util.ArrayList;

public class CIUP {

	private ArrayList<Maison> listeMaison = new ArrayList<>();
	private ArrayList<Service> listeService = new ArrayList<>();

	public void afficheListeMaison() {
		for (Maison maison : listeMaison) {
			maison.afficheMaison();
		}
	}
	
	public void afficheListeService() {
		for (Service service : listeService) {
			service.afficheService();
		}
	}

	public void ajouterMaison(Maison maison) {
		listeMaison.add(maison);
	}
	public void ajouterService(Service service) {
		listeService.add(service);
	}

	public static void main(String[] args) {
		CIUP ciup = new CIUP();
		MaisonClassique maison1 = new MaisonClassique(1, "Maison des Etudiants Canadiens", "Maison pour les étudiants canadiens", "01 02 03 04 05", "Cité Internationale Universitaire de Paris", "M. Dupont", 1950, 1, 1, 100);
		MaisonInternationale maison2 = new MaisonInternationale(2, "Maison des Etudiants Japonais", "Maison pour les étudiants japonais", "06 07 08 09 10", "Cité Internationale Universitaire de Paris", "M. Suzuki", 1960, 2, 2, 50);
		Service service1 = new Service(1, "Service de restauration", "Service de restauration pour les étudiants", 8, 20);
		Service service2 = new Service(2, "Service de sécurité", "Service de sécurité pour les étudiants", 0, 24);
		maison2.ajoutService(service2);
		maison2.ajoutService(service1);
		ciup.ajouterMaison(maison1);
		ciup.ajouterMaison(maison2);
		ciup.ajouterService(service1);
		ciup.ajouterService(service2);
		ciup.afficheListeMaison();
		ciup.afficheListeService();
	}
}