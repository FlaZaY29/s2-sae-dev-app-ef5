package tests.ciuptest;

import CIUP.Maison;
import CIUP.MaisonInternationale;
import CIUP.Service;


public class MaisonInternationalTest {
    public static void MaisonInternationaleTest() {
        
    }

    public static void ajoutServiceTest() {
        MaisonInternationale maisonInternationale = new MaisonInternationale();
        Service service = new Service();
        maisonInternationale.ajoutService(service);
        assert(maisonInternationale.getSesServices().contains(service));
    }
}
