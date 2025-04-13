package ciuptest;

import ciup.*;

public class CIUPTest {
    public static void main(String[] args) {
        // Execution des tests
        System.out.println("========================================");
        System.out.println("Debut des tests CIUP...");
        System.out.println("========================================");

        // Executez les tests de chaque classe
        CIUPTest.runTests();
        EtudiantTest.runTests();
        MaisonClassiqueTest.runTests();
        MaisonInternationaleTest.runTests();
        MaisonTest.runTests();
        ServiceTest.runTests();

        // Fin des tests
        System.out.println("========================================");
        System.out.println("Tous les tests ont ete executes avec succes!");
        System.out.println("========================================");
        System.out.println("CIUPTest [OK]");
        System.out.println("EtudiantTest [OK]");
        System.out.println("MaisonClassiqueTest [OK]");
        System.out.println("MaisonInternationaleTest [OK]");
        System.out.println("MaisonTest [OK]");
        System.out.println("ServiceTest [OK]");
        System.out.println("========================================");
    }
    
    // Executez tous les tests de la classe CIUP
    public static void runTests() {
        System.out.println("\nCIUPTest :");

        // Ajout et suppression de maisons, services et etudiants
        testAjoutMaison();
        testSupprMaison();
        testAjoutService();
        testSupprService();
        testAjoutEtudiant();
        testSupprEtudiant();

        // Ajout de plusieurs maisons, services et etudiants
        testAjoutPlusieursMaisons();
        testAjoutPlusieursServices();
        testAjoutPlusieursEtudiants();

        // Suppression de maisons, services et etudiants inexistants
        testSupressionMaisonInexistant();
        testSupressionServiceInexistant();
        testSupressionEtudiantInexistant();

        System.out.println("\tCIUPTest : Tous les tests sont passes.");
    }

    // Methode de test pour ajouter une maison
    private static void testAjoutMaison() {
        CIUP ciup = new CIUP();
        
        Maison maison = new Maison(0, "Maison", null, null, null,null, 2025, null, 12);
        ciup.ajouterMaison(maison);

        assert(ciup.getListeMaison().size() == 1) : "Nombre de maisons incorrect";
        assert(ciup.getListeMaison().contains(maison)) : "Maison non ajoutee";
        System.out.println("\t[OK] testAjouterMaison passe.");
    }

    // Methode de test pour supprimer une maison
    private static void testSupprMaison() {
        CIUP ciup = new CIUP();

        Maison maison = new Maison(0, "Maison", null, null, null,null, 2025, null, 12);
        ciup.ajouterMaison(maison);
        ciup.supprMaison(maison);

        assert(!ciup.getListeMaison().contains(maison)) : "Maison non supprimee";
        System.out.println("\t[OK] testSupprimerMaison passe.");
    }

    // Methode de test pour ajouter un service
    private static void testAjoutService() {
        CIUP ciup = new CIUP();

        Service service = new Service(0,"Service", "Description", 8, 20);
        ciup.ajouterService(service);
        
        assert(ciup.getListeService().size() == 1) : "Nombre de services incorrect";
        assert(ciup.getListeService().contains(service)) : "Service non ajoutee";
        System.out.println("\t[OK] testAjouterService passe.");
    }

    // Methode de test pour supprimer un service
    private static void testSupprService() {
        CIUP ciup = new CIUP();

        Service service = new Service(0,"Service", "Description", 8, 20);
        ciup.ajouterService(service);
        ciup.supprService(service);

        assert(!ciup.getListeService().contains(service)) : "Service non supprimee";
        System.out.println("\t[OK] testSupprimerService passe.");
    }

    // Methode de test pour ajouter un etudiant
    private static void testAjoutEtudiant() {
        CIUP ciup = new CIUP();
        
        Etudiant etudiant = new Etudiant(0,"Nom", "Prenom", "Adresse", "Nationalite", "DateNaissance", "Tel", "Email", "Promotion", "Universite", "PieceIdentite");
        ciup.ajouterEtudiant(etudiant);
        
        assert(ciup.getListeEtudiant().size() == 1) : "Nombre d'etudiants incorrect";
        assert(ciup.getListeEtudiant().contains(etudiant)) : "Etudiant non ajoutee";
        System.out.println("\t[OK] testAjouterEtudiant passe.");
    }

