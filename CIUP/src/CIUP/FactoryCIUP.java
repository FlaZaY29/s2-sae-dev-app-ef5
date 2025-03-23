package CIUP;

public class FactoryCIUP {

    // Créer une Maison internationale
    static MaisonInternationale creeMaisonInternationale() {
        MaisonInternationale maison = new MaisonInternationale();
        maison.setNum(1);
        maison.setNom("Maison internationale");
        maison.setDesc("Maison internationale type moderne");
        maison.setTel("01 23 45 67 89");
        maison.setLocalisation("Paris");
        maison.setDirecteur("Directeur Jean");
        maison.setAnneeCreation(1995);
        maison.setDateFete("25/12");
        maison.setDureeFete(1);

        return maison;
    }


    // Créer une maisonClassique FrancoBritannique
    static MaisonClassique maisonFrançaise() {
        MaisonClassique maison = new MaisonClassique();

        // Maison
        maison.setNum(1);
        maison.setNom("Française");
        maison.setDesc("Maison classique type");
        maison.setTel("01 23 45 67 89");
        maison.setLocalisation("Paris");
        maison.setDirecteur("Directeur Emmanuel");
        maison.setAnneeCreation(1990);
        maison.setDateFete("01/11");
        maison.setDureeFete(1);

        // Maison Classique
        maison.setNationalite("Française");
        maison.setCapacite(100);
        maison.getListeEtudiant().add(etudiant1());
        maison.getListeEtudiant().add(etudiant2());
        maison.getListeEtudiant().add(etudiant3());
        maison.getListeEtudiant().add(etudiant4());
        maison.getListeEtudiant().add(etudiant5());
        maison.getListeEtudiant().add(etudiant6());
        maison.getListeEtudiant().add(etudiant7());
        maison.getListeEtudiant().add(etudiant8());
        maison.getListeEtudiant().add(etudiant9());

        return maison;
    }

    // Créer une maison traditionnelle Japonaise
    static MaisonClassique maisonJaponaise() {
        MaisonClassique maison = new MaisonClassique();
        // Maison
        maison.setNum(2);
        maison.setNom("Japonaise");
        maison.setDesc("Maison traditionnelle japonaise");
        maison.setTel("01 23 45 67 89");
        maison.setLocalisation("Kyoto");
        maison.setDirecteur("Directeur Kishida");
        maison.setAnneeCreation(2025);
        maison.setDateFete("15/08");
        maison.setDureeFete(1);

        // Maison Classique
        maison.setNationalite("Japonaise");
        maison.setCapacite(50);
        maison.getListeEtudiant().add(etudiant1Japonais());
        maison.getListeEtudiant().add(etudiant2Japonais());
        maison.getListeEtudiant().add(etudiant3Japonais());
        maison.getListeEtudiant().add(etudiant4Japonais());
        maison.getListeEtudiant().add(etudiant5Japonais());
        maison.getListeEtudiant().add(etudiant6Japonais());
        maison.getListeEtudiant().add(etudiant7Japonais());
        maison.getListeEtudiant().add(etudiant8Japonais());
        maison.getListeEtudiant().add(etudiant9Japonais());
        maison.getListeEtudiant().add(etudiant10Japonais());

        return maison;
    }

    // Exemple d'objets pour CIUP
    /*// Créer une maison
    static MaisonClassique creeMaison() {
        MaisonClassique maison = new MaisonClassique();

        // Maison
        maison.setNum(1);
        maison.setNom("Nom");
        maison.setDesc("Description");
        maison.setTel("01 23 45 67 89");
        maison.setLocalisation("Paris");
        maison.setDirecteur("Directeur");
        maison.setAnneeCreation(2000);
        maison.setDateFete("01/01");
        maison.setDureeFete(1);

        // Maison Classique
        maison.setNationalite("Française");
        maison.setCapacite(100);
        maison.listeEtudiant.add(creeEtudiant());

        return maison;
    }

    // Créer un service
    static Service creeService() {
        Service service = new Service();
        service.setNum(1);
        service.setNom("Service");
        service.setDesc("Description du service");
        service.setHeureOuv(8);
        service.setHeureFerm(20);

        return service;
    }

    // Créer un étudiant
    static Etudiant creeEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNum(1);
        etudiant.setNom("Nom");
        etudiant.setPrenom("Prenom");
        etudiant.setAdresse("Adresse");
        etudiant.setNationalite("Nationalite");
        etudiant.setDateNaissance("01/01/2000");
        etudiant.setTel("01 23 45 67 89");
        etudiant.setEmail("mail.mail@mail.com");
        etudiant.setPromotion("Promotion 2025");
        etudiant.setUniversite("Université de Paris-Saclay");
        etudiant.setPieceIdentite("Piece d'identité");
        etudiant.setActuEtudiant(true);
        etudiant.setEnAttente(false);
        etudiant.setMaisonActuelle(new MaisonClassique());

        return etudiant;
    }*/

