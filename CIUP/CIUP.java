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
}