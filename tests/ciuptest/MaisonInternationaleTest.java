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

        // Constructeur et affichage
        testConstructeurMaisonInternationale();
        testConstructeurMaisonInternationaleVide();
        testAfficheServicesMaisonInternationale();

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

    // Methode de test pour le constructeur de la Maison Internationale
    private static void testConstructeurMaisonInternationale() {
        MaisonInternationale maison = new MaisonInternationale(1, "Maison Internationale", "Description", "0123456789",
                "Localisation", "Directeur", 2000, "01/01/2000", 5);

        assert (maison.getNum() == 1) : "Numero incorrect";
        assert (maison.getNom().equals("Maison Internationale")) : "Nom incorrect";
        assert (maison.getDesc().equals("Description")) : "Description incorrecte";
        assert (maison.getTel().equals("0123456789")) : "Telephone incorrect";
        assert (maison.getLocalisation().equals("Localisation")) : "Localisation incorrecte";
        assert (maison.getDirecteur().equals("Directeur")) : "Directeur incorrect";
        assert (maison.getAnneeCreation() == 2000) : "Annee de creation incorrecte";
        assert (maison.getDateFete().equals("01/01/2000")) : "Date de la fete incorrecte";
        assert (maison.getDureeFete() == 5) : "Duree de la fete incorrecte";

        System.out.println("\t[OK] testConstructeurMaisonInternationale passé.");
    } 

    // Methode de test pour le constructeur vide de la Maison Internationale
    private static void testConstructeurMaisonInternationaleVide() {
        MaisonInternationale maison = new MaisonInternationale();

        assert (maison != null) : "Maison incorrecte";
        System.out.println("\t[OK] testConstructeurMaisonInternationaleVide passé.");
    }

    // Methode de test pour afficher les informations de la Maison Internationale
    private static void testAfficheServicesMaisonInternationale() {
        MaisonInternationale maison = new MaisonInternationale();

        for (int i = 0; i < 3; i++) {
            Service s = new Service(i, "Service" + i, "Description" + i, 8, 18);
            maison.ajoutService(s);
        }

        try {
            System.out.println("-------- AFFICHAGE --------");
            maison.afficheServices();
            System.out.println("---------------------------");
        } catch (Exception e) {
            assert (false) : "Erreur lors de l'affichage des services de la maison"+ e.getMessage();
        }

        System.out.println("\t[OK] testAfficheDescMaisonInternationale passé.");
    }

}