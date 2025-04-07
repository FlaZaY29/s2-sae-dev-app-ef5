package tests;

import CIUP.Etudiant;

public class EtudiantTest {

    public static void runTests() {
        testConstructeurEtudiant();
        testSettersEtudiant();
        testActuEtudiant();
        System.out.println("EtudiantTest : Tous les tests sont passés.");
    }

    private static void testConstructeurEtudiant() {
        Etudiant etu = new Etudiant(1, "Dupont", "Jean", "Adresse 1", "Française", "01/01/2000", "0606060606",
                "jean.dupont@example.com", "Promotion 2025", "Université Paris-Saclay", "12345");

        assert etu.getNum() == 1 : "Numéro incorrect";
        assert etu.getNom().equals("Dupont") : "Nom incorrect";
        assert etu.getPrenom().equals("Jean") : "Prénom incorrect";
        assert etu.getAdresse().equals("Adresse 1") : "Adresse incorrecte";
        assert etu.getNationalite().equals("Française") : "Nationalité incorrecte";
        assert etu.getDateNaissance().equals("01/01/2000") : "Date de naissance incorrecte";
        assert etu.getTel().equals("0606060606") : "Téléphone incorrect";
        assert etu.getEmail().equals("jean.dupont@example.com") : "Email incorrect";
        assert etu.getPromotion().equals("Promotion 2025") : "Promotion incorrecte";
        assert etu.getUniversite().equals("Université Paris-Saclay") : "Université incorrecte";
        assert etu.getPieceIdentite().equals("12345") : "Pièce d'identité incorrecte";

        System.out.println("testConstructeurEtudiant : OK");
    }

    private static void testSettersEtudiant() {
        Etudiant etu = new Etudiant();
        etu.setNom("Doe");
        etu.setPrenom("John");

        assert etu.getNom().equals("Doe") : "Setter Nom échoué";
        assert etu.getPrenom().equals("John") : "Setter Prénom échoué";

        System.out.println("testSettersEtudiant : OK");
    }

    private static void testActuEtudiant() {
        Etudiant etu = new Etudiant();
        etu.setActuEtudiant(true);

        assert etu.isActuEtudiant() : "Setter/getter ActuEtudiant échoué";

        System.out.println("testActuEtudiant : OK");
    }
}