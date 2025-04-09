package ciup;

import java.util.ArrayList;

public class MaisonClassique extends Maison {

    // Listes des Etudiant et Etudiant en attente de la MaisonClassique
    private ArrayList<Etudiant> listeEtudiant;
    private ArrayList<Etudiant> listeAttente;

    private String nationalite;
    private int capacite;

    // Constructeur
    public MaisonClassique(int num, String nom, String desc, String tel, String localisation, String directeur,
                           int anneeCreation, String dateFete, int dureeFete) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
    }

    // Constructeur vide
    public MaisonClassique() {
        super();
        this.listeEtudiant = new ArrayList<>();
        this.listeAttente = new ArrayList<>();
    }

    // Méthode pour ajouter un étudiant et le mettre en liste d'attente si la maison est pleine
    public void ajoutEtudiant(Etudiant etu) {
        if (listeEtudiant.size() < capacite) {
            listeEtudiant.add(etu);
            etu.setActuEtudiant(true);
        } else {
            System.out.println("La maison est pleine mise en liste d'attente");
            ajoutEtudiantAttente(etu);
        }
    }

    // Méthode pour supprimer un étudiant et le remplacer par l'étudiant en premiere position de la liste d'attente
    public void supprEtudiant(Etudiant etu) {
        if (listeEtudiant.contains(etu)) {
            listeEtudiant.remove(etu);
            System.out.println("L'étudiant a été supprimé de la maison");
            etu.setActuEtudiant(false);
        } else {
            System.out.println("L'étudiant n'est pas présent dans la maison");
        }

        if (listeAttente.size() > 0) {
            Etudiant etuAttente = listeAttente.get(0);
            listeAttente.remove(0);
            ajoutEtudiant(etuAttente);
            etuAttente.setEnAttente(false);
            System.out.println("Un étudiant de la liste d'attente a été ajouté à la maison");
        }
    }

    // Méthode pour afficher la liste des étudiants dans la maison
    public void afficheEtudiants() {
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
    public void afficheEtudiantsAttente() {
        System.out.println("Liste des étudiants en attente pour la maison " + getNom() + ":");

        for (Etudiant etu : listeAttente) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    // Getter et Setter pour les attributs
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

    public ArrayList<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }

    public void setListeEtudiant(ArrayList<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    public ArrayList<Etudiant> getListeAttente() {
        return listeAttente;
    }

    public void setListeAttente(ArrayList<Etudiant> listeAttente) {
        this.listeAttente = listeAttente;
    }
}