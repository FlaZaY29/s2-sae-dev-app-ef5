import tests.*;

public class CIUPTest {
    public static void main(String[] args) {
        EtudiantTest.runTests();
        MaisonTest.runTests();
        MaisonClassiqueTest.runTests();
        ServiceTest.runTests();
        System.out.println("Tous les tests ont été exécutés!");
    }
}