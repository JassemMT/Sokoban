class Labyrinthe {

    int hauteur;
    int largeur;
    boolean[][] murs; // murs[x][y] vaut true si et seulement si la case (x, y) est un mur

    // Getter pour la hauteur
    int getHauteur() {
        return hauteur;
    }

    // Getter pour la largeur
    int getLargeur() {
        return largeur;
    }

    // Getter pour les murs
    boolean[][] getMurs() {
        return murs;
    }

    // Définir les dimensions du labyrinthe
    void setDimensions(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        murs = new boolean[largeur][hauteur];  // Notez que l'indexation est murs[x][y] où x est la colonne et y est la ligne
    }

    // Vérifier si (x, y) correspond à un mur
    boolean etreMur(int x, int y) {
        // Vérification des indices pour s'assurer qu'ils sont dans les limites
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            return murs[x][y];  // Retourne true si c'est un mur, sinon false
        }
        return false;  // Si les indices sont hors limites, renvoyer false
    }

    // Définir une case comme un mur
    void setMur(int x, int y) {
        // Vérification des indices avant d'ajouter un mur
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            murs[x][y] = true;  // On place un mur à cette position
        } else {
            System.out.println("Coordonnées hors limites : (" + x + ", " + y + ")");
        }
    }

    // Définir une case comme libre (pas un mur)
    void setCaseLibre(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            murs[x][y] = false;  // On rend la case libre
        } else {
            System.out.println("Coordonnées hors limites : (" + x + ", " + y + ")");
        }
    }

    // Pour afficher le labyrinthe sous forme textuelle (utile pour le débogage)
    void afficherLabyrinthe() {
        for (int y = 0; y < hauteur; y++) {  // On parcourt les lignes (Y)
            for (int x = 0; x < largeur; x++) {  // On parcourt les colonnes (X)
                System.out.print(murs[x][y] ? "#" : " ");  // Affiche # pour un mur, espace pour une case vide
            }
            System.out.println();  // Nouvelle ligne après chaque ligne du labyrinthe
        }
    }
}
