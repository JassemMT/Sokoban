package jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestListeElements{

    @Test
    void testAjouterElement() {
        // Crée une nouvelle liste
        ListeElements liste = new ListeElements();
        Element e = new Caisse(1, 2, true);

        // Ajoute un élément
        liste.ajouterElement(e);

        // Vérifie que la taille est bien 1
        assertTrue(liste.taille() == 1);

        // Vérifie que l'élément est présent dans la liste
        assertTrue(liste.contient(e));
    }

    @Test
    void testRetirerElement() {
        // Crée une nouvelle liste
        ListeElements liste = new ListeElements();
        Element e = new Caisse(1, 2, true);

        // Ajoute un élément
        liste.ajouterElement(e);
        assertTrue(liste.taille() == 1);

        // Retire l'élément
        liste.retirerElement(e);

        // Vérifie que la liste est vide
        assertTrue(liste.taille() == 0);

        // Vérifie que l'élément n'est plus dans la liste
        assertFalse(liste.contient(e));
    }

    @Test
    void testObtenirElementValide() {
        // Crée une liste avec deux éléments
        ListeElements liste = new ListeElements();
        Element e1 = new Caisse(1, 2, true);
        Element e2 = new Depot(3, 4, false);

        liste.ajouterElement(e1);
        liste.ajouterElement(e2);

        // Récupère le deuxième élément
        Element recupere = liste.obtenirElement(1);

        // Vérifie que l'élément récupéré est correct
        assertNotNull(recupere);
        assertTrue(recupere == e2);
    }

    @Test
    void testObtenirElementInvalide() {
        // Crée une liste avec un seul élément
        ListeElements liste = new ListeElements();
        Element e1 = new Caisse(1, 2, true);

        liste.ajouterElement(e1);

        Element recupere = null;
        try {
            // Essaie de récupérer un index invalide
            recupere = liste.obtenirElement(5);
        } catch (Exception e) {
            fail("Pas d'exception attendue");
        }

        // Vérifie qu'on obtient null
        assertTrue(recupere == null);
    }

    @Test
    void testTaille() {
        // Crée une nouvelle liste
        ListeElements liste = new ListeElements();

        // La liste doit être vide au début
        assertTrue(liste.taille() == 0);

        // Ajoute deux éléments
        liste.ajouterElement(new Caisse(0, 0, true));
        liste.ajouterElement(new Depot(1, 1, false));

        // Vérifie que la taille est 2
        assertTrue(liste.taille() == 2);
    }

    @Test
    void testContient() {
        // Crée une nouvelle liste
        ListeElements liste = new ListeElements();
        Element e1 = new Caisse(1, 2, true);
        Element e2 = new Depot(3, 4, false);

        // Ajoute seulement e1
        liste.ajouterElement(e1);

        // Vérifie que e1 est trouvé
        assertTrue(liste.contient(e1));

        // Vérifie que e2 n'est pas trouvé
        assertFalse(liste.contient(e2));
    }
}
