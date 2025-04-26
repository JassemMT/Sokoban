class Caisse extends Element {
    boolean isMovable;

    Caisse(int x, int y, boolean isMovable) {
        super(x, y);
        this.isMovable = isMovable;
    }

    boolean isMovable() {
        return isMovable;
    }

    @Override
    public String toString() {
        return "Caisse à la position " + super.toString() + " (Déplaçable: " + isMovable + ")";
    }
}
