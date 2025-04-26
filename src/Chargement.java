import java.io.*;
import java.util.*;

class Chargement {

    static Jeu chargerJeu(String nomFichier) {
        // On crée le jeu et ses objets
        Jeu jeu = new Jeu();
        int ligne = 0;
        int colonne = 0;
        int max_colonne = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parcourt chaque caractère de la ligne
                for (colonne = 0; colonne < line.length(); colonne++) {
                    char lecture = line.charAt(colonne);

                    switch (lecture) {
                        case '#':
                            jeu.laby.setMur(ligne, colonne);
                            break;

                        case '$':
                            jeu.caisses.liste.add(new Caisse(ligne, colonne, true));  // Ajouter une Caisse spécifiquement
                            break;

                        case '.':
                            jeu.depots.liste.add(new Depot(ligne, colonne, false));  // Ajouter un Depot spécifiquement
                            break;

                        case '@':
                            jeu.perso.setPosition(ligne, colonne);  // Positionner le perso
                            break;

                        case ' ':
                            // Pas besoin de faire quoi que ce soit pour les espaces
                            break;

                        default:
                            break;
                    }
                }
                ligne++; // Après chaque ligne, on passe à la suivante
                max_colonne = Math.max(max_colonne, colonne);  // Mise à jour de la largeur maximale
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        jeu.laby.setDimensions(ligne, max_colonne);  // Mise à jour des dimensions du labyrinthe
        return jeu;
    }
}
