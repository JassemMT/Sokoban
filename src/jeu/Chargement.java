package jeu;

import java.io.*;

public class Chargement {

    public static Jeu chargerJeu(String nomFichier) throws FichierIncorrectException {
        Jeu jeu = new Jeu();

        int ligne = 0;
        int colonne = 0;
        int max_colonne = 0;

        // Première lecture : récupérer les dimensions
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;

            while ((line = br.readLine()) != null) {
                max_colonne = Math.max(max_colonne, line.length());
                ligne++;
            }

            if (ligne == 0 || max_colonne == 0) {
                throw new FichierIncorrectException("Le fichier est vide ou incorrect.");
            }

            jeu.laby.setDimensions(max_colonne, ligne);

        } catch (IOException e) {
            throw new FichierIncorrectException("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        // Deuxième lecture : charger les éléments
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            ligne = 0;

            while ((line = br.readLine()) != null) {
                for (colonne = 0; colonne < line.length(); colonne++) {
                    char lecture = line.charAt(colonne);

                    switch (lecture) {
                        case Labyrinthe.MUR:
                            jeu.laby.setMur(colonne, ligne);
                            break;
                        case Labyrinthe.CAISSE:
                            jeu.caisses.liste.add(new Caisse(colonne, ligne, true));
                            break;
                        case Labyrinthe.DEPOT:
                            jeu.depots.liste.add(new Depot(colonne, ligne, false));
                            break;
                        case Labyrinthe.PJ:
                            jeu.perso.setPosition(colonne, ligne);
                            break;
                        case ' ':
                            // Rien à faire
                            break;
                        default:
                            throw new FichierIncorrectException("Caractère invalide '" + lecture + "' à (" + colonne + ", " + ligne + ")");
                    }
                }
                ligne++;
            }
        } catch (IOException e) {
            throw new FichierIncorrectException("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return jeu;
    }
}
