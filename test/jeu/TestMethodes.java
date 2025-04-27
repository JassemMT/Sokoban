package jeu;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class TestMethodes {

    @Test
    /**
     * Vérification du chargement du jeu depuis un fichier
     */
    public void testChargementJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");

        // Vérification que le jeu a bien chargé les dimensions
        assertNotNull(jeu.laby);
        assertEquals(10, jeu.laby.getHauteur());  // Exemple, ajuster selon ton fichier
        assertEquals(10, jeu.laby.getLargeur());  // Exemple, ajuster selon ton fichier

        // Vérifier que les éléments sont correctement chargés
        assertNotNull(jeu.perso);
        assertTrue(jeu.caisses.liste.size() > 0);  // Vérifie qu'il y a des caisses
        assertTrue(jeu.depots.liste.size() > 0);   // Vérifie qu'il y a des dépôts
    }

    @Test
    public void testDeplacementPersonnage() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");

        // Déplacer le personnage vers le haut
        jeu.deplacerPerso(Jeu.HAUT);
        assertEquals(4, jeu.getPj().getX());  // Vérifier la nouvelle position
        assertEquals(2, jeu.getPj().getY());  // Vérifier la nouvelle position

        // Déplacer le personnage vers la droite
        jeu.deplacerPerso(Jeu.DROITE);
        assertEquals(5, jeu.getPj().getX());
        assertEquals(2, jeu.getPj().getY());

        // Déplacer le personnage vers le bas
        jeu.deplacerPerso(Jeu.BAS);
        assertEquals(5, jeu.getPj().getX());
        assertEquals(3, jeu.getPj().getY());

        // Déplacer le personnage vers la gauche
        jeu.deplacerPerso(Jeu.GAUCHE);
        assertEquals(4, jeu.getPj().getX());
        assertEquals(3, jeu.getPj().getY());
    }

    @Test
    public void testDeplacementCaisse() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");

        // Placer la caisse à une position initiale
        Element caisse = jeu.caisses.liste.get(0);  // Supposons qu'il y ait au moins une caisse
        int xInitial = caisse.getX();
        int yInitial = caisse.getY();

        // Déplacer la caisse
        jeu.deplacerPerso(Jeu.HAUT);  // Cela va pousser la caisse si possible

        // Vérifier que la caisse a bien changé de position
        assertNotEquals(xInitial, caisse.getX());
        assertNotEquals(yInitial, caisse.getY());
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
