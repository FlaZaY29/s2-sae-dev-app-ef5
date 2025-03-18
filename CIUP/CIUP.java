package CIUP;

import java.util.*;

public class CIUP {

	private ArrayList<Maison> listeMaison;
	private ArrayList<Service> listeService;

	public void afficheListeMaison() {
		for (Maison maison : listeMaison) {
			maison.afficheMaison();
		}
	}

	public void afficheListeService() {
		// TODO - implement CIUP.afficheListeService
		throw new UnsupportedOperationException();
	}

}