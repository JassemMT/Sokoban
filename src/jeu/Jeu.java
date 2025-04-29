package jeu;

public class Jeu {

    Perso perso;
    ListeElements caisses;
    ListeElements depots;
    Labyrinthe laby;

    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String DROITE = "droite";
    public static final String GAUCHE = "gauche";

    public Jeu() {
        perso = new Perso(0, 0);
        caisses = new ListeElements();
        depots = new ListeElements();
        laby = new Labyrinthe();
    }

    public boolean etreFini() {
        for (Element c : caisses.liste) {
            boolean trouve = false;
            int x = c.getX();
            int y = c.getY();
            for (Element d : depots.liste) {
                if (x == d.getX() && y == d.getY()) {
                    trouve = true;
                    break;
                }
            }
            if (!trouve) return false;
        }
        return true;
    }

    public boolean estCaisse(int x, int y) {
        for (Element e : caisses.liste) {
            if (e.getX() == x && e.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public Element getElement(int x, int y) {
        for (Element e : caisses.liste) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        for (Element e : depots.liste) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }

    public int[] getSuivant(int x, int y, String action) throws ActionInconnueException {
        switch (action) {
            case HAUT, "h" -> { return new int[]{x, y - 1}; }
            case BAS, "b" -> { return new int[]{x, y + 1}; }
            case DROITE, "d" -> { return new int[]{x + 1, y}; }
            case GAUCHE, "g" -> { return new int[]{x - 1, y}; }
            default -> throw new ActionInconnueException("Action invalide : " + action);
        }
    }

    public void deplacerPerso(String action) throws ActionInconnueException {
        int x = perso.getX();
        int y = perso.getY();

        int[] cible = getSuivant(x, y, action);
        int cx = cible[0];
        int cy = cible[1];

        if (laby.etreMur(cx, cy)) return;

        if (!estCaisse(cx, cy)) {
            perso.deplacement(action);
        } else {
            int[] cible2 = getSuivant(cx, cy, action);
            int cx2 = cible2[0];
            int cy2 = cible2[1];

            if (!laby.etreMur(cx2, cy2) && !estCaisse(cx2, cy2)) {
                getElement(cx, cy).deplacement(action);
                perso.deplacement(action);
            }
        }
    }

    public char getChar(int x, int y) {
        if (perso.getX() == x && perso.getY() == y) return Labyrinthe.PJ;
        for (Element c : caisses.liste) {
            if (c.getX() == x && c.getY() == y) return Labyrinthe.CAISSE;
        }
        for (Element d : depots.liste) {
            if (d.getX() == x && d.getY() == y) return Labyrinthe.DEPOT;
        }
        if (laby.etreMur(x, y)) return Labyrinthe.MUR;
        return ' ';
    }

    public String jeuToString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < laby.getHauteur(); y++) {
            for (int x = 0; x < laby.getLargeur(); x++) {
                sb.append(getChar(x, y));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public Perso getPj(){
        return perso;
    }
}
