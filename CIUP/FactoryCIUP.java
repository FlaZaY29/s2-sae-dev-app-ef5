package CIUP;

import java.util.ArrayList;
import java.util.List;

public class FactoryCIUP {

    private ArrayLis<Maison> listeMaisons;  // Liste des maisons
    private ArrayLis<Etudiant> listeEtudiants;  // Liste des étudiants
    private ArrayLis<Service> listeServices;  // Liste des services



    // Créer une maisonClassique
    public void creeMaison(String nom, String nationalite, String directeur, String localisationGPS, int nbChambres) {
        Maison maison = new MaisonClassique(nom, nationalite, directeur, localisationGPS, nbChambres);
        listeMaisons.add(maison);
	}

    // Créer une maisoninter
    public void creeMaisonInternationale(String nom, String nationalite, String directeur, String localisationGPS, int nbChambres) {
        MaisonInternationale maison = new MaisonInternationale(nom, nationalite, directeur, localisationGPS, nbChambres);
        listeMaisons.add(maison);
     
    }

    // Créer un service 
    public void creeService(String nomService, MaisonInternationale maison) {
        Service service = new Service(nomService);
        maison.ajouterService(service);
        listeServices.add(service);
       
    }

    // Créer un étudiant
    public void creeEtudiant(String nom, String nationalite) {
        Etudiant etudiant = new Etudiant(nom, nationalite);
        listeEtudiants.add(etudiant);
      
    }