    // Créer le service de restauration
    static Service creeServiceRestauration() {
        Service service = new Service();
        service.setNum(1);
        service.setNom("Service de restauration");
        service.setDesc("Service de restauration pour les étudiants");
        service.setHeureOuv(8);
        service.setHeureFerm(20);

        return service;
    }

    // Créer le service de sécurité
    static Service creeServiceSecurite() {
        Service service = new Service();
        service.setNum(2);
        service.setNom("Service de sécurité");
        service.setDesc("Service de sécurité pour les étudiants");
        service.setHeureOuv(0);
        service.setHeureFerm(24);

        return service;
    }

    // Créer un étudiant 1
    static Etudiant etudiant1() {
        return new Etudiant(1, "Nathan", "Thanna", "9 rue jolie",
                "Française", "29/10/2006", "06 07 08 09 10",
                "Nathan.thanna@mail.com", "Voltaire",
                "Paris-Saclay", "Nathan_Thanna.jpg");
    }

    // Créer un étudiant 2
    static Etudiant etudiant2() {
        return new Etudiant(2, "Alice", "Dupont", "15 avenue des Champs",
                "Française", "15/03/2005", "07 08 09 10 11",
                "alice.dupont@mail.com", "Victor Hugo",
                "Sorbonne", "Alice_Dupont.jpg");
    }

    // Créer un étudiant 3
    static Etudiant etudiant3() {
        return new Etudiant(3, "Jean", "Martin", "20 boulevard Haussmann",
                "Française", "10/12/2004", "06 12 34 56 78",
                "jean.martin@mail.com", "Molière",
                "Université de Lyon", "Jean_Martin.jpg");
    }

    // Créer un étudiant 4
    static Etudiant etudiant4() {
        return new Etudiant(4, "Marie", "Curie", "5 rue des Sciences",
                "Française", "07/11/1867", "06 11 22 33 44",
                "marie.curie@mail.com", "Pasteur",
                "Université de Paris", "Marie_Curie.jpg");
    }

    // Créer un étudiant 5
    static Etudiant etudiant5() {
        return new Etudiant(5, "Albert", "Einstein", "10 avenue Relativité",
                "Allemande", "14/03/1879", "06 55 66 77 88",
                "albert.einstein@mail.com", "Newton",
                "ETH Zurich", "Albert_Einstein.jpg");
    }

    // Créer un étudiant 6
    static Etudiant etudiant6() {
        return new Etudiant(6, "Isaac", "Newton", "20 rue Gravité",
                "Anglaise", "04/01/1643", "06 99 88 77 66",
                "isaac.newton@mail.com", "Galilée",
                "Université de Cambridge", "Isaac_Newton.jpg");
    }

    // Créer un étudiant 7
    static Etudiant etudiant7() {
        return new Etudiant(7, "Ada", "Lovelace", "15 boulevard Algorithmique",
                "Anglaise", "10/12/1815", "06 44 33 22 11",
                "ada.lovelace@mail.com", "Byron",
                "Université de Londres", "Ada_Lovelace.jpg");
    }

    // Créer un étudiant 8
    static Etudiant etudiant8() {
        return new Etudiant(8, "Charles", "Darwin", "25 avenue Evolution",
                "Anglaise", "12/02/1809", "06 77 88 99 00",
                "charles.darwin@mail.com", "Wallace",
                "Université d'Édimbourg", "Charles_Darwin.jpg");
    }

    // Créer un étudiant 9
    static Etudiant etudiant9() {
        return new Etudiant(9, "Galileo", "Galilei", "30 rue Astronomie",
                "Italienne", "15/02/1564", "06 22 33 44 55",
                "galileo.galilei@mail.com", "Copernic",
                "Université de Pise", "Galileo_Galilei.jpg");
    }

