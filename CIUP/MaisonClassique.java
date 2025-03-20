package CIUP;

import java.util.ArrayList;

public class MaisonClassique extends Maison{

	private String nationalite;
    private int capacite;
	ArrayList<Etudiant> listeEtudiant;
    ArrayList<Etudiant> listeAttente;

	// Constructeur
    public MaisonClassique(int num, String nom, String desc, String tel, String localisation, String directeur,
                           int anneeCreation, String dateFete, int dureeFete, int capacite, String nationalite) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
        this.nationalite = nationalite;
        this.capacite = capacite;
    }
    //constructeur vide
    public MaisonClassique() {
        super();
    }

    // Méthode pour ajouter un étudiant et le mettre en liste d'attente si la maison est pleine
    public void ajoutEtudiant(Etudiant etu) {
        if(listeEtudiant.size() < capacite){
            listeEtudiant.add(etu);
            etu.setActuEtudiant(true);
        }
        else{
            System.out.println("La maison est pleine mise en liste d'attente");
            ajoutEtudiantAttente(etu);
        }
    }

    // Méthode pour supprimer un étudiant et le remplacer par l'étudiant en premiere position de la liste d'attente
    public void supprEtudiant(Etudiant etu) {
        listeEtudiant.remove(etu);
        System.out.println("L'étudiant a été supprimé de la maison");
        etu.setActuEtudiant(false);
        if(listeAttente.size() > 0){
            Etudiant etuAttente = listeAttente.get(0);
            listeAttente.remove(0);
            ajoutEtudiant(etuAttente);
            etuAttente.setEnAttente(false);
        }
        
    }

    // Méthode pour afficher la liste des étudiants dans la maison
    public void afficherEtudiants() {
        System.out.println("Liste des étudiants dans la maison " + getNom() + ":");
        for (Etudiant etu : listeEtudiant) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    // Méthode pour ajouter un étudiant en attente
    public void ajoutEtudiantAttente(Etudiant etu) {
        listeAttente.add(etu);
        etu.setEnAttente(true);
    }

    // Méthode pour supprimer un étudiant de la liste d'attente
    public void supprEtudiantAttente(Etudiant etu) {
        listeAttente.remove(etu);
        etu.setEnAttente(false);
    }

    // Méthode pour afficher la liste des étudiants en attente
    public void afficherEtudiantsAttente() {
        System.out.println("Liste des étudiants en attente pour la maison " + getNom() + ":");
        for (Etudiant etu : listeAttente) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }   

        // Getter et Setter
        public String getNationalite() {
            return nationalite;
        }

        public void setNationalite(String nationalite) {
            this.nationalite = nationalite;
        }
        public int getCapacite() {
            return capacite;
        }
        public void setCapacite(int capacite) {
            this.capacite = capacite;
        }

        
}