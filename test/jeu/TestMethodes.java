 package jeu;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class TestMethodes {

    @Test
    /*
     verification de l'écriture des méthodes
     */
    public void verificationJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        jeu.deplacerPerso(Jeu.HAUT);

        // verification des coordonnees (si bien chargé)
        int x = jeu.getPj().getX();
        int y = jeu.getPj().getY();
        assertEquals(5,x);
        assertEquals(2,y);

        // le jeu n'est pas fini
        assertFalse(jeu.etreFini());
        String s = jeu.jeuToString();
    }


    @Test
    public void testConditionFin() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");

        // Déplacer toutes les caisses sur les dépôts
        for (Element c : jeu.caisses.liste) {
            // Déplacer chaque caisse vers un dépôt
            for (Element d : jeu.depots.liste) {
                c.setPosition(d.getX(), d.getY());
            }
        }

        // Vérifier que le jeu est fini
        assertTrue(jeu.etreFini());
    }

    @Test
    public void testChargementJeuFichierIncorrect() {
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/incorrect_laby.txt");
        });
    }

    @Test
    public void testJeuToString() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");

        // Vérifier que la représentation du jeu est correcte
        String representation = jeu.jeuToString();
        assertNotNull(representation);
        assertTrue(representation.contains("@"));  // Vérifier que le personnage est bien affiché
        assertTrue(representation.contains("$"));  // Vérifier qu'il y a des caisses
        assertTrue(representation.contains("."));  // Vérifier qu'il y a des

    }

}