import java.io.*;
import java.util.*;

class Chargement {

    static Jeu chargerJeu(String nomFichier) {
        // Création du jeu et de ses objets
        Jeu jeu = new Jeu();

        int ligne = 0;
        int colonne = 0;
        int max_colonne = 0;

        // Première boucle : récupérer uniquement les dimensions du labyrinthe
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Mise à jour de la largeur maximale (en fonction du nombre de caractères dans chaque ligne)
                max_colonne = Math.max(max_colonne, line.length());
                ligne++; // Incrémente le nombre de lignes
            }

            // Dimensions du labyrinthe
            int hauteur = ligne; // Le nombre total de lignes
            int largeur = max_colonne; // La plus grande longueur de ligne

            // Création du labyrinthe avec ces dimensions
            jeu.laby.setDimensions(largeur, hauteur);  // On inverse largeur et hauteur pour correspondre aux indices

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deuxième boucle : charger les éléments du jeu (murs, caisses, dépôts, etc.)
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            ligne = 0;  // Réinitialisation de la ligne à 0 pour recommencer à lire les éléments

            while ((line = br.readLine()) != null) {
                // Parcourt chaque caractère de la ligne
                for (colonne = 0; colonne < line.length(); colonne++) {
                    char lecture = line.charAt(colonne);

                    switch (lecture) {
                        case '#':
                            jeu.laby.setMur(colonne, ligne);  // Placer un mur
                            break;

                        case '$':
                            jeu.caisses.liste.add(new Caisse(colonne, ligne, true));  // Ajouter une Caisse
                            break;

                        case '.':
                            jeu.depots.liste.add(new Depot(colonne, ligne, false));  // Ajouter un Depot
                            break;

                        case '@':
                            jeu.perso.setPosition(colonne, ligne);  // Positionner le personnage
                            break;

                        case ' ':
                            // Pas besoin de faire quoi que ce soit pour les espaces
                            break;

                        default:
                            // Gérer les caractères invalides si nécessaire
                            break;
                    }
                }
                ligne++; // Incrémente le numéro de ligne
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jeu;
    }
}
