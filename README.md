Voici un exemple de `README.md` complet pour votre projet. N'hésitez pas à adapter les sections en fonction des spécificités de votre travail et des technologies utilisées :

```markdown
# Projet Jeu - Système de Labyrinthe

## Description

Ce projet implémente un jeu de labyrinthe où un personnage se déplace à travers des caisses et des dépôts, le tout dans un environnement en 2D. Le but est de résoudre le puzzle en déplaçant les caisses vers les dépôts appropriés. Ce projet a été développé en Java et inclut des fonctionnalités comme la gestion des déplacements, les interactions avec le labyrinthe, et une interface graphique minimale pour visualiser l'état du jeu.

## Technologies Utilisées

- **Java** : Langage de programmation principal.
- **JUnit** : Utilisé pour les tests unitaires afin de garantir le bon fonctionnement des méthodes critiques.
- **Git & GitHub** : Versioning et collaboration sur le code.

## Structure du Projet

Le projet est organisé en plusieurs packages afin de bien séparer les responsabilités :

- `jeu` : Contient les classes principales du jeu (comme `Jeu`, `Perso`, `Labyrinthe`, etc.).
- `graphisme` : Contient les classes pour l'interface graphique, utilisée pour afficher le jeu.
- `test` : Contient les tests unitaires pour valider le comportement des différentes classes et méthodes du jeu.

### Arborescence

```
src/
├── jeu/
│   ├── Jeu.java
│   ├── Perso.java
│   ├── Element.java
│   ├── ListeElements.java
│   └── Labyrinthe.java
├── graphisme/
│   ├── InterfaceGraphique.java
│   └── FenetreJeu.java
└── test/
    ├── JeuTest.java
    └── LabyrintheTest.java
```

## Fonctionnalités

### 1. Déplacement du Personnage

Le personnage peut se déplacer dans les quatre directions de base (haut, bas, gauche, droite). Les déplacements sont gérés par la méthode `deplacerPerso`, qui s'assure que le mouvement est valide en vérifiant la présence de murs et de caisses.

### 2. Interaction avec les Caisses

Le joueur peut déplacer des caisses, à condition qu'elles ne soient pas bloquées par des murs ou d'autres caisses. La méthode `deplacerPerso` vérifie si une caisse peut être déplacée avant de déplacer le personnage.

### 3. Vérification de la Fin du Jeu

Le jeu est considéré comme terminé lorsque toutes les caisses sont placées sur les dépôts. La méthode `etreFini` vérifie si toutes les caisses sont à la bonne position.

### 4. Gestion des Exceptions

Le projet inclut des exceptions personnalisées pour gérer les erreurs. Par exemple, la classe `FichierIncorrectException` est utilisée pour gérer les erreurs liées au chargement des fichiers du jeu.

```java
public class FichierIncorrectException extends Exception { 
    public FichierIncorrectException(String message) {
        super(message);
    }
}
```

## Tests

Des tests unitaires ont été écrits pour valider le comportement du jeu, en particulier pour les méthodes de déplacement et de vérification de la fin du jeu. Ces tests sont situés dans le répertoire `test/`.

Exemple de test pour vérifier les déplacements :

```java
@Test
public void testDeplacementPerso() {
    Jeu jeu = new Jeu();
    jeu.deplacerPerso("haut");
    assertTrue(jeu.getPerso().getY() == 1);
}
## Conclusion

Ce projet a été une bonne opportunité pour mettre en pratique nos connaissances en Java, en particulier sur les concepts de programmation orientée objet, l'utilisation des exceptions, et la gestion de projets avec Git. Nous avons appris à bien organiser notre code en packages, ce qui facilite la maintenance et la collaboration.

---

**Auteurs :**  
[Jassem TAMOURGH]  
[Yanis CHEBBAH]  
```
