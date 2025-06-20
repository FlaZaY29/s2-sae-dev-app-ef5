package ciuptest;

import ciup.MaisonInternationale;
import ciup.Service;

public class MaisonInternationaleTest {

    // Test de la classe MaisonInternationale
    public static void runTests() {
        System.out.println("\nMaisonInternationaleTest :");

        // Ajout et suppression
        testAjoutServiceMaisonInternationale();
        testAjoutPlusieursServicesMaisonInternationale();
        testSupprServiceMaisonInternationale();
        testSupressionServiceInexistantMaisonInternationale();

        System.out.println("\tMaisonInternationaleTest : Tous les tests sont passés.");
    }

    // Methode de test pour l'ajout d'un service a la Maison Internationale
    private static void testAjoutServiceMaisonInternationale() {
        MaisonInternationale maison = new MaisonInternationale();
        Service s = new Service();

        maison.ajoutService(s);

        assert (maison.getSesServices().contains(s)) : "Le service n'a pas été ajouté à la maison";
        assert (s.getSesMaison().contains(maison)) : "La maison n'a pas été ajoutée au service";

        System.out.println("\t[OK] testAjoutServiceMaisonInternationale passé.");
    }

    // Methode de test pour l'ajout de plusieurs services a la Maison Internationale
    private static void testAjoutPlusieursServicesMaisonInternationale() {
        MaisonInternationale maison = new MaisonInternationale();
        Service s1 = new Service();
        Service s2 = new Service();

        maison.ajoutService(s1);
        maison.ajoutService(s2);

        assert (maison.getSesServices().size() == 2) : "Le nombre de services ajoutés est incorrect";
        assert (maison.getSesServices().contains(s1)) : "Service 1 non ajouté";
        assert (maison.getSesServices().contains(s2)) : "Service 2 non ajouté";

        System.out.println("\t[OK] testAjoutPlusieursServicesMaisonInternationale passé.");
    }

    // Methode de test pour la suppression d'un service de la Maison Internationale
    private static void testSupprServiceMaisonInternationale(){
        MaisonInternationale maison = new MaisonInternationale();
        Service s = new Service();
    
        maison.ajoutService(s);
        maison.supprService(s);
    
        assert (!maison.getSesServices().contains(s)) : "Le service n'a pas été supprimé de la maison";
        assert (!s.getSesMaison().contains(maison)) : "La maison n'a pas été supprimée du service";

        System.out.println("\t[OK] testSupprServiceMaisonInternationale passé.");
    }

    // Methode de test pour la suppression d'un service inexistant de la Maison Internationale
    private static void testSupressionServiceInexistantMaisonInternationale(){
        MaisonInternationale maison = new MaisonInternationale();
        Service s = new Service();

        maison.supprService(s);

        assert (!maison.getSesServices().contains(s)) : "Un service inexistant a été supprimé";

        System.out.println("\t[OK] testSupressionServiceInexistantMaisonInternationale passé.");
    }
}