package CIUP;

import java.util.ArrayList;

public class CIUP {

	private ArrayList<Maison> listeMaison = new ArrayList<>();
	private ArrayList<Service> listeService = new ArrayList<>();
	private ArrayList<Etudiant> listeEtudiant = new ArrayList<>();

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

	public void afficheListeEtudiant() {
		for (Etudiant etudiant : listeEtudiant) {
			etudiant.afficheInfo();
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
		MaisonInternationale mInternationale = Factory.creeMaisonInternationale();
		Maison m1 = Factory.creeMaison();
		Maison m2 = Factory.creeMaison();
		ciup.ajouterMaison(mInternationale);
		ciup.ajouterMaison(m1);
		ciup.ajouterMaison(m2);
		
		ciup.afficheListeMaison();
		ciup.afficheListeService();
	}
}