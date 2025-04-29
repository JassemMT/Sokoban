package jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class TestChargement {

    // Test basique : charger un fichier correct
    @Test
    void testChargementFichierValide() throws Exception {
        // Création d'un fichier temporaire valide
        Path fichierTemp = Files.createTempFile("niveau", ".txt");
        try (FileWriter writer = new FileWriter(fichierTemp.toFile())) {
            writer.write(
                        "#####\n" +
                            "# @ #\n" +
                            "# $ #\n" +
                            "# . #\n" +
                            "#####"
            );
        }

        Jeu jeu = Chargement.chargerJeu(fichierTemp.toString());

        // Vérifications
        assertEquals(5, jeu.laby.getLargeur()); // largeur attendue
        assertEquals(5, jeu.laby.getHauteur()); // hauteur attendue
        assertEquals(1, jeu.caisses.liste.size()); // 1 caisse
        assertEquals(1, jeu.depots.liste.size()); // 1 dépôt
        assertEquals(2, jeu.perso.getX()); // Position X du joueur
        assertEquals(1, jeu.perso.getY()); // Position Y du joueur

        // Suppression du fichier temporaire
        Files.delete(fichierTemp);
    }

    @Test
    void testChargementFichierVide() {
        try {
            Path fichierTemp = Files.createTempFile("vide", ".txt");
            try (FileWriter writer = new FileWriter(fichierTemp.toFile())) {
                writer.write(""); // fichier vide
            }

            Jeu jeu = null;
            boolean erreur = false;

            try {
                jeu = Chargement.chargerJeu(fichierTemp.toString());
            } catch (Exception e) {
                erreur = true;
            }

            assertTrue(erreur, "On attendait une erreur sur un fichier vide.");
            assertNull(jeu);

            Files.delete(fichierTemp);

        } catch (IOException e) {
            fail("Erreur inattendue lors du test : " + e.getMessage());
        }
    }

    @Test
    void testChargementAvecCaractereInvalide() {
        try {
            Path fichierTemp = Files.createTempFile("invalide", ".txt");
            try (FileWriter writer = new FileWriter(fichierTemp.toFile())) {
                writer.write(
                        "#####\n" +
                                "# @ #\n" +
                                "# & #\n" + // '&' est invalide
                                "# . #\n" +
                                "#####"
                );
            }

            Jeu jeu = null;
            boolean erreur = false;

            try {
                jeu = Chargement.chargerJeu(fichierTemp.toString());
            } catch (Exception e) {
                erreur = true;
            }

            assertTrue(erreur, "On attendait une erreur à cause du caractère invalide.");
            assertNull(jeu);

            Files.delete(fichierTemp);

        } catch (IOException e) {
            fail("Erreur inattendue lors du test : " + e.getMessage());
        }
    }

    @Test
    void testChargementFichierInexistant() {
        Jeu jeu = null;
        boolean erreur = false;

        try {
            jeu = Chargement.chargerJeu("fichier/inexistant.txt");
        } catch (Exception e) {
            erreur = true;
        }

        assertTrue(erreur, "On attendait une erreur avec un fichier inexistant.");
        assertNull(jeu);
    }
}
