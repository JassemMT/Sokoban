import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void testConstructeurEtAccesseurs() {
        // Teste la création d'un élément et l'accès à ses coordonnées
        Element e = new Element(2, 3);
        assertEquals(2, e.getX());
        assertEquals(3, e.getY());
    }

    @Test
    void testSetPosition() {
        // Teste la modification de la position avec setPosition
        Element e = new Element(0, 0);
        e.setPosition(5, 7);
        assertEquals(5, e.getX());
        assertEquals(7, e.getY());
    }

    @Test
    void testDeplacerParCoordonnees() {
        // Teste le déplacement en ajoutant des valeurs
        Element e = new Element(1, 1);
        e.deplacerParCoordonnees(2, 3);
        assertEquals(3, e.getX());
        assertEquals(4, e.getY());
    }

    @Test
    void testDeplacementGauche() {
        // Teste le déplacement vers la gauche
        Element e = new Element(5, 5);
        e.deplacement("gauche");
        assertEquals(4, e.getX());
        assertEquals(5, e.getY());
    }

    @Test
    void testDeplacementDroite() {
        // Teste le déplacement vers la droite
        Element e = new Element(5, 5);
        e.deplacement("droite");
        assertEquals(6, e.getX());
        assertEquals(5, e.getY());
    }

    @Test
    void testDeplacementHaut() {
        // Teste le déplacement vers le haut
        Element e = new Element(5, 5);
        e.deplacement("haut");
        assertEquals(5, e.getX());
        assertEquals(4, e.getY());
    }

    @Test
    void testDeplacementBas() {
        // Teste le déplacement vers le bas
        Element e = new Element(5, 5);
        e.deplacement("bas");
        assertEquals(5, e.getX());
        assertEquals(6, e.getY());
    }

    @Test
    void testDeplacementActionInvalide() {
        // Teste que l'action invalide lève bien une exception
        Element e = new Element(0, 0);
        assertThrows(IllegalArgumentException.class, () -> e.deplacement("sauter"));
    }

    @Test
    void testToString() {
        // Teste l'affichage du toString
        Element e = new Element(2, 8);
        assertEquals("(2,8)", e.toString());
    }
}
