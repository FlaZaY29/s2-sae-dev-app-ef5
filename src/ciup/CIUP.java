package ciup;

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
            etudiant.afficheInfoResume();
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

        // Maison Internationale & Maisons & Services
        MaisonInternationale mInternationale = FactoryCIUP.creeMaisonInternationale();
        Maison m1 = FactoryCIUP.maisonFrançaise();
        Maison m2 = FactoryCIUP.maisonJaponaise();

        Service s1 = FactoryCIUP.creeServiceRestauration();
        Service s2 = FactoryCIUP.creeServiceSecurite();
        mInternationale.ajoutService(s1);
        mInternationale.ajoutService(s2);

        // Ajouter les Maisons & Services & Etudiants dans CIUP
        ciup.ajouterMaison(mInternationale);
        ciup.ajouterMaison(m1);
        ciup.ajouterMaison(m2);

        ciup.ajouterService(s1);
        ciup.ajouterService(s2);

        // Optionel mais pas fiable : j'ajoute les étudiants
        for (Etudiant etudiant : FactoryCIUP.maisonFrançaise().getListeEtudiant()) {
            ciup.ajouterEtudiant(etudiant);
        }
        for (Etudiant etudiant : FactoryCIUP.maisonJaponaise().getListeEtudiant()) {
            ciup.ajouterEtudiant(etudiant);
        }

        // Affichage toutes les liste dans ciup
        ciup.afficheListeMaison();
        ciup.afficheListeService();
        ciup.afficheListeEtudiant();

    }
}