import jeu.*;
import graphisme.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws FichierIncorrectException, IOException {
        // Créer un objet jeu.Jeu
        Jeu jeu = new Jeu();

        try {
            // Charger un jeu depuis un fichier (par exemple, "labyrinthe.txt")
            jeu = Chargement.chargerJeu("../laby/laby.txt");

            // Afficher le jeu initial
            System.out.println("jeu.Jeu chargé avec succès!");
            System.out.println(jeu.jeuToString());

            new Application(jeu);
        } catch (FichierIncorrectException e) {
            throw new RuntimeException(e);
        }
    }
}
