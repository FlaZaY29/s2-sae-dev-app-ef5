package ciuptest;

import ciup.Maison;

public class MaisonTest {

    // Test de la classe Maison
    public static void runTests() {
        System.out.println("\nMaisonTest :");

        // Test des constructeurs
        testConstructeurMaison();
        testConstructeurMaisonVide();
        testGetterSetterMaison();
        
        // afficher les informations de la maison
        testAfficheDescMaison();
        testAfficheNomMaison();
        testToStringMaison();

        System.out.println("\tMaisonTest : Tous les tests sont passes.");
    }

    // Methode de test pour le constructeur de la classe Maison
    private static void testConstructeurMaison() {
        Maison maison = new Maison(1, "Maison1", "Description1", "0123456789", "Localisation1", "Directeur1", 2000, "01/01/2000", 5);
        
        assert(maison.getNum() == 1) : "Numero incorrect";
        assert(maison.getNom().equals("Maison1")) : "Nom incorrect";
        assert(maison.getDesc().equals("Description1")) : "Description incorrecte";
        assert(maison.getTel().equals("0123456789")) : "Telephone incorrect";
        assert(maison.getLocalisation().equals("Localisation1")) : "Localisation incorrecte";
        assert(maison.getDirecteur().equals("Directeur1")) : "Directeur incorrect";
        assert(maison.getAnneeCreation() == 2000) : "Annee de creation incorrecte";
        assert(maison.getDateFete().equals("01/01/2000")) : "Date de la fete incorrecte";
        assert(maison.getDureeFete() == 5) : "Duree de la fete incorrecte";

        System.out.println("\t[OK] testConstructeurMaison passe.");
    }

    // Methode de test pour le constructeur vide de la classe Maison
    private static void testConstructeurMaisonVide() {
        Maison maison = new Maison();
        
        assert(maison != null) : "Maison incorrecte";
        System.out.println("\t[OK] testConstructeurMaisonVide passe.");
    }

    // Methode de test pour les getters et setters de la classe Maison
    private static void testGetterSetterMaison() {
        Maison maison = new Maison();
        
        maison.setNum(1);
        maison.setNom("Maison1");
        maison.setDesc("Description1");
        maison.setTel("0123456789");
        maison.setLocalisation("Localisation1");
        maison.setDirecteur("Directeur1");
        maison.setAnneeCreation(2000);
        maison.setDateFete("01/01/2000");
        maison.setDureeFete(5);

        assert(maison.getNum() == 1) : "Numero incorrect";
        assert(maison.getNom().equals("Maison1")) : "Nom incorrect";
        assert(maison.getDesc().equals("Description1")) : "Description incorrecte";
        assert(maison.getTel().equals("0123456789")) : "Telephone incorrect";
        assert(maison.getLocalisation().equals("Localisation1")) : "Localisation incorrecte";
        assert(maison.getDirecteur().equals("Directeur1")) : "Directeur incorrect";
        assert(maison.getAnneeCreation() == 2000) : "Annee de creation incorrecte";
        assert(maison.getDateFete().equals("01/01/2000")) : "Date de la fete incorrecte";
        assert(maison.getDureeFete() == 5) : "Duree de la fete incorrecte";

        System.out.println("\t[OK] testGetterSetterMaison passe.");
    }

    // Methode de test pour afficher les informations de la maison
    private static void testAfficheDescMaison() {
        Maison maison = new Maison(1, "Maison1", "Description1", "0123456789", "Localisation1", "Directeur1", 2000, "01/01/2000", 5);
        
        try {
            System.out.println("-------- AFFICHAGE --------");
            maison.afficheMaison();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert(false) : "Erreur lors de l'affichage de la maison : " + e.getMessage();
        }

        System.out.println("\t[OK] testAfficheDescMaison passe.");
    }

    // Methode de test pour afficher le nom de la maison
    private static void testAfficheNomMaison() {
        Maison maison = new Maison(1, "Maison1", "Description1", "0123456789", "Localisation1", "Directeur1", 2000, "01/01/2000", 5);
        
        try {
            System.out.println("-------- AFFICHAGE --------");
            maison.afficheDesc();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert(false) : "Erreur lors de l'affichage du nom de la maison : " + e.getMessage();
        }

        System.out.println("\t[OK] testAfficheNomMaison passe.");
    }

    // Methode de test pour la methode toString de la classe Maison
    private static void testToStringMaison() {
        Maison maison = new Maison(1, "Maison1", "Description1", "0123456789", "Localisation1", "Directeur1", 2000, "01/01/2000", 5);
        String texte = maison.toString();

        assert(texte.contains("Maison1")): "Nom incorrect";
        assert(texte.contains("Description1")): "Description incorrecte";
        assert(texte.contains("0123456789")): "Telephone incorrect";
        assert(texte.contains("Localisation1")): "Localisation incorrecte";
        assert(texte.contains("Directeur1")): "Directeur incorrect";
        assert(texte.contains("2000")): "Annee de creation incorrecte";
        assert(texte.contains("01/01/2000")): "Date de la fete incorrecte";
        assert(texte.contains("5")): "Duree de la fete incorrecte";

       System.out.println("\t[OK] testToStringMaison passe.");
    }
}