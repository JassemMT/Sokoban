class Labyrinthe {

    int hauteur;
    int largeur;
    boolean[][] murs; // murs[x][y] vaut true si et seulement si la case (x,y) est un mur

    // Constructeur
    Labyrinthe(int hauteur, int largeur) {
        setDimensions(hauteur, largeur);
    }

    int getHauteur() {
        return hauteur;
    }

    int getLargeur() {
        return largeur;
    }

    boolean[][] getMurs() {
        return murs;
    }

    void setDimensions(int x, int y) {
        this.hauteur = x;
        this.largeur = y;
        murs = new boolean[x][y];
    }

    // Pour tester si les coordonnées (x, y) correspondent à un mur
    boolean etreMur(int x, int y) {
        // Vérification de validité des indices
        if (x >= 0 && x < hauteur && y >= 0 && y < largeur) {
            return murs[x][y];
        }
        // Si les indices sont hors des limites du labyrinthe
        return false;
    }

    // Pour définir une case comme un mur
    void setMur(int x, int y) {
        // Vérification de validité des indices
        if (x >= 0 && x < hauteur && y >= 0 && y < largeur) {
            murs[x][y] = true;
        } else {
            System.out.println("Coordonnées hors limites.");
        }
    }

    // Pour retirer un mur d'une case
    void retirerMur(int x, int y) {
        if (x >= 0 && x < hauteur && y >= 0 && y < largeur) {
            murs[x][y] = false;
        } else {
            System.out.println("Coordonnées hors limites.");
        }
    }
}
