package jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestJeu {

    @Test
    void testInitialisation() {
        Jeu jeu = new Jeu();

        assertNotNull(jeu.perso);
        assertNotNull(jeu.caisses);
        assertNotNull(jeu.depots);
        assertNotNull(jeu.laby);
    }

    @Test
    void testEtreFiniTrue() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);

        jeu.caisses.liste.add(new Caisse(1, 1, true));
        jeu.depots.liste.add(new Depot(1, 1, false));

        assertTrue(jeu.etreFini());
    }

    @Test
    void testEtreFiniFalse() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);

        jeu.caisses.liste.add(new Caisse(1, 1, true));
        jeu.depots.liste.add(new Depot(2, 2, false));

        assertFalse(jeu.etreFini());
    }

    @Test
    void testEstCaisse() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);

        jeu.caisses.liste.add(new Caisse(2, 2, true));

        assertTrue(jeu.estCaisse(2, 2));
        assertFalse(jeu.estCaisse(0, 0));
    }

    @Test
    void testGetElement() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);

        jeu.caisses.liste.add(new Caisse(3, 3, true));
        jeu.depots.liste.add(new Depot(4, 4, false));

        assertNotNull(jeu.getElement(3, 3));
        assertNotNull(jeu.getElement(4, 4));
        assertTrue(jeu.getElement(0, 0) == null);
    }

    @Test
    void testGetSuivantValide() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);

        try {
            int[] suivant = jeu.getSuivant(2, 2, Jeu.HAUT);
            assertTrue(suivant[0] == 2 && suivant[1] == 1);

            suivant = jeu.getSuivant(2, 2, Jeu.BAS);
            assertTrue(suivant[0] == 2 && suivant[1] == 3);

            suivant = jeu.getSuivant(2, 2, Jeu.GAUCHE);
            assertTrue(suivant[0] == 1 && suivant[1] == 2);

            suivant = jeu.getSuivant(2, 2, Jeu.DROITE);
            assertTrue(suivant[0] == 3 && suivant[1] == 2);
        } catch (Exception e) {
            fail("Erreur inattendue : " + e.getMessage());
        }
    }

    @Test
    void testGetSuivantInvalide() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);

        boolean erreur = false;
        try {
            jeu.getSuivant(2, 2, "mauvaiseAction");
        } catch (Exception e) {
            erreur = true;
        }

        assertTrue(erreur);
    }

    @Test
    void testDeplacerPersoSansObstacle() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);
        jeu.perso.setPosition(1, 1);

        try {
            jeu.deplacerPerso(Jeu.DROITE);
        } catch (Exception e) {
            fail("Erreur inattendue : " + e.getMessage());
        }

        assertTrue(jeu.perso.getX() == 2);
        assertTrue(jeu.perso.getY() == 1);
    }

    @Test
    void testDeplacerPersoContreMur() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);
        jeu.perso.setPosition(1, 1);
        jeu.laby.setMur(2, 1);

        try {
            jeu.deplacerPerso(Jeu.DROITE);
        } catch (Exception e) {
            fail("Erreur inattendue : " + e.getMessage());
        }

        // Pas bougé
        assertTrue(jeu.perso.getX() == 1);
        assertTrue(jeu.perso.getY() == 1);
    }

    @Test
    void testDeplacerPersoPousseCaisse() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);
        jeu.perso.setPosition(1, 1);
        jeu.caisses.liste.add(new Caisse(2, 1, true));

        try {
            jeu.deplacerPerso(Jeu.DROITE);
        } catch (Exception e) {
            fail("Erreur inattendue : " + e.getMessage());
        }

        assertTrue(jeu.perso.getX() == 2);
        assertTrue(jeu.perso.getY() == 1);

        Element caisse = jeu.getElement(3, 1);
        assertNotNull(caisse);
        assertTrue(caisse.getX() == 3 && caisse.getY() == 1);
    }

    @Test
    void testGetChar() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(5, 5);
        jeu.perso.setPosition(0, 0);
        jeu.caisses.liste.add(new Caisse(1, 1, true));
        jeu.depots.liste.add(new Depot(2, 2, false));
        jeu.laby.setMur(3, 3);

        assertTrue(jeu.getChar(0, 0) == Labyrinthe.PJ);
        assertTrue(jeu.getChar(1, 1) == Labyrinthe.CAISSE);
        assertTrue(jeu.getChar(2, 2) == Labyrinthe.DEPOT);
        assertTrue(jeu.getChar(3, 3) == Labyrinthe.MUR);
        assertTrue(jeu.getChar(4, 4) == ' ');
    }

    @Test
    void testJeuToString() {
        Jeu jeu = new Jeu();
        jeu.laby.setDimensions(2, 2);
        jeu.perso.setPosition(0, 0);

        String resultat = jeu.jeuToString();

        assertTrue(resultat.contains("@"));
    }
}
