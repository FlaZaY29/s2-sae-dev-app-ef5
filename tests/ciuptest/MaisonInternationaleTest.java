package CIUP;

import java.util.ArrayList;

public class MaisonInternationale extends Maison {

    // Liste des services proposant la Maison Internationale
    private ArrayList<Service> sesServices;

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
        this.tel = tel;
        this.localisation = localisation;
        this.anneeCreation = anneeCreation;
    }

    // Constructeur vide
    public MaisonInternationale() {
        super();
        this.sesServices = new ArrayList<>();
    }

    // Méthode pour ajouter un service à la Maison Internationale
    public void ajoutService(Service service) {
        sesServices.add(service);

        // Ajout de la maison à la liste des maisons proposant ce service
        service.ajoutMaison(this);
    }

    // Méthode pour supprimer un service de la Maison Internationale
    public void supprService(Service service) {
        sesServices.remove(service);

        // Suppression de la maison de la liste des maisons proposant ce service
        service.supprMaison(this);
    }
}