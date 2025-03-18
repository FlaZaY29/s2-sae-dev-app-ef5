package CIUP;

public class Maison {

	private int num;
	private String nom;
	private String desc;
	private String tel;
	private String localisation;
	private String directeur;
	private int anneeCreation;
	private int dateFete;
	private int dureeFete;
	private Etudiant[] listeEtudiant;

    // Constructeur
    public Maison(int num, String nom, String desc, String tel, String localisation, String directeur,
                  int anneeCreation, int dateFete, int dureeFete, int capacite) {
        this.num = num;
        this.nom = nom;
        this.desc = desc;
        this.tel = tel;
        this.localisation = localisation;
        this.directeur = directeur;
        this.anneeCreation = anneeCreation;
        this.dateFete = dateFete;
        this.dureeFete = dureeFete;
        this.listeEtudiant = new Etudiant[capacite];
    }



    // Méthode pour ajouter un étudiant
    public boolean ajoutEtudiant(Etudiant etu) {
        for (int i = 0; i < listeEtudiant.length; i++) {
            if (listeEtudiant[i] == null) {
                listeEtudiant[i] = etu;
                return true;
            }
        }
        return false;
    }

    // Méthode pour supprimer un étudiant
    public boolean supprEtudiant(Etudiant etu) {
        for (int i = 0; i < listeEtudiant.length; i++) {
            if (listeEtudiant[i] != null && listeEtudiant[i].equals(etu)) {
                listeEtudiant[i] = null;
                return true;
            }
        }
        return false; 
    }

    // Méthode pour afficher la description de la maison
    public void afficheDesc() {
        System.out.println("Maison: " + nom);
        System.out.println("Description: " + desc);
        System.out.println("Téléphone: " + tel);
        System.out.println("Localisation: " + localisation);
        System.out.println("Directeur: " + directeur);
        System.out.println("Année de création: " + anneeCreation);
        System.out.println("Date de la fête: " + dateFete);
        System.out.println("Durée de la fête: " + dureeFete + " jours");
    }

    // Méthode pour afficher la liste des étudiants dans la maison
    public void afficherEtudiants() {
        System.out.println("Liste des étudiants dans la maison " + nom + ":");
        for (Etudiant etu : listeEtudiant) {
            if (etu != null) {
                System.out.println(etu.getNom() + " " + etu.getPrenom());
            }
        }
    }

	public void afficheMaison(){
        System.out.println("Maison: " + nom);
	}
}