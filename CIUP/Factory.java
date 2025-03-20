package CIUP;

import java.util.ArrayList;


public class Factory {
    // Créer une maisonClassique
    static MaisonClassique creeMaison() {
        MaisonClassique maison = new MaisonClassique();
        maison.setAnneeCreation(1990);
        maison.setCapacite(100);
        maison.setDateFete("01/01");
        maison.setDesc("Maison classique type");
        maison.setDirecteur("Directeur");
        maison.setLocalisation("Paris");
        maison.setNom("Maison type");
        maison.setNum(1);
        maison.setDureeFete(1);
        maison.setNationalite("Française");
        maison.listeEtudiant = new ArrayList<Etudiant>();
        Etudiant etudiant1 = new Etudiant(1, "Nathan", "Thanna", "9 rue jolie",
                            "Française","29/10/2006", "06 07 08 09 10",
                            "Nathan.thanna@mail.com","Voltaire",
                            "Paris-Saclay","Nathan_Thanna.jpg");

        Etudiant etudiant2 = new Etudiant(2, "Alice", "Dupont", "15 avenue des Champs",
                            "Française", "15/03/2005", "07 08 09 10 11",
                            "alice.dupont@mail.com", "Victor Hugo",
                            "Sorbonne", "Alice_Dupont.jpg");

        Etudiant etudiant3 = new Etudiant(3, "Jean", "Martin", "20 boulevard Haussmann",
                            "Française", "10/12/2004", "06 12 34 56 78",
                            "jean.martin@mail.com", "Molière",
                            "Université de Lyon", "Jean_Martin.jpg");

        Etudiant etudiant4 = new Etudiant(4, "Marie", "Curie", "5 rue des Sciences",
                            "Française", "07/11/1867", "06 11 22 33 44",
                            "marie.curie@mail.com", "Pasteur",
                            "Université de Paris", "Marie_Curie.jpg");

        Etudiant etudiant5 = new Etudiant(5, "Albert", "Einstein", "10 avenue Relativité",
                            "Allemande", "14/03/1879", "06 55 66 77 88",
                            "albert.einstein@mail.com", "Newton",
                            "ETH Zurich", "Albert_Einstein.jpg");

        Etudiant etudiant6 = new Etudiant(6, "Isaac", "Newton", "20 rue Gravité",
                            "Anglaise", "04/01/1643", "06 99 88 77 66",
                            "isaac.newton@mail.com", "Galilée",
                            "Université de Cambridge", "Isaac_Newton.jpg");

        Etudiant etudiant7 = new Etudiant(7, "Ada", "Lovelace", "15 boulevard Algorithmique",
                            "Anglaise", "10/12/1815", "06 44 33 22 11",
                            "ada.lovelace@mail.com", "Byron",
                            "Université de Londres", "Ada_Lovelace.jpg");

        Etudiant etudiant8 = new Etudiant(8, "Charles", "Darwin", "25 avenue Evolution",
                            "Anglaise", "12/02/1809", "06 77 88 99 00",
                            "charles.darwin@mail.com", "Wallace",
                            "Université d'Édimbourg", "Charles_Darwin.jpg");

        Etudiant etudiant9 = new Etudiant(9, "Galileo", "Galilei", "30 rue Astronomie",
                            "Italienne", "15/02/1564", "06 22 33 44 55",
                            "galileo.galilei@mail.com", "Copernic",
                            "Université de Pise", "Galileo_Galilei.jpg");

        Etudiant etudiant10 = new Etudiant(10, "Leonardo", "Da Vinci", "40 rue Renaissance",
                            "Italienne", "15/04/1452", "06 66 77 88 99",
                            "leonardo.davinci@mail.com", "Michelangelo",
                            "Académie des Beaux-Arts", "Leonardo_DaVinci.jpg");
        
        maison.listeEtudiant.add(etudiant1);
        maison.listeEtudiant.add(etudiant2);
        maison.listeEtudiant.add(etudiant3);
        maison.listeEtudiant.add(etudiant4);
        maison.listeEtudiant.add(etudiant5);
        maison.listeEtudiant.add(etudiant6);
        maison.listeEtudiant.add(etudiant7);
        maison.listeEtudiant.add(etudiant8);
        maison.listeEtudiant.add(etudiant9);
        maison.listeEtudiant.add(etudiant10);

        maison.listeAttente = new ArrayList<Etudiant>();

        return maison;
    }

    // Créer une maisoninter
    static MaisonInternationale creeMaisonInternationale() {
        MaisonInternationale maison = new MaisonInternationale();
        maison.setAnneeCreation(1990);
        maison.setDateFete("25/12");
        maison.setDesc("Maison internationale");
        maison.setDirecteur("Directeur");
        maison.setLocalisation("Paris");
        maison.setNom("Maison");
        maison.setNum(1);
        maison.setDureeFete(1);
        maison.sesServices = new ArrayList<Service>();
        Service service1 = new Service(1, "Service de restauration", "Service de restauration pour les étudiants", 8, 20);
        Service service2 = new Service(2, "Service de sécurité", "Service de sécurité pour les étudiants", 0, 24);
        maison.ajoutService(service1);
        maison.ajoutService(service2);


        return maison;
    }

    // Créer un service
    static Service creeService() {
        Service service = new Service();
        service.setNom("Service");
        service.setDesc("Description du service");
        service.setHeureOuv(8);
        service.setHeureFerm(20);
        service.setNum(1);
        service.sesMaison = new ArrayList<MaisonInternationale>();
        return service;
    }

    // Créer un étudiant
    static Etudiant creeEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Nom");
        etudiant.setPrenom("Prenom");
        etudiant.setNationalite("Française");
        etudiant.setNum(1);
        etudiant.setAdresse("Adresse");
        etudiant.setDateNaissance("01/01/2000");
        etudiant.setTel("06 07 08 09 10");
        etudiant.setEmail("mail.mail@mail.com");
        etudiant.maisonActuelle = new MaisonClassique();
        return etudiant;
    }
}