class Perso extends Element {
    String name;

    Perso(int x, int y) {
        super(x, y);
    }

    void action(String action) {
        deplacement(action);
    }

    @Override
    public String toString() {
        return "Perso " + name + " à la position " + super.toString();
    }
}
