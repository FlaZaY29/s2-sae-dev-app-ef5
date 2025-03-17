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
		s += " ; " + pieceIdentite;
		return s;
	}
	public void afficheInfo() {
		System.out.println(to_String());
	}
	

}