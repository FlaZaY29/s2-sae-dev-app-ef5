package ciuptest;

import ciup.Maison;

public class MaisonTest {

    // Test de la classe Maison
    public static void runTests() {
        System.out.println("\nMaisonTest :");
        
        // afficher les informations de la maison
        testToStringMaison();

        System.out.println("\tMaisonTest : Tous les tests sont passes.");
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