package CIUP;

import java.util.ArrayList;

public class CIUP {

    private ArrayList<Maison> listeMaison;
    private ArrayList<Service> listeService;

    // Constructeur
    public CIUP() {
        listeMaison = new ArrayList<>();
        listeService = new ArrayList<>();
    }

    // Méthode pour afficher la liste des maisons
    public void afficheListeMaison() {
        for (Maison maison : listeMaison) {
            maison.afficheDesc();
        }
    }

    // Méthode pour afficher la liste des services
    public void afficheListeService() {
        for (Service service : listeService) {
            System.out.println("Service: " + service.getNom());
        }
    }

    // Ajouter une maison à la liste
    public void ajouterMaison(Maison maison) {
        listeMaison.add(maison);
    }

    // Ajouter un service à la liste
    public void ajouterService(Service service) {
        listeService.add(service);
    }
}