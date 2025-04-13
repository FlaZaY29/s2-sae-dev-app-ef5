package ciuptest;

import ciup.Service;

public class ServiceTest {

    // Test de la classe Service
    public static void runTests() {
        testServiceToString();
        System.out.println("ServiceTest : Tous les tests sont passés.\n");
    }

    private static void testServiceToString() {
        Service service = new Service(1, "Restauration", "Repas pour étudiants", 8, 22);
        String expected = "1 ; Restauration ; Repas pour étudiants ; 8 ; 22";
        assert service.toString().equals(expected) : "Méthode toString échouée";

        System.out.println("testServiceToString : OK");
    }
}