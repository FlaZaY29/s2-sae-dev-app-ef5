package ciuptest;

import ciup.MaisonInternationale;
import ciup.Service;

public class MaisonInternationaleTest {

    // Test de la classe MaisonInternationale
    public static void runTests() {
        testAjoutService();
        testSupprService();
        System.out.println("MaisonInternationaleTest : Tous les tests sont passés.\n");
    }

    private static void testAjoutService() {
        // Création d'une maison internationale
        MaisonInternationale maison = new MaisonInternationale();

        // Création de services
        Service service1 = new Service(1, "Restauration", "Repas pour étudiants", 8, 22);
        Service service2 = new Service(2, "Bibliothèque", "Accès aux livres", 9, 20);

        // Ajout des services
        maison.ajoutService(service1);
        maison.ajoutService(service2);

        // Vérification
        assert maison.getSesServices().size() == 2 : "Échec de l'ajout des services";
        assert maison.getSesServices().contains(service1) : "Le service 1 n'est pas ajouté correctement";
        assert maison.getSesServices().contains(service2) : "Le service 2 n'est pas ajouté correctement";

        System.out.println("testAjoutService : OK");
    }

    private static void testSupprService() {
        // Création d'une maison internationale
        MaisonInternationale maison = new MaisonInternationale();

        // Création de services
        Service service1 = new Service(1, "Restauration", "Repas pour étudiants", 8, 22);
        Service service2 = new Service(2, "Bibliothèque", "Accès aux livres", 9, 20);

        // Ajout des services
        maison.ajoutService(service1);
        maison.ajoutService(service2);

        // Suppression d'un service
        maison.supprService(service1);

        // Vérification
        assert maison.getSesServices().size() == 1 : "Échec de la suppression d'un service";
        assert !maison.getSesServices().contains(service1) : "Le service 1 n'a pas été supprimé correctement";
        assert maison.getSesServices().contains(service2) : "Le service 2 a été supprimé par erreur";

        System.out.println("testSupprService : OK");
    }
}