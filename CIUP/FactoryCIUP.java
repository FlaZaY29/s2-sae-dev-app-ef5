package CIUP;

import java.util.ArrayList;
import java.util.List;

public class FactoryCIUP {

    private ArrayList<Maison> listeMaisons;  // Liste des maisons
    private ArrayList<Etudiant> listeEtudiants;  // Liste des étudiants
    private ArrayList<Service> listeServices;  // Liste des services


    // Créer une maisonClassique
    public void creeMaison(int num, String nom, String desc, String tel, String localisation, String directeur,
                           int anneeCreation, int dateFete, int dureeFete, int capacite) {
        Maison maison = new MaisonClassique(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete, capacite);
        listeMaisons.add(maison);
    }

    // Créer une maisoninter
    public void creeMaisonInternationale(int num, String nom, String desc, String tel, String localisation, String directeur,
                                         int anneeCreation, int dateFete, int dureeFete, int capacite) {
        MaisonInternationale maison = new MaisonInternationale(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete, capacite);
        listeMaisons.add(maison);

    }

    /*
    // Code manquante
    // Créer un service
    public void creeService(String nomService, MaisonInternationale maison) {
        Service service = new Service(nomService);
        maison.ajouterService(service);
        listeServices.add(service);
       
    }*/

    // Créer un étudiant
    public void creeEtudiant(int num, String nom, String prenom, String adresse, String nationalite, String dateNaissance, String tel, String email, String promotion, String universite, String pieceIdentite) {
        Etudiant etudiant = new Etudiant(num, nom, prenom, adresse, nationalite, dateNaissance, tel, email, promotion, universite, pieceIdentite);
        listeEtudiants.add(etudiant);
    }
}