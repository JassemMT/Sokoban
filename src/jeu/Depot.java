package jeu;

public class Depot extends Element {
    boolean isOccupied;

    Depot(int x, int y, boolean isOccupied) {
        super(x, y);
        this.isOccupied = isOccupied;
    }

    boolean isOccupied() {
        return isOccupied;
    }

    void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "jeu.Depot à la position " + super.toString() + " (Occupé: " + isOccupied + ")";
    }
}
