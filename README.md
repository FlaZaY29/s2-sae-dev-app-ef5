# Projet-Transverse - CIUP

## 📚 Introduction

Le projet SAE S2 consiste à concevoir et développer une application interactive de gestion pour la **Cité Internationale Universitaire de Paris (CIUP)**.  
L’application sera réalisée en utilisant les concepts de la **Qualité, des Interfaces Homme-Machine (IHM) et du Développement Orienté Objet (DOO)**.  

L'objectif principal est de gérer différents aspects de la CIUP, tels que :  
- La **gestion des maisons** (ajout, suppression, modification).  
- L’**inscription des étudiants** avec répartition automatique selon la nationalité et les disponibilités.  
- La **gestion des services** de la maison internationale (bibliothèque, cafétéria, administration, etc.).  
- La **gestion des étudiants** (suivi des alumni, événements, invitations).  

Ce projet sera réalisé en groupe de **4 étudiants** et impliquera plusieurs rendus collectifs et individuels.

## Importer le projet dans Eclipse

1. Ouvrir Eclipse.
2. Aller dans `File > Import > Existing Projects into Workspace`.
3. Sélectionner le dossier du projet cloné.
4. Valider.

## Configurer les tests

1. Clic droit sur le projet > `Properties > Java Build Path > Source`.
2. Cliquer sur `Add Folder...`.
3. Cocher le dossier `tests/` pour l’ajouter.
4. Appliquer et fermer.

## Activer les assertions

1. Aller dans `Run > Run Configurations... > Arguments`.
2. Dans la section `VM arguments`, ajouter : `-ea`
---

## Compiler automatiquement

1. Vérifier que `Project > Build Automatically` est bien activé.

## Lancer les tests

Le fichier CIUPTest contient `main()` avec tous les appels de test.

### Pour lancer les tests :

1. Clic droit sur le fichier CIUPTest avec les tests.
2. Sélectionner `Run As > Java Application`.
3. Lire les résultats.

## Répartition des tests

| Classe Java             | Auteur des tests |
|------------------------|------------------|
| `Maison`               | Donald Se         | 
| `MaisonClassique`      | Donald Se         | 
| `MaisonInternationale` | Zamperlini Flavio         |
| `Etudiant`             | Zamperlini Flavio         | |
| `CIUPTest`               | Urkmez Yavuz (abandon)         |
| `Service`              | Mouhou Maksen         |


## 🏗️ Structure du Projet

Le projet suit une architecture **MVC** (Modèle-Vue-Contrôleur) :

```{code}
ciup-projet/
├── src/
│   ├── modeles/
│   │   ├── CIUP.java
│   │   ├── Etudiant.java
│   │   ├── FactoryCIUP.java
│   │   ├── Maison.java
│   │   ├── MaisonClassique.java
│   │   ├── MaisonInternationale.java
│   │   └── Service.java
│   ├── vues/
│   │   ├── MainFrame.java
│   │   ├── MaisonPanel.java
│   │   ├── EtudiantPanel.java
│   │   └── ... (autres vues Swing)
│   ├── controleurs/
│   │   ├── MainControleur.java
│   │   ├── MaisonControleur.java
│   │   └── PersistenceControleur.java
│   ├── rapports/
│   │   └── (rapports générés, logs, etc.)
│   └── application/
│       └── Main.java
├── tests/
│   └── ciuptest/
│       ├── CIUPTest.java
│       ├── EtudiantTest.java
│       ├── MaisonClassiqueTest.java
│       ├── MaisonInternationaleTest.java
│       ├── MaisonTest.java
│       └── ServiceTest.java
├── Rapports_CIUP/
│   ├── SAE1256_DOO_Rapport_EF5.pdf
│   ├── SAE1256_DOO_JavaSwing_Rapport_EF5.pdf
│   ├── SAE1256_QUALITE_Rapport_EF5.pdf
│   └── SAE1256_DIAPO_EF5.pdf
└── README.md
```

