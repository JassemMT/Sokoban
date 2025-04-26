class Element {

    int x;
    int y;

    Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void deplacement(int dep_x, int dep_y) {
        this.x += dep_x;
        this.y += dep_y;
    }

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
                System.out.println("Action invalide : " + action);
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
