package CIUP;

import java.util.ArrayList;

public class CIUP {

    private ArrayList<Maison> listeMaison = new ArrayList<>();
    private ArrayList<Service> listeService = new ArrayList<>();
    private ArrayList<Etudiant> listeEtudiant = new ArrayList<>();

    // Affiche la liste des Maisons
    public void afficheListeMaison() {
        for (Maison maison : listeMaison) {
            maison.afficheMaison();
        }
    }

    // Affiche la liste des Services
    public void afficheListeService() {
        for (Service service : listeService) {
            service.afficheService();
        }
    }

    // Affiche la liste des Etudiants
    public void afficheListeEtudiant() {
        for (Etudiant etudiant : listeEtudiant) {
            etudiant.afficheInfo();
        }
    }

    // Méthode pour ajouter une Maison
    public void ajouterMaison(Maison maison) {
        listeMaison.add(maison);
    }

    // Méthode pour ajouter un service
    public void ajouterService(Service service) {
        listeService.add(service);
    }

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant(Etudiant etudiant) {
        listeEtudiant.add(etudiant);
    }

    public static void main(String[] args) {
        CIUP ciup = new CIUP();

        // Maison Internationale & Maisons
        MaisonInternationale mInternationale = FactoryCIUP.creeMaisonInternationale();
        Maison m1 = FactoryCIUP.maisonFrançaise();
        Maison m2 = FactoryCIUP.maisonJaponaise();

        // Affichage description des maisons
        /*m1.afficheDesc();
        m2.afficheDesc();*/

        // Ajouter les Maisons et Etudiants dans CIUP
        ciup.ajouterMaison(mInternationale);
        ciup.ajouterMaison(m1);
        ciup.ajouterMaison(m2);
        // ciup.ajouterEtudiant(FactoryCIUP.creeEtudiant());

        // Affichage de ciup
        ciup.afficheListeMaison();
        ciup.afficheListeService();
        // ciup.afficheListeEtudiant();


    }
}