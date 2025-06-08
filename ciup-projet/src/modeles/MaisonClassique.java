package modeles;

import java.util.ArrayList;

/**
 * Classe représentant une maison classique dans le système CIUP.
 * <p>
 * Une maison classique est caractérisée par une nationalité spécifique
 * et une capacité d'accueil limitée. Elle gère directement les étudiants
 * qui y résident ainsi qu'une liste d'attente pour les demandes excédentaires.
 * </p>
 * <p>
 * Cette classe implémente la logique de gestion des places disponibles
 * et du système de liste d'attente automatique.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Maison
 * @see Etudiant
 */
public class MaisonClassique extends Maison {
	private static final long serialVersionUID = 1L;

	/** Liste des étudiants actuellement logés dans la maison */
    private ArrayList<Etudiant> listeEtudiant;
    
    /** Liste des étudiants en attente d'une place dans la maison */
    private ArrayList<Etudiant> listeAttente;

    /** Nationalité principale de la maison */
    private String nationalite;
    
    /** Capacité maximale d'accueil de la maison */
    private int capacite;

    /**
     * Constructeur complet pour créer une maison classique.
     * <p>
     * Initialise automatiquement les listes d'étudiants et d'attente.
     * </p>
     * 
     * @param num Numéro unique d'identification
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel Numéro de téléphone
     * @param localisation Localisation géographique
     * @param directeur Nom du directeur
     * @param anneeCreation Année de création
     * @param dateFete Date de la fête annuelle
     * @param dureeFete Durée de la fête en jours
     */
    public MaisonClassique(int num, String nom, String desc, String tel, String localisation, String directeur,
                           int anneeCreation, String dateFete, int dureeFete) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
        // Initialiser les listes dans tous les constructeurs
        this.listeEtudiant = new ArrayList<>();
        this.listeAttente = new ArrayList<>();
    }

    /**
     * Constructeur par défaut.
     * <p>
     * Crée une maison classique avec des valeurs par défaut et
     * initialise les listes d'étudiants.
     * </p>
     */
    public MaisonClassique() {
        super();
        this.listeEtudiant = new ArrayList<>();
        this.listeAttente = new ArrayList<>();
    }

    /**
     * Ajoute un étudiant à la maison ou en liste d'attente.
     * <p>
     * Si la maison n'est pas pleine, l'étudiant est directement ajouté.
     * Sinon, il est placé en liste d'attente automatiquement.
     * </p>
     * 
     * @param etu L'étudiant à ajouter
     */
    public void ajoutEtudiant(Etudiant etu) {
        // Vérifier si la liste des étudiants est initialisée
        if (listeEtudiant == null) {
            listeEtudiant = new ArrayList<>();
        }
        
        if (listeEtudiant.size() < capacite) {
            listeEtudiant.add(etu);
            etu.setActuEtudiant(true);
        } else {
            System.out.println("La maison est pleine mise en liste d'attente");
            ajoutEtudiantAttente(etu);
        }
    }

    /**
     * Supprime un étudiant de la maison et gère la liste d'attente.
     * <p>
     * Après suppression, si des étudiants sont en attente, le premier
     * de la liste est automatiquement affecté à la place libérée.
     * </p>
     * 
     * @param etu L'étudiant à supprimer
     */
    public void supprEtudiant(Etudiant etu) {
        // Vérifier si la liste des étudiants est initialisée
        if (listeEtudiant == null) {
            listeEtudiant = new ArrayList<>();
            return;
        }
        
        if (listeEtudiant.contains(etu)) {
            listeEtudiant.remove(etu);
            System.out.println("L'etudiant a ete supprime de la maison");
            etu.setActuEtudiant(false);
        } else {
            System.out.println("L'etudiant n'est pas present dans la maison");
        }

        // Vérifier si la liste d'attente est initialisée
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
            return;
        }
        
        if (listeAttente.size() > 0) {
            Etudiant etuAttente = listeAttente.get(0);
            listeAttente.remove(0);
            ajoutEtudiant(etuAttente);
            etuAttente.setEnAttente(false);
            System.out.println("Un etudiant de la liste d'attente a ete ajoute a la maison");
        }
    }

    /**
     * Affiche la liste des étudiants logés dans la maison.
     * <p>
     * Affiche le nom et prénom de chaque étudiant résidant actuellement
     * dans la maison.
     * </p>
     */
    public void afficheEtudiants() {
        // Vérifier si la liste des étudiants est initialisée
        if (listeEtudiant == null) {
            listeEtudiant = new ArrayList<>();
            System.out.println("Aucun étudiant dans la maison " + getNom());
            return;
        }
        
        System.out.println("Liste des etudiants dans la maison " + getNom() + ":");

        for (Etudiant etu : listeEtudiant) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    /**
     * Ajoute un étudiant à la liste d'attente.
     * <p>
     * L'étudiant est marqué comme étant en attente.
     * </p>
     * 
     * @param etu L'étudiant à mettre en attente
     */
    public void ajoutEtudiantAttente(Etudiant etu) {
        // Vérifier si la liste d'attente est initialisée
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
        }
        
        listeAttente.add(etu);
        etu.setEnAttente(true);
    }

    /**
     * Supprime un étudiant de la liste d'attente.
     * <p>
     * L'étudiant n'est plus marqué comme étant en attente.
     * </p>
     * 
     * @param etu L'étudiant à retirer de la liste d'attente
     */
    public void supprEtudiantAttente(Etudiant etu) {
        // Vérifier si la liste d'attente est initialisée
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
            return;
        }
        
        listeAttente.remove(etu);
        etu.setEnAttente(false);
    }

    /**
     * Affiche la liste des étudiants en attente.
     * <p>
     * Affiche le nom et prénom de chaque étudiant en liste d'attente
     * pour cette maison.
     * </p>
     */
    public void afficheEtudiantsAttente() {
        // Vérifier si la liste d'attente est initialisée
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
            System.out.println("Aucun étudiant en attente pour la maison " + getNom());
            return;
        }
        
        System.out.println("Liste des etudiants en attente pour la maison " + getNom() + ":");

        for (Etudiant etu : listeAttente) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    // Getters et Setters avec documentation

    /**
     * Retourne la nationalité principale de la maison.
     * 
     * @return La nationalité de la maison
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * Définit la nationalité principale de la maison.
     * 
     * @param nationalite La nationalité de la maison
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * Retourne la capacité maximale d'accueil.
     * 
     * @return La capacité maximale
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Définit la capacité maximale d'accueil.
     * 
     * @param capacite La capacité maximale
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     * Retourne la liste des étudiants logés.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des étudiants logés
     */
    public ArrayList<Etudiant> getListeEtudiant() {
        // Vérifier si la liste des étudiants est initialisée
        if (listeEtudiant == null) {
            listeEtudiant = new ArrayList<>();
        }
        return listeEtudiant;
    }

    /**
     * Définit la liste des étudiants logés.
     * 
     * @param listeEtudiant La nouvelle liste d'étudiants
     */
    public void setListeEtudiant(ArrayList<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    /**
     * Retourne la liste des étudiants en attente.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des étudiants en attente
     */
    public ArrayList<Etudiant> getListeAttente() {
        // Vérifier si la liste d'attente est initialisée
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
        }
        return listeAttente;
    }

    /**
     * Définit la liste des étudiants en attente.
     * 
     * @param listeAttente La nouvelle liste d'attente
     */
    public void setListeAttente(ArrayList<Etudiant> listeAttente) {
        this.listeAttente = listeAttente;
    }
}
/**
 * cette classe a été crée par @author Donald Se
 */