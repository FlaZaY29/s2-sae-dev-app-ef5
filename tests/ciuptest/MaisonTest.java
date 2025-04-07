package tests;

import CIUP.Maison;

public class MaisonTest {

    public static void runTests() {
        testMaisonToString();
        testSettersMaison();
        System.out.println("MaisonTest : Tous les tests sont passés.");
    }

    private static void testMaisonToString() {
        Maison maison = new Maison(1, "Maison Test", "Description Test", "0606060606",
                "Paris", "Directeur Test", 2000, "01/01", 2);

        String expected = "1 ; Maison Test ; Description Test ; 0606060606 ; Paris ; Directeur Test ; 2000 ; 01/01 ; 2";
        assert maison.toString().equals(expected) : "Méthode toString échouée";

        System.out.println("testMaisonToString : OK");
    }

    private static void testSettersMaison() {
        Maison maison = new Maison();
        maison.setNom("Maison Internationale");

        assert maison.getNom().equals("Maison Internationale") : "Setter Nom échoué";

        System.out.println("testSettersMaison : OK");
    }
}