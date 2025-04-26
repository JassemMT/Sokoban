class Element {

    int x;
    int y;

    // Constructeur
    Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Modifier la position
    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Déplacement par coordonnées
    void deplacerParCoordonnees(int dep_x, int dep_y) {
        this.x += dep_x;
        this.y += dep_y;
    }

    // Déplacement selon l'action donnée
    void deplacement(String action) {
        switch (action.toLowerCase()) {
            case "gauche":
                this.x -= 1;
                break;
            case "droite":
                this.x += 1;
                break;
            case "haut":
                this.y -= 1;
                break;
            case "bas":
                this.y += 1;
                break;
            default:
                System.out.println("Action invalide : " + action);  // Lancer une exception pour gérer les actions invalides
        }
    }

    // Retourner la position X
    int getX() {
        return x;
    }

    // Retourner la position Y
    int getY() {
        return y;
    }

    // Affichage de la position sous forme (x, y)
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
