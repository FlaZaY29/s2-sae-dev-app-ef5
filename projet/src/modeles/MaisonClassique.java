package modeles;

import java.util.ArrayList;

/**
 * Classe repr�sentant une maison classique dans le syst�me CIUP.
 * <p>
 * Une maison classique est caract�ris�e par une nationalit� sp�cifique
 * et une capacit� d'accueil limit�e. Elle g�re directement les �tudiants
 * qui y r�sident ainsi qu'une liste d'attente pour les demandes exc�dentaires.
 * </p>
 * <p>
 * Cette classe impl�mente la logique de gestion des places disponibles
 * et du syst�me de liste d'attente automatique.
 * </p>
 * 
 * @author CIUP Development Team
 * @version 1.0
 * @see Maison
 * @see Etudiant
 */
public class MaisonClassique extends Maison {
	private static final long serialVersionUID = 1L;

	/** Liste des �tudiants actuellement log�s dans la maison */
    private ArrayList<Etudiant> listeEtudiant;
    
    /** Liste des �tudiants en attente d'une place dans la maison */
    private ArrayList<Etudiant> listeAttente;

    /** Nationalit� principale de la maison */
    private String nationalite;
    
    /** Capacit� maximale d'accueil de la maison */
    private int capacite;

    /**
     * Constructeur complet pour cr�er une maison classique.
     * <p>
     * Initialise automatiquement les listes d'�tudiants et d'attente.
     * </p>
     * 
     * @param num Num�ro unique d'identification
     * @param nom Nom de la maison
     * @param desc Description de la maison
     * @param tel Num�ro de t�l�phone
     * @param localisation Localisation g�ographique
     * @param directeur Nom du directeur
     * @param anneeCreation Ann�e de cr�ation
     * @param dateFete Date de la f�te annuelle
     * @param dureeFete Dur�e de la f�te en jours
     */
    public MaisonClassique(int num, String nom, String desc, String tel, String localisation, String directeur,
                           int anneeCreation, String dateFete, int dureeFete) {
        super(num, nom, desc, tel, localisation, directeur, anneeCreation, dateFete, dureeFete);
        // Initialiser les listes dans tous les constructeurs
        this.listeEtudiant = new ArrayList<>();
        this.listeAttente = new ArrayList<>();
    }

    /**
     * Constructeur par d�faut.
     * <p>
     * Cr�e une maison classique avec des valeurs par d�faut et
     * initialise les listes d'�tudiants.
     * </p>
     */
    public MaisonClassique() {
        super();
        this.listeEtudiant = new ArrayList<>();
        this.listeAttente = new ArrayList<>();
    }

    /**
     * Ajoute un �tudiant � la maison ou en liste d'attente.
     * <p>
     * Si la maison n'est pas pleine, l'�tudiant est directement ajout�.
     * Sinon, il est plac� en liste d'attente automatiquement.
     * </p>
     * 
     * @param etu L'�tudiant � ajouter
     */
    public void ajoutEtudiant(Etudiant etu) {
        // V�rifier si la liste des �tudiants est initialis�e
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
     * Supprime un �tudiant de la maison et g�re la liste d'attente.
     * <p>
     * Apr�s suppression, si des �tudiants sont en attente, le premier
     * de la liste est automatiquement affect� � la place lib�r�e.
     * </p>
     * 
     * @param etu L'�tudiant � supprimer
     */
    public void supprEtudiant(Etudiant etu) {
        // V�rifier si la liste des �tudiants est initialis�e
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

        // V�rifier si la liste d'attente est initialis�e
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
     * Affiche la liste des �tudiants log�s dans la maison.
     * <p>
     * Affiche le nom et pr�nom de chaque �tudiant r�sidant actuellement
     * dans la maison.
     * </p>
     */
    public void afficheEtudiants() {
        // V�rifier si la liste des �tudiants est initialis�e
        if (listeEtudiant == null) {
            listeEtudiant = new ArrayList<>();
            System.out.println("Aucun �tudiant dans la maison " + getNom());
            return;
        }
        
        System.out.println("Liste des etudiants dans la maison " + getNom() + ":");

        for (Etudiant etu : listeEtudiant) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    /**
     * Ajoute un �tudiant � la liste d'attente.
     * <p>
     * L'�tudiant est marqu� comme �tant en attente.
     * </p>
     * 
     * @param etu L'�tudiant � mettre en attente
     */
    public void ajoutEtudiantAttente(Etudiant etu) {
        // V�rifier si la liste d'attente est initialis�e
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
        }
        
        listeAttente.add(etu);
        etu.setEnAttente(true);
    }

    /**
     * Supprime un �tudiant de la liste d'attente.
     * <p>
     * L'�tudiant n'est plus marqu� comme �tant en attente.
     * </p>
     * 
     * @param etu L'�tudiant � retirer de la liste d'attente
     */
    public void supprEtudiantAttente(Etudiant etu) {
        // V�rifier si la liste d'attente est initialis�e
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
            return;
        }
        
        listeAttente.remove(etu);
        etu.setEnAttente(false);
    }

    /**
     * Affiche la liste des �tudiants en attente.
     * <p>
     * Affiche le nom et pr�nom de chaque �tudiant en liste d'attente
     * pour cette maison.
     * </p>
     */
    public void afficheEtudiantsAttente() {
        // V�rifier si la liste d'attente est initialis�e
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
            System.out.println("Aucun �tudiant en attente pour la maison " + getNom());
            return;
        }
        
        System.out.println("Liste des etudiants en attente pour la maison " + getNom() + ":");

        for (Etudiant etu : listeAttente) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }
    }

    // Getters et Setters avec documentation

    /**
     * Retourne la nationalit� principale de la maison.
     * 
     * @return La nationalit� de la maison
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * D�finit la nationalit� principale de la maison.
     * 
     * @param nationalite La nationalit� de la maison
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * Retourne la capacit� maximale d'accueil.
     * 
     * @return La capacit� maximale
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * D�finit la capacit� maximale d'accueil.
     * 
     * @param capacite La capacit� maximale
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     * Retourne la liste des �tudiants log�s.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des �tudiants log�s
     */
    public ArrayList<Etudiant> getListeEtudiant() {
        // V�rifier si la liste des �tudiants est initialis�e
        if (listeEtudiant == null) {
            listeEtudiant = new ArrayList<>();
        }
        return listeEtudiant;
    }

    /**
     * D�finit la liste des �tudiants log�s.
     * 
     * @param listeEtudiant La nouvelle liste d'�tudiants
     */
    public void setListeEtudiant(ArrayList<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    /**
     * Retourne la liste des �tudiants en attente.
     * <p>
     * Initialise la liste si elle n'existe pas encore.
     * </p>
     * 
     * @return ArrayList des �tudiants en attente
     */
    public ArrayList<Etudiant> getListeAttente() {
        // V�rifier si la liste d'attente est initialis�e
        if (listeAttente == null) {
            listeAttente = new ArrayList<>();
        }
        return listeAttente;
    }

    /**
     * D�finit la liste des �tudiants en attente.
     * 
     * @param listeAttente La nouvelle liste d'attente
     */
    public void setListeAttente(ArrayList<Etudiant> listeAttente) {
        this.listeAttente = listeAttente;
    }
}
/**
 * cette classe a �t� cr�e par @author Donald Se
 */