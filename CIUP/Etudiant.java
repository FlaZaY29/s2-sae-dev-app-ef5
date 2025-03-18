package CIUP;

public class Etudiant {

	private int num;
	private String nom;
	private String prenom;
	private String adresse;
	private String nationalite;
	private String dateNaissance;
	private String tel;
	private String email;
	private String promotion;
	private String universite;
	private String pieceIdentite;
	private boolean actuEtudiant;
	Maison maisonActuelle;


	public Etudiant(int num, String nom, String prenom, String adresse, String nationalite, String dateNaissance, String tel, String email, String promotion, String universite, String pieceIdentite) {
	    this.num = num;
	    this.nom = nom;
	    this.prenom = prenom;
	    this.adresse = adresse;
	    this.nationalite = nationalite;
	    this.dateNaissance = dateNaissance;
	    this.tel = tel;
	    this.email = email;
	    this.promotion = promotion;
	    this.universite = universite;
	    this.pieceIdentite = pieceIdentite;
	    this.actuEtudiant = true; // l'etudiant est actuellement dans sa periode d'etude
	    this.maisonActuelle = null; // l'etudiant n'est pas encore affecte a une maison
	}

	public String to_String()
	{
		String s = "";
		s += num;
		s += " ; " + nom;
		s += " ; " + prenom;
		s += " ; " + adresse;
		s += " ; " + nationalite;
		s += " ; " + dateNaissance;
		s += " ; " + tel;
		s += " ; " + email;
		s += " ; " + promotion;
		s += " ; " + universite;
		return s;
	}
	public void afficheInfo() {
		System.out.println(to_String());
	}

	public void afficheInfoResume() {
		System.out.println(num + " ; " + nom + " ; " + prenom + " ; " + promotion + " ; " + universite);
	}


}