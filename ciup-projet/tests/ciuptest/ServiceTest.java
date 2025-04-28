package ciuptest;

import modeles.MaisonInternationale;
import modeles.Service;

public class ServiceTest {

    // Test de la classe Service
    public static void runTests() {
        System.out.println("\nServiceTest :");

        // Ajout et suppression de maisons
        testAjoutMaisonAuService();
        testAjoutPlusieursMaisonsAuService();
        testSupprMaisonDuService();
        testSuppressionMaisonInexistante();
        testToStringService();

        System.out.println("\tServiceTest : Tous les tests sont passes.");
    }

    // Methode de test pour l'ajout d'une maison au service
    private static void testAjoutMaisonAuService() {
        Service service = new Service();
        MaisonInternationale maison = new MaisonInternationale();

        service.ajoutMaison(maison);

        assert (service.getSesMaison().contains(maison)) : "La maison n'a pas ete ajoutee au service";
        
        System.out.println("\t[OK] testAjoutMaisonAuService passe.");
    }

    // Methode de test pour l'ajout de plusieurs maisons au service
    private static void testAjoutPlusieursMaisonsAuService() {
        Service service = new Service();
        MaisonInternationale maison1 = new MaisonInternationale();
        MaisonInternationale maison2 = new MaisonInternationale();

        service.ajoutMaison(maison1);
        service.ajoutMaison(maison2);

        assert (service.getSesMaison().size() == 2) : "Le nombre de maisons ajoutees est incorrect";
        assert (service.getSesMaison().contains(maison1)) : "Maison 1 non ajoutee";
        assert (service.getSesMaison().contains(maison2)) : "Maison 2 non ajoutee";

        System.out.println("\t[OK] testAjoutPlusieursMaisonsAuService passe.");
    }

    // Methode de test pour la suppression d'une maison du service
    private static void testSupprMaisonDuService() {
        Service service = new Service();
        MaisonInternationale maison = new MaisonInternationale();

        service.ajoutMaison(maison);
        service.supprMaison(maison);

        assert (!service.getSesMaison().contains(maison)) : "La maison n'a pas ete supprimee du service";
        
        System.out.println("\t[OK] testSupprMaisonDuService passe.");
    }

    // Methode de test pour la suppression d'une maison inexistante du service
    private static void testSuppressionMaisonInexistante() {
        Service service = new Service();
        MaisonInternationale maison = new MaisonInternationale();

        service.supprMaison(maison);

        assert (!service.getSesMaison().contains(maison)) : "La maison n'a pas ete supprimee du service (inexistante)";

        System.out.println("\t[OK] testSuppressionMaisonInexistante passe.");
    }

    // Methode de test pour la methode toString de la classe Service
    private static void testToStringService() {
        Service service = new Service(1, "Service1", "Description1", 9, 17);
        String texte = service.toString();
        
        assert (texte.contains("1")) : "Numero incorrect";
        assert (texte.contains("Service1")) : "Nom incorrect";
        assert (texte.contains("Description1")) : "Description incorrecte";
        assert (texte.contains("9")) : "Heure d'ouverture incorrecte";
        assert (texte.contains("17")) : "Heure de fermeture incorrecte";

        System.out.println("\t[OK] testToStringService passe.");
    }
}