- **modeles/** : Toutes les classes métier (logique, données)
- **vues/** : Les interfaces graphiques Java Swing (IHM)
- **controleurs/** : Les classes qui font le lien entre vues et modèles
- **rapports/** : Génération de rapports, logs, etc.
- **application/** : Point d’entrée de l’application (Main.java)
- **tests/** : Tests unitaires
- **Rapports_CIUP/** : Tous les rapports PDF et diaporamas

Le projet est divisé en plusieurs domaines spécifiques :

### 🔹 Développement Orienté Objet (DOO) - R2.01
- Programmation en **Java**  
- Conception du modèle objet (diagrammes UML)  
- Gestion des classes et des objets de manière optimisée 

### 🔹 Interfaces Homme-Machine (IHM) - R2.02
- Conception et développement de l’interface utilisateur  
- Maquettes et storyboards réalisés avec **Figma**  
- Tests utilisateurs  

### 🔹 Qualité et Gestion du Projet - R2.03
- Gestion du dépôt **GitHub**
- Auto-évaluation et amélioration continue du code  

---

## 🛠️ Technologies Utilisées

- **Java** : Langage de programmation principal  
- **Java Swing** : Interface graphique (IHM)  
- **Visual Studio Code / Eclipse / IntelliJ** : Environnement de développement  
- **Visual Paradigm** : Modélisation UML  
- **GitHub** : Gestion du code et versioning 
- **Git** : collaboration via GitHub
- **Figma** : Conception UI et maquettes
- **Trello** : Gestion projet
- **Whats-App et Discord** : Outils de communication

---

## ⚙️ Fonctionnalités Principales

1. **Gestion des maisons**  
   - Création, modification et suppression des maisons  
   - Affichage des caractéristiques (nom, localisation, nationalité, nombre de chambres, etc.)  

2. **Inscription des étudiants**  
   - Attribution des chambres selon la nationalité et la disponibilité  
   - Gestion des listes d’attente  

3. **Services de la maison internationale**  
   - Bibliothèque, cafétéria, théâtre, piscine, administration...  

4. **Gestion des étudiants**  
   - Historique des promotions  
   - Convocation à la fête annuelle des anciens étudiants  

5. **Autres fonctionnalités optionnelles**  
   - Gestion des soirées et événements dans les maisons  
   - Consultation des menus des Restos U et cafétérias  

---

## 👥 Équipe du Projet

- **Zamperlini Flavio (flavio.zamperlini.pro@gmail.com)**    
- **Se Donald (donaldse175@gmail.com)**
- **Mouhou Maksen (maksenmouhoupro@gmail.com)**  
- **Urkmez Yavuz (yavuz.urk28@gmail.com)**

---

## 📄 Rapports du projet
Voici les documents produits dans le cadre du projet :

[![Rapport DOO](https://img.shields.io/badge/Rapport%20DOO-PDF-red?logo=adobe)](./Rapports_CIUP/SAE1256_DOO_Rapport_EF5.pdf)  
[![Rapport JavaSwing](https://img.shields.io/badge/Rapport%20JavaSwing-PDF-orange?logo=adobe)](./Rapports_CIUP/SAE1256_DOO_JavaSwing_Rapport_EF5.pdf)  
[![Rapport IHM](https://img.shields.io/badge/Rapport%20IHM-PDF-blue?logo=adobe)](./Rapports_CIUP/SAE1256_IHM_Rapport_EF5.pdf)   
[![Diaporama](https://img.shields.io/badge/Diaporama-PDF-green?logo=adobe)](./Rapports_CIUP/SAE1256_EF5_Soutenance.pdf)  

---

## 🔗 Liens Utiles

📄 **Documentation & Organisation**  
➡ [Google Docs](https://docs.google.com/document/d/1c_2ppuIT3E9pp6ZNnX-7VzV8bTorZlhN7kKHOdiDUgU/edit?tab=t.l6x6zdx2wss)  

🎨 **Design UI**  
➡ [Figma](https://www.figma.com/proto/5iaNvVvNolBQGIhYoBzMJ7/Projet-Transverse?t=RdrZv00osE9omSGz-1&scaling=min-zoom&content-scaling=fixed&page-id=108%3A189&node-id=126-143&starting-point-node-id=126%3A143)  

📋 **Gestion du projet**  
➡ [Trello](https://trello.com/invite/b/67b373e98c14354f8b719270/ATTI4a2b470552a1d4217687f450f279356f7850FB59/projet-transverse)  

---

## 🚀 Comment Contribuer ?

1. **Cloner le projet**  
   ```bash
   git clone https://github.com/FlaZaY29/s2-sae-dev-app-ef5.git

