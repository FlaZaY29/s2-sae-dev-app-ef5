package CIUP;

import java.util.ArrayList;
import java.util.List;

public class FactoryCIUP {

    private List<Maison> listeMaisons;  // Liste des maisons
    private List<Etudiant> listeEtudiants;  // Liste des étudiants
    private List<Service> listeServices;  // Liste des services

    public FactoryCIUP() {
        // Initialisation des listes
        this.listeMaisons = new ArrayList<>();
        this.listeEtudiants = new ArrayList<>();
        this.listeServices = new ArrayList<>();
    }

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