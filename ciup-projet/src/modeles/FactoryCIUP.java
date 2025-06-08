package modeles;

/**
 * Classe factory pour cr�er des instances pr�-configur�es des objets du mod�le CIUP.
 * <p>
 * Cette classe impl�mente le pattern Factory pour faciliter la cr�ation d'objets
 * de test et d'exemples avec des donn�es coh�rentes. Elle fournit des m�thodes
 * statiques pour cr�er des maisons, services et �tudiants pr�-configur�s.
 * </p>
 * <p>
 * Utilis�e principalement pour l'initialisation de l'application avec des donn�es
 * de d�monstration et pour les tests unitaires.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see MaisonInternationale
 * @see MaisonClassique
 * @see Service
 * @see Etudiant
 */
public class FactoryCIUP {

    /**
     * Cr�e une instance pr�-configur�e de maison internationale.
     * <p>
     * Retourne une maison internationale avec des donn�es d'exemple
     * typiques pour les tests et d�monstrations.
     * </p>
     * 
     * @return Une maison internationale pr�-configur�e
     */
    public static MaisonInternationale creeMaisonInternationale() {
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

    /**
     * Cr�e une instance pr�-configur�e de maison classique fran�aise.
     * <p>
     * Retourne une maison classique avec nationalit� fran�aise et
     * une liste d'�tudiants fran�ais pr�-d�finis.
     * </p>
     * 
     * @return Une maison classique fran�aise avec �tudiants
     */
    public static MaisonClassique maisonFrancaise() {
        MaisonClassique maison = new MaisonClassique();

        // Maison
        maison.setNum(1);
        maison.setNom("Francaise");
        maison.setDesc("Maison classique type");
        maison.setTel("01 23 45 67 89");
        maison.setLocalisation("Paris");
        maison.setDirecteur("Directeur Emmanuel");
        maison.setAnneeCreation(1990);
        maison.setDateFete("01/11");
        maison.setDureeFete(1);

        // Maison Classique
        maison.setNationalite("Francaise");
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

    /**
     * Cr�e une instance pr�-configur�e de maison classique japonaise.
     * <p>
     * Retourne une maison classique avec nationalit� japonaise et
     * une liste d'�tudiants japonais pr�-d�finis.
     * </p>
     * 
     * @return Une maison classique japonaise avec �tudiants
     */
    public static MaisonClassique maisonJaponaise() {
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

    /**
     * Cr�e une instance pr�-configur�e du service de restauration.
     * <p>
     * Service ouvert de 8h � 20h pour la restauration des �tudiants.
     * </p>
     * 
     * @return Un service de restauration pr�-configur�
     */
    public static Service creeServiceRestauration() {
        Service service = new Service();
        service.setNum(1);
        service.setNom("Service de restauration");
        service.setDesc("Service de restauration pour les etudiants");
        service.setHeureOuv(8);
        service.setHeureFerm(20);

        return service;
    }

    /**
     * Cr�e une instance pr�-configur�e du service de s�curit�.
     * <p>
     * Service ouvert 24h/24 pour la s�curit� des �tudiants.
     * </p>
     * 
     * @return Un service de s�curit� pr�-configur�
     */
    public static Service creeServiceSecurite() {
        Service service = new Service();
        service.setNum(2);
        service.setNom("Service de securite");
        service.setDesc("Service de securite pour les etudiants");
        service.setHeureOuv(0);
        service.setHeureFerm(24);

        return service;
    }

    /**
     * Cr�e un �tudiant fran�ais d'exemple (Nathan Thanna).
     * <p>
     * Premier �tudiant de la liste des �tudiants fran�ais avec
     * des informations compl�tes pr�-d�finies.
     * </p>
     * 
     * @return Un �tudiant fran�ais pr�-configur�
     */
    public static Etudiant etudiant1() {
        return new Etudiant(1, "Nathan", "Thanna", "9 rue jolie",
                "Francaise", "29/10/2006", "06 07 08 09 10",
                "Nathan.thanna@mail.com", "Voltaire",
                "Paris-Saclay", "Nathan_Thanna.jpg");
    }

    /**
     * Cr�e un �tudiant fran�ais d'exemple (Alice Dupont).
     * 
     * @return Un �tudiant fran�ais pr�-configur�
     */
    public static Etudiant etudiant2() {
        return new Etudiant(2, "Alice", "Dupont", "15 avenue des Champs",
                "Francaise", "15/03/2005", "07 08 09 10 11",
                "alice.dupont@mail.com", "Victor Hugo",
                "Sorbonne", "Alice_Dupont.jpg");
    }

    /**
     * Cr�e un �tudiant fran�ais d'exemple (Jean Martin).
     * 
     * @return Un �tudiant fran�ais pr�-configur�
     */
    public static Etudiant etudiant3() {
        return new Etudiant(3, "Jean", "Martin", "20 boulevard Haussmann",
                "Francaise", "10/12/2004", "06 12 34 56 78",
                "jean.martin@mail.com", "Moliere",
                "Universite de Lyon", "Jean_Martin.jpg");
    }

    /**
     * Cr�e un �tudiant fran�ais d'exemple (Marie Curie).
     * 
     * @return Un �tudiant fran�ais pr�-configur�
     */
    public static Etudiant etudiant4() {
        return new Etudiant(4, "Marie", "Curie", "5 rue des Sciences",
                "Francaise", "07/11/1867", "06 11 22 33 44",
                "marie.curie@mail.com", "Pasteur",
                "Universite de Paris", "Marie_Curie.jpg");
    }

    /**
     * Cr�e un �tudiant allemand d'exemple (Albert Einstein).
     * 
     * @return Un �tudiant allemand pr�-configur�
     */
    public static Etudiant etudiant5() {
        return new Etudiant(5, "Albert", "Einstein", "10 avenue Relativite",
                "Allemande", "14/03/1879", "06 55 66 77 88",
                "albert.einstein@mail.com", "Newton",
                "ETH Zurich", "Albert_Einstein.jpg");
    }

    /**
     * Cr�e un �tudiant anglais d'exemple (Isaac Newton).
     * 
     * @return Un �tudiant anglais pr�-configur�
     */
    public static Etudiant etudiant6() {
        return new Etudiant(6, "Isaac", "Newton", "20 rue Gravite",
                "Anglaise", "04/01/1643", "06 99 88 77 66",
                "isaac.newton@mail.com", "Galilee",
                "Universite de Cambridge", "Isaac_Newton.jpg");
    }

    /**
     * Cr�e un �tudiant anglais d'exemple (Ada Lovelace).
     * 
     * @return Un �tudiant anglais pr�-configur�
     */
    public static Etudiant etudiant7() {
        return new Etudiant(7, "Ada", "Lovelace", "15 boulevard Algorithmique",
                "Anglaise", "10/12/1815", "06 44 33 22 11",
                "ada.lovelace@mail.com", "Byron",
                "Universite de Londres", "Ada_Lovelace.jpg");
    }

    /**
     * Cr�e un �tudiant anglais d'exemple (Charles Darwin).
     * 
     * @return Un �tudiant anglais pr�-configur�
     */
    public static Etudiant etudiant8() {
        return new Etudiant(8, "Charles", "Darwin", "25 avenue Evolution",
                "Anglaise", "12/02/1809", "06 77 88 99 00",
                "charles.darwin@mail.com", "Wallace",
                "Universite d'edimbourg", "Charles_Darwin.jpg");
    }

    /**
     * Cr�e un �tudiant italien d'exemple (Galileo Galilei).
     * 
     * @return Un �tudiant italien pr�-configur�
     */
    public static Etudiant etudiant9() {
        return new Etudiant(9, "Galileo", "Galilei", "30 rue Astronomie",
                "Italienne", "15/02/1564", "06 22 33 44 55",
                "galileo.galilei@mail.com", "Copernic",
                "Universite de Pise", "Galileo_Galilei.jpg");
    }

    /**
     * Cr�e un �tudiant italien d'exemple (Leonardo Da Vinci).
     * 
     * @return Un �tudiant italien pr�-configur�
     */
    public static Etudiant etudiant10() {
        return new Etudiant(10, "Leonardo", "Da Vinci", "40 rue Renaissance",
                "Italienne", "15/04/1452", "06 66 77 88 99",
                "leonardo.davinci@mail.com", "Michelangelo",
                "Academie des Beaux-Arts", "Leonardo_DaVinci.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Hiroshi Tanaka).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant1Japonais() {
        return new Etudiant(10, "Hiroshi", "Tanaka", "7 rue Sakura",
                "Japonaise", "25/07/2005", "08 12 34 56 78",
                "hiroshi.tanaka@mail.com", "Yamato", "Universite de Tokyo", "Hiroshi_Tanaka.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Yuki Sato).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant2Japonais() {
        return new Etudiant(11, "Yuki", "Sato", "10 rue Fuji",
                "Japonaise", "11/04/2004", "09 13 14 15 16",
                "yuki.sato@mail.com", "Hana", "Universite de Kyoto", "Yuki_Sato.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Akira Nakamura).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant3Japonais() {
        return new Etudiant(12, "Akira", "Nakamura", "15 avenue Shibuya",
                "Japonaise", "22/03/2003", "06 11 23 34 45",
                "akira.nakamura@mail.com", "Kaito", "Universite de Osaka", "Akira_Nakamura.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Mai Kobayashi).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant4Japonais() {
        return new Etudiant(13, "Mai", "Kobayashi", "30 rue Kyoto",
                "Japonaise", "18/09/1999", "06 55 66 77 88",
                "mai.kobayashi@mail.com", "Yuki", "Universite de Hokkaido", "Mai_Kobayashi.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Ren Yamamoto).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant5Japonais() {
        return new Etudiant(14, "Ren", "Yamamoto", "20 rue Koi",
                "Japonaise", "12/01/2000", "06 22 33 44 55",
                "ren.yamamoto@mail.com", "Kazu", "Universite de Wako", "Ren_Yamamoto.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Haruto Takahashi).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant6Japonais() {
        return new Etudiant(15, "Haruto", "Takahashi", "8 rue Nara",
                "Japonaise", "29/06/2004", "06 99 00 11 22",
                "haruto.takahashi@mail.com", "Ryuu", "Universite de Kyoto", "Haruto_Takahashi.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Sakura Yoshida).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant7Japonais() {
        return new Etudiant(16, "Sakura", "Yoshida", "17 avenue Tokyo",
                "Japonaise", "05/11/1998", "06 77 88 99 00",
                "sakura.yoshida@mail.com", "Haruki", "Universite de Sapporo", "Sakura_Yoshida.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Yuto Fujimoto).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant8Japonais() {
        return new Etudiant(17, "Yuto", "Fujimoto", "10 rue Hokkaido",
                "Japonaise", "01/02/2006", "06 44 33 22 11",
                "yuto.fujimoto@mail.com", "Kaito", "Universite de Nagoya", "Yuto_Fujimoto.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Kaito Inoue).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant9Japonais() {
        return new Etudiant(18, "Kaito", "Inoue", "25 rue Tokyo",
                "Japonaise", "13/08/2001", "06 55 66 77 88",
                "kaito.inoue@mail.com", "Ryuu", "Universite de Keio", "Kaito_Inoue.jpg");
    }

    /**
     * Cr�e un �tudiant japonais d'exemple (Nina Matsumoto).
     * 
     * @return Un �tudiant japonais pr�-configur�
     */
    public static Etudiant etudiant10Japonais() {
        return new Etudiant(19, "Nina", "Matsumoto", "9 rue Shin",
                "Japonaise", "23/05/2002", "06 22 33 44 55",
                "nina.matsumoto@mail.com", "Haruto", "Universite de Tokyo", "Nina_Matsumoto.jpg");
    }
}
/**
 * cette classe a �t� cr�e par @author Flavio Zamperlini
 */