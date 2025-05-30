package modeles;

import java.util.ArrayList;

/**
 * Classe principale du modèle représentant la Cité Internationale Universitaire de Paris
 * Gère les collections de maisons, services et étudiants
 */
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

    // Méthode pour supprimer une Maison
    public void supprMaison(Maison maison) {
        listeMaison.remove(maison);
    }

    // Méthode pour ajouter un service
    public void ajouterService(Service service) {
        listeService.add(service);
    }

    // Méthode pour supprimer un service
    public void supprService(Service service) {
        listeService.remove(service);
    }

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant(Etudiant etudiant) {
        listeEtudiant.add(etudiant);
    }

    // Méthode pour supprimer un étudiant
    public void supprEtudiant(Etudiant etudiant) {
        listeEtudiant.remove(etudiant);
    }

    // Méthode pour rechercher une maison par nom
    public Maison rechercherMaisonParNom(String nom) {
        for (Maison maison : listeMaison) {
            if (maison.getNom().equalsIgnoreCase(nom)) {
                return maison;
            }
        }
        return null;
    }

    // Méthode pour rechercher un étudiant par nom et prénom
    public Etudiant rechercherEtudiantParNomPrenom(String nom, String prenom) {
        for (Etudiant etudiant : listeEtudiant) {
            if (etudiant.getNom().equalsIgnoreCase(nom) && etudiant.getPrenom().equalsIgnoreCase(prenom)) {
                return etudiant;
            }
        }
        return null;
    }

    public ArrayList<Maison> getListeMaison() {
        return listeMaison;
    }

    public ArrayList<Service> getListeService() {
        return listeService;
    }

    public ArrayList<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }
}
