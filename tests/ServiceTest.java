package tests;

import java.util.ArrayList;
import CIUP.Service;
import CIUP.MaisonInternationale;

public class ServiceTest{

    public static void main(String[] args) {
        testAjoutMaison();
        testSupprMaison();
    }

    public static void testAjoutMaison() {
        System.out.println("=== Test ajoutMaison ===");
        Service service = new Service(1, "Bibliothèque", "Lecture et études", 9, 18);
        MaisonInternationale maison = new MaisonInternationale(0, "Maison du Japon", null, null, null, null, 0, null, 0);

        service.ajoutMaison(maison);

        ArrayList<MaisonInternationale> maisons = service.getSesMaison();
        if (maisons.contains(maison) && maisons.size() == 1) {
            System.out.println("ajoutMaison fonctionne correctement.");
        } else {
            System.out.println("Erreur dans ajoutMaison.");
        }
    }

    public static void testSupprMaison() {
        System.out.println("=== Test supprMaison ===");
        Service service = new Service(2, "Sport", "Activités sportives", 8, 22);
        MaisonInternationale maison = new MaisonInternationale(0, "Maison du Maroc", null, null, null, null, 0, null, 0);

        service.ajoutMaison(maison);
        service.supprMaison(maison);

        ArrayList<MaisonInternationale> maisons = service.getSesMaison();
        if (!maisons.contains(maison) && maisons.size() == 0) {
            System.out.println("supprMaison fonctionne correctement.");
        } else {
            System.out.println("Erreur dans supprMaison.");
        }
    }
}