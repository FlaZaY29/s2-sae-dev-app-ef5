package CIUP;

public class MaisonClassique {

	private String nationalite;
	private int placeDispo;
	private int nbPlace;

	// Constructeur
    public MaisonClassique(String nationalite, int nbPlace) {
        this.nationalite = nationalite;
        this.nbPlace = nbPlace;
        this.placeDispo = nbPlace;
    }

    // Méthode pour inscrire un étudiant (si des places sont disponibles)
    public boolean inscrireEtudiant(Etudiant etu) {
        if (placeDispo > 0) {
            placeDispo--;
            return true;
        }
        return false; 
    }

    // Méthode pour annuler l'inscription d'un étudiant (libère une place)
    public void annulerInscription() {
        if (placeDispo < nbPlace) {
            placeDispo++;
        }
    }

    // Getter et Setter
    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getPlaceDispo() {
        return placeDispo;
    }

    public void setPlaceDispo(int placeDispo) {
        this.placeDispo = placeDispo;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }
}