package ciuptest;

import java.util.ArrayList;

import ciup.MaisonInternationale;
import ciup.Service;

public class ServiceTest {

    // Test de la classe Service
    public static void runTests() {
        System.out.println("\nServiceTest :");

        // Ajout et suppression de maisons
        testAjoutMaisonAuService();
        testAjoutPlusieursMaisonsAuService();
        testSupprMaisonDuService();
        testSuppressionMaisonInexistante();

        // Constructeur et affichage
        testConstructeurService();
        testConstructeurServiceVide();
        testGetterSetterService();
        testToStringService();
        testAfficheService();

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

    // Methode de test pour le constructeur de la classe Service
    private static void testConstructeurService() {
        Service service = new Service(1, "Service1", "Description1", 9, 17);

        assert (service.getNum() == 1) : "Numero incorrect";
        assert (service.getNom().equals("Service1")) : "Nom incorrect";
        assert (service.getDesc().equals("Description1")) : "Description incorrecte";
        assert (service.getHeureOuv() == 9) : "Heure d'ouverture incorrecte";
        assert (service.getHeureFerm() == 17) : "Heure de fermeture incorrecte";

        System.out.println("\t[OK] testConstructeurService passe.");
    }

    // Methode de test pour le constructeur vide de la classe Service
    private static void testConstructeurServiceVide() {
        Service service = new Service();

        assert(service !=null ) : "Service incorrect";
        System.out.println("\t[OK] testConstructeurServiceVide passe.");
    }

    // Methode de test pour les getters et setters de la classe Service
    private static void testGetterSetterService() {
        Service service = new Service();

        service.setNum(1);
        service.setNom("Service1");
        service.setDesc("Description1");
        service.setHeureOuv(9);
        service.setHeureFerm(17);
        service.setSesMaison(new ArrayList<MaisonInternationale>());

        assert (service.getNum() == 1) : "Numero incorrect";
        assert (service.getNom().equals("Service1")) : "Nom incorrect";
        assert (service.getDesc().equals("Description1")) : "Description incorrecte";
        assert (service.getHeureOuv() == 9) : "Heure d'ouverture incorrecte";
        assert (service.getHeureFerm() == 17) : "Heure de fermeture incorrecte";
        assert (service.getSesMaison().isEmpty()) : "Liste de maisons incorrecte";

        System.out.println("\t[OK] testGetterSetterService passe.");
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

    // Methode de test pour afficher les informations du service
    private static void testAfficheService() {
        Service service = new Service(1, "Service1", "Description1", 9, 17);

        for (int i = 0; i < 3; i++) {
            MaisonInternationale maison = new MaisonInternationale(i, "Maison" + i, "Description" + i, "0123456789", "Localisation" + i, "Directeur" + i, 2000 + i, "01/01/2000", 5);
            service.ajoutMaison(maison);
        }

        try {
            System.out.println("-------- AFFICHAGE --------");
            service.afficheService();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert (false) : "Erreur lors de l'affichage du service : " + e.getMessage();
        }

        System.out.println("\t[OK] testAfficheService passe.");
    }
}