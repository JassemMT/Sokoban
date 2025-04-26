class Jeu {

    Perso perso;
    ListeElements caisses;
    ListeElements depots;
    Labyrinthe laby;

    static final String HAUT = "Haut";
    static final String BAS = "bas";
    static final String DROITE = "droite";
    static final String GAUCHE = "gauche";

    // Condition de fin - Renvoie true si le jeu est fini
    boolean etreFini() {
        for (Element c : caisses.liste) {
            boolean trouve = false;
            int x = c.getX();
            int y = c.getY();

            // On vérifie chaque dépôt
            for (Element d : depots.liste) {
                if (x == d.getX() && y == d.getY()) {
                    trouve = true;
                    break;
                }
            }

            // Si une des caisses n'est pas sur un dépôt, alors le jeu continue
            if (!trouve) {
                return false;
            }
        }
        return true;
    }

    // Obtient les coordonnées suivantes selon l'action
    int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                return new int[]{x, y - 1};
            case BAS:
                return new int[]{x, y + 1};
            case DROITE:
                return new int[]{x + 1, y};
            case GAUCHE:
                return new int[]{x - 1, y};
            default:
                return null;
        }
    }

    // Récupérer un élément à une position donnée
    Element getElement(int x, int y) {
        // Recherche dans les caisses
        for (Element e : caisses.liste) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        // Recherche dans les dépôts si non trouvé parmi les caisses
        for (Element e : depots.liste) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }

    // Déplacer le personnage
    void deplacerPerso(String action) {
        int x = perso.getX();
        int y = perso.getY();

        int[] cible = getSuivant(x, y, action);
        int cx = cible[0];
        int cy = cible[1];

        // Mur : déplacement impossible
        if (laby.etreMur(cx, cy)) return;

        // Caisse présente ?
        Element caisse = getElement(cx, cy);

        if (caisse == null) {
            // Case vide ou dépôt : déplacement libre
            perso.deplacement(action);
        } else {
            // Tenter de pousser la caisse
            int[] cible2 = getSuivant(cx, cy, action);
            int cx2 = cible2[0];
            int cy2 = cible2[1];

            if (!laby.etreMur(cx2, cy2) && getElement(cx2, cy2) == null) {
                caisse.deplacement(action);
                perso.deplacement(action);
            }
        }
    }

    // Savoir quoi afficher à une case donnée
    char getChar(int x, int y) {
        if (perso.getX() == x && perso.getY() == y) return '@';

        for (Element c : caisses.liste) {
            if (c.getX() == x && c.getY() == y) return '$';
        }

        for (Element d : depots.liste) {
            if (d.getX() == x && d.getY() == y) return '.';
        }

        if (laby.etreMur(x, y)) return '#';

        return ' ';
    }

    // Convertir le jeu en chaîne pour affichage
    String jeuToString() {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < laby.getHauteur(); x++) {
            for (int y = 0; y < laby.getLargeur(); y++) {
                sb.append(getChar(x, y));
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
