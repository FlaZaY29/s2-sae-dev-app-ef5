package ciuptest;

import ciup.MaisonClassique;

import java.util.ArrayList;

import ciup.Etudiant;

public class MaisonClassiqueTest {

    // Test de la classe MaisonClassique
    public static void runTests() {
        
        System.out.println("\nMaisonClassiqueTest :");

        // Ajout et suppression d'etudiants
        testAjoutEtudiantSousCapacite();
        testAjoutEtudiantDepasseCapacite();
        testSupprEtudiant();
        testSupressionEtudiantInexistant();

        // Ajout et suppression d'etudiants en attente
        testSupprEtudiantAvecAttente();
        testAjoutEtudiantAttente();
        testSupprEtudiantAttente();
        
        System.out.println("\tMaisonClassiqueTest : Tous les tests sont passes.");
    }

    // Methode de test pour l'ajout d'etudiants
    private static void testAjoutEtudiantSousCapacite() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(2);
        Etudiant e1 = new Etudiant(1, "Jean", "Martin", "", "", "", "", "", "", "", "");
        Etudiant e2 = new Etudiant(2, "Claire", "Durand", "", "", "", "", "", "", "", "");

        maison.ajoutEtudiant(e1);
        maison.ajoutEtudiant(e2);

        assert (maison.getListeEtudiant().size() == 2) : "Les etudiants n'ont pas ete ajoutes correctement";
        assert (!e1.isEnAttente() && e1.isActuEtudiant()) : "Etat d'etudiant incorrect apres ajout";
        System.out.println("\t[OK] testAjoutEtudiantSousCapacite passe.");
    }

    // Methode de test pour l'ajout d'etudiants depassant la capacite
    private static void testAjoutEtudiantDepasseCapacite() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(1);
        Etudiant e1 = new Etudiant(1, "Jean", "Martin", "", "", "", "", "", "", "", "");
        Etudiant e2 = new Etudiant(2, "Claire", "Durand", "", "", "", "", "", "", "", "");

        maison.ajoutEtudiant(e1);
        maison.ajoutEtudiant(e2);

        assert (maison.getListeEtudiant().size() == 1) : "Capacite depassee mais etudiant ajoute quand meme";
        assert (maison.getListeAttente().contains(e2)) : "etudiant non ajoute a la liste d'attente";
        assert (e2.isEnAttente()) : "Statut en attente incorrect pour l'etudiant";
        System.out.println("\t[OK] testAjoutEtudiantDepasseCapacite passe.");
    }

    // Methode de test pour la suppression d'etudiants
    private static void testSupprEtudiant() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(2);
        Etudiant e1 = new Etudiant(1, "Jean", "Martin", "", "", "", "", "", "", "", "");

        maison.ajoutEtudiant(e1);
        maison.supprEtudiant(e1);

        assert (maison.getListeEtudiant().isEmpty()) : "echec de la suppression de l'etudiant";
        assert (!e1.isActuEtudiant()) : "Statut actuEtudiant incorrect apres suppression";
        System.out.println("\t[OK] testSupprEtudiant passe.");
    }

    // Methode de test pour la suppression d'un etudiant inexistant
    private static void testSupressionEtudiantInexistant() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(1);
        Etudiant e1 = new Etudiant(1, "Jean", "Martin", "", "", "", "", "", "", "", "");

        maison.supprEtudiant(e1);

        assert (maison.getListeEtudiant().isEmpty()) : "Suppression d'un etudiant inexistant a modifie la liste";
        System.out.println("\t[OK] testSupressionEtudiantInexistant passe.");
    }

    // Methode de test pour la suppression d'un etudiant avec un etudiant en attente
    private static void testSupprEtudiantAvecAttente() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(1);
        Etudiant e1 = new Etudiant(1, "Jean", "Martin", "", "", "", "", "", "", "", "");
        Etudiant e2 = new Etudiant(2, "Claire", "Durand", "", "", "", "", "", "", "", "");

        maison.ajoutEtudiant(e1);
        maison.ajoutEtudiant(e2);
        maison.supprEtudiant(e1);

        assert (maison.getListeEtudiant().contains(e2)) : "etudiant en attente non promu apres suppression";
        assert (!e2.isEnAttente()) : "Statut en attente incorrect apres ajout depuis la file";
        assert (e2.isActuEtudiant()) : "Statut actuEtudiant incorrect apres ajout depuis la file";
        System.out.println("\t[OK] testSupprEtudiantAvecAttente passe.");
    }

    // Methode de test pour l'ajout d'un etudiant en attente
    private static void testAjoutEtudiantAttente() {
        MaisonClassique maison = new MaisonClassique();
        Etudiant etudiant = new Etudiant();

        maison.ajoutEtudiantAttente(etudiant);

        assert (maison.getListeAttente().contains(etudiant)) : "echec de l'ajout en liste d'attente";
        assert (etudiant.isEnAttente()) : "Statut enAttente incorrect apres ajout";
        System.out.println("\t[OK] testAjoutEtudiantAttente passe.");
    }

    // Methode de test pour la suppression d'un etudiant de la liste d'attente
    private static void testSupprEtudiantAttente() {
        MaisonClassique maison = new MaisonClassique();
        Etudiant etudiant = new Etudiant();

        maison.ajoutEtudiantAttente(etudiant);
        maison.supprEtudiantAttente(etudiant);

        assert (!maison.getListeAttente().contains(etudiant)) : "echec de la suppression de la liste d'attente";
        assert (!etudiant.isEnAttente()) : "Statut enAttente incorrect apres suppression";
        System.out.println("\t[OK] testSupprEtudiantAttente passe.");
    }
}