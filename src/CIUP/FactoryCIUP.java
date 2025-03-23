package CIUP;

import java.util.ArrayList;

public class FactoryCIUP {

    // Créer une maisonClassique FrancoBritannique
    static MaisonClassique maisonFrancoBritannique() {
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

        maison.listeEtudiant = new ArrayList<Etudiant>();

        Etudiant etudiant1 = new Etudiant(1, "Nathan", "Thanna", "9 rue jolie",
                "Française", "29/10/2006", "06 07 08 09 10",
                "Nathan.thanna@mail.com", "Voltaire",
                "Paris-Saclay", "Nathan_Thanna.jpg");

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

        maison.listeEtudiant = new ArrayList<Etudiant>();

        Etudiant etudiant1 = new Etudiant(1, "Hiroshi", "Tanaka", "7 rue Sakura",
                "Japonaise", "25/07/2005", "08 12 34 56 78",
                "hiroshi.tanaka@mail.com", "Yamato", "Université de Tokyo", "Hiroshi_Tanaka.jpg");

        Etudiant etudiant2 = new Etudiant(2, "Yuki", "Sato", "10 rue Fuji",
                "Japonaise", "11/04/2004", "09 13 14 15 16",
                "yuki.sato@mail.com", "Hana", "Université de Kyoto", "Yuki_Sato.jpg");

        Etudiant etudiant3 = new Etudiant(3, "Akira", "Nakamura", "15 avenue Shibuya",
                "Japonaise", "22/03/2003", "06 11 23 34 45",
                "akira.nakamura@mail.com", "Kaito", "Université de Osaka", "Akira_Nakamura.jpg");

        Etudiant etudiant4 = new Etudiant(4, "Mai", "Kobayashi", "30 rue Kyoto",
                "Japonaise", "18/09/1999", "06 55 66 77 88",
                "mai.kobayashi@mail.com", "Yuki", "Université de Hokkaido", "Mai_Kobayashi.jpg");

        Etudiant etudiant5 = new Etudiant(5, "Ren", "Yamamoto", "20 rue Koi",
                "Japonaise", "12/01/2000", "06 99 88 77 66",
                "ren.yamamoto@mail.com", "Nori", "Université de Tohoku", "Ren_Yamamoto.jpg");

        Etudiant etudiant6 = new Etudiant(6, "Haruka", "Watanabe", "5 rue Asakusa",
                "Japonaise", "02/06/2001", "07 88 99 00 11",
                "haruka.watanabe@mail.com", "Sakura", "Université de Nagoya", "Haruka_Watanabe.jpg");

        Etudiant etudiant7 = new Etudiant(7, "Ichiro", "Fujita", "25 rue Sumo",
                "Japonaise", "14/07/2002", "08 77 66 55 44",
                "ichiro.fujita@mail.com", "Takashi", "Université de Keio", "Ichiro_Fujita.jpg");

        Etudiant etudiant8 = new Etudiant(8, "Naomi", "Matsumoto", "40 rue Zen",
                "Japonaise", "30/05/2000", "09 22 33 44 55",
                "naomi.matsumoto@mail.com", "Eiko", "Université de Meiji", "Naomi_Matsumoto.jpg");

        Etudiant etudiant9 = new Etudiant(9, "Taro", "Kobayashi", "50 rue Meiji",
                "Japonaise", "07/10/2000", "06 33 44 55 66",
                "taro.kobayashi@mail.com", "Shinji", "Université de Chuo", "Taro_Kobayashi.jpg");

        Etudiant etudiant10 = new Etudiant(10, "Sora", "Suzuki", "8 rue Shinto",
                "Japonaise", "20/02/1998", "06 44 55 66 77",
                "sora.suzuki@mail.com", "Mika", "Université de Rikkyo", "Sora_Suzuki.jpg");

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

        return maison;
    }

    // Créer une maisoninter
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
        service.setNum(1);
        service.setNom("Service");
        service.setDesc("Description du service");
        service.setHeureOuv(8);
        service.setHeureFerm(20);

        service.sesMaison = new ArrayList<MaisonInternationale>();

        return service;
    }

    // Créer un étudiant
    static Etudiant creeEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNum(1);
        etudiant.setNom("Nom");
        etudiant.setPrenom("Prenom");
        etudiant.setAdresse("Adresse");
        etudiant.setNationalite("Française");
        etudiant.setDateNaissance("01/01/2000");
        etudiant.setTel("06 07 08 09 10");
        etudiant.setEmail("mail.mail@mail.com");
        etudiant.setPromotion("Promotion 2025");
        etudiant.setUniversite("Université de Paris-Saclay");
        etudiant.setPieceIdentite("Carte d'identité N°123456789");
        etudiant.setActuEtudiant(true);
        etudiant.setEnAttente(false);
        etudiant.setMaisonActuelle(new MaisonClassique());

        return etudiant;
    }
}