    // Créer un étudiant 10
    static Etudiant etudiant10() {
        return new Etudiant(10, "Leonardo", "Da Vinci", "40 rue Renaissance",
                "Italienne", "15/04/1452", "06 66 77 88 99",
                "leonardo.davinci@mail.com", "Michelangelo",
                "Académie des Beaux-Arts", "Leonardo_DaVinci.jpg");
    }

    // Créer un étudiant japonais 1
    static Etudiant etudiant1Japonais() {
        return new Etudiant(10, "Hiroshi", "Tanaka", "7 rue Sakura",
                "Japonaise", "25/07/2005", "08 12 34 56 78",
                "hiroshi.tanaka@mail.com", "Yamato", "Université de Tokyo", "Hiroshi_Tanaka.jpg");
    }

    // Créer un étudiant japonais 2
    static Etudiant etudiant2Japonais() {
        return new Etudiant(11, "Yuki", "Sato", "10 rue Fuji",
                "Japonaise", "11/04/2004", "09 13 14 15 16",
                "yuki.sato@mail.com", "Hana", "Université de Kyoto", "Yuki_Sato.jpg");
    }

    // Créer un étudiant japonais 3
    static Etudiant etudiant3Japonais() {
        return new Etudiant(12, "Akira", "Nakamura", "15 avenue Shibuya",
                "Japonaise", "22/03/2003", "06 11 23 34 45",
                "akira.nakamura@mail.com", "Kaito", "Université de Osaka", "Akira_Nakamura.jpg");
    }

    // Créer un étudiant japonais 4
    static Etudiant etudiant4Japonais() {
        return new Etudiant(13, "Mai", "Kobayashi", "30 rue Kyoto",
                "Japonaise", "18/09/1999", "06 55 66 77 88",
                "mai.kobayashi@mail.com", "Yuki", "Université de Hokkaido", "Mai_Kobayashi.jpg");
    }

    // Créer un étudiant japonais 5
    static Etudiant etudiant5Japonais() {
        return new Etudiant(14, "Ren", "Yamamoto", "20 rue Koi",
                "Japonaise", "12/01/2000", "06 22 33 44 55",
                "ren.yamamoto@mail.com", "Kazu", "Université de Wako", "Ren_Yamamoto.jpg");
    }

    // Créer un étudiant japonais 6
    static Etudiant etudiant6Japonais() {
        return new Etudiant(15, "Haruto", "Takahashi", "8 rue Nara",
                "Japonaise", "29/06/2004", "06 99 00 11 22",
                "haruto.takahashi@mail.com", "Ryuu", "Université de Kyoto", "Haruto_Takahashi.jpg");
    }

    // Créer un étudiant japonais 7
    static Etudiant etudiant7Japonais() {
        return new Etudiant(16, "Sakura", "Yoshida", "17 avenue Tokyo",
                "Japonaise", "05/11/1998", "06 77 88 99 00",
                "sakura.yoshida@mail.com", "Haruki", "Université de Sapporo", "Sakura_Yoshida.jpg");
    }

    // Créer un étudiant japonais 8
    static Etudiant etudiant8Japonais() {
        return new Etudiant(17, "Yuto", "Fujimoto", "10 rue Hokkaido",
                "Japonaise", "01/02/2006", "06 44 33 22 11",
                "yuto.fujimoto@mail.com", "Kaito", "Université de Nagoya", "Yuto_Fujimoto.jpg");
    }

    // Créer un étudiant japonais 9
    static Etudiant etudiant9Japonais() {
        return new Etudiant(18, "Kaito", "Inoue", "25 rue Tokyo",
                "Japonaise", "13/08/2001", "06 55 66 77 88",
                "kaito.inoue@mail.com", "Ryuu", "Université de Keio", "Kaito_Inoue.jpg");
    }

    // Créer un étudiant japonais 10
    static Etudiant etudiant10Japonais() {
        return new Etudiant(19, "Nina", "Matsumoto", "9 rue Shin",
                "Japonaise", "23/05/2002", "06 22 33 44 55",
                "nina.matsumoto@mail.com", "Haruto", "Université de Tokyo", "Nina_Matsumoto.jpg");
    }
}