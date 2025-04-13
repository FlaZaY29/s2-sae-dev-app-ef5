package ciuptest;

import ciup.Etudiant;
import ciup.Maison;

public class EtudiantTest {

    // Executez tous les tests de la classe Etudiant
    public static void runTests() {
        System.out.println("\nEtudiantTest :");

        testConstructeurEtudiant();
        testConstructeurVide();
        testGetterSetterEtudiant();
        testMaisonActuelle();
        testActuEtudiant();
        testEnAttente();
        testToStringContenu();
        testAfficheInfo();
        testModificationComportement();
        
        System.out.println("\tEtudiantTest : Tous les tests sont passes.");
    }

    // Methode de test pour le constructeur de la classe Etudiant
    private static void testConstructeurEtudiant() {
        Etudiant etudiant = new Etudiant(1,"Nom", "Prenom", "Adresse", "Nationalite", "DateNaissance", "Tel", "Email", "Promotion", "Universite", "PieceIdentite");
        
        assert(etudiant.getNum() == 1) : "Numero incorrect";
        assert(etudiant.getNom().equals("Nom")) : "Nom incorrect";
        assert(etudiant.getPrenom().equals("Prenom")) : "Prenom incorrect";
        assert(etudiant.getAdresse().equals("Adresse")) : "Adresse incorrecte";
        assert(etudiant.getNationalite().equals("Nationalite")) : "Nationalite incorrecte";
        assert(etudiant.getDateNaissance().equals("DateNaissance")) : "Date de naissance incorrecte";
        assert(etudiant.getTel().equals("Tel")) : "Telephone incorrect";
        assert(etudiant.getEmail().equals("Email")) : "Email incorrect";
        assert(etudiant.getPromotion().equals("Promotion")) : "Promotion incorrecte";
        assert(etudiant.getUniversite().equals("Universite")) : "Universite incorrecte";
        assert(etudiant.getPieceIdentite().equals("PieceIdentite")) : "Piece d'identite incorrecte";
        assert(etudiant.isActuEtudiant()) : "ActuEtudiant incorrect";
        assert(!etudiant.isEnAttente()) : "EnAttente incorrect";
        assert(etudiant.getMaisonActuelle() == null) : "Maison actuelle incorrecte";
        
        System.out.println("\t[OK] testConstructeurEtudiant passe.");
    }

    private static void testConstructeurVide() {
        Etudiant etudiant = new Etudiant();

        assert( etudiant != null) : "etudiant incorrect";
        System.out.println("\t[OK] testConstructeurEtudiant passe.");
    }

    // Methode de test pour les getters et setters de la classe Etudiant
    private static void testGetterSetterEtudiant() {
        Etudiant etudiant = new Etudiant();

        etudiant.setNum(1);
        etudiant.setNom("Martin");
        etudiant.setPrenom("Bob");
        etudiant.setAdresse("123 rue des étudiants");
        etudiant.setNationalite("Française");
        etudiant.setDateNaissance("01/01/2000");
        etudiant.setTel("0123456789");
        etudiant.setEmail("bob@exemple.com");
        etudiant.setPromotion("L3 Informatique");
        etudiant.setUniversite("Sorbonne Université");
        etudiant.setPieceIdentite("1234567890");
        etudiant.setActuEtudiant(true);
        etudiant.setEnAttente(false);

        assert(etudiant.getNum() == 1) : "Numero incorrect";
        assert(etudiant.getNom().equals("Martin")) : "Nom incorrect";
        assert(etudiant.getPrenom().equals("Bob")) : "Prenom incorrect";
        assert(etudiant.getAdresse().equals("123 rue des étudiants")) : "Adresse incorrecte";
        assert(etudiant.getNationalite().equals("Française")) : "Nationalite incorrecte";
        assert(etudiant.getDateNaissance().equals("01/01/2000")) : "Date de naissance incorrecte";
        assert(etudiant.getTel().equals("0123456789")) : "Telephone incorrect";
        assert(etudiant.getEmail().equals("bob@exemple.com")) : "Email incorrect";
        assert(etudiant.getPromotion().equals("L3 Informatique")) : "Promotion incorrecte";
        assert(etudiant.getUniversite().equals("Sorbonne Université")) : "Universite incorrecte";
        assert(etudiant.getPieceIdentite().equals("1234567890")) : "Piece d'identite incorrecte";
        assert(etudiant.isActuEtudiant()) : "ActuEtudiant incorrect";
        assert(!etudiant.isEnAttente()) : "EnAttente incorrect";

        System.out.println("\t[OK] testGetterSetterEtudiant passe.");
    }

    private static void testMaisonActuelle() {
        Etudiant etudiant = new Etudiant();
        Maison maison = new Maison();

        etudiant.setMaisonActuelle(maison);

        assert(etudiant.getMaisonActuelle().equals(maison)) : "Maison actuelle incorrecte";
        System.out.println("\t[OK] testMaisonActuelle passe.");
    }

    private static void testActuEtudiant() {
        Etudiant etu = new Etudiant();
        etu.setActuEtudiant(true);

        assert(etu.isActuEtudiant()) : "Setter/getter ActuEtudiant echoue";
        System.out.println("\t[OK] testActuEtudiant passe.");
    }

    private static void testEnAttente() {
        Etudiant etu = new Etudiant();
        etu.setEnAttente(true);

        assert(etu.isEnAttente()) : "EnAttente incorrect";
        System.out.println("\t[OK] testEnAttente passe.");
    }

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

    private static void testAfficheInfo() {
        Etudiant etu = new Etudiant();

        try {
            System.out.println("-------- AFFICHAGE --------");
            etu.afficheInfo();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert(false) : "[ERR] Erreur lors de l'affichage des etudiants";
        }

        System.out.println("\t[OK] testToStringContenuEtudiant passe.");
    }

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