package ciuptest;

import ciup.Etudiant;
import ciup.Maison;

public class EtudiantTest {

    // Executez tous les tests de la classe Etudiant
    public static void runTests() {
        System.out.println("\nEtudiantTest :");

        // Tests
        testMaisonActuelle();
        testToStringContenu();
        testModificationComportement();
        
        System.out.println("\tEtudiantTest : Tous les tests sont passes.");
    }

    // Methode de test pour la maison actuelle de l'etudiant
    private static void testMaisonActuelle() {
        Etudiant etudiant = new Etudiant();
        Maison maison = new Maison();

        etudiant.setMaisonActuelle(maison);

        assert(etudiant.getMaisonActuelle().equals(maison)) : "Maison actuelle incorrecte";
        System.out.println("\t[OK] testMaisonActuelle passe.");
    }

    // Methode de test pour la methode toString de la classe Etudiant
    private static void testToStringContenu() {
        Etudiant etudiant = new Etudiant(1,"Nom", "Prenom", "Adresse", "Nationalite", "DateNaissance", "Tel", "Email", "Promotion", "Universite", "PieceIdentite");
        String texte = etudiant.toString();

        assert(texte.contains("1")): "Numero incorrect";
        assert(texte.contains("Nom")): "Nom incorrect";
        assert(texte.contains("Prenom")): "Prenom incorrect";
        assert(texte.contains("Adresse")): "Adresse incorrect";
        assert(texte.contains("Nationalite")): "Nationalite incorrect";
        assert(texte.contains("DateNaissance")): "Date de naissance incorrect";
        assert(texte.contains("Tel")): "Telephone incorrect";
        assert(texte.contains("Email")): "Email incorrect";
        assert(texte.contains("Promotion")): "Promotion incorrect";
        assert(texte.contains("Universite")): "Universite incorrect";
        assert(texte.contains("PieceIdentite")): "Piece d'identite incorrecte";
        assert(texte.contains("true")): "ActuEtudiant incorrect";
        assert(texte.contains("false")): "EnAttente incorrect";
        assert(texte.contains("null")): "Maison actuelle incorrecte";

        System.out.println("\t[OK] testToStringContenu passe.");
    }

    // Methode de test pour le comportement de modification de l'etudiant
    private static void testModificationComportement() {
        Etudiant etudiant = new Etudiant();

        Maison m1 = new Maison();
        Maison m2 = new Maison();
    
        etudiant.setMaisonActuelle(m1);
        assert(etudiant.getMaisonActuelle().equals(m1)) : "Maison incorrecte";
    
        etudiant.setMaisonActuelle(m2);
        assert(etudiant.getMaisonActuelle().equals(m2)): "Changement de maison echoue";
    
        etudiant.setActuEtudiant(false);
        etudiant.setEnAttente(true);

        assert(!etudiant.isActuEtudiant()): "ActuEtudiant incorrect";
        assert(etudiant.isEnAttente()): "EnAttente incorrect";
    
        System.out.println("\t[OK] testModificationComportement passe.");
    }
}