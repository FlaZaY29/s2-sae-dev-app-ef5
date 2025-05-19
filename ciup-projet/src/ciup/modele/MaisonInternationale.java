package modele;

import java.util.ArrayList;

public class MaisonInternationale extends Maison {

    // Liste des services proposant la Maison Internationale
    private ArrayList<Service> sesServices;


    // Constructeur
    public MaisonInternationale(int num, String nom, String desc, String tel, String localisation, String directeur,
                                int anneeCreation, String dateFete, int dureeFete) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
    }

    // Constructeur vide
    public MaisonInternationale() {
        super();
        this.sesServices = new ArrayList<>();
    }

    // Methode pour ajouter un service a la Maison Internationale
    public void ajoutService(Service service) {
        sesServices.add(service);

        // Ajout de la maison a la liste des maisons proposant ce service
        service.ajoutMaison(this);
    }

    // Methode pour supprimer un service de la Maison Internationale
    public void supprService(Service service) {
        sesServices.remove(service);

        // Suppression de la maison de la liste des maisons proposant ce service
        service.supprMaison(this);
    }

    // Methode pour afficher les services proposes
    public void afficheServices() {
        System.out.println("Services proposes par la Maison Internationale:");

        for (Service service : sesServices) {
            System.out.println(service.getNom() + ": " + service.getDesc());
        }
    }

    public ArrayList<Service> getSesServices() {
        return sesServices;
    }
}
