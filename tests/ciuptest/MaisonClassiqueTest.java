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

        // Affichage des etudiants
        testAffichageEtudiant();
        testAffichageEtudiantEnAttente();

        // Autres tests
        testConstructeurMaisonClassique();
        testConstructeurMaisonClassiqueVide();
        testGetterSetterMaisonClassique();
        
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

    // Methode de test pour l'affichage des etudiants
    private static void testAffichageEtudiant() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(1);
        
        for (int i = 0; i < 3; i++) {
            Etudiant etudiant = new Etudiant(i, "Etudiant" + i, "Nom" + i, "", "", "", "", "", "", "", "");
            maison.ajoutEtudiant(etudiant);
        }
        
        try {
            System.out.println("-------- AFFICHAGE --------");
            maison.afficheEtudiants();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert(false) : "Erreur lors de l'affichage des etudiants : " + e.getMessage();
        }

        System.out.println("\t[OK] testAffichageEtudiant passe.");
    }

    // Methode de test pour l'affichage des etudiants en attente
    private static void testAffichageEtudiantEnAttente() {
        MaisonClassique maison = new MaisonClassique();
        
        for (int i = 0; i < 3; i++) {
            Etudiant etudiant = new Etudiant(i, "Etudiant" + i, "Nom" + i, "", "", "", "", "", "", "", "");
            maison.ajoutEtudiantAttente(etudiant);
        }

        try {
            System.out.println("-------- AFFICHAGE --------");
            maison.afficheEtudiantsAttente();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert(false) : "Erreur lors de l'affichage des etudiants en attente : " + e.getMessage();
        }

        System.out.println("\t[OK] testAffichageEtudiantEnAttente passe.");
    }

    // Methode de test pour le constructeur de maison classique
    private static void testConstructeurMaisonClassique() {
        MaisonClassique maison = new MaisonClassique(
        1,
        "Maison Alpha",
        "Maison de test",
        "0123456789",
        "Paris",
        "Mme Dupuis",
        1950,
        "01/01",
        3
        );

        assert (maison.getNum() == 1) : "Numero incorrect dans le constructeur";
        assert (maison.getNom().equals("Maison Alpha")) : "Nom incorrect dans le constructeur";
        assert (maison.getDesc().equals("Maison de test")) : "Description incorrecte dans le constructeur";
        assert (maison.getTel().equals("0123456789")) : "Telephone incorrect dans le constructeur";
        assert (maison.getLocalisation().equals("Paris")) : "Localisation incorrecte dans le constructeur";
        assert (maison.getDirecteur().equals("Mme Dupuis")) : "Directeur incorrect dans le constructeur";
        assert (maison.getAnneeCreation() == 1950) : "Annee de creation incorrecte";
        assert (maison.getDateFete().equals("01/01")) : "Date de la fete incorrecte dans le constructeur";
        assert (maison.getDureeFete() == 3) : "Duree de la fete incorrecte dans le constructeur";

        assert (maison.getCapacite() == 0) : "Capacite incorrecte dans le constructeur";

        System.out.println("\t[OK] testConstructeurEtudiant passe.");
    }

    // Methode de test pour le constructeur vide de maison classique
    private static void testConstructeurMaisonClassiqueVide() {
        MaisonClassique maisonClassique = new MaisonClassique();

        assert (maisonClassique != null) : "echec du constructeur vide";
        System.out.println("\t[OK] testConstructeurVide passe.");
    }

    // Methode de test pour les getters et setters de maison classique
    private static void testGetterSetterMaisonClassique() {
        MaisonClassique maison = new MaisonClassique();
        maison.setNum(1);
        maison.setNom("Maison Alpha");
        maison.setDesc("Maison de test");
        maison.setTel("0123456789");
        maison.setLocalisation("Paris");
        maison.setDirecteur("Mme Dupuis");
        maison.setAnneeCreation(1950);
        maison.setDateFete("01/01");
        maison.setDureeFete(3);
        maison.setCapacite(100);
        maison.setListeEtudiant(new ArrayList<Etudiant>());
        maison.setListeAttente(new ArrayList<Etudiant>());

        assert (maison.getNum() == 1) : "Numero incorrect dans le setter";
        assert (maison.getNom().equals("Maison Alpha")) : "Nom incorrect dans le setter";
        assert (maison.getDesc().equals("Maison de test")) : "Description incorrecte dans le setter";
        assert (maison.getTel().equals("0123456789")) : "Telephone incorrect dans le setter";
        assert (maison.getLocalisation().equals("Paris")) : "Localisation incorrecte dans le setter";
        assert (maison.getDirecteur().equals("Mme Dupuis")) : "Directeur incorrect dans le setter";
        assert (maison.getAnneeCreation() == 1950) : "Annee de creation incorrecte dans le setter";
        assert (maison.getDateFete().equals("01/01")) : "Date de la fete incorrecte dans le setter";
        assert (maison.getDureeFete() == 3) : "Duree de la fete incorrecte dans le setter";
        assert (maison.getCapacite() == 100) : "Capacite incorrecte dans le setter";
        assert (maison.getListeEtudiant() != null) : "Liste d'etudiants incorrecte dans le setter";
        assert (maison.getListeAttente() != null) : "Liste d'attente incorrecte dans le setter";
        assert (maison.getListeEtudiant().isEmpty()) : "Liste d'etudiants incorrecte dans le setter";
        assert (maison.getListeAttente().isEmpty()) : "Liste d'attente incorrecte dans le setter";

        System.out.println("\t[OK] testGetterSetterEtudiant passe.");
    }
}