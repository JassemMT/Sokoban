package jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLabyrinthe {

    @Test
    void testSetDimensions() {
        Labyrinthe laby = new Labyrinthe();
        laby.setDimensions(5, 4);

        assertTrue(laby.getLargeur() == 5);
        assertTrue(laby.getHauteur() == 4);
        assertNotNull(laby.getMurs());
        assertTrue(laby.getMurs().length == 5);
        assertTrue(laby.getMurs()[0].length == 4);
    }

    @Test
    void testSetAndEtreMur() {
        Labyrinthe laby = new Labyrinthe();
        laby.setDimensions(3, 3);

        // On vérifie que tout est vide au début
        assertFalse(laby.etreMur(1, 1));

        // On pose un mur
        laby.setMur(1, 1);

        assertTrue(laby.etreMur(1, 1));

        // On vérifie que les autres cases ne sont pas des murs
        assertFalse(laby.etreMur(0, 0));
        assertFalse(laby.etreMur(2, 2));
    }

    @Test
    void testSetCaseLibre() {
        Labyrinthe laby = new Labyrinthe();
        laby.setDimensions(3, 3);

        laby.setMur(1, 1);
        assertTrue(laby.etreMur(1, 1));

        laby.setCaseLibre(1, 1);
        assertFalse(laby.etreMur(1, 1));
    }

    @Test
    void testEtreMurOutOfBounds() {
        Labyrinthe laby = new Labyrinthe();
        laby.setDimensions(2, 2);

        // Test hors limites
        assertFalse(laby.etreMur(-1, 0));
        assertFalse(laby.etreMur(0, -1));
        assertFalse(laby.etreMur(2, 0));
        assertFalse(laby.etreMur(0, 2));
    }

    @Test
    void testSetMurOutOfBounds() {
        Labyrinthe laby = new Labyrinthe();
        laby.setDimensions(2, 2);

        // Mettre un mur en dehors ne doit pas crasher
        try {
            laby.setMur(5, 5);
        } catch (Exception e) {
            fail("Pas d'exception attendue même hors limites");
        }

        // Pareil pour setCaseLibre
        try {
            laby.setCaseLibre(5, 5);
        } catch (Exception e) {
            fail("Pas d'exception attendue même hors limites");
        }
    }

    @Test
    void testAfficherLabyrinthe() {
        Labyrinthe laby = new Labyrinthe();
        laby.setDimensions(3, 3);
        laby.setMur(0, 0);
        laby.setMur(1, 1);
        laby.setMur(2, 2);

        // Ce test ne vérifie pas l'affichage exact mais s'assure que la méthode ne crashe pas
        try {
            laby.afficherLabyrinthe();
        } catch (Exception e) {
            fail("Erreur inattendue à l'affichage du labyrinthe : " + e.getMessage());
        }
    }
}
