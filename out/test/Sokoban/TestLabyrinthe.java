import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLabyrinthe {

    @Test
    void testInitialisation() {
        Labyrinthe laby = new Labyrinthe(5, 7);

        // Vérifie la bonne initialisation de la hauteur et largeur
        assertEquals(5, laby.getHauteur());
        assertEquals(7, laby.getLargeur());

        // Vérifie que toutes les cases sont sans murs après création
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 7; y++) {
                assertFalse(laby.etreMur(x, y));
            }
        }
    }

    @Test
    void testSetMur() {
        Labyrinthe laby = new Labyrinthe(3, 3);

        // Place un mur et vérifie sa présence
        laby.setMur(1, 1);
        assertTrue(laby.etreMur(1, 1));
    }

    @Test
    void testRetirerMur() {
        Labyrinthe laby = new Labyrinthe(3, 3);

        // Place un mur puis le retire
        laby.setMur(2, 2);
        assertTrue(laby.etreMur(2, 2));

        laby.retirerMur(2, 2);
        assertFalse(laby.etreMur(2, 2));
    }

    @Test
    void testEtreMurHorsLimite() {
        Labyrinthe laby = new Labyrinthe(2, 2);

        // Vérifie qu'on retourne false pour des coordonnées hors limites
        assertFalse(laby.etreMur(-1, 0));
        assertFalse(laby.etreMur(0, -1));
        assertFalse(laby.etreMur(2, 0));
        assertFalse(laby.etreMur(0, 2));
    }

    @Test
    void testSetMurHorsLimite() {
        Labyrinthe laby = new Labyrinthe(2, 2);

        // Tentative de placer des murs hors limites (ne doit rien casser)
        laby.setMur(-1, 0);
        laby.setMur(0, 3);
        laby.setMur(3, 0);
        laby.setMur(0, -1);

        // Vérifie qu'aucune case n'a été modifiée
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                assertFalse(laby.etreMur(x, y));
            }
        }
    }

    @Test
    void testRetirerMurHorsLimite() {
        Labyrinthe laby = new Labyrinthe(2, 2);

        // Tentative de retirer des murs hors limites (ne doit rien casser)
        laby.retirerMur(-1, 0);
        laby.retirerMur(2, 2);
        laby.retirerMur(0, 2);
        laby.retirerMur(2, 0);

        // Vérifie qu'aucun mur n'existe
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                assertFalse(laby.etreMur(x, y));
            }
        }
    }

    @Test
    void testCoinMur() {
        Labyrinthe laby = new Labyrinthe(3, 3);

        // Place des murs aux coins et vérifie
        laby.setMur(0, 0);
        laby.setMur(2, 2);

        assertTrue(laby.etreMur(0, 0));
        assertTrue(laby.etreMur(2, 2));
    }
}