    // Methode de test pour supprimer un etudiant
    private static void testSupprEtudiant() {
        CIUP ciup = new CIUP();
        
        Etudiant etudiant = new Etudiant(0,"Nom", "Prenom", "Adresse", "Nationalite", "DateNaissance", "Tel", "Email", "Promotion", "Universite", "PieceIdentite");
        ciup.ajouterEtudiant(etudiant);
        ciup.supprEtudiant(etudiant);
        
        assert(!ciup.getListeEtudiant().contains(etudiant)) : "Etudiant non supprimee";
        System.out.println("\t[OK] testSupprimerEtudiant passe.");
    }

    // Methode de test pour ajouter plusieurs maisons
    private static void testAjoutPlusieursMaisons() {
        CIUP ciup = new CIUP();
        
        for (int i = 0; i < 10; i++) {
            Maison maison = new Maison(i, "Maison" + i, null, null, null,null, 2025, null, 12);
            ciup.ajouterMaison(maison);
        }
        
        assert(ciup.getListeMaison().size() == 10) : "Nombre de maisons incorrect";
        System.out.println("\t[OK] testAjouterPlusieursMaisons passe.");
    }

    // Methode de test pour ajouter plusieurs services
    private static void testAjoutPlusieursServices() {
        CIUP ciup = new CIUP();
        
        for (int i = 0; i < 10; i++) {
            Service service = new Service(i, "Service" + i, "Description", 8, 20);
            ciup.ajouterService(service);
        }
        
        assert(ciup.getListeService().size() == 10) : "Nombre de services incorrect";
        System.out.println("\t[OK] testAjouterPlusieursServices passe.");
    }

    // Methode de test pour ajouter plusieurs etudiants
    private static void testAjoutPlusieursEtudiants() {
        CIUP ciup = new CIUP();
        
        for (int i = 0; i < 10; i++) {
            Etudiant etudiant = new Etudiant(i, "Nom" + i, "Prenom" + i, "Adresse", "Nationalite", "DateNaissance", "Tel", "Email", "Promotion", "Universite", "PieceIdentite");
            ciup.ajouterEtudiant(etudiant);
        }
        
        assert(ciup.getListeEtudiant().size() == 10) : "Nombre d'etudiants incorrect";
        System.out.println("\t[OK] testAjouterPlusieursEtudiants passe.");
    }

    // Methode de test pour supprimer une maison inexistante
    private static void testSupressionMaisonInexistant() {
        CIUP ciup = new CIUP();
        
        Maison maison = new Maison(0, "Maison", null, null, null,null, 2025, null, 12);
        ciup.supprMaison(maison);
        
        assert(!ciup.getListeMaison().contains(maison)) : "Maison inexistante non supprimee";
        System.out.println("\t[OK] testSupprimerMaisonInexistant passe.");
    }

    // Methode de test pour supprimer un service inexistant
    private static void testSupressionServiceInexistant() {
        CIUP ciup = new CIUP();
        
        Service service = new Service(0,"Service", "Description", 8, 20);
        ciup.supprService(service);
        
        assert(!ciup.getListeService().contains(service)) : "Service inexistant non supprimee";
        System.out.println("\t[OK] testSupprimerServiceInexistant passe.");
    }

    // Methode de test pour supprimer un etudiant inexistant
    private static void testSupressionEtudiantInexistant() {
        CIUP ciup = new CIUP();
        
        Etudiant etudiant = new Etudiant(0,"Nom", "Prenom", "Adresse", "Nationalite", "DateNaissance", "Tel", "Email", "Promotion", "Universite", "PieceIdentite");
        ciup.supprEtudiant(etudiant);
        
        assert(!ciup.getListeEtudiant().contains(etudiant)) : "Etudiant inexistant non supprimee";
        System.out.println("\t[OK] testSupprimerEtudiantInexistant passe.");
    }
}