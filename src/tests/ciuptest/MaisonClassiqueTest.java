package tests.ciuptest;

import CIUP.MaisonClassique;
import CIUP.Etudiant;

public class MaisonClassiqueTest {

    public static void runTests() {
        testAjoutEtudiant();
        testAfficheEtudiants();
        System.out.println("MaisonClassiqueTest : Tous les tests sont passés.");
    }

    private static void testAjoutEtudiant() {
        MaisonClassique maison = new MaisonClassique();
        maison.setCapacite(2);

        Etudiant etu1 = new Etudiant(1, "Dupont", "Jean", "", "", "", "", "", "", "", "");
        Etudiant etu2 = new Etudiant(2, "Durand", "Paul", "", "", "", "", "", "", "", "");
        Etudiant etu3 = new Etudiant(3, "Martin", "Alice", "", "", "", "", "", "", "", "");

        maison.ajoutEtudiant(etu1);
        maison.ajoutEtudiant(etu2);
        maison.ajoutEtudiant(etu3);

        assert maison.getListeEtudiant().size() == 2 : "Ajout des étudiants échoué (capacité dépassée)";
        assert maison.getListeAttente().size() == 1 : "Liste d'attente incorrecte";

        System.out.println("testAjoutEtudiant : OK");
    }

    private static void testAfficheEtudiants() {
        MaisonClassique maison = new MaisonClassique();
        maison.setNom("Maison Française");

        Etudiant etu = new Etudiant(1, "Dupont", "Jean", "", "", "", "", "", "", "", "");
        maison.ajoutEtudiant(etu);

        assert maison.getListeEtudiant().size() == 1 : "Affichage des étudiants échoué";

        System.out.println("testAfficheEtudiants : OK");
    }
}